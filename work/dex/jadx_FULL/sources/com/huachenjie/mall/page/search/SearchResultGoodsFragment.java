package com.huachenjie.mall.page.search;

import android.content.Context;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.base.works.BaseSearchResultFragment;
import com.huachenjie.mall.R;
import com.huachenjie.mall.databinding.MallFragmentSearchResultGoodsBinding;
import com.huachenjie.mall.external.adapter.CommodityAdapter;
import com.huachenjie.mall.external.bean.CommodityBean;
import com.huachenjie.mall.page.goods_detail.GoodsDetailActivity;
import com.huachenjie.mall.page.search.SearchResultGoodsFragment;
import com.zj.adlib.qk0;
import com.zj.adlib.y57;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/huachenjie/mall/page/search/SearchResultGoodsFragment;", "Lcom/huachenjie/base/works/BaseSearchResultFragment;", "Lcom/huachenjie/mall/databinding/MallFragmentSearchResultGoodsBinding;", "Lcom/huachenjie/mall/page/search/SearchResultGoodsModel;", "()V", "getLayoutResID", "", "getVariables", "", "", "initView", "", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SearchResultGoodsFragment extends BaseSearchResultFragment<MallFragmentSearchResultGoodsBinding, SearchResultGoodsModel> {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$1$lambda$0(CommodityAdapter commodityAdapter, SearchResultGoodsFragment searchResultGoodsFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(commodityAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(searchResultGoodsFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        CommodityBean commodityBean = (CommodityBean) commodityAdapter.getItem(i);
        GoodsDetailActivity.Companion companion = GoodsDetailActivity.INSTANCE;
        Context contextRequireContext = searchResultGoodsFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        companion.a(contextRequireContext, commodityBean.getGoodsNo());
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_fragment_search_result_goods;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(qk0.R), getOnRefreshListener())});
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        MutableLiveData<BaseQuickAdapter<CommodityBean, ?>> mutableLiveDataB = ((SearchResultGoodsModel) getMViewModel()).B();
        final CommodityAdapter commodityAdapter = new CommodityAdapter(0.0f, 0.0f, 0.0f, 7, null);
        y57.d(commodityAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.iy7
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SearchResultGoodsFragment.initView$lambda$1$lambda$0(commodityAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        mutableLiveDataB.setValue(commodityAdapter);
    }
}
