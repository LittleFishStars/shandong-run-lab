package com.huachenjie.login.util;

import android.app.Dialog;
import com.huachenjie.login.api.RequestModel;
import com.huachenjie.login.bean.AuthCodeData;
import com.huachenjie.login.bean.RemainTimesData;
import com.huachenjie.login.bean.VerifyCodeParams;
import com.huachenjie.login.enums.LoginThirdType;
import com.huachenjie.login.enums.VerifyCodeType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.login.util.SendVerifyCodeUtil$sendAuthCode$2", f = "SendVerifyCodeUtil.kt", i = {}, l = {199, 207, 215}, m = "invokeSuspend", n = {}, s = {})
public final class SendVerifyCodeUtil$sendAuthCode$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $captchaPoint;
    final /* synthetic */ Dialog $dialog;
    final /* synthetic */ int $loginThirdType;
    final /* synthetic */ Function2<Boolean, VerifyCodeParams, Unit> $onSendFinish;
    final /* synthetic */ String $phone;
    final /* synthetic */ RemainTimesData $remainTimesData;
    final /* synthetic */ VerifyCodeType $verifyCodeType;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SendVerifyCodeUtil$sendAuthCode$2(int i, String str, VerifyCodeType verifyCodeType, String str2, RemainTimesData remainTimesData, Dialog dialog, Function2<? super Boolean, ? super VerifyCodeParams, Unit> function2, Continuation<? super SendVerifyCodeUtil$sendAuthCode$2> continuation) {
        super(2, continuation);
        this.$loginThirdType = i;
        this.$phone = str;
        this.$verifyCodeType = verifyCodeType;
        this.$captchaPoint = str2;
        this.$remainTimesData = remainTimesData;
        this.$dialog = dialog;
        this.$onSendFinish = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SendVerifyCodeUtil$sendAuthCode$2(this.$loginThirdType, this.$phone, this.$verifyCodeType, this.$captchaPoint, this.$remainTimesData, this.$dialog, this.$onSendFinish, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        AuthCodeData authCodeData;
        String ticket;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            int i2 = this.$loginThirdType;
            if (i2 == LoginThirdType.None.getType()) {
                RequestModel requestModel = RequestModel.f34611a;
                String str = this.$phone;
                int value = this.$verifyCodeType.getValue();
                String str2 = this.$captchaPoint;
                this.label = 1;
                obj = requestModel.s(str, value, str2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                authCodeData = (AuthCodeData) obj;
            } else if (i2 == LoginThirdType.School.getType()) {
                RequestModel requestModel2 = RequestModel.f34611a;
                String str3 = this.$phone;
                int value2 = this.$verifyCodeType.getValue();
                String str4 = this.$captchaPoint;
                this.label = 2;
                obj = requestModel2.t(str3, value2, str4, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                authCodeData = (AuthCodeData) obj;
            } else {
                RequestModel requestModel3 = RequestModel.f34611a;
                String str5 = this.$phone;
                int value3 = this.$verifyCodeType.getValue();
                int i3 = this.$loginThirdType;
                String str6 = this.$captchaPoint;
                this.label = 3;
                obj = requestModel3.u(str5, value3, i3, str6, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                authCodeData = (AuthCodeData) obj;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            authCodeData = (AuthCodeData) obj;
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            authCodeData = (AuthCodeData) obj;
        } else {
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            authCodeData = (AuthCodeData) obj;
        }
        int smsLoginRemainTimes = this.$remainTimesData.getSmsLoginRemainTimes() - 1;
        int callLoginRemainTimes = this.$remainTimesData.getCallLoginRemainTimes() - 1;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (authCodeData == null || (ticket = authCodeData.getTicket()) == null) {
            ticket = "";
        }
        VerifyCodeParams verifyCodeParams = new VerifyCodeParams(smsLoginRemainTimes, callLoginRemainTimes, jCurrentTimeMillis, ticket, this.$verifyCodeType.getValue(), this.$loginThirdType, this.$phone);
        SendVerifyCodeUtil.phoneRemainTimes.put(this.$phone, verifyCodeParams);
        this.$dialog.dismiss();
        this.$onSendFinish.invoke(Boxing.boxBoolean(true), verifyCodeParams);
        return Unit.INSTANCE;
    }
}
