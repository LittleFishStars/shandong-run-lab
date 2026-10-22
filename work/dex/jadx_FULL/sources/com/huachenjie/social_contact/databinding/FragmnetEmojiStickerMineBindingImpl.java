package com.huachenjie.social_contact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.social_contact.page.emoji_sticker.adapter.EmojiStickerAdapter;
import com.huachenjie.social_contact.page.emoji_sticker.mine.MineEmojiStickerSubVM;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class FragmnetEmojiStickerMineBindingImpl extends FragmnetEmojiStickerMineBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36172a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12939a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12940a;

    public FragmnetEmojiStickerMineBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f12939a, f36172a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f12940a;
            this.f12940a = 0L;
        }
        MineEmojiStickerSubVM mineEmojiStickerSubVM = ((FragmnetEmojiStickerMineBinding) this).f12938a;
        long j2 = j & 7;
        EmojiStickerAdapter<MultiItemEntity> value = null;
        if (j2 != 0) {
            MutableLiveData<EmojiStickerAdapter<MultiItemEntity>> mutableLiveDataN = mineEmojiStickerSubVM != null ? mineEmojiStickerSubVM.n() : null;
            updateLiveDataRegistration(0, mutableLiveDataN);
            if (mutableLiveDataN != null) {
                value = mutableLiveDataN.getValue();
            }
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(((FragmnetEmojiStickerMineBinding) this).f36171a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12940a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12940a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.FragmnetEmojiStickerMineBinding
    public void k(@Nullable MineEmojiStickerSubVM mineEmojiStickerSubVM) {
        ((FragmnetEmojiStickerMineBinding) this).f12938a = mineEmojiStickerSubVM;
        synchronized (this) {
            this.f12940a |= 2;
        }
        notifyPropertyChanged(nk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<EmojiStickerAdapter<MultiItemEntity>> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12940a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return l((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (nk0.p0 != i) {
            return false;
        }
        k((MineEmojiStickerSubVM) obj);
        return true;
    }

    public FragmnetEmojiStickerMineBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (RecyclerView) objArr[0]);
        this.f12940a = -1L;
        ((FragmnetEmojiStickerMineBinding) this).f36171a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
