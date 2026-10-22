package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.run.R;
import com.huachenjie.run.page.ai_deduction.AiDeductionDetailVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunActivityAiDeductionDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f35446a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f11419a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AiDeductionDetailVM f11420a;

    public RunActivityAiDeductionDetailBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView recyclerView, LayoutToolbarBindingBinding titleBar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35446a = recyclerView;
        this.f11419a = titleBar;
    }

    public static RunActivityAiDeductionDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunActivityAiDeductionDetailBinding d(@NonNull View view, @Nullable Object component) {
        return (RunActivityAiDeductionDetailBinding) ViewDataBinding.bind(component, view, R.layout.run_activity_ai_deduction_detail);
    }

    @NonNull
    public static RunActivityAiDeductionDetailBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunActivityAiDeductionDetailBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunActivityAiDeductionDetailBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunActivityAiDeductionDetailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_ai_deduction_detail, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunActivityAiDeductionDetailBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunActivityAiDeductionDetailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_ai_deduction_detail, null, false, component);
    }

    @Nullable
    public AiDeductionDetailVM f() {
        return this.f11420a;
    }

    public abstract void k(@Nullable AiDeductionDetailVM vm);
}
