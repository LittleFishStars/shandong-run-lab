package com.huachenjie.works.page.search.fast_lenovo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.works.R;
import com.huachenjie.works.adapter.search.SearchFastLenovoAdapter;
import com.huachenjie.works.databinding.WorksFragmentSearchFastLenovoBinding;
import com.huachenjie.works.page.search.SearchActivity;
import com.huachenjie.works.page.search.fast_lenovo.SearchFastLenovoFragment;
import com.zj.adlib.qk0;
import com.zj.adlib.y57;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001 B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fR\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Lcom/huachenjie/works/page/search/fast_lenovo/SearchFastLenovoFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentSearchFastLenovoBinding;", "Lcom/huachenjie/works/page/search/fast_lenovo/SearchFastLenovoModel;", "", "initAdapter", "", "", "", "getVariables", "getLayoutResID", "initData", "", "hidden", "onHiddenChanged", "", CachedContentIndex.a.e, "searchFastLenovo", "Landroid/os/Handler;", "fastLenovoHandler$delegate", "Lkotlin/Lazy;", "getFastLenovoHandler", "()Landroid/os/Handler;", "fastLenovoHandler", "Ljava/lang/Runnable;", "fastLenovoCallback$delegate", "getFastLenovoCallback", "()Ljava/lang/Runnable;", "fastLenovoCallback", "<init>", "()V", "Companion", "a", "works_release"}, k = 1, mv = {1, 8, 0})
public final class SearchFastLenovoFragment extends BaseMVVMFragment<WorksFragmentSearchFastLenovoBinding, SearchFastLenovoModel> {
    private static final long SEARCH_DELAY_TIME = 100;

    @NotNull
    private static final String SEARCH_VALUE_KEY = "searchValue";

    /* JADX INFO: renamed from: fastLenovoHandler$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy fastLenovoHandler = LazyKt.lazy(new Function0<Handler>() { // from class: com.huachenjie.works.page.search.fast_lenovo.SearchFastLenovoFragment$fastLenovoHandler$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m968invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    /* JADX INFO: renamed from: fastLenovoCallback$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy fastLenovoCallback = LazyKt.lazy(new SearchFastLenovoFragment$fastLenovoCallback$2(this));

    private final Runnable getFastLenovoCallback() {
        return (Runnable) this.fastLenovoCallback.getValue();
    }

    private final Handler getFastLenovoHandler() {
        return (Handler) this.fastLenovoHandler.getValue();
    }

    private final void initAdapter() {
        MutableLiveData<SearchFastLenovoAdapter> mutableLiveDataI = getMViewModel().i();
        final SearchFastLenovoAdapter searchFastLenovoAdapter = new SearchFastLenovoAdapter();
        y57.d(searchFastLenovoAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.wx7
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SearchFastLenovoFragment.initAdapter$lambda$1$lambda$0(this.f20582a, searchFastLenovoAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        mutableLiveDataI.setValue(searchFastLenovoAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$1$lambda$0(SearchFastLenovoFragment searchFastLenovoFragment, SearchFastLenovoAdapter searchFastLenovoAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(searchFastLenovoFragment, "this$0");
        Intrinsics.checkNotNullParameter(searchFastLenovoAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        FragmentActivity activity = searchFastLenovoFragment.getActivity();
        SearchActivity searchActivity = activity instanceof SearchActivity ? (SearchActivity) activity : null;
        if (searchActivity != null) {
            SearchActivity.l0(searchActivity, searchFastLenovoAdapter.getData().get(i), false, 2, null);
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_fragment_search_fast_lenovo;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        String string;
        super.initData();
        initAdapter();
        MutableLiveData<String> mutableLiveDataJ = getMViewModel().j();
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(SEARCH_VALUE_KEY)) == null) {
            string = "";
        }
        mutableLiveDataJ.setValue(string);
        getMViewModel().k();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            getMViewModel().k();
            return;
        }
        SearchFastLenovoAdapter value = getMViewModel().i().getValue();
        if (value != null) {
            value.setList(CollectionsKt.emptyList());
        }
    }

    public final void searchFastLenovo(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, CachedContentIndex.a.e);
        if (isAdded()) {
            getMViewModel().j().setValue(key);
            getFastLenovoHandler().removeCallbacks(getFastLenovoCallback());
            getFastLenovoHandler().postDelayed(getFastLenovoCallback(), 100L);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(SEARCH_VALUE_KEY, key);
            setArguments(bundle);
        }
    }
}
