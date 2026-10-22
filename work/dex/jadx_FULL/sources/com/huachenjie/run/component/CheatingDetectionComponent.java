package com.huachenjie.run.component;

import android.os.Handler;
import android.os.Looper;
import com.huachenjie.common.base.BaseSimpleComponent;
import com.huachenjie.run.bean.CheatResult;
import com.zj.adlib.oj1;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class CheatingDetectionComponent extends BaseSimpleComponent {
    public final int K = 30000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f35438a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public DetectionCallback f11400a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ScheduledExecutorService f11401a;

    public interface DetectionCallback {
        void a(Map<Integer, CheatResult> cheatResult);
    }

    public CheatingDetectionComponent() {
        initExecutor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(Map map) {
        DetectionCallback detectionCallback = this.f11400a;
        if (detectionCallback != null) {
            detectionCallback.a(map);
        }
    }

    public final void e(final Map<Integer, CheatResult> cheatResult) {
        this.f35438a.post(new Runnable() { // from class: com.zj.adlib.pj1
            @Override // java.lang.Runnable
            public final void run() {
                this.f43992a.g(cheatResult);
            }
        });
    }

    public final void f() {
        Map<Integer, CheatResult> mapB = oj1.b();
        if (mapB.isEmpty()) {
            return;
        }
        e(mapB);
    }

    public void h(DetectionCallback callback) {
        this.f11400a = callback;
    }

    public final void initExecutor() {
        Runnable runnable = new Runnable() { // from class: com.zj.adlib.qj1
            @Override // java.lang.Runnable
            public final void run() {
                this.f44220a.f();
            }
        };
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f11401a = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        scheduledExecutorServiceNewSingleThreadScheduledExecutor.scheduleAtFixedRate(runnable, 30000L, 30000L, TimeUnit.MILLISECONDS);
    }

    @Override // com.huachenjie.common.base.BaseSimpleComponent, com.huachenjie.common.base.ILifecycleCallback
    public void onDestroy() {
        this.f11400a = null;
        stopExecutor();
        super.onDestroy();
    }

    public final void stopExecutor() {
        ScheduledExecutorService scheduledExecutorService = this.f11401a;
        if (scheduledExecutorService == null) {
            return;
        }
        try {
            try {
                scheduledExecutorService.shutdown();
                if (!this.f11401a.awaitTermination(30000L, TimeUnit.MILLISECONDS)) {
                    this.f11401a.shutdownNow();
                }
            } catch (InterruptedException unused) {
                this.f11401a.shutdownNow();
            }
        } finally {
            this.f11401a = null;
        }
    }
}
