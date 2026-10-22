package com.huachenjie.channel.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.widget.image_pick.ImagePickView;
import com.huachenjie.channel.page.advertise.create.CreateAdvertiseActivity;
import com.huachenjie.channel.page.advertise.create.CreateAdvertiseVM;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.noober.background.view.BLEditText;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelActivityAdvertiseCreateBindingImpl extends ChannelActivityAdvertiseCreateBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33025a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7388a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7389a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7390a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f7391a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f7392a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f7393a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f7394a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7395a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f7396a;
    public InverseBindingListener b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLView f7397b;

    @NonNull
    public final BLView c;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((ChannelActivityAdvertiseCreateBinding) ChannelActivityAdvertiseCreateBindingImpl.this).f7385a);
            CreateAdvertiseVM createAdvertiseVM = ((ChannelActivityAdvertiseCreateBinding) ChannelActivityAdvertiseCreateBindingImpl.this).f7384a;
            if (createAdvertiseVM != null) {
                MutableLiveData<String> mutableLiveDataL = createAdvertiseVM.l();
                if (mutableLiveDataL != null) {
                    mutableLiveDataL.setValue(textString);
                }
            }
        }
    }

    public class b implements InverseBindingListener {
        public b() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((ChannelActivityAdvertiseCreateBinding) ChannelActivityAdvertiseCreateBindingImpl.this).f7387b);
            CreateAdvertiseVM createAdvertiseVM = ((ChannelActivityAdvertiseCreateBinding) ChannelActivityAdvertiseCreateBindingImpl.this).f7384a;
            if (createAdvertiseVM != null) {
                MutableLiveData<String> mutableLiveDataS = createAdvertiseVM.s();
                if (mutableLiveDataS != null) {
                    mutableLiveDataS.setValue(textString);
                }
            }
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CreateAdvertiseActivity.a f33028a;

        public c a(CreateAdvertiseActivity.a aVar) {
            this.f33028a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33028a.b(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CreateAdvertiseActivity.a f33029a;

        public d a(CreateAdvertiseActivity.a aVar) {
            this.f33029a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33029a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(21);
        f7388a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{16}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33025a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.channel.R.id.tv_cover, 17);
        sparseIntArray.put(com.huachenjie.channel.R.id.cover_picker, 18);
        sparseIntArray.put(com.huachenjie.channel.R.id.tv_outside_link, 19);
        sparseIntArray.put(com.huachenjie.channel.R.id.switchBt, 20);
    }

    public ChannelActivityAdvertiseCreateBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 21, f7388a, f33025a));
    }

    /* JADX WARN: Code duplicated, block: B:103:0x014c  */
    /* JADX WARN: Code duplicated, block: B:27:0x0060  */
    /* JADX WARN: Code duplicated, block: B:36:0x007c  */
    /* JADX WARN: Code duplicated, block: B:76:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:85:0x010d  */
    /* JADX WARN: Code duplicated, block: B:94:0x012b  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        boolean z;
        int i;
        boolean z2;
        String str;
        boolean z3;
        String str2;
        BindingTitleBean bindingTitleBean;
        String value2;
        int i2;
        String value3;
        d dVarA;
        c cVarA;
        boolean zSafeUnbox;
        String value4;
        String value5;
        int i3;
        boolean z4;
        boolean zSafeUnbox2;
        BindingTitleBean value6;
        synchronized (this) {
            j = this.f7389a;
            this.f7389a = 0L;
        }
        CreateAdvertiseVM createAdvertiseVM = ((ChannelActivityAdvertiseCreateBinding) this).f7384a;
        CreateAdvertiseActivity.a aVar = ((ChannelActivityAdvertiseCreateBinding) this).f7383a;
        if ((1535 & j) != 0) {
            if ((j & 1281) != 0) {
                MutableLiveData<Boolean> mutableLiveDataK = createAdvertiseVM != null ? createAdvertiseVM.k() : null;
                updateLiveDataRegistration(0, mutableLiveDataK);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataK != null ? mutableLiveDataK.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 1282) == 0) {
                value4 = null;
            } else {
                MutableLiveData<String> mutableLiveDataS = createAdvertiseVM != null ? createAdvertiseVM.s() : null;
                updateLiveDataRegistration(1, mutableLiveDataS);
                if (mutableLiveDataS != null) {
                    value4 = mutableLiveDataS.getValue();
                } else {
                    value4 = null;
                }
            }
            if ((j & 1284) == 0) {
                value5 = null;
            } else {
                MediatorLiveData<String> mediatorLiveDataR = createAdvertiseVM != null ? createAdvertiseVM.r() : null;
                updateLiveDataRegistration(2, mediatorLiveDataR);
                if (mediatorLiveDataR != null) {
                    value5 = mediatorLiveDataR.getValue();
                } else {
                    value5 = null;
                }
            }
            long j2 = j & 1288;
            if (j2 != 0) {
                MutableLiveData<Boolean> mutableLiveDataU = createAdvertiseVM != null ? createAdvertiseVM.u() : null;
                updateLiveDataRegistration(3, mutableLiveDataU);
                boolean zSafeUnbox3 = ViewDataBinding.safeUnbox(mutableLiveDataU != null ? mutableLiveDataU.getValue() : null);
                if (j2 != 0) {
                    j |= zSafeUnbox3 ? PlaybackStateCompat.ACTION_PREPARE : 8192L;
                }
                i2 = zSafeUnbox3 ? -13877680 : -1;
                boolean z5 = !zSafeUnbox3;
                if ((j & 1288) != 0) {
                    j |= z5 ? 4096L : 2048L;
                }
                zSafeUnbox2 = ViewDataBinding.safeUnbox(Boolean.valueOf(z5));
                i3 = z5 ? -13877680 : -1;
                z4 = zSafeUnbox3;
            } else {
                i3 = 0;
                i2 = 0;
                z4 = false;
                zSafeUnbox2 = false;
            }
            if ((j & 1296) == 0) {
                value6 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = createAdvertiseVM != null ? createAdvertiseVM.i() : null;
                updateLiveDataRegistration(4, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value6 = mutableLiveDataI.getValue();
                } else {
                    value6 = null;
                }
            }
            if ((j & 1312) == 0) {
                value3 = null;
            } else {
                MutableLiveData<String> mutableLiveDataL = createAdvertiseVM != null ? createAdvertiseVM.l() : null;
                updateLiveDataRegistration(5, mutableLiveDataL);
                if (mutableLiveDataL != null) {
                    value3 = mutableLiveDataL.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 1344) == 0) {
                value2 = null;
            } else {
                MutableLiveData<String> mutableLiveDataT = createAdvertiseVM != null ? createAdvertiseVM.t() : null;
                updateLiveDataRegistration(6, mutableLiveDataT);
                if (mutableLiveDataT != null) {
                    value2 = mutableLiveDataT.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 1408) == 0) {
                value = null;
            } else {
                MediatorLiveData<String> mediatorLiveDataM = createAdvertiseVM != null ? createAdvertiseVM.m() : null;
                updateLiveDataRegistration(7, mediatorLiveDataM);
                if (mediatorLiveDataM != null) {
                    value = mediatorLiveDataM.getValue();
                } else {
                    value = null;
                }
            }
            str2 = value5;
            bindingTitleBean = value6;
            z2 = z4;
            str = value4;
            i = i3;
            z3 = zSafeUnbox;
            z = zSafeUnbox2;
        } else {
            value = null;
            z = false;
            i = 0;
            z2 = false;
            str = null;
            z3 = false;
            str2 = null;
            bindingTitleBean = null;
            value2 = null;
            i2 = 0;
            value3 = null;
        }
        long j3 = j & 1536;
        if (j3 == 0 || aVar == null) {
            dVarA = null;
            cVarA = null;
        } else {
            d dVar = this.f7393a;
            if (dVar == null) {
                dVar = new d();
                this.f7393a = dVar;
            }
            dVarA = dVar.a(aVar);
            c cVar = this.f7392a;
            if (cVar == null) {
                cVar = new c();
                this.f7392a = cVar;
            }
            cVarA = cVar.a(aVar);
        }
        if ((j & 1288) != 0) {
            CommonBindingAdapter.l0(((ChannelActivityAdvertiseCreateBinding) this).f7385a, z);
            CommonBindingAdapter.l0(((ChannelActivityAdvertiseCreateBinding) this).f7387b, z2);
            CommonBindingAdapter.l0(((ChannelActivityAdvertiseCreateBinding) this).f7386b, z);
            this.f.setTextColor(i2);
            CommonBindingAdapter.l0(this.g, z);
            CommonBindingAdapter.l0(this.f7396a, z2);
            CommonBindingAdapter.l0(this.h, z2);
            this.i.setTextColor(i);
            CommonBindingAdapter.l0(this.f7397b, z);
            CommonBindingAdapter.l0(this.j, z);
            CommonBindingAdapter.l0(this.c, z);
            CommonBindingAdapter.l0(((ChannelActivityAdvertiseCreateBinding) this).f33024a, z);
            CommonBindingAdapter.l0(super.c, z);
            CommonBindingAdapter.l0(this.d, z2);
        }
        if ((j & 1312) != 0) {
            TextViewBindingAdapter.setText(((ChannelActivityAdvertiseCreateBinding) this).f7385a, value3);
        }
        if ((1024 & j) != 0) {
            TextViewBindingAdapter.setTextWatcher(((ChannelActivityAdvertiseCreateBinding) this).f7385a, null, null, null, this.f7391a);
            TextViewBindingAdapter.setTextWatcher(((ChannelActivityAdvertiseCreateBinding) this).f7387b, null, null, null, this.b);
        }
        if ((j & 1282) != 0) {
            TextViewBindingAdapter.setText(((ChannelActivityAdvertiseCreateBinding) this).f7387b, str);
        }
        if ((1296 & j) != 0) {
            this.f7394a.k(bindingTitleBean);
        }
        if ((1284 & j) != 0) {
            TextViewBindingAdapter.setText(this.g, str2);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.h, dVarA, null);
            CommonBindingAdapter.q(this.f7395a, cVarA, null);
        }
        if ((j & 1281) != 0) {
            CommonBindingAdapter.e0(this.f7395a, z3);
        }
        if ((1344 & j) != 0) {
            TextViewBindingAdapter.setText(this.f7395a, value2);
        }
        if ((j & 1408) != 0) {
            TextViewBindingAdapter.setText(this.j, value);
        }
        ViewDataBinding.executeBindingsOn(this.f7394a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7389a != 0) {
                return true;
            }
            return this.f7394a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7389a = 1024L;
        }
        this.f7394a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityAdvertiseCreateBinding
    public void l(@Nullable CreateAdvertiseActivity.a aVar) {
        ((ChannelActivityAdvertiseCreateBinding) this).f7383a = aVar;
        synchronized (this) {
            this.f7389a |= 512;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityAdvertiseCreateBinding
    public void m(@Nullable CreateAdvertiseVM createAdvertiseVM) {
        ((ChannelActivityAdvertiseCreateBinding) this).f7384a = createAdvertiseVM;
        synchronized (this) {
            this.f7389a |= 256;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7389a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7389a |= 32;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return n((MutableLiveData) obj, i2);
            case 1:
                return r((MutableLiveData) obj, i2);
            case 2:
                return q((MediatorLiveData) obj, i2);
            case 3:
                return u((MutableLiveData) obj, i2);
            case 4:
                return t((MutableLiveData) obj, i2);
            case 5:
                return o((MutableLiveData) obj, i2);
            case 6:
                return s((MutableLiveData) obj, i2);
            case 7:
                return p((MediatorLiveData) obj, i2);
            default:
                return false;
        }
    }

    public final boolean p(MediatorLiveData<String> mediatorLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7389a |= 128;
        }
        return true;
    }

    public final boolean q(MediatorLiveData<String> mediatorLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7389a |= 4;
        }
        return true;
    }

    public final boolean r(MutableLiveData<String> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7389a |= 2;
        }
        return true;
    }

    public final boolean s(MutableLiveData<String> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7389a |= 64;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f7394a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 == i) {
            m((CreateAdvertiseVM) obj);
        } else {
            if (tk0.k != i) {
                return false;
            }
            l((CreateAdvertiseActivity.a) obj);
        }
        return true;
    }

    public final boolean t(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7389a |= 16;
        }
        return true;
    }

    public final boolean u(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7389a |= 8;
        }
        return true;
    }

    public ChannelActivityAdvertiseCreateBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 8, (ImagePickView) objArr[18], (BLEditText) objArr[5], (BLEditText) objArr[14], (ImagePickView) objArr[9], (SwitchCompat) objArr[20], (TextView) objArr[3], (TextView) objArr[17], (TextView) objArr[7], (TextView) objArr[11], (TextView) objArr[19]);
        this.f7391a = new a();
        this.b = new b();
        this.f7389a = -1L;
        ((ChannelActivityAdvertiseCreateBinding) this).f7385a.setTag(null);
        ((ChannelActivityAdvertiseCreateBinding) this).f7387b.setTag(null);
        ((ChannelActivityAdvertiseCreateBinding) this).f7386b.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[16];
        this.f7394a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f7390a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[10];
        this.g = textView2;
        textView2.setTag(null);
        BLView bLView = (BLView) objArr[12];
        this.f7396a = bLView;
        bLView.setTag(null);
        TextView textView3 = (TextView) objArr[13];
        this.h = textView3;
        textView3.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[15];
        this.f7395a = bLTextView;
        bLTextView.setTag(null);
        TextView textView4 = (TextView) objArr[2];
        this.i = textView4;
        textView4.setTag(null);
        BLView bLView2 = (BLView) objArr[4];
        this.f7397b = bLView2;
        bLView2.setTag(null);
        TextView textView5 = (TextView) objArr[6];
        this.j = textView5;
        textView5.setTag(null);
        BLView bLView3 = (BLView) objArr[8];
        this.c = bLView3;
        bLView3.setTag(null);
        ((ChannelActivityAdvertiseCreateBinding) this).f33024a.setTag(null);
        super.c.setTag(null);
        this.d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
