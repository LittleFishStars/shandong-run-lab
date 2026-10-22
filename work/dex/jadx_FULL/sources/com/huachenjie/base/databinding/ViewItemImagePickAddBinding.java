package com.huachenjie.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.R;
import com.huachenjie.base.widget.image_pick.ImagePickBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class ViewItemImagePickAddBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public ImagePickBean f32874a;

    public ViewItemImagePickAddBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static ViewItemImagePickAddBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewItemImagePickAddBinding d(@NonNull View view, @Nullable Object component) {
        return (ViewItemImagePickAddBinding) ViewDataBinding.bind(component, view, R.layout.view_item_image_pick_add);
    }

    @NonNull
    public static ViewItemImagePickAddBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ViewItemImagePickAddBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ViewItemImagePickAddBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (ViewItemImagePickAddBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_item_image_pick_add, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static ViewItemImagePickAddBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (ViewItemImagePickAddBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_item_image_pick_add, null, false, component);
    }

    @Nullable
    public ImagePickBean f() {
        return this.f32874a;
    }

    public abstract void k(@Nullable ImagePickBean bean);
}
