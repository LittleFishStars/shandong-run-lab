package com.ipd.dsp.internal.z0;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;
import android.window.OnBackInvokedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.R;
import com.ipd.dsp.ad.DspRewardVideoAd;
import com.ipd.dsp.internal.c2.k;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.internal.c2.r;
import com.ipd.dsp.internal.r1.g;
import com.ipd.dsp.internal.r1.h;
import com.ipd.dsp.internal.r1.j;
import com.ipd.dsp.internal.s1.i;
import com.zj.adlib.c49;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c extends com.ipd.dsp.internal.z0.b implements com.ipd.dsp.internal.b1.b.c, com.ipd.dsp.internal.b1.b.e {
    public static final HashMap<String, DspRewardVideoAd.InteractionListener> O = new HashMap<>();
    public static final int P = 1;
    public static final int Q = 2;
    public static final int R = 3;
    public static final int S = 4;
    public f A;
    public Runnable B;
    public Handler C;
    public int D;
    public int E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public Object N;
    public int h;
    public int k;
    public String l;
    public com.ipd.dsp.internal.e1.d m;
    public com.ipd.dsp.internal.j1.b n;
    public com.ipd.dsp.internal.r1.a o;
    public com.ipd.dsp.internal.r1.b p;
    public com.ipd.dsp.internal.v1.a q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;
    public boolean x;
    public boolean y;
    public com.ipd.dsp.internal.b1.b z;
    public boolean i = false;
    public boolean j = false;
    public final com.ipd.dsp.internal.c2.f.b M = new a();

    public class a implements com.ipd.dsp.internal.c2.f.b {
        public a() {
        }

        @Override // com.ipd.dsp.internal.c2.f.b
        public void onPause() {
        }

        @Override // com.ipd.dsp.internal.c2.f.b
        public void onResume() {
            com.ipd.dsp.internal.c2.f.a().b(c.this.M);
            c.this.w();
        }
    }

    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            int iT;
            if (c.this.o == null || c.this.C == null) {
                return;
            }
            int i = message.what;
            if (i == 2) {
                c.this.o.k();
                return;
            }
            if (i != 1) {
                if (i == 3) {
                    c.this.o.c(-1);
                    c.this.C.removeCallbacksAndMessages(null);
                    c.this.C = null;
                    return;
                } else {
                    if (i == 4 && c.this.j) {
                        c cVar = c.this;
                        if (!(cVar.z instanceof com.ipd.dsp.internal.b1.b.a) || cVar.i) {
                            return;
                        }
                        ((com.ipd.dsp.internal.b1.b.a) c.this.z).e();
                        return;
                    }
                    return;
                }
            }
            if (c.this.u) {
                Object obj = message.obj;
                if (!(obj instanceof Integer)) {
                    return;
                }
                c.this.E = ((Integer) obj).intValue();
                iT = c.this.D - c.this.E;
                if (c.this.E >= c.this.D && c.this.D != 0) {
                    c.this.x();
                }
            } else {
                iT = c.this.D - c.t(c.this);
                if (iT >= 0) {
                    c.this.C.sendEmptyMessageDelayed(1, 1000L);
                } else {
                    c.this.x();
                    if (c.this.D > 0) {
                        c.this.a(false);
                    }
                }
            }
            if (c.this.h > 0 && c.this.E >= c.this.h) {
                c.this.o.k();
            }
            c.this.o.c(iT);
        }
    }

    /* JADX INFO: renamed from: com.ipd.dsp.internal.z0.c$c, reason: collision with other inner class name */
    public class C0931c implements com.ipd.dsp.internal.r1.a.InterfaceC0916a {
        public C0931c() {
        }

        @Override // com.ipd.dsp.internal.r1.a.InterfaceC0916a
        public void a(Map<String, Object> map) {
            c.this.b(1, (float[]) null, map);
        }

        @Override // com.ipd.dsp.internal.r1.a.InterfaceC0916a
        public void a() {
            if (!c.this.r || c.this.F || c.this.G || !c.this.s || c.this.H) {
                c.this.a(true);
            } else {
                c.this.D();
            }
        }

        @Override // com.ipd.dsp.internal.r1.a.InterfaceC0916a
        public void a(boolean z) {
            if (c.this.p instanceof j) {
                ((j) c.this.p).a(z);
            }
        }
    }

    public static class f implements SensorEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f38625a;
        public final int b;
        public long c;
        public float d;
        public float e;
        public float f;
        public volatile boolean g;
        public Handler h;
        public final AtomicInteger i;
        public Runnable j;

        public /* synthetic */ f(int i, Runnable runnable, a aVar) {
            this(i, runnable);
        }

        public final void a(float f, float f2, float f3) {
            c cVar;
            if (this.i.incrementAndGet() >= 3) {
                this.g = false;
                Runnable runnable = this.j;
                if (runnable != null) {
                    runnable.run();
                    this.j = null;
                    return;
                }
                return;
            }
            if (!this.g || (cVar = this.f38625a) == null) {
                return;
            }
            if (cVar.b(3, new float[]{f, f2, f3}, (Map<String, Object>) null)) {
                this.f38625a.E();
            }
            this.g = false;
            Handler handler = this.h;
            if (handler != null) {
                handler.postDelayed(new Runnable() { // from class: com.zj.adlib.dra
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f41263a.a();
                    }
                }, 1000L);
            }
        }

        public void b() {
            this.f38625a = null;
            Handler handler = this.h;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.h = null;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (this.g) {
                long j = sensorEvent.timestamp;
                if (j - this.c < 200) {
                    return;
                }
                this.c = j;
                float[] fArr = sensorEvent.values;
                float f = fArr[0];
                float f2 = fArr[1];
                float f3 = fArr[2] - 9.80665f;
                if (Math.abs(f) > this.b && this.d * f <= 0.0f) {
                    a(f, f2, f3);
                    this.d = f;
                } else if (Math.abs(f2) > this.b && this.e * f2 <= 0.0f) {
                    a(f, f2, f3);
                    this.e = f2;
                } else {
                    if (Math.abs(f3) <= this.b || this.f * f3 > 0.0f) {
                        return;
                    }
                    a(f, f2, f3);
                    this.f = f3;
                }
            }
        }

        public f(int i, Runnable runnable) {
            this.c = 0L;
            this.g = true;
            this.h = null;
            this.i = new AtomicInteger(0);
            this.b = i;
            this.j = runnable;
        }

        public final /* synthetic */ void a() {
            try {
                this.g = true;
            } catch (Throwable unused) {
            }
        }

        public void a(c cVar) {
            this.f38625a = cVar;
            this.g = true;
            this.h = new Handler(Looper.getMainLooper());
        }
    }

    public static /* synthetic */ int t(c cVar) {
        int i = cVar.E + 1;
        cVar.E = i;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (this.F) {
            return;
        }
        this.F = true;
        if (this.r) {
            try {
                com.ipd.dsp.internal.h1.a.a(this.n, com.ipd.dsp.internal.h1.a.e.C);
                DspRewardVideoAd.InteractionListener interactionListener = O.get(this.l);
                if (interactionListener != null) {
                    interactionListener.onRewardVideoVerify();
                }
            } catch (Throwable th) {
                k.a("IAP", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (this.y) {
            return;
        }
        this.y = true;
        com.ipd.dsp.internal.j1.b bVar = this.n;
        com.ipd.dsp.internal.r1.a aVar = this.o;
        bVar.a(new com.ipd.dsp.internal.j1.a(aVar != null ? aVar.m : null));
        com.ipd.dsp.internal.h1.a.a(this.n, this.k);
        DspRewardVideoAd.InteractionListener interactionListener = O.get(this.l);
        if (interactionListener != null) {
            interactionListener.onRewardVideoShow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        this.G = true;
        Handler handler = this.C;
        if (handler != null) {
            handler.sendEmptyMessage(2);
        }
    }

    public final void A() {
        if (this.H) {
            return;
        }
        com.ipd.dsp.internal.r1.b bVar = this.p;
        if (bVar instanceof j) {
            ((j) bVar).b();
        } else {
            Handler handler = this.C;
            if (handler != null) {
                handler.removeMessages(1);
            }
        }
        F();
    }

    public void B() {
        Sensor defaultSensor;
        if (this.A == null || j() == null) {
            return;
        }
        try {
            SensorManager sensorManager = (SensorManager) j().getApplicationContext().getSystemService("sensor");
            if (sensorManager == null || (defaultSensor = sensorManager.getDefaultSensor(1)) == null) {
                return;
            }
            this.A.a(this);
            sensorManager.registerListener(this.A, defaultSensor, 2);
        } catch (Throwable th) {
            r.a(th);
        }
    }

    public final void C() {
        if (this.H) {
            return;
        }
        com.ipd.dsp.internal.r1.b bVar = this.p;
        if (!(bVar instanceof j) || this.x) {
            Handler handler = this.C;
            if (handler != null && !this.x) {
                handler.sendEmptyMessage(1);
            }
        } else {
            ((j) bVar).f();
        }
        B();
    }

    public final void D() {
        com.ipd.dsp.internal.e1.d dVar;
        com.ipd.dsp.internal.r1.a aVar = this.o;
        if (aVar == null || (dVar = this.m) == null) {
            return;
        }
        aVar.a(dVar.n, dVar.l, new e());
        A();
    }

    public final void E() {
        try {
            if (j().checkPermission("android.permission.VIBRATE", Process.myPid(), Process.myUid()) == 0) {
                Vibrator defaultVibrator = Build.VERSION.SDK_INT >= 31 ? ((VibratorManager) j().getSystemService("vibrator_manager")).getDefaultVibrator() : (Vibrator) j().getSystemService("vibrator");
                if (defaultVibrator == null || !defaultVibrator.hasVibrator()) {
                    return;
                }
                defaultVibrator.vibrate(VibrationEffect.createOneShot(400L, -1));
            }
        } catch (Throwable th) {
            r.a(th);
        }
    }

    public void F() {
        Sensor defaultSensor;
        if (this.A == null || j() == null) {
            return;
        }
        try {
            SensorManager sensorManager = (SensorManager) j().getApplicationContext().getSystemService("sensor");
            if (sensorManager == null || (defaultSensor = sensorManager.getDefaultSensor(1)) == null) {
                return;
            }
            this.A.b();
            sensorManager.unregisterListener(this.A, defaultSensor);
        } catch (Throwable th) {
            r.a(th);
        }
    }

    @Override // com.ipd.dsp.internal.b1.b.c
    public void onDownloadConfirmDialogDismiss() {
        this.x = false;
        C();
        if (this.K) {
            w();
        }
    }

    @Override // com.ipd.dsp.internal.b1.b.c
    public void onDownloadConfirmDialogShow() {
        this.x = true;
        A();
    }

    public class e implements i.a {
        public e() {
        }

        @Override // com.ipd.dsp.internal.s1.i.a
        public void a(Map<String, Object> map) {
            c.this.b(1, (float[]) null, map);
            c.this.C();
        }

        @Override // com.ipd.dsp.internal.s1.i.a
        public void b() {
            c.this.C();
        }

        @Override // com.ipd.dsp.internal.s1.i.a
        public void a() {
            c.this.a(true);
        }
    }

    public static void e(String str) {
        if (o.c(str)) {
            O.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v() {
        b(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        try {
            if (this.r && !this.F) {
                com.ipd.dsp.internal.r1.b bVar = this.p;
                if (bVar instanceof j) {
                    ((j) bVar).c();
                } else {
                    com.ipd.dsp.internal.h1.a.a(this.n, com.ipd.dsp.internal.h1.a.e.A);
                }
            }
            com.ipd.dsp.internal.r1.b bVar2 = this.p;
            if (bVar2 instanceof j) {
                ((j) bVar2).d();
            }
            com.ipd.dsp.internal.j1.b bVar3 = this.n;
            if (bVar3 != null) {
                com.ipd.dsp.internal.h1.a.a(bVar3, com.ipd.dsp.internal.h1.a.e.D);
            }
            DspRewardVideoAd.InteractionListener interactionListener = O.get(this.l);
            if (interactionListener != null) {
                interactionListener.onRewardVideoClose();
            }
        } catch (Throwable th) {
            k.a("IAP", th);
        }
        if (j().isFinishing()) {
            return;
        }
        j().finish();
    }

    @Override // com.ipd.dsp.internal.b1.b.c
    public boolean c() {
        return this.v;
    }

    public final /* synthetic */ void d(String str) {
        if (this.m == null) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                com.ipd.dsp.internal.b1.b bVar = this.z;
                if (bVar instanceof com.ipd.dsp.internal.b1.b.a) {
                    this.m.r.k = str;
                } else if (bVar instanceof com.ipd.dsp.internal.b1.b.d) {
                    this.m.r.j = str;
                }
            }
            if ((!this.r || this.F) && !this.K && this.J && (this.z instanceof com.ipd.dsp.internal.b1.b.d)) {
                com.ipd.dsp.internal.c2.f.a().a(this.M);
            }
            com.ipd.dsp.internal.b1.b bVar2 = this.z;
            if (bVar2 != null) {
                if (this.K) {
                    bVar2.a(new Runnable() { // from class: com.zj.adlib.pqa
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f44046a.w();
                        }
                    });
                } else {
                    bVar2.a();
                }
            }
        } catch (Throwable th) {
            r.a(th);
        }
    }

    @Override // com.ipd.dsp.internal.z0.b
    public void k() {
        Activity activityJ;
        if (Build.VERSION.SDK_INT >= 33) {
            try {
                if (this.N != null && (activityJ = j()) != null) {
                    activityJ.getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback((OnBackInvokedCallback) this.N);
                }
            } catch (Throwable th) {
                r.a(th);
            }
        }
        e(this.l);
        this.m = null;
        this.n = null;
        com.ipd.dsp.internal.r1.a aVar = this.o;
        if (aVar != null) {
            aVar.removeAllViews();
            this.o = null;
        }
        com.ipd.dsp.internal.b1.b bVar = this.z;
        if (bVar != null) {
            bVar.c();
            this.z = null;
        }
        Object obj = this.p;
        if (obj instanceof ViewGroup) {
            ((ViewGroup) obj).removeAllViews();
            this.p = null;
        }
        com.ipd.dsp.internal.v1.a aVar2 = this.q;
        if (aVar2 != null) {
            aVar2.setOnClickListener(null);
            this.q.j();
            this.q = null;
        }
        Handler handler = this.C;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.C = null;
        }
        this.A = null;
        this.B = null;
        super.k();
    }

    @Override // com.ipd.dsp.internal.z0.b
    public void l() {
        super.l();
        this.j = false;
        A();
    }

    @Override // com.ipd.dsp.internal.z0.b
    public void n() {
        super.n();
        this.j = true;
        C();
    }

    @Override // com.ipd.dsp.internal.z0.b
    public void p() {
        super.p();
        this.i = true;
    }

    public final void r() {
        switch (this.w) {
            case 1:
                this.p = new com.ipd.dsp.internal.r1.c(j(), this.m, this.v, this.L);
                break;
            case 2:
                this.p = new com.ipd.dsp.internal.r1.d(j(), this.m, this.v, this.L);
                break;
            case 3:
                this.p = new com.ipd.dsp.internal.r1.e(j(), this.m, this.v, this.L);
                break;
            case 4:
                this.p = new com.ipd.dsp.internal.r1.f(j(), this.m, this.n, this.v, this.L, this.I);
                break;
            case 5:
                this.p = new g(j(), this.m, this.n, this.v, this.L, this.I);
                break;
            case 6:
                this.p = new h(j(), this.m, this.n, this.v, this.L, this.I);
                break;
            case 7:
                this.p = new com.ipd.dsp.internal.r1.i(j(), this.m, this.n, this.v, this.L, this.I);
                break;
            default:
                this.p = null;
                break;
        }
        Object obj = this.p;
        if (obj == null) {
            Toast.makeText(j(), "版本错误", 0).show();
            j().finish();
            return;
        }
        this.o.m.addView((View) obj);
        if (this.L) {
            this.o.a(this.m.r.D);
        }
        this.p.h();
        List<View> clickableViews = this.p.getClickableViews();
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.zj.adlib.dpa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f41246a.a(view);
            }
        };
        Iterator<View> it = clickableViews.iterator();
        while (it.hasNext()) {
            it.next().setOnClickListener(onClickListener);
        }
        com.ipd.dsp.internal.e1.d dVar = this.m;
        if (dVar != null && !dVar.w.j && new Random().nextInt(100) < this.m.w.k) {
            com.ipd.dsp.internal.v1.b bVar = new com.ipd.dsp.internal.v1.b(j());
            this.q = bVar;
            bVar.setOnStopListener(new com.ipd.dsp.internal.v1.a.e() { // from class: com.zj.adlib.ppa
                @Override // com.ipd.dsp.internal.v1.a.e
                public final void onStop() {
                    this.f44040a.s();
                }
            });
            this.q.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.xpa
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f45874a.b(view);
                }
            });
            ((ViewGroup) this.p).addView(this.q);
            this.q.postDelayed(new Runnable() { // from class: com.zj.adlib.hqa
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42182a.t();
                }
            }, 500L);
        }
        boolean z = this.u;
        if (z) {
            com.ipd.dsp.internal.r1.b bVar2 = this.p;
            if (bVar2 instanceof j) {
                ((j) bVar2).setVideoListener(new d());
                this.C.sendEmptyMessageDelayed(2, 10000L);
                return;
            }
        }
        if (z) {
            return;
        }
        this.o.m.post(new Runnable() { // from class: com.zj.adlib.kqa
            @Override // java.lang.Runnable
            public final void run() {
                this.f42889a.y();
            }
        });
    }

    public final /* synthetic */ void s() {
        try {
            this.q.setOnClickListener(null);
        } catch (Throwable th) {
            r.a(th);
        }
        Object obj = this.p;
        if (obj instanceof ViewGroup) {
            try {
                ((ViewGroup) obj).removeView(this.q);
            } catch (Throwable unused) {
            }
        }
        this.q = null;
    }

    public final /* synthetic */ void t() {
        com.ipd.dsp.internal.v1.a aVar = this.q;
        if (aVar != null) {
            aVar.k();
        }
    }

    public final /* synthetic */ void u() {
        F();
        this.A = null;
        this.B = null;
    }

    @Override // com.ipd.dsp.internal.z0.b
    public void b(Bundle bundle) {
        Activity activityJ = j();
        if (Build.VERSION.SDK_INT >= 33) {
            try {
                this.N = new OnBackInvokedCallback() { // from class: com.zj.adlib.rqa
                    @Override // android.window.OnBackInvokedCallback
                    public final void onBackInvoked() {
                        this.f44516a.v();
                    }
                };
                activityJ.getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, (OnBackInvokedCallback) this.N);
            } catch (Throwable th) {
                r.a(th);
            }
        }
        b(activityJ);
        com.ipd.dsp.internal.b1.b bVarA = com.ipd.dsp.internal.b1.b.a(this.m, this.n);
        this.z = bVarA;
        if (bVarA instanceof com.ipd.dsp.internal.b1.b.a) {
            ((com.ipd.dsp.internal.b1.b.a) bVarA).a(this);
            this.z.a(j());
        }
        this.z.c = this;
        this.C = new b(Looper.getMainLooper());
        a(activityJ);
        activityJ.setContentView(this.o);
        r();
    }

    @Override // com.ipd.dsp.internal.b1.b.e
    public void c(String str) {
        com.ipd.dsp.internal.r1.a aVar = this.o;
        if (aVar != null && this.H) {
            aVar.setEndCardCTABtnText(str);
            return;
        }
        com.ipd.dsp.internal.r1.b bVar = this.p;
        if (bVar == null || this.H) {
            return;
        }
        bVar.a(str);
    }

    public class d implements com.ipd.dsp.internal.s1.h.a {
        public d() {
        }

        @Override // com.ipd.dsp.internal.s1.h.a
        public void a(int i, int i2) {
            if (c.this.C != null) {
                c.this.C.removeMessages(2);
                c.this.C.sendMessage(c.this.C.obtainMessage(1, Integer.valueOf(i)));
            }
            c cVar = c.this;
            cVar.D = Math.min(cVar.D, i2 - 1);
            c.this.y();
        }

        @Override // com.ipd.dsp.internal.s1.h.a
        public void a(int i) {
            if (c.this.C != null) {
                c.this.C.sendMessage(c.this.C.obtainMessage(1, Integer.valueOf(i)));
            }
        }

        @Override // com.ipd.dsp.internal.s1.h.a
        public void a() {
            if (c.this.o != null) {
                c.this.o.setVolumeBtnVisibility(false);
                c.this.o.k();
            }
            c.this.a(false);
        }

        @Override // com.ipd.dsp.internal.s1.h.a
        public void a(int i, String str) {
            c.this.z();
        }
    }

    public static String a(DspRewardVideoAd.InteractionListener interactionListener) {
        HashMap<String, DspRewardVideoAd.InteractionListener> map = O;
        if (map.containsValue(interactionListener)) {
            for (Map.Entry<String, DspRewardVideoAd.InteractionListener> entry : map.entrySet()) {
                if (entry.getValue() == interactionListener) {
                    return entry.getKey();
                }
            }
        }
        String strReplace = UUID.randomUUID().toString().replace(c49.f40900a, "");
        O.put(strReplace, interactionListener);
        return strReplace;
    }

    public final void a(Activity activity) {
        boolean z = this.v;
        int i = this.w;
        com.ipd.dsp.internal.r1.a aVar = new com.ipd.dsp.internal.r1.a(activity, z, (i == 3 || i == 7) ? 1.25f : 1.78f, this.u, this.I, this.r, this.m.t);
        this.o = aVar;
        aVar.setOnClickListener(new C0931c());
        int i2 = this.m.q.h;
        this.h = i2;
        if (i2 == 0) {
            this.o.k();
        }
        Handler handler = this.C;
        if (handler == null || !this.u) {
            return;
        }
        handler.sendMessage(Message.obtain(handler, 1, 0));
    }

    public final void b(Activity activity) {
        Intent intent = activity.getIntent();
        com.ipd.dsp.internal.e1.d dVar = (com.ipd.dsp.internal.e1.d) intent.getSerializableExtra("data");
        this.m = dVar;
        this.n = new com.ipd.dsp.internal.j1.b(dVar);
        this.k = intent.getIntExtra("be", 0);
        this.l = intent.getStringExtra("uuid");
        com.ipd.dsp.internal.e1.d dVar2 = this.m;
        boolean z = dVar2.B;
        this.r = z;
        this.s = dVar2.z;
        this.t = dVar2.A;
        this.v = dVar2.y;
        int i = dVar2.s.j;
        this.w = i;
        this.u = i > 3;
        this.I = intent.getBooleanExtra("isVolumeOn", z);
        this.D = this.r ? this.m.q.g : this.m.q.h;
        com.ipd.dsp.internal.e1.d dVar3 = this.m;
        com.ipd.dsp.internal.e1.c cVar = dVar3.w;
        this.J = cVar.l;
        this.K = cVar.m;
        this.L = dVar3.r.b();
        if (this.m.w.g) {
            Runnable runnable = new Runnable() { // from class: com.zj.adlib.tqa
                @Override // java.lang.Runnable
                public final void run() {
                    this.f44989a.u();
                }
            };
            this.B = runnable;
            this.A = new f(this.m.w.h, runnable, null);
        }
        if (this.v) {
            activity.requestWindowFeature(1);
            activity.getWindow().setFlags(1024, 1024);
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                activity.getWindow().setAttributes(attributes);
                activity.getWindow().getDecorView().setSystemUiVisibility(1280);
            }
        }
    }

    public final /* synthetic */ void a(View view) {
        Object tag = view.getTag(R.id.ipd_custom_key_2);
        if (tag instanceof com.ipd.dsp.internal.x1.a) {
            try {
                b(view.getTag(R.id.ipd_custom_key_1) == Boolean.TRUE ? 2 : 1, (float[]) null, ((com.ipd.dsp.internal.x1.a) tag).a());
                return;
            } catch (Throwable unused) {
            }
        }
        if (view instanceof com.ipd.dsp.internal.x1.c) {
            try {
                b(1, (float[]) null, ((com.ipd.dsp.internal.x1.c) view).getTouchCoordsMap());
                return;
            } catch (Throwable unused2) {
            }
        }
        b(1, (float[]) null, this.p.getTouchCoordsMap());
    }

    private void a(int i, float[] fArr, Map<String, Object> map) {
        com.ipd.dsp.internal.j1.b bVar = this.n;
        if (bVar == null) {
            return;
        }
        com.ipd.dsp.internal.h1.a.a(bVar, this.k, i, fArr, map, new com.ipd.dsp.internal.h1.a.d() { // from class: com.zj.adlib.nqa
            @Override // com.ipd.dsp.internal.h1.a.d
            public final void a(Object obj) {
                this.f43591a.d((String) obj);
            }
        });
    }

    public final void a(boolean z) {
        com.ipd.dsp.internal.r1.a aVar = this.o;
        if (aVar != null) {
            aVar.c(-1);
        }
        Handler handler = this.C;
        if (handler != null) {
            handler.sendEmptyMessage(3);
        }
        if (this.H || !this.t || this.o == null) {
            if (z) {
                w();
                return;
            }
            return;
        }
        this.H = true;
        F();
        com.ipd.dsp.internal.v1.a aVar2 = this.q;
        if (aVar2 != null) {
            aVar2.j();
        }
        com.ipd.dsp.internal.r1.b bVar = this.p;
        if (bVar != null) {
            bVar.e();
        }
        this.o.a(this.m, (this.u && (this.p instanceof j) && TextUtils.isEmpty(this.m.o)) ? ((j) this.p).getVideoCapture() : null);
    }

    @Override // com.ipd.dsp.internal.b1.b.e
    public void a(long j, long j2) {
        com.ipd.dsp.internal.r1.a aVar = this.o;
        if (aVar != null && this.H) {
            aVar.setEndCardCTABtnText(o.a(j, j2));
            return;
        }
        com.ipd.dsp.internal.r1.b bVar = this.p;
        if (bVar == null || this.H) {
            return;
        }
        bVar.a(o.a(j, j2));
    }

    public final /* synthetic */ void b(View view) {
        b(1, (float[]) null, view instanceof com.ipd.dsp.internal.x1.c ? ((com.ipd.dsp.internal.x1.c) view).getTouchCoordsMap() : null);
        if (view instanceof com.ipd.dsp.internal.v1.a) {
            try {
                ((com.ipd.dsp.internal.v1.a) view).j();
            } catch (Throwable unused) {
            }
        }
    }

    public final boolean b(int i, float[] fArr, Map<String, Object> map) {
        if (this.x || this.o == null) {
            return false;
        }
        a(i, fArr, map);
        DspRewardVideoAd.InteractionListener interactionListener = O.get(this.l);
        if (interactionListener == null) {
            return true;
        }
        interactionListener.onRewardVideoClick();
        return true;
    }

    @Override // com.ipd.dsp.internal.z0.b
    public boolean b(int i) {
        com.ipd.dsp.internal.r1.a aVar;
        if (i == 4) {
            com.ipd.dsp.internal.e1.d dVar = this.m;
            if (dVar == null || !dVar.E || (aVar = this.o) == null || !aVar.i()) {
                return true;
            }
            this.o.j();
            return true;
        }
        return super.b(i);
    }

    @Override // com.ipd.dsp.internal.z0.b
    public void b(int i, int i2, @Nullable Intent intent) {
        super.b(i, i2, intent);
        Handler handler = this.C;
        if (handler != null && i == 9529 && i2 == 0) {
            handler.sendEmptyMessageDelayed(4, 100L);
        }
    }

    @Override // com.ipd.dsp.internal.z0.b
    public void b(Throwable th) {
        DspRewardVideoAd.InteractionListener interactionListener = O.get(this.l);
        if (interactionListener != null) {
            com.ipd.dsp.internal.f1.a aVarA = com.ipd.dsp.internal.f1.a.a(th);
            com.ipd.dsp.internal.j1.b bVar = this.n;
            if (bVar != null) {
                com.ipd.dsp.internal.h1.a.a(bVar, com.ipd.dsp.internal.h1.a.e.c, aVarA.toString());
            }
            interactionListener.onRewardVideoError(aVarA.f38306a, aVarA.b);
        }
    }
}
