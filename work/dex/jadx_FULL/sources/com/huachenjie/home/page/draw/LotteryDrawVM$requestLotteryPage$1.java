package com.huachenjie.home.page.draw;

import com.huachenjie.base.bean.FeaturedAwardBean;
import com.huachenjie.base.bean.JackpotBean;
import com.huachenjie.base.bean.LotteryDrawBean;
import com.huachenjie.home.api.HomeRequest;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.home.page.draw.LotteryDrawVM$requestLotteryPage$1", f = "LotteryDrawVM.kt", i = {}, l = {21}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nLotteryDrawVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LotteryDrawVM.kt\ncom/huachenjie/home/page/draw/LotteryDrawVM$requestLotteryPage$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,112:1\n1855#2,2:113\n*S KotlinDebug\n*F\n+ 1 LotteryDrawVM.kt\ncom/huachenjie/home/page/draw/LotteryDrawVM$requestLotteryPage$1\n*L\n25#1:113,2\n*E\n"})
public final class LotteryDrawVM$requestLotteryPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LotteryDrawVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LotteryDrawVM$requestLotteryPage$1(LotteryDrawVM lotteryDrawVM, Continuation<? super LotteryDrawVM$requestLotteryPage$1> continuation) {
        super(2, continuation);
        this.this$0 = lotteryDrawVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LotteryDrawVM$requestLotteryPage$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String awardNo;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.j().setValue(Boxing.boxBoolean(true));
            HomeRequest homeRequest = HomeRequest.f34197a;
            this.label = 1;
            obj = homeRequest.B(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        LotteryDrawBean lotteryDrawBean = (LotteryDrawBean) obj;
        if (lotteryDrawBean == null) {
            return Unit.INSTANCE;
        }
        LotteryDrawVM lotteryDrawVM = this.this$0;
        FeaturedAwardBean featuredAward = lotteryDrawBean.getFeaturedAward();
        if (featuredAward == null || (awardNo = featuredAward.getAwardNo()) == null) {
            awardNo = "";
        }
        int total = lotteryDrawBean.getInspiration().getTotal();
        for (JackpotBean jackpotBean : lotteryDrawBean.getJackpotList()) {
            if (jackpotBean.getJackpotType() == 3) {
                jackpotBean.setAwardNo(awardNo);
            } else {
                jackpotBean.setAwardNo("");
            }
            jackpotBean.setTotalInspiration(total);
        }
        FeaturedAwardBean featuredAward2 = lotteryDrawBean.getFeaturedAward();
        if (featuredAward2 != null) {
            lotteryDrawBean.getAwardList().add(0, featuredAward2);
        }
        lotteryDrawVM.k().setValue(lotteryDrawBean);
        return Unit.INSTANCE;
    }
}
