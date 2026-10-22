package com.huachenjie.mall.databinding;

import android.text.TextUtils;
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
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.ApplyRefundFileBean;
import com.zj.adlib.hk0;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemApplyRefundPicBindingImpl extends MallItemApplyRefundPicBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34977a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10727a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10728a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f10729a;

    @NonNull
    public final ImageView b;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34977a = sparseIntArray;
        sparseIntArray.put(R.id.iv_del, 2);
    }

    public MallItemApplyRefundPicBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f10727a, f34977a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zIsEmpty;
        RequestOptions requestOptions;
        String cover;
        synchronized (this) {
            j = this.f10728a;
            this.f10728a = 0L;
        }
        ApplyRefundFileBean applyRefundFileBean = ((MallItemApplyRefundPicBinding) this).f10726a;
        long j2 = j & 3;
        String str = null;
        if (j2 != 0) {
            requestOptions = ju3.p;
            cover = applyRefundFileBean != null ? applyRefundFileBean.getCover() : null;
            zIsEmpty = TextUtils.isEmpty(cover);
            if (j2 != 0) {
                j = zIsEmpty ? j | 8 : j | 4;
            }
        } else {
            zIsEmpty = false;
            requestOptions = null;
            cover = null;
        }
        String path = ((j & 8) == 0 || applyRefundFileBean == null) ? null : applyRefundFileBean.getPath();
        long j3 = j & 3;
        if (j3 != 0) {
            str = zIsEmpty ? path : cover;
        }
        if (j3 != 0) {
            CommonBindingAdapter.b0(this.b, str, requestOptions, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10728a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10728a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemApplyRefundPicBinding
    public void k(@Nullable ApplyRefundFileBean applyRefundFileBean) {
        ((MallItemApplyRefundPicBinding) this).f10726a = applyRefundFileBean;
        synchronized (this) {
            this.f10728a |= 1;
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
        k((ApplyRefundFileBean) obj);
        return true;
    }

    public MallItemApplyRefundPicBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[2]);
        this.f10728a = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f10729a = frameLayout;
        frameLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.b = imageView;
        imageView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
