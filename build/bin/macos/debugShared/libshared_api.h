#ifndef KONAN_LIBSHARED_H
#define KONAN_LIBSHARED_H
#ifdef __cplusplus
extern "C" {
#endif
#ifdef __cplusplus
typedef bool            libshared_KBoolean;
#else
typedef _Bool           libshared_KBoolean;
#endif
typedef unsigned short     libshared_KChar;
typedef signed char        libshared_KByte;
typedef short              libshared_KShort;
typedef int                libshared_KInt;
typedef long long          libshared_KLong;
typedef unsigned char      libshared_KUByte;
typedef unsigned short     libshared_KUShort;
typedef unsigned int       libshared_KUInt;
typedef unsigned long long libshared_KULong;
typedef float              libshared_KFloat;
typedef double             libshared_KDouble;
typedef float __attribute__ ((__vector_size__ (16))) libshared_KVector128;
typedef void*              libshared_KNativePtr;
struct libshared_KType;
typedef struct libshared_KType libshared_KType;

typedef struct {
  libshared_KNativePtr pinned;
} libshared_kref_kotlin_Byte;
typedef struct {
  libshared_KNativePtr pinned;
} libshared_kref_kotlin_Short;
typedef struct {
  libshared_KNativePtr pinned;
} libshared_kref_kotlin_Int;
typedef struct {
  libshared_KNativePtr pinned;
} libshared_kref_kotlin_Long;
typedef struct {
  libshared_KNativePtr pinned;
} libshared_kref_kotlin_Float;
typedef struct {
  libshared_KNativePtr pinned;
} libshared_kref_kotlin_Double;
typedef struct {
  libshared_KNativePtr pinned;
} libshared_kref_kotlin_Char;
typedef struct {
  libshared_KNativePtr pinned;
} libshared_kref_kotlin_Boolean;
typedef struct {
  libshared_KNativePtr pinned;
} libshared_kref_kotlin_Unit;
typedef struct {
  libshared_KNativePtr pinned;
} libshared_kref_raytracerchallenge_tupleimpl_Tuple;
typedef struct {
  libshared_KNativePtr pinned;
} libshared_kref_Executable_Projectile_Environment;
typedef struct {
  libshared_KNativePtr pinned;
} libshared_kref_Executable_Projectile_Projectile;
typedef struct {
  libshared_KNativePtr pinned;
} libshared_kref_kotlin_Any;
typedef struct {
  libshared_KNativePtr pinned;
} libshared_kref_raytracerchallenge_matriximpl_Matrix;
typedef struct {
  libshared_KNativePtr pinned;
} libshared_kref_raytracerchallenge_cameraimpl_Camera;
typedef struct {
  libshared_KNativePtr pinned;
} libshared_kref_raytracerchallenge_raysimpl_Ray;
typedef struct {
  libshared_KNativePtr pinned;
} libshared_kref_raytracerchallenge_worldimpl_World;
typedef struct {
  libshared_KNativePtr pinned;
} libshared_kref_raytracerchallenge_canvasimpl_Canvas;
typedef struct {
  libshared_KNativePtr pinned;
} libshared_kref_raytracerchallenge_shadingimpl_PointLight;
typedef struct {
  libshared_KNativePtr pinned;
} libshared_kref_raytracerchallenge_shadingimpl_Material;
typedef struct {
  libshared_KNativePtr pinned;
} libshared_kref_raytracerchallenge_raysimpl_Sphere;
typedef struct {
  libshared_KNativePtr pinned;
} libshared_kref_kotlin_Array;
typedef struct {
  libshared_KNativePtr pinned;
} libshared_kref_raytracerchallenge_raysimpl_Intersection;
typedef struct {
  libshared_KNativePtr pinned;
} libshared_kref_raytracerchallenge_raysimpl_Shape;
typedef struct {
  libshared_KNativePtr pinned;
} libshared_kref_raytracerchallenge_raysimpl_Plane;
typedef struct {
  libshared_KNativePtr pinned;
} libshared_kref_raytracerchallenge_worldimpl_Computations;


typedef struct {
  /* Service functions. */
  void (*DisposeStablePointer)(libshared_KNativePtr ptr);
  void (*DisposeString)(const char* string);
  libshared_KBoolean (*IsInstance)(libshared_KNativePtr ref, const libshared_KType* type);
  libshared_kref_kotlin_Byte (*createNullableByte)(libshared_KByte);
  libshared_kref_kotlin_Short (*createNullableShort)(libshared_KShort);
  libshared_kref_kotlin_Int (*createNullableInt)(libshared_KInt);
  libshared_kref_kotlin_Long (*createNullableLong)(libshared_KLong);
  libshared_kref_kotlin_Float (*createNullableFloat)(libshared_KFloat);
  libshared_kref_kotlin_Double (*createNullableDouble)(libshared_KDouble);
  libshared_kref_kotlin_Char (*createNullableChar)(libshared_KChar);
  libshared_kref_kotlin_Boolean (*createNullableBoolean)(libshared_KBoolean);
  libshared_kref_kotlin_Unit (*createNullableUnit)(void);

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
          libshared_KInt (*getHeightCoord)(libshared_kref_raytracerchallenge_tupleimpl_Tuple tuple, libshared_KInt centerHeight);
          libshared_KInt (*getWidthCoord)(libshared_kref_raytracerchallenge_tupleimpl_Tuple tuple, libshared_KInt centerWidth);
          void (*main)();
        } Clock;
        struct {
          void (*main)();
        } Plane;
        struct {
          void (*main)();
          libshared_kref_Executable_Projectile_Projectile (*tick)(libshared_kref_Executable_Projectile_Environment env, libshared_kref_Executable_Projectile_Projectile proj);
          struct {
            libshared_KType* (*_type)(void);
            libshared_kref_Executable_Projectile_Environment (*Environment)(libshared_kref_raytracerchallenge_tupleimpl_Tuple gravity, libshared_kref_raytracerchallenge_tupleimpl_Tuple wind);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*get_gravity)(libshared_kref_Executable_Projectile_Environment thiz);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*get_wind)(libshared_kref_Executable_Projectile_Environment thiz);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*component1)(libshared_kref_Executable_Projectile_Environment thiz);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*component2)(libshared_kref_Executable_Projectile_Environment thiz);
            libshared_kref_Executable_Projectile_Environment (*copy)(libshared_kref_Executable_Projectile_Environment thiz, libshared_kref_raytracerchallenge_tupleimpl_Tuple gravity, libshared_kref_raytracerchallenge_tupleimpl_Tuple wind);
            libshared_KBoolean (*equals)(libshared_kref_Executable_Projectile_Environment thiz, libshared_kref_kotlin_Any other);
            libshared_KInt (*hashCode)(libshared_kref_Executable_Projectile_Environment thiz);
            const char* (*toString)(libshared_kref_Executable_Projectile_Environment thiz);
          } Environment;
          struct {
            libshared_KType* (*_type)(void);
            libshared_kref_Executable_Projectile_Projectile (*Projectile)(libshared_kref_raytracerchallenge_tupleimpl_Tuple position, libshared_kref_raytracerchallenge_tupleimpl_Tuple velocity);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*get_position)(libshared_kref_Executable_Projectile_Projectile thiz);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*get_velocity)(libshared_kref_Executable_Projectile_Projectile thiz);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*component1)(libshared_kref_Executable_Projectile_Projectile thiz);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*component2)(libshared_kref_Executable_Projectile_Projectile thiz);
            libshared_kref_Executable_Projectile_Projectile (*copy)(libshared_kref_Executable_Projectile_Projectile thiz, libshared_kref_raytracerchallenge_tupleimpl_Tuple position, libshared_kref_raytracerchallenge_tupleimpl_Tuple velocity);
            libshared_KBoolean (*equals)(libshared_kref_Executable_Projectile_Projectile thiz, libshared_kref_kotlin_Any other);
            libshared_KInt (*hashCode)(libshared_kref_Executable_Projectile_Projectile thiz);
            const char* (*toString)(libshared_kref_Executable_Projectile_Projectile thiz);
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
          libshared_kref_raytracerchallenge_matriximpl_Matrix (*viewTransform)(libshared_kref_raytracerchallenge_tupleimpl_Tuple from, libshared_kref_raytracerchallenge_tupleimpl_Tuple to, libshared_kref_raytracerchallenge_tupleimpl_Tuple up);
          struct {
            libshared_KType* (*_type)(void);
            libshared_kref_raytracerchallenge_cameraimpl_Camera (*Camera)(libshared_KInt hSize, libshared_KInt vSize, libshared_KFloat fieldOfView);
            libshared_kref_raytracerchallenge_cameraimpl_Camera (*Camera_)(libshared_KInt hSize, libshared_KInt vSize, libshared_KFloat fieldOfView, libshared_kref_raytracerchallenge_matriximpl_Matrix transform);
            libshared_KFloat (*get_fieldOfView)(libshared_kref_raytracerchallenge_cameraimpl_Camera thiz);
            libshared_KInt (*get_hSize)(libshared_kref_raytracerchallenge_cameraimpl_Camera thiz);
            libshared_KFloat (*get_pixelSize)(libshared_kref_raytracerchallenge_cameraimpl_Camera thiz);
            libshared_kref_raytracerchallenge_matriximpl_Matrix (*get_transform)(libshared_kref_raytracerchallenge_cameraimpl_Camera thiz);
            libshared_KInt (*get_vSize)(libshared_kref_raytracerchallenge_cameraimpl_Camera thiz);
            libshared_KInt (*component1)(libshared_kref_raytracerchallenge_cameraimpl_Camera thiz);
            libshared_KInt (*component2)(libshared_kref_raytracerchallenge_cameraimpl_Camera thiz);
            libshared_KFloat (*component3)(libshared_kref_raytracerchallenge_cameraimpl_Camera thiz);
            libshared_kref_raytracerchallenge_matriximpl_Matrix (*component4)(libshared_kref_raytracerchallenge_cameraimpl_Camera thiz);
            libshared_kref_raytracerchallenge_cameraimpl_Camera (*copy)(libshared_kref_raytracerchallenge_cameraimpl_Camera thiz, libshared_KInt hSize, libshared_KInt vSize, libshared_KFloat fieldOfView, libshared_kref_raytracerchallenge_matriximpl_Matrix transform);
            libshared_KBoolean (*equals)(libshared_kref_raytracerchallenge_cameraimpl_Camera thiz, libshared_kref_kotlin_Any other);
            libshared_KInt (*hashCode)(libshared_kref_raytracerchallenge_cameraimpl_Camera thiz);
            libshared_kref_raytracerchallenge_raysimpl_Ray (*rayForPixel)(libshared_kref_raytracerchallenge_cameraimpl_Camera thiz, libshared_KInt x, libshared_KInt y);
            libshared_kref_raytracerchallenge_canvasimpl_Canvas (*render)(libshared_kref_raytracerchallenge_cameraimpl_Camera thiz, libshared_kref_raytracerchallenge_worldimpl_World world);
            libshared_kref_raytracerchallenge_canvasimpl_Canvas (*render_)(libshared_kref_raytracerchallenge_cameraimpl_Camera thiz, libshared_kref_raytracerchallenge_worldimpl_World world, libshared_KBoolean useShadows);
            const char* (*toString)(libshared_kref_raytracerchallenge_cameraimpl_Camera thiz);
          } Camera;
        } cameraimpl;
        struct {
          struct {
            libshared_KType* (*_type)(void);
            libshared_kref_raytracerchallenge_canvasimpl_Canvas (*Canvas)(libshared_KInt width, libshared_KInt height);
            libshared_KInt (*get_height)(libshared_kref_raytracerchallenge_canvasimpl_Canvas thiz);
            libshared_KInt (*get_width)(libshared_kref_raytracerchallenge_canvasimpl_Canvas thiz);
            libshared_KInt (*component1)(libshared_kref_raytracerchallenge_canvasimpl_Canvas thiz);
            libshared_KInt (*component2)(libshared_kref_raytracerchallenge_canvasimpl_Canvas thiz);
            libshared_kref_raytracerchallenge_canvasimpl_Canvas (*copy)(libshared_kref_raytracerchallenge_canvasimpl_Canvas thiz, libshared_KInt width, libshared_KInt height);
            libshared_KBoolean (*equals)(libshared_kref_raytracerchallenge_canvasimpl_Canvas thiz, libshared_kref_kotlin_Any other);
            libshared_KInt (*hashCode)(libshared_kref_raytracerchallenge_canvasimpl_Canvas thiz);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*pixelAt)(libshared_kref_raytracerchallenge_canvasimpl_Canvas thiz, libshared_KInt widthPos, libshared_KInt heightPos);
            void (*toFile)(libshared_kref_raytracerchallenge_canvasimpl_Canvas thiz, const char* fileStr);
            void (*toOutput)(libshared_kref_raytracerchallenge_canvasimpl_Canvas thiz);
            const char* (*toString)(libshared_kref_raytracerchallenge_canvasimpl_Canvas thiz);
            void (*writePixel)(libshared_kref_raytracerchallenge_canvasimpl_Canvas thiz, libshared_KInt widthPos, libshared_KInt heightPos, libshared_kref_raytracerchallenge_tupleimpl_Tuple aColor);
          } Canvas;
        } canvasimpl;
        struct {
          libshared_KFloat (*get_ANTI_SELF_SHADOW_BOOST)();
          libshared_kref_raytracerchallenge_tupleimpl_Tuple (*get_BLACK_COLOR)();
          libshared_kref_raytracerchallenge_tupleimpl_Tuple (*get_BLUE_COLOR)();
          libshared_kref_raytracerchallenge_shadingimpl_PointLight (*get_DEFAULT_LIGHT)();
          libshared_kref_raytracerchallenge_shadingimpl_Material (*get_DEFAULT_MATERIAL)();
          libshared_kref_raytracerchallenge_raysimpl_Sphere (*get_DEFAULT_SPHERE1)();
          libshared_kref_raytracerchallenge_raysimpl_Sphere (*get_DEFAULT_SPHERE2)();
          libshared_kref_kotlin_Array (*get_DEFAULT_SPHERES)();
          libshared_kref_raytracerchallenge_worldimpl_World (*get_DEFAULT_WORLD)();
          libshared_KFloat (*get_HALF_PI)();
          libshared_KFloat (*get_HALF_ROOT_OF_TWO)();
          libshared_KFloat (*get_HALF_TAU)();
          libshared_kref_raytracerchallenge_matriximpl_Matrix (*get_IDENTITY_MATRIX)();
          libshared_kref_raytracerchallenge_tupleimpl_Tuple (*get_MINUS_VECTOR_UNIT_Z)();
          libshared_kref_raytracerchallenge_raysimpl_Intersection (*get_NO_INTERSECTION)();
          libshared_KFloat (*get_PI)();
          libshared_KFloat (*get_PI_SQUARED)();
          libshared_kref_raytracerchallenge_tupleimpl_Tuple (*get_POINT_UNIT_X)();
          libshared_kref_raytracerchallenge_tupleimpl_Tuple (*get_POINT_UNIT_Y)();
          libshared_kref_raytracerchallenge_tupleimpl_Tuple (*get_POINT_UNIT_Z)();
          libshared_kref_raytracerchallenge_tupleimpl_Tuple (*get_POINT_ZERO)();
          libshared_KFloat (*get_QUARTER_PI)();
          libshared_KFloat (*get_QUARTER_TAU)();
          libshared_kref_raytracerchallenge_tupleimpl_Tuple (*get_RED_COLOR)();
          libshared_KFloat (*get_ROOT_OF_THREE)();
          libshared_KFloat (*get_ROOT_OF_TWO)();
          libshared_KFloat (*get_TAU)();
          libshared_KFloat (*get_THIRD_OF_PI)();
          libshared_KFloat (*get_TWO_PI)();
          libshared_kref_raytracerchallenge_tupleimpl_Tuple (*get_VECTOR_UNIT_X)();
          libshared_kref_raytracerchallenge_tupleimpl_Tuple (*get_VECTOR_UNIT_Y)();
          libshared_kref_raytracerchallenge_tupleimpl_Tuple (*get_VECTOR_UNIT_Z)();
          libshared_kref_raytracerchallenge_tupleimpl_Tuple (*get_VECTOR_ZERO)();
          libshared_kref_raytracerchallenge_tupleimpl_Tuple (*get_WHITE_COLOR)();
        } constants;
        struct {
          libshared_kref_raytracerchallenge_matriximpl_Matrix (*makeScaling)(libshared_KFloat x, libshared_KFloat y, libshared_KFloat z);
          libshared_kref_raytracerchallenge_matriximpl_Matrix (*makeShearing)(libshared_KFloat xRelativeToY, libshared_KFloat xRelativeToZ, libshared_KFloat yRelativeToX, libshared_KFloat yRelativeToZ, libshared_KFloat zRelativeToX, libshared_KFloat zRelativeToY);
          libshared_kref_raytracerchallenge_matriximpl_Matrix (*makeTranslation)(libshared_KFloat x, libshared_KFloat y, libshared_KFloat z);
          libshared_kref_raytracerchallenge_matriximpl_Matrix (*rotationX)(libshared_KFloat radians);
          libshared_kref_raytracerchallenge_matriximpl_Matrix (*rotationY)(libshared_KFloat radians);
          libshared_kref_raytracerchallenge_matriximpl_Matrix (*rotationZ)(libshared_KFloat radians);
          struct {
            libshared_KType* (*_type)(void);
            libshared_kref_raytracerchallenge_matriximpl_Matrix (*Matrix)(libshared_kref_raytracerchallenge_tupleimpl_Tuple row_0, libshared_kref_raytracerchallenge_tupleimpl_Tuple row_1, libshared_kref_raytracerchallenge_tupleimpl_Tuple row_2, libshared_kref_raytracerchallenge_tupleimpl_Tuple row_3);
            libshared_kref_raytracerchallenge_matriximpl_Matrix (*Matrix_)(libshared_KFloat x, libshared_KFloat y, libshared_KFloat z);
            libshared_kref_raytracerchallenge_matriximpl_Matrix (*Matrix__)(libshared_KFloat zero_0, libshared_KFloat zero_1, libshared_KFloat zero_2, libshared_KFloat zero_3, libshared_KFloat one_0, libshared_KFloat one_1, libshared_KFloat one_2, libshared_KFloat one_3, libshared_KFloat two_0, libshared_KFloat two_1, libshared_KFloat two_2, libshared_KFloat two_3, libshared_KFloat three_0, libshared_KFloat three_1, libshared_KFloat three_2, libshared_KFloat three_3);
            libshared_KFloat (*cofactor)(libshared_kref_raytracerchallenge_matriximpl_Matrix thiz, libshared_KInt row, libshared_KInt column);
            libshared_KFloat (*cofactor3x3)(libshared_kref_raytracerchallenge_matriximpl_Matrix thiz, libshared_KInt row, libshared_KInt column);
            libshared_KFloat (*determinant)(libshared_kref_raytracerchallenge_matriximpl_Matrix thiz);
            libshared_KFloat (*determinant2x2)(libshared_kref_raytracerchallenge_matriximpl_Matrix thiz);
            libshared_KFloat (*determinant3x3)(libshared_kref_raytracerchallenge_matriximpl_Matrix thiz);
            libshared_KBoolean (*equals)(libshared_kref_raytracerchallenge_matriximpl_Matrix thiz, libshared_kref_kotlin_Any other);
            libshared_KBoolean (*equals_)(libshared_kref_raytracerchallenge_matriximpl_Matrix thiz, libshared_kref_raytracerchallenge_matriximpl_Matrix aMatrix);
            libshared_KFloat (*get)(libshared_kref_raytracerchallenge_matriximpl_Matrix thiz, libshared_KInt row, libshared_KInt column);
            libshared_kref_raytracerchallenge_matriximpl_Matrix (*inverse)(libshared_kref_raytracerchallenge_matriximpl_Matrix thiz);
            libshared_KBoolean (*invertible)(libshared_kref_raytracerchallenge_matriximpl_Matrix thiz);
            libshared_KFloat (*minor)(libshared_kref_raytracerchallenge_matriximpl_Matrix thiz, libshared_KInt row, libshared_KInt column);
            libshared_KFloat (*minor3x3)(libshared_kref_raytracerchallenge_matriximpl_Matrix thiz, libshared_KInt row, libshared_KInt column);
            libshared_kref_raytracerchallenge_matriximpl_Matrix (*multipliedBy)(libshared_kref_raytracerchallenge_matriximpl_Matrix thiz, libshared_kref_raytracerchallenge_matriximpl_Matrix aMatrix);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*multipliedBy_)(libshared_kref_raytracerchallenge_matriximpl_Matrix thiz, libshared_kref_raytracerchallenge_tupleimpl_Tuple aTuple);
            libshared_kref_raytracerchallenge_matriximpl_Matrix (*subMatrix)(libshared_kref_raytracerchallenge_matriximpl_Matrix thiz, libshared_KInt row, libshared_KInt column);
            const char* (*toString)(libshared_kref_raytracerchallenge_matriximpl_Matrix thiz);
            libshared_kref_raytracerchallenge_matriximpl_Matrix (*transposed)(libshared_kref_raytracerchallenge_matriximpl_Matrix thiz);
          } Matrix;
        } matriximpl;
        struct {
          libshared_kref_raytracerchallenge_raysimpl_Intersection (*hit)(libshared_kref_kotlin_Array crosses);
          libshared_kref_kotlin_Array (*intersect)(libshared_kref_raytracerchallenge_raysimpl_Sphere aSphere, libshared_kref_raytracerchallenge_raysimpl_Ray aRay);
          libshared_kref_kotlin_Array (*intersectGetT)(libshared_kref_raytracerchallenge_raysimpl_Sphere aSphere, libshared_kref_raytracerchallenge_raysimpl_Ray aRay);
          struct {
            libshared_KType* (*_type)(void);
            libshared_kref_raytracerchallenge_raysimpl_Intersection (*Intersection)(libshared_KFloat tVal, libshared_kref_raytracerchallenge_raysimpl_Shape obj);
            libshared_kref_raytracerchallenge_raysimpl_Shape (*get_obj)(libshared_kref_raytracerchallenge_raysimpl_Intersection thiz);
            libshared_KFloat (*get_tVal)(libshared_kref_raytracerchallenge_raysimpl_Intersection thiz);
            libshared_KFloat (*component1)(libshared_kref_raytracerchallenge_raysimpl_Intersection thiz);
            libshared_kref_raytracerchallenge_raysimpl_Shape (*component2)(libshared_kref_raytracerchallenge_raysimpl_Intersection thiz);
            libshared_kref_raytracerchallenge_raysimpl_Intersection (*copy)(libshared_kref_raytracerchallenge_raysimpl_Intersection thiz, libshared_KFloat tVal, libshared_kref_raytracerchallenge_raysimpl_Shape obj);
            libshared_KBoolean (*equals)(libshared_kref_raytracerchallenge_raysimpl_Intersection thiz, libshared_kref_kotlin_Any other);
            libshared_KInt (*hashCode)(libshared_kref_raytracerchallenge_raysimpl_Intersection thiz);
            const char* (*toString)(libshared_kref_raytracerchallenge_raysimpl_Intersection thiz);
          } Intersection;
          struct {
            libshared_KType* (*_type)(void);
            libshared_kref_raytracerchallenge_raysimpl_Plane (*Plane)();
            libshared_kref_raytracerchallenge_raysimpl_Plane (*Plane_)(libshared_kref_raytracerchallenge_shadingimpl_Material material, libshared_kref_raytracerchallenge_matriximpl_Matrix transform);
            libshared_kref_kotlin_Array (*localIntersect)(libshared_kref_raytracerchallenge_raysimpl_Plane thiz, libshared_kref_raytracerchallenge_raysimpl_Ray localRay);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*localNormalAt)(libshared_kref_raytracerchallenge_raysimpl_Plane thiz, libshared_kref_raytracerchallenge_tupleimpl_Tuple point);
          } Plane;
          struct {
            libshared_KType* (*_type)(void);
            libshared_kref_raytracerchallenge_raysimpl_Ray (*Ray)(libshared_kref_raytracerchallenge_tupleimpl_Tuple origin, libshared_kref_raytracerchallenge_tupleimpl_Tuple direction);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*get_direction)(libshared_kref_raytracerchallenge_raysimpl_Ray thiz);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*get_origin)(libshared_kref_raytracerchallenge_raysimpl_Ray thiz);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*component1)(libshared_kref_raytracerchallenge_raysimpl_Ray thiz);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*component2)(libshared_kref_raytracerchallenge_raysimpl_Ray thiz);
            libshared_kref_raytracerchallenge_raysimpl_Ray (*copy)(libshared_kref_raytracerchallenge_raysimpl_Ray thiz, libshared_kref_raytracerchallenge_tupleimpl_Tuple origin, libshared_kref_raytracerchallenge_tupleimpl_Tuple direction);
            libshared_KFloat (*dotSelf)(libshared_kref_raytracerchallenge_raysimpl_Ray thiz);
            libshared_KBoolean (*equals)(libshared_kref_raytracerchallenge_raysimpl_Ray thiz, libshared_kref_kotlin_Any other);
            libshared_KInt (*hashCode)(libshared_kref_raytracerchallenge_raysimpl_Ray thiz);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*position)(libshared_kref_raytracerchallenge_raysimpl_Ray thiz, libshared_KFloat distance);
            const char* (*toString)(libshared_kref_raytracerchallenge_raysimpl_Ray thiz);
            libshared_kref_raytracerchallenge_raysimpl_Ray (*transform)(libshared_kref_raytracerchallenge_raysimpl_Ray thiz, libshared_kref_raytracerchallenge_matriximpl_Matrix matrix);
          } Ray;
          struct {
            libshared_KType* (*_type)(void);
            libshared_kref_raytracerchallenge_raysimpl_Shape (*Shape)();
            libshared_kref_raytracerchallenge_raysimpl_Shape (*Shape_)(libshared_kref_raytracerchallenge_shadingimpl_Material material, libshared_kref_raytracerchallenge_matriximpl_Matrix transform);
            libshared_kref_raytracerchallenge_shadingimpl_Material (*get_material)(libshared_kref_raytracerchallenge_raysimpl_Shape thiz);
            libshared_kref_raytracerchallenge_matriximpl_Matrix (*get_transform)(libshared_kref_raytracerchallenge_raysimpl_Shape thiz);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*getLocalPoint)(libshared_kref_raytracerchallenge_raysimpl_Shape thiz, libshared_kref_raytracerchallenge_tupleimpl_Tuple point);
            libshared_kref_raytracerchallenge_raysimpl_Ray (*getLocalRay)(libshared_kref_raytracerchallenge_raysimpl_Shape thiz, libshared_kref_raytracerchallenge_raysimpl_Ray aRay);
            libshared_kref_kotlin_Array (*intersect)(libshared_kref_raytracerchallenge_raysimpl_Shape thiz, libshared_kref_raytracerchallenge_raysimpl_Ray aRay);
            libshared_kref_kotlin_Array (*localIntersect)(libshared_kref_raytracerchallenge_raysimpl_Shape thiz, libshared_kref_raytracerchallenge_raysimpl_Ray localRay);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*localNormalAt)(libshared_kref_raytracerchallenge_raysimpl_Shape thiz, libshared_kref_raytracerchallenge_tupleimpl_Tuple point);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*normalAt)(libshared_kref_raytracerchallenge_raysimpl_Shape thiz, libshared_kref_raytracerchallenge_tupleimpl_Tuple point);
          } Shape;
          struct {
            libshared_KType* (*_type)(void);
            libshared_kref_raytracerchallenge_raysimpl_Sphere (*Sphere)();
            libshared_kref_raytracerchallenge_raysimpl_Sphere (*Sphere_)(libshared_kref_raytracerchallenge_tupleimpl_Tuple center);
            libshared_kref_raytracerchallenge_raysimpl_Sphere (*Sphere__)(libshared_kref_raytracerchallenge_tupleimpl_Tuple center, libshared_kref_raytracerchallenge_shadingimpl_Material material);
            libshared_kref_raytracerchallenge_raysimpl_Sphere (*Sphere___)(libshared_kref_raytracerchallenge_tupleimpl_Tuple center, libshared_kref_raytracerchallenge_shadingimpl_Material material, libshared_kref_raytracerchallenge_matriximpl_Matrix transform);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*get_center)(libshared_kref_raytracerchallenge_raysimpl_Sphere thiz);
            libshared_kref_kotlin_Array (*intersectGetT)(libshared_kref_raytracerchallenge_raysimpl_Sphere thiz, libshared_kref_raytracerchallenge_raysimpl_Ray localRay);
            libshared_kref_kotlin_Array (*localIntersect)(libshared_kref_raytracerchallenge_raysimpl_Sphere thiz, libshared_kref_raytracerchallenge_raysimpl_Ray localRay);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*localNormalAt)(libshared_kref_raytracerchallenge_raysimpl_Sphere thiz, libshared_kref_raytracerchallenge_tupleimpl_Tuple point);
          } Sphere;
        } raysimpl;
        struct {
          libshared_kref_raytracerchallenge_tupleimpl_Tuple (*reflect)(libshared_kref_raytracerchallenge_tupleimpl_Tuple vector, libshared_kref_raytracerchallenge_tupleimpl_Tuple normal);
          struct {
            libshared_KType* (*_type)(void);
            libshared_kref_raytracerchallenge_shadingimpl_Material (*Material)();
            libshared_kref_raytracerchallenge_shadingimpl_Material (*Material_)(libshared_kref_raytracerchallenge_tupleimpl_Tuple aColor);
            libshared_kref_raytracerchallenge_shadingimpl_Material (*Material__)(libshared_kref_raytracerchallenge_tupleimpl_Tuple aColor, libshared_KFloat specular);
            libshared_kref_raytracerchallenge_shadingimpl_Material (*Material___)(libshared_kref_raytracerchallenge_tupleimpl_Tuple color, libshared_KFloat ambient, libshared_KFloat diffuse, libshared_KFloat specular, libshared_KFloat shininess);
            libshared_KFloat (*get_ambient)(libshared_kref_raytracerchallenge_shadingimpl_Material thiz);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*get_color)(libshared_kref_raytracerchallenge_shadingimpl_Material thiz);
            libshared_KFloat (*get_diffuse)(libshared_kref_raytracerchallenge_shadingimpl_Material thiz);
            libshared_KFloat (*get_shininess)(libshared_kref_raytracerchallenge_shadingimpl_Material thiz);
            libshared_KFloat (*get_specular)(libshared_kref_raytracerchallenge_shadingimpl_Material thiz);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*component1)(libshared_kref_raytracerchallenge_shadingimpl_Material thiz);
            libshared_KFloat (*component2)(libshared_kref_raytracerchallenge_shadingimpl_Material thiz);
            libshared_KFloat (*component3)(libshared_kref_raytracerchallenge_shadingimpl_Material thiz);
            libshared_KFloat (*component4)(libshared_kref_raytracerchallenge_shadingimpl_Material thiz);
            libshared_KFloat (*component5)(libshared_kref_raytracerchallenge_shadingimpl_Material thiz);
            libshared_kref_raytracerchallenge_shadingimpl_Material (*copy)(libshared_kref_raytracerchallenge_shadingimpl_Material thiz, libshared_kref_raytracerchallenge_tupleimpl_Tuple color, libshared_KFloat ambient, libshared_KFloat diffuse, libshared_KFloat specular, libshared_KFloat shininess);
            libshared_KBoolean (*equals)(libshared_kref_raytracerchallenge_shadingimpl_Material thiz, libshared_kref_kotlin_Any other);
            libshared_KInt (*hashCode)(libshared_kref_raytracerchallenge_shadingimpl_Material thiz);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*lighting)(libshared_kref_raytracerchallenge_shadingimpl_Material thiz, libshared_kref_raytracerchallenge_shadingimpl_PointLight light, libshared_kref_raytracerchallenge_tupleimpl_Tuple position, libshared_kref_raytracerchallenge_tupleimpl_Tuple eyeVector, libshared_kref_raytracerchallenge_tupleimpl_Tuple normal, libshared_KBoolean inShadow);
            const char* (*toString)(libshared_kref_raytracerchallenge_shadingimpl_Material thiz);
          } Material;
          struct {
            libshared_KType* (*_type)(void);
            libshared_kref_raytracerchallenge_shadingimpl_PointLight (*PointLight)(libshared_kref_raytracerchallenge_tupleimpl_Tuple position, libshared_kref_raytracerchallenge_tupleimpl_Tuple intensity);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*get_intensity)(libshared_kref_raytracerchallenge_shadingimpl_PointLight thiz);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*get_position)(libshared_kref_raytracerchallenge_shadingimpl_PointLight thiz);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*component1)(libshared_kref_raytracerchallenge_shadingimpl_PointLight thiz);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*component2)(libshared_kref_raytracerchallenge_shadingimpl_PointLight thiz);
            libshared_kref_raytracerchallenge_shadingimpl_PointLight (*copy)(libshared_kref_raytracerchallenge_shadingimpl_PointLight thiz, libshared_kref_raytracerchallenge_tupleimpl_Tuple position, libshared_kref_raytracerchallenge_tupleimpl_Tuple intensity);
            libshared_KBoolean (*equals)(libshared_kref_raytracerchallenge_shadingimpl_PointLight thiz, libshared_kref_kotlin_Any other);
            libshared_KInt (*hashCode)(libshared_kref_raytracerchallenge_shadingimpl_PointLight thiz);
            const char* (*toString)(libshared_kref_raytracerchallenge_shadingimpl_PointLight thiz);
          } PointLight;
        } shadingimpl;
        struct {
          libshared_KFloat (*get_EPSILON)();
          libshared_KFloat (*approxCos)(libshared_KFloat rawRadians);
          libshared_KFloat (*approxSin)(libshared_KFloat rawRadians);
          libshared_kref_raytracerchallenge_tupleimpl_Tuple (*blend)(libshared_kref_raytracerchallenge_tupleimpl_Tuple tupleA, libshared_kref_raytracerchallenge_tupleimpl_Tuple tupleB);
          libshared_kref_raytracerchallenge_tupleimpl_Tuple (*cross)(libshared_kref_raytracerchallenge_tupleimpl_Tuple tupleA, libshared_kref_raytracerchallenge_tupleimpl_Tuple tupleB);
          libshared_KFloat (*dot)(libshared_kref_raytracerchallenge_tupleimpl_Tuple tupleA, libshared_kref_raytracerchallenge_tupleimpl_Tuple tupleB);
          libshared_KBoolean (*equalsFloat)(libshared_KFloat aFloat, libshared_KFloat otherFloat);
          libshared_KBoolean (*isOne)(libshared_KFloat aFloat);
          libshared_KBoolean (*isPoint)(libshared_kref_raytracerchallenge_tupleimpl_Tuple aTuple);
          libshared_KBoolean (*isVector)(libshared_kref_raytracerchallenge_tupleimpl_Tuple aTuple);
          libshared_KBoolean (*isZero)(libshared_KFloat aFloat);
          libshared_KFloat (*magnitude)(libshared_kref_raytracerchallenge_tupleimpl_Tuple aTuple);
          libshared_kref_raytracerchallenge_tupleimpl_Tuple (*makeColor)(libshared_KFloat r, libshared_KFloat g, libshared_KFloat b);
          libshared_kref_raytracerchallenge_tupleimpl_Tuple (*makeDiagonalVector)(libshared_KFloat k);
          libshared_kref_raytracerchallenge_tupleimpl_Tuple (*makeOpaqueColor)(libshared_kref_raytracerchallenge_tupleimpl_Tuple aColor);
          libshared_kref_raytracerchallenge_tupleimpl_Tuple (*makePoint)(libshared_KFloat x, libshared_KFloat y, libshared_KFloat z);
          libshared_kref_raytracerchallenge_tupleimpl_Tuple (*makePointX)(libshared_KFloat x);
          libshared_kref_raytracerchallenge_tupleimpl_Tuple (*makePointY)(libshared_KFloat y);
          libshared_kref_raytracerchallenge_tupleimpl_Tuple (*makePointZ)(libshared_KFloat z);
          libshared_kref_raytracerchallenge_tupleimpl_Tuple (*makeVector)(libshared_KFloat x, libshared_KFloat y, libshared_KFloat z);
          libshared_kref_raytracerchallenge_tupleimpl_Tuple (*makeVectorX)(libshared_KFloat x);
          libshared_kref_raytracerchallenge_tupleimpl_Tuple (*makeVectorY)(libshared_KFloat y);
          libshared_kref_raytracerchallenge_tupleimpl_Tuple (*makeVectorZ)(libshared_KFloat z);
          libshared_kref_raytracerchallenge_tupleimpl_Tuple (*normalized)(libshared_kref_raytracerchallenge_tupleimpl_Tuple aTuple);
          libshared_kref_raytracerchallenge_tupleimpl_Tuple (*times)(libshared_KFloat thiz, libshared_kref_raytracerchallenge_tupleimpl_Tuple aTuple);
          struct {
            libshared_KType* (*_type)(void);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*Tuple)(libshared_KFloat x, libshared_KFloat y, libshared_KFloat z, libshared_KFloat w);
            libshared_KFloat (*get_w)(libshared_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libshared_KFloat (*get_x)(libshared_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libshared_KFloat (*get_y)(libshared_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libshared_KFloat (*get_z)(libshared_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libshared_KFloat (*alpha)(libshared_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libshared_KInt (*alphaInt)(libshared_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libshared_KFloat (*blue)(libshared_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libshared_KInt (*blueInt)(libshared_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libshared_KFloat (*component1)(libshared_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libshared_KFloat (*component2)(libshared_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libshared_KFloat (*component3)(libshared_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libshared_KFloat (*component4)(libshared_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*copy)(libshared_kref_raytracerchallenge_tupleimpl_Tuple thiz, libshared_KFloat x, libshared_KFloat y, libshared_KFloat z, libshared_KFloat w);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*div)(libshared_kref_raytracerchallenge_tupleimpl_Tuple thiz, libshared_KFloat scalar);
            libshared_KBoolean (*equals)(libshared_kref_raytracerchallenge_tupleimpl_Tuple thiz, libshared_kref_kotlin_Any other);
            libshared_KBoolean (*equals_)(libshared_kref_raytracerchallenge_tupleimpl_Tuple thiz, libshared_kref_raytracerchallenge_tupleimpl_Tuple other);
            libshared_KFloat (*green)(libshared_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libshared_KInt (*greenInt)(libshared_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libshared_KInt (*hashCode)(libshared_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libshared_KFloat (*magnitude)(libshared_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*minus)(libshared_kref_raytracerchallenge_tupleimpl_Tuple thiz, libshared_kref_raytracerchallenge_tupleimpl_Tuple aTuple);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*plus)(libshared_kref_raytracerchallenge_tupleimpl_Tuple thiz, libshared_kref_raytracerchallenge_tupleimpl_Tuple aTuple);
            libshared_KFloat (*red)(libshared_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libshared_KInt (*redInt)(libshared_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*times)(libshared_kref_raytracerchallenge_tupleimpl_Tuple thiz, libshared_KFloat scalar);
            const char* (*toString)(libshared_kref_raytracerchallenge_tupleimpl_Tuple thiz);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*unaryMinus)(libshared_kref_raytracerchallenge_tupleimpl_Tuple thiz);
          } Tuple;
        } tupleimpl;
        struct {
          libshared_KBoolean (*isShadowed)(libshared_kref_raytracerchallenge_worldimpl_World world, libshared_kref_raytracerchallenge_tupleimpl_Tuple point);
          struct {
            libshared_KType* (*_type)(void);
            libshared_kref_raytracerchallenge_worldimpl_Computations (*Computations)(libshared_kref_raytracerchallenge_raysimpl_Intersection intersection, libshared_kref_raytracerchallenge_raysimpl_Ray ray);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*get_eyeVector)(libshared_kref_raytracerchallenge_worldimpl_Computations thiz);
            libshared_KBoolean (*get_inside)(libshared_kref_raytracerchallenge_worldimpl_Computations thiz);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*get_normalVector)(libshared_kref_raytracerchallenge_worldimpl_Computations thiz);
            libshared_kref_raytracerchallenge_raysimpl_Shape (*get_obj)(libshared_kref_raytracerchallenge_worldimpl_Computations thiz);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*get_overPoint)(libshared_kref_raytracerchallenge_worldimpl_Computations thiz);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*get_point)(libshared_kref_raytracerchallenge_worldimpl_Computations thiz);
            libshared_KFloat (*get_tVal)(libshared_kref_raytracerchallenge_worldimpl_Computations thiz);
          } Computations;
          struct {
            libshared_KType* (*_type)(void);
            libshared_kref_raytracerchallenge_worldimpl_World (*World)(libshared_kref_raytracerchallenge_shadingimpl_PointLight light, libshared_kref_kotlin_Array shapes);
            libshared_kref_raytracerchallenge_shadingimpl_PointLight (*get_light)(libshared_kref_raytracerchallenge_worldimpl_World thiz);
            libshared_kref_kotlin_Array (*get_shapes)(libshared_kref_raytracerchallenge_worldimpl_World thiz);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*colorAt)(libshared_kref_raytracerchallenge_worldimpl_World thiz, libshared_kref_raytracerchallenge_raysimpl_Ray ray);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*colorAt_)(libshared_kref_raytracerchallenge_worldimpl_World thiz, libshared_kref_raytracerchallenge_raysimpl_Ray ray, libshared_KBoolean useShadow);
            libshared_kref_raytracerchallenge_shadingimpl_PointLight (*component1)(libshared_kref_raytracerchallenge_worldimpl_World thiz);
            libshared_kref_kotlin_Array (*component2)(libshared_kref_raytracerchallenge_worldimpl_World thiz);
            libshared_kref_raytracerchallenge_worldimpl_World (*copy)(libshared_kref_raytracerchallenge_worldimpl_World thiz, libshared_kref_raytracerchallenge_shadingimpl_PointLight light, libshared_kref_kotlin_Array shapes);
            libshared_KBoolean (*equals)(libshared_kref_raytracerchallenge_worldimpl_World thiz, libshared_kref_kotlin_Any other);
            libshared_KBoolean (*equals_)(libshared_kref_raytracerchallenge_worldimpl_World thiz, libshared_kref_raytracerchallenge_worldimpl_World world);
            libshared_KInt (*hashCode)(libshared_kref_raytracerchallenge_worldimpl_World thiz);
            libshared_kref_kotlin_Array (*intersect)(libshared_kref_raytracerchallenge_worldimpl_World thiz, libshared_kref_raytracerchallenge_raysimpl_Ray ray);
            libshared_KBoolean (*isShadowed)(libshared_kref_raytracerchallenge_worldimpl_World thiz, libshared_kref_raytracerchallenge_tupleimpl_Tuple point);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*shadeHit)(libshared_kref_raytracerchallenge_worldimpl_World thiz, libshared_kref_raytracerchallenge_worldimpl_Computations comps);
            libshared_kref_raytracerchallenge_tupleimpl_Tuple (*shadeHit_)(libshared_kref_raytracerchallenge_worldimpl_World thiz, libshared_kref_raytracerchallenge_worldimpl_Computations comps, libshared_KBoolean useShadows);
            const char* (*toString)(libshared_kref_raytracerchallenge_worldimpl_World thiz);
          } World;
        } worldimpl;
      } raytracerchallenge;
    } root;
  } kotlin;
} libshared_ExportedSymbols;
extern libshared_ExportedSymbols* libshared_symbols(void);
#ifdef __cplusplus
}  /* extern "C" */
#endif
#endif  /* KONAN_LIBSHARED_H */
