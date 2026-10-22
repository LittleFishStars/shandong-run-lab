package com.huachenjie.im.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.im.bean.EmojiItemData;
import com.noober.background.view.BLView;
import com.zj.adlib.aw9;
import com.zj.adlib.ju3;
import com.zj.adlib.yk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ItemStickerIconBindingImpl extends ItemStickerIconBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34499a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9878a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9879a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f9880a;

    public ItemStickerIconBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f9878a, f34499a));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0028  */
    /* JADX WARN: Code duplicated, block: B:20:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        int emojiBagIconRes;
        synchronized (this) {
            j = this.f9879a;
            this.f9879a = 0L;
        }
        EmojiItemData emojiItemData = ((ItemStickerIconBinding) this).f9876a;
        long j2 = j & 3;
        String emojiBagIcon = null;
        boolean selected = false;
        if (j2 != 0) {
            requestOptions = ju3.h;
            if (emojiItemData != null) {
                selected = emojiItemData.getSelected();
                emojiBagIcon = emojiItemData.getEmojiBagIcon();
                emojiBagIconRes = emojiItemData.getEmojiBagIconRes();
            }
            if (j2 != 0) {
                CommonBindingAdapter.l0(((ItemStickerIconBinding) this).f9877a, selected);
                aw9.h(((ItemStickerIconBinding) this).f34498a, emojiBagIcon, requestOptions, emojiBagIconRes);
            }
        }
        requestOptions = null;
        emojiBagIconRes = 0;
        if (j2 != 0) {
            CommonBindingAdapter.l0(((ItemStickerIconBinding) this).f9877a, selected);
            aw9.h(((ItemStickerIconBinding) this).f34498a, emojiBagIcon, requestOptions, emojiBagIconRes);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9879a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9879a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.im.databinding.ItemStickerIconBinding
    public void k(@Nullable EmojiItemData emojiItemData) {
        ((ItemStickerIconBinding) this).f9876a = emojiItemData;
        synchronized (this) {
            this.f9879a |= 1;
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
        k((EmojiItemData) obj);
        return true;
    }

    public ItemStickerIconBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (BLView) objArr[1], (ImageView) objArr[2]);
        this.f9879a = -1L;
        ((ItemStickerIconBinding) this).f9877a.setTag(null);
        ((ItemStickerIconBinding) this).f34498a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f9880a = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
