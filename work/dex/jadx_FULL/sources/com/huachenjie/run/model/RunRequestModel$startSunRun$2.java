package com.huachenjie.run.model;

import androidx.camera.video.AudioStats;
import com.huachenjie.common.bean.StartRunEntity;
import com.huachenjie.common.reconfig.net.IResponse;
import com.huachenjie.run.api.ISunshineApi;
import com.huachenjie.run.bean.StartRunPageParam;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u008a@"}, d2 = {"Lcom/huachenjie/common/reconfig/net/IResponse;", "Lcom/huachenjie/common/bean/StartRunEntity;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.run.model.RunRequestModel$startSunRun$2", f = "RunRequestModel.kt", i = {}, l = {330}, m = "invokeSuspend", n = {}, s = {})
public final class RunRequestModel$startSunRun$2 extends SuspendLambda implements Function1<Continuation<? super IResponse<StartRunEntity>>, Object> {
    final /* synthetic */ StartRunPageParam $param;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RunRequestModel$startSunRun$2(StartRunPageParam startRunPageParam, Continuation<? super RunRequestModel$startSunRun$2> continuation) {
        super(1, continuation);
        this.$param = startRunPageParam;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new RunRequestModel$startSunRun$2(this.$param, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super IResponse<StartRunEntity>> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        ISunshineApi iSunshineApiA = RunRequestModel.f35764a.a();
        String schoolCode = this.$param.getSchoolCode();
        String fenceCode = this.$param.getFenceCode();
        String activityCode = this.$param.getActivityCode();
        Double lat = this.$param.getLat();
        double dDoubleValue = AudioStats.AUDIO_AMPLITUDE_NONE;
        double dDoubleValue2 = lat != null ? lat.doubleValue() : 0.0d;
        Double lng = this.$param.getLng();
        if (lng != null) {
            dDoubleValue = lng.doubleValue();
        }
        long minRunDis = this.$param.getMinRunDis();
        boolean useCreditSword = this.$param.getUseCreditSword();
        String runPlanCode = this.$param.getRunPlanCode();
        int sportType = this.$param.getSportType();
        this.label = 1;
        Object objK = iSunshineApiA.K(schoolCode, fenceCode, activityCode, dDoubleValue2, dDoubleValue, minRunDis, useCreditSword, runPlanCode, sportType, this);
        return objK == coroutine_suspended ? coroutine_suspended : objK;
    }
}
