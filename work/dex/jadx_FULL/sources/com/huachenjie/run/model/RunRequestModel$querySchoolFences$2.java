package com.huachenjie.run.model;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.common.reconfig.net.IResponse;
import com.huachenjie.run.api.ISunshineApi;
import java.util.List;
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
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00010\u0000H\u008a@"}, d2 = {"Lcom/huachenjie/common/reconfig/net/IResponse;", "", "Lcom/huachenjie/common/bean/GeoFenceDetail;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.run.model.RunRequestModel$querySchoolFences$2", f = "RunRequestModel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_SIZE}, m = "invokeSuspend", n = {}, s = {})
public final class RunRequestModel$querySchoolFences$2 extends SuspendLambda implements Function1<Continuation<? super IResponse<List<? extends GeoFenceDetail>>>, Object> {
    final /* synthetic */ String $schoolCode;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RunRequestModel$querySchoolFences$2(String str, Continuation<? super RunRequestModel$querySchoolFences$2> continuation) {
        super(1, continuation);
        this.$schoolCode = str;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new RunRequestModel$querySchoolFences$2(this.$schoolCode, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super IResponse<List<GeoFenceDetail>>> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ISunshineApi iSunshineApiA = RunRequestModel.f35764a.a();
            String str = this.$schoolCode;
            this.label = 1;
            obj = iSunshineApiA.H(str, this);
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
