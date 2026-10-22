package com.huachenjie.mall.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.ImageViewBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.mall.page.pay.PayResultActivity;
import com.huachenjie.mall.page.pay.PayResultVM;
import com.noober.background.view.BLTextView;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallActivityPayResultBindingImpl extends MallActivityPayResultBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34833a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10323a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10324a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10325a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f10326a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10327a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f10328a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f10329b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PayResultActivity.a f34834a;

        public a a(PayResultActivity.a aVar) {
            this.f34834a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34834a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PayResultActivity.a f34835a;

        public b a(PayResultActivity.a aVar) {
            this.f34835a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34835a.b(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(8);
        f10323a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{7}, new int[]{R.layout.layout_toolbar_binding});
        f34833a = null;
    }

    public MallActivityPayResultBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f10323a, f34833a));
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00c9  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        BindingTitleBean value;
        String string;
        Drawable drawable;
        Drawable drawable2;
        String string2;
        a aVarA;
        b bVarA;
        Context context;
        int i;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f10324a;
            this.f10324a = 0L;
        }
        PayResultVM payResultVM = ((MallActivityPayResultBinding) this).f10321a;
        PayResultActivity.a aVar = ((MallActivityPayResultBinding) this).f10320a;
        if ((45 & j) != 0) {
            long j4 = j & 41;
            if (j4 != 0) {
                MutableLiveData<Boolean> mutableLiveDataJ = payResultVM != null ? payResultVM.j() : null;
                updateLiveDataRegistration(0, mutableLiveDataJ);
                boolean zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataJ != null ? mutableLiveDataJ.getValue() : null);
                if (j4 != 0) {
                    if (zSafeUnbox) {
                        j2 = j | 128 | 512 | 2048;
                        j3 = 8192;
                    } else {
                        j2 = j | 64 | 256 | 1024;
                        j3 = 4096;
                    }
                    j = j2 | j3;
                }
                string = this.f10329b.getResources().getString(zSafeUnbox ? com.huachenjie.mall.R.string.mall_pay_success_info : com.huachenjie.mall.R.string.mall_pay_fail_info);
                string2 = ((MallActivityPayResultBinding) this).f34832a.getResources().getString(zSafeUnbox ? com.huachenjie.mall.R.string.mall_pay_success_desc : com.huachenjie.mall.R.string.mall_pay_fail_desc);
                drawable = zSafeUnbox ? AppCompatResources.getDrawable(this.f10325a.getContext(), com.huachenjie.mall.R.drawable.mall_bg_result_success) : AppCompatResources.getDrawable(this.f10325a.getContext(), com.huachenjie.mall.R.drawable.mall_bg_result_fail);
                if (zSafeUnbox) {
                    context = this.b.getContext();
                    i = com.huachenjie.mall.R.drawable.mall_ic_pay_success;
                } else {
                    context = this.b.getContext();
                    i = com.huachenjie.mall.R.drawable.mall_ic_pay_fail;
                }
                drawable2 = AppCompatResources.getDrawable(context, i);
            } else {
                string = null;
                drawable = null;
                drawable2 = null;
                string2 = null;
            }
            if ((j & 44) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = payResultVM != null ? payResultVM.i() : null;
                updateLiveDataRegistration(2, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            string = null;
            drawable = null;
            drawable2 = null;
            string2 = null;
        }
        long j5 = j & 48;
        if (j5 == 0 || aVar == null) {
            aVarA = null;
            bVarA = null;
        } else {
            b bVar = this.f10328a;
            if (bVar == null) {
                bVar = new b();
                this.f10328a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f10327a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f10327a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if ((j & 41) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.f10325a, drawable);
            ImageViewBindingAdapter.setImageDrawable(this.b, drawable2);
            TextViewBindingAdapter.setText(this.f10329b, string);
            TextViewBindingAdapter.setText(((MallActivityPayResultBinding) this).f34832a, string2);
        }
        if ((j & 44) != 0) {
            ((MallActivityPayResultBinding) this).f10319a.k(value);
        }
        if (j5 != 0) {
            CommonBindingAdapter.q(((MallActivityPayResultBinding) this).f10322a, aVarA, null);
            CommonBindingAdapter.q(((MallActivityPayResultBinding) this).b, bVarA, null);
        }
        ViewDataBinding.executeBindingsOn(((MallActivityPayResultBinding) this).f10319a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10324a != 0) {
                return true;
            }
            return ((MallActivityPayResultBinding) this).f10319a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10324a = 32L;
        }
        ((MallActivityPayResultBinding) this).f10319a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityPayResultBinding
    public void l(@Nullable PayResultActivity.a aVar) {
        ((MallActivityPayResultBinding) this).f10320a = aVar;
        synchronized (this) {
            this.f10324a |= 16;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityPayResultBinding
    public void m(@Nullable PayResultVM payResultVM) {
        ((MallActivityPayResultBinding) this).f10321a = payResultVM;
        synchronized (this) {
            this.f10324a |= 8;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10324a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10324a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return n((LayoutToolbarBindingBinding) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return p((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10324a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((MallActivityPayResultBinding) this).f10319a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            m((PayResultVM) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((PayResultActivity.a) obj);
        }
        return true;
    }

    public MallActivityPayResultBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (LayoutToolbarBindingBinding) objArr[7], (TextView) objArr[4], (BLTextView) objArr[6], (BLTextView) objArr[5]);
        this.f10324a = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f10326a = relativeLayout;
        relativeLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f10325a = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[2];
        this.b = imageView2;
        imageView2.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f10329b = textView;
        textView.setTag(null);
        setContainedBinding(((MallActivityPayResultBinding) this).f10319a);
        ((MallActivityPayResultBinding) this).f34832a.setTag(null);
        ((MallActivityPayResultBinding) this).f10322a.setTag(null);
        ((MallActivityPayResultBinding) this).b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
