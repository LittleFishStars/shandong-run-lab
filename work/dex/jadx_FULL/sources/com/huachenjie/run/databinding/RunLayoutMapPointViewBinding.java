package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.run.R;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunLayoutMapPointViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f35673a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f12091a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12092a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f12093a;

    @NonNull
    public final BLTextView b;

    public RunLayoutMapPointViewBinding(@NonNull View rootView, @NonNull ImageView ivGuide, @NonNull BLTextView tvNFC, @NonNull BLTextView tvName, @NonNull TextView tvText) {
        this.f35673a = rootView;
        this.f12091a = ivGuide;
        this.f12093a = tvNFC;
        this.b = tvName;
        this.f12092a = tvText;
    }

    @NonNull
    public static RunLayoutMapPointViewBinding a(@NonNull View rootView) {
        BLTextView bLTextViewFindChildViewById;
        BLTextView bLTextViewFindChildViewById2;
        int i = R.id.ivGuide;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null && (bLTextViewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.tvNFC))) != null && (bLTextViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.tvName))) != null) {
            i = R.id.tvText;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                return new RunLayoutMapPointViewBinding(rootView, imageView, bLTextViewFindChildViewById, bLTextViewFindChildViewById2, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static RunLayoutMapPointViewBinding b(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        if (parent == null) {
            throw new NullPointerException("parent");
        }
        inflater.inflate(R.layout.run_layout_map_point_view, parent);
        return a(parent);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f35673a;
    }
}
