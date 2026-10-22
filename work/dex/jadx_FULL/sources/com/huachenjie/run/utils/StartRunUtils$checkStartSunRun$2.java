package com.huachenjie.run.utils;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huachenjie.common.bean.StartRunEntity;
import com.huachenjie.run.bean.StartRunPageParam;
import com.huachenjie.run.model.RunRequestModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.run.utils.StartRunUtils$checkStartSunRun$2", f = "StartRunUtils.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING}, m = "invokeSuspend", n = {}, s = {})
public final class StartRunUtils$checkStartSunRun$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ StartRunPageParam $param;
    int label;
    final /* synthetic */ StartRunUtils this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartRunUtils$checkStartSunRun$2(StartRunPageParam startRunPageParam, StartRunUtils startRunUtils, Continuation<? super StartRunUtils$checkStartSunRun$2> continuation) {
        super(2, continuation);
        this.$param = startRunPageParam;
        this.this$0 = startRunUtils;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new StartRunUtils$checkStartSunRun$2(this.$param, this.this$0, continuation);
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
            StartRunPageParam startRunPageParam = this.$param;
            this.label = 1;
            obj = runRequestModel.E(startRunPageParam, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        StartRunEntity startRunEntity = (StartRunEntity) obj;
        if (startRunEntity != null) {
            if (this.$param.getRunScene() == 10) {
                startRunEntity.setCheatLevel(1);
            }
            this.$param.setStartRunEntity(startRunEntity);
            this.$param.setSchoolRule(this.this$0.getRunDetailBean().getSchoolDemandRule());
            final StartRunUtils startRunUtils = this.this$0;
            startRunUtils.b0(this.$param, new Function0<Unit>() { // from class: com.huachenjie.run.utils.StartRunUtils$checkStartSunRun$2.1
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m731invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m731invoke() {
                    startRunUtils.setStartRunBusy(false);
                }
            });
        } else {
            this.this$0.setStartRunBusy(false);
        }
        return Unit.INSTANCE;
    }
}
