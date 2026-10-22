package com.huachenjie.compat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.compat.R;
import com.huachenjie.compat.page.student.UserFaceActivity;
import com.huachenjie.compat.page.student.UserFaceVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class CompatActivityUserFaceBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LayoutToolbarBindingBinding f34061a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public UserFaceActivity.ClickProxy f9189a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public UserFaceVM f9190a;

    public CompatActivityUserFaceBinding(Object obj, View view, int i, LayoutToolbarBindingBinding layoutToolbarBindingBinding) {
        super(obj, view, i);
        this.f34061a = layoutToolbarBindingBinding;
    }

    public static CompatActivityUserFaceBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CompatActivityUserFaceBinding d(@NonNull View view, @Nullable Object obj) {
        return (CompatActivityUserFaceBinding) ViewDataBinding.bind(obj, view, R.layout.compat_activity_user_face);
    }

    @NonNull
    public static CompatActivityUserFaceBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static CompatActivityUserFaceBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static CompatActivityUserFaceBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (CompatActivityUserFaceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.compat_activity_user_face, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static CompatActivityUserFaceBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (CompatActivityUserFaceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.compat_activity_user_face, null, false, obj);
    }

    @Nullable
    public UserFaceActivity.ClickProxy f() {
        return this.f9189a;
    }

    @Nullable
    public UserFaceVM g() {
        return this.f9190a;
    }

    public abstract void l(@Nullable UserFaceActivity.ClickProxy clickProxy);

    public abstract void m(@Nullable UserFaceVM userFaceVM);
}
