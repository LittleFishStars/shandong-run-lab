package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.address.edit.ShippingAddressEditActivity;
import com.huachenjie.mall.page.address.edit.ShippingAddressEditVM;
import com.noober.background.view.BLConstraintLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityShippingAddressEditBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f34863a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final EditText f10412a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f10413a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10414a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwitchCompat f10415a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f10416a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ShippingAddressEditActivity.a f10417a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ShippingAddressEditVM f10418a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f10419a;

    @NonNull
    public final View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final EditText f10420b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f10421b;

    @NonNull
    public final View c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final EditText f10422c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f10423c;

    @NonNull
    public final View d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final TextView f10424d;

    public MallActivityShippingAddressEditBinding(Object obj, View view, int i, TextView textView, EditText editText, EditText editText2, EditText editText3, FrameLayout frameLayout, View view2, View view3, View view4, View view5, SwitchCompat switchCompat, LayoutToolbarBindingBinding layoutToolbarBindingBinding, TextView textView2, TextView textView3, TextView textView4, BLConstraintLayout bLConstraintLayout) {
        super(obj, view, i);
        this.f10414a = textView;
        this.f10412a = editText;
        this.f10420b = editText2;
        this.f10422c = editText3;
        this.f10413a = frameLayout;
        this.f34863a = view2;
        this.b = view3;
        this.c = view4;
        this.d = view5;
        this.f10415a = switchCompat;
        this.f10416a = layoutToolbarBindingBinding;
        this.f10421b = textView2;
        this.f10423c = textView3;
        this.f10424d = textView4;
        this.f10419a = bLConstraintLayout;
    }

    public static MallActivityShippingAddressEditBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityShippingAddressEditBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityShippingAddressEditBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_shipping_address_edit);
    }

    @NonNull
    public static MallActivityShippingAddressEditBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityShippingAddressEditBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityShippingAddressEditBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityShippingAddressEditBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_shipping_address_edit, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityShippingAddressEditBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityShippingAddressEditBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_shipping_address_edit, null, false, obj);
    }

    @Nullable
    public ShippingAddressEditActivity.a f() {
        return this.f10417a;
    }

    @Nullable
    public ShippingAddressEditVM g() {
        return this.f10418a;
    }

    public abstract void l(@Nullable ShippingAddressEditActivity.a aVar);

    public abstract void m(@Nullable ShippingAddressEditVM shippingAddressEditVM);
}
