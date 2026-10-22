package com.huachenjie.mall.page.comment.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.p002lifecycle.Observer;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.mall.R;
import com.huachenjie.mall.databinding.MallFragmentCommodityCommentListBinding;
import com.huachenjie.mall.page.comment.list.CommodityCommentListFragment;
import com.zj.adlib.hk0;
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
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/mall/page/comment/list/CommodityCommentListFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/mall/databinding/MallFragmentCommodityCommentListBinding;", "Lcom/huachenjie/mall/page/comment/list/CommodityCommentListVM;", "", "initAdapter", "", "", "", "getVariables", "getLayoutResID", "initView", "initData", "", "goodsNo$delegate", "Lkotlin/Lazy;", "getGoodsNo", "()Ljava/lang/String;", "goodsNo", "evaluate$delegate", "getEvaluate", "()Ljava/lang/Integer;", CommodityCommentListFragment.EVALUATE, "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "<init>", "()V", "Companion", "a", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class CommodityCommentListFragment extends BaseMVVMFragment<MallFragmentCommodityCommentListBinding, CommodityCommentListVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String EVALUATE = "evaluate";

    @NotNull
    public static final String GOODS_NO = "goodsNo";

    /* JADX INFO: renamed from: goodsNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy goodsNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.page.comment.list.CommodityCommentListFragment$goodsNo$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            Bundle arguments = this.this$0.getArguments();
            if (arguments != null) {
                return arguments.getString("goodsNo");
            }
            return null;
        }
    });

    /* JADX INFO: renamed from: evaluate$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy evaluate = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.mall.page.comment.list.CommodityCommentListFragment$evaluate$2
        {
            super(0);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m506invoke() {
            Bundle arguments = this.this$0.getArguments();
            if (arguments != null) {
                return Integer.valueOf(arguments.getInt(CommodityCommentListFragment.EVALUATE));
            }
            return null;
        }
    });

    @NotNull
    private final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.qp1
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            CommodityCommentListFragment.onRefreshListener$lambda$0(this.f44267a);
        }
    };

    /* JADX INFO: renamed from: com.huachenjie.mall.page.comment.list.CommodityCommentListFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/mall/page/comment/list/CommodityCommentListFragment$a;", "", "", "goodsNo", "", CommodityCommentListFragment.EVALUATE, "Lcom/huachenjie/mall/page/comment/list/CommodityCommentListFragment;", "a", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/huachenjie/mall/page/comment/list/CommodityCommentListFragment;", "EVALUATE", "Ljava/lang/String;", "GOODS_NO", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CommodityCommentListFragment a(@NotNull String goodsNo, @Nullable Integer evaluate) {
            Intrinsics.checkNotNullParameter(goodsNo, "goodsNo");
            CommodityCommentListFragment commodityCommentListFragment = new CommodityCommentListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("goodsNo", goodsNo);
            if (evaluate != null) {
                bundle.putInt(CommodityCommentListFragment.EVALUATE, evaluate.intValue());
            }
            commodityCommentListFragment.setArguments(bundle);
            return commodityCommentListFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35152a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35152a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35152a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35152a.invoke(obj);
        }
    }

    public static final /* synthetic */ MallFragmentCommodityCommentListBinding access$getMBinding(CommodityCommentListFragment commodityCommentListFragment) {
        return commodityCommentListFragment.getMBinding();
    }

    private final Integer getEvaluate() {
        return (Integer) this.evaluate.getValue();
    }

    private final String getGoodsNo() {
        return (String) this.goodsNo.getValue();
    }

    private final void initAdapter() {
        MallFragmentCommodityCommentListBinding mBinding = getMBinding();
        if (mBinding != null) {
            CommodityCommentAdapter commodityCommentAdapter = new CommodityCommentAdapter();
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.mall_layout_empty_data, (ViewGroup) null);
            View viewFindViewById = viewInflate.findViewById(R.id.bt_empty);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
            }
            Intrinsics.checkNotNullExpressionValue(viewInflate, "view");
            commodityCommentAdapter.g(viewInflate);
            commodityCommentAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.pp1
                @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
                public final void onLoadMore() {
                    CommodityCommentListFragment.initAdapter$lambda$2$lambda$1(this.f44034a);
                }
            });
            getMViewModel().i().setValue(commodityCommentAdapter);
            StateLayout stateLayout = mBinding.f10667a;
            Intrinsics.checkNotNullExpressionValue(stateLayout, "stateLayout");
            StateLayout.showLoading$default(stateLayout, null, false, false, 7, null);
        }
        getMViewModel().n().observe(this, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.mall.page.comment.list.CommodityCommentListFragment.initAdapter.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                MallFragmentCommodityCommentListBinding mallFragmentCommodityCommentListBindingAccess$getMBinding;
                StateLayout stateLayout2;
                if (bool.booleanValue() || (mallFragmentCommodityCommentListBindingAccess$getMBinding = CommodityCommentListFragment.access$getMBinding(CommodityCommentListFragment.this)) == null || (stateLayout2 = mallFragmentCommodityCommentListBindingAccess$getMBinding.f10667a) == null) {
                    return;
                }
                StateLayout.showContent$default(stateLayout2, null, 1, null);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$2$lambda$1(CommodityCommentListFragment commodityCommentListFragment) {
        Intrinsics.checkNotNullParameter(commodityCommentListFragment, "this$0");
        commodityCommentListFragment.getMViewModel().o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRefreshListener$lambda$0(CommodityCommentListFragment commodityCommentListFragment) {
        Intrinsics.checkNotNullParameter(commodityCommentListFragment, "this$0");
        commodityCommentListFragment.getMViewModel().q();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_fragment_commodity_comment_list;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.R), this.onRefreshListener)});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().q();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        getMViewModel().k().setValue(getGoodsNo());
        IntRange intRange = new IntRange(1, 3);
        Integer evaluate = getEvaluate();
        if (evaluate != null && intRange.contains(evaluate.intValue())) {
            getMViewModel().j().setValue(getEvaluate());
        }
        initAdapter();
    }
}
