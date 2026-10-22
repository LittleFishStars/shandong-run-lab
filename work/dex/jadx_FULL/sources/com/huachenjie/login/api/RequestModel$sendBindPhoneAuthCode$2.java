package com.huachenjie.login.api;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huachenjie.common.reconfig.net.IResponse;
import com.huachenjie.login.bean.AuthCodeData;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u008a@"}, d2 = {"Lcom/huachenjie/common/reconfig/net/IResponse;", "Lcom/huachenjie/login/bean/AuthCodeData;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.login.api.RequestModel$sendBindPhoneAuthCode$2", f = "RequestModel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_GET_CACHE_TIMESTAMP}, m = "invokeSuspend", n = {}, s = {})
public final class RequestModel$sendBindPhoneAuthCode$2 extends SuspendLambda implements Function1<Continuation<? super IResponse<AuthCodeData>>, Object> {
    final /* synthetic */ String $captchaPoint;
    final /* synthetic */ String $phone;
    final /* synthetic */ int $sendType;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestModel$sendBindPhoneAuthCode$2(String str, int i, String str2, Continuation<? super RequestModel$sendBindPhoneAuthCode$2> continuation) {
        super(1, continuation);
        this.$phone = str;
        this.$sendType = i;
        this.$captchaPoint = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new RequestModel$sendBindPhoneAuthCode$2(this.$phone, this.$sendType, this.$captchaPoint, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super IResponse<AuthCodeData>> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LoginApi loginApiA = RequestModel.f34611a.a();
            String str = this.$phone;
            int i2 = this.$sendType;
            String str2 = this.$captchaPoint;
            this.label = 1;
            obj = loginApiA.d(str, i2, 5, str2, this);
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
