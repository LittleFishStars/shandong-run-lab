package com.huachenjie.run.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.common.widget.CheckTextView;
import com.huachenjie.run.R;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.noober.background.view.BLConstraintLayout;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunItemGeofenceListV2BindingImpl extends RunItemGeofenceListV2Binding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35617a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11937a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11938a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f11939a;

    public RunItemGeofenceListV2BindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 8, f11937a, f35617a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zIsOpenStatus;
        String string;
        String fenceName;
        boolean zEquals;
        boolean z;
        boolean z2;
        String str;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f11938a;
            this.f11938a = 0L;
        }
        GeoFenceDetail geoFenceDetail = ((RunItemGeofenceListV2Binding) this).f11933a;
        Integer num = ((RunItemGeofenceListV2Binding) this).f11936a;
        String str2 = this.f;
        Boolean bool = ((RunItemGeofenceListV2Binding) this).f11935a;
        long j4 = j & 17;
        boolean z3 = false;
        if (j4 != 0) {
            if (geoFenceDetail != null) {
                fenceName = geoFenceDetail.getFenceName();
                zIsOpenStatus = geoFenceDetail.isOpenStatus();
            } else {
                zIsOpenStatus = false;
                fenceName = null;
            }
            if (j4 != 0) {
                j |= zIsOpenStatus ? 256L : 128L;
            }
            string = this.d.getResources().getString(zIsOpenStatus ? R.string.geofence_open : R.string.geofence_close);
        } else {
            zIsOpenStatus = false;
            string = null;
            fenceName = null;
        }
        String strValueOf = (j & 18) != 0 ? String.valueOf(ViewDataBinding.safeUnbox(num)) : null;
        long j5 = j & 28;
        if (j5 != 0) {
            zEquals = Boolean.TRUE.equals(bool);
            if (j5 != 0) {
                if (zEquals) {
                    j2 = j | 64;
                    j3 = 1024;
                } else {
                    j2 = j | 32;
                    j3 = 512;
                }
                j = j2 | j3;
            }
            z = !zEquals;
            if ((j & 28) != 0) {
                j |= z ? 4096L : 2048L;
            }
        } else {
            zEquals = false;
            z = false;
        }
        boolean z4 = ((j & 4640) == 0 || (j & 4608) == 0) ? false : !TextUtils.isEmpty(str2);
        long j6 = j & 28;
        if (j6 != 0) {
            String str3 = zEquals ? "你在此围栏" : str2;
            boolean z5 = zEquals ? true : z4;
            z2 = z ? z4 : false;
            str = str3;
            z3 = z5;
        } else {
            z2 = false;
            str = null;
        }
        if ((j & 24) != 0) {
            CommonBindingAdapter.l0(((RunItemGeofenceListV2Binding) this).f35616a, zEquals);
            CommonBindingAdapter.l0(((RunItemGeofenceListV2Binding) this).f11934a, zEquals);
        }
        if (j6 != 0) {
            CommonBindingAdapter.l0(((RunItemGeofenceListV2Binding) this).f11931a, z3);
            TextViewBindingAdapter.setText(((RunItemGeofenceListV2Binding) this).f11934a, str);
            CommonBindingAdapter.l0(((RunItemGeofenceListV2Binding) this).f11932a, z2);
        }
        if ((j & 17) != 0) {
            ((RunItemGeofenceListV2Binding) this).f11934a.setChecked(zIsOpenStatus);
            this.b.setChecked(zIsOpenStatus);
            TextViewBindingAdapter.setText(this.c, fenceName);
            this.c.setChecked(zIsOpenStatus);
            TextViewBindingAdapter.setText(this.d, string);
            this.d.setChecked(zIsOpenStatus);
        }
        if ((16 & j) != 0) {
            CheckTextView checkTextView = ((RunItemGeofenceListV2Binding) this).f11934a;
            int i = R.color.color_979A9A;
            DrawablesBindingAdapter.g(checkTextView, Integer.valueOf(ViewDataBinding.getColorFromResource(checkTextView, i)), Integer.valueOf(RunIndexRecordAdapter.P), null, null, null, null, null);
            CheckTextView checkTextView2 = this.b;
            int i2 = R.color.color_CCCCCC;
            DrawablesBindingAdapter.h(checkTextView2, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(checkTextView2, i2)), 0, 0.0f, 0.0f, 0.0f, 10.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, -16002049, 0, 0.0f, 0.0f, 0.0f, 10.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            CheckTextView checkTextView3 = this.b;
            int i3 = R.color.white;
            DrawablesBindingAdapter.g(checkTextView3, Integer.valueOf(ViewDataBinding.getColorFromResource(checkTextView3, i3)), Integer.valueOf(ViewDataBinding.getColorFromResource(this.b, i3)), null, null, null, null, null);
            CheckTextView checkTextView4 = this.c;
            DrawablesBindingAdapter.g(checkTextView4, Integer.valueOf(ViewDataBinding.getColorFromResource(checkTextView4, i)), Integer.valueOf(ViewDataBinding.getColorFromResource(this.c, R.color.color_191F20)), null, null, null, null, null);
            CheckTextView checkTextView5 = this.d;
            DrawablesBindingAdapter.h(checkTextView5, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(checkTextView5, i2)), 0, 0.0f, 0.0f, 0.0f, 10.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, -12858007, 0, 0.0f, 0.0f, 0.0f, 10.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            CheckTextView checkTextView6 = this.d;
            DrawablesBindingAdapter.g(checkTextView6, Integer.valueOf(ViewDataBinding.getColorFromResource(checkTextView6, i3)), Integer.valueOf(ViewDataBinding.getColorFromResource(this.d, i3)), null, null, null, null, null);
        }
        if ((20 & j) != 0) {
            TextViewBindingAdapter.setText(((RunItemGeofenceListV2Binding) this).f11932a, str2);
        }
        if ((j & 18) != 0) {
            TextViewBindingAdapter.setText(this.b, strValueOf);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11938a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11938a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunItemGeofenceListV2Binding
    public void o(@Nullable Boolean Contains) {
        ((RunItemGeofenceListV2Binding) this).f11935a = Contains;
        synchronized (this) {
            this.f11938a |= 8;
        }
        notifyPropertyChanged(lk0.m);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // com.huachenjie.run.databinding.RunItemGeofenceListV2Binding
    public void p(@Nullable GeoFenceDetail Data) {
        ((RunItemGeofenceListV2Binding) this).f11933a = Data;
        synchronized (this) {
            this.f11938a |= 1;
        }
        notifyPropertyChanged(lk0.o);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunItemGeofenceListV2Binding
    public void q(@Nullable String Distance) {
        this.f = Distance;
        synchronized (this) {
            this.f11938a |= 4;
        }
        notifyPropertyChanged(lk0.q);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunItemGeofenceListV2Binding
    public void r(@Nullable Integer Index) {
        ((RunItemGeofenceListV2Binding) this).f11936a = Index;
        synchronized (this) {
            this.f11938a |= 2;
        }
        notifyPropertyChanged(lk0.w);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.o == variableId) {
            p((GeoFenceDetail) variable);
        } else if (lk0.w == variableId) {
            r((Integer) variable);
        } else if (lk0.q == variableId) {
            q((String) variable);
        } else {
            if (lk0.m != variableId) {
                return false;
            }
            o((Boolean) variable);
        }
        return true;
    }

    public RunItemGeofenceListV2BindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[5], (LinearLayout) bindings[4], (CheckTextView) bindings[6], (TextView) bindings[7], (CheckTextView) bindings[1], (CheckTextView) bindings[2], (CheckTextView) bindings[3]);
        this.f11938a = -1L;
        ((RunItemGeofenceListV2Binding) this).f35616a.setTag(null);
        ((RunItemGeofenceListV2Binding) this).f11931a.setTag(null);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) bindings[0];
        this.f11939a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        ((RunItemGeofenceListV2Binding) this).f11934a.setTag(null);
        ((RunItemGeofenceListV2Binding) this).f11932a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
