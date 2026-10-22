package com.huachenjie.home.page.draw;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.home.api.HomeRequest;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.home.page.draw.LotteryDrawVM$querySignTodayStatus$1", f = "LotteryDrawVM.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
public final class LotteryDrawVM$querySignTodayStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ LotteryDrawVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LotteryDrawVM$querySignTodayStatus$1(LotteryDrawVM lotteryDrawVM, Continuation<? super LotteryDrawVM$querySignTodayStatus$1> continuation) {
        super(2, continuation);
        this.this$0 = lotteryDrawVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LotteryDrawVM$querySignTodayStatus$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableLiveData<Boolean> mutableLiveDataN = this.this$0.n();
            HomeRequest homeRequest = HomeRequest.f34197a;
            this.L$0 = mutableLiveDataN;
            this.label = 1;
            Object objV = homeRequest.v(this);
            if (objV == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData = mutableLiveDataN;
            obj = objV;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableLiveData = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        mutableLiveData.setValue(obj);
        return Unit.INSTANCE;
    }
}
