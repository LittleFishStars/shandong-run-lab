package androidx.room.guava;

import android.annotation.SuppressLint;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@SuppressLint({"RestrictedAPI"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class GuavaRoom {
    private static Executor sDirectExecutor = new Executor() { // from class: androidx.room.guava.GuavaRoom.4
        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            runnable.run();
        }
    };

    private GuavaRoom() {
    }

    @Deprecated
    public static <T> ListenableFuture<T> createListenableFuture(final Callable<T> callable, final RoomSQLiteQuery query, final boolean releaseQuery) {
        return createListenableFuture(ArchTaskExecutor.getIOThreadExecutor(), callable, query, releaseQuery, (CancellationSignal) null);
    }

    private static Executor getExecutor(RoomDatabase database, boolean inTransaction) {
        return inTransaction ? database.getTransactionExecutor() : database.getQueryExecutor();
    }

    @Deprecated
    public static <T> ListenableFuture<T> createListenableFuture(final RoomDatabase roomDatabase, final Callable<T> callable, final RoomSQLiteQuery query, final boolean releaseQuery) {
        return createListenableFuture(roomDatabase.getQueryExecutor(), callable, query, releaseQuery, (CancellationSignal) null);
    }

    @SuppressLint({"LambdaLast"})
    public static <T> ListenableFuture<T> createListenableFuture(final RoomDatabase roomDatabase, final boolean inTransaction, final Callable<T> callable, final RoomSQLiteQuery query, final boolean releaseQuery) {
        return createListenableFuture(getExecutor(roomDatabase, inTransaction), callable, query, releaseQuery, (CancellationSignal) null);
    }

    @NonNull
    public static <T> ListenableFuture<T> createListenableFuture(@NonNull final RoomDatabase roomDatabase, final boolean inTransaction, @NonNull final Callable<T> callable, @NonNull final RoomSQLiteQuery query, final boolean releaseQuery, @Nullable final CancellationSignal cancellationSignal) {
        return createListenableFuture(getExecutor(roomDatabase, inTransaction), callable, query, releaseQuery, cancellationSignal);
    }

    private static <T> ListenableFuture<T> createListenableFuture(final Executor executor, final Callable<T> callable, final RoomSQLiteQuery query, final boolean releaseQuery, @Nullable final CancellationSignal cancellationSignal) {
        final ListenableFuture<T> listenableFutureCreateListenableFuture = createListenableFuture(executor, callable);
        if (cancellationSignal != null) {
            listenableFutureCreateListenableFuture.addListener(new Runnable() { // from class: androidx.room.guava.GuavaRoom.1
                @Override // java.lang.Runnable
                public void run() {
                    if (listenableFutureCreateListenableFuture.isCancelled()) {
                        cancellationSignal.cancel();
                    }
                }
            }, sDirectExecutor);
        }
        if (releaseQuery) {
            listenableFutureCreateListenableFuture.addListener(new Runnable() { // from class: androidx.room.guava.GuavaRoom.2
                @Override // java.lang.Runnable
                public void run() {
                    query.release();
                }
            }, sDirectExecutor);
        }
        return listenableFutureCreateListenableFuture;
    }

    @NonNull
    @Deprecated
    public static <T> ListenableFuture<T> createListenableFuture(@NonNull final RoomDatabase roomDatabase, @NonNull final Callable<T> callable) {
        return createListenableFuture(roomDatabase, false, (Callable) callable);
    }

    @NonNull
    public static <T> ListenableFuture<T> createListenableFuture(@NonNull final RoomDatabase roomDatabase, final boolean inTransaction, @NonNull final Callable<T> callable) {
        return createListenableFuture(getExecutor(roomDatabase, inTransaction), callable);
    }

    @NonNull
    private static <T> ListenableFuture<T> createListenableFuture(@NonNull final Executor executor, @NonNull final Callable<T> callable) {
        final ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        executor.execute(new Runnable() { // from class: androidx.room.guava.GuavaRoom.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    resolvableFutureCreate.set(callable.call());
                } catch (Throwable th) {
                    resolvableFutureCreate.setException(th);
                }
            }
        });
        return resolvableFutureCreate;
    }
}
