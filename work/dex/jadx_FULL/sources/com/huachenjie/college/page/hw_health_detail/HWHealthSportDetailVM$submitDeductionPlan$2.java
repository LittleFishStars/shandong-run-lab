package com.huachenjie.college.page.hw_health_detail;

import com.huachenjie.college.api.RequestModel;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.college.page.hw_health_detail.HWHealthSportDetailVM$submitDeductionPlan$2", f = "HWHealthSportDetailVM.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
public final class HWHealthSportDetailVM$submitDeductionPlan$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $dedPlanCode;
    final /* synthetic */ String $sportRecordCode;
    int label;
    final /* synthetic */ HWHealthSportDetailVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWHealthSportDetailVM$submitDeductionPlan$2(String str, String str2, HWHealthSportDetailVM hWHealthSportDetailVM, Continuation<? super HWHealthSportDetailVM$submitDeductionPlan$2> continuation) {
        super(2, continuation);
        this.$sportRecordCode = str;
        this.$dedPlanCode = str2;
        this.this$0 = hWHealthSportDetailVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new HWHealthSportDetailVM$submitDeductionPlan$2(this.$sportRecordCode, this.$dedPlanCode, this.this$0, continuation);
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
            RequestModel requestModel = RequestModel.f33549a;
            String str = this.$sportRecordCode;
            String str2 = this.$dedPlanCode;
            this.label = 1;
            if (requestModel.r(str, str2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.n().setValue(Boxing.boxBoolean(true));
        this.this$0.l().setValue(Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    }
}
