package com.huachenjie.sport.page.mine.attendance.range;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coroutines.ViewDataBinding;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.LocationRangeBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.sport.R;
import com.huachenjie.sport.databinding.ActivityAttendanceRangeBinding;
import com.huachenjie.sport.page.mine.attendance.range.AttendanceRangeActivity;
import com.kuaishou.weapon.p0.bo;
import com.zj.adlib.ai9;
import com.zj.adlib.cr2;
import com.zj.adlib.i62;
import com.zj.adlib.lj0;
import com.zj.adlib.ok0;
import com.zj.adlib.p59;
import com.zj.adlib.tw0;
import com.zj.adlib.zn1;
import huachenjie.sdk.map.adapter.location.callback.HCJLocationListener;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(path = RoutePathConstants.Sport.w)
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00021CB\u0007¢\u0006\u0004\bA\u0010BJ\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\n\u001a\u00020\bH\u0014J\b\u0010\u000b\u001a\u00020\bH\u0014J\b\u0010\f\u001a\u00020\bH\u0014J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0014J\u0006\u0010\u0012\u001a\u00020\bJ\u001a\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0002J\u0012\u0010\u0019\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u001c\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J(\u0010\u0014\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!H\u0002J\b\u0010%\u001a\u00020\bH\u0002J \u0010)\u001a\u00020\b2\u0006\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020!H\u0002J\u0010\u0010+\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u0015H\u0002J\u001a\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010-\u001a\u00020,2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00105R\u0018\u00109\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00108R\u0018\u0010;\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010:R*\u0010@\u001a\u0016\u0012\u0004\u0012\u00020=\u0018\u00010<j\n\u0012\u0004\u0012\u00020=\u0018\u0001`>8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b1\u0010?¨\u0006D"}, d2 = {"Lcom/huachenjie/sport/page/mine/attendance/range/AttendanceRangeActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/sport/page/mine/attendance/range/AttendanceRangeVM;", "Lhuachenjie/sdk/map/adapter/location/callback/HCJLocationListener;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "onDestroy", "onResume", "onPause", "outState", "Landroid/os/PersistableBundle;", "outPersistentState", "onSaveInstanceState", "initViewModel", "u0", "", bo.g, "Lhuachenjie/sdk/map/lib_base/HCJAddressInfo;", "p1", "onLocationListener", "r0", "q0", "Lcom/amap/api/maps/model/LatLng;", "latLng", "t0", "userLatLng", "o0", "Lcom/amap/api/maps/model/LatLngBounds$Builder;", "builder", "", "lat", "lng", "radiusMeters", "n0", "latitude", "longitude", "radius", "j0", RequestParameters.SUBRESOURCE_LOCATION, "k0", "Landroid/view/View;", "view", "Lcom/amap/api/maps/model/Marker;", "v0", "Lcom/amap/api/maps/MapView;", "a", "Lcom/amap/api/maps/MapView;", "mapView", "Lcom/amap/api/maps/AMap;", "Lcom/amap/api/maps/AMap;", "aMap", "", "Ljava/lang/Boolean;", "moveToMyLocation", "Lcom/amap/api/maps/model/Marker;", "myMarkers", "Ljava/util/ArrayList;", "Lcom/huachenjie/common/bean/LocationRangeBean;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "locationRangeList", "<init>", "()V", "b", "sport_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nAttendanceRangeActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AttendanceRangeActivity.kt\ncom/huachenjie/sport/page/mine/attendance/range/AttendanceRangeActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,310:1\n1855#2,2:311\n1855#2,2:313\n*S KotlinDebug\n*F\n+ 1 AttendanceRangeActivity.kt\ncom/huachenjie/sport/page/mine/attendance/range/AttendanceRangeActivity\n*L\n177#1:311,2\n206#1:313,2\n*E\n"})
public final class AttendanceRangeActivity extends BaseVmActivity<AttendanceRangeVM> implements HCJLocationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final double f36613a = 111320.0d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final float f13726a = 3.0f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final b f13727a = new b(null);
    public static final float b = 20.0f;
    public static final float c = 18.0f;
    public static final float d = 48.0f;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public AMap aMap;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public MapView mapView;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Marker myMarkers;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Boolean moveToMyLocation;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Autowired(name = UserConstants.MINE_PARAMS.o)
    @JvmField
    @Nullable
    public ArrayList<LocationRangeBean> locationRangeList;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/sport/page/mine/attendance/range/AttendanceRangeActivity$a;", "", "Landroid/view/View;", "view", "", "b", "a", "<init>", "(Lcom/huachenjie/sport/page/mine/attendance/range/AttendanceRangeActivity;)V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            AttendanceRangeActivity.this.moveToMyLocation = Boolean.TRUE;
            AttendanceRangeActivity.this.u0();
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            AttendanceRangeActivity.this.moveToMyLocation = Boolean.FALSE;
            AttendanceRangeActivity.this.u0();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0004¨\u0006\r"}, d2 = {"Lcom/huachenjie/sport/page/mine/attendance/range/AttendanceRangeActivity$b;", "", "", "BOUNDS_PADDING_DP", "F", "MAX_ZOOM", "", "METERS_PER_DEGREE", "D", "MIN_ZOOM", "MY_LOCATION_ZOOM", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final void l0(AvatarView avatarView, final AttendanceRangeActivity attendanceRangeActivity, final FrameLayout frameLayout, final HCJAddressInfo hCJAddressInfo) {
        Intrinsics.checkNotNullParameter(avatarView, "$avatarView");
        Intrinsics.checkNotNullParameter(attendanceRangeActivity, "this$0");
        Intrinsics.checkNotNullParameter(frameLayout, "$view");
        Intrinsics.checkNotNullParameter(hCJAddressInfo, "$location");
        try {
            avatarView.loadImageSync(ai9.e().getAvatar(), "");
            attendanceRangeActivity.runOnUiThread(new Runnable() { // from class: com.zj.adlib.vc0
                @Override // java.lang.Runnable
                public final void run() {
                    AttendanceRangeActivity.m0(this.f20202a, frameLayout, hCJAddressInfo);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final void m0(AttendanceRangeActivity attendanceRangeActivity, FrameLayout frameLayout, HCJAddressInfo hCJAddressInfo) {
        Intrinsics.checkNotNullParameter(attendanceRangeActivity, "this$0");
        Intrinsics.checkNotNullParameter(frameLayout, "$view");
        Intrinsics.checkNotNullParameter(hCJAddressInfo, "$location");
        Marker markerV0 = attendanceRangeActivity.v0(frameLayout, new LatLng(hCJAddressInfo.getLat(), hCJAddressInfo.getLng()));
        if (markerV0 != null) {
            attendanceRangeActivity.myMarkers = markerV0;
        }
    }

    public static final void s0(AttendanceRangeActivity attendanceRangeActivity, View view) {
        Intrinsics.checkNotNullParameter(attendanceRangeActivity, "this$0");
        attendanceRangeActivity.finish();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.activity_attendance_range), Integer.valueOf(ok0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(ok0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…   ClickProxy()\n        )");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        r0();
        q0(savedInstanceState);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }

    public final void j0(double latitude, double longitude, double radius) {
        AMap map;
        MapView mapView = this.mapView;
        if (mapView == null || (map = mapView.getMap()) == null) {
            return;
        }
        map.addCircle(new CircleOptions().center(new LatLng(latitude, longitude)).radius(radius).fillColor(Color.parseColor("#4D36A1FF")).strokeWidth(0.0f));
    }

    public final void k0(final HCJAddressInfo location) {
        if (this.myMarkers == null) {
            final FrameLayout frameLayout = new FrameLayout(this);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(cr2.c(this, 32.0f), cr2.c(this, 32.0f)));
            final AvatarView avatarView = new AvatarView(this, null, 0, 6, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(cr2.c(this, 32.0f), cr2.c(this, 32.0f));
            avatarView.setSelect(true);
            avatarView.setSelectDrawable(R.drawable.bg_avatar_attendance_selected);
            layoutParams.gravity = 17;
            frameLayout.addView(avatarView, layoutParams);
            p59.b().submit(new Runnable() { // from class: com.zj.adlib.uc0
                @Override // java.lang.Runnable
                public final void run() {
                    AttendanceRangeActivity.l0(avatarView, this, frameLayout, location);
                }
            });
        }
    }

    public final void n0() {
        ArrayList<LocationRangeBean> arrayList = this.locationRangeList;
        if (arrayList != null) {
            for (LocationRangeBean locationRangeBean : arrayList) {
                j0(locationRangeBean.getLat(), locationRangeBean.getLng(), locationRangeBean.getScope());
            }
        }
    }

    public final void o0(LatLng userLatLng) {
        MapView mapView = this.mapView;
        AMap map = mapView != null ? mapView.getMap() : null;
        if (map == null) {
            return;
        }
        ArrayList<LocationRangeBean> arrayList = this.locationRangeList;
        if (arrayList == null || arrayList.isEmpty()) {
            t0(userLatLng);
            return;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(userLatLng);
        for (LocationRangeBean locationRangeBean : arrayList) {
            p0(builder, locationRangeBean.getLat(), locationRangeBean.getLng(), locationRangeBean.getScope());
        }
        try {
            map.animateCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), SizeUtils.b(48.0f)));
        } catch (Exception e) {
            e.printStackTrace();
            t0(userLatLng);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MapView mapView = this.mapView;
        if (mapView != null) {
            mapView.onDestroy();
        }
    }

    public void onLocationListener(int p0, @Nullable HCJAddressInfo p1) {
        if (p1 != null) {
            Boolean bool = this.moveToMyLocation;
            if (bool == null) {
                n0();
                k0(p1);
                o0(new LatLng(p1.getLat(), p1.getLng()));
                this.moveToMyLocation = Boolean.TRUE;
                return;
            }
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                t0(new LatLng(p1.getLat(), p1.getLng()));
                return;
            }
            Marker marker = this.myMarkers;
            if (marker == null) {
                return;
            }
            marker.setPosition(new LatLng(p1.getLat(), p1.getLng()));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MapView mapView = this.mapView;
        if (mapView != null) {
            mapView.onPause();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MapView mapView = this.mapView;
        if (mapView != null) {
            mapView.onResume();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle outState, @NotNull PersistableBundle outPersistentState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        Intrinsics.checkNotNullParameter(outPersistentState, "outPersistentState");
        super.onSaveInstanceState(outState, outPersistentState);
        MapView mapView = this.mapView;
        if (mapView != null) {
            mapView.onSaveInstanceState(outState);
        }
    }

    public final void p0(LatLngBounds.Builder builder, double lat, double lng, double radiusMeters) {
        double d2 = radiusMeters / 111320.0d;
        double dCoerceAtLeast = radiusMeters / (RangesKt.coerceAtLeast(Math.cos(Math.toRadians(lat)), 0.01d) * 111320.0d);
        builder.include(new LatLng(lat + d2, lng));
        builder.include(new LatLng(lat - d2, lng));
        builder.include(new LatLng(lat, lng + dCoerceAtLeast));
        builder.include(new LatLng(lat, lng - dCoerceAtLeast));
    }

    public final void q0(Bundle savedInstanceState) {
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.sport.databinding.ActivityAttendanceRangeBinding");
        MapView mapView = ((ActivityAttendanceRangeBinding) binding).f36366a;
        this.mapView = mapView;
        AMap map = mapView.getMap();
        this.aMap = map;
        if (map != null) {
            map.setMapType(1);
        }
        AMap aMap = this.aMap;
        UiSettings uiSettings = aMap != null ? aMap.getUiSettings() : null;
        if (uiSettings != null) {
            uiSettings.setCompassEnabled(false);
        }
        AMap aMap2 = this.aMap;
        UiSettings uiSettings2 = aMap2 != null ? aMap2.getUiSettings() : null;
        if (uiSettings2 != null) {
            uiSettings2.setScaleControlsEnabled(false);
        }
        AMap aMap3 = this.aMap;
        UiSettings uiSettings3 = aMap3 != null ? aMap3.getUiSettings() : null;
        if (uiSettings3 != null) {
            uiSettings3.setZoomControlsEnabled(false);
        }
        AMap aMap4 = this.aMap;
        UiSettings uiSettings4 = aMap4 != null ? aMap4.getUiSettings() : null;
        if (uiSettings4 != null) {
            uiSettings4.setRotateGesturesEnabled(false);
        }
        AMap aMap5 = this.aMap;
        UiSettings uiSettings5 = aMap5 != null ? aMap5.getUiSettings() : null;
        if (uiSettings5 != null) {
            uiSettings5.setTiltGesturesEnabled(false);
        }
        AMap aMap6 = this.aMap;
        if (aMap6 != null) {
            aMap6.setMinZoomLevel(3.0f);
        }
        AMap aMap7 = this.aMap;
        if (aMap7 != null) {
            aMap7.setMaxZoomLevel(20.0f);
        }
        AMap aMap8 = this.aMap;
        if (aMap8 != null) {
            aMap8.showBuildings(true);
        }
        AMap aMap9 = this.aMap;
        if (aMap9 != null) {
            aMap9.setMyLocationEnabled(false);
        }
        AMap aMap10 = this.aMap;
        if (aMap10 != null) {
            MyLocationStyle myLocationStyle = new MyLocationStyle();
            myLocationStyle.showMyLocation(false);
            myLocationStyle.interval(2000L);
            myLocationStyle.myLocationType(1);
            aMap10.setMyLocationStyle(myLocationStyle);
        }
        MapView mapView2 = this.mapView;
        if (mapView2 != null) {
            mapView2.onCreate(savedInstanceState);
        }
        lj0.p(this, false, null, this, 6, null);
    }

    public final void r0() {
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = ((BaseVM) ((AttendanceRangeVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue();
        Intrinsics.checkNotNull(value);
        ((AttendanceRangeVM) ((BaseVmActivity) this).f8507a).i.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setTitleName("打卡范围").setBackground(zn1.a(R.color.white)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(Integer.valueOf(zn1.a(R.color.black))).setTitleTextColor(zn1.a(R.color.color_2C3E50)).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.wc0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AttendanceRangeActivity.s0(this.f45567a, view);
            }
        }));
    }

    public final void t0(LatLng latLng) {
        AMap map;
        MapView mapView = this.mapView;
        if (mapView == null || (map = mapView.getMap()) == null || latLng == null) {
            return;
        }
        map.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(latLng, 18.0f, 0.0f, 0.0f)));
    }

    public final void u0() {
        AMap map;
        MapView mapView = this.mapView;
        MyLocationStyle myLocationStyle = (mapView == null || (map = mapView.getMap()) == null) ? null : map.getMyLocationStyle();
        if (myLocationStyle == null) {
            return;
        }
        myLocationStyle.myLocationType(1);
        MapView mapView2 = this.mapView;
        AMap map2 = mapView2 != null ? mapView2.getMap() : null;
        if (map2 != null) {
            map2.setMyLocationStyle(myLocationStyle);
        }
        lj0.p(this, false, null, this, 6, null);
    }

    public final Marker v0(View view, LatLng latLng) {
        Bitmap bitmapB = tw0.b(view);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(bitmapB));
        markerOptions.setFlat(true);
        markerOptions.zIndex(99.0f);
        markerOptions.anchor(0.5f, 1.0f);
        AMap aMap = this.aMap;
        if (aMap != null) {
            return aMap.addMarker(markerOptions);
        }
        return null;
    }
}
