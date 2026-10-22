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
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.bean.RunDetailFaceClockBean;
import com.noober.background.view.BLTextView;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunItemDetailFaceMachineBindingImpl extends RunItemDetailFaceMachineBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35613a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11927a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11928a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11929a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11930a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public RunItemDetailFaceMachineBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 5, f11927a, f35613a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zIsWarn;
        String pointName;
        String timeDisplay;
        int timeColor;
        int nameColor;
        int dotBg;
        synchronized (this) {
            j = this.f11928a;
            this.f11928a = 0L;
        }
        RunDetailFaceClockBean runDetailFaceClockBean = ((RunItemDetailFaceMachineBinding) this).f35612a;
        int i = this.K;
        long j2 = 5 & j;
        if (j2 == 0 || runDetailFaceClockBean == null) {
            zIsWarn = false;
            pointName = null;
            timeDisplay = null;
            timeColor = 0;
            nameColor = 0;
            dotBg = 0;
        } else {
            timeDisplay = runDetailFaceClockBean.getTimeDisplay();
            zIsWarn = runDetailFaceClockBean.isWarn();
            timeColor = runDetailFaceClockBean.getTimeColor();
            nameColor = runDetailFaceClockBean.getNameColor();
            dotBg = runDetailFaceClockBean.getDotBg();
            pointName = runDetailFaceClockBean.getPointName();
        }
        long j3 = j & 6;
        String strValueOf = j3 != 0 ? String.valueOf(i) : null;
        if (j3 != 0) {
            TextViewBindingAdapter.setText(this.f11930a, strValueOf);
        }
        if (j2 != 0) {
            CommonBindingAdapter.x(this.f11930a, dotBg);
            TextViewBindingAdapter.setText(this.b, pointName);
            this.b.setTextColor(nameColor);
            TextViewBindingAdapter.setText(this.c, timeDisplay);
            this.c.setTextColor(timeColor);
            CommonBindingAdapter.l0(((RunItemDetailFaceMachineBinding) this).f11926a, zIsWarn);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11928a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11928a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunItemDetailFaceMachineBinding
    public void l(@Nullable RunDetailFaceClockBean Bean) {
        ((RunItemDetailFaceMachineBinding) this).f35612a = Bean;
        synchronized (this) {
            this.f11928a |= 1;
        }
        notifyPropertyChanged(lk0.g);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunItemDetailFaceMachineBinding
    public void m(int Index) {
        this.K = Index;
        synchronized (this) {
            this.f11928a |= 2;
        }
        notifyPropertyChanged(lk0.w);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.g == variableId) {
            l((RunDetailFaceClockBean) variable);
        } else {
            if (lk0.w != variableId) {
                return false;
            }
            m(((Integer) variable).intValue());
        }
        return true;
    }

    public RunItemDetailFaceMachineBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (BLTextView) bindings[4]);
        this.f11928a = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f11929a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.f11930a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[2];
        this.b = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) bindings[3];
        this.c = textView3;
        textView3.setTag(null);
        ((RunItemDetailFaceMachineBinding) this).f11926a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
