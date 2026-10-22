package com.huachenjie.shandong_school.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.shandong_school.R;
import com.huachenjie.shandong_school.home.HomeActivity;
import com.huachenjie.shandong_school.home.HomeVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class LayoutHomeSlideBindingImpl extends LayoutHomeSlideBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36029a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12648a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12649a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f12650a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12651a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f12652a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f12653a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f12654a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f12655a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f12656a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f f12657a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g f12658a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public h f12659a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public i f12660a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public j f12661a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public k f12662a;

    @NonNull
    public final FrameLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12663b;

    @NonNull
    public final LinearLayout c;

    @NonNull
    public final LinearLayout d;

    @NonNull
    public final LinearLayout e;

    @NonNull
    public final LinearLayout f;

    @NonNull
    public final LinearLayout g;

    @NonNull
    public final LinearLayout h;

    @NonNull
    public final LinearLayout i;

    @NonNull
    public final LinearLayout j;

    @NonNull
    public final LinearLayout k;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HomeActivity.a f36030a;

        public a a(HomeActivity.a aVar) {
            this.f36030a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36030a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HomeActivity.a f36031a;

        public b a(HomeActivity.a aVar) {
            this.f36031a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36031a.h(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HomeActivity.a f36032a;

        public c a(HomeActivity.a aVar) {
            this.f36032a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36032a.k(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HomeActivity.a f36033a;

        public d a(HomeActivity.a aVar) {
            this.f36033a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36033a.d(view);
        }
    }

    public static class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HomeActivity.a f36034a;

        public e a(HomeActivity.a aVar) {
            this.f36034a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36034a.c(view);
        }
    }

    public static class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HomeActivity.a f36035a;

        public f a(HomeActivity.a aVar) {
            this.f36035a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36035a.b(view);
        }
    }

    public static class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HomeActivity.a f36036a;

        public g a(HomeActivity.a aVar) {
            this.f36036a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36036a.e(view);
        }
    }

    public static class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HomeActivity.a f36037a;

        public h a(HomeActivity.a aVar) {
            this.f36037a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36037a.i(view);
        }
    }

    public static class i implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HomeActivity.a f36038a;

        public i a(HomeActivity.a aVar) {
            this.f36038a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36038a.g(view);
        }
    }

    public static class j implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HomeActivity.a f36039a;

        public j a(HomeActivity.a aVar) {
            this.f36039a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36039a.j(view);
        }
    }

    public static class k implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HomeActivity.a f36040a;

        public k a(HomeActivity.a aVar) {
            this.f36040a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36040a.f(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36029a = sparseIntArray;
        sparseIntArray.put(R.id.fl_container_ad_person, 13);
    }

    public LayoutHomeSlideBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, f12648a, f36029a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j2;
        int i2;
        int iSafeUnbox;
        a aVarA;
        k kVar;
        b bVar;
        c cVar;
        d dVar;
        e eVarA;
        j jVarA;
        g gVar;
        f fVar;
        i iVar;
        h hVar;
        f fVar2;
        synchronized (this) {
            j2 = this.f12649a;
            this.f12649a = 0L;
        }
        HomeVM homeVM = ((LayoutHomeSlideBinding) this).f12647a;
        HomeActivity.a aVar = ((LayoutHomeSlideBinding) this).f12646a;
        long j3 = 11 & j2;
        if (j3 != 0) {
            BaseViewModel.b bVarE = homeVM != null ? homeVM.e() : null;
            MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
            updateLiveDataRegistration(0, mutableLiveDataB);
            int iSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
            int iSafeUnbox3 = ViewDataBinding.safeUnbox(Integer.valueOf(iSafeUnbox2 + 4));
            iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(iSafeUnbox2 + 60));
            i2 = iSafeUnbox3;
        } else {
            i2 = 0;
            iSafeUnbox = 0;
        }
        long j4 = j2 & 12;
        if (j4 == 0 || aVar == null) {
            aVarA = null;
            kVar = null;
            bVar = null;
            cVar = null;
            dVar = null;
            eVarA = null;
            jVarA = null;
            gVar = null;
            fVar = null;
            iVar = null;
            hVar = null;
        } else {
            k kVar2 = this.f12662a;
            if (kVar2 == null) {
                kVar2 = new k();
                this.f12662a = kVar2;
            }
            k kVarA = kVar2.a(aVar);
            b bVar2 = this.f12653a;
            if (bVar2 == null) {
                bVar2 = new b();
                this.f12653a = bVar2;
            }
            b bVarA = bVar2.a(aVar);
            c cVar2 = this.f12654a;
            if (cVar2 == null) {
                cVar2 = new c();
                this.f12654a = cVar2;
            }
            c cVarA = cVar2.a(aVar);
            d dVar2 = this.f12655a;
            if (dVar2 == null) {
                dVar2 = new d();
                this.f12655a = dVar2;
            }
            d dVarA = dVar2.a(aVar);
            e eVar = this.f12656a;
            if (eVar == null) {
                eVar = new e();
                this.f12656a = eVar;
            }
            eVarA = eVar.a(aVar);
            f fVar3 = this.f12657a;
            if (fVar3 == null) {
                fVar3 = new f();
                this.f12657a = fVar3;
            }
            f fVarA = fVar3.a(aVar);
            g gVar2 = this.f12658a;
            if (gVar2 == null) {
                gVar2 = new g();
                this.f12658a = gVar2;
            }
            g gVarA = gVar2.a(aVar);
            h hVar2 = this.f12659a;
            if (hVar2 == null) {
                hVar2 = new h();
                this.f12659a = hVar2;
            }
            h hVarA = hVar2.a(aVar);
            i iVar2 = this.f12660a;
            if (iVar2 == null) {
                iVar2 = new i();
                this.f12660a = iVar2;
            }
            i iVarA = iVar2.a(aVar);
            j jVar = this.f12661a;
            if (jVar == null) {
                jVar = new j();
                this.f12661a = jVar;
            }
            jVarA = jVar.a(aVar);
            a aVar2 = this.f12652a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f12652a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            dVar = dVarA;
            cVar = cVarA;
            bVar = bVarA;
            kVar = kVarA;
            fVar = fVarA;
            gVar = gVarA;
            hVar = hVarA;
            iVar = iVarA;
        }
        if (j3 != 0) {
            CommonBindingAdapter.I(this.f12651a, 0, iSafeUnbox, 0, 0, null);
            fVar2 = fVar;
            CommonBindingAdapter.I(this.f12650a, 0, i2, 16, 0, null);
        } else {
            fVar2 = fVar;
        }
        if (j4 != 0) {
            CommonBindingAdapter.q(this.f12663b, aVarA, null);
            CommonBindingAdapter.q(this.c, kVar, null);
            CommonBindingAdapter.q(this.f12650a, fVar2, null);
            CommonBindingAdapter.q(this.d, hVar, null);
            CommonBindingAdapter.q(this.e, bVar, null);
            CommonBindingAdapter.q(this.f, cVar, null);
            CommonBindingAdapter.q(this.g, dVar, null);
            CommonBindingAdapter.q(this.h, iVar, null);
            CommonBindingAdapter.q(this.i, gVar, null);
            CommonBindingAdapter.q(this.j, eVarA, null);
            CommonBindingAdapter.q(this.k, jVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12649a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12649a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.shandong_school.databinding.LayoutHomeSlideBinding
    public void l(@Nullable HomeActivity.a aVar) {
        ((LayoutHomeSlideBinding) this).f12646a = aVar;
        synchronized (this) {
            this.f12649a |= 4;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // com.huachenjie.shandong_school.databinding.LayoutHomeSlideBinding
    public void m(@Nullable HomeVM homeVM) {
        ((LayoutHomeSlideBinding) this).f12647a = homeVM;
        synchronized (this) {
            this.f12649a |= 2;
        }
        notifyPropertyChanged(67);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Integer> mutableLiveData, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.f12649a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return n((MutableLiveData) obj, i3);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (67 == i2) {
            m((HomeVM) obj);
        } else {
            if (10 != i2) {
                return false;
            }
            l((HomeActivity.a) obj);
        }
        return true;
    }

    public LayoutHomeSlideBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (FrameLayout) objArr[13]);
        this.f12649a = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.b = frameLayout;
        frameLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.f12651a = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[10];
        this.f12663b = linearLayout2;
        linearLayout2.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[11];
        this.c = linearLayout3;
        linearLayout3.setTag(null);
        ImageView imageView = (ImageView) objArr[12];
        this.f12650a = imageView;
        imageView.setTag(null);
        LinearLayout linearLayout4 = (LinearLayout) objArr[2];
        this.d = linearLayout4;
        linearLayout4.setTag(null);
        LinearLayout linearLayout5 = (LinearLayout) objArr[3];
        this.e = linearLayout5;
        linearLayout5.setTag(null);
        LinearLayout linearLayout6 = (LinearLayout) objArr[4];
        this.f = linearLayout6;
        linearLayout6.setTag(null);
        LinearLayout linearLayout7 = (LinearLayout) objArr[5];
        this.g = linearLayout7;
        linearLayout7.setTag(null);
        LinearLayout linearLayout8 = (LinearLayout) objArr[6];
        this.h = linearLayout8;
        linearLayout8.setTag(null);
        LinearLayout linearLayout9 = (LinearLayout) objArr[7];
        this.i = linearLayout9;
        linearLayout9.setTag(null);
        LinearLayout linearLayout10 = (LinearLayout) objArr[8];
        this.j = linearLayout10;
        linearLayout10.setTag(null);
        LinearLayout linearLayout11 = (LinearLayout) objArr[9];
        this.k = linearLayout11;
        linearLayout11.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
