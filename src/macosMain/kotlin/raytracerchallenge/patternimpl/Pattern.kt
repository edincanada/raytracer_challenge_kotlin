package raytracerchallenge.patternimpl

import raytracerchallenge.constants.*
import raytracerchallenge.matriximpl.Matrix
import raytracerchallenge.raysimpl.Shape
import raytracerchallenge.tupleimpl.Tuple
import raytracerchallenge.tupleimpl.makeColor
import kotlin.math.floor
import kotlin.math.sqrt

abstract class Pattern(private val transform: Matrix) {
    abstract fun patternAt(point: Tuple): Tuple
    fun patternAtObject(obj: Shape, point: Tuple): Tuple {
        val objectSpacePoint = obj.transform.inverse().multipliedBy(point)
        val patternSpacePoint = transform.inverse().multipliedBy(objectSpacePoint)
        return patternAt(patternSpacePoint)
    }
}

class TestPattern(transform: Matrix): Pattern(transform) {
    constructor(): this(IDENTITY_MATRIX)
    override fun patternAt(point: Tuple): Tuple {
        return makeColor(point.x, point.y, point.z)
    }
}

class SingleColorPattern (private val color: Tuple, transform: Matrix): Pattern(transform) {
    constructor(color: Tuple): this(color, IDENTITY_MATRIX)
    override fun patternAt(point: Tuple): Tuple = color
}

class StripePattern (private val a: Pattern, private val b: Pattern, transform: Matrix): Pattern(transform) {
    constructor(a: Pattern, b: Pattern): this(a, b, IDENTITY_MATRIX)
    constructor(a: Tuple, b: Tuple, transform: Matrix): this(SingleColorPattern(a), SingleColorPattern(b), transform)
    constructor(a: Tuple, b: Tuple): this(a, b, IDENTITY_MATRIX)
    override fun patternAt(point: Tuple): Tuple {
        return if (floor(point.x).toInt() % 2 == 0)
            a.patternAt(point)
        else
            b.patternAt(point)
    }
}

class GradientPattern (private val a: Pattern, private val b: Pattern, transform: Matrix): Pattern(transform) {
    constructor(a: Pattern, b: Pattern): this(a, b, IDENTITY_MATRIX)
    constructor(a: Tuple, b: Tuple, transform: Matrix): this(SingleColorPattern(a), SingleColorPattern(b), transform)
    constructor(a: Tuple, b: Tuple): this(a, b, IDENTITY_MATRIX)
    override fun patternAt(point: Tuple): Tuple {
        val aColor = a.patternAt(point)
        val distance = b.patternAt(point) - aColor
        val fraction = (point.x) - floor(point.x)
        return aColor + (distance * fraction)
    }
}

class RadialGradientPattern (private val a: Pattern, private val b: Pattern, transform: Matrix): Pattern(transform) {
    constructor(a: Pattern, b: Pattern): this(a, b, IDENTITY_MATRIX)
    constructor(a: Tuple, b: Tuple, transform: Matrix): this(SingleColorPattern(a), SingleColorPattern(b), transform)
    constructor(a: Tuple, b: Tuple): this(a, b, IDENTITY_MATRIX)
    override fun patternAt(point: Tuple): Tuple {
        val aColor = a.patternAt(point)
        val distance = b.patternAt(point) - aColor
        val fraction = (point.x) - floor(point.x)
        val fixedForSin = - PI + (fraction * 2.0f * PI)
        val cosBetween1And0 = (kotlin.math.sin(fixedForSin) + 1.0f)/2.0f
        return aColor + (distance * cosBetween1And0)
    }
}

class RingPattern (private val a: Pattern, private val b: Pattern, transform: Matrix): Pattern(transform) {
    constructor(a: Pattern, b: Pattern): this(a, b, IDENTITY_MATRIX)
    constructor(a: Tuple, b: Tuple, transform: Matrix): this(SingleColorPattern(a), SingleColorPattern(b), transform)
    constructor(a: Tuple, b: Tuple): this(a, b, IDENTITY_MATRIX)
    override fun patternAt(point: Tuple): Tuple {
        return if (floor(sqrt((point.x * point.x) + (point.z * point.z))).toInt() % 2 == 0)
            a.patternAt(point)
        else
            b.patternAt(point)
    }
}

class CheckersPattern (private val a: Pattern, private val b: Pattern, transform: Matrix): Pattern(transform) {
    constructor(a: Pattern, b: Pattern): this(a, b, IDENTITY_MATRIX)
    constructor(a: Tuple, b: Tuple, transform: Matrix): this(SingleColorPattern(a), SingleColorPattern(b), transform)
    constructor(a: Tuple, b: Tuple): this(a, b, IDENTITY_MATRIX)
    override fun patternAt(point: Tuple): Tuple {
        return if ((floor(point.x) + floor(point.y) + floor(point.z)).toInt() % 2 == 0)
            a.patternAt(point)
        else
            b.patternAt(point)
    }
}