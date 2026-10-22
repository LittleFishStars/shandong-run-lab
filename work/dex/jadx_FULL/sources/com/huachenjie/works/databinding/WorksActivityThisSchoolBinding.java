package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.works.R;
import com.huachenjie.works.page.this_school.ThisSchoolActivity;
import com.huachenjie.works.page.this_school.ThisSchoolVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksActivityThisSchoolBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f36811a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f13955a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ThisSchoolActivity.a f13956a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ThisSchoolVM f13957a;

    public WorksActivityThisSchoolBinding(Object _bindingComponent, View _root, int _localFieldCount, FrameLayout flContainer, ImageView titleLeftBt) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f36811a = flContainer;
        this.f13955a = titleLeftBt;
    }

    public static WorksActivityThisSchoolBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksActivityThisSchoolBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksActivityThisSchoolBinding) ViewDataBinding.bind(component, view, R.layout.works_activity_this_school);
    }

    @NonNull
    public static WorksActivityThisSchoolBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksActivityThisSchoolBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksActivityThisSchoolBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksActivityThisSchoolBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_activity_this_school, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksActivityThisSchoolBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksActivityThisSchoolBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_activity_this_school, null, false, component);
    }

    @Nullable
    public ThisSchoolActivity.a f() {
        return this.f13956a;
    }

    @Nullable
    public ThisSchoolVM g() {
        return this.f13957a;
    }

    public abstract void l(@Nullable ThisSchoolActivity.a click);

    public abstract void m(@Nullable ThisSchoolVM vm);
}
