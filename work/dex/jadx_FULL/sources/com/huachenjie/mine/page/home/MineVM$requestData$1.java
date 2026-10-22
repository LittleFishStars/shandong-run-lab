package com.huachenjie.mine.page.home;

import com.huachenjie.base.bean.MineMateData;
import com.huachenjie.mine.bean.MineData;
import com.zj.adlib.v41;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mine.page.home.MineVM$requestData$1", f = "MineVM.kt", i = {0, 1}, l = {39, 40}, m = "invokeSuspend", n = {"task2", "metaData"}, s = {"L$0", "L$0"})
public final class MineVM$requestData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appUserCode;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MineVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MineVM$requestData$1(MineVM mineVM, String str, Continuation<? super MineVM$requestData$1> continuation) {
        super(2, continuation);
        this.this$0 = mineVM;
        this.$appUserCode = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        MineVM$requestData$1 mineVM$requestData$1 = new MineVM$requestData$1(this.this$0, this.$appUserCode, continuation);
        mineVM$requestData$1.L$0 = obj;
        return mineVM$requestData$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0070  */
    /* JADX WARN: Code duplicated, block: B:26:0x0073  */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Deferred deferred;
        MineMateData mineMateData;
        MineData mineData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                deferred = (Deferred) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mineMateData = (MineMateData) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            mineData = (MineData) obj;
            if (mineData == null) {
                return Unit.INSTANCE;
            }
            this.this$0.n().setValue(mineMateData);
            this.this$0.m().setValue(mineData);
            this.this$0.j(mineData.getNickName(), mineData.getAvatar(), mineData.getAvatarFrameImgUrl(), Boxing.boxBoolean(mineMateData.getBisVip()));
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Deferred deferredB = v41.b(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new MineVM$requestData$1$task1$1(this.$appUserCode, null), 3, (Object) null);
        Deferred deferredB2 = v41.b(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new MineVM$requestData$1$task2$1(this.$appUserCode, null), 3, (Object) null);
        this.L$0 = deferredB2;
        this.label = 1;
        Object objH = deferredB.H(this);
        if (objH == coroutine_suspended) {
            return coroutine_suspended;
        }
        deferred = deferredB2;
        obj = objH;
        MineMateData mineMateData2 = (MineMateData) obj;
        if (mineMateData2 == null) {
            return Unit.INSTANCE;
        }
        this.L$0 = mineMateData2;
        this.label = 2;
        Object objH2 = deferred.H(this);
        if (objH2 == coroutine_suspended) {
            return coroutine_suspended;
        }
        mineMateData = mineMateData2;
        obj = objH2;
        mineData = (MineData) obj;
        if (mineData == null) {
            return Unit.INSTANCE;
        }
        this.this$0.n().setValue(mineMateData);
        this.this$0.m().setValue(mineData);
        this.this$0.j(mineData.getNickName(), mineData.getAvatar(), mineData.getAvatarFrameImgUrl(), Boxing.boxBoolean(mineMateData.getBisVip()));
        return Unit.INSTANCE;
    }
}
