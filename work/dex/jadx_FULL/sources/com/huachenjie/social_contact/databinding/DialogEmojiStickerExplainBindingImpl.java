package com.huachenjie.social_contact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.social_contact.page.emoji_sticker.dialog.EmojiStickerExplainDialog;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class DialogEmojiStickerExplainBindingImpl extends DialogEmojiStickerExplainBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36131a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12849a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12850a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f12851a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f12852a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f12853a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f12854a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f12855a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public EmojiStickerExplainDialog.a f36132a;

        public a a(EmojiStickerExplainDialog.a aVar) {
            this.f36132a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36132a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public EmojiStickerExplainDialog.a f36133a;

        public b a(EmojiStickerExplainDialog.a aVar) {
            this.f36133a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36133a.b(view);
        }
    }

    public DialogEmojiStickerExplainBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f12849a, f36131a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        b bVarA;
        a aVarA;
        synchronized (this) {
            j = this.f12850a;
            this.f12850a = 0L;
        }
        EmojiStickerExplainDialog.a aVar = ((DialogEmojiStickerExplainBinding) this).f36130a;
        long j2 = j & 3;
        if (j2 == 0 || aVar == null) {
            bVarA = null;
            aVarA = null;
        } else {
            b bVar = this.f12853a;
            if (bVar == null) {
                bVar = new b();
                this.f12853a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f12852a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f12852a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f12851a, aVarA, null);
            CommonBindingAdapter.q(this.f12854a, bVarA, null);
            CommonBindingAdapter.q(this.f12855a, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12850a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12850a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.DialogEmojiStickerExplainBinding
    public void k(@Nullable EmojiStickerExplainDialog.a aVar) {
        ((DialogEmojiStickerExplainBinding) this).f36130a = aVar;
        synchronized (this) {
            this.f12850a |= 1;
        }
        notifyPropertyChanged(nk0.k);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (nk0.k != i) {
            return false;
        }
        k((EmojiStickerExplainDialog.a) obj);
        return true;
    }

    public DialogEmojiStickerExplainBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f12850a = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f12851a = frameLayout;
        frameLayout.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[1];
        this.f12854a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[2];
        this.f12855a = bLTextView;
        bLTextView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
