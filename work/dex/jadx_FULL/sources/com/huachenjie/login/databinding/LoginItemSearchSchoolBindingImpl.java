package com.huachenjie.login.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.bean.SchoolInfo;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.zj.adlib.ju3;
import com.zj.adlib.zk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class LoginItemSearchSchoolBindingImpl extends LoginItemSearchSchoolBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34684a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10080a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10081a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10082a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10083a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10084a;

    public LoginItemSearchSchoolBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f10080a, f34684a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String schoolName;
        synchronized (this) {
            j = this.f10081a;
            this.f10081a = 0L;
        }
        SchoolInfo schoolInfo = ((LoginItemSearchSchoolBinding) this).f34683a;
        long j2 = j & 3;
        String schoolLogo = null;
        if (j2 != 0) {
            requestOptions = ju3.e;
            if (schoolInfo != null) {
                schoolName = schoolInfo.getSchoolName();
                schoolLogo = schoolInfo.getSchoolLogo();
            } else {
                schoolName = null;
            }
        } else {
            requestOptions = null;
            schoolName = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(this.f10082a, schoolLogo, requestOptions, false);
            TextViewBindingAdapter.setText(this.f10084a, schoolName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10081a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10081a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginItemSearchSchoolBinding
    public void k(@Nullable SchoolInfo schoolInfo) {
        ((LoginItemSearchSchoolBinding) this).f34683a = schoolInfo;
        synchronized (this) {
            this.f10081a |= 1;
        }
        notifyPropertyChanged(zk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (zk0.g != i) {
            return false;
        }
        k((SchoolInfo) obj);
        return true;
    }

    public LoginItemSearchSchoolBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f10081a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10083a = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f10082a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f10084a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
