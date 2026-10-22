package com.huachenjie.channel.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.manage_channel.admin.add.AddSubAdminAdapter;
import com.huachenjie.channel.page.manage_channel.admin.add.AddSubAdminDialog;
import com.huachenjie.channel.page.manage_channel.admin.add.AddSubAdminVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLEditText;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelDialogAddSubAdminBindingImpl extends ChannelDialogAddSubAdminBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33139a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7718a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7719a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f7720a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f7721a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f7722a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f7723a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f7724a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f7725a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f7726a;

    @NonNull
    public final ImageView b;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((ChannelDialogAddSubAdminBinding) ChannelDialogAddSubAdminBindingImpl.this).f7717a);
            AddSubAdminVM addSubAdminVM = ((ChannelDialogAddSubAdminBinding) ChannelDialogAddSubAdminBindingImpl.this).f7716a;
            if (addSubAdminVM != null) {
                MutableLiveData<String> mutableLiveDataN = addSubAdminVM.n();
                if (mutableLiveDataN != null) {
                    mutableLiveDataN.setValue(textString);
                }
            }
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AddSubAdminDialog.a f33141a;

        public b a(AddSubAdminDialog.a aVar) {
            this.f33141a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33141a.d(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AddSubAdminDialog.a f33142a;

        public c a(AddSubAdminDialog.a aVar) {
            this.f33142a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33142a.c(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AddSubAdminDialog.a f33143a;

        public d a(AddSubAdminDialog.a aVar) {
            this.f33143a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33143a.e(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33139a = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 6);
        sparseIntArray.put(R.id.tv_member_title, 7);
    }

    public ChannelDialogAddSubAdminBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f7718a, f33139a));
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0059  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        AddSubAdminAdapter value;
        String value2;
        c cVarA;
        b bVarA;
        d dVarA;
        synchronized (this) {
            j = this.f7719a;
            this.f7719a = 0L;
        }
        AddSubAdminVM addSubAdminVM = ((ChannelDialogAddSubAdminBinding) this).f7716a;
        AddSubAdminDialog.a aVar = ((ChannelDialogAddSubAdminBinding) this).f7715a;
        if ((23 & j) != 0) {
            if ((j & 21) != 0) {
                MutableLiveData<String> mutableLiveDataN = addSubAdminVM != null ? addSubAdminVM.n() : null;
                updateLiveDataRegistration(0, mutableLiveDataN);
                value2 = mutableLiveDataN != null ? mutableLiveDataN.getValue() : null;
                z = !TextUtils.isEmpty(value2);
            } else {
                z = false;
                value2 = null;
            }
            if ((j & 22) == 0) {
                value = null;
            } else {
                MutableLiveData<AddSubAdminAdapter> mutableLiveDataL = addSubAdminVM != null ? addSubAdminVM.l() : null;
                updateLiveDataRegistration(1, mutableLiveDataL);
                if (mutableLiveDataL != null) {
                    value = mutableLiveDataL.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            z = false;
            value = null;
            value2 = null;
        }
        long j2 = j & 24;
        if (j2 == 0 || aVar == null) {
            cVarA = null;
            bVarA = null;
            dVarA = null;
        } else {
            d dVar = this.f7726a;
            if (dVar == null) {
                dVar = new d();
                this.f7726a = dVar;
            }
            dVarA = dVar.a(aVar);
            b bVar = this.f7724a;
            if (bVar == null) {
                bVar = new b();
                this.f7724a = bVar;
            }
            bVarA = bVar.a(aVar);
            c cVar = this.f7725a;
            if (cVar == null) {
                cVar = new c();
                this.f7725a = cVar;
            }
            cVarA = cVar.a(aVar);
        }
        if ((j & 21) != 0) {
            TextViewBindingAdapter.setText(((ChannelDialogAddSubAdminBinding) this).f7717a, value2);
            CommonBindingAdapter.l0(this.b, z);
        }
        if ((16 & j) != 0) {
            TextViewBindingAdapter.setTextWatcher(((ChannelDialogAddSubAdminBinding) this).f7717a, null, null, null, this.f7722a);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f7721a, bVarA, null);
            CommonBindingAdapter.q(this.b, cVarA, null);
            CommonBindingAdapter.q(super.b, dVarA, null);
        }
        if ((j & 22) != 0) {
            CommonBindingAdapter.g(this.f7723a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7719a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7719a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelDialogAddSubAdminBinding
    public void l(@Nullable AddSubAdminDialog.a aVar) {
        ((ChannelDialogAddSubAdminBinding) this).f7715a = aVar;
        synchronized (this) {
            this.f7719a |= 8;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelDialogAddSubAdminBinding
    public void m(@Nullable AddSubAdminVM addSubAdminVM) {
        ((ChannelDialogAddSubAdminBinding) this).f7716a = addSubAdminVM;
        synchronized (this) {
            this.f7719a |= 4;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<AddSubAdminAdapter> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7719a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7719a |= 1;
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
            m((AddSubAdminVM) obj);
        } else {
            if (tk0.k != i) {
                return false;
            }
            l((AddSubAdminDialog.a) obj);
        }
        return true;
    }

    public ChannelDialogAddSubAdminBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (BLEditText) objArr[2], (TextView) objArr[7], (TextView) objArr[4], (TextView) objArr[6]);
        this.f7722a = new a();
        this.f7719a = -1L;
        ((ChannelDialogAddSubAdminBinding) this).f7717a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f7720a = frameLayout;
        frameLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f7721a = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[3];
        this.b = imageView2;
        imageView2.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[5];
        this.f7723a = recyclerView;
        recyclerView.setTag(null);
        super.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
