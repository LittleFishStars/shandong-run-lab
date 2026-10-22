package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.channel.adapter.ClubMessageAdapter;
import com.huachenjie.channel.page.organize_detail.OrganizeDetailVM;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelActivityOrganizeDetailBindingImpl extends ChannelActivityOrganizeDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33115a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7650a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7651a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f7652a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f7653a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(3);
        f7650a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{2}, new int[]{R.layout.layout_toolbar_binding});
        f33115a = null;
    }

    public ChannelActivityOrganizeDetailBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f7650a, f33115a));
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
        ClubMessageAdapter clubMessageAdapter;
        BindingTitleBean value;
        synchronized (this) {
            j = this.f7651a;
            this.f7651a = 0L;
        }
        OrganizeDetailVM organizeDetailVM = ((ChannelActivityOrganizeDetailBinding) this).f7649a;
        BindingTitleBean bindingTitleBean = null;
        value = null;
        ClubMessageAdapter value2 = null;
        if ((15 & j) != 0) {
            if ((j & 13) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = organizeDetailVM != null ? organizeDetailVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 14) != 0) {
                MutableLiveData<ClubMessageAdapter> mutableLiveDataL = organizeDetailVM != null ? organizeDetailVM.l() : null;
                updateLiveDataRegistration(1, mutableLiveDataL);
                if (mutableLiveDataL != null) {
                    value2 = mutableLiveDataL.getValue();
                }
            }
            clubMessageAdapter = value2;
            bindingTitleBean = value;
        } else {
            clubMessageAdapter = null;
        }
        if ((13 & j) != 0) {
            this.f7653a.k(bindingTitleBean);
        }
        if ((j & 14) != 0) {
            CommonBindingAdapter.g(((ChannelActivityOrganizeDetailBinding) this).f33114a, clubMessageAdapter, false, false);
        }
        ViewDataBinding.executeBindingsOn(this.f7653a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7651a != 0) {
                return true;
            }
            return this.f7653a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7651a = 8L;
        }
        this.f7653a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityOrganizeDetailBinding
    public void k(@Nullable OrganizeDetailVM organizeDetailVM) {
        ((ChannelActivityOrganizeDetailBinding) this).f7649a = organizeDetailVM;
        synchronized (this) {
            this.f7651a |= 4;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<ClubMessageAdapter> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7651a |= 2;
        }
        return true;
    }

    public final boolean m(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7651a |= 1;
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
        this.f7653a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 != i) {
            return false;
        }
        k((OrganizeDetailVM) obj);
        return true;
    }

    public ChannelActivityOrganizeDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (RecyclerView) objArr[1]);
        this.f7651a = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f7652a = frameLayout;
        frameLayout.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[2];
        this.f7653a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        ((ChannelActivityOrganizeDetailBinding) this).f33114a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
