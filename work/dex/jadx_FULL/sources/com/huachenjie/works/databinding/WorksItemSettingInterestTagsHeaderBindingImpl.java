package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.works.bean.InterestTag;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemSettingInterestTagsHeaderBindingImpl extends WorksItemSettingInterestTagsHeaderBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37074a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14692a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14693a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14694a;

    public WorksItemSettingInterestTagsHeaderBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 1, f14692a, f37074a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f14693a;
            this.f14693a = 0L;
        }
        InterestTag interestTag = ((WorksItemSettingInterestTagsHeaderBinding) this).f37073a;
        long j2 = j & 3;
        String tagName = (j2 == 0 || interestTag == null) ? null : interestTag.getTagName();
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f14694a, tagName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14693a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14693a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemSettingInterestTagsHeaderBinding
    public void k(@Nullable InterestTag Bean) {
        ((WorksItemSettingInterestTagsHeaderBinding) this).f37073a = Bean;
        synchronized (this) {
            this.f14693a |= 1;
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

    public WorksItemSettingInterestTagsHeaderBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0);
        this.f14693a = -1L;
        TextView textView = (TextView) bindings[0];
        this.f14694a = textView;
        textView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
