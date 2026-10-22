package com.huachenjie.compat.page.account;

import android.text.TextUtils;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fv5;
import com.zj.adlib.n76;
import com.zj.adlib.rq1;
import com.zj.adlib.y6b;
import com.zj.adlib.ze1;
import huachenjie.sdk.http.BaseEntity;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\b\u0010\u0007\u001a\u00020\u0004H\u0002R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\rR(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R(\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R(\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b \u0010\u0016R(\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b#\u0010\u0016R\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u000f8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u0011\u0010\u0014R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006¢\u0006\f\n\u0004\b'\u0010\u0012\u001a\u0004\b'\u0010\u0014R\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006¢\u0006\f\n\u0004\b)\u0010\u0012\u001a\u0004\b)\u0010\u0014R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020%0\u000f8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\"\u0010\u0014¨\u0006."}, d2 = {"Lcom/huachenjie/compat/page/account/ChangePasswordVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "captchaPoint", "", "r", y6b.g, "v", "Lcom/zj/adlib/rq1;", "a", "Lcom/zj/adlib/rq1;", ze1.k, "Lkotlin/text/Regex;", "Lkotlin/text/Regex;", "regex", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "i", "Landroidx/lifecycle/MutableLiveData;", "q", "()Landroidx/lifecycle/MutableLiveData;", "x", "(Landroidx/lifecycle/MutableLiveData;)V", "titleBean", "j", "n", "w", AliyunLogCommon.TERMINAL_TYPE, "k", t.d, "u", "mSMSCode", "t", "mPassword", "m", "s", "mConfirmPassword", "", "canSendSmsCode", j.b, "sendSmsCodeStr", "p", "ticket", "needCaptchaCheck", "<init>", "()V", "compat_release"}, k = 1, mv = {1, 8, 0})
public final class ChangePasswordVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final rq1 model = new rq1();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Regex regex = new Regex("^(?![a-zA-Z]+$)(?![A-Z0-9]+$)(?![A-Z!@#$%^&\\.]+$)(?![a-z0-9]+$)(?![a-z!@#$%^&\\.]+$)(?![0-9!@#$%^&\\.]+$)[a-zA-Z0-9!@#$%^&\\.]{8,16}$");

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<String> phone = new MutableLiveData<>();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<String> mSMSCode = new MutableLiveData<>();

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<String> mPassword = new MutableLiveData<>();

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<String> mConfirmPassword = new MutableLiveData<>();

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> canSendSmsCode = new MutableLiveData<>();

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> sendSmsCodeStr = new MutableLiveData<>();

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> ticket = new MutableLiveData<>();

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> needCaptchaCheck = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0014\u0010\t\u001a\u00020\b2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0014J\u001a\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014¨\u0006\u000f"}, d2 = {"com/huachenjie/compat/page/account/ChangePasswordVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/alibaba/fastjson/JSONObject;", "data", "", "onCCSuccess", "Lhuachenjie/sdk/http/BaseEntity;", "baseEntity", "", "onBizError", "", "code", "", "message", "onFailed", "compat_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<JSONObject> {
        public a() {
            super(ChangePasswordVM.this, true);
        }

        public boolean onBizError(@NotNull BaseEntity<?> baseEntity) {
            Intrinsics.checkNotNullParameter(baseEntity, "baseEntity");
            if (baseEntity.code != 1600) {
                return super/*huachenjie.sdk.http.subscriber.BizSubscriber*/.onBizError(baseEntity);
            }
            MutableLiveData<Boolean> mutableLiveDataI = ChangePasswordVM.this.i();
            Boolean bool = Boolean.TRUE;
            mutableLiveDataI.setValue(bool);
            ChangePasswordVM.this.o().setValue("获取验证码");
            ChangePasswordVM.this.m().setValue(bool);
            return true;
        }

        public void onFailed(int code, @Nullable String message) {
            ChangePasswordVM.this.i().setValue(Boolean.TRUE);
            ChangePasswordVM.this.o().setValue("获取验证码");
            super.onFailed(code, message);
        }

        public void onCCSuccess(@Nullable JSONObject data) {
            if (data != null) {
                ChangePasswordVM changePasswordVM = ChangePasswordVM.this;
                if (data.containsKey("ticket")) {
                    changePasswordVM.p().setValue(data.getString("ticket"));
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/compat/page/account/ChangePasswordVM$b", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "", "data", "", "onCCSuccess", "compat_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends DialogVMSubscriber<Object> {
        public b() {
            super(ChangePasswordVM.this, true);
        }

        public void onCCSuccess(@Nullable Object data) {
            fv5.b("设置成功");
            ChangePasswordVM.this.h.setValue(Boolean.TRUE);
        }
    }

    public final void h() {
        if (TextUtils.isEmpty(this.mSMSCode.getValue())) {
            fv5.b("请输入验证码");
            return;
        }
        if (TextUtils.isEmpty(this.mPassword.getValue()) || TextUtils.isEmpty(this.mConfirmPassword.getValue())) {
            fv5.b("请设置密码");
            return;
        }
        String value = this.mPassword.getValue();
        if (value != null && this.regex.matches(value)) {
            String value2 = this.mConfirmPassword.getValue();
            if (value2 != null && this.regex.matches(value2)) {
                if (!TextUtils.equals(this.mPassword.getValue(), this.mConfirmPassword.getValue())) {
                    fv5.b("两次密码输入不一致");
                    return;
                } else if (TextUtils.isEmpty(this.ticket.getValue())) {
                    fv5.b("请先获取验证码！");
                    return;
                } else {
                    v();
                    return;
                }
            }
        }
        fv5.b("密码仅支持8~16位特殊字符、大小写字母、数字三种及以上组合");
    }

    @NotNull
    public final MutableLiveData<Boolean> i() {
        return this.canSendSmsCode;
    }

    @NotNull
    public final MutableLiveData<String> j() {
        return this.mConfirmPassword;
    }

    @NotNull
    public final MutableLiveData<String> k() {
        return this.mPassword;
    }

    @NotNull
    public final MutableLiveData<String> l() {
        return this.mSMSCode;
    }

    @NotNull
    public final MutableLiveData<Boolean> m() {
        return this.needCaptchaCheck;
    }

    @NotNull
    public final MutableLiveData<String> n() {
        return this.phone;
    }

    @NotNull
    public final MutableLiveData<String> o() {
        return this.sendSmsCodeStr;
    }

    @NotNull
    public final MutableLiveData<String> p() {
        return this.ticket;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> q() {
        return this.titleBean;
    }

    public final void r(@Nullable String captchaPoint) {
        this.canSendSmsCode.setValue(Boolean.FALSE);
        n76.e(this, this.model.g(captchaPoint)).p5(new a());
    }

    public final void s(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mConfirmPassword = mutableLiveData;
    }

    public final void t(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mPassword = mutableLiveData;
    }

    public final void u(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mSMSCode = mutableLiveData;
    }

    public final void v() {
        n76.e(this, this.model.m(this.ticket.getValue(), this.mPassword.getValue(), this.mSMSCode.getValue(), this.phone.getValue())).p5(new b());
    }

    public final void w(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.phone = mutableLiveData;
    }

    public final void x(@NotNull MutableLiveData<BindingTitleBean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.titleBean = mutableLiveData;
    }
}
