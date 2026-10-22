package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.run.R;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunLayoutMapPointPassedBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f35672a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f12089a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f12090a;

    public RunLayoutMapPointPassedBinding(@NonNull View rootView, @NonNull ImageView ivIcon, @NonNull BLTextView tvNFC) {
        this.f35672a = rootView;
        this.f12089a = ivIcon;
        this.f12090a = tvNFC;
    }

    @NonNull
    public static RunLayoutMapPointPassedBinding a(@NonNull View rootView) {
        BLTextView bLTextViewFindChildViewById;
        int i = R.id.ivIcon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView == null || (bLTextViewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.tvNFC))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
        }
        return new RunLayoutMapPointPassedBinding(rootView, imageView, bLTextViewFindChildViewById);
    }

    @NonNull
    public static RunLayoutMapPointPassedBinding b(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        if (parent == null) {
            throw new NullPointerException("parent");
        }
        inflater.inflate(R.layout.run_layout_map_point_passed, parent);
        return a(parent);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f35672a;
    }
}
