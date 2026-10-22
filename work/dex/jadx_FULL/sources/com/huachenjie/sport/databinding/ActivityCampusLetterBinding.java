package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.campus_letter.CampusLetterVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityCampusLetterBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f36373a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CampusLetterVM f13151a;

    public ActivityCampusLetterBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ActivityCampusLetterBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityCampusLetterBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityCampusLetterBinding) ViewDataBinding.bind(obj, view, R.layout.activity_campus_letter);
    }

    @NonNull
    public static ActivityCampusLetterBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityCampusLetterBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityCampusLetterBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityCampusLetterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_campus_letter, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityCampusLetterBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityCampusLetterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_campus_letter, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f36373a;
    }

    @Nullable
    public CampusLetterVM g() {
        return this.f13151a;
    }

    public abstract void l(@Nullable CampusLetterVM campusLetterVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
