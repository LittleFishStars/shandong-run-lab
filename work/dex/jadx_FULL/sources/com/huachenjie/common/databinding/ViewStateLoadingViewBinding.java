package com.huachenjie.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.common.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final class ViewStateLoadingViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ViewStub f33805a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f8749a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ProgressBar f8750a;

    @NonNull
    public final FrameLayout b;

    public ViewStateLoadingViewBinding(@NonNull FrameLayout rootView, @NonNull FrameLayout flLoading, @NonNull ProgressBar progressWheel, @NonNull ViewStub vsError) {
        this.f8749a = rootView;
        this.b = flLoading;
        this.f8750a = progressWheel;
        this.f33805a = vsError;
    }

    @NonNull
    public static ViewStateLoadingViewBinding a(@NonNull View rootView) {
        FrameLayout frameLayout = (FrameLayout) rootView;
        int i = R.id.progress_wheel;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
        if (progressBar != null) {
            i = R.id.vs_error;
            ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(rootView, i);
            if (viewStub != null) {
                return new ViewStateLoadingViewBinding(frameLayout, frameLayout, progressBar, viewStub);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static ViewStateLoadingViewBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static ViewStateLoadingViewBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.view_state_loading_view, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f8749a;
    }
}
