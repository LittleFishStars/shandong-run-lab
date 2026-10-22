package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.bean.MultipleActivityBean;
import com.zj.adlib.ju3;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemActivityListBindingImpl extends WorksItemActivityListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36994a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14423a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14424a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f14425a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14426a;

    public WorksItemActivityListBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 2, f14423a, f36994a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        synchronized (this) {
            j = this.f14424a;
            this.f14424a = 0L;
        }
        MultipleActivityBean multipleActivityBean = ((WorksItemActivityListBinding) this).f36993a;
        long j2 = j & 3;
        String activityPicUrl = null;
        if (j2 != 0) {
            requestOptions = ju3.n;
            if (multipleActivityBean != null) {
                activityPicUrl = multipleActivityBean.getActivityPicUrl();
            }
        } else {
            requestOptions = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(this.f14426a, activityPicUrl, requestOptions, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14424a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14424a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemActivityListBinding
    public void k(@Nullable MultipleActivityBean Bean) {
        ((WorksItemActivityListBinding) this).f36993a = Bean;
        synchronized (this) {
            this.f14424a |= 1;
        }
        notifyPropertyChanged(qk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.g != variableId) {
            return false;
        }
        k((MultipleActivityBean) variable);
        return true;
    }

    public WorksItemActivityListBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0);
        this.f14424a = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.f14425a = frameLayout;
        frameLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.f14426a = imageView;
        imageView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
