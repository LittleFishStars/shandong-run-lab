package com.huachenjie.run.page.run_index;

import com.huachenjie.common.bean.SunshineRunDetail;
import com.huachenjie.run.model.RunRequestModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.run.page.run_index.RunIndexVM$queryRunDetail$1", f = "RunIndexVM.kt", i = {}, l = {331}, m = "invokeSuspend", n = {}, s = {})
public final class RunIndexVM$queryRunDetail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<SunshineRunDetail, Unit> $onSuccess;
    final /* synthetic */ String $runPlanCode;
    final /* synthetic */ String $semesterCode;
    final /* synthetic */ int $sportType;
    int label;
    final /* synthetic */ RunIndexVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RunIndexVM$queryRunDetail$1(String str, String str2, int i, RunIndexVM runIndexVM, Function1<? super SunshineRunDetail, Unit> function1, Continuation<? super RunIndexVM$queryRunDetail$1> continuation) {
        super(2, continuation);
        this.$semesterCode = str;
        this.$runPlanCode = str2;
        this.$sportType = i;
        this.this$0 = runIndexVM;
        this.$onSuccess = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RunIndexVM$queryRunDetail$1(this.$semesterCode, this.$runPlanCode, this.$sportType, this.this$0, this.$onSuccess, continuation);
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
            RunRequestModel runRequestModel = RunRequestModel.f35764a;
            String str = this.$semesterCode;
            String str2 = this.$runPlanCode;
            int i2 = this.$sportType;
            this.label = 1;
            obj = runRequestModel.x(str, str2, i2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        SunshineRunDetail sunshineRunDetail = (SunshineRunDetail) obj;
        this.this$0.i0().setValue(sunshineRunDetail);
        if (sunshineRunDetail != null) {
            Function1<SunshineRunDetail, Unit> function1 = this.$onSuccess;
            EventBus.f().q(sunshineRunDetail);
            if (function1 != null) {
                function1.invoke(sunshineRunDetail);
            }
        }
        return Unit.INSTANCE;
    }
}
