package com.zj.adlib;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@TargetApi(16)
public class s49 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f44609a = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
    public static final String b = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    public static final float[] c = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    public static final int h = 4;
    public static final int i = 20;
    public static final int j = 0;
    public static final int k = 3;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f19509a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public FloatBuffer f19510a;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f19514c;
    public int d;
    public int e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float[] f19511a = new float[16];

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public float[] f19513b = new float[16];

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f19512b = -12345;

    public s49(int i2) {
        this.g = i2;
        float[] fArr = c;
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f19510a = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(fArr).position(0);
        Matrix.setIdentityM(this.f19513b, 0);
    }

    public void a(String str) {
        GLES20.glDeleteProgram(this.f19509a);
        int iC = c(f44609a, str);
        this.f19509a = iC;
        if (iC == 0) {
            throw new RuntimeException("failed creating program");
        }
    }

    public void b(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        throw new RuntimeException(str + ": glError " + iGlGetError);
    }

    public final int c(String str, String str2) {
        int iF;
        int iF2 = f(35633, str);
        if (iF2 == 0 || (iF = f(35632, str2)) == 0) {
            return 0;
        }
        int iGlCreateProgram = GLES20.glCreateProgram();
        b("glCreateProgram");
        if (iGlCreateProgram == 0) {
            return 0;
        }
        GLES20.glAttachShader(iGlCreateProgram, iF2);
        b("glAttachShader");
        GLES20.glAttachShader(iGlCreateProgram, iF);
        b("glAttachShader");
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return iGlCreateProgram;
        }
        GLES20.glDeleteProgram(iGlCreateProgram);
        return 0;
    }

    public void d(SurfaceTexture surfaceTexture, boolean z) {
        b("onDrawFrame start");
        surfaceTexture.getTransformMatrix(this.f19513b);
        if (z) {
            float[] fArr = this.f19513b;
            fArr[5] = -fArr[5];
            fArr[13] = 1.0f - fArr[13];
        }
        GLES20.glUseProgram(this.f19509a);
        b("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f19512b);
        this.f19510a.position(0);
        GLES20.glVertexAttribPointer(this.e, 3, 5126, false, 20, (Buffer) this.f19510a);
        b("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.e);
        b("glEnableVertexAttribArray maPositionHandle");
        this.f19510a.position(3);
        GLES20.glVertexAttribPointer(this.f, 2, 5126, false, 20, (Buffer) this.f19510a);
        b("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.f);
        b("glEnableVertexAttribArray maTextureHandle");
        GLES20.glUniformMatrix4fv(this.d, 1, false, this.f19513b, 0);
        GLES20.glUniformMatrix4fv(this.f19514c, 1, false, this.f19511a, 0);
        GLES20.glDrawArrays(5, 0, 4);
        b("glDrawArrays");
        GLES20.glFinish();
    }

    public int e() {
        return this.f19512b;
    }

    public final int f(int i2, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i2);
        b("glCreateShader type=" + i2);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    public void g() {
        int iC = c(f44609a, b);
        this.f19509a = iC;
        if (iC == 0) {
            throw new RuntimeException("failed creating program");
        }
        this.e = GLES20.glGetAttribLocation(iC, "aPosition");
        b("glGetAttribLocation aPosition");
        if (this.e == -1) {
            throw new RuntimeException("Could not get attrib location for aPosition");
        }
        this.f = GLES20.glGetAttribLocation(this.f19509a, "aTextureCoord");
        b("glGetAttribLocation aTextureCoord");
        if (this.f == -1) {
            throw new RuntimeException("Could not get attrib location for aTextureCoord");
        }
        this.f19514c = GLES20.glGetUniformLocation(this.f19509a, "uMVPMatrix");
        b("glGetUniformLocation uMVPMatrix");
        if (this.f19514c == -1) {
            throw new RuntimeException("Could not get attrib location for uMVPMatrix");
        }
        this.d = GLES20.glGetUniformLocation(this.f19509a, "uSTMatrix");
        b("glGetUniformLocation uSTMatrix");
        if (this.d == -1) {
            throw new RuntimeException("Could not get attrib location for uSTMatrix");
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i2 = iArr[0];
        this.f19512b = i2;
        GLES20.glBindTexture(36197, i2);
        b("glBindTexture mTextureID");
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        b("glTexParameter");
        Matrix.setIdentityM(this.f19511a, 0);
        int i3 = this.g;
        if (i3 != 0) {
            Matrix.rotateM(this.f19511a, 0, i3, 0.0f, 0.0f, 1.0f);
        }
    }
}
