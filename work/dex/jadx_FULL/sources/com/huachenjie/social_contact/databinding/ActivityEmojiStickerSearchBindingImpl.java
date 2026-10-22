package com.huachenjie.social_contact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.social_contact.page.emoji_sticker.adapter.EmojiStickerAdapter;
import com.huachenjie.social_contact.page.emoji_sticker.search.SearchEmojiStickerActivity;
import com.huachenjie.social_contact.page.emoji_sticker.search.SearchEmojiStickerVM;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivityEmojiStickerSearchBindingImpl extends ActivityEmojiStickerSearchBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36084a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12723a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12724a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12725a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f12726a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f12727a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f12728a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f12729a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f12730a;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((ActivityEmojiStickerSearchBinding) ActivityEmojiStickerSearchBindingImpl.this).f36083a);
            SearchEmojiStickerVM searchEmojiStickerVM = ((ActivityEmojiStickerSearchBinding) ActivityEmojiStickerSearchBindingImpl.this).f12722a;
            if (searchEmojiStickerVM != null) {
                MutableLiveData<String> mutableLiveDataP = searchEmojiStickerVM.p();
                if (mutableLiveDataP != null) {
                    mutableLiveDataP.setValue(textString);
                }
            }
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SearchEmojiStickerActivity.a f36086a;

        public b a(SearchEmojiStickerActivity.a aVar) {
            this.f36086a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36086a.a(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SearchEmojiStickerActivity.a f36087a;

        public c a(SearchEmojiStickerActivity.a aVar) {
            this.f36087a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36087a.b(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SearchEmojiStickerActivity.a f36088a;

        public d a(SearchEmojiStickerActivity.a aVar) {
            this.f36088a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36088a.c(view);
        }
    }

    public ActivityEmojiStickerSearchBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f12723a, f36084a));
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0078  */
    /* JADX WARN: Code duplicated, block: B:47:0x0098  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        int i;
        String value;
        EmojiStickerAdapter<MultiItemEntity> value2;
        c cVarA;
        d dVarA;
        b bVarA;
        int iSafeUnbox;
        synchronized (this) {
            j = this.f12724a;
            this.f12724a = 0L;
        }
        SearchEmojiStickerVM searchEmojiStickerVM = ((ActivityEmojiStickerSearchBinding) this).f12722a;
        SearchEmojiStickerActivity.a aVar = ((ActivityEmojiStickerSearchBinding) this).f12721a;
        if ((95 & j) != 0) {
            if ((j & 81) != 0) {
                MutableLiveData<Boolean> mutableLiveDataO = searchEmojiStickerVM != null ? searchEmojiStickerVM.o() : null;
                updateLiveDataRegistration(0, mutableLiveDataO);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataO != null ? mutableLiveDataO.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 82) != 0) {
                MutableLiveData<Integer> mutableLiveData = searchEmojiStickerVM != null ? ((BaseVM) searchEmojiStickerVM).f33644a : null;
                updateLiveDataRegistration(1, mutableLiveData);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData != null ? mutableLiveData.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            if ((j & 84) == 0) {
                value2 = null;
            } else {
                MutableLiveData<EmojiStickerAdapter<MultiItemEntity>> mutableLiveDataM = searchEmojiStickerVM != null ? searchEmojiStickerVM.m() : null;
                updateLiveDataRegistration(2, mutableLiveDataM);
                if (mutableLiveDataM != null) {
                    value2 = mutableLiveDataM.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 88) == 0) {
                i = iSafeUnbox;
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataP = searchEmojiStickerVM != null ? searchEmojiStickerVM.p() : null;
                updateLiveDataRegistration(3, mutableLiveDataP);
                if (mutableLiveDataP != null) {
                    value = mutableLiveDataP.getValue();
                    i = iSafeUnbox;
                } else {
                    i = iSafeUnbox;
                    value = null;
                }
            }
        } else {
            zSafeUnbox = false;
            i = 0;
            value = null;
            value2 = null;
        }
        long j2 = 96 & j;
        if (j2 == 0 || aVar == null) {
            cVarA = null;
            dVarA = null;
            bVarA = null;
        } else {
            d dVar = this.f12730a;
            if (dVar == null) {
                dVar = new d();
                this.f12730a = dVar;
            }
            dVarA = dVar.a(aVar);
            b bVar = this.f12728a;
            if (bVar == null) {
                bVar = new b();
                this.f12728a = bVar;
            }
            bVarA = bVar.a(aVar);
            c cVar = this.f12729a;
            if (cVar == null) {
                cVar = new c();
                this.f12729a = cVar;
            }
            cVarA = cVar.a(aVar);
        }
        if ((84 & j) != 0) {
            CommonBindingAdapter.g(((ActivityEmojiStickerSearchBinding) this).f12720a, value2, false, false);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((ActivityEmojiStickerSearchBinding) this).f12718a, cVarA, null);
            CommonBindingAdapter.q(this.b, bVarA, null);
            CommonBindingAdapter.q(((ActivityEmojiStickerSearchBinding) this).f12719a, dVarA, null);
        }
        if ((81 & j) != 0) {
            CommonBindingAdapter.l0(this.b, zSafeUnbox);
        }
        if ((88 & j) != 0) {
            TextViewBindingAdapter.setText(((ActivityEmojiStickerSearchBinding) this).f36083a, value);
        }
        if ((64 & j) != 0) {
            TextViewBindingAdapter.setTextWatcher(((ActivityEmojiStickerSearchBinding) this).f36083a, null, null, null, this.f12727a);
        }
        if ((j & 82) != 0) {
            CommonBindingAdapter.O(this.f12726a, 0, i, 0, 0, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12724a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12724a = 64L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ActivityEmojiStickerSearchBinding
    public void l(@Nullable SearchEmojiStickerActivity.a aVar) {
        ((ActivityEmojiStickerSearchBinding) this).f12721a = aVar;
        synchronized (this) {
            this.f12724a |= 32;
        }
        notifyPropertyChanged(nk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ActivityEmojiStickerSearchBinding
    public void m(@Nullable SearchEmojiStickerVM searchEmojiStickerVM) {
        ((ActivityEmojiStickerSearchBinding) this).f12722a = searchEmojiStickerVM;
        synchronized (this) {
            this.f12724a |= 16;
        }
        notifyPropertyChanged(nk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<EmojiStickerAdapter<MultiItemEntity>> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12724a |= 4;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12724a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return q((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12724a |= 2;
        }
        return true;
    }

    public final boolean q(MutableLiveData<String> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12724a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (nk0.p0 == i) {
            m((SearchEmojiStickerVM) obj);
        } else {
            if (nk0.k != i) {
                return false;
            }
            l((SearchEmojiStickerActivity.a) obj);
        }
        return true;
    }

    public ActivityEmojiStickerSearchBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (RecyclerView) objArr[6], (ImageView) objArr[2], (ImageView) objArr[5], (EditText) objArr[4], (TextView) objArr[3]);
        this.f12727a = new a();
        this.f12724a = -1L;
        ((ActivityEmojiStickerSearchBinding) this).f12720a.setTag(null);
        ((ActivityEmojiStickerSearchBinding) this).f12718a.setTag(null);
        this.b.setTag(null);
        ((ActivityEmojiStickerSearchBinding) this).f36083a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f12725a = linearLayout;
        linearLayout.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[1];
        this.f12726a = constraintLayout;
        constraintLayout.setTag(null);
        ((ActivityEmojiStickerSearchBinding) this).f12719a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
