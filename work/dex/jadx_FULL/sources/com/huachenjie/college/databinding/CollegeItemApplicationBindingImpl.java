package com.huachenjie.college.databinding;

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
import com.huachenjie.college.bean.CampusApplicationBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.zj.adlib.uk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class CollegeItemApplicationBindingImpl extends CollegeItemApplicationBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33573a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8395a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8396a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f8397a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8398a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8399a;

    public CollegeItemApplicationBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f8395a, f33573a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String iconUrl;
        RequestOptions iconOptions;
        String title;
        synchronized (this) {
            j = this.f8396a;
            this.f8396a = 0L;
        }
        CampusApplicationBean campusApplicationBean = ((CollegeItemApplicationBinding) this).f33572a;
        long j2 = j & 3;
        if (j2 == 0 || campusApplicationBean == null) {
            iconUrl = null;
            iconOptions = null;
            title = null;
        } else {
            iconUrl = campusApplicationBean.getIconUrl();
            iconOptions = campusApplicationBean.getIconOptions();
            title = campusApplicationBean.getTitle();
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(this.f8397a, iconUrl, iconOptions, false);
            TextViewBindingAdapter.setText(this.f8399a, title);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8396a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8396a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.college.databinding.CollegeItemApplicationBinding
    public void k(@Nullable CampusApplicationBean campusApplicationBean) {
        ((CollegeItemApplicationBinding) this).f33572a = campusApplicationBean;
        synchronized (this) {
            this.f8396a |= 1;
        }
        notifyPropertyChanged(uk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (uk0.g != i) {
            return false;
        }
        k((CampusApplicationBean) obj);
        return true;
    }

    public CollegeItemApplicationBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f8396a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f8398a = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f8397a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f8399a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
