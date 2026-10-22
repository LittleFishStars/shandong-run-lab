package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.channel.page.manage_channel.topic.ManageTopicAdapter;
import com.huachenjie.channel.page.manage_channel.topic.ManageTopicVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelFragmentManageTopicBindingImpl extends ChannelFragmentManageTopicBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33189a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7833a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7834a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f7835a;

    public ChannelFragmentManageTopicBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f7833a, f33189a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f7834a;
            this.f7834a = 0L;
        }
        ManageTopicVM manageTopicVM = ((ChannelFragmentManageTopicBinding) this).f33188a;
        long j2 = j & 7;
        ManageTopicAdapter value = null;
        if (j2 != 0) {
            MutableLiveData<ManageTopicAdapter> mutableLiveDataN = manageTopicVM != null ? manageTopicVM.n() : null;
            updateLiveDataRegistration(0, mutableLiveDataN);
            if (mutableLiveDataN != null) {
                value = mutableLiveDataN.getValue();
            }
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(this.f7835a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7834a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7834a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelFragmentManageTopicBinding
    public void k(@Nullable ManageTopicVM manageTopicVM) {
        ((ChannelFragmentManageTopicBinding) this).f33188a = manageTopicVM;
        synchronized (this) {
            this.f7834a |= 2;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<ManageTopicAdapter> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7834a |= 1;
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
        k((ManageTopicVM) obj);
        return true;
    }

    public ChannelFragmentManageTopicBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1);
        this.f7834a = -1L;
        RecyclerView recyclerView = (RecyclerView) objArr[0];
        this.f7835a = recyclerView;
        recyclerView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
