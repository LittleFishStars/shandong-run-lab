package com.huachenjie.college.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.college.bean.RecommendItemBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.zj.adlib.ju3;
import com.zj.adlib.uk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class CollegeItemTownRecommendBindingImpl extends CollegeItemTownRecommendBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33580a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8416a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8417a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8418a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f8419a;

    public CollegeItemTownRecommendBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f8416a, f33580a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String bizName;
        synchronized (this) {
            j = this.f8417a;
            this.f8417a = 0L;
        }
        RecommendItemBean recommendItemBean = ((CollegeItemTownRecommendBinding) this).f8415a;
        long j2 = j & 3;
        String coverImg = null;
        if (j2 != 0) {
            requestOptions = ju3.x;
            if (recommendItemBean != null) {
                coverImg = recommendItemBean.getCoverImg();
                bizName = recommendItemBean.getBizName();
            } else {
                bizName = null;
            }
        } else {
            requestOptions = null;
            bizName = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(((CollegeItemTownRecommendBinding) this).f33579a, coverImg, requestOptions, false);
            TextViewBindingAdapter.setText(this.f8418a, bizName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8417a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8417a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.college.databinding.CollegeItemTownRecommendBinding
    public void k(@Nullable RecommendItemBean recommendItemBean) {
        ((CollegeItemTownRecommendBinding) this).f8415a = recommendItemBean;
        synchronized (this) {
            this.f8417a |= 1;
        }
        notifyPropertyChanged(uk0.p0);
        super.requestRebind();
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

    public CollegeItemTownRecommendBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1]);
        this.f8417a = -1L;
        ((CollegeItemTownRecommendBinding) this).f33579a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f8419a = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f8418a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
