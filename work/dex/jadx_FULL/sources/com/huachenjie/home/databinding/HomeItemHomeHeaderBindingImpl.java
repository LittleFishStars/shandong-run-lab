package com.huachenjie.home.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.home.bean.HomeHeaderBean;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ju3;
import com.zj.adlib.xk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeItemHomeHeaderBindingImpl extends HomeItemHomeHeaderBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34276a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9484a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9485a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9486a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f9487a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f9488a;

    public HomeItemHomeHeaderBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f9484a, f34276a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        RequestOptions requestOptions;
        String str;
        String str2;
        boolean z2;
        String str3;
        String iconUrl;
        synchronized (this) {
            j = this.f9485a;
            this.f9485a = 0L;
        }
        HomeHeaderBean homeHeaderBean = ((HomeItemHomeHeaderBinding) this).f9483a;
        long j2 = j & 3;
        String str4 = null;
        if (j2 != 0) {
            requestOptions = ju3.h;
            if (homeHeaderBean != null) {
                String name = homeHeaderBean.getName();
                String badge = homeHeaderBean.getBadge();
                iconUrl = homeHeaderBean.getIconUrl();
                boolean zShowBadge = homeHeaderBean.showBadge();
                str3 = name;
                str4 = badge;
                z2 = zShowBadge;
            } else {
                z2 = false;
                str3 = null;
                iconUrl = null;
            }
            String str5 = str3;
            str = "" + str4;
            str4 = iconUrl;
            z = z2;
            str2 = str5;
        } else {
            z = false;
            requestOptions = null;
            str = null;
            str2 = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(((HomeItemHomeHeaderBinding) this).f34275a, str4, requestOptions, false);
            CommonBindingAdapter.l0(this.f9488a, z);
            TextViewBindingAdapter.setText(this.f9488a, str);
            TextViewBindingAdapter.setText(this.f9486a, str2);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9485a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9485a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeItemHomeHeaderBinding
    public void k(@Nullable HomeHeaderBean homeHeaderBean) {
        ((HomeItemHomeHeaderBinding) this).f9483a = homeHeaderBean;
        synchronized (this) {
            this.f9485a |= 1;
        }
        notifyPropertyChanged(xk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (xk0.g != i) {
            return false;
        }
        k((HomeHeaderBean) obj);
        return true;
    }

    public HomeItemHomeHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1]);
        this.f9485a = -1L;
        ((HomeItemHomeHeaderBinding) this).f34275a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f9487a = constraintLayout;
        constraintLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[2];
        this.f9488a = bLTextView;
        bLTextView.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f9486a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
