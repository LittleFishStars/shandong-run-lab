package com.huachenjie.college.page.point_activity;

import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.college.R;
import com.huachenjie.college.bean.PointActivityBean;
import com.huachenjie.college.databinding.CollegeActivityPointActivityListBinding;
import com.huachenjie.college.page.point_activity.PointActivityListActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.zj.adlib.fv5;
import com.zj.adlib.su9;
import com.zj.adlib.uk0;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/college/page/point_activity/PointActivityListActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/college/databinding/CollegeActivityPointActivityListBinding;", "Lcom/huachenjie/college/page/point_activity/PointActivityListVM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "g0", "d0", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "a", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "<init>", "()V", "college_release"}, k = 1, mv = {1, 8, 0})
public final class PointActivityListActivity extends BaseMVVMActivity<CollegeActivityPointActivityListBinding, PointActivityListVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.it6
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            PointActivityListActivity.i0(this.f42438a);
        }
    };

    public static final void e0(PointActivityListActivity pointActivityListActivity) {
        Intrinsics.checkNotNullParameter(pointActivityListActivity, "this$0");
        pointActivityListActivity.getMViewModel().w(false);
    }

    public static final void f0(PointActivityListAdapter pointActivityListAdapter, PointActivityListActivity pointActivityListActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(pointActivityListAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(pointActivityListActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        PointActivityBean item = pointActivityListAdapter.getItem(i);
        if (item.isNotStartingStatus() || System.currentTimeMillis() < item.getActivityStart()) {
            fv5.a(R.string.college_point_activity_list_no_start_toast);
        } else if (item.isEndedStatus() || System.currentTimeMillis() > item.getActivityEnd()) {
            fv5.a(R.string.college_point_activity_list_end_toast);
        } else {
            su9.i(pointActivityListActivity, item.getActivityNo());
        }
    }

    public static final void h0(PointActivityListActivity pointActivityListActivity, View view) {
        Intrinsics.checkNotNullParameter(pointActivityListActivity, "this$0");
        pointActivityListActivity.finish();
    }

    public static final void i0(PointActivityListActivity pointActivityListActivity) {
        Intrinsics.checkNotNullParameter(pointActivityListActivity, "this$0");
        pointActivityListActivity.getMViewModel().y();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(uk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(uk0.R), this.onRefreshListener)});
    }

    public final void d0() {
        MutableLiveData<PointActivityListAdapter> mutableLiveDataB = getMViewModel().B();
        final PointActivityListAdapter pointActivityListAdapter = new PointActivityListAdapter();
        PointActivityListVM mViewModel = getMViewModel();
        StateLayout stateLayout = getMBinding().f8371a;
        Intrinsics.checkNotNullExpressionValue(stateLayout, "mBinding.stateLayout");
        mViewModel.o(this, stateLayout, pointActivityListAdapter, false);
        getMViewModel().m(this, pointActivityListAdapter, false);
        pointActivityListAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.ft6
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                PointActivityListActivity.e0(this.f41754a);
            }
        });
        pointActivityListAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.gt6
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                PointActivityListActivity.f0(pointActivityListAdapter, this, baseQuickAdapter, view, i);
            }
        });
        mutableLiveDataB.setValue(pointActivityListAdapter);
    }

    public final void g0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setTitleName(getString(R.string.college_point_activity_list_title)).setTitleTextColor(zn1.a(R.color.hcj_header_txt)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.ht6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PointActivityListActivity.h0(this.f42199a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.college_activity_point_activity_list;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().y();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        g0();
        d0();
    }
}
