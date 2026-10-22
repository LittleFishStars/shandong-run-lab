package com.huachenjie.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.base.R;
import com.huachenjie.base.dsbridge_webview.WebContentView;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class ActivityDwebviewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f32804a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final WebContentView f6967a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f6968a;

    public ActivityDwebviewBinding(@NonNull LinearLayout rootView, @NonNull WebContentView dWebContentView, @NonNull LayoutToolbarBindingBinding headerBar) {
        this.f32804a = rootView;
        this.f6967a = dWebContentView;
        this.f6968a = headerBar;
    }

    @NonNull
    public static ActivityDwebviewBinding a(@NonNull View rootView) {
        View viewFindChildViewById;
        int i = R.id.dWebContentView;
        WebContentView webContentView = (WebContentView) ViewBindings.findChildViewById(rootView, i);
        if (webContentView == null || (viewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.headerBar))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
        }
        return new ActivityDwebviewBinding((LinearLayout) rootView, webContentView, LayoutToolbarBindingBinding.c(viewFindChildViewById));
    }

    @NonNull
    public static ActivityDwebviewBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static ActivityDwebviewBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_dwebview, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f32804a;
    }
}
