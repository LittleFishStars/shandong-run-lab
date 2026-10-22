package com.huachenjie.social_contact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.social_contact.page.emoji_sticker.EmojiStickerActivity;
import com.huachenjie.social_contact.page.emoji_sticker.EmojiStickerVM;
import com.huachenjie.social_contact.page.emoji_sticker.adapter.EmojiStickerAdapter;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivityEmojiStickerBindingImpl extends ActivityEmojiStickerBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36072a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12689a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12690a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f12691a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f12692a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f12693a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public EmojiStickerActivity.a f36073a;

        public a a(EmojiStickerActivity.a aVar) {
            this.f36073a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36073a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f12689a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        f36072a = null;
    }

    public ActivityEmojiStickerBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f12689a, f36072a));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0033  */
    /* JADX WARN: Code duplicated, block: B:24:0x004f  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        EmojiStickerAdapter<MultiItemEntity> value;
        BindingTitleBean value2;
        a aVarA;
        synchronized (this) {
            j = this.f12690a;
            this.f12690a = 0L;
        }
        EmojiStickerVM emojiStickerVM = ((ActivityEmojiStickerBinding) this).f12688a;
        EmojiStickerActivity.a aVar = ((ActivityEmojiStickerBinding) this).f12687a;
        if ((23 & j) != 0) {
            if ((j & 21) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataQ = emojiStickerVM != null ? emojiStickerVM.q() : null;
                updateLiveDataRegistration(0, mutableLiveDataQ);
                if (mutableLiveDataQ != null) {
                    value2 = mutableLiveDataQ.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 22) == 0) {
                value = null;
            } else {
                MutableLiveData<EmojiStickerAdapter<MultiItemEntity>> mutableLiveDataM = emojiStickerVM != null ? emojiStickerVM.m() : null;
                updateLiveDataRegistration(1, mutableLiveDataM);
                if (mutableLiveDataM != null) {
                    value = mutableLiveDataM.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
        }
        long j2 = 24 & j;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f12693a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f12693a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if ((22 & j) != 0) {
            CommonBindingAdapter.g(((ActivityEmojiStickerBinding) this).f12686a, value, false, false);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((ActivityEmojiStickerBinding) this).f36071a, aVarA, null);
        }
        if ((j & 21) != 0) {
            this.f12692a.k(value2);
        }
        ViewDataBinding.executeBindingsOn(this.f12692a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f12690a != 0) {
                return true;
            }
            return this.f12692a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12690a = 16L;
        }
        this.f12692a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ActivityEmojiStickerBinding
    public void l(@Nullable EmojiStickerActivity.a aVar) {
        ((ActivityEmojiStickerBinding) this).f12687a = aVar;
        synchronized (this) {
            this.f12690a |= 8;
        }
        notifyPropertyChanged(nk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ActivityEmojiStickerBinding
    public void m(@Nullable EmojiStickerVM emojiStickerVM) {
        ((ActivityEmojiStickerBinding) this).f12688a = emojiStickerVM;
        synchronized (this) {
            this.f12690a |= 4;
        }
        notifyPropertyChanged(nk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<EmojiStickerAdapter<MultiItemEntity>> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12690a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12690a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f12692a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (nk0.p0 == i) {
            m((EmojiStickerVM) obj);
        } else {
            if (nk0.k != i) {
                return false;
            }
            l((EmojiStickerActivity.a) obj);
        }
        return true;
    }

    public ActivityEmojiStickerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (RecyclerView) objArr[1], (LinearLayout) objArr[2]);
        this.f12690a = -1L;
        ((ActivityEmojiStickerBinding) this).f12686a.setTag(null);
        ((ActivityEmojiStickerBinding) this).f36071a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12691a = constraintLayout;
        constraintLayout.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[3];
        this.f12692a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        setRootTag(view);
        invalidateAll();
    }
}
