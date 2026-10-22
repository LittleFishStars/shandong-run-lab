package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.exam.ExamAnswerSheetAdapter;
import com.huachenjie.sport.page.mine.exam.ExamAnswerSheetVM;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class DialogBottomExamAnswerSheetBindingImpl extends DialogBottomExamAnswerSheetBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36444a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13388a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13389a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13390a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f13391a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36444a = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 4);
        sparseIntArray.put(R.id.tv_question_split, 5);
    }

    public DialogBottomExamAnswerSheetBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f13388a, f36444a));
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0058  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String strValueOf;
        String strValueOf2;
        ExamAnswerSheetAdapter examAnswerSheetAdapter;
        ExamAnswerSheetAdapter value;
        synchronized (this) {
            j = this.f13389a;
            this.f13389a = 0L;
        }
        ExamAnswerSheetVM examAnswerSheetVM = ((DialogBottomExamAnswerSheetBinding) this).f13387a;
        GridLayoutManager gridLayoutManager = ((DialogBottomExamAnswerSheetBinding) this).f13386a;
        if ((47 & j) != 0) {
            if ((j & 41) != 0) {
                MutableLiveData<Integer> mutableLiveData = examAnswerSheetVM != null ? examAnswerSheetVM.i : null;
                updateLiveDataRegistration(0, mutableLiveData);
                strValueOf2 = String.valueOf(ViewDataBinding.safeUnbox(mutableLiveData != null ? mutableLiveData.getValue() : null));
            } else {
                strValueOf2 = null;
            }
            if ((j & 42) == 0) {
                value = null;
            } else {
                MutableLiveData<ExamAnswerSheetAdapter> mutableLiveData2 = examAnswerSheetVM != null ? examAnswerSheetVM.k : null;
                updateLiveDataRegistration(1, mutableLiveData2);
                if (mutableLiveData2 != null) {
                    value = mutableLiveData2.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 44) != 0) {
                MutableLiveData<Integer> mutableLiveData3 = examAnswerSheetVM != null ? examAnswerSheetVM.j : null;
                updateLiveDataRegistration(2, mutableLiveData3);
                strValueOf = String.valueOf(ViewDataBinding.safeUnbox(mutableLiveData3 != null ? mutableLiveData3.getValue() : null));
                examAnswerSheetAdapter = value;
            } else {
                examAnswerSheetAdapter = value;
                strValueOf = null;
            }
        } else {
            strValueOf = null;
            strValueOf2 = null;
            examAnswerSheetAdapter = null;
        }
        long j2 = 48 & j;
        if ((j & 32) != 0) {
            ConstraintLayout constraintLayout = this.f13390a;
            DrawablesBindingAdapter.h(constraintLayout, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(constraintLayout, R.color.white)), 0, 0.0f, 0.0f, 0.0f, 0.0f, 13.0f, 0.0f, 13.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
        }
        if (j2 != 0) {
            this.f13391a.setLayoutManager(gridLayoutManager);
        }
        if ((j & 42) != 0) {
            CommonBindingAdapter.g(this.f13391a, examAnswerSheetAdapter, false, false);
        }
        if ((41 & j) != 0) {
            TextViewBindingAdapter.setText(((DialogBottomExamAnswerSheetBinding) this).f36443a, strValueOf2);
        }
        if ((j & 44) != 0) {
            TextViewBindingAdapter.setText(this.b, strValueOf);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13389a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13389a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.DialogBottomExamAnswerSheetBinding
    public void l(@Nullable GridLayoutManager gridLayoutManager) {
        ((DialogBottomExamAnswerSheetBinding) this).f13386a = gridLayoutManager;
        synchronized (this) {
            this.f13389a |= 16;
        }
        notifyPropertyChanged(ok0.J);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.DialogBottomExamAnswerSheetBinding
    public void m(@Nullable ExamAnswerSheetVM examAnswerSheetVM) {
        ((DialogBottomExamAnswerSheetBinding) this).f13387a = examAnswerSheetVM;
        synchronized (this) {
            this.f13389a |= 8;
        }
        notifyPropertyChanged(ok0.L);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<ExamAnswerSheetAdapter> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13389a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13389a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return p((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13389a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.L == i) {
            m((ExamAnswerSheetVM) obj);
        } else {
            if (ok0.J != i) {
                return false;
            }
            l((GridLayoutManager) obj);
        }
        return true;
    }

    public DialogBottomExamAnswerSheetBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (TextView) objArr[1], (TextView) objArr[2], (TextView) objArr[5], (TextView) objArr[4]);
        this.f13389a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13390a = constraintLayout;
        constraintLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[3];
        this.f13391a = recyclerView;
        recyclerView.setTag(null);
        ((DialogBottomExamAnswerSheetBinding) this).f36443a.setTag(null);
        this.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
