package sample

import raytracerchallenge.cameraimpl.Camera
import raytracerchallenge.cameraimpl.viewTransform
import raytracerchallenge.canvasimpl.Canvas
import raytracerchallenge.matriximpl.*
import raytracerchallenge.raysimpl.*
import raytracerchallenge.shadingimpl.*
import raytracerchallenge.tupleimpl.*
import raytracerchallenge.constants.*
import raytracerchallenge.patternimpl.*
import raytracerchallenge.worldimpl.*
import kotlin.test.*

class SampleTests {

    @Test
    fun testTuple() {
        val aPoint = Tuple(4.3f, 4.2f, 3.1f, 1.0f)
        val aVector = Tuple(4.3f, -4.2f, 3.1f, 0.0f)

        assertTrue(isPoint(aPoint), aPoint.toString())
        assertFalse(isVector(aPoint), aPoint.toString())

        assertTrue(isVector(aVector), aPoint.toString())
        assertFalse(isPoint(aVector), aPoint.toString())

        assertEquals(Tuple(4.3f, 4.2f, 3.1f, 1.0f), aPoint)
        assertEquals(Tuple(4.3f, -4.2f, 3.1f, 0.0f),aVector)
        assertNotEquals(aVector, aPoint)

        val samePoint = makePoint(4.3f, 4.2f, 3.1f)
        val sameVector = makeVector(4.3f, -4.2f, 3.1f)

        assertEquals(samePoint, aPoint)
        assertEquals(sameVector, aVector)
        assertNotEquals(samePoint, sameVector)
    }

    @Test
    fun testTupleArithmetic() {
        val aPoint = Tuple(3.0f, -2.0f, 5.0f, 1.0f)
        val aVector = Tuple(-2.0f, 3.0f, 1.0f, 0.0f)
        val pointPlusVector = aPoint + aVector
        assertTrue(pointPlusVector.equals(Tuple(1.0f, 1.0f, 6.0f, 1.0f)), pointPlusVector.toString())

        val endPoint = makePoint(3.0f, 2.0f, 1.0f)
        val startPoint = makePoint(5.0f, 6.0f, 7.0f)
        val pathVector = endPoint - startPoint
        assertTrue(pathVector.equals(makeVector(-2.0f, -4.0f, -6.0f)), pathVector.toString())

        val positiveVector = makeVector(-2.0f, -4.0f, -6.0f)
        val negativeVector = -positiveVector
        val addedVectors = positiveVector + negativeVector
        assertTrue(addedVectors.equals(VECTOR_ZERO), addedVectors.toString())

        val thisPoint = makePoint(3.0f, 2.0f, 1.0f)
        val thisVector = makeVector(5.0f, 6.0f, 7.0f)
        val pointMinusVector = thisPoint - thisVector
        assertTrue(pointMinusVector.equals(
            makePoint(
                -2.0f,
                -4.0f,
                -6.0f
            )
        ), pointMinusVector.toString())

        val firstVector = makeVector(3.0f, 2.0f, 1.0f)
        val secondVector = makeVector(5.0f, 6.0f, 7.0f)
        val subtractedVectors = firstVector - secondVector
        assertTrue(subtractedVectors.equals(
            makeVector(
                -2.0f,
                -4.0f,
                -6.0f
            )
        ), subtractedVectors.toString())

        val nonZeroVector = makeVector(1.0f, -2.0f, 3.0f)
        val vectorMinusZero = VECTOR_ZERO - nonZeroVector
        val negatedVector = -nonZeroVector
        assertTrue(vectorMinusZero.equals(
            makeVector(
                -1.0f,
                2.0f,
                -3.0f
            )
        ), vectorMinusZero.toString())
        assertEquals(negatedVector,vectorMinusZero)

        val aTuple = Tuple(1.0f, -2.0f, 3.0f, -4.0f)
        val timesTuple = 3.5f * aTuple
        val timesTupleAgain = aTuple * 3.5f
        assertEquals(Tuple(3.5f, -7.0f, 10.5f, -14.0f), timesTuple)
        assertEquals(timesTupleAgain,timesTuple)

        val wholeTuple = Tuple(1.0f, -2.0f, 3.0f, -4.0f)
        val dividedTuple = wholeTuple/2.0f
        val halfTuple = wholeTuple * 0.5f
        assertEquals(Tuple(0.5f, -1.0f, 1.5f, -2.0f), dividedTuple)
        assertEquals(halfTuple,dividedTuple)
    }

    @Test
    fun testTupleMath() {
        val xOneVector: Tuple = VECTOR_UNIT_X
        assertTrue(isOne(xOneVector.magnitude()), xOneVector.toString())

        val yOneVector: Tuple = VECTOR_UNIT_Y
        assertTrue(isOne(yOneVector.magnitude()), yOneVector.toString())

        val zOneVector: Tuple = VECTOR_UNIT_Z
        assertTrue(isOne(zOneVector.magnitude()), zOneVector.toString())

        run {
            val vector: Tuple =
                makeVector(1.0f, 2.0f, 3.0f)
            val magnitude: Float = magnitude(vector)
            assertTrue(equalsFloat(magnitude, 3.7416573f), magnitude.toString())
        }

        run {
            val vector: Tuple =
                makeVector(-1.0f, -2.0f, -3.0f)
            val magnitude: Float = magnitude(vector)
            assertTrue(equalsFloat(magnitude, 3.7416573f), magnitude.toString())
        }

        run {
            val vector = makeVector(1.0f, 2.0f, 3.0f)
            val normalVector = normalized(vector)
            assertEquals(makeVector(0.26726f,0.53452f,0.80178f), normalVector)
            val normalMagnitude: Float = normalVector.magnitude()
            assertTrue(isOne(normalMagnitude), normalMagnitude.toString())
        }

        run {
            val oneVector = makeVector(1.0f, 2.0f, 3.0f)
            val otherVector = makeVector(2.0f, 3.0f, 4.0f)
            val dotProduct = dot(oneVector, otherVector)
            assertTrue(equalsFloat(dotProduct, 20.0f), dotProduct.toString())
        }

        run {
            val oneVector = makeVector(1.0f, 2.0f, 3.0f)
            val otherVector = makeVector(2.0f, 3.0f, 4.0f)
            val oneDotOther = cross(oneVector, otherVector)
            val otherDotOne = cross(otherVector, oneVector)
            assertEquals(makeVector(-1.0f,2.0f,-1.0f), oneDotOther)
            assertEquals(makeVector(1.0f, -2.0f, 1.0f), otherDotOne)
        }
    }

    @Test
    fun testColor() {
        run {
            val color = makeColor(-0.5f, 0.4f, 1.7f)
            assertTrue(equalsFloat(color.red(), -0.5f), color.red().toString())
            assertTrue(equalsFloat(color.green(), 0.4f), color.green().toString())
            assertTrue(equalsFloat(color.blue(), 1.7f), color.blue().toString())
        }

        run {
            val aColor = makeColor(1.0f, 0.2f, 0.4f)
            val otherColor = makeColor(0.9f, 1.0f, 0.1f)
            val blendedColor = blend(aColor, otherColor)
            assertEquals(makeColor(0.9f, 0.2f, 0.04f), blendedColor)
        }

        run {
            val ppmOutput = """
                P3
                5 3 255
                255 0 0
                0 0 0
                0 0 0
                0 0 0
                0 0 0
                0 0 0
                0 0 0
                0 128 0
                0 0 0
                0 0 0
                0 0 0
                0 0 0
                0 0 0
                0 0 0
                0 0 255
            """.trimIndent()

            val canvas = Canvas(5, 3)
            canvas.writePixel(0, 0, makeColor(1.5f, 0.0f, 0.0f))
            canvas.writePixel(2, 1, makeColor(0.0f, 0.5f, 0.0f))
            canvas.writePixel(4, 2, makeColor(-0.5f, 0.0f, 1.0f))
            assertEquals(ppmOutput, canvas.toString())
        }
    }

    @Test
    fun testMatrix() {
        run {
            val matrix = Matrix(
                Tuple(1.0f, 2.0f, 3.0f, 4.0f),
                Tuple(5.5f, 6.5f, 7.5f, 8.5f),
                Tuple(9.0f, 10.0f, 11.0f, 12.0f),
                Tuple(13.5f, 14.5f, 15.5f, 16.5f)
            )

            assertTrue(equalsFloat(matrix[0,0], 1.0f), "(0,0) = " + matrix[0,0].toString())
            assertTrue(equalsFloat(matrix[0,3], 4.0f), "(0,3) = " + matrix[0,3].toString())
            assertTrue(equalsFloat(matrix[1,0], 5.5f), "(1,0) = " + matrix[1,1].toString())
            assertTrue(equalsFloat(matrix[1,2], 7.5f), "(1,2) = " + matrix[1,2].toString())
            assertTrue(equalsFloat(matrix[2,2], 11f), "(2,2) = " + matrix[2,2].toString())
            assertTrue(equalsFloat(matrix[3,0], 13.5f), "(3,0) = " + matrix[3,0].toString())
            assertTrue(equalsFloat(matrix[3,2], 15.5f), "(3,2) = " + matrix[3,2].toString())
        }

        run {
            val matrix = Matrix(
                Tuple(-3.0f, 5.0f, 0.0f, 0.0f),
                Tuple(1.0f, -2.0f, 0.0f, 0.0f),
                VECTOR_ZERO,
                VECTOR_ZERO
            )

            assertTrue(equalsFloat(matrix[0,0], -3.0f), matrix[0,0].toString())
            assertTrue(equalsFloat(matrix[0,1], 5.0f), matrix[0,1].toString())
            assertTrue(equalsFloat(matrix[1,0], 1.0f), matrix[1,0].toString())
            assertTrue(equalsFloat(matrix[1,1], -2.0f), matrix[1,1].toString())
        }

        run {
            val aMatrix = Matrix(
                Tuple(1.0f, 2.0f, 3.0f, 4.0f),
                Tuple(5.0f, 6.0f, 7.0f, 8.0f),
                Tuple(9.0f, 8.0f, 7.0f, 6.0f),
                Tuple(13.0f, 14.0f, 15.0f, 16.0f)
            )

            val sameMatrix = Matrix(
                Tuple(1.0f, 2.0f, 3.0f, 4.0f),
                Tuple(5.0f, 6.0f, 7.0f, 8.0f),
                Tuple(9.0f, 8.0f, 7.0f, 6.0f),
                Tuple(13.0f, 14.0f, 15.0f, 16.0f)
            )

            val differentMatrix = Matrix(
                Tuple(2.0f, 3.0f, 4.0f, 5.0f),
                Tuple(6.0f, 7.0f, 8.0f, 9.0f),
                Tuple(8.0f, 7.0f, 6.0f, 5.0f),
                Tuple(4.0f, 3.0f, 2.0f, 1.0f)
            )

            assertTrue(aMatrix.equals(sameMatrix), "Not equal $aMatrix")
            assertFalse(aMatrix.equals(differentMatrix), "Equal $aMatrix")
        }

        run {
            val aMatrix = Matrix(
                Tuple(1.0f, 2.0f, 3.0f, 4.0f),
                Tuple(5.0f, 6.0f, 7.0f, 8.0f),
                Tuple(9.0f, 8.0f, 7.0f, 6.0f),
                Tuple(5.0f, 4.0f, 3.0f, 2.0f)
            )

            val otherMatrix = Matrix(
                Tuple(-2.0f,1.0f, 2.0f, 3.0f),
                Tuple(3.0f, 2.0f, 1.0f, -1.0f),
                Tuple(4.0f, 3.0f, 6.0f, 5.0f),
                Tuple(1.0f, 2.0f, 7.0f, 8.0f)
            )

            val expected = Matrix(
                Tuple(20.0f, 22.0f, 50.0f, 48.0f),
                Tuple(44.0f, 54.0f, 114.0f, 108.0f),
                Tuple(40.0f, 58.0f, 110.0f, 102.0f),
                Tuple(16.0f, 26.0f, 46.0f, 42.0f)
            )

            val result = aMatrix.multipliedBy(otherMatrix)
            assertTrue(result.equals(expected), result.toString())
        }

        run {
            val aMatrix = Matrix(
                Tuple(1.0f, 2.0f, 3.0f, 4.0f),
                Tuple(2.0f, 4.0f, 4.0f, 2.0f),
                Tuple(8.0f, 6.0f, 4.0f, 1.0f),
                Tuple(0.0f, 0.0f, 0.0f, 1.0f)
            )

            val aTuple = Tuple(1.0f, 2.0f, 3.0f, 1.0f)
            val result = aMatrix.multipliedBy(aTuple)
            val expected = Tuple(18.0f, 24.0f, 33.0f, 1.0f)

            assertTrue(result.equals(expected), result.toString())
        }

        run {
            val aMatrix = IDENTITY_MATRIX
            val aTuple = Tuple(1.0f, 2.0f, 3.0f, 4.0f)
            val result = aMatrix.multipliedBy(aTuple)
            assertTrue(result.equals(aTuple), result.toString())
        }

        run {
            val aMatrix = Matrix(
                0.0f, 9.0f, 3.0f, 0.0f,
                9.0f, 8.0f, 0.0f, 8.0f,
                1.0f, 8.0f, 5.0f, 3.0f,
                0.0f, 0.0f, 5.0f, 8.0f
            )
            val transposedMatrix = aMatrix.transposed()
            val expectedMatrix = Matrix(
                0.0f, 9.0f, 1.0f, 0.0f,
                9.0f, 8.0f, 8.0f, 0.0f,
                3.0f, 0.0f, 5.0f, 5.0f,
                0.0f, 8.0f, 3.0f, 8.0f
            )
            assertTrue(transposedMatrix.equals(expectedMatrix), transposedMatrix.toString())
            val transposedIdentity = IDENTITY_MATRIX.transposed()
            assertTrue(transposedIdentity.equals(IDENTITY_MATRIX), transposedIdentity.toString())
        }

        run {
            val aMatrix = Matrix(
                makeVector(1.0f, 5.0f, 0.0f),
                makeVector(-3.0f, 2.0f, 7.0f),
                makeVector(0.0f, 6.0f, -3.0f),
                VECTOR_ZERO
            )
            val smallerMatrix = aMatrix.subMatrix(0, 2)
            val expectedMatrix = Matrix(
                makeVector(-3.0f, 2.0f, 0.0f),
                makeVectorY(6.0f),
                VECTOR_ZERO,
                VECTOR_ZERO
            )
            assertTrue(smallerMatrix.equals(expectedMatrix), smallerMatrix.toString())
        }

        run {
            val aMatrix = Matrix(
                -6.0f, 1.0f, 1.0f, 6.0f,
                -8.0f, 5.0f, 8.0f, 6.0f,
                -1.0f, 0.0f, 8.0f, 2.0f,
                -7.0f, 1.0f, -1.0f, 1.0f
            )
            val smallerMatrix = aMatrix.subMatrix(2, 1)
            val expectedMatrix = Matrix(
                makeVector(-6.0f, 1.0f, 6.0f),
                makeVector(-8.0f, 8.0f, 6.0f),
                makeVector(-7.0f,-1.0f, 1.0f),
                VECTOR_ZERO
            )
            assertTrue(smallerMatrix.equals(expectedMatrix), smallerMatrix.toString())
        }

        run {
            val matrix = Matrix(
                makeVector(1.0f, 5.0f, 0.0f),
                makeVector(-3.0f, 2.0f, 0.0f),
                VECTOR_ZERO,
                VECTOR_ZERO
            )
            val determinant2x2 = matrix.determinant2x2()
            assertTrue(equalsFloat(determinant2x2,17.0f), determinant2x2.toString())
        }

        run {
            val matrix = Matrix(
                makeVector(3.0f, 5.0f, 0.0f),
                makeVector(2.0f, -1.0f, -7.0f),
                makeVector(6.0f, -1.0f, 5.0f),
                VECTOR_ZERO
            )
            val minor3x3 = matrix.minor3x3(1, 0)
            val subMatrix = matrix.subMatrix(1,0)
            val verified = subMatrix.determinant2x2()
            assertTrue(equalsFloat(verified,25.0f), verified.toString())
            assertTrue(equalsFloat(minor3x3,verified), minor3x3.toString())
        }

        run {
            val matrix = Matrix(
                makeVector(3.0f, 5.0f, 0.0f),
                makeVector(2.0f, -1.0f, -7.0f),
                makeVector(6.0f, -1.0f, 5.0f),
                VECTOR_ZERO
            )
            val minor00 = matrix.minor3x3(0, 0)
            val cofactor00 = matrix.cofactor3x3(0,0)
            val minor10 = matrix.minor3x3(1, 0)
            val cofactor10 = matrix.cofactor3x3(1, 0)
            assertTrue(equalsFloat(minor00,-12.0f), minor00.toString())
            assertTrue(equalsFloat(cofactor00, -12.0f), cofactor00.toString())
            assertTrue(equalsFloat(minor10,25.0f), minor10.toString())
            assertTrue(equalsFloat(cofactor10, -25.0f), cofactor10.toString())
        }

        run {
            val matrix = Matrix(
                makeVector(1.0f, 2.0f, 6.0f),
                makeVector(-5.0f, 8.0f, -4.0f),
                makeVector(2.0f, 6.0f, 4.0f),
                VECTOR_ZERO
            )
            val cofactor00 = matrix.cofactor3x3(0,0)
            val cofactor01 = matrix.cofactor3x3(0, 1)
            val cofactor02 = matrix.cofactor3x3(0, 2)
            val determinant = matrix.determinant3x3()

            assertTrue(equalsFloat(cofactor00,56.0f), "expected: 56.0f - $cofactor00")
            assertTrue(equalsFloat(cofactor01, 12.0f), "expected: 12.0f - $cofactor01")
            assertTrue(equalsFloat(cofactor02,-46.0f), "expected: -46.0f - $cofactor02")
            assertTrue(equalsFloat(determinant, -196.0f), "expected: -196.0f - $determinant")
        }

        run {
            val matrix = Matrix(
                -2.0f, -8.0f, 3.0f, 5.0f,
                -3.0f, 1.0f, 7.0f, 3.0f,
                 1.0f, 2.0f, -9.0f, 6.0f,
                -6.0f, 7.0f, 7.0f, -9.0f
            )
            val cofactor00 = matrix.cofactor(0,0)
            val cofactor01 = matrix.cofactor(0, 1)
            val cofactor02 = matrix.cofactor(0, 2)
            val cofactor03 = matrix.cofactor(0, 3)
            val determinant = matrix.determinant()

            assertTrue(equalsFloat(cofactor00,690.0f), "expected: 690.0f - $cofactor00")
            assertTrue(equalsFloat(cofactor01, 447.0f), "expected: 447.0f - $cofactor01")
            assertTrue(equalsFloat(cofactor02,210.0f), "expected: 210.0f - $cofactor02")
            assertTrue(equalsFloat(cofactor03,51.0f), "expected: 51.0f - $cofactor03")
            assertTrue(equalsFloat(determinant, -4071.0f), "expected: -4071.0f - $determinant")
        }

        run {
            val matrix = Matrix(
                6.0f, 4.0f, 4.0f, 4.0f,
                5.0f, 5.0f, 7.0f, 6.0f,
                4.0f, -9.0f, 3.0f, -7.0f,
                9.0f, 1.0f, 7.0f, -6.0f
            )
            assertTrue(matrix.invertible(), matrix.invertible().toString())

            val otherMatrix = Matrix(
                -4.0f, 2.0f, -2.0f, -3.0f,
                9.0f, 6.0f, 2.0f, 6.0f,
                0.0f, -5.0f, 1.0f, -5.0f,
                0.0f, 0.0f, 0.0f, 0.0f
            )
            assertFalse(otherMatrix.invertible(), otherMatrix.invertible().toString())
        }

        run {
            val matrix = Matrix(
                -5.0f, 2.0f, 6.0f, -8.0f,
                1.0f, -5.0f, 1.0f, 8.0f,
                7.0f, 7.0f, -6.0f, -7.0f,
                1.0f, -3.0f, 7.0f, 4.0f
            )
            val inverse = matrix.inverse()
            val expectedInverse = Matrix(
                0.21805f, 0.45113f, 0.24060f, -0.04511f,
                -0.80827f, -1.45677f, -0.44361f, 0.52068f,
                -0.07895f, -0.22368f, -0.05263f, 0.19737f,
                -0.52256f, -0.81391f, -0.30075f, 0.30639f
            )
            val cofactor23 = matrix.cofactor(2, 3)
            val cofactor32 = matrix.cofactor(3, 2)
            assertTrue(equalsFloat(matrix.determinant(), 532.0f), matrix.determinant().toString())
            assertTrue(equalsFloat(cofactor23, -160.0f), cofactor23.toString())
            assertTrue(equalsFloat(inverse[3, 2], -160.0f/532.0f), inverse[3, 2].toString())
            assertTrue(equalsFloat(cofactor32, 105.0f), cofactor32.toString())
            assertTrue(equalsFloat(inverse[2, 3], 105.0f/532.0f), inverse[3, 2].toString())
            assertTrue(inverse.equals(expectedInverse), inverse.toString())
        }

        run {
            val matrix = Matrix(
                8.0f, -5.0f, 9.0f, 2.0f,
                7.0f, 5.0f, 6.0f, 1.0f,
                -6.0f, 0.0f, 9.0f, 6.0f,
                -3.0f, 0.0f, -9.0f, -4.0f
            )

            val expectedInverse = Matrix(
                -0.15385f, -0.15385f, -0.28205f, -0.53846f,
                -0.07692f,  0.12308f,  0.02564f,  0.03077f,
                0.35897f,  0.35897f,  0.43590f,  0.92308f,
                -0.69231f, -0.69231f, -0.76923f, -1.92308f
            )

            val inverse = matrix.inverse()
            assertTrue(inverse.equals(expectedInverse), inverse.toString())
        }

        run {
            val matrix = Matrix(
                9.0f,  3.0f,  0.0f,  9.0f,
               -5.0f, -2.0f, -6.0f, -3.0f,
               -4.0f,  9.0f,  6.0f,  4.0f,
               -7.0f,  6.0f,  6.0f,  2.0f
            )

            val expectedInverse = Matrix(
                -0.04074f, -0.07778f,  0.14444f, -0.22222f,
                -0.07778f,  0.03333f,  0.36667f, -0.33333f,
                -0.02901f, -0.14630f, -0.10926f,  0.12963f,
                0.17778f,  0.06667f, -0.26667f,  0.33333f
            )

            val inverse = matrix.inverse()
            assertTrue(inverse.equals(expectedInverse), inverse.toString())
        }

        run {
            val matrix = Matrix(
               3.0f, -9.0f,  7.0f,  3.0f,
               3.0f, -8.0f,  2.0f, -9.0f,
               -4.0f,  4.0f,  4.0f,  1.0f,
               -6.0f,  5.0f, -1.0f,  1.0f
            )

            val otherMatrix = Matrix(
                8.0f,  2.0f,  2.0f,  2.0f,
                3.0f, -1.0f,  7.0f,  0.0f,
                7.0f,  0.0f,  5.0f,  4.0f,
                6.0f, -2.0f,  0.0f,  5.0f
            )

            val multiplied = matrix.multipliedBy(otherMatrix)
            assertTrue(multiplied.multipliedBy(otherMatrix.inverse()).equals(matrix))
        }
    }

    @Test
    fun testTransformation() {
        run {
            val transform = makeTranslation(5.0f, -3.0f, 2.0f)
            val p = makePoint(-3.0f, 4.0f, 5.0f)
            val expectedPoint = makePoint(2.0f, 1.0f, 7.0f)
            val translated = transform.multipliedBy(p)
            assertTrue(translated.equals(expectedPoint), translated.toString())
        }

        run {
            val transform = makeTranslation(5.0f, -3.0f, 2.0f)
            val inverse = transform.inverse()
            val p = makePoint(-3.0f, 4.0f, 5.0f)
            val expectedPoint = makePoint(-8.0f, 7.0f, 3.0f)
            val translated = inverse.multipliedBy(p)
            assertTrue(translated.equals(expectedPoint), translated.toString())
        }

        run {
            val transform = makeTranslation(5.0f, -3.0f, 2.0f)
            val vector = makeVector(-3.0f, 4.0f, 5.0f)
            assertTrue(vector.equals(transform.multipliedBy(vector)))
        }

        run {
            val transform = makeScaling(2.0f, 3.0f, 4.0f)
            val p = makePoint(-4.0f, 6.0f, 8.0f)
            val expectedPoint = makePoint(-8.0f, 18.0f, 32.0f)
            val scaled = transform.multipliedBy(p)
            assertTrue(scaled.equals(expectedPoint), scaled.toString())
        }

        run {
            val transform = makeScaling(2.0f, 3.0f, 4.0f)
            val v = makeVector(-4.0f, 6.0f, 8.0f)
            val expectedVector = makeVector(-8.0f, 18.0f, 32.0f)
            val scaled = transform.multipliedBy(v)
            assertTrue(scaled.equals(expectedVector), scaled.toString())
        }

        run {
            val transform = makeScaling(2.0f, 3.0f, 4.0f)
            val inverse = transform.inverse()
            val v = makeVector(-4.0f, 6.0f, 8.0f)
            val expectedVector = makeVector(-2.0f, 2.0f, 2.0f)
            val scaled = inverse.multipliedBy(v)
            assertTrue(scaled.equals(expectedVector), scaled.toString())
        }

        run {
            val transform = makeScaling(-1.0f, 1.0f, 1.0f)
            val point = makePoint(2.0f, 3.0f, 4.0f)
            val expectedPoint = makePoint(-2.0f, 3.0f, 4.0f)
            val scaled = transform.multipliedBy(point)
            assertTrue(scaled.equals(expectedPoint), scaled.toString())
        }

        run {
            val point = POINT_UNIT_Y
            val halfQuarter = rotationX(QUARTER_PI)
            val fullQuarter = rotationX(HALF_PI)
            val expectedHalfQuarterPoint = makePoint(0.0f, HALF_ROOT_OF_TWO, HALF_ROOT_OF_TWO)
            val expectedFullQuarterPoint = POINT_UNIT_Z
            val halfQuarterPoint = halfQuarter.multipliedBy(point)
            val fullQuarterPoint = fullQuarter.multipliedBy(point)

            assertTrue(halfQuarterPoint.equals(expectedHalfQuarterPoint))
            assertTrue(fullQuarterPoint.equals(expectedFullQuarterPoint))
        }

        run {
            val point = POINT_UNIT_Y
            val halfQuarter = rotationX(QUARTER_PI)
            val inverse = halfQuarter.inverse()
            val expectedPoint = makePoint(0.0f, HALF_ROOT_OF_TWO,-HALF_ROOT_OF_TWO)
            val rotated = inverse.multipliedBy(point)

            assertTrue(rotated.equals(expectedPoint), "$rotated is not $expectedPoint")
        }

        run {
            val point = POINT_UNIT_Z
            val halfQuarter = rotationY(QUARTER_PI)
            val fullQuarter = rotationY(HALF_PI)
            val expectedHalfQuarterPoint = makePoint(HALF_ROOT_OF_TWO, 0.0f, HALF_ROOT_OF_TWO)
            val expectedFullQuarterPoint = POINT_UNIT_X
            val halfQuarterPoint = halfQuarter.multipliedBy(point)
            val fullQuarterPoint = fullQuarter.multipliedBy(point)

            assertTrue(halfQuarterPoint.equals(expectedHalfQuarterPoint))
            assertTrue(fullQuarterPoint.equals(expectedFullQuarterPoint))
        }

        run {
            val point = POINT_UNIT_Y
            val halfQuarter = rotationZ(QUARTER_PI)
            val fullQuarter = rotationZ(HALF_PI)
            val expectedHalfQuarterPoint = makePoint(-HALF_ROOT_OF_TWO, HALF_ROOT_OF_TWO, 0.0f)
            val expectedFullQuarterPoint = makePointX(-1.0f)
            val halfQuarterPoint = halfQuarter.multipliedBy(point)
            val fullQuarterPoint = fullQuarter.multipliedBy(point)

            assertTrue(halfQuarterPoint.equals(expectedHalfQuarterPoint))
            assertTrue(fullQuarterPoint.equals(expectedFullQuarterPoint))
        }

        run {
            val transform = makeShearing(0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f)
            val point = makePoint(2.0f, 3.0f, 4.0f)
            val expectedPoint = makePoint(6.0f, 3.0f, 4.0f)
            assertTrue(expectedPoint.equals(transform.multipliedBy(point)))
        }

        run {
            val transform = makeShearing(0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f)
            val point = makePoint(2.0f, 3.0f, 4.0f)
            val expectedPoint = makePoint(2.0f, 5.0f, 4.0f)
            assertTrue(expectedPoint.equals(transform.multipliedBy(point)))
        }

        run {
            val transform = makeShearing(0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f)
            val point = makePoint(2.0f, 3.0f, 4.0f)
            val expectedPoint = makePoint(2.0f, 7.0f, 4.0f)
            assertTrue(expectedPoint.equals(transform.multipliedBy(point)))
        }

        run {
            val transform = makeShearing(0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f)
            val point = makePoint(2.0f, 3.0f, 4.0f)
            val expectedPoint = makePoint(2.0f, 3.0f, 6.0f)
            assertTrue(expectedPoint.equals(transform.multipliedBy(point)))
        }

        run {
            val transform = makeShearing(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f)
            val point = makePoint(2.0f, 3.0f, 4.0f)
            val expectedPoint = makePoint(2.0f, 3.0f, 7.0f)
            assertTrue(expectedPoint.equals(transform.multipliedBy(point)))
        }

        run {
            val point = makePoint(1.0f, 0.0f, 1.0f)
            val rotationX = rotationX(HALF_PI)
            val scaling = makeScaling(5.0f, 5.0f, 5.0f)
            val translation = makeTranslation(10.0f, 5.0f, 7.0f)

            val rotatedPoint = rotationX.multipliedBy(point)
            assertTrue(rotatedPoint.equals(makePoint(1.0f, -1.0f, 0.0f)), rotatedPoint.toString())
            val scaled = scaling.multipliedBy(rotatedPoint)
            assertTrue(scaled.equals(makePoint(5.0f, -5.0f, 0.0f)), scaled.toString())
            val translated = translation.multipliedBy(scaled)
            assertTrue(translated.equals(makePoint(15.0f, 0.0f, 7.0f)), translated.toString())
            val transformation = translation.multipliedBy(scaling).multipliedBy(rotationX)
            val transformed = transformation.multipliedBy(point)
            assertTrue(transformed.equals(makePoint(15.0f, 0.0f, 7.0f)), transformed.toString())
        }
    }

    @Test
    fun testRay() {
        run {
            val origin = makePoint(1.0f, 2.0f, 3.0f)
            val direction = makeVector(4.0f, 5.0f, 6.0f)
            val ray = Ray(origin, direction)
            assertTrue(ray.origin.equals(origin))
            assertTrue(ray.direction.equals(direction))
        }

        run {
            val ray = Ray(makePoint(2.0f, 3.0f, 4.0f), VECTOR_UNIT_X)
            assert(ray.position(0.0f).equals(makePoint(2.0f, 3.0f, 4.0f)))
            assert(ray.position(1.0f).equals(makePoint(3.0f, 3.0f, 4.0f)))
            assert(ray.position(-1.0f).equals(makePoint(1.0f, 3.0f, 4.0f)))
            assert(ray.position(2.5f).equals(makePoint(4.5f, 3.0f, 4.0f)))

        }

        run {
            val ray = Ray(makePointZ(-5.0f), VECTOR_UNIT_Z)
            val sphere = Sphere()
            val xs = sphere.intersectGetT(ray)
            assertTrue(xs.size == 2, xs.contentToString())
            assertTrue(equalsFloat(xs[0], 4.0f), xs.contentToString())
            assertTrue(equalsFloat(xs[1], 6.0f), xs.contentToString())
        }

        run {
            val ray = Ray(makePoint(0.0f, 1.0f, -5.0f), VECTOR_UNIT_Z)
            val sphere = Sphere()
            val xs = sphere.intersectGetT(ray)
            assertTrue(xs.size == 2, xs.contentToString())
            assertTrue(equalsFloat(xs[0], 5.0f), xs.contentToString())
            assertTrue(equalsFloat(xs[1], 5.0f), xs.contentToString())
        }

        run {
            val ray = Ray(makePoint(0.0f, 2.0f, -5.0f), VECTOR_UNIT_Z)
            val sphere = Sphere()
            val xs = sphere.intersectGetT(ray)
            assertTrue(xs.isEmpty(), xs.contentToString())
        }

        run {
            val ray = Ray(POINT_ZERO, VECTOR_UNIT_Z)
            val sphere = Sphere()
            val xs = sphere.intersectGetT(ray)
            assertTrue(xs.size == 2, xs.contentToString())
            assertTrue(equalsFloat(xs[0], -1.0f), xs.contentToString())
            assertTrue(equalsFloat(xs[1], 1.0f), xs.contentToString())
        }

        run {
            val ray = Ray(makePointZ(5.0f), VECTOR_UNIT_Z)
            val sphere = Sphere()
            val xs = sphere.intersectGetT(ray)
            assertTrue(xs.size == 2, xs.contentToString())
            assertTrue(equalsFloat(xs[0], -6.0f), xs.contentToString())
            assertTrue(equalsFloat(xs[1], -4.0f), xs.contentToString())
        }
    }

    @Test
    fun testIntersections() {
        run {
            val sphere = Sphere()
            val i1 = Intersection(1.0f, sphere)
            val i2 = Intersection(2.0f, sphere)
            val xs = arrayOf(i1, i2)
            assertTrue(xs.size.equals(2))
            assertTrue(equalsFloat(xs[0].tVal, 1.0f))
            assertTrue(equalsFloat(xs[1].tVal, 2.0f))
        }

        run {
            val ray = Ray(makePointZ(-5.0f), VECTOR_UNIT_Z)
            val sphere = Sphere()
            val crosses = sphere.intersect(ray)
            assertTrue(crosses.size.equals(2))
            assertEquals(crosses[0].obj, sphere)
            assertEquals(crosses[1].obj, sphere)
        }

        run {
            val sphere = Sphere()
            val cross1 = Intersection(1.0f, sphere)
            val cross2 = Intersection(2.0f, sphere)
            val crosses = arrayOf(cross1, cross2)
            val hit = hit(crosses)
            assertEquals(cross1, hit)
        }

        run {
            val sphere = Sphere()
            val cross1 = Intersection(-1.0f, sphere)
            val cross2 = Intersection(1.0f, sphere)
            val crosses = arrayOf(cross1, cross2)
            val hit = hit(crosses)
            assertEquals(cross2, hit)
        }

        run {
            val sphere = Sphere()
            val cross1 = Intersection(-2.0f, sphere)
            val cross2 = Intersection(-1.0f, sphere)
            val crosses = arrayOf(cross1, cross2)
            val hit = hit(crosses)
            assertEquals(NO_INTERSECTION, hit)
        }

        run {
            val sphere = Sphere()
            val cross1 = Intersection(5.0f, sphere)
            val cross2 = Intersection(7.0f, sphere)
            val cross3 = Intersection(-3.0f, sphere)
            val cross4 = Intersection(2.0f, sphere)
            val crosses = arrayOf(cross1, cross2, cross3, cross4)
            val hit = hit(crosses)
            assertEquals(cross4, hit)
        }

        run {
            val ray = Ray(makePoint(1.0f, 2.0f, 3.0f), VECTOR_UNIT_Y)
            val matrix = makeTranslation(3.0f, 4.0f, 5.0f)
            val transformedRay = ray.transform(matrix)
            val expectedPoint = makePoint(4.0f, 6.0f, 8.0f)
            val expectedVector = VECTOR_UNIT_Y
            assertTrue(transformedRay.origin.equals(expectedPoint))
            assertTrue(transformedRay.direction.equals(expectedVector))
        }

        run {
            val ray = Ray(makePoint(1.0f, 2.0f, 3.0f), VECTOR_UNIT_Y)
            val matrix = makeScaling(2.0f, 3.0f, 4.0f)
            val transformedRay = ray.transform(matrix)
            val expectedPoint = makePoint(2.0f, 6.0f, 12.0f)
            val expectedVector = makeVectorY(3.0f)
            assertTrue(transformedRay.origin.equals(expectedPoint))
            assertTrue(transformedRay.direction.equals(expectedVector))
        }

        run {
            val sphere = Sphere()
            assertTrue(sphere.transform.equals(IDENTITY_MATRIX))
        }

        run {
            val translation = makeTranslation(2.0f, 3.0f, 4.0f)
            val sphere = Sphere(DEFAULT_MATERIAL, translation)
            assertTrue(sphere.transform.equals(translation))
        }

        run {
            val ray = Ray(makePointZ(-5.0f), VECTOR_UNIT_Z)
            val sphere = Sphere(DEFAULT_MATERIAL, makeScaling(2.0f, 2.0f, 2.0f))
            val crosses = sphere.intersect(ray)
            assertEquals(crosses.size, 2)
            assertTrue(equalsFloat(crosses[0].tVal, 3.0f))
            assertTrue(equalsFloat(crosses[1].tVal, 7.0f))
        }

        run {
            val ray = Ray(makePointZ(-5.0f), VECTOR_UNIT_Z)
            val sphere = Sphere(DEFAULT_MATERIAL, makeTranslation(5.0f, 0.0f, 0.0f))
            val crosses = sphere.intersect(ray)
            assertEquals(crosses.size, 0)
        }
    }

    @Test
    fun testNormals() {
        run {
            val sphere = Sphere()
            val normal = sphere.normalAt(POINT_UNIT_X)
            assertTrue(normal.equals(VECTOR_UNIT_X))
        }

        run {
            val sphere = Sphere()
            val normal = sphere.normalAt(POINT_UNIT_Y)
            assertTrue(normal.equals(VECTOR_UNIT_Y))
        }

        run {
            val sphere = Sphere()
            val normal = sphere.normalAt(POINT_UNIT_Z)
            assertTrue(normal.equals(VECTOR_UNIT_Z))
        }

        run {
            val thirdRootOfThree = ROOT_OF_THREE / 3.0f
            val sphere = Sphere()
            val point = makePoint(thirdRootOfThree, thirdRootOfThree, thirdRootOfThree)
            val expectedNormal = makeDiagonalVector(thirdRootOfThree)
            val normal = sphere.normalAt(point)
            assertTrue(normal.equals(expectedNormal))
            assertTrue(normal.equals(normalized(normal)))
        }

        run {
            val sphere = Sphere(DEFAULT_MATERIAL, makeTranslation(0.0f, 1.0f, 0.0f))
            val normal = sphere.normalAt(makePoint(0.0f, 1.70711f, -0.70711f))
            assertTrue(normal.equals(makeVector(0.0f, 0.70711f, -0.70711f)))
        }

        run {
            val halfRootOfTwo = ROOT_OF_TWO/2.0f
            val sphere = Sphere(DEFAULT_MATERIAL, makeScaling(1.0f, 0.5f, 1.0f).multipliedBy(rotationZ(PI/5.0f)))
            val normal = sphere.normalAt(makePoint(0.0f, halfRootOfTwo, -halfRootOfTwo))
            assertTrue(normal.equals(makeVector(0.0f, 0.97014f, -0.24254f)))
        }
    }

    @Test
    fun testReflecting() {
        run {
            val vector = makeVector(1.0f, -1.0f, 0.0f)
            val normal = VECTOR_UNIT_Y
            val reflected = reflect(vector, normal)
            assertEquals(reflected, makeVector(1.0f, 1.0f, 0.0f))
        }

        run {
            val vector = - VECTOR_UNIT_Y
            val normal = makeVector(HALF_ROOT_OF_TWO, HALF_ROOT_OF_TWO, 0.0f)
            val reflected = reflect(vector, normal)
            assertEquals(reflected, VECTOR_UNIT_X)
        }
    }

    @Test
    fun testLighting() {
        run {
            val material = DEFAULT_MATERIAL
            val position = POINT_ZERO
            val eyeVector = MINUS_VECTOR_UNIT_Z
            val normalVector = MINUS_VECTOR_UNIT_Z
            val light = PointLight(makePointZ(-10.0f), WHITE_COLOR)
            val result = material.lighting(DEFAULT_SPHERE1, light, position, eyeVector, normalVector, false)
            assertEquals(result, makeColor(1.9f, 1.9f, 1.9f))
        }

        run {
            val material = DEFAULT_MATERIAL
            val position = POINT_ZERO
            val eyeVector = makeVector(0.0f, HALF_ROOT_OF_TWO, - HALF_ROOT_OF_TWO)
            val normalVector = MINUS_VECTOR_UNIT_Z
            val light = PointLight(makePointZ(-10.0f), WHITE_COLOR)
            val result = material.lighting(DEFAULT_SPHERE1, light, position, eyeVector, normalVector, false)
            assertEquals(result, makeColor(1.0f, 1.0f, 1.0f))
        }

        run {
            val material = DEFAULT_MATERIAL
            val position = POINT_ZERO
            val eyeVector = MINUS_VECTOR_UNIT_Z
            val normalVector = MINUS_VECTOR_UNIT_Z
            val light = PointLight(makePoint(0.0f, 10.0f, -10.0f), WHITE_COLOR)
            val result = material.lighting(DEFAULT_SPHERE1, light, position, eyeVector, normalVector, false)
            assertEquals(result, makeColor(0.7364f, 0.7364f, 0.7364f))
        }

        run {
            val material = DEFAULT_MATERIAL
            val position = POINT_ZERO
            val eyeVector = makeVector(0.0f, -HALF_ROOT_OF_TWO, - HALF_ROOT_OF_TWO)
            val normalVector = MINUS_VECTOR_UNIT_Z
            val light = PointLight(makePoint(0.0f, 10.0f, -10.0f), WHITE_COLOR)
            val result = material.lighting(DEFAULT_SPHERE1, light, position, eyeVector, normalVector, false)
            assertEquals(result, makeColor(1.636385f, 1.636385f, 1.636385f))
        }

        run {
            val material = DEFAULT_MATERIAL
            val position = POINT_ZERO
            val eyeVector = MINUS_VECTOR_UNIT_Z
            val normalVector = MINUS_VECTOR_UNIT_Z
            val light = PointLight(makePointZ(10.0f), WHITE_COLOR)
            val result = material.lighting(DEFAULT_SPHERE1, light, position, eyeVector, normalVector, false)
            assertEquals(result, makeColor(0.1f, 0.1f, 0.1f))
        }
    }

    @Test
    fun testWorld() {

        run {
            assertEquals(DEFAULT_LIGHT, DEFAULT_WORLD.light)
            assertTrue(DEFAULT_WORLD.shapes.contains(DEFAULT_SPHERE1) &&
                        DEFAULT_WORLD.shapes.contains(DEFAULT_SPHERE2))
        }

        run {
            val ray = Ray(makePointZ(-5.0f), VECTOR_UNIT_Z)
            val crosses = DEFAULT_WORLD.intersect(ray)
            assertEquals(crosses.size, 4)
            assertTrue(equalsFloat(crosses[0].tVal, 4.0f))
            assertTrue(equalsFloat(crosses[1].tVal, 4.5f))
            assertTrue(equalsFloat(crosses[2].tVal, 5.5f))
            assertTrue(equalsFloat(crosses[3].tVal, 6.0f))
        }
    }

    @Test
     fun testPrecomputation() {
        run {
            val ray = Ray(makePointZ(-5.0f), VECTOR_UNIT_Z)
            val shape = Sphere()
            val intersection = Intersection(4.0f, shape)
            val comps = Computations(intersection, ray)
            assertEquals(comps.obj, intersection.obj)
            assertEquals(comps.point, makePointZ(-1.0f))
            assertEquals(comps.eyeVector, MINUS_VECTOR_UNIT_Z)
            assertEquals(comps.normalVector, MINUS_VECTOR_UNIT_Z)
            assertFalse(comps.inside)
        }

        run {
            val ray = Ray(POINT_ZERO, VECTOR_UNIT_Z)
            val shape = Sphere()
            val intersection = Intersection(1.0f, shape)
            val comps = Computations(intersection, ray)

            assertEquals(comps.obj, intersection.obj)
            assertEquals(comps.point, POINT_UNIT_Z)
            assertEquals(comps.eyeVector, MINUS_VECTOR_UNIT_Z)
            assertEquals(comps.normalVector, MINUS_VECTOR_UNIT_Z)
            assertTrue(comps.inside)
        }

        run {
            val world = DEFAULT_WORLD
            val ray = Ray(makePointZ(-5.0f), VECTOR_UNIT_Z)
            val shape = world.shapes[0]
            val intersection = Intersection(4.0f, shape)
            val comps = Computations(intersection, ray)
            val color = world.shadeHit(comps, false)
            assertEquals(makeColor(0.38066f, 0.47583f, 0.2855f), color)
        }

        run {
            val world = World(PointLight(makePointY(0.25f), WHITE_COLOR), DEFAULT_SPHERES)
            val ray = Ray(POINT_ZERO, VECTOR_UNIT_Z)
            val shape = world.shapes[1]
            val intersection = Intersection(0.5f, shape)
            val comps = Computations(intersection, ray)
            val color = world.shadeHit(comps, false)
            assertEquals(makeColor(0.90498f, 0.90498f, 0.90498f), color)
        }

        run {
            val world = DEFAULT_WORLD
            val ray = Ray(makePointZ(-5.0f), VECTOR_UNIT_Y)
            val color = world.colorAt(ray)
            assertEquals(color, BLACK_COLOR)
        }

        run {
            val world = DEFAULT_WORLD
            val ray = Ray(makePointZ(-5.0f), VECTOR_UNIT_Z)
            val color = world.colorAt(ray, false)
            assertEquals(color, makeColor(0.38066f, 0.47583f, 0.2855f))
        }

        run {
            val sphere1 = Sphere(Material(
                makeColor(0.8f, 1.0f, 0.6f), 1.0f, 0.7f, 0.2f, 200.0f))

            val sphere2 = Sphere(Material(
                makeColor(0.8f, 1.0f, 0.6f), 1.0f, 0.7f, 0.2f, 200.0f),
                makeScaling(0.5f, 0.5f, 0.5f))

            val world = World(DEFAULT_LIGHT, arrayOf(sphere1, sphere2))
            val inner = world.shapes[1]
            val ray = Ray(makePointZ(0.75f), MINUS_VECTOR_UNIT_Z)
            val color = world.colorAt(ray, false)
            assertEquals(color, inner.material.colorAt(sphere1, POINT_ZERO))
        }
    }

    @Test
    fun testViewTransformation() {
        run {
            val from = POINT_ZERO
            val to = makePointZ(-1.0f)
            val up = POINT_UNIT_Y
            val t = viewTransform(from, to, up)
            assertEquals(t, IDENTITY_MATRIX)
        }

        run {
            val from = POINT_ZERO
            val to = POINT_UNIT_Z
            val up = POINT_UNIT_Y
            val t = viewTransform(from, to, up)
            assertEquals(t, makeScaling(-1.0f, 1.0f, -1.0f))
        }

        run {
            val from = makePointZ(8.0f)
            val to = POINT_ZERO
            val up = POINT_UNIT_Y
            val t = viewTransform(from, to, up)
            assertEquals(t, makeTranslation(0.0f, 0.0f, -8.0f))
        }

        run {
            val from = makePoint(1.0f, 3.0f, 2.0f)
            val to = makePoint(4.0f, -2.0f, 8.0f)
            val up = makePoint(1.0f, 1.0f, 0.0f)
            val t = viewTransform(from, to, up)
            val expectedMatrix = Matrix(
                -0.50709f, 0.50709f, 0.67612f, -2.36643f,
                0.76772f, 0.60609f, 0.12122f, -2.82843f,
                -0.35857f, 0.59761f, -0.71714f, 0.0f,
                0.0f, 0.0f, 0.0f, 1.0f
            )
            assertEquals(expectedMatrix, t)
        }
    }

    @Test
    fun testCamera() {
        run {
            val camera = Camera(160, 120, HALF_PI)
            assertEquals(camera.hSize, 160)
            assertEquals(camera.vSize, 120)
            assertEquals(camera.fieldOfView, HALF_PI)
            assertEquals(camera.transform, IDENTITY_MATRIX)
        }

        run {
            val camera = Camera(200, 125, HALF_PI)
            assertTrue(equalsFloat(0.01f, camera.pixelSize))
        }

        run {
            val camera = Camera(125, 200, HALF_PI)
            assertTrue(equalsFloat(0.01f, camera.pixelSize))
        }

        run {
            val camera = Camera(201, 101, HALF_PI)
            val ray = camera.rayForPixel(100, 50)
            assertEquals(POINT_ZERO, ray.origin)
            assertEquals(MINUS_VECTOR_UNIT_Z, ray.direction)
        }

        run {
            val camera = Camera(201, 101, HALF_PI)
            val ray = camera.rayForPixel(0, 0)
            assertEquals(POINT_ZERO, ray.origin)
            assertEquals(makeVector(0.66519f, 0.33259f, -0.66851f), ray.direction)
        }

        run {
            val camera = Camera(201, 101, HALF_PI,
                rotationY(QUARTER_PI).multipliedBy(makeTranslation(0.0f, -2.0f, 5.0f)))

            val ray = camera.rayForPixel(100, 50)
            assertEquals(makePoint(0.0f, 2.0f, -5.0f), ray.origin)
            assertEquals(makeVector(HALF_ROOT_OF_TWO, 0.0f, - HALF_ROOT_OF_TWO), ray.direction)
        }

        run {
            val world = DEFAULT_WORLD
            val from = makePointZ(-5.0f)
            val to = POINT_ZERO
            val up = VECTOR_UNIT_Y
            val camera = Camera(11, 11, HALF_PI, viewTransform(from, to, up))
            val image = camera.render(world, false)
            assertEquals(makeColor(0.38066f, 0.47583f, 0.2855f), image.pixelAt(5, 5))
        }
    }

    @Test
    fun testShadow() {
        run {
            val eyeVector = MINUS_VECTOR_UNIT_Z
            val normalVector = MINUS_VECTOR_UNIT_Z
            val light = PointLight(makePointZ(-10.0f), WHITE_COLOR)
            val inShadow = true
            val result = DEFAULT_MATERIAL.lighting(DEFAULT_SPHERE1, light, POINT_ZERO, eyeVector, normalVector, inShadow)
            assertEquals(makeColor(0.1f, 0.1f, 0.1f), result)
        }

        run {
            val world = DEFAULT_WORLD
            val point = makePointY(10.0f)
            assertFalse(isShadowed(world, point))
        }

        run {
            val world = DEFAULT_WORLD
            val point = makePoint(10.0f, -10.0f, 10.0f)
            assertTrue(isShadowed(world, point))
        }

        run {
            val world = DEFAULT_WORLD
            val point = makePoint(-2.0f, 2.0f, -2.0f)
            assertFalse(isShadowed(world, point))
        }
    }

    @Test
    fun testShapes() {
        run {
            val ray = Ray(makePointZ(-5.0f), VECTOR_UNIT_Z)
            val shape = Sphere(DEFAULT_MATERIAL, makeScaling(2.0f, 2.0f, 2.0f))
            assertEquals(makePointZ(-2.5f),shape.getLocalRay(ray).origin)
            assertEquals(makeVectorZ(0.5f), shape.getLocalRay(ray).direction)
        }
        run {
            val ray = Ray(makePointZ(-5.0f), VECTOR_UNIT_Z)
            val shape = Sphere(DEFAULT_MATERIAL, makeTranslation(5.0f, 0.0f, 0.0f))
            assertEquals(makePoint(-5.0f, 0.0f, -5.0f),shape.getLocalRay(ray).origin)
            assertEquals(VECTOR_UNIT_Z, shape.getLocalRay(ray).direction)
        }

        run {
            val shape = Sphere(DEFAULT_MATERIAL, makeTranslation(0.0f, 1.0f, 0.0f))
            val normal = shape.normalAt(makePoint(0.0f, 1.70711f, -0.70711f))
            assertEquals(makeVector(0.0f, 0.70711f, -0.70711f), normal)
        }

        run {
            val shape = Sphere(
                DEFAULT_MATERIAL,
                makeScaling(1.0f, 0.5f, 1.0f).multipliedBy(rotationZ(PI/5.0f))
            )

            val normal = shape.normalAt(makePoint(0.0f, HALF_ROOT_OF_TWO, - HALF_ROOT_OF_TWO))
            assertEquals(makeVector(0.0f, 0.97014f, -0.24254f), normal)
        }

        run {
            val plane = Plane()
            assertEquals(VECTOR_UNIT_Y, plane.localNormalAt(POINT_ZERO))
            assertEquals(VECTOR_UNIT_Y, plane.localNormalAt(makePoint(10.0f, 0.0f, -10.0f)))
            assertEquals(VECTOR_UNIT_Y, plane.localNormalAt(makePoint(-5.0f, 0.0f, 150.0f)))
        }

        run {
            val plane = Plane()
            val ray = Ray(makePointY(10.0f), VECTOR_UNIT_Z)
            val crosses = plane.localIntersect(ray)
            assertTrue(crosses.isEmpty())
        }

        run {
            val plane = Plane()
            val ray = Ray(POINT_ZERO, VECTOR_UNIT_Z)
            val crosses = plane.localIntersect(ray)
            assertTrue(crosses.isEmpty())
        }

        run {
            val plane = Plane()
            val ray = Ray(POINT_UNIT_Y, - VECTOR_UNIT_Y)
            val crosses = plane.localIntersect(ray)
            assertEquals(1, crosses.size)
            assertEquals(1.0f, crosses[0].tVal)
            assertEquals(plane, crosses[0].obj)
        }

        run {
            val plane = Plane()
            val ray = Ray(makePointY(-1.0f), VECTOR_UNIT_Y)
            val crosses = plane.localIntersect(ray)
            assertEquals(1, crosses.size)
            assertEquals(1.0f, crosses[0].tVal)
            assertEquals(plane, crosses[0].obj)
        }
    }

    @Test
    fun testPattern() {
        run {
            val pattern = StripePattern(WHITE_COLOR, BLACK_COLOR)
            assertEquals(WHITE_COLOR, pattern.patternAt(POINT_ZERO))
            assertEquals(WHITE_COLOR, pattern.patternAt(POINT_UNIT_Y))
            assertEquals(WHITE_COLOR, pattern.patternAt(makePointY(2.0f)))
        }

        run {
            val pattern = StripePattern(WHITE_COLOR, BLACK_COLOR)
            assertEquals(WHITE_COLOR, pattern.patternAt(POINT_ZERO))
            assertEquals(WHITE_COLOR, pattern.patternAt(POINT_UNIT_Z))
            assertEquals(WHITE_COLOR, pattern.patternAt(makePointZ(2.0f)))
        }

        run {
            val pattern = StripePattern(WHITE_COLOR, BLACK_COLOR)
            assertEquals(WHITE_COLOR, pattern.patternAt(POINT_ZERO))
            assertEquals(WHITE_COLOR, pattern.patternAt(makePointX(0.9f)))

            assertEquals(BLACK_COLOR, pattern.patternAt(VECTOR_UNIT_X))
            assertEquals(BLACK_COLOR, pattern.patternAt(makePointX(-0.1f)))

            assertEquals(BLACK_COLOR, pattern.patternAt(makePointX(-1.0f)))
            assertEquals(WHITE_COLOR, pattern.patternAt(makePointX(-1.1f)))
        }

        run {
            val patternMat = Material(StripePattern(WHITE_COLOR, BLACK_COLOR), 1.0f, 0.0f, 0.0f, 200.0f)
            val eyeVector = - VECTOR_UNIT_Z
            val normalVector = - VECTOR_UNIT_Z
            val light = PointLight(makePointZ(-10.0f), WHITE_COLOR)
            val c1 = patternMat.lighting(DEFAULT_SPHERE1, light, makePointX(0.9f), eyeVector, normalVector, false)
            val c2 = patternMat.lighting(DEFAULT_SPHERE1, light, makePointX(1.1f), eyeVector, normalVector, false)
            assertEquals(WHITE_COLOR, c1)
            assertEquals(BLACK_COLOR, c2)
        }

        run {
            val sphere = Sphere(DEFAULT_MATERIAL, makeScaling(2.0f, 2.0f, 2.0f))
            val pattern = StripePattern(WHITE_COLOR, BLACK_COLOR)
            val c = pattern.patternAtObject(sphere, makePointX(1.5f))
            assertEquals(WHITE_COLOR, c)
        }

        run {
            val sphere = Sphere(DEFAULT_MATERIAL)
            val pattern = StripePattern(WHITE_COLOR, BLACK_COLOR, makeScaling(2.0f, 2.0f, 2.0f))
            val c = pattern.patternAtObject(sphere, makePointX(1.5f))
            assertEquals(WHITE_COLOR, c)
        }

        run {
            val sphere = Sphere(DEFAULT_MATERIAL, makeScaling(2.0f, 2.0f, 2.0f))
            val pattern = StripePattern(WHITE_COLOR, BLACK_COLOR, makeTranslation(0.5f, 0.0f, 0.0f))
            val c = pattern.patternAtObject(sphere, makePointX(2.5f))
            assertEquals(WHITE_COLOR, c)
        }

        run {
            val shape = Sphere(makeScaling(2.0f, 2.0f, 2.0f))
            val pattern = TEST_PATTERN
            val c = pattern.patternAtObject(shape, makePoint(2.0f, 3.0f, 4.0f))
            assertEquals(makeColor(1.0f, 1.5f, 2.0f), c)
        }

        run {
            val shape = Sphere(makeScaling(2.0f, 2.0f, 2.0f))
            val pattern = TestPattern(makeTranslation(0.5f, 1.0f, 1.5f))
            val c = pattern.patternAtObject(shape, makePoint(2.5f, 3.0f, 3.5f))
            assertEquals(makeColor(0.75f, 0.5f, 0.25f), c)
        }

        run {
            val pattern = GradientPattern(WHITE_COLOR, BLACK_COLOR)
            assertEquals(WHITE_COLOR, pattern.patternAt(POINT_ZERO))
            assertEquals(makeColor(0.75f, 0.75f, 0.75f), pattern.patternAt(makePointX(0.25f)))
            assertEquals(makeColor(0.5f, 0.5f, 0.5f), pattern.patternAt(makePointX(0.5f)))
            assertEquals(makeColor(0.25f, 0.25f, 0.25f), pattern.patternAt(makePointX(0.75f)))
        }

        run {
            val pattern = RingPattern(WHITE_COLOR, BLACK_COLOR)
            assertEquals(WHITE_COLOR, pattern.patternAt(POINT_ZERO))
            assertEquals(BLACK_COLOR, pattern.patternAt(POINT_UNIT_X))
            assertEquals(BLACK_COLOR, pattern.patternAt(POINT_UNIT_Z))
            assertEquals(BLACK_COLOR, pattern.patternAt(makePoint(0.708f, 00f, 0.708f)))
        }
    }

    @Test
    fun testCheckersPattern() {
        val pattern = CheckersPattern(WHITE_COLOR, BLACK_COLOR)
        run {
            assertEquals(WHITE_COLOR, pattern.patternAt(POINT_ZERO))
            assertEquals(WHITE_COLOR, pattern.patternAt(makePointX(0.99f)))
            assertEquals(BLACK_COLOR, pattern.patternAt(makePointX(1.01f)))
        }

        run {
            assertEquals(WHITE_COLOR, pattern.patternAt(POINT_ZERO))
            assertEquals(WHITE_COLOR, pattern.patternAt(makePointY(0.99f)))
            assertEquals(BLACK_COLOR, pattern.patternAt(makePointY(1.01f)))
        }

        run {
            assertEquals(WHITE_COLOR, pattern.patternAt(POINT_ZERO))
            assertEquals(WHITE_COLOR, pattern.patternAt(makePointZ(0.99f)))
            assertEquals(BLACK_COLOR, pattern.patternAt(makePointZ(1.01f)))
        }
    }

    @Test
    fun testReflection() {
        run {
            val shape = Plane()
            val ray = Ray(makePoint(0.0f, 1.0f, -1.0f), makeVector(0.0f, -HALF_ROOT_OF_TWO, HALF_ROOT_OF_TWO))
            val int = Intersection(ROOT_OF_TWO, shape)
            val comps = Computations(int, ray)
            assertEquals(makeVector(0.0f, HALF_ROOT_OF_TWO, HALF_ROOT_OF_TWO), comps.reflectVector)
        }

        run {
            val secondSphere = Sphere(Material(WHITE_COLOR, 1.0f, 0.9f), DEFAULT_SPHERE2.transform)
            val world = World(DEFAULT_LIGHT, arrayOf(DEFAULT_SPHERE1, secondSphere))
            val ray = Ray(POINT_ZERO, VECTOR_UNIT_Z)
            val shape = world.shapes[1]
            val int = Intersection(1.0f, shape)
            val comps = Computations(int, ray)
            val color = world.reflectedColor(comps)
            assertEquals(BLACK_COLOR, color)
        }

        run {
            val shapeMaterial = Material(
                WHITE_SOLID_PATTERN,
                Material.DEFAULT_AMBIENT,
                Material.DEFAULT_DIFFUSE,
                Material.DEFAULT_SPECULAR,
                Material.DEFAULT_SHININESS,
                0.5f
            )

            val shape = Plane(shapeMaterial, makeTranslation(0.0f, -1.0f, 0.0f))
            val world = World(DEFAULT_LIGHT, arrayOf(DEFAULT_SPHERE1, DEFAULT_SPHERE2, shape))
            val ray = Ray(makePointZ(-3.0f), makeVector(0.0f, - HALF_ROOT_OF_TWO, HALF_ROOT_OF_TWO))
            val int = Intersection(ROOT_OF_TWO, shape)
            val comps = Computations(int, ray)
            val color = world.reflectedColor(comps)
            //Currently breaking
            assertEquals(makeColor(0.19032f, 0.2379f, 0.14274f), color)
        }

        run {
            val shapeMaterial = Material(
                WHITE_SOLID_PATTERN,
                Material.DEFAULT_AMBIENT,
                Material.DEFAULT_DIFFUSE,
                Material.DEFAULT_SPECULAR,
                Material.DEFAULT_SHININESS,
                0.5f
            )

            val shape = Plane(shapeMaterial, makeTranslation(0.0f, -1.0f, 0.0f))
            val world = World(DEFAULT_LIGHT, arrayOf(DEFAULT_SPHERE1, DEFAULT_SPHERE2, shape))
            val ray = Ray(makePointZ(-3.0f), makeVector(0.0f, - HALF_ROOT_OF_TWO, HALF_ROOT_OF_TWO))
            val int = Intersection(ROOT_OF_TWO, shape)
            val comps = Computations(int, ray)
            val color = world.shadeHit(comps)
            assertEquals(makeColor(0.87677f, 0.924346f, 0.82918f), color)
        }
    }
}
