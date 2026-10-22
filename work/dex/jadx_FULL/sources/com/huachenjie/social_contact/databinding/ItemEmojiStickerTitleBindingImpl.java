package com.huachenjie.social_contact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.social_contact.bean.EmojiStickerTitleBean;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemEmojiStickerTitleBindingImpl extends ItemEmojiStickerTitleBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36183a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12968a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12969a;

    public ItemEmojiStickerTitleBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f12968a, f36183a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int paddingTop;
        String itemTitle;
        synchronized (this) {
            j = this.f12969a;
            this.f12969a = 0L;
        }
        EmojiStickerTitleBean emojiStickerTitleBean = ((ItemEmojiStickerTitleBinding) this).f12967a;
        long j2 = j & 3;
        if (j2 == 0 || emojiStickerTitleBean == null) {
            paddingTop = 0;
            itemTitle = null;
        } else {
            paddingTop = emojiStickerTitleBean.getPaddingTop();
            itemTitle = emojiStickerTitleBean.getItemTitle();
        }
        int i = paddingTop;
        if (j2 != 0) {
            TextViewBindingAdapter.setText(((ItemEmojiStickerTitleBinding) this).f36182a, itemTitle);
            CommonBindingAdapter.O(((ItemEmojiStickerTitleBinding) this).f36182a, 0, i, 0, 0, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12969a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12969a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ItemEmojiStickerTitleBinding
    public void k(@Nullable EmojiStickerTitleBean emojiStickerTitleBean) {
        ((ItemEmojiStickerTitleBinding) this).f12967a = emojiStickerTitleBean;
        synchronized (this) {
            this.f12969a |= 1;
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
        k((EmojiStickerTitleBean) obj);
        return true;
    }

    public ItemEmojiStickerTitleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[0]);
        this.f12969a = -1L;
        ((ItemEmojiStickerTitleBinding) this).f36182a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
