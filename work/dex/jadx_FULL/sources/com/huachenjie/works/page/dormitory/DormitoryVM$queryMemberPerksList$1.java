package com.huachenjie.works.page.dormitory;

import com.huachenjie.works.R;
import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.dorm.DormExchangeBean;
import com.zj.adlib.ys8;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.dormitory.DormitoryVM$queryMemberPerksList$1", f = "DormitoryVM.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
public final class DormitoryVM$queryMemberPerksList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<DormExchangeBean, Unit> $callback;
    int label;
    final /* synthetic */ DormitoryVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DormitoryVM$queryMemberPerksList$1(DormitoryVM dormitoryVM, Function1<? super DormExchangeBean, Unit> function1, Continuation<? super DormitoryVM$queryMemberPerksList$1> continuation) {
        super(2, continuation);
        this.this$0 = dormitoryVM;
        this.$callback = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DormitoryVM$queryMemberPerksList$1(this.this$0, this.$callback, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f36762a;
            this.label = 1;
            obj = requestModel.U(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        DormExchangeBean dormExchangeBean = (DormExchangeBean) obj;
        if (dormExchangeBean != null) {
            DormitoryVM dormitoryVM = this.this$0;
            Function1<DormExchangeBean, Unit> function1 = this.$callback;
            if (dormExchangeBean.getList().isEmpty()) {
                String strE = ys8.e(R.string.works_dormitory_exchange_none);
                Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.works_dormitory_exchange_none)");
                dormitoryVM.h(strE);
                return Unit.INSTANCE;
            }
            function1.invoke(dormExchangeBean);
        }
        return Unit.INSTANCE;
    }
}
