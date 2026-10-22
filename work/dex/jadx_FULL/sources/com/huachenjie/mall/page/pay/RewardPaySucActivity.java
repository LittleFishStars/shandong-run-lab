package com.huachenjie.mall.page.pay;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.util.ActivityLifecycleManager;
import com.huachenjie.mall.R;
import com.huachenjie.mall.databinding.MallActivityRewardPaySucBinding;
import com.huachenjie.mall.page.check_order.CheckOrderActivity;
import com.huachenjie.mall.page.goods_detail.GoodsDetailActivity;
import com.huachenjie.mall.page.order_detail.OrderDetailActivity;
import com.huachenjie.mall.page.pay.RewardPaySucActivity;
import com.zj.adlib.hk0;
import com.zj.adlib.t14;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000f\u0010B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0002¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/mall/page/pay/RewardPaySucActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityRewardPaySucBinding;", "Lcom/huachenjie/mall/page/pay/RewardPaySucVM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "a0", "<init>", "()V", "a", "b", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class RewardPaySucActivity extends BaseMVVMActivity<MallActivityRewardPaySucBinding, RewardPaySucVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "order_no";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/mall/page/pay/RewardPaySucActivity$a;", "", "Landroid/view/View;", "view", "", "b", "a", "<init>", "(Lcom/huachenjie/mall/page/pay/RewardPaySucActivity;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            t14.e(RewardPaySucActivity.this, null, false, 0, 14, null);
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            OrderDetailActivity.Companion companion = OrderDetailActivity.INSTANCE;
            RewardPaySucActivity rewardPaySucActivity = RewardPaySucActivity.this;
            String stringExtra = rewardPaySucActivity.getIntent().getStringExtra("order_no");
            if (stringExtra == null) {
                stringExtra = "";
            }
            companion.a(rewardPaySucActivity, stringExtra);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mall.page.pay.RewardPaySucActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/mall/page/pay/RewardPaySucActivity$b;", "", "Landroid/content/Context;", "context", "", UserTrackConstant.IS_SUCCESS, "", "orderNo", "", "a", "KEY_ORDER_NO", "Ljava/lang/String;", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, boolean isSuccess, @NotNull String orderNo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(orderNo, "orderNo");
            Intent intent = new Intent(context, (Class<?>) RewardPaySucActivity.class);
            intent.putExtra("order_no", orderNo);
            context.startActivity(intent);
        }
    }

    public static final void b0(RewardPaySucActivity rewardPaySucActivity, View view) {
        Intrinsics.checkNotNullParameter(rewardPaySucActivity, "this$0");
        rewardPaySucActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.k), new a())});
    }

    public final void a0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.vh7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RewardPaySucActivity.b0(this.f45353a, view);
            }
        }).setBackground(0));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_reward_pay_suc;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        ActivityLifecycleManager.l().f(CheckOrderActivity.class);
        ActivityLifecycleManager.l().f(GoodsDetailActivity.class);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        a0();
    }
}
