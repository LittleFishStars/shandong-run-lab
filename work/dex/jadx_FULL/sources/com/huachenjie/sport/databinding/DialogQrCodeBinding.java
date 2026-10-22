package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.qrcode.QRCodeDialog;
import com.huachenjie.sport.page.mine.qrcode.QRCodeVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class DialogQrCodeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f36454a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public QRCodeDialog.a f13411a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public QRCodeVM f13412a;

    public DialogQrCodeBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.f36454a = imageView;
    }

    public static DialogQrCodeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogQrCodeBinding d(@NonNull View view, @Nullable Object obj) {
        return (DialogQrCodeBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_qr_code);
    }

    @NonNull
    public static DialogQrCodeBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static DialogQrCodeBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static DialogQrCodeBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (DialogQrCodeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_qr_code, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static DialogQrCodeBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (DialogQrCodeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_qr_code, null, false, obj);
    }

    @Nullable
    public QRCodeDialog.a f() {
        return this.f13411a;
    }

    @Nullable
    public QRCodeVM g() {
        return this.f13412a;
    }

    public abstract void l(@Nullable QRCodeDialog.a aVar);

    public abstract void m(@Nullable QRCodeVM qRCodeVM);
}
