package com.huachenjie.sport.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemExamInfoBindingImpl extends ItemExamInfoBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36504a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13580a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13581a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13582a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13583a;

    @NonNull
    public final TextView b;

    public ItemExamInfoBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f13580a, f36504a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f13581a;
            this.f13581a = 0L;
        }
        String str = this.g;
        String str2 = this.f;
        Float f = ((ItemExamInfoBinding) this).f36503a;
        long j2 = 9 & j;
        boolean z = j2 != 0 ? !TextUtils.isEmpty(str) : false;
        long j3 = 10 & j;
        long j4 = j & 12;
        if (j2 != 0) {
            CommonBindingAdapter.l0(this.f13582a, z);
            TextViewBindingAdapter.setText(this.b, str);
        }
        if (j4 != 0) {
            CommonBindingAdapter.X(this.f13583a, f);
            CommonBindingAdapter.X(this.b, f);
        }
        if (j3 != 0) {
            TextViewBindingAdapter.setText(this.f13583a, str2);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13581a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13581a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemExamInfoBinding
    public void k(@Nullable Float f) {
        ((ItemExamInfoBinding) this).f36503a = f;
        synchronized (this) {
            this.f13581a |= 4;
        }
        notifyPropertyChanged(ok0.e0);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemExamInfoBinding
    public void l(@Nullable String str) {
        this.f = str;
        synchronized (this) {
            this.f13581a |= 2;
        }
        notifyPropertyChanged(ok0.m0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // com.huachenjie.sport.databinding.ItemExamInfoBinding
    public void setContent(@Nullable String str) {
        this.g = str;
        synchronized (this) {
            this.f13581a |= 1;
        }
        notifyPropertyChanged(ok0.n);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.n == i) {
            setContent((String) obj);
        } else if (ok0.m0 == i) {
            l((String) obj);
        } else {
            if (ok0.e0 != i) {
                return false;
            }
            k((Float) obj);
        }
        return true;
    }

    public ItemExamInfoBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f13581a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f13582a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f13583a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.b = textView2;
        textView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
