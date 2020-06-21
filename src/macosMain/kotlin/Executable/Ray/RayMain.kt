package Executable.Ray

import raytracerchallenge.canvasimpl.Canvas
import raytracerchallenge.raysimpl.*
import raytracerchallenge.constants.*
import raytracerchallenge.tupleimpl.makePoint
import raytracerchallenge.tupleimpl.normalized

fun main() {

    val rayOrigin = makePoint(0.0f, 0.0f, -5.0f)
    val wallZ = 10.0f
    val wallSize =7.0f
    val canvasPixels = 100
    val pixelSize = wallSize / canvasPixels
    val half = wallSize / 2.0f

    val canvas = Canvas(canvasPixels, canvasPixels)
    val color = RED_COLOR
    val shape = Sphere()

    for (y in 0 until canvasPixels) {
        val worldY = half - pixelSize * y

        for (x in 0 until canvasPixels) {
            val worldX = -half + pixelSize * x
            val position = makePoint(worldX, worldY, wallZ)
            val ray = Ray(rayOrigin, normalized(position-rayOrigin))
            val crosses = shape.intersect(ray)
            if (hit(crosses) != NO_INTERSECTION) {
                canvas.writePixel(x, y, color)
            }
        }
    }
    canvas.toFile("SphereShadow.ppm")
}