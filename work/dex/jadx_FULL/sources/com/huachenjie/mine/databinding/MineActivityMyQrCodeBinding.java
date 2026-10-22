package com.huachenjie.mine.databinding;

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
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.mine.R;
import com.huachenjie.mine.page.qr_code.MineQrCodeActivity;
import com.huachenjie.mine.page.qr_code.MineQrCodeVM;
import com.noober.background.view.BLConstraintLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MineActivityMyQrCodeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35297a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11202a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f11203a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MineQrCodeActivity.a f11204a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MineQrCodeVM f11205a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f11206a;

    @NonNull
    public final BLConstraintLayout b;

    public MineActivityMyQrCodeBinding(Object obj, View view, int i, BLConstraintLayout bLConstraintLayout, BLConstraintLayout bLConstraintLayout2, AvatarView avatarView, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.f11206a = bLConstraintLayout;
        this.b = bLConstraintLayout2;
        this.f11203a = avatarView;
        this.f35297a = imageView;
        this.f11202a = textView;
    }

    public static MineActivityMyQrCodeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MineActivityMyQrCodeBinding d(@NonNull View view, @Nullable Object obj) {
        return (MineActivityMyQrCodeBinding) ViewDataBinding.bind(obj, view, R.layout.mine_activity_my_qr_code);
    }

    @NonNull
    public static MineActivityMyQrCodeBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MineActivityMyQrCodeBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MineActivityMyQrCodeBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MineActivityMyQrCodeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_activity_my_qr_code, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MineActivityMyQrCodeBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MineActivityMyQrCodeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_activity_my_qr_code, null, false, obj);
    }

    @Nullable
    public MineQrCodeActivity.a f() {
        return this.f11204a;
    }

    @Nullable
    public MineQrCodeVM g() {
        return this.f11205a;
    }

    public abstract void l(@Nullable MineQrCodeActivity.a aVar);

    public abstract void m(@Nullable MineQrCodeVM mineQrCodeVM);
}
