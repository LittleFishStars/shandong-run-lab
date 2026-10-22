package com.huachenjie.mall.dialog.pay;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.ViewModelKt;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.OrderPayBean;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.v41;
import com.zj.adlib.y6b;
import com.zj.adlib.ys8;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0004J\b\u0010\t\u001a\u00020\u0004H\u0002R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\n8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000fR\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\n8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000fR\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\n8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u000fR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\u001f\u0010\r\u001a\u0004\b \u0010\u000fR\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0\n8\u0006¢\u0006\f\n\u0004\b#\u0010\r\u001a\u0004\b$\u0010\u000fR\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0006¢\u0006\f\n\u0004\b&\u0010\r\u001a\u0004\b'\u0010\u000fR\u0016\u0010+\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006."}, d2 = {"Lcom/huachenjie/mall/dialog/pay/PayVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "seconds", "", "v", "type", "t", "u", "w", "Landroidx/lifecycle/MutableLiveData;", "", "a", "Landroidx/lifecycle/MutableLiveData;", "p", "()Landroidx/lifecycle/MutableLiveData;", "showAlipay", "b", "q", "showWXPay", "", "c", "r", "tradeNo", "d", j.b, "price", "", "e", t.d, "countDown", "f", "m", "finishCountDown", "Lcom/huachenjie/mall/bean/OrderPayBean;", y6b.f, "n", "orderPayBean", y6b.g, "s", "tradeStatus", "K", "I", "secondsNum", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class PayVM extends BaseViewModel {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int secondsNum;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showAlipay = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showWXPay = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> tradeNo = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> price = new MutableLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<CharSequence> countDown = new MutableLiveData<>();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> finishCountDown = new MutableLiveData<>();

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<OrderPayBean> orderPayBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> tradeStatus = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<CharSequence> l() {
        return this.countDown;
    }

    @NotNull
    public final MutableLiveData<Boolean> m() {
        return this.finishCountDown;
    }

    @NotNull
    public final MutableLiveData<OrderPayBean> n() {
        return this.orderPayBean;
    }

    @NotNull
    public final MutableLiveData<String> o() {
        return this.price;
    }

    @NotNull
    public final MutableLiveData<Boolean> p() {
        return this.showAlipay;
    }

    @NotNull
    public final MutableLiveData<Boolean> q() {
        return this.showWXPay;
    }

    @NotNull
    public final MutableLiveData<String> r() {
        return this.tradeNo;
    }

    @NotNull
    public final MutableLiveData<Integer> s() {
        return this.tradeStatus;
    }

    public final void t(int type) {
        BaseViewModelExtKt.b(this, true, false, null, null, new PayVM$payOrder$1(this, type, null), 14, null);
    }

    public final void u() {
        BaseViewModelExtKt.b(this, true, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.mall.dialog.pay.PayVM$queryTradeProgress$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                this.this$0.s().setValue(-1);
                return Boolean.FALSE;
            }
        }, null, new PayVM$queryTradeProgress$2(this, null), 10, null);
    }

    public final void v(int seconds) {
        this.secondsNum = seconds;
        v41.e(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PayVM$startCountDown$1(this, null), 3, (Object) null);
    }

    public final void w() {
        int i = this.secondsNum;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i / 3600), Integer.valueOf((i % 3600) / 60), Integer.valueOf(i % 60)}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(ys8.f(R.string.mall_pay_dialog_hint, str));
        spannableStringBuilder.setSpan(new StyleSpan(1), 3, str.length() + 3, 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FF762F")), 3, str.length() + 3, 33);
        this.countDown.setValue(spannableStringBuilder);
    }
}
