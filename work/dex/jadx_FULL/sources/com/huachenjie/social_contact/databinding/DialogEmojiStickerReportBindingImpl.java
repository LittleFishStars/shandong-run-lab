package com.huachenjie.social_contact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.page.emoji_sticker.dialog.EmojiStickerReportDialog;
import com.huachenjie.social_contact.page.emoji_sticker.dialog.EmojiStickerReportVM;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class DialogEmojiStickerReportBindingImpl extends DialogEmojiStickerReportBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36135a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12858a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12859a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f12860a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f12861a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f12862a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f12863a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f12864a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f12865a;

    @NonNull
    public final BLTextView b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public EmojiStickerReportDialog.a f36136a;

        public a a(EmojiStickerReportDialog.a aVar) {
            this.f36136a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36136a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public EmojiStickerReportDialog.a f36137a;

        public b a(EmojiStickerReportDialog.a aVar) {
            this.f36137a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36137a.b(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public EmojiStickerReportDialog.a f36138a;

        public c a(EmojiStickerReportDialog.a aVar) {
            this.f36138a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36138a.c(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36135a = sparseIntArray;
        sparseIntArray.put(R.id.rb_report_infringement, 4);
        sparseIntArray.put(R.id.rb_report_harass, 5);
        sparseIntArray.put(R.id.rb_report_content, 6);
    }

    public DialogEmojiStickerReportBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f12858a, f36135a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        c cVarA;
        a aVarA;
        b bVarA;
        synchronized (this) {
            j = this.f12859a;
            this.f12859a = 0L;
        }
        EmojiStickerReportDialog.a aVar = ((DialogEmojiStickerReportBinding) this).f12856a;
        long j2 = j & 6;
        if (j2 == 0 || aVar == null) {
            cVarA = null;
            aVarA = null;
            bVarA = null;
        } else {
            c cVar = this.f12863a;
            if (cVar == null) {
                cVar = new c();
                this.f12863a = cVar;
            }
            cVarA = cVar.a(aVar);
            a aVar2 = this.f12861a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f12861a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            b bVar = this.f12862a;
            if (bVar == null) {
                bVar = new b();
                this.f12862a = bVar;
            }
            bVarA = bVar.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f12860a, aVarA, null);
            CommonBindingAdapter.q(this.f12864a, cVarA, null);
            CommonBindingAdapter.q(this.f12865a, aVarA, null);
            CommonBindingAdapter.q(this.b, bVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12859a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12859a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.DialogEmojiStickerReportBinding
    public void l(@Nullable EmojiStickerReportDialog.a aVar) {
        ((DialogEmojiStickerReportBinding) this).f12856a = aVar;
        synchronized (this) {
            this.f12859a |= 2;
        }
        notifyPropertyChanged(nk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.DialogEmojiStickerReportBinding
    public void m(@Nullable EmojiStickerReportVM emojiStickerReportVM) {
        ((DialogEmojiStickerReportBinding) this).f12857a = emojiStickerReportVM;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (nk0.p0 == i) {
            m((EmojiStickerReportVM) obj);
        } else {
            if (nk0.k != i) {
                return false;
            }
            l((EmojiStickerReportDialog.a) obj);
        }
        return true;
    }

    public DialogEmojiStickerReportBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RadioButton) objArr[6], (RadioButton) objArr[5], (RadioButton) objArr[4]);
        this.f12859a = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f12860a = frameLayout;
        frameLayout.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[1];
        this.f12864a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[2];
        this.f12865a = bLTextView;
        bLTextView.setTag(null);
        BLTextView bLTextView2 = (BLTextView) objArr[3];
        this.b = bLTextView2;
        bLTextView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
