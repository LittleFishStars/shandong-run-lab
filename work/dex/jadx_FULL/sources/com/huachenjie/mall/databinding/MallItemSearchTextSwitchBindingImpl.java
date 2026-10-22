package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemSearchTextSwitchBindingImpl extends MallItemSearchTextSwitchBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35033a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10902a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10903a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10904a;

    public MallItemSearchTextSwitchBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f10902a, f35033a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10903a;
            this.f10903a = 0L;
        }
        String str = this.f;
        if ((j & 3) != 0) {
            TextViewBindingAdapter.setText(this.f10904a, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10903a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10903a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemSearchTextSwitchBinding
    public void k(@Nullable String str) {
        this.f = str;
        synchronized (this) {
            this.f10903a |= 1;
        }
        notifyPropertyChanged(hk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.g != i) {
            return false;
        }
        k((String) obj);
        return true;
    }

    public MallItemSearchTextSwitchBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f10903a = -1L;
        TextView textView = (TextView) objArr[0];
        this.f10904a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
