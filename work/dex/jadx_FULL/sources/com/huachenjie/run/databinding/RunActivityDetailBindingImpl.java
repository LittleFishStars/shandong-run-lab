package com.huachenjie.run.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.widget.ShadowLayout;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RunDetailEntity;
import com.huachenjie.run.page.run_detail.RunDetailActivity;
import com.huachenjie.run.page.run_detail.RunDetailVM;
import com.huawei.hms.utils.FileUtil;
import com.noober.background.view.BLTextView;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunActivityDetailBindingImpl extends RunActivityDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35455a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11458a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11459a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShadowLayout f11460a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11461a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f11462a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f11463a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11464a;

    @NonNull
    public final FrameLayout c;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RunDetailActivity.a f35456a;

        public a a(RunDetailActivity.a value) {
            this.f35456a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35456a.back(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RunDetailActivity.a f35457a;

        public b a(RunDetailActivity.a value) {
            this.f35457a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35457a.c(arg0);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RunDetailActivity.a f35458a;

        public c a(RunDetailActivity.a value) {
            this.f35458a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35458a.a(arg0);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(18);
        f11458a = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"run_layout_statics", "run_layout_run_record_status", "run_layout_metrics", "run_layout_pace_list", "run_layout_step_list", "run_layout_run_vision", "run_layout_run_face_detect", "run_layout_run_face_machine"}, new int[]{8, 9, 10, 11, 12, 13, 14, 15}, new int[]{R.layout.run_layout_statics, R.layout.run_layout_run_record_status, R.layout.run_layout_metrics, R.layout.run_layout_pace_list, R.layout.run_layout_step_list, R.layout.run_layout_run_vision, R.layout.run_layout_run_face_detect, R.layout.run_layout_run_face_machine});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35455a = sparseIntArray;
        sparseIntArray.put(R.id.nsv, 16);
        sparseIntArray.put(R.id.ll_list_end, 17);
    }

    public RunActivityDetailBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 18, f11458a, f35455a));
    }

    /* JADX WARN: Code duplicated, block: B:73:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:76:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:78:0x0103  */
    /* JADX WARN: Code duplicated, block: B:81:0x0123  */
    /* JADX WARN: Code duplicated, block: B:84:0x0152  */
    /* JADX WARN: Code duplicated, block: B:87:0x016d  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        float f;
        boolean z;
        int i;
        int i2;
        long j2;
        a aVarA;
        b bVarA;
        c cVarA;
        int iSafeUnbox;
        synchronized (this) {
            j = this.f11459a;
            this.f11459a = 0L;
        }
        RunDetailVM runDetailVM = ((RunActivityDetailBinding) this).f11455a;
        RunDetailActivity.a aVar = ((RunActivityDetailBinding) this).f11454a;
        float fSafeUnbox = 0.0f;
        if ((10628 & j) != 0) {
            if ((j & 10244) != 0) {
                MutableLiveData<Float> mutableLiveDataM = runDetailVM != null ? runDetailVM.m() : null;
                updateLiveDataRegistration(2, mutableLiveDataM);
                fSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataM != null ? mutableLiveDataM.getValue() : null);
            }
            if ((j & 10368) != 0) {
                BaseViewModel.b bVarE = runDetailVM != null ? runDetailVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(7, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            long j3 = j & 10496;
            if (j3 != 0) {
                MutableLiveData<RunDetailEntity> mutableLiveDataL = runDetailVM != null ? runDetailVM.l() : null;
                updateLiveDataRegistration(8, mutableLiveDataL);
                RunDetailEntity value = mutableLiveDataL != null ? mutableLiveDataL.getValue() : null;
                boolean z2 = (value != null ? value.getSunRunRecordStatus() : 0) == 3;
                if (j3 != 0) {
                    j |= z2 ? PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID : PlaybackStateCompat.ACTION_PREPARE;
                }
                i = iSafeUnbox;
                i2 = z2 ? 88 : 0;
                f = fSafeUnbox;
                z = z2;
            } else {
                i = iSafeUnbox;
                f = fSafeUnbox;
                z = false;
            }
            j2 = 12288 & j;
            if (j2 != 0 || aVar == null) {
                aVarA = null;
                bVarA = null;
                cVarA = null;
            } else {
                c cVar = this.f11463a;
                if (cVar == null) {
                    cVar = new c();
                    this.f11463a = cVar;
                }
                cVarA = cVar.a(aVar);
                a aVar2 = this.f11461a;
                if (aVar2 == null) {
                    aVar2 = new a();
                    this.f11461a = aVar2;
                }
                aVarA = aVar2.a(aVar);
                b bVar = this.f11462a;
                if (bVar == null) {
                    bVar = new b();
                    this.f11462a = bVar;
                }
                bVarA = bVar.a(aVar);
            }
            if ((10244 & j) != 0) {
                CommonBindingAdapter.f0(((RunActivityDetailBinding) this).f35454a, f);
            }
            if (j2 != 0) {
                CommonBindingAdapter.q(((RunActivityDetailBinding) this).f11443a, aVarA, null);
                CommonBindingAdapter.q(((RunActivityDetailBinding) this).f11456b, bVarA, null);
                ((RunActivityDetailBinding) this).f11448a.l(aVar);
                ((RunActivityDetailBinding) this).f11452a.l(aVar);
                CommonBindingAdapter.q(this.f11464a, cVarA, null);
            }
            if ((FileUtil.LOCAL_REPORT_FILE_MAX_SIZE & j) != 0) {
                ((RunActivityDetailBinding) this).f11448a.m(runDetailVM);
                ((RunActivityDetailBinding) this).f11449a.k(runDetailVM);
                ((RunActivityDetailBinding) this).f11446a.k(runDetailVM);
                ((RunActivityDetailBinding) this).f11447a.k(runDetailVM);
                ((RunActivityDetailBinding) this).f11452a.m(runDetailVM);
                ((RunActivityDetailBinding) this).f11450a.k(runDetailVM);
                ((RunActivityDetailBinding) this).f11453a.k(runDetailVM);
                ((RunActivityDetailBinding) this).f11451a.k(runDetailVM);
            }
            if ((10496 & j) != 0) {
                CommonBindingAdapter.O(((RunActivityDetailBinding) this).f11444a, 0, 0, 0, i2, null);
                CommonBindingAdapter.l0(this.f11460a, z);
            }
            if ((j & 10368) != 0) {
                CommonBindingAdapter.O(((RunActivityDetailBinding) this).b, 0, i, 0, 0, null);
            }
            ViewDataBinding.executeBindingsOn(((RunActivityDetailBinding) this).f11452a);
            ViewDataBinding.executeBindingsOn(((RunActivityDetailBinding) this).f11450a);
            ViewDataBinding.executeBindingsOn(((RunActivityDetailBinding) this).f11446a);
            ViewDataBinding.executeBindingsOn(((RunActivityDetailBinding) this).f11447a);
            ViewDataBinding.executeBindingsOn(((RunActivityDetailBinding) this).f11453a);
            ViewDataBinding.executeBindingsOn(((RunActivityDetailBinding) this).f11451a);
            ViewDataBinding.executeBindingsOn(((RunActivityDetailBinding) this).f11448a);
            ViewDataBinding.executeBindingsOn(((RunActivityDetailBinding) this).f11449a);
        }
        f = 0.0f;
        z = false;
        i = 0;
        i2 = 0;
        j2 = 12288 & j;
        if (j2 != 0) {
            aVarA = null;
            bVarA = null;
            cVarA = null;
        } else {
            aVarA = null;
            bVarA = null;
            cVarA = null;
        }
        if ((10244 & j) != 0) {
            CommonBindingAdapter.f0(((RunActivityDetailBinding) this).f35454a, f);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((RunActivityDetailBinding) this).f11443a, aVarA, null);
            CommonBindingAdapter.q(((RunActivityDetailBinding) this).f11456b, bVarA, null);
            ((RunActivityDetailBinding) this).f11448a.l(aVar);
            ((RunActivityDetailBinding) this).f11452a.l(aVar);
            CommonBindingAdapter.q(this.f11464a, cVarA, null);
        }
        if ((FileUtil.LOCAL_REPORT_FILE_MAX_SIZE & j) != 0) {
            ((RunActivityDetailBinding) this).f11448a.m(runDetailVM);
            ((RunActivityDetailBinding) this).f11449a.k(runDetailVM);
            ((RunActivityDetailBinding) this).f11446a.k(runDetailVM);
            ((RunActivityDetailBinding) this).f11447a.k(runDetailVM);
            ((RunActivityDetailBinding) this).f11452a.m(runDetailVM);
            ((RunActivityDetailBinding) this).f11450a.k(runDetailVM);
            ((RunActivityDetailBinding) this).f11453a.k(runDetailVM);
            ((RunActivityDetailBinding) this).f11451a.k(runDetailVM);
        }
        if ((10496 & j) != 0) {
            CommonBindingAdapter.O(((RunActivityDetailBinding) this).f11444a, 0, 0, 0, i2, null);
            CommonBindingAdapter.l0(this.f11460a, z);
        }
        if ((j & 10368) != 0) {
            CommonBindingAdapter.O(((RunActivityDetailBinding) this).b, 0, i, 0, 0, null);
        }
        ViewDataBinding.executeBindingsOn(((RunActivityDetailBinding) this).f11452a);
        ViewDataBinding.executeBindingsOn(((RunActivityDetailBinding) this).f11450a);
        ViewDataBinding.executeBindingsOn(((RunActivityDetailBinding) this).f11446a);
        ViewDataBinding.executeBindingsOn(((RunActivityDetailBinding) this).f11447a);
        ViewDataBinding.executeBindingsOn(((RunActivityDetailBinding) this).f11453a);
        ViewDataBinding.executeBindingsOn(((RunActivityDetailBinding) this).f11451a);
        ViewDataBinding.executeBindingsOn(((RunActivityDetailBinding) this).f11448a);
        ViewDataBinding.executeBindingsOn(((RunActivityDetailBinding) this).f11449a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11459a != 0) {
                return true;
            }
            return ((RunActivityDetailBinding) this).f11452a.hasPendingBindings() || ((RunActivityDetailBinding) this).f11450a.hasPendingBindings() || ((RunActivityDetailBinding) this).f11446a.hasPendingBindings() || ((RunActivityDetailBinding) this).f11447a.hasPendingBindings() || ((RunActivityDetailBinding) this).f11453a.hasPendingBindings() || ((RunActivityDetailBinding) this).f11451a.hasPendingBindings() || ((RunActivityDetailBinding) this).f11448a.hasPendingBindings() || ((RunActivityDetailBinding) this).f11449a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11459a = 8192L;
        }
        ((RunActivityDetailBinding) this).f11452a.invalidateAll();
        ((RunActivityDetailBinding) this).f11450a.invalidateAll();
        ((RunActivityDetailBinding) this).f11446a.invalidateAll();
        ((RunActivityDetailBinding) this).f11447a.invalidateAll();
        ((RunActivityDetailBinding) this).f11453a.invalidateAll();
        ((RunActivityDetailBinding) this).f11451a.invalidateAll();
        ((RunActivityDetailBinding) this).f11448a.invalidateAll();
        ((RunActivityDetailBinding) this).f11449a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivityDetailBinding
    public void l(@Nullable RunDetailActivity.a Click) {
        ((RunActivityDetailBinding) this).f11454a = Click;
        synchronized (this) {
            this.f11459a |= 4096;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivityDetailBinding
    public void m(@Nullable RunDetailVM Vm) {
        ((RunActivityDetailBinding) this).f11455a = Vm;
        synchronized (this) {
            this.f11459a |= 2048;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean n(RunLayoutRunFaceDetectBinding LayoutFaceDetect, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11459a |= 16;
        }
        return true;
    }

    public final boolean o(RunLayoutRunFaceMachineBinding LayoutFaceMachine, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11459a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return o((RunLayoutRunFaceMachineBinding) object, fieldId);
            case 1:
                return s((RunLayoutRunRecordStatusBinding) object, fieldId);
            case 2:
                return w((MutableLiveData) object, fieldId);
            case 3:
                return q((RunLayoutPaceListBinding) object, fieldId);
            case 4:
                return n((RunLayoutRunFaceDetectBinding) object, fieldId);
            case 5:
                return u((RunLayoutRunVisionBinding) object, fieldId);
            case 6:
                return t((RunLayoutStepListBinding) object, fieldId);
            case 7:
                return x((MutableLiveData) object, fieldId);
            case 8:
                return v((MutableLiveData) object, fieldId);
            case 9:
                return p((RunLayoutMetricsBinding) object, fieldId);
            case 10:
                return r((RunLayoutStaticsBinding) object, fieldId);
            default:
                return false;
        }
    }

    public final boolean p(RunLayoutMetricsBinding LayoutMetrics, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11459a |= 512;
        }
        return true;
    }

    public final boolean q(RunLayoutPaceListBinding LayoutPace, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11459a |= 8;
        }
        return true;
    }

    public final boolean r(RunLayoutStaticsBinding LayoutStatics, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11459a |= 1024;
        }
        return true;
    }

    public final boolean s(RunLayoutRunRecordStatusBinding LayoutStatusLog, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11459a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((RunActivityDetailBinding) this).f11452a.setLifecycleOwner(lifecycleOwner);
        ((RunActivityDetailBinding) this).f11450a.setLifecycleOwner(lifecycleOwner);
        ((RunActivityDetailBinding) this).f11446a.setLifecycleOwner(lifecycleOwner);
        ((RunActivityDetailBinding) this).f11447a.setLifecycleOwner(lifecycleOwner);
        ((RunActivityDetailBinding) this).f11453a.setLifecycleOwner(lifecycleOwner);
        ((RunActivityDetailBinding) this).f11451a.setLifecycleOwner(lifecycleOwner);
        ((RunActivityDetailBinding) this).f11448a.setLifecycleOwner(lifecycleOwner);
        ((RunActivityDetailBinding) this).f11449a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 == variableId) {
            m((RunDetailVM) variable);
        } else {
            if (lk0.k != variableId) {
                return false;
            }
            l((RunDetailActivity.a) variable);
        }
        return true;
    }

    public final boolean t(RunLayoutStepListBinding LayoutStep, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11459a |= 64;
        }
        return true;
    }

    public final boolean u(RunLayoutRunVisionBinding LayoutVision, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11459a |= 32;
        }
        return true;
    }

    public final boolean v(MutableLiveData<RunDetailEntity> VmDetailLiveData, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11459a |= 256;
        }
        return true;
    }

    public final boolean w(MutableLiveData<Float> VmMapHeightPx, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11459a |= 4;
        }
        return true;
    }

    public final boolean x(MutableLiveData<Integer> VmUiLiveDataStatusBarHeight, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11459a |= 128;
        }
        return true;
    }

    public RunActivityDetailBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 11, (FrameLayout) bindings[2], (ImageView) bindings[4], (ImageView) bindings[5], (RunLayoutRunFaceDetectBinding) bindings[14], (RunLayoutRunFaceMachineBinding) bindings[15], (RunLayoutMetricsBinding) bindings[10], (RunLayoutPaceListBinding) bindings[11], (RunLayoutStaticsBinding) bindings[8], (RunLayoutRunRecordStatusBinding) bindings[9], (RunLayoutStepListBinding) bindings[12], (RunLayoutRunVisionBinding) bindings[13], (LinearLayout) bindings[1], (LinearLayout) bindings[17], (NestedScrollView) bindings[16], (FrameLayout) bindings[3]);
        this.f11459a = -1L;
        ((RunActivityDetailBinding) this).f35454a.setTag(null);
        ((RunActivityDetailBinding) this).f11443a.setTag(null);
        ((RunActivityDetailBinding) this).f11456b.setTag(null);
        setContainedBinding(((RunActivityDetailBinding) this).f11448a);
        setContainedBinding(((RunActivityDetailBinding) this).f11449a);
        setContainedBinding(((RunActivityDetailBinding) this).f11446a);
        setContainedBinding(((RunActivityDetailBinding) this).f11447a);
        setContainedBinding(((RunActivityDetailBinding) this).f11452a);
        setContainedBinding(((RunActivityDetailBinding) this).f11450a);
        setContainedBinding(((RunActivityDetailBinding) this).f11453a);
        setContainedBinding(((RunActivityDetailBinding) this).f11451a);
        ((RunActivityDetailBinding) this).f11444a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.c = frameLayout;
        frameLayout.setTag(null);
        ShadowLayout shadowLayout = (ShadowLayout) bindings[6];
        this.f11460a = shadowLayout;
        shadowLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[7];
        this.f11464a = bLTextView;
        bLTextView.setTag(null);
        ((RunActivityDetailBinding) this).b.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
