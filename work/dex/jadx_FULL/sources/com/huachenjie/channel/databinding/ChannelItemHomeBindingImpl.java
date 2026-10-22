package com.huachenjie.channel.databinding;

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
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.ChannelHomeItemBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.zj.adlib.ju3;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemHomeBindingImpl extends ChannelItemHomeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33250a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7985a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7986a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7987a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f7988a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7989a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f7990a;

    @NonNull
    public final BLTextView b;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33250a = sparseIntArray;
        sparseIntArray.put(R.id.itemContainer, 6);
    }

    public ChannelItemHomeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f7985a, f33250a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String reviewText;
        String str;
        boolean zShowReviewStatus;
        boolean z;
        boolean zShowOfficeIcon;
        boolean selected;
        int officeIcon;
        int unreadCount;
        synchronized (this) {
            j = this.f7986a;
            this.f7986a = 0L;
        }
        ChannelHomeItemBean channelHomeItemBean = ((ChannelItemHomeBinding) this).f7984a;
        long j2 = j & 3;
        String logo = null;
        if (j2 != 0) {
            requestOptions = ju3.m;
            if (channelHomeItemBean != null) {
                logo = channelHomeItemBean.getLogo();
                unreadCount = channelHomeItemBean.getUnreadCount();
                zShowOfficeIcon = channelHomeItemBean.showOfficeIcon();
                selected = channelHomeItemBean.getSelected();
                officeIcon = channelHomeItemBean.formatOfficeIcon();
                reviewText = channelHomeItemBean.formatReviewText();
                str = channelHomeItemBean.formatterUnreadCount();
                zShowReviewStatus = channelHomeItemBean.showReviewStatus();
            } else {
                reviewText = null;
                str = null;
                zShowReviewStatus = false;
                unreadCount = 0;
                zShowOfficeIcon = false;
                selected = false;
                officeIcon = 0;
            }
            z = unreadCount > 0;
        } else {
            requestOptions = null;
            reviewText = null;
            str = null;
            zShowReviewStatus = false;
            z = false;
            zShowOfficeIcon = false;
            selected = false;
            officeIcon = 0;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(((ChannelItemHomeBinding) this).f7983a, logo, requestOptions, false);
            CommonBindingAdapter.l0(this.f7989a, zShowReviewStatus);
            TextViewBindingAdapter.setText(this.f7989a, reviewText);
            CommonBindingAdapter.l0(this.f7987a, zShowOfficeIcon);
            CommonBindingAdapter.x(this.f7987a, officeIcon);
            CommonBindingAdapter.l0(this.f7990a, selected);
            CommonBindingAdapter.l0(this.b, z);
            TextViewBindingAdapter.setText(this.b, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7986a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7986a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemHomeBinding
    public void k(@Nullable ChannelHomeItemBean channelHomeItemBean) {
        ((ChannelItemHomeBinding) this).f7984a = channelHomeItemBean;
        synchronized (this) {
            this.f7986a |= 1;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 != i) {
            return false;
        }
        k((ChannelHomeItemBean) obj);
        return true;
    }

    public ChannelItemHomeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[6], (ImageView) objArr[1]);
        this.f7986a = -1L;
        ((ChannelItemHomeBinding) this).f7983a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f7988a = constraintLayout;
        constraintLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[2];
        this.f7989a = bLTextView;
        bLTextView.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f7987a = textView;
        textView.setTag(null);
        BLView bLView = (BLView) objArr[4];
        this.f7990a = bLView;
        bLView.setTag(null);
        BLTextView bLTextView2 = (BLTextView) objArr[5];
        this.b = bLTextView2;
        bLTextView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
