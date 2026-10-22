package com.huachenjie.compat.page.account;

import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.kuaishou.weapon.p0.t;
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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R0\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00020\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R0\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00180\u00180\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\r\u0010\u0010\"\u0004\b\u0019\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/compat/page/account/CancelAccountSubmitVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "ticket", AliyunLogCommon.TERMINAL_TYPE, "", y6b.g, "Lcom/zj/adlib/rq1;", "a", "Lcom/zj/adlib/rq1;", ze1.k, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "i", "Landroidx/lifecycle/MutableLiveData;", "k", "()Landroidx/lifecycle/MutableLiveData;", "n", "(Landroidx/lifecycle/MutableLiveData;)V", "titleBean", "kotlin.jvm.PlatformType", "j", "m", "mReason", "", t.d, "appealSuccess", "<init>", "()V", "compat_release"}, k = 1, mv = {1, 8, 0})
public final class CancelAccountSubmitVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final rq1 model = new rq1();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<String> mReason = new MutableLiveData<>("");

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<Boolean> appealSuccess = new MutableLiveData<>(Boolean.FALSE);

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\u000b"}, d2 = {"com/huachenjie/compat/page/account/CancelAccountSubmitVM$a", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Lcom/alibaba/fastjson/JSONObject;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "compat_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends BizSubscriber<JSONObject> {
        public a() {
            super(true);
        }

        public void onFailed(int code, @Nullable String message) {
            super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(code, message);
        }

        public void onCCSuccess(@Nullable JSONObject data) {
            CancelAccountSubmitVM.this.i().setValue(Boolean.TRUE);
        }
    }

    public final void h(@Nullable String ticket, @Nullable String phone) {
        rq1 rq1Var = this.model;
        String value = this.mReason.getValue();
        if (value == null) {
            value = "";
        }
        n76.e(this, rq1Var.a(ticket, phone, value)).p5(new a());
    }

    @NotNull
    public final MutableLiveData<Boolean> i() {
        return this.appealSuccess;
    }

    @NotNull
    public final MutableLiveData<String> j() {
        return this.mReason;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> k() {
        return this.titleBean;
    }

    public final void l(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.appealSuccess = mutableLiveData;
    }

    public final void m(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mReason = mutableLiveData;
    }

    public final void n(@NotNull MutableLiveData<BindingTitleBean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.titleBean = mutableLiveData;
    }
}
