package com.huachenjie.social_contact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.social_contact.bean.EmojiStickerImageBean;
import com.noober.background.view.BLConstraintLayout;
import com.zj.adlib.aw9;
import com.zj.adlib.ju3;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemEmojiStickerDetailBindingImpl extends ItemEmojiStickerDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36180a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12962a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12963a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f12964a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f12965a;

    public ItemEmojiStickerDetailBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f12962a, f36180a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        synchronized (this) {
            j = this.f12963a;
            this.f12963a = 0L;
        }
        EmojiStickerImageBean emojiStickerImageBean = ((ItemEmojiStickerDetailBinding) this).f36179a;
        long j2 = j & 3;
        String imgUrl = null;
        if (j2 != 0) {
            requestOptions = ju3.l;
            if (emojiStickerImageBean != null) {
                imgUrl = emojiStickerImageBean.getImgUrl();
            }
        } else {
            requestOptions = null;
        }
        if (j2 != 0) {
            aw9.h(this.f12964a, imgUrl, requestOptions, 0);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12963a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12963a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ItemEmojiStickerDetailBinding
    public void k(@Nullable EmojiStickerImageBean emojiStickerImageBean) {
        ((ItemEmojiStickerDetailBinding) this).f36179a = emojiStickerImageBean;
        synchronized (this) {
            this.f12963a |= 1;
        }
        notifyPropertyChanged(nk0.p0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (nk0.p0 != i) {
            return false;
        }
        k((EmojiStickerImageBean) obj);
        return true;
    }

    public ItemEmojiStickerDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f12963a = -1L;
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[0];
        this.f12965a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f12964a = imageView;
        imageView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
