package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
import com.huachenjie.works.page.campus_wall.post.PostAdapter;
import com.huachenjie.works.page.campus_wall.post.list.PostListActivity;
import com.huachenjie.works.page.campus_wall.post.list.PostListVM;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksActivityHotListBindingImpl extends WorksActivityHotListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36781a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13870a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13871a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f13872a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f13873a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13874a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f13875a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f13876a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f13877a;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f36782a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener value) {
            this.f36782a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f36782a.onRefresh();
        }
    }

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PostListActivity.a f36783a;

        public a a(PostListActivity.a value) {
            this.f36783a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36783a.a(arg0);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(6);
        f13870a = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"layout_toolbar_binding"}, new int[]{5}, new int[]{R.layout.layout_toolbar_binding});
        f36781a = null;
    }

    public WorksActivityHotListBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 6, f13870a, f36781a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0037  */
    /* JADX WARN: Code duplicated, block: B:36:0x0077  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        PostAdapter value;
        BindingTitleBean value2;
        boolean zSafeUnbox;
        OnRefreshListenerImpl onRefreshListenerImplA;
        a aVarA;
        synchronized (this) {
            j = this.f13871a;
            this.f13871a = 0L;
        }
        PostListVM postListVM = ((WorksActivityHotListBinding) this).f13869a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((WorksActivityHotListBinding) this).f13866a;
        PostListActivity.a aVar = ((WorksActivityHotListBinding) this).f13868a;
        if ((157 & j) != 0) {
            if ((j & 145) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = postListVM != null ? postListVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value2 = mutableLiveDataI.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 148) != 0) {
                MutableLiveData<Boolean> mutableLiveDataN = postListVM != null ? postListVM.n() : null;
                updateLiveDataRegistration(2, mutableLiveDataN);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataN != null ? mutableLiveDataN.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 152) == 0) {
                value = null;
            } else {
                MutableLiveData<PostAdapter> mutableLiveDataJ = postListVM != null ? postListVM.j() : null;
                updateLiveDataRegistration(3, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value = mutableLiveDataJ.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
            zSafeUnbox = false;
        }
        long j2 = 160 & j;
        if (j2 == 0 || onRefreshListener == null) {
            onRefreshListenerImplA = null;
        } else {
            OnRefreshListenerImpl onRefreshListenerImpl = this.f13876a;
            if (onRefreshListenerImpl == null) {
                onRefreshListenerImpl = new OnRefreshListenerImpl();
                this.f13876a = onRefreshListenerImpl;
            }
            onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
        }
        long j3 = j & 192;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f13877a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f13877a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            this.f13875a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((148 & j) != 0) {
            this.f13875a.setRefreshing(zSafeUnbox);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f13873a, aVarA, null);
        }
        if ((152 & j) != 0) {
            CommonBindingAdapter.g(((WorksActivityHotListBinding) this).f36780a, value, false, false);
        }
        if ((j & 145) != 0) {
            ((WorksActivityHotListBinding) this).f13867a.k(value2);
        }
        ViewDataBinding.executeBindingsOn(((WorksActivityHotListBinding) this).f13867a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f13871a != 0) {
                return true;
            }
            return ((WorksActivityHotListBinding) this).f13867a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13871a = 128L;
        }
        ((WorksActivityHotListBinding) this).f13867a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksActivityHotListBinding
    public void m(@Nullable PostListActivity.a Click) {
        ((WorksActivityHotListBinding) this).f13868a = Click;
        synchronized (this) {
            this.f13871a |= 64;
        }
        notifyPropertyChanged(qk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksActivityHotListBinding
    public void n(@Nullable PostListVM Vm) {
        ((WorksActivityHotListBinding) this).f13869a = Vm;
        synchronized (this) {
            this.f13871a |= 16;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean o(LayoutToolbarBindingBinding Toolbar, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13871a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return r((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return o((LayoutToolbarBindingBinding) object, fieldId);
        }
        if (localFieldId == 2) {
            return q((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 3) {
            return false;
        }
        return p((MutableLiveData) object, fieldId);
    }

    public final boolean p(MutableLiveData<PostAdapter> VmAdapter, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13871a |= 8;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Boolean> VmIsRefreshing, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13871a |= 4;
        }
        return true;
    }

    public final boolean r(MutableLiveData<BindingTitleBean> VmTitleBean, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13871a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((WorksActivityHotListBinding) this).f13867a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // com.huachenjie.works.databinding.WorksActivityHotListBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener Refresh) {
        ((WorksActivityHotListBinding) this).f13866a = Refresh;
        synchronized (this) {
            this.f13871a |= 32;
        }
        notifyPropertyChanged(qk0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 == variableId) {
            n((PostListVM) variable);
        } else if (qk0.R == variableId) {
            setRefresh((SwipeRefreshLayout.OnRefreshListener) variable);
        } else {
            if (qk0.k != variableId) {
                return false;
            }
            m((PostListActivity.a) variable);
        }
        return true;
    }

    public WorksActivityHotListBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4, (RecyclerView) bindings[3], (LayoutToolbarBindingBinding) bindings[5]);
        this.f13871a = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.f13872a = frameLayout;
        frameLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[1];
        this.f13874a = linearLayout;
        linearLayout.setTag(null);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) bindings[2];
        this.f13875a = swipeRefreshLayout;
        swipeRefreshLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[4];
        this.f13873a = imageView;
        imageView.setTag(null);
        ((WorksActivityHotListBinding) this).f36780a.setTag(null);
        setContainedBinding(((WorksActivityHotListBinding) this).f13867a);
        setRootTag(root);
        invalidateAll();
    }
}
