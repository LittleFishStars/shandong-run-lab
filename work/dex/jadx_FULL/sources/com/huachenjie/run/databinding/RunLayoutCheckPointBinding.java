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
public final class RunLayoutCheckPointBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f35649a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f12016a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f12017a;

    @NonNull
    public final BLTextView b;

    public RunLayoutCheckPointBinding(@NonNull View rootView, @NonNull ImageView ivIcon, @NonNull BLTextView tvNFC, @NonNull BLTextView tvName) {
        this.f35649a = rootView;
        this.f12016a = ivIcon;
        this.f12017a = tvNFC;
        this.b = tvName;
    }

    @NonNull
    public static RunLayoutCheckPointBinding a(@NonNull View rootView) {
        BLTextView bLTextViewFindChildViewById;
        BLTextView bLTextViewFindChildViewById2;
        int i = R.id.ivIcon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView == null || (bLTextViewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.tvNFC))) == null || (bLTextViewFindChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.tvName))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
        }
        return new RunLayoutCheckPointBinding(rootView, imageView, bLTextViewFindChildViewById, bLTextViewFindChildViewById2);
    }

    @NonNull
    public static RunLayoutCheckPointBinding b(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        if (parent == null) {
            throw new NullPointerException("parent");
        }
        inflater.inflate(R.layout.run_layout_check_point, parent);
        return a(parent);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f35649a;
    }
}
