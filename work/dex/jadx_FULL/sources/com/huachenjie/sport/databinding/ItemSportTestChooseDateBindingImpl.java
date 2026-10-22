package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.sport.R;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemSportTestChooseDateBindingImpl extends ItemSportTestChooseDateBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36529a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13642a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13643a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13644a;

    public ItemSportTestChooseDateBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f13642a, f36529a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int colorFromResource;
        TextView textView;
        int i;
        synchronized (this) {
            j = this.f13643a;
            this.f13643a = 0L;
        }
        String str = this.f;
        Boolean bool = ((ItemSportTestChooseDateBinding) this).f13641a;
        long j2 = j & 6;
        if (j2 != 0) {
            boolean zSafeUnbox = ViewDataBinding.safeUnbox(bool);
            if (j2 != 0) {
                j |= zSafeUnbox ? 16L : 8L;
            }
            if (zSafeUnbox) {
                textView = ((ItemSportTestChooseDateBinding) this).f36528a;
                i = R.color.color_361BFD;
            } else {
                textView = ((ItemSportTestChooseDateBinding) this).f36528a;
                i = R.color.color_8997A4;
            }
            colorFromResource = ViewDataBinding.getColorFromResource(textView, i);
        } else {
            colorFromResource = 0;
        }
        if ((5 & j) != 0) {
            TextViewBindingAdapter.setText(((ItemSportTestChooseDateBinding) this).f36528a, str);
        }
        if ((j & 6) != 0) {
            ((ItemSportTestChooseDateBinding) this).f36528a.setTextColor(colorFromResource);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13643a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13643a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemSportTestChooseDateBinding
    public void l(@Nullable String str) {
        this.f = str;
        synchronized (this) {
            this.f13643a |= 1;
        }
        notifyPropertyChanged(ok0.p);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemSportTestChooseDateBinding
    public void m(@Nullable Boolean bool) {
        ((ItemSportTestChooseDateBinding) this).f13641a = bool;
        synchronized (this) {
            this.f13643a |= 2;
        }
        notifyPropertyChanged(ok0.E);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p == i) {
            l((String) obj);
        } else {
            if (ok0.E != i) {
                return false;
            }
            m((Boolean) obj);
        }
        return true;
    }

    public ItemSportTestChooseDateBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1]);
        this.f13643a = -1L;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) objArr[0];
        this.f13644a = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        ((ItemSportTestChooseDateBinding) this).f36528a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
