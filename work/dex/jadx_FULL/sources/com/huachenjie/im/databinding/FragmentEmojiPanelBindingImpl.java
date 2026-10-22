package com.huachenjie.im.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.huachenjie.base.adapter.ViewPager2Adapter;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.im.page.emoji.EmojiPanelFragment;
import com.huachenjie.im.page.emoji.EmojiPanelVM;
import com.huachenjie.im.page.emoji.StickerItemAdapter;
import com.zj.adlib.yk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class FragmentEmojiPanelBindingImpl extends FragmentEmojiPanelBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34422a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9691a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9692a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f9693a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9694a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f9695a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f9696a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final ImageView c;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public EmojiPanelFragment.a f34423a;

        public a a(EmojiPanelFragment.a aVar) {
            this.f34423a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34423a.b(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public EmojiPanelFragment.a f34424a;

        public b a(EmojiPanelFragment.a aVar) {
            this.f34424a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34424a.a(view);
        }
    }

    public FragmentEmojiPanelBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f9691a, f34422a));
    }

    /* JADX WARN: Code duplicated, block: B:27:0x005a  */
    /* JADX WARN: Code duplicated, block: B:36:0x0076  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        ViewPager2Adapter value;
        StickerItemAdapter value2;
        a aVarA;
        b bVarA;
        synchronized (this) {
            j = this.f9692a;
            this.f9692a = 0L;
        }
        EmojiPanelVM emojiPanelVM = ((FragmentEmojiPanelBinding) this).f9690a;
        EmojiPanelFragment.a aVar = ((FragmentEmojiPanelBinding) this).f9689a;
        if ((47 & j) != 0) {
            if ((j & 41) != 0) {
                MutableLiveData<Boolean> mutableLiveDataK = emojiPanelVM != null ? emojiPanelVM.k() : null;
                updateLiveDataRegistration(0, mutableLiveDataK);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataK != null ? mutableLiveDataK.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 42) == 0) {
                value2 = null;
            } else {
                MutableLiveData<StickerItemAdapter> mutableLiveDataI = emojiPanelVM != null ? emojiPanelVM.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value2 = mutableLiveDataI.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 44) == 0) {
                value = null;
            } else {
                MutableLiveData<ViewPager2Adapter> mutableLiveDataL = emojiPanelVM != null ? emojiPanelVM.l() : null;
                updateLiveDataRegistration(2, mutableLiveDataL);
                if (mutableLiveDataL != null) {
                    value = mutableLiveDataL.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            zSafeUnbox = false;
            value = null;
            value2 = null;
        }
        long j2 = j & 48;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
            bVarA = null;
        } else {
            b bVar = this.f9696a;
            if (bVar == null) {
                bVar = new b();
                this.f9696a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f9695a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f9695a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if ((j & 42) != 0) {
            CommonBindingAdapter.g(((FragmentEmojiPanelBinding) this).f34421a, value2, false, false);
        }
        if ((44 & j) != 0) {
            CommonBindingAdapter.t(((FragmentEmojiPanelBinding) this).f9688a, value);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f9693a, bVarA, null);
            CommonBindingAdapter.q(this.c, aVarA, null);
        }
        if ((j & 41) != 0) {
            CommonBindingAdapter.l0(this.b, zSafeUnbox);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9692a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9692a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.im.databinding.FragmentEmojiPanelBinding
    public void l(@Nullable EmojiPanelFragment.a aVar) {
        ((FragmentEmojiPanelBinding) this).f9689a = aVar;
        synchronized (this) {
            this.f9692a |= 16;
        }
        notifyPropertyChanged(yk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.im.databinding.FragmentEmojiPanelBinding
    public void m(@Nullable EmojiPanelVM emojiPanelVM) {
        ((FragmentEmojiPanelBinding) this).f9690a = emojiPanelVM;
        synchronized (this) {
            this.f9692a |= 8;
        }
        notifyPropertyChanged(yk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<StickerItemAdapter> mutableLiveData, int i) {
        if (i != yk0.f46050a) {
            return false;
        }
        synchronized (this) {
            this.f9692a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != yk0.f46050a) {
            return false;
        }
        synchronized (this) {
            this.f9692a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return p((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<ViewPager2Adapter> mutableLiveData, int i) {
        if (i != yk0.f46050a) {
            return false;
        }
        synchronized (this) {
            this.f9692a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (yk0.p0 == i) {
            m((EmojiPanelVM) obj);
        } else {
            if (yk0.k != i) {
                return false;
            }
            l((EmojiPanelFragment.a) obj);
        }
        return true;
    }

    public FragmentEmojiPanelBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (RecyclerView) objArr[3], (ViewPager2) objArr[5]);
        this.f9692a = -1L;
        ((FragmentEmojiPanelBinding) this).f34421a.setTag(null);
        ((FragmentEmojiPanelBinding) this).f9688a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f9694a = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f9693a = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[2];
        this.b = imageView2;
        imageView2.setTag(null);
        ImageView imageView3 = (ImageView) objArr[4];
        this.c = imageView3;
        imageView3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
