package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.contrarywind.view.WheelView;
import com.huachenjie.common.widget.CustomerTextView;
import com.huachenjie.run.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunLayoutDurationTargetBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f35655a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final WheelView f12031a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CustomerTextView f12032a;

    @NonNull
    public final WheelView b;

    @NonNull
    public final WheelView c;

    public RunLayoutDurationTargetBinding(Object _bindingComponent, View _root, int _localFieldCount, WheelView durationOptions1, WheelView durationOptions2, WheelView durationOptions3, RelativeLayout rlDurationRuler, CustomerTextView tvDurationTarget) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f12031a = durationOptions1;
        this.b = durationOptions2;
        this.c = durationOptions3;
        this.f35655a = rlDurationRuler;
        this.f12032a = tvDurationTarget;
    }

    public static RunLayoutDurationTargetBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunLayoutDurationTargetBinding d(@NonNull View view, @Nullable Object component) {
        return (RunLayoutDurationTargetBinding) ViewDataBinding.bind(component, view, R.layout.run_layout_duration_target);
    }

    @NonNull
    public static RunLayoutDurationTargetBinding e(@NonNull LayoutInflater inflater) {
        return h(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunLayoutDurationTargetBinding f(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return g(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunLayoutDurationTargetBinding g(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunLayoutDurationTargetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_duration_target, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunLayoutDurationTargetBinding h(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunLayoutDurationTargetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_duration_target, null, false, component);
    }
}
