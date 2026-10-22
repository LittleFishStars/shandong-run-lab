package com.huachenjie.works.page.search.result.child;

import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.huachenjie.base.works.BaseSearchResultFragment;
import com.huachenjie.base.works.ISearchContentChangeListener;
import com.huachenjie.works.R;
import com.huachenjie.works.databinding.WorksFragmentSearchResultWorksBinding;
import com.huachenjie.works.external.adapter.WorksAdapter;
import com.zj.adlib.qk0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0016J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/works/page/search/result/child/SearchResultWorksFragment;", "Lcom/huachenjie/base/works/BaseSearchResultFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentSearchResultWorksBinding;", "Lcom/huachenjie/works/page/search/result/child/SearchResultWorksModel;", "Lcom/huachenjie/base/works/ISearchContentChangeListener;", "()V", "getLayoutResID", "", "getVariables", "", "", "initAdapter", "Lcom/huachenjie/works/external/adapter/WorksAdapter;", "initView", "", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SearchResultWorksFragment extends BaseSearchResultFragment<WorksFragmentSearchResultWorksBinding, SearchResultWorksModel> implements ISearchContentChangeListener {
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_fragment_search_result_works;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(qk0.R), getOnRefreshListener())});
    }

    @NotNull
    public final WorksAdapter initAdapter() {
        return new WorksAdapter() { // from class: com.huachenjie.works.page.search.result.child.SearchResultWorksFragment.initAdapter.1
            {
                super(false, false, false, 7, null);
            }

            @Override // com.huachenjie.works.external.adapter.WorksAdapter
            public void s(@NotNull TextView tvEmpty, @NotNull ConstraintLayout.LayoutParams ivLayoutParams) {
                Intrinsics.checkNotNullParameter(tvEmpty, "tvEmpty");
                Intrinsics.checkNotNullParameter(ivLayoutParams, "ivLayoutParams");
                tvEmpty.setText(SearchResultWorksFragment.this.getString(R.string.works_works_search_empty));
                ivLayoutParams.verticalBias = 0.4f;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        ((SearchResultWorksModel) getMViewModel()).B().setValue(initAdapter());
        WorksFragmentSearchResultWorksBinding worksFragmentSearchResultWorksBinding = (WorksFragmentSearchResultWorksBinding) getMBinding();
        RecyclerView recyclerView = worksFragmentSearchResultWorksBinding != null ? worksFragmentSearchResultWorksBinding.f36959a : null;
        if (recyclerView == null) {
            return;
        }
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        staggeredGridLayoutManager.setGapStrategy(0);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
    }
}
