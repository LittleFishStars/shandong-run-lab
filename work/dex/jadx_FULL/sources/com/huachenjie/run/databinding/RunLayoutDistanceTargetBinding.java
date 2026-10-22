package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.widget.CustomerTextView;
import com.huachenjie.common.widget.ruler.VerticalRulerView;
import com.huachenjie.run.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunLayoutDistanceTargetBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f35651a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12020a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CustomerTextView f12021a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final VerticalRulerView f12022a;

    public RunLayoutDistanceTargetBinding(Object _bindingComponent, View _root, int _localFieldCount, RelativeLayout rlDistanceRuler, VerticalRulerView rulerDistance, TextView tvCustomDistance, CustomerTextView tvDistanceTarget) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35651a = rlDistanceRuler;
        this.f12022a = rulerDistance;
        this.f12020a = tvCustomDistance;
        this.f12021a = tvDistanceTarget;
    }

    public static RunLayoutDistanceTargetBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunLayoutDistanceTargetBinding d(@NonNull View view, @Nullable Object component) {
        return (RunLayoutDistanceTargetBinding) ViewDataBinding.bind(component, view, R.layout.run_layout_distance_target);
    }

    @NonNull
    public static RunLayoutDistanceTargetBinding e(@NonNull LayoutInflater inflater) {
        return h(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunLayoutDistanceTargetBinding f(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return g(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunLayoutDistanceTargetBinding g(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunLayoutDistanceTargetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_distance_target, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunLayoutDistanceTargetBinding h(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunLayoutDistanceTargetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_distance_target, null, false, component);
    }
}
