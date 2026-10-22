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
import com.huachenjie.home.R;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeLayoutEmptyDataBindingImpl extends HomeLayoutEmptyDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34300a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9564a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9565a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34300a = sparseIntArray;
        sparseIntArray.put(R.id.emptyView, 1);
        sparseIntArray.put(R.id.tv_empty, 2);
        sparseIntArray.put(R.id.bt_empty, 3);
    }

    public HomeLayoutEmptyDataBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f9564a, f34300a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f9565a = 0L;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9565a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9565a = 1L;
        }
        requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    public HomeLayoutEmptyDataBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (BLTextView) objArr[3], (ConstraintLayout) objArr[0], (ImageView) objArr[1], (TextView) objArr[2]);
        this.f9565a = -1L;
        ((HomeLayoutEmptyDataBinding) this).f9562a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
