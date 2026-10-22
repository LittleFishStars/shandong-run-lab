package com.huachenjie.home.dialog.sign;

import com.huachenjie.home.api.HomeRequest;
import com.huachenjie.home.bean.SignConfigBean;
import com.huachenjie.home.bean.VideoConfigBean;
import com.zj.adlib.fe9;
import com.zj.adlib.fv5;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.home.dialog.sign.SignVM$submitVideoReward$1", f = "SignVM.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
public final class SignVM$submitVideoReward$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SignVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignVM$submitVideoReward$1(SignVM signVM, Continuation<? super SignVM$submitVideoReward$1> continuation) {
        super(2, continuation);
        this.this$0 = signVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SignVM$submitVideoReward$1(this.this$0, continuation);
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
            HomeRequest homeRequest = HomeRequest.f34197a;
            this.label = 1;
            obj = homeRequest.D(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        fv5.b("成功获得" + ((Number) obj).intValue() + fe9.b.FLASH_COINS);
        SignConfigBean value = this.this$0.j().getValue();
        if (value != null) {
            SignVM signVM = this.this$0;
            VideoConfigBean videoConfig = value.getVideoConfig();
            videoConfig.setTodayWatchedCount(videoConfig.getTodayWatchedCount() + 1);
            signVM.j().setValue(value);
        }
        return Unit.INSTANCE;
    }
}
