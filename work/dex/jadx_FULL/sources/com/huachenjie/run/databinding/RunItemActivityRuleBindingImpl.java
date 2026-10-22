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
import com.huachenjie.common.bean.ActivityRunRule;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunItemActivityRuleBindingImpl extends RunItemActivityRuleBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35606a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11910a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11911a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11912a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f11913a;

    @NonNull
    public final TextView b;

    public RunItemActivityRuleBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, f11910a, f35606a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String content;
        String title;
        synchronized (this) {
            j = this.f11911a;
            this.f11911a = 0L;
        }
        ActivityRunRule activityRunRule = ((RunItemActivityRuleBinding) this).f35605a;
        long j2 = j & 3;
        if (j2 == 0 || activityRunRule == null) {
            content = null;
            title = null;
        } else {
            content = activityRunRule.getContent();
            title = activityRunRule.getTitle();
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f11912a, title);
            TextViewBindingAdapter.setText(this.b, content);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11911a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11911a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunItemActivityRuleBinding
    public void k(@Nullable ActivityRunRule MState) {
        ((RunItemActivityRuleBinding) this).f35605a = MState;
        synchronized (this) {
            this.f11911a |= 1;
        }
        notifyPropertyChanged(lk0.L);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.L != variableId) {
            return false;
        }
        k((ActivityRunRule) variable);
        return true;
    }

    public RunItemActivityRuleBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0);
        this.f11911a = -1L;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) bindings[0];
        this.f11913a = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.f11912a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[2];
        this.b = textView2;
        textView2.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
