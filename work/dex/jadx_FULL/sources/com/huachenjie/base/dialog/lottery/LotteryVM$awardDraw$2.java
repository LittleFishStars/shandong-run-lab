package com.huachenjie.base.dialog.lottery;

import com.huachenjie.base.api.RequestModel;
import com.huachenjie.base.bean.reward.RewardInfoBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.base.dialog.lottery.LotteryVM$awardDraw$2", f = "LotteryVM.kt", i = {}, l = {21, 23}, m = "invokeSuspend", n = {}, s = {})
public final class LotteryVM$awardDraw$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $awardNo;
    final /* synthetic */ int $inspiration;
    final /* synthetic */ String $lotteryNo;
    final /* synthetic */ int $source;
    int label;
    final /* synthetic */ LotteryVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LotteryVM$awardDraw$2(int i, String str, int i2, String str2, LotteryVM lotteryVM, Continuation<? super LotteryVM$awardDraw$2> continuation) {
        super(2, continuation);
        this.$source = i;
        this.$lotteryNo = str;
        this.$inspiration = i2;
        this.$awardNo = str2;
        this.this$0 = lotteryVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LotteryVM$awardDraw$2(this.$source, this.$lotteryNo, this.$inspiration, this.$awardNo, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        RewardInfoBean rewardInfoBean;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$source == 1) {
                RequestModel requestModel = RequestModel.f32789a;
                String str = this.$lotteryNo;
                int i2 = this.$inspiration;
                String str2 = this.$awardNo;
                this.label = 1;
                obj = requestModel.d(str, i2, str2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                rewardInfoBean = (RewardInfoBean) obj;
            } else {
                RequestModel requestModel2 = RequestModel.f32789a;
                String str3 = this.$lotteryNo;
                int i3 = this.$inspiration;
                String str4 = this.$awardNo;
                this.label = 2;
                obj = requestModel2.e(str3, i3, str4, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                rewardInfoBean = (RewardInfoBean) obj;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            rewardInfoBean = (RewardInfoBean) obj;
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            rewardInfoBean = (RewardInfoBean) obj;
        }
        this.this$0.j().setValue(Boxing.boxInt(1));
        this.this$0.k().setValue(rewardInfoBean);
        return Unit.INSTANCE;
    }
}
