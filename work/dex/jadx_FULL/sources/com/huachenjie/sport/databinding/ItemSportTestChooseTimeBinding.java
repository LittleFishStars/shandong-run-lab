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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemSportTestChooseTimeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36530a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Boolean f13645a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Bindable
    public Boolean f13646b;

    public ItemSportTestChooseTimeBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f36530a = textView;
        this.b = textView2;
    }

    public static ItemSportTestChooseTimeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSportTestChooseTimeBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemSportTestChooseTimeBinding) ViewDataBinding.bind(obj, view, R.layout.item_sport_test_choose_time);
    }

    @NonNull
    public static ItemSportTestChooseTimeBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemSportTestChooseTimeBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemSportTestChooseTimeBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemSportTestChooseTimeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_sport_test_choose_time, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemSportTestChooseTimeBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemSportTestChooseTimeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_sport_test_choose_time, null, false, obj);
    }

    @Nullable
    public Boolean f() {
        return this.f13646b;
    }

    @Nullable
    public Boolean g() {
        return this.f13645a;
    }

    public abstract void l(@Nullable Boolean bool);

    public abstract void m(@Nullable Boolean bool);
}
