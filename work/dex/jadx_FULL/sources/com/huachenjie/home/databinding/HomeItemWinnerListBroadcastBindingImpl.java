package com.huachenjie.home.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.zj.adlib.xk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeItemWinnerListBroadcastBindingImpl extends HomeItemWinnerListBroadcastBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34296a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9551a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9552a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9553a;

    public HomeItemWinnerListBroadcastBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f9551a, f34296a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f9552a;
            this.f9552a = 0L;
        }
        String str = this.f;
        if ((j & 3) != 0) {
            TextViewBindingAdapter.setText(this.f9553a, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9552a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9552a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeItemWinnerListBroadcastBinding
    public void k(@Nullable String str) {
        this.f = str;
        synchronized (this) {
            this.f9552a |= 1;
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
        k((String) obj);
        return true;
    }

    public HomeItemWinnerListBroadcastBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f9552a = -1L;
        TextView textView = (TextView) objArr[0];
        this.f9553a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
