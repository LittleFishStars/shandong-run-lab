package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.apply_refund.ApplyRefundActivity;
import com.huachenjie.mall.page.apply_refund.ApplyRefundVM;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityApplyRefundBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final EditText f34764a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10125a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RadioButton f10126a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RadioGroup f10127a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10128a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f10129a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ApplyRefundActivity.ClickProxy f10130a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ApplyRefundVM f10131a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f10132a;

    @NonNull
    public final RadioButton b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f10133b;

    @NonNull
    public final TextView c;

    public MallActivityApplyRefundBinding(Object obj, View view, int i, EditText editText, ImageView imageView, RadioButton radioButton, RadioButton radioButton2, RadioGroup radioGroup, LayoutToolbarBindingBinding layoutToolbarBindingBinding, BLTextView bLTextView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f34764a = editText;
        this.f10125a = imageView;
        this.f10126a = radioButton;
        this.b = radioButton2;
        this.f10127a = radioGroup;
        this.f10129a = layoutToolbarBindingBinding;
        this.f10132a = bLTextView;
        this.f10128a = textView;
        this.f10133b = textView2;
        this.c = textView3;
    }

    public static MallActivityApplyRefundBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityApplyRefundBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityApplyRefundBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_apply_refund);
    }

    @NonNull
    public static MallActivityApplyRefundBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityApplyRefundBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityApplyRefundBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityApplyRefundBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_apply_refund, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityApplyRefundBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityApplyRefundBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_apply_refund, null, false, obj);
    }

    @Nullable
    public ApplyRefundActivity.ClickProxy f() {
        return this.f10130a;
    }

    @Nullable
    public ApplyRefundVM g() {
        return this.f10131a;
    }

    public abstract void l(@Nullable ApplyRefundActivity.ClickProxy clickProxy);

    public abstract void m(@Nullable ApplyRefundVM applyRefundVM);
}
