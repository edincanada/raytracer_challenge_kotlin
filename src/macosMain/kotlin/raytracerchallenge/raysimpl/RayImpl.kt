package raytracerchallenge.raysimpl

import raytracerchallenge.matriximpl.Matrix
import raytracerchallenge.shadingimpl.Material
import raytracerchallenge.constants.*
import raytracerchallenge.tupleimpl.*


data class Ray (val origin: Tuple, val direction: Tuple) {
    fun position(distance: Float): Tuple {
        return  origin + (direction * distance)
    }
    fun dotSelf(): Float {
        return dot(this.direction, this.direction)
    }

    fun transform(matrix: Matrix): Ray {
        return Ray(matrix.multipliedBy(origin), matrix.multipliedBy(direction))
    }
}

abstract class Shape(val material: Material, val transform: Matrix) {
    constructor(): this(DEFAULT_MATERIAL, IDENTITY_MATRIX)
    abstract fun localIntersect(localRay: Ray): Array<Intersection>
    abstract fun localNormalAt(point: Tuple): Tuple

    fun getLocalRay(aRay: Ray): Ray {
        return aRay.transform(this.transform.inverse())
    }

    fun intersect(aRay: Ray): Array<Intersection> {
        return localIntersect(getLocalRay(aRay))
    }

    private fun getLocalPoint(point: Tuple): Tuple {
        return transform.inverse().multipliedBy(point)
    }

    fun normalAt(point: Tuple): Tuple {
        val objectNormal = localNormalAt(getLocalPoint(point))
        val worldNormal = transform.inverse().transposed().multipliedBy(objectNormal)
        val worldNormalFixed = makeVector(worldNormal.x, worldNormal.y, worldNormal.z)
        return normalized(worldNormalFixed)
    }
}

class Sphere (material: Material, transform: Matrix) : Shape(material, transform) {
    constructor(): this(DEFAULT_MATERIAL, IDENTITY_MATRIX)
    constructor(transform: Matrix) : this(DEFAULT_MATERIAL, transform)
    constructor(material: Material) : this(material, IDENTITY_MATRIX)

    fun intersectGetT(localRay: Ray): Array<Float> {
        val sphereToRay = localRay.origin - POINT_ZERO
        val a = localRay.dotSelf()
        val b = 2.0f * dot(localRay.direction, sphereToRay)
        val c = dot(sphereToRay, sphereToRay) - 1.0f
        val discriminant = (b * b) - (4.0f * a * c)

        return when {
            discriminant < 0.0f -> emptyArray()
            else -> {
                val t1 = (-b - kotlin.math.sqrt(discriminant))/(2.0f * a)
                val t2 = (-b + kotlin.math.sqrt(discriminant))/(2.0f * a)
                arrayOf(t1, t2)
            }
        }
    }

    override fun localIntersect(localRay: Ray): Array<Intersection> {
        val intersectionTs = intersectGetT(localRay)
        return when {
            intersectionTs.size > 1 ->
                arrayOf(Intersection(intersectionTs[0], this), Intersection(intersectionTs[1], this))
            intersectionTs.isEmpty() -> emptyArray()
            else -> arrayOf(Intersection(intersectionTs[0], this))
        }
    }

    override fun localNormalAt(point: Tuple): Tuple = (point - POINT_ZERO)
}

class Plane(material: Material, transform: Matrix): Shape(material, transform) {
    constructor(): this(DEFAULT_MATERIAL, IDENTITY_MATRIX)
    constructor(material: Material): this(material, IDENTITY_MATRIX)
    override fun localNormalAt(point: Tuple): Tuple = VECTOR_UNIT_Y

    override fun localIntersect(localRay: Ray): Array<Intersection> {
        return if (isZero(localRay.direction.y)) {
            emptyArray()
        } else {
            val t = (-(localRay.origin.y)) / localRay.direction.y
            arrayOf(Intersection(t, this))
        }
    }
}

data class Intersection(val tVal: Float, val obj: Shape)

fun hit(crosses: Array<Intersection>): Intersection {
    return when {
        crosses.size == 2 -> {
            when {
                crosses[0].tVal >= 0.0f && (crosses[1].tVal < 0.0f || crosses[0].tVal < crosses[1].tVal) -> crosses[0]
                crosses[1].tVal >= 0.0f && (crosses[0].tVal < 0.0f || crosses[1].tVal < crosses[0].tVal) -> crosses[1]
                else -> NO_INTERSECTION
            }
        }

        crosses.size == 1 -> if (crosses[0].tVal >= 0.0f) crosses[0] else NO_INTERSECTION
        crosses.isEmpty() -> NO_INTERSECTION
        else -> {
            var hitIndex = -1
            for ((index, value) in crosses.withIndex()) {
                if (value.tVal >= 0.0f && (hitIndex < 0 || value.tVal < crosses[hitIndex].tVal)) {
                    hitIndex = index
                }
            }

            if (hitIndex > -1) crosses[hitIndex] else NO_INTERSECTION
        }
    }
}
