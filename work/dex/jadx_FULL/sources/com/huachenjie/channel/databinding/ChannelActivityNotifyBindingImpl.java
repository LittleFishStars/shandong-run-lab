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
import com.huachenjie.channel.page.notify.NotifyAdapter;
import com.huachenjie.channel.page.notify.NotifyVM;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelActivityNotifyBindingImpl extends ChannelActivityNotifyBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33097a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7598a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7599a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7600a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f7601a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f7602a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(3);
        f7598a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{2}, new int[]{R.layout.layout_toolbar_binding});
        f33097a = null;
    }

    public ChannelActivityNotifyBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f7598a, f33097a));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0031  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        NotifyAdapter notifyAdapter;
        BindingTitleBean value;
        synchronized (this) {
            j = this.f7599a;
            this.f7599a = 0L;
        }
        NotifyVM notifyVM = ((ChannelActivityNotifyBinding) this).f33096a;
        BindingTitleBean bindingTitleBean = null;
        value = null;
        NotifyAdapter value2 = null;
        if ((15 & j) != 0) {
            if ((j & 13) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataL = notifyVM != null ? notifyVM.l() : null;
                updateLiveDataRegistration(0, mutableLiveDataL);
                if (mutableLiveDataL != null) {
                    value = mutableLiveDataL.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 14) != 0) {
                MutableLiveData<NotifyAdapter> mutableLiveDataK = notifyVM != null ? notifyVM.k() : null;
                updateLiveDataRegistration(1, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value2 = mutableLiveDataK.getValue();
                }
            }
            notifyAdapter = value2;
            bindingTitleBean = value;
        } else {
            notifyAdapter = null;
        }
        if ((13 & j) != 0) {
            this.f7602a.k(bindingTitleBean);
        }
        if ((j & 14) != 0) {
            CommonBindingAdapter.g(this.f7601a, notifyAdapter, false, false);
        }
        ViewDataBinding.executeBindingsOn(this.f7602a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7599a != 0) {
                return true;
            }
            return this.f7602a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7599a = 8L;
        }
        this.f7602a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityNotifyBinding
    public void k(@Nullable NotifyVM notifyVM) {
        ((ChannelActivityNotifyBinding) this).f33096a = notifyVM;
        synchronized (this) {
            this.f7599a |= 4;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<NotifyAdapter> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7599a |= 2;
        }
        return true;
    }

    public final boolean m(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7599a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return m((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return l((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f7602a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 != i) {
            return false;
        }
        k((NotifyVM) obj);
        return true;
    }

    public ChannelActivityNotifyBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2);
        this.f7599a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[2];
        this.f7602a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f7600a = linearLayout;
        linearLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[1];
        this.f7601a = recyclerView;
        recyclerView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
