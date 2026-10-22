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
import com.huachenjie.sport.bean.SportTestItemBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemSportTestBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36526a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SportTestItemBean f13634a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Boolean f13635a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public ItemSportTestBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f36526a = textView;
        this.b = textView2;
        this.c = textView3;
    }

    public static ItemSportTestBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSportTestBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemSportTestBinding) ViewDataBinding.bind(obj, view, R.layout.item_sport_test);
    }

    @NonNull
    public static ItemSportTestBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemSportTestBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemSportTestBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemSportTestBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_sport_test, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemSportTestBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemSportTestBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_sport_test, null, false, obj);
    }

    @Nullable
    public Boolean f() {
        return this.f13635a;
    }

    @Nullable
    public SportTestItemBean g() {
        return this.f13634a;
    }

    public abstract void l(@Nullable Boolean bool);

    public abstract void m(@Nullable SportTestItemBean sportTestItemBean);
}
