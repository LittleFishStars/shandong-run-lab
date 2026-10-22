package com.huachenjie.im.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.im.R;
import com.huachenjie.im.vm.BaseSignalTowerVM;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class FragmentFloatingSignalTowerBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f34425a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f9697a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f9698a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9699a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f9700a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9701a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f9702a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseSignalTowerVM f9703a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f9704a;

    @NonNull
    public final View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ImageView f9705b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9706b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f9707b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final RecyclerView f9708b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final RecyclerView f9709c;

    @NonNull
    public final ImageView d;

    public FragmentFloatingSignalTowerBinding(Object obj, View view, int i, View view2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout, LinearLayout linearLayout2, RecyclerView recyclerView, View view3, RecyclerView recyclerView2, FrameLayout frameLayout, RelativeLayout relativeLayout, BLView bLView, TextView textView, TextView textView2, RecyclerView recyclerView3) {
        super(obj, view, i);
        this.f34425a = view2;
        this.f9698a = imageView;
        this.f9705b = imageView2;
        this.c = imageView3;
        this.d = imageView4;
        this.f9699a = linearLayout;
        this.f9706b = linearLayout2;
        this.f9702a = recyclerView;
        this.b = view3;
        this.f9708b = recyclerView2;
        this.f9697a = frameLayout;
        this.f9700a = relativeLayout;
        this.f9704a = bLView;
        this.f9701a = textView;
        this.f9707b = textView2;
        this.f9709c = recyclerView3;
    }

    public static FragmentFloatingSignalTowerBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFloatingSignalTowerBinding d(@NonNull View view, @Nullable Object obj) {
        return (FragmentFloatingSignalTowerBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_floating_signal_tower);
    }

    @NonNull
    public static FragmentFloatingSignalTowerBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentFloatingSignalTowerBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentFloatingSignalTowerBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentFloatingSignalTowerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_floating_signal_tower, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static FragmentFloatingSignalTowerBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentFloatingSignalTowerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_floating_signal_tower, null, false, obj);
    }

    @Nullable
    public BaseSignalTowerVM f() {
        return this.f9703a;
    }

    public abstract void k(@Nullable BaseSignalTowerVM baseSignalTowerVM);
}
