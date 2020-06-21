package Executable.Clock

import raytracerchallenge.canvasimpl.Canvas
import raytracerchallenge.matriximpl.rotationZ
import raytracerchallenge.constants.*
import raytracerchallenge.tupleimpl.Tuple
import raytracerchallenge.tupleimpl.makePoint

fun main () {
    val canvas = Canvas(401, 401)

    val twelve = makePoint(0.0f, 100.0f, 0.0f)

    var points = arrayOf<Tuple>(
        POINT_ZERO,
        POINT_ZERO,
        POINT_ZERO,
        POINT_ZERO,
        POINT_ZERO,
        POINT_ZERO,
        POINT_ZERO,
        POINT_ZERO,
        POINT_ZERO,
        POINT_ZERO,
        POINT_ZERO,
        POINT_ZERO
    )

    for (i in 0..11) {
        val rotateMatrix = rotationZ(i.toFloat() * PI/6.0f)
        points[i] = rotateMatrix.multipliedBy(twelve)

        val widthCoord = getWidthCoord(points[i], 200)
        val heightCoord = getHeightCoord(points[i], 200)
        canvas.writePixel(widthCoord, heightCoord, BLUE_COLOR)
    }

    canvas.toFile("myClock.ppm")
}

fun getWidthCoord(tuple: Tuple, centerWidth: Int): Int {
    return centerWidth + (tuple.x + 0.5f).toInt()
}

fun getHeightCoord(tuple: Tuple, centerHeight: Int): Int {
    return centerHeight - (tuple.y + 0.5f).toInt()
}