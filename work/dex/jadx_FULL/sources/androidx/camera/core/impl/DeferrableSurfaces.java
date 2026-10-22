package androidx.camera.core.impl;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public final class DeferrableSurfaces {
    private DeferrableSurfaces() {
    }

    public static void decrementAll(@NonNull List<DeferrableSurface> list) {
        Iterator<DeferrableSurface> it = list.iterator();
        while (it.hasNext()) {
            it.next().decrementUseCount();
        }
    }

    public static void incrementAll(@NonNull List<DeferrableSurface> list) throws DeferrableSurface.SurfaceClosedException {
        if (list.isEmpty()) {
            return;
        }
        int i = 0;
        do {
            try {
                list.get(i).incrementUseCount();
                i++;
            } catch (DeferrableSurface.SurfaceClosedException e) {
                for (int i2 = i - 1; i2 >= 0; i2--) {
                    list.get(i2).decrementUseCount();
                }
                throw e;
            }
        } while (i < list.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$surfaceListWithTimeout$0(ListenableFuture listenableFuture, CallbackToFutureAdapter.Completer completer, long j) {
        if (listenableFuture.isDone()) {
            return;
        }
        completer.setException(new TimeoutException("Cannot complete surfaceList within " + j));
        listenableFuture.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$surfaceListWithTimeout$1(Executor executor, final ListenableFuture listenableFuture, final CallbackToFutureAdapter.Completer completer, final long j) {
        executor.execute(new Runnable(listenableFuture, completer, j) { // from class: com.zj.adlib.gk2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f41926a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ CallbackToFutureAdapter.Completer f16800a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ ListenableFuture f16801a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$surfaceListWithTimeout$3(List list, ScheduledExecutorService scheduledExecutorService, final Executor executor, final long j, final boolean z, final CallbackToFutureAdapter.Completer completer) throws Exception {
        final ListenableFuture listenableFutureSuccessfulAsList = Futures.successfulAsList(list);
        final ScheduledFuture<?> scheduledFutureSchedule = scheduledExecutorService.schedule(new Runnable(executor, listenableFutureSuccessfulAsList, completer, j) { // from class: com.zj.adlib.hk2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f42143a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ CallbackToFutureAdapter.Completer f16993a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ ListenableFuture f16994a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Executor f16995a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        }, j, TimeUnit.MILLISECONDS);
        completer.addCancellationListener(new Runnable(listenableFutureSuccessfulAsList) { // from class: com.zj.adlib.ik2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ListenableFuture f42376a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        }, executor);
        Futures.addCallback(listenableFutureSuccessfulAsList, new FutureCallback<List<Surface>>() { // from class: androidx.camera.core.impl.DeferrableSurfaces.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
                completer.set(Collections.unmodifiableList(Collections.emptyList()));
                scheduledFutureSchedule.cancel(true);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable List<Surface> list2) {
                ArrayList arrayList = new ArrayList(list2);
                if (z) {
                    arrayList.removeAll(Collections.singleton(null));
                }
                completer.set(arrayList);
                scheduledFutureSchedule.cancel(true);
            }
        }, executor);
        return "surfaceList";
    }

    @NonNull
    public static ListenableFuture<List<Surface>> surfaceListWithTimeout(@NonNull Collection<DeferrableSurface> collection, final boolean z, final long j, @NonNull final Executor executor, @NonNull final ScheduledExecutorService scheduledExecutorService) {
        final ArrayList arrayList = new ArrayList();
        Iterator<DeferrableSurface> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(Futures.nonCancellationPropagating(it.next().getSurface()));
        }
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(arrayList, scheduledExecutorService, executor, j, z) { // from class: com.zj.adlib.jk2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f42606a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ List f17410a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Executor f17411a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ ScheduledExecutorService f17412a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ boolean f17413a;

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
            }
        });
    }

    public static boolean tryIncrementAll(@NonNull List<DeferrableSurface> list) {
        try {
            incrementAll(list);
            return true;
        } catch (DeferrableSurface.SurfaceClosedException unused) {
            return false;
        }
    }
}
