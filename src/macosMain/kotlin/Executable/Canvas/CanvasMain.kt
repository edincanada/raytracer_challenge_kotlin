package Executable.Canvas

import raytracerchallenge.canvasimpl.Canvas
import raytracerchallenge.tupleimpl.makeColor

fun main() {
    val canvas = Canvas(50, 30)
    for (i in 0..49) {
        for (j in 0..29) {
            canvas.writePixel(i, j, makeColor(i/50.0f, 0.0f, j/30.0f))
        }
    }
    canvas.writePixel(0, 0, makeColor(1.5f, 0.0f, 0.0f))
    canvas.writePixel(2, 1, makeColor(0.0f, 0.5f, 0.0f))
    canvas.writePixel(4, 2, makeColor(-0.5f, 0.0f, 1.0f))
    canvas.toFile("myFile.ppm")
}
