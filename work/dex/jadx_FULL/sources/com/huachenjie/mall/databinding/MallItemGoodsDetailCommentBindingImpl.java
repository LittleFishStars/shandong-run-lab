package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.timepicker.TimeModel;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailCommentInfo;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailOneGoodsComment;
import com.noober.background.view.BLTextView;
import com.zj.adlib.hk0;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemGoodsDetailCommentBindingImpl extends MallItemGoodsDetailCommentBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35002a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10803a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10804a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10805a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f10806a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f10807a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public MallItemGoodsDetailCommentBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f10803a, f35002a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean status;
        RequestOptions requestOptions;
        String str;
        RequestOptions requestOptions2;
        String str2;
        String commentUrl;
        String nickName;
        String commentContent;
        int goodsCommentCount;
        String avatarUrl;
        GoodsDetailCommentInfo commentInfo;
        int commentImageCount;
        synchronized (this) {
            j = this.f10804a;
            this.f10804a = 0L;
        }
        GoodsDetailOneGoodsComment goodsDetailOneGoodsComment = ((MallItemGoodsDetailCommentBinding) this).f10802a;
        long j2 = j & 3;
        String str3 = null;
        if (j2 != 0) {
            requestOptions = ju3.b;
            requestOptions2 = ju3.p;
            if (goodsDetailOneGoodsComment != null) {
                status = goodsDetailOneGoodsComment.getStatus();
                goodsCommentCount = goodsDetailOneGoodsComment.getGoodsCommentCount();
                commentInfo = goodsDetailOneGoodsComment.getCommentInfo();
                nickName = goodsDetailOneGoodsComment.getNickName();
                avatarUrl = goodsDetailOneGoodsComment.getAvatarUrl();
            } else {
                status = false;
                goodsCommentCount = 0;
                avatarUrl = null;
                commentInfo = null;
                nickName = null;
            }
            str2 = String.format("(%d)", Integer.valueOf(goodsCommentCount));
            if (commentInfo != null) {
                commentImageCount = commentInfo.getCommentImageCount();
                commentContent = commentInfo.getCommentContent();
                commentUrl = commentInfo.getCommentUrl();
            } else {
                commentUrl = null;
                commentContent = null;
                commentImageCount = 0;
            }
            String str4 = avatarUrl;
            str = String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(commentImageCount));
            str3 = str4;
        } else {
            status = false;
            requestOptions = null;
            str = null;
            requestOptions2 = null;
            str2 = null;
            commentUrl = null;
            nickName = null;
            commentContent = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(((MallItemGoodsDetailCommentBinding) this).f35001a, str3, requestOptions, false);
            CommonBindingAdapter.b0(super.b, commentUrl, requestOptions2, false);
            TextViewBindingAdapter.setText(this.b, str2);
            CommonBindingAdapter.l0(this.f10806a, status);
            TextViewBindingAdapter.setText(this.f10807a, str);
            TextViewBindingAdapter.setText(this.c, nickName);
            TextViewBindingAdapter.setText(((MallItemGoodsDetailCommentBinding) this).f10801a, commentContent);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10804a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10804a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemGoodsDetailCommentBinding
    public void k(@Nullable GoodsDetailOneGoodsComment goodsDetailOneGoodsComment) {
        ((MallItemGoodsDetailCommentBinding) this).f10802a = goodsDetailOneGoodsComment;
        synchronized (this) {
            this.f10804a |= 1;
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
        k((GoodsDetailOneGoodsComment) obj);
        return true;
    }

    public MallItemGoodsDetailCommentBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[5], (ImageView) objArr[3], (TextView) objArr[6]);
        this.f10804a = -1L;
        ((MallItemGoodsDetailCommentBinding) this).f35001a.setTag(null);
        super.b.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10805a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.b = textView;
        textView.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[2];
        this.f10806a = constraintLayout;
        constraintLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[4];
        this.f10807a = bLTextView;
        bLTextView.setTag(null);
        TextView textView2 = (TextView) objArr[7];
        this.c = textView2;
        textView2.setTag(null);
        ((MallItemGoodsDetailCommentBinding) this).f10801a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
