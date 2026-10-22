package com.huachenjie.college.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.college.R;
import com.huachenjie.college.bean.CollegeTownBannerBean;
import com.huachenjie.college.bean.CollegeTownBean;
import com.huachenjie.college.bean.SchoolDetailBean;
import com.huachenjie.college.page.sport.CollegeActivity;
import com.huachenjie.college.page.sport.CollegeVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.youth.banner.Banner;
import com.zj.adlib.uk0;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class CollegeLayoutHomeHeaderBindingImpl extends CollegeLayoutHomeHeaderBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33584a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8432a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8433a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f8434a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8435a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f8436a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f8437a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f8438a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f8439a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f8440a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f8441a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f f8442a;

    @NonNull
    public final LinearLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f8443b;

    @NonNull
    public final LinearLayout c;

    @NonNull
    public final ImageView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8444d;

    @NonNull
    public final ImageView e;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CollegeActivity.a f33585a;

        public a a(CollegeActivity.a aVar) {
            this.f33585a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33585a.e(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CollegeActivity.a f33586a;

        public b a(CollegeActivity.a aVar) {
            this.f33586a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33586a.b(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CollegeActivity.a f33587a;

        public c a(CollegeActivity.a aVar) {
            this.f33587a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33587a.f(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CollegeActivity.a f33588a;

        public d a(CollegeActivity.a aVar) {
            this.f33588a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33588a.a(view);
        }
    }

    public static class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CollegeActivity.a f33589a;

        public e a(CollegeActivity.a aVar) {
            this.f33589a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33589a.h(view);
        }
    }

    public static class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CollegeActivity.a f33590a;

        public f a(CollegeActivity.a aVar) {
            this.f33590a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33590a.g(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33584a = sparseIntArray;
        sparseIntArray.put(R.id.bg_school_sport, 14);
        sparseIntArray.put(R.id.banner_header, 15);
    }

    public CollegeLayoutHomeHeaderBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 16, f8432a, f33584a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        boolean z;
        boolean z2;
        List<CollegeTownBannerBean> bannerList;
        String logoUrl;
        String str;
        String str2;
        String motto;
        c cVar;
        e eVar;
        a aVar;
        b bVar;
        d dVar;
        f fVar;
        long j2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        String name;
        String coverUrl;
        synchronized (this) {
            j = this.f8433a;
            this.f8433a = 0L;
        }
        CollegeVM collegeVM = ((CollegeLayoutHomeHeaderBinding) this).f8428a;
        RequestOptions requestOptions = ((CollegeLayoutHomeHeaderBinding) this).f8431b;
        RequestOptions requestOptions2 = ((CollegeLayoutHomeHeaderBinding) this).f8426a;
        CollegeActivity.a aVar2 = ((CollegeLayoutHomeHeaderBinding) this).f8427a;
        if ((191 & j) != 0) {
            if ((j & 185) != 0) {
                MutableLiveData<SchoolDetailBean> mutableLiveDataQ = collegeVM != null ? collegeVM.q() : null;
                updateLiveDataRegistration(0, mutableLiveDataQ);
                SchoolDetailBean value = mutableLiveDataQ != null ? mutableLiveDataQ.getValue() : null;
                if ((j & 137) != 0) {
                    if (value != null) {
                        motto = value.getMotto();
                        name = value.getName();
                    } else {
                        motto = null;
                        name = null;
                    }
                    z6 = !TextUtils.isEmpty(motto);
                } else {
                    z6 = false;
                    motto = null;
                    name = null;
                }
                coverUrl = ((j & 169) == 0 || value == null) ? null : value.getCoverUrl();
                logoUrl = ((j & 153) == 0 || value == null) ? null : value.getLogoUrl();
            } else {
                z6 = false;
                logoUrl = null;
                motto = null;
                name = null;
                coverUrl = null;
            }
            if ((j & 138) != 0) {
                MutableLiveData<Boolean> mutableLiveDataL = collegeVM != null ? collegeVM.l() : null;
                updateLiveDataRegistration(1, mutableLiveDataL);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataL != null ? mutableLiveDataL.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            long j3 = j & 140;
            if (j3 != 0) {
                MutableLiveData<CollegeTownBean> mutableLiveDataK = collegeVM != null ? collegeVM.k() : null;
                updateLiveDataRegistration(2, mutableLiveDataK);
                CollegeTownBean value2 = mutableLiveDataK != null ? mutableLiveDataK.getValue() : null;
                bannerList = value2 != null ? value2.getBannerList() : null;
                z = bannerList != null;
                if (j3 != 0) {
                    j = z ? j | 512 : j | 256;
                }
                str = name;
                z2 = z6;
                str2 = coverUrl;
            } else {
                z = false;
                str = name;
                z2 = z6;
                str2 = coverUrl;
                bannerList = null;
            }
        } else {
            zSafeUnbox = false;
            z = false;
            z2 = false;
            bannerList = null;
            logoUrl = null;
            str = null;
            str2 = null;
            motto = null;
        }
        long j4 = j & 153;
        long j5 = j & 169;
        long j6 = j & 192;
        if (j6 == 0 || aVar2 == null) {
            cVar = null;
            eVar = null;
            aVar = null;
            bVar = null;
            dVar = null;
            fVar = null;
        } else {
            f fVar2 = this.f8442a;
            if (fVar2 == null) {
                fVar2 = new f();
                this.f8442a = fVar2;
            }
            f fVarA = fVar2.a(aVar2);
            a aVar3 = this.f8437a;
            if (aVar3 == null) {
                aVar3 = new a();
                this.f8437a = aVar3;
            }
            a aVarA = aVar3.a(aVar2);
            b bVar2 = this.f8438a;
            if (bVar2 == null) {
                bVar2 = new b();
                this.f8438a = bVar2;
            }
            b bVarA = bVar2.a(aVar2);
            c cVar2 = this.f8439a;
            if (cVar2 == null) {
                cVar2 = new c();
                this.f8439a = cVar2;
            }
            c cVarA = cVar2.a(aVar2);
            d dVar2 = this.f8440a;
            if (dVar2 == null) {
                dVar2 = new d();
                this.f8440a = dVar2;
            }
            d dVarA = dVar2.a(aVar2);
            e eVar2 = this.f8441a;
            if (eVar2 == null) {
                eVar2 = new e();
                this.f8441a = eVar2;
            }
            e eVarA = eVar2.a(aVar2);
            aVar = aVarA;
            bVar = bVarA;
            fVar = fVarA;
            dVar = dVarA;
            eVar = eVarA;
            cVar = cVarA;
        }
        if ((j & 512) != 0) {
            z3 = (bannerList != null ? bannerList.size() : 0) > 0;
            j2 = 140;
        } else {
            j2 = 140;
            z3 = false;
        }
        long j7 = j & j2;
        if (j7 != 0) {
            if (!z) {
                z3 = false;
            }
            z4 = z3;
        } else {
            z4 = false;
        }
        if (j4 != 0) {
            z5 = false;
            CommonBindingAdapter.b0(((CollegeLayoutHomeHeaderBinding) this).f8430b, logoUrl, requestOptions, false);
        } else {
            z5 = false;
        }
        if (j5 != 0) {
            CommonBindingAdapter.b0(super.c, str2, requestOptions2, z5);
        }
        if ((j & 138) != 0) {
            CommonBindingAdapter.l0(this.d, zSafeUnbox);
            CommonBindingAdapter.l0(this.e, zSafeUnbox);
        }
        if (j6 != 0) {
            CommonBindingAdapter.q(this.f8435a, cVar, null);
            CommonBindingAdapter.q(this.b, eVar, null);
            CommonBindingAdapter.q(this.c, bVar, null);
            CommonBindingAdapter.q(this.f8444d, aVar, null);
            CommonBindingAdapter.q(((CollegeLayoutHomeHeaderBinding) this).f33583a, dVar, null);
            CommonBindingAdapter.q(((CollegeLayoutHomeHeaderBinding) this).b, fVar, null);
        }
        if (j7 != 0) {
            CommonBindingAdapter.l0(this.f8436a, z4);
        }
        if ((j & 137) != 0) {
            CommonBindingAdapter.l0(this.f8443b, z2);
            TextViewBindingAdapter.setText(this.f8443b, motto);
            TextViewBindingAdapter.setText(((CollegeLayoutHomeHeaderBinding) this).f8425a, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8433a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8433a = 128L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.college.databinding.CollegeLayoutHomeHeaderBinding
    public void o(@Nullable RequestOptions requestOptions) {
        ((CollegeLayoutHomeHeaderBinding) this).f8431b = requestOptions;
        synchronized (this) {
            this.f8433a |= 16;
        }
        notifyPropertyChanged(uk0.e);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return u((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return t((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return s((MutableLiveData) obj, i2);
    }

    @Override // com.huachenjie.college.databinding.CollegeLayoutHomeHeaderBinding
    public void p(@Nullable RequestOptions requestOptions) {
        ((CollegeLayoutHomeHeaderBinding) this).f8426a = requestOptions;
        synchronized (this) {
            this.f8433a |= 32;
        }
        notifyPropertyChanged(uk0.h);
        super.requestRebind();
    }

    @Override // com.huachenjie.college.databinding.CollegeLayoutHomeHeaderBinding
    public void q(@Nullable CollegeActivity.a aVar) {
        ((CollegeLayoutHomeHeaderBinding) this).f8427a = aVar;
        synchronized (this) {
            this.f8433a |= 64;
        }
        notifyPropertyChanged(uk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.college.databinding.CollegeLayoutHomeHeaderBinding
    public void r(@Nullable CollegeVM collegeVM) {
        ((CollegeLayoutHomeHeaderBinding) this).f8428a = collegeVM;
        synchronized (this) {
            this.f8433a |= 8;
        }
        notifyPropertyChanged(uk0.p0);
        super.requestRebind();
    }

    public final boolean s(MutableLiveData<CollegeTownBean> mutableLiveData, int i) {
        if (i != uk0.f45162a) {
            return false;
        }
        synchronized (this) {
            this.f8433a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (uk0.p0 == i) {
            r((CollegeVM) obj);
        } else if (uk0.e == i) {
            o((RequestOptions) obj);
        } else if (uk0.h == i) {
            p((RequestOptions) obj);
        } else {
            if (uk0.k != i) {
                return false;
            }
            q((CollegeActivity.a) obj);
        }
        return true;
    }

    public final boolean t(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != uk0.f45162a) {
            return false;
        }
        synchronized (this) {
            this.f8433a |= 2;
        }
        return true;
    }

    public final boolean u(MutableLiveData<SchoolDetailBean> mutableLiveData, int i) {
        if (i != uk0.f45162a) {
            return false;
        }
        synchronized (this) {
            this.f8433a |= 1;
        }
        return true;
    }

    public CollegeLayoutHomeHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (Banner) objArr[15], (ImageView) objArr[14], (ImageView) objArr[2], (ImageView) objArr[1], (TextView) objArr[3], (View) objArr[7], (View) objArr[6]);
        this.f8433a = -1L;
        ((CollegeLayoutHomeHeaderBinding) this).f8430b.setTag(null);
        super.c.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f8434a = frameLayout;
        frameLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[10];
        this.d = imageView;
        imageView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[11];
        this.f8435a = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[12];
        this.b = linearLayout2;
        linearLayout2.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[13];
        this.f8436a = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.f8443b = textView;
        textView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[5];
        this.e = imageView2;
        imageView2.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[8];
        this.c = linearLayout3;
        linearLayout3.setTag(null);
        LinearLayout linearLayout4 = (LinearLayout) objArr[9];
        this.f8444d = linearLayout4;
        linearLayout4.setTag(null);
        ((CollegeLayoutHomeHeaderBinding) this).f8425a.setTag(null);
        ((CollegeLayoutHomeHeaderBinding) this).f33583a.setTag(null);
        ((CollegeLayoutHomeHeaderBinding) this).b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
