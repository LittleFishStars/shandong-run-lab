package com.huachenjie.im.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.im.R;
import com.noober.background.view.BLImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class IncludeCustomShareLinkBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f34451a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9773a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f9774a;

    @NonNull
    public final TextView b;

    public IncludeCustomShareLinkBinding(@NonNull View view, @NonNull TextView textView, @NonNull BLImageView bLImageView, @NonNull TextView textView2) {
        this.f34451a = view;
        this.f9773a = textView;
        this.f9774a = bLImageView;
        this.b = textView2;
    }

    @NonNull
    public static IncludeCustomShareLinkBinding a(@NonNull View view) {
        BLImageView bLImageViewFindChildViewById;
        int i = R.id.share_link_des;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null && (bLImageViewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.share_link_image))) != null) {
            i = R.id.share_link_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                return new IncludeCustomShareLinkBinding(view, textView, bLImageViewFindChildViewById, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static IncludeCustomShareLinkBinding b(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R.layout.include_custom_share_link, viewGroup);
        return a(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f34451a;
    }
}
