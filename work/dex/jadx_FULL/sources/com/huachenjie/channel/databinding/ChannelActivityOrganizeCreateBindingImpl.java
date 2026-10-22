package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.widget.image_pick.ImagePickView;
import com.huachenjie.channel.page.organize.create.CreateOrganizeActivity;
import com.huachenjie.channel.page.organize.create.CreateOrganizeVM;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.noober.background.view.BLEditText;
import com.noober.background.view.BLTextView;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelActivityOrganizeCreateBindingImpl extends ChannelActivityOrganizeCreateBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33110a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7642a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7643a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7644a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f7645a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f7646a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f7647a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7648a;
    public InverseBindingListener b;

    @NonNull
    public final TextView d;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((ChannelActivityOrganizeCreateBinding) ChannelActivityOrganizeCreateBindingImpl.this).f7640a);
            CreateOrganizeVM createOrganizeVM = ((ChannelActivityOrganizeCreateBinding) ChannelActivityOrganizeCreateBindingImpl.this).f7639a;
            if (createOrganizeVM != null) {
                MutableLiveData<String> mutableLiveDataM = createOrganizeVM.m();
                if (mutableLiveDataM != null) {
                    mutableLiveDataM.setValue(textString);
                }
            }
        }
    }

    public class b implements InverseBindingListener {
        public b() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((ChannelActivityOrganizeCreateBinding) ChannelActivityOrganizeCreateBindingImpl.this).f7641b);
            CreateOrganizeVM createOrganizeVM = ((ChannelActivityOrganizeCreateBinding) ChannelActivityOrganizeCreateBindingImpl.this).f7639a;
            if (createOrganizeVM != null) {
                MutableLiveData<String> mutableLiveDataR = createOrganizeVM.r();
                if (mutableLiveDataR != null) {
                    mutableLiveDataR.setValue(textString);
                }
            }
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CreateOrganizeActivity.a f33113a;

        public c a(CreateOrganizeActivity.a aVar) {
            this.f33113a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33113a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(10);
        f7642a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{5}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33110a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.channel.R.id.tv_name, 6);
        sparseIntArray.put(com.huachenjie.channel.R.id.tv_cover, 7);
        sparseIntArray.put(com.huachenjie.channel.R.id.cover_picker, 8);
        sparseIntArray.put(com.huachenjie.channel.R.id.tv_content, 9);
    }

    public ChannelActivityOrganizeCreateBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, f7642a, f33110a));
    }

    /* JADX WARN: Code duplicated, block: B:26:0x005b  */
    /* JADX WARN: Code duplicated, block: B:35:0x0077  */
    /* JADX WARN: Code duplicated, block: B:44:0x0093  */
    /* JADX WARN: Code duplicated, block: B:53:0x00af  */
    /* JADX WARN: Code duplicated, block: B:62:0x00cd  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        BindingTitleBean value2;
        String value3;
        String value4;
        String value5;
        c cVarA;
        synchronized (this) {
            j = this.f7643a;
            this.f7643a = 0L;
        }
        CreateOrganizeVM createOrganizeVM = ((ChannelActivityOrganizeCreateBinding) this).f7639a;
        CreateOrganizeActivity.a aVar = ((ChannelActivityOrganizeCreateBinding) this).f7638a;
        boolean zSafeUnbox = false;
        if ((383 & j) != 0) {
            if ((j & 321) != 0) {
                MutableLiveData<Boolean> mutableLiveDataL = createOrganizeVM != null ? createOrganizeVM.l() : null;
                updateLiveDataRegistration(0, mutableLiveDataL);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataL != null ? mutableLiveDataL.getValue() : null);
            }
            if ((j & 322) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = createOrganizeVM != null ? createOrganizeVM.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value2 = mutableLiveDataI.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 324) == 0) {
                value5 = null;
            } else {
                MutableLiveData<String> mutableLiveDataM = createOrganizeVM != null ? createOrganizeVM.m() : null;
                updateLiveDataRegistration(2, mutableLiveDataM);
                if (mutableLiveDataM != null) {
                    value5 = mutableLiveDataM.getValue();
                } else {
                    value5 = null;
                }
            }
            if ((j & 328) == 0) {
                value3 = null;
            } else {
                MutableLiveData<String> mutableLiveDataS = createOrganizeVM != null ? createOrganizeVM.s() : null;
                updateLiveDataRegistration(3, mutableLiveDataS);
                if (mutableLiveDataS != null) {
                    value3 = mutableLiveDataS.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 336) == 0) {
                value4 = null;
            } else {
                MediatorLiveData<String> mediatorLiveDataN = createOrganizeVM != null ? createOrganizeVM.n() : null;
                updateLiveDataRegistration(4, mediatorLiveDataN);
                if (mediatorLiveDataN != null) {
                    value4 = mediatorLiveDataN.getValue();
                } else {
                    value4 = null;
                }
            }
            if ((j & 352) == 0) {
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataR = createOrganizeVM != null ? createOrganizeVM.r() : null;
                updateLiveDataRegistration(5, mutableLiveDataR);
                if (mutableLiveDataR != null) {
                    value = mutableLiveDataR.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
            value3 = null;
            value4 = null;
            value5 = null;
        }
        long j2 = j & 384;
        if (j2 == 0 || aVar == null) {
            cVarA = null;
        } else {
            c cVar = this.f7646a;
            if (cVar == null) {
                cVar = new c();
                this.f7646a = cVar;
            }
            cVarA = cVar.a(aVar);
        }
        if ((j & 324) != 0) {
            TextViewBindingAdapter.setText(((ChannelActivityOrganizeCreateBinding) this).f7640a, value5);
        }
        if ((256 & j) != 0) {
            TextViewBindingAdapter.setTextWatcher(((ChannelActivityOrganizeCreateBinding) this).f7640a, null, null, null, this.f7645a);
            TextViewBindingAdapter.setTextWatcher(((ChannelActivityOrganizeCreateBinding) this).f7641b, null, null, null, this.b);
        }
        if ((352 & j) != 0) {
            TextViewBindingAdapter.setText(((ChannelActivityOrganizeCreateBinding) this).f7641b, value);
        }
        if ((322 & j) != 0) {
            this.f7647a.k(value2);
        }
        if ((336 & j) != 0) {
            TextViewBindingAdapter.setText(this.d, value4);
        }
        if ((j & 321) != 0) {
            CommonBindingAdapter.e0(this.f7648a, zSafeUnbox);
        }
        if ((j & 328) != 0) {
            TextViewBindingAdapter.setText(this.f7648a, value3);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f7648a, cVarA, null);
        }
        ViewDataBinding.executeBindingsOn(this.f7647a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7643a != 0) {
                return true;
            }
            return this.f7647a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7643a = 256L;
        }
        this.f7647a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityOrganizeCreateBinding
    public void l(@Nullable CreateOrganizeActivity.a aVar) {
        ((ChannelActivityOrganizeCreateBinding) this).f7638a = aVar;
        synchronized (this) {
            this.f7643a |= 128;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityOrganizeCreateBinding
    public void m(@Nullable CreateOrganizeVM createOrganizeVM) {
        ((ChannelActivityOrganizeCreateBinding) this).f7639a = createOrganizeVM;
        synchronized (this) {
            this.f7643a |= 64;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7643a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7643a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return s((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 3) {
            return r((MutableLiveData) obj, i2);
        }
        if (i == 4) {
            return p((MediatorLiveData) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return q((MutableLiveData) obj, i2);
    }

    public final boolean p(MediatorLiveData<String> mediatorLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7643a |= 16;
        }
        return true;
    }

    public final boolean q(MutableLiveData<String> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7643a |= 32;
        }
        return true;
    }

    public final boolean r(MutableLiveData<String> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7643a |= 8;
        }
        return true;
    }

    public final boolean s(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7643a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f7647a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 == i) {
            m((CreateOrganizeVM) obj);
        } else {
            if (tk0.k != i) {
                return false;
            }
            l((CreateOrganizeActivity.a) obj);
        }
        return true;
    }

    public ChannelActivityOrganizeCreateBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (ImagePickView) objArr[8], (BLEditText) objArr[2], (BLEditText) objArr[1], (TextView) objArr[9], (TextView) objArr[7], (TextView) objArr[6]);
        this.f7645a = new a();
        this.b = new b();
        this.f7643a = -1L;
        ((ChannelActivityOrganizeCreateBinding) this).f7640a.setTag(null);
        ((ChannelActivityOrganizeCreateBinding) this).f7641b.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[5];
        this.f7647a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f7644a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.d = textView;
        textView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[4];
        this.f7648a = bLTextView;
        bLTextView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
