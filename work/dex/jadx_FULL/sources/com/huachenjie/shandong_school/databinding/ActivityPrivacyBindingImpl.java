package com.huachenjie.shandong_school.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.shandong_school.splash.PrivacyActivity;
import com.noober.background.view.BLButton;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class ActivityPrivacyBindingImpl extends ActivityPrivacyBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36022a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12634a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12635a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12636a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f12637a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f12638a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PrivacyActivity.a f36023a;

        public a a(PrivacyActivity.a aVar) {
            this.f36023a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36023a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PrivacyActivity.a f36024a;

        public b a(PrivacyActivity.a aVar) {
            this.f36024a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36024a.b(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36022a = sparseIntArray;
        sparseIntArray.put(2131368306, 3);
    }

    public ActivityPrivacyBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f12634a, f36022a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        b bVarA;
        a aVarA;
        synchronized (this) {
            j = this.f12635a;
            this.f12635a = 0L;
        }
        PrivacyActivity.a aVar = ((ActivityPrivacyBinding) this).f12632a;
        long j2 = j & 3;
        if (j2 == 0 || aVar == null) {
            bVarA = null;
            aVarA = null;
        } else {
            b bVar = this.f12638a;
            if (bVar == null) {
                bVar = new b();
                this.f12638a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f12637a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f12637a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((ActivityPrivacyBinding) this).f12633a, aVarA, null);
            CommonBindingAdapter.q(this.b, bVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12635a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12635a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.shandong_school.databinding.ActivityPrivacyBinding
    public void k(@Nullable PrivacyActivity.a aVar) {
        ((ActivityPrivacyBinding) this).f12632a = aVar;
        synchronized (this) {
            this.f12635a |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (10 != i) {
            return false;
        }
        k((PrivacyActivity.a) obj);
        return true;
    }

    public ActivityPrivacyBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (BLButton) objArr[2], (BLButton) objArr[1], (TextView) objArr[3]);
        this.f12635a = -1L;
        ((ActivityPrivacyBinding) this).f12633a.setTag(null);
        this.b.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f12636a = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
