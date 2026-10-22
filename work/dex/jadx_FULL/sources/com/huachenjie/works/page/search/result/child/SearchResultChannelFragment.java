package com.huachenjie.works.page.search.result.child;

import com.huachenjie.base.works.BaseSearchResultFragment;
import com.huachenjie.works.R;
import com.huachenjie.works.adapter.search.SearchResultChannelAdapter;
import com.huachenjie.works.databinding.WorksFragmentSearchResultChannelBinding;
import com.zj.adlib.qk0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/huachenjie/works/page/search/result/child/SearchResultChannelFragment;", "Lcom/huachenjie/base/works/BaseSearchResultFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentSearchResultChannelBinding;", "Lcom/huachenjie/works/page/search/result/child/SearchResultChannelModel;", "()V", "getLayoutResID", "", "getVariables", "", "", "initView", "", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SearchResultChannelFragment extends BaseSearchResultFragment<WorksFragmentSearchResultChannelBinding, SearchResultChannelModel> {
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_fragment_search_result_channel;
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
        ((SearchResultChannelModel) getMViewModel()).B().setValue(new SearchResultChannelAdapter());
    }
}
