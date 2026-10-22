package com.huachenjie.run.page.activities_run;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.p002lifecycle.Lifecycle;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.e;
import com.huachenjie.common.base.SideTextInterface;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.common.bean.SunshineRunDetail;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.common.permission.RequiredSettingComponent;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.util.permission.PermissionResultListener;
import com.huachenjie.common.util.weimai_hh.SpanHonghuUtil;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RunPlanBean;
import com.huachenjie.run.component.ActivityFenceViewComponent;
import com.huachenjie.run.databinding.RunRunActivityActivityReadyBinding;
import com.huachenjie.run.page.activities_run.ActivityReadyActivity;
import com.huachenjie.run.page.free.FreeRunActivity;
import com.huachenjie.run.utils.StartRunUtils;
import com.kuaishou.weapon.p0.bo;
import com.zj.adlib.ai9;
import com.zj.adlib.en7;
import com.zj.adlib.jj8;
import com.zj.adlib.lj0;
import com.zj.adlib.lk0;
import com.zj.adlib.ll7;
import com.zj.adlib.vo6;
import com.zj.adlib.y6b;
import com.zj.adlib.zn1;
import huachenjie.sdk.map.adapter.location.callback.HCJLocationListener;
import huachenjie.sdk.map.adapter.map.HCJMap;
import huachenjie.sdk.map.adapter.map.HCJMapFragment;
import huachenjie.sdk.map.adapter.map.HCJMapView;
import huachenjie.sdk.map.adapter.map.adapter.HCJMapAdapter;
import huachenjie.sdk.map.adapter.map.callback.CaocaoOnMapLoadedListener;
import huachenjie.sdk.map.adapter.map.model.CaocaoCameraUpdate;
import huachenjie.sdk.map.adapter.map.model.CaocaoCameraUpdateFactory;
import huachenjie.sdk.map.adapter.map.model.CaocaoLatLngBounds;
import huachenjie.sdk.map.adapter.map.model.CaocaoPolygonOptions;
import huachenjie.sdk.map.adapter.map.model.CaocaoUiSettings;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import huachenjie.sdk.map.mapentry.HCJMapEntry;
import java.util.List;
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
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Route(path = RoutePathConstants.Run.r)
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u0006:\u00016B\u0007¢\u0006\u0004\bP\u0010QJ\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\u0012\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\fH\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0014\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0016J\u0012\u0010\u001f\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010!\u001a\u00020\u0011H\u0016J\n\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010$\u001a\u00020\u0014H\u0016J\b\u0010%\u001a\u00020\u0007H\u0016J\u001a\u0010)\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00142\b\u0010(\u001a\u0004\u0018\u00010'H\u0016R\u001b\u0010.\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001b\u00101\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010+\u001a\u0004\b0\u0010-R\u001b\u00105\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010+\u001a\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00107R\u0018\u0010<\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010>R\u001e\u0010C\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010BR\u0018\u0010F\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010ER\u0016\u0010H\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u00107R\u0018\u0010J\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010LR\u0018\u0010O\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010N¨\u0006R"}, d2 = {"Lcom/huachenjie/run/page/activities_run/ActivityReadyActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/run/databinding/RunRunActivityActivityReadyBinding;", "Lcom/huachenjie/run/page/activities_run/ActivityReadyVM;", "Lhuachenjie/sdk/map/adapter/map/callback/CaocaoOnMapLoadedListener;", "Lhuachenjie/sdk/map/adapter/location/callback/HCJLocationListener;", "Lcom/huachenjie/common/base/SideTextInterface;", "", "u0", "w0", "v0", "t0", "Lhuachenjie/sdk/map/adapter/map/model/CaocaoPolygonOptions;", "q0", "s0", "A0", "z0", "", "l0", "m0", "", "getLayoutResID", "", "", "V", "S", "W", "initView", "initData", "Landroid/widget/TextView;", "view", "q", "p", "s", "", "H", "C", "onMapLoaded", "code", "Lhuachenjie/sdk/map/lib_base/HCJAddressInfo;", "hcjAddressInfo", "onLocationListener", "b", "Lkotlin/Lazy;", "o0", "()Ljava/lang/String;", "activityCode", "c", bo.g, "activityFenceCode", "d", "r0", "()I", FreeRunActivity.y, "a", "Z", "hasMapLoaded", "hasDrawFence", "Lhuachenjie/sdk/map/adapter/map/adapter/HCJMapAdapter;", "Lhuachenjie/sdk/map/adapter/map/adapter/HCJMapAdapter;", "mMapAdapter", "Lhuachenjie/sdk/map/adapter/map/HCJMapFragment;", "Lhuachenjie/sdk/map/adapter/map/HCJMapFragment;", "mMapFragment", "Lcom/huachenjie/common/permission/RequiredSettingComponent;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/huachenjie/common/permission/RequiredSettingComponent;", "requiredSettingComponent", "Lcom/huachenjie/run/component/ActivityFenceViewComponent;", "Lcom/huachenjie/run/component/ActivityFenceViewComponent;", "mGeoFenceViewComponent", y6b.f, "hasStartLocation", "Lhuachenjie/sdk/map/lib_base/HCJAddressInfo;", "mAddressInfo", "Lcom/huachenjie/run/utils/StartRunUtils;", "Lcom/huachenjie/run/utils/StartRunUtils;", "startRunUtils", "Landroid/widget/TextView;", "sideTextView", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nActivityReadyActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityReadyActivity.kt\ncom/huachenjie/run/page/activities_run/ActivityReadyActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,339:1\n1855#2,2:340\n*S KotlinDebug\n*F\n+ 1 ActivityReadyActivity.kt\ncom/huachenjie/run/page/activities_run/ActivityReadyActivity\n*L\n263#1:340,2\n*E\n"})
public final class ActivityReadyActivity extends BaseMVVMActivity<RunRunActivityActivityReadyBinding, ActivityReadyVM> implements CaocaoOnMapLoadedListener, HCJLocationListener, SideTextInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public RequiredSettingComponent<AppCompatActivity> requiredSettingComponent;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public ActivityFenceViewComponent mGeoFenceViewComponent;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public StartRunUtils startRunUtils;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public HCJMapFragment mMapFragment;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public HCJMapAdapter mMapAdapter;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public HCJAddressInfo mAddressInfo;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean hasMapLoaded;

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    public boolean hasDrawFence;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public boolean hasStartLocation;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @Nullable
    public TextView sideTextView;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy activityCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.run.page.activities_run.ActivityReadyActivity$activityCode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra(UserConstants.RUN_PARAMS.f33735a);
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy activityFenceCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.run.page.activities_run.ActivityReadyActivity$activityFenceCode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra(UserConstants.RUN_PARAMS.b);
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy targetDistance = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.run.page.activities_run.ActivityReadyActivity$targetDistance$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m633invoke() {
            return Integer.valueOf(this.this$0.getIntent().getIntExtra(UserConstants.RUN_PARAMS.c, 0));
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/run/page/activities_run/ActivityReadyActivity$a;", "", "Landroid/view/View;", "v", "", "a", "<init>", "(Lcom/huachenjie/run/page/activities_run/ActivityReadyActivity;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@Nullable View v) {
            StartRunUtils startRunUtils;
            if (ActivityReadyActivity.g0(ActivityReadyActivity.this).i(6) || (startRunUtils = ActivityReadyActivity.this.startRunUtils) == null) {
                return;
            }
            int iR0 = ActivityReadyActivity.this.r0();
            int iR1 = ActivityReadyActivity.this.r0();
            String strO0 = ActivityReadyActivity.this.o0();
            SunshineRunDetail value = ActivityReadyActivity.g0(ActivityReadyActivity.this).n().getValue();
            Intrinsics.checkNotNull(value);
            SunshineRunDetail sunshineRunDetail = value;
            List<GeoFenceDetail> value2 = ActivityReadyActivity.g0(ActivityReadyActivity.this).l().getValue();
            RunPlanBean value3 = ActivityReadyActivity.g0(ActivityReadyActivity.this).k().getValue();
            startRunUtils.l0(6, 1, iR0, iR1, strO0, sunshineRunDetail, value2, value3 != null ? value3.getRunPlanCode() : null, false);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35770a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35770a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35770a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35770a.invoke(obj);
        }
    }

    public static final /* synthetic */ ActivityReadyVM g0(ActivityReadyActivity activityReadyActivity) {
        return activityReadyActivity.getMViewModel();
    }

    public static final void n0(ActivityReadyActivity activityReadyActivity, boolean z) {
        Intrinsics.checkNotNullParameter(activityReadyActivity, "this$0");
        if (z) {
            activityReadyActivity.hasStartLocation = true;
            lj0.n(activityReadyActivity, 3000L, activityReadyActivity, null, false, 24, null);
        }
    }

    public static final void x0(ActivityReadyActivity activityReadyActivity, View view) {
        Intrinsics.checkNotNullParameter(activityReadyActivity, "this$0");
        activityReadyActivity.finish();
    }

    public static final void y0(ActivityReadyActivity activityReadyActivity, float f) {
        Intrinsics.checkNotNullParameter(activityReadyActivity, "this$0");
        HCJMapFragment hCJMapFragment = activityReadyActivity.mMapFragment;
        if (hCJMapFragment != null) {
            hCJMapFragment.showMyLocationMarker(f);
        }
    }

    public final void A0() {
        CaocaoLatLngBounds caocaoLatLngBoundsBuild;
        HCJMapFragment hCJMapFragment;
        HCJMap map;
        CaocaoCameraUpdateFactory caocaoCameraUpdateFactoryCreateCameraUpdateFactoryOption;
        List<HCJLatLng> fenceList;
        HCJMapAdapter hCJMapAdapter = this.mMapAdapter;
        CaocaoCameraUpdate caocaoCameraUpdateNewLatLngBounds = null;
        CaocaoLatLngBounds.Builder builderCreateLatLngBoundsBuilder = hCJMapAdapter != null ? hCJMapAdapter.createLatLngBoundsBuilder() : null;
        GeoFenceDetail value = getMViewModel().w().getValue();
        if (value != null && (fenceList = value.getFenceList()) != null) {
            for (HCJLatLng hCJLatLng : fenceList) {
                if (builderCreateLatLngBoundsBuilder != null) {
                    builderCreateLatLngBoundsBuilder.include(hCJLatLng);
                }
            }
        }
        HCJAddressInfo hCJAddressInfo = this.mAddressInfo;
        if (hCJAddressInfo != null && builderCreateLatLngBoundsBuilder != null) {
            builderCreateLatLngBoundsBuilder.include(new HCJLatLng(hCJAddressInfo.getLat(), hCJAddressInfo.getLng()));
        }
        if (builderCreateLatLngBoundsBuilder == null || (caocaoLatLngBoundsBuild = builderCreateLatLngBoundsBuilder.build()) == null || (hCJMapFragment = this.mMapFragment) == null || (map = hCJMapFragment.getMap()) == null) {
            return;
        }
        HCJMapAdapter hCJMapAdapter2 = this.mMapAdapter;
        if (hCJMapAdapter2 != null && (caocaoCameraUpdateFactoryCreateCameraUpdateFactoryOption = hCJMapAdapter2.createCameraUpdateFactoryOption()) != null) {
            caocaoCameraUpdateNewLatLngBounds = caocaoCameraUpdateFactoryCreateCameraUpdateFactoryOption.newLatLngBounds(caocaoLatLngBoundsBuild, 0);
        }
        map.moveCamera(caocaoCameraUpdateNewLatLngBounds);
    }

    @Override // com.huachenjie.common.base.SideTextInterface
    public int C() {
        return -1;
    }

    @Override // com.huachenjie.common.base.SideTextInterface
    @Nullable
    public String H() {
        return null;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseActivity
    public void S() {
        e.p3(this).G2(R.color.transparent).T2(false).k3().G1(false).a1();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(lk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(lk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().w().observe(this, new b(new Function1<GeoFenceDetail, Unit>() { // from class: com.huachenjie.run.page.activities_run.ActivityReadyActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GeoFenceDetail) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable GeoFenceDetail geoFenceDetail) {
                this.this$0.z0();
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_run_activity_activity_ready;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        ActivityReadyVM mViewModel = getMViewModel();
        String strP0 = p0();
        Intrinsics.checkNotNullExpressionValue(strP0, "activityFenceCode");
        mViewModel.z(strP0);
        m0();
        getMViewModel().s(ai9.e().getSchoolCode());
        getMViewModel().r(6);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        u0();
        w0();
        v0();
        t0();
        s0();
    }

    public final boolean l0() {
        if (vo6.a(this)) {
            return true;
        }
        RequiredSettingComponent<AppCompatActivity> requiredSettingComponent = this.requiredSettingComponent;
        if (requiredSettingComponent == null) {
            return false;
        }
        requiredSettingComponent.d(1);
        return false;
    }

    public final void m0() {
        if (l0()) {
            en7.c(this, new PermissionResultListener() { // from class: com.zj.adlib.vt
                @Override // com.huachenjie.common.util.permission.PermissionResultListener
                public final void onResult(boolean z) {
                    ActivityReadyActivity.n0(this.f45452a, z);
                }
            });
        }
    }

    public final String o0() {
        return (String) this.activityCode.getValue();
    }

    public void onLocationListener(int code, @Nullable HCJAddressInfo hcjAddressInfo) {
        if (hcjAddressInfo == null || code != 0) {
            return;
        }
        boolean z = this.mAddressInfo == null;
        this.mAddressInfo = hcjAddressInfo;
        HCJMapFragment hCJMapFragment = this.mMapFragment;
        if (hCJMapFragment != null) {
            hCJMapFragment.showMyLocationMarker(new HCJLatLng(hcjAddressInfo.getLat(), hcjAddressInfo.getLng()), -hcjAddressInfo.getDirection(), false);
        }
        if (z) {
            A0();
        }
    }

    public void onMapLoaded() {
        HCJMapView mapView;
        HCJMap map;
        CaocaoUiSettings uiSettings;
        HCJMapView mapView2;
        HCJMap map2;
        CaocaoUiSettings uiSettings2;
        HCJMapView mapView3;
        HCJMap map3;
        CaocaoUiSettings uiSettings3;
        HCJMapFragment hCJMapFragment = this.mMapFragment;
        Intrinsics.checkNotNull(hCJMapFragment);
        ActivityFenceViewComponent activityFenceViewComponent = new ActivityFenceViewComponent(hCJMapFragment.getMap());
        this.mGeoFenceViewComponent = activityFenceViewComponent;
        activityFenceViewComponent.e(q0());
        Lifecycle lifecycle = getLifecycle();
        ActivityFenceViewComponent activityFenceViewComponent2 = this.mGeoFenceViewComponent;
        Intrinsics.checkNotNull(activityFenceViewComponent2);
        lifecycle.addObserver(activityFenceViewComponent2);
        HCJMapFragment hCJMapFragment2 = this.mMapFragment;
        if (hCJMapFragment2 != null) {
            hCJMapFragment2.setOnOritationChangeListener(new HCJMapFragment.OrientationChangeListener() { // from class: com.zj.adlib.ut
                public final void onOrientationChange(float f) {
                    ActivityReadyActivity.y0(this.f45225a, f);
                }
            });
        }
        HCJMapFragment hCJMapFragment3 = this.mMapFragment;
        if (hCJMapFragment3 != null && (mapView3 = hCJMapFragment3.getMapView()) != null && (map3 = mapView3.getMap()) != null && (uiSettings3 = map3.getUiSettings()) != null) {
            uiSettings3.setZoomGesturesEnabled(true);
        }
        HCJMapFragment hCJMapFragment4 = this.mMapFragment;
        if (hCJMapFragment4 != null && (mapView2 = hCJMapFragment4.getMapView()) != null && (map2 = mapView2.getMap()) != null && (uiSettings2 = map2.getUiSettings()) != null) {
            uiSettings2.setScrollGesturesEnabled(true);
        }
        HCJMapFragment hCJMapFragment5 = this.mMapFragment;
        if (hCJMapFragment5 != null && (mapView = hCJMapFragment5.getMapView()) != null && (map = mapView.getMap()) != null && (uiSettings = map.getUiSettings()) != null) {
            uiSettings.setRotateGesturesEnabled(true);
        }
        this.hasMapLoaded = true;
        z0();
    }

    @Override // com.huachenjie.common.base.SideTextInterface
    @Nullable
    /* JADX INFO: renamed from: p, reason: from getter */
    public TextView getSideTextView() {
        return this.sideTextView;
    }

    public final String p0() {
        return (String) this.activityFenceCode.getValue();
    }

    @Override // com.huachenjie.common.base.SideTextInterface
    public void q(@Nullable TextView view) {
        this.sideTextView = view;
    }

    public final CaocaoPolygonOptions<?, ?> q0() {
        CaocaoPolygonOptions<?, ?> caocaoPolygonOptionsCreatePolygonOptions2;
        HCJMapAdapter hCJMapAdapter = this.mMapAdapter;
        if (hCJMapAdapter == null || (caocaoPolygonOptionsCreatePolygonOptions2 = hCJMapAdapter.createPolygonOptions2()) == null) {
            return null;
        }
        caocaoPolygonOptionsCreatePolygonOptions2.fillColor(zn1.a(R.color.percent_6_139aff));
        caocaoPolygonOptionsCreatePolygonOptions2.strokeColor(zn1.a(R.color.color_main_v2));
        caocaoPolygonOptionsCreatePolygonOptions2.strokeWidth(jj8.a(2.0f) + 0.1f);
        return caocaoPolygonOptionsCreatePolygonOptions2;
    }

    public final int r0() {
        return ((Number) this.targetDistance.getValue()).intValue();
    }

    @Override // com.huachenjie.common.base.SideTextInterface
    public boolean s() {
        return true;
    }

    public final void s0() {
        this.requiredSettingComponent = new RequiredSettingComponent<>(this);
        Lifecycle lifecycle = getLifecycle();
        RequiredSettingComponent<AppCompatActivity> requiredSettingComponent = this.requiredSettingComponent;
        Intrinsics.checkNotNull(requiredSettingComponent);
        lifecycle.addObserver(requiredSettingComponent);
    }

    public final void t0() {
        HCJMapAdapter hCJMapEntry = HCJMapEntry.getInstance();
        this.mMapAdapter = hCJMapEntry;
        HCJMapFragment hCJMapFragmentCreateMapFragment = hCJMapEntry != null ? hCJMapEntry.createMapFragment() : null;
        this.mMapFragment = hCJMapFragmentCreateMapFragment;
        if (hCJMapFragmentCreateMapFragment != null) {
            hCJMapFragmentCreateMapFragment.addOnMapLoadedListener(this);
        }
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        int i = R.id.fl_map_container;
        HCJMapFragment hCJMapFragment = this.mMapFragment;
        Intrinsics.checkNotNull(hCJMapFragment);
        fragmentTransactionBeginTransaction.replace(i, hCJMapFragment).commit();
        HCJMapFragment hCJMapFragment2 = this.mMapFragment;
        if (hCJMapFragment2 != null) {
            hCJMapFragment2.setMyLocationMarkerRes(R.drawable.run_ic_my_location);
        }
        HCJMapFragment hCJMapFragment3 = this.mMapFragment;
        if (hCJMapFragment3 != null) {
            hCJMapFragment3.setMyLocationEnable(Boolean.TRUE);
        }
    }

    public final void u0() {
        this.startRunUtils = new ActivityReadyActivity$initStartRunUtils$1(this, getMViewModel());
    }

    public final void v0() {
        SpanHonghuUtil.a().a("目标里程 ", 18).a(ll7.f43096a.d(Integer.valueOf(r0())), 36).a(" km", 18).v0(getMBinding().f12260a);
    }

    public final void w0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataY = getMViewModel().y();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataY.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setTitleName("开始跑步").setBackground(zn1.o("#B35478CF")).setBackIconResId(R.drawable.ic_back_white).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.wt
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActivityReadyActivity.x0(this.f45685a, view);
            }
        }));
    }

    public final void z0() {
        if (this.hasDrawFence || !this.hasMapLoaded || getMViewModel().w().getValue() == null) {
            return;
        }
        this.hasDrawFence = true;
        ActivityFenceViewComponent activityFenceViewComponent = this.mGeoFenceViewComponent;
        if (activityFenceViewComponent != null) {
            GeoFenceDetail value = getMViewModel().w().getValue();
            Intrinsics.checkNotNull(value);
            activityFenceViewComponent.c(value);
        }
        A0();
    }
}
