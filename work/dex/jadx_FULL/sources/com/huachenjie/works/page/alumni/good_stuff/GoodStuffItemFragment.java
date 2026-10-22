package com.huachenjie.works.page.alumni.good_stuff;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.base.works.BaseSearchResultFragment;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.GoodStuffBean;
import com.huachenjie.works.databinding.WorksFragmentGoodStuffItemBinding;
import com.huachenjie.works.page.alumni.good_stuff.GoodStuffItemFragment;
import com.zj.adlib.il0;
import com.zj.adlib.lq5;
import com.zj.adlib.qk0;
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
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 <2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001=B\u0007¢\u0006\u0004\b:\u0010;J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\u0006\u0010\u0018\u001a\u00020\bJ\b\u0010\u0019\u001a\u00020\bH\u0016J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0010H\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016R\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001b\u0010+\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010%\u001a\u0004\b*\u0010'R\u0016\u0010,\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00101\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00100R\u0016\u00102\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010-R\u0016\u00103\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010-R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010-¨\u0006>"}, d2 = {"Lcom/huachenjie/works/page/alumni/good_stuff/GoodStuffItemFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentGoodStuffItemBinding;", "Lcom/huachenjie/works/page/alumni/good_stuff/GoodStuffItemVM;", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "initLayoutManager", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "changeMaxPosition", "", "positions", "", "getMaxPosition", "checkVisible", "onVisibleToUser", "", "visible", "onVisibleChange", "", "", "getVariables", "getLayoutResID", "initView", "initAdapter", "initData", "hidden", "onHiddenChanged", "isVisibleToUser", "setUserVisibleHint", "onResume", "onPause", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "", "tabCode$delegate", "Lkotlin/Lazy;", "getTabCode", "()Ljava/lang/String;", "tabCode", "tabName$delegate", "getTabName", "tabName", "hasInitModel", "Z", "hasInitData", "hiddenChanged", "Ljava/lang/Boolean;", "visibleToUser", "realVisible", BaseSearchResultFragment.NEED_REFRESH_KEY, "", "lastShowTime", "J", "lastMaxPosition", "I", "hasScroll", "<init>", "()V", "Companion", "a", "works_release"}, k = 1, mv = {1, 8, 0})
public final class GoodStuffItemFragment extends BaseMVVMFragment<WorksFragmentGoodStuffItemBinding, GoodStuffItemVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String WORK_TAB_CODE = "tabCode";

    @NotNull
    public static final String WORK_TAB_NAME = "tabName";
    private boolean hasInitData;
    private boolean hasInitModel;
    private boolean hasScroll;

    @Nullable
    private Boolean hiddenChanged;
    private long lastShowTime;
    private boolean needRefresh;
    private boolean realVisible;

    @Nullable
    private Boolean visibleToUser;

    @NotNull
    private final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.fv3
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            GoodStuffItemFragment.onRefreshListener$lambda$0(this.f41764a);
        }
    };

    /* JADX INFO: renamed from: tabCode$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy tabCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.alumni.good_stuff.GoodStuffItemFragment$tabCode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("tabCode")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: tabName$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy tabName = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.alumni.good_stuff.GoodStuffItemFragment$tabName$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("tabName")) == null) ? "" : string;
        }
    });
    private int lastMaxPosition = -1;

    /* JADX INFO: renamed from: com.huachenjie.works.page.alumni.good_stuff.GoodStuffItemFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\b¨\u0006\f"}, d2 = {"Lcom/huachenjie/works/page/alumni/good_stuff/GoodStuffItemFragment$a;", "", "", "tabCode", "tabName", "Lcom/huachenjie/works/page/alumni/good_stuff/GoodStuffItemFragment;", "a", "WORK_TAB_CODE", "Ljava/lang/String;", "WORK_TAB_NAME", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GoodStuffItemFragment a(@NotNull String tabCode, @NotNull String tabName) {
            Intrinsics.checkNotNullParameter(tabCode, "tabCode");
            Intrinsics.checkNotNullParameter(tabName, "tabName");
            GoodStuffItemFragment goodStuffItemFragment = new GoodStuffItemFragment();
            Bundle bundle = new Bundle();
            bundle.putString("tabCode", tabCode);
            bundle.putString("tabName", tabName);
            goodStuffItemFragment.setArguments(bundle);
            return goodStuffItemFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37175a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37175a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37175a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37175a.invoke(obj);
        }
    }

    public static final /* synthetic */ WorksFragmentGoodStuffItemBinding access$getMBinding(GoodStuffItemFragment goodStuffItemFragment) {
        return goodStuffItemFragment.getMBinding();
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

    private final void checkVisible() {
        Boolean bool = this.hiddenChanged;
        Boolean bool2 = Boolean.TRUE;
        if (Intrinsics.areEqual(bool, bool2) || !Intrinsics.areEqual(this.visibleToUser, bool2)) {
            if (this.realVisible) {
                this.realVisible = false;
                onVisibleChange(false);
                return;
            }
            return;
        }
        onVisibleToUser();
        if (this.realVisible) {
            return;
        }
        this.realVisible = true;
        onVisibleChange(true);
    }

    private final int getMaxPosition(int[] positions) {
        int iMax = -1;
        for (int i : positions) {
            iMax = (int) Math.max(iMax, i);
        }
        return iMax;
    }

    private final String getTabCode() {
        return (String) this.tabCode.getValue();
    }

    private final String getTabName() {
        return (String) this.tabName.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$3$lambda$1(GoodStuffItemFragment goodStuffItemFragment) {
        Intrinsics.checkNotNullParameter(goodStuffItemFragment, "this$0");
        goodStuffItemFragment.getMViewModel().n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initAdapter$lambda$3$lambda$2(GoodStuffAdapter goodStuffAdapter, GoodStuffItemFragment goodStuffItemFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(goodStuffAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(goodStuffItemFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "view");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        GoodStuffBean goodStuffBean = (GoodStuffBean) goodStuffAdapter.getItem(i);
        String clickUrl = goodStuffBean.getPublishInfo().getClickUrl();
        if (TextUtils.isEmpty(clickUrl)) {
            return;
        }
        if (!StringsKt.startsWith$default(clickUrl, "http", false, 2, (Object) null)) {
            clickUrl = "https://" + clickUrl;
        }
        Context context = baseQuickAdapter.getContext();
        String tabCode = goodStuffItemFragment.getTabCode();
        Intrinsics.checkNotNullExpressionValue(tabCode, "tabCode");
        String tabName = goodStuffItemFragment.getTabName();
        Intrinsics.checkNotNullExpressionValue(tabName, "tabName");
        lq5.c(context, tabCode, tabName, goodStuffBean.findGoodsName(), clickUrl, String.valueOf(i));
        il0 il0Var = il0.f42382a;
        FragmentActivity fragmentActivityRequireActivity = goodStuffItemFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        il0Var.d(fragmentActivityRequireActivity, clickUrl);
    }

    private final StaggeredGridLayoutManager initLayoutManager() {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        staggeredGridLayoutManager.setGapStrategy(0);
        return staggeredGridLayoutManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRefreshListener$lambda$0(GoodStuffItemFragment goodStuffItemFragment) {
        Intrinsics.checkNotNullParameter(goodStuffItemFragment, "this$0");
        goodStuffItemFragment.getMViewModel().p();
    }

    private final void onVisibleChange(boolean visible) {
        if (visible) {
            this.lastShowTime = System.currentTimeMillis();
            return;
        }
        if (this.lastShowTime > 0) {
            int iCurrentTimeMillis = (int) ((System.currentTimeMillis() - this.lastShowTime) / ((long) 1000));
            this.lastShowTime = 0L;
            Context context = getContext();
            if (context != null) {
                String tabCode = getTabCode();
                Intrinsics.checkNotNullExpressionValue(tabCode, "tabCode");
                String tabName = getTabName();
                Intrinsics.checkNotNullExpressionValue(tabName, "tabName");
                lq5.b(context, tabCode, tabName, String.valueOf(iCurrentTimeMillis));
                if (this.lastMaxPosition > -1) {
                    String tabCode2 = getTabCode();
                    Intrinsics.checkNotNullExpressionValue(tabCode2, "tabCode");
                    String tabName2 = getTabName();
                    Intrinsics.checkNotNullExpressionValue(tabName2, "tabName");
                    lq5.a(context, tabCode2, tabName2, String.valueOf(this.lastMaxPosition + 1));
                }
            }
        }
    }

    private final void onVisibleToUser() {
        if (!this.hasInitData && this.hasInitModel) {
            this.hasInitData = true;
            getMViewModel().p();
        } else if (this.needRefresh) {
            this.needRefresh = false;
            getMViewModel().p();
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_fragment_good_stuff_item;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(qk0.R), this.onRefreshListener)});
    }

    public final void initAdapter() {
        final WorksFragmentGoodStuffItemBinding mBinding = getMBinding();
        if (mBinding != null) {
            mBinding.f36911a.setLayoutManager(initLayoutManager());
            final GoodStuffAdapter goodStuffAdapter = new GoodStuffAdapter(0.0f, 0.0f, 0.0f, 7, null);
            goodStuffAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.gv3
                @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
                public final void onLoadMore() {
                    GoodStuffItemFragment.initAdapter$lambda$3$lambda$1(this.f41991a);
                }
            });
            y57.d(goodStuffAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.hv3
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    GoodStuffItemFragment.initAdapter$lambda$3$lambda$2(goodStuffAdapter, this, baseQuickAdapter, view, i);
                }
            }, 1, null);
            mBinding.f36911a.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.huachenjie.works.page.alumni.good_stuff.GoodStuffItemFragment$initAdapter$1$3
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
                    Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                    if (newState == 0) {
                        this.f37176a.hasScroll = true;
                        this.f37176a.changeMaxPosition(recyclerView);
                    }
                }
            });
            mBinding.f36911a.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.huachenjie.works.page.alumni.good_stuff.GoodStuffItemFragment$initAdapter$1$4
                @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
                public void onChildViewAttachedToWindow(@NotNull View view) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (this.f14865a.hasScroll) {
                        return;
                    }
                    GoodStuffItemFragment goodStuffItemFragment = this.f14865a;
                    RecyclerView recyclerView = mBinding.f36911a;
                    Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
                    goodStuffItemFragment.changeMaxPosition(recyclerView);
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
                public void onChildViewDetachedFromWindow(@NotNull View view) {
                    Intrinsics.checkNotNullParameter(view, "view");
                }
            });
            getMViewModel().i().setValue(goodStuffAdapter);
            mBinding.f14207a.setEnabled(true);
            StateLayout stateLayout = mBinding.f14208a;
            Intrinsics.checkNotNullExpressionValue(stateLayout, "stateLayout");
            StateLayout.showLoading$default(stateLayout, null, false, false, 7, null);
        }
        getMViewModel().m().observe(this, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.works.page.alumni.good_stuff.GoodStuffItemFragment.initAdapter.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                WorksFragmentGoodStuffItemBinding worksFragmentGoodStuffItemBindingAccess$getMBinding;
                StateLayout stateLayout2;
                if (bool.booleanValue() || (worksFragmentGoodStuffItemBindingAccess$getMBinding = GoodStuffItemFragment.access$getMBinding(GoodStuffItemFragment.this)) == null || (stateLayout2 = worksFragmentGoodStuffItemBindingAccess$getMBinding.f14208a) == null) {
                    return;
                }
                StateLayout.showContent$default(stateLayout2, null, 1, null);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        GoodStuffItemVM mViewModel = getMViewModel();
        String tabCode = getTabCode();
        Intrinsics.checkNotNullExpressionValue(tabCode, "tabCode");
        mViewModel.s(tabCode);
        this.hasInitModel = true;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        initAdapter();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        this.hiddenChanged = Boolean.valueOf(hidden);
        checkVisible();
        super.onHiddenChanged(hidden);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        if (this.realVisible) {
            this.realVisible = false;
            onVisibleChange(false);
        }
        super.onPause();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        checkVisible();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.visibleToUser = Boolean.valueOf(isVisibleToUser);
        checkVisible();
        super.setUserVisibleHint(isVisibleToUser);
    }
}
