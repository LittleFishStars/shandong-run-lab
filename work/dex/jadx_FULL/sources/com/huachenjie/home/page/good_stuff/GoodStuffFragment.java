package com.huachenjie.home.page.good_stuff;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.GoodStuffBean;
import com.huachenjie.home.databinding.HomeFragmentGoodStuffBinding;
import com.huachenjie.home.page.good_stuff.GoodStuffFragment;
import com.zj.adlib.er7;
import com.zj.adlib.lq5;
import com.zj.adlib.xk0;
import com.zj.adlib.y57;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\r\u0018\u0000 :2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001;B\u0007¢\u0006\u0004\b8\u00109J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\u0006\u0010\u0019\u001a\u00020\u0004R\u001b\u0010\u001e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\"R\u001b\u0010&\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010\"R\u0016\u0010'\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010-R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010(R\u0016\u00103\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010-R\"\u00104\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010(\u001a\u0004\b5\u0010\u001d\"\u0004\b6\u00107¨\u0006<"}, d2 = {"Lcom/huachenjie/home/page/good_stuff/GoodStuffFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/home/databinding/HomeFragmentGoodStuffBinding;", "Lcom/huachenjie/home/page/good_stuff/GoodStuffVM;", "", "initScroll", "initAdapter", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "initLayoutManager", "", "visible", "onVisibleChange", "changeVisible", "", "positions", "", "getMaxPosition", "onFragmentRealVisibleChange", "", "getVariables", "getLayoutResID", "initView", "initData", "onResume", "onPause", "changeMaxPosition", "tabPosition$delegate", "Lkotlin/Lazy;", "getTabPosition", "()I", GoodStuffFragment.TAB_POSITION, "", "tabCode$delegate", "getTabCode", "()Ljava/lang/String;", "tabCode", "tabName$delegate", "getTabName", "tabName", "verticalOffset", "I", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasLoadData", "Ljava/util/concurrent/atomic/AtomicBoolean;", "realFragmentVisible", "Z", "realFirstViewVisible", "", "lastShowTime", "J", "lastMaxPosition", "hasScroll", "firstItemHeight", "getFirstItemHeight", "setFirstItemHeight", "(I)V", "<init>", "()V", "Companion", "a", "home_release"}, k = 1, mv = {1, 8, 0})
public final class GoodStuffFragment extends BaseMVVMFragment<HomeFragmentGoodStuffBinding, GoodStuffVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAB_CODE = "tabCode";

    @NotNull
    public static final String TAB_NAME = "tabName";

    @NotNull
    public static final String TAB_POSITION = "tabPosition";
    private int firstItemHeight;
    private boolean hasScroll;
    private long lastShowTime;
    private boolean realFirstViewVisible;
    private boolean realFragmentVisible;
    private int verticalOffset;

    /* JADX INFO: renamed from: tabPosition$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy tabPosition = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.home.page.good_stuff.GoodStuffFragment$tabPosition$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m422invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt(GoodStuffFragment.TAB_POSITION) : -1);
        }
    });

    /* JADX INFO: renamed from: tabCode$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy tabCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.home.page.good_stuff.GoodStuffFragment$tabCode$2
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
    private final Lazy tabName = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.home.page.good_stuff.GoodStuffFragment$tabName$2
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

    @NotNull
    private final AtomicBoolean hasLoadData = new AtomicBoolean(false);
    private int lastMaxPosition = -1;

    /* JADX INFO: renamed from: com.huachenjie.home.page.good_stuff.GoodStuffFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/home/page/good_stuff/GoodStuffFragment$a;", "", "", "position", "", "tabCode", "tabName", "Lcom/huachenjie/home/page/good_stuff/GoodStuffFragment;", "a", "TAB_CODE", "Ljava/lang/String;", "TAB_NAME", "TAB_POSITION", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GoodStuffFragment a(int position, @NotNull String tabCode, @NotNull String tabName) {
            Intrinsics.checkNotNullParameter(tabCode, "tabCode");
            Intrinsics.checkNotNullParameter(tabName, "tabName");
            GoodStuffFragment goodStuffFragment = new GoodStuffFragment();
            Bundle bundle = new Bundle();
            bundle.putString("tabCode", tabCode);
            bundle.putString("tabName", tabName);
            bundle.putInt(GoodStuffFragment.TAB_POSITION, position);
            goodStuffFragment.setArguments(bundle);
            return goodStuffFragment;
        }
    }

    private final void changeVisible(boolean visible) {
        if (this.realFragmentVisible != visible) {
            this.realFragmentVisible = visible;
            onVisibleChange(visible);
        }
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

    private final int getTabPosition() {
        return ((Number) this.tabPosition.getValue()).intValue();
    }

    private final void initAdapter() {
        HomeFragmentGoodStuffBinding mBinding = getMBinding();
        if (mBinding != null) {
            mBinding.f34247a.setLayoutManager(initLayoutManager());
            final GoodStuffAdapter goodStuffAdapter = new GoodStuffAdapter(new WeakReference(this), 0.0f, 0.0f, 0.0f, 14, null);
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.home_layout_empty_data, (ViewGroup) null);
            View viewFindViewById = viewInflate.findViewById(R.id.bt_empty);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
            }
            Intrinsics.checkNotNullExpressionValue(viewInflate, "view");
            goodStuffAdapter.s(viewInflate);
            goodStuffAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.cv3
                @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
                public final void onLoadMore() {
                    GoodStuffFragment.initAdapter$lambda$3$lambda$1(this.f41045a);
                }
            });
            y57.d(goodStuffAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.dv3
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    GoodStuffFragment.initAdapter$lambda$3$lambda$2(goodStuffAdapter, this, baseQuickAdapter, view, i);
                }
            }, 1, null);
            getMViewModel().j().setValue(goodStuffAdapter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$3$lambda$1(GoodStuffFragment goodStuffFragment) {
        Intrinsics.checkNotNullParameter(goodStuffFragment, "this$0");
        goodStuffFragment.getMViewModel().o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$3$lambda$2(GoodStuffAdapter goodStuffAdapter, GoodStuffFragment goodStuffFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(goodStuffAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(goodStuffFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "view");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        MultiItemEntity multiItemEntity = (MultiItemEntity) goodStuffAdapter.getItem(i);
        if (multiItemEntity instanceof GoodStuffBean) {
            GoodStuffBean goodStuffBean = (GoodStuffBean) multiItemEntity;
            String clickUrl = goodStuffBean.getPublishInfo().getClickUrl();
            Context context = baseQuickAdapter.getContext();
            String tabCode = goodStuffFragment.getTabCode();
            Intrinsics.checkNotNullExpressionValue(tabCode, "tabCode");
            String tabName = goodStuffFragment.getTabName();
            Intrinsics.checkNotNullExpressionValue(tabName, "tabName");
            lq5.c(context, tabCode, tabName, goodStuffBean.findGoodsName(), clickUrl, String.valueOf(i));
            er7 er7Var = er7.f41510a;
            Context contextRequireContext = goodStuffFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            er7Var.a(contextRequireContext, clickUrl);
        }
    }

    private final StaggeredGridLayoutManager initLayoutManager() {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        staggeredGridLayoutManager.setGapStrategy(0);
        return staggeredGridLayoutManager;
    }

    private final void initScroll() {
        this.verticalOffset = 0;
        HomeFragmentGoodStuffBinding mBinding = getMBinding();
        if (mBinding != null) {
            mBinding.f34247a.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.huachenjie.home.page.good_stuff.GoodStuffFragment$initScroll$1$1

                /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
                public int lastState;

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
                    Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                    int i = this.lastState;
                    if (newState == 0) {
                        this.f9611a.hasScroll = true;
                        this.f9611a.changeMaxPosition();
                    }
                    this.lastState = newState;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(@NotNull RecyclerView recyclerView, int dx, int dy) {
                    Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                    this.f9611a.verticalOffset += dy;
                }
            });
            mBinding.f34247a.addOnChildAttachStateChangeListener(new GoodStuffFragment$initScroll$1$2(this, mBinding));
        }
    }

    private final void onFragmentRealVisibleChange() {
        if (this.realFragmentVisible && this.realFirstViewVisible) {
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

    private final void onVisibleChange(boolean visible) {
        onFragmentRealVisibleChange();
    }

    public final void changeMaxPosition() {
        RecyclerView recyclerView;
        RecyclerView.LayoutManager layoutManager;
        HomeFragmentGoodStuffBinding mBinding = getMBinding();
        if (mBinding == null || (recyclerView = mBinding.f34247a) == null || (layoutManager = recyclerView.getLayoutManager()) == null || !(layoutManager instanceof StaggeredGridLayoutManager)) {
            return;
        }
        int[] iArrFindLastCompletelyVisibleItemPositions = ((StaggeredGridLayoutManager) layoutManager).findLastCompletelyVisibleItemPositions(null);
        Intrinsics.checkNotNullExpressionValue(iArrFindLastCompletelyVisibleItemPositions, "manager.findLastComplete…isibleItemPositions(null)");
        this.lastMaxPosition = Math.max(getMaxPosition(iArrFindLastCompletelyVisibleItemPositions), this.lastMaxPosition);
    }

    public final int getFirstItemHeight() {
        return this.firstItemHeight;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.home_fragment_good_stuff;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, GoodStuffVM> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(xk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        GoodStuffVM mViewModel = getMViewModel();
        String tabCode = getTabCode();
        Intrinsics.checkNotNullExpressionValue(tabCode, "tabCode");
        mViewModel.u(tabCode);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        initScroll();
        initAdapter();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        changeVisible(false);
        super.onPause();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hasLoadData.get()) {
            return;
        }
        this.hasLoadData.set(true);
        getMViewModel().r(getTabPosition() == 0, new Function0<Unit>() { // from class: com.huachenjie.home.page.good_stuff.GoodStuffFragment.onResume.1
            public /* bridge */ /* synthetic */ Object invoke() {
                m419invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m419invoke() {
            }
        });
    }

    public final void setFirstItemHeight(int i) {
        this.firstItemHeight = i;
    }
}
