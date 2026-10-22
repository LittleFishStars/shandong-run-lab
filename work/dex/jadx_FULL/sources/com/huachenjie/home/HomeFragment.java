package com.huachenjie.home;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.coroutines.ViewStubProxy;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.Lifecycle;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import cn.hzjizhun.admin.ad.bean.JZUnifiedAdInfo;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.google.android.material.appbar.AppBarLayout;
import com.huachenjie.ad.interfaces.InterstitialAdListener;
import com.huachenjie.base.adapter.ViewPagerAdapter;
import com.huachenjie.base.bean.CommonSwitchConfig;
import com.huachenjie.base.broadcast.config.ConfigOperateReceiver;
import com.huachenjie.base.broadcast.inspiration.InspirationReceiver;
import com.huachenjie.base.util.CustomTabStyle;
import com.huachenjie.common.bean.AdPlatformSwitch;
import com.huachenjie.common.constants.Environment;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.home.HomeFragment;
import com.huachenjie.home.bean.AdPopupBean;
import com.huachenjie.home.bean.DailyTasksBean;
import com.huachenjie.home.bean.GoodStuffPickData;
import com.huachenjie.home.bean.HomeData;
import com.huachenjie.home.bean.HomeHeaderBean;
import com.huachenjie.home.bean.JackpotAwardBean;
import com.huachenjie.home.bean.PromoSlotBean;
import com.huachenjie.home.bean.SeaViewBean;
import com.huachenjie.home.bean.reward.HomeRewardBean;
import com.huachenjie.home.databinding.HomeFragmentMainBinding;
import com.huachenjie.home.dialog.HomeAdPopupDialog;
import com.huachenjie.home.dialog.HomeRewardDialog;
import com.huachenjie.home.page.draw.LotteryThemeConfigManager;
import com.huachenjie.home.page.home.HomeBuddyCardPageFragment;
import com.huachenjie.home.page.scan_code.ScanMallQRCodeActivity;
import com.huachenjie.home.util.TasksUtil;
import com.huachenjie.home.widget.BuddyScopeTabWidget;
import com.huachenjie.home.widget.WrapContentHeightViewPager;
import com.huachenjie.works.bean.BuddyTypeScopeTypeBean;
import com.huachenjie.works.external.adapter.WorksAdapter;
import com.huachenjie.works.external.bean.WorkItemBean;
import com.huachenjie.works.external.bean.WorkNativeAdBean;
import com.huachenjie.works.page.dormitory.DormitoryActivity;
import com.huachenjie.works.page.search.SearchActivity;
import com.igexin.push.g.o;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;
import com.zj.adlib.cr8;
import com.zj.adlib.dq1;
import com.zj.adlib.er7;
import com.zj.adlib.ew;
import com.zj.adlib.fb4;
import com.zj.adlib.fe9;
import com.zj.adlib.fx7;
import com.zj.adlib.i90;
import com.zj.adlib.ip4;
import com.zj.adlib.j14;
import com.zj.adlib.jj8;
import com.zj.adlib.mq5;
import com.zj.adlib.pi4;
import com.zj.adlib.r90;
import com.zj.adlib.su9;
import com.zj.adlib.vs1;
import com.zj.adlib.xk0;
import com.zj.adlib.y57;
import com.zj.adlib.y6b;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001SB\u0005¢\u0006\u0002\u0010\u0004J\u001e\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010-\u001a\u00020.H\u0002J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u0006H\u0002J\u0018\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002J\u0012\u00106\u001a\u00020+2\b\u00107\u001a\u0004\u0018\u000108H\u0002J\b\u00109\u001a\u00020.H\u0002J\b\u0010:\u001a\u00020.H\u0016J\u0014\u0010;\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020=0<H\u0016J\b\u0010>\u001a\u00020+H\u0002J\b\u0010?\u001a\u00020+H\u0002J\b\u0010@\u001a\u00020+H\u0016J\b\u0010A\u001a\u00020+H\u0016J\b\u0010B\u001a\u00020+H\u0002J\b\u0010C\u001a\u00020+H\u0002J\b\u0010D\u001a\u00020+H\u0002J\b\u0010E\u001a\u00020+H\u0002J\b\u0010F\u001a\u00020+H\u0002J\b\u0010G\u001a\u00020+H\u0016J\b\u0010H\u001a\u00020+H\u0002J\b\u0010I\u001a\u00020+H\u0002J\u0018\u0010J\u001a\u00020+2\u0006\u0010K\u001a\u0002032\u0006\u0010L\u001a\u00020.H\u0002J\b\u0010M\u001a\u00020+H\u0016J\b\u0010N\u001a\u00020+H\u0016J\b\u0010O\u001a\u00020+H\u0016J\u0010\u0010P\u001a\u00020+2\u0006\u0010Q\u001a\u00020.H\u0002J\b\u0010R\u001a\u00020+H\u0002R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00060\u0017R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\r\u001a\u0004\b$\u0010%R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/huachenjie/home/HomeFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/home/databinding/HomeFragmentMainBinding;", "Lcom/huachenjie/home/HomeVM;", "()V", "boundBuddyTypeCodes", "", "", "buddyCardPagerAdapter", "Lcom/huachenjie/base/adapter/ViewPagerAdapter;", "getBuddyCardPagerAdapter", "()Lcom/huachenjie/base/adapter/ViewPagerAdapter;", "buddyCardPagerAdapter$delegate", "Lkotlin/Lazy;", "buddyCardViewPager", "Lcom/huachenjie/home/widget/WrapContentHeightViewPager;", "buddyPlazaInitialized", "", "buddyScopeTabWidget", "Lcom/huachenjie/home/widget/BuddyScopeTabWidget;", "buddyTypeTabLayout", "Lcom/flyco/tablayout/SlidingTabLayout;", "clickProxy", "Lcom/huachenjie/home/HomeFragment$ClickProxy;", "configOperateReceiver", "Lcom/huachenjie/base/broadcast/config/ConfigOperateReceiver;", "getConfigOperateReceiver", "()Lcom/huachenjie/base/broadcast/config/ConfigOperateReceiver;", "configOperateReceiver$delegate", "customTabStyle", "Lcom/huachenjie/base/util/CustomTabStyle;", "getCustomTabStyle", "()Lcom/huachenjie/base/util/CustomTabStyle;", "customTabStyle$delegate", "inspirationOperateReceiver", "Lcom/huachenjie/base/broadcast/inspiration/InspirationReceiver;", "getInspirationOperateReceiver", "()Lcom/huachenjie/base/broadcast/inspiration/InspirationReceiver;", "inspirationOperateReceiver$delegate", "onRefreshListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "swipeRefreshEnabled", "bindBuddyTypeTab", "", "titles", "currentPosition", "", "createBuddyTypeFragments", "Landroidx/fragment/app/Fragment;", "dealRecyclerViewTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "fillNativeAd", "unifiedAdInfo", "Lcn/hzjizhun/admin/ad/bean/JZUnifiedAdInfo;", "findShandongHeader", "getLayoutResID", "getVariables", "", "", "handleBuddyConfig", "initBuddyPlaza", "initData", "initDataObservable", "initHeaderAdapter", "initHeaderGoodsAdapter", "initRecyclerView", "initScroll", "initSearchTextSwitch", "initView", "loadNativeAd", "observeAdPopup", "onClickGoodsPick", "view", "position", "onDestroyView", "onFragmentResume", "onViewCreated", "selectBuddyTypeTab", "index", "updateBuddyScopeForPages", "ClickProxy", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHomeFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HomeFragment.kt\ncom/huachenjie/home/HomeFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,602:1\n800#2,11:603\n1855#2,2:614\n1549#2:616\n1620#2,3:617\n*S KotlinDebug\n*F\n+ 1 HomeFragment.kt\ncom/huachenjie/home/HomeFragment\n*L\n427#1:603,11\n428#1:614,2\n433#1:616\n433#1:617,3\n*E\n"})
public final class HomeFragment extends BaseMVVMFragment<HomeFragmentMainBinding, HomeVM> {

    @Nullable
    private List<String> boundBuddyTypeCodes;

    @Nullable
    private WrapContentHeightViewPager buddyCardViewPager;
    private boolean buddyPlazaInitialized;

    @Nullable
    private BuddyScopeTabWidget buddyScopeTabWidget;

    @Nullable
    private SlidingTabLayout buddyTypeTabLayout;
    private boolean swipeRefreshEnabled;

    @NotNull
    private final ClickProxy clickProxy = new ClickProxy();

    /* JADX INFO: renamed from: customTabStyle$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy customTabStyle = LazyKt.lazy(new Function0<CustomTabStyle>() { // from class: com.huachenjie.home.HomeFragment$customTabStyle$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final CustomTabStyle m397invoke() {
            return new CustomTabStyle();
        }
    });

    /* JADX INFO: renamed from: buddyCardPagerAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy buddyCardPagerAdapter = LazyKt.lazy(new Function0<ViewPagerAdapter>() { // from class: com.huachenjie.home.HomeFragment$buddyCardPagerAdapter$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ViewPagerAdapter m395invoke() {
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            return new ViewPagerAdapter(childFragmentManager);
        }
    });

    /* JADX INFO: renamed from: configOperateReceiver$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy configOperateReceiver = LazyKt.lazy(new HomeFragment$configOperateReceiver$2(this));

    @NotNull
    private final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.k14
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            HomeFragment.onRefreshListener$lambda$0(this.f42719a);
        }
    };

    /* JADX INFO: renamed from: inspirationOperateReceiver$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy inspirationOperateReceiver = LazyKt.lazy(new HomeFragment$inspirationOperateReceiver$2(this));

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/home/HomeFragment$ClickProxy;", "", "Landroid/view/View;", "view", "", "j", y6b.f, y6b.g, "i", "f", "e", "b", "d", "<init>", "(Lcom/huachenjie/home/HomeFragment;)V", "home_release"}, k = 1, mv = {1, 8, 0})
    public final class ClickProxy {
        public ClickProxy() {
        }

        public static final void c(RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(recyclerView, "$this_apply");
            recyclerView.scrollToPosition(0);
        }

        public final void b(@NotNull View view) {
            final RecyclerView recyclerView;
            AppBarLayout appBarLayout;
            Intrinsics.checkNotNullParameter(view, "view");
            HomeFragmentMainBinding homeFragmentMainBindingAccess$getMBinding = HomeFragment.access$getMBinding(HomeFragment.this);
            if (homeFragmentMainBindingAccess$getMBinding != null && (appBarLayout = homeFragmentMainBindingAccess$getMBinding.f9419a) != null) {
                appBarLayout.setExpanded(true);
            }
            HomeFragmentMainBinding homeFragmentMainBindingAccess$getMBinding2 = HomeFragment.access$getMBinding(HomeFragment.this);
            if (homeFragmentMainBindingAccess$getMBinding2 == null || (recyclerView = homeFragmentMainBindingAccess$getMBinding2.f9416a) == null) {
                return;
            }
            recyclerView.post(new Runnable() { // from class: com.zj.adlib.s14
                @Override // java.lang.Runnable
                public final void run() {
                    HomeFragment.ClickProxy.c(recyclerView);
                }
            });
        }

        public final void d(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            su9.l(view.getContext(), Environment.c + "/#/buddy");
        }

        public final void e(@NotNull View view) {
            JackpotAwardBean value;
            DailyTasksBean taskInfo;
            DailyTasksBean taskInfo2;
            DailyTasksBean taskInfo3;
            Intrinsics.checkNotNullParameter(view, "view");
            JackpotAwardBean value2 = HomeFragment.access$getMViewModel(HomeFragment.this).E().getValue();
            Integer numValueOf = (value2 == null || (taskInfo3 = value2.getTaskInfo()) == null) ? null : Integer.valueOf(taskInfo3.getStatus());
            if (numValueOf != null && numValueOf.intValue() == 2) {
                ARouter.getInstance().build(zj7.e.CHANGE_REWARD).withBoolean(yj7.c.KEY_CHANGE_IMPORTANT_REWARD, true).navigation();
                return;
            }
            if (numValueOf != null && numValueOf.intValue() == 1) {
                JackpotAwardBean value3 = HomeFragment.access$getMViewModel(HomeFragment.this).E().getValue();
                if (value3 == null || (taskInfo2 = value3.getTaskInfo()) == null) {
                    return;
                }
                taskInfo2.setTaskType(9);
                TasksUtil tasksUtil = TasksUtil.f34372a;
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "view.context");
                HomeVM homeVMAccess$getMViewModel = HomeFragment.access$getMViewModel(HomeFragment.this);
                FragmentManager childFragmentManager = HomeFragment.this.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                tasksUtil.h(context, homeVMAccess$getMViewModel, childFragmentManager, taskInfo2, (48 & 16) != 0 ? null : null, (48 & 32) != 0 ? null : null);
                return;
            }
            if (numValueOf == null || numValueOf.intValue() != 0 || (value = HomeFragment.access$getMViewModel(HomeFragment.this).E().getValue()) == null || (taskInfo = value.getTaskInfo()) == null) {
                return;
            }
            taskInfo.setTaskType(9);
            TasksUtil tasksUtil2 = TasksUtil.f34372a;
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "view.context");
            Lifecycle lifecycle = HomeFragment.this.getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, RequestParameters.SUBRESOURCE_LIFECYCLE);
            FragmentManager childFragmentManager2 = HomeFragment.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "childFragmentManager");
            FragmentManager parentFragmentManager = HomeFragment.this.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            HomeVM homeVMAccess$getMViewModel2 = HomeFragment.access$getMViewModel(HomeFragment.this);
            final HomeFragment homeFragment = HomeFragment.this;
            tasksUtil2.e(context2, lifecycle, childFragmentManager2, parentFragmentManager, homeVMAccess$getMViewModel2, taskInfo, new Function2<Boolean, String, Unit>() { // from class: com.huachenjie.home.HomeFragment$ClickProxy$clickFlashSale$1
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke(((Boolean) obj).booleanValue(), (String) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z, @Nullable String str) {
                    if (z) {
                        HomeFragment.access$getMViewModel(homeFragment).W();
                    }
                }
            });
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final void f(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            try {
                String string = view.getTag().toString();
                switch (string.hashCode()) {
                    case 48:
                        if (string.equals("0")) {
                            HomeFragment.this.onClickGoodsPick(view, 0);
                        }
                        break;
                    case 49:
                        if (string.equals("1")) {
                            HomeFragment.this.onClickGoodsPick(view, 1);
                        }
                        break;
                    case 50:
                        if (string.equals("2")) {
                            HomeFragment.this.onClickGoodsPick(view, 2);
                        }
                        break;
                }
            } catch (Exception unused) {
            }
        }

        public final void g(@NotNull View view) {
            Banner banner;
            Intrinsics.checkNotNullParameter(view, "view");
            HomeFragmentMainBinding homeFragmentMainBindingAccess$getMBinding = HomeFragment.access$getMBinding(HomeFragment.this);
            if (homeFragmentMainBindingAccess$getMBinding == null || (banner = homeFragmentMainBindingAccess$getMBinding.f9424a) == null) {
                return;
            }
            if (banner.getAdapter().getRealCount() <= 0) {
                SearchActivity.Companion companion = SearchActivity.INSTANCE;
                Context contextRequireContext = HomeFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                companion.a(contextRequireContext, "输入内容搜索");
                return;
            }
            try {
                String string = banner.getAdapter().getData(banner.getAdapter().getRealPosition(banner.getCurrentItem())).toString();
                SearchActivity.Companion companion2 = SearchActivity.INSTANCE;
                Context contextRequireContext2 = HomeFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                companion2.a(contextRequireContext2, string);
            } catch (Exception unused) {
                SearchActivity.Companion companion3 = SearchActivity.INSTANCE;
                Context contextRequireContext3 = HomeFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
                companion3.a(contextRequireContext3, "输入内容搜索");
            }
        }

        public final void h(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            HomeFragment.this.startActivity(new Intent(view.getContext(), (Class<?>) ScanMallQRCodeActivity.class));
        }

        public final void i(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ARouter.getInstance().build(zj7.a.HOME).withString(yj7.a.HOME_TAB_NAME, fe9.b.FLASH_COINS).navigation();
        }

        public final void j(@NotNull View view) {
            SeaViewBean seaview;
            Intrinsics.checkNotNullParameter(view, "view");
            HomeData value = HomeFragment.access$getMViewModel(HomeFragment.this).C().getValue();
            if (value == null || (seaview = value.getSeaview()) == null) {
                return;
            }
            j14.g(HomeFragment.this.getContext(), seaview.getClickTarget());
            er7 er7Var = er7.f41510a;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            er7Var.b(context, seaview.getClickType(), seaview.getClickTarget());
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/huachenjie/home/HomeFragment$a", "Lcom/flyco/tablayout/listener/OnTabSelectListener;", "", "position", "", "b", "a", "home_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements OnTabSelectListener {
        public a() {
        }

        @Override // com.flyco.tablayout.listener.OnTabSelectListener
        public void a(int position) {
        }

        @Override // com.flyco.tablayout.listener.OnTabSelectListener
        public void b(int position) {
            BuddyTypeScopeTypeBean buddyTypeScopeTypeBean;
            List<BuddyTypeScopeTypeBean> value = HomeFragment.access$getMViewModel(HomeFragment.this).x().getValue();
            if (value == null || (buddyTypeScopeTypeBean = (BuddyTypeScopeTypeBean) CollectionsKt.getOrNull(value, position)) == null) {
                return;
            }
            HomeFragment.access$getMViewModel(HomeFragment.this).Z(buddyTypeScopeTypeBean.getBuddyTypeCode());
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"com/huachenjie/home/HomeFragment$b", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout", "", "verticalOffset", "", "onOffsetChanged", "", "a", "Z", "onTop", "home_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements AppBarLayout.OnOffsetChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
        public boolean onTop;

        public b() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(@NotNull AppBarLayout appBarLayout, int verticalOffset) {
            ImageView imageView;
            LinearLayout linearLayout;
            ImageView imageView2;
            LinearLayout linearLayout2;
            ImageView imageView3;
            FrameLayout frameLayout;
            FrameLayout frameLayout2;
            SwipeRefreshLayout swipeRefreshLayout;
            Intrinsics.checkNotNullParameter(appBarLayout, "appBarLayout");
            HomeFragment.this.swipeRefreshEnabled = Math.abs(verticalOffset) == 0;
            HomeFragmentMainBinding homeFragmentMainBindingAccess$getMBinding = HomeFragment.access$getMBinding(HomeFragment.this);
            if (homeFragmentMainBindingAccess$getMBinding != null && (swipeRefreshLayout = homeFragmentMainBindingAccess$getMBinding.f9418a) != null) {
                swipeRefreshLayout.setEnabled(HomeFragment.this.swipeRefreshEnabled);
            }
            HomeFragment.access$getMViewModel(HomeFragment.this).s().setValue(Integer.valueOf(verticalOffset));
            HomeFragmentMainBinding homeFragmentMainBindingAccess$getMBinding2 = HomeFragment.access$getMBinding(HomeFragment.this);
            if (((homeFragmentMainBindingAccess$getMBinding2 == null || (frameLayout2 = homeFragmentMainBindingAccess$getMBinding2.f9410a) == null) ? 0 : frameLayout2.getHeight()) > 0) {
                HomeFragmentMainBinding homeFragmentMainBindingAccess$getMBinding3 = HomeFragment.access$getMBinding(HomeFragment.this);
                int height = (homeFragmentMainBindingAccess$getMBinding3 == null || (frameLayout = homeFragmentMainBindingAccess$getMBinding3.f9410a) == null) ? 50 : frameLayout.getHeight();
                float fAbs = Math.abs(RangesKt.coerceAtMost(height, Math.abs(verticalOffset)) / height);
                HomeFragmentMainBinding homeFragmentMainBindingAccess$getMBinding4 = HomeFragment.access$getMBinding(HomeFragment.this);
                View view = homeFragmentMainBindingAccess$getMBinding4 != null ? homeFragmentMainBindingAccess$getMBinding4.f34251a : null;
                if (view != null) {
                    view.setAlpha(fAbs);
                }
                boolean z = this.onTop;
                if (!z && fAbs >= 1.0f) {
                    this.onTop = true;
                    HomeFragmentMainBinding homeFragmentMainBindingAccess$getMBinding5 = HomeFragment.access$getMBinding(HomeFragment.this);
                    if (homeFragmentMainBindingAccess$getMBinding5 != null && (imageView3 = homeFragmentMainBindingAccess$getMBinding5.e) != null) {
                        imageView3.setImageResource(R.drawable.home_ic_shandong_top);
                    }
                    HomeFragmentMainBinding homeFragmentMainBindingAccess$getMBinding6 = HomeFragment.access$getMBinding(HomeFragment.this);
                    if (homeFragmentMainBindingAccess$getMBinding6 != null && (linearLayout2 = homeFragmentMainBindingAccess$getMBinding6.f9412a) != null) {
                        linearLayout2.setBackgroundResource(R.drawable.home_bg_home_search_top);
                    }
                } else if (z && fAbs < 1.0f) {
                    this.onTop = false;
                    HomeFragmentMainBinding homeFragmentMainBindingAccess$getMBinding7 = HomeFragment.access$getMBinding(HomeFragment.this);
                    if (homeFragmentMainBindingAccess$getMBinding7 != null && (imageView2 = homeFragmentMainBindingAccess$getMBinding7.e) != null) {
                        imageView2.setImageResource(HomeFragment.this.findShandongHeader());
                    }
                    HomeFragmentMainBinding homeFragmentMainBindingAccess$getMBinding8 = HomeFragment.access$getMBinding(HomeFragment.this);
                    if (homeFragmentMainBindingAccess$getMBinding8 != null && (linearLayout = homeFragmentMainBindingAccess$getMBinding8.f9412a) != null) {
                        linearLayout.setBackgroundResource(R.drawable.home_bg_home_search);
                    }
                }
            }
            if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                HomeFragmentMainBinding homeFragmentMainBindingAccess$getMBinding9 = HomeFragment.access$getMBinding(HomeFragment.this);
                imageView = homeFragmentMainBindingAccess$getMBinding9 != null ? homeFragmentMainBindingAccess$getMBinding9.f9411a : null;
                if (imageView == null) {
                    return;
                }
                imageView.setVisibility(0);
                return;
            }
            HomeFragmentMainBinding homeFragmentMainBindingAccess$getMBinding10 = HomeFragment.access$getMBinding(HomeFragment.this);
            imageView = homeFragmentMainBindingAccess$getMBinding10 != null ? homeFragmentMainBindingAccess$getMBinding10.f9411a : null;
            if (imageView == null) {
                return;
            }
            imageView.setVisibility(8);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/huachenjie/home/HomeFragment$c", "Lcom/huachenjie/ad/interfaces/InterstitialAdListener;", "", "loadSupplier", "", "platform", "", "e", "home_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends InterstitialAdListener {
        @Override // com.huachenjie.ad.interfaces.InterstitialAdListener
        public void e(int loadSupplier, @NotNull String platform) {
            Intrinsics.checkNotNullParameter(platform, "platform");
            ew.a(loadSupplier);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/home/HomeFragment$d", "Lcom/zj/adlib/pi4;", "Lcn/hzjizhun/admin/ad/bean/JZUnifiedAdInfo;", "adInfo", "", "c", "home_release"}, k = 1, mv = {1, 8, 0})
    public static final class d extends pi4 {
        public d() {
        }

        @Override // com.zj.adlib.pi4
        public void c(@Nullable JZUnifiedAdInfo adInfo) {
            HomeFragment.this.fillNativeAd(adInfo);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class e implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f34190a;

        public e(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f34190a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f34190a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f34190a.invoke(obj);
        }
    }

    public static final /* synthetic */ HomeFragmentMainBinding access$getMBinding(HomeFragment homeFragment) {
        return homeFragment.getMBinding();
    }

    public static final /* synthetic */ HomeVM access$getMViewModel(HomeFragment homeFragment) {
        return homeFragment.getMViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bindBuddyTypeTab(List<String> titles, int currentPosition) {
        SlidingTabLayout slidingTabLayout;
        WrapContentHeightViewPager wrapContentHeightViewPager = this.buddyCardViewPager;
        if (wrapContentHeightViewPager == null || (slidingTabLayout = this.buddyTypeTabLayout) == null) {
            return;
        }
        List<Fragment> listCreateBuddyTypeFragments = createBuddyTypeFragments();
        if (listCreateBuddyTypeFragments.isEmpty()) {
            return;
        }
        wrapContentHeightViewPager.clearHeightCache();
        wrapContentHeightViewPager.setOffscreenPageLimit(titles.size());
        getBuddyCardPagerAdapter().a(titles, listCreateBuddyTypeFragments);
        slidingTabLayout.setViewPager(wrapContentHeightViewPager, titles);
        getCustomTabStyle().e(slidingTabLayout, wrapContentHeightViewPager, new a(), currentPosition);
    }

    private final List<Fragment> createBuddyTypeFragments() {
        Integer value = getMViewModel().t().getValue();
        if (value == null) {
            value = 1;
        }
        int iIntValue = value.intValue();
        List<BuddyTypeScopeTypeBean> value2 = getMViewModel().x().getValue();
        if (value2 == null) {
            value2 = CollectionsKt.emptyList();
        }
        List<BuddyTypeScopeTypeBean> list = value2;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(HomeBuddyCardPageFragment.INSTANCE.a(iIntValue, ((BuddyTypeScopeTypeBean) it.next()).getBuddyTypeCode()));
        }
        return arrayList;
    }

    private final boolean dealRecyclerViewTouch(View v, MotionEvent event) {
        SwipeRefreshLayout swipeRefreshLayout;
        SwipeRefreshLayout swipeRefreshLayout2;
        HomeFragmentMainBinding mBinding;
        SwipeRefreshLayout swipeRefreshLayout3;
        int action = event.getAction();
        if (action == 0) {
            HomeFragmentMainBinding mBinding2 = getMBinding();
            if (mBinding2 == null || (swipeRefreshLayout = mBinding2.f9418a) == null) {
                return true;
            }
            swipeRefreshLayout.setEnabled(false);
            return true;
        }
        if (action == 1) {
            HomeFragmentMainBinding mBinding3 = getMBinding();
            if (mBinding3 != null && (swipeRefreshLayout2 = mBinding3.f9418a) != null) {
                swipeRefreshLayout2.setEnabled(this.swipeRefreshEnabled);
            }
        } else if (action == 2 && (mBinding = getMBinding()) != null && (swipeRefreshLayout3 = mBinding.f9418a) != null) {
            swipeRefreshLayout3.setEnabled(false);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fillNativeAd(JZUnifiedAdInfo unifiedAdInfo) {
        WorksAdapter value;
        if (unifiedAdInfo == null) {
            return;
        }
        try {
            if (Intrinsics.areEqual(getMViewModel().J().getValue(), Boolean.TRUE) || (value = getMViewModel().r().getValue()) == null || value.getData().isEmpty()) {
                return;
            }
            int iCoerceAtMost = RangesKt.coerceAtMost(4, value.getData().size());
            int i = -1;
            int i2 = -1;
            for (int i3 = 0; i3 < iCoerceAtMost; i3++) {
                WorkItemBean workItemBean = (WorkItemBean) value.getData().get(i3);
                if (workItemBean.getPostType() == 4) {
                    i = i3;
                } else if (workItemBean.getPostType() == 3) {
                    i2 = i3;
                }
            }
            if (i != -1) {
                WorkItemBean workItemBean2 = (WorkItemBean) value.getData().get(i);
                Intrinsics.checkNotNull(workItemBean2, "null cannot be cast to non-null type com.huachenjie.works.external.bean.WorkNativeAdBean");
                ((WorkNativeAdBean) workItemBean2).setAdInfo(unifiedAdInfo);
                value.notifyItemChanged(i);
            } else {
                int iCoerceAtMost2 = RangesKt.coerceAtMost(i2 == -1 ? 1 : 2, value.getData().size());
                WorkNativeAdBean workNativeAdBean = new WorkNativeAdBean();
                workNativeAdBean.setAdInfo(unifiedAdInfo);
                value.addData(iCoerceAtMost2, workNativeAdBean);
            }
            ip4.b().e(null);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int findShandongHeader() {
        HomeData value = getMViewModel().C().getValue();
        boolean z = false;
        if (value != null && value.getHasSeaview()) {
            z = true;
        }
        return z ? R.drawable.home_ic_shandong_sea_view : R.drawable.home_ic_shandong;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewPagerAdapter getBuddyCardPagerAdapter() {
        return (ViewPagerAdapter) this.buddyCardPagerAdapter.getValue();
    }

    private final ConfigOperateReceiver getConfigOperateReceiver() {
        return (ConfigOperateReceiver) this.configOperateReceiver.getValue();
    }

    private final CustomTabStyle getCustomTabStyle() {
        return (CustomTabStyle) this.customTabStyle.getValue();
    }

    private final InspirationReceiver getInspirationOperateReceiver() {
        return (InspirationReceiver) this.inspirationOperateReceiver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleBuddyConfig() {
        CommonSwitchConfig commonSwitchConfigD = dq1.d();
        if (commonSwitchConfigD != null && commonSwitchConfigD.getBuddyEnable()) {
            initBuddyPlaza();
            getMViewModel().L();
        }
    }

    private final void initBuddyPlaza() {
        View viewInflate;
        ViewStubProxy viewStubProxy;
        ViewStub viewStub;
        ViewStubProxy viewStubProxy2;
        if (this.buddyPlazaInitialized) {
            return;
        }
        HomeFragmentMainBinding mBinding = getMBinding();
        if (mBinding == null || (viewStubProxy2 = mBinding.f9415a) == null || (viewInflate = viewStubProxy2.getRoot()) == null) {
            HomeFragmentMainBinding mBinding2 = getMBinding();
            viewInflate = (mBinding2 == null || (viewStubProxy = mBinding2.f9415a) == null || (viewStub = viewStubProxy.getViewStub()) == null) ? null : viewStub.inflate();
            if (viewInflate == null) {
                return;
            }
        }
        this.buddyScopeTabWidget = (BuddyScopeTabWidget) viewInflate.findViewById(R.id.buddy_scope_tab);
        this.buddyTypeTabLayout = (SlidingTabLayout) viewInflate.findViewById(R.id.rv_buddy_type);
        this.buddyCardViewPager = (WrapContentHeightViewPager) viewInflate.findViewById(R.id.vp_buddy_card);
        View viewFindViewById = viewInflate.findViewById(R.id.tv_buddy_more);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.q14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeFragment.initBuddyPlaza$lambda$12(this.f44102a, view);
                }
            });
        }
        WrapContentHeightViewPager wrapContentHeightViewPager = this.buddyCardViewPager;
        if (wrapContentHeightViewPager != null) {
            wrapContentHeightViewPager.setAdapter(getBuddyCardPagerAdapter());
        }
        BuddyScopeTabWidget buddyScopeTabWidget = this.buddyScopeTabWidget;
        if (buddyScopeTabWidget != null) {
            buddyScopeTabWidget.setOnScopeChangeListener(new Function1<Integer, Unit>() { // from class: com.huachenjie.home.HomeFragment.initBuddyPlaza.2
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i) {
                    HomeFragment.access$getMViewModel(HomeFragment.this).Y(i);
                }
            });
        }
        this.buddyPlazaInitialized = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initBuddyPlaza$lambda$12(HomeFragment homeFragment, View view) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        ClickProxy clickProxy = homeFragment.clickProxy;
        Intrinsics.checkNotNullExpressionValue(view, o.f);
        clickProxy.d(view);
    }

    private final void initHeaderAdapter() {
        RecyclerView recyclerView;
        final HomeFunctionAdapter homeFunctionAdapter = new HomeFunctionAdapter();
        y57.d(homeFunctionAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.n14
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                HomeFragment.initHeaderAdapter$lambda$7$lambda$6(homeFunctionAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        getMViewModel().B().setValue(homeFunctionAdapter);
        HomeFragmentMainBinding mBinding = getMBinding();
        if (mBinding == null || (recyclerView = mBinding.f9428b) == null) {
            return;
        }
        recyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: com.zj.adlib.o14
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return HomeFragment.initHeaderAdapter$lambda$8(this.f43647a, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final void initHeaderAdapter$lambda$7$lambda$6(HomeFunctionAdapter homeFunctionAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(homeFunctionAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        HomeHeaderBean homeHeaderBean = homeFunctionAdapter.getData().get(i);
        j14.b(view.getContext(), fe9.b.HOME + homeHeaderBean.getName());
        if (homeHeaderBean.getJumpType() == 1) {
            su9.l(view.getContext(), homeHeaderBean.getJumpUrl());
        }
        if (homeHeaderBean.getJumpType() == 2) {
            su9.q(view.getContext(), homeHeaderBean.getJumpUrl());
            return;
        }
        if (homeHeaderBean.getJumpType() == 0) {
            String jumpUrl = homeHeaderBean.getJumpUrl();
            switch (jumpUrl.hashCode()) {
                case -1404561961:
                    if (jumpUrl.equals("shandong://local")) {
                        su9.m(view.getContext());
                        break;
                    }
                    break;
                case -1398055456:
                    if (jumpUrl.equals("shandong://sport")) {
                        ARouter.getInstance().build(zj7.c.HOME).navigation();
                        break;
                    }
                    break;
                case -1292217816:
                    if (jumpUrl.equals("shandong://mall")) {
                        ARouter.getInstance().build(zj7.g.MALL_HOME).navigation();
                        break;
                    }
                    break;
                case -662375076:
                    if (jumpUrl.equals("shandong://space/home")) {
                        DormitoryActivity.Companion companion = DormitoryActivity.INSTANCE;
                        Context context = view.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "view.context");
                        companion.a(context);
                        j14.d(view.getContext());
                        break;
                    }
                    break;
                case 2117634548:
                    if (jumpUrl.equals("shandong://entertainment")) {
                        ARouter.getInstance().build(zj7.c.RECREATION).navigation();
                        break;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initHeaderAdapter$lambda$8(HomeFragment homeFragment, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(view, "v");
        Intrinsics.checkNotNullExpressionValue(motionEvent, "event");
        return homeFragment.dealRecyclerViewTouch(view, motionEvent);
    }

    private final void initHeaderGoodsAdapter() {
        RecyclerView recyclerView;
        HomeGoodsAdapter homeGoodsAdapter = new HomeGoodsAdapter();
        y57.d(homeGoodsAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.l14
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                HomeFragment.initHeaderGoodsAdapter$lambda$10$lambda$9(this.f42970a, baseQuickAdapter, view, i);
            }
        }, 1, null);
        getMViewModel().A().setValue(homeGoodsAdapter);
        HomeFragmentMainBinding mBinding = getMBinding();
        if (mBinding == null || (recyclerView = mBinding.f9430c) == null) {
            return;
        }
        recyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: com.zj.adlib.m14
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return HomeFragment.initHeaderGoodsAdapter$lambda$11(this.f43198a, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initHeaderGoodsAdapter$lambda$10$lambda$9(HomeFragment homeFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        homeFragment.onClickGoodsPick(view, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initHeaderGoodsAdapter$lambda$11(HomeFragment homeFragment, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(view, "v");
        Intrinsics.checkNotNullExpressionValue(motionEvent, "event");
        return homeFragment.dealRecyclerViewTouch(view, motionEvent);
    }

    private final void initRecyclerView() {
        HomeFragmentMainBinding mBinding = getMBinding();
        RecyclerView recyclerView = mBinding != null ? mBinding.f9416a : null;
        if (recyclerView != null) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
            staggeredGridLayoutManager.setGapStrategy(0);
            recyclerView.setLayoutManager(staggeredGridLayoutManager);
        }
        MutableLiveData<WorksAdapter> mutableLiveDataR = getMViewModel().r();
        WorksAdapter worksAdapter = new WorksAdapter(true, false, true, 2, null);
        worksAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.r14
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                HomeFragment.initRecyclerView$lambda$5$lambda$4(this.f44342a);
            }
        });
        mutableLiveDataR.setValue(worksAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$5$lambda$4(HomeFragment homeFragment) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        homeFragment.getMViewModel().K();
        j14.h(homeFragment.requireContext(), homeFragment.getMViewModel().getPageNum());
    }

    private final void initScroll() {
        AppBarLayout appBarLayout;
        HomeFragmentMainBinding mBinding = getMBinding();
        if (mBinding == null || (appBarLayout = mBinding.f9419a) == null) {
            return;
        }
        appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new b());
    }

    private final void initSearchTextSwitch() {
        Banner banner;
        HomeFragmentMainBinding mBinding = getMBinding();
        if (mBinding == null || (banner = mBinding.f9424a) == null) {
            return;
        }
        banner.addBannerLifecycleObserver(this).setAdapter(new HomeSearchTextSwitchAdapter()).setUserInputEnabled(false).setLoopTime(2000L).setScrollTime(500).setIndicator(new CircleIndicator(banner.getContext()));
        banner.setOnBannerListener(new OnBannerListener() { // from class: com.zj.adlib.p14
            public final void OnBannerClick(Object obj, int i) {
                HomeFragment.initSearchTextSwitch$lambda$2(this.f43873a, obj, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSearchTextSwitch$lambda$2(HomeFragment homeFragment, Object obj, int i) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        SearchActivity.Companion companion = SearchActivity.INSTANCE;
        Context contextRequireContext = homeFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        companion.a(contextRequireContext, obj.toString());
    }

    private final void loadNativeAd() {
        FragmentActivity activity;
        try {
            AdPlatformSwitch adPlatformSwitchE = r90.e("hprp");
            boolean z = false;
            if (adPlatformSwitchE != null && adPlatformSwitchE.getOpenFlag()) {
                z = true;
            }
            if (z && (activity = getActivity()) != null) {
                ip4.b().d(activity, new d());
            }
        } catch (Exception unused) {
        }
    }

    private final void observeAdPopup() {
        getMViewModel().q().observe(this, new e(new Function1<AdPopupBean, Unit>() { // from class: com.huachenjie.home.HomeFragment.observeAdPopup.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((AdPopupBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(AdPopupBean adPopupBean) {
                boolean z = false;
                if (adPopupBean != null && adPopupBean.getHasPopup()) {
                    z = true;
                }
                if (z) {
                    HomeAdPopupDialog.Companion companion = HomeAdPopupDialog.INSTANCE;
                    FragmentManager childFragmentManager = HomeFragment.this.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                    Intrinsics.checkNotNullExpressionValue(adPopupBean, o.f);
                    final HomeFragment homeFragment = HomeFragment.this;
                    companion.a(childFragmentManager, adPopupBean, new Function0<Unit>() { // from class: com.huachenjie.home.HomeFragment.observeAdPopup.1.1
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m399invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m399invoke() {
                            AppBarLayout appBarLayout;
                            HomeFragmentMainBinding homeFragmentMainBindingAccess$getMBinding = HomeFragment.access$getMBinding(homeFragment);
                            if (homeFragmentMainBindingAccess$getMBinding == null || (appBarLayout = homeFragmentMainBindingAccess$getMBinding.f9419a) == null) {
                                return;
                            }
                            appBarLayout.setExpanded(false, true);
                        }
                    });
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClickGoodsPick(View view, int position) {
        GoodStuffPickData value = getMViewModel().G().getValue();
        if (value == null) {
            return;
        }
        PromoSlotBean promoSlotBeanFindPromoSlot = value.findPromoSlot(position);
        mq5.b(view.getContext(), promoSlotBeanFindPromoSlot.getPosition(), promoSlotBeanFindPromoSlot.getJumpUrl());
        int jumpType = promoSlotBeanFindPromoSlot.getJumpType();
        if (jumpType != 1) {
            if (jumpType == 2 || jumpType == 3) {
                ARouter.getInstance().build(zj7.g.GOOD_DETAIL).withString("goodsNo", promoSlotBeanFindPromoSlot.getJumpUrl()).navigation();
                return;
            }
            return;
        }
        er7 er7Var = er7.f41510a;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        er7Var.a(contextRequireContext, promoSlotBeanFindPromoSlot.getJumpUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRefreshListener$lambda$0(HomeFragment homeFragment) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        homeFragment.getMViewModel().W();
        homeFragment.getMViewModel().O();
        homeFragment.loadNativeAd();
        homeFragment.getMViewModel().V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void selectBuddyTypeTab(int index) {
        SlidingTabLayout slidingTabLayout;
        WrapContentHeightViewPager wrapContentHeightViewPager = this.buddyCardViewPager;
        if (wrapContentHeightViewPager == null || (slidingTabLayout = this.buddyTypeTabLayout) == null) {
            return;
        }
        if (wrapContentHeightViewPager.getCurrentItem() != index) {
            wrapContentHeightViewPager.setCurrentItem(index, false);
        }
        if (slidingTabLayout.getCurrentTab() != index) {
            slidingTabLayout.setCurrentTab(index, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateBuddyScopeForPages() {
        Integer value = getMViewModel().t().getValue();
        if (value == null) {
            value = 1;
        }
        int iIntValue = value.intValue();
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "childFragmentManager.fragments");
        ArrayList arrayList = new ArrayList();
        for (Object obj : fragments) {
            if (obj instanceof HomeBuddyCardPageFragment) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((HomeBuddyCardPageFragment) it.next()).updateScopeType(iIntValue);
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.home_fragment_main;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(xk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(xk0.k), this.clickProxy), TuplesKt.to(Integer.valueOf(xk0.R), this.onRefreshListener)});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().P();
        getMViewModel().Q();
        getMViewModel().M();
        getMViewModel().O();
        getMViewModel().N();
        loadNativeAd();
        getMViewModel().V();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        getMViewModel().E().observe(this, new e(new Function1<JackpotAwardBean, Unit>() { // from class: com.huachenjie.home.HomeFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((JackpotAwardBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(JackpotAwardBean jackpotAwardBean) {
                LotteryThemeConfigManager lotteryThemeConfigManager = LotteryThemeConfigManager.f9607a;
                Context contextRequireContext = HomeFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                lotteryThemeConfigManager.c(contextRequireContext, jackpotAwardBean.getThemeConfig());
            }
        }));
        getMViewModel().H().observe(this, new e(new Function1<List<? extends String>, Unit>() { // from class: com.huachenjie.home.HomeFragment.initDataObservable.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<String>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<String> list) {
                Banner banner;
                HomeFragmentMainBinding homeFragmentMainBindingAccess$getMBinding = HomeFragment.access$getMBinding(HomeFragment.this);
                if (homeFragmentMainBindingAccess$getMBinding == null || (banner = homeFragmentMainBindingAccess$getMBinding.f9424a) == null) {
                    return;
                }
                banner.setDatas(list);
            }
        }));
        getMViewModel().t().observe(this, new e(new Function1<Integer, Unit>() { // from class: com.huachenjie.home.HomeFragment.initDataObservable.3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Integer num) {
                BuddyScopeTabWidget buddyScopeTabWidget = HomeFragment.this.buddyScopeTabWidget;
                if (buddyScopeTabWidget != null) {
                    Intrinsics.checkNotNullExpressionValue(num, "scopeType");
                    buddyScopeTabWidget.setScopeType(num.intValue());
                }
            }
        }));
        getMViewModel().y().observe(this, new e(new Function1<List<? extends String>, Unit>() { // from class: com.huachenjie.home.HomeFragment.initDataObservable.4
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<String>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<String> list) {
                List<String> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    return;
                }
                Integer value = HomeFragment.access$getMViewModel(HomeFragment.this).w().getValue();
                if (value == null) {
                    value = 0;
                }
                int iIntValue = value.intValue();
                Intrinsics.checkNotNullExpressionValue(list, "titles");
                int iCoerceIn = RangesKt.coerceIn(iIntValue, 0, CollectionsKt.getLastIndex(list));
                List<BuddyTypeScopeTypeBean> value2 = HomeFragment.access$getMViewModel(HomeFragment.this).x().getValue();
                if (value2 == null) {
                    value2 = CollectionsKt.emptyList();
                }
                List<BuddyTypeScopeTypeBean> list3 = value2;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                Iterator<T> it = list3.iterator();
                while (it.hasNext()) {
                    arrayList.add(((BuddyTypeScopeTypeBean) it.next()).getBuddyTypeCode());
                }
                if (Intrinsics.areEqual(HomeFragment.this.boundBuddyTypeCodes, arrayList) && HomeFragment.this.getBuddyCardPagerAdapter().getCount() == list.size()) {
                    HomeFragment.this.updateBuddyScopeForPages();
                } else {
                    HomeFragment.this.boundBuddyTypeCodes = arrayList;
                    HomeFragment.this.bindBuddyTypeTab(list, iCoerceIn);
                }
                HomeFragment.this.selectBuddyTypeTab(iCoerceIn);
            }
        }));
        getMViewModel().w().observe(this, new e(new Function1<Integer, Unit>() { // from class: com.huachenjie.home.HomeFragment.initDataObservable.5
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Integer num) {
                int count = HomeFragment.this.getBuddyCardPagerAdapter().getCount();
                if (count <= 0) {
                    return;
                }
                HomeFragment homeFragment = HomeFragment.this;
                Intrinsics.checkNotNullExpressionValue(num, "index");
                homeFragment.selectBuddyTypeTab(RangesKt.coerceIn(num.intValue(), 0, count - 1));
            }
        }));
        getMViewModel().C().observe(this, new e(new Function1<HomeData, Unit>() { // from class: com.huachenjie.home.HomeFragment.initDataObservable.6
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HomeData) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(HomeData homeData) {
                ImageView imageView;
                HomeFunctionAdapter value = HomeFragment.access$getMViewModel(HomeFragment.this).B().getValue();
                if (value != null) {
                    value.setList(homeData.getFunctionEntries());
                }
                HomeFragmentMainBinding homeFragmentMainBindingAccess$getMBinding = HomeFragment.access$getMBinding(HomeFragment.this);
                if (homeFragmentMainBindingAccess$getMBinding == null || (imageView = homeFragmentMainBindingAccess$getMBinding.e) == null) {
                    return;
                }
                imageView.setImageResource(HomeFragment.this.findShandongHeader());
            }
        }));
        getMViewModel().D().observe(this, new e(new Function1<HomeRewardBean, Unit>() { // from class: com.huachenjie.home.HomeFragment.initDataObservable.7
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HomeRewardBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(HomeRewardBean homeRewardBean) {
                if (homeRewardBean.getStatus() == 1) {
                    HomeRewardDialog.Companion companion = HomeRewardDialog.INSTANCE;
                    FragmentManager childFragmentManager = HomeFragment.this.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                    Intrinsics.checkNotNullExpressionValue(homeRewardBean, o.f);
                    companion.a(childFragmentManager, homeRewardBean);
                }
            }
        }));
        getMViewModel().I().observe(this, new e(new Function1<Boolean, Unit>() { // from class: com.huachenjie.home.HomeFragment.initDataObservable.8
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                View view;
                View view2;
                int iK0 = com.gyf.immersionbar.e.K0(HomeFragment.this);
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    HomeFragmentMainBinding homeFragmentMainBindingAccess$getMBinding = HomeFragment.access$getMBinding(HomeFragment.this);
                    if (homeFragmentMainBindingAccess$getMBinding == null || (view2 = homeFragmentMainBindingAccess$getMBinding.c) == null) {
                        return;
                    }
                    view2.getLayoutParams().height = (((int) ((fx7.j() / 375.0f) * 320.0f)) - iK0) - jj8.a(116.0f);
                    return;
                }
                HomeFragmentMainBinding homeFragmentMainBindingAccess$getMBinding2 = HomeFragment.access$getMBinding(HomeFragment.this);
                if (homeFragmentMainBindingAccess$getMBinding2 == null || (view = homeFragmentMainBindingAccess$getMBinding2.c) == null) {
                    return;
                }
                view.getLayoutParams().height = 0;
            }
        }));
        observeAdPopup();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        i90.k(getActivity(), getLifecycle(), new c());
        initScroll();
        initHeaderAdapter();
        initHeaderGoodsAdapter();
        initSearchTextSwitch();
        initRecyclerView();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment, com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Context context = getContext();
        if (context != null) {
            fb4.f41638a.unregisterReceiver(context, getInspirationOperateReceiver());
            vs1.f45437a.unregisterReceiver(context, getConfigOperateReceiver());
        }
        this.buddyScopeTabWidget = null;
        this.buddyTypeTabLayout = null;
        this.buddyCardViewPager = null;
        this.buddyPlazaInitialized = false;
        this.boundBuddyTypeCodes = null;
        super.onDestroyView();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void onFragmentResume() {
        super.onFragmentResume();
        cr8.f(this, true);
        getMViewModel().W();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void onViewCreated() {
        super.onViewCreated();
        Context context = getContext();
        if (context != null) {
            fb4.f41638a.registerReceiver(context, getInspirationOperateReceiver());
            vs1.f45437a.registerReceiver(context, getConfigOperateReceiver());
        }
        handleBuddyConfig();
    }
}
