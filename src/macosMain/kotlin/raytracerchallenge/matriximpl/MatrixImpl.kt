package raytracerchallenge.matriximpl

import raytracerchallenge.tupleimpl.*

internal const val SIDE_SIZE: Int = 4

internal const val ZERO_0 = 0
internal const val ZERO_1 = 1
internal const val ZERO_2 = 2
internal const val ZERO_3 = 3

internal const val ONE_0 = 4
internal const val ONE_1 = 5
internal const val ONE_2 = 6
internal const val ONE_3 = 7

internal const val TWO_0 = 8
internal const val TWO_1 = 9
internal const val TWO_2 = 10
internal const val TWO_3 = 11

internal const val THREE_0 = 12
internal const val THREE_1 = 13
internal const val THREE_2 = 14
internal const val THREE_3 = 15

internal inline fun determinant2x2(zero0: Float, zero1: Float, one0: Float, one1: Float): Float {
    return zero0 * one1 - zero1 * one0
}

internal inline fun determinant3x3(
    zero0: Float, zero1: Float, zero2: Float,
    one0: Float, one1: Float, one2: Float,
    two0: Float, two1: Float, two2: Float
) : Float {
    return  zero0 * (one1*two2 - one2*two1) -
            zero1 * (one0*two2 - one2*two0) +
            zero2 * (one0*two1 - one1*two0)
}

internal inline fun determinant4x4(
    zero0:  Float, zero1:  Float, zero2:  Float, zero3:  Float,
    one0:   Float, one1:   Float, one2:   Float, one3:  Float,
    two0:   Float, two1:   Float, two2:   Float, two3:   Float,
    three0: Float, three1: Float, three2: Float, three3: Float
) : Float {
    return zero0 * determinant3x3(
            one1,   one2,   one3,
            two1,   two2,   two3,
            three1, three2, three3
        ) -
        zero1 * determinant3x3(
            one0,   one2,   one3,
            two0,   two2,   two3,
            three0, three2, three3
        ) +
        zero2 * determinant3x3(
            one0,   one1,   one3,
            two0,   two1,   two3,
            three0, three1, three3
        ) -
        zero3 * determinant3x3(
        one0,   one1,   one2,
        two0,   two1,   two2,
        three0, three1, three2
    )
}

class Matrix(
              zero_0: Float, zero_1: Float, zero_2: Float, zero_3: Float,
              one_0: Float,  one_1: Float,  one_2: Float,  one_3: Float,
              two_0: Float,  two_1: Float,  two_2: Float,  two_3: Float,
              three_0: Float, three_1: Float, three_2: Float, three_3: Float
) {
    private val values = floatArrayOf(
        zero_0, zero_1, zero_2, zero_3,
        one_0,  one_1,  one_2,  one_3,
        two_0,  two_1,  two_2,  two_3,
        three_0, three_1, three_2, three_3
    )

    constructor(
                 row_0: Tuple,
                 row_1: Tuple,
                 row_2: Tuple,
                 row_3: Tuple):
    this(
        row_0.x, row_0.y, row_0.z, row_0.w,
        row_1.x, row_1.y, row_1.z, row_1.w,
        row_2.x, row_2.y, row_2.z, row_2.w,
        row_3.x, row_3.y, row_3.z, row_3.w
    )

    constructor(x: Float, y: Float, z: Float) : this(
        1.0f, 0.0f, 0.0f, x,
        0.0f, 1.0f, 0.0f, y,
        0.0f, 0.0f, 1.0f, z,
        0.0f, 0.0f, 0.0f, 1.0f
    )

    operator fun get(row: Int, column: Int): Float{
        return values[row * SIDE_SIZE + column]
    }

    override fun equals(other: Any?): Boolean {
        return other != null && other is Matrix && equalsMatrix(other)
    }

    fun equals(aMatrix: Matrix): Boolean {
        return equalsMatrix(aMatrix)
    }

    private fun equalsMatrix(aMatrix: Matrix): Boolean {
        return equalsFloat(values[0], aMatrix.values[0]) &&
                equalsFloat(values[1], aMatrix.values[1]) &&
                equalsFloat(values[2], aMatrix.values[2]) &&
                equalsFloat(values[3], aMatrix.values[3]) &&
                equalsFloat(values[4], aMatrix.values[4]) &&
                equalsFloat(values[5], aMatrix.values[5]) &&
                equalsFloat(values[6], aMatrix.values[6]) &&
                equalsFloat(values[7], aMatrix.values[7]) &&
                equalsFloat(values[8], aMatrix.values[8]) &&
                equalsFloat(values[9], aMatrix.values[9]) &&
                equalsFloat(values[10], aMatrix.values[10]) &&
                equalsFloat(values[11], aMatrix.values[11]) &&
                equalsFloat(values[12], aMatrix.values[12]) &&
                equalsFloat(values[13], aMatrix.values[13]) &&
                equalsFloat(values[14], aMatrix.values[14]) &&
                equalsFloat(values[15], aMatrix.values[15])
    }

    private inline fun multiplyAt(aMatrix: Matrix, row: Int, column: Int): Float {
        return this[row, 0] * aMatrix[0, column] +
                this[row, 1] * aMatrix[1, column] +
                this[row, 2] * aMatrix[2, column] +
                this[row, 3] * aMatrix[3, column]
    }

    private inline fun multiplyAt(aTuple: Tuple, row: Int): Float {
        return  this[row, 0] * aTuple.x +
                this[row, 1] * aTuple.y +
                this[row, 2] * aTuple.z +
                this[row, 3] * aTuple.w
    }

    fun multipliedBy(aMatrix: Matrix): Matrix {
        return Matrix(
            multiplyAt(aMatrix, 0,0),
            multiplyAt(aMatrix, 0,1),
            multiplyAt(aMatrix, 0,2),
            multiplyAt(aMatrix, 0,3),

            multiplyAt(aMatrix, 1,0),
            multiplyAt(aMatrix, 1,1),
            multiplyAt(aMatrix, 1,2),
            multiplyAt(aMatrix, 1,3),

            multiplyAt(aMatrix, 2,0),
            multiplyAt(aMatrix, 2,1),
            multiplyAt(aMatrix, 2,2),
            multiplyAt(aMatrix, 2,3),

            multiplyAt(aMatrix, 3,0),
            multiplyAt(aMatrix, 3,1),
            multiplyAt(aMatrix, 3,2),
            multiplyAt(aMatrix, 3,3)
        )
    }

    fun multipliedBy(aTuple: Tuple): Tuple {
        return Tuple(
            multiplyAt(aTuple, 0),
            multiplyAt(aTuple, 1),
            multiplyAt(aTuple, 2),
            multiplyAt(aTuple, 3)
        )
    }

    fun transposed(): Matrix {
        return Matrix(
            values[0], values[4], values[8],  values[12],
            values[1], values[5], values[9],  values[13],
            values[2], values[6], values[10], values[14],
            values[3], values[7], values[11], values[15]
        )
    }

    fun subMatrix(row: Int, column: Int): Matrix {
        val indices = submatrixIndices[row * SIDE_SIZE + column]
        return Matrix(
            values[indices[0]], values[indices[1]], values[indices[2]],  0.0f,
            values[indices[3]], values[indices[4]], values[indices[5]],  0.0f,
            values[indices[6]], values[indices[7]], values[indices[8]], 0.0f,
            0.0f, 0.0f, 0.0f, 0.0f
        )
    }

    fun determinant2x2(): Float {
        return raytracerchallenge.matriximpl.determinant2x2(
            values[ZERO_0], values[ZERO_1],
            values[ONE_0], values[ONE_1]
        )
    }

    fun determinant3x3(): Float {
        return raytracerchallenge.matriximpl.determinant3x3(
            values[ZERO_0], values[ZERO_1], values[ZERO_2],
            values[ONE_0], values[ONE_1], values[ONE_2],
            values[TWO_0], values[TWO_1], values[TWO_2]
        )
    }

    fun determinant(): Float {
        return raytracerchallenge.matriximpl.determinant4x4(
            values[ZERO_0], values[ZERO_1], values[ZERO_2], values[ZERO_3],
            values[ONE_0], values[ONE_1], values[ONE_2], values[ONE_3],
            values[TWO_0], values[TWO_1], values[TWO_2], values[TWO_3],
            values[THREE_0], values[THREE_1], values[THREE_2], values[THREE_3]
        )
    }
    fun minor3x3(row: Int, column: Int): Float { return subMatrix(row, column).determinant2x2() }
    fun minor(row: Int, column: Int): Float { return subMatrix(row, column).determinant3x3() }

    fun cofactor3x3(row: Int, column: Int): Float {
        return when {
            (row + column) % 2 == 0 -> minor3x3(row, column)
            else -> -1.0f * minor3x3(row, column)
        }
    }

    fun cofactor(row: Int, column: Int): Float {
        return when {
            (row + column) % 2 == 0 -> minor(row, column)
            else -> -1.0f * minor(row, column)
        }
    }

    fun invertible(): Boolean {
        return !isZero(determinant())
    }

    fun inverse(): Matrix {
        val determinant = determinant()
        return Matrix(
            cofactor(0,0)/determinant,
            cofactor(1,0)/determinant,
            cofactor(2,0)/determinant,
            cofactor(3,0)/determinant,

            cofactor(0,1)/determinant,
            cofactor(1,1)/determinant,
            cofactor(2,1)/determinant,
            cofactor(3,1)/determinant,

            cofactor(0,2)/determinant,
            cofactor(1,2)/determinant,
            cofactor(2,2)/determinant,
            cofactor(3,2)/determinant,

            cofactor(0,3)/determinant,
            cofactor(1,3)/determinant,
            cofactor(2,3)/determinant,
            cofactor(3,3)/determinant
        )
    }

    override fun toString(): String {
        return "matrix(values=[${values.joinToString(",")}])"
    }
}



internal val REMOVE_00 = intArrayOf(ONE_1, ONE_2, ONE_3, TWO_1, TWO_2, TWO_3, THREE_1, THREE_2, THREE_3)
internal val REMOVE_01 = intArrayOf(ONE_0, ONE_2, ONE_3, TWO_0, TWO_2, TWO_3, THREE_0, THREE_2, THREE_3)
internal val REMOVE_02 = intArrayOf(ONE_0, ONE_1, ONE_3, TWO_0, TWO_1, TWO_3, THREE_0, THREE_1, THREE_3)
internal val REMOVE_03 = intArrayOf(ONE_0, ONE_1, ONE_2, TWO_0, TWO_1, TWO_2, THREE_0, THREE_1, THREE_2)

internal val REMOVE_10 = intArrayOf(ZERO_1, ZERO_2, ZERO_3, TWO_1, TWO_2, TWO_3, THREE_1, THREE_2, THREE_3)
internal val REMOVE_11 = intArrayOf(ZERO_0, ZERO_2, ZERO_3, TWO_0, TWO_2, TWO_3, THREE_0, THREE_2, THREE_3)
internal val REMOVE_12 = intArrayOf(ZERO_0, ZERO_1, ZERO_3, TWO_0, TWO_1, TWO_3, THREE_0, THREE_1, THREE_3)
internal val REMOVE_13 = intArrayOf(ZERO_0, ZERO_1, ZERO_2, TWO_0, TWO_1, TWO_2, THREE_0, THREE_1, THREE_2)

internal val REMOVE_20 = intArrayOf(ZERO_1, ZERO_2, ZERO_3, ONE_1, ONE_2, ONE_3, THREE_1, THREE_2, THREE_3)
internal val REMOVE_21 = intArrayOf(ZERO_0, ZERO_2, ZERO_3, ONE_0, ONE_2, ONE_3, THREE_0, THREE_2, THREE_3)
internal val REMOVE_22 = intArrayOf(ZERO_0, ZERO_1, ZERO_3, ONE_0, ONE_1, ONE_3, THREE_0, THREE_1, THREE_3)
internal val REMOVE_23 = intArrayOf(ZERO_0, ZERO_1, ZERO_2, ONE_0, ONE_1, ONE_2, THREE_0, THREE_1, THREE_2)

internal val REMOVE_30 = intArrayOf(ZERO_1, ZERO_2, ZERO_3, ONE_1, ONE_2, ONE_3, TWO_1, TWO_2, TWO_3)
internal val REMOVE_31 = intArrayOf(ZERO_0, ZERO_2, ZERO_3, ONE_0, ONE_2, ONE_3, TWO_0, TWO_2, TWO_3)
internal val REMOVE_32 = intArrayOf(ZERO_0, ZERO_1, ZERO_3, ONE_0, ONE_1, ONE_3, TWO_0, TWO_1, TWO_3)
internal val REMOVE_33 = intArrayOf(ZERO_0, ZERO_1, ZERO_2, ONE_0, ONE_1, ONE_2, TWO_0, TWO_1, TWO_2)

internal val submatrixIndices = arrayOf(
    REMOVE_00,
    REMOVE_01,
    REMOVE_02,
    REMOVE_03,

    REMOVE_10,
    REMOVE_11,
    REMOVE_12,
    REMOVE_13,

    REMOVE_20,
    REMOVE_21,
    REMOVE_22,
    REMOVE_23,

    REMOVE_30,
    REMOVE_31,
    REMOVE_32,
    REMOVE_33
)

fun makeTranslation(x:Float, y: Float, z: Float): Matrix {
    return Matrix(x, y, z)
}

fun makeScaling(x:Float, y: Float, z: Float): Matrix {
    return Matrix(
            x, 0.0f, 0.0f, 0.0f,
            0.0f, y,0.0f, 0.0f,
            0.0f,0.0f, z, 0.0f,
            0.0f,0.0f,0.0f,1.0f
        )
}

fun makeShearing(
    xRelativeToY: Float,
    xRelativeToZ: Float,
    yRelativeToX: Float,
    yRelativeToZ: Float,
    zRelativeToX: Float,
    zRelativeToY: Float
) : Matrix {
    return Matrix(
        1.0f, xRelativeToY, xRelativeToZ, 0.0f,
        yRelativeToX, 1.0f, yRelativeToZ, 0.0f,
        zRelativeToX, zRelativeToY, 1.0f, 0.0f,
        0.0f, 0.0f, 0.0f, 1.0f
    )
}

fun rotationX(radians: Float): Matrix {
    return Matrix(
        1.0f, 0.0f, 0.0f, 0.0f,
        0.0f, approxCos(radians), -approxSin(radians), 0.0f,
        0.0f, approxSin(radians), approxCos(radians), 0.0f,
        0.0f, 0.0f, 0.0f, 1.0f
    )
}

fun rotationY(radians: Float): Matrix {
    return Matrix(
        approxCos(radians), 0.0f, approxSin(radians), 0.0f,
        0.0f, 1.0f, 0.0f, 0.0f,
        -approxSin(radians), 0.0f, approxCos(radians), 0.0f,
        0.0f, 0.0f, 0.0f, 1.0f
    )
}

fun rotationZ(radians: Float): Matrix {
    return Matrix(
        approxCos(radians), -approxSin(radians), 0.0f, 0.0f,
        approxSin(radians), approxCos(radians), 0.0f, 0.0f,
        0.0f, 0.0f, 1.0f, 0.0f,
        0.0f, 0.0f, 0.0f, 1.0f
    )
}