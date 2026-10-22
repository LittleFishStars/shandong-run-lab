package com.huachenjie.im.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.im.R;
import com.huachenjie.im.custom.ShareGoodsAttachment;
import com.huachenjie.im.page.SingleChatFragment;
import com.huachenjie.im.vm.SingleChatVM;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.yk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class FragmentSingleChatBindingImpl extends FragmentSingleChatBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34440a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9746a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9747a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final View f9748a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9749a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9750a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f9751a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f9752a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f9753a;

    @NonNull
    public final TextView b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SingleChatFragment.k f34441a;

        public a a(SingleChatFragment.k kVar) {
            this.f34441a = kVar;
            if (kVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34441a.c(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SingleChatFragment.k f34442a;

        public b a(SingleChatFragment.k kVar) {
            this.f34442a = kVar;
            if (kVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34442a.b(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34440a = sparseIntArray;
        sparseIntArray.put(R.id.flContainer, 5);
        sparseIntArray.put(R.id.single_chat_recycler, 6);
        sparseIntArray.put(R.id.input_panel_container, 7);
    }

    public FragmentSingleChatBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f9746a, f34440a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        a aVarA;
        b bVarA;
        synchronized (this) {
            j = this.f9747a;
            this.f9747a = 0L;
        }
        SingleChatVM singleChatVM = ((FragmentSingleChatBinding) this).f9745a;
        SingleChatFragment.k kVar = ((FragmentSingleChatBinding) this).f9744a;
        boolean z2 = false;
        if ((23 & j) != 0) {
            if ((j & 21) != 0) {
                MutableLiveData<String> mutableLiveData = singleChatVM != null ? singleChatVM.r : null;
                updateLiveDataRegistration(0, mutableLiveData);
                z = !TextUtils.isEmpty(mutableLiveData != null ? mutableLiveData.getValue() : null);
            } else {
                z = false;
            }
            if ((j & 22) != 0) {
                MutableLiveData<ShareGoodsAttachment> mutableLiveData2 = singleChatVM != null ? singleChatVM.s : null;
                updateLiveDataRegistration(1, mutableLiveData2);
                if ((mutableLiveData2 != null ? mutableLiveData2.getValue() : null) != null) {
                    z2 = true;
                }
            }
        } else {
            z = false;
        }
        long j2 = 24 & j;
        if (j2 == 0 || kVar == null) {
            aVarA = null;
            bVarA = null;
        } else {
            b bVar = this.f9752a;
            if (bVar == null) {
                bVar = new b();
                this.f9752a = bVar;
            }
            bVarA = bVar.a(kVar);
            a aVar = this.f9751a;
            if (aVar == null) {
                aVar = new a();
                this.f9751a = aVar;
            }
            aVarA = aVar.a(kVar);
        }
        if ((21 & j) != 0) {
            CommonBindingAdapter.l0(this.f9753a, z);
        }
        if ((j & 22) != 0) {
            CommonBindingAdapter.l0(this.f9750a, z2);
            CommonBindingAdapter.l0(this.f9748a, z2);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f9750a, bVarA, null);
            CommonBindingAdapter.q(this.b, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9747a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9747a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.im.databinding.FragmentSingleChatBinding
    public void l(@Nullable SingleChatFragment.k kVar) {
        ((FragmentSingleChatBinding) this).f9744a = kVar;
        synchronized (this) {
            this.f9747a |= 8;
        }
        notifyPropertyChanged(yk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.im.databinding.FragmentSingleChatBinding
    public void m(@Nullable SingleChatVM singleChatVM) {
        ((FragmentSingleChatBinding) this).f9745a = singleChatVM;
        synchronized (this) {
            this.f9747a |= 4;
        }
        notifyPropertyChanged(yk0.L);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<ShareGoodsAttachment> mutableLiveData, int i) {
        if (i != yk0.f46050a) {
            return false;
        }
        synchronized (this) {
            this.f9747a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != yk0.f46050a) {
            return false;
        }
        synchronized (this) {
            this.f9747a |= 1;
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
        if (yk0.L == i) {
            m((SingleChatVM) obj);
        } else {
            if (yk0.k != i) {
                return false;
            }
            l((SingleChatFragment.k) obj);
        }
        return true;
    }

    public FragmentSingleChatBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (FrameLayout) objArr[5], (FrameLayout) objArr[7], (RecyclerView) objArr[6]);
        this.f9747a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f9749a = linearLayout;
        linearLayout.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[1];
        this.f9753a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f9750a = textView;
        textView.setTag(null);
        View view2 = (View) objArr[3];
        this.f9748a = view2;
        view2.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.b = textView2;
        textView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
