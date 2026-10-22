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
import com.huachenjie.common.widget.ShadowLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final class LayoutToolbarRoundIconBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f33793a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8714a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final Toolbar f8715a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShadowLayout f8716a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f8717b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final Toolbar f8718b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ShadowLayout f8719b;

    public LayoutToolbarRoundIconBinding(@NonNull Toolbar rootView, @NonNull ImageView imgBack, @NonNull ImageView imgMenu, @NonNull ShadowLayout slBack, @NonNull ShadowLayout slMenu, @NonNull Toolbar toolbar, @NonNull TextView tvSubTitle, @NonNull TextView tvTitle) {
        this.f8715a = rootView;
        this.f33793a = imgBack;
        this.b = imgMenu;
        this.f8716a = slBack;
        this.f8719b = slMenu;
        this.f8718b = toolbar;
        this.f8714a = tvSubTitle;
        this.f8717b = tvTitle;
    }

    @NonNull
    public static LayoutToolbarRoundIconBinding a(@NonNull View rootView) {
        int i = R.id.img_back;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.img_menu;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView2 != null) {
                i = R.id.sl_back;
                ShadowLayout shadowLayout = (ShadowLayout) ViewBindings.findChildViewById(rootView, i);
                if (shadowLayout != null) {
                    i = R.id.sl_menu;
                    ShadowLayout shadowLayout2 = (ShadowLayout) ViewBindings.findChildViewById(rootView, i);
                    if (shadowLayout2 != null) {
                        Toolbar toolbar = (Toolbar) rootView;
                        i = R.id.tv_sub_title;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView != null) {
                            i = R.id.tv_title;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView2 != null) {
                                return new LayoutToolbarRoundIconBinding(toolbar, imageView, imageView2, shadowLayout, shadowLayout2, toolbar, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static LayoutToolbarRoundIconBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static LayoutToolbarRoundIconBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.layout_toolbar_round_icon, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Toolbar getRoot() {
        return this.f8715a;
    }
}
