package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.base.view.RoundImageView;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.CommodityCommentBean;
import com.zj.adlib.aw9;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemCommodityCommentBindingImpl extends MallItemCommodityCommentBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34985a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10753a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10754a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f10755a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34985a = sparseIntArray;
        sparseIntArray.put(R.id.ivCommentLevel, 11);
    }

    public MallItemCommodityCommentBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, f10753a, f34985a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zShowImage;
        boolean z;
        boolean zShowImage2;
        String imageUrl;
        boolean zShowImage3;
        String imageUrl2;
        String imageUrl3;
        boolean zShowImage4;
        boolean zShowImage5;
        String imageUrl4;
        String str;
        String str2;
        String avatar;
        boolean zShowComment;
        String submitTime;
        String str3;
        String str4;
        synchronized (this) {
            j = this.f10754a;
            this.f10754a = 0L;
        }
        CommodityCommentBean commodityCommentBean = ((MallItemCommodityCommentBinding) this).f10749a;
        long j2 = j & 3;
        if (j2 == 0 || commodityCommentBean == null) {
            zShowImage = false;
            z = false;
            zShowImage2 = false;
            imageUrl = null;
            zShowImage3 = false;
            imageUrl2 = null;
            imageUrl3 = null;
            zShowImage4 = false;
            zShowImage5 = false;
            imageUrl4 = null;
            str = null;
            str2 = null;
            avatar = null;
            zShowComment = false;
            submitTime = null;
            str3 = null;
            str4 = null;
        } else {
            imageUrl = commodityCommentBean.formatImageUrl(0);
            imageUrl2 = commodityCommentBean.formatImageUrl(4);
            zShowImage4 = commodityCommentBean.showImage(2);
            imageUrl4 = commodityCommentBean.formatImageUrl(3);
            String comment = commodityCommentBean.formatComment();
            zShowImage5 = commodityCommentBean.showImage(3);
            String nickName = commodityCommentBean.getNickName();
            avatar = commodityCommentBean.getAvatar();
            zShowComment = commodityCommentBean.showComment();
            submitTime = commodityCommentBean.formatSubmitTime();
            imageUrl3 = commodityCommentBean.formatImageUrl(2);
            zShowImage3 = commodityCommentBean.showImage(4);
            boolean zShowImage6 = commodityCommentBean.showImage(0);
            String imageUrl5 = commodityCommentBean.formatImageUrl(1);
            String imageUrl6 = commodityCommentBean.formatImageUrl(5);
            zShowImage2 = commodityCommentBean.showImage(5);
            zShowImage = commodityCommentBean.showImage(1);
            z = zShowImage6;
            str3 = nickName;
            str2 = imageUrl5;
            str4 = comment;
            str = imageUrl6;
        }
        if (j2 != 0) {
            aw9.d(((MallItemCommodityCommentBinding) this).f10748a, avatar, false, null);
            CommonBindingAdapter.l0(((MallItemCommodityCommentBinding) this).f10747a, z);
            CommonBindingAdapter.b0(((MallItemCommodityCommentBinding) this).f10747a, imageUrl, null, false);
            CommonBindingAdapter.l0(((MallItemCommodityCommentBinding) this).f10750b, zShowImage);
            CommonBindingAdapter.b0(((MallItemCommodityCommentBinding) this).f10750b, str2, null, false);
            CommonBindingAdapter.l0(((MallItemCommodityCommentBinding) this).f10751c, zShowImage4);
            CommonBindingAdapter.b0(((MallItemCommodityCommentBinding) this).f10751c, imageUrl3, null, false);
            CommonBindingAdapter.l0(((MallItemCommodityCommentBinding) this).f10752d, zShowImage5);
            CommonBindingAdapter.b0(((MallItemCommodityCommentBinding) this).f10752d, imageUrl4, null, false);
            CommonBindingAdapter.l0(this.e, zShowImage3);
            CommonBindingAdapter.b0(this.e, imageUrl2, null, false);
            CommonBindingAdapter.l0(this.f, zShowImage2);
            CommonBindingAdapter.b0(this.f, str, null, false);
            CommonBindingAdapter.l0(((MallItemCommodityCommentBinding) this).b, zShowComment);
            TextViewBindingAdapter.setText(((MallItemCommodityCommentBinding) this).b, str4);
            TextViewBindingAdapter.setText(((MallItemCommodityCommentBinding) this).c, str3);
            TextViewBindingAdapter.setText(((MallItemCommodityCommentBinding) this).d, submitTime);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10754a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10754a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemCommodityCommentBinding
    public void k(@Nullable CommodityCommentBean commodityCommentBean) {
        ((MallItemCommodityCommentBinding) this).f10749a = commodityCommentBean;
        synchronized (this) {
            this.f10754a |= 1;
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
        k((CommodityCommentBean) obj);
        return true;
    }

    public MallItemCommodityCommentBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AvatarView) objArr[1], (RoundImageView) objArr[5], (RoundImageView) objArr[6], (RoundImageView) objArr[7], (RoundImageView) objArr[8], (RoundImageView) objArr[9], (RoundImageView) objArr[10], (TextView) objArr[11], (TextView) objArr[4], (TextView) objArr[2], (TextView) objArr[3]);
        this.f10754a = -1L;
        ((MallItemCommodityCommentBinding) this).f10748a.setTag(null);
        ((MallItemCommodityCommentBinding) this).f10747a.setTag(null);
        ((MallItemCommodityCommentBinding) this).f10750b.setTag(null);
        ((MallItemCommodityCommentBinding) this).f10751c.setTag(null);
        ((MallItemCommodityCommentBinding) this).f10752d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f10755a = constraintLayout;
        constraintLayout.setTag(null);
        ((MallItemCommodityCommentBinding) this).b.setTag(null);
        ((MallItemCommodityCommentBinding) this).c.setTag(null);
        ((MallItemCommodityCommentBinding) this).d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
