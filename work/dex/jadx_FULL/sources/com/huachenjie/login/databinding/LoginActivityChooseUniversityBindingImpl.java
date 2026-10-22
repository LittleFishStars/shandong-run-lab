package com.huachenjie.login.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.bean.SchoolInfo;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.login.bean.GradeBean;
import com.huachenjie.login.page.info.university.ChooseUniversityActivity;
import com.huachenjie.login.page.info.university.ChooseUniversityVM;
import com.zj.adlib.zk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class LoginActivityChooseUniversityBindingImpl extends LoginActivityChooseUniversityBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34635a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9966a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9967a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f9968a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f9969a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9970a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9971a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f9972a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f9973a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f9974a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f9975a;

    @NonNull
    public final LinearLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f9976b;

    @NonNull
    public final LinearLayout c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f9977c;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChooseUniversityActivity.a f34636a;

        public a a(ChooseUniversityActivity.a aVar) {
            this.f34636a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34636a.b(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChooseUniversityActivity.a f34637a;

        public b a(ChooseUniversityActivity.a aVar) {
            this.f34637a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34637a.a(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChooseUniversityActivity.a f34638a;

        public c a(ChooseUniversityActivity.a aVar) {
            this.f34638a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34638a.d(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChooseUniversityActivity.a f34639a;

        public d a(ChooseUniversityActivity.a aVar) {
            this.f34639a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34639a.c(view);
        }
    }

    public LoginActivityChooseUniversityBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f9966a, f34635a));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0165  */
    /* JADX WARN: Code duplicated, block: B:104:0x018b  */
    /* JADX WARN: Code duplicated, block: B:107:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:110:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:113:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0049 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x004b  */
    /* JADX WARN: Code duplicated, block: B:25:0x0050  */
    /* JADX WARN: Code duplicated, block: B:27:0x0054  */
    /* JADX WARN: Code duplicated, block: B:28:0x005b  */
    /* JADX WARN: Code duplicated, block: B:31:0x0061  */
    /* JADX WARN: Code duplicated, block: B:32:0x0068  */
    /* JADX WARN: Code duplicated, block: B:34:0x0078  */
    /* JADX WARN: Code duplicated, block: B:37:0x0080 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x0082  */
    /* JADX WARN: Code duplicated, block: B:39:0x0089  */
    /* JADX WARN: Code duplicated, block: B:42:0x0090  */
    /* JADX WARN: Code duplicated, block: B:43:0x0097  */
    /* JADX WARN: Code duplicated, block: B:45:0x009a  */
    /* JADX WARN: Code duplicated, block: B:46:0x009c  */
    /* JADX WARN: Code duplicated, block: B:48:0x009f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:55:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:88:0x0145 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:89:0x0147  */
    /* JADX WARN: Code duplicated, block: B:91:0x014b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x014d  */
    /* JADX WARN: Code duplicated, block: B:93:0x0150  */
    /* JADX WARN: Code duplicated, block: B:96:0x0155  */
    /* JADX WARN: Code duplicated, block: B:97:0x0158  */
    /* JADX WARN: Code duplicated, block: B:98:0x015b  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        int iSafeUnbox;
        int i;
        MutableLiveData<GradeBean> mutableLiveDataK;
        String schoolName;
        GradeBean value;
        String str;
        c cVarA;
        long j2;
        b bVarA;
        d dVarA;
        a aVarA;
        boolean z2;
        boolean z3;
        long j3;
        String str2;
        long j4;
        int iSafeUnbox2;
        long j5;
        MutableLiveData<SchoolInfo> mutableLiveDataN;
        SchoolInfo value2;
        BaseViewModel.b bVarE;
        MutableLiveData<Integer> mutableLiveDataB;
        Integer value3;
        synchronized (this) {
            j = this.f9967a;
            this.f9967a = 0L;
        }
        ChooseUniversityVM chooseUniversityVM = ((LoginActivityChooseUniversityBinding) this).f9965a;
        ChooseUniversityActivity.a aVar = ((LoginActivityChooseUniversityBinding) this).f34634a;
        if ((47 & j) != 0) {
            if ((j & 41) != 0) {
                mutableLiveDataK = chooseUniversityVM != null ? chooseUniversityVM.k() : null;
                updateLiveDataRegistration(0, mutableLiveDataK);
                value = mutableLiveDataK != null ? mutableLiveDataK.getValue() : null;
                String name = value != null ? value.getName() : null;
                if ((j & 42) != 0) {
                    if (chooseUniversityVM != null) {
                        bVarE = chooseUniversityVM.e();
                    } else {
                        bVarE = null;
                    }
                    if (bVarE != null) {
                        mutableLiveDataB = bVarE.b();
                    } else {
                        mutableLiveDataB = null;
                    }
                    updateLiveDataRegistration(1, mutableLiveDataB);
                    if (mutableLiveDataB != null) {
                        value3 = mutableLiveDataB.getValue();
                    } else {
                        value3 = null;
                    }
                    iSafeUnbox2 = ViewDataBinding.safeUnbox(value3);
                    iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(iSafeUnbox2 + 16));
                } else {
                    iSafeUnbox2 = 0;
                    iSafeUnbox = 0;
                }
                j5 = j & 45;
                if (j5 != 0) {
                    if (chooseUniversityVM != null) {
                        mutableLiveDataN = chooseUniversityVM.n();
                    } else {
                        mutableLiveDataN = null;
                    }
                    updateLiveDataRegistration(2, mutableLiveDataN);
                    if (mutableLiveDataN != null) {
                        value2 = mutableLiveDataN.getValue();
                    } else {
                        value2 = null;
                    }
                    if (value2 != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (j5 != 0) {
                        if (z) {
                            j |= 512;
                        } else {
                            j |= 256;
                        }
                    }
                    if ((j & 44) == 0 && value2 != null) {
                        schoolName = value2.getSchoolName();
                        i = iSafeUnbox2;
                        str = name;
                    }
                } else {
                    z = false;
                }
                i = iSafeUnbox2;
                str = name;
                schoolName = null;
            } else {
                mutableLiveDataK = null;
                value = null;
            }
            if ((j & 42) != 0) {
                if (chooseUniversityVM != null) {
                    bVarE = chooseUniversityVM.e();
                } else {
                    bVarE = null;
                }
                if (bVarE != null) {
                    mutableLiveDataB = bVarE.b();
                } else {
                    mutableLiveDataB = null;
                }
                updateLiveDataRegistration(1, mutableLiveDataB);
                if (mutableLiveDataB != null) {
                    value3 = mutableLiveDataB.getValue();
                } else {
                    value3 = null;
                }
                iSafeUnbox2 = ViewDataBinding.safeUnbox(value3);
                iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(iSafeUnbox2 + 16));
            } else {
                iSafeUnbox2 = 0;
                iSafeUnbox = 0;
            }
            j5 = j & 45;
            if (j5 != 0) {
                if (chooseUniversityVM != null) {
                    mutableLiveDataN = chooseUniversityVM.n();
                } else {
                    mutableLiveDataN = null;
                }
                updateLiveDataRegistration(2, mutableLiveDataN);
                if (mutableLiveDataN != null) {
                    value2 = mutableLiveDataN.getValue();
                } else {
                    value2 = null;
                }
                if (value2 != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (j5 != 0) {
                    if (z) {
                        j |= 512;
                    } else {
                        j |= 256;
                    }
                }
                if ((j & 44) == 0) {
                }
            } else {
                z = false;
            }
            i = iSafeUnbox2;
            str = name;
            schoolName = null;
        } else {
            z = false;
            iSafeUnbox = 0;
            i = 0;
            mutableLiveDataK = null;
            schoolName = null;
            value = null;
            str = null;
        }
        if ((j & 48) == 0 || aVar == null) {
            cVarA = null;
            j2 = 512;
            bVarA = null;
            dVarA = null;
            aVarA = null;
        } else {
            d dVar = this.f9975a;
            if (dVar == null) {
                dVar = new d();
                this.f9975a = dVar;
            }
            dVarA = dVar.a(aVar);
            a aVar2 = this.f9972a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f9972a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            b bVar = this.f9973a;
            if (bVar == null) {
                bVar = new b();
                this.f9973a = bVar;
            }
            bVarA = bVar.a(aVar);
            c cVar = this.f9974a;
            if (cVar == null) {
                cVar = new c();
                this.f9974a = cVar;
            }
            cVarA = cVar.a(aVar);
            j2 = 512;
        }
        if ((j2 & j) != 0) {
            if (chooseUniversityVM != null) {
                mutableLiveDataK = chooseUniversityVM.k();
            }
            z2 = false;
            updateLiveDataRegistration(0, mutableLiveDataK);
            if (mutableLiveDataK != null) {
                value = mutableLiveDataK.getValue();
            }
            if (value != null) {
                z3 = true;
            }
            j3 = j & 45;
            if (j3 != 0) {
                if (z) {
                    z2 = z3;
                }
                if (j3 != 0) {
                    if (z2) {
                        j4 = 128;
                    } else {
                        j4 = 64;
                    }
                    j |= j4;
                }
                if (z2) {
                    str2 = "#0BD3FF";
                } else {
                    str2 = "#FFFFFF";
                }
            } else {
                str2 = null;
            }
            if ((42 & j) != 0) {
                CommonBindingAdapter.I(this.f9970a, 0, i, 0, 0, null);
                CommonBindingAdapter.I(this.f9969a, 0, iSafeUnbox, 0, 0, null);
            }
            if ((j & 48) != 0) {
                CommonBindingAdapter.q(this.b, dVarA, null);
                CommonBindingAdapter.q(this.c, aVarA, null);
                CommonBindingAdapter.q(this.f9977c, cVarA, null);
                CommonBindingAdapter.q(this.f9969a, bVarA, null);
            }
            if ((44 & j) != 0) {
                TextViewBindingAdapter.setText(this.f9971a, schoolName);
            }
            if ((41 & j) != 0) {
                TextViewBindingAdapter.setText(this.f9976b, str);
            }
            if ((j & 45) != 0) {
                CommonBindingAdapter.e0(this.f9977c, z2);
                CommonBindingAdapter.W(this.f9977c, str2);
            }
        }
        z2 = false;
        z3 = z2;
        j3 = j & 45;
        if (j3 != 0) {
            if (z) {
                z2 = z3;
            }
            if (j3 != 0) {
                if (z2) {
                    j4 = 128;
                } else {
                    j4 = 64;
                }
                j |= j4;
            }
            if (z2) {
                str2 = "#0BD3FF";
            } else {
                str2 = "#FFFFFF";
            }
        } else {
            str2 = null;
        }
        if ((42 & j) != 0) {
            CommonBindingAdapter.I(this.f9970a, 0, i, 0, 0, null);
            CommonBindingAdapter.I(this.f9969a, 0, iSafeUnbox, 0, 0, null);
        }
        if ((j & 48) != 0) {
            CommonBindingAdapter.q(this.b, dVarA, null);
            CommonBindingAdapter.q(this.c, aVarA, null);
            CommonBindingAdapter.q(this.f9977c, cVarA, null);
            CommonBindingAdapter.q(this.f9969a, bVarA, null);
        }
        if ((44 & j) != 0) {
            TextViewBindingAdapter.setText(this.f9971a, schoolName);
        }
        if ((41 & j) != 0) {
            TextViewBindingAdapter.setText(this.f9976b, str);
        }
        if ((j & 45) != 0) {
            CommonBindingAdapter.e0(this.f9977c, z2);
            CommonBindingAdapter.W(this.f9977c, str2);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9967a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9967a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginActivityChooseUniversityBinding
    public void l(@Nullable ChooseUniversityActivity.a aVar) {
        ((LoginActivityChooseUniversityBinding) this).f34634a = aVar;
        synchronized (this) {
            this.f9967a |= 16;
        }
        notifyPropertyChanged(zk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginActivityChooseUniversityBinding
    public void m(@Nullable ChooseUniversityVM chooseUniversityVM) {
        ((LoginActivityChooseUniversityBinding) this).f9965a = chooseUniversityVM;
        synchronized (this) {
            this.f9967a |= 8;
        }
        notifyPropertyChanged(zk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<GradeBean> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f9967a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<SchoolInfo> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f9967a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return p((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f9967a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (zk0.p0 == i) {
            m((ChooseUniversityVM) obj);
        } else {
            if (zk0.k != i) {
                return false;
            }
            l((ChooseUniversityActivity.a) obj);
        }
        return true;
    }

    public LoginActivityChooseUniversityBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3);
        this.f9967a = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f9968a = frameLayout;
        frameLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.f9970a = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[2];
        this.b = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f9971a = textView;
        textView.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[4];
        this.c = linearLayout3;
        linearLayout3.setTag(null);
        TextView textView2 = (TextView) objArr[5];
        this.f9976b = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[6];
        this.f9977c = textView3;
        textView3.setTag(null);
        ImageView imageView = (ImageView) objArr[7];
        this.f9969a = imageView;
        imageView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
