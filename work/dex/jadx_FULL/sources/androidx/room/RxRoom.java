package androidx.room;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class RxRoom {
    public static final Object NOTHING = new Object();

    @Deprecated
    public RxRoom() {
    }

    public static Flowable<Object> createFlowable(final RoomDatabase database, final String... tableNames) {
        return Flowable.create(new FlowableOnSubscribe<Object>() { // from class: androidx.room.RxRoom.1
            public void subscribe(final FlowableEmitter<Object> emitter) throws Exception {
                final InvalidationTracker.Observer observer = new InvalidationTracker.Observer(tableNames) { // from class: androidx.room.RxRoom.1.1
                    @Override // androidx.room.InvalidationTracker.Observer
                    public void onInvalidated(@NonNull Set<String> tables) {
                        if (emitter.isCancelled()) {
                            return;
                        }
                        emitter.onNext(RxRoom.NOTHING);
                    }
                };
                if (!emitter.isCancelled()) {
                    database.getInvalidationTracker().addObserver(observer);
                    emitter.setDisposable(Disposables.fromAction(new Action() { // from class: androidx.room.RxRoom.1.2
                        public void run() throws Exception {
                            database.getInvalidationTracker().removeObserver(observer);
                        }
                    }));
                }
                if (emitter.isCancelled()) {
                    return;
                }
                emitter.onNext(RxRoom.NOTHING);
            }
        }, BackpressureStrategy.LATEST);
    }

    public static Observable<Object> createObservable(final RoomDatabase database, final String... tableNames) {
        return Observable.create(new ObservableOnSubscribe<Object>() { // from class: androidx.room.RxRoom.3
            public void subscribe(final ObservableEmitter<Object> emitter) throws Exception {
                final InvalidationTracker.Observer observer = new InvalidationTracker.Observer(tableNames) { // from class: androidx.room.RxRoom.3.1
                    @Override // androidx.room.InvalidationTracker.Observer
                    public void onInvalidated(@NonNull Set<String> tables) {
                        emitter.onNext(RxRoom.NOTHING);
                    }
                };
                database.getInvalidationTracker().addObserver(observer);
                emitter.setDisposable(Disposables.fromAction(new Action() { // from class: androidx.room.RxRoom.3.2
                    public void run() throws Exception {
                        database.getInvalidationTracker().removeObserver(observer);
                    }
                }));
                emitter.onNext(RxRoom.NOTHING);
            }
        });
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T> Single<T> createSingle(final Callable<T> callable) {
        return Single.create(new SingleOnSubscribe<T>() { // from class: androidx.room.RxRoom.5
            public void subscribe(SingleEmitter<T> emitter) throws Exception {
                try {
                    emitter.onSuccess(callable.call());
                } catch (EmptyResultSetException e) {
                    emitter.tryOnError(e);
                }
            }
        });
    }

    private static Executor getExecutor(RoomDatabase database, boolean inTransaction) {
        return inTransaction ? database.getTransactionExecutor() : database.getQueryExecutor();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static <T> Flowable<T> createFlowable(final RoomDatabase database, final String[] tableNames, final Callable<T> callable) {
        return createFlowable(database, false, tableNames, callable);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static <T> Observable<T> createObservable(final RoomDatabase database, final String[] tableNames, final Callable<T> callable) {
        return createObservable(database, false, tableNames, callable);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T> Flowable<T> createFlowable(final RoomDatabase database, final boolean inTransaction, final String[] tableNames, final Callable<T> callable) {
        Scheduler schedulerFrom = Schedulers.from(getExecutor(database, inTransaction));
        final Maybe maybeFromCallable = Maybe.fromCallable(callable);
        return createFlowable(database, tableNames).subscribeOn(schedulerFrom).unsubscribeOn(schedulerFrom).observeOn(schedulerFrom).flatMapMaybe(new Function<Object, MaybeSource<T>>() { // from class: androidx.room.RxRoom.2
            /* JADX INFO: renamed from: apply, reason: merged with bridge method [inline-methods] */
            public MaybeSource<T> m67apply(Object o) throws Exception {
                return maybeFromCallable;
            }
        });
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T> Observable<T> createObservable(final RoomDatabase database, final boolean inTransaction, final String[] tableNames, final Callable<T> callable) {
        Scheduler schedulerFrom = Schedulers.from(getExecutor(database, inTransaction));
        final Maybe maybeFromCallable = Maybe.fromCallable(callable);
        return createObservable(database, tableNames).subscribeOn(schedulerFrom).unsubscribeOn(schedulerFrom).observeOn(schedulerFrom).flatMapMaybe(new Function<Object, MaybeSource<T>>() { // from class: androidx.room.RxRoom.4
            /* JADX INFO: renamed from: apply, reason: merged with bridge method [inline-methods] */
            public MaybeSource<T> m68apply(Object o) throws Exception {
                return maybeFromCallable;
            }
        });
    }
}
