package com.huachenjie.home.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.home.bean.InspirationRecordBean;
import com.zj.adlib.xk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeItemInspirationRecordTitleBindingImpl extends HomeItemInspirationRecordTitleBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34283a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9506a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9507a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9508a;

    public HomeItemInspirationRecordTitleBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f9506a, f34283a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f9507a;
            this.f9507a = 0L;
        }
        InspirationRecordBean inspirationRecordBean = ((HomeItemInspirationRecordTitleBinding) this).f9505a;
        long j2 = j & 3;
        String name = (j2 == 0 || inspirationRecordBean == null) ? null : inspirationRecordBean.getName();
        if (j2 != 0) {
            TextViewBindingAdapter.setText(((HomeItemInspirationRecordTitleBinding) this).f34282a, name);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9507a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9507a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeItemInspirationRecordTitleBinding
    public void k(@Nullable InspirationRecordBean inspirationRecordBean) {
        ((HomeItemInspirationRecordTitleBinding) this).f9505a = inspirationRecordBean;
        synchronized (this) {
            this.f9507a |= 1;
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
        k((InspirationRecordBean) obj);
        return true;
    }

    public HomeItemInspirationRecordTitleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1]);
        this.f9507a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f9508a = linearLayout;
        linearLayout.setTag(null);
        ((HomeItemInspirationRecordTitleBinding) this).f34282a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
