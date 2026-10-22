package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.InspirationRecordBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeItemInspirationRecordGetBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f34279a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9495a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public InspirationRecordBean f9496a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public HomeItemInspirationRecordGetBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, View view2) {
        super(obj, view, i);
        this.f9495a = textView;
        this.b = textView2;
        this.c = textView3;
        this.f34279a = view2;
    }

    public static HomeItemInspirationRecordGetBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeItemInspirationRecordGetBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeItemInspirationRecordGetBinding) ViewDataBinding.bind(obj, view, R.layout.home_item_inspiration_record_get);
    }

    @NonNull
    public static HomeItemInspirationRecordGetBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeItemInspirationRecordGetBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeItemInspirationRecordGetBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeItemInspirationRecordGetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_inspiration_record_get, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeItemInspirationRecordGetBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeItemInspirationRecordGetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_inspiration_record_get, null, false, obj);
    }

    @Nullable
    public InspirationRecordBean f() {
        return this.f9496a;
    }

    public abstract void k(@Nullable InspirationRecordBean inspirationRecordBean);
}
