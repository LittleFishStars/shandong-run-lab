package com.huachenjie.run.utils;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huachenjie.common.bean.CheckRunConfig;
import com.huachenjie.common.bean.FaceCheckConfig;
import com.huachenjie.run.bean.StartRunPageParam;
import com.huachenjie.run.bean.SunshineRunFaceCheckData;
import com.huachenjie.run.bean.SunshineRunFaceRecord;
import com.huachenjie.run.model.RunRequestModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.run.utils.StartRunUtils$checkRunRule$2", f = "StartRunUtils.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODER_STALL}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nStartRunUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StartRunUtils.kt\ncom/huachenjie/run/utils/StartRunUtils$checkRunRule$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,899:1\n1864#2,3:900\n*S KotlinDebug\n*F\n+ 1 StartRunUtils.kt\ncom/huachenjie/run/utils/StartRunUtils$checkRunRule$2\n*L\n378#1:900,3\n*E\n"})
public final class StartRunUtils$checkRunRule$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ StartRunPageParam $param;
    int label;
    final /* synthetic */ StartRunUtils this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartRunUtils$checkRunRule$2(StartRunPageParam startRunPageParam, StartRunUtils startRunUtils, Continuation<? super StartRunUtils$checkRunRule$2> continuation) {
        super(2, continuation);
        this.$param = startRunPageParam;
        this.this$0 = startRunUtils;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new StartRunUtils$checkRunRule$2(this.$param, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objD;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RunRequestModel runRequestModel = RunRequestModel.f35764a;
            String schoolCode = this.$param.getSchoolCode();
            String subSchoolCode = this.$param.getSubSchoolCode();
            int minRunDis = this.$param.getMinRunDis();
            String activityCode = this.$param.getActivityCode();
            String runPlanCode = this.$param.getRunPlanCode();
            String fenceCode = this.$param.getFenceCode();
            if (fenceCode == null) {
                fenceCode = "";
            }
            int sportType = this.$param.getSportType();
            this.label = 1;
            objD = runRequestModel.d(schoolCode, subSchoolCode, minRunDis, activityCode, runPlanCode, fenceCode, sportType, this);
            if (objD == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            objD = obj;
        }
        CheckRunConfig checkRunConfig = (CheckRunConfig) objD;
        if (checkRunConfig == null) {
            this.this$0.G(null, this.$param);
            return Unit.INSTANCE;
        }
        this.$param.setRunScene(checkRunConfig.getRunScene());
        this.$param.setSemesterCode(checkRunConfig.getSemesterCode());
        ArrayList arrayList = new ArrayList();
        List<FaceCheckConfig> faceCheckConfigList = checkRunConfig.getFaceCheckConfigList();
        if (faceCheckConfigList != null) {
            int i2 = 0;
            for (Object obj2 : faceCheckConfigList) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                FaceCheckConfig faceCheckConfig = (FaceCheckConfig) obj2;
                int lowerLimit = faceCheckConfig.getLowerLimit();
                if (faceCheckConfig.getUpperLimit() > faceCheckConfig.getLowerLimit()) {
                    lowerLimit = new Random().nextInt(faceCheckConfig.getUpperLimit() - faceCheckConfig.getLowerLimit()) + faceCheckConfig.getLowerLimit();
                }
                arrayList.add(new SunshineRunFaceRecord(i3, lowerLimit, false, false, null, null, null, null, false, null, null, null, null, null, null, null, null, null, 262140, null));
                i2 = i3;
            }
        }
        this.$param.setFaceCheckData(new SunshineRunFaceCheckData(checkRunConfig.isFaceAuth(), checkRunConfig.getFaceImg(), checkRunConfig.getSimilarityValue(), checkRunConfig.getFaceTime(), checkRunConfig.getBodyEnable(), checkRunConfig.getBodyRate(), checkRunConfig.getFaceModelType(), arrayList, -1, ((long) checkRunConfig.getFaceTime()) * 1000, 0L, 0L));
        this.$param.setFaceEnabled(checkRunConfig.getFaceEnabled());
        if (checkRunConfig.getNfcPauseDuration() > 0) {
            this.$param.setNfcPauseDuration(checkRunConfig.getNfcPauseDuration());
        }
        if (checkRunConfig.getAlertTip() == null) {
            this.this$0.C(this.$param);
        } else {
            this.this$0.G(checkRunConfig.getAlertTip(), this.$param);
        }
        return Unit.INSTANCE;
    }
}
