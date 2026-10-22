package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.widget.ShadowConstraintLayout;
import com.huachenjie.sport.page.mine.exam.ExamQuestionAdapter;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemExamQuestionBindingImpl extends ItemExamQuestionBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36508a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13592a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13593a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f13594a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShadowConstraintLayout f13595a;

    public ItemExamQuestionBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f13592a, f36508a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f13593a;
            this.f13593a = 0L;
        }
        ExamQuestionAdapter examQuestionAdapter = ((ItemExamQuestionBinding) this).f36507a;
        if ((j & 3) != 0) {
            CommonBindingAdapter.g(this.f13594a, examQuestionAdapter, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13593a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13593a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemExamQuestionBinding
    public void k(@Nullable ExamQuestionAdapter examQuestionAdapter) {
        ((ItemExamQuestionBinding) this).f36507a = examQuestionAdapter;
        synchronized (this) {
            this.f13593a |= 1;
        }
        notifyPropertyChanged(ok0.b);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.b != i) {
            return false;
        }
        k((ExamQuestionAdapter) obj);
        return true;
    }

    public ItemExamQuestionBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f13593a = -1L;
        ShadowConstraintLayout shadowConstraintLayout = (ShadowConstraintLayout) objArr[0];
        this.f13595a = shadowConstraintLayout;
        shadowConstraintLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[1];
        this.f13594a = recyclerView;
        recyclerView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
