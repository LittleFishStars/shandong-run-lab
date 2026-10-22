package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.bean.RunDetailEntity;
import com.huachenjie.run.page.run_detail.RunDetailVM;
import com.zj.adlib.lk0;
import com.zj.adlib.s72;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunLayoutMetricsContentBindingImpl extends RunLayoutMetricsContentBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35677a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12098a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12099a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12100a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12101a;

    @NonNull
    public final LinearLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f12102b;

    @NonNull
    public final LinearLayout c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f12103c;

    @NonNull
    public final TextView d;

    public RunLayoutMetricsContentBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 7, f12098a, f35677a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        long duration;
        boolean z;
        String str;
        String strValueOf;
        String strE;
        int pace;
        int frequency;
        synchronized (this) {
            j = this.f12099a;
            duration = 0;
            this.f12099a = 0L;
        }
        RunDetailVM runDetailVM = ((RunLayoutMetricsContentBinding) this).f35676a;
        long j2 = j & 7;
        boolean zIsValid = false;
        String calorie = null;
        if (j2 != 0) {
            MutableLiveData<RunDetailEntity> mutableLiveDataL = runDetailVM != null ? runDetailVM.l() : null;
            updateLiveDataRegistration(0, mutableLiveDataL);
            RunDetailEntity value = mutableLiveDataL != null ? mutableLiveDataL.getValue() : null;
            if (value != null) {
                zIsValid = value.isValid();
                calorie = value.formatCalorie();
                duration = value.getDuration();
                frequency = value.getFrequency();
                pace = value.getPace();
            } else {
                pace = 0;
                frequency = 0;
            }
            z = !zIsValid;
            String strN = s72.n(duration);
            strValueOf = String.valueOf(frequency);
            strE = s72.e(pace);
            String str2 = calorie;
            calorie = strN;
            str = str2;
        } else {
            z = false;
            str = null;
            strValueOf = null;
            strE = null;
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f12101a, calorie);
            TextViewBindingAdapter.setText(this.f12102b, strE);
            CommonBindingAdapter.l0(this.b, zIsValid);
            TextViewBindingAdapter.setText(this.f12103c, str);
            CommonBindingAdapter.l0(this.c, z);
            TextViewBindingAdapter.setText(this.d, strValueOf);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12099a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12099a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunLayoutMetricsContentBinding
    public void k(@Nullable RunDetailVM Vm) {
        ((RunLayoutMetricsContentBinding) this).f35676a = Vm;
        synchronized (this) {
            this.f12099a |= 2;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<RunDetailEntity> VmDetailLiveData, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12099a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return l((MutableLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 != variableId) {
            return false;
        }
        k((RunDetailVM) variable);
        return true;
    }

    public RunLayoutMetricsContentBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1);
        this.f12099a = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f12100a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.f12101a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[2];
        this.f12102b = textView2;
        textView2.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) bindings[3];
        this.b = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView3 = (TextView) bindings[4];
        this.f12103c = textView3;
        textView3.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) bindings[5];
        this.c = linearLayout3;
        linearLayout3.setTag(null);
        TextView textView4 = (TextView) bindings[6];
        this.d = textView4;
        textView4.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
