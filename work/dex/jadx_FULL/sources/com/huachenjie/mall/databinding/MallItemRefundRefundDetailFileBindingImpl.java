package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.bean.AttachmentBean;
import com.zj.adlib.hk0;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemRefundRefundDetailFileBindingImpl extends MallItemRefundRefundDetailFileBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35028a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10887a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10888a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10889a;

    public MallItemRefundRefundDetailFileBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f10887a, f35028a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        RequestOptions requestOptions;
        String str;
        synchronized (this) {
            j = this.f10888a;
            this.f10888a = 0L;
        }
        AttachmentBean attachmentBean = ((MallItemRefundRefundDetailFileBinding) this).f35027a;
        long j2 = j & 3;
        if (j2 != 0) {
            requestOptions = ju3.p;
            z = (attachmentBean != null ? attachmentBean.getAttachmentType() : 0) == 1;
            if (j2 != 0) {
                j = z ? j | 8 : j | 4;
            }
        } else {
            z = false;
            requestOptions = null;
        }
        String coverPath = ((4 & j) == 0 || attachmentBean == null) ? null : attachmentBean.getCoverPath();
        String url = ((8 & j) == 0 || attachmentBean == null) ? null : attachmentBean.getUrl();
        long j3 = j & 3;
        if (j3 != 0) {
            str = z ? url : coverPath;
        } else {
            str = null;
        }
        if (j3 != 0) {
            CommonBindingAdapter.b0(this.f10889a, str, requestOptions, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10888a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10888a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemRefundRefundDetailFileBinding
    public void k(@Nullable AttachmentBean attachmentBean) {
        ((MallItemRefundRefundDetailFileBinding) this).f35027a = attachmentBean;
        synchronized (this) {
            this.f10888a |= 1;
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
        k((AttachmentBean) obj);
        return true;
    }

    public MallItemRefundRefundDetailFileBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f10888a = -1L;
        ImageView imageView = (ImageView) objArr[0];
        this.f10889a = imageView;
        imageView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
