package androidx.room;

import android.annotation.SuppressLint;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.p002lifecycle.LiveData;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
class RoomTrackingLiveData<T> extends LiveData<T> {
    final Callable<T> mComputeFunction;
    private final InvalidationLiveDataContainer mContainer;
    final RoomDatabase mDatabase;
    final boolean mInTransaction;
    final InvalidationTracker.Observer mObserver;
    final AtomicBoolean mInvalid = new AtomicBoolean(true);
    final AtomicBoolean mComputing = new AtomicBoolean(false);
    final AtomicBoolean mRegisteredObserver = new AtomicBoolean(false);
    final Runnable mRefreshRunnable = new Runnable() { // from class: androidx.room.RoomTrackingLiveData.1
        /* JADX WARN: Bottom block not found for handler: all -> 0x0053 */
        @Override // java.lang.Runnable
        @WorkerThread
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z;
            if (RoomTrackingLiveData.this.mRegisteredObserver.compareAndSet(false, true)) {
                RoomTrackingLiveData.this.mDatabase.getInvalidationTracker().addWeakObserver(RoomTrackingLiveData.this.mObserver);
            }
            do {
                if (RoomTrackingLiveData.this.mComputing.compareAndSet(false, true)) {
                    T tCall = null;
                    z = false;
                    while (RoomTrackingLiveData.this.mInvalid.compareAndSet(true, false)) {
                        try {
                            tCall = RoomTrackingLiveData.this.mComputeFunction.call();
                            z = true;
                        } catch (Exception e) {
                            throw new RuntimeException("Exception while computing database live data.", e);
                        }
                    }
                    if (z) {
                        RoomTrackingLiveData.this.postValue(tCall);
                    }
                    RoomTrackingLiveData.this.mComputing.set(false);
                } else {
                    z = false;
                }
                if (!z) {
                    return;
                }
            } while (RoomTrackingLiveData.this.mInvalid.get());
        }
    };
    final Runnable mInvalidationRunnable = new Runnable() { // from class: androidx.room.RoomTrackingLiveData.2
        @Override // java.lang.Runnable
        @MainThread
        public void run() {
            boolean zHasActiveObservers = RoomTrackingLiveData.this.hasActiveObservers();
            if (RoomTrackingLiveData.this.mInvalid.compareAndSet(false, true) && zHasActiveObservers) {
                RoomTrackingLiveData.this.getQueryExecutor().execute(RoomTrackingLiveData.this.mRefreshRunnable);
            }
        }
    };

    @SuppressLint({"RestrictedApi"})
    public RoomTrackingLiveData(RoomDatabase database, InvalidationLiveDataContainer container, boolean inTransaction, Callable<T> computeFunction, String[] tableNames) {
        this.mDatabase = database;
        this.mInTransaction = inTransaction;
        this.mComputeFunction = computeFunction;
        this.mContainer = container;
        this.mObserver = new InvalidationTracker.Observer(tableNames) { // from class: androidx.room.RoomTrackingLiveData.3
            @Override // androidx.room.InvalidationTracker.Observer
            public void onInvalidated(@NonNull Set<String> tables) {
                ArchTaskExecutor.getInstance().executeOnMainThread(RoomTrackingLiveData.this.mInvalidationRunnable);
            }
        };
    }

    public Executor getQueryExecutor() {
        return this.mInTransaction ? this.mDatabase.getTransactionExecutor() : this.mDatabase.getQueryExecutor();
    }

    @Override // androidx.p002lifecycle.LiveData
    public void onActive() {
        super.onActive();
        this.mContainer.onActive(this);
        getQueryExecutor().execute(this.mRefreshRunnable);
    }

    @Override // androidx.p002lifecycle.LiveData
    public void onInactive() {
        super.onInactive();
        this.mContainer.onInactive(this);
    }
}
