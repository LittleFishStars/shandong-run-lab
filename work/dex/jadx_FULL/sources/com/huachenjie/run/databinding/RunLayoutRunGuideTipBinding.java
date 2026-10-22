package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.run.R;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunLayoutRunGuideTipBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35692a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12145a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f12146a;

    public RunLayoutRunGuideTipBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivTipMascot, LinearLayout rlTopTips, BLTextView tvTip1) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35692a = ivTipMascot;
        this.f12145a = rlTopTips;
        this.f12146a = tvTip1;
    }

    public static RunLayoutRunGuideTipBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunLayoutRunGuideTipBinding d(@NonNull View view, @Nullable Object component) {
        return (RunLayoutRunGuideTipBinding) ViewDataBinding.bind(component, view, R.layout.run_layout_run_guide_tip);
    }

    @NonNull
    public static RunLayoutRunGuideTipBinding e(@NonNull LayoutInflater inflater) {
        return h(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunLayoutRunGuideTipBinding f(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return g(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunLayoutRunGuideTipBinding g(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunLayoutRunGuideTipBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_run_guide_tip, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunLayoutRunGuideTipBinding h(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunLayoutRunGuideTipBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_run_guide_tip, null, false, component);
    }
}
