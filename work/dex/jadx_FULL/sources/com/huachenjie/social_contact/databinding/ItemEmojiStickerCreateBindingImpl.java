package com.huachenjie.social_contact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.EmojiStickerImageBean;
import com.noober.background.view.BLConstraintLayout;
import com.zj.adlib.aw9;
import com.zj.adlib.ju3;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemEmojiStickerCreateBindingImpl extends ItemEmojiStickerCreateBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36178a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12959a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12960a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f12961a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36178a = sparseIntArray;
        sparseIntArray.put(R.id.iv_emoji_sticker_delete, 2);
    }

    public ItemEmojiStickerCreateBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f12959a, f36178a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        synchronized (this) {
            j = this.f12960a;
            this.f12960a = 0L;
        }
        EmojiStickerImageBean emojiStickerImageBean = ((ItemEmojiStickerCreateBinding) this).f12958a;
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
            aw9.h(((ItemEmojiStickerCreateBinding) this).f36177a, imgUrl, requestOptions, 0);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12960a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12960a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ItemEmojiStickerCreateBinding
    public void k(@Nullable EmojiStickerImageBean emojiStickerImageBean) {
        ((ItemEmojiStickerCreateBinding) this).f12958a = emojiStickerImageBean;
        synchronized (this) {
            this.f12960a |= 1;
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

    public ItemEmojiStickerCreateBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (ImageView) objArr[2]);
        this.f12960a = -1L;
        ((ItemEmojiStickerCreateBinding) this).f36177a.setTag(null);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[0];
        this.f12961a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
