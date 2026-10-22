package com.huachenjie.im.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.im.bean.EmojiBean;
import com.noober.background.view.BLConstraintLayout;
import com.zj.adlib.aw9;
import com.zj.adlib.ju3;
import com.zj.adlib.yk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ItemStickerBindingImpl extends ItemStickerBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34497a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9872a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9873a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f9874a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f9875a;

    public ItemStickerBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f9872a, f34497a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        synchronized (this) {
            j = this.f9873a;
            this.f9873a = 0L;
        }
        EmojiBean emojiBean = ((ItemStickerBinding) this).f34496a;
        long j2 = j & 3;
        String imgUrl = null;
        if (j2 != 0) {
            requestOptions = ju3.h;
            if (emojiBean != null) {
                imgUrl = emojiBean.getImgUrl();
            }
        } else {
            requestOptions = null;
        }
        if (j2 != 0) {
            aw9.h(this.f9874a, imgUrl, requestOptions, 0);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9873a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9873a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.im.databinding.ItemStickerBinding
    public void k(@Nullable EmojiBean emojiBean) {
        ((ItemStickerBinding) this).f34496a = emojiBean;
        synchronized (this) {
            this.f9873a |= 1;
        }
        notifyPropertyChanged(yk0.p0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (yk0.p0 != i) {
            return false;
        }
        k((EmojiBean) obj);
        return true;
    }

    public ItemStickerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f9873a = -1L;
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[0];
        this.f9875a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f9874a = imageView;
        imageView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
