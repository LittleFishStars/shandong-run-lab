package com.huachenjie.login.util;

import android.os.Handler;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0006*\u0001\u0013\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0004R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/login/util/CountDownTimerHelper;", "", "", "millisUntilFinished", "", y6b.f, "f", "mMillisUntilFinished", "mCountdownInterval", y6b.g, "d", "Landroid/os/Handler;", "a", "Landroid/os/Handler;", "e", "()Landroid/os/Handler;", "handler", "J", "b", "com/huachenjie/login/util/CountDownTimerHelper$a", "Lcom/huachenjie/login/util/CountDownTimerHelper$a;", "countDownTask", "<init>", "(Landroid/os/Handler;)V", "login_release"}, k = 1, mv = {1, 8, 0})
public abstract class CountDownTimerHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public long mMillisUntilFinished;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Handler handler;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final a countDownTask;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public long mCountdownInterval;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/login/util/CountDownTimerHelper$a", "Ljava/lang/Runnable;", "", "run", "login_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CountDownTimerHelper.this.mMillisUntilFinished <= 0) {
                CountDownTimerHelper.this.f();
                return;
            }
            CountDownTimerHelper.this.mMillisUntilFinished -= CountDownTimerHelper.this.mCountdownInterval;
            CountDownTimerHelper.this.getHandler().postDelayed(this, CountDownTimerHelper.this.mCountdownInterval);
            CountDownTimerHelper countDownTimerHelper = CountDownTimerHelper.this;
            countDownTimerHelper.g(countDownTimerHelper.mMillisUntilFinished);
        }
    }

    public CountDownTimerHelper(@NotNull Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.handler = handler;
        this.countDownTask = new a();
    }

    public final void d() {
        this.handler.removeCallbacks(this.countDownTask);
    }

    @NotNull
    /* JADX INFO: renamed from: e, reason: from getter */
    public final Handler getHandler() {
        return this.handler;
    }

    public abstract void f();

    public abstract void g(long millisUntilFinished);

    public final void h(long mMillisUntilFinished, long mCountdownInterval) {
        this.mMillisUntilFinished = mMillisUntilFinished;
        this.mCountdownInterval = mCountdownInterval;
        d();
        g(mMillisUntilFinished);
        this.handler.postDelayed(this.countDownTask, mCountdownInterval);
    }
}
