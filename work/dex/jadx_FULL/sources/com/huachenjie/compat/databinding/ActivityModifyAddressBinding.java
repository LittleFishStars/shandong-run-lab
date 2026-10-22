package com.huachenjie.compat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.compat.R;
import com.huachenjie.compat.page.personal.ModifyAddressActivity;
import com.huachenjie.compat.page.personal.ModifyAddressVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class ActivityModifyAddressBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f34034a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final EditText f9106a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f9107a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9108a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ModifyAddressActivity.a f9109a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ModifyAddressVM f9110a;

    @NonNull
    public final View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f9111b;

    @NonNull
    public final View c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f9112c;

    public ActivityModifyAddressBinding(Object obj, View view, int i, EditText editText, ImageView imageView, TextView textView, TextView textView2, TextView textView3, View view2, View view3, View view4) {
        super(obj, view, i);
        this.f9106a = editText;
        this.f9107a = imageView;
        this.f9108a = textView;
        this.f9111b = textView2;
        this.f9112c = textView3;
        this.f34034a = view2;
        this.b = view3;
        this.c = view4;
    }

    public static ActivityModifyAddressBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityModifyAddressBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityModifyAddressBinding) ViewDataBinding.bind(obj, view, R.layout.activity_modify_address);
    }

    @NonNull
    public static ActivityModifyAddressBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityModifyAddressBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityModifyAddressBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityModifyAddressBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_modify_address, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityModifyAddressBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityModifyAddressBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_modify_address, null, false, obj);
    }

    @Nullable
    public ModifyAddressActivity.a f() {
        return this.f9109a;
    }

    @Nullable
    public ModifyAddressVM g() {
        return this.f9110a;
    }

    public abstract void l(@Nullable ModifyAddressActivity.a aVar);

    public abstract void m(@Nullable ModifyAddressVM modifyAddressVM);
}
