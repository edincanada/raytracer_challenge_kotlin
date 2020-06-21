package Executable.Camera

import raytracerchallenge.cameraimpl.Camera
import raytracerchallenge.cameraimpl.viewTransform
import raytracerchallenge.constants.*
import raytracerchallenge.matriximpl.makeScaling
import raytracerchallenge.matriximpl.makeTranslation
import raytracerchallenge.matriximpl.rotationX
import raytracerchallenge.matriximpl.rotationY
import raytracerchallenge.raysimpl.Sphere
import raytracerchallenge.shadingimpl.Material
import raytracerchallenge.shadingimpl.PointLight
import raytracerchallenge.tupleimpl.makeColor
import raytracerchallenge.tupleimpl.makePoint
import raytracerchallenge.worldimpl.World

fun main () {
    val floor = Sphere(
        Material(makeColor(1.0f, 0.9f, 0.9f), Material.DEFAULT_AMBIENT, Material.DEFAULT_DIFFUSE),
        makeScaling(10.0f, 0.01f, 10.0f))

    val leftWall = Sphere(
    floor.material,
    makeTranslation(0.0f, 0.0f, 5.0f)
        .multipliedBy(rotationY(-QUARTER_PI))
        .multipliedBy(rotationX(HALF_PI))
        .multipliedBy(makeScaling(10.0f, 0.01f, 10.0f)))

    val rightWall = Sphere(
        floor.material,
        makeTranslation(0.0f, 0.0f, 5.0f)
            .multipliedBy(rotationY(QUARTER_PI))
            .multipliedBy(rotationX(HALF_PI))
            .multipliedBy(makeScaling(10.0f, 0.01f, 10.0f)))

    val middle = Sphere(
        Material(makeColor(0.1f, 1.0f, 0.5f), 0.1f, 0.7f, 0.3f, 200.0f),
        makeTranslation(-0.5f, 1.0f, 0.5f))

    val right = Sphere(
        Material(makeColor(0.5f, 1.0f, 0.1f), 0.1f, 0.7f, 0.3f, 200.0f),
        makeTranslation(1.5f, 0.5f, -0.5f).multipliedBy(makeScaling(0.5f, 0.5f, 0.5f)))

    val left = Sphere(
        Material(makeColor(1.0f, 0.8f, 1.0f), 0.1f, 0.7f, 0.3f, 200.0f),
        makeTranslation(-1.5f, 0.33f, -0.75f).multipliedBy(makeScaling(0.33f, 0.33f, 0.33f)))

    val world = World(PointLight(makePoint(-10.0f, 10.0f, -10.0f), makeColor(1.0f, 1.0f, 1.0f)),
        arrayOf(floor, rightWall, leftWall, right, middle, left))

    val camera = Camera(
        1000,
        500,
        THIRD_OF_PI,
        viewTransform(makePoint(0.0f, 1.5f, -5.0f), POINT_UNIT_Y, VECTOR_UNIT_Y)
    )

    val canvas = camera.render(world)
    canvas.toFile("MyScene.ppm")
}