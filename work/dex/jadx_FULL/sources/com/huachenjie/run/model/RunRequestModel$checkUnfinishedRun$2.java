package com.huachenjie.run.model;

import com.huachenjie.common.bean.UnfinishedRun;
import com.huachenjie.common.reconfig.net.IResponse;
import com.huachenjie.run.api.ISunshineApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u008a@"}, d2 = {"Lcom/huachenjie/common/reconfig/net/IResponse;", "Lcom/huachenjie/common/bean/UnfinishedRun;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.run.model.RunRequestModel$checkUnfinishedRun$2", f = "RunRequestModel.kt", i = {}, l = {302}, m = "invokeSuspend", n = {}, s = {})
public final class RunRequestModel$checkUnfinishedRun$2 extends SuspendLambda implements Function1<Continuation<? super IResponse<UnfinishedRun>>, Object> {
    final /* synthetic */ int $sportType;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RunRequestModel$checkUnfinishedRun$2(int i, Continuation<? super RunRequestModel$checkUnfinishedRun$2> continuation) {
        super(1, continuation);
        this.$sportType = i;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new RunRequestModel$checkUnfinishedRun$2(this.$sportType, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super IResponse<UnfinishedRun>> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ISunshineApi iSunshineApiA = RunRequestModel.f35764a.a();
            Map<String, String> mapMapOf = MapsKt.mapOf(TuplesKt.to("sportType", String.valueOf(this.$sportType)));
            this.label = 1;
            obj = iSunshineApiA.s(mapMapOf, this);
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
