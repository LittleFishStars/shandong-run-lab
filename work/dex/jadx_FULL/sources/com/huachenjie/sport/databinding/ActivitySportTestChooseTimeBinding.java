package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.flyco.tablayout.SlidingTabLayout2;
import com.huachenjie.common.widget.ShadowConstraintLayout;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.sport_test.time.SportTestChooseTimeActivity;
import com.huachenjie.sport.page.mine.sport_test.time.SportTestChooseTimeVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivitySportTestChooseTimeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36425a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ViewPager2 f13328a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SlidingTabLayout2 f13329a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShadowConstraintLayout f13330a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SportTestChooseTimeActivity.a f13331a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SportTestChooseTimeVM f13332a;

    @NonNull
    public final TextView b;

    public ActivitySportTestChooseTimeBinding(Object obj, View view, int i, ShadowConstraintLayout shadowConstraintLayout, SlidingTabLayout2 slidingTabLayout2, TextView textView, TextView textView2, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.f13330a = shadowConstraintLayout;
        this.f13329a = slidingTabLayout2;
        this.f36425a = textView;
        this.b = textView2;
        this.f13328a = viewPager2;
    }

    public static ActivitySportTestChooseTimeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySportTestChooseTimeBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivitySportTestChooseTimeBinding) ViewDataBinding.bind(obj, view, R.layout.activity_sport_test_choose_time);
    }

    @NonNull
    public static ActivitySportTestChooseTimeBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivitySportTestChooseTimeBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivitySportTestChooseTimeBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivitySportTestChooseTimeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_sport_test_choose_time, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivitySportTestChooseTimeBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivitySportTestChooseTimeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_sport_test_choose_time, null, false, obj);
    }

    @Nullable
    public SportTestChooseTimeActivity.a f() {
        return this.f13331a;
    }

    @Nullable
    public SportTestChooseTimeVM g() {
        return this.f13332a;
    }

    public abstract void l(@Nullable SportTestChooseTimeActivity.a aVar);

    public abstract void m(@Nullable SportTestChooseTimeVM sportTestChooseTimeVM);
}
