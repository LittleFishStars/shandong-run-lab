package com.huachenjie.common.run_component;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huachenjie.common.base.BaseSimpleComponent;
import com.huachenjie.common.run_interface.IRunTimeStateChangeListener;
import com.huachenjie.common.run_interface.RunStateChangeListener;
import com.zj.adlib.i4a;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class TimeComponent extends BaseSimpleComponent implements IRunTimeStateChangeListener {
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f33890a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f8866a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public PauseTimerType f8867a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TimeChangeListener f8868a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Runnable f8869a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ScheduledExecutorService f8870a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ThreadFactory f8871a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f8872a;
    public final String f;

    public interface TimeChangeListener {
        void a(long elapsedTime, PauseTimerType type);
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f33891a;

        static {
            int[] iArr = new int[RunStateChangeListener.State.values().length];
            f33891a = iArr;
            try {
                iArr[RunStateChangeListener.State.normal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33891a[RunStateChangeListener.State.userPause.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33891a[RunStateChangeListener.State.autoPause.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33891a[RunStateChangeListener.State.faceRecognition.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33891a[RunStateChangeListener.State.nfcCheck.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f33891a[RunStateChangeListener.State.finish.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public TimeComponent(@NonNull ThreadFactory threadFactory) {
        this(threadFactory, PauseTimerType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        TimeChangeListener timeChangeListener = this.f8868a;
        if (timeChangeListener != null) {
            timeChangeListener.a(this.f33890a, this.f8867a);
        } else {
            i4a.d(this.f, "mTimeChangeListener IS null, 没法通知外层时间更新");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        this.f33890a += (long) this.K;
        this.f8866a.post(new Runnable() { // from class: com.zj.adlib.z69
            @Override // java.lang.Runnable
            public final void run() {
                this.f46197a.f();
            }
        });
    }

    @Override // com.huachenjie.common.run_interface.IRunTimeStateChangeListener
    public void a(@Nullable PauseTimerType pauseTimerType, @Nullable RunStateChangeListener.State state, @Nullable Map<String, ?> map) {
        switch (a.f33891a[state.ordinal()]) {
            case 1:
                if (pauseTimerType == null || PauseTimerType.NONE == pauseTimerType || PauseTimerType.SPEED_ERROR == pauseTimerType) {
                    k();
                } else {
                    h();
                }
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                if (pauseTimerType == null || PauseTimerType.NONE == pauseTimerType || PauseTimerType.SPEED_ERROR == pauseTimerType) {
                    h();
                } else {
                    k();
                }
                break;
            case 6:
                h();
                i();
                break;
        }
    }

    @Override // com.huachenjie.common.run_interface.RunStateChangeListener
    public void b(RunStateChangeListener.State state, Map<String, Object> map) {
        a(PauseTimerType.NONE, state, map);
    }

    public boolean e() {
        return this.f8872a;
    }

    public void h() {
        if (this.f8872a) {
            this.f8872a = false;
            stopExecutor();
            PauseTimerType pauseTimerType = this.f8867a;
            if (pauseTimerType == null || pauseTimerType == PauseTimerType.NONE) {
                return;
            }
            i4a.b(this.f, this.f8867a + "|计时器 暂停工作*****");
        }
    }

    public void i() {
        this.f33890a = 0L;
    }

    public void initData() {
        i();
        initExecutor();
    }

    public void initExecutor() {
        this.f8869a = new Runnable() { // from class: com.zj.adlib.y69
            @Override // java.lang.Runnable
            public final void run() {
                this.f45963a.g();
            }
        };
    }

    public void j(TimeChangeListener listener) {
        this.f8868a = listener;
    }

    public void k() {
        if (this.f8872a) {
            return;
        }
        this.f8872a = true;
        if (this.f8870a != null) {
            stopExecutor();
        }
        ThreadFactory threadFactory = this.f8871a;
        if (threadFactory == null) {
            this.f8870a = Executors.newSingleThreadScheduledExecutor();
        } else {
            this.f8870a = Executors.newSingleThreadScheduledExecutor(threadFactory);
        }
        ScheduledExecutorService scheduledExecutorService = this.f8870a;
        Runnable runnable = this.f8869a;
        int i = this.K;
        scheduledExecutorService.scheduleAtFixedRate(runnable, i, i, TimeUnit.MILLISECONDS);
        PauseTimerType pauseTimerType = this.f8867a;
        if (pauseTimerType == null || pauseTimerType == PauseTimerType.NONE) {
            return;
        }
        i4a.b(this.f, this.f8867a + "|计时器开始工作");
    }

    @Override // com.huachenjie.common.base.BaseSimpleComponent, com.huachenjie.common.base.ILifecycleCallback
    public void onDestroy() {
        this.f8872a = false;
        stopExecutor();
        this.f8868a = null;
        super.onDestroy();
    }

    public void stopExecutor() {
        ScheduledExecutorService scheduledExecutorService = this.f8870a;
        if (scheduledExecutorService == null) {
            return;
        }
        try {
            try {
                scheduledExecutorService.shutdown();
                if (!this.f8870a.awaitTermination(this.K, TimeUnit.MILLISECONDS)) {
                    this.f8870a.shutdownNow();
                }
            } catch (InterruptedException unused) {
                this.f8870a.shutdownNow();
            }
        } finally {
            this.f8870a = null;
        }
    }

    public TimeComponent(@NonNull ThreadFactory threadFactory, @Nullable PauseTimerType type) {
        this.f8866a = new Handler(Looper.getMainLooper());
        this.f = getClass().getSimpleName();
        this.f33890a = 0L;
        this.K = 1000;
        this.f8872a = false;
        this.f8871a = threadFactory;
        this.f8867a = type;
        initData();
    }
}
