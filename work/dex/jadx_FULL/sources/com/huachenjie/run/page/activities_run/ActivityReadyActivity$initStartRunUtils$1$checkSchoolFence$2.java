package com.huachenjie.run.page.activities_run;

import com.alibaba.fastjson.JSONObject;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.run.R;
import com.huachenjie.run.model.RunRequestModel;
import com.zj.adlib.fv5;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.run.page.activities_run.ActivityReadyActivity$initStartRunUtils$1$checkSchoolFence$2", f = "ActivityReadyActivity.kt", i = {}, l = {186}, m = "invokeSuspend", n = {}, s = {})
public final class ActivityReadyActivity$initStartRunUtils$1$checkSchoolFence$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $useHighAccuracy;
    int label;
    final /* synthetic */ ActivityReadyActivity this$0;
    final /* synthetic */ ActivityReadyActivity$initStartRunUtils$1 this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityReadyActivity$initStartRunUtils$1$checkSchoolFence$2(ActivityReadyActivity activityReadyActivity, ActivityReadyActivity$initStartRunUtils$1 activityReadyActivity$initStartRunUtils$1, boolean z, Continuation<? super ActivityReadyActivity$initStartRunUtils$1$checkSchoolFence$2> continuation) {
        super(2, continuation);
        this.this$0 = activityReadyActivity;
        this.this$1 = activityReadyActivity$initStartRunUtils$1;
        this.$useHighAccuracy = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ActivityReadyActivity$initStartRunUtils$1$checkSchoolFence$2(this.this$0, this.this$1, this.$useHighAccuracy, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00a8  */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RunRequestModel runRequestModel = RunRequestModel.f35764a;
            String strP0 = this.this$0.p0();
            Intrinsics.checkNotNullExpressionValue(strP0, "activityFenceCode");
            this.label = 1;
            obj = runRequestModel.f(strP0, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        JSONObject jSONObject = (JSONObject) obj;
        String string = jSONObject != null ? jSONObject.getString("fenceCode") : null;
        if (Intrinsics.areEqual(string, this.this$0.p0())) {
            GeoFenceDetail value = ActivityReadyActivity.g0(this.this$0).w().getValue();
            if (Intrinsics.areEqual(value != null ? value.getFenceCode() : null, string)) {
                GeoFenceDetail value2 = ActivityReadyActivity.g0(this.this$0).w().getValue();
                Intrinsics.checkNotNull(value2);
                if (value2.getClockMode() == 0) {
                    fv5.a(R.string.clock_mode_config_error);
                    this.this$1.setStartRunBusy(false);
                    return Unit.INSTANCE;
                }
                ActivityReadyActivity$initStartRunUtils$1 activityReadyActivity$initStartRunUtils$1 = this.this$1;
                GeoFenceDetail value3 = ActivityReadyActivity.g0(this.this$0).w().getValue();
                Intrinsics.checkNotNull(value3);
                activityReadyActivity$initStartRunUtils$1.checkUnFinishedRun(value3, this.$useHighAccuracy);
            } else {
                fv5.b("围栏被禁止使用，请联系老师！");
                this.this$1.setStartRunBusy(false);
            }
        } else {
            fv5.b("围栏被禁止使用，请联系老师！");
            this.this$1.setStartRunBusy(false);
        }
        return Unit.INSTANCE;
    }
}
