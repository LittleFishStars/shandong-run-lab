package com.huachenjie.social_contact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.EmojiPropBean;
import com.huachenjie.social_contact.page.emoji_sticker.dialog.EmojiStickerSuccessDialog;
import com.huachenjie.social_contact.page.emoji_sticker.dialog.EmojiStickerSuccessVM;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class DialogEmojiStickerSuccessBindingImpl extends DialogEmojiStickerSuccessBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36140a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12868a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12869a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f12870a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12871a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f12872a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f12873a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f12874a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f12875a;

    @NonNull
    public final TextView b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public EmojiStickerSuccessDialog.a f36141a;

        public a a(EmojiStickerSuccessDialog.a aVar) {
            this.f36141a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36141a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public EmojiStickerSuccessDialog.a f36142a;

        public b a(EmojiStickerSuccessDialog.a aVar) {
            this.f36142a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36142a.b(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36140a = sparseIntArray;
        sparseIntArray.put(R.id.bg_emoji_sticker, 6);
    }

    public DialogEmojiStickerSuccessBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f12868a, f36140a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0039  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String level;
        String emojiBagCover;
        String emojiBagName;
        b bVarA;
        a aVarA;
        synchronized (this) {
            j = this.f12869a;
            this.f12869a = 0L;
        }
        EmojiStickerSuccessVM emojiStickerSuccessVM = ((DialogEmojiStickerSuccessBinding) this).f12867a;
        EmojiStickerSuccessDialog.a aVar = ((DialogEmojiStickerSuccessBinding) this).f12866a;
        long j2 = 11 & j;
        if (j2 == 0) {
            level = null;
            emojiBagCover = null;
            emojiBagName = null;
        } else {
            MutableLiveData<EmojiPropBean> mutableLiveDataH = emojiStickerSuccessVM != null ? emojiStickerSuccessVM.h() : null;
            updateLiveDataRegistration(0, mutableLiveDataH);
            EmojiPropBean value = mutableLiveDataH != null ? mutableLiveDataH.getValue() : null;
            if (value != null) {
                emojiBagCover = value.getEmojiBagCover();
                emojiBagName = value.getEmojiBagName();
                level = value.formatLevel();
            } else {
                level = null;
                emojiBagCover = null;
                emojiBagName = null;
            }
        }
        long j3 = j & 12;
        if (j3 == 0 || aVar == null) {
            bVarA = null;
            aVarA = null;
        } else {
            b bVar = this.f12873a;
            if (bVar == null) {
                bVar = new b();
                this.f12873a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f12872a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f12872a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(super.b, emojiBagCover, null, false);
            TextViewBindingAdapter.setText(this.f12871a, emojiBagName);
            TextViewBindingAdapter.setText(this.b, level);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f12870a, aVarA, null);
            CommonBindingAdapter.q(this.f12874a, bVarA, null);
            CommonBindingAdapter.q(this.f12875a, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12869a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12869a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.DialogEmojiStickerSuccessBinding
    public void l(@Nullable EmojiStickerSuccessDialog.a aVar) {
        ((DialogEmojiStickerSuccessBinding) this).f12866a = aVar;
        synchronized (this) {
            this.f12869a |= 4;
        }
        notifyPropertyChanged(nk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.DialogEmojiStickerSuccessBinding
    public void m(@Nullable EmojiStickerSuccessVM emojiStickerSuccessVM) {
        ((DialogEmojiStickerSuccessBinding) this).f12867a = emojiStickerSuccessVM;
        synchronized (this) {
            this.f12869a |= 2;
        }
        notifyPropertyChanged(nk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<EmojiPropBean> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12869a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (nk0.p0 == i) {
            m((EmojiStickerSuccessVM) obj);
        } else {
            if (nk0.k != i) {
                return false;
            }
            l((EmojiStickerSuccessDialog.a) obj);
        }
        return true;
    }

    public DialogEmojiStickerSuccessBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[6], (ImageView) objArr[3]);
        this.f12869a = -1L;
        super.b.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f12870a = frameLayout;
        frameLayout.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[1];
        this.f12874a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f12871a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.b = textView2;
        textView2.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[5];
        this.f12875a = bLTextView;
        bLTextView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
