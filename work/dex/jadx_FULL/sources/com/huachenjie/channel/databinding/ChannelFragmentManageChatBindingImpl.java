package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.channel.page.manage_channel.chat.ManageChatAdapter;
import com.huachenjie.channel.page.manage_channel.chat.ManageChatVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelFragmentManageChatBindingImpl extends ChannelFragmentManageChatBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33183a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7816a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7817a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f7818a;

    public ChannelFragmentManageChatBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f7816a, f33183a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f7817a;
            this.f7817a = 0L;
        }
        ManageChatVM manageChatVM = ((ChannelFragmentManageChatBinding) this).f33182a;
        long j2 = j & 7;
        ManageChatAdapter value = null;
        if (j2 != 0) {
            MutableLiveData<ManageChatAdapter> mutableLiveDataN = manageChatVM != null ? manageChatVM.n() : null;
            updateLiveDataRegistration(0, mutableLiveDataN);
            if (mutableLiveDataN != null) {
                value = mutableLiveDataN.getValue();
            }
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(this.f7818a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7817a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7817a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelFragmentManageChatBinding
    public void k(@Nullable ManageChatVM manageChatVM) {
        ((ChannelFragmentManageChatBinding) this).f33182a = manageChatVM;
        synchronized (this) {
            this.f7817a |= 2;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<ManageChatAdapter> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7817a |= 1;
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
        k((ManageChatVM) obj);
        return true;
    }

    public ChannelFragmentManageChatBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1);
        this.f7817a = -1L;
        RecyclerView recyclerView = (RecyclerView) objArr[0];
        this.f7818a = recyclerView;
        recyclerView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
