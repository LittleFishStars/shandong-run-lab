package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.channel.page.advertise.preview.PreviewAdvertiseVM;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.CommonBannerBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.widget.CommonBanner;
import com.zj.adlib.tk0;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelActivityAdvertisePreviewBindingImpl extends ChannelActivityAdvertisePreviewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33031a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7399a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7400a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7401a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7402a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f7403a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f7399a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        f33031a = null;
    }

    public ChannelActivityAdvertisePreviewBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f7399a, f33031a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0035  */
    /* JADX WARN: Code duplicated, block: B:25:0x0051  */
    /* JADX WARN: Code duplicated, block: B:46:0x0085  */
    /* JADX WARN: Code duplicated, block: B:49:0x008f  */
    /* JADX WARN: Code duplicated, block: B:52:0x0099  */
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
        String value;
        boolean z;
        BindingTitleBean value2;
        synchronized (this) {
            j = this.f7400a;
            this.f7400a = 0L;
        }
        PreviewAdvertiseVM previewAdvertiseVM = ((ChannelActivityAdvertisePreviewBinding) this).f33030a;
        BindingTitleBean bindingTitleBean = null;
        if ((31 & j) != 0) {
            if ((j & 25) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = previewAdvertiseVM != null ? previewAdvertiseVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value2 = mutableLiveDataI.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 26) == 0) {
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataJ = previewAdvertiseVM != null ? previewAdvertiseVM.j() : null;
                updateLiveDataRegistration(1, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value = mutableLiveDataJ.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 28) != 0) {
                MutableLiveData<List<CommonBannerBean>> mutableLiveDataK = previewAdvertiseVM != null ? previewAdvertiseVM.k() : null;
                updateLiveDataRegistration(2, mutableLiveDataK);
                List<CommonBannerBean> value3 = mutableLiveDataK != null ? mutableLiveDataK.getValue() : null;
                z = (value3 != null ? value3.size() : 0) > 0;
                bindingTitleBean = value2;
            } else {
                bindingTitleBean = value2;
            }
            if ((28 & j) != 0) {
                CommonBindingAdapter.l0(((ChannelActivityAdvertisePreviewBinding) this).f7398a, z);
            }
            if ((25 & j) != 0) {
                this.f7403a.k(bindingTitleBean);
            }
            if ((j & 26) != 0) {
                TextViewBindingAdapter.setText(this.f7402a, value);
            }
            ViewDataBinding.executeBindingsOn(this.f7403a);
        }
        value = null;
        z = false;
        if ((28 & j) != 0) {
            CommonBindingAdapter.l0(((ChannelActivityAdvertisePreviewBinding) this).f7398a, z);
        }
        if ((25 & j) != 0) {
            this.f7403a.k(bindingTitleBean);
        }
        if ((j & 26) != 0) {
            TextViewBindingAdapter.setText(this.f7402a, value);
        }
        ViewDataBinding.executeBindingsOn(this.f7403a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7400a != 0) {
                return true;
            }
            return this.f7403a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7400a = 16L;
        }
        this.f7403a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityAdvertisePreviewBinding
    public void k(@Nullable PreviewAdvertiseVM previewAdvertiseVM) {
        ((ChannelActivityAdvertisePreviewBinding) this).f33030a = previewAdvertiseVM;
        synchronized (this) {
            this.f7400a |= 8;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<String> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7400a |= 2;
        }
        return true;
    }

    public final boolean m(MutableLiveData<List<CommonBannerBean>> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7400a |= 4;
        }
        return true;
    }

    public final boolean n(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7400a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return l((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return m((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f7403a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 != i) {
            return false;
        }
        k((PreviewAdvertiseVM) obj);
        return true;
    }

    public ChannelActivityAdvertisePreviewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (CommonBanner) objArr[1]);
        this.f7400a = -1L;
        ((ChannelActivityAdvertisePreviewBinding) this).f7398a.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[3];
        this.f7403a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f7401a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f7402a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
