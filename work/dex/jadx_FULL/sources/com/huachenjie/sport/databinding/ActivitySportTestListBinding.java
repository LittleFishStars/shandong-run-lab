package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.flyco.tablayout.SlidingTabLayout2;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.sport_test.test_list.SportTestListVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivitySportTestListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f36434a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SlidingTabLayout2 f13360a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SportTestListVM f13361a;

    public ActivitySportTestListBinding(Object obj, View view, int i, SlidingTabLayout2 slidingTabLayout2, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.f13360a = slidingTabLayout2;
        this.f36434a = viewPager2;
    }

    public static ActivitySportTestListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySportTestListBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivitySportTestListBinding) ViewDataBinding.bind(obj, view, R.layout.activity_sport_test_list);
    }

    @NonNull
    public static ActivitySportTestListBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivitySportTestListBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivitySportTestListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivitySportTestListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_sport_test_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivitySportTestListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivitySportTestListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_sport_test_list, null, false, obj);
    }

    @Nullable
    public SportTestListVM f() {
        return this.f13361a;
    }

    public abstract void k(@Nullable SportTestListVM sportTestListVM);
}
