package androidx.camera.view;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.arch.core.util.Function;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Pair;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(api = 21)
class PendingValue<T> {

    @Nullable
    private Pair<CallbackToFutureAdapter.Completer<Void>, T> mCompleterAndValue;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$setValue$0(Object obj, CallbackToFutureAdapter.Completer completer) throws Exception {
        Pair<CallbackToFutureAdapter.Completer<Void>, T> pair = this.mCompleterAndValue;
        if (pair != null) {
            CallbackToFutureAdapter.Completer<Void> completer2 = pair.first;
            Objects.requireNonNull(completer2);
            completer2.setCancelled();
        }
        this.mCompleterAndValue = new Pair<>(completer, obj);
        return "PendingValue " + obj;
    }

    @MainThread
    public void propagateIfHasValue(Function<T, ListenableFuture<Void>> function) {
        Threads.checkMainThread();
        Pair<CallbackToFutureAdapter.Completer<Void>, T> pair = this.mCompleterAndValue;
        if (pair != null) {
            ListenableFuture<Void> listenableFutureApply = function.apply(pair.second);
            CallbackToFutureAdapter.Completer<Void> completer = this.mCompleterAndValue.first;
            Objects.requireNonNull(completer);
            Futures.propagate(listenableFutureApply, completer);
            this.mCompleterAndValue = null;
        }
    }

    @MainThread
    public ListenableFuture<Void> setValue(@NonNull final T t) {
        Threads.checkMainThread();
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.view.e
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f21432a.lambda$setValue$0(t, completer);
            }
        });
    }
}
