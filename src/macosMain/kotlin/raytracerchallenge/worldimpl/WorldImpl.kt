package raytracerchallenge.worldimpl

import raytracerchallenge.constants.*
import raytracerchallenge.raysimpl.*
import raytracerchallenge.shadingimpl.PointLight
import raytracerchallenge.shadingimpl.reflect
import raytracerchallenge.tupleimpl.*


data class World(val light: PointLight, val shapes: Array<Shape>) {

    private fun equalsTuple(world: World): Boolean = light.equals(world.light) && shapes.contentDeepEquals(world.shapes)
    fun equals(world: World): Boolean = equalsTuple(world)
    override fun equals(other: Any?): Boolean = (other != null && other is World && equalsTuple(other))

    fun intersect(ray: Ray): Array<Intersection> {
        val intersectionList = ArrayList<Intersection>()
            for (shape in shapes) {
            val intersections = shape.intersect(ray)
            for (intersection in intersections) {
                if (intersection != NO_INTERSECTION) {
                    intersectionList.add(intersection)
                }
            }
        }
        return if (intersectionList.isEmpty())
            emptyArray()
        else
            intersectionList.sortedWith(compareBy { it.tVal }).toTypedArray()
    }

    fun isShadowed(point: Tuple): Boolean {
        val vector = light.position - point
        val distance = vector.magnitude()
        val direction = normalized(vector)
        val ray = Ray(point, direction)
        val crosses = intersect(ray)
        val hit = hit(crosses)
        return !hit.equals(NO_INTERSECTION) && hit.tVal < distance
    }

    fun shadeHit(comps: Computations, useShadows: Boolean, remaining: Int): Tuple {
        return comps.obj.material.lighting(
            comps.obj,
            light,
            if (useShadows) comps.overPoint else comps.point,
            comps.eyeVector,
            comps.normalVector,
            useShadows && isShadowed(this, comps.overPoint)) + reflectedColor(comps, useShadows, remaining - 1)
    }

    fun shadeHit(comps: Computations, useShadows: Boolean): Tuple = shadeHit(comps, useShadows, 0)

    fun shadeHit(comps: Computations): Tuple {
        return comps.obj.material.lighting(
            comps.obj,
            light,
            comps.overPoint,
            comps.eyeVector,
            comps.normalVector,
            isShadowed(this, comps.overPoint)) + reflectedColor(comps, false, 0)
    }

    fun colorAt(ray: Ray, useShadow: Boolean, remaining: Int): Tuple {
        val crosses = intersect(ray)
        val intersection = hit(crosses)
        return if (intersection == NO_INTERSECTION) {
            BLACK_COLOR
        }
        else {
            shadeHit(Computations(intersection, ray), useShadow, remaining)
        }
    }

    fun colorAt(ray: Ray, useShadow: Boolean): Tuple = colorAt(ray, useShadow, 0)
    fun colorAt(ray: Ray): Tuple = colorAt(ray, false, 0)

    fun reflectedColor(comps: Computations, useShadows: Boolean, remaining: Int): Tuple {
        return if (remaining < 1 || isZero(comps.obj.material.reflective))
            BLACK_COLOR
        else {
            val reflectRay = Ray(comps.overPoint, comps.reflectVector)
            val color = colorAt(reflectRay, useShadows , remaining)
            makeOpaqueColor(color * comps.obj.material.reflective)
        }
    }

    fun reflectedColor(comps: Computations): Tuple = reflectedColor(comps, false, 0)

    override fun hashCode(): Int = (31 * light.hashCode() + shapes.contentHashCode())
}

class Computations(intersection: Intersection, ray: Ray) {

    val tVal = intersection.tVal
    val obj = intersection.obj
    val point = ray.position(tVal)
    val eyeVector = -ray.direction

    val inside: Boolean
    val normalVector: Tuple
    val overPoint: Tuple

    init {
        val rawNormalVector = obj.normalAt(point)
        val normalDotEye = dot(rawNormalVector, eyeVector)

        inside = (normalDotEye < 0.0f)
        normalVector = if (inside) {
            -rawNormalVector
        } else {
            rawNormalVector
        }
        overPoint = point + (normalVector * ANTI_SELF_SHADOW_BOOST)
    }

    val reflectVector = reflect(ray.direction, normalVector)
}

fun isShadowed(world: World, point: Tuple): Boolean {
    val vector = world.light.position - point
    val distance = vector.magnitude()
    val direction = normalized(vector)
    val ray = Ray(point, direction)
    val crosses = world.intersect(ray)
    val hit = hit(crosses)
    return !hit.equals(NO_INTERSECTION) && hit.tVal < distance
}
