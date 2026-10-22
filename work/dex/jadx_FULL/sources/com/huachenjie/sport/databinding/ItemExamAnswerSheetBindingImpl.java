package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.common.widget.CheckTextView;
import com.huachenjie.sport.R;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemExamAnswerSheetBindingImpl extends ItemExamAnswerSheetBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36500a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13564a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13565a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13566a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CheckTextView f13567a;

    public ItemExamAnswerSheetBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f13564a, f36500a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f13565a;
            this.f13565a = 0L;
        }
        Integer num = ((ItemExamAnswerSheetBinding) this).f13563a;
        Boolean bool = ((ItemExamAnswerSheetBinding) this).f36499a;
        long j2 = 5 & j;
        String strValueOf = j2 != 0 ? String.valueOf(ViewDataBinding.safeUnbox(num)) : null;
        long j3 = 6 & j;
        boolean zSafeUnbox = j3 != 0 ? ViewDataBinding.safeUnbox(bool) : false;
        if (j3 != 0) {
            this.f13567a.setChecked(zSafeUnbox);
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f13567a, strValueOf);
        }
        if ((j & 4) != 0) {
            CheckTextView checkTextView = this.f13567a;
            DrawablesBindingAdapter.h(checkTextView, 1, Integer.valueOf(ViewDataBinding.getColorFromResource(checkTextView, R.color.color_E6E8EC)), 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1, Integer.valueOf(ViewDataBinding.getColorFromResource(this.f13567a, R.color.color_main_v2)), 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            CheckTextView checkTextView2 = this.f13567a;
            DrawablesBindingAdapter.g(checkTextView2, Integer.valueOf(ViewDataBinding.getColorFromResource(checkTextView2, R.color.color_333333)), Integer.valueOf(ViewDataBinding.getColorFromResource(this.f13567a, R.color.white)), null, null, null, null, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13565a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13565a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemExamAnswerSheetBinding
    public void l(@Nullable Integer num) {
        ((ItemExamAnswerSheetBinding) this).f13563a = num;
        synchronized (this) {
            this.f13565a |= 1;
        }
        notifyPropertyChanged(ok0.w);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // com.huachenjie.sport.databinding.ItemExamAnswerSheetBinding
    public void setChecked(@Nullable Boolean bool) {
        ((ItemExamAnswerSheetBinding) this).f36499a = bool;
        synchronized (this) {
            this.f13565a |= 2;
        }
        notifyPropertyChanged(ok0.j);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.w == i) {
            l((Integer) obj);
        } else {
            if (ok0.j != i) {
                return false;
            }
            setChecked((Boolean) obj);
        }
        return true;
    }

    public ItemExamAnswerSheetBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f13565a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13566a = constraintLayout;
        constraintLayout.setTag(null);
        CheckTextView checkTextView = (CheckTextView) objArr[1];
        this.f13567a = checkTextView;
        checkTextView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
