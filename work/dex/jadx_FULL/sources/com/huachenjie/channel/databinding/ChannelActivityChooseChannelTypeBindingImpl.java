package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.channel.page.create_channel.type.ChooseChannelTypeAdapter;
import com.huachenjie.channel.page.create_channel.type.ChooseChannelTypeVM;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelActivityChooseChannelTypeBindingImpl extends ChannelActivityChooseChannelTypeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33054a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7469a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7470a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f7471a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f7472a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f7469a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{2}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33054a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.channel.R.id.tv_sub_title, 3);
    }

    public ChannelActivityChooseChannelTypeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f7469a, f33054a));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0031  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        BindingTitleBean value;
        synchronized (this) {
            j = this.f7470a;
            this.f7470a = 0L;
        }
        ChooseChannelTypeVM chooseChannelTypeVM = ((ChannelActivityChooseChannelTypeBinding) this).f7467a;
        ChooseChannelTypeAdapter value2 = null;
        if ((29 & j) != 0) {
            if ((j & 25) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataJ = chooseChannelTypeVM != null ? chooseChannelTypeVM.j() : null;
                updateLiveDataRegistration(0, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value = mutableLiveDataJ.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 28) != 0) {
                MutableLiveData<ChooseChannelTypeAdapter> mutableLiveDataI = chooseChannelTypeVM != null ? chooseChannelTypeVM.i() : null;
                updateLiveDataRegistration(2, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value2 = mutableLiveDataI.getValue();
                }
            }
        } else {
            value = null;
        }
        if ((28 & j) != 0) {
            CommonBindingAdapter.g(this.f7472a, value2, false, false);
        }
        if ((j & 25) != 0) {
            ((ChannelActivityChooseChannelTypeBinding) this).f7468a.k(value);
        }
        ViewDataBinding.executeBindingsOn(((ChannelActivityChooseChannelTypeBinding) this).f7468a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7470a != 0) {
                return true;
            }
            return ((ChannelActivityChooseChannelTypeBinding) this).f7468a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7470a = 16L;
        }
        ((ChannelActivityChooseChannelTypeBinding) this).f7468a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityChooseChannelTypeBinding
    public void k(@Nullable ChooseChannelTypeVM chooseChannelTypeVM) {
        ((ChannelActivityChooseChannelTypeBinding) this).f7467a = chooseChannelTypeVM;
        synchronized (this) {
            this.f7470a |= 8;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean l(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7470a |= 2;
        }
        return true;
    }

    public final boolean m(MutableLiveData<ChooseChannelTypeAdapter> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7470a |= 4;
        }
        return true;
    }

    public final boolean n(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7470a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return l((LayoutToolbarBindingBinding) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return m((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((ChannelActivityChooseChannelTypeBinding) this).f7468a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 != i) {
            return false;
        }
        k((ChooseChannelTypeVM) obj);
        return true;
    }

    public ChannelActivityChooseChannelTypeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (LayoutToolbarBindingBinding) objArr[2], (TextView) objArr[3]);
        this.f7470a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f7471a = constraintLayout;
        constraintLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[1];
        this.f7472a = recyclerView;
        recyclerView.setTag(null);
        setContainedBinding(((ChannelActivityChooseChannelTypeBinding) this).f7468a);
        setRootTag(view);
        invalidateAll();
    }
}
