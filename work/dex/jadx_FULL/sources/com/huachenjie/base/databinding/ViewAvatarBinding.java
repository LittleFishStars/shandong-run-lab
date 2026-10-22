package com.huachenjie.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.base.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class ViewAvatarBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f32872a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f7137a;

    @NonNull
    public final View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ImageView f7138b;

    public ViewAvatarBinding(@NonNull View rootView, @NonNull ImageView avatarFrameIcon, @NonNull ImageView avatarIcon, @NonNull View avatarSelect) {
        this.f32872a = rootView;
        this.f7137a = avatarFrameIcon;
        this.f7138b = avatarIcon;
        this.b = avatarSelect;
    }

    @NonNull
    public static ViewAvatarBinding a(@NonNull View rootView) {
        View viewFindChildViewById;
        int i = R.id.avatar_frame_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.avatar_icon;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.avatar_select))) != null) {
                return new ViewAvatarBinding(rootView, imageView, imageView2, viewFindChildViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static ViewAvatarBinding b(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        if (parent == null) {
            throw new NullPointerException("parent");
        }
        inflater.inflate(R.layout.view_avatar, parent);
        return a(parent);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f32872a;
    }
}
