package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.base.view.slide.LetterSideBarView;
import com.huachenjie.channel.adapter.FriendListAdapter;
import com.huachenjie.channel.page.friend_list.FriendListViewModel;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.widget.CommonSearchView;
import com.zj.adlib.tk0;
import com.zj.adlib.xq8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelActivityFriendListBindingImpl extends ChannelActivityFriendListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33083a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7556a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7557a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f7558a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(6);
        f7556a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{4}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33083a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.channel.R.id.search_view, 5);
    }

    public ChannelActivityFriendListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f7556a, f33083a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0034  */
    /* JADX WARN: Code duplicated, block: B:25:0x0050  */
    /* JADX WARN: Code duplicated, block: B:45:0x0090  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        FriendListAdapter value;
        Integer value2;
        BindingTitleBean value3;
        synchronized (this) {
            j = this.f7557a;
            this.f7557a = 0L;
        }
        FriendListViewModel friendListViewModel = ((ChannelActivityFriendListBinding) this).f7553a;
        if ((63 & j) != 0) {
            if ((j & 49) == 0) {
                value2 = null;
            } else {
                MutableLiveData<Integer> mutableLiveDataL = friendListViewModel != null ? friendListViewModel.l() : null;
                updateLiveDataRegistration(0, mutableLiveDataL);
                if (mutableLiveDataL != null) {
                    value2 = mutableLiveDataL.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 50) == 0) {
                value3 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataP = friendListViewModel != null ? friendListViewModel.p() : null;
                updateLiveDataRegistration(1, mutableLiveDataP);
                if (mutableLiveDataP != null) {
                    value3 = mutableLiveDataP.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 52) != 0) {
                MutableLiveData<Boolean> mutableLiveDataO = friendListViewModel != null ? friendListViewModel.o() : null;
                updateLiveDataRegistration(2, mutableLiveDataO);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataO != null ? mutableLiveDataO.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 56) == 0) {
                value = null;
            } else {
                MutableLiveData<FriendListAdapter> mutableLiveDataJ = friendListViewModel != null ? friendListViewModel.j() : null;
                updateLiveDataRegistration(3, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value = mutableLiveDataJ.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            zSafeUnbox = false;
            value = null;
            value2 = null;
            value3 = null;
        }
        if ((j & 50) != 0) {
            this.f7558a.k(value3);
        }
        if ((56 & j) != 0) {
            CommonBindingAdapter.g(((ChannelActivityFriendListBinding) this).f7551a, value, false, false);
        }
        if ((52 & j) != 0) {
            CommonBindingAdapter.i(((ChannelActivityFriendListBinding) this).f7552a, zSafeUnbox);
        }
        if ((j & 49) != 0) {
            xq8.a(((ChannelActivityFriendListBinding) this).f7554a, value2, null);
        }
        ViewDataBinding.executeBindingsOn(this.f7558a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7557a != 0) {
                return true;
            }
            return this.f7558a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7557a = 32L;
        }
        this.f7558a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityFriendListBinding
    public void k(@Nullable FriendListViewModel friendListViewModel) {
        ((ChannelActivityFriendListBinding) this).f7553a = friendListViewModel;
        synchronized (this) {
            this.f7557a |= 16;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<FriendListAdapter> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7557a |= 8;
        }
        return true;
    }

    public final boolean m(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7557a |= 1;
        }
        return true;
    }

    public final boolean n(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7557a |= 4;
        }
        return true;
    }

    public final boolean o(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7557a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return m((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return l((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f7558a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 != i) {
            return false;
        }
        k((FriendListViewModel) obj);
        return true;
    }

    public ChannelActivityFriendListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (LinearLayout) objArr[0], (RecyclerView) objArr[2], (CommonSearchView) objArr[5], (LetterSideBarView) objArr[3], (StateLayout) objArr[1]);
        this.f7557a = -1L;
        ((ChannelActivityFriendListBinding) this).f33082a.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[4];
        this.f7558a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        ((ChannelActivityFriendListBinding) this).f7551a.setTag(null);
        ((ChannelActivityFriendListBinding) this).f7552a.setTag(null);
        ((ChannelActivityFriendListBinding) this).f7554a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
