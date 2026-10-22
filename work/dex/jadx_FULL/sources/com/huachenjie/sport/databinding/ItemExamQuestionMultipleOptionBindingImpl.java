package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.common.widget.CheckConstraintLayout;
import com.huachenjie.common.widget.CheckImageView;
import com.huachenjie.sport.R;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemExamQuestionMultipleOptionBindingImpl extends ItemExamQuestionMultipleOptionBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36510a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13597a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13598a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13599a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CheckConstraintLayout f13600a;

    public ItemExamQuestionMultipleOptionBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f13597a, f36510a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f13598a;
            this.f13598a = 0L;
        }
        Boolean bool = ((ItemExamQuestionMultipleOptionBinding) this).f13596a;
        String str = this.f;
        long j2 = 5 & j;
        boolean zSafeUnbox = j2 != 0 ? ViewDataBinding.safeUnbox(bool) : false;
        long j3 = 6 & j;
        if ((j & 4) != 0) {
            CheckImageView checkImageView = ((ItemExamQuestionMultipleOptionBinding) this).f36509a;
            DrawablesBindingAdapter.d(checkImageView, AppCompatResources.getDrawable(checkImageView.getContext(), R.drawable.ic_exam_multiple_normal), null, AppCompatResources.getDrawable(((ItemExamQuestionMultipleOptionBinding) this).f36509a.getContext(), R.drawable.ic_exam_multiple_checked), null, null, null, null, null, null, null, null, null, null, null);
            DrawablesBindingAdapter.h(this.f13600a, 0, 15725564, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, -1051652, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
        }
        if (j2 != 0) {
            this.f13600a.setChecked(zSafeUnbox);
        }
        if (j3 != 0) {
            TextViewBindingAdapter.setText(this.f13599a, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13598a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13598a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemExamQuestionMultipleOptionBinding
    public void k(@Nullable String str) {
        this.f = str;
        synchronized (this) {
            this.f13598a |= 2;
        }
        notifyPropertyChanged(ok0.o);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // com.huachenjie.sport.databinding.ItemExamQuestionMultipleOptionBinding
    public void setChecked(@Nullable Boolean bool) {
        ((ItemExamQuestionMultipleOptionBinding) this).f13596a = bool;
        synchronized (this) {
            this.f13598a |= 1;
        }
        notifyPropertyChanged(ok0.j);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.j == i) {
            setChecked((Boolean) obj);
        } else {
            if (ok0.o != i) {
                return false;
            }
            k((String) obj);
        }
        return true;
    }

    public ItemExamQuestionMultipleOptionBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CheckImageView) objArr[1]);
        this.f13598a = -1L;
        ((ItemExamQuestionMultipleOptionBinding) this).f36509a.setTag(null);
        CheckConstraintLayout checkConstraintLayout = (CheckConstraintLayout) objArr[0];
        this.f13600a = checkConstraintLayout;
        checkConstraintLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f13599a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
