package com.huachenjie.run.utils;

import android.content.Intent;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huachenjie.run.model.RunRequestModel;
import com.huachenjie.run.page.sun_run.SunshineRunActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.run.utils.StartRunUtils$resumeRun$1$2", f = "StartRunUtils.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_STREAM_INFO}, m = "invokeSuspend", n = {}, s = {})
public final class StartRunUtils$resumeRun$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $runRecordCode;
    final /* synthetic */ int $type;
    int label;
    final /* synthetic */ StartRunUtils this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartRunUtils$resumeRun$1$2(int i, String str, StartRunUtils startRunUtils, Continuation<? super StartRunUtils$resumeRun$1$2> continuation) {
        super(2, continuation);
        this.$type = i;
        this.$runRecordCode = str;
        this.this$0 = startRunUtils;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new StartRunUtils$resumeRun$1$2(this.$type, this.$runRecordCode, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                RunRequestModel runRequestModel = RunRequestModel.f35764a;
                int i2 = this.$type;
                String str = this.$runRecordCode;
                this.label = 1;
                if (runRequestModel.G(i2, str, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.this$0.com.byazt.hv.TTDownloadField.TT_ACTIVITY java.lang.String.startActivity(new Intent(this.this$0.com.byazt.hv.TTDownloadField.TT_ACTIVITY java.lang.String, (Class<?>) SunshineRunActivity.class).putExtra(SunshineRunActivity.t, true));
            this.this$0.setStartRunBusy(false);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            this.this$0.setStartRunBusy(false);
            throw th;
        }
    }
}
