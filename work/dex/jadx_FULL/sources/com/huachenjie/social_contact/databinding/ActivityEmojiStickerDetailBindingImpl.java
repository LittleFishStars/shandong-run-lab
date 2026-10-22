package com.huachenjie.social_contact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.social_contact.page.emoji_sticker.detail.EmojiStickerDetailActivity;
import com.huachenjie.social_contact.page.emoji_sticker.detail.EmojiStickerDetailAdapter;
import com.huachenjie.social_contact.page.emoji_sticker.detail.EmojiStickerDetailVM;
import com.noober.background.view.BLTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivityEmojiStickerDetailBindingImpl extends ActivityEmojiStickerDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36078a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12703a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12704a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12705a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12706a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f12707a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f12708a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f12709a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f12710a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f12711a;

    @NonNull
    public final BLTextView b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public EmojiStickerDetailActivity.a f36079a;

        public a a(EmojiStickerDetailActivity.a aVar) {
            this.f36079a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36079a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public EmojiStickerDetailActivity.a f36080a;

        public b a(EmojiStickerDetailActivity.a aVar) {
            this.f36080a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36080a.b(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(7);
        f12703a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{6}, new int[]{R.layout.layout_toolbar_binding});
        f36078a = null;
    }

    public ActivityEmojiStickerDetailBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f12703a, f36078a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0038  */
    /* JADX WARN: Code duplicated, block: B:25:0x0056  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:65:0x00d1  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        boolean z;
        String value;
        EmojiStickerDetailAdapter value2;
        String value3;
        BindingTitleBean value4;
        a aVarA;
        b bVarA;
        boolean z2;
        boolean z3;
        Long l;
        synchronized (this) {
            j = this.f12704a;
            this.f12704a = 0L;
        }
        EmojiStickerDetailVM emojiStickerDetailVM = ((ActivityEmojiStickerDetailBinding) this).f12702a;
        EmojiStickerDetailActivity.a aVar = ((ActivityEmojiStickerDetailBinding) this).f12701a;
        if ((383 & j) != 0) {
            if ((j & 321) == 0) {
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataL = emojiStickerDetailVM != null ? emojiStickerDetailVM.l() : null;
                updateLiveDataRegistration(0, mutableLiveDataL);
                if (mutableLiveDataL != null) {
                    value = mutableLiveDataL.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 324) == 0) {
                value4 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataW = emojiStickerDetailVM != null ? emojiStickerDetailVM.w() : null;
                updateLiveDataRegistration(2, mutableLiveDataW);
                if (mutableLiveDataW != null) {
                    value4 = mutableLiveDataW.getValue();
                } else {
                    value4 = null;
                }
            }
            long j2 = j & 330;
            if (j2 != 0) {
                MutableLiveData<Boolean> mutableLiveDataN = emojiStickerDetailVM != null ? emojiStickerDetailVM.n() : null;
                updateLiveDataRegistration(3, mutableLiveDataN);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataN != null ? mutableLiveDataN.getValue() : null);
                if (j2 != 0) {
                    j |= zSafeUnbox ? 1024L : 512L;
                }
                z = !zSafeUnbox;
                if ((j & 330) != 0) {
                    j |= z ? 4096L : 2048L;
                }
            } else {
                zSafeUnbox = false;
                z = false;
            }
            if ((j & 336) == 0) {
                value2 = null;
            } else {
                MutableLiveData<EmojiStickerDetailAdapter> mutableLiveDataJ = emojiStickerDetailVM != null ? emojiStickerDetailVM.j() : null;
                updateLiveDataRegistration(4, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value2 = mutableLiveDataJ.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 352) == 0) {
                value3 = null;
            } else {
                MutableLiveData<String> mutableLiveDataK = emojiStickerDetailVM != null ? emojiStickerDetailVM.k() : null;
                updateLiveDataRegistration(5, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value3 = mutableLiveDataK.getValue();
                } else {
                    value3 = null;
                }
            }
        } else {
            zSafeUnbox = false;
            z = false;
            value = null;
            value2 = null;
            value3 = null;
            value4 = null;
        }
        long j3 = j & 384;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
            bVarA = null;
        } else {
            b bVar = this.f12710a;
            if (bVar == null) {
                bVar = new b();
                this.f12710a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f12709a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f12709a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if ((j & 5120) != 0) {
            MutableLiveData<Boolean> mutableLiveDataU = emojiStickerDetailVM != null ? emojiStickerDetailVM.u() : null;
            updateLiveDataRegistration(1, mutableLiveDataU);
            z2 = !ViewDataBinding.safeUnbox(mutableLiveDataU != null ? mutableLiveDataU.getValue() : null);
        } else {
            z2 = false;
        }
        long j4 = j & 330;
        if (j4 != 0) {
            z3 = zSafeUnbox ? z2 : false;
            if (!z) {
                z2 = false;
            }
        } else {
            z2 = false;
            z3 = false;
        }
        if ((j & 352) != 0) {
            l = null;
            aw9.d(((ActivityEmojiStickerDetailBinding) this).f36077a, value3, false, null);
        } else {
            l = null;
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(((ActivityEmojiStickerDetailBinding) this).f36077a, aVarA, l);
            CommonBindingAdapter.q(this.f12711a, bVarA, l);
        }
        if ((324 & j) != 0) {
            this.f12708a.k(value4);
        }
        if ((336 & j) != 0) {
            CommonBindingAdapter.g(this.f12707a, value2, false, false);
        }
        if ((j & 321) != 0) {
            TextViewBindingAdapter.setText(this.f12706a, value);
        }
        if (j4 != 0) {
            CommonBindingAdapter.l0(this.f12711a, z2);
            CommonBindingAdapter.l0(this.b, z3);
        }
        ViewDataBinding.executeBindingsOn(this.f12708a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f12704a != 0) {
                return true;
            }
            return this.f12708a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12704a = 256L;
        }
        this.f12708a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ActivityEmojiStickerDetailBinding
    public void l(@Nullable EmojiStickerDetailActivity.a aVar) {
        ((ActivityEmojiStickerDetailBinding) this).f12701a = aVar;
        synchronized (this) {
            this.f12704a |= 128;
        }
        notifyPropertyChanged(nk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ActivityEmojiStickerDetailBinding
    public void m(@Nullable EmojiStickerDetailVM emojiStickerDetailVM) {
        ((ActivityEmojiStickerDetailBinding) this).f12702a = emojiStickerDetailVM;
        synchronized (this) {
            this.f12704a |= 64;
        }
        notifyPropertyChanged(nk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<EmojiStickerDetailAdapter> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12704a |= 16;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12704a |= 32;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return r((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return s((MutableLiveData) obj, i2);
        }
        if (i == 3) {
            return q((MutableLiveData) obj, i2);
        }
        if (i == 4) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<String> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12704a |= 1;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12704a |= 8;
        }
        return true;
    }

    public final boolean r(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12704a |= 2;
        }
        return true;
    }

    public final boolean s(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12704a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f12708a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (nk0.p0 == i) {
            m((EmojiStickerDetailVM) obj);
        } else {
            if (nk0.k != i) {
                return false;
            }
            l((EmojiStickerDetailActivity.a) obj);
        }
        return true;
    }

    public ActivityEmojiStickerDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (AvatarView) objArr[2]);
        this.f12704a = -1L;
        ((ActivityEmojiStickerDetailBinding) this).f36077a.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[6];
        this.f12708a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f12705a = linearLayout;
        linearLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[1];
        this.f12707a = recyclerView;
        recyclerView.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f12706a = textView;
        textView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[4];
        this.f12711a = bLTextView;
        bLTextView.setTag(null);
        BLTextView bLTextView2 = (BLTextView) objArr[5];
        this.b = bLTextView2;
        bLTextView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
