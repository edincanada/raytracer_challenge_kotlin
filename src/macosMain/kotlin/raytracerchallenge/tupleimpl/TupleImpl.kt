package raytracerchallenge.tupleimpl

import raytracerchallenge.constants.ROOT_OF_THREE
import kotlin.math.absoluteValue
import kotlin.math.sqrt

const val EPSILON = 0.00001f

inline fun equalsFloat(aFloat: Float, otherFloat: Float): Boolean{
    return (aFloat - otherFloat).absoluteValue < EPSILON
}

inline fun isZero(aFloat: Float): Boolean = aFloat.absoluteValue < EPSILON
inline fun isOne(aFloat: Float): Boolean = equalsFloat(aFloat, 1.0f)

data class Tuple (val x: Float, val y: Float, val z: Float, val w: Float) {
    private val magnitude: Float = when {
        !isZero(w) -> Float.NaN
        isZero(x) && isZero(y) -> z.absoluteValue
        isZero(x) && isZero(z) -> y.absoluteValue
        isZero(y) && isZero(z) -> x.absoluteValue
        equalsFloat(x, y) && equalsFloat(x, z) -> ROOT_OF_THREE * x.absoluteValue
        else -> Float.NaN
    }

    private inline fun clamp01(aFloat: Float): Float {
        return when {
            aFloat in 0.0f..1.0f -> aFloat
            aFloat < 0.0f -> 0.0f
            aFloat > 1.0f -> 1.0f
            else -> aFloat
        }
    }

    inline fun red(): Float = x
    fun redInt(): Int = (clamp01(x) * 255 + 0.5f).toInt()
    inline fun green(): Float = y
    fun greenInt(): Int = (clamp01(y) * 255 + 0.5f).toInt()
    inline fun blue(): Float = z
    fun blueInt(): Int = (clamp01(z) * 255 + 0.5f).toInt()
    inline fun alpha(): Float = w
    fun alphaInt(): Int = (clamp01(w) * 255 + 0.5f).toInt()

    override fun equals(other: Any?): Boolean {
        return other != null && other is Tuple && equalsTuple(other)
    }

    fun equals(other: Tuple) : Boolean {
        return equalsTuple(other)
    }

    private fun equalsTuple(other: Tuple) : Boolean {
        return equalsFloat(x, other.x) &&
                equalsFloat(y, other.y) &&
                equalsFloat(z, other.z) &&
                equalsFloat(w, other.w)
    }

    operator fun plus(aTuple: Tuple): Tuple {
        return Tuple(
            x + aTuple.x,
            y + aTuple.y,
            z + aTuple.z,
            w + aTuple.w
        )
    }

    operator fun minus(aTuple: Tuple): Tuple {
        return Tuple(
            x - aTuple.x,
            y - aTuple.y,
            z - aTuple.z,
            w - aTuple.w
        )
    }

    operator fun unaryMinus(): Tuple =
        Tuple(-x, -y, -z, -w)

    operator fun times(scalar: Float): Tuple = scalar * this
    operator fun div(scalar: Float): Tuple =
        Tuple(x / scalar, y / scalar, z / scalar, w / scalar)

    fun magnitude(): Float {
        if (magnitude.isNaN()) {
            return sqrt(x*x + y*y + z*z)
        }
        return magnitude
    }
}

operator fun Float.times(aTuple: Tuple): Tuple {
    return Tuple(
        aTuple.x * this,
        aTuple.y * this,
        aTuple.z * this,
        aTuple.w * this
    )
}

inline fun makePoint(x: Float, y: Float, z: Float): Tuple =
    Tuple(x, y, z, 1.0f)

inline fun makePointX(x: Float): Tuple = Tuple(x, 0.0f, 0.0f, 1.0f)

inline fun makePointY(y: Float): Tuple = Tuple(0.0f, y, 0.0f, 1.0f)

inline fun makePointZ(z: Float): Tuple = Tuple(0.0f, 0.0f, z, 1.0f)

inline fun makeVector(x: Float, y: Float, z: Float): Tuple = Tuple(x, y, z, 0.0f)

inline fun makeVectorX(x: Float): Tuple = Tuple(x, 0.0f, 0.0f, 0.0f)

inline fun makeVectorY(y: Float): Tuple = Tuple(0.0f, y, 0.0f, 0.0f)

inline fun makeVectorZ(z: Float): Tuple = Tuple(0.0f, 0.0f, z, 0.0f)

inline fun makeDiagonalVector(k: Float): Tuple = Tuple(k, k, k, 0.0f)

inline fun makeColor(r: Float, g: Float, b: Float): Tuple = Tuple(r, g, b, 1.0f)

inline fun makeOpaqueColor(aColor: Tuple): Tuple = Tuple(aColor.x, aColor.y, aColor.z, 1.0f)

inline fun isPoint(aTuple: Tuple): Boolean = equalsFloat(aTuple.w, 1.0f)

inline fun isVector(aTuple: Tuple): Boolean = equalsFloat(aTuple.w, 0.0f)

inline fun magnitude(aTuple: Tuple): Float = aTuple.magnitude()

fun normalized(aTuple: Tuple): Tuple {
    val magnitude: Float = aTuple.magnitude()
    return Tuple(
        aTuple.x / magnitude,
        aTuple.y / magnitude,
        aTuple.z / magnitude,
        aTuple.w / magnitude
    )
}

inline fun dot(tupleA: Tuple, tupleB: Tuple): Float {
    return tupleA.x * tupleB.x + tupleA.y * tupleB.y + tupleA.z * tupleB.z + tupleA.w * tupleB.w
}

fun cross(tupleA: Tuple, tupleB: Tuple): Tuple {
    return makeVector(
        tupleA.y * tupleB.z - tupleA.z * tupleB.y,
        tupleA.z * tupleB.x - tupleA.x * tupleB.z,
        tupleA.x * tupleB.y - tupleA.y * tupleB.x
    )
}

inline fun blend(tupleA: Tuple, tupleB: Tuple): Tuple {
    return Tuple(
        tupleA.red() * tupleB.red(),
        tupleA.green() * tupleB.green(),
        tupleA.blue() * tupleB.blue(),
        tupleA.alpha() * tupleB.alpha()
    )
}

inline fun approxSin(rawRadians: Float): Float {
    return kotlin.math.sin(rawRadians)
}

inline fun approxCos(rawRadians: Float): Float {
    return kotlin.math.cos(rawRadians)
}
