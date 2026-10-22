package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.channel.page.manage_channel.topic_chat.ManageTopicChatAdapter;
import com.huachenjie.channel.page.manage_channel.topic_chat.ManageTopicChatVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelFragmentManageTopicChatBindingImpl extends ChannelFragmentManageTopicChatBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33191a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7836a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7837a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f7838a;

    public ChannelFragmentManageTopicChatBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f7836a, f33191a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f7837a;
            this.f7837a = 0L;
        }
        ManageTopicChatVM manageTopicChatVM = ((ChannelFragmentManageTopicChatBinding) this).f33190a;
        long j2 = j & 7;
        ManageTopicChatAdapter value = null;
        if (j2 != 0) {
            MutableLiveData<ManageTopicChatAdapter> mutableLiveDataI = manageTopicChatVM != null ? manageTopicChatVM.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            if (mutableLiveDataI != null) {
                value = mutableLiveDataI.getValue();
            }
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(this.f7838a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7837a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7837a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelFragmentManageTopicChatBinding
    public void k(@Nullable ManageTopicChatVM manageTopicChatVM) {
        ((ChannelFragmentManageTopicChatBinding) this).f33190a = manageTopicChatVM;
        synchronized (this) {
            this.f7837a |= 2;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<ManageTopicChatAdapter> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7837a |= 1;
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
        k((ManageTopicChatVM) obj);
        return true;
    }

    public ChannelFragmentManageTopicChatBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1);
        this.f7837a = -1L;
        RecyclerView recyclerView = (RecyclerView) objArr[0];
        this.f7838a = recyclerView;
        recyclerView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
