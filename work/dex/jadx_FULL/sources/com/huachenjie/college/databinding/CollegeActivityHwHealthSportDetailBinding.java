package com.huachenjie.college.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.amap.api.maps.MapView;
import com.huachenjie.college.R;
import com.huachenjie.college.page.hw_health_detail.HWHealthSportDetailActivity;
import com.huachenjie.college.page.hw_health_detail.HWHealthSportDetailVM;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class CollegeActivityHwHealthSportDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f33556a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f8342a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8343a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8344a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final MapView f8345a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CollegeItemSportDetailCardBinding f8346a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public HWHealthSportDetailActivity.a f8347a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public HWHealthSportDetailVM f8348a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f8349a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f8350a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f8351a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f8352a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8353b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f8354b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final CollegeItemSportDetailCardBinding f8355b;

    @NonNull
    public final TextView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final CollegeItemSportDetailCardBinding f8356c;

    @NonNull
    public final TextView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final CollegeItemSportDetailCardBinding f8357d;

    @NonNull
    public final TextView e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NonNull
    public final CollegeItemSportDetailCardBinding f8358e;

    @NonNull
    public final TextView f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    @NonNull
    public final CollegeItemSportDetailCardBinding f8359f;

    @NonNull
    public final TextView g;

    public CollegeActivityHwHealthSportDetailBinding(Object obj, View view, int i, BLTextView bLTextView, CollegeItemSportDetailCardBinding collegeItemSportDetailCardBinding, CollegeItemSportDetailCardBinding collegeItemSportDetailCardBinding2, CollegeItemSportDetailCardBinding collegeItemSportDetailCardBinding3, CollegeItemSportDetailCardBinding collegeItemSportDetailCardBinding4, CollegeItemSportDetailCardBinding collegeItemSportDetailCardBinding5, CollegeItemSportDetailCardBinding collegeItemSportDetailCardBinding6, BLConstraintLayout bLConstraintLayout, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, MapView mapView, LayoutToolbarBindingBinding layoutToolbarBindingBinding, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, BLView bLView) {
        super(obj, view, i);
        this.f8351a = bLTextView;
        this.f8346a = collegeItemSportDetailCardBinding;
        this.f8355b = collegeItemSportDetailCardBinding2;
        this.f8356c = collegeItemSportDetailCardBinding3;
        this.f8357d = collegeItemSportDetailCardBinding4;
        this.f8358e = collegeItemSportDetailCardBinding5;
        this.f8359f = collegeItemSportDetailCardBinding6;
        this.f8350a = bLConstraintLayout;
        this.f33556a = frameLayout;
        this.f8342a = imageView;
        this.b = imageView2;
        this.f8343a = linearLayout;
        this.f8353b = linearLayout2;
        this.f8345a = mapView;
        this.f8349a = layoutToolbarBindingBinding;
        this.f8344a = textView;
        this.f8354b = textView2;
        this.c = textView3;
        this.d = textView4;
        this.e = textView5;
        this.f = textView6;
        this.g = textView7;
        this.f8352a = bLView;
    }

    public static CollegeActivityHwHealthSportDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CollegeActivityHwHealthSportDetailBinding d(@NonNull View view, @Nullable Object obj) {
        return (CollegeActivityHwHealthSportDetailBinding) ViewDataBinding.bind(obj, view, R.layout.college_activity_hw_health_sport_detail);
    }

    @NonNull
    public static CollegeActivityHwHealthSportDetailBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static CollegeActivityHwHealthSportDetailBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static CollegeActivityHwHealthSportDetailBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (CollegeActivityHwHealthSportDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_activity_hw_health_sport_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static CollegeActivityHwHealthSportDetailBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (CollegeActivityHwHealthSportDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_activity_hw_health_sport_detail, null, false, obj);
    }

    @Nullable
    public HWHealthSportDetailActivity.a f() {
        return this.f8347a;
    }

    @Nullable
    public HWHealthSportDetailVM g() {
        return this.f8348a;
    }

    public abstract void l(@Nullable HWHealthSportDetailActivity.a aVar);

    public abstract void m(@Nullable HWHealthSportDetailVM hWHealthSportDetailVM);
}
