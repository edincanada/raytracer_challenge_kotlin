package raytracerchallenge.canvasimpl

import platform.posix.fclose
import platform.posix.fprintf
import raytracerchallenge.constants.*
import raytracerchallenge.tupleimpl.Tuple
import raytracerchallenge.tupleimpl.makeColor

data class Canvas(val width: Int, val height: Int) {
    private val pixels = Array(width * height) { _ -> BLACK_COLOR }

    fun writePixel(widthPos: Int, heightPos: Int, aColor: Tuple) {
        pixels[width * heightPos + widthPos] = aColor
    }

    fun pixelAt(widthPos: Int, heightPos: Int): Tuple = pixels[width * heightPos + widthPos]

    fun toFile(fileStr: String) {
        val fileOutput = platform.posix.fopen(fileStr, "w")
        if (fileOutput != null) {
            fprintf(fileOutput, "P3\n")
            fprintf(fileOutput, "$width $height 255\n")
            var counter = 0
            for (pixel in pixels) {
                counter++
                val separator = if (counter > 5) {
                    counter = 0
                    "\n"
                } else {
                    " "
                }
                fprintf(fileOutput, "${separator}${pixel.redInt()} ${pixel.greenInt()} ${pixel.blueInt()}")
            }
            fprintf(fileOutput, "\n")
            fclose(fileOutput)
        }
    }

    fun toOutput() {
        println("P3")
        print("$width $height 255")
        for (pixel in pixels) {
            print(" ${pixel.redInt()} ${pixel.greenInt()} ${pixel.blueInt()}")
        }
    }

    override fun toString(): String {
        val strBuilder: StringBuilder = StringBuilder(10 * 1024)
        strBuilder.append("P3\n")
        strBuilder.append("$width $height 255")
        for (pixel in pixels) {
            strBuilder.append("\n${pixel.redInt()} ${pixel.greenInt()} ${pixel.blueInt()}")
        }

        return strBuilder.toString()
    }

    private fun aaPixel(i: Int, j: Int): Tuple {
        val iSegment = i * 3
        val jSegment = j * 3

        val pixelAddition =
            pixelAt(iSegment,jSegment) +
            pixelAt(iSegment+1, jSegment) +
            pixelAt(iSegment+2, jSegment) +

            pixelAt(iSegment,jSegment+1) +
            pixelAt(iSegment+1, jSegment+1) +
            pixelAt(iSegment+2, jSegment+1) +

            pixelAt(iSegment,jSegment+2) +
            pixelAt(iSegment+1, jSegment+2) +
            pixelAt(iSegment+2, jSegment+2);

        return makeColor(pixelAddition.red()/9, pixelAddition.green()/9, pixelAddition.blue()/9)
    }

    fun toAACanvas(): Canvas {
        val aaCanvas = Canvas(width/3, height/3)
        for (ii in 0 until width/3) {
            for (jj in 0 until height/3) {
                aaCanvas.writePixel(ii, jj, aaPixel(ii, jj))
            }
        }

        return aaCanvas
    }
}

