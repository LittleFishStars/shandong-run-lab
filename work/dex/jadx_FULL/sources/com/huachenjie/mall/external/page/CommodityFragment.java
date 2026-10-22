package com.huachenjie.mall.external.page;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.p002lifecycle.Observer;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.mall.R;
import com.huachenjie.mall.databinding.MallFragmentCommodityBinding;
import com.huachenjie.mall.external.adapter.CommodityAdapter;
import com.huachenjie.mall.external.bean.CommodityBean;
import com.huachenjie.mall.external.page.CommodityFragment;
import com.huachenjie.mall.page.goods_detail.GoodsDetailActivity;
import com.zj.adlib.hk0;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016R\u001b\u0010\u0010\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0018\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u0014R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lcom/huachenjie/mall/external/page/CommodityFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/mall/databinding/MallFragmentCommodityBinding;", "Lcom/huachenjie/mall/external/page/CommodityVM;", "", "", "", "getVariables", "getLayoutResID", "", "initView", "initData", "commodityType$delegate", "Lkotlin/Lazy;", "getCommodityType", "()I", CommodityFragment.COMMODITY_TYPE, "", "shopNo$delegate", "getShopNo", "()Ljava/lang/String;", "shopNo", "emptyTitle$delegate", "getEmptyTitle", "emptyTitle", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "<init>", "()V", "Companion", "a", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class CommodityFragment extends BaseMVVMFragment<MallFragmentCommodityBinding, CommodityVM> {

    @NotNull
    public static final String COMMODITY_EMPTY_TITLE = "commodityTypeTitle";

    @NotNull
    public static final String COMMODITY_TYPE = "commodityType";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String SHOP_NO = "shopNo";

    /* JADX INFO: renamed from: commodityType$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy commodityType = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.mall.external.page.CommodityFragment$commodityType$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m480invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt(CommodityFragment.COMMODITY_TYPE) : 0);
        }
    });

    /* JADX INFO: renamed from: shopNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy shopNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.external.page.CommodityFragment$shopNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("shopNo")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: emptyTitle$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy emptyTitle = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.external.page.CommodityFragment$emptyTitle$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString(CommodityFragment.COMMODITY_EMPTY_TITLE)) == null) ? "" : string;
        }
    });

    @NotNull
    private final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.tp1
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            CommodityFragment.onRefreshListener$lambda$0(this.f44975a);
        }
    };

    /* JADX INFO: renamed from: com.huachenjie.mall.external.page.CommodityFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/mall/external/page/CommodityFragment$a;", "", "", "shopNo", "", "type", "emptyTitle", "Lcom/huachenjie/mall/external/page/CommodityFragment;", "a", "COMMODITY_EMPTY_TITLE", "Ljava/lang/String;", "COMMODITY_TYPE", "SHOP_NO", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CommodityFragment a(@NotNull String shopNo, int type, @NotNull String emptyTitle) {
            Intrinsics.checkNotNullParameter(shopNo, "shopNo");
            Intrinsics.checkNotNullParameter(emptyTitle, "emptyTitle");
            CommodityFragment commodityFragment = new CommodityFragment();
            Bundle bundle = new Bundle();
            bundle.putString("shopNo", shopNo);
            bundle.putInt(CommodityFragment.COMMODITY_TYPE, type);
            bundle.putString(CommodityFragment.COMMODITY_EMPTY_TITLE, emptyTitle);
            commodityFragment.setArguments(bundle);
            return commodityFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35118a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35118a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35118a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35118a.invoke(obj);
        }
    }

    public static final /* synthetic */ MallFragmentCommodityBinding access$getMBinding(CommodityFragment commodityFragment) {
        return commodityFragment.getMBinding();
    }

    private final int getCommodityType() {
        return ((Number) this.commodityType.getValue()).intValue();
    }

    private final String getEmptyTitle() {
        return (String) this.emptyTitle.getValue();
    }

    private final String getShopNo() {
        return (String) this.shopNo.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$4$lambda$2$lambda$1(CommodityAdapter commodityAdapter, CommodityFragment commodityFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(commodityAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(commodityFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        CommodityBean commodityBean = (CommodityBean) commodityAdapter.getItem(i);
        GoodsDetailActivity.Companion companion = GoodsDetailActivity.INSTANCE;
        Context contextRequireContext = commodityFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        companion.a(contextRequireContext, commodityBean.getGoodsNo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4$lambda$3(CommodityFragment commodityFragment) {
        Intrinsics.checkNotNullParameter(commodityFragment, "this$0");
        commodityFragment.getMViewModel().o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRefreshListener$lambda$0(CommodityFragment commodityFragment) {
        Intrinsics.checkNotNullParameter(commodityFragment, "this$0");
        commodityFragment.getMViewModel().q();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_fragment_commodity;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.R), this.onRefreshListener)});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().m().setValue(getShopNo());
        getMViewModel().j().setValue(Integer.valueOf(getCommodityType()));
        getMViewModel().q();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        TextView textView;
        MallFragmentCommodityBinding mBinding = getMBinding();
        if (mBinding != null) {
            final CommodityAdapter commodityAdapter = new CommodityAdapter(0.0f, 0.0f, 0.0f, 7, null);
            y57.d(commodityAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.rp1
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    CommodityFragment.initView$lambda$4$lambda$2$lambda$1(commodityAdapter, this, baseQuickAdapter, view, i);
                }
            }, 1, null);
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.mall_layout_empty_data, (ViewGroup) null);
            View viewFindViewById = viewInflate.findViewById(R.id.bt_empty);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
            }
            if (!TextUtils.isEmpty(getEmptyTitle()) && (textView = (TextView) viewInflate.findViewById(R.id.tv_empty)) != null) {
                textView.setText(getEmptyTitle());
            }
            Intrinsics.checkNotNullExpressionValue(viewInflate, "view");
            commodityAdapter.o(viewInflate);
            commodityAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.sp1
                @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
                public final void onLoadMore() {
                    CommodityFragment.initView$lambda$4$lambda$3(this.f44740a);
                }
            });
            getMViewModel().i().setValue(commodityAdapter);
            StateLayout stateLayout = mBinding.f10660a;
            Intrinsics.checkNotNullExpressionValue(stateLayout, "stateLayout");
            StateLayout.showLoading$default(stateLayout, null, false, false, 7, null);
        }
        getMViewModel().n().observe(this, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.mall.external.page.CommodityFragment.initView.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                MallFragmentCommodityBinding mallFragmentCommodityBindingAccess$getMBinding;
                StateLayout stateLayout2;
                if (bool.booleanValue() || (mallFragmentCommodityBindingAccess$getMBinding = CommodityFragment.access$getMBinding(CommodityFragment.this)) == null || (stateLayout2 = mallFragmentCommodityBindingAccess$getMBinding.f10660a) == null) {
                    return;
                }
                StateLayout.showContent$default(stateLayout2, null, 1, null);
            }
        }));
    }
}
