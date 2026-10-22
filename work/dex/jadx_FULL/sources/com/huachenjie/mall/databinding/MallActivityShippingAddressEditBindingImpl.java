package com.huachenjie.mall.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.mall.page.address.edit.ShippingAddressEditActivity;
import com.huachenjie.mall.page.address.edit.ShippingAddressEditVM;
import com.noober.background.view.BLConstraintLayout;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallActivityShippingAddressEditBindingImpl extends MallActivityShippingAddressEditBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34864a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10425a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10426a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10427a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f10428a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f10429a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f10430a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f10431a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f f10432a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g f10433a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public InverseBindingListener f10434b;
    public InverseBindingListener c;

    @NonNull
    public final TextView e;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((MallActivityShippingAddressEditBinding) MallActivityShippingAddressEditBindingImpl.this).f10412a);
            ShippingAddressEditVM shippingAddressEditVM = ((MallActivityShippingAddressEditBinding) MallActivityShippingAddressEditBindingImpl.this).f10418a;
            if (shippingAddressEditVM != null) {
                MutableLiveData<String> mutableLiveDataO = shippingAddressEditVM.o();
                if (mutableLiveDataO != null) {
                    mutableLiveDataO.setValue(textString);
                }
            }
        }
    }

    public class b implements InverseBindingListener {
        public b() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((MallActivityShippingAddressEditBinding) MallActivityShippingAddressEditBindingImpl.this).f10420b);
            ShippingAddressEditVM shippingAddressEditVM = ((MallActivityShippingAddressEditBinding) MallActivityShippingAddressEditBindingImpl.this).f10418a;
            if (shippingAddressEditVM != null) {
                MutableLiveData<String> mutableLiveDataQ = shippingAddressEditVM.q();
                if (mutableLiveDataQ != null) {
                    mutableLiveDataQ.setValue(textString);
                }
            }
        }
    }

    public class c implements InverseBindingListener {
        public c() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((MallActivityShippingAddressEditBinding) MallActivityShippingAddressEditBindingImpl.this).f10422c);
            ShippingAddressEditVM shippingAddressEditVM = ((MallActivityShippingAddressEditBinding) MallActivityShippingAddressEditBindingImpl.this).f10418a;
            if (shippingAddressEditVM != null) {
                MutableLiveData<String> mutableLiveDataR = shippingAddressEditVM.r();
                if (mutableLiveDataR != null) {
                    mutableLiveDataR.setValue(textString);
                }
            }
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ShippingAddressEditActivity.a f34868a;

        public d a(ShippingAddressEditActivity.a aVar) {
            this.f34868a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34868a.a(view);
        }
    }

    public static class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ShippingAddressEditActivity.a f34869a;

        public e a(ShippingAddressEditActivity.a aVar) {
            this.f34869a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34869a.c(view);
        }
    }

    public static class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ShippingAddressEditActivity.a f34870a;

        public f a(ShippingAddressEditActivity.a aVar) {
            this.f34870a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34870a.d(view);
        }
    }

    public static class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ShippingAddressEditActivity.a f34871a;

        public g a(ShippingAddressEditActivity.a aVar) {
            this.f34871a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34871a.b(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(19);
        f10425a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{8}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34864a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.mall.R.id.vContainer, 9);
        sparseIntArray.put(com.huachenjie.mall.R.id.tvName, 10);
        sparseIntArray.put(com.huachenjie.mall.R.id.splitLineName, 11);
        sparseIntArray.put(com.huachenjie.mall.R.id.splitLinePhone, 12);
        sparseIntArray.put(com.huachenjie.mall.R.id.tvAddress, 13);
        sparseIntArray.put(com.huachenjie.mall.R.id.splitLineAddress, 14);
        sparseIntArray.put(com.huachenjie.mall.R.id.splitLineAddressStreet, 15);
        sparseIntArray.put(com.huachenjie.mall.R.id.switchBt, 16);
        sparseIntArray.put(com.huachenjie.mall.R.id.tvDefaultAddress, 17);
        sparseIntArray.put(com.huachenjie.mall.R.id.fl_bottom, 18);
    }

    public MallActivityShippingAddressEditBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 19, f10425a, f34864a));
    }

    /* JADX WARN: Code duplicated, block: B:118:0x01b9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:120:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:122:0x01bf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:123:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:124:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:125:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:128:0x01d2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:129:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:130:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:133:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:135:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:138:0x01fa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:140:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:142:0x0200 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:143:0x0202  */
    /* JADX WARN: Code duplicated, block: B:144:0x0205  */
    /* JADX WARN: Code duplicated, block: B:145:0x020a  */
    /* JADX WARN: Code duplicated, block: B:148:0x0213 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:149:0x0215  */
    /* JADX WARN: Code duplicated, block: B:150:0x021a  */
    /* JADX WARN: Code duplicated, block: B:153:0x0222  */
    /* JADX WARN: Code duplicated, block: B:157:0x023c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:158:0x023e  */
    /* JADX WARN: Code duplicated, block: B:159:0x0241  */
    /* JADX WARN: Code duplicated, block: B:161:0x0246  */
    /* JADX WARN: Code duplicated, block: B:164:0x024f  */
    /* JADX WARN: Code duplicated, block: B:165:0x0257  */
    /* JADX WARN: Code duplicated, block: B:168:0x025f  */
    /* JADX WARN: Code duplicated, block: B:171:0x027d  */
    /* JADX WARN: Code duplicated, block: B:174:0x028e  */
    /* JADX WARN: Code duplicated, block: B:177:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:180:0x02be  */
    /* JADX WARN: Code duplicated, block: B:182:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:185:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:42:0x009a  */
    /* JADX WARN: Code duplicated, block: B:55:0x00c0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:56:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:57:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:60:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:62:0x00dc  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        MutableLiveData<String> mutableLiveDataO;
        String value;
        BindingTitleBean value2;
        MutableLiveData<String> mutableLiveDataK;
        String value3;
        MutableLiveData<String> mutableLiveDataR;
        String value4;
        boolean z;
        String value5;
        boolean z2;
        f fVarA;
        d dVar;
        e eVar;
        g gVarA;
        boolean z3;
        MutableLiveData<String> mutableLiveData;
        boolean z4;
        long j2;
        boolean z5;
        long j3;
        String str;
        boolean z6;
        long j4;
        boolean z7;
        boolean z8;
        MutableLiveData<String> mutableLiveDataO2;
        MutableLiveData<String> mutableLiveDataK2;
        synchronized (this) {
            j = this.f10426a;
            this.f10426a = 0L;
        }
        ShippingAddressEditVM shippingAddressEditVM = ((MallActivityShippingAddressEditBinding) this).f10418a;
        ShippingAddressEditActivity.a aVar = ((MallActivityShippingAddressEditBinding) this).f10417a;
        if ((379 & j) != 0) {
            long j5 = j & 371;
            if (j5 != 0) {
                MutableLiveData<String> mutableLiveDataQ = shippingAddressEditVM != null ? shippingAddressEditVM.q() : null;
                updateLiveDataRegistration(0, mutableLiveDataQ);
                value = mutableLiveDataQ != null ? mutableLiveDataQ.getValue() : null;
                z = !TextUtils.isEmpty(value);
                if (j5 != 0) {
                    j = z ? j | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : j | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                }
            } else {
                z = false;
                value = null;
            }
            if ((j & 322) != 0) {
                mutableLiveDataO = shippingAddressEditVM != null ? shippingAddressEditVM.o() : null;
                updateLiveDataRegistration(1, mutableLiveDataO);
                value5 = mutableLiveDataO != null ? mutableLiveDataO.getValue() : null;
                z2 = !TextUtils.isEmpty(value5);
            } else {
                z2 = false;
                mutableLiveDataO = null;
                value5 = null;
            }
            if ((j & 328) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = shippingAddressEditVM != null ? shippingAddressEditVM.i() : null;
                updateLiveDataRegistration(3, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value2 = mutableLiveDataI.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 336) != 0) {
                mutableLiveDataR = shippingAddressEditVM != null ? shippingAddressEditVM.r() : null;
                updateLiveDataRegistration(4, mutableLiveDataR);
                value4 = mutableLiveDataR != null ? mutableLiveDataR.getValue() : null;
                if ((j & 352) != 0) {
                    if (shippingAddressEditVM != null) {
                        mutableLiveDataK = shippingAddressEditVM.k();
                    } else {
                        mutableLiveDataK = null;
                    }
                    updateLiveDataRegistration(5, mutableLiveDataK);
                    if (mutableLiveDataK != null) {
                        value3 = mutableLiveDataK.getValue();
                        z = z;
                    }
                } else {
                    mutableLiveDataK = null;
                }
                value3 = null;
            } else {
                mutableLiveDataR = null;
            }
            if ((j & 352) != 0) {
                if (shippingAddressEditVM != null) {
                    mutableLiveDataK = shippingAddressEditVM.k();
                } else {
                    mutableLiveDataK = null;
                }
                updateLiveDataRegistration(5, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value3 = mutableLiveDataK.getValue();
                    z = z;
                }
            } else {
                mutableLiveDataK = null;
            }
            value3 = null;
        } else {
            mutableLiveDataO = null;
            value = null;
            value2 = null;
            mutableLiveDataK = null;
            value3 = null;
            mutableLiveDataR = null;
            value4 = null;
            z = false;
            value5 = null;
            z2 = false;
        }
        if ((j & 384) == 0 || aVar == null) {
            fVarA = null;
            dVar = null;
            eVar = null;
            gVarA = null;
        } else {
            g gVar = this.f10433a;
            if (gVar == null) {
                gVar = new g();
                this.f10433a = gVar;
            }
            gVarA = gVar.a(aVar);
            d dVar2 = this.f10430a;
            if (dVar2 == null) {
                dVar2 = new d();
                this.f10430a = dVar2;
            }
            d dVarA = dVar2.a(aVar);
            e eVar2 = this.f10431a;
            if (eVar2 == null) {
                eVar2 = new e();
                this.f10431a = eVar2;
            }
            e eVarA = eVar2.a(aVar);
            f fVar = this.f10432a;
            if (fVar == null) {
                fVar = new f();
                this.f10432a = fVar;
            }
            fVarA = fVar.a(aVar);
            eVar = eVarA;
            dVar = dVarA;
        }
        if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) != 0) {
            if (shippingAddressEditVM != null) {
                mutableLiveDataR = shippingAddressEditVM.r();
            }
            updateLiveDataRegistration(4, mutableLiveDataR);
            if (mutableLiveDataR != null) {
                value4 = mutableLiveDataR.getValue();
            }
            z3 = !TextUtils.isEmpty(value4);
        } else {
            z3 = false;
        }
        long j6 = j & 371;
        if (j6 != 0) {
            if (!z) {
                z3 = false;
            }
            if (j6 != 0) {
                j = z3 ? j | 4096 : j | 2048;
            }
        } else {
            z3 = false;
        }
        if ((j & 4096) != 0) {
            if (shippingAddressEditVM != null) {
                mutableLiveDataR = shippingAddressEditVM.r();
            }
            mutableLiveData = mutableLiveDataK;
            updateLiveDataRegistration(4, mutableLiveDataR);
            if (mutableLiveDataR != null) {
                value4 = mutableLiveDataR.getValue();
            }
            z4 = (value4 != null ? value4.length() : 0) == 11;
            j2 = j & 371;
            if (j2 != 0) {
                if (!z3) {
                    z4 = false;
                }
                if (j2 != 0) {
                    if (z4) {
                        j |= 1024;
                    } else {
                        j |= 512;
                    }
                }
            } else {
                z4 = false;
            }
            if ((j & 1024) != 0) {
                if (shippingAddressEditVM != null) {
                    mutableLiveDataK2 = shippingAddressEditVM.k();
                } else {
                    mutableLiveDataK2 = mutableLiveData;
                }
                updateLiveDataRegistration(5, mutableLiveDataK2);
                if (mutableLiveDataK2 != null) {
                    value3 = mutableLiveDataK2.getValue();
                }
                z5 = !TextUtils.isEmpty(value3);
            } else {
                z5 = false;
            }
            j3 = j & 371;
            if (j3 != 0) {
                if (!z4) {
                    z5 = false;
                }
                if (j3 != 0) {
                    if (z5) {
                        j |= PlaybackStateCompat.ACTION_PREPARE;
                    } else {
                        j |= 8192;
                    }
                }
            } else {
                z5 = false;
            }
            if ((j & PlaybackStateCompat.ACTION_PREPARE) != 0) {
                if (shippingAddressEditVM != null) {
                    mutableLiveDataO2 = shippingAddressEditVM.o();
                } else {
                    mutableLiveDataO2 = mutableLiveDataO;
                }
                updateLiveDataRegistration(1, mutableLiveDataO2);
                if (mutableLiveDataO2 != null) {
                    value5 = mutableLiveDataO2.getValue();
                }
                z2 = !TextUtils.isEmpty(value5);
            }
            str = value5;
            z6 = z2;
            j4 = j & 371;
            if (j4 != 0) {
                if (z5) {
                    z8 = z6;
                } else {
                    z8 = false;
                }
                z7 = z8;
            } else {
                z7 = false;
            }
            if ((j & 352) != 0) {
                TextViewBindingAdapter.setText(((MallActivityShippingAddressEditBinding) this).f10414a, value3);
            }
            if ((j & 384) != 0) {
                CommonBindingAdapter.q(((MallActivityShippingAddressEditBinding) this).f10414a, fVarA, null);
                CommonBindingAdapter.q(this.f10427a, gVarA, null);
                CommonBindingAdapter.q(this.b, dVar, null);
                CommonBindingAdapter.q(this.e, eVar, null);
            }
            if ((322 & j) != 0) {
                TextViewBindingAdapter.setText(((MallActivityShippingAddressEditBinding) this).f10412a, str);
                CommonBindingAdapter.l0(this.b, z6);
            }
            if ((256 & j) != 0) {
                TextViewBindingAdapter.setTextWatcher(((MallActivityShippingAddressEditBinding) this).f10412a, null, null, null, this.f10429a);
                TextViewBindingAdapter.setTextWatcher(((MallActivityShippingAddressEditBinding) this).f10420b, null, null, null, this.f10434b);
                TextViewBindingAdapter.setTextWatcher(((MallActivityShippingAddressEditBinding) this).f10422c, null, null, null, this.c);
            }
            if ((321 & j) != 0) {
                TextViewBindingAdapter.setText(((MallActivityShippingAddressEditBinding) this).f10420b, value);
                CommonBindingAdapter.l0(this.f10427a, z);
            }
            if ((336 & j) != 0) {
                TextViewBindingAdapter.setText(((MallActivityShippingAddressEditBinding) this).f10422c, value4);
            }
            if (j4 != 0) {
                CommonBindingAdapter.e0(this.e, z7);
            }
            if ((j & 328) != 0) {
                ((MallActivityShippingAddressEditBinding) this).f10416a.k(value2);
            }
            ViewDataBinding.executeBindingsOn(((MallActivityShippingAddressEditBinding) this).f10416a);
        }
        mutableLiveData = mutableLiveDataK;
        j2 = j & 371;
        if (j2 != 0) {
            if (!z3) {
                z4 = false;
            }
            if (j2 != 0) {
                if (z4) {
                    j |= 1024;
                } else {
                    j |= 512;
                }
            }
        } else {
            z4 = false;
        }
        if ((j & 1024) != 0) {
            if (shippingAddressEditVM != null) {
                mutableLiveDataK2 = shippingAddressEditVM.k();
            } else {
                mutableLiveDataK2 = mutableLiveData;
            }
            updateLiveDataRegistration(5, mutableLiveDataK2);
            if (mutableLiveDataK2 != null) {
                value3 = mutableLiveDataK2.getValue();
            }
            z5 = !TextUtils.isEmpty(value3);
        } else {
            z5 = false;
        }
        j3 = j & 371;
        if (j3 != 0) {
            if (!z4) {
                z5 = false;
            }
            if (j3 != 0) {
                if (z5) {
                    j |= PlaybackStateCompat.ACTION_PREPARE;
                } else {
                    j |= 8192;
                }
            }
        } else {
            z5 = false;
        }
        if ((j & PlaybackStateCompat.ACTION_PREPARE) != 0) {
            if (shippingAddressEditVM != null) {
                mutableLiveDataO2 = shippingAddressEditVM.o();
            } else {
                mutableLiveDataO2 = mutableLiveDataO;
            }
            updateLiveDataRegistration(1, mutableLiveDataO2);
            if (mutableLiveDataO2 != null) {
                value5 = mutableLiveDataO2.getValue();
            }
            z2 = !TextUtils.isEmpty(value5);
        }
        str = value5;
        z6 = z2;
        j4 = j & 371;
        if (j4 != 0) {
            if (z5) {
                z8 = z6;
            } else {
                z8 = false;
            }
            z7 = z8;
        } else {
            z7 = false;
        }
        if ((j & 352) != 0) {
            TextViewBindingAdapter.setText(((MallActivityShippingAddressEditBinding) this).f10414a, value3);
        }
        if ((j & 384) != 0) {
            CommonBindingAdapter.q(((MallActivityShippingAddressEditBinding) this).f10414a, fVarA, null);
            CommonBindingAdapter.q(this.f10427a, gVarA, null);
            CommonBindingAdapter.q(this.b, dVar, null);
            CommonBindingAdapter.q(this.e, eVar, null);
        }
        if ((322 & j) != 0) {
            TextViewBindingAdapter.setText(((MallActivityShippingAddressEditBinding) this).f10412a, str);
            CommonBindingAdapter.l0(this.b, z6);
        }
        if ((256 & j) != 0) {
            TextViewBindingAdapter.setTextWatcher(((MallActivityShippingAddressEditBinding) this).f10412a, null, null, null, this.f10429a);
            TextViewBindingAdapter.setTextWatcher(((MallActivityShippingAddressEditBinding) this).f10420b, null, null, null, this.f10434b);
            TextViewBindingAdapter.setTextWatcher(((MallActivityShippingAddressEditBinding) this).f10422c, null, null, null, this.c);
        }
        if ((321 & j) != 0) {
            TextViewBindingAdapter.setText(((MallActivityShippingAddressEditBinding) this).f10420b, value);
            CommonBindingAdapter.l0(this.f10427a, z);
        }
        if ((336 & j) != 0) {
            TextViewBindingAdapter.setText(((MallActivityShippingAddressEditBinding) this).f10422c, value4);
        }
        if (j4 != 0) {
            CommonBindingAdapter.e0(this.e, z7);
        }
        if ((j & 328) != 0) {
            ((MallActivityShippingAddressEditBinding) this).f10416a.k(value2);
        }
        ViewDataBinding.executeBindingsOn(((MallActivityShippingAddressEditBinding) this).f10416a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10426a != 0) {
                return true;
            }
            return ((MallActivityShippingAddressEditBinding) this).f10416a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10426a = 256L;
        }
        ((MallActivityShippingAddressEditBinding) this).f10416a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityShippingAddressEditBinding
    public void l(@Nullable ShippingAddressEditActivity.a aVar) {
        ((MallActivityShippingAddressEditBinding) this).f10417a = aVar;
        synchronized (this) {
            this.f10426a |= 128;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityShippingAddressEditBinding
    public void m(@Nullable ShippingAddressEditVM shippingAddressEditVM) {
        ((MallActivityShippingAddressEditBinding) this).f10418a = shippingAddressEditVM;
        synchronized (this) {
            this.f10426a |= 64;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10426a |= 4;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10426a |= 32;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return q((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return n((LayoutToolbarBindingBinding) obj, i2);
        }
        if (i == 3) {
            return s((MutableLiveData) obj, i2);
        }
        if (i == 4) {
            return r((MutableLiveData) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<String> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10426a |= 2;
        }
        return true;
    }

    public final boolean q(MutableLiveData<String> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10426a |= 1;
        }
        return true;
    }

    public final boolean r(MutableLiveData<String> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10426a |= 16;
        }
        return true;
    }

    public final boolean s(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10426a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((MallActivityShippingAddressEditBinding) this).f10416a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            m((ShippingAddressEditVM) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((ShippingAddressEditActivity.a) obj);
        }
        return true;
    }

    public MallActivityShippingAddressEditBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (TextView) objArr[4], (EditText) objArr[5], (EditText) objArr[1], (EditText) objArr[3], (FrameLayout) objArr[18], (View) objArr[14], (View) objArr[15], (View) objArr[11], (View) objArr[12], (SwitchCompat) objArr[16], (LayoutToolbarBindingBinding) objArr[8], (TextView) objArr[13], (TextView) objArr[17], (TextView) objArr[10], (BLConstraintLayout) objArr[9]);
        this.f10429a = new a();
        this.f10434b = new b();
        this.c = new c();
        this.f10426a = -1L;
        ((MallActivityShippingAddressEditBinding) this).f10414a.setTag(null);
        ((MallActivityShippingAddressEditBinding) this).f10412a.setTag(null);
        ((MallActivityShippingAddressEditBinding) this).f10420b.setTag(null);
        ((MallActivityShippingAddressEditBinding) this).f10422c.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f10428a = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.f10427a = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[6];
        this.b = imageView2;
        imageView2.setTag(null);
        TextView textView = (TextView) objArr[7];
        this.e = textView;
        textView.setTag(null);
        setContainedBinding(((MallActivityShippingAddressEditBinding) this).f10416a);
        setRootTag(view);
        invalidateAll();
    }
}
