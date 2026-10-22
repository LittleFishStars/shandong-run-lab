package com.google.android.inner_exoplayer2.video.spherical;

import com.google.android.inner_exoplayer2.util.Assertions;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
final class Projection {
    public static final int DRAW_MODE_TRIANGLES = 0;
    public static final int DRAW_MODE_TRIANGLES_FAN = 2;
    public static final int DRAW_MODE_TRIANGLES_STRIP = 1;
    public static final int POSITION_COORDS_PER_VERTEX = 3;
    public static final int TEXTURE_COORDS_PER_VERTEX = 2;
    public final Mesh leftMesh;
    public final Mesh rightMesh;
    public final boolean singleMesh;
    public final int stereoMode;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface DrawMode {
    }

    public static final class Mesh {
        private final SubMesh[] subMeshes;

        public Mesh(SubMesh... subMeshArr) {
            this.subMeshes = subMeshArr;
        }

        public SubMesh getSubMesh(int i) {
            return this.subMeshes[i];
        }

        public int getSubMeshCount() {
            return this.subMeshes.length;
        }
    }

    public static final class SubMesh {
        public static final int VIDEO_TEXTURE_ID = 0;
        public final int mode;
        public final float[] textureCoords;
        public final int textureId;
        public final float[] vertices;

        public SubMesh(int i, float[] fArr, float[] fArr2, int i2) {
            this.textureId = i;
            Assertions.checkArgument(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.vertices = fArr;
            this.textureCoords = fArr2;
            this.mode = i2;
        }

        public int getVertexCount() {
            return this.vertices.length / 3;
        }
    }

    public Projection(Mesh mesh, int i) {
        this(mesh, mesh, i);
    }

    public static Projection createEquirectangular(int i) {
        return createEquirectangular(50.0f, 36, 72, 180.0f, 360.0f, i);
    }

    public Projection(Mesh mesh, Mesh mesh2, int i) {
        this.leftMesh = mesh;
        this.rightMesh = mesh2;
        this.stereoMode = i;
        this.singleMesh = mesh == mesh2;
    }

    public static Projection createEquirectangular(float f, int i, int i2, float f2, float f3, int i3) {
        int i4;
        int i5;
        int i6;
        float[] fArr;
        int i7;
        int i8 = i;
        int i9 = i2;
        Assertions.checkArgument(f > 0.0f);
        Assertions.checkArgument(i8 >= 1);
        Assertions.checkArgument(i9 >= 1);
        Assertions.checkArgument(f2 > 0.0f && f2 <= 180.0f);
        Assertions.checkArgument(f3 > 0.0f && f3 <= 360.0f);
        float radians = (float) Math.toRadians(f2);
        float radians2 = (float) Math.toRadians(f3);
        float f4 = radians / i8;
        float f5 = radians2 / i9;
        int i10 = i9 + 1;
        int i11 = ((i10 * 2) + 2) * i8;
        float[] fArr2 = new float[i11 * 3];
        float[] fArr3 = new float[i11 * 2];
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < i8) {
            float f6 = radians / 2.0f;
            float f7 = (i12 * f4) - f6;
            int i15 = i12 + 1;
            float f8 = (i15 * f4) - f6;
            int i16 = 0;
            while (i16 < i10) {
                float f9 = f7;
                int i17 = i15;
                int i18 = 0;
                int i19 = 2;
                while (i18 < i19) {
                    float f10 = i16 * f5;
                    float f11 = f5;
                    int i20 = i16;
                    double d = f;
                    float f12 = f4;
                    double d2 = (f10 + 3.1415927f) - (radians2 / 2.0f);
                    int i21 = i18;
                    double d3 = i18 == 0 ? f9 : f8;
                    float[] fArr4 = fArr3;
                    float f13 = f8;
                    fArr2[i13] = -((float) (Math.sin(d2) * d * Math.cos(d3)));
                    float f14 = radians;
                    float f15 = radians2;
                    fArr2[i13 + 1] = (float) (d * Math.sin(d3));
                    int i22 = i13 + 3;
                    fArr2[i13 + 2] = (float) (d * Math.cos(d2) * Math.cos(d3));
                    fArr4[i14] = f10 / f15;
                    int i23 = i14 + 2;
                    fArr4[i14 + 1] = ((i12 + i21) * f12) / f14;
                    if (i20 == 0 && i21 == 0) {
                        i4 = i2;
                        i5 = i20;
                        i6 = i21;
                    } else {
                        i4 = i2;
                        i5 = i20;
                        i6 = i21;
                        if (i5 != i4 || i6 != 1) {
                            fArr = fArr4;
                            i7 = 2;
                            i14 = i23;
                            i13 = i22;
                        }
                        int i24 = i6 + 1;
                        fArr3 = fArr;
                        i19 = i7;
                        radians = f14;
                        i10 = i10;
                        f5 = f11;
                        f4 = f12;
                        f8 = f13;
                        i18 = i24;
                        i9 = i4;
                        i16 = i5;
                        radians2 = f15;
                    }
                    System.arraycopy(fArr2, i13, fArr2, i22, 3);
                    i13 += 6;
                    fArr = fArr4;
                    i7 = 2;
                    System.arraycopy(fArr, i14, fArr, i23, 2);
                    i14 += 4;
                    int i25 = i6 + 1;
                    fArr3 = fArr;
                    i19 = i7;
                    radians = f14;
                    i10 = i10;
                    f5 = f11;
                    f4 = f12;
                    f8 = f13;
                    i18 = i25;
                    i9 = i4;
                    i16 = i5;
                    radians2 = f15;
                }
                float f16 = radians2;
                int i26 = i16;
                int i27 = i9;
                int i28 = i26 + 1;
                f7 = f9;
                i15 = i17;
                f5 = f5;
                radians2 = f16;
                f8 = f8;
                i9 = i27;
                i16 = i28;
            }
            i8 = i;
            i12 = i15;
        }
        return new Projection(new Mesh(new SubMesh(0, fArr2, fArr3, 1)), i3);
    }
}
