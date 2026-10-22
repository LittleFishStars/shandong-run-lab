package com.huachenjie.login.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.login.R;
import com.huachenjie.login.page.base.ThirdLoginInterface;
import com.zj.adlib.zk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class LoginLayoutThirdLoginBindingImpl extends LoginLayoutThirdLoginBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34689a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10094a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10095a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10096a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10097a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f10098a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f10099a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ThirdLoginInterface f34690a;

        public a a(ThirdLoginInterface thirdLoginInterface) {
            this.f34690a = thirdLoginInterface;
            if (thirdLoginInterface == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34690a.b(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ThirdLoginInterface f34691a;

        public b a(ThirdLoginInterface thirdLoginInterface) {
            this.f34691a = thirdLoginInterface;
            if (thirdLoginInterface == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34691a.c(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ThirdLoginInterface f34692a;

        public c a(ThirdLoginInterface thirdLoginInterface) {
            this.f34692a = thirdLoginInterface;
            if (thirdLoginInterface == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34692a.e(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34689a = sparseIntArray;
        sparseIntArray.put(R.id.v_line_left, 4);
        sparseIntArray.put(R.id.tv_login_other, 5);
        sparseIntArray.put(R.id.v_line_right, 6);
    }

    public LoginLayoutThirdLoginBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f10094a, f34689a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        c cVarA;
        a aVarA;
        b bVarA;
        synchronized (this) {
            j = this.f10095a;
            this.f10095a = 0L;
        }
        ThirdLoginInterface thirdLoginInterface = ((LoginLayoutThirdLoginBinding) this).f10092a;
        long j2 = j & 3;
        if (j2 == 0 || thirdLoginInterface == null) {
            cVarA = null;
            aVarA = null;
            bVarA = null;
        } else {
            c cVar = this.f10099a;
            if (cVar == null) {
                cVar = new c();
                this.f10099a = cVar;
            }
            cVarA = cVar.a(thirdLoginInterface);
            a aVar = this.f10097a;
            if (aVar == null) {
                aVar = new a();
                this.f10097a = aVar;
            }
            aVarA = aVar.a(thirdLoginInterface);
            b bVar = this.f10098a;
            if (bVar == null) {
                bVar = new b();
                this.f10098a = bVar;
            }
            bVarA = bVar.a(thirdLoginInterface);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((LoginLayoutThirdLoginBinding) this).f10091a, aVarA, null);
            CommonBindingAdapter.q(((LoginLayoutThirdLoginBinding) this).f10093b, cVarA, null);
            CommonBindingAdapter.q(this.c, bVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10095a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10095a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginLayoutThirdLoginBinding
    public void k(@Nullable ThirdLoginInterface thirdLoginInterface) {
        ((LoginLayoutThirdLoginBinding) this).f10092a = thirdLoginInterface;
        synchronized (this) {
            this.f10095a |= 1;
        }
        notifyPropertyChanged(zk0.k);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (zk0.k != i) {
            return false;
        }
        k((ThirdLoginInterface) obj);
        return true;
    }

    public LoginLayoutThirdLoginBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1], (TextView) objArr[3], (TextView) objArr[2], (TextView) objArr[5], (View) objArr[4], (View) objArr[6]);
        this.f10095a = -1L;
        ((LoginLayoutThirdLoginBinding) this).f10091a.setTag(null);
        ((LoginLayoutThirdLoginBinding) this).f10093b.setTag(null);
        this.c.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10096a = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
