package com.huachenjie.compat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.base.bean.NotifyConfig;
import com.noober.background.view.BLTextView;
import com.zj.adlib.wk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class CompatItemPushSettingTitleBindingImpl extends CompatItemPushSettingTitleBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34068a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9203a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9204a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f9205a;

    public CompatItemPushSettingTitleBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f9203a, f34068a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f9204a;
            this.f9204a = 0L;
        }
        NotifyConfig notifyConfig = ((CompatItemPushSettingTitleBinding) this).f34067a;
        long j2 = j & 3;
        String notifyTypeName = (j2 == 0 || notifyConfig == null) ? null : notifyConfig.getNotifyTypeName();
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f9205a, notifyTypeName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9204a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9204a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.CompatItemPushSettingTitleBinding
    public void k(@Nullable NotifyConfig notifyConfig) {
        ((CompatItemPushSettingTitleBinding) this).f34067a = notifyConfig;
        synchronized (this) {
            this.f9204a |= 1;
        }
        notifyPropertyChanged(wk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (wk0.g != i) {
            return false;
        }
        k((NotifyConfig) obj);
        return true;
    }

    public CompatItemPushSettingTitleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f9204a = -1L;
        BLTextView bLTextView = (BLTextView) objArr[0];
        this.f9205a = bLTextView;
        bLTextView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
