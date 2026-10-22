package com.huachenjie.sport.databinding;

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
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.common.widget.ShadowConstraintLayout;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.HuodongBean;
import com.huachenjie.sport.widget.HuodongStatusWidget;
import com.zj.adlib.ju3;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemSchoolyardBindingImpl extends ItemSchoolyardBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36525a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13631a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13632a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShadowConstraintLayout f13633a;

    @NonNull
    public final TextView b;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36525a = sparseIntArray;
        sparseIntArray.put(R.id.iv_time, 6);
    }

    public ItemSchoolyardBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f13631a, f36525a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003e  */
    /* JADX WARN: Code duplicated, block: B:18:0x0228  */
    /* JADX WARN: Code duplicated, block: B:25:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String str;
        String str2;
        synchronized (this) {
            j = this.f13632a;
            this.f13632a = 0L;
        }
        HuodongBean huodongBean = ((ItemSchoolyardBinding) this).f13629a;
        long j2 = 3 & j;
        int activityStatus = 0;
        String str3 = null;
        if (j2 != 0) {
            requestOptions = ju3.g;
            if (huodongBean != null) {
                String activityTime = huodongBean.getActivityTime();
                String activityTitle = huodongBean.getActivityTitle();
                String coverImage = huodongBean.getCoverImage();
                activityStatus = huodongBean.getActivityStatus();
                str = activityTime;
                str3 = coverImage;
                str2 = activityTitle;
            } else {
                str = null;
            }
            if ((j & 2) != 0) {
                DrawablesBindingAdapter.h(((ItemSchoolyardBinding) this).f13628a, 0, -285212673, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 13.0f, 0.0f, 13.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            }
            if (j2 != 0) {
                CommonBindingAdapter.b0(((ItemSchoolyardBinding) this).f36524a, str3, requestOptions, false);
                TextViewBindingAdapter.setText(this.b, str);
                TextViewBindingAdapter.setText(((ItemSchoolyardBinding) this).f13627a, str2);
                ((ItemSchoolyardBinding) this).f13630a.setStatus(activityStatus);
            }
        }
        requestOptions = null;
        str = null;
        str2 = str;
        if ((j & 2) != 0) {
            DrawablesBindingAdapter.h(((ItemSchoolyardBinding) this).f13628a, 0, -285212673, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 13.0f, 0.0f, 13.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(((ItemSchoolyardBinding) this).f36524a, str3, requestOptions, false);
            TextViewBindingAdapter.setText(this.b, str);
            TextViewBindingAdapter.setText(((ItemSchoolyardBinding) this).f13627a, str2);
            ((ItemSchoolyardBinding) this).f13630a.setStatus(activityStatus);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13632a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13632a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemSchoolyardBinding
    public void k(@Nullable HuodongBean huodongBean) {
        ((ItemSchoolyardBinding) this).f13629a = huodongBean;
        synchronized (this) {
            this.f13632a |= 1;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 != i) {
            return false;
        }
        k((HuodongBean) obj);
        return true;
    }

    public ItemSchoolyardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[2], (ImageView) objArr[1], (ImageView) objArr[6], (TextView) objArr[3], (HuodongStatusWidget) objArr[5]);
        this.f13632a = -1L;
        ((ItemSchoolyardBinding) this).f13628a.setTag(null);
        ((ItemSchoolyardBinding) this).f36524a.setTag(null);
        ShadowConstraintLayout shadowConstraintLayout = (ShadowConstraintLayout) objArr[0];
        this.f13633a = shadowConstraintLayout;
        shadowConstraintLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.b = textView;
        textView.setTag(null);
        ((ItemSchoolyardBinding) this).f13627a.setTag(null);
        ((ItemSchoolyardBinding) this).f13630a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
