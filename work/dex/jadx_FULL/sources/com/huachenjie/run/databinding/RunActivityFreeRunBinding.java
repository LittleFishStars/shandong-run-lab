package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.run.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunActivityFreeRunBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f35463a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f11478a;

    @NonNull
    public final FrameLayout b;

    public RunActivityFreeRunBinding(@NonNull RelativeLayout rootView, @NonNull FrameLayout flCountdownContainer, @NonNull FrameLayout flMapContainer) {
        this.f11478a = rootView;
        this.f35463a = flCountdownContainer;
        this.b = flMapContainer;
    }

    @NonNull
    public static RunActivityFreeRunBinding a(@NonNull View rootView) {
        int i = R.id.fl_countdown_container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
        if (frameLayout != null) {
            i = R.id.fl_map_container;
            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
            if (frameLayout2 != null) {
                return new RunActivityFreeRunBinding((RelativeLayout) rootView, frameLayout, frameLayout2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static RunActivityFreeRunBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunActivityFreeRunBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_activity_free_run, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f11478a;
    }
}
