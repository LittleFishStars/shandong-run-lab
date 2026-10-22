package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.channel.page.home.FlashMessageAdapter;
import com.huachenjie.channel.page.home.FlashMessageFragment;
import com.huachenjie.channel.page.home.FlashMessageVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.noober.background.view.BLView;
import com.zj.adlib.jj8;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelFragmentFlashMessageBindingImpl extends ChannelFragmentFlashMessageBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33166a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7780a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7781a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7782a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f7783a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f7784a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f7785a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f7786a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f7787a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public FlashMessageFragment.a f33167a;

        public a a(FlashMessageFragment.a aVar) {
            this.f33167a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33167a.b(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public FlashMessageFragment.a f33168a;

        public b a(FlashMessageFragment.a aVar) {
            this.f33168a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33168a.c(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public FlashMessageFragment.a f33169a;

        public c a(FlashMessageFragment.a aVar) {
            this.f33169a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33169a.a(view);
        }
    }

    public ChannelFragmentFlashMessageBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f7780a, f33166a));
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0077  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        FlashMessageAdapter value;
        boolean z;
        Integer value2;
        b bVarA;
        c cVarA;
        a aVarA;
        int iSafeUnbox;
        synchronized (this) {
            j = this.f7781a;
            this.f7781a = 0L;
        }
        FlashMessageVM flashMessageVM = ((ChannelFragmentFlashMessageBinding) this).f7779a;
        FlashMessageFragment.a aVar = ((ChannelFragmentFlashMessageBinding) this).f7778a;
        if ((23 & j) != 0) {
            long j2 = j & 21;
            if (j2 != 0) {
                BaseViewModel.b bVarE = flashMessageVM != null ? flashMessageVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataC = bVarE != null ? bVarE.c() : null;
                updateLiveDataRegistration(0, mutableLiveDataC);
                value2 = mutableLiveDataC != null ? mutableLiveDataC.getValue() : null;
                z = ViewDataBinding.safeUnbox(value2) > jj8.a(44.0f);
                if (j2 != 0) {
                    j |= z ? 64L : 32L;
                }
            } else {
                z = false;
                value2 = null;
            }
            if ((j & 22) == 0) {
                value = null;
            } else {
                MutableLiveData<FlashMessageAdapter> mutableLiveDataP = flashMessageVM != null ? flashMessageVM.p() : null;
                updateLiveDataRegistration(1, mutableLiveDataP);
                if (mutableLiveDataP != null) {
                    value = mutableLiveDataP.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            z = false;
            value2 = null;
        }
        long j3 = 24 & j;
        if (j3 == 0 || aVar == null) {
            bVarA = null;
            cVarA = null;
            aVarA = null;
        } else {
            c cVar = this.f7786a;
            if (cVar == null) {
                cVar = new c();
                this.f7786a = cVar;
            }
            cVarA = cVar.a(aVar);
            a aVar2 = this.f7784a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f7784a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            b bVar = this.f7785a;
            if (bVar == null) {
                bVar = new b();
                this.f7785a = bVar;
            }
            bVarA = bVar.a(aVar);
        }
        long j4 = j & 21;
        if (j4 != 0) {
            iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(z ? value2.intValue() : jj8.a(44.0f)));
        } else {
            iSafeUnbox = 0;
        }
        if (j4 != 0) {
            CommonBindingAdapter.G(this.f7787a, iSafeUnbox);
        }
        if ((j & 22) != 0) {
            CommonBindingAdapter.g(this.f7783a, value, false, false);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(((ChannelFragmentFlashMessageBinding) this).f33165a, cVarA, null);
            CommonBindingAdapter.q(this.b, aVarA, null);
            CommonBindingAdapter.q(this.c, bVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7781a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7781a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelFragmentFlashMessageBinding
    public void l(@Nullable FlashMessageFragment.a aVar) {
        ((ChannelFragmentFlashMessageBinding) this).f7778a = aVar;
        synchronized (this) {
            this.f7781a |= 8;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelFragmentFlashMessageBinding
    public void m(@Nullable FlashMessageVM flashMessageVM) {
        ((ChannelFragmentFlashMessageBinding) this).f7779a = flashMessageVM;
        synchronized (this) {
            this.f7781a |= 4;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<FlashMessageAdapter> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7781a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7781a |= 1;
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
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 == i) {
            m((FlashMessageVM) obj);
        } else {
            if (tk0.k != i) {
                return false;
            }
            l((FlashMessageFragment.a) obj);
        }
        return true;
    }

    public ChannelFragmentFlashMessageBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (TextView) objArr[2], (TextView) objArr[3], (TextView) objArr[4]);
        this.f7781a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f7782a = linearLayout;
        linearLayout.setTag(null);
        BLView bLView = (BLView) objArr[1];
        this.f7787a = bLView;
        bLView.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[5];
        this.f7783a = recyclerView;
        recyclerView.setTag(null);
        ((ChannelFragmentFlashMessageBinding) this).f33165a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
