package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLImageView;
import com.zj.adlib.ju3;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemBroadcastFloorBannerBindingImpl extends WorksItemBroadcastFloorBannerBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37005a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14467a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14468a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f14469a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f14470a;

    public WorksItemBroadcastFloorBannerBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 2, f14467a, f37005a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f14468a;
            this.f14468a = 0L;
        }
        String str = this.f;
        long j2 = j & 3;
        RequestOptions requestOptions = j2 != 0 ? ju3.m : null;
        if (j2 != 0) {
            CommonBindingAdapter.b0(this.f14470a, str, requestOptions, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14468a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14468a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemBroadcastFloorBannerBinding
    public void k(@Nullable String Bean) {
        this.f = Bean;
        synchronized (this) {
            this.f14468a |= 1;
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
        k((String) variable);
        return true;
    }

    public WorksItemBroadcastFloorBannerBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0);
        this.f14468a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f14469a = constraintLayout;
        constraintLayout.setTag(null);
        BLImageView bLImageView = (BLImageView) bindings[1];
        this.f14470a = bLImageView;
        bLImageView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
