package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.sport_test.detail.SportTestDetailActivity;
import com.huachenjie.sport.page.mine.sport_test.detail.SportTestDetailVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivitySportTestDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f36428a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SportTestDetailActivity.a f13339a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SportTestDetailVM f13340a;

    @NonNull
    public final LinearLayout b;

    public ActivitySportTestDetailBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2) {
        super(obj, view, i);
        this.f36428a = linearLayout;
        this.b = linearLayout2;
    }

    public static ActivitySportTestDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySportTestDetailBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivitySportTestDetailBinding) ViewDataBinding.bind(obj, view, R.layout.activity_sport_test_detail);
    }

    @NonNull
    public static ActivitySportTestDetailBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivitySportTestDetailBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivitySportTestDetailBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivitySportTestDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_sport_test_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivitySportTestDetailBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivitySportTestDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_sport_test_detail, null, false, obj);
    }

    @Nullable
    public SportTestDetailActivity.a f() {
        return this.f13339a;
    }

    @Nullable
    public SportTestDetailVM g() {
        return this.f13340a;
    }

    public abstract void l(@Nullable SportTestDetailActivity.a aVar);

    public abstract void m(@Nullable SportTestDetailVM sportTestDetailVM);
}
