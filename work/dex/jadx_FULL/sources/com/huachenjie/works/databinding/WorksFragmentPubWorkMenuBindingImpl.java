package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.ViewStubProxy;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.works.R;
import com.huachenjie.works.adapter.publish.BasePubWorkMenuAdapter;
import com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment;
import com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuModel;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksFragmentPubWorkMenuBindingImpl extends WorksFragmentPubWorkMenuBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36935a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14279a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14280a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14281a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f14282a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f14283a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f14284a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f14285a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final ImageView c;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((WorksFragmentPubWorkMenuBinding) WorksFragmentPubWorkMenuBindingImpl.this).f36934a);
            BasePubWorkMenuModel basePubWorkMenuModel = ((WorksFragmentPubWorkMenuBinding) WorksFragmentPubWorkMenuBindingImpl.this).f14278a;
            if (basePubWorkMenuModel != null) {
                MutableLiveData<String> mutableLiveDataH = basePubWorkMenuModel.H();
                if (mutableLiveDataH != null) {
                    mutableLiveDataH.setValue(textString);
                }
            }
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BasePubWorkMenuFragment f36937a;

        public b a(BasePubWorkMenuFragment value) {
            this.f36937a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36937a.onDismissDialog(arg0);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BasePubWorkMenuFragment f36938a;

        public c a(BasePubWorkMenuFragment value) {
            this.f36938a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36938a.onClearInput(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36935a = sparseIntArray;
        sparseIntArray.put(R.id.vs_placeholder1, 7);
        sparseIntArray.put(R.id.vs_placeholder2, 8);
        sparseIntArray.put(R.id.state_layout, 9);
    }

    public WorksFragmentPubWorkMenuBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 10, f14279a, f36935a));
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0064  */
    /* JADX WARN: Code duplicated, block: B:36:0x0082  */
    /* JADX WARN: Code duplicated, block: B:66:0x00d7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:68:0x00de  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ec  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        b bVarA;
        c cVarA;
        BasePubWorkMenuAdapter<?, ?> value;
        String value2;
        String value3;
        int iSafeUnbox;
        String value4;
        boolean z;
        MutableLiveData<BasePubWorkMenuAdapter<?, ?>> mutableLiveDataB;
        synchronized (this) {
            j = this.f14280a;
            this.f14280a = 0L;
        }
        BasePubWorkMenuFragment basePubWorkMenuFragment = ((WorksFragmentPubWorkMenuBinding) this).f14277a;
        BasePubWorkMenuModel basePubWorkMenuModel = ((WorksFragmentPubWorkMenuBinding) this).f14278a;
        long j2 = 160 & j;
        if (j2 == 0 || basePubWorkMenuFragment == null) {
            bVarA = null;
            cVarA = null;
        } else {
            c cVar = this.f14284a;
            if (cVar == null) {
                cVar = new c();
                this.f14284a = cVar;
            }
            cVarA = cVar.a(basePubWorkMenuFragment);
            b bVar = this.f14283a;
            if (bVar == null) {
                bVar = new b();
                this.f14283a = bVar;
            }
            bVarA = bVar.a(basePubWorkMenuFragment);
        }
        if ((223 & j) != 0) {
            if ((j & 193) == 0) {
                value3 = null;
            } else {
                MutableLiveData<String> mutableLiveDataF = basePubWorkMenuModel != null ? basePubWorkMenuModel.F() : null;
                updateLiveDataRegistration(0, mutableLiveDataF);
                if (mutableLiveDataF != null) {
                    value3 = mutableLiveDataF.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 194) == 0) {
                value2 = null;
            } else {
                MutableLiveData<String> mutableLiveDataD = basePubWorkMenuModel != null ? basePubWorkMenuModel.D() : null;
                updateLiveDataRegistration(1, mutableLiveDataD);
                if (mutableLiveDataD != null) {
                    value2 = mutableLiveDataD.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 196) != 0) {
                MutableLiveData<Integer> mutableLiveDataG = basePubWorkMenuModel != null ? basePubWorkMenuModel.G() : null;
                updateLiveDataRegistration(2, mutableLiveDataG);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataG != null ? mutableLiveDataG.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            if ((j & 200) != 0) {
                MutableLiveData<String> mutableLiveDataH = basePubWorkMenuModel != null ? basePubWorkMenuModel.H() : null;
                updateLiveDataRegistration(3, mutableLiveDataH);
                value4 = mutableLiveDataH != null ? mutableLiveDataH.getValue() : null;
                z = (value4 != null ? value4.length() : 0) > 0;
                if ((j & 208) == 0) {
                    value = null;
                } else {
                    if (basePubWorkMenuModel != null) {
                        mutableLiveDataB = basePubWorkMenuModel.B();
                    } else {
                        mutableLiveDataB = null;
                    }
                    updateLiveDataRegistration(4, mutableLiveDataB);
                    if (mutableLiveDataB != null) {
                        value = mutableLiveDataB.getValue();
                    } else {
                        value = null;
                    }
                }
            } else {
                value4 = null;
            }
            if ((j & 208) == 0) {
                value = null;
            } else {
                if (basePubWorkMenuModel != null) {
                    mutableLiveDataB = basePubWorkMenuModel.B();
                } else {
                    mutableLiveDataB = null;
                }
                updateLiveDataRegistration(4, mutableLiveDataB);
                if (mutableLiveDataB != null) {
                    value = mutableLiveDataB.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
            value3 = null;
            iSafeUnbox = 0;
            value4 = null;
            z = false;
        }
        if ((j & 193) != 0) {
            ((WorksFragmentPubWorkMenuBinding) this).f36934a.setHint(value3);
        }
        if ((j & 200) != 0) {
            TextViewBindingAdapter.setText(((WorksFragmentPubWorkMenuBinding) this).f36934a, value4);
            CommonBindingAdapter.l0(this.c, z);
        }
        if ((128 & j) != 0) {
            TextViewBindingAdapter.setTextWatcher(((WorksFragmentPubWorkMenuBinding) this).f36934a, null, null, null, this.f14282a);
            CommonBindingAdapter.I(this.f14285a, 0, 44, 0, 0, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f14281a, bVarA, null);
            CommonBindingAdapter.q(this.c, cVarA, null);
        }
        if ((196 & j) != 0) {
            CommonBindingAdapter.S(this.b, iSafeUnbox);
        }
        if ((208 & j) != 0) {
            CommonBindingAdapter.g(((WorksFragmentPubWorkMenuBinding) this).f14275a, value, false, false);
        }
        if ((j & 194) != 0) {
            TextViewBindingAdapter.setText(((WorksFragmentPubWorkMenuBinding) this).f14273a, value2);
        }
        if (((WorksFragmentPubWorkMenuBinding) this).f14274a.getBinding() != null) {
            ViewDataBinding.executeBindingsOn(((WorksFragmentPubWorkMenuBinding) this).f14274a.getBinding());
        }
        if (super.b.getBinding() != null) {
            ViewDataBinding.executeBindingsOn(super.b.getBinding());
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14280a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14280a = 128L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentPubWorkMenuBinding
    public void l(@Nullable BasePubWorkMenuFragment Fragment) {
        ((WorksFragmentPubWorkMenuBinding) this).f14277a = Fragment;
        synchronized (this) {
            this.f14280a |= 32;
        }
        notifyPropertyChanged(qk0.s);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentPubWorkMenuBinding
    public void m(@Nullable BasePubWorkMenuModel Vm) {
        ((WorksFragmentPubWorkMenuBinding) this).f14278a = Vm;
        synchronized (this) {
            this.f14280a |= 64;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData VmAdapter, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14280a |= 16;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> VmMenuName, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14280a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return p((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return o((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 2) {
            return q((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 3) {
            return r((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 4) {
            return false;
        }
        return n((MutableLiveData) object, fieldId);
    }

    public final boolean p(MutableLiveData<String> VmSearchHint, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14280a |= 1;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Integer> VmSearchIcon, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14280a |= 4;
        }
        return true;
    }

    public final boolean r(MutableLiveData<String> VmSearchValue, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14280a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.s == variableId) {
            l((BasePubWorkMenuFragment) variable);
        } else {
            if (qk0.p0 != variableId) {
                return false;
            }
            m((BasePubWorkMenuModel) variable);
        }
        return true;
    }

    public WorksFragmentPubWorkMenuBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5, (EditText) bindings[4], (RecyclerView) bindings[6], (StateLayout) bindings[9], (TextView) bindings[2], new ViewStubProxy((ViewStub) bindings[7]), new ViewStubProxy((ViewStub) bindings[8]));
        this.f14282a = new a();
        this.f14280a = -1L;
        ((WorksFragmentPubWorkMenuBinding) this).f36934a.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) bindings[0];
        this.f14285a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.f14281a = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) bindings[3];
        this.b = imageView2;
        imageView2.setTag(null);
        ImageView imageView3 = (ImageView) bindings[5];
        this.c = imageView3;
        imageView3.setTag(null);
        ((WorksFragmentPubWorkMenuBinding) this).f14275a.setTag(null);
        ((WorksFragmentPubWorkMenuBinding) this).f14273a.setTag(null);
        ((WorksFragmentPubWorkMenuBinding) this).f14274a.setContainingBinding(this);
        super.b.setContainingBinding(this);
        setRootTag(root);
        invalidateAll();
    }
}
