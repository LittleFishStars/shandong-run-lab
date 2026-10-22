package com.huachenjie.works.page.search.result.child;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.huachenjie.base.works.BaseSearchResultFragment;
import com.huachenjie.works.R;
import com.huachenjie.works.adapter.buddy.BuddyCardAdapter;
import com.huachenjie.works.bean.BuddyCardBean;
import com.huachenjie.works.bean.BuddyTypeScopeTypeBean;
import com.huachenjie.works.bean.BuddyUserBean;
import com.huachenjie.works.databinding.WorksFragmentSearchResultBuddyBinding;
import com.huachenjie.works.page.buddy.BuddyApplyDialog;
import com.huachenjie.works.page.search.result.child.SearchResultBuddyFragment;
import com.zj.adlib.qk0;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/huachenjie/works/page/search/result/child/SearchResultBuddyFragment;", "Lcom/huachenjie/base/works/BaseSearchResultFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentSearchResultBuddyBinding;", "Lcom/huachenjie/works/page/search/result/child/SearchResultBuddyModel;", "()V", "getLayoutResID", "", "getVariables", "", "", "initView", "", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SearchResultBuddyFragment extends BaseSearchResultFragment<WorksFragmentSearchResultBuddyBinding, SearchResultBuddyModel> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1$lambda$0(BuddyCardAdapter buddyCardAdapter, SearchResultBuddyFragment searchResultBuddyFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(buddyCardAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(searchResultBuddyFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        BuddyCardBean item = buddyCardAdapter.getItem(i);
        if (item.isJoinButtonEnabled()) {
            BuddyApplyDialog.Companion companion = BuddyApplyDialog.INSTANCE;
            FragmentManager parentFragmentManager = searchResultBuddyFragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            String buddyCode = item.getBuddyCode();
            BuddyUserBean creatorInfo = item.getCreatorInfo();
            String avatar = creatorInfo != null ? creatorInfo.getAvatar() : null;
            String str = avatar == null ? "" : avatar;
            String str2 = item.formatterTitle();
            List<String> list = item.formatterTagList();
            BuddyTypeScopeTypeBean buddyTypeInfo = item.getBuddyTypeInfo();
            String buddyTypeName = buddyTypeInfo != null ? buddyTypeInfo.getBuddyTypeName() : null;
            companion.a(parentFragmentManager, buddyCode, str, str2, list, (64 & 32) != 0 ? "" : buddyTypeName == null ? "" : buddyTypeName, (64 & 64) != 0 ? null : null);
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_fragment_search_result_buddy;
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
        MutableLiveData<BaseQuickAdapter<BuddyCardBean, ?>> mutableLiveDataB = ((SearchResultBuddyModel) getMViewModel()).B();
        final BuddyCardAdapter buddyCardAdapter = new BuddyCardAdapter();
        buddyCardAdapter.addChildClickViewIds(R.id.tv_buddy_join);
        buddyCardAdapter.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.zj.adlib.gy7
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SearchResultBuddyFragment.initView$lambda$1$lambda$0(buddyCardAdapter, this, baseQuickAdapter, view, i);
            }
        });
        mutableLiveDataB.setValue(buddyCardAdapter);
    }
}
