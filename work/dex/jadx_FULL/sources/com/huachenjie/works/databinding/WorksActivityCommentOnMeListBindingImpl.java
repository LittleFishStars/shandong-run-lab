package com.huachenjie.works.databinding;

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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.works.external.adapter.CommentOnMeAdapter;
import com.huachenjie.works.page.comment.me_list.CommentOnMeListModel;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksActivityCommentOnMeListBindingImpl extends WorksActivityCommentOnMeListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36776a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13845a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13846a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13847a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f13848a;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f36777a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener value) {
            this.f36777a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f36777a.onRefresh();
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f13845a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        f36776a = null;
    }

    public WorksActivityCommentOnMeListBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f13845a, f36776a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    /* JADX WARN: Code duplicated, block: B:36:0x0076  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        CommentOnMeAdapter value;
        BindingTitleBean value2;
        OnRefreshListenerImpl onRefreshListenerImplA;
        synchronized (this) {
            j = this.f13846a;
            this.f13846a = 0L;
        }
        CommentOnMeListModel commentOnMeListModel = ((WorksActivityCommentOnMeListBinding) this).f13844a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((WorksActivityCommentOnMeListBinding) this).f13841a;
        if ((93 & j) != 0) {
            if ((j & 81) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = commentOnMeListModel != null ? commentOnMeListModel.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value2 = mutableLiveDataI.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 84) != 0) {
                MutableLiveData<Boolean> mutableLiveDataV = commentOnMeListModel != null ? commentOnMeListModel.v() : null;
                updateLiveDataRegistration(2, mutableLiveDataV);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataV != null ? mutableLiveDataV.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 88) == 0) {
                value = null;
            } else {
                MutableLiveData<CommentOnMeAdapter> mutableLiveDataB = commentOnMeListModel != null ? commentOnMeListModel.B() : null;
                updateLiveDataRegistration(3, mutableLiveDataB);
                if (mutableLiveDataB != null) {
                    value = mutableLiveDataB.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            zSafeUnbox = false;
            value = null;
            value2 = null;
        }
        long j2 = j & 96;
        if (j2 == 0 || onRefreshListener == null) {
            onRefreshListenerImplA = null;
        } else {
            OnRefreshListenerImpl onRefreshListenerImpl = this.f13848a;
            if (onRefreshListenerImpl == null) {
                onRefreshListenerImpl = new OnRefreshListenerImpl();
                this.f13848a = onRefreshListenerImpl;
            }
            onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
        }
        if (j2 != 0) {
            ((WorksActivityCommentOnMeListBinding) this).f13842a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((84 & j) != 0) {
            ((WorksActivityCommentOnMeListBinding) this).f13842a.setRefreshing(zSafeUnbox);
        }
        if ((88 & j) != 0) {
            CommonBindingAdapter.g(((WorksActivityCommentOnMeListBinding) this).f36775a, value, false, false);
        }
        if ((j & 81) != 0) {
            ((WorksActivityCommentOnMeListBinding) this).f13843a.k(value2);
        }
        ViewDataBinding.executeBindingsOn(((WorksActivityCommentOnMeListBinding) this).f13843a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f13846a != 0) {
                return true;
            }
            return ((WorksActivityCommentOnMeListBinding) this).f13843a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13846a = 64L;
        }
        ((WorksActivityCommentOnMeListBinding) this).f13843a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksActivityCommentOnMeListBinding
    public void l(@Nullable CommentOnMeListModel Vm) {
        ((WorksActivityCommentOnMeListBinding) this).f13844a = Vm;
        synchronized (this) {
            this.f13846a |= 16;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean m(LayoutToolbarBindingBinding Toolbar, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13846a |= 2;
        }
        return true;
    }

    public final boolean n(MutableLiveData<CommentOnMeAdapter> VmAdapter, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13846a |= 8;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> VmIsRefreshing, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13846a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return p((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return m((LayoutToolbarBindingBinding) object, fieldId);
        }
        if (localFieldId == 2) {
            return o((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 3) {
            return false;
        }
        return n((MutableLiveData) object, fieldId);
    }

    public final boolean p(MutableLiveData<BindingTitleBean> VmTitleBean, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13846a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((WorksActivityCommentOnMeListBinding) this).f13843a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // com.huachenjie.works.databinding.WorksActivityCommentOnMeListBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener Refresh) {
        ((WorksActivityCommentOnMeListBinding) this).f13841a = Refresh;
        synchronized (this) {
            this.f13846a |= 32;
        }
        notifyPropertyChanged(qk0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 == variableId) {
            l((CommentOnMeListModel) variable);
        } else {
            if (qk0.R != variableId) {
                return false;
            }
            setRefresh((SwipeRefreshLayout.OnRefreshListener) variable);
        }
        return true;
    }

    public WorksActivityCommentOnMeListBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4, (SwipeRefreshLayout) bindings[1], (RecyclerView) bindings[2], (LayoutToolbarBindingBinding) bindings[3]);
        this.f13846a = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f13847a = linearLayout;
        linearLayout.setTag(null);
        ((WorksActivityCommentOnMeListBinding) this).f13842a.setTag(null);
        ((WorksActivityCommentOnMeListBinding) this).f36775a.setTag(null);
        setContainedBinding(((WorksActivityCommentOnMeListBinding) this).f13843a);
        setRootTag(root);
        invalidateAll();
    }
}
