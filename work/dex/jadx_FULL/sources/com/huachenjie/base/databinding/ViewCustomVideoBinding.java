package com.huachenjie.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.base.R;
import com.huachenjie.base.view.CustomTextureView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class ViewCustomVideoBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f32873a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f7139a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CustomTextureView f7140a;

    @NonNull
    public final ImageView b;

    public ViewCustomVideoBinding(@NonNull View rootView, @NonNull CustomTextureView customTextureView, @NonNull ImageView ivControl, @NonNull ImageView ivThumbnail) {
        this.f32873a = rootView;
        this.f7140a = customTextureView;
        this.f7139a = ivControl;
        this.b = ivThumbnail;
    }

    @NonNull
    public static ViewCustomVideoBinding a(@NonNull View rootView) {
        int i = R.id.custom_texture_view;
        CustomTextureView customTextureView = (CustomTextureView) ViewBindings.findChildViewById(rootView, i);
        if (customTextureView != null) {
            i = R.id.iv_control;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.iv_thumbnail;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView2 != null) {
                    return new ViewCustomVideoBinding(rootView, customTextureView, imageView, imageView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static ViewCustomVideoBinding b(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        if (parent == null) {
            throw new NullPointerException("parent");
        }
        inflater.inflate(R.layout.view_custom_video, parent);
        return a(parent);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f32873a;
    }
}
