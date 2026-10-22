package com.huachenjie.common.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import com.huachenjie.common.run_component.StepComponent;
import com.huachenjie.common.step.StepValuePassListener;
import com.igexin.sdk.PushConsts;
import com.zj.adlib.hr8;
import com.zj.adlib.om2;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class StepService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f33898a = 27000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Sensor f8877a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SensorManager f8878a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Handler f8879a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public StepComponent.StepChangeCallBack f8880a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f8882a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public hr8 f8883a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final StepBinder f8881a = new StepBinder();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f8884a = true;
    public int K = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BroadcastReceiver f8876a = new BroadcastReceiver() { // from class: com.huachenjie.common.service.StepService.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(final Context context, final Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.SCREEN_ON".equals(action)) {
                StepService.this.f8879a.removeCallbacks(StepService.this.f8882a);
            } else if (!"android.intent.action.SCREEN_OFF".equals(action)) {
                PushConsts.ACTION_BROADCAST_USER_PRESENT.equals(action);
            } else {
                StepService.this.f8879a.removeCallbacks(StepService.this.f8882a);
                StepService.this.f8879a.postDelayed(StepService.this.f8882a, StepService.f33898a);
            }
        }
    };

    public class StepBinder extends Binder {
        public StepBinder() {
        }

        public StepService getService() {
            return StepService.this;
        }
    }

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<StepService> f33900a;

        public a(StepService service) {
            if (service != null) {
                this.f33900a = new WeakReference<>(service);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            StepService stepService;
            WeakReference<StepService> weakReference = this.f33900a;
            if (weakReference == null || (stepService = weakReference.get()) == null) {
                return;
            }
            stepService.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(int i) {
        if (this.f8884a) {
            return;
        }
        int i2 = this.K + i;
        this.K = i2;
        l(i2);
    }

    public final void e() {
        hr8 hr8Var = new hr8();
        this.f8883a = hr8Var;
        this.f8878a.registerListener(hr8Var.c(), this.f8877a, 0);
        this.f8883a.d(new StepValuePassListener() { // from class: com.zj.adlib.rr8
            @Override // com.huachenjie.common.step.StepValuePassListener
            public final void a(int i) {
                this.f44519a.g(i);
            }
        });
    }

    public final void f() {
        if (this.f8877a == null) {
            this.f8877a = this.f8878a.getDefaultSensor(1);
        }
        if (this.f8877a != null) {
            e();
        }
    }

    public final void h() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_USER_PRESENT);
        registerReceiver(this.f8876a, intentFilter);
    }

    public final void i() {
        this.K = 0;
    }

    public final void j() {
        if (this.f8878a != null) {
            this.f8878a = null;
        }
        this.f8878a = (SensorManager) getSystemService("sensor");
        f();
    }

    public final void k() {
        hr8 hr8Var;
        SensorManager sensorManager = this.f8878a;
        if (sensorManager == null || this.f8877a == null || (hr8Var = this.f8883a) == null) {
            return;
        }
        sensorManager.unregisterListener(hr8Var.c());
    }

    public final void l(int stepCount) {
        StepComponent.StepChangeCallBack stepChangeCallBack = this.f8880a;
        if (stepChangeCallBack != null) {
            stepChangeCallBack.a(stepCount);
        }
    }

    public final void m() {
        om2.d(this, 3000L, StepService.class.getName());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f8881a;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        i();
        this.f8879a = new Handler();
        this.f8882a = new a(this);
        h();
        j();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.f8876a);
        this.f8879a.removeCallbacksAndMessages(null);
        this.f8882a = null;
        i();
        k();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        return 1;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public void pauseStep() {
        this.f8884a = true;
    }

    public void registerCallback(StepComponent.StepChangeCallBack callback) {
        this.f8880a = callback;
    }

    public void resumeStep() {
        this.f8884a = false;
    }
}
