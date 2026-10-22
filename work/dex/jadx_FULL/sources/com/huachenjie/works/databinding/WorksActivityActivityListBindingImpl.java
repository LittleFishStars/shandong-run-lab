package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.works.adapter.ActivityListAdapter;
import com.huachenjie.works.page.activity.ActivityListModel;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksActivityActivityListBindingImpl extends WorksActivityActivityListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36766a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13808a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13809a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f13810a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f13808a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        f36766a = null;
    }

    public WorksActivityActivityListBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f13808a, f36766a));
    }

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
        ActivityListAdapter activityListAdapter;
        int i;
        BindingTitleBean value;
        int statusBarHeight;
        synchronized (this) {
            j = this.f13809a;
            this.f13809a = 0L;
        }
        ActivityListModel activityListModel = ((WorksActivityActivityListBinding) this).f13807a;
        BindingTitleBean bindingTitleBean = null;
        value = null;
        ActivityListAdapter value2 = null;
        if ((29 & j) != 0) {
            if ((j & 25) != 0) {
                MutableLiveData<BindingTitleBean> mutableLiveDataK = activityListModel != null ? activityListModel.k() : null;
                updateLiveDataRegistration(0, mutableLiveDataK);
                value = mutableLiveDataK != null ? mutableLiveDataK.getValue() : null;
                statusBarHeight = (value != null ? value.getStatusBarHeight() : 0) + 8;
            } else {
                value = null;
                statusBarHeight = 0;
            }
            if ((j & 28) != 0) {
                MutableLiveData<ActivityListAdapter> mutableLiveDataJ = activityListModel != null ? activityListModel.j() : null;
                updateLiveDataRegistration(2, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value2 = mutableLiveDataJ.getValue();
                }
            }
            activityListAdapter = value2;
            i = statusBarHeight;
            bindingTitleBean = value;
        } else {
            activityListAdapter = null;
            i = 0;
        }
        if ((25 & j) != 0) {
            CommonBindingAdapter.I(((WorksActivityActivityListBinding) this).f36765a, 0, i, 0, 0, null);
            ((WorksActivityActivityListBinding) this).f13806a.k(bindingTitleBean);
        }
        if ((j & 28) != 0) {
            CommonBindingAdapter.g(((WorksActivityActivityListBinding) this).f13805a, activityListAdapter, false, false);
        }
        ViewDataBinding.executeBindingsOn(((WorksActivityActivityListBinding) this).f13806a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f13809a != 0) {
                return true;
            }
            return ((WorksActivityActivityListBinding) this).f13806a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13809a = 16L;
        }
        ((WorksActivityActivityListBinding) this).f13806a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksActivityActivityListBinding
    public void k(@Nullable ActivityListModel Vm) {
        ((WorksActivityActivityListBinding) this).f13807a = Vm;
        synchronized (this) {
            this.f13809a |= 8;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean l(LayoutToolbarBindingBinding TitleBar, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13809a |= 2;
        }
        return true;
    }

    public final boolean m(MutableLiveData<ActivityListAdapter> VmAdapter, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13809a |= 4;
        }
        return true;
    }

    public final boolean n(MutableLiveData<BindingTitleBean> VmTitleBean, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13809a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return n((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return l((LayoutToolbarBindingBinding) object, fieldId);
        }
        if (localFieldId != 2) {
            return false;
        }
        return m((MutableLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((WorksActivityActivityListBinding) this).f13806a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 != variableId) {
            return false;
        }
        k((ActivityListModel) variable);
        return true;
    }

    public WorksActivityActivityListBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (ImageView) bindings[2], (RecyclerView) bindings[1], (LayoutToolbarBindingBinding) bindings[3]);
        this.f13809a = -1L;
        ((WorksActivityActivityListBinding) this).f36765a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.f13810a = frameLayout;
        frameLayout.setTag(null);
        ((WorksActivityActivityListBinding) this).f13805a.setTag(null);
        setContainedBinding(((WorksActivityActivityListBinding) this).f13806a);
        setRootTag(root);
        invalidateAll();
    }
}
