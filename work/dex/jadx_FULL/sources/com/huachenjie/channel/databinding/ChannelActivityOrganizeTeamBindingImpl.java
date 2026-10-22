package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.channel.page.organize.team.OrganizeTeamActivity;
import com.huachenjie.channel.page.organize.team.OrganizeTeamAdapter;
import com.huachenjie.channel.page.organize.team.OrganizeTeamVM;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelActivityOrganizeTeamBindingImpl extends ChannelActivityOrganizeTeamBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33122a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7675a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7676a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f7677a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f7678a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OrganizeTeamActivity.a f33123a;

        public a a(OrganizeTeamActivity.a aVar) {
            this.f33123a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33123a.b(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        f7675a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33122a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.channel.R.id.v_line, 4);
    }

    public ChannelActivityOrganizeTeamBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f7675a, f33122a));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0033  */
    /* JADX WARN: Code duplicated, block: B:24:0x004f  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        OrganizeTeamAdapter value;
        BindingTitleBean value2;
        a aVarA;
        synchronized (this) {
            j = this.f7676a;
            this.f7676a = 0L;
        }
        OrganizeTeamVM organizeTeamVM = ((ChannelActivityOrganizeTeamBinding) this).f7671a;
        OrganizeTeamActivity.a aVar = ((ChannelActivityOrganizeTeamBinding) this).f7670a;
        if ((45 & j) != 0) {
            if ((j & 41) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = organizeTeamVM != null ? organizeTeamVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value2 = mutableLiveDataI.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 44) == 0) {
                value = null;
            } else {
                MutableLiveData<OrganizeTeamAdapter> mutableLiveDataK = organizeTeamVM != null ? organizeTeamVM.k() : null;
                updateLiveDataRegistration(2, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value = mutableLiveDataK.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
        }
        long j2 = 48 & j;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f7678a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f7678a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((ChannelActivityOrganizeTeamBinding) this).f7673a, aVarA, null);
        }
        if ((44 & j) != 0) {
            CommonBindingAdapter.g(((ChannelActivityOrganizeTeamBinding) this).f33121a, value, false, false);
        }
        if ((j & 41) != 0) {
            ((ChannelActivityOrganizeTeamBinding) this).f7672a.k(value2);
        }
        ViewDataBinding.executeBindingsOn(((ChannelActivityOrganizeTeamBinding) this).f7672a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7676a != 0) {
                return true;
            }
            return ((ChannelActivityOrganizeTeamBinding) this).f7672a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7676a = 32L;
        }
        ((ChannelActivityOrganizeTeamBinding) this).f7672a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityOrganizeTeamBinding
    public void l(@Nullable OrganizeTeamActivity.a aVar) {
        ((ChannelActivityOrganizeTeamBinding) this).f7670a = aVar;
        synchronized (this) {
            this.f7676a |= 16;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityOrganizeTeamBinding
    public void m(@Nullable OrganizeTeamVM organizeTeamVM) {
        ((ChannelActivityOrganizeTeamBinding) this).f7671a = organizeTeamVM;
        synchronized (this) {
            this.f7676a |= 8;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean n(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7676a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<OrganizeTeamAdapter> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7676a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return n((LayoutToolbarBindingBinding) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7676a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((ChannelActivityOrganizeTeamBinding) this).f7672a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 == i) {
            m((OrganizeTeamVM) obj);
        } else {
            if (tk0.k != i) {
                return false;
            }
            l((OrganizeTeamActivity.a) obj);
        }
        return true;
    }

    public ChannelActivityOrganizeTeamBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (BLTextView) objArr[2], (RecyclerView) objArr[1], (LayoutToolbarBindingBinding) objArr[3], (BLView) objArr[4]);
        this.f7676a = -1L;
        ((ChannelActivityOrganizeTeamBinding) this).f7673a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f7677a = constraintLayout;
        constraintLayout.setTag(null);
        ((ChannelActivityOrganizeTeamBinding) this).f33121a.setTag(null);
        setContainedBinding(((ChannelActivityOrganizeTeamBinding) this).f7672a);
        setRootTag(view);
        invalidateAll();
    }
}
