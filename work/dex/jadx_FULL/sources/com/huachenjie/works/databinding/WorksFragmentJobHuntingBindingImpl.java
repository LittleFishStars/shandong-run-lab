package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.dsbridge_webview.WebContentView;
import com.huachenjie.works.R;
import com.huachenjie.works.page.alumni.job_hunting.JobHuntingVM;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksFragmentJobHuntingBindingImpl extends WorksFragmentJobHuntingBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36915a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14214a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14215a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f14216a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36915a = sparseIntArray;
        sparseIntArray.put(R.id.web_content_view, 1);
    }

    public WorksFragmentJobHuntingBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 2, f14214a, f36915a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f14215a = 0L;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14215a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14215a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentJobHuntingBinding
    public void k(@Nullable JobHuntingVM Vm) {
        ((WorksFragmentJobHuntingBinding) this).f14213a = Vm;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 != variableId) {
            return false;
        }
        k((JobHuntingVM) variable);
        return true;
    }

    public WorksFragmentJobHuntingBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (WebContentView) bindings[1]);
        this.f14215a = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.f14216a = frameLayout;
        frameLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
