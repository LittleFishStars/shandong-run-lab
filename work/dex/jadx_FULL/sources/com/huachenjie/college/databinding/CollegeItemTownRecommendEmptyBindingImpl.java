package com.huachenjie.college.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.college.R;
import com.huachenjie.college.bean.RecommendItemBean;
import com.noober.background.view.BLImageView;
import com.zj.adlib.uk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class CollegeItemTownRecommendEmptyBindingImpl extends CollegeItemTownRecommendEmptyBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33582a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8421a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8422a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f8423a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33582a = sparseIntArray;
        sparseIntArray.put(R.id.iv_recommend_image, 1);
    }

    public CollegeItemTownRecommendEmptyBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f8421a, f33582a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f8422a = 0L;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8422a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8422a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.college.databinding.CollegeItemTownRecommendEmptyBinding
    public void k(@Nullable RecommendItemBean recommendItemBean) {
        ((CollegeItemTownRecommendEmptyBinding) this).f33581a = recommendItemBean;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (uk0.p0 != i) {
            return false;
        }
        k((RecommendItemBean) obj);
        return true;
    }

    public CollegeItemTownRecommendEmptyBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (BLImageView) objArr[1]);
        this.f8422a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f8423a = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
