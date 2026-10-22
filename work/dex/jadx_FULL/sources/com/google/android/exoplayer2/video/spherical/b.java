package com.google.android.exoplayer2.video.spherical;

import android.opengl.GLES20;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.GlUtil;
import com.zj.adlib.hu3;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f31194a = "uniform mat4 uMvpMatrix;\nuniform mat3 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec2 aTexCoords;\nvarying vec2 vTexCoords;\n// Standard transformation.\nvoid main() {\n  gl_Position = uMvpMatrix * aPosition;\n  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;\n}\n";
    public static final String b = "// This is required since the texture data is GL_TEXTURE_EXTERNAL_OES.\n#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n// Standard texture rendering shader.\nuniform samplerExternalOES uTexture;\nvarying vec2 vTexCoords;\nvoid main() {\n  gl_FragColor = texture2D(uTexture, vTexCoords);\n}\n";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f5395a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public a f5396a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public hu3 f5397a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f5398b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public a f5399b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f5400c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public int f5401d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public int f5402e;
    public int f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final float[] f5393a = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final float[] f5394b = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};
    public static final float[] c = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 1.0f, 1.0f};
    public static final float[] d = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};
    public static final float[] e = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.5f, 1.0f, 1.0f};

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31195a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final FloatBuffer f5403a;
        public final int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final FloatBuffer f5404b;

        public a(Projection.b bVar) {
            this.f31195a = bVar.a();
            this.f5403a = GlUtil.i(bVar.f5371a);
            this.f5404b = GlUtil.i(bVar.f5372b);
            int i = bVar.b;
            if (i == 1) {
                this.b = 5;
            } else if (i != 2) {
                this.b = 4;
            } else {
                this.b = 6;
            }
        }
    }

    public static boolean c(Projection projection) {
        Projection.a aVar = projection.f5368a;
        Projection.a aVar2 = projection.f5370b;
        return aVar.b() == 1 && aVar.a(0).f31189a == 0 && aVar2.b() == 1 && aVar2.a(0).f31189a == 0;
    }

    public void a(int i, float[] fArr, boolean z) {
        float[] fArr2;
        a aVar = z ? this.f5399b : this.f5396a;
        if (aVar == null) {
            return;
        }
        int i2 = this.f5395a;
        if (i2 == 1) {
            fArr2 = z ? c : f5394b;
        } else if (i2 == 2) {
            fArr2 = z ? e : d;
        } else {
            fArr2 = f5393a;
        }
        GLES20.glUniformMatrix3fv(this.f5400c, 1, false, fArr2, 0);
        GLES20.glUniformMatrix4fv(this.f5398b, 1, false, fArr, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i);
        GLES20.glUniform1i(this.f, 0);
        GlUtil.g();
        GLES20.glVertexAttribPointer(this.f5401d, 3, 5126, false, 12, (Buffer) aVar.f5403a);
        GlUtil.g();
        GLES20.glVertexAttribPointer(this.f5402e, 2, 5126, false, 8, (Buffer) aVar.f5404b);
        GlUtil.g();
        GLES20.glDrawArrays(aVar.b, 0, aVar.f31195a);
        GlUtil.g();
    }

    public void b() {
        hu3 hu3Var = new hu3(f31194a, b);
        this.f5397a = hu3Var;
        this.f5398b = hu3Var.k("uMvpMatrix");
        this.f5400c = this.f5397a.k("uTexMatrix");
        this.f5401d = this.f5397a.f("aPosition");
        this.f5402e = this.f5397a.f("aTexCoords");
        this.f = this.f5397a.k("uTexture");
    }

    public void d(Projection projection) {
        if (c(projection)) {
            this.f5395a = projection.f31187a;
            a aVar = new a(projection.f5368a.a(0));
            this.f5396a = aVar;
            if (!projection.f5369a) {
                aVar = new a(projection.f5370b.a(0));
            }
            this.f5399b = aVar;
        }
    }

    public void e() {
        hu3 hu3Var = this.f5397a;
        if (hu3Var != null) {
            hu3Var.delete();
        }
    }
}
