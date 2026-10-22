package com.zj.adlib;

import android.graphics.Matrix;
import android.graphics.Path;
import androidx.annotation.NonNull;
import androidx.camera.video.AudioStats;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class bn6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f40782a = "PathParser";

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f40783a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f15574a;

        public b() {
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public char f40784a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public float[] f15575a;

        public c(char c, float[] fArr) {
            this.f40784a = c;
            this.f15575a = fArr;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void a(Path path, float[] fArr, char c, char c2, float[] fArr2) {
            int i;
            int i2;
            int i3;
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            char c3 = c2;
            boolean z = false;
            float f9 = fArr[0];
            float f10 = fArr[1];
            float f11 = fArr[2];
            float f12 = fArr[3];
            float f13 = fArr[4];
            float f14 = fArr[5];
            switch (c3) {
                case 'A':
                case 'a':
                    i = 7;
                    i2 = i;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    i2 = i;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i2 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i2 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i2 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f13, f14);
                    f9 = f13;
                    f11 = f9;
                    f10 = f14;
                    f12 = f10;
                    i2 = 2;
                    break;
            }
            float f15 = f9;
            float f16 = f10;
            float f17 = f13;
            float f18 = f14;
            int i4 = 0;
            char c4 = c;
            while (i4 < fArr2.length) {
                if (c3 != 'A') {
                    if (c3 == 'C') {
                        i3 = i4;
                        int i5 = i3 + 2;
                        int i6 = i3 + 3;
                        int i7 = i3 + 4;
                        int i8 = i3 + 5;
                        path.cubicTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i5], fArr2[i6], fArr2[i7], fArr2[i8]);
                        f15 = fArr2[i7];
                        float f19 = fArr2[i8];
                        float f20 = fArr2[i5];
                        float f21 = fArr2[i6];
                        f16 = f19;
                        f12 = f21;
                        f11 = f20;
                    } else if (c3 == 'H') {
                        i3 = i4;
                        int i9 = i3 + 0;
                        path.lineTo(fArr2[i9], f16);
                        f15 = fArr2[i9];
                    } else if (c3 == 'Q') {
                        i3 = i4;
                        int i10 = i3 + 0;
                        int i11 = i3 + 1;
                        int i12 = i3 + 2;
                        int i13 = i3 + 3;
                        path.quadTo(fArr2[i10], fArr2[i11], fArr2[i12], fArr2[i13]);
                        float f22 = fArr2[i10];
                        float f23 = fArr2[i11];
                        f15 = fArr2[i12];
                        f16 = fArr2[i13];
                        f11 = f22;
                        f12 = f23;
                    } else if (c3 == 'V') {
                        i3 = i4;
                        int i14 = i3 + 0;
                        path.lineTo(f15, fArr2[i14]);
                        f16 = fArr2[i14];
                    } else if (c3 != 'a') {
                        if (c3 != 'c') {
                            if (c3 == 'h') {
                                int i15 = i4 + 0;
                                path.rLineTo(fArr2[i15], 0.0f);
                                f15 += fArr2[i15];
                            } else if (c3 != 'q') {
                                if (c3 == 'v') {
                                    int i16 = i4 + 0;
                                    path.rLineTo(0.0f, fArr2[i16]);
                                    f4 = fArr2[i16];
                                } else if (c3 == 'L') {
                                    int i17 = i4 + 0;
                                    int i18 = i4 + 1;
                                    path.lineTo(fArr2[i17], fArr2[i18]);
                                    f15 = fArr2[i17];
                                    f16 = fArr2[i18];
                                } else if (c3 == 'M') {
                                    f15 = fArr2[i4 + 0];
                                    f16 = fArr2[i4 + 1];
                                    if (i4 > 0) {
                                        path.lineTo(f15, f16);
                                    } else {
                                        path.moveTo(f15, f16);
                                        i3 = i4;
                                        f18 = f16;
                                        f17 = f15;
                                    }
                                } else if (c3 == 'S') {
                                    if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                        f15 = (f15 * 2.0f) - f11;
                                        f16 = (f16 * 2.0f) - f12;
                                    }
                                    float f24 = f16;
                                    int i19 = i4 + 0;
                                    int i20 = i4 + 1;
                                    int i21 = i4 + 2;
                                    int i22 = i4 + 3;
                                    path.cubicTo(f15, f24, fArr2[i19], fArr2[i20], fArr2[i21], fArr2[i22]);
                                    f = fArr2[i19];
                                    f2 = fArr2[i20];
                                    f15 = fArr2[i21];
                                    f16 = fArr2[i22];
                                    f11 = f;
                                    f12 = f2;
                                } else if (c3 == 'T') {
                                    if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                        f15 = (f15 * 2.0f) - f11;
                                        f16 = (f16 * 2.0f) - f12;
                                    }
                                    int i23 = i4 + 0;
                                    int i24 = i4 + 1;
                                    path.quadTo(f15, f16, fArr2[i23], fArr2[i24]);
                                    float f25 = fArr2[i23];
                                    float f26 = fArr2[i24];
                                    i3 = i4;
                                    f12 = f16;
                                    f11 = f15;
                                    f15 = f25;
                                    f16 = f26;
                                } else if (c3 == 'l') {
                                    int i25 = i4 + 0;
                                    int i26 = i4 + 1;
                                    path.rLineTo(fArr2[i25], fArr2[i26]);
                                    f15 += fArr2[i25];
                                    f4 = fArr2[i26];
                                } else if (c3 == 'm') {
                                    float f27 = fArr2[i4 + 0];
                                    f15 += f27;
                                    float f28 = fArr2[i4 + 1];
                                    f16 += f28;
                                    if (i4 > 0) {
                                        path.rLineTo(f27, f28);
                                    } else {
                                        path.rMoveTo(f27, f28);
                                        i3 = i4;
                                        f18 = f16;
                                        f17 = f15;
                                    }
                                } else if (c3 == 's') {
                                    if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                        float f29 = f15 - f11;
                                        f5 = f16 - f12;
                                        f6 = f29;
                                    } else {
                                        f6 = 0.0f;
                                        f5 = 0.0f;
                                    }
                                    int i27 = i4 + 0;
                                    int i28 = i4 + 1;
                                    int i29 = i4 + 2;
                                    int i30 = i4 + 3;
                                    path.rCubicTo(f6, f5, fArr2[i27], fArr2[i28], fArr2[i29], fArr2[i30]);
                                    f = fArr2[i27] + f15;
                                    f2 = fArr2[i28] + f16;
                                    f15 += fArr2[i29];
                                    f3 = fArr2[i30];
                                } else if (c3 == 't') {
                                    if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                        f7 = f15 - f11;
                                        f8 = f16 - f12;
                                    } else {
                                        f8 = 0.0f;
                                        f7 = 0.0f;
                                    }
                                    int i31 = i4 + 0;
                                    int i32 = i4 + 1;
                                    path.rQuadTo(f7, f8, fArr2[i31], fArr2[i32]);
                                    float f30 = f7 + f15;
                                    float f31 = f8 + f16;
                                    f15 += fArr2[i31];
                                    f16 += fArr2[i32];
                                    f12 = f31;
                                    f11 = f30;
                                }
                                f16 += f4;
                            } else {
                                int i33 = i4 + 0;
                                int i34 = i4 + 1;
                                int i35 = i4 + 2;
                                int i36 = i4 + 3;
                                path.rQuadTo(fArr2[i33], fArr2[i34], fArr2[i35], fArr2[i36]);
                                f = fArr2[i33] + f15;
                                f2 = fArr2[i34] + f16;
                                f15 += fArr2[i35];
                                f3 = fArr2[i36];
                            }
                            i3 = i4;
                        } else {
                            int i37 = i4 + 2;
                            int i38 = i4 + 3;
                            int i39 = i4 + 4;
                            int i40 = i4 + 5;
                            path.rCubicTo(fArr2[i4 + 0], fArr2[i4 + 1], fArr2[i37], fArr2[i38], fArr2[i39], fArr2[i40]);
                            f = fArr2[i37] + f15;
                            f2 = fArr2[i38] + f16;
                            f15 += fArr2[i39];
                            f3 = fArr2[i40];
                        }
                        f16 += f3;
                        f11 = f;
                        f12 = f2;
                        i3 = i4;
                    } else {
                        int i41 = i4 + 5;
                        int i42 = i4 + 6;
                        i3 = i4;
                        c(path, f15, f16, fArr2[i41] + f15, fArr2[i42] + f16, fArr2[i4 + 0], fArr2[i4 + 1], fArr2[i4 + 2], fArr2[i4 + 3] != 0.0f, fArr2[i4 + 4] != 0.0f);
                        f15 += fArr2[i41];
                        f16 += fArr2[i42];
                    }
                    i4 = i3 + i2;
                    c4 = c2;
                    c3 = c4;
                    z = false;
                } else {
                    i3 = i4;
                    int i43 = i3 + 5;
                    int i44 = i3 + 6;
                    c(path, f15, f16, fArr2[i43], fArr2[i44], fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3] != 0.0f, fArr2[i3 + 4] != 0.0f);
                    f15 = fArr2[i43];
                    f16 = fArr2[i44];
                }
                f12 = f16;
                f11 = f15;
                i4 = i3 + i2;
                c4 = c2;
                c3 = c4;
                z = false;
            }
            fArr[z ? 1 : 0] = f15;
            fArr[1] = f16;
            fArr[2] = f11;
            fArr[3] = f12;
            fArr[4] = f17;
            fArr[5] = f18;
        }

        public static void b(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            double d10 = d3;
            int iCeil = (int) Math.ceil(Math.abs((d9 * 4.0d) / 3.141592653589793d));
            double dCos = Math.cos(d7);
            double dSin = Math.sin(d7);
            double dCos2 = Math.cos(d8);
            double dSin2 = Math.sin(d8);
            double d11 = -d10;
            double d12 = d11 * dCos;
            double d13 = d4 * dSin;
            double d14 = (d12 * dSin2) - (d13 * dCos2);
            double d15 = d11 * dSin;
            double d16 = d4 * dCos;
            double d17 = (dSin2 * d15) + (dCos2 * d16);
            double d18 = d9 / ((double) iCeil);
            double d19 = d17;
            double d20 = d14;
            int i = 0;
            double d21 = d5;
            double d22 = d6;
            double d23 = d8;
            while (i < iCeil) {
                double d24 = d23 + d18;
                double dSin3 = Math.sin(d24);
                double dCos3 = Math.cos(d24);
                double d25 = (d + ((d10 * dCos) * dCos3)) - (d13 * dSin3);
                double d26 = d2 + (d10 * dSin * dCos3) + (d16 * dSin3);
                double d27 = (d12 * dSin3) - (d13 * dCos3);
                double d28 = (dSin3 * d15) + (dCos3 * d16);
                double d29 = d24 - d23;
                double dTan = Math.tan(d29 / 2.0d);
                double dSin4 = (Math.sin(d29) * (Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d)) / 3.0d;
                double d30 = d21 + (d20 * dSin4);
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) d30, (float) (d22 + (d19 * dSin4)), (float) (d25 - (dSin4 * d27)), (float) (d26 - (dSin4 * d28)), (float) d25, (float) d26);
                i++;
                d18 = d18;
                dSin = dSin;
                d21 = d25;
                d15 = d15;
                dCos = dCos;
                d23 = d24;
                d19 = d28;
                d20 = d27;
                iCeil = iCeil;
                d22 = d26;
                d10 = d3;
            }
        }

        public static void c(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            double d2;
            double radians = Math.toRadians(f7);
            double dCos = Math.cos(radians);
            double dSin = Math.sin(radians);
            double d3 = f;
            double d4 = d3 * dCos;
            double d5 = f2;
            double d6 = f5;
            double d7 = (d4 + (d5 * dSin)) / d6;
            double d8 = (((double) (-f)) * dSin) + (d5 * dCos);
            double d9 = f6;
            double d10 = d8 / d9;
            double d11 = f4;
            double d12 = ((((double) f3) * dCos) + (d11 * dSin)) / d6;
            double d13 = ((((double) (-f3)) * dSin) + (d11 * dCos)) / d9;
            double d14 = d7 - d12;
            double d15 = d10 - d13;
            double d16 = (d7 + d12) / 2.0d;
            double d17 = (d10 + d13) / 2.0d;
            double d18 = (d14 * d14) + (d15 * d15);
            if (d18 == AudioStats.AUDIO_AMPLITUDE_NONE) {
                return;
            }
            double d19 = (1.0d / d18) - 0.25d;
            if (d19 < AudioStats.AUDIO_AMPLITUDE_NONE) {
                float fSqrt = (float) (Math.sqrt(d18) / 1.99999d);
                c(path, f, f2, f3, f4, f5 * fSqrt, f6 * fSqrt, f7, z, z2);
                return;
            }
            double dSqrt = Math.sqrt(d19);
            double d20 = d14 * dSqrt;
            double d21 = dSqrt * d15;
            if (z == z2) {
                d = d16 - d21;
                d2 = d17 + d20;
            } else {
                d = d16 + d21;
                d2 = d17 - d20;
            }
            double dAtan2 = Math.atan2(d10 - d2, d7 - d);
            double dAtan3 = Math.atan2(d13 - d2, d12 - d) - dAtan2;
            if (z2 != (dAtan3 >= AudioStats.AUDIO_AMPLITUDE_NONE)) {
                dAtan3 = dAtan3 > AudioStats.AUDIO_AMPLITUDE_NONE ? dAtan3 - 6.283185307179586d : dAtan3 + 6.283185307179586d;
            }
            double d22 = d * d6;
            double d23 = d2 * d9;
            b(path, (d22 * dCos) - (d23 * dSin), (d22 * dSin) + (d23 * dCos), d6, d9, d3, d5, radians, dAtan2, dAtan3);
        }

        public static void d(c[] cVarArr, Path path) {
            float[] fArr = new float[6];
            char c = 'm';
            for (c cVar : cVarArr) {
                a(path, fArr, c, cVar.f40784a, cVar.f15575a);
                c = cVar.f40784a;
            }
        }
    }

    public static void a(List<c> list, char c2, float[] fArr) {
        list.add(new c(c2, fArr));
    }

    public static float[] b(@NonNull float[] fArr, int i, int i2) {
        int i3 = i2 - i;
        int iMin = Math.min(i3, fArr.length - i);
        float[] fArr2 = new float[i3];
        System.arraycopy(fArr, i, fArr2, 0, iMin);
        return fArr2;
    }

    public static c[] c(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int iG = g(str, i);
            String strTrim = str.substring(i2, iG).trim();
            if (strTrim.length() > 0) {
                a(arrayList, strTrim.charAt(0), f(strTrim));
            }
            i2 = iG;
            i = iG + 1;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            a(arrayList, str.charAt(i2), new float[0]);
        }
        return (c[]) arrayList.toArray(new c[0]);
    }

    public static Path d(String str) {
        Path path = new Path();
        c[] cVarArrC = c(str);
        if (cVarArrC == null) {
            return null;
        }
        try {
            c.d(cVarArrC, path);
            return path;
        } catch (RuntimeException e) {
            throw new RuntimeException("Error in parsing " + str, e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:21:0x0035  */
    public static void e(String str, int i, b bVar) {
        bVar.f15574a = false;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i2 = i; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == ' ') {
                z = false;
                z3 = true;
            } else if (cCharAt != 'E' && cCharAt != 'e') {
                switch (cCharAt) {
                    case ',':
                        z = false;
                        z3 = true;
                        break;
                    case '-':
                        if (i2 == i || z) {
                            z = false;
                        } else {
                            bVar.f15574a = true;
                            z = false;
                            z3 = true;
                        }
                        break;
                    case '.':
                        if (z2) {
                            bVar.f15574a = true;
                            z = false;
                            z3 = true;
                        } else {
                            z = false;
                            z2 = true;
                        }
                        break;
                    default:
                        z = false;
                        break;
                }
            } else {
                z = true;
            }
            if (z3) {
                bVar.f40783a = i2;
            }
        }
        bVar.f40783a = i2;
    }

    public static float[] f(String str) {
        int i = 1;
        if ((str.charAt(0) == 'z') || (str.charAt(0) == 'Z')) {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            b bVar = new b();
            int length = str.length();
            int i2 = 0;
            while (i < length) {
                e(str, i, bVar);
                int i3 = bVar.f40783a;
                if (i < i3) {
                    fArr[i2] = Float.parseFloat(str.substring(i, i3));
                    i2++;
                }
                i = bVar.f15574a ? i3 : i3 + 1;
            }
            return b(fArr, 0, i2);
        } catch (NumberFormatException e) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e);
        }
    }

    public static int g(String str, int i) {
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (((cCharAt - 'A') * (cCharAt - 'Z') <= 0 || (cCharAt - 'a') * (cCharAt - 'z') <= 0) && cCharAt != 'e' && cCharAt != 'E') {
                return i;
            }
            i++;
        }
        return i;
    }

    public static List<Path> h(float f, float f2, List<Path> list, List<String> list2) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2);
        ArrayList arrayList = new ArrayList();
        for (Path path : list) {
            Path path2 = new Path();
            path.transform(matrix, path2);
            arrayList.add(path2);
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x004b  */
    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:27:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0054  */
    /* JADX WARN: Code duplicated, block: B:59:0x009e  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:63:0x00aa  */
    public static void i(float f, float f2, char c2, float[] fArr) {
        int i;
        char c3 = 'H';
        if (c2 == 'A') {
            i = 7;
        } else if (c2 == 'C') {
            i = 6;
        } else if (c2 == 'H') {
            i = 1;
        } else if (c2 == 'Q') {
            i = 4;
        } else if (c2 == 'V') {
            i = 1;
        } else if (c2 == 'a') {
            i = 7;
        } else if (c2 == 'c') {
            i = 6;
        } else if (c2 == 'h') {
            i = 1;
        } else if (c2 == 'q') {
            i = 4;
        } else if (c2 != 'v') {
            i = 2;
            if (c2 != 'L' && c2 != 'M' && (c2 == 'S' || (c2 != 'T' && c2 != 'l' && c2 != 'm' && c2 == 's'))) {
                i = 4;
            }
        } else {
            i = 1;
        }
        int i2 = 0;
        while (i2 < fArr.length) {
            if (c2 == 'A') {
                fArr[i2] = fArr[i2] * f;
                int i3 = i2 + 1;
                fArr[i3] = fArr[i3] * f2;
                int i4 = i2 + 5;
                fArr[i4] = fArr[i4] * f;
                int i5 = i2 + 6;
                fArr[i5] = fArr[i5] * f2;
            } else if (c2 == 'C') {
                fArr[i2] = fArr[i2] * f;
                int i6 = i2 + 1;
                fArr[i6] = fArr[i6] * f2;
                int i7 = i2 + 2;
                fArr[i7] = fArr[i7] * f;
                int i8 = i2 + 3;
                fArr[i8] = fArr[i8] * f2;
                int i9 = i2 + 4;
                fArr[i9] = fArr[i9] * f;
                int i10 = i2 + 5;
                fArr[i10] = fArr[i10] * f2;
            } else if (c2 == c3) {
                fArr[i2] = fArr[i2] * f;
            } else if (c2 == 'Q') {
                fArr[i2] = fArr[i2] * f;
                int i11 = i2 + 1;
                fArr[i11] = fArr[i11] * f2;
                int i12 = i2 + 2;
                fArr[i12] = fArr[i12] * f;
                int i13 = i2 + 3;
                fArr[i13] = fArr[i13] * f2;
                fArr[i2] = fArr[i2] * f;
                int i14 = i2 + 1;
                fArr[i14] = fArr[i14] * f2;
                int i15 = i2 + 5;
                fArr[i15] = fArr[i15] * f;
                int i16 = i2 + 6;
                fArr[i16] = fArr[i16] * f2;
            } else if (c2 == 'V') {
                fArr[i2] = fArr[i2] * f2;
            } else if (c2 == 'a') {
                fArr[i2] = fArr[i2] * f;
                int i17 = i2 + 1;
                fArr[i17] = fArr[i17] * f2;
                int i18 = i2 + 5;
                fArr[i18] = fArr[i18] * f;
                int i19 = i2 + 6;
                fArr[i19] = fArr[i19] * f2;
            } else if (c2 == 'c') {
                fArr[i2] = fArr[i2] * f;
                int i20 = i2 + 1;
                fArr[i20] = fArr[i20] * f2;
                int i21 = i2 + 2;
                fArr[i21] = fArr[i21] * f;
                int i22 = i2 + 3;
                fArr[i22] = fArr[i22] * f2;
                int i23 = i2 + 4;
                fArr[i23] = fArr[i23] * f;
                int i110 = i2 + 5;
                fArr[i110] = fArr[i110] * f2;
            } else if (c2 != 'h') {
                if (c2 != 'q') {
                    if (c2 != 'v') {
                        if (c2 != 'L' && c2 != 'M') {
                            if (c2 != 'S') {
                                if (c2 != 'T' && c2 != 'l' && c2 != 'm') {
                                    if (c2 != 's') {
                                        if (c2 != 't') {
                                        }
                                    }
                                }
                            }
                        }
                        fArr[i2] = fArr[i2] * f;
                        int i24 = i2 + 1;
                        fArr[i24] = fArr[i24] * f2;
                    } else {
                        fArr[i2] = fArr[i2] * f2;
                    }
                }
                fArr[i2] = fArr[i2] * f;
                int i111 = i2 + 1;
                fArr[i111] = fArr[i111] * f2;
                int i112 = i2 + 2;
                fArr[i112] = fArr[i112] * f;
                int i113 = i2 + 3;
                fArr[i113] = fArr[i113] * f2;
                fArr[i2] = fArr[i2] * f;
                int i114 = i2 + 1;
                fArr[i114] = fArr[i114] * f2;
                int i115 = i2 + 5;
                fArr[i115] = fArr[i115] * f;
                int i116 = i2 + 6;
                fArr[i116] = fArr[i116] * f2;
            } else {
                fArr[i2] = fArr[i2] * f;
            }
            i2 += i;
            c3 = 'H';
        }
    }

    public static void j(float f, float f2, c[] cVarArr) {
        for (c cVar : cVarArr) {
            i(f, f2, cVar.f40784a, cVar.f15575a);
        }
    }
}
