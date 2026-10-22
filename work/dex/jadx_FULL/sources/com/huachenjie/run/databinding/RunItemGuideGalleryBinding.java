package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.imageview.ShapeableImageView;
import com.huachenjie.run.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunItemGuideGalleryBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f35618a;

    @NonNull
    public final ShapeableImageView b;

    public RunItemGuideGalleryBinding(@NonNull ShapeableImageView rootView, @NonNull ShapeableImageView imgGuide) {
        this.f35618a = rootView;
        this.b = imgGuide;
    }

    @NonNull
    public static RunItemGuideGalleryBinding a(@NonNull View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        ShapeableImageView shapeableImageView = (ShapeableImageView) rootView;
        return new RunItemGuideGalleryBinding(shapeableImageView, shapeableImageView);
    }

    @NonNull
    public static RunItemGuideGalleryBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunItemGuideGalleryBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_item_guide_gallery, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ShapeableImageView getRoot() {
        return this.f35618a;
    }
}
