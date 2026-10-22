package com.king.zxing;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.camera.video.AudioStats;
import androidx.fragment.app.Fragment;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.king.zxing.b;
import com.king.zxing.camera.CameraManager;
import com.king.zxing.camera.FrontLightMode;
import com.zj.adlib.i50;
import com.zj.adlib.u15;
import com.zj.adlib.ug7;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class b implements CaptureLifecycle, CaptureTouchEvent, CaptureManager, SurfaceHolder.Callback {
    public static final int M = 6;
    public int K;
    public int L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f40019a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Activity f15028a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SurfaceHolder f15029a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SurfaceView f15030a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f15031a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CaptureHandler f15032a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InactivityTimer f15033a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnCaptureCallback f15034a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnCaptureListener f15035a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ViewfinderView f15036a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f15037a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CameraManager f15038a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public i50 f15039a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Collection<BarcodeFormat> f15040a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<DecodeHintType, Object> f15041a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15042a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f15043b;
    public float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f15044c;
    public float d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f15045d;
    public boolean e;
    public String f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f15046f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;

    @Deprecated
    public b(Fragment fragment, SurfaceView surfaceView, ViewfinderView viewfinderView) {
        this(fragment, surfaceView, viewfinderView, (View) null);
    }

    public static /* synthetic */ void D(String str, boolean z, Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        parameters.setFocusMode(str);
        camera.setParameters(parameters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(View view) {
        CameraManager cameraManager = this.f15038a;
        if (cameraManager != null) {
            cameraManager.r(!this.f15031a.isSelected());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(boolean z, boolean z2, float f) {
        if (z2) {
            if (this.f15031a.getVisibility() != 0) {
                this.f15031a.setVisibility(0);
            }
        } else {
            if (z || this.f15031a.getVisibility() != 0) {
                return;
            }
            this.f15031a.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(boolean z) {
        this.f15031a.setSelected(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(ug7 ug7Var, Bitmap bitmap, float f) {
        this.f15033a.c();
        this.f15037a.g();
        K(ug7Var, bitmap, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(String str) {
        OnCaptureCallback onCaptureCallback = this.f15034a;
        if (onCaptureCallback == null || !onCaptureCallback.onResultCallback(str)) {
            Intent intent = new Intent();
            intent.putExtra("SCAN_RESULT", str);
            this.f15028a.setResult(-1, intent);
            this.f15028a.finish();
        }
    }

    public final void A(boolean z, Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        if (!parameters.isZoomSupported()) {
            u15.l("zoom not supported");
            return;
        }
        int maxZoom = parameters.getMaxZoom();
        int zoom = parameters.getZoom();
        if (z && zoom < maxZoom) {
            zoom++;
        } else if (zoom > 0) {
            zoom--;
        }
        parameters.setZoom(zoom);
        camera.setParameters(parameters);
    }

    public final void B(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalStateException("No SurfaceHolder provided");
        }
        if (this.f15038a.h()) {
            u15.z("initCamera() while already open -- late SurfaceView callback?");
            return;
        }
        try {
            this.f15038a.i(surfaceHolder);
            if (this.f15032a == null) {
                CaptureHandler captureHandler = new CaptureHandler(this.f15028a, this.f15036a, this.f15035a, this.f15040a, this.f15041a, this.f, this.f15038a);
                this.f15032a = captureHandler;
                captureHandler.l(this.i);
                this.f15032a.i(this.j);
                this.f15032a.j(this.f15044c);
                this.f15032a.k(this.f15045d);
            }
        } catch (IOException e) {
            u15.B(e);
        } catch (RuntimeException e2) {
            u15.A("Unexpected error initializing camera", e2);
        }
    }

    public final void C() {
        CameraManager cameraManager = new CameraManager(this.f15028a);
        this.f15038a = cameraManager;
        cameraManager.o(this.k);
        this.f15038a.m(this.b);
        this.f15038a.n(this.K);
        this.f15038a.l(this.L);
        View view = this.f15031a;
        if (view == null || !this.l) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.ne1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f43506a.E(view2);
            }
        });
        this.f15038a.setOnSensorListener(new CameraManager.OnSensorListener() { // from class: com.zj.adlib.oe1
            @Override // com.king.zxing.camera.CameraManager.OnSensorListener
            public final void a(boolean z, boolean z2, float f) {
                this.f43729a.F(z, z2, f);
            }
        });
        this.f15038a.setOnTorchListener(new CameraManager.OnTorchListener() { // from class: com.zj.adlib.pe1
            @Override // com.king.zxing.camera.CameraManager.OnTorchListener
            public final void a(boolean z) {
                this.f43959a.G(z);
            }
        });
    }

    public void J(ug7 ug7Var) {
        CaptureHandler captureHandler;
        final String strG = ug7Var.g();
        if (this.e) {
            OnCaptureCallback onCaptureCallback = this.f15034a;
            if (onCaptureCallback != null) {
                onCaptureCallback.onResultCallback(strG);
            }
            if (this.f15046f) {
                M();
                return;
            }
            return;
        }
        if (this.g && (captureHandler = this.f15032a) != null) {
            captureHandler.postDelayed(new Runnable() { // from class: com.zj.adlib.ke1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42798a.I(strG);
                }
            }, 100L);
            return;
        }
        OnCaptureCallback onCaptureCallback2 = this.f15034a;
        if (onCaptureCallback2 == null || !onCaptureCallback2.onResultCallback(strG)) {
            Intent intent = new Intent();
            intent.putExtra("SCAN_RESULT", strG);
            this.f15028a.setResult(-1, intent);
            this.f15028a.finish();
        }
    }

    public void K(ug7 ug7Var, Bitmap bitmap, float f) {
        J(ug7Var);
    }

    public b L(boolean z) {
        this.g = z;
        a aVar = this.f15037a;
        if (aVar != null) {
            aVar.h(z);
        }
        return this;
    }

    public void M() {
        CaptureHandler captureHandler = this.f15032a;
        if (captureHandler != null) {
            captureHandler.h();
        }
    }

    public b N(boolean z) {
        this.j = z;
        CaptureHandler captureHandler = this.f15032a;
        if (captureHandler != null) {
            captureHandler.i(z);
        }
        return this;
    }

    public b O(OnCaptureCallback onCaptureCallback) {
        this.f15034a = onCaptureCallback;
        return this;
    }

    public b P(boolean z) {
        this.f15044c = z;
        CaptureHandler captureHandler = this.f15032a;
        if (captureHandler != null) {
            captureHandler.j(z);
        }
        return this;
    }

    public b Q(boolean z) {
        this.f15045d = z;
        CaptureHandler captureHandler = this.f15032a;
        if (captureHandler != null) {
            captureHandler.k(z);
        }
        return this;
    }

    public b R(boolean z) {
        this.i = z;
        CaptureHandler captureHandler = this.f15032a;
        if (captureHandler != null) {
            captureHandler.l(z);
        }
        return this;
    }

    public b S(boolean z) {
        this.f15043b = z;
        return this;
    }

    public b T(float f) {
        this.c = f;
        i50 i50Var = this.f15039a;
        if (i50Var != null) {
            i50Var.b(f);
        }
        return this;
    }

    public b U(boolean z) {
        this.h = z;
        a aVar = this.f15037a;
        if (aVar != null) {
            aVar.j(z);
        }
        return this;
    }

    @Override // com.king.zxing.CaptureManager
    public a a() {
        return this.f15037a;
    }

    @Override // com.king.zxing.CaptureManager
    public InactivityTimer b() {
        return this.f15033a;
    }

    @Override // com.king.zxing.CaptureManager
    public CameraManager c() {
        return this.f15038a;
    }

    @Override // com.king.zxing.CaptureManager
    public i50 d() {
        return this.f15039a;
    }

    public b k(boolean z) {
        this.f15046f = z;
        return this;
    }

    public b l(float f) {
        this.d = f;
        i50 i50Var = this.f15039a;
        if (i50Var != null) {
            i50Var.b(this.c);
        }
        return this;
    }

    public final float m(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public final Rect n(float f, float f2, float f3, Camera.Size size) {
        int iIntValue = Float.valueOf(f3 * 200.0f).intValue();
        int i = (int) (((f / size.width) * 2000.0f) - 1000.0f);
        int i2 = (int) (((f2 / size.height) * 2000.0f) - 1000.0f);
        int i3 = iIntValue / 2;
        int iP = p(i - i3, -1000, 1000);
        int iP2 = p(i2 - i3, -1000, 1000);
        RectF rectF = new RectF(iP, iP2, iP + iIntValue, iP2 + iIntValue);
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public b o(String str) {
        this.f = str;
        return this;
    }

    @Override // com.king.zxing.CaptureLifecycle
    public void onCreate() {
        this.f15029a = this.f15030a.getHolder();
        this.f15042a = false;
        this.f15033a = new InactivityTimer(this.f15028a);
        this.f15037a = new a(this.f15028a);
        this.f15039a = new i50(this.f15028a);
        this.l = this.f15028a.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
        C();
        this.f15035a = new OnCaptureListener() { // from class: com.zj.adlib.me1
            @Override // com.king.zxing.OnCaptureListener
            public final void a(ug7 ug7Var, Bitmap bitmap, float f) {
                this.f43279a.H(ug7Var, bitmap, f);
            }
        };
        this.f15037a.h(this.g);
        this.f15037a.j(this.h);
        this.f15039a.b(this.c);
        this.f15039a.a(this.d);
    }

    @Override // com.king.zxing.CaptureLifecycle
    public void onDestroy() {
        this.f15033a.f();
    }

    @Override // com.king.zxing.CaptureLifecycle
    public void onPause() {
        CaptureHandler captureHandler = this.f15032a;
        if (captureHandler != null) {
            captureHandler.g();
            this.f15032a = null;
        }
        this.f15033a.d();
        this.f15039a.d();
        this.f15037a.close();
        this.f15038a.b();
        if (!this.f15042a) {
            this.f15029a.removeCallback(this);
        }
        View view = this.f15031a;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.f15031a.setSelected(false);
        this.f15031a.setVisibility(4);
    }

    @Override // com.king.zxing.CaptureLifecycle
    public void onResume() {
        this.f15037a.l();
        this.f15033a.e();
        if (this.f15042a) {
            B(this.f15029a);
        } else {
            this.f15029a.addCallback(this);
        }
        this.f15039a.c(this.f15038a);
    }

    @Override // com.king.zxing.CaptureTouchEvent
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Camera cameraA;
        if (!this.f15043b || !this.f15038a.h() || (cameraA = this.f15038a.f().a()) == null || motionEvent.getPointerCount() <= 1) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 2) {
            float fM = m(motionEvent);
            float f = this.f40019a;
            if (fM > f + 6.0f) {
                A(true, cameraA);
            } else if (fM < f - 6.0f) {
                A(false, cameraA);
            }
            this.f40019a = fM;
        } else if (action == 5) {
            this.f40019a = m(motionEvent);
        }
        return true;
    }

    public final int p(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        return i < i2 ? i2 : i;
    }

    public b q(boolean z) {
        this.e = z;
        return this;
    }

    public b r(Collection<BarcodeFormat> collection) {
        this.f15040a = collection;
        return this;
    }

    public b s(DecodeHintType decodeHintType, Object obj) {
        if (this.f15041a == null) {
            this.f15041a = new EnumMap(DecodeHintType.class);
        }
        this.f15041a.put(decodeHintType, obj);
        return this;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            u15.z("*** WARNING *** surfaceCreated() gave us a null surface!");
        }
        if (this.f15042a) {
            return;
        }
        this.f15042a = true;
        B(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f15042a = false;
    }

    public b t(Map<DecodeHintType, Object> map) {
        this.f15041a = map;
        return this;
    }

    @Deprecated
    public final void u(MotionEvent motionEvent, Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        Camera.Size previewSize = parameters.getPreviewSize();
        Rect rectN = n(motionEvent.getRawX(), motionEvent.getRawY(), 1.0f, previewSize);
        Rect rectN2 = n(motionEvent.getRawX(), motionEvent.getRawY(), 1.5f, previewSize);
        Camera.Parameters parameters2 = camera.getParameters();
        if (parameters2.getMaxNumFocusAreas() > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Camera.Area(rectN, 600));
            parameters2.setFocusAreas(arrayList);
        }
        if (parameters2.getMaxNumMeteringAreas() > 0) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new Camera.Area(rectN2, 600));
            parameters2.setMeteringAreas(arrayList2);
        }
        final String focusMode = parameters.getFocusMode();
        parameters.setFocusMode("macro");
        camera.setParameters(parameters);
        camera.autoFocus(new Camera.AutoFocusCallback() { // from class: com.zj.adlib.le1
            @Override // android.hardware.Camera.AutoFocusCallback
            public final void onAutoFocus(boolean z, Camera camera2) {
                b.D(focusMode, z, camera2);
            }
        });
    }

    public b v(int i) {
        this.L = i;
        CameraManager cameraManager = this.f15038a;
        if (cameraManager != null) {
            cameraManager.l(i);
        }
        return this;
    }

    public b w(@FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        this.b = f;
        CameraManager cameraManager = this.f15038a;
        if (cameraManager != null) {
            cameraManager.m(f);
        }
        return this;
    }

    public b x(int i) {
        this.K = i;
        CameraManager cameraManager = this.f15038a;
        if (cameraManager != null) {
            cameraManager.n(i);
        }
        return this;
    }

    public b y(FrontLightMode frontLightMode) {
        FrontLightMode.put(this.f15028a, frontLightMode);
        View view = this.f15031a;
        if (view != null && frontLightMode != FrontLightMode.AUTO) {
            view.setVisibility(4);
        }
        return this;
    }

    public b z(boolean z) {
        this.k = z;
        CameraManager cameraManager = this.f15038a;
        if (cameraManager != null) {
            cameraManager.o(z);
        }
        return this;
    }

    public b(Fragment fragment, SurfaceView surfaceView, ViewfinderView viewfinderView, View view) {
        this(fragment.getActivity(), surfaceView, viewfinderView, view);
    }

    @Deprecated
    public b(Activity activity, SurfaceView surfaceView, ViewfinderView viewfinderView) {
        this(activity, surfaceView, viewfinderView, (View) null);
    }

    public b(Activity activity, SurfaceView surfaceView, ViewfinderView viewfinderView, View view) {
        this.f15043b = true;
        this.f15044c = true;
        this.f15045d = false;
        this.e = false;
        this.f15046f = true;
        this.b = 0.9f;
        this.c = 45.0f;
        this.d = 100.0f;
        this.f15028a = activity;
        this.f15030a = surfaceView;
        this.f15036a = viewfinderView;
        this.f15031a = view;
    }
}
