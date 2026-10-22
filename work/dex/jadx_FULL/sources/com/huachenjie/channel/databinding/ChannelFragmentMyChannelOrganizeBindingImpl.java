package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.channel.page.my_channel.organize.OrganizeAdapter;
import com.huachenjie.channel.page.my_channel.organize.OrganizeVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelFragmentMyChannelOrganizeBindingImpl extends ChannelFragmentMyChannelOrganizeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33197a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7850a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7851a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f7852a;

    public ChannelFragmentMyChannelOrganizeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f7850a, f33197a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f7851a;
            this.f7851a = 0L;
        }
        OrganizeVM organizeVM = ((ChannelFragmentMyChannelOrganizeBinding) this).f33196a;
        long j2 = j & 7;
        OrganizeAdapter value = null;
        if (j2 != 0) {
            MutableLiveData<OrganizeAdapter> mutableLiveDataK = organizeVM != null ? organizeVM.k() : null;
            updateLiveDataRegistration(0, mutableLiveDataK);
            if (mutableLiveDataK != null) {
                value = mutableLiveDataK.getValue();
            }
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(this.f7852a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7851a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7851a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelFragmentMyChannelOrganizeBinding
    public void k(@Nullable OrganizeVM organizeVM) {
        ((ChannelFragmentMyChannelOrganizeBinding) this).f33196a = organizeVM;
        synchronized (this) {
            this.f7851a |= 2;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<OrganizeAdapter> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7851a |= 1;
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
        k((OrganizeVM) obj);
        return true;
    }

    public ChannelFragmentMyChannelOrganizeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1);
        this.f7851a = -1L;
        RecyclerView recyclerView = (RecyclerView) objArr[0];
        this.f7852a = recyclerView;
        recyclerView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
