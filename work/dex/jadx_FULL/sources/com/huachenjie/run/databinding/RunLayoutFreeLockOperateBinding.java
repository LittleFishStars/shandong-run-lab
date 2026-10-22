package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.common.widget.ShrinkScrollView;
import com.huachenjie.run.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunLayoutFreeLockOperateBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f35659a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShrinkScrollView f12039a;

    @NonNull
    public final FrameLayout b;

    public RunLayoutFreeLockOperateBinding(@NonNull FrameLayout rootView, @NonNull FrameLayout flLock, @NonNull ShrinkScrollView scrollLock) {
        this.f35659a = rootView;
        this.b = flLock;
        this.f12039a = scrollLock;
    }

    @NonNull
    public static RunLayoutFreeLockOperateBinding a(@NonNull View rootView) {
        FrameLayout frameLayout = (FrameLayout) rootView;
        int i = R.id.scroll_lock;
        ShrinkScrollView shrinkScrollView = (ShrinkScrollView) ViewBindings.findChildViewById(rootView, i);
        if (shrinkScrollView != null) {
            return new RunLayoutFreeLockOperateBinding(frameLayout, frameLayout, shrinkScrollView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static RunLayoutFreeLockOperateBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunLayoutFreeLockOperateBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_layout_free_lock_operate, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f35659a;
    }
}
