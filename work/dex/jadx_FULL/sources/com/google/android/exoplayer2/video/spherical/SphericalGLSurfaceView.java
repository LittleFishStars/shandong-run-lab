package com.google.android.exoplayer2.video.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.AnyThread;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.zj.adlib.gj9;
import com.zj.adlib.nv7;
import com.zj.adlib.sb0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class SphericalGLSurfaceView extends GLSurfaceView {
    public static final int K = 90;
    static final float UPRIGHT_ROLL = 3.1415927f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f31190a = 0.1f;
    public static final float b = 100.0f;
    public static final float c = 25.0f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public SurfaceTexture f5373a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Sensor f5374a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SensorManager f5375a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f5376a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Surface f5377a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final OrientationListener f5378a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TouchTracker f5379a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final nv7 f5380a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CopyOnWriteArrayList<VideoSurfaceListener> f5381a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f5382a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f5383b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f5384c;

    public interface VideoSurfaceListener {
        void onVideoSurfaceCreated(Surface surface);

        void onVideoSurfaceDestroyed(Surface surface);
    }

    @VisibleForTesting
    public final class a implements GLSurfaceView.Renderer, TouchTracker.Listener, OrientationListener.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f31191a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final nv7 f5386a;
        public float b;
        public final float[] c;
        public final float[] d;
        public final float[] e;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final float[] f5387a = new float[16];

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final float[] f5388b = new float[16];
        public final float[] f = new float[16];
        public final float[] g = new float[16];

        public a(nv7 nv7Var) {
            float[] fArr = new float[16];
            this.c = fArr;
            float[] fArr2 = new float[16];
            this.d = fArr2;
            float[] fArr3 = new float[16];
            this.e = fArr3;
            this.f5386a = nv7Var;
            Matrix.setIdentityM(fArr, 0);
            Matrix.setIdentityM(fArr2, 0);
            Matrix.setIdentityM(fArr3, 0);
            this.b = SphericalGLSurfaceView.UPRIGHT_ROLL;
        }

        public final float a(float f) {
            if (f > 1.0f) {
                return (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / ((double) f))) * 2.0d);
            }
            return 90.0f;
        }

        @AnyThread
        public final void b() {
            Matrix.setRotateM(this.d, 0, -this.f31191a, (float) Math.cos(this.b), (float) Math.sin(this.b), 0.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            synchronized (this) {
                Matrix.multiplyMM(this.g, 0, this.c, 0, this.e, 0);
                Matrix.multiplyMM(this.f, 0, this.d, 0, this.g, 0);
            }
            Matrix.multiplyMM(this.f5388b, 0, this.f5387a, 0, this.f, 0);
            this.f5386a.c(this.f5388b, false);
        }

        @Override // com.google.android.exoplayer2.video.spherical.OrientationListener.Listener
        @BinderThread
        public synchronized void onOrientationChange(float[] fArr, float f) {
            float[] fArr2 = this.c;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.b = -f;
            b();
        }

        @Override // com.google.android.exoplayer2.video.spherical.TouchTracker.Listener
        @UiThread
        public synchronized void onScrollChange(PointF pointF) {
            this.f31191a = pointF.y;
            b();
            Matrix.setRotateM(this.e, 0, -pointF.x, 0.0f, 1.0f, 0.0f);
        }

        @Override // com.google.android.exoplayer2.video.spherical.TouchTracker.Listener
        @UiThread
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return SphericalGLSurfaceView.this.performClick();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GLES20.glViewport(0, 0, i, i2);
            float f = i / i2;
            Matrix.perspectiveM(this.f5387a, 0, a(f), f, 0.1f, 100.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            SphericalGLSurfaceView.this.e(this.f5386a.d());
        }
    }

    public SphericalGLSurfaceView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        Surface surface = this.f5377a;
        if (surface != null) {
            Iterator<VideoSurfaceListener> it = this.f5381a.iterator();
            while (it.hasNext()) {
                it.next().onVideoSurfaceDestroyed(surface);
            }
        }
        f(this.f5373a, surface);
        this.f5373a = null;
        this.f5377a = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = this.f5373a;
        Surface surface = this.f5377a;
        Surface surface2 = new Surface(surfaceTexture);
        this.f5373a = surfaceTexture;
        this.f5377a = surface2;
        Iterator<VideoSurfaceListener> it = this.f5381a.iterator();
        while (it.hasNext()) {
            it.next().onVideoSurfaceCreated(surface2);
        }
        f(surfaceTexture2, surface);
    }

    public static void f(@Nullable SurfaceTexture surfaceTexture, @Nullable Surface surface) {
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (surface != null) {
            surface.release();
        }
    }

    public void addVideoSurfaceListener(VideoSurfaceListener videoSurfaceListener) {
        this.f5381a.add(videoSurfaceListener);
    }

    public final void e(final SurfaceTexture surfaceTexture) {
        this.f5376a.post(new Runnable() { // from class: com.zj.adlib.rm8
            @Override // java.lang.Runnable
            public final void run() {
                this.f19373a.d(surfaceTexture);
            }
        });
    }

    public final void g() {
        boolean z = this.f5382a && this.f5383b;
        Sensor sensor = this.f5374a;
        if (sensor == null || z == this.f5384c) {
            return;
        }
        if (z) {
            this.f5375a.registerListener(this.f5378a, sensor, 0);
        } else {
            this.f5375a.unregisterListener(this.f5378a);
        }
        this.f5384c = z;
    }

    public CameraMotionListener getCameraMotionListener() {
        return this.f5380a;
    }

    public VideoFrameMetadataListener getVideoFrameMetadataListener() {
        return this.f5380a;
    }

    @Nullable
    public Surface getVideoSurface() {
        return this.f5377a;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f5376a.post(new Runnable() { // from class: com.zj.adlib.tm8
            @Override // java.lang.Runnable
            public final void run() {
                this.f44954a.c();
            }
        });
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        this.f5383b = false;
        g();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        this.f5383b = true;
        g();
    }

    public void removeVideoSurfaceListener(VideoSurfaceListener videoSurfaceListener) {
        this.f5381a.remove(videoSurfaceListener);
    }

    public void setDefaultStereoMode(int i) {
        this.f5380a.f(i);
    }

    public void setUseSensorRotation(boolean z) {
        this.f5382a = z;
        g();
    }

    public SphericalGLSurfaceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5381a = new CopyOnWriteArrayList<>();
        this.f5376a = new Handler(Looper.getMainLooper());
        SensorManager sensorManager = (SensorManager) sb0.g(context.getSystemService("sensor"));
        this.f5375a = sensorManager;
        Sensor defaultSensor = gj9.f41922a >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.f5374a = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        nv7 nv7Var = new nv7();
        this.f5380a = nv7Var;
        a aVar = new a(nv7Var);
        TouchTracker touchTracker = new TouchTracker(context, aVar, 25.0f);
        this.f5379a = touchTracker;
        this.f5378a = new OrientationListener(((WindowManager) sb0.g((WindowManager) context.getSystemService("window"))).getDefaultDisplay(), touchTracker, aVar);
        this.f5382a = true;
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setOnTouchListener(touchTracker);
    }
}
