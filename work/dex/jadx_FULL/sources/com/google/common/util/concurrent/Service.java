package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@DoNotMock("Create an AbstractIdleService")
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public interface Service {

    public static abstract class Listener {
        public void a(State state, Throwable th) {
        }

        public void b() {
        }

        public void c() {
        }

        public void d(State state) {
        }

        public void e(State state) {
        }
    }

    public enum State {
        NEW,
        STARTING,
        RUNNING,
        STOPPING,
        TERMINATED,
        FAILED
    }

    void a();

    void b(Listener listener, Executor executor);

    @CanIgnoreReturnValue
    Service c();

    @CanIgnoreReturnValue
    Service d();

    Throwable e();

    void f(long j, TimeUnit timeUnit) throws TimeoutException;

    void g();

    void h(long j, TimeUnit timeUnit) throws TimeoutException;

    State i();

    boolean isRunning();
}
