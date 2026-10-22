package com.huachenjie.mall.page.pay;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.mall.R;
import com.huachenjie.mall.databinding.MallActivityPayResultBinding;
import com.huachenjie.mall.page.order_detail.OrderDetailActivity;
import com.huachenjie.mall.page.pay.PayResultActivity;
import com.noober.background.drawable.DrawableCreator;
import com.zj.adlib.hk0;
import com.zj.adlib.t14;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/mall/page/pay/PayResultActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityPayResultBinding;", "Lcom/huachenjie/mall/page/pay/PayResultVM;", "", "", "", "V", "getLayoutResID", "", "initView", "b0", "", UserTrackConstant.IS_SUCCESS, "a0", "<init>", "()V", "a", "b", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class PayResultActivity extends BaseMVVMActivity<MallActivityPayResultBinding, PayResultVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "is_success";

    @NotNull
    public static final String x = "order_no";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/mall/page/pay/PayResultActivity$a;", "", "Landroid/view/View;", "view", "", "b", "a", "<init>", "(Lcom/huachenjie/mall/page/pay/PayResultActivity;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            t14.e(PayResultActivity.this, null, false, 0, 14, null);
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            OrderDetailActivity.Companion companion = OrderDetailActivity.INSTANCE;
            PayResultActivity payResultActivity = PayResultActivity.this;
            String stringExtra = payResultActivity.getIntent().getStringExtra("order_no");
            if (stringExtra == null) {
                stringExtra = "";
            }
            companion.a(payResultActivity, stringExtra);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mall.page.pay.PayResultActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/mall/page/pay/PayResultActivity$b;", "", "Landroid/content/Context;", "context", "", UserTrackConstant.IS_SUCCESS, "", "orderNo", "", "a", "KEY_IS_SUCCESS", "Ljava/lang/String;", "KEY_ORDER_NO", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, boolean isSuccess, @NotNull String orderNo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(orderNo, "orderNo");
            Intent intent = new Intent(context, (Class<?>) PayResultActivity.class);
            intent.putExtra(PayResultActivity.t, isSuccess);
            intent.putExtra("order_no", orderNo);
            context.startActivity(intent);
        }
    }

    public static final void c0(PayResultActivity payResultActivity, View view) {
        Intrinsics.checkNotNullParameter(payResultActivity, "this$0");
        payResultActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.k), new a())});
    }

    public final void a0(boolean isSuccess) {
        if (isSuccess) {
            getMBinding().b.setBackground(new DrawableCreator.Builder().setCornersRadius(SizeUtils.b(20.0f)).setStrokeColor(Color.parseColor("#650aec")).setStrokeWidth(SizeUtils.b(1.0f)).build());
            getMBinding().b.setTextColor(Color.parseColor("#650aec"));
            getMBinding().f10322a.setBackground(new DrawableCreator.Builder().setCornersRadius(SizeUtils.b(20.0f)).setSolidColor(Color.parseColor("#650aec")).build());
        } else {
            getMBinding().b.setBackground(new DrawableCreator.Builder().setCornersRadius(SizeUtils.b(20.0f)).setStrokeColor(Color.parseColor("#FF3D3D")).setStrokeWidth(SizeUtils.b(1.0f)).build());
            getMBinding().b.setTextColor(Color.parseColor("#FF3D3D"));
            getMBinding().f10322a.setBackground(new DrawableCreator.Builder().setCornersRadius(SizeUtils.b(20.0f)).setSolidColor(Color.parseColor("#FF3D3D")).build());
        }
    }

    public final void b0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setTitleName(getString(R.string.mall_pay_result_title)).setTitleTextColor(zn1.a(R.color.hcj_header_txt)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.jn6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PayResultActivity.c0(this.f42624a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_pay_result;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        getMViewModel().j().setValue(Boolean.valueOf(getIntent().getBooleanExtra(t, false)));
        b0();
        Boolean value = getMViewModel().j().getValue();
        Intrinsics.checkNotNull(value);
        a0(value.booleanValue());
    }
}
