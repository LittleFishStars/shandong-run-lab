package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.works.bean.InterestTag;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemSettingInterestTagsBindingImpl extends WorksItemSettingInterestTagsBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37072a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14689a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14690a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AppCompatCheckedTextView f14691a;

    public WorksItemSettingInterestTagsBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 1, f14689a, f37072a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean selected;
        String tagName;
        synchronized (this) {
            j = this.f14690a;
            this.f14690a = 0L;
        }
        InterestTag interestTag = ((WorksItemSettingInterestTagsBinding) this).f37071a;
        long j2 = j & 3;
        if (j2 == 0 || interestTag == null) {
            selected = false;
            tagName = null;
        } else {
            selected = interestTag.getSelected();
            tagName = interestTag.getTagName();
        }
        if (j2 != 0) {
            this.f14691a.setChecked(selected);
            TextViewBindingAdapter.setText(this.f14691a, tagName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14690a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14690a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemSettingInterestTagsBinding
    public void k(@Nullable InterestTag Bean) {
        ((WorksItemSettingInterestTagsBinding) this).f37071a = Bean;
        synchronized (this) {
            this.f14690a |= 1;
        }
        notifyPropertyChanged(qk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.g != variableId) {
            return false;
        }
        k((InterestTag) variable);
        return true;
    }

    public WorksItemSettingInterestTagsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0);
        this.f14690a = -1L;
        AppCompatCheckedTextView appCompatCheckedTextView = (AppCompatCheckedTextView) bindings[0];
        this.f14691a = appCompatCheckedTextView;
        appCompatCheckedTextView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
