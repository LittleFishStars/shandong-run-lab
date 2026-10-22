package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.widget.DrawableCenterButton;
import com.huachenjie.mall.widget.OrderDetailServiceView;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallViewOrderDetailServiceBindingImpl extends MallViewOrderDetailServiceBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35096a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11081a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11082a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11083a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final DrawableCenterButton f11084a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11085a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f11086a;

    @NonNull
    public final DrawableCenterButton b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OrderDetailServiceView.a f35097a;

        public a a(OrderDetailServiceView.a aVar) {
            this.f35097a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35097a.b(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OrderDetailServiceView.a f35098a;

        public b a(OrderDetailServiceView.a aVar) {
            this.f35098a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35098a.a(view);
        }
    }

    public MallViewOrderDetailServiceBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f11081a, f35096a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        b bVarA;
        a aVarA;
        synchronized (this) {
            j = this.f11082a;
            this.f11082a = 0L;
        }
        OrderDetailServiceView.a aVar = ((MallViewOrderDetailServiceBinding) this).f35095a;
        long j2 = j & 3;
        if (j2 == 0 || aVar == null) {
            bVarA = null;
            aVarA = null;
        } else {
            b bVar = this.f11086a;
            if (bVar == null) {
                bVar = new b();
                this.f11086a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f11085a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f11085a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f11084a, aVarA, null);
            CommonBindingAdapter.q(this.b, bVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11082a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11082a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallViewOrderDetailServiceBinding
    public void k(@Nullable OrderDetailServiceView.a aVar) {
        ((MallViewOrderDetailServiceBinding) this).f35095a = aVar;
        synchronized (this) {
            this.f11082a |= 1;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.k != i) {
            return false;
        }
        k((OrderDetailServiceView.a) obj);
        return true;
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [android.view.View, com.huachenjie.common.widget.DrawableCenterButton] */
    /* JADX WARN: Type inference failed for: r4v8, types: [android.view.View, com.huachenjie.common.widget.DrawableCenterButton] */
    public MallViewOrderDetailServiceBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f11082a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f11083a = linearLayout;
        linearLayout.setTag(null);
        ?? r4 = (DrawableCenterButton) objArr[1];
        this.f11084a = r4;
        r4.setTag(null);
        ?? r5 = (DrawableCenterButton) objArr[2];
        this.b = r5;
        r5.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
