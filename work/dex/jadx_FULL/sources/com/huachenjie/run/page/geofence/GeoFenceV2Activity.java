package com.huachenjie.run.page.geofence;

import android.os.Bundle;
import android.view.View;
import androidx.coroutines.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.ToastUtils;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.gyf.immersionbar.e;
import com.huachenjie.base.bean.TabEntity;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.run.R;
import com.huachenjie.run.adapter.GuideFragmentAdapter;
import com.huachenjie.run.bean.VideoInfoData;
import com.huachenjie.run.databinding.RunActivityRunGeoGuideV3Binding;
import com.huachenjie.run.page.geofence.GeoFenceV2Activity;
import com.zj.adlib.i62;
import com.zj.adlib.lk0;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Route(path = RoutePathConstants.Run.c)
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b \u0010!J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\u0018\u0010\u000f\u001a\u00020\u00032\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0002R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/huachenjie/run/page/geofence/GeoFenceV2Activity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/run/page/geofence/GeoFenceActivityVM;", "", "initViewModel", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "e0", "Landroid/os/Bundle;", "savedInstanceState", "init", "n0", "", "Lcom/huachenjie/run/bean/VideoInfoData;", "videos", "k0", "l0", "initView", "", "position", "o0", "Lcom/huachenjie/run/adapter/GuideFragmentAdapter;", "a", "Lcom/huachenjie/run/adapter/GuideFragmentAdapter;", "mPagerAdapter", "", "c", "Ljava/util/List;", "mPageTitleList", "K", "I", "mLastPagePosition", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nGeoFenceV2Activity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GeoFenceV2Activity.kt\ncom/huachenjie/run/page/geofence/GeoFenceV2Activity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,125:1\n1#2:126\n1855#3,2:127\n*S KotlinDebug\n*F\n+ 1 GeoFenceV2Activity.kt\ncom/huachenjie/run/page/geofence/GeoFenceV2Activity\n*L\n92#1:127,2\n*E\n"})
public final class GeoFenceV2Activity extends BaseVmActivity<GeoFenceActivityVM> {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int mLastPagePosition;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public GuideFragmentAdapter mPagerAdapter;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final List<String> mPageTitleList = CollectionsKt.listOf(new String[]{"跑步区域", "打卡点", "公里数", "配速要求"});

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/run/page/geofence/GeoFenceV2Activity$a;", "", "Landroid/view/View;", "v", "", "a", "<init>", "(Lcom/huachenjie/run/page/geofence/GeoFenceV2Activity;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@Nullable View v) {
            GeoFenceV2Activity.this.finish();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/huachenjie/run/page/geofence/GeoFenceV2Activity$b", "Lcom/flyco/tablayout/listener/OnTabSelectListener;", "", "position", "", "b", "a", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements OnTabSelectListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RunActivityRunGeoGuideV3Binding f35878a;

        public b(RunActivityRunGeoGuideV3Binding runActivityRunGeoGuideV3Binding) {
            this.f35878a = runActivityRunGeoGuideV3Binding;
        }

        @Override // com.flyco.tablayout.listener.OnTabSelectListener
        public void a(int position) {
        }

        @Override // com.flyco.tablayout.listener.OnTabSelectListener
        public void b(int position) {
            this.f35878a.f35486a.setCurrentItem(position);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35879a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35879a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35879a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35879a.invoke(obj);
        }
    }

    public static final void m0(GeoFenceV2Activity geoFenceV2Activity, View view) {
        Intrinsics.checkNotNullParameter(geoFenceV2Activity, "this$0");
        geoFenceV2Activity.finish();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void e0() {
        e.p3(this).G2(R.color.transparent).T2(true).u1(R.color.white).G1(true).a1();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        Integer numValueOf = Integer.valueOf(R.layout.run_activity_run_geo_guide_v3);
        Integer numValueOf2 = Integer.valueOf(lk0.L);
        Q q = ((BaseVmActivity) this).f8507a;
        Intrinsics.checkNotNull(q);
        i62 i62VarA = new i62(numValueOf, numValueOf2, q).a(Integer.valueOf(lk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        l0();
        initView();
        GeoFenceActivityVM geoFenceActivityVM = (GeoFenceActivityVM) ((BaseVmActivity) this).f8507a;
        if (geoFenceActivityVM != null) {
            geoFenceActivityVM.j();
        }
    }

    public final void initView() {
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.run.databinding.RunActivityRunGeoGuideV3Binding");
        final RunActivityRunGeoGuideV3Binding runActivityRunGeoGuideV3Binding = (RunActivityRunGeoGuideV3Binding) binding;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        GuideFragmentAdapter guideFragmentAdapter = new GuideFragmentAdapter(this, supportFragmentManager, new ArrayList(), new ArrayList());
        this.mPagerAdapter = guideFragmentAdapter;
        runActivityRunGeoGuideV3Binding.f35486a.setAdapter(guideFragmentAdapter);
        runActivityRunGeoGuideV3Binding.f35486a.setOffscreenPageLimit(4);
        ArrayList<CustomTabEntity> arrayList = new ArrayList<>();
        Iterator<T> it = this.mPageTitleList.iterator();
        while (it.hasNext()) {
            arrayList.add(new TabEntity((String) it.next()));
        }
        runActivityRunGeoGuideV3Binding.f11534a.setTabData(arrayList);
        runActivityRunGeoGuideV3Binding.f11534a.setOnTabSelectListener(new b(runActivityRunGeoGuideV3Binding));
        runActivityRunGeoGuideV3Binding.f35486a.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() { // from class: com.huachenjie.run.page.geofence.GeoFenceV2Activity.initView.3
            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int position) {
                runActivityRunGeoGuideV3Binding.f11534a.setCurrentTab(position);
                GeoFenceV2Activity geoFenceV2Activity = this;
                geoFenceV2Activity.o0(geoFenceV2Activity.mLastPagePosition);
                this.mLastPagePosition = position;
            }
        });
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
        n0();
    }

    public final void k0(List<VideoInfoData> videos) {
        List<VideoInfoData> list = videos;
        if (list == null || list.isEmpty()) {
            ToastUtils.W("引导视频 或奖励礼盒数据配置异常!", new Object[0]);
            return;
        }
        GuideFragmentAdapter guideFragmentAdapter = this.mPagerAdapter;
        if (guideFragmentAdapter != null) {
            guideFragmentAdapter.m(this.mPageTitleList, videos);
        }
    }

    public final void l0() {
        MutableLiveData<Integer> mutableLiveData;
        Integer value;
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        bindingTitleBean.setTitleName("跑步指引");
        bindingTitleBean.setBackground(zn1.a(R.color.white));
        bindingTitleBean.setTitleTextColor(zn1.a(R.color.hcj_header_txt));
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(-16777216);
        bindingTitleBean.setShowDivider(true);
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.rt3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GeoFenceV2Activity.m0(this.f44533a, view);
            }
        });
        GeoFenceActivityVM geoFenceActivityVM = (GeoFenceActivityVM) ((BaseVmActivity) this).f8507a;
        if (geoFenceActivityVM != null && (mutableLiveData = ((BaseVM) geoFenceActivityVM).f33644a) != null && (value = mutableLiveData.getValue()) != null) {
            bindingTitleBean.setStatusBarHeight(value.intValue());
        }
        GeoFenceActivityVM geoFenceActivityVM2 = (GeoFenceActivityVM) ((BaseVmActivity) this).f8507a;
        MediatorLiveData<BindingTitleBean> mediatorLiveData = geoFenceActivityVM2 != null ? geoFenceActivityVM2.titleBean : null;
        if (mediatorLiveData == null) {
            return;
        }
        mediatorLiveData.setValue(bindingTitleBean);
    }

    public final void n0() {
        MutableLiveData<List<VideoInfoData>> mutableLiveDataH;
        GeoFenceActivityVM geoFenceActivityVM = (GeoFenceActivityVM) ((BaseVmActivity) this).f8507a;
        if (geoFenceActivityVM == null || (mutableLiveDataH = geoFenceActivityVM.h()) == null) {
            return;
        }
        mutableLiveDataH.observe(this, new c(new Function1<List<? extends VideoInfoData>, Unit>() { // from class: com.huachenjie.run.page.geofence.GeoFenceV2Activity$observeData$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<VideoInfoData>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<VideoInfoData> list) {
                this.this$0.k0(list);
            }
        }));
    }

    public final void o0(int position) {
        if (position <= 0) {
            return;
        }
        GuideFragmentAdapter guideFragmentAdapter = this.mPagerAdapter;
        Fragment item = guideFragmentAdapter != null ? guideFragmentAdapter.getItem(position) : null;
        if (item instanceof VideoGuideFragment) {
            ((VideoGuideFragment) item).pauseVideo();
        }
    }
}
