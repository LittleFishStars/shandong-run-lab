package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.huachenjie.common.widget.SelectBoldTabLayout;
import com.huachenjie.works.R;
import com.huachenjie.works.page.search.result.SearchResultModel;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksFragmentSearchResultBindingImpl extends WorksFragmentSearchResultBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36949a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14309a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14310a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14311a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36949a = sparseIntArray;
        sparseIntArray.put(R.id.card_view, 1);
        sparseIntArray.put(R.id.tab_layout, 2);
        sparseIntArray.put(R.id.vp, 3);
    }

    public WorksFragmentSearchResultBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f14309a, f36949a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f14310a = 0L;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14310a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14310a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentSearchResultBinding
    public void k(@Nullable SearchResultModel Vm) {
        ((WorksFragmentSearchResultBinding) this).f14308a = Vm;
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
        k((SearchResultModel) variable);
        return true;
    }

    public WorksFragmentSearchResultBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (FrameLayout) bindings[1], (SelectBoldTabLayout) bindings[2], (ViewPager2) bindings[3]);
        this.f14310a = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f14311a = linearLayout;
        linearLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
