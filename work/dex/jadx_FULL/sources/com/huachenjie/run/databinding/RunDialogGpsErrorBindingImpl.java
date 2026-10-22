package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.page.activities_run.dialog.GPSErrorDialog;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunDialogGpsErrorBindingImpl extends RunDialogGpsErrorBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35536a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11718a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11719a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f11720a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11721a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f11722a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f11723a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f11724a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11725a;

    @NonNull
    public final BLTextView b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GPSErrorDialog.a f35537a;

        public a a(GPSErrorDialog.a value) {
            this.f35537a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35537a.c(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GPSErrorDialog.a f35538a;

        public b a(GPSErrorDialog.a value) {
            this.f35538a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35538a.a(arg0);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GPSErrorDialog.a f35539a;

        public c a(GPSErrorDialog.a value) {
            this.f35539a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35539a.b(arg0);
        }
    }

    public RunDialogGpsErrorBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f11718a, f35536a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        c cVarA;
        a aVarA;
        b bVarA;
        synchronized (this) {
            j = this.f11719a;
            this.f11719a = 0L;
        }
        GPSErrorDialog.a aVar = ((RunDialogGpsErrorBinding) this).f35535a;
        long j2 = j & 3;
        if (j2 == 0 || aVar == null) {
            cVarA = null;
            aVarA = null;
            bVarA = null;
        } else {
            c cVar = this.f11723a;
            if (cVar == null) {
                cVar = new c();
                this.f11723a = cVar;
            }
            cVarA = cVar.a(aVar);
            a aVar2 = this.f11721a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f11721a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            b bVar = this.f11722a;
            if (bVar == null) {
                bVar = new b();
                this.f11722a = bVar;
            }
            bVarA = bVar.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f11720a, cVarA, null);
            CommonBindingAdapter.q(this.f11725a, aVarA, null);
            CommonBindingAdapter.q(this.b, bVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11719a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11719a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunDialogGpsErrorBinding
    public void k(@Nullable GPSErrorDialog.a Click) {
        ((RunDialogGpsErrorBinding) this).f35535a = Click;
        synchronized (this) {
            this.f11719a |= 1;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.k != variableId) {
            return false;
        }
        k((GPSErrorDialog.a) variable);
        return true;
    }

    public RunDialogGpsErrorBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0);
        this.f11719a = -1L;
        BLLinearLayout bLLinearLayout = (BLLinearLayout) bindings[0];
        this.f11724a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.f11720a = imageView;
        imageView.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[2];
        this.f11725a = bLTextView;
        bLTextView.setTag(null);
        BLTextView bLTextView2 = (BLTextView) bindings[3];
        this.b = bLTextView2;
        bLTextView2.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
