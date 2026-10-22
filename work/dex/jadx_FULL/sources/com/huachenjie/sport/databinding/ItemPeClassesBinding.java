package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.PEClassBean;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemPeClassesBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36519a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PEClassBean f13616a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f13617a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Integer f13618a;

    public ItemPeClassesBinding(Object obj, View view, int i, TextView textView, BLTextView bLTextView) {
        super(obj, view, i);
        this.f36519a = textView;
        this.f13617a = bLTextView;
    }

    public static ItemPeClassesBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemPeClassesBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemPeClassesBinding) ViewDataBinding.bind(obj, view, R.layout.item_pe_classes);
    }

    @NonNull
    public static ItemPeClassesBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemPeClassesBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemPeClassesBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemPeClassesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_pe_classes, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemPeClassesBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemPeClassesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_pe_classes, null, false, obj);
    }

    @Nullable
    public PEClassBean f() {
        return this.f13616a;
    }

    @Nullable
    public Integer getType() {
        return this.f13618a;
    }

    public abstract void k(@Nullable Integer num);

    public abstract void l(@Nullable PEClassBean pEClassBean);
}
