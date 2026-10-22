package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.view.RoundImageView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.zj.adlib.ju3;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemFeedbackDetailsBindingImpl extends ItemFeedbackDetailsBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36516a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13608a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13609a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f13610a;

    public ItemFeedbackDetailsBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f13608a, f36516a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        boolean z;
        synchronized (this) {
            j = this.f13609a;
            this.f13609a = 0L;
        }
        String str = this.f;
        long j2 = j & 3;
        String str2 = null;
        if (j2 != 0) {
            requestOptions = ju3.h;
            z = str == null;
            if (j2 != 0) {
                j |= z ? 8L : 4L;
            }
        } else {
            requestOptions = null;
            z = false;
        }
        long j3 = j & 3;
        if (j3 != 0) {
            if (z) {
                str = "";
            }
            str2 = str;
        }
        if (j3 != 0) {
            CommonBindingAdapter.b0(((ItemFeedbackDetailsBinding) this).f36515a, str2, requestOptions, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13609a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13609a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemFeedbackDetailsBinding
    public void k(@Nullable String str) {
        this.f = str;
        synchronized (this) {
            this.f13609a |= 1;
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
        k((String) obj);
        return true;
    }

    public ItemFeedbackDetailsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundImageView) objArr[1]);
        this.f13609a = -1L;
        ((ItemFeedbackDetailsBinding) this).f36515a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f13610a = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
