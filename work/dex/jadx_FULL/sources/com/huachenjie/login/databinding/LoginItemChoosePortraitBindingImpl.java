package com.huachenjie.login.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLImageView;
import com.zj.adlib.ju3;
import com.zj.adlib.zk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class LoginItemChoosePortraitBindingImpl extends LoginItemChoosePortraitBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34680a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10070a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10071a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f10072a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10073a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f10074a;

    public LoginItemChoosePortraitBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f10070a, f34680a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10071a;
            this.f10071a = 0L;
        }
        Boolean bool = ((LoginItemChoosePortraitBinding) this).f34679a;
        String str = this.f;
        long j2 = 5 & j;
        boolean zSafeUnbox = j2 != 0 ? ViewDataBinding.safeUnbox(bool) : false;
        long j3 = j & 6;
        RequestOptions requestOptions = j3 != 0 ? ju3.b : null;
        if (j3 != 0) {
            CommonBindingAdapter.b0(this.f10074a, str, requestOptions, false);
        }
        if (j2 != 0) {
            CommonBindingAdapter.l0(this.f10073a, zSafeUnbox);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10071a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10071a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginItemChoosePortraitBinding
    public void l(@Nullable Boolean bool) {
        ((LoginItemChoosePortraitBinding) this).f34679a = bool;
        synchronized (this) {
            this.f10071a |= 1;
        }
        notifyPropertyChanged(zk0.F);
        super.requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginItemChoosePortraitBinding
    public void m(@Nullable String str) {
        this.f = str;
        synchronized (this) {
            this.f10071a |= 2;
        }
        notifyPropertyChanged(zk0.O);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (zk0.F == i) {
            l((Boolean) obj);
        } else {
            if (zk0.O != i) {
                return false;
            }
            m((String) obj);
        }
        return true;
    }

    public LoginItemChoosePortraitBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f10071a = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f10072a = frameLayout;
        frameLayout.setTag(null);
        BLImageView bLImageView = (BLImageView) objArr[1];
        this.f10074a = bLImageView;
        bLImageView.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.f10073a = imageView;
        imageView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
