package com.huachenjie.mall.page.video_enter;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.MyCourseOrEpisodesBean;
import com.huachenjie.mall.databinding.MallFragmentPurchasedVideoGoodsBinding;
import com.huachenjie.mall.page.course_detail.CourseDetailActivity;
import com.huachenjie.mall.page.episodes_detail.EpisodesDetailActivity;
import com.huachenjie.mall.page.video_enter.PurchasedVideoGoodsFragment;
import com.zj.adlib.hk0;
import com.zj.adlib.y57;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016R\u001b\u0010\u0011\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/mall/page/video_enter/PurchasedVideoGoodsFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/mall/databinding/MallFragmentPurchasedVideoGoodsBinding;", "Lcom/huachenjie/mall/page/video_enter/PurchasedVideoGoodsVM;", "", "initAdapter", "", "", "", "getVariables", "getLayoutResID", "initView", "initData", "type$delegate", "Lkotlin/Lazy;", "getType", "()I", "type", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "<init>", "()V", "Companion", "a", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class PurchasedVideoGoodsFragment extends BaseMVVMFragment<MallFragmentPurchasedVideoGoodsBinding, PurchasedVideoGoodsVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_TYPE = "type";

    /* JADX INFO: renamed from: type$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy type = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.mall.page.video_enter.PurchasedVideoGoodsFragment$type$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m581invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("type") : 0);
        }
    });

    @NotNull
    private final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.k47
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            PurchasedVideoGoodsFragment.onRefreshListener$lambda$0(this.f42741a);
        }
    };

    /* JADX INFO: renamed from: com.huachenjie.mall.page.video_enter.PurchasedVideoGoodsFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/mall/page/video_enter/PurchasedVideoGoodsFragment$a;", "", "", "type", "Lcom/huachenjie/mall/page/video_enter/PurchasedVideoGoodsFragment;", "a", "", "KEY_TYPE", "Ljava/lang/String;", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PurchasedVideoGoodsFragment a(int type) {
            PurchasedVideoGoodsFragment purchasedVideoGoodsFragment = new PurchasedVideoGoodsFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("type", type);
            purchasedVideoGoodsFragment.setArguments(bundle);
            return purchasedVideoGoodsFragment;
        }
    }

    private final int getType() {
        return ((Number) this.type.getValue()).intValue();
    }

    private final void initAdapter() {
        MutableLiveData<PurchasedVideoGoodsAdapter> mutableLiveDataB = getMViewModel().B();
        final PurchasedVideoGoodsAdapter purchasedVideoGoodsAdapter = new PurchasedVideoGoodsAdapter();
        PurchasedVideoGoodsVM mViewModel = getMViewModel();
        MallFragmentPurchasedVideoGoodsBinding mBinding = getMBinding();
        Intrinsics.checkNotNull(mBinding);
        StateLayout stateLayout = mBinding.f10691a;
        Intrinsics.checkNotNullExpressionValue(stateLayout, "mBinding!!.stateLayout");
        BaseStateRequestModel.p(mViewModel, this, stateLayout, purchasedVideoGoodsAdapter, false, 8, null);
        BaseStateRequestModel.n(getMViewModel(), this, purchasedVideoGoodsAdapter, false, 4, null);
        purchasedVideoGoodsAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.l47
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                PurchasedVideoGoodsFragment.initAdapter$lambda$3$lambda$1(this.f42995a);
            }
        });
        y57.d(purchasedVideoGoodsAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.m47
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                PurchasedVideoGoodsFragment.initAdapter$lambda$3$lambda$2(purchasedVideoGoodsAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        mutableLiveDataB.setValue(purchasedVideoGoodsAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$3$lambda$1(PurchasedVideoGoodsFragment purchasedVideoGoodsFragment) {
        Intrinsics.checkNotNullParameter(purchasedVideoGoodsFragment, "this$0");
        BaseStateRequestModel.x(purchasedVideoGoodsFragment.getMViewModel(), false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$3$lambda$2(PurchasedVideoGoodsAdapter purchasedVideoGoodsAdapter, PurchasedVideoGoodsFragment purchasedVideoGoodsFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(purchasedVideoGoodsAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(purchasedVideoGoodsFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        MyCourseOrEpisodesBean item = purchasedVideoGoodsAdapter.getItem(i);
        if (purchasedVideoGoodsFragment.getType() == 0) {
            CourseDetailActivity.Companion companion = CourseDetailActivity.INSTANCE;
            Context contextRequireContext = purchasedVideoGoodsFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            companion.b(contextRequireContext, item.getOrderItemNo());
            return;
        }
        EpisodesDetailActivity.Companion companion2 = EpisodesDetailActivity.INSTANCE;
        Context contextRequireContext2 = purchasedVideoGoodsFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        companion2.b(contextRequireContext2, item.getOrderItemNo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRefreshListener$lambda$0(PurchasedVideoGoodsFragment purchasedVideoGoodsFragment) {
        Intrinsics.checkNotNullParameter(purchasedVideoGoodsFragment, "this$0");
        purchasedVideoGoodsFragment.getMViewModel().y();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_fragment_purchased_video_goods;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.R), this.onRefreshListener)});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().C(getType());
        getMViewModel().y();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initAdapter();
    }
}
