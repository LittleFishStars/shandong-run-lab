package com.huachenjie.run.model;

import com.huachenjie.common.bean.SunshineRunDetail;
import com.huachenjie.common.reconfig.net.IResponse;
import com.huachenjie.run.api.ISunshineApi;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u008a@"}, d2 = {"Lcom/huachenjie/common/reconfig/net/IResponse;", "Lcom/huachenjie/common/bean/SunshineRunDetail;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.run.model.RunRequestModel$querySunRunAbstractInfo$2", f = "RunRequestModel.kt", i = {}, l = {185}, m = "invokeSuspend", n = {}, s = {})
public final class RunRequestModel$querySunRunAbstractInfo$2 extends SuspendLambda implements Function1<Continuation<? super IResponse<SunshineRunDetail>>, Object> {
    final /* synthetic */ String $runPlanCode;
    final /* synthetic */ String $semesterCode;
    final /* synthetic */ int $sportType;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RunRequestModel$querySunRunAbstractInfo$2(String str, String str2, int i, Continuation<? super RunRequestModel$querySunRunAbstractInfo$2> continuation) {
        super(1, continuation);
        this.$semesterCode = str;
        this.$runPlanCode = str2;
        this.$sportType = i;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new RunRequestModel$querySunRunAbstractInfo$2(this.$semesterCode, this.$runPlanCode, this.$sportType, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super IResponse<SunshineRunDetail>> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ISunshineApi iSunshineApiA = RunRequestModel.f35764a.a();
            String str = this.$semesterCode;
            String str2 = this.$runPlanCode;
            int i2 = this.$sportType;
            this.label = 1;
            obj = iSunshineApiA.d(str, str2, i2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
