package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.BroadcastFloorMessageBean;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailVM;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksDialogBroadcastFloorDetailBindingImpl extends WorksDialogBroadcastFloorDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36835a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14008a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14009a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14010a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14011a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f14012a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BroadcastFloorDetailDialog.ClickProxy f36836a;

        public a a(BroadcastFloorDetailDialog.ClickProxy value) {
            this.f36836a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36836a.c(arg0);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(3);
        f14008a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"works_item_broadcast_floor"}, new int[]{2}, new int[]{R.layout.works_item_broadcast_floor});
        f36835a = null;
    }

    public WorksDialogBroadcastFloorDetailBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, f14008a, f36835a));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        BroadcastFloorMessageBean value;
        a aVarA;
        synchronized (this) {
            j = this.f14009a;
            this.f14009a = 0L;
        }
        BroadcastFloorDetailVM broadcastFloorDetailVM = ((WorksDialogBroadcastFloorDetailBinding) this).f14007a;
        BroadcastFloorDetailDialog.ClickProxy clickProxy = ((WorksDialogBroadcastFloorDetailBinding) this).f14006a;
        long j2 = 22 & j;
        if (j2 == 0) {
            value = null;
        } else {
            MutableLiveData<BroadcastFloorMessageBean> mutableLiveDataI = broadcastFloorDetailVM != null ? broadcastFloorDetailVM.i() : null;
            updateLiveDataRegistration(1, mutableLiveDataI);
            if (mutableLiveDataI != null) {
                value = mutableLiveDataI.getValue();
            } else {
                value = null;
            }
        }
        long j3 = j & 24;
        if (j3 == 0 || clickProxy == null) {
            aVarA = null;
        } else {
            a aVar = this.f14012a;
            if (aVar == null) {
                aVar = new a();
                this.f14012a = aVar;
            }
            aVarA = aVar.a(clickProxy);
        }
        if (j2 != 0) {
            ((WorksDialogBroadcastFloorDetailBinding) this).f36834a.k(value);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f14010a, aVarA, null);
        }
        ViewDataBinding.executeBindingsOn(((WorksDialogBroadcastFloorDetailBinding) this).f36834a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f14009a != 0) {
                return true;
            }
            return ((WorksDialogBroadcastFloorDetailBinding) this).f36834a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14009a = 16L;
        }
        ((WorksDialogBroadcastFloorDetailBinding) this).f36834a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksDialogBroadcastFloorDetailBinding
    public void l(@Nullable BroadcastFloorDetailDialog.ClickProxy Click) {
        ((WorksDialogBroadcastFloorDetailBinding) this).f14006a = Click;
        synchronized (this) {
            this.f14009a |= 8;
        }
        notifyPropertyChanged(qk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksDialogBroadcastFloorDetailBinding
    public void m(@Nullable BroadcastFloorDetailVM Vm) {
        ((WorksDialogBroadcastFloorDetailBinding) this).f14007a = Vm;
        synchronized (this) {
            this.f14009a |= 4;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean n(WorksItemBroadcastFloorBinding Content, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14009a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<BroadcastFloorMessageBean> VmBean, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14009a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return n((WorksItemBroadcastFloorBinding) object, fieldId);
        }
        if (localFieldId != 1) {
            return false;
        }
        return o((MutableLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((WorksDialogBroadcastFloorDetailBinding) this).f36834a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 == variableId) {
            m((BroadcastFloorDetailVM) variable);
        } else {
            if (qk0.k != variableId) {
                return false;
            }
            l((BroadcastFloorDetailDialog.ClickProxy) variable);
        }
        return true;
    }

    public WorksDialogBroadcastFloorDetailBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (WorksItemBroadcastFloorBinding) bindings[2]);
        this.f14009a = -1L;
        setContainedBinding(((WorksDialogBroadcastFloorDetailBinding) this).f36834a);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f14011a = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.f14010a = imageView;
        imageView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
