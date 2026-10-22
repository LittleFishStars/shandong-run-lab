package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.DrinkDetailBean;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemReplenishEnergyListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f36185a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12973a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public DrinkDetailBean f12974a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f12975a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f12976a;

    public ItemReplenishEnergyListBinding(Object obj, View view, int i, ImageView imageView, BLLinearLayout bLLinearLayout, BLTextView bLTextView, TextView textView) {
        super(obj, view, i);
        this.f36185a = imageView;
        this.f12975a = bLLinearLayout;
        this.f12976a = bLTextView;
        this.f12973a = textView;
    }

    public static ItemReplenishEnergyListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemReplenishEnergyListBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemReplenishEnergyListBinding) ViewDataBinding.bind(obj, view, R.layout.item_replenish_energy_list);
    }

    @NonNull
    public static ItemReplenishEnergyListBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemReplenishEnergyListBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemReplenishEnergyListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemReplenishEnergyListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_replenish_energy_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemReplenishEnergyListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemReplenishEnergyListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_replenish_energy_list, null, false, obj);
    }

    @Nullable
    public DrinkDetailBean f() {
        return this.f12974a;
    }

    public abstract void k(@Nullable DrinkDetailBean drinkDetailBean);
}
