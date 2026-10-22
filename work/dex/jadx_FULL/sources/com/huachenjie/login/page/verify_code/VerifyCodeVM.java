package com.huachenjie.login.page.verify_code;

import android.text.TextUtils;
import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.login.R;
import com.huachenjie.login.bean.LoginResultData;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fv5;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b.\u0010/J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR%\u0010\u0010\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u00068\u0006¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\nR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00068\u0006¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0013\u0010\nR%\u0010\u0017\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u00068\u0006¢\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0016\u0010\nR\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u00068\u0006¢\u0006\f\n\u0004\b\u0018\u0010\b\u001a\u0004\b\u0019\u0010\nR\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00068\u0006¢\u0006\f\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001d\u0010\nR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001f\u0010\b\u001a\u0004\b \u0010\nR\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006¢\u0006\f\n\u0004\b\"\u0010\b\u001a\u0004\b#\u0010\nR\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006¢\u0006\f\n\u0004\b%\u0010\b\u001a\u0004\b&\u0010\nR\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006¢\u0006\f\n\u0004\b(\u0010\b\u001a\u0004\b%\u0010\nR\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\b\u001a\u0004\b(\u0010\nR\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020+0\u00068\u0006¢\u0006\f\n\u0004\b,\u0010\b\u001a\u0004\b,\u0010\n¨\u00060"}, d2 = {"Lcom/huachenjie/login/page/verify_code/VerifyCodeVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "verifyCode", "", "u", "Landroidx/lifecycle/MutableLiveData;", "a", "Landroidx/lifecycle/MutableLiveData;", "k", "()Landroidx/lifecycle/MutableLiveData;", "loginPhone", "", "kotlin.jvm.PlatformType", "b", j.b, "sendSmsCodeEnabled", "", "c", "p", "sendSmsCodeStr", "d", "q", "sendVoiceCodeEnabled", "e", "r", "sendVoiceCodeStr", "", "f", "m", VerifyCodeActivity.x, y6b.f, "t", VerifyCodeActivity.y, y6b.g, "n", "schoolCode", "i", "s", "studentNumber", "j", "bindKey", "lastTicket", "Lcom/huachenjie/login/bean/LoginResultData;", t.d, "loginResultData", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
public final class VerifyCodeVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> loginPhone = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> sendSmsCodeEnabled = new MutableLiveData<>(Boolean.FALSE);

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<CharSequence> sendSmsCodeStr = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> sendVoiceCodeEnabled = new MutableLiveData<>(Boolean.TRUE);

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<CharSequence> sendVoiceCodeStr = new MutableLiveData<>();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> loginThirdType = new MutableLiveData<>();

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> thirdKey = new MutableLiveData<>();

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> schoolCode = new MutableLiveData<>();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> studentNumber = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> bindKey = new MutableLiveData<>();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> lastTicket = new MutableLiveData<>();

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<LoginResultData> loginResultData = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<String> i() {
        return this.bindKey;
    }

    @NotNull
    public final MutableLiveData<String> j() {
        return this.lastTicket;
    }

    @NotNull
    public final MutableLiveData<String> k() {
        return this.loginPhone;
    }

    @NotNull
    public final MutableLiveData<LoginResultData> l() {
        return this.loginResultData;
    }

    @NotNull
    public final MutableLiveData<Integer> m() {
        return this.loginThirdType;
    }

    @NotNull
    public final MutableLiveData<String> n() {
        return this.schoolCode;
    }

    @NotNull
    public final MutableLiveData<Boolean> o() {
        return this.sendSmsCodeEnabled;
    }

    @NotNull
    public final MutableLiveData<CharSequence> p() {
        return this.sendSmsCodeStr;
    }

    @NotNull
    public final MutableLiveData<Boolean> q() {
        return this.sendVoiceCodeEnabled;
    }

    @NotNull
    public final MutableLiveData<CharSequence> r() {
        return this.sendVoiceCodeStr;
    }

    @NotNull
    public final MutableLiveData<String> s() {
        return this.studentNumber;
    }

    @NotNull
    public final MutableLiveData<String> t() {
        return this.thirdKey;
    }

    public final void u(@NotNull String verifyCode) {
        Intrinsics.checkNotNullParameter(verifyCode, "verifyCode");
        if (TextUtils.isEmpty(this.lastTicket.getValue())) {
            fv5.a(R.string.login_input_ticket_empty);
        } else if (TextUtils.isEmpty(verifyCode)) {
            fv5.a(R.string.login_input_verify_code_empty);
        } else {
            BaseViewModelExtKt.b(this, true, false, null, null, new VerifyCodeVM$login$1(this, verifyCode, null), 14, null);
        }
    }
}
