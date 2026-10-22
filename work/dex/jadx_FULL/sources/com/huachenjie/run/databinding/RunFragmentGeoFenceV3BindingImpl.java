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
import com.huachenjie.common.bean.ClockMode;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.common.widget.CheckTextView;
import com.huachenjie.common.widget.ShadowConstraintLayout;
import com.huachenjie.run.R;
import com.huachenjie.run.page.geofence.GeoFenceFragment;
import com.huachenjie.run.page.geofence.GeoFenceV2VM;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunFragmentGeoFenceV3BindingImpl extends RunFragmentGeoFenceV3Binding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35582a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11844a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11845a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f11846a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11847a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f11848a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f11849a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f11850a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GeoFenceFragment.a f35583a;

        public a a(GeoFenceFragment.a value) {
            this.f35583a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35583a.c(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GeoFenceFragment.a f35584a;

        public b a(GeoFenceFragment.a value) {
            this.f35584a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35584a.d(arg0);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GeoFenceFragment.a f35585a;

        public c a(GeoFenceFragment.a value) {
            this.f35585a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35585a.e(arg0);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GeoFenceFragment.a f35586a;

        public d a(GeoFenceFragment.a value) {
            this.f35586a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35586a.b(arg0);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(16);
        f11844a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"run_layout_run_guide_customer_service", "run_layout_run_guide_tip"}, new int[]{8, 9}, new int[]{R.layout.run_layout_run_guide_customer_service, R.layout.run_layout_run_guide_tip});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35582a = sparseIntArray;
        sparseIntArray.put(R.id.fl_map_container, 10);
        sparseIntArray.put(R.id.bottomContentLayout, 11);
        sparseIntArray.put(R.id.iv_run_type_title, 12);
        sparseIntArray.put(R.id.tv_run_type_title, 13);
        sparseIntArray.put(R.id.iv_open_time, 14);
        sparseIntArray.put(R.id.tv_open_time_title, 15);
    }

    public RunFragmentGeoFenceV3BindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 16, f11844a, f35582a));
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0064  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        boolean z;
        String fenceName;
        String str2;
        String value;
        String str3;
        boolean z2;
        b bVarA;
        c cVarA;
        d dVarA;
        a aVarA;
        boolean z3;
        String str4;
        boolean zIsOpenStatus;
        synchronized (this) {
            j = this.f11845a;
            this.f11845a = 0L;
        }
        GeoFenceV2VM geoFenceV2VM = ((RunFragmentGeoFenceV3Binding) this).f11840a;
        GeoFenceFragment.a aVar = ((RunFragmentGeoFenceV3Binding) this).f11839a;
        if ((171 & j) != 0) {
            if ((j & 161) != 0) {
                MediatorLiveData<ClockMode> mediatorLiveData = geoFenceV2VM != null ? geoFenceV2VM.clockMode : null;
                updateLiveDataRegistration(0, mediatorLiveData);
                ClockMode value2 = mediatorLiveData != null ? mediatorLiveData.getValue() : null;
                if (value2 != null) {
                    str3 = value2.content;
                    str4 = value2.title;
                } else {
                    str3 = null;
                    str4 = null;
                }
                z3 = value2 != ClockMode.NO_POINT;
            } else {
                z3 = false;
                str3 = null;
                str4 = null;
            }
            if ((j & 162) == 0) {
                value = null;
            } else {
                MediatorLiveData<String> mediatorLiveDataJ = geoFenceV2VM != null ? geoFenceV2VM.j() : null;
                updateLiveDataRegistration(1, mediatorLiveDataJ);
                if (mediatorLiveDataJ != null) {
                    value = mediatorLiveDataJ.getValue();
                } else {
                    value = null;
                }
            }
            long j2 = j & 168;
            if (j2 != 0) {
                MutableLiveData<GeoFenceDetail> mutableLiveData = geoFenceV2VM != null ? geoFenceV2VM.mGeoFenceDetail : null;
                updateLiveDataRegistration(3, mutableLiveData);
                GeoFenceDetail value3 = mutableLiveData != null ? mutableLiveData.getValue() : null;
                if (value3 != null) {
                    fenceName = value3.getFenceName();
                    zIsOpenStatus = value3.isOpenStatus();
                } else {
                    zIsOpenStatus = false;
                    fenceName = null;
                }
                if (j2 != 0) {
                    j |= zIsOpenStatus ? 512L : 256L;
                }
                str2 = zIsOpenStatus ? "开放中" : "未开放";
                boolean z4 = z3;
                z = zIsOpenStatus;
                str = str4;
                z2 = z4;
            } else {
                str = str4;
                fenceName = null;
                str2 = null;
                z2 = z3;
                z = false;
            }
        } else {
            str = null;
            z = false;
            fenceName = null;
            str2 = null;
            value = null;
            str3 = null;
            z2 = false;
        }
        long j3 = j & 192;
        if (j3 == 0 || aVar == null) {
            bVarA = null;
            cVarA = null;
            dVarA = null;
            aVarA = null;
        } else {
            d dVar = this.f11850a;
            if (dVar == null) {
                dVar = new d();
                this.f11850a = dVar;
            }
            dVarA = dVar.a(aVar);
            a aVar2 = this.f11847a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f11847a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            b bVar = this.f11848a;
            if (bVar == null) {
                bVar = new b();
                this.f11848a = bVar;
            }
            bVarA = bVar.a(aVar);
            c cVar = this.f11849a;
            if (cVar == null) {
                cVar = new c();
                this.f11849a = cVar;
            }
            cVarA = cVar.a(aVar);
        }
        if (j3 != 0) {
            ((RunFragmentGeoFenceV3Binding) this).f11837a.setOnClick(aVarA);
            CommonBindingAdapter.q(((RunFragmentGeoFenceV3Binding) this).f11841a, dVarA, null);
            CommonBindingAdapter.q(((RunFragmentGeoFenceV3Binding) this).f11834a, bVarA, null);
            CommonBindingAdapter.q(this.d, cVarA, null);
        }
        if ((161 & j) != 0) {
            CommonBindingAdapter.l0(((RunFragmentGeoFenceV3Binding) this).f11841a, z2);
            TextViewBindingAdapter.setText(this.e, str);
            TextViewBindingAdapter.setText(((RunFragmentGeoFenceV3Binding) this).f11842a, str3);
        }
        if ((168 & j) != 0) {
            TextViewBindingAdapter.setText(((RunFragmentGeoFenceV3Binding) this).f11843b, fenceName);
            TextViewBindingAdapter.setText(((RunFragmentGeoFenceV3Binding) this).f11835a, str2);
            ((RunFragmentGeoFenceV3Binding) this).f11835a.setChecked(z);
        }
        if ((128 & j) != 0) {
            CheckTextView checkTextView = ((RunFragmentGeoFenceV3Binding) this).f11835a;
            int i = R.color.color_8997A4;
            DrawablesBindingAdapter.h(checkTextView, 0, null, ViewDataBinding.getColorFromResource(checkTextView, i), 1.0f, 0.0f, 0.0f, 10.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, -12858007, 0, 0.0f, 0.0f, 0.0f, 10.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            CheckTextView checkTextView2 = ((RunFragmentGeoFenceV3Binding) this).f11835a;
            DrawablesBindingAdapter.g(checkTextView2, Integer.valueOf(ViewDataBinding.getColorFromResource(checkTextView2, i)), Integer.valueOf(ViewDataBinding.getColorFromResource(((RunFragmentGeoFenceV3Binding) this).f11835a, R.color.white)), null, null, null, null, null);
        }
        if ((j & 162) != 0) {
            TextViewBindingAdapter.setText(this.d, value);
        }
        ViewDataBinding.executeBindingsOn(((RunFragmentGeoFenceV3Binding) this).f11837a);
        ViewDataBinding.executeBindingsOn(((RunFragmentGeoFenceV3Binding) this).f11838a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11845a != 0) {
                return true;
            }
            return ((RunFragmentGeoFenceV3Binding) this).f11837a.hasPendingBindings() || ((RunFragmentGeoFenceV3Binding) this).f11838a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11845a = 128L;
        }
        ((RunFragmentGeoFenceV3Binding) this).f11837a.invalidateAll();
        ((RunFragmentGeoFenceV3Binding) this).f11838a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunFragmentGeoFenceV3Binding
    public void l(@Nullable GeoFenceFragment.a Click) {
        ((RunFragmentGeoFenceV3Binding) this).f11839a = Click;
        synchronized (this) {
            this.f11845a |= 64;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunFragmentGeoFenceV3Binding
    public void m(@Nullable GeoFenceV2VM MState) {
        ((RunFragmentGeoFenceV3Binding) this).f11840a = MState;
        synchronized (this) {
            this.f11845a |= 32;
        }
        notifyPropertyChanged(lk0.L);
        super.requestRebind();
    }

    public final boolean n(RunLayoutRunGuideCustomerServiceBinding IncludeCs, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11845a |= 16;
        }
        return true;
    }

    public final boolean o(RunLayoutRunGuideTipBinding IncludeTip, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11845a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return p((MediatorLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return r((MediatorLiveData) object, fieldId);
        }
        if (localFieldId == 2) {
            return o((RunLayoutRunGuideTipBinding) object, fieldId);
        }
        if (localFieldId == 3) {
            return q((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 4) {
            return false;
        }
        return n((RunLayoutRunGuideCustomerServiceBinding) object, fieldId);
    }

    public final boolean p(MediatorLiveData<ClockMode> MStateClockMode, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11845a |= 1;
        }
        return true;
    }

    public final boolean q(MutableLiveData<GeoFenceDetail> MStateMGeoFenceDetail, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11845a |= 8;
        }
        return true;
    }

    public final boolean r(MediatorLiveData<String> MStateMGeoFenceOpenTimes, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11845a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((RunFragmentGeoFenceV3Binding) this).f11837a.setLifecycleOwner(lifecycleOwner);
        ((RunFragmentGeoFenceV3Binding) this).f11838a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.L == variableId) {
            m((GeoFenceV2VM) variable);
        } else {
            if (lk0.k != variableId) {
                return false;
            }
            l((GeoFenceFragment.a) variable);
        }
        return true;
    }

    public RunFragmentGeoFenceV3BindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5, (ShadowConstraintLayout) bindings[11], (FrameLayout) bindings[10], (RunLayoutRunGuideCustomerServiceBinding) bindings[8], (RunLayoutRunGuideTipBinding) bindings[9], (ImageView) bindings[14], (ImageView) bindings[12], (BLLinearLayout) bindings[5], (TextView) bindings[3], (TextView) bindings[1], (CheckTextView) bindings[2], (TextView) bindings[15], (TextView) bindings[7], (TextView) bindings[4], (BLTextView) bindings[6], (TextView) bindings[13]);
        this.f11845a = -1L;
        setContainedBinding(((RunFragmentGeoFenceV3Binding) this).f11837a);
        setContainedBinding(((RunFragmentGeoFenceV3Binding) this).f11838a);
        ((RunFragmentGeoFenceV3Binding) this).f11841a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f11846a = constraintLayout;
        constraintLayout.setTag(null);
        ((RunFragmentGeoFenceV3Binding) this).f11834a.setTag(null);
        ((RunFragmentGeoFenceV3Binding) this).f11843b.setTag(null);
        ((RunFragmentGeoFenceV3Binding) this).f11835a.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        ((RunFragmentGeoFenceV3Binding) this).f11842a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
