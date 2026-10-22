package com.huachenjie.mall.page.home_tab;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.mall.R;
import com.huachenjie.mall.databinding.MallFragmentMallItemBinding;
import com.huachenjie.mall.external.adapter.CommodityAdapter;
import com.huachenjie.mall.external.bean.CommodityBean;
import com.huachenjie.mall.page.goods_detail.GoodsDetailActivity;
import com.huachenjie.mall.page.home_tab.MallItemFragment;
import com.zj.adlib.hk0;
import com.zj.adlib.mq5;
import com.zj.adlib.y57;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 .2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001/B\u0007¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001d\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R\u001b\u0010 \u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+¨\u00060"}, d2 = {"Lcom/huachenjie/mall/page/home_tab/MallItemFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/mall/databinding/MallFragmentMallItemBinding;", "Lcom/huachenjie/mall/page/home_tab/MallItemVM;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "changeMaxPosition", "", "positions", "", "getMaxPosition", "", "", "getVariables", "getLayoutResID", "initView", "initData", "lazyLoadData", "onResume", "onPause", "", "navigationNo$delegate", "Lkotlin/Lazy;", "getNavigationNo", "()Ljava/lang/String;", MallItemFragment.NAVIGATION_NO, "navigationName$delegate", "getNavigationName", MallItemFragment.NAVIGATION_NAME, "catNo$delegate", "getCatNo", "catNo", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "", "lastShowTime", "J", "lastMaxPosition", "I", "", "hasScroll", "Z", "<init>", "()V", "Companion", "a", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class MallItemFragment extends BaseMVVMFragment<MallFragmentMallItemBinding, MallItemVM> {

    @NotNull
    public static final String CAT_NO = "catNo";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String NAVIGATION_NAME = "navigationName";

    @NotNull
    public static final String NAVIGATION_NO = "navigationNo";
    private boolean hasScroll;
    private long lastShowTime;

    /* JADX INFO: renamed from: navigationNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy navigationNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.page.home_tab.MallItemFragment$navigationNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString(MallItemFragment.NAVIGATION_NO)) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: navigationName$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy navigationName = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.page.home_tab.MallItemFragment$navigationName$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString(MallItemFragment.NAVIGATION_NAME)) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: catNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy catNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.page.home_tab.MallItemFragment$catNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("catNo")) == null) ? "" : string;
        }
    });

    @NotNull
    private final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.u65
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            MallItemFragment.onRefreshListener$lambda$0(this.f45071a);
        }
    };
    private int lastMaxPosition = -1;

    /* JADX INFO: renamed from: com.huachenjie.mall.page.home_tab.MallItemFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ*\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/mall/page/home_tab/MallItemFragment$a;", "", "", MallItemFragment.NAVIGATION_NO, MallItemFragment.NAVIGATION_NAME, "catNo", "Lcom/huachenjie/mall/page/home_tab/MallItemFragment;", "a", "CAT_NO", "Ljava/lang/String;", "NAVIGATION_NAME", "NAVIGATION_NO", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ MallItemFragment b(Companion companion, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                str3 = null;
            }
            return companion.a(str, str2, str3);
        }

        @NotNull
        public final MallItemFragment a(@Nullable String navigationNo, @Nullable String navigationName, @Nullable String catNo) {
            MallItemFragment mallItemFragment = new MallItemFragment();
            Bundle bundle = new Bundle();
            bundle.putString(MallItemFragment.NAVIGATION_NO, navigationNo);
            bundle.putString(MallItemFragment.NAVIGATION_NAME, navigationName);
            bundle.putString("catNo", catNo);
            mallItemFragment.setArguments(bundle);
            return mallItemFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35222a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35222a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35222a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35222a.invoke(obj);
        }
    }

    public static final /* synthetic */ MallFragmentMallItemBinding access$getMBinding(MallItemFragment mallItemFragment) {
        return mallItemFragment.getMBinding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeMaxPosition(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            int[] iArrFindLastCompletelyVisibleItemPositions = ((StaggeredGridLayoutManager) layoutManager).findLastCompletelyVisibleItemPositions(null);
            Intrinsics.checkNotNullExpressionValue(iArrFindLastCompletelyVisibleItemPositions, "manager.findLastComplete…isibleItemPositions(null)");
            this.lastMaxPosition = Math.max(getMaxPosition(iArrFindLastCompletelyVisibleItemPositions), this.lastMaxPosition);
        }
    }

    private final String getCatNo() {
        return (String) this.catNo.getValue();
    }

    private final int getMaxPosition(int[] positions) {
        int iMax = -1;
        for (int i : positions) {
            iMax = (int) Math.max(iMax, i);
        }
        return iMax;
    }

    private final String getNavigationName() {
        return (String) this.navigationName.getValue();
    }

    private final String getNavigationNo() {
        return (String) this.navigationNo.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$4$lambda$2$lambda$1(CommodityAdapter commodityAdapter, MallItemFragment mallItemFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(commodityAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(mallItemFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "view");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        CommodityBean commodityBean = (CommodityBean) commodityAdapter.getItem(i);
        mq5.a(baseQuickAdapter.getContext(), mallItemFragment.getNavigationName(), commodityBean.getGoodsNo(), commodityBean.getGoodsName(), commodityBean.getPriceStr(), String.valueOf(i));
        GoodsDetailActivity.Companion companion = GoodsDetailActivity.INSTANCE;
        Context contextRequireContext = mallItemFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        companion.a(contextRequireContext, commodityBean.getGoodsNo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4$lambda$3(MallItemFragment mallItemFragment) {
        Intrinsics.checkNotNullParameter(mallItemFragment, "this$0");
        mallItemFragment.getMViewModel().o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRefreshListener$lambda$0(MallItemFragment mallItemFragment) {
        Intrinsics.checkNotNullParameter(mallItemFragment, "this$0");
        mallItemFragment.getMViewModel().q();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_fragment_mall_item;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.R), this.onRefreshListener)});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().s(getNavigationNo());
        getMViewModel().r(getCatNo());
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        final MallFragmentMallItemBinding mBinding = getMBinding();
        if (mBinding != null) {
            final CommodityAdapter commodityAdapter = new CommodityAdapter(3.5f, 6.0f, 7.0f);
            y57.d(commodityAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.s65
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    MallItemFragment.initView$lambda$4$lambda$2$lambda$1(commodityAdapter, this, baseQuickAdapter, view, i);
                }
            }, 1, null);
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.mall_layout_empty_data, (ViewGroup) null);
            View viewFindViewById = viewInflate.findViewById(R.id.bt_empty);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
            }
            Intrinsics.checkNotNullExpressionValue(viewInflate, "view");
            commodityAdapter.o(viewInflate);
            commodityAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.t65
                @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
                public final void onLoadMore() {
                    MallItemFragment.initView$lambda$4$lambda$3(this.f44856a);
                }
            });
            getMViewModel().i().setValue(commodityAdapter);
            StateLayout stateLayout = mBinding.f10677a;
            Intrinsics.checkNotNullExpressionValue(stateLayout, "stateLayout");
            StateLayout.showLoading$default(stateLayout, null, false, false, 7, null);
            mBinding.f34954a.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.huachenjie.mall.page.home_tab.MallItemFragment$initView$1$2
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
                    Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                    if (newState == 0) {
                        this.f35223a.hasScroll = true;
                        this.f35223a.changeMaxPosition(recyclerView);
                    }
                }
            });
            mBinding.f34954a.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.huachenjie.mall.page.home_tab.MallItemFragment$initView$1$3
                @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
                public void onChildViewAttachedToWindow(@NotNull View view) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (this.f11141a.hasScroll) {
                        return;
                    }
                    MallItemFragment mallItemFragment = this.f11141a;
                    RecyclerView recyclerView = mBinding.f34954a;
                    Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
                    mallItemFragment.changeMaxPosition(recyclerView);
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
                public void onChildViewDetachedFromWindow(@NotNull View view) {
                    Intrinsics.checkNotNullParameter(view, "view");
                }
            });
        }
        getMViewModel().n().observe(this, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.mall.page.home_tab.MallItemFragment.initView.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                MallFragmentMallItemBinding mallFragmentMallItemBindingAccess$getMBinding;
                StateLayout stateLayout2;
                if (bool.booleanValue() || (mallFragmentMallItemBindingAccess$getMBinding = MallItemFragment.access$getMBinding(MallItemFragment.this)) == null || (stateLayout2 = mallFragmentMallItemBindingAccess$getMBinding.f10677a) == null) {
                    return;
                }
                StateLayout.showContent$default(stateLayout2, null, 1, null);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void lazyLoadData() {
        super.lazyLoadData();
        getMViewModel().q();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        if (this.lastShowTime > 0) {
            int iCurrentTimeMillis = (int) ((System.currentTimeMillis() - this.lastShowTime) / ((long) 1000));
            this.lastShowTime = 0L;
            Context context = getContext();
            if (context != null) {
                mq5.c(context, getNavigationName(), String.valueOf(iCurrentTimeMillis), String.valueOf(this.lastMaxPosition + 1));
            }
        }
        super.onPause();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.lastShowTime = System.currentTimeMillis();
    }
}
