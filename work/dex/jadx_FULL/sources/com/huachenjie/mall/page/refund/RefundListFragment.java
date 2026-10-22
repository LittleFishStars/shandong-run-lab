package com.huachenjie.mall.page.refund;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.ExpressCompanyBean;
import com.huachenjie.mall.bean.MyRefundBean;
import com.huachenjie.mall.databinding.MallFragmentRefundListBinding;
import com.huachenjie.mall.dialog.express.FillExpressDialog;
import com.huachenjie.mall.page.merchants.MerchantsActivity;
import com.huachenjie.mall.page.refund.RefundListFragment;
import com.huachenjie.mall.page.refund_detail.RefundCancelDialog;
import com.huachenjie.mall.page.refund_detail.RefundDetailActivity;
import com.igexin.push.g.o;
import com.zj.adlib.hk0;
import com.zj.adlib.y57;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0006\u0010\u0011\u001a\u00020\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/mall/page/refund/RefundListFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/mall/databinding/MallFragmentRefundListBinding;", "Lcom/huachenjie/mall/page/refund/RefundListVM;", "()V", "onRefreshListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "getLayoutResID", "", "getVariables", "", "", "initAdapter", "", "initDataObservable", "initView", "onResume", "refreshData", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RefundListFragment extends BaseMVVMFragment<MallFragmentRefundListBinding, RefundListVM> {

    @NotNull
    private final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.yd7
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            RefundListFragment.onRefreshListener$lambda$0(this.f46006a);
        }
    };

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35254a;

        public a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35254a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35254a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35254a.invoke(obj);
        }
    }

    public static final /* synthetic */ RefundListVM access$getMViewModel(RefundListFragment refundListFragment) {
        return refundListFragment.getMViewModel();
    }

    private final void initAdapter() {
        MutableLiveData<RefundListAdapter> mutableLiveDataC = getMViewModel().C();
        final RefundListAdapter refundListAdapter = new RefundListAdapter();
        RefundListVM mViewModel = getMViewModel();
        MallFragmentRefundListBinding mBinding = getMBinding();
        Intrinsics.checkNotNull(mBinding);
        StateLayout stateLayout = mBinding.f10697a;
        Intrinsics.checkNotNullExpressionValue(stateLayout, "mBinding!!.stateLayout");
        BaseStateRequestModel.p(mViewModel, this, stateLayout, refundListAdapter, false, 8, null);
        BaseStateRequestModel.n(getMViewModel(), this, refundListAdapter, false, 4, null);
        refundListAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.zd7
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                RefundListFragment.initAdapter$lambda$5$lambda$1(this.f46239a);
            }
        });
        y57.d(refundListAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.ae7
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RefundListFragment.initAdapter$lambda$5$lambda$2(this.f15260a, refundListAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        refundListAdapter.addChildClickViewIds(R.id.iv_shop, R.id.tv_shop_name, R.id.bt_cancel, R.id.bt_express);
        y57.b(refundListAdapter, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.be7
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RefundListFragment.initAdapter$lambda$5$lambda$4(refundListAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        mutableLiveDataC.setValue(refundListAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$5$lambda$1(RefundListFragment refundListFragment) {
        Intrinsics.checkNotNullParameter(refundListFragment, "this$0");
        BaseStateRequestModel.x(refundListFragment.getMViewModel(), false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$5$lambda$2(RefundListFragment refundListFragment, RefundListAdapter refundListAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(refundListFragment, "this$0");
        Intrinsics.checkNotNullParameter(refundListAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        RefundDetailActivity.Companion companion = RefundDetailActivity.INSTANCE;
        Context contextRequireContext = refundListFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        refundListFragment.startActivity(companion.a(contextRequireContext, refundListAdapter.getData().get(i).getRefundOrderNo()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$5$lambda$4(RefundListAdapter refundListAdapter, final RefundListFragment refundListFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(refundListAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(refundListFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        final MyRefundBean myRefundBean = refundListAdapter.getData().get(i);
        int id = view.getId();
        boolean z = true;
        if (id != R.id.iv_shop && id != R.id.tv_shop_name) {
            z = false;
        }
        if (z) {
            MerchantsActivity.Companion companion = MerchantsActivity.INSTANCE;
            Context contextRequireContext = refundListFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            companion.a(contextRequireContext, myRefundBean.getShopNo());
            return;
        }
        if (id == R.id.bt_cancel) {
            RefundCancelDialog refundCancelDialog = new RefundCancelDialog();
            refundCancelDialog.setCallback(new Function1<String, Unit>() { // from class: com.huachenjie.mall.page.refund.RefundListFragment$initAdapter$1$3$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull String str) {
                    Intrinsics.checkNotNullParameter(str, o.f);
                    RefundListFragment.access$getMViewModel(this.this$0).B(myRefundBean.getRefundOrderNo(), str);
                }
            });
            FragmentManager childFragmentManager = refundListFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            refundCancelDialog.show(childFragmentManager, "RefundCancelDialog");
            return;
        }
        if (id == R.id.bt_express) {
            FillExpressDialog.Companion companion2 = FillExpressDialog.INSTANCE;
            FragmentManager childFragmentManager2 = refundListFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "childFragmentManager");
            companion2.a(childFragmentManager2, true, myRefundBean.getRefundOrderNo(), (56 & 8) != 0 ? "" : null, (56 & 16) != 0 ? "" : null, (56 & 32) != 0 ? "" : null, new Function2<ExpressCompanyBean, String, Unit>() { // from class: com.huachenjie.mall.page.refund.RefundListFragment$initAdapter$1$3$2
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((ExpressCompanyBean) obj, (String) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull ExpressCompanyBean expressCompanyBean, @NotNull String str) {
                    Intrinsics.checkNotNullParameter(expressCompanyBean, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                    RefundListFragment.access$getMViewModel(this.this$0).y();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRefreshListener$lambda$0(RefundListFragment refundListFragment) {
        Intrinsics.checkNotNullParameter(refundListFragment, "this$0");
        refundListFragment.getMViewModel().y();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_fragment_refund_list;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.R), this.onRefreshListener)});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        super.initDataObservable();
        getMViewModel().D().observe(this, new a(new Function1<Boolean, Unit>() { // from class: com.huachenjie.mall.page.refund.RefundListFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                RefundListFragment.access$getMViewModel(RefundListFragment.this).y();
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initAdapter();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getMViewModel().u().getValue() == null) {
            getMViewModel().y();
        }
    }

    public final void refreshData() {
        getMViewModel().y();
    }
}
