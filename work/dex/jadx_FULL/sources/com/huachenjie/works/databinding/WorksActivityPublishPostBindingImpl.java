package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
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
import com.huachenjie.common.widget.DrawableCenterButton;
import com.huachenjie.works.page.post.PublishPostActivity;
import com.huachenjie.works.page.post.PublishPostAdapter;
import com.huachenjie.works.page.post.PublishPostVM;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksActivityPublishPostBindingImpl extends WorksActivityPublishPostBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36793a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13905a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13906a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13907a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f13908a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final DrawableCenterButton f13909a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f13910a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PublishPostActivity.a f36794a;

        public a a(PublishPostActivity.a value) {
            this.f36794a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36794a.a(arg0);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        f13905a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36793a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.works.R.id.cb_anonymity, 4);
    }

    public WorksActivityPublishPostBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 5, f13905a, f36793a));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0033  */
    /* JADX WARN: Code duplicated, block: B:24:0x004f  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        PublishPostAdapter value;
        BindingTitleBean value2;
        a aVarA;
        synchronized (this) {
            j = this.f13906a;
            this.f13906a = 0L;
        }
        PublishPostVM publishPostVM = ((WorksActivityPublishPostBinding) this).f13904a;
        PublishPostActivity.a aVar = ((WorksActivityPublishPostBinding) this).f13903a;
        if ((23 & j) != 0) {
            if ((j & 21) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = publishPostVM != null ? publishPostVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value2 = mutableLiveDataI.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 22) == 0) {
                value = null;
            } else {
                MutableLiveData<PublishPostAdapter> mutableLiveDataM = publishPostVM != null ? publishPostVM.m() : null;
                updateLiveDataRegistration(1, mutableLiveDataM);
                if (mutableLiveDataM != null) {
                    value = mutableLiveDataM.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
        }
        long j2 = 24 & j;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f13910a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f13910a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if ((21 & j) != 0) {
            this.f13908a.k(value2);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f13909a, aVarA, null);
        }
        if ((j & 22) != 0) {
            CommonBindingAdapter.g(((WorksActivityPublishPostBinding) this).f13902a, value, false, false);
        }
        ViewDataBinding.executeBindingsOn(this.f13908a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f13906a != 0) {
                return true;
            }
            return this.f13908a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13906a = 16L;
        }
        this.f13908a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksActivityPublishPostBinding
    public void l(@Nullable PublishPostActivity.a Click) {
        ((WorksActivityPublishPostBinding) this).f13903a = Click;
        synchronized (this) {
            this.f13906a |= 8;
        }
        notifyPropertyChanged(qk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksActivityPublishPostBinding
    public void m(@Nullable PublishPostVM Vm) {
        ((WorksActivityPublishPostBinding) this).f13904a = Vm;
        synchronized (this) {
            this.f13906a |= 4;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<PublishPostAdapter> VmAdapter, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13906a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<BindingTitleBean> VmTitleBean, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13906a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return o((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 1) {
            return false;
        }
        return n((MutableLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f13908a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 == variableId) {
            m((PublishPostVM) variable);
        } else {
            if (qk0.k != variableId) {
                return false;
            }
            l((PublishPostActivity.a) variable);
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r7v9, types: [android.view.View, com.huachenjie.common.widget.DrawableCenterButton] */
    public WorksActivityPublishPostBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (CheckBox) bindings[4], (RecyclerView) bindings[1]);
        this.f13906a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) bindings[3];
        this.f13908a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f13907a = linearLayout;
        linearLayout.setTag(null);
        ?? r7 = (DrawableCenterButton) bindings[2];
        this.f13909a = r7;
        r7.setTag(null);
        ((WorksActivityPublishPostBinding) this).f13902a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
