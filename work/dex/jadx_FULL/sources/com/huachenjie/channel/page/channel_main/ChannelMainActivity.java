package com.huachenjie.channel.page.channel_main;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.android.material.appbar.AppBarLayout;
import com.gyf.immersionbar.e;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.AdvertiseBean;
import com.huachenjie.channel.bean.ChannelMainBean;
import com.huachenjie.channel.databinding.ChannelActivityChannelMainBinding;
import com.huachenjie.channel.page.advertise.preview.PreviewAdvertiseActivity;
import com.huachenjie.channel.page.all_member.AllMemberActivity;
import com.huachenjie.channel.page.channel_main.ChannelMainActivity;
import com.huachenjie.channel.page.channel_main.organize.ChannelMainOrganizeFragment;
import com.huachenjie.channel.page.channel_main.topic.ChannelMainTopicFragment;
import com.huachenjie.common.bean.CommonBannerBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.common.widget.CommonBanner;
import com.huachenjie.common.widget.CommonBannerConfig;
import com.igexin.push.g.o;
import com.noober.background.drawable.DrawableCreator;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.listener.OnPageChangeListener;
import com.zj.adlib.ar6;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.jj8;
import com.zj.adlib.kq5;
import com.zj.adlib.qi1;
import com.zj.adlib.tk0;
import com.zj.adlib.w88;
import com.zj.adlib.ys8;
import com.zj.adlib.zj7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Route(path = zj7.b.CHANNEL_MAIN)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001 B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002J\u0016\u0010\u0017\u001a\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002R\u0016\u0010\u001d\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/huachenjie/channel/page/channel_main/ChannelMainActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityChannelMainBinding;", "Lcom/huachenjie/channel/page/channel_main/ChannelMainVM;", "", "getLayoutResID", "", "", "V", "", "S", "initView", "initData", "W", "", "isDark", "m0", "certificationFlag", "n0", "i0", "", "Lcom/huachenjie/channel/bean/AdvertiseBean;", "advertiseBeans", "g0", "l0", "k0", "", "t", "Ljava/lang/String;", "channelNo", "<init>", "()V", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class ChannelMainActivity extends BaseMVVMActivity<ChannelActivityChannelMainBinding, ChannelMainVM> {

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    @Autowired(name = "channelNo")
    @JvmField
    @NotNull
    public String channelNo = "";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/channel/page/channel_main/ChannelMainActivity$a;", "", "Landroid/view/View;", "view", "", "c", "f", "b", "d", "<init>", "(Lcom/huachenjie/channel/page/channel_main/ChannelMainActivity;)V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public static final void e(ChannelMainActivity channelMainActivity, View view) {
            Intrinsics.checkNotNullParameter(channelMainActivity, "this$0");
            ChannelMainActivity.c0(channelMainActivity).p(channelMainActivity.channelNo);
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ChannelMainBean value = ChannelMainActivity.c0(ChannelMainActivity.this).l().getValue();
            boolean z = false;
            if (value != null && !value.isRunOrUniverseChannel()) {
                z = true;
            }
            if (z) {
                ChannelMainActivity channelMainActivity = ChannelMainActivity.this;
                channelMainActivity.startActivity(AllMemberActivity.INSTANCE.a(channelMainActivity, AllMemberActivity.K, channelMainActivity.channelNo));
            }
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ChannelMainActivity.this.finish();
        }

        public final void d(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (ChannelMainActivity.c0(ChannelMainActivity.this).l().getValue() == null) {
                return;
            }
            ChannelMainBean value = ChannelMainActivity.c0(ChannelMainActivity.this).l().getValue();
            boolean z = false;
            if (value != null && value.getJoinFlag()) {
                z = true;
            }
            if (!z) {
                ChannelMainActivity.c0(ChannelMainActivity.this).o(ChannelMainActivity.this.channelNo);
                return;
            }
            ChannelMainActivity channelMainActivity = ChannelMainActivity.this;
            String string = channelMainActivity.getString(R.string.channel_main_out_channel);
            final ChannelMainActivity channelMainActivity2 = ChannelMainActivity.this;
            ft1.p(channelMainActivity, string, new View.OnClickListener() { // from class: com.zj.adlib.li1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ChannelMainActivity.a.e(channelMainActivity2, view2);
                }
            });
        }

        public final void f(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (ChannelMainActivity.c0(ChannelMainActivity.this).l().getValue() == null) {
                return;
            }
            ChannelMainBean value = ChannelMainActivity.c0(ChannelMainActivity.this).l().getValue();
            Intrinsics.checkNotNull(value);
            FragmentManager supportFragmentManager = ChannelMainActivity.this.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            w88.b(value, supportFragmentManager);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"com/huachenjie/channel/page/channel_main/ChannelMainActivity$b", "Lcom/youth/banner/listener/OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", "onPageScrolled", "onPageSelected", "state", "onPageScrollStateChanged", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements OnPageChangeListener {
        public b() {
        }

        public void onPageScrollStateChanged(int state) {
        }

        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        public void onPageSelected(int position) {
            AdvertiseBean advertiseBean;
            List<AdvertiseBean> value = ChannelMainActivity.c0(ChannelMainActivity.this).j().getValue();
            if (value == null || (advertiseBean = (AdvertiseBean) CollectionsKt.getOrNull(value, position)) == null) {
                return;
            }
            ChannelMainActivity.this.l0(advertiseBean);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33385a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33385a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33385a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33385a.invoke(obj);
        }
    }

    public static final /* synthetic */ ChannelMainVM c0(ChannelMainActivity channelMainActivity) {
        return channelMainActivity.getMViewModel();
    }

    public static final void h0(ChannelMainActivity channelMainActivity, CommonBannerBean commonBannerBean, int i) {
        AdvertiseBean advertiseBean;
        Intrinsics.checkNotNullParameter(channelMainActivity, "this$0");
        List<AdvertiseBean> value = channelMainActivity.getMViewModel().j().getValue();
        if (value == null || (advertiseBean = (AdvertiseBean) CollectionsKt.getOrNull(value, i)) == null) {
            return;
        }
        channelMainActivity.getMViewModel().i(advertiseBean);
        channelMainActivity.k0(advertiseBean);
    }

    public static final void j0(ChannelMainActivity channelMainActivity, AppBarLayout appBarLayout, int i) {
        Intrinsics.checkNotNullParameter(channelMainActivity, "this$0");
        float fAbs = Math.abs(i) / (channelMainActivity.getMBinding().f7457a.getHeight() - channelMainActivity.getMBinding().f33049a.getHeight());
        if (fAbs < 0.0f) {
            fAbs = 0.0f;
        }
        if (fAbs > 1.0f) {
            fAbs = 1.0f;
        }
        channelMainActivity.getMBinding().f33049a.setBackgroundColor(Color.argb((int) (255 * fAbs), 255, 255, 255));
        boolean z = ((double) fAbs) > 0.5d;
        channelMainActivity.m0(z);
        if (z) {
            channelMainActivity.getMBinding().f7461a.setBackground(null);
            channelMainActivity.getMBinding().b.setBackground(null);
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(-16777216);
            channelMainActivity.getMBinding().f7461a.setImageTintList(colorStateListValueOf);
            channelMainActivity.getMBinding().b.setImageTintList(colorStateListValueOf);
            return;
        }
        Drawable drawableBuild = new DrawableCreator.Builder().setSolidColor(Integer.MIN_VALUE).setCornersRadius(jj8.a(36.0f)).build();
        channelMainActivity.getMBinding().f7461a.setBackground(drawableBuild);
        channelMainActivity.getMBinding().b.setBackground(drawableBuild);
        ColorStateList colorStateListValueOf2 = ColorStateList.valueOf(-1);
        channelMainActivity.getMBinding().f7461a.setImageTintList(colorStateListValueOf2);
        channelMainActivity.getMBinding().b.setImageTintList(colorStateListValueOf2);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseActivity
    public void S() {
        m0(false);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(tk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        getMViewModel().l().observe(this, new c(new Function1<ChannelMainBean, Unit>() { // from class: com.huachenjie.channel.page.channel_main.ChannelMainActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ChannelMainBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ChannelMainBean channelMainBean) {
                this.this$0.n0(channelMainBean.getCertificationFlag());
                if (channelMainBean.getCertificationFlag()) {
                    ChannelMainActivity.c0(this.this$0).r(this.this$0.channelNo);
                }
            }
        }));
        getMViewModel().j().observe(this, new c(new Function1<List<? extends AdvertiseBean>, Unit>() { // from class: com.huachenjie.channel.page.channel_main.ChannelMainActivity$initDataObserve$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<AdvertiseBean>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<AdvertiseBean> list) {
                List<AdvertiseBean> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    return;
                }
                CommonBanner commonBanner = this.this$0.getMBinding().f7458a.f8187a;
                ChannelMainActivity channelMainActivity = this.this$0;
                Intrinsics.checkNotNullExpressionValue(list, o.f);
                List<AdvertiseBean> list3 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                Iterator<T> it = list3.iterator();
                while (it.hasNext()) {
                    arrayList.add(new CommonBannerBean(((AdvertiseBean) it.next()).getCoverUrl(), 0, 0, false, 0.0f, 30, null));
                }
                CommonBannerConfig commonBannerConfig = new CommonBannerConfig();
                commonBannerConfig.setMinHeightDp(120);
                commonBannerConfig.setMaxHeightDp(120);
                commonBannerConfig.setIndicatorStyle(CommonBannerConfig.BannerIndicatorStyle.CircleStyle.INSTANCE);
                Unit unit = Unit.INSTANCE;
                commonBanner.setImageList(channelMainActivity, arrayList, commonBannerConfig);
                this.this$0.g0(list);
            }
        }));
        getMViewModel().m().observe(this, new c(new Function1<AdvertiseBean, Unit>() { // from class: com.huachenjie.channel.page.channel_main.ChannelMainActivity$initDataObserve$3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((AdvertiseBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(AdvertiseBean advertiseBean) {
                if (advertiseBean == null) {
                    return;
                }
                if (advertiseBean.getLinkType()) {
                    ARouter.getInstance().build(RoutePathConstants.Common.c).withString("url", advertiseBean.getLinkUrl()).withString("title", "详情").navigation();
                } else {
                    PreviewAdvertiseActivity.f33365a.a(this.this$0, advertiseBean);
                }
            }
        }));
        getMViewModel().n().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.channel.page.channel_main.ChannelMainActivity$initDataObserve$4
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    fv5.b(ys8.e(R.string.channel_main_join_channel_success));
                    ChannelMainBean value = ChannelMainActivity.c0(this.this$0).l().getValue();
                    if (value != null) {
                        qi1.f44215a.d(this.this$0, value.getChannelNo(), value.getLogo());
                    }
                }
            }
        }));
        getMViewModel().k().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.channel.page.channel_main.ChannelMainActivity$initDataObserve$5
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    fv5.b(ys8.e(R.string.channel_main_out_channel_success));
                    qi1 qi1Var = qi1.f44215a;
                    ChannelMainActivity channelMainActivity = this.this$0;
                    qi1Var.c(channelMainActivity, channelMainActivity.channelNo);
                }
            }
        }));
    }

    public final void g0(List<AdvertiseBean> advertiseBeans) {
        if (!advertiseBeans.isEmpty()) {
            l0(advertiseBeans.get(0));
        }
        getMBinding().f7458a.f8187a.setOnBannerListener(new OnBannerListener() { // from class: com.zj.adlib.ji1
            public final void OnBannerClick(Object obj, int i) {
                ChannelMainActivity.h0(this.f42592a, (CommonBannerBean) obj, i);
            }
        });
        getMBinding().f7458a.f8187a.addOnPageChangeListener(new b());
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_channel_main;
    }

    public final void i0() {
        getMBinding().f7456a.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.zj.adlib.ki1
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                ChannelMainActivity.j0(this.f42825a, appBarLayout, i);
            }
        });
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().q(this.channelNo);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        getWindow().getDecorView().setBackgroundColor(ar6.E);
        getMBinding().f7454a.setUserInputEnabled(false);
        i0();
    }

    public final void k0(AdvertiseBean advertiseBeans) {
        kq5.b(this, "channelAdClick", MapsKt.mapOf(TuplesKt.to("channelAdCode", advertiseBeans.getChannelAdCode())));
    }

    public final void l0(AdvertiseBean advertiseBeans) {
        kq5.b(this, "channelAdExposure", MapsKt.mapOf(TuplesKt.to("channelAdCode", advertiseBeans.getChannelAdCode())));
    }

    public final void m0(boolean isDark) {
        e.p3(this).G2(R.color.transparent).T2(isDark).k3().a1();
    }

    public final void n0(boolean certificationFlag) {
        List<String> listListOf;
        List<Fragment> listListOf2;
        if (certificationFlag) {
            getMBinding().f7455a.setVisibility(0);
            listListOf = CollectionsKt.listOf(new String[]{"频道话题", "官方组织"});
            listListOf2 = CollectionsKt.listOf(new BaseMVVMFragment[]{ChannelMainTopicFragment.INSTANCE.a(this.channelNo), ChannelMainOrganizeFragment.INSTANCE.a(this.channelNo)});
        } else {
            getMBinding().f7455a.setVisibility(8);
            listListOf = CollectionsKt.listOf("频道话题");
            listListOf2 = CollectionsKt.listOf(ChannelMainTopicFragment.INSTANCE.a(this.channelNo));
        }
        getMBinding().f7455a.setViewPager(getMBinding().f7454a, listListOf, this, listListOf2);
    }
}
