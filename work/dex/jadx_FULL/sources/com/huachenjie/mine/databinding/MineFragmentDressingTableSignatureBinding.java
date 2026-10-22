package com.huachenjie.mine.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.mine.R;
import com.huachenjie.mine.page.dressing_table.signature.SignatureFragment;
import com.huachenjie.mine.page.dressing_table.signature.SignatureVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MineFragmentDressingTableSignatureBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public SignatureFragment.a f35313a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SignatureVM f11241a;

    public MineFragmentDressingTableSignatureBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static MineFragmentDressingTableSignatureBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MineFragmentDressingTableSignatureBinding d(@NonNull View view, @Nullable Object obj) {
        return (MineFragmentDressingTableSignatureBinding) ViewDataBinding.bind(obj, view, R.layout.mine_fragment_dressing_table_signature);
    }

    @NonNull
    public static MineFragmentDressingTableSignatureBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MineFragmentDressingTableSignatureBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MineFragmentDressingTableSignatureBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MineFragmentDressingTableSignatureBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_fragment_dressing_table_signature, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MineFragmentDressingTableSignatureBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MineFragmentDressingTableSignatureBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_fragment_dressing_table_signature, null, false, obj);
    }

    @Nullable
    public SignatureFragment.a f() {
        return this.f35313a;
    }

    @Nullable
    public SignatureVM g() {
        return this.f11241a;
    }

    public abstract void l(@Nullable SignatureFragment.a aVar);

    public abstract void m(@Nullable SignatureVM signatureVM);
}
