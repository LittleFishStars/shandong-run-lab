package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.channel.bean.ClassificationBean;
import com.huachenjie.channel.page.create_channel.preference.ChooseChannelTypePreferenceAdapter;
import com.huachenjie.channel.page.create_channel.preference.ChooseTypePreferenceVM;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelActivityChooseTypePreferenceBindingImpl extends ChannelActivityChooseTypePreferenceBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33056a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7475a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7476a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f7477a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f7478a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f7475a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        f33056a = null;
    }

    public ChannelActivityChooseTypePreferenceBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f7475a, f33056a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0034  */
    /* JADX WARN: Code duplicated, block: B:43:0x0094  */
    /* JADX WARN: Code duplicated, block: B:46:0x009f  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ab  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        BindingTitleBean value;
        String str;
        ChooseChannelTypePreferenceAdapter value2;
        synchronized (this) {
            j = this.f7476a;
            this.f7476a = 0L;
        }
        ChooseTypePreferenceVM chooseTypePreferenceVM = ((ChannelActivityChooseTypePreferenceBinding) this).f7473a;
        if ((61 & j) != 0) {
            if ((j & 49) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataJ = chooseTypePreferenceVM != null ? chooseTypePreferenceVM.j() : null;
                updateLiveDataRegistration(0, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value = mutableLiveDataJ.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 52) != 0) {
                MutableLiveData<ClassificationBean> mutableLiveDataK = chooseTypePreferenceVM != null ? chooseTypePreferenceVM.k() : null;
                updateLiveDataRegistration(2, mutableLiveDataK);
                ClassificationBean value3 = mutableLiveDataK != null ? mutableLiveDataK.getValue() : null;
                str = String.format(((ChannelActivityChooseTypePreferenceBinding) this).f33055a.getResources().getString(com.huachenjie.channel.R.string.channel_type_preference_title), value3 != null ? value3.getClassificationName() : null);
            } else {
                str = null;
            }
            if ((j & 56) != 0) {
                MutableLiveData<ChooseChannelTypePreferenceAdapter> mutableLiveDataI = chooseTypePreferenceVM != null ? chooseTypePreferenceVM.i() : null;
                updateLiveDataRegistration(3, mutableLiveDataI);
                value2 = mutableLiveDataI != null ? mutableLiveDataI.getValue() : null;
            }
            if ((56 & j) != 0) {
                CommonBindingAdapter.g(this.f7478a, value2, false, false);
            }
            if ((j & 49) != 0) {
                ((ChannelActivityChooseTypePreferenceBinding) this).f7474a.k(value);
            }
            if ((j & 52) != 0) {
                TextViewBindingAdapter.setText(((ChannelActivityChooseTypePreferenceBinding) this).f33055a, str);
            }
            ViewDataBinding.executeBindingsOn(((ChannelActivityChooseTypePreferenceBinding) this).f7474a);
        }
        value = null;
        str = null;
        if ((56 & j) != 0) {
            CommonBindingAdapter.g(this.f7478a, value2, false, false);
        }
        if ((j & 49) != 0) {
            ((ChannelActivityChooseTypePreferenceBinding) this).f7474a.k(value);
        }
        if ((j & 52) != 0) {
            TextViewBindingAdapter.setText(((ChannelActivityChooseTypePreferenceBinding) this).f33055a, str);
        }
        ViewDataBinding.executeBindingsOn(((ChannelActivityChooseTypePreferenceBinding) this).f7474a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7476a != 0) {
                return true;
            }
            return ((ChannelActivityChooseTypePreferenceBinding) this).f7474a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7476a = 32L;
        }
        ((ChannelActivityChooseTypePreferenceBinding) this).f7474a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityChooseTypePreferenceBinding
    public void k(@Nullable ChooseTypePreferenceVM chooseTypePreferenceVM) {
        ((ChannelActivityChooseTypePreferenceBinding) this).f7473a = chooseTypePreferenceVM;
        synchronized (this) {
            this.f7476a |= 16;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean l(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7476a |= 2;
        }
        return true;
    }

    public final boolean m(MutableLiveData<ChooseChannelTypePreferenceAdapter> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7476a |= 8;
        }
        return true;
    }

    public final boolean n(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7476a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<ClassificationBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7476a |= 4;
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
        if (i == 2) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return m((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((ChannelActivityChooseTypePreferenceBinding) this).f7474a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 != i) {
            return false;
        }
        k((ChooseTypePreferenceVM) obj);
        return true;
    }

    public ChannelActivityChooseTypePreferenceBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (LayoutToolbarBindingBinding) objArr[3], (TextView) objArr[1]);
        this.f7476a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f7477a = constraintLayout;
        constraintLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[2];
        this.f7478a = recyclerView;
        recyclerView.setTag(null);
        setContainedBinding(((ChannelActivityChooseTypePreferenceBinding) this).f7474a);
        ((ChannelActivityChooseTypePreferenceBinding) this).f33055a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
