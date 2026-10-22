package com.google.android.exoplayer2.video;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.b;
import com.google.android.exoplayer2.util.GlUtil;
import com.zj.adlib.hu3;
import com.zj.adlib.sb0;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class VideoDecoderGLSurfaceView extends GLSurfaceView implements VideoDecoderOutputBufferRenderer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f31176a;

    public static final class a implements GLSurfaceView.Renderer {
        public static final String f = "varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n";
        public static final String g = "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n";
        public int K;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final GLSurfaceView f5325a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public b f5326a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public hu3 f5327a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static final float[] f5323a = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};
        public static final float[] b = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};
        public static final float[] c = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static final String[] f5324a = {"y_tex", "u_tex", "v_tex"};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final FloatBuffer f31177a = GlUtil.i(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int[] f5329a = new int[3];

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final int[] f5331b = new int[3];

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public final int[] f5332c = new int[3];
        public final int[] d = new int[3];

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final AtomicReference<b> f5328a = new AtomicReference<>();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final FloatBuffer[] f5330a = new FloatBuffer[3];

        public a(GLSurfaceView gLSurfaceView) {
            this.f5325a = gLSurfaceView;
            for (int i = 0; i < 3; i++) {
                int[] iArr = this.f5332c;
                this.d[i] = -1;
                iArr[i] = -1;
            }
        }

        public void a(b bVar) {
            b andSet = this.f5328a.getAndSet(bVar);
            if (andSet != null) {
                andSet.j();
            }
            this.f5325a.requestRender();
        }

        @RequiresNonNull({"program"})
        public final void b() {
            GLES20.glGenTextures(3, this.f5329a, 0);
            for (int i = 0; i < 3; i++) {
                GLES20.glUniform1i(this.f5327a.k(f5324a[i]), i);
                GLES20.glActiveTexture(33984 + i);
                GlUtil.d(3553, this.f5329a[i]);
            }
            GlUtil.g();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            b andSet = this.f5328a.getAndSet(null);
            if (andSet == null && this.f5326a == null) {
                return;
            }
            if (andSet != null) {
                b bVar = this.f5326a;
                if (bVar != null) {
                    bVar.j();
                }
                this.f5326a = andSet;
            }
            b bVar2 = (b) sb0.g(this.f5326a);
            float[] fArr = b;
            int i = bVar2.Q;
            if (i == 1) {
                fArr = f5323a;
            } else if (i == 3) {
                fArr = c;
            }
            GLES20.glUniformMatrix3fv(this.K, 1, false, fArr, 0);
            int[] iArr = (int[]) sb0.g(bVar2.f2606a);
            ByteBuffer[] byteBufferArr = (ByteBuffer[]) sb0.g(bVar2.f2607a);
            int i2 = 0;
            while (i2 < 3) {
                int i3 = i2 == 0 ? bVar2.P : (bVar2.P + 1) / 2;
                GLES20.glActiveTexture(33984 + i2);
                GLES20.glBindTexture(3553, this.f5329a[i2]);
                GLES20.glPixelStorei(3317, 1);
                GLES20.glTexImage2D(3553, 0, 6409, iArr[i2], i3, 0, 6409, 5121, byteBufferArr[i2]);
                i2++;
            }
            int i4 = bVar2.O;
            int i5 = (i4 + 1) / 2;
            int[] iArr2 = {i4, i5, i5};
            for (int i6 = 0; i6 < 3; i6++) {
                if (this.f5332c[i6] != iArr2[i6] || this.d[i6] != iArr[i6]) {
                    sb0.i(iArr[i6] != 0);
                    float f2 = iArr2[i6] / iArr[i6];
                    this.f5330a[i6] = GlUtil.i(new float[]{0.0f, 0.0f, 0.0f, 1.0f, f2, 0.0f, f2, 1.0f});
                    GLES20.glVertexAttribPointer(this.f5331b[i6], 2, 5126, false, 0, (Buffer) this.f5330a[i6]);
                    this.f5332c[i6] = iArr2[i6];
                    this.d[i6] = iArr[i6];
                }
            }
            GLES20.glClear(16384);
            GLES20.glDrawArrays(5, 0, 4);
            GlUtil.g();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GLES20.glViewport(0, 0, i, i2);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            hu3 hu3Var = new hu3(f, g);
            this.f5327a = hu3Var;
            GLES20.glVertexAttribPointer(hu3Var.f("in_pos"), 2, 5126, false, 0, (Buffer) f31177a);
            this.f5331b[0] = this.f5327a.f("in_tc_y");
            this.f5331b[1] = this.f5327a.f("in_tc_u");
            this.f5331b[2] = this.f5327a.f("in_tc_v");
            this.K = this.f5327a.k("mColorConversion");
            GlUtil.g();
            b();
            GlUtil.g();
        }
    }

    public VideoDecoderGLSurfaceView(Context context) {
        this(context, null);
    }

    @Deprecated
    public VideoDecoderOutputBufferRenderer getVideoDecoderOutputBufferRenderer() {
        return this;
    }

    @Override // com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer
    public void setOutputBuffer(b bVar) {
        this.f31176a.a(bVar);
    }

    public VideoDecoderGLSurfaceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a aVar = new a(this);
        this.f31176a = aVar;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setRenderMode(0);
    }
}
