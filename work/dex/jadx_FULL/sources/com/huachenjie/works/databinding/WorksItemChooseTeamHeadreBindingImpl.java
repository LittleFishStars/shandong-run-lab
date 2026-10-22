package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.works.bean.ChatTeamHeaderBean;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemChooseTeamHeadreBindingImpl extends WorksItemChooseTeamHeadreBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37016a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14516a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14517a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14518a;

    public WorksItemChooseTeamHeadreBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 1, f14516a, f37016a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f14517a;
            this.f14517a = 0L;
        }
        ChatTeamHeaderBean chatTeamHeaderBean = ((WorksItemChooseTeamHeadreBinding) this).f37015a;
        long j2 = j & 3;
        String str = null;
        if (j2 != 0) {
            str = String.format("@%s", chatTeamHeaderBean != null ? chatTeamHeaderBean.getName() : null);
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f14518a, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14517a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14517a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemChooseTeamHeadreBinding
    public void k(@Nullable ChatTeamHeaderBean Bean) {
        ((WorksItemChooseTeamHeadreBinding) this).f37015a = Bean;
        synchronized (this) {
            this.f14517a |= 1;
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
        k((ChatTeamHeaderBean) variable);
        return true;
    }

    public WorksItemChooseTeamHeadreBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0);
        this.f14517a = -1L;
        TextView textView = (TextView) bindings[0];
        this.f14518a = textView;
        textView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
