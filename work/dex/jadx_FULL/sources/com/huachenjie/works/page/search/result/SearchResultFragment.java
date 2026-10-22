package com.huachenjie.works.page.search.result;

import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.huachenjie.base.util.manager.IMallModule;
import com.huachenjie.base.works.BaseSearchResultFragment;
import com.huachenjie.base.works.ISearchContentChangeListener;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.common.widget.SelectBoldTabLayout;
import com.huachenjie.works.R;
import com.huachenjie.works.databinding.WorksFragmentSearchResultBinding;
import com.huachenjie.works.page.search.result.child.SearchResultBuddyFragment;
import com.huachenjie.works.page.search.result.child.SearchResultChannelFragment;
import com.huachenjie.works.page.search.result.child.SearchResultUserFragment;
import com.huachenjie.works.page.search.result.child.SearchResultWorksFragment;
import com.zj.adlib.cd4;
import com.zj.adlib.dq1;
import com.zj.adlib.qk0;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0016J\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0010R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/works/page/search/result/SearchResultFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentSearchResultBinding;", "Lcom/huachenjie/works/page/search/result/SearchResultModel;", "()V", "fragmentList", "", "Landroidx/fragment/app/Fragment;", "getFragmentList", "()Ljava/util/List;", "fragmentList$delegate", "Lkotlin/Lazy;", "getLayoutResID", "", "getSearchResultTabTitles", "", "", "()[Ljava/lang/String;", "getVariables", "", "", "initView", "", BaseSearchResultFragment.SEARCH_CONTENT_KEY, "content", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSearchResultFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchResultFragment.kt\ncom/huachenjie/works/page/search/result/SearchResultFragment\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,102:1\n37#2,2:103\n1855#3,2:105\n*S KotlinDebug\n*F\n+ 1 SearchResultFragment.kt\ncom/huachenjie/works/page/search/result/SearchResultFragment\n*L\n75#1:103,2\n88#1:105,2\n*E\n"})
public final class SearchResultFragment extends BaseMVVMFragment<WorksFragmentSearchResultBinding, SearchResultModel> {

    /* JADX INFO: renamed from: fragmentList$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy fragmentList = LazyKt.lazy(new Function0<List<Fragment>>() { // from class: com.huachenjie.works.page.search.result.SearchResultFragment$fragmentList$2
        @NotNull
        public final List<Fragment> invoke() {
            BaseSearchResultFragment<?, ?> searchResultWorksFragment;
            List<Fragment> listMutableListOf = CollectionsKt.mutableListOf(new Fragment[]{new SearchResultWorksFragment(), new SearchResultUserFragment(), new SearchResultChannelFragment()});
            if (dq1.e().getBuddyEnable()) {
                listMutableListOf.add(new SearchResultBuddyFragment());
            }
            IMallModule iMallModule = (IMallModule) cd4.a(IMallModule.class);
            if (iMallModule == null || (searchResultWorksFragment = iMallModule.a()) == null) {
                searchResultWorksFragment = new SearchResultWorksFragment();
            }
            listMutableListOf.add(searchResultWorksFragment);
            return listMutableListOf;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Fragment> getFragmentList() {
        return (List) this.fragmentList.getValue();
    }

    private final String[] getSearchResultTabTitles() {
        String[] stringArray = getResources().getStringArray(R.array.works_search_result);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray…rray.works_search_result)");
        List mutableList = ArraysKt.toMutableList(stringArray);
        if (!dq1.e().getBuddyEnable()) {
            mutableList.remove(3);
        }
        return (String[]) mutableList.toArray(new String[0]);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_fragment_search_result;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        WorksFragmentSearchResultBinding mBinding = getMBinding();
        Intrinsics.checkNotNull(mBinding);
        mBinding.f14306a.setAdapter(new FragmentStateAdapter() { // from class: com.huachenjie.works.page.search.result.SearchResultFragment.initView.1
            {
                super(SearchResultFragment.this);
            }

            @Override // androidx.viewpager2.adapter.FragmentStateAdapter
            @NotNull
            public Fragment createFragment(int position) {
                return (Fragment) SearchResultFragment.this.getFragmentList().get(position);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return SearchResultFragment.this.getFragmentList().size();
            }
        });
        WorksFragmentSearchResultBinding mBinding2 = getMBinding();
        Intrinsics.checkNotNull(mBinding2);
        SelectBoldTabLayout selectBoldTabLayout = mBinding2.f14307a;
        WorksFragmentSearchResultBinding mBinding3 = getMBinding();
        Intrinsics.checkNotNull(mBinding3);
        ViewPager2 viewPager2 = mBinding3.f14306a;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "mBinding!!.vp");
        selectBoldTabLayout.attachViewPager(viewPager2, getSearchResultTabTitles());
        WorksFragmentSearchResultBinding mBinding4 = getMBinding();
        Intrinsics.checkNotNull(mBinding4);
        mBinding4.f14306a.setOffscreenPageLimit(getFragmentList().size());
    }

    public final void searchContent(@NotNull String content) {
        ViewPager2 viewPager2;
        Intrinsics.checkNotNullParameter(content, "content");
        WorksFragmentSearchResultBinding mBinding = getMBinding();
        Fragment fragment = null;
        if (((mBinding == null || (viewPager2 = mBinding.f14306a) == null) ? null : viewPager2.getAdapter()) != null) {
            List<Fragment> fragmentList = getFragmentList();
            WorksFragmentSearchResultBinding mBinding2 = getMBinding();
            Intrinsics.checkNotNull(mBinding2);
            fragment = (Fragment) CollectionsKt.getOrNull(fragmentList, mBinding2.f14306a.getCurrentItem());
        }
        for (ActivityResultCaller activityResultCaller : getFragmentList()) {
            if (activityResultCaller instanceof ISearchContentChangeListener) {
                if (Intrinsics.areEqual(activityResultCaller, fragment)) {
                    ((ISearchContentChangeListener) activityResultCaller).startSearch(content);
                } else {
                    ((ISearchContentChangeListener) activityResultCaller).onSearchContentChange(content);
                }
            }
        }
    }
}
