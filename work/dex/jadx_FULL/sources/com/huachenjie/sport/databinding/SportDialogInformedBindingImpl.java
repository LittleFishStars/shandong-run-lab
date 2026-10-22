package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.sport_test.informed.InformedDialog;
import com.huachenjie.sport.page.mine.sport_test.informed.InformedVM;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class SportDialogInformedBindingImpl extends SportDialogInformedBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36548a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13693a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13694a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f13695a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f13696a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f13697a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f13698a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f13699a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13700b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f13701b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InformedDialog.a f36549a;

        public a a(InformedDialog.a aVar) {
            this.f36549a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36549a.c(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InformedDialog.a f36550a;

        public b a(InformedDialog.a aVar) {
            this.f36550a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36550a.a(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InformedDialog.a f36551a;

        public c a(InformedDialog.a aVar) {
            this.f36551a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36551a.b(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36548a = sparseIntArray;
        sparseIntArray.put(R.id.web_html, 7);
    }

    public SportDialogInformedBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f13693a, f36548a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        c cVarA;
        a aVarA;
        b bVarA;
        synchronized (this) {
            j = this.f13694a;
            this.f13694a = 0L;
        }
        InformedVM informedVM = ((SportDialogInformedBinding) this).f13692a;
        InformedDialog.a aVar = ((SportDialogInformedBinding) this).f13691a;
        long j2 = 11 & j;
        boolean zSafeUnbox = false;
        if (j2 != 0) {
            MutableLiveData<Boolean> mutableLiveDataQ = informedVM != null ? informedVM.q() : null;
            updateLiveDataRegistration(0, mutableLiveDataQ);
            boolean zSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataQ != null ? mutableLiveDataQ.getValue() : null);
            zSafeUnbox = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox2));
            z = zSafeUnbox2;
        } else {
            z = false;
        }
        long j3 = j & 12;
        if (j3 == 0 || aVar == null) {
            cVarA = null;
            aVarA = null;
            bVarA = null;
        } else {
            c cVar = this.f13698a;
            if (cVar == null) {
                cVar = new c();
                this.f13698a = cVar;
            }
            cVarA = cVar.a(aVar);
            a aVar2 = this.f13696a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f13696a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            b bVar = this.f13697a;
            if (bVar == null) {
                bVar = new b();
                this.f13697a = bVar;
            }
            bVarA = bVar.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.l0(((SportDialogInformedBinding) this).f13689a, zSafeUnbox);
            CommonBindingAdapter.l0(this.f13695a, z);
            CommonBindingAdapter.l0(this.b, z);
            CommonBindingAdapter.l0(((SportDialogInformedBinding) this).f13690a, zSafeUnbox);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f13699a, aVarA, null);
            CommonBindingAdapter.q(this.f13701b, bVarA, null);
            CommonBindingAdapter.q(this.b, cVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13694a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13694a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.SportDialogInformedBinding
    public void l(@Nullable InformedDialog.a aVar) {
        ((SportDialogInformedBinding) this).f13691a = aVar;
        synchronized (this) {
            this.f13694a |= 4;
        }
        notifyPropertyChanged(ok0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.SportDialogInformedBinding
    public void m(@Nullable InformedVM informedVM) {
        ((SportDialogInformedBinding) this).f13692a = informedVM;
        synchronized (this) {
            this.f13694a |= 2;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13694a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 == i) {
            m((InformedVM) obj);
        } else {
            if (ok0.k != i) {
                return false;
            }
            l((InformedDialog.a) obj);
        }
        return true;
    }

    public SportDialogInformedBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (LinearLayout) objArr[3], (TextView) objArr[2], (WebView) objArr[7]);
        this.f13694a = -1L;
        ((SportDialogInformedBinding) this).f13689a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f13700b = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f13695a = imageView;
        imageView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[4];
        this.f13699a = bLTextView;
        bLTextView.setTag(null);
        BLTextView bLTextView2 = (BLTextView) objArr[5];
        this.f13701b = bLTextView2;
        bLTextView2.setTag(null);
        ImageView imageView2 = (ImageView) objArr[6];
        this.b = imageView2;
        imageView2.setTag(null);
        ((SportDialogInformedBinding) this).f13690a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
