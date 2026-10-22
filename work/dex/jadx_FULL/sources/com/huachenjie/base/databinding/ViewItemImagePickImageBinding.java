package com.huachenjie.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.R;
import com.huachenjie.base.view.RoundImageView;
import com.huachenjie.base.widget.image_pick.ImagePickBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class ViewItemImagePickImageBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f32876a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RoundImageView f7145a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ImagePickBean f7146a;

    public ViewItemImagePickImageBinding(Object _bindingComponent, View _root, int _localFieldCount, RoundImageView ivCommodityImage, ImageView ivDelete) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f7145a = ivCommodityImage;
        this.f32876a = ivDelete;
    }

    public static ViewItemImagePickImageBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewItemImagePickImageBinding d(@NonNull View view, @Nullable Object component) {
        return (ViewItemImagePickImageBinding) ViewDataBinding.bind(component, view, R.layout.view_item_image_pick_image);
    }

    @NonNull
    public static ViewItemImagePickImageBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ViewItemImagePickImageBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ViewItemImagePickImageBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (ViewItemImagePickImageBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_item_image_pick_image, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static ViewItemImagePickImageBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (ViewItemImagePickImageBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_item_image_pick_image, null, false, component);
    }

    @Nullable
    public ImagePickBean f() {
        return this.f7146a;
    }

    public abstract void k(@Nullable ImagePickBean bean);
}
