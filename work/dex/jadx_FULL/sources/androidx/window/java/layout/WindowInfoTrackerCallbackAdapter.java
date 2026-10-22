package androidx.window.java.layout;

import android.app.Activity;
import androidx.core.util.Consumer;
import androidx.window.flow.WindowInfoTracker;
import androidx.window.flow.WindowLayoutInfo;
import com.byazt.hv.TTDownloadField;
import com.zj.adlib.h73;
import com.zj.adlib.v41;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.f;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J2\u0010\n\u001a\u00020\u000b\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\f0\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\f0\u0011H\u0002J$\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006J\u0014\u0010\u0016\u001a\u00020\u000b2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002J\u0014\u0010\u0017\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006J\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0096\u0001R\u001e\u0010\u0004\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/window/java/layout/WindowInfoTrackerCallbackAdapter;", "Landroidx/window/layout/WindowInfoTracker;", "tracker", "(Landroidx/window/layout/WindowInfoTracker;)V", "consumerToJobMap", "", "Landroidx/core/util/Consumer;", "Lkotlinx/coroutines/Job;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "addListener", "", "T", "executor", "Ljava/util/concurrent/Executor;", "consumer", "flow", "Lkotlinx/coroutines/flow/Flow;", "addWindowLayoutInfoListener", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "Landroidx/window/layout/WindowLayoutInfo;", "removeListener", "removeWindowLayoutInfoListener", "windowLayoutInfo", "window-java_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class WindowInfoTrackerCallbackAdapter implements WindowInfoTracker {

    @NotNull
    private final Map<Consumer<?>, Job> consumerToJobMap;

    @NotNull
    private final ReentrantLock lock;

    @NotNull
    private final WindowInfoTracker tracker;

    public WindowInfoTrackerCallbackAdapter(@NotNull WindowInfoTracker windowInfoTracker) {
        Intrinsics.checkNotNullParameter(windowInfoTracker, "tracker");
        this.tracker = windowInfoTracker;
        this.lock = new ReentrantLock();
        this.consumerToJobMap = new LinkedHashMap();
    }

    private final <T> void addListener(Executor executor, Consumer<T> consumer, Flow<? extends T> flow) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.consumerToJobMap.get(consumer) == null) {
                this.consumerToJobMap.put(consumer, v41.e(f.a(h73.c(executor)), (CoroutineContext) null, (CoroutineStart) null, new WindowInfoTrackerCallbackAdapter$addListener$1$1(flow, consumer, null), 3, (Object) null));
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void removeListener(Consumer<?> consumer) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Job job = this.consumerToJobMap.get(consumer);
            if (job != null) {
                Job.a.b(job, (CancellationException) null, 1, (Object) null);
            }
            this.consumerToJobMap.remove(consumer);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void addWindowLayoutInfoListener(@NotNull Activity activity, @NotNull Executor executor, @NotNull Consumer<WindowLayoutInfo> consumer) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        addListener(executor, consumer, this.tracker.windowLayoutInfo(activity));
    }

    public final void removeWindowLayoutInfoListener(@NotNull Consumer<WindowLayoutInfo> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        removeListener(consumer);
    }

    @Override // androidx.window.flow.WindowInfoTracker
    @NotNull
    public Flow<WindowLayoutInfo> windowLayoutInfo(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        return this.tracker.windowLayoutInfo(activity);
    }
}
