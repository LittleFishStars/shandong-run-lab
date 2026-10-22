package com.huachenjie.mall.page.refund;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.mall.R;
import com.huachenjie.mall.databinding.MallActivityRefundListBinding;
import com.huachenjie.mall.page.refund.RefundListActivity;
import com.huachenjie.mall.page.refund.RefundListActivity.RefundOrderReceiver;
import com.zj.adlib.hk0;
import com.zj.adlib.wd6;
import com.zj.adlib.zn1;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\tH\u0002R\u001f\u0010\u0012\u001a\u00060\rR\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/mall/page/refund/RefundListActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityRefundListBinding;", "Lcom/huachenjie/mall/page/refund/RefundListAVM;", "", "", "", "V", "getLayoutResID", "", "initView", "onDestroy", "b0", "Lcom/huachenjie/mall/page/refund/RefundListActivity$RefundOrderReceiver;", "b", "Lkotlin/Lazy;", "a0", "()Lcom/huachenjie/mall/page/refund/RefundListActivity$RefundOrderReceiver;", "orderReceiver", "<init>", "()V", "RefundOrderReceiver", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class RefundListActivity extends BaseMVVMActivity<MallActivityRefundListBinding, RefundListAVM> {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy orderReceiver = LazyKt.lazy(new Function0<RefundOrderReceiver>() { // from class: com.huachenjie.mall.page.refund.RefundListActivity$orderReceiver$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final RefundListActivity.RefundOrderReceiver m577invoke() {
            return this.this$0.new RefundOrderReceiver();
        }
    });

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/huachenjie/mall/page/refund/RefundListActivity$RefundOrderReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/huachenjie/mall/page/refund/RefundListActivity;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class RefundOrderReceiver extends BroadcastReceiver {
        public RefundOrderReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NotNull Context context, @Nullable Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            boolean z = false;
            if (intent != null && intent.getIntExtra(wd6.ORDER_OPERATE_TYPE_KEY, -1) == 5) {
                z = true;
            }
            if (z) {
                List<Fragment> fragments = RefundListActivity.this.getSupportFragmentManager().getFragments();
                Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
                Fragment fragment = (Fragment) CollectionsKt.firstOrNull(fragments);
                if (fragment == null || !(fragment instanceof RefundListFragment)) {
                    return;
                }
                ((RefundListFragment) fragment).refreshData();
            }
        }
    }

    public static final void c0(RefundListActivity refundListActivity, View view) {
        Intrinsics.checkNotNullParameter(refundListActivity, "this$0");
        refundListActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()));
    }

    public final RefundOrderReceiver a0() {
        return (RefundOrderReceiver) this.orderReceiver.getValue();
    }

    public final void b0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(-1).setTitleName(getString(R.string.mall_order_refund_title)).setTitleTextColor(zn1.a(R.color.hcj_header_txt)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.xd7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RefundListActivity.c0(this.f45799a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_refund_list;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        b0();
        wd6.f20422a.a(this, a0());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        wd6.f20422a.c(this, a0());
    }
}
