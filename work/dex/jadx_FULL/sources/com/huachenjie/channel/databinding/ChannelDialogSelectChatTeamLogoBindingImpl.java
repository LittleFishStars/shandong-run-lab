package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.channel.page.manage_channel.chat.SelectChatTeamLogoAdapter;
import com.huachenjie.channel.page.manage_channel.chat.SelectChatTeamLogoVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelDialogSelectChatTeamLogoBindingImpl extends ChannelDialogSelectChatTeamLogoBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33154a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7755a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7756a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f7757a;

    public ChannelDialogSelectChatTeamLogoBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f7755a, f33154a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f7756a;
            this.f7756a = 0L;
        }
        SelectChatTeamLogoVM selectChatTeamLogoVM = ((ChannelDialogSelectChatTeamLogoBinding) this).f7754a;
        long j2 = j & 7;
        SelectChatTeamLogoAdapter value = null;
        if (j2 != 0) {
            MutableLiveData<SelectChatTeamLogoAdapter> mutableLiveDataI = selectChatTeamLogoVM != null ? selectChatTeamLogoVM.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            if (mutableLiveDataI != null) {
                value = mutableLiveDataI.getValue();
            }
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(((ChannelDialogSelectChatTeamLogoBinding) this).f33153a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7756a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7756a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelDialogSelectChatTeamLogoBinding
    public void k(@Nullable SelectChatTeamLogoVM selectChatTeamLogoVM) {
        ((ChannelDialogSelectChatTeamLogoBinding) this).f7754a = selectChatTeamLogoVM;
        synchronized (this) {
            this.f7756a |= 2;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<SelectChatTeamLogoAdapter> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7756a |= 1;
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
        k((SelectChatTeamLogoVM) obj);
        return true;
    }

    public ChannelDialogSelectChatTeamLogoBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (RecyclerView) objArr[1]);
        this.f7756a = -1L;
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[0];
        this.f7757a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        ((ChannelDialogSelectChatTeamLogoBinding) this).f33153a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
