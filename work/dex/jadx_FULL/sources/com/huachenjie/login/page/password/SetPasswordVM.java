package com.huachenjie.login.page.password;

import android.text.TextUtils;
import androidx.p002lifecycle.MutableLiveData;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.login.R;
import com.huachenjie.login.bean.LoginResultData;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fe7;
import com.zj.adlib.fv5;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b3\u00104J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000fR\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000fR\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000fR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001e\u0010\u000fR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b!\u0010\u000fR\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0006¢\u0006\f\n\u0004\b#\u0010\r\u001a\u0004\b$\u0010\u000fR\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b&\u0010\r\u001a\u0004\b'\u0010\u000fR\u0016\u0010*\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010)R\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020+0\n8\u0006¢\u0006\f\n\u0004\b,\u0010\r\u001a\u0004\b-\u0010\u000fR\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b/\u0010\u000fR\u001d\u00102\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b1\u0010\u000f¨\u00065"}, d2 = {"Lcom/huachenjie/login/page/password/SetPasswordVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", AliyunLogCommon.TERMINAL_TYPE, "captchaPoint", "", "x", "k", j.o, "y", "Landroidx/lifecycle/MutableLiveData;", "", "a", "Landroidx/lifecycle/MutableLiveData;", "n", "()Landroidx/lifecycle/MutableLiveData;", SetPasswordActivity.x, "b", "w", "verifyCode", "c", "q", "password", "d", t.d, "confirmPassword", "e", "u", "showPassword", "f", "t", "showConfirmPassword", y6b.f, "r", "sendSmsCodeEnabled", y6b.g, "s", "sendSmsCodeStr", "i", "v", "startCountDown", "Ljava/lang/String;", "lastTicket", "Lcom/huachenjie/login/bean/LoginResultData;", "j", j.b, "loginResultData", "m", "finishActivity", "p", "needCaptchaCheck", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
public final class SetPasswordVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> forgotPassword = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> verifyCode = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> password = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> confirmPassword = new MutableLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showPassword = new MutableLiveData<>();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showConfirmPassword = new MutableLiveData<>();

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> sendSmsCodeEnabled = new MutableLiveData<>(Boolean.FALSE);

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> sendSmsCodeStr = new MutableLiveData<>();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> startCountDown = new MutableLiveData<>();

    /* JADX INFO: renamed from: f, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public String lastTicket = "";

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<LoginResultData> loginResultData = new MutableLiveData<>();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> finishActivity = new MutableLiveData<>();

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> needCaptchaCheck = new MutableLiveData<>();

    public final void k(@NotNull String phone) {
        Intrinsics.checkNotNullParameter(phone, AliyunLogCommon.TERMINAL_TYPE);
        if (TextUtils.isEmpty(this.password.getValue()) || TextUtils.isEmpty(this.password.getValue())) {
            fv5.a(R.string.login_input_password_empty);
            return;
        }
        if (!TextUtils.equals(this.password.getValue(), this.confirmPassword.getValue())) {
            fv5.a(R.string.login_input_password_equal_error);
            return;
        }
        fe7 fe7Var = fe7.f41654a;
        if (!fe7Var.b(this.password.getValue()) || !fe7Var.b(this.confirmPassword.getValue())) {
            fv5.a(R.string.login_input_password_error);
            return;
        }
        if (TextUtils.isEmpty(this.verifyCode.getValue())) {
            fv5.a(R.string.login_input_verify_code_empty);
            return;
        }
        if (TextUtils.isEmpty(this.lastTicket)) {
            fv5.a(R.string.login_input_ticket_empty);
        } else if (Intrinsics.areEqual(this.forgotPassword.getValue(), Boolean.TRUE)) {
            y(phone);
        } else {
            z(phone);
        }
    }

    @NotNull
    public final MutableLiveData<String> l() {
        return this.confirmPassword;
    }

    @NotNull
    public final MutableLiveData<Boolean> m() {
        return this.finishActivity;
    }

    @NotNull
    public final MutableLiveData<Boolean> n() {
        return this.forgotPassword;
    }

    @NotNull
    public final MutableLiveData<LoginResultData> o() {
        return this.loginResultData;
    }

    @NotNull
    public final MutableLiveData<Boolean> p() {
        return this.needCaptchaCheck;
    }

    @NotNull
    public final MutableLiveData<String> q() {
        return this.password;
    }

    @NotNull
    public final MutableLiveData<Boolean> r() {
        return this.sendSmsCodeEnabled;
    }

    @NotNull
    public final MutableLiveData<String> s() {
        return this.sendSmsCodeStr;
    }

    @NotNull
    public final MutableLiveData<Boolean> t() {
        return this.showConfirmPassword;
    }

    @NotNull
    public final MutableLiveData<Boolean> u() {
        return this.showPassword;
    }

    @NotNull
    public final MutableLiveData<Boolean> v() {
        return this.startCountDown;
    }

    @NotNull
    public final MutableLiveData<String> w() {
        return this.verifyCode;
    }

    public final void x(@NotNull String phone, @Nullable String captchaPoint) {
        Intrinsics.checkNotNullParameter(phone, AliyunLogCommon.TERMINAL_TYPE);
        BaseViewModelExtKt.b(this, true, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.login.page.password.SetPasswordVM$requestPasswordVerifyCode$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                boolean z;
                Intrinsics.checkNotNullParameter(resultException, o.f);
                MutableLiveData<Boolean> mutableLiveDataR = this.this$0.r();
                Boolean bool = Boolean.TRUE;
                mutableLiveDataR.setValue(bool);
                if (resultException.getCode() == 1600) {
                    this.this$0.p().setValue(bool);
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }, null, new SetPasswordVM$requestPasswordVerifyCode$2(phone, captchaPoint, this, null), 10, null);
    }

    public final void y(String phone) {
        BaseViewModelExtKt.b(this, true, false, null, null, new SetPasswordVM$resetPassword$1(this, phone, null), 14, null);
    }

    public final void z(String phone) {
        BaseViewModelExtKt.b(this, true, false, null, null, new SetPasswordVM$setPassword$1(this, phone, null), 14, null);
    }
}
