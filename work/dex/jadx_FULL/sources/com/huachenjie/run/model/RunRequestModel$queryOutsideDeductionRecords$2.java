package com.huachenjie.run.model;

import com.huachenjie.common.reconfig.net.IResponse;
import com.huachenjie.run.api.ISunshineApi;
import com.huachenjie.run.bean.OutsideDeductionRecordBean;
import huachenjie.sdk.http.PageEntity;
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
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0000H\u008a@"}, d2 = {"Lcom/huachenjie/common/reconfig/net/IResponse;", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/run/bean/OutsideDeductionRecordBean;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.run.model.RunRequestModel$queryOutsideDeductionRecords$2", f = "RunRequestModel.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {})
public final class RunRequestModel$queryOutsideDeductionRecords$2 extends SuspendLambda implements Function1<Continuation<? super IResponse<PageEntity<OutsideDeductionRecordBean>>>, Object> {
    final /* synthetic */ int $pageNum;
    final /* synthetic */ String $runPlanCode;
    final /* synthetic */ String $semesterCode;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RunRequestModel$queryOutsideDeductionRecords$2(int i, String str, String str2, Continuation<? super RunRequestModel$queryOutsideDeductionRecords$2> continuation) {
        super(1, continuation);
        this.$pageNum = i;
        this.$semesterCode = str;
        this.$runPlanCode = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new RunRequestModel$queryOutsideDeductionRecords$2(this.$pageNum, this.$semesterCode, this.$runPlanCode, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super IResponse<PageEntity<OutsideDeductionRecordBean>>> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ISunshineApi iSunshineApiA = RunRequestModel.f35764a.a();
            int i2 = this.$pageNum;
            String str = this.$semesterCode;
            String str2 = this.$runPlanCode;
            this.label = 1;
            obj = iSunshineApiA.y(10, i2, str, str2, this);
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
