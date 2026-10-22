package com.huachenjie.social_contact.vm;

import android.text.TextUtils;
import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.google.gson.Gson;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.OrderBean;
import com.huachenjie.common.bean.PayResult;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.social_contact.api.UniverseModel;
import com.huachenjie.social_contact.bean.BuyStarDrillInfo;
import com.huachenjie.social_contact.bean.PayBean;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fv5;
import com.zj.adlib.gq1;
import com.zj.adlib.n76;
import com.zj.adlib.ze1;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b5\u00106J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0014R(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR(\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR(\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\"\u0010\u001a\"\u0004\b#\u0010\u001cR(\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001cR(\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0018\u001a\u0004\b(\u0010\u001a\"\u0004\b)\u0010\u001cR(\u0010.\u001a\b\u0012\u0004\u0012\u00020+0\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b,\u0010\u001a\"\u0004\b-\u0010\u001cR(\u00101\u001a\b\u0012\u0004\u0012\u00020+0\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0018\u001a\u0004\b/\u0010\u001a\"\u0004\b0\u0010\u001cR(\u00104\u001a\b\u0012\u0004\u0012\u00020\t0\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0018\u001a\u0004\b2\u0010\u001a\"\u0004\b3\u0010\u001c¨\u00067"}, d2 = {"Lcom/huachenjie/social_contact/vm/PayVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "i", "", "payType", "n", t.d, "j", "", "mOrderNo", "k", "Lcom/huachenjie/common/bean/PayResult;", "result", "m", "Lcom/zj/adlib/gq1;", "a", "Lcom/zj/adlib/gq1;", "commonModel", "Lcom/huachenjie/social_contact/api/UniverseModel;", "Lcom/huachenjie/social_contact/api/UniverseModel;", ze1.k, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/social_contact/bean/PayBean;", "Landroidx/lifecycle/MutableLiveData;", "q", "()Landroidx/lifecycle/MutableLiveData;", "y", "(Landroidx/lifecycle/MutableLiveData;)V", UserConstants.SOCIAL_CONTACT_PARAMS.f33737a, "Lcom/huachenjie/social_contact/bean/BuyStarDrillInfo;", "v", "D", "starDrillInfo", "r", j.o, "payByAli", "s", "A", "payByWechat", "u", "C", "payResult", "", j.b, "w", "checkingPayResult", "t", "B", "payFailed", "p", "x", "orderNo", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPayVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PayVM.kt\ncom/huachenjie/social_contact/vm/PayVM\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,135:1\n1#2:136\n*E\n"})
public final class PayVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final gq1 commonModel = new gq1();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final UniverseModel model = new UniverseModel();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<PayBean> payBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<BuyStarDrillInfo> starDrillInfo = new MutableLiveData<>();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<String> payByAli = new MutableLiveData<>();

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<String> payByWechat = new MutableLiveData<>();

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<PayResult> payResult = new MutableLiveData<>();

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<Boolean> checkingPayResult = new MutableLiveData<>();

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<Boolean> payFailed = new MutableLiveData<>();

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<String> orderNo = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/social_contact/vm/PayVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/social_contact/bean/BuyStarDrillInfo;", "data", "", "onCCSuccess", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<BuyStarDrillInfo> {
        public a() {
            super(PayVM.this);
        }

        public void onCCSuccess(@Nullable BuyStarDrillInfo data) {
            if (data != null) {
                PayVM.this.v().setValue(data);
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\u000b\u001a\u00020\u0004H\u0014¨\u0006\f"}, d2 = {"com/huachenjie/social_contact/vm/PayVM$b", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/common/bean/PayResult;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "onFinish", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends DialogVMSubscriber<PayResult> {
        public final /* synthetic */ int K;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i) {
            super(PayVM.this, false);
            this.K = i;
        }

        public void onFailed(int code, @Nullable String message) {
            super.onFailed(code, message);
            PayVM.this.t().setValue(Boolean.TRUE);
        }

        public void onFinish() {
            int i = this.K;
            if (i == 1) {
                PayVM.this.s().setValue("");
                PayVM.this.p().setValue("");
            } else if (i == 2) {
                PayVM.this.r().setValue("");
                PayVM.this.p().setValue("");
            }
            PayVM.this.o().setValue(Boolean.FALSE);
        }

        public void onCCSuccess(@Nullable PayResult data) {
            PayVM.this.m(data);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/social_contact/vm/PayVM$c", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/common/bean/OrderBean;", "data", "", "onCCSuccess", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends DialogVMSubscriber<OrderBean> {
        public final /* synthetic */ int K;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i) {
            super(PayVM.this, true);
            this.K = i;
        }

        public void onCCSuccess(@Nullable OrderBean data) {
            if (data != null) {
                PayVM payVM = PayVM.this;
                int i = this.K;
                payVM.p().setValue(data.getOrderNo());
                if (i == 1) {
                    payVM.s().setValue(new Gson().toJson(data));
                } else {
                    if (i != 2) {
                        return;
                    }
                    if (TextUtils.isEmpty(data.getOrderCode())) {
                        fv5.b("创建订单失败");
                    } else {
                        payVM.r().setValue(data.getOrderCode());
                    }
                }
            }
        }
    }

    public final void A(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.payByWechat = mutableLiveData;
    }

    public final void B(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.payFailed = mutableLiveData;
    }

    public final void C(@NotNull MutableLiveData<PayResult> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.payResult = mutableLiveData;
    }

    public final void D(@NotNull MutableLiveData<BuyStarDrillInfo> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.starDrillInfo = mutableLiveData;
    }

    public final void i() {
        n76.e(this, this.model.b()).p5(new a());
    }

    public final void j() {
        String value = this.orderNo.getValue();
        if (value == null) {
            value = "";
        }
        k(2, value);
    }

    public final void k(int payType, String mOrderNo) {
        if (TextUtils.isEmpty(mOrderNo)) {
            return;
        }
        Boolean value = this.checkingPayResult.getValue();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(value, bool)) {
            return;
        }
        this.checkingPayResult.setValue(bool);
        n76.e(this, this.commonModel.c(payType, mOrderNo)).p5(new b(payType));
    }

    public final void l() {
        String value = this.orderNo.getValue();
        if (value == null) {
            value = "";
        }
        k(1, value);
    }

    public final void m(PayResult result) {
        if (result == null) {
            this.payFailed.setValue(Boolean.TRUE);
        } else {
            this.payResult.setValue(result);
        }
    }

    public final void n(int payType) {
        PayBean value = this.payBean.getValue();
        if (value != null) {
            n76.e(this, this.commonModel.f(payType, value.getType(), value.getGoodsSubType(), value.getGoodsCode())).p5(new c(payType));
        }
    }

    @NotNull
    public final MutableLiveData<Boolean> o() {
        return this.checkingPayResult;
    }

    @NotNull
    public final MutableLiveData<String> p() {
        return this.orderNo;
    }

    @NotNull
    public final MutableLiveData<PayBean> q() {
        return this.payBean;
    }

    @NotNull
    public final MutableLiveData<String> r() {
        return this.payByAli;
    }

    @NotNull
    public final MutableLiveData<String> s() {
        return this.payByWechat;
    }

    @NotNull
    public final MutableLiveData<Boolean> t() {
        return this.payFailed;
    }

    @NotNull
    public final MutableLiveData<PayResult> u() {
        return this.payResult;
    }

    @NotNull
    public final MutableLiveData<BuyStarDrillInfo> v() {
        return this.starDrillInfo;
    }

    public final void w(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.checkingPayResult = mutableLiveData;
    }

    public final void x(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.orderNo = mutableLiveData;
    }

    public final void y(@NotNull MutableLiveData<PayBean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.payBean = mutableLiveData;
    }

    public final void z(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.payByAli = mutableLiveData;
    }
}
