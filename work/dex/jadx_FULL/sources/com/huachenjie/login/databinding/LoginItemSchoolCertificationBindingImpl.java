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
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.login.bean.SchoolCertificationBean;
import com.zj.adlib.ju3;
import com.zj.adlib.zk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class LoginItemSchoolCertificationBindingImpl extends LoginItemSchoolCertificationBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34682a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10075a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10076a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10077a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10078a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10079a;

    public LoginItemSchoolCertificationBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f10075a, f34682a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String schoolName;
        synchronized (this) {
            j = this.f10076a;
            this.f10076a = 0L;
        }
        SchoolCertificationBean schoolCertificationBean = ((LoginItemSchoolCertificationBinding) this).f34681a;
        long j2 = j & 3;
        String logoUrl = null;
        if (j2 != 0) {
            requestOptions = ju3.e;
            if (schoolCertificationBean != null) {
                logoUrl = schoolCertificationBean.getLogoUrl();
                schoolName = schoolCertificationBean.getSchoolName();
            } else {
                schoolName = null;
            }
        } else {
            requestOptions = null;
            schoolName = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(this.f10077a, logoUrl, requestOptions, false);
            TextViewBindingAdapter.setText(this.f10079a, schoolName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10076a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10076a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginItemSchoolCertificationBinding
    public void k(@Nullable SchoolCertificationBean schoolCertificationBean) {
        ((LoginItemSchoolCertificationBinding) this).f34681a = schoolCertificationBean;
        synchronized (this) {
            this.f10076a |= 1;
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
        k((SchoolCertificationBean) obj);
        return true;
    }

    public LoginItemSchoolCertificationBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f10076a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10078a = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f10077a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f10079a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
