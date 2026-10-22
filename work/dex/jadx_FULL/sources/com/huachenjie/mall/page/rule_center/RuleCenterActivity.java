package com.huachenjie.mall.page.rule_center;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.p002lifecycle.MutableLiveData;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.Environment;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.RuleCenterBean;
import com.huachenjie.mall.databinding.MallActivityTrySeeListBinding;
import com.huachenjie.mall.page.rule_center.RuleCenterActivity;
import com.zj.adlib.hk0;
import com.zj.adlib.su9;
import com.zj.adlib.y57;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/mall/page/rule_center/RuleCenterActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityTrySeeListBinding;", "Lcom/huachenjie/mall/page/rule_center/RuleCenterVM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "g0", "d0", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "a", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class RuleCenterActivity extends BaseMVVMActivity<MallActivityTrySeeListBinding, RuleCenterVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.gl7
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            RuleCenterActivity.i0(this.f41934a);
        }
    };

    public static final void e0(RuleCenterActivity ruleCenterActivity) {
        Intrinsics.checkNotNullParameter(ruleCenterActivity, "this$0");
        ruleCenterActivity.getMViewModel().n();
    }

    public static final void f0(RuleCenterAdapter ruleCenterAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(ruleCenterAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        RuleCenterBean item = ruleCenterAdapter.getItem(i);
        su9.v(view.getContext(), Environment.c + "/#/mall/consumer-rule-detail?contentNo=" + item.getContentNo());
    }

    public static final void h0(RuleCenterActivity ruleCenterActivity, View view) {
        Intrinsics.checkNotNullParameter(ruleCenterActivity, "this$0");
        ruleCenterActivity.finish();
    }

    public static final void i0(RuleCenterActivity ruleCenterActivity) {
        Intrinsics.checkNotNullParameter(ruleCenterActivity, "this$0");
        ruleCenterActivity.getMViewModel().p();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.R), this.onRefreshListener)});
    }

    public final void d0() {
        MutableLiveData<RuleCenterAdapter> mutableLiveDataJ = getMViewModel().j();
        final RuleCenterAdapter ruleCenterAdapter = new RuleCenterAdapter();
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.mall_layout_empty_data, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(R.id.bt_empty);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        Intrinsics.checkNotNullExpressionValue(viewInflate, "view");
        ruleCenterAdapter.h(viewInflate);
        ruleCenterAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.el7
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                RuleCenterActivity.e0(this.f41465a);
            }
        });
        y57.d(ruleCenterAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.fl7
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RuleCenterActivity.f0(ruleCenterAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        mutableLiveDataJ.setValue(ruleCenterAdapter);
    }

    public final void g0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(-1).setTitleName("消费者规则中心").setTitleTextColor(zn1.a(R.color.hcj_header_txt)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.dl7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RuleCenterActivity.h0(this.f41225a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_rule_center;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().p();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        g0();
        d0();
    }
}
