package com.huachenjie.social_contact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.EmojiStickerAddBean;
import com.noober.background.view.BLConstraintLayout;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemEmojiStickerAddBindingImpl extends ItemEmojiStickerAddBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36174a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12942a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12943a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f12944a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36174a = sparseIntArray;
        sparseIntArray.put(R.id.iv_emoji_sticker, 1);
    }

    public ItemEmojiStickerAddBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f12942a, f36174a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f12943a = 0L;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12943a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12943a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ItemEmojiStickerAddBinding
    public void k(@Nullable EmojiStickerAddBean emojiStickerAddBean) {
        ((ItemEmojiStickerAddBinding) this).f12941a = emojiStickerAddBean;
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
        k((EmojiStickerAddBean) obj);
        return true;
    }

    public ItemEmojiStickerAddBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1]);
        this.f12943a = -1L;
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[0];
        this.f12944a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
