package com.huachenjie.compat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.compat.page.about_as.AboutAsActivity;
import com.huachenjie.compat.page.about_as.AboutAsVM;
import com.zj.adlib.wk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class ActivityAboutAsBindingImpl extends ActivityAboutAsBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33983a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8983a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8984a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f8985a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f8986a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f8987a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f8988a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f8989a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f8990a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f8991a;

    @NonNull
    public final TextView f;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AboutAsActivity.a f33984a;

        public a a(AboutAsActivity.a aVar) {
            this.f33984a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33984a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AboutAsActivity.a f33985a;

        public b a(AboutAsActivity.a aVar) {
            this.f33985a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33985a.e(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AboutAsActivity.a f33986a;

        public c a(AboutAsActivity.a aVar) {
            this.f33986a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33986a.c(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AboutAsActivity.a f33987a;

        public d a(AboutAsActivity.a aVar) {
            this.f33987a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33987a.b(view);
        }
    }

    public static class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AboutAsActivity.a f33988a;

        public e a(AboutAsActivity.a aVar) {
            this.f33988a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33988a.d(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(10);
        f8983a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{7}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33983a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.compat.R.id.iv_app_icon, 8);
        sparseIntArray.put(com.huachenjie.compat.R.id.tv_app_name, 9);
    }

    public ActivityAboutAsBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, f8983a, f33983a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0033  */
    /* JADX WARN: Code duplicated, block: B:25:0x004d  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        BindingTitleBean value2;
        d dVarA;
        b bVarA;
        c cVarA;
        e eVarA;
        a aVarA;
        synchronized (this) {
            j = this.f8984a;
            this.f8984a = 0L;
        }
        AboutAsVM aboutAsVM = ((ActivityAboutAsBinding) this).f8982a;
        AboutAsActivity.a aVar = ((ActivityAboutAsBinding) this).f8981a;
        if ((23 & j) != 0) {
            if ((j & 21) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveData = aboutAsVM != null ? aboutAsVM.i : null;
                updateLiveDataRegistration(0, mutableLiveData);
                if (mutableLiveData != null) {
                    value2 = mutableLiveData.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 22) == 0) {
                value = null;
            } else {
                MutableLiveData<String> mutableLiveData2 = aboutAsVM != null ? aboutAsVM.j : null;
                updateLiveDataRegistration(1, mutableLiveData2);
                if (mutableLiveData2 != null) {
                    value = mutableLiveData2.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
        }
        long j2 = 24 & j;
        if (j2 == 0 || aVar == null) {
            dVarA = null;
            bVarA = null;
            cVarA = null;
            eVarA = null;
            aVarA = null;
        } else {
            e eVar = this.f8991a;
            if (eVar == null) {
                eVar = new e();
                this.f8991a = eVar;
            }
            eVarA = eVar.a(aVar);
            a aVar2 = this.f8987a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f8987a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            b bVar = this.f8988a;
            if (bVar == null) {
                bVar = new b();
                this.f8988a = bVar;
            }
            bVarA = bVar.a(aVar);
            c cVar = this.f8989a;
            if (cVar == null) {
                cVar = new c();
                this.f8989a = cVar;
            }
            cVarA = cVar.a(aVar);
            d dVar = this.f8990a;
            if (dVar == null) {
                dVar = new d();
                this.f8990a = dVar;
            }
            dVarA = dVar.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((ActivityAboutAsBinding) this).f8979a, bVarA, null);
            CommonBindingAdapter.q(this.b, aVarA, null);
            CommonBindingAdapter.q(this.c, dVarA, null);
            CommonBindingAdapter.q(this.d, cVarA, null);
            CommonBindingAdapter.q(this.e, eVarA, null);
        }
        if ((j & 21) != 0) {
            this.f8986a.k(value2);
        }
        if ((j & 22) != 0) {
            TextViewBindingAdapter.setText(this.f, value);
        }
        ViewDataBinding.executeBindingsOn(this.f8986a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f8984a != 0) {
                return true;
            }
            return this.f8986a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8984a = 16L;
        }
        this.f8986a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.ActivityAboutAsBinding
    public void l(@Nullable AboutAsActivity.a aVar) {
        ((ActivityAboutAsBinding) this).f8981a = aVar;
        synchronized (this) {
            this.f8984a |= 8;
        }
        notifyPropertyChanged(wk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.ActivityAboutAsBinding
    public void m(@Nullable AboutAsVM aboutAsVM) {
        ((ActivityAboutAsBinding) this).f8982a = aboutAsVM;
        synchronized (this) {
            this.f8984a |= 4;
        }
        notifyPropertyChanged(wk0.L);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f8984a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f8984a |= 2;
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
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f8986a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (wk0.L == i) {
            m((AboutAsVM) obj);
        } else {
            if (wk0.k != i) {
                return false;
            }
            l((AboutAsActivity.a) obj);
        }
        return true;
    }

    public ActivityAboutAsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ImageView) objArr[8], (LinearLayout) objArr[1], (TextView) objArr[9], (TextView) objArr[4], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[3]);
        this.f8984a = -1L;
        ((ActivityAboutAsBinding) this).f8979a.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[7];
        this.f8986a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f8985a = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f = textView;
        textView.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
