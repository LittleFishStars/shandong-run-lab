package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.run.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunLayoutFreeRunPanelModelBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f35663a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f12055a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f12056a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12057a;

    @NonNull
    public final FrameLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f12058b;

    @NonNull
    public final RelativeLayout c;

    public RunLayoutFreeRunPanelModelBinding(@NonNull RelativeLayout rootView, @NonNull FrameLayout flStaticContainer, @NonNull FrameLayout flTargetContainer, @NonNull ImageView imgMapEntry, @NonNull RelativeLayout rlMapEntry, @NonNull RelativeLayout rlPanelModel, @NonNull TextView tvTitle) {
        this.f12056a = rootView;
        this.f35663a = flStaticContainer;
        this.b = flTargetContainer;
        this.f12055a = imgMapEntry;
        this.f12058b = rlMapEntry;
        this.c = rlPanelModel;
        this.f12057a = tvTitle;
    }

    @NonNull
    public static RunLayoutFreeRunPanelModelBinding a(@NonNull View rootView) {
        int i = R.id.fl_static_container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
        if (frameLayout != null) {
            i = R.id.fl_target_container;
            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
            if (frameLayout2 != null) {
                i = R.id.img_map_entry;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView != null) {
                    i = R.id.rl_map_entry;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                    if (relativeLayout != null) {
                        RelativeLayout relativeLayout2 = (RelativeLayout) rootView;
                        i = R.id.tv_title;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView != null) {
                            return new RunLayoutFreeRunPanelModelBinding(relativeLayout2, frameLayout, frameLayout2, imageView, relativeLayout, relativeLayout2, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static RunLayoutFreeRunPanelModelBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunLayoutFreeRunPanelModelBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_layout_free_run_panel_model, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f12056a;
    }
}
