package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.dialog.express.FillExpressDialog;
import com.huachenjie.mall.dialog.express.FillExpressVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallDialogFillExpressBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f34907a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final EditText f10542a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10543a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10544a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public FillExpressDialog.a f10545a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public FillExpressVM f10546a;

    public MallDialogFillExpressBinding(Object obj, View view, int i, EditText editText, LinearLayout linearLayout, TextView textView, View view2) {
        super(obj, view, i);
        this.f10542a = editText;
        this.f10543a = linearLayout;
        this.f10544a = textView;
        this.f34907a = view2;
    }

    public static MallDialogFillExpressBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallDialogFillExpressBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallDialogFillExpressBinding) ViewDataBinding.bind(obj, view, R.layout.mall_dialog_fill_express);
    }

    @NonNull
    public static MallDialogFillExpressBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallDialogFillExpressBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallDialogFillExpressBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallDialogFillExpressBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_dialog_fill_express, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallDialogFillExpressBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallDialogFillExpressBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_dialog_fill_express, null, false, obj);
    }

    @Nullable
    public FillExpressDialog.a f() {
        return this.f10545a;
    }

    @Nullable
    public FillExpressVM g() {
        return this.f10546a;
    }

    public abstract void l(@Nullable FillExpressDialog.a aVar);

    public abstract void m(@Nullable FillExpressVM fillExpressVM);
}
