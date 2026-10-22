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
public abstract class RunLayoutCaloriesCostedTargetBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f35645a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12005a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CustomerTextView f12006a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final VerticalRulerView f12007a;

    public RunLayoutCaloriesCostedTargetBinding(Object _bindingComponent, View _root, int _localFieldCount, RelativeLayout rlCaloriasRuler, VerticalRulerView rulerCalorias, CustomerTextView tvCaloriesTarget, TextView tvCustomCalories) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35645a = rlCaloriasRuler;
        this.f12007a = rulerCalorias;
        this.f12006a = tvCaloriesTarget;
        this.f12005a = tvCustomCalories;
    }

    public static RunLayoutCaloriesCostedTargetBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunLayoutCaloriesCostedTargetBinding d(@NonNull View view, @Nullable Object component) {
        return (RunLayoutCaloriesCostedTargetBinding) ViewDataBinding.bind(component, view, R.layout.run_layout_calories_costed_target);
    }

    @NonNull
    public static RunLayoutCaloriesCostedTargetBinding e(@NonNull LayoutInflater inflater) {
        return h(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunLayoutCaloriesCostedTargetBinding f(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return g(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunLayoutCaloriesCostedTargetBinding g(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunLayoutCaloriesCostedTargetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_calories_costed_target, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunLayoutCaloriesCostedTargetBinding h(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunLayoutCaloriesCostedTargetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_calories_costed_target, null, false, component);
    }
}
