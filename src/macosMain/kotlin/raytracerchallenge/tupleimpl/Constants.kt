package raytracerchallenge.constants

import raytracerchallenge.matriximpl.makeScaling
import raytracerchallenge.patternimpl.SingleColorPattern
import raytracerchallenge.patternimpl.TestPattern
import raytracerchallenge.raysimpl.Intersection
import raytracerchallenge.raysimpl.Shape
import raytracerchallenge.raysimpl.Sphere
import raytracerchallenge.shadingimpl.Material
import raytracerchallenge.shadingimpl.PointLight
import raytracerchallenge.tupleimpl.*
import raytracerchallenge.worldimpl.World
import kotlin.math.sqrt

const val PI      = 3.14159f
const val TWO_PI  = 2.0F * PI
const val PI_SQUARED = PI * PI
const val TAU = TWO_PI
const val HALF_PI = PI/2.0f
const val THIRD_OF_PI = PI/3.0f
const val QUARTER_PI = PI/4.0f
const val HALF_TAU = TAU/2.0f
const val QUARTER_TAU = TAU/4.0f
val ROOT_OF_TWO = sqrt(2.0f)
val ROOT_OF_THREE = sqrt(3.0f)
val HALF_ROOT_OF_TWO = ROOT_OF_TWO/2.0f

val POINT_ZERO = makePoint(0.0f, 0.0f, 0.0f)
val VECTOR_ZERO = makeVector(0.0f, 0.0f, 0.0f)
val BLACK_COLOR = makeColor(0.0f, 0.0f, 0.0f)
val RED_COLOR = makeColor(1.0f, 0.0f, 0.0f)
val BLUE_COLOR = makeColor(0.0f, 0.0f, 1.0f)
val GREEN_COLOR = makeColor(0.0f, 1.0f, 0.0f)
val WHITE_COLOR = makeColor(1.0f, 1.0f, 1.0f)

val VECTOR_UNIT_X = makeVectorX(1.0f)
val VECTOR_UNIT_Y = makeVectorY(1.0f)
val VECTOR_UNIT_Z = makeVectorZ(1.0f)
val MINUS_VECTOR_UNIT_Z = - VECTOR_UNIT_Z

val POINT_UNIT_X = makePointX(1.0f)
val POINT_UNIT_Y = makePointY(1.0f)
val POINT_UNIT_Z = makePointZ(1.0f)

val IDENTITY_MATRIX = makeScaling(1.0f, 1.0f, 1.0f)

internal val NO_SPHERE = Sphere()
val NO_INTERSECTION = Intersection(-1.0f, NO_SPHERE)

val DEFAULT_MATERIAL = Material(WHITE_COLOR, 0.1f, 0.9f, 0.9f, 200.0f)

val DEFAULT_SPHERE1 = Sphere(Material(
    makeColor(0.8f, 1.0f, 0.6f), 0.1f, 0.7f, 0.2f, 200.0f))
val DEFAULT_SPHERE2 = Sphere(DEFAULT_MATERIAL, makeScaling(0.5f, 0.5f, 0.5f))
val DEFAULT_SPHERES : Array<Shape> = arrayOf(DEFAULT_SPHERE1, DEFAULT_SPHERE2)
val DEFAULT_LIGHT = PointLight(makePoint(-10.0f, 10.0f, -10.0f), WHITE_COLOR)

val DEFAULT_WORLD = World(DEFAULT_LIGHT, DEFAULT_SPHERES)
const val ANTI_SELF_SHADOW_BOOST = 0.0025f

val TEST_PATTERN = TestPattern()
val WHITE_SOLID_PATTERN = SingleColorPattern(WHITE_COLOR)
