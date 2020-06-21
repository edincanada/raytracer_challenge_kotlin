#ifndef KONAN_LIBSTATICLIB_H
#define KONAN_LIBSTATICLIB_H
#ifdef __cplusplus
extern "C" {
#endif
#ifdef __cplusplus
typedef bool            libstaticLib_KBoolean;
#else
typedef _Bool           libstaticLib_KBoolean;
#endif
typedef unsigned short     libstaticLib_KChar;
typedef signed char        libstaticLib_KByte;
typedef short              libstaticLib_KShort;
typedef int                libstaticLib_KInt;
typedef long long          libstaticLib_KLong;
typedef unsigned char      libstaticLib_KUByte;
typedef unsigned short     libstaticLib_KUShort;
typedef unsigned int       libstaticLib_KUInt;
typedef unsigned long long libstaticLib_KULong;
typedef float              libstaticLib_KFloat;
typedef double             libstaticLib_KDouble;
typedef float __attribute__ ((__vector_size__ (16))) libstaticLib_KVector128;
typedef void*              libstaticLib_KNativePtr;
struct libstaticLib_KType;
typedef struct libstaticLib_KType libstaticLib_KType;

typedef struct {
  libstaticLib_KNativePtr pinned;
} libstaticLib_kref_kotlin_Byte;
typedef struct {
  libstaticLib_KNativePtr pinned;
} libstaticLib_kref_kotlin_Short;
typedef struct {
  libstaticLib_KNativePtr pinned;
} libstaticLib_kref_kotlin_Int;
typedef struct {
  libstaticLib_KNativePtr pinned;
} libstaticLib_kref_kotlin_Long;
typedef struct {
  libstaticLib_KNativePtr pinned;
} libstaticLib_kref_kotlin_Float;
typedef struct {
  libstaticLib_KNativePtr pinned;
} libstaticLib_kref_kotlin_Double;
typedef struct {
  libstaticLib_KNativePtr pinned;
} libstaticLib_kref_kotlin_Char;
typedef struct {
  libstaticLib_KNativePtr pinned;
} libstaticLib_kref_kotlin_Boolean;
typedef struct {
  libstaticLib_KNativePtr pinned;
} libstaticLib_kref_kotlin_Unit;
typedef struct {
  libstaticLib_KNativePtr pinned;
} libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple;
typedef struct {
  libstaticLib_KNativePtr pinned;
} libstaticLib_kref_Executable_Projectile_Environment;
typedef struct {
  libstaticLib_KNativePtr pinned;
} libstaticLib_kref_Executable_Projectile_Projectile;
typedef struct {
  libstaticLib_KNativePtr pinned;
} libstaticLib_kref_kotlin_Any;
typedef struct {
  libstaticLib_KNativePtr pinned;
} libstaticLib_kref_raytracerchallenge_matriximpl_Matrix;
typedef struct {
  libstaticLib_KNativePtr pinned;
} libstaticLib_kref_raytracerchallenge_cameraimpl_Camera;
typedef struct {
  libstaticLib_KNativePtr pinned;
} libstaticLib_kref_raytracerchallenge_raysimpl_Ray;
typedef struct {
  libstaticLib_KNativePtr pinned;
} libstaticLib_kref_raytracerchallenge_worldimpl_World;
typedef struct {
  libstaticLib_KNativePtr pinned;
} libstaticLib_kref_raytracerchallenge_canvasimpl_Canvas;
typedef struct {
  libstaticLib_KNativePtr pinned;
} libstaticLib_kref_raytracerchallenge_shadingimpl_PointLight;
typedef struct {
  libstaticLib_KNativePtr pinned;
} libstaticLib_kref_raytracerchallenge_shadingimpl_Material;
typedef struct {
  libstaticLib_KNativePtr pinned;
} libstaticLib_kref_raytracerchallenge_raysimpl_Sphere;
typedef struct {
  libstaticLib_KNativePtr pinned;
} libstaticLib_kref_kotlin_Array;
typedef struct {
  libstaticLib_KNativePtr pinned;
} libstaticLib_kref_raytracerchallenge_raysimpl_Intersection;
typedef struct {
  libstaticLib_KNativePtr pinned;
} libstaticLib_kref_raytracerchallenge_raysimpl_Shape;
typedef struct {
  libstaticLib_KNativePtr pinned;
} libstaticLib_kref_raytracerchallenge_raysimpl_Plane;
typedef struct {
  libstaticLib_KNativePtr pinned;
} libstaticLib_kref_raytracerchallenge_worldimpl_Computations;


typedef struct {
  /* Service functions. */
  void (*DisposeStablePointer)(libstaticLib_KNativePtr ptr);
  void (*DisposeString)(const char* string);
  libstaticLib_KBoolean (*IsInstance)(libstaticLib_KNativePtr ref, const libstaticLib_KType* type);
  libstaticLib_kref_kotlin_Byte (*createNullableByte)(libstaticLib_KByte);
  libstaticLib_kref_kotlin_Short (*createNullableShort)(libstaticLib_KShort);
  libstaticLib_kref_kotlin_Int (*createNullableInt)(libstaticLib_KInt);
  libstaticLib_kref_kotlin_Long (*createNullableLong)(libstaticLib_KLong);
  libstaticLib_kref_kotlin_Float (*createNullableFloat)(libstaticLib_KFloat);
  libstaticLib_kref_kotlin_Double (*createNullableDouble)(libstaticLib_KDouble);
  libstaticLib_kref_kotlin_Char (*createNullableChar)(libstaticLib_KChar);
  libstaticLib_kref_kotlin_Boolean (*createNullableBoolean)(libstaticLib_KBoolean);
  libstaticLib_kref_kotlin_Unit (*createNullableUnit)(void);

  /* User functions. */
  struct {
    struct {
      struct {
        struct {
          void (*main)();
        } Camera;
        struct {
          void (*main)();
        } Canvas;
        struct {
          libstaticLib_KInt (*getHeightCoord)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple tuple, libstaticLib_KInt centerHeight);
          libstaticLib_KInt (*getWidthCoord)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple tuple, libstaticLib_KInt centerWidth);
          void (*main)();
        } Clock;
        struct {
          void (*main)();
        } Plane;
        struct {
          void (*main)();
          libstaticLib_kref_Executable_Projectile_Projectile (*tick)(libstaticLib_kref_Executable_Projectile_Environment env, libstaticLib_kref_Executable_Projectile_Projectile proj);
          struct {
            libstaticLib_KType* (*_type)(void);
            libstaticLib_kref_Executable_Projectile_Environment (*Environment)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple gravity, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple wind);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*get_gravity)(libstaticLib_kref_Executable_Projectile_Environment thiz);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*get_wind)(libstaticLib_kref_Executable_Projectile_Environment thiz);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*component1)(libstaticLib_kref_Executable_Projectile_Environment thiz);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*component2)(libstaticLib_kref_Executable_Projectile_Environment thiz);
            libstaticLib_kref_Executable_Projectile_Environment (*copy)(libstaticLib_kref_Executable_Projectile_Environment thiz, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple gravity, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple wind);
            libstaticLib_KBoolean (*equals)(libstaticLib_kref_Executable_Projectile_Environment thiz, libstaticLib_kref_kotlin_Any other);
            libstaticLib_KInt (*hashCode)(libstaticLib_kref_Executable_Projectile_Environment thiz);
            const char* (*toString)(libstaticLib_kref_Executable_Projectile_Environment thiz);
          } Environment;
          struct {
            libstaticLib_KType* (*_type)(void);
            libstaticLib_kref_Executable_Projectile_Projectile (*Projectile)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple position, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple velocity);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*get_position)(libstaticLib_kref_Executable_Projectile_Projectile thiz);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*get_velocity)(libstaticLib_kref_Executable_Projectile_Projectile thiz);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*component1)(libstaticLib_kref_Executable_Projectile_Projectile thiz);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*component2)(libstaticLib_kref_Executable_Projectile_Projectile thiz);
            libstaticLib_kref_Executable_Projectile_Projectile (*copy)(libstaticLib_kref_Executable_Projectile_Projectile thiz, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple position, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple velocity);
            libstaticLib_KBoolean (*equals)(libstaticLib_kref_Executable_Projectile_Projectile thiz, libstaticLib_kref_kotlin_Any other);
            libstaticLib_KInt (*hashCode)(libstaticLib_kref_Executable_Projectile_Projectile thiz);
            const char* (*toString)(libstaticLib_kref_Executable_Projectile_Projectile thiz);
          } Projectile;
        } Projectile;
        struct {
          void (*main)();
        } Ray;
        struct {
          void (*main)();
        } Shading;
      } Executable;
      struct {
        struct {
          libstaticLib_kref_raytracerchallenge_matriximpl_Matrix (*viewTransform)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple from, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple to, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple up);
          struct {
            libstaticLib_KType* (*_type)(void);
            libstaticLib_kref_raytracerchallenge_cameraimpl_Camera (*Camera)(libstaticLib_KInt hSize, libstaticLib_KInt vSize, libstaticLib_KFloat fieldOfView);
            libstaticLib_kref_raytracerchallenge_cameraimpl_Camera (*Camera_)(libstaticLib_KInt hSize, libstaticLib_KInt vSize, libstaticLib_KFloat fieldOfView, libstaticLib_kref_raytracerchallenge_matriximpl_Matrix transform);
            libstaticLib_KFloat (*get_fieldOfView)(libstaticLib_kref_raytracerchallenge_cameraimpl_Camera thiz);
            libstaticLib_KInt (*get_hSize)(libstaticLib_kref_raytracerchallenge_cameraimpl_Camera thiz);
            libstaticLib_KFloat (*get_pixelSize)(libstaticLib_kref_raytracerchallenge_cameraimpl_Camera thiz);
            libstaticLib_kref_raytracerchallenge_matriximpl_Matrix (*get_transform)(libstaticLib_kref_raytracerchallenge_cameraimpl_Camera thiz);
            libstaticLib_KInt (*get_vSize)(libstaticLib_kref_raytracerchallenge_cameraimpl_Camera thiz);
            libstaticLib_KInt (*component1)(libstaticLib_kref_raytracerchallenge_cameraimpl_Camera thiz);
            libstaticLib_KInt (*component2)(libstaticLib_kref_raytracerchallenge_cameraimpl_Camera thiz);
            libstaticLib_KFloat (*component3)(libstaticLib_kref_raytracerchallenge_cameraimpl_Camera thiz);
            libstaticLib_kref_raytracerchallenge_matriximpl_Matrix (*component4)(libstaticLib_kref_raytracerchallenge_cameraimpl_Camera thiz);
            libstaticLib_kref_raytracerchallenge_cameraimpl_Camera (*copy)(libstaticLib_kref_raytracerchallenge_cameraimpl_Camera thiz, libstaticLib_KInt hSize, libstaticLib_KInt vSize, libstaticLib_KFloat fieldOfView, libstaticLib_kref_raytracerchallenge_matriximpl_Matrix transform);
            libstaticLib_KBoolean (*equals)(libstaticLib_kref_raytracerchallenge_cameraimpl_Camera thiz, libstaticLib_kref_kotlin_Any other);
            libstaticLib_KInt (*hashCode)(libstaticLib_kref_raytracerchallenge_cameraimpl_Camera thiz);
            libstaticLib_kref_raytracerchallenge_raysimpl_Ray (*rayForPixel)(libstaticLib_kref_raytracerchallenge_cameraimpl_Camera thiz, libstaticLib_KInt x, libstaticLib_KInt y);
            libstaticLib_kref_raytracerchallenge_canvasimpl_Canvas (*render)(libstaticLib_kref_raytracerchallenge_cameraimpl_Camera thiz, libstaticLib_kref_raytracerchallenge_worldimpl_World world);
            libstaticLib_kref_raytracerchallenge_canvasimpl_Canvas (*render_)(libstaticLib_kref_raytracerchallenge_cameraimpl_Camera thiz, libstaticLib_kref_raytracerchallenge_worldimpl_World world, libstaticLib_KBoolean useShadows);
            const char* (*toString)(libstaticLib_kref_raytracerchallenge_cameraimpl_Camera thiz);
          } Camera;
        } cameraimpl;
        struct {
          struct {
            libstaticLib_KType* (*_type)(void);
            libstaticLib_kref_raytracerchallenge_canvasimpl_Canvas (*Canvas)(libstaticLib_KInt width, libstaticLib_KInt height);
            libstaticLib_KInt (*get_height)(libstaticLib_kref_raytracerchallenge_canvasimpl_Canvas thiz);
            libstaticLib_KInt (*get_width)(libstaticLib_kref_raytracerchallenge_canvasimpl_Canvas thiz);
            libstaticLib_KInt (*component1)(libstaticLib_kref_raytracerchallenge_canvasimpl_Canvas thiz);
            libstaticLib_KInt (*component2)(libstaticLib_kref_raytracerchallenge_canvasimpl_Canvas thiz);
            libstaticLib_kref_raytracerchallenge_canvasimpl_Canvas (*copy)(libstaticLib_kref_raytracerchallenge_canvasimpl_Canvas thiz, libstaticLib_KInt width, libstaticLib_KInt height);
            libstaticLib_KBoolean (*equals)(libstaticLib_kref_raytracerchallenge_canvasimpl_Canvas thiz, libstaticLib_kref_kotlin_Any other);
            libstaticLib_KInt (*hashCode)(libstaticLib_kref_raytracerchallenge_canvasimpl_Canvas thiz);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*pixelAt)(libstaticLib_kref_raytracerchallenge_canvasimpl_Canvas thiz, libstaticLib_KInt widthPos, libstaticLib_KInt heightPos);
            void (*toFile)(libstaticLib_kref_raytracerchallenge_canvasimpl_Canvas thiz, const char* fileStr);
            void (*toOutput)(libstaticLib_kref_raytracerchallenge_canvasimpl_Canvas thiz);
            const char* (*toString)(libstaticLib_kref_raytracerchallenge_canvasimpl_Canvas thiz);
            void (*writePixel)(libstaticLib_kref_raytracerchallenge_canvasimpl_Canvas thiz, libstaticLib_KInt widthPos, libstaticLib_KInt heightPos, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple aColor);
          } Canvas;
        } canvasimpl;
        struct {
          libstaticLib_KFloat (*get_ANTI_SELF_SHADOW_BOOST)();
          libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*get_BLACK_COLOR)();
          libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*get_BLUE_COLOR)();
          libstaticLib_kref_raytracerchallenge_shadingimpl_PointLight (*get_DEFAULT_LIGHT)();
          libstaticLib_kref_raytracerchallenge_shadingimpl_Material (*get_DEFAULT_MATERIAL)();
          libstaticLib_kref_raytracerchallenge_raysimpl_Sphere (*get_DEFAULT_SPHERE1)();
          libstaticLib_kref_raytracerchallenge_raysimpl_Sphere (*get_DEFAULT_SPHERE2)();
          libstaticLib_kref_kotlin_Array (*get_DEFAULT_SPHERES)();
          libstaticLib_kref_raytracerchallenge_worldimpl_World (*get_DEFAULT_WORLD)();
          libstaticLib_KFloat (*get_HALF_PI)();
          libstaticLib_KFloat (*get_HALF_ROOT_OF_TWO)();
          libstaticLib_KFloat (*get_HALF_TAU)();
          libstaticLib_kref_raytracerchallenge_matriximpl_Matrix (*get_IDENTITY_MATRIX)();
          libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*get_MINUS_VECTOR_UNIT_Z)();
          libstaticLib_kref_raytracerchallenge_raysimpl_Intersection (*get_NO_INTERSECTION)();
          libstaticLib_KFloat (*get_PI)();
          libstaticLib_KFloat (*get_PI_SQUARED)();
          libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*get_POINT_UNIT_X)();
          libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*get_POINT_UNIT_Y)();
          libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*get_POINT_UNIT_Z)();
          libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*get_POINT_ZERO)();
          libstaticLib_KFloat (*get_QUARTER_PI)();
          libstaticLib_KFloat (*get_QUARTER_TAU)();
          libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*get_RED_COLOR)();
          libstaticLib_KFloat (*get_ROOT_OF_THREE)();
          libstaticLib_KFloat (*get_ROOT_OF_TWO)();
          libstaticLib_KFloat (*get_TAU)();
          libstaticLib_KFloat (*get_THIRD_OF_PI)();
          libstaticLib_KFloat (*get_TWO_PI)();
          libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*get_VECTOR_UNIT_X)();
          libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*get_VECTOR_UNIT_Y)();
          libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*get_VECTOR_UNIT_Z)();
          libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*get_VECTOR_ZERO)();
          libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*get_WHITE_COLOR)();
        } constants;
        struct {
          libstaticLib_kref_raytracerchallenge_matriximpl_Matrix (*makeScaling)(libstaticLib_KFloat x, libstaticLib_KFloat y, libstaticLib_KFloat z);
          libstaticLib_kref_raytracerchallenge_matriximpl_Matrix (*makeShearing)(libstaticLib_KFloat xRelativeToY, libstaticLib_KFloat xRelativeToZ, libstaticLib_KFloat yRelativeToX, libstaticLib_KFloat yRelativeToZ, libstaticLib_KFloat zRelativeToX, libstaticLib_KFloat zRelativeToY);
          libstaticLib_kref_raytracerchallenge_matriximpl_Matrix (*makeTranslation)(libstaticLib_KFloat x, libstaticLib_KFloat y, libstaticLib_KFloat z);
          libstaticLib_kref_raytracerchallenge_matriximpl_Matrix (*rotationX)(libstaticLib_KFloat radians);
          libstaticLib_kref_raytracerchallenge_matriximpl_Matrix (*rotationY)(libstaticLib_KFloat radians);
          libstaticLib_kref_raytracerchallenge_matriximpl_Matrix (*rotationZ)(libstaticLib_KFloat radians);
          struct {
            libstaticLib_KType* (*_type)(void);
            libstaticLib_kref_raytracerchallenge_matriximpl_Matrix (*Matrix)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple row_0, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple row_1, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple row_2, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple row_3);
            libstaticLib_kref_raytracerchallenge_matriximpl_Matrix (*Matrix_)(libstaticLib_KFloat x, libstaticLib_KFloat y, libstaticLib_KFloat z);
            libstaticLib_kref_raytracerchallenge_matriximpl_Matrix (*Matrix__)(libstaticLib_KFloat zero_0, libstaticLib_KFloat zero_1, libstaticLib_KFloat zero_2, libstaticLib_KFloat zero_3, libstaticLib_KFloat one_0, libstaticLib_KFloat one_1, libstaticLib_KFloat one_2, libstaticLib_KFloat one_3, libstaticLib_KFloat two_0, libstaticLib_KFloat two_1, libstaticLib_KFloat two_2, libstaticLib_KFloat two_3, libstaticLib_KFloat three_0, libstaticLib_KFloat three_1, libstaticLib_KFloat three_2, libstaticLib_KFloat three_3);
            libstaticLib_KFloat (*cofactor)(libstaticLib_kref_raytracerchallenge_matriximpl_Matrix thiz, libstaticLib_KInt row, libstaticLib_KInt column);
            libstaticLib_KFloat (*cofactor3x3)(libstaticLib_kref_raytracerchallenge_matriximpl_Matrix thiz, libstaticLib_KInt row, libstaticLib_KInt column);
            libstaticLib_KFloat (*determinant)(libstaticLib_kref_raytracerchallenge_matriximpl_Matrix thiz);
            libstaticLib_KFloat (*determinant2x2)(libstaticLib_kref_raytracerchallenge_matriximpl_Matrix thiz);
            libstaticLib_KFloat (*determinant3x3)(libstaticLib_kref_raytracerchallenge_matriximpl_Matrix thiz);
            libstaticLib_KBoolean (*equals)(libstaticLib_kref_raytracerchallenge_matriximpl_Matrix thiz, libstaticLib_kref_kotlin_Any other);
            libstaticLib_KBoolean (*equals_)(libstaticLib_kref_raytracerchallenge_matriximpl_Matrix thiz, libstaticLib_kref_raytracerchallenge_matriximpl_Matrix aMatrix);
            libstaticLib_KFloat (*get)(libstaticLib_kref_raytracerchallenge_matriximpl_Matrix thiz, libstaticLib_KInt row, libstaticLib_KInt column);
            libstaticLib_kref_raytracerchallenge_matriximpl_Matrix (*inverse)(libstaticLib_kref_raytracerchallenge_matriximpl_Matrix thiz);
            libstaticLib_KBoolean (*invertible)(libstaticLib_kref_raytracerchallenge_matriximpl_Matrix thiz);
            libstaticLib_KFloat (*minor)(libstaticLib_kref_raytracerchallenge_matriximpl_Matrix thiz, libstaticLib_KInt row, libstaticLib_KInt column);
            libstaticLib_KFloat (*minor3x3)(libstaticLib_kref_raytracerchallenge_matriximpl_Matrix thiz, libstaticLib_KInt row, libstaticLib_KInt column);
            libstaticLib_kref_raytracerchallenge_matriximpl_Matrix (*multipliedBy)(libstaticLib_kref_raytracerchallenge_matriximpl_Matrix thiz, libstaticLib_kref_raytracerchallenge_matriximpl_Matrix aMatrix);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*multipliedBy_)(libstaticLib_kref_raytracerchallenge_matriximpl_Matrix thiz, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple aTuple);
            libstaticLib_kref_raytracerchallenge_matriximpl_Matrix (*subMatrix)(libstaticLib_kref_raytracerchallenge_matriximpl_Matrix thiz, libstaticLib_KInt row, libstaticLib_KInt column);
            const char* (*toString)(libstaticLib_kref_raytracerchallenge_matriximpl_Matrix thiz);
            libstaticLib_kref_raytracerchallenge_matriximpl_Matrix (*transposed)(libstaticLib_kref_raytracerchallenge_matriximpl_Matrix thiz);
          } Matrix;
        } matriximpl;
        struct {
          libstaticLib_kref_raytracerchallenge_raysimpl_Intersection (*hit)(libstaticLib_kref_kotlin_Array crosses);
          libstaticLib_kref_kotlin_Array (*intersect)(libstaticLib_kref_raytracerchallenge_raysimpl_Sphere aSphere, libstaticLib_kref_raytracerchallenge_raysimpl_Ray aRay);
          libstaticLib_kref_kotlin_Array (*intersectGetT)(libstaticLib_kref_raytracerchallenge_raysimpl_Sphere aSphere, libstaticLib_kref_raytracerchallenge_raysimpl_Ray aRay);
          struct {
            libstaticLib_KType* (*_type)(void);
            libstaticLib_kref_raytracerchallenge_raysimpl_Intersection (*Intersection)(libstaticLib_KFloat tVal, libstaticLib_kref_raytracerchallenge_raysimpl_Shape obj);
            libstaticLib_kref_raytracerchallenge_raysimpl_Shape (*get_obj)(libstaticLib_kref_raytracerchallenge_raysimpl_Intersection thiz);
            libstaticLib_KFloat (*get_tVal)(libstaticLib_kref_raytracerchallenge_raysimpl_Intersection thiz);
            libstaticLib_KFloat (*component1)(libstaticLib_kref_raytracerchallenge_raysimpl_Intersection thiz);
            libstaticLib_kref_raytracerchallenge_raysimpl_Shape (*component2)(libstaticLib_kref_raytracerchallenge_raysimpl_Intersection thiz);
            libstaticLib_kref_raytracerchallenge_raysimpl_Intersection (*copy)(libstaticLib_kref_raytracerchallenge_raysimpl_Intersection thiz, libstaticLib_KFloat tVal, libstaticLib_kref_raytracerchallenge_raysimpl_Shape obj);
            libstaticLib_KBoolean (*equals)(libstaticLib_kref_raytracerchallenge_raysimpl_Intersection thiz, libstaticLib_kref_kotlin_Any other);
            libstaticLib_KInt (*hashCode)(libstaticLib_kref_raytracerchallenge_raysimpl_Intersection thiz);
            const char* (*toString)(libstaticLib_kref_raytracerchallenge_raysimpl_Intersection thiz);
          } Intersection;
          struct {
            libstaticLib_KType* (*_type)(void);
            libstaticLib_kref_raytracerchallenge_raysimpl_Plane (*Plane)();
            libstaticLib_kref_raytracerchallenge_raysimpl_Plane (*Plane_)(libstaticLib_kref_raytracerchallenge_shadingimpl_Material material, libstaticLib_kref_raytracerchallenge_matriximpl_Matrix transform);
            libstaticLib_kref_kotlin_Array (*localIntersect)(libstaticLib_kref_raytracerchallenge_raysimpl_Plane thiz, libstaticLib_kref_raytracerchallenge_raysimpl_Ray localRay);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*localNormalAt)(libstaticLib_kref_raytracerchallenge_raysimpl_Plane thiz, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple point);
          } Plane;
          struct {
            libstaticLib_KType* (*_type)(void);
            libstaticLib_kref_raytracerchallenge_raysimpl_Ray (*Ray)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple origin, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple direction);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*get_direction)(libstaticLib_kref_raytracerchallenge_raysimpl_Ray thiz);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*get_origin)(libstaticLib_kref_raytracerchallenge_raysimpl_Ray thiz);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*component1)(libstaticLib_kref_raytracerchallenge_raysimpl_Ray thiz);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*component2)(libstaticLib_kref_raytracerchallenge_raysimpl_Ray thiz);
            libstaticLib_kref_raytracerchallenge_raysimpl_Ray (*copy)(libstaticLib_kref_raytracerchallenge_raysimpl_Ray thiz, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple origin, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple direction);
            libstaticLib_KFloat (*dotSelf)(libstaticLib_kref_raytracerchallenge_raysimpl_Ray thiz);
            libstaticLib_KBoolean (*equals)(libstaticLib_kref_raytracerchallenge_raysimpl_Ray thiz, libstaticLib_kref_kotlin_Any other);
            libstaticLib_KInt (*hashCode)(libstaticLib_kref_raytracerchallenge_raysimpl_Ray thiz);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*position)(libstaticLib_kref_raytracerchallenge_raysimpl_Ray thiz, libstaticLib_KFloat distance);
            const char* (*toString)(libstaticLib_kref_raytracerchallenge_raysimpl_Ray thiz);
            libstaticLib_kref_raytracerchallenge_raysimpl_Ray (*transform)(libstaticLib_kref_raytracerchallenge_raysimpl_Ray thiz, libstaticLib_kref_raytracerchallenge_matriximpl_Matrix matrix);
          } Ray;
          struct {
            libstaticLib_KType* (*_type)(void);
            libstaticLib_kref_raytracerchallenge_raysimpl_Shape (*Shape)();
            libstaticLib_kref_raytracerchallenge_raysimpl_Shape (*Shape_)(libstaticLib_kref_raytracerchallenge_shadingimpl_Material material, libstaticLib_kref_raytracerchallenge_matriximpl_Matrix transform);
            libstaticLib_kref_raytracerchallenge_shadingimpl_Material (*get_material)(libstaticLib_kref_raytracerchallenge_raysimpl_Shape thiz);
            libstaticLib_kref_raytracerchallenge_matriximpl_Matrix (*get_transform)(libstaticLib_kref_raytracerchallenge_raysimpl_Shape thiz);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*getLocalPoint)(libstaticLib_kref_raytracerchallenge_raysimpl_Shape thiz, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple point);
            libstaticLib_kref_raytracerchallenge_raysimpl_Ray (*getLocalRay)(libstaticLib_kref_raytracerchallenge_raysimpl_Shape thiz, libstaticLib_kref_raytracerchallenge_raysimpl_Ray aRay);
            libstaticLib_kref_kotlin_Array (*intersect)(libstaticLib_kref_raytracerchallenge_raysimpl_Shape thiz, libstaticLib_kref_raytracerchallenge_raysimpl_Ray aRay);
            libstaticLib_kref_kotlin_Array (*localIntersect)(libstaticLib_kref_raytracerchallenge_raysimpl_Shape thiz, libstaticLib_kref_raytracerchallenge_raysimpl_Ray localRay);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*localNormalAt)(libstaticLib_kref_raytracerchallenge_raysimpl_Shape thiz, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple point);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*normalAt)(libstaticLib_kref_raytracerchallenge_raysimpl_Shape thiz, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple point);
          } Shape;
          struct {
            libstaticLib_KType* (*_type)(void);
            libstaticLib_kref_raytracerchallenge_raysimpl_Sphere (*Sphere)();
            libstaticLib_kref_raytracerchallenge_raysimpl_Sphere (*Sphere_)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple center);
            libstaticLib_kref_raytracerchallenge_raysimpl_Sphere (*Sphere__)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple center, libstaticLib_kref_raytracerchallenge_shadingimpl_Material material);
            libstaticLib_kref_raytracerchallenge_raysimpl_Sphere (*Sphere___)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple center, libstaticLib_kref_raytracerchallenge_shadingimpl_Material material, libstaticLib_kref_raytracerchallenge_matriximpl_Matrix transform);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*get_center)(libstaticLib_kref_raytracerchallenge_raysimpl_Sphere thiz);
            libstaticLib_kref_kotlin_Array (*intersectGetT)(libstaticLib_kref_raytracerchallenge_raysimpl_Sphere thiz, libstaticLib_kref_raytracerchallenge_raysimpl_Ray localRay);
            libstaticLib_kref_kotlin_Array (*localIntersect)(libstaticLib_kref_raytracerchallenge_raysimpl_Sphere thiz, libstaticLib_kref_raytracerchallenge_raysimpl_Ray localRay);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*localNormalAt)(libstaticLib_kref_raytracerchallenge_raysimpl_Sphere thiz, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple point);
          } Sphere;
        } raysimpl;
        struct {
          libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*reflect)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple vector, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple normal);
          struct {
            libstaticLib_KType* (*_type)(void);
            libstaticLib_kref_raytracerchallenge_shadingimpl_Material (*Material)();
            libstaticLib_kref_raytracerchallenge_shadingimpl_Material (*Material_)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple aColor);
            libstaticLib_kref_raytracerchallenge_shadingimpl_Material (*Material__)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple aColor, libstaticLib_KFloat specular);
            libstaticLib_kref_raytracerchallenge_shadingimpl_Material (*Material___)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple color, libstaticLib_KFloat ambient, libstaticLib_KFloat diffuse, libstaticLib_KFloat specular, libstaticLib_KFloat shininess);
            libstaticLib_KFloat (*get_ambient)(libstaticLib_kref_raytracerchallenge_shadingimpl_Material thiz);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*get_color)(libstaticLib_kref_raytracerchallenge_shadingimpl_Material thiz);
            libstaticLib_KFloat (*get_diffuse)(libstaticLib_kref_raytracerchallenge_shadingimpl_Material thiz);
            libstaticLib_KFloat (*get_shininess)(libstaticLib_kref_raytracerchallenge_shadingimpl_Material thiz);
            libstaticLib_KFloat (*get_specular)(libstaticLib_kref_raytracerchallenge_shadingimpl_Material thiz);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*component1)(libstaticLib_kref_raytracerchallenge_shadingimpl_Material thiz);
            libstaticLib_KFloat (*component2)(libstaticLib_kref_raytracerchallenge_shadingimpl_Material thiz);
            libstaticLib_KFloat (*component3)(libstaticLib_kref_raytracerchallenge_shadingimpl_Material thiz);
            libstaticLib_KFloat (*component4)(libstaticLib_kref_raytracerchallenge_shadingimpl_Material thiz);
            libstaticLib_KFloat (*component5)(libstaticLib_kref_raytracerchallenge_shadingimpl_Material thiz);
            libstaticLib_kref_raytracerchallenge_shadingimpl_Material (*copy)(libstaticLib_kref_raytracerchallenge_shadingimpl_Material thiz, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple color, libstaticLib_KFloat ambient, libstaticLib_KFloat diffuse, libstaticLib_KFloat specular, libstaticLib_KFloat shininess);
            libstaticLib_KBoolean (*equals)(libstaticLib_kref_raytracerchallenge_shadingimpl_Material thiz, libstaticLib_kref_kotlin_Any other);
            libstaticLib_KInt (*hashCode)(libstaticLib_kref_raytracerchallenge_shadingimpl_Material thiz);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*lighting)(libstaticLib_kref_raytracerchallenge_shadingimpl_Material thiz, libstaticLib_kref_raytracerchallenge_shadingimpl_PointLight light, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple position, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple eyeVector, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple normal, libstaticLib_KBoolean inShadow);
            const char* (*toString)(libstaticLib_kref_raytracerchallenge_shadingimpl_Material thiz);
          } Material;
          struct {
            libstaticLib_KType* (*_type)(void);
            libstaticLib_kref_raytracerchallenge_shadingimpl_PointLight (*PointLight)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple position, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple intensity);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*get_intensity)(libstaticLib_kref_raytracerchallenge_shadingimpl_PointLight thiz);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*get_position)(libstaticLib_kref_raytracerchallenge_shadingimpl_PointLight thiz);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*component1)(libstaticLib_kref_raytracerchallenge_shadingimpl_PointLight thiz);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*component2)(libstaticLib_kref_raytracerchallenge_shadingimpl_PointLight thiz);
            libstaticLib_kref_raytracerchallenge_shadingimpl_PointLight (*copy)(libstaticLib_kref_raytracerchallenge_shadingimpl_PointLight thiz, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple position, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple intensity);
            libstaticLib_KBoolean (*equals)(libstaticLib_kref_raytracerchallenge_shadingimpl_PointLight thiz, libstaticLib_kref_kotlin_Any other);
            libstaticLib_KInt (*hashCode)(libstaticLib_kref_raytracerchallenge_shadingimpl_PointLight thiz);
            const char* (*toString)(libstaticLib_kref_raytracerchallenge_shadingimpl_PointLight thiz);
          } PointLight;
        } shadingimpl;
        struct {
          libstaticLib_KFloat (*get_EPSILON)();
          libstaticLib_KFloat (*approxCos)(libstaticLib_KFloat rawRadians);
          libstaticLib_KFloat (*approxSin)(libstaticLib_KFloat rawRadians);
          libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*blend)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple tupleA, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple tupleB);
          libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*cross)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple tupleA, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple tupleB);
          libstaticLib_KFloat (*dot)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple tupleA, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple tupleB);
          libstaticLib_KBoolean (*equalsFloat)(libstaticLib_KFloat aFloat, libstaticLib_KFloat otherFloat);
          libstaticLib_KBoolean (*isOne)(libstaticLib_KFloat aFloat);
          libstaticLib_KBoolean (*isPoint)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple aTuple);
          libstaticLib_KBoolean (*isVector)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple aTuple);
          libstaticLib_KBoolean (*isZero)(libstaticLib_KFloat aFloat);
          libstaticLib_KFloat (*magnitude)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple aTuple);
          libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*makeColor)(libstaticLib_KFloat r, libstaticLib_KFloat g, libstaticLib_KFloat b);
          libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*makeDiagonalVector)(libstaticLib_KFloat k);
          libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*makeOpaqueColor)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple aColor);
          libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*makePoint)(libstaticLib_KFloat x, libstaticLib_KFloat y, libstaticLib_KFloat z);
          libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*makePointX)(libstaticLib_KFloat x);
          libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*makePointY)(libstaticLib_KFloat y);
          libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*makePointZ)(libstaticLib_KFloat z);
          libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*makeVector)(libstaticLib_KFloat x, libstaticLib_KFloat y, libstaticLib_KFloat z);
          libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*makeVectorX)(libstaticLib_KFloat x);
          libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*makeVectorY)(libstaticLib_KFloat y);
          libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*makeVectorZ)(libstaticLib_KFloat z);
          libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*normalized)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple aTuple);
          libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*times)(libstaticLib_KFloat thiz, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple aTuple);
          struct {
            libstaticLib_KType* (*_type)(void);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*Tuple)(libstaticLib_KFloat x, libstaticLib_KFloat y, libstaticLib_KFloat z, libstaticLib_KFloat w);
            libstaticLib_KFloat (*get_w)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libstaticLib_KFloat (*get_x)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libstaticLib_KFloat (*get_y)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libstaticLib_KFloat (*get_z)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libstaticLib_KFloat (*alpha)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libstaticLib_KInt (*alphaInt)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libstaticLib_KFloat (*blue)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libstaticLib_KInt (*blueInt)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libstaticLib_KFloat (*component1)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libstaticLib_KFloat (*component2)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libstaticLib_KFloat (*component3)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libstaticLib_KFloat (*component4)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*copy)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple thiz, libstaticLib_KFloat x, libstaticLib_KFloat y, libstaticLib_KFloat z, libstaticLib_KFloat w);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*div)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple thiz, libstaticLib_KFloat scalar);
            libstaticLib_KBoolean (*equals)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple thiz, libstaticLib_kref_kotlin_Any other);
            libstaticLib_KBoolean (*equals_)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple thiz, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple other);
            libstaticLib_KFloat (*green)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libstaticLib_KInt (*greenInt)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libstaticLib_KInt (*hashCode)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libstaticLib_KFloat (*magnitude)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*minus)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple thiz, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple aTuple);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*plus)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple thiz, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple aTuple);
            libstaticLib_KFloat (*red)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libstaticLib_KInt (*redInt)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*times)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple thiz, libstaticLib_KFloat scalar);
            const char* (*toString)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*unaryMinus)(libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple thiz);
          } Tuple;
        } tupleimpl;
        struct {
          libstaticLib_KBoolean (*isShadowed)(libstaticLib_kref_raytracerchallenge_worldimpl_World world, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple point);
          struct {
            libstaticLib_KType* (*_type)(void);
            libstaticLib_kref_raytracerchallenge_worldimpl_Computations (*Computations)(libstaticLib_kref_raytracerchallenge_raysimpl_Intersection intersection, libstaticLib_kref_raytracerchallenge_raysimpl_Ray ray);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*get_eyeVector)(libstaticLib_kref_raytracerchallenge_worldimpl_Computations thiz);
            libstaticLib_KBoolean (*get_inside)(libstaticLib_kref_raytracerchallenge_worldimpl_Computations thiz);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*get_normalVector)(libstaticLib_kref_raytracerchallenge_worldimpl_Computations thiz);
            libstaticLib_kref_raytracerchallenge_raysimpl_Shape (*get_obj)(libstaticLib_kref_raytracerchallenge_worldimpl_Computations thiz);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*get_overPoint)(libstaticLib_kref_raytracerchallenge_worldimpl_Computations thiz);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*get_point)(libstaticLib_kref_raytracerchallenge_worldimpl_Computations thiz);
            libstaticLib_KFloat (*get_tVal)(libstaticLib_kref_raytracerchallenge_worldimpl_Computations thiz);
          } Computations;
          struct {
            libstaticLib_KType* (*_type)(void);
            libstaticLib_kref_raytracerchallenge_worldimpl_World (*World)(libstaticLib_kref_raytracerchallenge_shadingimpl_PointLight light, libstaticLib_kref_kotlin_Array shapes);
            libstaticLib_kref_raytracerchallenge_shadingimpl_PointLight (*get_light)(libstaticLib_kref_raytracerchallenge_worldimpl_World thiz);
            libstaticLib_kref_kotlin_Array (*get_shapes)(libstaticLib_kref_raytracerchallenge_worldimpl_World thiz);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*colorAt)(libstaticLib_kref_raytracerchallenge_worldimpl_World thiz, libstaticLib_kref_raytracerchallenge_raysimpl_Ray ray);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*colorAt_)(libstaticLib_kref_raytracerchallenge_worldimpl_World thiz, libstaticLib_kref_raytracerchallenge_raysimpl_Ray ray, libstaticLib_KBoolean useShadow);
            libstaticLib_kref_raytracerchallenge_shadingimpl_PointLight (*component1)(libstaticLib_kref_raytracerchallenge_worldimpl_World thiz);
            libstaticLib_kref_kotlin_Array (*component2)(libstaticLib_kref_raytracerchallenge_worldimpl_World thiz);
            libstaticLib_kref_raytracerchallenge_worldimpl_World (*copy)(libstaticLib_kref_raytracerchallenge_worldimpl_World thiz, libstaticLib_kref_raytracerchallenge_shadingimpl_PointLight light, libstaticLib_kref_kotlin_Array shapes);
            libstaticLib_KBoolean (*equals)(libstaticLib_kref_raytracerchallenge_worldimpl_World thiz, libstaticLib_kref_kotlin_Any other);
            libstaticLib_KBoolean (*equals_)(libstaticLib_kref_raytracerchallenge_worldimpl_World thiz, libstaticLib_kref_raytracerchallenge_worldimpl_World world);
            libstaticLib_KInt (*hashCode)(libstaticLib_kref_raytracerchallenge_worldimpl_World thiz);
            libstaticLib_kref_kotlin_Array (*intersect)(libstaticLib_kref_raytracerchallenge_worldimpl_World thiz, libstaticLib_kref_raytracerchallenge_raysimpl_Ray ray);
            libstaticLib_KBoolean (*isShadowed)(libstaticLib_kref_raytracerchallenge_worldimpl_World thiz, libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple point);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*shadeHit)(libstaticLib_kref_raytracerchallenge_worldimpl_World thiz, libstaticLib_kref_raytracerchallenge_worldimpl_Computations comps);
            libstaticLib_kref_raytracerchallenge_tupleimpl_Tuple (*shadeHit_)(libstaticLib_kref_raytracerchallenge_worldimpl_World thiz, libstaticLib_kref_raytracerchallenge_worldimpl_Computations comps, libstaticLib_KBoolean useShadows);
            const char* (*toString)(libstaticLib_kref_raytracerchallenge_worldimpl_World thiz);
          } World;
        } worldimpl;
      } raytracerchallenge;
    } root;
  } kotlin;
} libstaticLib_ExportedSymbols;
extern libstaticLib_ExportedSymbols* libstaticLib_symbols(void);
#ifdef __cplusplus
}  /* extern "C" */
#endif
#endif  /* KONAN_LIBSTATICLIB_H */
