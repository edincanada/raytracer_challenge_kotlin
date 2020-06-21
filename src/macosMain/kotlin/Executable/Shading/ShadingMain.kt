package Executable.Shading

import raytracerchallenge.canvasimpl.Canvas
import raytracerchallenge.raysimpl.*
import raytracerchallenge.constants.*
import raytracerchallenge.shadingimpl.Material
import raytracerchallenge.shadingimpl.PointLight
import raytracerchallenge.tupleimpl.makeColor
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
    val material = Material(makeColor(1.0f, 0.2f, 1.0f))
    val shape = Sphere(material)

    val light = PointLight(makePoint(-10.0f, -10.0f, -10.0f), WHITE_COLOR)

    for (y in 0 until canvasPixels) {
        val worldY = half - pixelSize * y

        for (x in 0 until canvasPixels) {
            val worldX = -half + pixelSize * x
            val position = makePoint(worldX, worldY, wallZ)
            val ray = Ray(rayOrigin, normalized(position-rayOrigin))
            val crosses = shape.intersect(ray)
            val intersection = hit(crosses)

            if (intersection != NO_INTERSECTION) {
                val point = ray.position(intersection.tVal)
                val normal = intersection.obj.normalAt(point)
                val eye = - ray.direction
                val color = intersection.obj.material.lighting(intersection.obj, light, point, eye, normal, false)
                canvas.writePixel(x, canvasPixels- y, color)
            }
        }
    }
    canvas.toFile("SphereImage.ppm")
}