package raytracerchallenge.cameraimpl

import raytracerchallenge.canvasimpl.Canvas
import raytracerchallenge.constants.IDENTITY_MATRIX
import raytracerchallenge.constants.POINT_ZERO
import raytracerchallenge.matriximpl.Matrix
import raytracerchallenge.matriximpl.makeTranslation
import raytracerchallenge.raysimpl.Ray
import raytracerchallenge.tupleimpl.*
import raytracerchallenge.worldimpl.World
import kotlin.math.tan

data class Camera (val hSize: Int, val vSize: Int, val fieldOfView: Float, val transform: Matrix) {

    private val halfView = tan(fieldOfView/2.0f)
    private val aspectRatio = hSize.toFloat()/vSize
    private val halfCanvasHeight = if (aspectRatio < 1.0f) halfView else halfView/aspectRatio
    private val halfCanvasWidth =  if (aspectRatio < 1.0f) halfView * aspectRatio else halfView

    val pixelSize = if (aspectRatio < 1.0f) (2.0f * halfView)/vSize else (2.0f * halfView)/hSize

    constructor(hSize: Int, vSize: Int, fieldOfView: Float): this(hSize, vSize, fieldOfView, IDENTITY_MATRIX)

    fun rayForPixel (x: Int, y: Int): Ray {
        val xOffset = (x + 0.5f) * pixelSize
        val yOffset = (y + 0.5f) * pixelSize

        val worldX = halfCanvasWidth - xOffset
        val worldY = halfCanvasHeight - yOffset

        val pixel = transform.inverse().multipliedBy(makePoint(worldX, worldY, -1.0f))
        val origin = transform.inverse().multipliedBy(POINT_ZERO)
        val direction = normalized(pixel - origin)
        return Ray(origin, direction)
    }

    fun render(world: World, useShadows: Boolean): Canvas {
        val image = Canvas(hSize, vSize)
        for (y in 0 until vSize) {
            for (x in 0 until hSize) {
                val ray = rayForPixel(x, y)
                val color = world.colorAt(ray, useShadows, 5)
                image.writePixel(x, y, color)
            }
        }
        return image
    }

    fun render(world: World): Canvas = render(world, true)
}

fun viewTransform(from: Tuple, to: Tuple, up: Tuple) : Matrix {
    val forward= normalized(to-from)
    val left = cross(forward, normalized(up))
    val trueUp = cross(left, forward)

    val orientation = Matrix(left.x, left.y, left.z, 0.0f,
        trueUp.x, trueUp.y, trueUp.z, 0.0f,
        -forward.x, -forward.y, -forward.z, 0.0f,
        0.0f, 0.0f, 0.0f, 1.0f)

    return orientation.multipliedBy(makeTranslation(-from.x, -from.y, -from.z))
}