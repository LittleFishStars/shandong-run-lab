package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.channel.page.manage_channel.admin.ManageAdminAdapter;
import com.huachenjie.channel.page.manage_channel.admin.ManageAdminVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelFragmentManageAdminBindingImpl extends ChannelFragmentManageAdminBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33174a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7796a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7797a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f7798a;

    public ChannelFragmentManageAdminBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f7796a, f33174a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f7797a;
            this.f7797a = 0L;
        }
        ManageAdminVM manageAdminVM = ((ChannelFragmentManageAdminBinding) this).f33173a;
        long j2 = j & 7;
        ManageAdminAdapter value = null;
        if (j2 != 0) {
            MutableLiveData<ManageAdminAdapter> mutableLiveDataL = manageAdminVM != null ? manageAdminVM.l() : null;
            updateLiveDataRegistration(0, mutableLiveDataL);
            if (mutableLiveDataL != null) {
                value = mutableLiveDataL.getValue();
            }
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(this.f7798a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7797a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7797a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelFragmentManageAdminBinding
    public void k(@Nullable ManageAdminVM manageAdminVM) {
        ((ChannelFragmentManageAdminBinding) this).f33173a = manageAdminVM;
        synchronized (this) {
            this.f7797a |= 2;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<ManageAdminAdapter> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7797a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return l((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 != i) {
            return false;
        }
        k((ManageAdminVM) obj);
        return true;
    }

    public ChannelFragmentManageAdminBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1);
        this.f7797a = -1L;
        RecyclerView recyclerView = (RecyclerView) objArr[0];
        this.f7798a = recyclerView;
        recyclerView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
