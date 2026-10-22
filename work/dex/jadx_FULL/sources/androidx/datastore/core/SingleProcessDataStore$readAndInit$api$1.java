package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.sync.Mutex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001JD\u0010\u0002\u001a\u00028\u000021\u0010\u0003\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"androidx/datastore/core/SingleProcessDataStore$readAndInit$api$1", "Landroidx/datastore/core/InitializerApi;", "updateData", "transform", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "t", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SingleProcessDataStore$readAndInit$api$1<T> implements InitializerApi<T> {
    final /* synthetic */ Ref.ObjectRef<T> $initData;
    final /* synthetic */ Ref.BooleanRef $initializationComplete;
    final /* synthetic */ Mutex $updateLock;
    final /* synthetic */ SingleProcessDataStore<T> this$0;

    public SingleProcessDataStore$readAndInit$api$1(Mutex mutex, Ref.BooleanRef booleanRef, Ref.ObjectRef<T> objectRef, SingleProcessDataStore<T> singleProcessDataStore) {
        this.$updateLock = mutex;
        this.$initializationComplete = booleanRef;
        this.$initData = objectRef;
        this.this$0 = singleProcessDataStore;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00ba A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #0 {all -> 0x0056, blocks: (B:21:0x0052, B:36:0x00b2, B:38:0x00ba), top: B:53:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00c8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.datastore.core.InitializerApi
    @Nullable
    public Object updateData(@NotNull Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) throws Throwable {
        Continuation<? super Unit> singleProcessDataStore$readAndInit$api$1$updateData$1;
        Mutex mutex;
        SingleProcessDataStore singleProcessDataStore;
        Ref.BooleanRef booleanRef;
        Ref.ObjectRef<T> objectRef;
        Mutex mutex2;
        Mutex mutex3;
        SingleProcessDataStore singleProcessDataStore2;
        Object obj;
        Ref.ObjectRef<T> objectRef2;
        if (continuation instanceof SingleProcessDataStore$readAndInit$api$1$updateData$1) {
            singleProcessDataStore$readAndInit$api$1$updateData$1 = (SingleProcessDataStore$readAndInit$api$1$updateData$1) continuation;
            int i = singleProcessDataStore$readAndInit$api$1$updateData$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                singleProcessDataStore$readAndInit$api$1$updateData$1.label = i - Integer.MIN_VALUE;
            } else {
                singleProcessDataStore$readAndInit$api$1$updateData$1 = new SingleProcessDataStore$readAndInit$api$1$updateData$1(this, continuation);
            }
        } else {
            singleProcessDataStore$readAndInit$api$1$updateData$1 = new SingleProcessDataStore$readAndInit$api$1$updateData$1(this, continuation);
        }
        Object obj2 = singleProcessDataStore$readAndInit$api$1$updateData$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = singleProcessDataStore$readAndInit$api$1$updateData$1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj2);
                mutex = this.$updateLock;
                Ref.BooleanRef booleanRef2 = this.$initializationComplete;
                Ref.ObjectRef<T> objectRef3 = this.$initData;
                singleProcessDataStore = this.this$0;
                singleProcessDataStore$readAndInit$api$1$updateData$1.L$0 = function2;
                singleProcessDataStore$readAndInit$api$1$updateData$1.L$1 = mutex;
                singleProcessDataStore$readAndInit$api$1$updateData$1.L$2 = booleanRef2;
                singleProcessDataStore$readAndInit$api$1$updateData$1.L$3 = objectRef3;
                singleProcessDataStore$readAndInit$api$1$updateData$1.L$4 = singleProcessDataStore;
                singleProcessDataStore$readAndInit$api$1$updateData$1.label = 1;
                if (mutex.d((Object) null, singleProcessDataStore$readAndInit$api$1$updateData$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                booleanRef = booleanRef2;
                objectRef = objectRef3;
            } else {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        obj = singleProcessDataStore$readAndInit$api$1$updateData$1.L$2;
                        objectRef2 = (Ref.ObjectRef) singleProcessDataStore$readAndInit$api$1$updateData$1.L$1;
                        mutex2 = (Mutex) singleProcessDataStore$readAndInit$api$1$updateData$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            objectRef2.element = obj;
                            objectRef = objectRef2;
                            Object obj3 = objectRef.element;
                            mutex2.unlock((Object) null);
                            return obj3;
                        } catch (Throwable th) {
                            th = th;
                            mutex2.unlock((Object) null);
                            throw th;
                        }
                    }
                    SingleProcessDataStore singleProcessDataStore3 = (SingleProcessDataStore) singleProcessDataStore$readAndInit$api$1$updateData$1.L$2;
                    objectRef = (Ref.ObjectRef) singleProcessDataStore$readAndInit$api$1$updateData$1.L$1;
                    mutex3 = (Mutex) singleProcessDataStore$readAndInit$api$1$updateData$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        singleProcessDataStore2 = singleProcessDataStore3;
                        if (Intrinsics.areEqual(obj2, objectRef.element)) {
                            mutex2 = mutex3;
                        } else {
                            singleProcessDataStore$readAndInit$api$1$updateData$1.L$0 = mutex3;
                            singleProcessDataStore$readAndInit$api$1$updateData$1.L$1 = objectRef;
                            singleProcessDataStore$readAndInit$api$1$updateData$1.L$2 = obj2;
                            singleProcessDataStore$readAndInit$api$1$updateData$1.label = 3;
                            if (singleProcessDataStore2.writeData$datastore_core(obj2, singleProcessDataStore$readAndInit$api$1$updateData$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj = obj2;
                            objectRef2 = objectRef;
                            mutex2 = mutex3;
                            objectRef2.element = obj;
                            objectRef = objectRef2;
                        }
                        Object obj4 = objectRef.element;
                        mutex2.unlock((Object) null);
                        return obj4;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2 = mutex3;
                        mutex2.unlock((Object) null);
                        throw th;
                    }
                }
                SingleProcessDataStore singleProcessDataStore4 = (SingleProcessDataStore) singleProcessDataStore$readAndInit$api$1$updateData$1.L$4;
                objectRef = (Ref.ObjectRef) singleProcessDataStore$readAndInit$api$1$updateData$1.L$3;
                booleanRef = (Ref.BooleanRef) singleProcessDataStore$readAndInit$api$1$updateData$1.L$2;
                Mutex mutex4 = (Mutex) singleProcessDataStore$readAndInit$api$1$updateData$1.L$1;
                Function2<? super T, ? super Continuation<? super T>, ? extends Object> function3 = (Function2) singleProcessDataStore$readAndInit$api$1$updateData$1.L$0;
                ResultKt.throwOnFailure(obj2);
                mutex = mutex4;
                singleProcessDataStore = singleProcessDataStore4;
                function2 = function3;
            }
            if (booleanRef.element) {
                throw new IllegalStateException("InitializerApi.updateData should not be called after initialization is complete.");
            }
            Object obj5 = objectRef.element;
            singleProcessDataStore$readAndInit$api$1$updateData$1.L$0 = mutex;
            singleProcessDataStore$readAndInit$api$1$updateData$1.L$1 = objectRef;
            singleProcessDataStore$readAndInit$api$1$updateData$1.L$2 = singleProcessDataStore;
            singleProcessDataStore$readAndInit$api$1$updateData$1.L$3 = null;
            singleProcessDataStore$readAndInit$api$1$updateData$1.L$4 = null;
            singleProcessDataStore$readAndInit$api$1$updateData$1.label = 2;
            Object objInvoke = function2.invoke(obj5, singleProcessDataStore$readAndInit$api$1$updateData$1);
            if (objInvoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex3 = mutex;
            obj2 = objInvoke;
            singleProcessDataStore2 = singleProcessDataStore;
            if (Intrinsics.areEqual(obj2, objectRef.element)) {
                singleProcessDataStore$readAndInit$api$1$updateData$1.L$0 = mutex3;
                singleProcessDataStore$readAndInit$api$1$updateData$1.L$1 = objectRef;
                singleProcessDataStore$readAndInit$api$1$updateData$1.L$2 = obj2;
                singleProcessDataStore$readAndInit$api$1$updateData$1.label = 3;
                if (singleProcessDataStore2.writeData$datastore_core(obj2, singleProcessDataStore$readAndInit$api$1$updateData$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = obj2;
                objectRef2 = objectRef;
                mutex2 = mutex3;
                objectRef2.element = obj;
                objectRef = objectRef2;
            } else {
                mutex2 = mutex3;
            }
            Object obj6 = objectRef.element;
            mutex2.unlock((Object) null);
            return obj6;
        } catch (Throwable th3) {
            th = th3;
            mutex2 = mutex;
            mutex2.unlock((Object) null);
            throw th;
        }
    }
}
