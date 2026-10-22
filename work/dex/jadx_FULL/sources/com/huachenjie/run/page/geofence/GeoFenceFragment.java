package com.huachenjie.run.page.geofence;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.video.AudioStats;
import androidx.coroutines.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.p002lifecycle.Observer;
import com.blankj.utilcode.util.ToastUtils;
import com.huachenjie.base.util.CustomerServiceUtil;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVMFragment;
import com.huachenjie.common.bean.ClockMode;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.common.bean.NewOpenTimesBean;
import com.huachenjie.common.map.GeoFenceComponent;
import com.huachenjie.common.permission.RequiredSettingComponent;
import com.huachenjie.common.util.permission.PermissionResultListener;
import com.huachenjie.common.util.weimai_hh.SpanHonghuUtil;
import com.huachenjie.common.widget.CustomizeViewDialog;
import com.huachenjie.run.R;
import com.huachenjie.run.databinding.RunFragmentGeoFenceV3Binding;
import com.huachenjie.run.dialog.AllFenceListDialog;
import com.huachenjie.run.dialog.FenceOpenTimeListDialog;
import com.huachenjie.run.page.geofence.GeoFenceFragment;
import com.igexin.push.g.o;
import com.zj.adlib.fv5;
import com.zj.adlib.i4a;
import com.zj.adlib.i62;
import com.zj.adlib.jj8;
import com.zj.adlib.lj0;
import com.zj.adlib.lk0;
import com.zj.adlib.r90;
import com.zj.adlib.si0;
import com.zj.adlib.vo6;
import com.zj.adlib.zn1;
import huachenjie.sdk.map.adapter.location.callback.HCJLocationListener;
import huachenjie.sdk.map.adapter.map.HCJMap;
import huachenjie.sdk.map.adapter.map.HCJMapFragment;
import huachenjie.sdk.map.adapter.map.adapter.HCJMapAdapter;
import huachenjie.sdk.map.adapter.map.callback.CaocaoOnMapLoadedListener;
import huachenjie.sdk.map.adapter.map.model.CaocaoCameraUpdateFactory;
import huachenjie.sdk.map.adapter.map.model.CaocaoLatLngBounds;
import huachenjie.sdk.map.adapter.map.model.CaocaoPolygonOptions;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import huachenjie.sdk.map.mapentry.HCJMapEntry;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 C2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0003DEFB\u0007¢\u0006\u0004\bA\u0010BJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0014J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\u0012\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u001b\u001a\u00020\u0005H\u0014J\b\u0010\u001c\u001a\u00020\u0005H\u0014J\b\u0010\u001d\u001a\u00020\u0005H\u0014J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\u0005H\u0004J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\u0006\u0010&\u001a\u00020\u0005R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00101\u001a\b\u0012\u0002\b\u0003\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u001e\u00108\u001a\n\u0012\u0004\u0012\u000207\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010;\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u001c\u0010@\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030=8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?¨\u0006G"}, d2 = {"Lcom/huachenjie/run/page/geofence/GeoFenceFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVMFragment;", "Lcom/huachenjie/run/page/geofence/GeoFenceV2VM;", "Lhuachenjie/sdk/map/adapter/map/callback/CaocaoOnMapLoadedListener;", "Lhuachenjie/sdk/map/adapter/map/HCJMapFragment$OrientationChangeListener;", "", "initMap", "observeData", "Lcom/huachenjie/common/bean/GeoFenceDetail;", "geoFenceDetail", "changeGeoFence", "detail", "showFenceAndMyPosition", "animateCamera", "Lhuachenjie/sdk/map/lib_base/HCJAddressInfo;", "my", "onLocationSuccess", "checkLocationRight", "startLocation", "stopLocation", "showFenListDialog", "initViewModel", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "init", "initDataAfterView", "onUserVisible", "onUserInvisible", "onStart", "onStop", "onDestroy", "initField", "", "bearing", "onOrientationChange", "onMapLoaded", "initComponent", "Lhuachenjie/sdk/map/adapter/map/HCJMapFragment;", "mMapFragment", "Lhuachenjie/sdk/map/adapter/map/HCJMapFragment;", "Lhuachenjie/sdk/map/adapter/map/adapter/HCJMapAdapter;", "mMapAdapter", "Lhuachenjie/sdk/map/adapter/map/adapter/HCJMapAdapter;", "Lhuachenjie/sdk/map/adapter/location/callback/HCJLocationListener;", "mLocationListener", "Lhuachenjie/sdk/map/adapter/location/callback/HCJLocationListener;", "Lcom/huachenjie/common/map/GeoFenceComponent;", "geoFenceComponent", "Lcom/huachenjie/common/map/GeoFenceComponent;", "", "onMapInited", "Z", "Lcom/huachenjie/common/permission/RequiredSettingComponent;", "Landroidx/appcompat/app/AppCompatActivity;", "requiredSettingComponent", "Lcom/huachenjie/common/permission/RequiredSettingComponent;", "Lcom/huachenjie/run/dialog/AllFenceListDialog;", "mFenListDialog", "Lcom/huachenjie/run/dialog/AllFenceListDialog;", "Lhuachenjie/sdk/map/adapter/map/model/CaocaoPolygonOptions;", "getPolygonOptions", "()Lhuachenjie/sdk/map/adapter/map/model/CaocaoPolygonOptions;", "polygonOptions", "<init>", "()V", "Companion", "a", "b", "c", "run_release"}, k = 1, mv = {1, 8, 0})
public final class GeoFenceFragment extends BaseVMFragment<GeoFenceV2VM> implements CaocaoOnMapLoadedListener, HCJMapFragment.OrientationChangeListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private GeoFenceComponent<?> geoFenceComponent;

    @Nullable
    private AllFenceListDialog mFenListDialog;

    @Nullable
    private HCJLocationListener mLocationListener;

    @Nullable
    private HCJMapAdapter mMapAdapter;

    @Nullable
    private HCJMapFragment mMapFragment;
    private boolean onMapInited;

    @Nullable
    private RequiredSettingComponent<AppCompatActivity> requiredSettingComponent;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\f"}, d2 = {"Lcom/huachenjie/run/page/geofence/GeoFenceFragment$a;", "", "Landroid/view/View;", "v", "", "a", "c", "d", "b", "e", "<init>", "(Lcom/huachenjie/run/page/geofence/GeoFenceFragment;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class a {

        /* JADX INFO: renamed from: com.huachenjie.run.page.geofence.GeoFenceFragment$a$a, reason: collision with other inner class name */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class C0821a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f35872a;

            static {
                int[] iArr = new int[ClockMode.values().length];
                try {
                    iArr[ClockMode.Free.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ClockMode.Order.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ClockMode.Random.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f35872a = iArr;
            }
        }

        public a() {
        }

        public final void a(@Nullable View v) {
            FragmentActivity activity = GeoFenceFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }

        public final void b(@Nullable View v) {
            FragmentActivity activity;
            BaseVM baseVM = ((BaseVMFragment) GeoFenceFragment.this).mState;
            Intrinsics.checkNotNull(baseVM);
            ClockMode value = ((GeoFenceV2VM) baseVM).clockMode.getValue();
            if (value == null || (activity = GeoFenceFragment.this.getActivity()) == null) {
                return;
            }
            int i = C0821a.f35872a[value.ordinal()];
            if (i == 1) {
                RunModeGuideActivity.INSTANCE.a(activity, RunModeGuideActivity.x);
            } else if (i == 2) {
                RunModeGuideActivity.INSTANCE.a(activity, RunModeGuideActivity.z);
            } else {
                if (i != 3) {
                    return;
                }
                RunModeGuideActivity.INSTANCE.a(activity, RunModeGuideActivity.y);
            }
        }

        public final void c(@Nullable View v) {
            if (si0.b()) {
                CustomerServiceUtil.f32958a.f(GeoFenceFragment.this);
            }
        }

        public final void d(@Nullable View v) {
            if (si0.a()) {
                return;
            }
            GeoFenceFragment.this.showFenListDialog();
        }

        public final void e(@Nullable View v) {
            GeoFenceDetail value = ((GeoFenceV2VM) ((BaseVMFragment) GeoFenceFragment.this).mState).mGeoFenceDetail.getValue();
            if (value != null) {
                GeoFenceFragment geoFenceFragment = GeoFenceFragment.this;
                FenceOpenTimeListDialog.Companion companion = FenceOpenTimeListDialog.INSTANCE;
                ArrayList<NewOpenTimesBean> newOpenTimes = value.getNewOpenTimes();
                Intrinsics.checkNotNullExpressionValue(newOpenTimes, "it.newOpenTimes");
                companion.a(newOpenTimes).show(geoFenceFragment.getParentFragmentManager(), "FENCE_OPEN_TIME_LIST_DIALOG");
            }
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.run.page.geofence.GeoFenceFragment$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0006"}, d2 = {"Lcom/huachenjie/run/page/geofence/GeoFenceFragment$b;", "", "Lcom/huachenjie/run/page/geofence/GeoFenceFragment;", "a", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GeoFenceFragment a() {
            GeoFenceFragment geoFenceFragment = new GeoFenceFragment();
            geoFenceFragment.setArguments(new Bundle());
            return geoFenceFragment;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/run/page/geofence/GeoFenceFragment$c;", "Lhuachenjie/sdk/map/adapter/location/callback/HCJLocationListener;", "", "code", "Lhuachenjie/sdk/map/lib_base/HCJAddressInfo;", "hcjAddressInfo", "", "onLocationListener", "Ljava/lang/ref/WeakReference;", "Lcom/huachenjie/run/page/geofence/GeoFenceFragment;", "a", "Ljava/lang/ref/WeakReference;", "weakReference", "fragment", "<init>", "(Lcom/huachenjie/run/page/geofence/GeoFenceFragment;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements HCJLocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        public WeakReference<GeoFenceFragment> weakReference;

        public c(@NotNull GeoFenceFragment geoFenceFragment) {
            Intrinsics.checkNotNullParameter(geoFenceFragment, "fragment");
            this.weakReference = new WeakReference<>(geoFenceFragment);
        }

        public void onLocationListener(int code, @Nullable HCJAddressInfo hcjAddressInfo) {
            WeakReference<GeoFenceFragment> weakReference = this.weakReference;
            if (weakReference == null) {
                return;
            }
            GeoFenceFragment geoFenceFragment = weakReference != null ? weakReference.get() : null;
            if (geoFenceFragment == null || geoFenceFragment.isDetached()) {
                return;
            }
            if (code != 0 || hcjAddressInfo == null) {
                ToastUtils.W("您的位置定位失败!!", new Object[0]);
            } else {
                r90.k0(hcjAddressInfo);
                geoFenceFragment.onLocationSuccess(hcjAddressInfo);
            }
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class d implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35874a;

        public d(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35874a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35874a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35874a.invoke(obj);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/run/page/geofence/GeoFenceFragment$e", "Lcom/huachenjie/run/dialog/AllFenceListDialog$OnSureCallback;", "", "any", "", "a", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class e implements AllFenceListDialog.OnSureCallback {
        public e() {
        }

        @Override // com.huachenjie.run.dialog.AllFenceListDialog.OnSureCallback
        public void a(@Nullable Object any) {
            if (any instanceof GeoFenceDetail) {
                ((GeoFenceV2VM) ((BaseVMFragment) GeoFenceFragment.this).mState).mGeoFenceDetail.setValue(any);
            } else {
                i4a.c("您没做任何选择");
            }
        }
    }

    private final void animateCamera() {
        HCJMapFragment hCJMapFragment;
        HCJMap map;
        CaocaoCameraUpdateFactory caocaoCameraUpdateFactoryCreateCameraUpdateFactoryOption;
        HCJMapFragment hCJMapFragment2 = this.mMapFragment;
        Intrinsics.checkNotNull(hCJMapFragment2);
        if (hCJMapFragment2.getMap() == null) {
            return;
        }
        HCJMapAdapter hCJMapAdapter = this.mMapAdapter;
        Intrinsics.checkNotNull(hCJMapAdapter);
        CaocaoLatLngBounds.Builder builderCreateLatLngBoundsBuilder = hCJMapAdapter.createLatLngBoundsBuilder();
        GeoFenceDetail value = ((GeoFenceV2VM) ((BaseVMFragment) this).mState).mGeoFenceDetail.getValue();
        if (value != null) {
            Iterator<HCJLatLng> it = value.getFenceList().iterator();
            while (it.hasNext()) {
                builderCreateLatLngBoundsBuilder.include(it.next());
            }
        } else {
            HCJAddressInfo hCJAddressInfoO = r90.o();
            if (hCJAddressInfoO != null) {
                double lat = hCJAddressInfoO.getLat();
                if ((Double.isInfinite(lat) || Double.isNaN(lat)) ? false : true) {
                    builderCreateLatLngBoundsBuilder.include(new HCJLatLng(hCJAddressInfoO.getLat(), hCJAddressInfoO.getLng()));
                }
            }
        }
        CaocaoLatLngBounds caocaoLatLngBoundsBuild = builderCreateLatLngBoundsBuilder.build();
        if (caocaoLatLngBoundsBuild == null || (hCJMapFragment = this.mMapFragment) == null || (map = hCJMapFragment.getMap()) == null) {
            return;
        }
        HCJMapAdapter hCJMapAdapter2 = this.mMapAdapter;
        map.animateCamera((hCJMapAdapter2 == null || (caocaoCameraUpdateFactoryCreateCameraUpdateFactoryOption = hCJMapAdapter2.createCameraUpdateFactoryOption()) == null) ? null : caocaoCameraUpdateFactoryCreateCameraUpdateFactoryOption.newLatLngBounds(caocaoLatLngBoundsBuild, jj8.a(50.0f)));
    }

    private final void changeGeoFence(GeoFenceDetail geoFenceDetail) {
        if (geoFenceDetail != null) {
            GeoFenceComponent<?> geoFenceComponent = this.geoFenceComponent;
            if (geoFenceComponent != null) {
                geoFenceComponent.j();
            }
            HashMap map = new HashMap();
            String fenceCode = geoFenceDetail.getFenceCode();
            Intrinsics.checkNotNullExpressionValue(fenceCode, "geoFenceDetail.fenceCode");
            map.put(fenceCode, geoFenceDetail);
            GeoFenceComponent<?> geoFenceComponent2 = this.geoFenceComponent;
            if (geoFenceComponent2 != null) {
                geoFenceComponent2.p(map);
            }
            GeoFenceComponent<?> geoFenceComponent3 = this.geoFenceComponent;
            if (geoFenceComponent3 != null) {
                geoFenceComponent3.z(getPolygonOptions());
            }
            GeoFenceComponent<?> geoFenceComponent4 = this.geoFenceComponent;
            if (geoFenceComponent4 != null) {
                geoFenceComponent4.i();
            }
        }
        animateCamera();
    }

    private final void checkLocationRight() {
        AppCompatActivity appCompatActivity = this.mActivity;
        Intrinsics.checkNotNullExpressionValue(appCompatActivity, "mActivity");
        if (vo6.a(appCompatActivity)) {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            vo6.j(contextRequireContext, "android.permission.ACCESS_FINE_LOCATION", "为了获取您的位置并根据您的位置显示跑步区域，我们需要访问您的准确位置权限", new PermissionResultListener() { // from class: com.zj.adlib.qt3
                @Override // com.huachenjie.common.util.permission.PermissionResultListener
                public final void onResult(boolean z) {
                    GeoFenceFragment.checkLocationRight$lambda$4(this.f44295a, z);
                }
            });
        } else {
            RequiredSettingComponent<AppCompatActivity> requiredSettingComponent = this.requiredSettingComponent;
            if (requiredSettingComponent != null) {
                requiredSettingComponent.d(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkLocationRight$lambda$4(GeoFenceFragment geoFenceFragment, boolean z) {
        Intrinsics.checkNotNullParameter(geoFenceFragment, "this$0");
        if (z) {
            geoFenceFragment.startLocation();
        } else {
            fv5.b("无定位权限，您的位置无法显示!");
        }
    }

    private final CaocaoPolygonOptions<?, ?> getPolygonOptions() {
        HCJMapAdapter hCJMapAdapter = this.mMapAdapter;
        Intrinsics.checkNotNull(hCJMapAdapter);
        CaocaoPolygonOptions<?, ?> caocaoPolygonOptionsCreatePolygonOptions2 = hCJMapAdapter.createPolygonOptions2();
        caocaoPolygonOptionsCreatePolygonOptions2.fillColor(Color.parseColor("#1A0BD3FF"));
        caocaoPolygonOptionsCreatePolygonOptions2.strokeColor(Color.parseColor("#FF0BD3FF"));
        caocaoPolygonOptionsCreatePolygonOptions2.strokeWidth(jj8.a(2.0f));
        Intrinsics.checkNotNullExpressionValue(caocaoPolygonOptionsCreatePolygonOptions2, "polygonOption");
        return caocaoPolygonOptionsCreatePolygonOptions2;
    }

    private final void initMap() {
        FragmentManager supportFragmentManager;
        FragmentTransaction fragmentTransactionBeginTransaction;
        FragmentTransaction fragmentTransactionReplace;
        initField();
        HCJMapAdapter hCJMapAdapter = this.mMapAdapter;
        HCJMapFragment hCJMapFragmentCreateMapFragment = hCJMapAdapter != null ? hCJMapAdapter.createMapFragment() : null;
        this.mMapFragment = hCJMapFragmentCreateMapFragment;
        if (hCJMapFragmentCreateMapFragment != null) {
            hCJMapFragmentCreateMapFragment.addOnMapLoadedListener(this);
            FragmentActivity activity = getActivity();
            if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null && (fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction()) != null && (fragmentTransactionReplace = fragmentTransactionBeginTransaction.replace(R.id.fl_map_container, hCJMapFragmentCreateMapFragment)) != null) {
                fragmentTransactionReplace.commit();
            }
            hCJMapFragmentCreateMapFragment.setMyLocationMarkerRes(R.drawable.run_ic_my_location);
            hCJMapFragmentCreateMapFragment.setMyLocationEnable(Boolean.TRUE);
        }
    }

    private final void observeData() {
        ((GeoFenceV2VM) ((BaseVMFragment) this).mState).mGeoFenceDetail.observe(this, new d(new Function1<GeoFenceDetail, Unit>() { // from class: com.huachenjie.run.page.geofence.GeoFenceFragment.observeData.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GeoFenceDetail) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(GeoFenceDetail geoFenceDetail) {
                GeoFenceFragment.this.showFenceAndMyPosition(geoFenceDetail);
            }
        }));
        ((GeoFenceV2VM) ((BaseVMFragment) this).mState).i().observe(this, new d(new Function1<List<? extends GeoFenceDetail>, Unit>() { // from class: com.huachenjie.run.page.geofence.GeoFenceFragment.observeData.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<? extends GeoFenceDetail>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable List<? extends GeoFenceDetail> list) {
                ViewDataBinding binding = GeoFenceFragment.this.getBinding();
                Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.run.databinding.RunFragmentGeoFenceV3Binding");
                RunFragmentGeoFenceV3Binding runFragmentGeoFenceV3Binding = (RunFragmentGeoFenceV3Binding) binding;
                if (list == null || list.isEmpty()) {
                    SpanHonghuUtil.a().h("学校暂未设置可用的跑步区域。").v0(runFragmentGeoFenceV3Binding.f11838a.f12146a);
                    runFragmentGeoFenceV3Binding.f11836a.setVisibility(4);
                    return;
                }
                SpanHonghuUtil.SpanBuilder spanBuilderH = SpanHonghuUtil.a().h("由学校规定的有效跑步区域，\n").d("跑步必须在区域内进行", zn1.a(R.color.hcj_vip_txt_color)).h("。");
                ViewDataBinding binding2 = GeoFenceFragment.this.getBinding();
                Intrinsics.checkNotNull(binding2, "null cannot be cast to non-null type com.huachenjie.run.databinding.RunFragmentGeoFenceV3Binding");
                spanBuilderH.v0(((RunFragmentGeoFenceV3Binding) binding2).f11838a.f12146a);
                runFragmentGeoFenceV3Binding.f11836a.setVisibility(0);
            }
        }));
        ((GeoFenceV2VM) ((BaseVMFragment) this).mState).f.observe(this, new d(new Function1<CustomizeViewDialog.Builder, Unit>() { // from class: com.huachenjie.run.page.geofence.GeoFenceFragment.observeData.3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((CustomizeViewDialog.Builder) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable CustomizeViewDialog.Builder builder) {
                FragmentActivity activity = GeoFenceFragment.this.getActivity();
                if (activity == null || builder == null) {
                    return;
                }
                builder.create(activity);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLocationSuccess(HCJAddressInfo my) {
        HCJMapFragment hCJMapFragment;
        if (my.getLat() == AudioStats.AUDIO_AMPLITUDE_NONE) {
            return;
        }
        if ((my.getLng() == AudioStats.AUDIO_AMPLITUDE_NONE) || (hCJMapFragment = this.mMapFragment) == null) {
            return;
        }
        hCJMapFragment.showMyLocationMarker(new HCJLatLng(my.getLat(), my.getLng()), my.getDirection(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showFenListDialog() {
        if (requireActivity() == null || requireActivity().isDestroyed() || requireActivity().isFinishing()) {
            return;
        }
        if (this.mFenListDialog == null) {
            this.mFenListDialog = AllFenceListDialog.INSTANCE.a(((GeoFenceV2VM) ((BaseVMFragment) this).mState).i().getValue(), new e());
        }
        FragmentManager parentFragmentManager = getParentFragmentManager();
        AllFenceListDialog allFenceListDialog = this.mFenListDialog;
        if (allFenceListDialog != null) {
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, o.f);
            allFenceListDialog.show(parentFragmentManager, "mFenListDialog", ((GeoFenceV2VM) ((BaseVMFragment) this).mState).mGeoFenceDetail.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showFenceAndMyPosition(GeoFenceDetail detail) {
        if (this.onMapInited && detail != null) {
            changeGeoFence(detail);
        }
    }

    private final void startLocation() {
        if (this.mLocationListener == null) {
            this.mLocationListener = new c(this);
        }
        AppCompatActivity appCompatActivity = this.mActivity;
        Intrinsics.checkNotNullExpressionValue(appCompatActivity, "mActivity");
        HCJLocationListener hCJLocationListener = this.mLocationListener;
        Intrinsics.checkNotNull(hCJLocationListener);
        lj0.p(appCompatActivity, false, null, hCJLocationListener, 6, null);
    }

    private final void stopLocation() {
        AppCompatActivity appCompatActivity = this.mActivity;
        Intrinsics.checkNotNullExpressionValue(appCompatActivity, "mActivity");
        lj0.t(appCompatActivity, false, 2, null);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.run_fragment_geo_fence_v3), Integer.valueOf(lk0.L), ((BaseVMFragment) this).mState).a(Integer.valueOf(lk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void init(@Nullable Bundle savedInstanceState) {
        initComponent();
        ((GeoFenceV2VM) ((BaseVMFragment) this).mState).l();
    }

    public final void initComponent() {
        RequiredSettingComponent<AppCompatActivity> requiredSettingComponent = new RequiredSettingComponent<>(this.mActivity);
        this.requiredSettingComponent = requiredSettingComponent;
        getLifecycle().addObserver(requiredSettingComponent);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initDataAfterView() {
        initMap();
    }

    public final void initField() {
        this.mMapAdapter = HCJMapEntry.getInstance();
        GeoFenceComponent<?> geoFenceComponent = new GeoFenceComponent<>(this);
        this.geoFenceComponent = geoFenceComponent;
        getLifecycle().addObserver(geoFenceComponent);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initViewModel() {
        observeData();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stopLocation();
        this.mLocationListener = null;
        HCJMapFragment hCJMapFragment = this.mMapFragment;
        if (hCJMapFragment != null) {
            hCJMapFragment.clear(false);
        }
    }

    public void onMapLoaded() {
        HCJMapFragment hCJMapFragment = this.mMapFragment;
        if (hCJMapFragment != null) {
            hCJMapFragment.setOnOritationChangeListener(this);
        }
        GeoFenceComponent<?> geoFenceComponent = this.geoFenceComponent;
        if (geoFenceComponent != null) {
            HCJMapFragment hCJMapFragment2 = this.mMapFragment;
            geoFenceComponent.y(hCJMapFragment2 != null ? hCJMapFragment2.getMap() : null);
        }
        GeoFenceComponent<?> geoFenceComponent2 = this.geoFenceComponent;
        if (geoFenceComponent2 != null) {
            geoFenceComponent2.s();
        }
        this.onMapInited = true;
        showFenceAndMyPosition(((GeoFenceV2VM) ((BaseVMFragment) this).mState).mGeoFenceDetail.getValue());
        checkLocationRight();
    }

    public void onOrientationChange(float bearing) {
        HCJMapFragment hCJMapFragment;
        HCJMapFragment hCJMapFragment2 = this.mMapFragment;
        if ((hCJMapFragment2 != null ? hCJMapFragment2.getMap() : null) == null || (hCJMapFragment = this.mMapFragment) == null) {
            return;
        }
        hCJMapFragment.showMyLocationMarker(bearing);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        HCJMapFragment hCJMapFragment = this.mMapFragment;
        if (hCJMapFragment != null) {
            hCJMapFragment.startOritationSensor(true);
        }
        HCJMapFragment hCJMapFragment2 = this.mMapFragment;
        if (hCJMapFragment2 != null) {
            hCJMapFragment2.onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        HCJMapFragment hCJMapFragment = this.mMapFragment;
        if (hCJMapFragment != null) {
            hCJMapFragment.startOritationSensor(false);
        }
        HCJMapFragment hCJMapFragment2 = this.mMapFragment;
        if (hCJMapFragment2 != null) {
            hCJMapFragment2.onStop();
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void onUserInvisible() {
        super.onUserInvisible();
        HCJMapFragment hCJMapFragment = this.mMapFragment;
        if (hCJMapFragment != null) {
            hCJMapFragment.onPause();
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void onUserVisible() {
        HCJMapFragment hCJMapFragment;
        super.onUserVisible();
        i4a.b("VideoGuideFragment", "onFragmentResume() called 已重启动");
        HCJMapFragment hCJMapFragment2 = this.mMapFragment;
        if (hCJMapFragment2 == null || hCJMapFragment2.getMapView() == null || (hCJMapFragment = this.mMapFragment) == null) {
            return;
        }
        hCJMapFragment.onResume();
    }
}
