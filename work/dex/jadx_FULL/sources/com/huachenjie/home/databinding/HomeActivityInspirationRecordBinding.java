package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.widget.SelectBoldTabLayout;
import com.huachenjie.home.R;
import com.huachenjie.home.page.inspiration_record.InspirationRecordVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeActivityInspirationRecordBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f34203a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f9277a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SelectBoldTabLayout f9278a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public InspirationRecordVM f9279a;

    public HomeActivityInspirationRecordBinding(Object obj, View view, int i, SelectBoldTabLayout selectBoldTabLayout, LayoutToolbarBindingBinding layoutToolbarBindingBinding, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.f9278a = selectBoldTabLayout;
        this.f9277a = layoutToolbarBindingBinding;
        this.f34203a = viewPager2;
    }

    public static HomeActivityInspirationRecordBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeActivityInspirationRecordBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeActivityInspirationRecordBinding) ViewDataBinding.bind(obj, view, R.layout.home_activity_inspiration_record);
    }

    @NonNull
    public static HomeActivityInspirationRecordBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeActivityInspirationRecordBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeActivityInspirationRecordBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeActivityInspirationRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_activity_inspiration_record, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeActivityInspirationRecordBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeActivityInspirationRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_activity_inspiration_record, null, false, obj);
    }

    @Nullable
    public InspirationRecordVM f() {
        return this.f9279a;
    }

    public abstract void k(@Nullable InspirationRecordVM inspirationRecordVM);
}
