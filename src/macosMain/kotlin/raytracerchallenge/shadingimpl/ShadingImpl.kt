package raytracerchallenge.shadingimpl

import raytracerchallenge.constants.*
import raytracerchallenge.patternimpl.Pattern
import raytracerchallenge.patternimpl.SingleColorPattern
import raytracerchallenge.raysimpl.Shape
import raytracerchallenge.tupleimpl.*
import kotlin.math.pow


fun reflect(vector: Tuple, normal: Tuple) : Tuple {
    return vector - (normal * (dot(vector, normal) * 2.0f))
}

data class PointLight(val position: Tuple, val intensity: Tuple)

data class Material(
    private val pattern: Pattern,
    private val ambient: Float,
    private val diffuse: Float,
    private val specular: Float,
    private val shininess: Float,
    val reflective: Float) {

    companion object {
        const val DEFAULT_AMBIENT = 0.1f
        const val DEFAULT_DIFFUSE = 0.9f
        const val DEFAULT_SPECULAR = 0.9f
        const val DEFAULT_SHININESS = 200.0f
        const val DEFAULT_REFLECTIVE = 0.0f
    }

    constructor(pattern: Pattern, ambient: Float, diffuse: Float, specular: Float, shininess: Float):
            this(pattern, ambient, diffuse, specular, shininess, DEFAULT_REFLECTIVE)

    constructor(pattern: Pattern, ambient: Float, diffuse: Float, specular: Float):
            this(pattern, ambient, diffuse, specular, DEFAULT_SHININESS, DEFAULT_REFLECTIVE)

    constructor(pattern: Pattern, ambient: Float, diffuse: Float):
            this(pattern, ambient, diffuse, DEFAULT_SPECULAR, DEFAULT_SHININESS, DEFAULT_REFLECTIVE)

    constructor(pattern: Pattern):
            this(pattern, DEFAULT_AMBIENT, DEFAULT_DIFFUSE, DEFAULT_SPECULAR, DEFAULT_SHININESS, DEFAULT_REFLECTIVE)

    constructor(color: Tuple, ambient: Float, diffuse: Float, specular: Float, shininess: Float, reflective: Float):
            this(SingleColorPattern(color), ambient, diffuse, specular, shininess, reflective)

    constructor(color: Tuple, ambient: Float, diffuse: Float, specular: Float, shininess: Float):
            this(color, ambient, diffuse, specular, shininess, DEFAULT_REFLECTIVE)

    constructor(color: Tuple, ambient: Float, diffuse: Float, specular: Float):
            this(color, ambient, diffuse, specular, DEFAULT_SHININESS, DEFAULT_REFLECTIVE)

    constructor(color: Tuple, ambient: Float, diffuse: Float):
            this(color, ambient, diffuse, DEFAULT_SPECULAR, DEFAULT_SHININESS, DEFAULT_REFLECTIVE)

    constructor(color: Tuple):
            this(SingleColorPattern(color), DEFAULT_AMBIENT, DEFAULT_DIFFUSE, DEFAULT_SPECULAR, DEFAULT_SHININESS, DEFAULT_REFLECTIVE)

    constructor():
            this(WHITE_SOLID_PATTERN, DEFAULT_AMBIENT, DEFAULT_DIFFUSE, DEFAULT_SPECULAR, DEFAULT_SHININESS, DEFAULT_REFLECTIVE)

    fun colorAt(obj: Shape, point: Tuple): Tuple = pattern.patternAtObject(obj, point)

    fun lighting(obj: Shape, light: PointLight, position: Tuple, eyeVector: Tuple, normal: Tuple, inShadow: Boolean): Tuple {
        val color = colorAt(obj, position)
        val effectiveColor = blend(color, light.intensity)
        val ambient = effectiveColor * ambient
        val lightVector = normalized(light.position - position)
        val lightDotNormal = dot(lightVector, normal)

        return if (!inShadow && lightDotNormal > 0.0f) {
            val diffuse = effectiveColor * diffuse * lightDotNormal
            val reflectVector = reflect(- lightVector, normal)
            val reflectDotEye = dot(reflectVector, eyeVector)

            val specular = if (reflectDotEye > 0.0f) {
                val factor = reflectDotEye.pow(shininess)
                light.intensity * specular * factor
            }
            else {
                BLACK_COLOR
            }
            makeOpaqueColor(ambient + diffuse + specular)
        }
        else {
            makeOpaqueColor(ambient)
        }
    }
}
