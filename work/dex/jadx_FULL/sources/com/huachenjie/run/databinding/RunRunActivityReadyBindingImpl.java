package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.run.page.activities_run.ReadyActivity;
import com.huachenjie.run.page.activities_run.ReadyVM;
import com.huachenjie.run.widget.DisplayOnlyDanMuView;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunRunActivityReadyBindingImpl extends RunRunActivityReadyBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35736a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12278a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12279a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f12280a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f12281a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f12282a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f12283a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f12284a;

    @NonNull
    public final BLTextView b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ReadyActivity.ClickProxy f35737a;

        public a a(ReadyActivity.ClickProxy value) {
            this.f35737a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35737a.a(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ReadyActivity.ClickProxy f35738a;

        public b a(ReadyActivity.ClickProxy value) {
            this.f35738a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35738a.b(arg0);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ReadyActivity.ClickProxy f35739a;

        public c a(ReadyActivity.ClickProxy value) {
            this.f35739a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35739a.c(arg0);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ReadyActivity.ClickProxy f35740a;

        public d a(ReadyActivity.ClickProxy value) {
            this.f35740a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35740a.d(arg0);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(17);
        f12278a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{9}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35736a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.run.R.id.fl_map_container, 10);
        sparseIntArray.put(com.huachenjie.run.R.id.v_top_gradient, 11);
        sparseIntArray.put(com.huachenjie.run.R.id.ll_stats_card, 12);
        sparseIntArray.put(com.huachenjie.run.R.id.dan_mu_view, 13);
        sparseIntArray.put(com.huachenjie.run.R.id.fl_fd, 14);
        sparseIntArray.put(com.huachenjie.run.R.id.v_bottom_gradient, 15);
        sparseIntArray.put(com.huachenjie.run.R.id.ll_goal_card, 16);
    }

    public RunRunActivityReadyBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 17, f12278a, f35736a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003c  */
    /* JADX WARN: Code duplicated, block: B:25:0x005a  */
    /* JADX WARN: Code duplicated, block: B:44:0x008e A[PHI: r2
      0x008e: PHI (r2v3 long) = (r2v0 long), (r2v5 long) binds: [B:27:0x005f, B:41:0x0088] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:53:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:82:0x010e  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        String value2;
        String value3;
        int i;
        boolean z;
        String str;
        BindingTitleBean value4;
        b bVarA;
        c cVarA;
        d dVarA;
        a aVarA;
        String value5;
        long j2;
        boolean zSafeUnbox;
        synchronized (this) {
            j = this.f12279a;
            this.f12279a = 0L;
        }
        ReadyVM readyVM = ((RunRunActivityReadyBinding) this).f12270a;
        ReadyActivity.ClickProxy clickProxy = ((RunRunActivityReadyBinding) this).f12269a;
        if ((1471 & j) != 0) {
            if ((j & 1281) == 0) {
                value2 = null;
            } else {
                MutableLiveData<String> mutableLiveDataT = readyVM != null ? readyVM.t() : null;
                updateLiveDataRegistration(0, mutableLiveDataT);
                if (mutableLiveDataT != null) {
                    value2 = mutableLiveDataT.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 1282) == 0) {
                value3 = null;
            } else {
                MutableLiveData<String> mutableLiveDataY = readyVM != null ? readyVM.y() : null;
                updateLiveDataRegistration(1, mutableLiveDataY);
                if (mutableLiveDataY != null) {
                    value3 = mutableLiveDataY.getValue();
                } else {
                    value3 = null;
                }
            }
            long j3 = j & 1284;
            if (j3 == 0) {
                i = 0;
            } else {
                MutableLiveData<Boolean> mutableLiveDataA = readyVM != null ? readyVM.A() : null;
                updateLiveDataRegistration(2, mutableLiveDataA);
                boolean zSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataA != null ? mutableLiveDataA.getValue() : null);
                if (j3 != 0) {
                    j |= zSafeUnbox2 ? 4096L : 2048L;
                }
                if (zSafeUnbox2) {
                    i = 0;
                } else {
                    i = 8;
                }
            }
            if ((j & 1288) == 0) {
                value4 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataD = readyVM != null ? readyVM.D() : null;
                updateLiveDataRegistration(3, mutableLiveDataD);
                if (mutableLiveDataD != null) {
                    value4 = mutableLiveDataD.getValue();
                } else {
                    value4 = null;
                }
            }
            if ((j & 1296) == 0) {
                value5 = null;
            } else {
                MutableLiveData<String> mutableLiveDataE = readyVM != null ? readyVM.E() : null;
                updateLiveDataRegistration(4, mutableLiveDataE);
                if (mutableLiveDataE != null) {
                    value5 = mutableLiveDataE.getValue();
                } else {
                    value5 = null;
                }
            }
            if ((j & 1312) != 0) {
                MediatorLiveData<Boolean> mediatorLiveDataB = readyVM != null ? readyVM.B() : null;
                updateLiveDataRegistration(5, mediatorLiveDataB);
                zSafeUnbox = ViewDataBinding.safeUnbox(mediatorLiveDataB != null ? mediatorLiveDataB.getValue() : null);
                j2 = 1408;
            } else {
                j2 = 1408;
                zSafeUnbox = false;
            }
            if ((j & j2) == 0) {
                str = value5;
                z = zSafeUnbox;
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataU = readyVM != null ? readyVM.u() : null;
                updateLiveDataRegistration(7, mutableLiveDataU);
                if (mutableLiveDataU != null) {
                    value = mutableLiveDataU.getValue();
                    str = value5;
                    z = zSafeUnbox;
                } else {
                    str = value5;
                    z = zSafeUnbox;
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
            value3 = null;
            i = 0;
            z = false;
            str = null;
            value4 = null;
        }
        long j4 = j & 1536;
        if (j4 == 0 || clickProxy == null) {
            bVarA = null;
            cVarA = null;
            dVarA = null;
            aVarA = null;
        } else {
            d dVar = this.f12284a;
            if (dVar == null) {
                dVar = new d();
                this.f12284a = dVar;
            }
            dVarA = dVar.a(clickProxy);
            a aVar = this.f12281a;
            if (aVar == null) {
                aVar = new a();
                this.f12281a = aVar;
            }
            aVarA = aVar.a(clickProxy);
            b bVar = this.f12282a;
            if (bVar == null) {
                bVar = new b();
                this.f12282a = bVar;
            }
            bVarA = bVar.a(clickProxy);
            c cVar = this.f12283a;
            if (cVar == null) {
                cVar = new c();
                this.f12283a = cVar;
            }
            cVarA = cVar.a(clickProxy);
        }
        if ((j & 1288) != 0) {
            ((RunRunActivityReadyBinding) this).f12268a.k(value4);
        }
        if (j4 != 0) {
            CommonBindingAdapter.q(((RunRunActivityReadyBinding) this).f12266a, cVarA, null);
            CommonBindingAdapter.q(this.b, bVarA, null);
            CommonBindingAdapter.q(((RunRunActivityReadyBinding) this).f12275b, aVarA, null);
            CommonBindingAdapter.q(this.d, dVarA, null);
        }
        if ((j & 1281) != 0) {
            TextViewBindingAdapter.setText(((RunRunActivityReadyBinding) this).f12273a, value2);
        }
        if ((1284 & j) != 0) {
            ((RunRunActivityReadyBinding) this).f12273a.setVisibility(i);
        }
        if ((1408 & j) != 0) {
            TextViewBindingAdapter.setText(((RunRunActivityReadyBinding) this).f12267a, value);
        }
        if ((1312 & j) != 0) {
            CommonBindingAdapter.l0(((RunRunActivityReadyBinding) this).f12275b, z);
        }
        if ((j & 1282) != 0) {
            TextViewBindingAdapter.setText(this.c, value3);
        }
        if ((j & 1296) != 0) {
            TextViewBindingAdapter.setText(this.e, str);
        }
        ViewDataBinding.executeBindingsOn(((RunRunActivityReadyBinding) this).f12268a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f12279a != 0) {
                return true;
            }
            return ((RunRunActivityReadyBinding) this).f12268a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12279a = 1024L;
        }
        ((RunRunActivityReadyBinding) this).f12268a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunRunActivityReadyBinding
    public void l(@Nullable ReadyActivity.ClickProxy Click) {
        ((RunRunActivityReadyBinding) this).f12269a = Click;
        synchronized (this) {
            this.f12279a |= 512;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunRunActivityReadyBinding
    public void m(@Nullable ReadyVM Vm) {
        ((RunRunActivityReadyBinding) this).f12270a = Vm;
        synchronized (this) {
            this.f12279a |= 256;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean n(LayoutToolbarBindingBinding ClTitle, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12279a |= 64;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> VmGoalTipText, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12279a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return o((MutableLiveData) object, fieldId);
            case 1:
                return q((MutableLiveData) object, fieldId);
            case 2:
                return r((MutableLiveData) object, fieldId);
            case 3:
                return t((MutableLiveData) object, fieldId);
            case 4:
                return u((MutableLiveData) object, fieldId);
            case 5:
                return s((MediatorLiveData) object, fieldId);
            case 6:
                return n((LayoutToolbarBindingBinding) object, fieldId);
            case 7:
                return p((MutableLiveData) object, fieldId);
            default:
                return false;
        }
    }

    public final boolean p(MutableLiveData<String> VmGoalValueText, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12279a |= 128;
        }
        return true;
    }

    public final boolean q(MutableLiveData<String> VmRunningCountText, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12279a |= 2;
        }
        return true;
    }

    public final boolean r(MutableLiveData<Boolean> VmShowGoalTip, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12279a |= 4;
        }
        return true;
    }

    public final boolean s(MediatorLiveData<Boolean> VmShowNfcCheckIn, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12279a |= 32;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((RunRunActivityReadyBinding) this).f12268a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 == variableId) {
            m((ReadyVM) variable);
        } else {
            if (lk0.k != variableId) {
                return false;
            }
            l((ReadyActivity.ClickProxy) variable);
        }
        return true;
    }

    public final boolean t(MutableLiveData<BindingTitleBean> VmTitleBean, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12279a |= 8;
        }
        return true;
    }

    public final boolean u(MutableLiveData<String> VmTotalDistanceText, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12279a |= 16;
        }
        return true;
    }

    public RunRunActivityReadyBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 8, (LayoutToolbarBindingBinding) bindings[9], (DisplayOnlyDanMuView) bindings[13], (FrameLayout) bindings[14], (FrameLayout) bindings[10], (ImageView) bindings[8], (BLLinearLayout) bindings[16], (BLLinearLayout) bindings[12], (BLTextView) bindings[5], (TextView) bindings[3], (TextView) bindings[7], (TextView) bindings[1], (TextView) bindings[6], (TextView) bindings[2], (BLView) bindings[15], (BLView) bindings[11]);
        this.f12279a = -1L;
        setContainedBinding(((RunRunActivityReadyBinding) this).f12268a);
        ((RunRunActivityReadyBinding) this).f12266a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f12280a = constraintLayout;
        constraintLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[4];
        this.b = bLTextView;
        bLTextView.setTag(null);
        ((RunRunActivityReadyBinding) this).f12273a.setTag(null);
        ((RunRunActivityReadyBinding) this).f12267a.setTag(null);
        ((RunRunActivityReadyBinding) this).f12275b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
