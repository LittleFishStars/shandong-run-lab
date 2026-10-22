package com.huachenjie.im.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.im.R;
import com.huachenjie.im.page.SignalTowerFragment;
import com.huachenjie.im.vm.SignalTowerVM;
import com.noober.background.view.BLLinearLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class FragmentSignalTowerBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f34435a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f9728a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9729a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f9730a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SignalTowerFragment.h f9731a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SignalTowerVM f9732a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f9733a;

    @NonNull
    public final FrameLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f9734b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final RecyclerView f9735b;

    @NonNull
    public final TextView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final RecyclerView f9736c;

    public FragmentSignalTowerBinding(Object obj, View view, int i, BLLinearLayout bLLinearLayout, TextView textView, View view2, TextView textView2, FrameLayout frameLayout, FrameLayout frameLayout2, RecyclerView recyclerView, RecyclerView recyclerView2, RecyclerView recyclerView3, TextView textView3) {
        super(obj, view, i);
        this.f9733a = bLLinearLayout;
        this.f9729a = textView;
        this.f34435a = view2;
        this.f9734b = textView2;
        this.f9728a = frameLayout;
        this.b = frameLayout2;
        this.f9730a = recyclerView;
        this.f9735b = recyclerView2;
        this.f9736c = recyclerView3;
        this.c = textView3;
    }

    public static FragmentSignalTowerBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSignalTowerBinding d(@NonNull View view, @Nullable Object obj) {
        return (FragmentSignalTowerBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_signal_tower);
    }

    @NonNull
    public static FragmentSignalTowerBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentSignalTowerBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentSignalTowerBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentSignalTowerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_signal_tower, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static FragmentSignalTowerBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentSignalTowerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_signal_tower, null, false, obj);
    }

    @Nullable
    public SignalTowerFragment.h f() {
        return this.f9731a;
    }

    @Nullable
    public SignalTowerVM g() {
        return this.f9732a;
    }

    public abstract void l(@Nullable SignalTowerFragment.h hVar);

    public abstract void m(@Nullable SignalTowerVM signalTowerVM);
}
