package com.huachenjie.mall.page.home_tab;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.fragment.app.Fragment;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.flyco.tablayout.SlidingTabLayout2;
import com.huachenjie.ad.util.OAIDUtil;
import com.huachenjie.base.adapter.BaseViewPager2Adapter;
import com.huachenjie.base.dialog.open_oaid.OpenOaidDialog;
import com.huachenjie.base.mob.MobClickConstants;
import com.huachenjie.base.util.CustomTabStyle;
import com.huachenjie.college.bean.PointActivityBean;
import com.huachenjie.college.page.point_activity.PointActivityListActivity;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.MallBannerBean;
import com.huachenjie.mall.bean.MallNavigationBean;
import com.huachenjie.mall.databinding.MallActivityMallBinding;
import com.huachenjie.mall.page.goods_detail.GoodsDetailActivity;
import com.huachenjie.mall.page.home_tab.MallActivity;
import com.huachenjie.mall.page.home_tab.search.MallSearchActivity;
import com.huachenjie.mall.page.merchants.MerchantsActivity;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.bo;
import com.noober.background.drawable.DrawableCreator;
import com.noober.background.view.BLConstraintLayout;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.util.BannerUtils;
import com.zj.adlib.fv5;
import com.zj.adlib.fx7;
import com.zj.adlib.hk0;
import com.zj.adlib.jj8;
import com.zj.adlib.ju3;
import com.zj.adlib.kq5;
import com.zj.adlib.lr9;
import com.zj.adlib.r90;
import com.zj.adlib.su9;
import com.zj.adlib.wl0;
import com.zj.adlib.y6b;
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
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Route(path = zj7.g.MALL_HOME)
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001(B\u0007¢\u0006\u0004\b+\u0010,J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u001c\u0010\u0011\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\tJ\u0016\u0010\u0016\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\u001e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u0013H\u0002J\b\u0010\u001b\u001a\u00020\tH\u0002J\b\u0010\u001c\u001a\u00020\tH\u0002R\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/huachenjie/mall/page/home_tab/MallActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityMallBinding;", "Lcom/huachenjie/mall/page/home_tab/MallHomeVM;", "", "getLayoutResID", "", "", "V", "", "initView", "W", "initData", "", "keyword", "", MallSearchActivity.x, "r0", "i0", "", "Lcom/huachenjie/mall/bean/MallNavigationBean;", "navigationList", "o0", "Landroid/view/ViewGroup;", "contentView", "levelList", bo.g, "k0", "m0", "Lcom/huachenjie/base/util/CustomTabStyle;", "b", "Lkotlin/Lazy;", "j0", "()Lcom/huachenjie/base/util/CustomTabStyle;", "customTabStyle", "", "c", "Ljava/util/List;", "flowViewIdList", "Landroid/widget/PopupWindow;", "a", "Landroid/widget/PopupWindow;", "popupWindow", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nMallActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MallActivity.kt\ncom/huachenjie/mall/page/home_tab/MallActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,299:1\n1855#2,2:300\n1864#2,3:302\n*S KotlinDebug\n*F\n+ 1 MallActivity.kt\ncom/huachenjie/mall/page/home_tab/MallActivity\n*L\n194#1:300,2\n202#1:302,3\n*E\n"})
public final class MallActivity extends BaseMVVMActivity<MallActivityMallBinding, MallHomeVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public PopupWindow popupWindow;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy customTabStyle = LazyKt.lazy(new Function0<CustomTabStyle>() { // from class: com.huachenjie.mall.page.home_tab.MallActivity$customTabStyle$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final CustomTabStyle m555invoke() {
            return new CustomTabStyle();
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final List<Integer> flowViewIdList = new ArrayList();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/huachenjie/mall/page/home_tab/MallActivity$a;", "", "Landroid/view/View;", "view", "", "c", y6b.g, y6b.f, "d", "i", "<init>", "(Lcom/huachenjie/mall/page/home_tab/MallActivity;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nMallActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MallActivity.kt\ncom/huachenjie/mall/page/home_tab/MallActivity$ClickProxy\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,299:1\n1549#2:300\n1620#2,3:301\n*S KotlinDebug\n*F\n+ 1 MallActivity.kt\ncom/huachenjie/mall/page/home_tab/MallActivity$ClickProxy\n*L\n138#1:300\n138#1:301,3\n*E\n"})
    public final class a {
        public a() {
        }

        public static final void e(MallActivity mallActivity, View view) {
            Intrinsics.checkNotNullParameter(mallActivity, "this$0");
            PopupWindow popupWindow = mallActivity.popupWindow;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
        }

        public static final void f(MallActivity mallActivity) {
            ImageView imageView;
            Intrinsics.checkNotNullParameter(mallActivity, "this$0");
            MallActivityMallBinding mallActivityMallBindingC0 = MallActivity.c0(mallActivity);
            if (mallActivityMallBindingC0 == null || (imageView = mallActivityMallBindingC0.b) == null) {
                return;
            }
            imageView.setImageResource(R.drawable.mall_ic_home_tab_filter);
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            MallActivity.this.finish();
        }

        public final void d(@NotNull View view) {
            MutableLiveData<List<MallNavigationBean>> mutableLiveDataL;
            List<MallNavigationBean> value;
            ImageView imageView;
            Intrinsics.checkNotNullParameter(view, "view");
            MallHomeVM mallHomeVMD0 = MallActivity.d0(MallActivity.this);
            if (mallHomeVMD0 == null || (mutableLiveDataL = mallHomeVMD0.l()) == null || (value = mutableLiveDataL.getValue()) == null) {
                return;
            }
            MallActivity mallActivity = MallActivity.this;
            List<MallNavigationBean> list = value;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((MallNavigationBean) it.next()).getName());
            }
            List list2 = CollectionsKt.toList(arrayList);
            View viewInflate = LayoutInflater.from(view.getContext()).inflate(R.layout.mall_popub_home_filter, (ViewGroup) null);
            MallActivity mallActivity2 = MallActivity.this;
            Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.view.ViewGroup");
            mallActivity2.p0((ViewGroup) viewInflate, list2);
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            MallActivity.this.popupWindow = new PopupWindow(viewInflate, fx7.j(), ((fx7.h() - view.getHeight()) - iArr[1]) - (wl0.q(mallActivity) ? wl0.i() : 0), true);
            final MallActivity mallActivity3 = MallActivity.this;
            viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.o65
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    MallActivity.a.e(mallActivity3, view2);
                }
            });
            PopupWindow popupWindow = MallActivity.this.popupWindow;
            if (popupWindow != null) {
                popupWindow.showAsDropDown(view);
            }
            MallActivityMallBinding mallActivityMallBindingC0 = MallActivity.c0(MallActivity.this);
            if (mallActivityMallBindingC0 != null && (imageView = mallActivityMallBindingC0.b) != null) {
                imageView.setImageResource(R.drawable.mall_ic_home_tab_filter_close);
            }
            PopupWindow popupWindow2 = MallActivity.this.popupWindow;
            if (popupWindow2 != null) {
                final MallActivity mallActivity4 = MallActivity.this;
                popupWindow2.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.zj.adlib.p65
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public final void onDismiss() {
                        MallActivity.a.f(mallActivity4);
                    }
                });
            }
        }

        public final void g(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            MallActivity.d0(MallActivity.this).t();
        }

        public final void h(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            su9.r(view.getContext());
        }

        public final void i(@NotNull View view) {
            Banner banner;
            Intrinsics.checkNotNullParameter(view, "view");
            MallActivityMallBinding mallActivityMallBindingC0 = MallActivity.c0(MallActivity.this);
            MallActivity.this.r0((mallActivityMallBindingC0 == null || (banner = mallActivityMallBindingC0.f10257b) == null) ? null : (String) banner.getAdapter().getData(BannerUtils.getRealPosition(true, banner.getCurrentItem(), banner.getRealCount())), true);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35220a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35220a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35220a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35220a.invoke(obj);
        }
    }

    public static final /* synthetic */ MallActivityMallBinding c0(MallActivity mallActivity) {
        return mallActivity.getMBinding();
    }

    public static final /* synthetic */ MallHomeVM d0(MallActivity mallActivity) {
        return mallActivity.getMViewModel();
    }

    public static final void l0(MallActivity mallActivity, MallBannerBean mallBannerBean, int i) {
        Intrinsics.checkNotNullParameter(mallActivity, "this$0");
        kq5.c(mallActivity, MobClickConstants.f32937a);
        int jumpType = mallBannerBean.getJumpType();
        if (jumpType == 1) {
            GoodsDetailActivity.INSTANCE.a(mallActivity, mallBannerBean.getJumpContent());
        } else if (jumpType == 2) {
            MerchantsActivity.INSTANCE.a(mallActivity, mallBannerBean.getJumpContent());
        } else {
            if (jumpType != 3) {
                return;
            }
            su9.l(mallActivity, mallBannerBean.getJumpContent());
        }
    }

    public static final void n0(MallActivity mallActivity, Object obj, int i) {
        Intrinsics.checkNotNullParameter(mallActivity, "this$0");
        List<String> value = mallActivity.getMViewModel().o().getValue();
        s0(mallActivity, value != null ? (String) CollectionsKt.getOrNull(value, i) : null, false, 2, null);
    }

    public static final void q0(MallActivity mallActivity, int i, View view) {
        Intrinsics.checkNotNullParameter(mallActivity, "this$0");
        MallActivityMallBinding mBinding = mallActivity.getMBinding();
        SlidingTabLayout2 slidingTabLayout2 = mBinding != null ? mBinding.f10250a : null;
        if (slidingTabLayout2 != null) {
            slidingTabLayout2.setCurrentTab(i);
        }
        PopupWindow popupWindow = mallActivity.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public static /* synthetic */ void s0(MallActivity mallActivity, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        mallActivity.r0(str, z);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        MutableLiveData<List<String>> mutableLiveDataO;
        MutableLiveData<List<MallBannerBean>> mutableLiveDataK;
        getMViewModel().l().observe(this, new b(new Function1<List<? extends MallNavigationBean>, Unit>() { // from class: com.huachenjie.mall.page.home_tab.MallActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<MallNavigationBean>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<MallNavigationBean> list) {
                MallActivity mallActivity = this.this$0;
                Intrinsics.checkNotNullExpressionValue(list, o.f);
                mallActivity.o0(list);
            }
        }));
        MallHomeVM mViewModel = getMViewModel();
        if (mViewModel != null && (mutableLiveDataK = mViewModel.k()) != null) {
            mutableLiveDataK.observe(this, new b(new Function1<List<? extends MallBannerBean>, Unit>() { // from class: com.huachenjie.mall.page.home_tab.MallActivity$initDataObserve$2
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((List<MallBannerBean>) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(List<MallBannerBean> list) {
                    Banner banner;
                    MallActivityMallBinding mallActivityMallBindingC0 = MallActivity.c0(this.this$0);
                    if (mallActivityMallBindingC0 == null || (banner = mallActivityMallBindingC0.f10256a) == null) {
                        return;
                    }
                    banner.setDatas(list);
                }
            }));
        }
        MallHomeVM mViewModel2 = getMViewModel();
        if (mViewModel2 != null && (mutableLiveDataO = mViewModel2.o()) != null) {
            mutableLiveDataO.observe(this, new b(new Function1<List<? extends String>, Unit>() { // from class: com.huachenjie.mall.page.home_tab.MallActivity$initDataObserve$3
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((List<String>) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(List<String> list) {
                    Banner banner;
                    MallActivityMallBinding mallActivityMallBindingC0 = MallActivity.c0(this.this$0);
                    if (mallActivityMallBindingC0 == null || (banner = mallActivityMallBindingC0.f10257b) == null) {
                        return;
                    }
                    banner.setDatas(list);
                }
            }));
        }
        getMViewModel().n().observe(this, new b(new Function1<List<? extends PointActivityBean>, Unit>() { // from class: com.huachenjie.mall.page.home_tab.MallActivity$initDataObserve$4
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<PointActivityBean>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<PointActivityBean> list) {
                if (list == null || list.isEmpty()) {
                    fv5.b("暂无秒杀活动~");
                } else if (list.size() == 1) {
                    su9.i(this.this$0, list.get(0).getActivityNo());
                } else {
                    this.this$0.startActivity(new Intent(this.this$0, (Class<?>) PointActivityListActivity.class));
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_mall;
    }

    public final void i0() {
        if (OAIDUtil.b() || r90.t()) {
            return;
        }
        OpenOaidDialog.INSTANCE.a().show(getSupportFragmentManager(), OpenOaidDialog.class.getSimpleName());
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().s();
        i0();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        k0();
        m0();
    }

    public final CustomTabStyle j0() {
        return (CustomTabStyle) this.customTabStyle.getValue();
    }

    public final void k0() {
        Banner banner;
        Banner banner2;
        BannerImageAdapter<MallBannerBean> bannerImageAdapter = new BannerImageAdapter<MallBannerBean>() { // from class: com.huachenjie.mall.page.home_tab.MallActivity$initBanner$bannerAdapter$1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void onBindView(@NotNull BannerImageHolder holder, @NotNull MallBannerBean data, int position, int size) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(data, "data");
                Glide.with(holder.itemView).load(data.getPicUrl()).apply((BaseRequestOptions<?>) ju3.n).into(holder.imageView);
            }
        };
        bannerImageAdapter.setOnBannerListener(new OnBannerListener() { // from class: com.zj.adlib.l65
            public final void OnBannerClick(Object obj, int i) {
                MallActivity.l0(this.f43006a, (MallBannerBean) obj, i);
            }
        });
        MallActivityMallBinding mBinding = getMBinding();
        if (mBinding != null && (banner2 = mBinding.f10256a) != null) {
            banner2.setAdapter(bannerImageAdapter);
        }
        MallActivityMallBinding mBinding2 = getMBinding();
        Banner banner3 = mBinding2 != null ? mBinding2.f10256a : null;
        if (banner3 != null) {
            banner3.setIndicator(new CircleIndicator(this));
        }
        MallActivityMallBinding mBinding3 = getMBinding();
        if (mBinding3 == null || (banner = mBinding3.f10256a) == null) {
            return;
        }
        banner.addBannerLifecycleObserver(this);
    }

    public final void m0() {
        Banner banner;
        MallActivityMallBinding mBinding = getMBinding();
        if (mBinding == null || (banner = mBinding.f10257b) == null) {
            return;
        }
        banner.addBannerLifecycleObserver(this).setAdapter(new SearchTextSwitchAdapter()).setUserInputEnabled(false).setLoopTime(2000L).setScrollTime(500).setIndicator(new CircleIndicator(banner.getContext()));
        banner.setOnBannerListener(new OnBannerListener() { // from class: com.zj.adlib.n65
            public final void OnBannerClick(Object obj, int i) {
                MallActivity.n0(this.f43458a, obj, i);
            }
        });
    }

    public final void o0(List<MallNavigationBean> navigationList) {
        MallActivityMallBinding mBinding = getMBinding();
        if (mBinding != null) {
            BaseViewPager2Adapter<MallNavigationBean> baseViewPager2Adapter = new BaseViewPager2Adapter<MallNavigationBean>(this) { // from class: com.huachenjie.mall.page.home_tab.MallActivity$initTab$1$pagerAdapter$1
                {
                    super(this);
                }

                @Override // com.huachenjie.base.adapter.BaseViewPager2Adapter
                @NotNull
                /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
                public Fragment c(int position, @NotNull MallNavigationBean bean) {
                    Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
                    return MallItemFragment.Companion.b(MallItemFragment.INSTANCE, bean.getNavigationNo(), bean.getName(), null, 4, null);
                }
            };
            ViewPager2 viewPager2 = mBinding.f10249a;
            Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.viewPager");
            lr9.a(viewPager2);
            mBinding.f10249a.setAdapter(baseViewPager2Adapter);
            ArrayList arrayList = new ArrayList();
            Iterator<MallNavigationBean> it = navigationList.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getName());
            }
            baseViewPager2Adapter.setList(navigationList);
            mBinding.f10250a.setViewPager(mBinding.f10249a, arrayList);
            CustomTabStyle customTabStyleJ0 = j0();
            SlidingTabLayout2 slidingTabLayout2 = mBinding.f10250a;
            Intrinsics.checkNotNullExpressionValue(slidingTabLayout2, "binding.tabLayout");
            CustomTabStyle.h(customTabStyleJ0, slidingTabLayout2, mBinding.f10249a, null, 0, 12, null);
        }
    }

    public final void p0(ViewGroup contentView, List<String> levelList) {
        BLConstraintLayout bLConstraintLayoutFindViewById;
        SlidingTabLayout2 slidingTabLayout2;
        Flow flow = (Flow) contentView.findViewById(R.id.flowLevel);
        if (flow == null || (bLConstraintLayoutFindViewById = contentView.findViewById(R.id.constraintLayout)) == null) {
            return;
        }
        Iterator<T> it = this.flowViewIdList.iterator();
        while (it.hasNext()) {
            View viewFindViewById = contentView.findViewById(((Number) it.next()).intValue());
            if (viewFindViewById != null) {
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById<View>(it)");
                bLConstraintLayoutFindViewById.removeView(viewFindViewById);
                flow.removeView(viewFindViewById);
            }
        }
        this.flowViewIdList.clear();
        MallActivityMallBinding mBinding = getMBinding();
        int currentTab = (mBinding == null || (slidingTabLayout2 = mBinding.f10250a) == null) ? 0 : slidingTabLayout2.getCurrentTab();
        final int i = 0;
        for (Object obj : levelList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TextView textView = new TextView(contentView.getContext());
            textView.setId(View.generateViewId());
            textView.setLayoutParams(new ViewGroup.LayoutParams(-2, jj8.a(32.0f)));
            textView.setGravity(17);
            int iA = jj8.a(20.0f);
            textView.setPadding(iA, 0, iA, 0);
            textView.setText((String) obj);
            String str = "#191F20";
            textView.setTextColor(currentTab == i ? Color.parseColor("#ffffff") : Color.parseColor("#191F20"));
            textView.setTextSize(14.0f);
            DrawableCreator.Builder builder = new DrawableCreator.Builder();
            if (currentTab != i) {
                str = "#FFF7F7F7";
            }
            textView.setBackground(builder.setSolidColor(Color.parseColor(str)).setCornersRadius(jj8.a(16.0f)).build());
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.m65
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MallActivity.q0(this.f43232a, i, view);
                }
            });
            this.flowViewIdList.add(Integer.valueOf(textView.getId()));
            bLConstraintLayoutFindViewById.addView(textView);
            flow.addView(textView);
            i = i2;
        }
    }

    public final void r0(@Nullable String keyword, boolean isSearch) {
        MallSearchActivity.Companion bVar = MallSearchActivity.INSTANCE;
        if (Intrinsics.areEqual(getMViewModel().m().getValue(), Boolean.TRUE)) {
            keyword = null;
        }
        bVar.a(this, keyword, isSearch);
    }
}
