package com.huachenjie.compat.page.account;

import android.text.TextUtils;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.fastjson.JSONObject;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fv5;
import com.zj.adlib.n76;
import com.zj.adlib.rq1;
import com.zj.adlib.y6b;
import com.zj.adlib.ze1;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\f\u001a\u0004\b\u000b\u0010\u000e\"\u0004\b\u0016\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/compat/page/account/CancelAccountVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "k", j.b, "Lcom/zj/adlib/rq1;", "a", "Lcom/zj/adlib/rq1;", ze1.k, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "i", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "n", "(Landroidx/lifecycle/MutableLiveData;)V", "titleBean", "", y6b.g, t.d, "mPhone", "m", "mSMSCode", "<init>", "()V", "compat_release"}, k = 1, mv = {1, 8, 0})
public final class CancelAccountVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final rq1 model = new rq1();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<String> mPhone = new MutableLiveData<>();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<String> mSMSCode = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\u000b"}, d2 = {"com/huachenjie/compat/page/account/CancelAccountVM$a", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Lcom/alibaba/fastjson/JSONObject;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "compat_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends BizSubscriber<JSONObject> {
        public a() {
            super(true);
        }

        public void onFailed(int code, @Nullable String message) {
            if (code == 1514) {
                fv5.b("一天只能获取3次短信验证码哦！");
            } else if (code != 1515) {
                super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(code, message);
            } else {
                fv5.b("验证码发送失败，请重试！");
            }
        }

        public void onCCSuccess(@Nullable JSONObject data) {
            fv5.b("验证码已发送");
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\u000b"}, d2 = {"com/huachenjie/compat/page/account/CancelAccountVM$b", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Lcom/alibaba/fastjson/JSONObject;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "compat_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends BizSubscriber<JSONObject> {
        public b() {
            super(true);
        }

        public void onFailed(int code, @Nullable String message) {
            if (code == 1516) {
                fv5.b("验证码已过期，请重新获取验证码！");
            } else if (code != 1520) {
                super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(code, message);
            } else {
                fv5.b("今天错误次数过多，明天再来吧！");
            }
        }

        public void onCCSuccess(@Nullable JSONObject data) {
            if (data != null) {
                CancelAccountVM cancelAccountVM = CancelAccountVM.this;
                if (data.containsKey("ticket")) {
                    String string = data.getString("ticket");
                    if (TextUtils.isEmpty(data.getString("ticket"))) {
                        return;
                    }
                    Postcard postcardWithString = ARouter.getInstance().build(RoutePathConstants.Compat.n).withString(UserConstants.MINE_PARAMS.b, string);
                    String value = cancelAccountVM.h().getValue();
                    if (value == null) {
                        value = "";
                    }
                    postcardWithString.withString(UserConstants.MINE_PARAMS.c, value).navigation();
                    cancelAccountVM.h.setValue(Boolean.TRUE);
                }
            }
        }
    }

    @NotNull
    public final MutableLiveData<String> h() {
        return this.mPhone;
    }

    @NotNull
    public final MutableLiveData<String> i() {
        return this.mSMSCode;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> j() {
        return this.titleBean;
    }

    public final void k() {
        rq1 rq1Var = this.model;
        String value = this.mPhone.getValue();
        if (value == null) {
            value = "";
        }
        n76.e(this, rq1Var.d(value)).p5(new a());
    }

    public final void l(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mPhone = mutableLiveData;
    }

    public final void m(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mSMSCode = mutableLiveData;
    }

    public final void n(@NotNull MutableLiveData<BindingTitleBean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.titleBean = mutableLiveData;
    }

    public final void o() {
        rq1 rq1Var = this.model;
        String value = this.mPhone.getValue();
        if (value == null) {
            value = "";
        }
        String value2 = this.mSMSCode.getValue();
        n76.e(this, rq1Var.p(value, value2 != null ? value2 : "")).p5(new b());
    }
}
