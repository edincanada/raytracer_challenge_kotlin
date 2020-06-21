package Executable.Plane

import raytracerchallenge.cameraimpl.Camera
import raytracerchallenge.cameraimpl.viewTransform
import raytracerchallenge.constants.*
import raytracerchallenge.matriximpl.*
import raytracerchallenge.patternimpl.*
import raytracerchallenge.raysimpl.Plane
import raytracerchallenge.raysimpl.Shape
import raytracerchallenge.raysimpl.Sphere
import raytracerchallenge.shadingimpl.Material
import raytracerchallenge.shadingimpl.PointLight
import raytracerchallenge.tupleimpl.makeColor
import raytracerchallenge.tupleimpl.makePoint
import raytracerchallenge.worldimpl.World

fun main (args: Array<String>) {

    val floor = Plane(Material(CheckersPattern(BLACK_COLOR, WHITE_COLOR), 0.1f, 0.7f, 0.3f, 30.0f, 0.1f))

    val wallMaterial =
        Material(CheckersPattern(WHITE_COLOR, BLACK_COLOR, makeScaling(3.0f, 3.0f, 3.0f)), 0.1f, 0.7f, 0.3f, 200.0f)

    val backdrop1 = Plane(
        wallMaterial,
        rotationY(QUARTER_PI).multipliedBy(makeTranslation(0.0f, 0.0f, 9.0f)).multipliedBy(rotationX(HALF_PI))
    )

    val backdrop2 = Plane(
        wallMaterial,
        rotationY(-QUARTER_PI).multipliedBy(makeTranslation(0.0f, 0.0f, 9.0f)).multipliedBy(rotationX(HALF_PI))
    )

    val backdrop3 = Plane(
        wallMaterial,
        rotationY(QUARTER_PI).multipliedBy(makeTranslation(0.0f, 0.0f, -15.0f)).multipliedBy(rotationX(HALF_PI))
    )

    val backdrop4 = Plane(
        wallMaterial,
        rotationY(-QUARTER_PI).multipliedBy(makeTranslation(0.0f, 0.0f, -15.0f)).multipliedBy(rotationX(HALF_PI))
    )

    val middle = Sphere(
        Material(SingleColorPattern(BLUE_COLOR), 0.1f, 0.5f, 0.6f, 200.0f, 0.85f),
        makeTranslation(-0.5f, 1.0f, 3.5f).multipliedBy(rotationZ(-QUARTER_PI))
    )

    val right = Sphere(
        Material(CheckersPattern(BLACK_COLOR, RED_COLOR, makeScaling(0.25f, 0.25f, 0.25f)), 0.1f, 0.7f, 0.3f, 200.0f),
        makeTranslation(1.5f, 0.5f, 1.1f).multipliedBy(makeScaling(0.5f, 0.5f, 0.5f))
    )

    val left = Sphere(
        Material(makeColor(0.5f, 1.0f, 0.1f), 0.1f, 0.7f, 0.7f, 120.0f),
        makeTranslation(-1.5f, 0.33f, 1.75f).multipliedBy(makeScaling(0.33f, 0.33f, 0.33f))
    )

    val shapes = ArrayList<Shape>()

    if (args.contains("floor"))
        shapes.add(floor)

    if (args.contains("backdrop")) {
        shapes.add(backdrop1)
        shapes.add(backdrop2)
        shapes.add(backdrop3)
        shapes.add(backdrop4)
    }

    if (args.contains("left"))
        shapes.add(left)

    if (args.contains("middle"))
        shapes.add(middle)

    if (args.contains("right"))
        shapes.add(right)

    val world = World(
        PointLight(makePoint(-10.0f, 10.0f, -10.0f), makeColor(1.0f, 1.0f, 1.0f)),
        shapes.toTypedArray()
    )

    val camera = Camera(
        //times three is for super sampling
        1000, 500, THIRD_OF_PI,
         viewTransform(makePoint(0.0f, 1.5f, -5.0f), POINT_UNIT_Y, VECTOR_UNIT_Y)
    )

    val canvas = camera.render(world, args.contains("shadows"))

    //aaCanvas brings the size back to the targeted sampling.
    canvas.toFile("MyScene.ppm")
}