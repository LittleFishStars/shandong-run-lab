package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.run.page.activities_run.GPSDiagnosisVM;
import com.zj.adlib.lk0;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunActivityGpsDiagnosisBindingImpl extends RunActivityGpsDiagnosisBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35471a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11492a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11493a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f11494a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f11495a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(10);
        f11492a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{6}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35471a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.run.R.id.v_side_after, 7);
        sparseIntArray.put(com.huachenjie.run.R.id.v_side_front, 8);
        sparseIntArray.put(com.huachenjie.run.R.id.v_side, 9);
    }

    public RunActivityGpsDiagnosisBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 10, f11492a, f35471a));
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00b3  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        int i;
        int i2;
        int satellites;
        String str;
        String str2;
        BindingTitleBean value;
        String str3;
        long j2;
        long j3;
        float speed;
        int gpsStatus;
        float accuracy;
        synchronized (this) {
            j = this.f11493a;
            this.f11493a = 0L;
        }
        GPSDiagnosisVM gPSDiagnosisVM = ((RunActivityGpsDiagnosisBinding) this).f11490a;
        String str4 = null;
        if ((61 & j) != 0) {
            long j4 = j & 49;
            if (j4 != 0) {
                MutableLiveData<HCJAddressInfo> mutableLiveDataH = gPSDiagnosisVM != null ? gPSDiagnosisVM.h() : null;
                updateLiveDataRegistration(0, mutableLiveDataH);
                HCJAddressInfo value2 = mutableLiveDataH != null ? mutableLiveDataH.getValue() : null;
                if (value2 != null) {
                    satellites = value2.getSatellites();
                    speed = value2.getSpeed();
                    accuracy = value2.getAccuracy();
                    gpsStatus = value2.getGpsStatus();
                } else {
                    speed = 0.0f;
                    gpsStatus = 0;
                    satellites = 0;
                    accuracy = 0.0f;
                }
                str3 = String.format("当前手机可连接卫星数：%s", Integer.valueOf(satellites));
                str = String.format("陀螺仪速度：%sM/s", Float.valueOf(speed));
                str2 = String.format("定位精度：%sM", Float.valueOf(accuracy));
                z = gpsStatus == 1;
                if (j4 != 0) {
                    j = z ? j | 8192 : j | 4096;
                }
            } else {
                z = false;
                satellites = 0;
                str = null;
                str2 = null;
                str3 = null;
            }
            if ((j & 52) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataJ = gPSDiagnosisVM != null ? gPSDiagnosisVM.j() : null;
                updateLiveDataRegistration(2, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value = mutableLiveDataJ.getValue();
                } else {
                    value = null;
                }
            }
            long j5 = j & 56;
            if (j5 != 0) {
                MutableLiveData<Boolean> mutableLiveDataI = gPSDiagnosisVM != null ? gPSDiagnosisVM.i() : null;
                updateLiveDataRegistration(3, mutableLiveDataI);
                boolean zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataI != null ? mutableLiveDataI.getValue() : null);
                if (j5 != 0) {
                    if (zSafeUnbox) {
                        j2 = j | 128;
                        j3 = 2048;
                    } else {
                        j2 = j | 64;
                        j3 = 1024;
                    }
                    j = j2 | j3;
                }
                i = 8;
                i2 = zSafeUnbox ? 0 : 8;
                if (!zSafeUnbox) {
                    i = 0;
                }
            } else {
                i = 0;
                i2 = 0;
            }
        } else {
            z = false;
            i = 0;
            i2 = 0;
            satellites = 0;
            str = null;
            str2 = null;
            value = null;
            str3 = null;
        }
        boolean z2 = (8192 & j) != 0 && satellites > 0;
        long j6 = j & 49;
        if (j6 != 0) {
            if (!z) {
                z2 = false;
            }
            if (j6 != 0) {
                j |= z2 ? 512L : 256L;
            }
            str4 = String.format("连接方式：%s", z2 ? "卫星定位" : "网络定位");
        }
        String str5 = str4;
        if ((56 & j) != 0) {
            this.f11494a.setVisibility(i);
            ((RunActivityGpsDiagnosisBinding) this).f11488a.setVisibility(i2);
            ((RunActivityGpsDiagnosisBinding) this).f11491b.setVisibility(i2);
            this.c.setVisibility(i2);
            this.d.setVisibility(i2);
        }
        if ((52 & j) != 0) {
            ((RunActivityGpsDiagnosisBinding) this).f11489a.k(value);
        }
        if ((j & 49) != 0) {
            TextViewBindingAdapter.setText(((RunActivityGpsDiagnosisBinding) this).f11488a, str2);
            TextViewBindingAdapter.setText(((RunActivityGpsDiagnosisBinding) this).f11491b, str3);
            TextViewBindingAdapter.setText(this.c, str);
            TextViewBindingAdapter.setText(this.d, str5);
        }
        ViewDataBinding.executeBindingsOn(((RunActivityGpsDiagnosisBinding) this).f11489a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11493a != 0) {
                return true;
            }
            return ((RunActivityGpsDiagnosisBinding) this).f11489a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11493a = 32L;
        }
        ((RunActivityGpsDiagnosisBinding) this).f11489a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivityGpsDiagnosisBinding
    public void k(@Nullable GPSDiagnosisVM Vm) {
        ((RunActivityGpsDiagnosisBinding) this).f11490a = Vm;
        synchronized (this) {
            this.f11493a |= 16;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean l(LayoutToolbarBindingBinding Toolbar, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11493a |= 2;
        }
        return true;
    }

    public final boolean m(MutableLiveData<HCJAddressInfo> VmAddressInfo, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11493a |= 1;
        }
        return true;
    }

    public final boolean n(MutableLiveData<Boolean> VmHasLocation, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11493a |= 8;
        }
        return true;
    }

    public final boolean o(MutableLiveData<BindingTitleBean> VmTitleBean, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11493a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return m((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return l((LayoutToolbarBindingBinding) object, fieldId);
        }
        if (localFieldId == 2) {
            return o((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 3) {
            return false;
        }
        return n((MutableLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((RunActivityGpsDiagnosisBinding) this).f11489a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 != variableId) {
            return false;
        }
        k((GPSDiagnosisVM) variable);
        return true;
    }

    public RunActivityGpsDiagnosisBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4, (LayoutToolbarBindingBinding) bindings[6], (TextView) bindings[5], (TextView) bindings[2], (TextView) bindings[4], (TextView) bindings[3], (TextView) bindings[9], (View) bindings[7], (View) bindings[8]);
        this.f11493a = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.f11495a = relativeLayout;
        relativeLayout.setTag(null);
        FrameLayout frameLayout = (FrameLayout) bindings[1];
        this.f11494a = frameLayout;
        frameLayout.setTag(null);
        setContainedBinding(((RunActivityGpsDiagnosisBinding) this).f11489a);
        ((RunActivityGpsDiagnosisBinding) this).f11488a.setTag(null);
        ((RunActivityGpsDiagnosisBinding) this).f11491b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
