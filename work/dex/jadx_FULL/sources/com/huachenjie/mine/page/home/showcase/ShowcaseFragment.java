package com.huachenjie.mine.page.home.showcase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.p002lifecycle.Observer;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.base.works.BaseSearchResultFragment;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.mall.external.adapter.CommodityAdapter;
import com.huachenjie.mall.external.bean.CommodityBean;
import com.huachenjie.mine.R;
import com.huachenjie.mine.databinding.MineFragmentShowcaseBinding;
import com.huachenjie.mine.page.home.showcase.ShowcaseFragment;
import com.zj.adlib.i4a;
import com.zj.adlib.ik0;
import com.zj.adlib.y57;
import com.zj.adlib.zj7;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001(B\u0007¢\u0006\u0004\b%\u0010&J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010!R\u0016\u0010#\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001eR\u0016\u0010$\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\u001e¨\u0006)"}, d2 = {"Lcom/huachenjie/mine/page/home/showcase/ShowcaseFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/mine/databinding/MineFragmentShowcaseBinding;", "Lcom/huachenjie/mine/page/home/showcase/ShowcaseVM;", "", "checkVisible", "onVisibleToUser", "", "", "", "getVariables", "getLayoutResID", "initView", "initData", "", "hidden", "onHiddenChanged", "isVisibleToUser", "setUserVisibleHint", "onResume", "", "userNo$delegate", "Lkotlin/Lazy;", "getUserNo", "()Ljava/lang/String;", ShowcaseFragment.USER_NO, "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "hasInitModel", "Z", "hasInitData", "hiddenChanged", "Ljava/lang/Boolean;", "visibleToUser", "realVisible", BaseSearchResultFragment.NEED_REFRESH_KEY, "<init>", "()V", "Companion", "a", "mine_release"}, k = 1, mv = {1, 8, 0})
public final class ShowcaseFragment extends BaseMVVMFragment<MineFragmentShowcaseBinding, ShowcaseVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String USER_NO = "userNo";
    private boolean hasInitData;
    private boolean hasInitModel;

    @Nullable
    private Boolean hiddenChanged;
    private boolean needRefresh;
    private boolean realVisible;

    @Nullable
    private Boolean visibleToUser;

    /* JADX INFO: renamed from: userNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy userNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mine.page.home.showcase.ShowcaseFragment$userNo$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            Bundle arguments = this.this$0.getArguments();
            if (arguments != null) {
                return arguments.getString(ShowcaseFragment.USER_NO);
            }
            return null;
        }
    });

    @NotNull
    private final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.gb8
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            ShowcaseFragment.onRefreshListener$lambda$0(this.f41866a);
        }
    };

    /* JADX INFO: renamed from: com.huachenjie.mine.page.home.showcase.ShowcaseFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/huachenjie/mine/page/home/showcase/ShowcaseFragment$a;", "", "", ShowcaseFragment.USER_NO, "Lcom/huachenjie/mine/page/home/showcase/ShowcaseFragment;", "a", "USER_NO", "Ljava/lang/String;", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ShowcaseFragment b(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.a(str);
        }

        @NotNull
        public final ShowcaseFragment a(@Nullable String userNo) {
            ShowcaseFragment showcaseFragment = new ShowcaseFragment();
            Bundle bundle = new Bundle();
            bundle.putString(ShowcaseFragment.USER_NO, userNo);
            showcaseFragment.setArguments(bundle);
            return showcaseFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35399a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35399a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35399a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35399a.invoke(obj);
        }
    }

    public static final /* synthetic */ MineFragmentShowcaseBinding access$getMBinding(ShowcaseFragment showcaseFragment) {
        return showcaseFragment.getMBinding();
    }

    private final void checkVisible() {
        i4a.c("checkVisible:" + this.hasInitModel + ',' + this.hasInitData + ',' + this.hiddenChanged + ',' + this.visibleToUser + ',' + this.realVisible + ',' + this.needRefresh);
        Boolean bool = this.hiddenChanged;
        Boolean bool2 = Boolean.TRUE;
        if (Intrinsics.areEqual(bool, bool2) || !Intrinsics.areEqual(this.visibleToUser, bool2)) {
            this.realVisible = false;
        } else {
            onVisibleToUser();
            this.realVisible = true;
        }
    }

    private final String getUserNo() {
        return (String) this.userNo.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$4$lambda$2$lambda$1(CommodityAdapter commodityAdapter, ShowcaseFragment showcaseFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(commodityAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(showcaseFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        ARouter.getInstance().build(zj7.g.GOOD_DETAIL).withString("goodsNo", ((CommodityBean) commodityAdapter.getItem(i)).getGoodsNo()).withString("source", "20").withString("traceNo", showcaseFragment.getUserNo()).navigation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4$lambda$3(ShowcaseFragment showcaseFragment) {
        Intrinsics.checkNotNullParameter(showcaseFragment, "this$0");
        showcaseFragment.getMViewModel().n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRefreshListener$lambda$0(ShowcaseFragment showcaseFragment) {
        Intrinsics.checkNotNullParameter(showcaseFragment, "this$0");
        showcaseFragment.getMViewModel().p();
    }

    private final void onVisibleToUser() {
        i4a.c("onVisibleToUser:" + this.hasInitModel + ',' + this.hasInitData + ',' + this.hiddenChanged + ',' + this.visibleToUser + ',' + this.realVisible + ',' + this.needRefresh);
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
        return R.layout.mine_fragment_showcase;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(ik0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(ik0.R), this.onRefreshListener)});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().s(getUserNo());
        this.hasInitModel = true;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        MineFragmentShowcaseBinding mBinding = getMBinding();
        if (mBinding != null) {
            final CommodityAdapter commodityAdapter = new CommodityAdapter(3.5f, 6.0f, 7.0f);
            y57.d(commodityAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.hb8
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    ShowcaseFragment.initView$lambda$4$lambda$2$lambda$1(commodityAdapter, this, baseQuickAdapter, view, i);
                }
            }, 1, null);
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_empty_work, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "view");
            commodityAdapter.o(viewInflate);
            commodityAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.ib8
                @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
                public final void onLoadMore() {
                    ShowcaseFragment.initView$lambda$4$lambda$3(this.f42321a);
                }
            });
            getMViewModel().i().setValue(commodityAdapter);
            StateLayout stateLayout = mBinding.f11306a;
            Intrinsics.checkNotNullExpressionValue(stateLayout, "stateLayout");
            StateLayout.showLoading$default(stateLayout, null, false, false, 7, null);
        }
        getMViewModel().m().observe(this, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.mine.page.home.showcase.ShowcaseFragment.initView.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                MineFragmentShowcaseBinding mineFragmentShowcaseBindingAccess$getMBinding;
                StateLayout stateLayout2;
                if (bool.booleanValue() || (mineFragmentShowcaseBindingAccess$getMBinding = ShowcaseFragment.access$getMBinding(ShowcaseFragment.this)) == null || (stateLayout2 = mineFragmentShowcaseBindingAccess$getMBinding.f11306a) == null) {
                    return;
                }
                StateLayout.showContent$default(stateLayout2, null, 1, null);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        this.hiddenChanged = Boolean.valueOf(hidden);
        checkVisible();
        super.onHiddenChanged(hidden);
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
