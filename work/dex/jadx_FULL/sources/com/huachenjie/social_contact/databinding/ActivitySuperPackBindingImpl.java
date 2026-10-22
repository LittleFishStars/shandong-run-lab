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
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.dsbridge_webview.SpineWebView;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.PropInfo;
import com.huachenjie.social_contact.bean.RoleInfo;
import com.huachenjie.social_contact.bean.SkillInfo;
import com.huachenjie.social_contact.bean.SuperPackInfo;
import com.huachenjie.social_contact.page.SuperPackActivity;
import com.huachenjie.social_contact.vm.SuperPackVM;
import com.zj.adlib.ju3;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivitySuperPackBindingImpl extends ActivitySuperPackBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36113a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12813a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12814a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f12815a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f12816a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f12817a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f12818a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f12819a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f12820a;

    @NonNull
    public final TextView e;

    @NonNull
    public final ImageView f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    @NonNull
    public final TextView f12821f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SuperPackActivity.a f36114a;

        public a a(SuperPackActivity.a aVar) {
            this.f36114a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36114a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SuperPackActivity.a f36115a;

        public b a(SuperPackActivity.a aVar) {
            this.f36115a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36115a.d(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SuperPackActivity.a f36116a;

        public c a(SuperPackActivity.a aVar) {
            this.f36116a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36116a.c(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SuperPackActivity.a f36117a;

        public d a(SuperPackActivity.a aVar) {
            this.f36117a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36117a.e(view);
        }
    }

    public static class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SuperPackActivity.a f36118a;

        public e a(SuperPackActivity.a aVar) {
            this.f36118a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36118a.b(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36113a = sparseIntArray;
        sparseIntArray.put(R.id.spine_web, 19);
        sparseIntArray.put(R.id.rl_avatar_frame, 20);
        sparseIntArray.put(R.id.cv_bg_frame, 21);
        sparseIntArray.put(R.id.iv_bg_frame, 22);
        sparseIntArray.put(R.id.iv_avatar_frame, 23);
        sparseIntArray.put(R.id.lottie_skill, 24);
        sparseIntArray.put(R.id.iv_star_drill, 25);
    }

    public ActivitySuperPackBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 26, f12813a, f36113a));
    }

    /* JADX WARN: Code duplicated, block: B:106:0x019c  */
    /* JADX WARN: Code duplicated, block: B:108:0x01a3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:109:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:111:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:112:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:114:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:115:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:117:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:119:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:122:0x0207  */
    /* JADX WARN: Code duplicated, block: B:123:0x0224  */
    /* JADX WARN: Code duplicated, block: B:125:0x0228  */
    /* JADX WARN: Code duplicated, block: B:128:0x0277  */
    /* JADX WARN: Code duplicated, block: B:135:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x0142  */
    /* JADX WARN: Code duplicated, block: B:86:0x0145  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        int i;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String ipName;
        String str;
        String str2;
        String img;
        Integer num;
        Integer starDrill;
        String desc;
        String desc2;
        String str3;
        long j2;
        RequestOptions requestOptions;
        long j3;
        e eVarA;
        a aVarA;
        d dVarA;
        c cVarA;
        b bVarA;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        int iIntValue;
        int iIntValue2;
        int iSafeUnbox;
        RoleInfo role;
        SkillInfo skill;
        Integer crystalValue;
        PropInfo prop;
        String buyPriceStr;
        Integer signReward;
        String name;
        synchronized (this) {
            j = this.f12814a;
            this.f12814a = 0L;
        }
        SuperPackVM superPackVM = ((ActivitySuperPackBinding) this).f12806a;
        SuperPackActivity.a aVar = ((ActivitySuperPackBinding) this).f12805a;
        if ((23 & j) != 0) {
            if ((j & 21) != 0) {
                MutableLiveData<Integer> mutableLiveData = superPackVM != null ? ((BaseVM) superPackVM).f33644a : null;
                updateLiveDataRegistration(0, mutableLiveData);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData != null ? mutableLiveData.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            long j4 = j & 22;
            if (j4 != 0) {
                MutableLiveData<SuperPackInfo> mutableLiveDataI = superPackVM != null ? superPackVM.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                SuperPackInfo value = mutableLiveDataI != null ? mutableLiveDataI.getValue() : null;
                if (value != null) {
                    skill = value.getSkill();
                    crystalValue = value.getCrystalValue();
                    starDrill = value.getStarDrill();
                    prop = value.getProp();
                    buyPriceStr = value.getBuyPriceStr();
                    signReward = value.getSignReward();
                    role = value.getRole();
                } else {
                    role = null;
                    skill = null;
                    crystalValue = null;
                    starDrill = null;
                    prop = null;
                    buyPriceStr = null;
                    signReward = null;
                }
                String skillName = skill != null ? skill.getSkillName() : null;
                z2 = crystalValue == null;
                z3 = starDrill == null;
                str2 = String.format("%s", buyPriceStr);
                int iSafeUnbox2 = ViewDataBinding.safeUnbox(signReward);
                if (j4 != 0) {
                    j |= z2 ? 256L : 128L;
                }
                if ((j & 22) != 0) {
                    j |= z3 ? 1024L : 512L;
                }
                if (prop != null) {
                    img = prop.getImg();
                    name = prop.getName();
                    desc = prop.getDesc();
                } else {
                    img = null;
                    desc = null;
                    name = null;
                }
                if (role != null) {
                    desc2 = role.getDesc();
                    ipName = role.getIpName();
                } else {
                    ipName = null;
                    desc2 = null;
                }
                z = iSafeUnbox2 == 1;
                z4 = desc == null;
                z5 = desc2 == null;
                if ((j & 22) != 0) {
                    j |= z4 ? 64L : 32L;
                }
                if ((j & 22) != 0) {
                    j |= z5 ? 4096L : 2048L;
                }
                str3 = name;
                Integer num2 = crystalValue;
                i = iSafeUnbox;
                str = skillName;
                num = num2;
            } else {
                i = iSafeUnbox;
                z = false;
                z2 = false;
            }
            j2 = 22 & j;
            if (j2 != 0) {
                requestOptions = ju3.h;
            } else {
                requestOptions = null;
            }
            j3 = j & 24;
            if (j3 != 0 || aVar == null) {
                eVarA = null;
                aVarA = null;
                dVarA = null;
                cVarA = null;
                bVarA = null;
            } else {
                e eVar = this.f12820a;
                if (eVar == null) {
                    eVar = new e();
                    this.f12820a = eVar;
                }
                eVarA = eVar.a(aVar);
                a aVar2 = this.f12816a;
                if (aVar2 == null) {
                    aVar2 = new a();
                    this.f12816a = aVar2;
                }
                aVarA = aVar2.a(aVar);
                b bVar = this.f12817a;
                if (bVar == null) {
                    bVar = new b();
                    this.f12817a = bVar;
                }
                bVarA = bVar.a(aVar);
                c cVar = this.f12818a;
                if (cVar == null) {
                    cVar = new c();
                    this.f12818a = cVar;
                }
                cVarA = cVar.a(aVar);
                d dVar = this.f12819a;
                if (dVar == null) {
                    dVar = new d();
                    this.f12819a = dVar;
                }
                dVarA = dVar.a(aVar);
            }
            if (j2 != 0) {
                if (z4) {
                    desc = "";
                }
                if (z2) {
                    iIntValue = 0;
                } else {
                    iIntValue = num.intValue();
                }
                if (z3) {
                    iIntValue2 = 0;
                } else {
                    iIntValue2 = starDrill.intValue();
                }
                if (z5) {
                    desc2 = "";
                }
                String str9 = String.format("%s", desc);
                String str10 = String.format("世界水晶 X%d", Integer.valueOf(iIntValue));
                str7 = String.format("星空钻 X%d", Integer.valueOf(iIntValue2));
                str6 = String.format("「%s」", desc2);
                str5 = str10;
                str4 = str9;
            } else {
                str4 = null;
                str5 = null;
                str6 = null;
                str7 = null;
            }
            str8 = str5;
            if (j3 != 0) {
                CommonBindingAdapter.q(((ActivitySuperPackBinding) this).f36112a, cVarA, null);
                CommonBindingAdapter.q(this.f, eVarA, null);
                CommonBindingAdapter.q(((ActivitySuperPackBinding) this).f12799a, aVarA, null);
                CommonBindingAdapter.q(((ActivitySuperPackBinding) this).f12807b, dVarA, null);
                CommonBindingAdapter.q(((ActivitySuperPackBinding) this).f12810c, bVarA, null);
            }
            if (j2 != 0) {
                CommonBindingAdapter.b0(((ActivitySuperPackBinding) this).c, img, requestOptions, false);
                CommonBindingAdapter.l0(((ActivitySuperPackBinding) this).d, z);
                TextViewBindingAdapter.setText(this.e, str4);
                CommonBindingAdapter.l0(this.f12821f, z);
                CommonBindingAdapter.l0(this.g, z);
                TextViewBindingAdapter.setText(this.h, str2);
                TextViewBindingAdapter.setText(this.i, ipName);
                TextViewBindingAdapter.setText(this.j, str);
                TextViewBindingAdapter.setText(((ActivitySuperPackBinding) this).f12801a, str3);
                TextViewBindingAdapter.setText(((ActivitySuperPackBinding) this).f12809b, str6);
                TextViewBindingAdapter.setText(((ActivitySuperPackBinding) this).f12811c, str7);
                TextViewBindingAdapter.setText(((ActivitySuperPackBinding) this).f12812d, str8);
            }
            if ((j & 21) != 0) {
                CommonBindingAdapter.O(((ActivitySuperPackBinding) this).f12808b, 0, i, 0, 0, null);
            }
        }
        z = false;
        i = 0;
        z2 = false;
        z3 = z2;
        z4 = z3;
        z5 = z4;
        ipName = null;
        str = null;
        str2 = null;
        img = null;
        num = null;
        starDrill = null;
        desc = null;
        desc2 = null;
        str3 = null;
        j2 = 22 & j;
        if (j2 != 0) {
            requestOptions = ju3.h;
        } else {
            requestOptions = null;
        }
        j3 = j & 24;
        if (j3 != 0) {
            eVarA = null;
            aVarA = null;
            dVarA = null;
            cVarA = null;
            bVarA = null;
        } else {
            eVarA = null;
            aVarA = null;
            dVarA = null;
            cVarA = null;
            bVarA = null;
        }
        if (j2 != 0) {
            if (z4) {
                desc = "";
            }
            if (z2) {
                iIntValue = 0;
            } else {
                iIntValue = num.intValue();
            }
            if (z3) {
                iIntValue2 = 0;
            } else {
                iIntValue2 = starDrill.intValue();
            }
            if (z5) {
                desc2 = "";
            }
            String str11 = String.format("%s", desc);
            String str12 = String.format("世界水晶 X%d", Integer.valueOf(iIntValue));
            str7 = String.format("星空钻 X%d", Integer.valueOf(iIntValue2));
            str6 = String.format("「%s」", desc2);
            str5 = str12;
            str4 = str11;
        } else {
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
        }
        str8 = str5;
        if (j3 != 0) {
            CommonBindingAdapter.q(((ActivitySuperPackBinding) this).f36112a, cVarA, null);
            CommonBindingAdapter.q(this.f, eVarA, null);
            CommonBindingAdapter.q(((ActivitySuperPackBinding) this).f12799a, aVarA, null);
            CommonBindingAdapter.q(((ActivitySuperPackBinding) this).f12807b, dVarA, null);
            CommonBindingAdapter.q(((ActivitySuperPackBinding) this).f12810c, bVarA, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(((ActivitySuperPackBinding) this).c, img, requestOptions, false);
            CommonBindingAdapter.l0(((ActivitySuperPackBinding) this).d, z);
            TextViewBindingAdapter.setText(this.e, str4);
            CommonBindingAdapter.l0(this.f12821f, z);
            CommonBindingAdapter.l0(this.g, z);
            TextViewBindingAdapter.setText(this.h, str2);
            TextViewBindingAdapter.setText(this.i, ipName);
            TextViewBindingAdapter.setText(this.j, str);
            TextViewBindingAdapter.setText(((ActivitySuperPackBinding) this).f12801a, str3);
            TextViewBindingAdapter.setText(((ActivitySuperPackBinding) this).f12809b, str6);
            TextViewBindingAdapter.setText(((ActivitySuperPackBinding) this).f12811c, str7);
            TextViewBindingAdapter.setText(((ActivitySuperPackBinding) this).f12812d, str8);
        }
        if ((j & 21) != 0) {
            CommonBindingAdapter.O(((ActivitySuperPackBinding) this).f12808b, 0, i, 0, 0, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12814a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12814a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ActivitySuperPackBinding
    public void l(@Nullable SuperPackActivity.a aVar) {
        ((ActivitySuperPackBinding) this).f12805a = aVar;
        synchronized (this) {
            this.f12814a |= 8;
        }
        notifyPropertyChanged(nk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ActivitySuperPackBinding
    public void m(@Nullable SuperPackVM superPackVM) {
        ((ActivitySuperPackBinding) this).f12806a = superPackVM;
        synchronized (this) {
            this.f12814a |= 4;
        }
        notifyPropertyChanged(nk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12814a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<SuperPackInfo> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12814a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (nk0.p0 == i) {
            m((SuperPackVM) obj);
        } else {
            if (nk0.k != i) {
                return false;
            }
            l((SuperPackActivity.a) obj);
        }
        return true;
    }

    public ActivitySuperPackBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (FrameLayout) objArr[17], (CardView) objArr[21], (ImageView) objArr[23], (ImageView) objArr[22], (ImageView) objArr[11], (ImageView) objArr[14], (ImageView) objArr[25], (LottieAnimationView) objArr[24], (RelativeLayout) objArr[20], (SpineWebView) objArr[19], (LinearLayout) objArr[6], (LinearLayout) objArr[4], (LinearLayout) objArr[7], (RelativeLayout) objArr[1], (TextView) objArr[12], (TextView) objArr[3], (TextView) objArr[9], (TextView) objArr[10]);
        this.f12814a = -1L;
        ((ActivitySuperPackBinding) this).f36112a.setTag(null);
        ((ActivitySuperPackBinding) this).c.setTag(null);
        ((ActivitySuperPackBinding) this).d.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12815a = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[13];
        this.e = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[15];
        this.f12821f = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[16];
        this.g = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[18];
        this.h = textView4;
        textView4.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.f = imageView;
        imageView.setTag(null);
        TextView textView5 = (TextView) objArr[5];
        this.i = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[8];
        this.j = textView6;
        textView6.setTag(null);
        ((ActivitySuperPackBinding) this).f12799a.setTag(null);
        ((ActivitySuperPackBinding) this).f12807b.setTag(null);
        ((ActivitySuperPackBinding) this).f12810c.setTag(null);
        ((ActivitySuperPackBinding) this).f12808b.setTag(null);
        ((ActivitySuperPackBinding) this).f12801a.setTag(null);
        ((ActivitySuperPackBinding) this).f12809b.setTag(null);
        ((ActivitySuperPackBinding) this).f12811c.setTag(null);
        ((ActivitySuperPackBinding) this).f12812d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
