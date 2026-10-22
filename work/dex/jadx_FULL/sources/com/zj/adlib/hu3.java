package com.zj.adlib;

import android.content.Context;
import android.opengl.GLES20;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.GlUtil;
import java.io.IOException;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class hu3 {
    public static final int b = 35815;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f42203a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<String, a> f17072a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a[] f17073a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b[] f17074a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Map<String, b> f17075b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f42204a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f17076a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Buffer f17077a;
        public final int b;
        public int c;

        public a(String str, int i, int i2) {
            this.f17076a = str;
            this.f42204a = i;
            this.b = i2;
        }

        public static a b(int i, int i2) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i, 35722, iArr, 0);
            int i3 = iArr[0];
            byte[] bArr = new byte[i3];
            GLES20.glGetActiveAttrib(i, i2, i3, new int[1], 0, new int[1], 0, new int[1], 0, bArr, 0);
            String str = new String(bArr, 0, hu3.i(bArr));
            return new a(str, i2, hu3.g(i, str));
        }

        public void a() {
            Buffer buffer = (Buffer) sb0.h(this.f17077a, "call setBuffer before bind");
            GLES20.glBindBuffer(34962, 0);
            GLES20.glVertexAttribPointer(this.b, this.c, 5126, false, 0, buffer);
            GLES20.glEnableVertexAttribArray(this.f42204a);
            GlUtil.g();
        }

        public void c(float[] fArr, int i) {
            this.f17077a = GlUtil.i(fArr);
            this.c = i;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f42205a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f17078a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final float[] f17079a = new float[16];
        public final int b;
        public int c;
        public int d;

        public b(String str, int i, int i2) {
            this.f17078a = str;
            this.f42205a = i;
            this.b = i2;
        }

        public static b b(int i, int i2) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i, 35719, iArr, 0);
            int[] iArr2 = new int[1];
            int i3 = iArr[0];
            byte[] bArr = new byte[i3];
            GLES20.glGetActiveUniform(i, i2, i3, new int[1], 0, new int[1], 0, iArr2, 0, bArr, 0);
            String str = new String(bArr, 0, hu3.i(bArr));
            return new b(str, hu3.j(i, str), iArr2[0]);
        }

        public void a() {
            switch (this.b) {
                case 5126:
                    GLES20.glUniform1fv(this.f42205a, 1, this.f17079a, 0);
                    GlUtil.g();
                    return;
                case 35664:
                    GLES20.glUniform2fv(this.f42205a, 1, this.f17079a, 0);
                    GlUtil.g();
                    return;
                case 35665:
                    GLES20.glUniform3fv(this.f42205a, 1, this.f17079a, 0);
                    GlUtil.g();
                    return;
                case 35675:
                    GLES20.glUniformMatrix3fv(this.f42205a, 1, false, this.f17079a, 0);
                    GlUtil.g();
                    return;
                case 35676:
                    GLES20.glUniformMatrix4fv(this.f42205a, 1, false, this.f17079a, 0);
                    GlUtil.g();
                    return;
                case 35678:
                case hu3.b /* 35815 */:
                case 36198:
                    if (this.c == 0) {
                        throw new IllegalStateException("No call to setSamplerTexId() before bind.");
                    }
                    GLES20.glActiveTexture(this.d + 33984);
                    GlUtil.g();
                    GlUtil.d(this.b == 35678 ? 3553 : 36197, this.c);
                    GLES20.glUniform1i(this.f42205a, this.d);
                    GlUtil.g();
                    return;
                default:
                    throw new IllegalStateException("Unexpected uniform type: " + this.b);
            }
        }

        public void c(float f) {
            this.f17079a[0] = f;
        }

        public void d(float[] fArr) {
            System.arraycopy(fArr, 0, this.f17079a, 0, fArr.length);
        }

        public void e(int i, int i2) {
            this.c = i;
            this.d = i2;
        }
    }

    public hu3(Context context, String str, String str2) throws IOException {
        this(GlUtil.F(context, str), GlUtil.F(context, str2));
    }

    public static void d(int i, int i2, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i2);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 1) {
            GlUtil.G(GLES20.glGetShaderInfoLog(iGlCreateShader) + ", source: " + str);
        }
        GLES20.glAttachShader(i, iGlCreateShader);
        GLES20.glDeleteShader(iGlCreateShader);
        GlUtil.g();
    }

    public static int g(int i, String str) {
        return GLES20.glGetAttribLocation(i, str);
    }

    public static int i(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] == 0) {
                return i;
            }
        }
        return bArr.length;
    }

    public static int j(int i, String str) {
        return GLES20.glGetUniformLocation(i, str);
    }

    public void delete() {
        GLES20.glDeleteProgram(this.f42203a);
        GlUtil.g();
    }

    public void e() {
        for (a aVar : this.f17073a) {
            aVar.a();
        }
        for (b bVar : this.f17074a) {
            bVar.a();
        }
    }

    public int f(String str) {
        int iH = h(str);
        GLES20.glEnableVertexAttribArray(iH);
        GlUtil.g();
        return iH;
    }

    public final int h(String str) {
        return g(this.f42203a, str);
    }

    public int k(String str) {
        return j(this.f42203a, str);
    }

    public void l(String str, float[] fArr, int i) {
        ((a) sb0.g(this.f17072a.get(str))).c(fArr, i);
    }

    public void m(String str, float f) {
        ((b) sb0.g(this.f17075b.get(str))).c(f);
    }

    public void n(String str, float[] fArr) {
        ((b) sb0.g(this.f17075b.get(str))).d(fArr);
    }

    public void o(String str, int i, int i2) {
        ((b) sb0.g(this.f17075b.get(str))).e(i, i2);
    }

    public void p() {
        GLES20.glUseProgram(this.f42203a);
        GlUtil.g();
    }

    public hu3(String str, String str2) {
        int iGlCreateProgram = GLES20.glCreateProgram();
        this.f42203a = iGlCreateProgram;
        GlUtil.g();
        d(iGlCreateProgram, 35633, str);
        d(iGlCreateProgram, 35632, str2);
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            GlUtil.G("Unable to link shader program: \n" + GLES20.glGetProgramInfoLog(iGlCreateProgram));
        }
        GLES20.glUseProgram(iGlCreateProgram);
        this.f17072a = new HashMap();
        int[] iArr2 = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35721, iArr2, 0);
        this.f17073a = new a[iArr2[0]];
        for (int i = 0; i < iArr2[0]; i++) {
            a aVarB = a.b(this.f42203a, i);
            this.f17073a[i] = aVarB;
            this.f17072a.put(aVarB.f17076a, aVarB);
        }
        this.f17075b = new HashMap();
        int[] iArr3 = new int[1];
        GLES20.glGetProgramiv(this.f42203a, 35718, iArr3, 0);
        this.f17074a = new b[iArr3[0]];
        for (int i2 = 0; i2 < iArr3[0]; i2++) {
            b bVarB = b.b(this.f42203a, i2);
            this.f17074a[i2] = bVarB;
            this.f17075b.put(bVarB.f17078a, bVarB);
        }
        GlUtil.g();
    }
}
