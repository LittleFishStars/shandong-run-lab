package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.dialog.ExchangeWorldCrystalsDialog;
import com.huachenjie.social_contact.vm.ExchangeWorldCrystalsVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class DialogExchangeWorldCrystalsBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f36143a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ExchangeWorldCrystalsDialog.a f12876a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ExchangeWorldCrystalsVM f12877a;

    @NonNull
    public final ImageView b;

    public DialogExchangeWorldCrystalsBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2) {
        super(obj, view, i);
        this.f36143a = imageView;
        this.b = imageView2;
    }

    public static DialogExchangeWorldCrystalsBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogExchangeWorldCrystalsBinding d(@NonNull View view, @Nullable Object obj) {
        return (DialogExchangeWorldCrystalsBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_exchange_world_crystals);
    }

    @NonNull
    public static DialogExchangeWorldCrystalsBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static DialogExchangeWorldCrystalsBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static DialogExchangeWorldCrystalsBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (DialogExchangeWorldCrystalsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_exchange_world_crystals, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static DialogExchangeWorldCrystalsBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (DialogExchangeWorldCrystalsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_exchange_world_crystals, null, false, obj);
    }

    @Nullable
    public ExchangeWorldCrystalsDialog.a f() {
        return this.f12876a;
    }

    @Nullable
    public ExchangeWorldCrystalsVM g() {
        return this.f12877a;
    }

    public abstract void l(@Nullable ExchangeWorldCrystalsDialog.a aVar);

    public abstract void m(@Nullable ExchangeWorldCrystalsVM exchangeWorldCrystalsVM);
}
