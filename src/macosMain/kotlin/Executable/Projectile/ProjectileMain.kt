package Executable.Projectile

import raytracerchallenge.canvasimpl.Canvas
import raytracerchallenge.tupleimpl.Tuple
import raytracerchallenge.tupleimpl.makePoint
import raytracerchallenge.tupleimpl.makeVector
import raytracerchallenge.tupleimpl.normalized
import raytracerchallenge.constants.RED_COLOR

data class Environment(val gravity: Tuple, val wind: Tuple)
data class Projectile(val position: Tuple, val velocity: Tuple)

fun tick(env: Environment, proj: Projectile): Projectile {
    val position = proj.position + proj.velocity
    val velocity = proj.velocity + env.gravity + env.wind
    return Projectile(position, velocity)
}

fun main() {
    var projectile = Projectile(
        makePoint(0.0f, 1.0f, 0.0f),
        normalized(makeVector(1.0f, 1.8f, 0.0f)) * 11.25f
    )
    val env = Environment(
        makeVector(0.0f, -0.1f, 0.0f),
        makeVector(-0.01f, 0.0f, 0.0f)
    )

    val canvas = Canvas(900, 500)
    for (ii in 0..500) {
        projectile = tick(env, projectile)
        if (projectile.position.x.toInt() in 0..899 && projectile.position.y.toInt() in 0..499) {
            canvas.writePixel(projectile.position.x.toInt(), projectile.position.y.toInt(), RED_COLOR)
        }
    }
    canvas.toFile("MyProjectile.ppm")
}

