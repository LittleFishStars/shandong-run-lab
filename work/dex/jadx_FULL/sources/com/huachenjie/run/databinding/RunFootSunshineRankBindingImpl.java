package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MediatorLiveData;
import com.huachenjie.run.page.rankinglist.SunshineRankingVM;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunFootSunshineRankBindingImpl extends RunFootSunshineRankBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35566a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11798a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11799a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11800a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f11801a;

    public RunFootSunshineRankBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 2, f11798a, f35566a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f11799a;
            this.f11799a = 0L;
        }
        SunshineRankingVM sunshineRankingVM = ((RunFootSunshineRankBinding) this).f35565a;
        long j2 = j & 7;
        String value = null;
        if (j2 != 0) {
            MediatorLiveData<String> mediatorLiveDataE = sunshineRankingVM != null ? sunshineRankingVM.E() : null;
            updateLiveDataRegistration(0, mediatorLiveDataE);
            if (mediatorLiveDataE != null) {
                value = mediatorLiveDataE.getValue();
            }
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f11800a, value);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11799a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11799a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunFootSunshineRankBinding
    public void k(@Nullable SunshineRankingVM Vm) {
        ((RunFootSunshineRankBinding) this).f35565a = Vm;
        synchronized (this) {
            this.f11799a |= 2;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean l(MediatorLiveData<String> VmUpdateTimeStr, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11799a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return l((MediatorLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 != variableId) {
            return false;
        }
        k((SunshineRankingVM) variable);
        return true;
    }

    public RunFootSunshineRankBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1);
        this.f11799a = -1L;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) bindings[0];
        this.f11801a = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.f11800a = textView;
        textView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
