package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RunRewardBean;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunRunItemRunRewardBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f35745a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RunRewardBean f12304a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f12305a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    public RunRunItemRunRewardBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView btRemarkLook, TextView tvDistanceLabel, BLTextView tvIndex, TextView tvName, TextView tvRemarkContent, TextView tvRemarkLabel, TextView tvTimeLabel, TextView tvTimesLabel) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35745a = btRemarkLook;
        this.b = tvDistanceLabel;
        this.f12305a = tvIndex;
        this.c = tvName;
        this.d = tvRemarkContent;
        this.e = tvRemarkLabel;
        this.f = tvTimeLabel;
        this.g = tvTimesLabel;
    }

    public static RunRunItemRunRewardBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunRunItemRunRewardBinding d(@NonNull View view, @Nullable Object component) {
        return (RunRunItemRunRewardBinding) ViewDataBinding.bind(component, view, R.layout.run_run_item_run_reward);
    }

    @NonNull
    public static RunRunItemRunRewardBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunRunItemRunRewardBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunRunItemRunRewardBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunRunItemRunRewardBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_run_item_run_reward, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunRunItemRunRewardBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunRunItemRunRewardBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_run_item_run_reward, null, false, component);
    }

    @Nullable
    public RunRewardBean f() {
        return this.f12304a;
    }

    public abstract void k(@Nullable RunRewardBean bean);
}
