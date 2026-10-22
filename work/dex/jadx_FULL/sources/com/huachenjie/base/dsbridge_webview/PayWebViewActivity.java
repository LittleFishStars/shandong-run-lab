package com.huachenjie.base.dsbridge_webview;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.exoplayer2.source.rtsp.j;
import com.google.gson.Gson;
import com.huachenjie.common.bean.CommonUserInfo;
import com.huachenjie.common.bean.OrderBean;
import com.huachenjie.common.bean.PayResult;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.pay.receiver.WechatPayReceiver;
import com.zj.adlib.ai9;
import com.zj.adlib.gq1;
import com.zj.adlib.it9;
import com.zj.adlib.ln6;
import com.zj.adlib.n76;
import com.zj.adlib.uj1;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Route(path = RoutePathConstants.Base.b)
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001$\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b*\u0010+J4\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u0010\u001a\u00020\u000bH\u0014J*\u0010\u0013\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0002J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0002R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010(¨\u0006,"}, d2 = {"Lcom/huachenjie/base/dsbridge_webview/PayWebViewActivity;", "Lcom/huachenjie/base/dsbridge_webview/DWebViewActivity;", "", "type", "goodsSubType", "payType", "", "goodsCode", "Lcom/huachenjie/base/dsbridge_webview/CompletionHandler;", "", "handler", "", "J0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "onDestroy", "", "params", "E0", "F0", "H0", "G0", "Lcom/zj/adlib/gq1;", "a", "Lkotlin/Lazy;", "I0", "()Lcom/zj/adlib/gq1;", "mCommonModel", "Lcom/huachenjie/base/dsbridge_webview/CompletionHandler;", "mWebViewHandler", "Ljava/lang/Integer;", "mType", j.o, "Ljava/lang/String;", "mOrderNo", "com/huachenjie/base/dsbridge_webview/PayWebViewActivity$b", "Lcom/huachenjie/base/dsbridge_webview/PayWebViewActivity$b;", "mHandler", "Lcom/huachenjie/pay/receiver/WechatPayReceiver;", "Lcom/huachenjie/pay/receiver/WechatPayReceiver;", "mReceiver", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPayWebViewActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PayWebViewActivity.kt\ncom/huachenjie/base/dsbridge_webview/PayWebViewActivity\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,155:1\n215#2,2:156\n*S KotlinDebug\n*F\n+ 1 PayWebViewActivity.kt\ncom/huachenjie/base/dsbridge_webview/PayWebViewActivity\n*L\n77#1:156,2\n*E\n"})
public class PayWebViewActivity extends DWebViewActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public CompletionHandler<Object> mWebViewHandler;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Integer mType;

    /* JADX INFO: renamed from: z, reason: from kotlin metadata */
    @Nullable
    public String mOrderNo;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy mCommonModel = LazyKt.lazy(new Function0<gq1>() { // from class: com.huachenjie.base.dsbridge_webview.PayWebViewActivity$mCommonModel$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final gq1 m220invoke() {
            return new gq1();
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final b mHandler = new b(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final WechatPayReceiver mReceiver = new WechatPayReceiver(new c());

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\u000b\u001a\u00020\u0004H\u0014¨\u0006\f"}, d2 = {"com/huachenjie/base/dsbridge_webview/PayWebViewActivity$a", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Lcom/huachenjie/common/bean/PayResult;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "onFinish", "base_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nPayWebViewActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PayWebViewActivity.kt\ncom/huachenjie/base/dsbridge_webview/PayWebViewActivity$checkPayResult$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,155:1\n1#2:156\n*E\n"})
    public static final class a extends BizSubscriber<PayResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Dialog f32922a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Dialog dialog) {
            super(false);
            this.f32922a = dialog;
        }

        public void onFailed(int code, @Nullable String message) throws JSONException {
            super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(code, message);
            PayWebViewActivity payWebViewActivity = PayWebViewActivity.this;
            CompletionHandler completionHandler = payWebViewActivity.mWebViewHandler;
            Intrinsics.checkNotNull(completionHandler);
            payWebViewActivity.E0(completionHandler, MapsKt.mapOf(TuplesKt.to("result", Boolean.FALSE)));
        }

        public void onFinish() {
            super.onFinish();
            this.f32922a.dismiss();
            PayWebViewActivity.this.mWebViewHandler = null;
            PayWebViewActivity.this.mType = null;
            PayWebViewActivity.this.mOrderNo = null;
        }

        public void onCCSuccess(@Nullable PayResult data) throws JSONException {
            if (data == null || data.getPayStatus() != 1) {
                PayWebViewActivity payWebViewActivity = PayWebViewActivity.this;
                CompletionHandler completionHandler = payWebViewActivity.mWebViewHandler;
                Intrinsics.checkNotNull(completionHandler);
                payWebViewActivity.E0(completionHandler, MapsKt.mapOf(TuplesKt.to("result", Boolean.FALSE)));
                return;
            }
            Integer num = PayWebViewActivity.this.mType;
            if (num != null && num.intValue() == 3) {
                CommonUserInfo commonUserInfoE = ai9.e();
                commonUserInfoE.setHasMonthCardRight(true);
                ai9.s(commonUserInfoE);
            }
            PayWebViewActivity payWebViewActivity2 = PayWebViewActivity.this;
            CompletionHandler completionHandler2 = payWebViewActivity2.mWebViewHandler;
            Intrinsics.checkNotNull(completionHandler2);
            payWebViewActivity2.E0(completionHandler2, MapsKt.mapOf(TuplesKt.to("result", Boolean.TRUE)));
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/base/dsbridge_webview/PayWebViewActivity$b", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "dispatchMessage", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void dispatchMessage(@NotNull Message msg) throws JSONException {
            Intrinsics.checkNotNullParameter(msg, "msg");
            if (msg.what == 200) {
                PayWebViewActivity.this.F0();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/base/dsbridge_webview/PayWebViewActivity$c", "Lcom/huachenjie/pay/receiver/WechatPayReceiver$WechatPayCallback;", "", "code", "", "a", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements WechatPayReceiver.WechatPayCallback {
        public c() {
        }

        @Override // com.huachenjie.pay.receiver.WechatPayReceiver.WechatPayCallback
        public void a(int code) throws JSONException {
            PayWebViewActivity.this.H0();
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\u000b"}, d2 = {"com/huachenjie/base/dsbridge_webview/PayWebViewActivity$d", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Lcom/huachenjie/common/bean/OrderBean;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class d extends BizSubscriber<OrderBean> {
        public final /* synthetic */ int K;
        public final /* synthetic */ int L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Dialog f32925a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ CompletionHandler<Object> f7205a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ PayWebViewActivity f7206a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Dialog dialog, PayWebViewActivity payWebViewActivity, CompletionHandler<Object> completionHandler, int i, int i2) {
            super(true);
            this.f32925a = dialog;
            this.f7206a = payWebViewActivity;
            this.f7205a = completionHandler;
            this.K = i;
            this.L = i2;
        }

        public void onFailed(int code, @Nullable String message) throws JSONException {
            super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(code, message);
            this.f32925a.dismiss();
            this.f7206a.E0(this.f7205a, MapsKt.mapOf(new Pair[]{TuplesKt.to("result", Boolean.FALSE), TuplesKt.to("message", "创建订单失败")}));
        }

        public void onCCSuccess(@Nullable OrderBean data) throws JSONException {
            this.f32925a.dismiss();
            if ((data != null ? data.getOrderNo() : null) == null) {
                this.f7206a.E0(this.f7205a, MapsKt.mapOf(new Pair[]{TuplesKt.to("result", Boolean.FALSE), TuplesKt.to("message", "创建订单失败")}));
                return;
            }
            this.f7206a.mWebViewHandler = this.f7205a;
            this.f7206a.mType = Integer.valueOf(this.K);
            this.f7206a.mOrderNo = data.getOrderNo();
            int i = this.L;
            if (i == 1) {
                String json = new Gson().toJson(data);
                Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(data)");
                ln6.g(json, it9.n(), it9.a.m());
            } else if (i == 2) {
                PayWebViewActivity payWebViewActivity = this.f7206a;
                ln6.b(payWebViewActivity, payWebViewActivity.mHandler, data.getOrderCode());
            }
        }
    }

    public final void E0(CompletionHandler<Object> handler, Map<String, ? extends Object> params) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ? extends Object> entry : params.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        handler.a(jSONObject);
    }

    public final void F0() throws JSONException {
        G0(2);
    }

    public final void G0(int payType) throws JSONException {
        if (this.mWebViewHandler == null) {
            return;
        }
        if (this.mType == null || TextUtils.isEmpty(this.mOrderNo)) {
            CompletionHandler<Object> completionHandler = this.mWebViewHandler;
            Intrinsics.checkNotNull(completionHandler);
            E0(completionHandler, MapsKt.mapOf(TuplesKt.to("result", Boolean.FALSE)));
        } else {
            Dialog dialogP = DialogUtil.p(this, false);
            dialogP.show();
            n76.e(this, I0().c(payType, this.mOrderNo)).p5(new a(dialogP));
        }
    }

    public final void H0() throws JSONException {
        G0(1);
    }

    public final gq1 I0() {
        return (gq1) this.mCommonModel.getValue();
    }

    public final void J0(int type, int goodsSubType, int payType, @NotNull String goodsCode, @NotNull CompletionHandler<Object> handler) throws JSONException {
        Intrinsics.checkNotNullParameter(goodsCode, "goodsCode");
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (payType == 1 && !uj1.c(this)) {
            E0(handler, MapsKt.mapOf(new Pair[]{TuplesKt.to("result", Boolean.FALSE), TuplesKt.to("message", "微信客户端未安装")}));
            return;
        }
        Dialog dialogP = DialogUtil.p(this, false);
        dialogP.show();
        n76.e(this, I0().f(payType, type, goodsSubType, goodsCode)).p5(new d(dialogP, this, handler, type, payType));
    }

    @Override // com.huachenjie.common.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ln6.f18003a.d(this, this.mReceiver);
    }

    @Override // com.huachenjie.base.dsbridge_webview.DWebViewActivity, com.huachenjie.common.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ln6.f18003a.f(this, this.mReceiver);
        this.mHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}
