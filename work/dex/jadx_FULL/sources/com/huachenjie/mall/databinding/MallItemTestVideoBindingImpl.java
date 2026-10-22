package com.huachenjie.mall.databinding;

import android.text.SpannableString;
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
import com.huachenjie.mall.page.test.TestVideoDetailBean;
import com.huachenjie.mall.page.test.WorkImageBean;
import com.zj.adlib.hk0;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemTestVideoBindingImpl extends MallItemTestVideoBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35045a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10944a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10945a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f10946a;

    public MallItemTestVideoBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f10944a, f35045a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        SpannableString content;
        String nickName;
        WorkImageBean coverBean;
        synchronized (this) {
            j = this.f10945a;
            this.f10945a = 0L;
        }
        TestVideoDetailBean testVideoDetailBean = ((MallItemTestVideoBinding) this).f10943a;
        long j2 = j & 3;
        String path = null;
        if (j2 != 0) {
            requestOptions = ju3.h;
            if (testVideoDetailBean != null) {
                content = testVideoDetailBean.formatContent();
                coverBean = testVideoDetailBean.formatCoverBean();
                nickName = testVideoDetailBean.formatNickName();
            } else {
                content = null;
                nickName = null;
                coverBean = null;
            }
            if (coverBean != null) {
                path = coverBean.getPath();
            }
        } else {
            requestOptions = null;
            content = null;
            nickName = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(((MallItemTestVideoBinding) this).f35044a, path, requestOptions, false);
            TextViewBindingAdapter.setText(((MallItemTestVideoBinding) this).f10942a, nickName);
            TextViewBindingAdapter.setText(this.b, content);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10945a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10945a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemTestVideoBinding
    public void k(@Nullable TestVideoDetailBean testVideoDetailBean) {
        ((MallItemTestVideoBinding) this).f10943a = testVideoDetailBean;
        synchronized (this) {
            this.f10945a |= 1;
        }
        notifyPropertyChanged(hk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.g != i) {
            return false;
        }
        k((TestVideoDetailBean) obj);
        return true;
    }

    public MallItemTestVideoBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (TextView) objArr[2], (TextView) objArr[3]);
        this.f10945a = -1L;
        ((MallItemTestVideoBinding) this).f35044a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f10946a = constraintLayout;
        constraintLayout.setTag(null);
        ((MallItemTestVideoBinding) this).f10942a.setTag(null);
        this.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
