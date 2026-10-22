package com.huachenjie.channel.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.coroutines.adapters.ViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.AdvertiseBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.ju3;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemAdvertiseBindingImpl extends ChannelItemAdvertiseBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33221a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7909a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7910a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7911a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f7912a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f7913a;

    @NonNull
    public final ImageView d;

    @NonNull
    public final ImageView e;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33221a = sparseIntArray;
        sparseIntArray.put(R.id.ivEditAd, 7);
        sparseIntArray.put(R.id.ivDeleteAd, 8);
    }

    public ChannelItemAdvertiseBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f7909a, f33221a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        RequestOptions requestOptions;
        String str2;
        boolean z;
        boolean z2;
        boolean z3;
        int adStatus;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f7910a;
            this.f7910a = 0L;
        }
        AdvertiseBean advertiseBean = ((ChannelItemAdvertiseBinding) this).f7908a;
        long j4 = j & 3;
        Drawable drawable = null;
        String coverUrl = null;
        boolean z4 = true;
        if (j4 != 0) {
            requestOptions = ju3.n;
            if (advertiseBean != null) {
                coverUrl = advertiseBean.getCoverUrl();
                adStatus = advertiseBean.getAdStatus();
            } else {
                adStatus = 0;
            }
            z2 = adStatus == 2;
            z3 = adStatus == 3;
            boolean z5 = adStatus == 1;
            if (j4 != 0) {
                if (z5) {
                    j2 = j | 8 | 32;
                    j3 = 128;
                } else {
                    j2 = j | 4 | 16;
                    j3 = 64;
                }
                j = j2 | j3;
            }
            Drawable drawable2 = AppCompatResources.getDrawable(((ChannelItemAdvertiseBinding) this).f7907a.getContext(), z5 ? R.drawable.channel_bg_advertise_under_review : R.drawable.channel_bg_advertise_audit_failure);
            str2 = z5 ? "审核中" : "审核失败";
            String str3 = coverUrl;
            drawable = drawable2;
            str = str3;
            z = z5;
        } else {
            str = null;
            requestOptions = null;
            str2 = null;
            z = false;
            z2 = false;
            z3 = false;
        }
        long j5 = j & 3;
        if (j5 == 0) {
            z4 = false;
        } else if (!z) {
            z4 = z3;
        }
        if (j5 != 0) {
            CommonBindingAdapter.l0(this.c, z2);
            CommonBindingAdapter.l0(((ChannelItemAdvertiseBinding) this).f7907a, z4);
            ViewBindingAdapter.setBackground(((ChannelItemAdvertiseBinding) this).f7907a, drawable);
            CommonBindingAdapter.b0(this.d, str, requestOptions, false);
            TextViewBindingAdapter.setText(this.f7911a, str2);
            CommonBindingAdapter.l0(this.e, z3);
            CommonBindingAdapter.l0(this.f7913a, z3);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7910a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7910a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemAdvertiseBinding
    public void k(@Nullable AdvertiseBean advertiseBean) {
        ((ChannelItemAdvertiseBinding) this).f7908a = advertiseBean;
        synchronized (this) {
            this.f7910a |= 1;
        }
        notifyPropertyChanged(tk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.g != i) {
            return false;
        }
        k((AdvertiseBean) obj);
        return true;
    }

    public ChannelItemAdvertiseBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[8], (ImageView) objArr[7], (ImageView) objArr[2], (LinearLayout) objArr[3]);
        this.f7910a = -1L;
        this.c.setTag(null);
        ((ChannelItemAdvertiseBinding) this).f7907a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f7912a = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.d = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.f7911a = textView;
        textView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[5];
        this.e = imageView2;
        imageView2.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[6];
        this.f7913a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
