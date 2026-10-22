package com.huachenjie.login.util;

import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.login.R;
import com.huachenjie.login.api.RequestModel;
import com.huachenjie.login.bean.RemainTimesData;
import com.huachenjie.login.bean.VerifyCodeParams;
import com.huachenjie.login.enums.VerifyCodeType;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.ws1;
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
@DebugMetadata(c = "com.huachenjie.login.util.SendVerifyCodeUtil$checkVerifyTimes$2", f = "SendVerifyCodeUtil.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
public final class SendVerifyCodeUtil$checkVerifyTimes$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ String $captchaPoint;
    final /* synthetic */ Dialog $dialog;
    final /* synthetic */ int $loginThirdType;
    final /* synthetic */ Function2<Boolean, VerifyCodeParams, Unit> $onSendFinish;
    final /* synthetic */ String $phone;
    final /* synthetic */ VerifyCodeType $verifyCodeType;
    final /* synthetic */ BaseViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SendVerifyCodeUtil$checkVerifyTimes$2(String str, VerifyCodeType verifyCodeType, Dialog dialog, FragmentActivity fragmentActivity, Function2<? super Boolean, ? super VerifyCodeParams, Unit> function2, BaseViewModel baseViewModel, int i, String str2, Continuation<? super SendVerifyCodeUtil$checkVerifyTimes$2> continuation) {
        super(2, continuation);
        this.$phone = str;
        this.$verifyCodeType = verifyCodeType;
        this.$dialog = dialog;
        this.$activity = fragmentActivity;
        this.$onSendFinish = function2;
        this.$viewModel = baseViewModel;
        this.$loginThirdType = i;
        this.$captchaPoint = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(Function2 function2, View view) {
        function2.invoke(Boolean.FALSE, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$1(FragmentActivity fragmentActivity, BaseViewModel baseViewModel, String str, int i, String str2, Function2 function2, View view) {
        SendVerifyCodeUtil.f34757a.e(fragmentActivity, baseViewModel, str, VerifyCodeType.VOICE, i, str2, function2);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SendVerifyCodeUtil$checkVerifyTimes$2(this.$phone, this.$verifyCodeType, this.$dialog, this.$activity, this.$onSendFinish, this.$viewModel, this.$loginThirdType, this.$captchaPoint, continuation);
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
            RequestModel requestModel = RequestModel.f34611a;
            String str = this.$phone;
            this.label = 1;
            obj = requestModel.e(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        RemainTimesData remainTimesData = (RemainTimesData) obj;
        if (this.$verifyCodeType == VerifyCodeType.SMS) {
            if ((remainTimesData != null ? remainTimesData.getSmsLoginRemainTimes() : 0) == 0) {
                if ((remainTimesData != null ? remainTimesData.getCallLoginRemainTimes() : 0) > 0) {
                    this.$dialog.dismiss();
                    ws1 ws1VarF = ft1.g(this.$activity).Q(this.$activity.getString(R.string.login_request_voice_code_limit_dialog)).F(OptionsPickerHelper.e);
                    final Function2<Boolean, VerifyCodeParams, Unit> function2 = this.$onSendFinish;
                    ws1 ws1VarN = ws1VarF.C(new View.OnClickListener() { // from class: com.huachenjie.login.util.a
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            SendVerifyCodeUtil$checkVerifyTimes$2.invokeSuspend$lambda$0(function2, view);
                        }
                    }).N(this.$activity.getString(R.string.login_request_verify_code));
                    final FragmentActivity fragmentActivity = this.$activity;
                    final BaseViewModel baseViewModel = this.$viewModel;
                    final String str2 = this.$phone;
                    final int i2 = this.$loginThirdType;
                    final String str3 = this.$captchaPoint;
                    final Function2<Boolean, VerifyCodeParams, Unit> function3 = this.$onSendFinish;
                    ws1VarN.J(new View.OnClickListener() { // from class: com.huachenjie.login.util.b
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            SendVerifyCodeUtil$checkVerifyTimes$2.invokeSuspend$lambda$1(fragmentActivity, baseViewModel, str2, i2, str3, function3, view);
                        }
                    }).Y();
                } else {
                    this.$dialog.dismiss();
                    fv5.a(R.string.login_request_verify_code_limit);
                    this.$onSendFinish.invoke(Boxing.boxBoolean(false), (Object) null);
                }
                return Unit.INSTANCE;
            }
        }
        if (this.$verifyCodeType == VerifyCodeType.VOICE) {
            if ((remainTimesData != null ? remainTimesData.getCallLoginRemainTimes() : 0) == 0) {
                this.$dialog.dismiss();
                fv5.a(R.string.login_request_verify_code_limit);
                this.$onSendFinish.invoke(Boxing.boxBoolean(false), (Object) null);
                return Unit.INSTANCE;
            }
        }
        if (remainTimesData != null) {
            SendVerifyCodeUtil.f34757a.i(this.$activity, this.$viewModel, this.$phone, this.$verifyCodeType, this.$loginThirdType, remainTimesData, this.$dialog, this.$captchaPoint, this.$onSendFinish);
            return Unit.INSTANCE;
        }
        this.$dialog.dismiss();
        fv5.b("数据异常");
        this.$onSendFinish.invoke(Boxing.boxBoolean(false), (Object) null);
        return Unit.INSTANCE;
    }
}
