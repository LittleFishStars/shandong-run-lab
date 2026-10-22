package com.huachenjie.college.page.hw_health_detail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import androidx.camera.video.AudioStats;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.google.android.material.timepicker.TimeModel;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import com.huachenjie.college.R;
import com.huachenjie.college.bean.HWHealthSportDetailBean;
import com.huachenjie.college.bean.HWHealthSportDetailPointBean;
import com.huachenjie.college.bean.HuaweiHealthDeductionOptionBean;
import com.huachenjie.college.databinding.CollegeActivityHwHealthSportDetailBinding;
import com.huachenjie.college.databinding.CollegeItemSportDetailCardBinding;
import com.huachenjie.college.page.hw_health_detail.HWHealthSportDetailActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.zj.adlib.c49;
import com.zj.adlib.fv5;
import com.zj.adlib.uk0;
import com.zj.adlib.zn1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 :2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002:GB\u0007¢\u0006\u0004\bL\u0010MJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J(\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J \u0010\u001d\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0012H\u0002J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010!\u001a\u00020 H\u0002J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010$\u001a\u00020#H\u0002J\u0016\u0010)\u001a\u00020\u00042\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002J\u0014\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020+0*H\u0016J\b\u0010-\u001a\u00020\u0012H\u0016J\b\u0010.\u001a\u00020\u0004H\u0016J\b\u0010/\u001a\u00020\u0004H\u0016J\b\u00100\u001a\u00020\u0004H\u0016J\b\u00101\u001a\u00020\u0004H\u0014J\b\u00102\u001a\u00020\u0004H\u0014J\b\u00103\u001a\u00020\u0004H\u0014J\b\u00104\u001a\u00020\u0004H\u0016J\u0018\u00108\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00062\u0006\u00107\u001a\u000206H\u0016R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010>R\u0016\u0010B\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010DR\u001b\u0010K\u001a\u00020F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J¨\u0006N"}, d2 = {"Lcom/huachenjie/college/page/hw_health_detail/HWHealthSportDetailActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/college/databinding/CollegeActivityHwHealthSportDetailBinding;", "Lcom/huachenjie/college/page/hw_health_detail/HWHealthSportDetailVM;", "", "initToolbar", "Landroid/os/Bundle;", "savedInstanceState", "u0", "Lcom/huachenjie/college/bean/HWHealthSportDetailBean;", "data", "j0", "l0", "i0", "k0", "m0", "Lcom/huachenjie/college/databinding/CollegeItemSportDetailCardBinding;", "cardBinding", "", "iconRes", "", "label", "value", "h0", "o0", "text", "backgroundColor", "Lcom/amap/api/maps/model/BitmapDescriptor;", "kotlin.jvm.PlatformType", "n0", "seconds", "q0", "", "paceSecondsPerKm", "r0", "", "timestamp", "s0", "", "Lcom/huachenjie/college/bean/HuaweiHealthDeductionOptionBean;", "options", "w0", "", "", "V", "getLayoutResID", "initView", "W", "initData", "onResume", "onPause", "onDestroy", "finish", "outState", "Landroid/os/PersistableBundle;", "outPersistentState", "onSaveInstanceState", "Lcom/amap/api/maps/MapView;", "a", "Lcom/amap/api/maps/MapView;", "mapView", "Lcom/amap/api/maps/AMap;", "Lcom/amap/api/maps/AMap;", "aMap", "t", "Ljava/lang/String;", HWHealthSportDetailActivity.x, "", "Z", HWHealthSportDetailActivity.y, "Lcom/huachenjie/base/widget/picker/OptionsPickerHelper;", "b", "Lkotlin/Lazy;", "t0", "()Lcom/huachenjie/base/widget/picker/OptionsPickerHelper;", "pickerHelper", "<init>", "()V", "college_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nHWHealthSportDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HWHealthSportDetailActivity.kt\ncom/huachenjie/college/page/hw_health_detail/HWHealthSportDetailActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,507:1\n766#2:508\n857#2,2:509\n1549#2:511\n1620#2,3:512\n1855#2,2:515\n1549#2:517\n1620#2,3:518\n*S KotlinDebug\n*F\n+ 1 HWHealthSportDetailActivity.kt\ncom/huachenjie/college/page/hw_health_detail/HWHealthSportDetailActivity\n*L\n321#1:508\n321#1:509,2\n322#1:511\n322#1:512,3\n359#1:515,2\n477#1:517\n477#1:518,3\n*E\n"})
public final class HWHealthSportDetailActivity extends BaseMVVMActivity<CollegeActivityHwHealthSportDetailBinding, HWHealthSportDetailVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String x = "sportRecordCode";

    @NotNull
    public static final String y = "deductionSuccess";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public AMap aMap;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public MapView mapView;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean deductionSuccess;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    @NotNull
    public String sportRecordCode = "";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy pickerHelper = LazyKt.lazy(new Function0<OptionsPickerHelper>() { // from class: com.huachenjie.college.page.hw_health_detail.HWHealthSportDetailActivity$pickerHelper$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final OptionsPickerHelper m332invoke() {
            return new OptionsPickerHelper();
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/college/page/hw_health_detail/HWHealthSportDetailActivity$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/college/page/hw_health_detail/HWHealthSportDetailActivity;)V", "college_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            HWHealthSportDetailActivity.d0(HWHealthSportDetailActivity.this).j(HWHealthSportDetailActivity.this.sportRecordCode);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.college.page.hw_health_detail.HWHealthSportDetailActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/college/page/hw_health_detail/HWHealthSportDetailActivity$b;", "", "Landroid/content/Context;", "context", "", HWHealthSportDetailActivity.x, "Landroid/content/Intent;", "a", "data", "", "c", "b", "EXTRA_DEDUCTION_SUCCESS", "Ljava/lang/String;", "EXTRA_SPORT_RECORD_CODE", "<init>", "()V", "college_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent a(@NotNull Context context, @NotNull String sportRecordCode) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(sportRecordCode, HWHealthSportDetailActivity.x);
            Intent intent = new Intent(context, (Class<?>) HWHealthSportDetailActivity.class);
            intent.putExtra(HWHealthSportDetailActivity.x, sportRecordCode);
            return intent;
        }

        @NotNull
        public final String b(@Nullable Intent data) {
            String stringExtra = data != null ? data.getStringExtra(HWHealthSportDetailActivity.x) : null;
            return stringExtra == null ? "" : stringExtra;
        }

        public final boolean c(@Nullable Intent data) {
            return data != null && data.getBooleanExtra(HWHealthSportDetailActivity.y, false);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33599a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33599a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33599a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33599a.invoke(obj);
        }
    }

    public static final /* synthetic */ HWHealthSportDetailVM d0(HWHealthSportDetailActivity hWHealthSportDetailActivity) {
        return hWHealthSportDetailActivity.getMViewModel();
    }

    public static final void p0(LatLngBounds.Builder builder, HWHealthSportDetailActivity hWHealthSportDetailActivity) {
        Intrinsics.checkNotNullParameter(builder, "$boundsBuilder");
        Intrinsics.checkNotNullParameter(hWHealthSportDetailActivity, "this$0");
        LatLngBounds latLngBoundsBuild = builder.build();
        float f = hWHealthSportDetailActivity.getResources().getDisplayMetrics().density;
        int i = (int) (40 * f);
        int i2 = (int) (32 * f);
        int i3 = (int) (f * 52);
        AMap aMap = hWHealthSportDetailActivity.aMap;
        if (aMap != null) {
            aMap.moveCamera(CameraUpdateFactory.newLatLngBoundsRect(latLngBoundsBuild, i, i2, i, i3));
        }
    }

    public static final void v0(HWHealthSportDetailActivity hWHealthSportDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(hWHealthSportDetailActivity, "this$0");
        hWHealthSportDetailActivity.finish();
    }

    public static final void x0(List list, HWHealthSportDetailActivity hWHealthSportDetailActivity, int i, String str) {
        Intrinsics.checkNotNullParameter(list, "$options");
        Intrinsics.checkNotNullParameter(hWHealthSportDetailActivity, "this$0");
        HuaweiHealthDeductionOptionBean huaweiHealthDeductionOptionBean = (HuaweiHealthDeductionOptionBean) CollectionsKt.getOrNull(list, i);
        if (huaweiHealthDeductionOptionBean == null) {
            fv5.b("请先选择抵扣计划");
        } else {
            hWHealthSportDetailActivity.getMViewModel().p(hWHealthSportDetailActivity.sportRecordCode, huaweiHealthDeductionOptionBean.getDedPlanCode());
        }
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(uk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(uk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().o().observe(this, new c(new Function1<HWHealthSportDetailBean, Unit>() { // from class: com.huachenjie.college.page.hw_health_detail.HWHealthSportDetailActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HWHealthSportDetailBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(HWHealthSportDetailBean hWHealthSportDetailBean) {
                if (hWHealthSportDetailBean != null) {
                    this.this$0.j0(hWHealthSportDetailBean);
                }
            }
        }));
        getMViewModel().m().observe(this, new c(new Function1<List<? extends HuaweiHealthDeductionOptionBean>, Unit>() { // from class: com.huachenjie.college.page.hw_health_detail.HWHealthSportDetailActivity$initDataObserve$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<HuaweiHealthDeductionOptionBean>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<HuaweiHealthDeductionOptionBean> list) {
                HWHealthSportDetailActivity hWHealthSportDetailActivity = this.this$0;
                Intrinsics.checkNotNullExpressionValue(list, "options");
                hWHealthSportDetailActivity.w0(list);
            }
        }));
        getMViewModel().n().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.college.page.hw_health_detail.HWHealthSportDetailActivity$initDataObserve$3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    fv5.b("抵扣成功");
                    this.this$0.deductionSuccess = true;
                    MutableLiveData<HWHealthSportDetailBean> mutableLiveDataO = HWHealthSportDetailActivity.d0(this.this$0).o();
                    HWHealthSportDetailBean value = HWHealthSportDetailActivity.d0(this.this$0).o().getValue();
                    if (value != null) {
                        value.setDeducted(true);
                    } else {
                        value = null;
                    }
                    mutableLiveDataO.setValue(value);
                }
            }
        }));
    }

    @Override // android.app.Activity
    public void finish() {
        if (this.deductionSuccess) {
            Intent intent = new Intent();
            intent.putExtra(x, this.sportRecordCode);
            intent.putExtra(y, true);
            Unit unit = Unit.INSTANCE;
            setResult(-1, intent);
        }
        super.finish();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.college_activity_hw_health_sport_detail;
    }

    public final void h0(CollegeItemSportDetailCardBinding cardBinding, int iconRes, String label, String value) {
        cardBinding.f33578a.setImageResource(iconRes);
        cardBinding.f8413a.setText(label);
        cardBinding.b.setText(value);
    }

    public final void i0(HWHealthSportDetailBean data) {
        getMBinding().f8343a.setVisibility(0);
        CollegeItemSportDetailCardBinding collegeItemSportDetailCardBinding = getMBinding().f8356c;
        Intrinsics.checkNotNullExpressionValue(collegeItemSportDetailCardBinding, "mBinding.cardRow2Left");
        h0(collegeItemSportDetailCardBinding, R.drawable.college_ic_health_exercise_pace, "速度(km/h)", String.valueOf(data.getSpeedKmPerHour()));
        getMBinding().f8357d.getRoot().setVisibility(4);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().k(this.sportRecordCode);
    }

    public final void initToolbar() {
        int iIntValue;
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        if (value == null) {
            iIntValue = 0;
        } else {
            Intrinsics.checkNotNullExpressionValue(value, "mViewModel.uiLiveData.statusBarHeight.value ?: 0");
            iIntValue = value.intValue();
        }
        bindingTitleBean.setStatusBarHeight(iIntValue);
        bindingTitleBean.setBackground(0);
        bindingTitleBean.setTitleTextColor(zn1.a(R.color.black_main));
        bindingTitleBean.setTitleName("运动详情");
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(-16777216);
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.xx3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HWHealthSportDetailActivity.v0(this.f45912a, view);
            }
        });
        mutableLiveDataI.setValue(bindingTitleBean);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        String stringExtra = getIntent().getStringExtra(x);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.sportRecordCode = stringExtra;
        initToolbar();
        u0(null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:21:0x003c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0090  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void j0(HWHealthSportDetailBean data) {
        int i;
        String str;
        switch (data.getSportType()) {
            case "RUNNING":
                i = R.drawable.college_bg_health_exercise_runner;
                break;
            case "JUMP_ROPE":
                i = R.drawable.college_bg_health_exercise_jump;
                break;
            case "SWIMMING":
                i = R.drawable.college_bg_health_exercise_swimming;
                break;
            case "CYCLING":
                i = R.drawable.college_bg_health_exercise_cycling;
                break;
            default:
                i = R.drawable.college_bg_health_exercise_runner;
                break;
        }
        getMBinding().f8342a.setImageResource(i);
        switch (data.getSportType()) {
            case "RUNNING":
                str = "跑步里程";
                break;
            case "JUMP_ROPE":
                str = "跳绳个数";
                break;
            case "SWIMMING":
                str = "主泳姿：" + data.getSwimmingStroke();
                break;
            case "CYCLING":
                str = "骑行里程";
                break;
            default:
                str = "";
                break;
        }
        getMBinding().f.setText(str);
        if (Intrinsics.areEqual(data.getSportType(), "JUMP_ROPE")) {
            getMBinding().e.setText(String.valueOf(data.getSkipNum()));
            getMBinding().d.setText("个");
        } else {
            getMBinding().e.setText(data.getDistanceKm());
            getMBinding().d.setText("km");
        }
        getMBinding().g.setText(s0(data.getStartTime()));
        getMBinding().c.setText(((int) data.getAverageHeartRate()) + "bpm");
        CollegeItemSportDetailCardBinding collegeItemSportDetailCardBinding = getMBinding().f8355b;
        Intrinsics.checkNotNullExpressionValue(collegeItemSportDetailCardBinding, "mBinding.cardDuration");
        h0(collegeItemSportDetailCardBinding, R.drawable.college_ic_health_exercise_duration, "运动时长", q0(data.getActiveTimeSeconds()));
        CollegeItemSportDetailCardBinding collegeItemSportDetailCardBinding2 = getMBinding().f8346a;
        Intrinsics.checkNotNullExpressionValue(collegeItemSportDetailCardBinding2, "mBinding.cardCalories");
        h0(collegeItemSportDetailCardBinding2, R.drawable.college_ic_health_exercise_calories, "总消耗热量(kcal)", String.valueOf((int) data.getCalories()));
        String sportType = data.getSportType();
        switch (sportType.hashCode()) {
            case -2026200673:
                if (sportType.equals("RUNNING")) {
                    l0(data);
                }
                break;
            case -793726365:
                if (sportType.equals("JUMP_ROPE")) {
                    k0(data);
                }
                break;
            case 691184349:
                if (sportType.equals("SWIMMING")) {
                    m0(data);
                }
                break;
            case 1945411587:
                if (sportType.equals("CYCLING")) {
                    i0(data);
                }
                break;
        }
        if (Intrinsics.areEqual(data.getSportType(), "RUNNING") || Intrinsics.areEqual(data.getSportType(), "CYCLING")) {
            o0(data);
        }
    }

    public final void k0(HWHealthSportDetailBean data) {
        getMBinding().f8343a.setVisibility(0);
        CollegeItemSportDetailCardBinding collegeItemSportDetailCardBinding = getMBinding().f8356c;
        Intrinsics.checkNotNullExpressionValue(collegeItemSportDetailCardBinding, "mBinding.cardRow2Left");
        h0(collegeItemSportDetailCardBinding, R.drawable.college_ic_health_exercise_pace, "跳绳速度(次/分钟)", String.valueOf((int) data.getSkipSpeed()));
        CollegeItemSportDetailCardBinding collegeItemSportDetailCardBinding2 = getMBinding().f8357d;
        Intrinsics.checkNotNullExpressionValue(collegeItemSportDetailCardBinding2, "mBinding.cardRow2Right");
        h0(collegeItemSportDetailCardBinding2, R.drawable.college_ic_health_exercise_jump, "最多连跳(个)", String.valueOf(data.getMaxSkippingTimes()));
    }

    public final void l0(HWHealthSportDetailBean data) {
        getMBinding().f8343a.setVisibility(0);
        CollegeItemSportDetailCardBinding collegeItemSportDetailCardBinding = getMBinding().f8356c;
        Intrinsics.checkNotNullExpressionValue(collegeItemSportDetailCardBinding, "mBinding.cardRow2Left");
        h0(collegeItemSportDetailCardBinding, R.drawable.college_ic_health_exercise_pace, "平均配速", r0(data.getAveragePaceSecondsPerKm()));
        CollegeItemSportDetailCardBinding collegeItemSportDetailCardBinding2 = getMBinding().f8357d;
        Intrinsics.checkNotNullExpressionValue(collegeItemSportDetailCardBinding2, "mBinding.cardRow2Right");
        h0(collegeItemSportDetailCardBinding2, R.drawable.college_ic_health_exercise_steps, "步数", String.valueOf(data.getSteps()));
        getMBinding().f8353b.setVisibility(0);
        CollegeItemSportDetailCardBinding collegeItemSportDetailCardBinding3 = getMBinding().f8358e;
        Intrinsics.checkNotNullExpressionValue(collegeItemSportDetailCardBinding3, "mBinding.cardRow3Left");
        h0(collegeItemSportDetailCardBinding3, R.drawable.college_ic_health_exercise_stride, "平均步幅", String.valueOf(data.getAverageStepLengthMeter()));
        CollegeItemSportDetailCardBinding collegeItemSportDetailCardBinding4 = getMBinding().f8359f;
        Intrinsics.checkNotNullExpressionValue(collegeItemSportDetailCardBinding4, "mBinding.cardRow3Right");
        h0(collegeItemSportDetailCardBinding4, R.drawable.college_ic_health_exercise_cadence, "平均步频(步/分钟)", String.valueOf((int) data.getAverageStepRate()));
    }

    public final void m0(HWHealthSportDetailBean data) {
        getMBinding().f8343a.setVisibility(0);
        CollegeItemSportDetailCardBinding collegeItemSportDetailCardBinding = getMBinding().f8356c;
        Intrinsics.checkNotNullExpressionValue(collegeItemSportDetailCardBinding, "mBinding.cardRow2Left");
        h0(collegeItemSportDetailCardBinding, R.drawable.college_ic_health_exercise_pace, "平均配速", r0(data.getAveragePaceSecondsPerKm()));
        CollegeItemSportDetailCardBinding collegeItemSportDetailCardBinding2 = getMBinding().f8357d;
        Intrinsics.checkNotNullExpressionValue(collegeItemSportDetailCardBinding2, "mBinding.cardRow2Right");
        h0(collegeItemSportDetailCardBinding2, R.drawable.college_ic_health_exercise_swim_num, "划水次数", String.valueOf(data.getPullTimes()));
        getMBinding().f8353b.setVisibility(0);
        CollegeItemSportDetailCardBinding collegeItemSportDetailCardBinding3 = getMBinding().f8358e;
        Intrinsics.checkNotNullExpressionValue(collegeItemSportDetailCardBinding3, "mBinding.cardRow3Left");
        h0(collegeItemSportDetailCardBinding3, R.drawable.college_ic_health_exercise_swolf, "平均SWOLF", String.valueOf((int) data.getSwolf()));
        CollegeItemSportDetailCardBinding collegeItemSportDetailCardBinding4 = getMBinding().f8359f;
        Intrinsics.checkNotNullExpressionValue(collegeItemSportDetailCardBinding4, "mBinding.cardRow3Right");
        h0(collegeItemSportDetailCardBinding4, R.drawable.college_ic_health_exercise_swim_frequency, "划水频率(次/分钟)", String.valueOf((int) data.getSwimmingStrokeRate()));
    }

    public final BitmapDescriptor n0(String text, int backgroundColor) {
        Paint paint = new Paint(1);
        paint.setColor(-1);
        paint.setTextSize(30.0f);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        Paint paint2 = new Paint(1);
        paint2.setColor(backgroundColor);
        float fMeasureText = paint.measureText(text);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f = 2;
        int i = (int) (fMeasureText + (22.0f * f));
        int i2 = (int) ((fontMetrics.bottom - fontMetrics.top) + (f * 12.0f));
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, heig… Bitmap.Config.ARGB_8888)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        float f2 = i2;
        float f3 = f2 / 2.0f;
        float f4 = i;
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, f4, f2), f3, f3, paint2);
        canvas.drawText(text, f4 / 2.0f, f3 - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f), paint);
        return BitmapDescriptorFactory.fromBitmap(bitmapCreateBitmap);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0068  */
    public final void o0(HWHealthSportDetailBean data) {
        boolean z;
        if (!data.getHasLocation()) {
            AMap aMap = this.aMap;
            if (aMap != null) {
                aMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(new LatLng(39.90923d, 116.397428d), 12.0f, 0.0f, 0.0f)));
                return;
            }
            return;
        }
        List<HWHealthSportDetailPointBean> points = data.getLocationJson().getPoints();
        ArrayList<HWHealthSportDetailPointBean> arrayList = new ArrayList();
        for (Object obj : points) {
            HWHealthSportDetailPointBean hWHealthSportDetailPointBean = (HWHealthSportDetailPointBean) obj;
            if (!(hWHealthSportDetailPointBean.getLatitude() == AudioStats.AUDIO_AMPLITUDE_NONE)) {
                z = (hWHealthSportDetailPointBean.getLongitude() > AudioStats.AUDIO_AMPLITUDE_NONE ? 1 : (hWHealthSportDetailPointBean.getLongitude() == AudioStats.AUDIO_AMPLITUDE_NONE ? 0 : -1)) == 0 ? false : true;
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        for (HWHealthSportDetailPointBean hWHealthSportDetailPointBean2 : arrayList) {
            arrayList2.add(new LatLng(hWHealthSportDetailPointBean2.getLatitude(), hWHealthSportDetailPointBean2.getLongitude()));
        }
        if (arrayList2.size() < 2) {
            AMap aMap2 = this.aMap;
            if (aMap2 != null) {
                aMap2.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(new LatLng(39.90923d, 116.397428d), 12.0f, 0.0f, 0.0f)));
                return;
            }
            return;
        }
        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.addAll(arrayList2);
        polylineOptions.color(-16271498);
        polylineOptions.width(10.0f);
        AMap aMap3 = this.aMap;
        if (aMap3 != null) {
            aMap3.addPolyline(polylineOptions);
        }
        AMap aMap4 = this.aMap;
        if (aMap4 != null) {
            aMap4.addMarker(new MarkerOptions().position((LatLng) CollectionsKt.first(arrayList2)).title("起点").icon(n0("起", Color.parseColor("#07B776"))).anchor(0.5f, 0.5f));
        }
        AMap aMap5 = this.aMap;
        if (aMap5 != null) {
            aMap5.addMarker(new MarkerOptions().position((LatLng) CollectionsKt.last(arrayList2)).title("终点").icon(n0("终", Color.parseColor("#F54E42"))).anchor(0.5f, 0.5f));
        }
        final LatLngBounds.Builder builder = new LatLngBounds.Builder();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            builder.include((LatLng) it.next());
        }
        getMBinding().f8345a.post(new Runnable() { // from class: com.zj.adlib.vx3
            @Override // java.lang.Runnable
            public final void run() {
                HWHealthSportDetailActivity.p0(builder, this);
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        t0().i();
        super.onDestroy();
        MapView mapView = this.mapView;
        if (mapView != null) {
            mapView.onDestroy();
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

    public final String q0(int seconds) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(seconds / 3600), Integer.valueOf((seconds % 3600) / 60), Integer.valueOf(seconds % 60)}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return str;
    }

    public final String r0(float paceSecondsPerKm) {
        if (paceSecondsPerKm <= 0.0f) {
            return c49.f40900a;
        }
        float f = 60;
        int i = (int) (paceSecondsPerKm / f);
        int i2 = (int) (paceSecondsPerKm % f);
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append('\'');
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        sb.append(str);
        sb.append('\"');
        return sb.toString();
    }

    public final String s0(long timestamp) {
        if (timestamp == 0) {
            return "";
        }
        if (timestamp < 10000000000L) {
            timestamp *= (long) 1000;
        }
        String str = new SimpleDateFormat("yyyy-MM-dd  HH:mm", Locale.getDefault()).format(new Date(timestamp));
        Intrinsics.checkNotNullExpressionValue(str, "sdf.format(date)");
        return str;
    }

    public final OptionsPickerHelper t0() {
        return (OptionsPickerHelper) this.pickerHelper.getValue();
    }

    public final void u0(Bundle savedInstanceState) {
        MapView mapView = getMBinding().f8345a;
        this.mapView = mapView;
        if (mapView != null) {
            mapView.onCreate(savedInstanceState);
        }
        MapView mapView2 = this.mapView;
        AMap map = mapView2 != null ? mapView2.getMap() : null;
        this.aMap = map;
        if (map != null) {
            map.setMapType(1);
            UiSettings uiSettings = map.getUiSettings();
            if (uiSettings != null) {
                uiSettings.setCompassEnabled(false);
            }
            UiSettings uiSettings2 = map.getUiSettings();
            if (uiSettings2 != null) {
                uiSettings2.setScaleControlsEnabled(false);
            }
            UiSettings uiSettings3 = map.getUiSettings();
            if (uiSettings3 != null) {
                uiSettings3.setZoomControlsEnabled(false);
            }
            UiSettings uiSettings4 = map.getUiSettings();
            if (uiSettings4 != null) {
                uiSettings4.setRotateGesturesEnabled(false);
            }
            UiSettings uiSettings5 = map.getUiSettings();
            if (uiSettings5 != null) {
                uiSettings5.setTiltGesturesEnabled(false);
            }
            map.setMyLocationEnabled(false);
        }
    }

    public final void w0(final List<HuaweiHealthDeductionOptionBean> options) {
        if (options.isEmpty()) {
            fv5.b("暂无可抵扣的阳光跑计划");
            return;
        }
        List<HuaweiHealthDeductionOptionBean> list = options;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((HuaweiHealthDeductionOptionBean) it.next()).getRunPlanName());
        }
        OptionsPickerHelper optionsPickerHelperT0 = t0();
        String str = (String) CollectionsKt.firstOrNull(arrayList);
        if (str == null) {
            str = "";
        }
        optionsPickerHelperT0.q(this, str, arrayList, "抵扣选择", OptionsPickerHelper.e, "立即抵扣", new OptionsPickerHelper.OnPickChangeListener() { // from class: com.zj.adlib.wx3
            @Override // com.huachenjie.base.widget.picker.OptionsPickerHelper.OnPickChangeListener
            public final void a(int i, String str2) {
                HWHealthSportDetailActivity.x0(options, this, i, str2);
            }
        });
    }
}
