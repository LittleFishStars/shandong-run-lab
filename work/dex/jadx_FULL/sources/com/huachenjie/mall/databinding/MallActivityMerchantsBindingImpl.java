package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.MerchantsBean;
import com.huachenjie.mall.page.merchants.MerchantsActivity;
import com.huachenjie.mall.page.merchants.MerchantsVM;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallActivityMerchantsBindingImpl extends MallActivityMerchantsBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34817a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10289a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10290a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f10291a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10292a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final NestedScrollView f10293a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10294a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f10295a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final MallLayoutEmptyDataBinding f10296a;

    @NonNull
    public final TextView d;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MerchantsActivity.a f34818a;

        public a a(MerchantsActivity.a aVar) {
            this.f34818a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34818a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MerchantsActivity.a f34819a;

        public b a(MerchantsActivity.a aVar) {
            this.f34819a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34819a.b(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(17);
        f10289a = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"mall_layout_empty_data"}, new int[]{12}, new int[]{R.layout.mall_layout_empty_data});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34817a = sparseIntArray;
        sparseIntArray.put(R.id.bl_LinearLayout, 13);
        sparseIntArray.put(R.id.app_bar, 14);
        sparseIntArray.put(R.id.tool_bar, 15);
        sparseIntArray.put(R.id.vSplitLine, 16);
    }

    public MallActivityMerchantsBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 17, f10289a, f34817a));
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:53:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:56:0x0105  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        int i;
        String shopUrl;
        String str;
        String shopName;
        String score;
        long j2;
        a aVarA;
        b bVarA;
        int iSafeUnbox;
        boolean close;
        String saleCount;
        synchronized (this) {
            j = this.f10290a;
            this.f10290a = 0L;
        }
        MerchantsVM merchantsVM = ((MallActivityMerchantsBinding) this).f10286a;
        MerchantsActivity.a aVar = ((MallActivityMerchantsBinding) this).f10285a;
        if ((23 & j) != 0) {
            if ((j & 21) != 0) {
                BaseViewModel.b bVarE = merchantsVM != null ? merchantsVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(0, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            if ((j & 22) != 0) {
                MutableLiveData<MerchantsBean> mutableLiveDataI = merchantsVM != null ? merchantsVM.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                MerchantsBean value = mutableLiveDataI != null ? mutableLiveDataI.getValue() : null;
                if (value != null) {
                    shopName = value.getShopName();
                    score = value.formatScore();
                    saleCount = value.formatSaleCount();
                    close = value.getClose();
                    shopUrl = value.getShopUrl();
                } else {
                    close = false;
                    shopUrl = null;
                    shopName = null;
                    score = null;
                    saleCount = null;
                }
                z = close;
                z2 = !close;
                String str2 = saleCount;
                i = iSafeUnbox;
                str = str2;
            } else {
                i = iSafeUnbox;
                z = false;
                z2 = false;
            }
            j2 = j & 24;
            if (j2 != 0 || aVar == null) {
                aVarA = null;
                bVarA = null;
            } else {
                b bVar = this.f10295a;
                if (bVar == null) {
                    bVar = new b();
                    this.f10295a = bVar;
                }
                bVarA = bVar.a(aVar);
                a aVar2 = this.f10294a;
                if (aVar2 == null) {
                    aVar2 = new a();
                    this.f10294a = aVar2;
                }
                aVarA = aVar2.a(aVar);
            }
            if ((22 & j) != 0) {
                aw9.d(((MallActivityMerchantsBinding) this).f10284a, shopUrl, false, null);
                CommonBindingAdapter.l0(this.f10293a, z);
                TextViewBindingAdapter.setText(this.d, str);
                CommonBindingAdapter.l0(((MallActivityMerchantsBinding) this).f10282a, z2);
                TextViewBindingAdapter.setText(((MallActivityMerchantsBinding) this).f10279a, shopName);
                TextViewBindingAdapter.setText(this.b, shopName);
                TextViewBindingAdapter.setText(this.c, score);
                CommonBindingAdapter.l0(((MallActivityMerchantsBinding) this).f10281a, z2);
            }
            if (j2 != 0) {
                CommonBindingAdapter.q(((MallActivityMerchantsBinding) this).f10278a, aVarA, null);
                CommonBindingAdapter.q(((MallActivityMerchantsBinding) this).f10288a, bVarA, null);
            }
            if ((j & 21) != 0) {
                CommonBindingAdapter.O(this.f10292a, 0, i, 0, 0, null);
            }
            ViewDataBinding.executeBindingsOn(this.f10296a);
        }
        z = false;
        z2 = false;
        i = 0;
        shopUrl = null;
        str = null;
        shopName = null;
        score = null;
        j2 = j & 24;
        if (j2 != 0) {
            aVarA = null;
            bVarA = null;
        } else {
            aVarA = null;
            bVarA = null;
        }
        if ((22 & j) != 0) {
            aw9.d(((MallActivityMerchantsBinding) this).f10284a, shopUrl, false, null);
            CommonBindingAdapter.l0(this.f10293a, z);
            TextViewBindingAdapter.setText(this.d, str);
            CommonBindingAdapter.l0(((MallActivityMerchantsBinding) this).f10282a, z2);
            TextViewBindingAdapter.setText(((MallActivityMerchantsBinding) this).f10279a, shopName);
            TextViewBindingAdapter.setText(this.b, shopName);
            TextViewBindingAdapter.setText(this.c, score);
            CommonBindingAdapter.l0(((MallActivityMerchantsBinding) this).f10281a, z2);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((MallActivityMerchantsBinding) this).f10278a, aVarA, null);
            CommonBindingAdapter.q(((MallActivityMerchantsBinding) this).f10288a, bVarA, null);
        }
        if ((j & 21) != 0) {
            CommonBindingAdapter.O(this.f10292a, 0, i, 0, 0, null);
        }
        ViewDataBinding.executeBindingsOn(this.f10296a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10290a != 0) {
                return true;
            }
            return this.f10296a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10290a = 16L;
        }
        this.f10296a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityMerchantsBinding
    public void l(@Nullable MerchantsActivity.a aVar) {
        ((MallActivityMerchantsBinding) this).f10285a = aVar;
        synchronized (this) {
            this.f10290a |= 8;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityMerchantsBinding
    public void m(@Nullable MerchantsVM merchantsVM) {
        ((MallActivityMerchantsBinding) this).f10286a = merchantsVM;
        synchronized (this) {
            this.f10290a |= 4;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<MerchantsBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10290a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10290a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f10296a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            m((MerchantsVM) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((MerchantsActivity.a) obj);
        }
        return true;
    }

    public MallActivityMerchantsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (AppBarLayout) objArr[14], (AvatarView) objArr[5], (BLLinearLayout) objArr[13], (ImageView) objArr[11], (SlidingTabLayout) objArr[2], (Toolbar) objArr[15], (BLTextView) objArr[9], (TextView) objArr[6], (TextView) objArr[10], (TextView) objArr[7], (View) objArr[16], (ViewPager) objArr[3]);
        this.f10290a = -1L;
        ((MallActivityMerchantsBinding) this).f10284a.setTag(null);
        ((MallActivityMerchantsBinding) this).f10278a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f10291a = frameLayout;
        frameLayout.setTag(null);
        NestedScrollView nestedScrollView = (NestedScrollView) objArr[1];
        this.f10293a = nestedScrollView;
        nestedScrollView.setTag(null);
        MallLayoutEmptyDataBinding mallLayoutEmptyDataBinding = (MallLayoutEmptyDataBinding) objArr[12];
        this.f10296a = mallLayoutEmptyDataBinding;
        setContainedBinding(mallLayoutEmptyDataBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[4];
        this.f10292a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[8];
        this.d = textView;
        textView.setTag(null);
        ((MallActivityMerchantsBinding) this).f10282a.setTag(null);
        ((MallActivityMerchantsBinding) this).f10288a.setTag(null);
        ((MallActivityMerchantsBinding) this).f10279a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        ((MallActivityMerchantsBinding) this).f10281a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
