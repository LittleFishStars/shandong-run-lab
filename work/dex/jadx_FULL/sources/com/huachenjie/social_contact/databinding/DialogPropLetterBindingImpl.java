package com.huachenjie.social_contact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.dialog.PropLetterDialog;
import com.huachenjie.social_contact.vm.PropLetterVM;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class DialogPropLetterBindingImpl extends DialogPropLetterBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36150a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12897a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12898a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f12899a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f12900a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f12901a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final ImageView i;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PropLetterDialog.a f36151a;

        public a a(PropLetterDialog.a aVar) {
            this.f36151a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36151a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PropLetterDialog.a f36152a;

        public b a(PropLetterDialog.a aVar) {
            this.f36152a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36152a.b(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36150a = sparseIntArray;
        sparseIntArray.put(R.id.rl_letter_annex, 5);
        sparseIntArray.put(R.id.tvAnnexName, 6);
        sparseIntArray.put(R.id.rlGift1, 7);
        sparseIntArray.put(R.id.ivIcon1, 8);
        sparseIntArray.put(R.id.ivGeneType1, 9);
        sparseIntArray.put(R.id.rlGift2, 10);
        sparseIntArray.put(R.id.ivIcon2, 11);
        sparseIntArray.put(R.id.ivGeneType2, 12);
        sparseIntArray.put(R.id.rlGift3, 13);
        sparseIntArray.put(R.id.ivIcon3, 14);
        sparseIntArray.put(R.id.ivGeneType3, 15);
        sparseIntArray.put(R.id.rlGift4, 16);
        sparseIntArray.put(R.id.ivIcon4, 17);
        sparseIntArray.put(R.id.ivGeneType4, 18);
    }

    public DialogPropLetterBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 19, f12897a, f36150a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0037  */
    /* JADX WARN: Code duplicated, block: B:25:0x0053  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:66:0x00de  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:72:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:79:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        String value2;
        String str;
        float fSafeUnbox;
        long j2;
        a aVarA;
        b bVarA;
        long j3;
        long j4;
        synchronized (this) {
            j = this.f12898a;
            this.f12898a = 0L;
        }
        PropLetterVM propLetterVM = ((DialogPropLetterBinding) this).f12893a;
        PropLetterDialog.a aVar = ((DialogPropLetterBinding) this).f12892a;
        if ((47 & j) != 0) {
            if ((j & 41) == 0) {
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataJ = propLetterVM != null ? propLetterVM.j() : null;
                updateLiveDataRegistration(0, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value = mutableLiveDataJ.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 42) == 0) {
                value2 = null;
            } else {
                MutableLiveData<String> mutableLiveDataH = propLetterVM != null ? propLetterVM.h() : null;
                updateLiveDataRegistration(1, mutableLiveDataH);
                if (mutableLiveDataH != null) {
                    value2 = mutableLiveDataH.getValue();
                } else {
                    value2 = null;
                }
            }
            long j5 = j & 44;
            if (j5 != 0) {
                MutableLiveData<Boolean> mutableLiveDataI = propLetterVM != null ? propLetterVM.i() : null;
                updateLiveDataRegistration(2, mutableLiveDataI);
                boolean zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataI != null ? mutableLiveDataI.getValue() : null);
                if (j5 != 0) {
                    if (zSafeUnbox) {
                        j3 = j | 128;
                        j4 = 512;
                    } else {
                        j3 = j | 64;
                        j4 = 256;
                    }
                    j = j3 | j4;
                }
                str = zSafeUnbox ? "已领取" : "领取";
                fSafeUnbox = ViewDataBinding.safeUnbox(Float.valueOf(zSafeUnbox ? "0.33" : "1"));
            } else {
                str = null;
            }
            j2 = j & 48;
            if (j2 != 0 || aVar == null) {
                aVarA = null;
                bVarA = null;
            } else {
                b bVar = this.f12901a;
                if (bVar == null) {
                    bVar = new b();
                    this.f12901a = bVar;
                }
                bVarA = bVar.a(aVar);
                a aVar2 = this.f12900a;
                if (aVar2 == null) {
                    aVar2 = new a();
                    this.f12900a = aVar2;
                }
                aVarA = aVar2.a(aVar);
            }
            if (j2 != 0) {
                CommonBindingAdapter.q(this.i, bVarA, null);
                CommonBindingAdapter.q(this.d, aVarA, null);
            }
            if ((j & 41) != 0) {
                TextViewBindingAdapter.setText(this.b, value);
            }
            if ((42 & j) != 0) {
                TextViewBindingAdapter.setText(this.c, value2);
            }
            if ((j & 44) != 0) {
                CommonBindingAdapter.c0(this.d, fSafeUnbox);
                TextViewBindingAdapter.setText(this.d, str);
            }
        }
        value = null;
        value2 = null;
        str = null;
        fSafeUnbox = 0.0f;
        j2 = j & 48;
        if (j2 != 0) {
            aVarA = null;
            bVarA = null;
        } else {
            aVarA = null;
            bVarA = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.i, bVarA, null);
            CommonBindingAdapter.q(this.d, aVarA, null);
        }
        if ((j & 41) != 0) {
            TextViewBindingAdapter.setText(this.b, value);
        }
        if ((42 & j) != 0) {
            TextViewBindingAdapter.setText(this.c, value2);
        }
        if ((j & 44) != 0) {
            CommonBindingAdapter.c0(this.d, fSafeUnbox);
            TextViewBindingAdapter.setText(this.d, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12898a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12898a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.DialogPropLetterBinding
    public void l(@Nullable PropLetterDialog.a aVar) {
        ((DialogPropLetterBinding) this).f12892a = aVar;
        synchronized (this) {
            this.f12898a |= 16;
        }
        notifyPropertyChanged(nk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.DialogPropLetterBinding
    public void m(@Nullable PropLetterVM propLetterVM) {
        ((DialogPropLetterBinding) this).f12893a = propLetterVM;
        synchronized (this) {
            this.f12898a |= 8;
        }
        notifyPropertyChanged(nk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<String> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12898a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12898a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<String> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12898a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (nk0.p0 == i) {
            m((PropLetterVM) obj);
        } else {
            if (nk0.k != i) {
                return false;
            }
            l((PropLetterDialog.a) obj);
        }
        return true;
    }

    public DialogPropLetterBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (ImageView) objArr[9], (ImageView) objArr[12], (ImageView) objArr[15], (ImageView) objArr[18], (ImageView) objArr[8], (ImageView) objArr[11], (ImageView) objArr[14], (ImageView) objArr[17], (RelativeLayout) objArr[7], (RelativeLayout) objArr[10], (RelativeLayout) objArr[13], (RelativeLayout) objArr[16], (LinearLayout) objArr[5], (TextView) objArr[6]);
        this.f12898a = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f12899a = frameLayout;
        frameLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.i = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.b = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.c = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[4];
        this.d = textView3;
        textView3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
