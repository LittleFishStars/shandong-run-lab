package com.huachenjie.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.common.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final class LayoutToolbarBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f33785a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8697a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final Toolbar f8698a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f8699b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final Toolbar f8700b;

    @NonNull
    public final TextView c;

    public LayoutToolbarBinding(@NonNull Toolbar rootView, @NonNull ImageView imgBack, @NonNull ImageView imgMenu, @NonNull Toolbar toolbar, @NonNull TextView tvMenu, @NonNull TextView tvSubTitle, @NonNull TextView tvTitle) {
        this.f8698a = rootView;
        this.f33785a = imgBack;
        this.b = imgMenu;
        this.f8700b = toolbar;
        this.f8697a = tvMenu;
        this.f8699b = tvSubTitle;
        this.c = tvTitle;
    }

    @NonNull
    public static LayoutToolbarBinding a(@NonNull View rootView) {
        int i = R.id.img_back;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.img_menu;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView2 != null) {
                Toolbar toolbar = (Toolbar) rootView;
                i = R.id.tv_menu;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.tv_sub_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        i = R.id.tv_title;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null) {
                            return new LayoutToolbarBinding(toolbar, imageView, imageView2, toolbar, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static LayoutToolbarBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static LayoutToolbarBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.layout_toolbar, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Toolbar getRoot() {
        return this.f8698a;
    }
}
