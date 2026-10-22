package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.bean.MyCourseOrEpisodesBean;
import com.huachenjie.mall.widget.VideoProgressView;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.hk0;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemPurchasedVideoGoodsBindingImpl extends MallItemPurchasedVideoGoodsBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35024a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10870a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10871a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10872a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final VideoProgressView f10873a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f10874a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f10875a;

    @NonNull
    public final TextView b;

    public MallItemPurchasedVideoGoodsBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f10870a, f35024a));
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003a  */
    /* JADX WARN: Code duplicated, block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String str;
        String str2;
        String episodeName;
        synchronized (this) {
            j = this.f10871a;
            this.f10871a = 0L;
        }
        MyCourseOrEpisodesBean myCourseOrEpisodesBean = ((MallItemPurchasedVideoGoodsBinding) this).f35023a;
        long j2 = j & 3;
        int i = 0;
        String str3 = null;
        if (j2 != 0) {
            requestOptions = ju3.m;
            if (myCourseOrEpisodesBean != null) {
                int progressRate = myCourseOrEpisodesBean.getProgressRate();
                str = myCourseOrEpisodesBean.formatterStatus();
                String goodsImage = myCourseOrEpisodesBean.getGoodsImage();
                episodeName = myCourseOrEpisodesBean.getEpisodeName();
                String str4 = myCourseOrEpisodesBean.formatterColor();
                i = progressRate;
                str3 = goodsImage;
                str2 = str4;
            } else {
                str = null;
            }
            if (j2 != 0) {
                CommonBindingAdapter.b0(this.f10874a, str3, requestOptions, false);
                TextViewBindingAdapter.setText(this.f10872a, episodeName);
                VideoProgressView.setVideoProgress(this.f10873a, i);
                TextViewBindingAdapter.setText(this.b, str);
                CommonBindingAdapter.W(this.b, str2);
            }
        }
        requestOptions = null;
        str = null;
        str2 = str;
        episodeName = str2;
        if (j2 != 0) {
            CommonBindingAdapter.b0(this.f10874a, str3, requestOptions, false);
            TextViewBindingAdapter.setText(this.f10872a, episodeName);
            VideoProgressView.setVideoProgress(this.f10873a, i);
            TextViewBindingAdapter.setText(this.b, str);
            CommonBindingAdapter.W(this.b, str2);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10871a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10871a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemPurchasedVideoGoodsBinding
    public void k(@Nullable MyCourseOrEpisodesBean myCourseOrEpisodesBean) {
        ((MallItemPurchasedVideoGoodsBinding) this).f35023a = myCourseOrEpisodesBean;
        synchronized (this) {
            this.f10871a |= 1;
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
        k((MyCourseOrEpisodesBean) obj);
        return true;
    }

    public MallItemPurchasedVideoGoodsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f10871a = -1L;
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[0];
        this.f10875a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        BLImageView bLImageView = (BLImageView) objArr[1];
        this.f10874a = bLImageView;
        bLImageView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f10872a = textView;
        textView.setTag(null);
        VideoProgressView videoProgressView = (VideoProgressView) objArr[3];
        this.f10873a = videoProgressView;
        videoProgressView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.b = textView2;
        textView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
