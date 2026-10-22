package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.widget.ShadowConstraintLayout;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.dialog.ReceiveSysGiftDialog;
import com.huachenjie.social_contact.vm.ReceiveSysGiftVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class DialogReceiveSysGiftBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36154a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f12903a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShadowConstraintLayout f12904a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ReceiveSysGiftDialog.a f12905a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ReceiveSysGiftVM f12906a;

    public DialogReceiveSysGiftBinding(Object obj, View view, int i, RecyclerView recyclerView, ShadowConstraintLayout shadowConstraintLayout, TextView textView) {
        super(obj, view, i);
        this.f12903a = recyclerView;
        this.f12904a = shadowConstraintLayout;
        this.f36154a = textView;
    }

    public static DialogReceiveSysGiftBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogReceiveSysGiftBinding d(@NonNull View view, @Nullable Object obj) {
        return (DialogReceiveSysGiftBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_receive_sys_gift);
    }

    @NonNull
    public static DialogReceiveSysGiftBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static DialogReceiveSysGiftBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static DialogReceiveSysGiftBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (DialogReceiveSysGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_receive_sys_gift, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static DialogReceiveSysGiftBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (DialogReceiveSysGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_receive_sys_gift, null, false, obj);
    }

    @Nullable
    public ReceiveSysGiftDialog.a f() {
        return this.f12905a;
    }

    @Nullable
    public ReceiveSysGiftVM g() {
        return this.f12906a;
    }

    public abstract void l(@Nullable ReceiveSysGiftDialog.a aVar);

    public abstract void m(@Nullable ReceiveSysGiftVM receiveSysGiftVM);
}
