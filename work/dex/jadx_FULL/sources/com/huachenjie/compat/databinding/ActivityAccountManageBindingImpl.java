package com.huachenjie.compat.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.huachenjie.compat.page.account.AccountManageActivity;
import com.huachenjie.compat.page.account.AccountManageVM;
import com.zj.adlib.wk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class ActivityAccountManageBindingImpl extends ActivityAccountManageBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33990a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8993a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8994a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f8995a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8996a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8997a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f8998a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f8999a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f9000a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f9001a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f9002a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f9003a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9004b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f9005b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9006c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f9007c;

    @NonNull
    public final LinearLayout d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final TextView f9008d;

    @NonNull
    public final LinearLayout e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NonNull
    public final TextView f9009e;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AccountManageActivity.a f33991a;

        public a a(AccountManageActivity.a aVar) {
            this.f33991a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33991a.g(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AccountManageActivity.a f33992a;

        public b a(AccountManageActivity.a aVar) {
            this.f33992a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33992a.j(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AccountManageActivity.a f33993a;

        public c a(AccountManageActivity.a aVar) {
            this.f33993a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33993a.h(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AccountManageActivity.a f33994a;

        public d a(AccountManageActivity.a aVar) {
            this.f33994a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33994a.e(view);
        }
    }

    public static class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AccountManageActivity.a f33995a;

        public e a(AccountManageActivity.a aVar) {
            this.f33995a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33995a.d(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(14);
        f8993a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{13}, new int[]{R.layout.layout_toolbar_binding});
        f33990a = null;
    }

    public ActivityAccountManageBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, f8993a, f33990a));
    }

    /* JADX WARN: Code duplicated, block: B:102:0x017e  */
    /* JADX WARN: Code duplicated, block: B:93:0x015e  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        Drawable drawable;
        BindingTitleBean bindingTitleBean;
        String str2;
        String str3;
        boolean z;
        int i;
        int colorFromResource;
        boolean z2;
        String str4;
        Drawable drawable2;
        Drawable drawable3;
        int i2;
        d dVarA;
        a aVar;
        c cVar;
        b bVar;
        e eVar;
        boolean zSafeUnbox;
        boolean zSafeUnbox2;
        String str5;
        Drawable drawable4;
        Drawable drawable5;
        int colorFromResource2;
        String str6;
        BindingTitleBean value;
        String value2;
        long j2;
        long j3;
        Context context;
        int i3;
        long j4;
        long j5;
        long j6;
        long j7;
        synchronized (this) {
            j = this.f8994a;
            this.f8994a = 0L;
        }
        AccountManageVM accountManageVM = ((ActivityAccountManageBinding) this).f8992a;
        AccountManageActivity.a aVar2 = ((ActivityAccountManageBinding) this).f33989a;
        if ((767 & j) != 0) {
            if ((j & 641) != 0) {
                MutableLiveData<Boolean> mutableLiveDataR = accountManageVM != null ? accountManageVM.r() : null;
                updateLiveDataRegistration(0, mutableLiveDataR);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataR != null ? mutableLiveDataR.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 642) != 0) {
                MutableLiveData<Boolean> mutableLiveDataS = accountManageVM != null ? accountManageVM.s() : null;
                updateLiveDataRegistration(1, mutableLiveDataS);
                zSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataS != null ? mutableLiveDataS.getValue() : null);
            } else {
                zSafeUnbox2 = false;
            }
            long j8 = j & 644;
            if (j8 != 0) {
                MutableLiveData<Boolean> mutableLiveDataO = accountManageVM != null ? accountManageVM.o() : null;
                updateLiveDataRegistration(2, mutableLiveDataO);
                boolean zSafeUnbox3 = ViewDataBinding.safeUnbox(mutableLiveDataO != null ? mutableLiveDataO.getValue() : null);
                if (j8 != 0) {
                    if (zSafeUnbox3) {
                        j6 = j | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID | 131072;
                        j7 = 8388608;
                    } else {
                        j6 = j | PlaybackStateCompat.ACTION_PREPARE | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                        j7 = PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED;
                    }
                    j = j6 | j7;
                }
                str5 = zSafeUnbox3 ? "解绑" : "未绑定";
                drawable4 = zSafeUnbox3 ? AppCompatResources.getDrawable(this.f8995a.getContext(), com.huachenjie.compat.R.drawable.ic_login_alipay) : AppCompatResources.getDrawable(this.f8995a.getContext(), com.huachenjie.compat.R.drawable.ic_login_alipay_unbind);
                colorFromResource = ViewDataBinding.getColorFromResource(this.f8997a, zSafeUnbox3 ? com.huachenjie.compat.R.color.color_191F20 : com.huachenjie.compat.R.color.color_CCCCCC);
            } else {
                str5 = null;
                drawable4 = null;
                colorFromResource = 0;
            }
            long j9 = j & 648;
            if (j9 != 0) {
                MutableLiveData<Boolean> mutableLiveDataP = accountManageVM != null ? accountManageVM.p() : null;
                updateLiveDataRegistration(3, mutableLiveDataP);
                boolean zSafeUnbox4 = ViewDataBinding.safeUnbox(mutableLiveDataP != null ? mutableLiveDataP.getValue() : null);
                if (j9 != 0) {
                    if (zSafeUnbox4) {
                        j4 = j | 2048 | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                        j5 = 2097152;
                    } else {
                        j4 = j | 1024 | 262144;
                        j5 = 1048576;
                    }
                    j = j4 | j5;
                }
                colorFromResource2 = ViewDataBinding.getColorFromResource(this.f9009e, zSafeUnbox4 ? com.huachenjie.compat.R.color.color_191F20 : com.huachenjie.compat.R.color.color_CCCCCC);
                str6 = zSafeUnbox4 ? "解绑" : "未绑定";
                if (zSafeUnbox4) {
                    context = this.c.getContext();
                    i3 = com.huachenjie.compat.R.drawable.ic_login_qq;
                } else {
                    context = this.c.getContext();
                    i3 = com.huachenjie.compat.R.drawable.ic_login_qq_unbind;
                }
                drawable5 = AppCompatResources.getDrawable(context, i3);
            } else {
                drawable5 = null;
                colorFromResource2 = 0;
                str6 = null;
            }
            if ((j & 656) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = accountManageVM != null ? accountManageVM.i() : null;
                updateLiveDataRegistration(4, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 672) == 0) {
                value2 = null;
            } else {
                MutableLiveData<String> mutableLiveDataL = accountManageVM != null ? accountManageVM.l() : null;
                updateLiveDataRegistration(5, mutableLiveDataL);
                if (mutableLiveDataL != null) {
                    value2 = mutableLiveDataL.getValue();
                } else {
                    value2 = null;
                }
            }
            long j10 = j & 704;
            if (j10 != 0) {
                MutableLiveData<Boolean> mutableLiveDataQ = accountManageVM != null ? accountManageVM.q() : null;
                updateLiveDataRegistration(6, mutableLiveDataQ);
                boolean zSafeUnbox5 = ViewDataBinding.safeUnbox(mutableLiveDataQ != null ? mutableLiveDataQ.getValue() : null);
                if (j10 != 0) {
                    if (zSafeUnbox5) {
                        j2 = j | 8192 | 33554432;
                        j3 = 134217728;
                    } else {
                        j2 = j | 4096 | 16777216;
                        j3 = 67108864;
                    }
                    j = j2 | j3;
                }
                drawable = AppCompatResources.getDrawable(this.b.getContext(), zSafeUnbox5 ? com.huachenjie.compat.R.drawable.ic_login_wx : com.huachenjie.compat.R.drawable.ic_login_wx_unbind);
                int colorFromResource3 = zSafeUnbox5 ? ViewDataBinding.getColorFromResource(this.f9008d, com.huachenjie.compat.R.color.color_191F20) : ViewDataBinding.getColorFromResource(this.f9008d, com.huachenjie.compat.R.color.color_CCCCCC);
                str = zSafeUnbox5 ? "解绑" : "未绑定";
                drawable3 = drawable5;
                i2 = colorFromResource2;
                z2 = zSafeUnbox;
                str4 = str5;
                str2 = value2;
                z = zSafeUnbox2;
                str3 = str6;
                bindingTitleBean = value;
                drawable2 = drawable4;
                i = colorFromResource3;
                j = j;
            } else {
                BindingTitleBean bindingTitleBean2 = value;
                drawable3 = drawable5;
                i2 = colorFromResource2;
                str = null;
                drawable = null;
                z2 = zSafeUnbox;
                str4 = str5;
                str2 = value2;
                z = zSafeUnbox2;
                str3 = str6;
                bindingTitleBean = bindingTitleBean2;
                drawable2 = drawable4;
                i = 0;
            }
        } else {
            str = null;
            drawable = null;
            bindingTitleBean = null;
            str2 = null;
            str3 = null;
            z = false;
            i = 0;
            colorFromResource = 0;
            z2 = false;
            str4 = null;
            drawable2 = null;
            drawable3 = null;
            i2 = 0;
        }
        long j11 = j & 768;
        if (j11 == 0 || aVar2 == null) {
            dVarA = null;
            aVar = null;
            cVar = null;
            bVar = null;
            eVar = null;
        } else {
            e eVar2 = this.f9003a;
            if (eVar2 == null) {
                eVar2 = new e();
                this.f9003a = eVar2;
            }
            e eVarA = eVar2.a(aVar2);
            a aVar3 = this.f8999a;
            if (aVar3 == null) {
                aVar3 = new a();
                this.f8999a = aVar3;
            }
            a aVarA = aVar3.a(aVar2);
            b bVar2 = this.f9000a;
            if (bVar2 == null) {
                bVar2 = new b();
                this.f9000a = bVar2;
            }
            b bVarA = bVar2.a(aVar2);
            c cVar2 = this.f9001a;
            if (cVar2 == null) {
                cVar2 = new c();
                this.f9001a = cVar2;
            }
            c cVarA = cVar2.a(aVar2);
            d dVar = this.f9002a;
            if (dVar == null) {
                dVar = new d();
                this.f9002a = dVar;
            }
            dVarA = dVar.a(aVar2);
            aVar = aVarA;
            bVar = bVarA;
            cVar = cVarA;
            eVar = eVarA;
        }
        if ((j & 656) != 0) {
            this.f8998a.k(bindingTitleBean);
        }
        if (j11 != 0) {
            CommonBindingAdapter.q(this.f9004b, aVar, null);
            CommonBindingAdapter.q(this.f9005b, eVar, null);
            CommonBindingAdapter.q(this.f9006c, bVar, null);
            CommonBindingAdapter.q(this.d, cVar, null);
            CommonBindingAdapter.q(this.e, dVarA, null);
        }
        if ((644 & j) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.f8995a, drawable2);
            TextViewBindingAdapter.setText(this.f8997a, str4);
            this.f8997a.setTextColor(colorFromResource);
        }
        if ((672 & j) != 0) {
            TextViewBindingAdapter.setText(this.f9007c, str2);
        }
        if ((j & 642) != 0) {
            CommonBindingAdapter.l0(this.f9006c, z);
        }
        if ((704 & j) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.b, drawable);
            TextViewBindingAdapter.setText(this.f9008d, str);
            this.f9008d.setTextColor(i);
        }
        if ((j & 641) != 0) {
            CommonBindingAdapter.l0(this.d, z2);
        }
        if ((j & 648) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.c, drawable3);
            TextViewBindingAdapter.setText(this.f9009e, str3);
            this.f9009e.setTextColor(i2);
        }
        ViewDataBinding.executeBindingsOn(this.f8998a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f8994a != 0) {
                return true;
            }
            return this.f8998a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8994a = 512L;
        }
        this.f8998a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.ActivityAccountManageBinding
    public void l(@Nullable AccountManageActivity.a aVar) {
        ((ActivityAccountManageBinding) this).f33989a = aVar;
        synchronized (this) {
            this.f8994a |= 256;
        }
        notifyPropertyChanged(wk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.ActivityAccountManageBinding
    public void m(@Nullable AccountManageVM accountManageVM) {
        ((ActivityAccountManageBinding) this).f8992a = accountManageVM;
        synchronized (this) {
            this.f8994a |= 128;
        }
        notifyPropertyChanged(wk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f8994a |= 4;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f8994a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return q((MutableLiveData) obj, i2);
            case 1:
                return r((MutableLiveData) obj, i2);
            case 2:
                return n((MutableLiveData) obj, i2);
            case 3:
                return o((MutableLiveData) obj, i2);
            case 4:
                return t((MutableLiveData) obj, i2);
            case 5:
                return s((MutableLiveData) obj, i2);
            case 6:
                return p((MutableLiveData) obj, i2);
            default:
                return false;
        }
    }

    public final boolean p(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f8994a |= 64;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f8994a |= 1;
        }
        return true;
    }

    public final boolean r(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f8994a |= 2;
        }
        return true;
    }

    public final boolean s(MutableLiveData<String> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f8994a |= 32;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f8998a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (wk0.p0 == i) {
            m((AccountManageVM) obj);
        } else {
            if (wk0.k != i) {
                return false;
            }
            l((AccountManageActivity.a) obj);
        }
        return true;
    }

    public final boolean t(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f8994a |= 16;
        }
        return true;
    }

    public ActivityAccountManageBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7);
        this.f8994a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[13];
        this.f8998a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f8996a = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[1];
        this.f9004b = linearLayout2;
        linearLayout2.setTag(null);
        ImageView imageView = (ImageView) objArr[10];
        this.f8995a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[11];
        this.f8997a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[12];
        this.f9005b = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[2];
        this.f9007c = textView3;
        textView3.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[3];
        this.f9006c = linearLayout3;
        linearLayout3.setTag(null);
        ImageView imageView2 = (ImageView) objArr[4];
        this.b = imageView2;
        imageView2.setTag(null);
        TextView textView4 = (TextView) objArr[5];
        this.f9008d = textView4;
        textView4.setTag(null);
        LinearLayout linearLayout4 = (LinearLayout) objArr[6];
        this.d = linearLayout4;
        linearLayout4.setTag(null);
        ImageView imageView3 = (ImageView) objArr[7];
        this.c = imageView3;
        imageView3.setTag(null);
        TextView textView5 = (TextView) objArr[8];
        this.f9009e = textView5;
        textView5.setTag(null);
        LinearLayout linearLayout5 = (LinearLayout) objArr[9];
        this.e = linearLayout5;
        linearLayout5.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
