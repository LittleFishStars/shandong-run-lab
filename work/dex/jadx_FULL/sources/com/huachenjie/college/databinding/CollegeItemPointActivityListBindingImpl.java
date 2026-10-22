package com.huachenjie.college.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.college.bean.PointActivityBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ju3;
import com.zj.adlib.uk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class CollegeItemPointActivityListBindingImpl extends CollegeItemPointActivityListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33577a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8408a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8409a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8410a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLFrameLayout f8411a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f8412a;

    public CollegeItemPointActivityListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f8408a, f33577a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        RequestOptions requestOptions;
        String str;
        String name;
        String str2;
        String str3;
        boolean zIsStartingStatus;
        String mainImageUrl;
        synchronized (this) {
            j = this.f8409a;
            this.f8409a = 0L;
        }
        PointActivityBean pointActivityBean = ((CollegeItemPointActivityListBinding) this).f33576a;
        long j2 = j & 3;
        String str4 = null;
        if (j2 != 0) {
            requestOptions = ju3.m;
            if (pointActivityBean != null) {
                str4 = pointActivityBean.formatterStatusColor();
                name = pointActivityBean.getName();
                str2 = pointActivityBean.formatterStatusName();
                zIsStartingStatus = pointActivityBean.isStartingStatus();
                str3 = pointActivityBean.formatterDesColor();
                mainImageUrl = pointActivityBean.getMainImageUrl();
            } else {
                zIsStartingStatus = false;
                mainImageUrl = null;
                name = null;
                str2 = null;
                str3 = null;
            }
            z = !zIsStartingStatus;
            String str5 = mainImageUrl;
            str = str4;
            str4 = str5;
        } else {
            z = false;
            requestOptions = null;
            str = null;
            name = null;
            str2 = null;
            str3 = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(((CollegeItemPointActivityListBinding) this).f8406a, str4, requestOptions, false);
            CommonBindingAdapter.l0(this.f8411a, z);
            TextViewBindingAdapter.setText(this.f8410a, name);
            CommonBindingAdapter.W(this.f8410a, str3);
            TextViewBindingAdapter.setText(((CollegeItemPointActivityListBinding) this).f8407a, str2);
            CommonBindingAdapter.W(((CollegeItemPointActivityListBinding) this).f8407a, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8409a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8409a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.college.databinding.CollegeItemPointActivityListBinding
    public void k(@Nullable PointActivityBean pointActivityBean) {
        ((CollegeItemPointActivityListBinding) this).f33576a = pointActivityBean;
        synchronized (this) {
            this.f8409a |= 1;
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
        k((PointActivityBean) obj);
        return true;
    }

    public CollegeItemPointActivityListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (BLImageView) objArr[1], (BLTextView) objArr[3]);
        this.f8409a = -1L;
        ((CollegeItemPointActivityListBinding) this).f8406a.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[0];
        this.f8412a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        BLFrameLayout bLFrameLayout = (BLFrameLayout) objArr[2];
        this.f8411a = bLFrameLayout;
        bLFrameLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.f8410a = textView;
        textView.setTag(null);
        ((CollegeItemPointActivityListBinding) this).f8407a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
