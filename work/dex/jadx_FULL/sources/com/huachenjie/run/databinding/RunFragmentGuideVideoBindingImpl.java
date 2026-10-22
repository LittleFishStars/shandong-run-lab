package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import com.huachenjie.base.view.CustomVideoView;
import com.huachenjie.run.R;
import com.huachenjie.run.page.geofence.GeoFenceV2VM;
import com.huachenjie.run.page.geofence.VideoGuideFragment;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunFragmentGuideVideoBindingImpl extends RunFragmentGuideVideoBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35588a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11855a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11856a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f11857a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11858a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public VideoGuideFragment.a f35589a;

        public a a(VideoGuideFragment.a value) {
            this.f35589a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35589a.a(arg0);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f11855a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"run_layout_run_guide_customer_service", "run_layout_run_guide_tip"}, new int[]{1, 2}, new int[]{R.layout.run_layout_run_guide_customer_service, R.layout.run_layout_run_guide_tip});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35588a = sparseIntArray;
        sparseIntArray.put(R.id.playView, 3);
    }

    public RunFragmentGuideVideoBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f11855a, f35588a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        a aVarA;
        synchronized (this) {
            j = this.f11856a;
            this.f11856a = 0L;
        }
        VideoGuideFragment.a aVar = ((RunFragmentGuideVideoBinding) this).f11854a;
        long j2 = j & 24;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f11858a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f11858a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            ((RunFragmentGuideVideoBinding) this).f11851a.setOnClick(aVarA);
        }
        ViewDataBinding.executeBindingsOn(((RunFragmentGuideVideoBinding) this).f11851a);
        ViewDataBinding.executeBindingsOn(((RunFragmentGuideVideoBinding) this).f11852a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11856a != 0) {
                return true;
            }
            return ((RunFragmentGuideVideoBinding) this).f11851a.hasPendingBindings() || ((RunFragmentGuideVideoBinding) this).f11852a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11856a = 16L;
        }
        ((RunFragmentGuideVideoBinding) this).f11851a.invalidateAll();
        ((RunFragmentGuideVideoBinding) this).f11852a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunFragmentGuideVideoBinding
    public void l(@Nullable VideoGuideFragment.a Click) {
        ((RunFragmentGuideVideoBinding) this).f11854a = Click;
        synchronized (this) {
            this.f11856a |= 8;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunFragmentGuideVideoBinding
    public void m(@Nullable GeoFenceV2VM MState) {
        ((RunFragmentGuideVideoBinding) this).f11853a = MState;
    }

    public final boolean n(RunLayoutRunGuideCustomerServiceBinding IncludeCs, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11856a |= 1;
        }
        return true;
    }

    public final boolean o(RunLayoutRunGuideTipBinding IncludeTip, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11856a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return n((RunLayoutRunGuideCustomerServiceBinding) object, fieldId);
        }
        if (localFieldId != 1) {
            return false;
        }
        return o((RunLayoutRunGuideTipBinding) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((RunFragmentGuideVideoBinding) this).f11851a.setLifecycleOwner(lifecycleOwner);
        ((RunFragmentGuideVideoBinding) this).f11852a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.L == variableId) {
            m((GeoFenceV2VM) variable);
        } else {
            if (lk0.k != variableId) {
                return false;
            }
            l((VideoGuideFragment.a) variable);
        }
        return true;
    }

    public RunFragmentGuideVideoBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (RunLayoutRunGuideCustomerServiceBinding) bindings[1], (RunLayoutRunGuideTipBinding) bindings[2], (CustomVideoView) bindings[3]);
        this.f11856a = -1L;
        setContainedBinding(((RunFragmentGuideVideoBinding) this).f11851a);
        setContainedBinding(((RunFragmentGuideVideoBinding) this).f11852a);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.f11857a = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
