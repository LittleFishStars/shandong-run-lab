package com.huachenjie.compat.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.CompoundButtonBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.base.bean.NotifySubConfig;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLRelativeLayout;
import com.zj.adlib.wk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class CompatItemPushSettingContentBindingImpl extends CompatItemPushSettingContentBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34065a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9198a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9199a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final Switch f9200a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f9201a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLRelativeLayout f9202a;

    @NonNull
    public final TextView b;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            boolean zIsChecked = CompatItemPushSettingContentBindingImpl.this.f9200a.isChecked();
            NotifySubConfig notifySubConfig = ((CompatItemPushSettingContentBinding) CompatItemPushSettingContentBindingImpl.this).f9197a;
            if (notifySubConfig != null) {
                notifySubConfig.setOpenFlag(zIsChecked);
            }
        }
    }

    public CompatItemPushSettingContentBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f9198a, f34065a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        String tip;
        String str;
        String notifySubTypeName;
        synchronized (this) {
            j = this.f9199a;
            this.f9199a = 0L;
        }
        NotifySubConfig notifySubConfig = ((CompatItemPushSettingContentBinding) this).f9197a;
        long j2 = 3 & j;
        boolean openFlag = false;
        if (j2 != 0) {
            if (notifySubConfig != null) {
                openFlag = notifySubConfig.getOpenFlag();
                notifySubTypeName = notifySubConfig.getNotifySubTypeName();
                tip = notifySubConfig.getTip();
            } else {
                tip = null;
                notifySubTypeName = null;
            }
            String str2 = notifySubTypeName;
            z = openFlag;
            openFlag = !TextUtils.isEmpty(tip);
            str = str2;
        } else {
            z = false;
            tip = null;
            str = null;
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.b, tip);
            CommonBindingAdapter.l0(this.b, openFlag);
            CompoundButtonBindingAdapter.setChecked(this.f9200a, z);
            TextViewBindingAdapter.setText(((CompatItemPushSettingContentBinding) this).f34064a, str);
        }
        if ((j & 2) != 0) {
            CompoundButtonBindingAdapter.setListeners(this.f9200a, null, this.f9201a);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9199a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9199a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.CompatItemPushSettingContentBinding
    public void k(@Nullable NotifySubConfig notifySubConfig) {
        ((CompatItemPushSettingContentBinding) this).f9197a = notifySubConfig;
        synchronized (this) {
            this.f9199a |= 1;
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
        k((NotifySubConfig) obj);
        return true;
    }

    public CompatItemPushSettingContentBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1]);
        this.f9201a = new a();
        this.f9199a = -1L;
        BLRelativeLayout bLRelativeLayout = (BLRelativeLayout) objArr[0];
        this.f9202a = bLRelativeLayout;
        bLRelativeLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.b = textView;
        textView.setTag(null);
        Switch r5 = (Switch) objArr[3];
        this.f9200a = r5;
        r5.setTag(null);
        ((CompatItemPushSettingContentBinding) this).f34064a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
