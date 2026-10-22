package com.huachenjie.mall.databinding;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.base.bean.mall.OrderDetailBean;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.mall.page.order_detail.OrderDetailActivity;
import com.huachenjie.mall.page.order_detail.OrderDetailGoodsAdapter;
import com.huachenjie.mall.page.order_detail.OrderDetailVM;
import com.noober.background.view.BLButton;
import com.zj.adlib.hk0;
import com.zj.adlib.xq8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallActivityOrderDetailBindingImpl extends MallActivityOrderDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34823a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10307a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10308a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10309a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f10310a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10311a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f10312a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f10313a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f10314a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f10315a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f f10316a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g f10317a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public h f10318a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OrderDetailActivity.ClickProxy f34824a;

        public a a(OrderDetailActivity.ClickProxy clickProxy) {
            this.f34824a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34824a.j(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OrderDetailActivity.ClickProxy f34825a;

        public b a(OrderDetailActivity.ClickProxy clickProxy) {
            this.f34825a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34825a.f(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OrderDetailActivity.ClickProxy f34826a;

        public c a(OrderDetailActivity.ClickProxy clickProxy) {
            this.f34826a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34826a.b(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OrderDetailActivity.ClickProxy f34827a;

        public d a(OrderDetailActivity.ClickProxy clickProxy) {
            this.f34827a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34827a.h(view);
        }
    }

    public static class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OrderDetailActivity.ClickProxy f34828a;

        public e a(OrderDetailActivity.ClickProxy clickProxy) {
            this.f34828a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34828a.a(view);
        }
    }

    public static class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OrderDetailActivity.ClickProxy f34829a;

        public f a(OrderDetailActivity.ClickProxy clickProxy) {
            this.f34829a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34829a.g(view);
        }
    }

    public static class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OrderDetailActivity.ClickProxy f34830a;

        public g a(OrderDetailActivity.ClickProxy clickProxy) {
            this.f34830a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34830a.e(view);
        }
    }

    public static class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OrderDetailActivity.ClickProxy f34831a;

        public h a(OrderDetailActivity.ClickProxy clickProxy) {
            this.f34831a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34831a.c(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(12);
        f10307a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{11}, new int[]{R.layout.layout_toolbar_binding});
        f34823a = null;
    }

    public MallActivityOrderDetailBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, f10307a, f34823a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:70:0x010a  */
    /* JADX WARN: Code duplicated, block: B:90:0x0154  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        BindingTitleBean value;
        Integer value2;
        boolean zIsWaitCommentStatus;
        String string;
        int colorFromResource;
        String value3;
        OrderDetailGoodsAdapter value4;
        boolean z;
        boolean zSafeUnbox;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        g gVar;
        e eVar;
        c cVar;
        h hVar;
        d dVar;
        b bVar;
        f fVar;
        a aVar;
        boolean zIsWaitReceiveStatus;
        boolean logisticTrackEnable;
        boolean zIsWaitPayOrPayingStatus;
        boolean zShowLearOrSeenButton;
        int i;
        Resources resources;
        int i2;
        synchronized (this) {
            j = this.f10308a;
            this.f10308a = 0L;
        }
        OrderDetailVM orderDetailVM = ((MallActivityOrderDetailBinding) this).f10305a;
        OrderDetailActivity.ClickProxy clickProxy = ((MallActivityOrderDetailBinding) this).f10304a;
        if ((751 & j) != 0) {
            if ((j & 641) == 0) {
                value2 = null;
            } else {
                MutableLiveData<Integer> mutableLiveDataU = orderDetailVM != null ? orderDetailVM.u() : null;
                updateLiveDataRegistration(0, mutableLiveDataU);
                if (mutableLiveDataU != null) {
                    value2 = mutableLiveDataU.getValue();
                } else {
                    value2 = null;
                }
            }
            long j2 = j & 642;
            if (j2 != 0) {
                MutableLiveData<OrderDetailBean> mutableLiveDataQ = orderDetailVM != null ? orderDetailVM.q() : null;
                updateLiveDataRegistration(1, mutableLiveDataQ);
                OrderDetailBean value5 = mutableLiveDataQ != null ? mutableLiveDataQ.getValue() : null;
                if (value5 != null) {
                    zIsWaitReceiveStatus = value5.isWaitReceiveStatus();
                    logisticTrackEnable = value5.getLogisticTrackEnable();
                    int categoryView = value5.getCategoryView();
                    boolean commentViewEnable = value5.getCommentViewEnable();
                    zIsWaitPayOrPayingStatus = value5.isWaitPayOrPayingStatus();
                    zShowLearOrSeenButton = value5.showLearOrSeenButton();
                    zIsWaitCommentStatus = value5.isWaitCommentStatus();
                    i = categoryView;
                    z = commentViewEnable;
                } else {
                    zIsWaitCommentStatus = false;
                    i = 0;
                    z = false;
                    zIsWaitReceiveStatus = false;
                    logisticTrackEnable = false;
                    zIsWaitPayOrPayingStatus = false;
                    zShowLearOrSeenButton = false;
                }
                if (j2 != 0) {
                    j |= zIsWaitReceiveStatus ? 2048L : 1024L;
                }
                colorFromResource = ViewDataBinding.getColorFromResource(this.g, zIsWaitReceiveStatus ? com.huachenjie.mall.R.color.color_2C3E50 : com.huachenjie.mall.R.color.color_650aec);
                boolean z6 = i == 1;
                if ((j & 642) != 0) {
                    j |= z6 ? 8192L : 4096L;
                }
                if (z6) {
                    resources = this.g.getResources();
                    i2 = com.huachenjie.mall.R.string.mall_my_order_menu_start_learn;
                } else {
                    resources = this.g.getResources();
                    i2 = com.huachenjie.mall.R.string.mall_my_order_menu_start_see;
                }
                string = resources.getString(i2);
            } else {
                zIsWaitCommentStatus = false;
                string = null;
                colorFromResource = 0;
                z = false;
                zIsWaitReceiveStatus = false;
                logisticTrackEnable = false;
                zIsWaitPayOrPayingStatus = false;
                zShowLearOrSeenButton = false;
            }
            if ((j & 644) == 0) {
                value3 = null;
            } else {
                MutableLiveData<String> mutableLiveDataT = orderDetailVM != null ? orderDetailVM.t() : null;
                updateLiveDataRegistration(2, mutableLiveDataT);
                if (mutableLiveDataT != null) {
                    value3 = mutableLiveDataT.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 648) == 0) {
                value4 = null;
            } else {
                MutableLiveData<OrderDetailGoodsAdapter> mutableLiveDataP = orderDetailVM != null ? orderDetailVM.p() : null;
                updateLiveDataRegistration(3, mutableLiveDataP);
                if (mutableLiveDataP != null) {
                    value4 = mutableLiveDataP.getValue();
                } else {
                    value4 = null;
                }
            }
            if ((j & 672) != 0) {
                MutableLiveData<Boolean> mutableLiveDataV = orderDetailVM != null ? orderDetailVM.v() : null;
                updateLiveDataRegistration(5, mutableLiveDataV);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataV != null ? mutableLiveDataV.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 704) == 0) {
                z2 = zIsWaitReceiveStatus;
                z3 = logisticTrackEnable;
                z4 = zIsWaitPayOrPayingStatus;
                z5 = zShowLearOrSeenButton;
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = orderDetailVM != null ? orderDetailVM.i() : null;
                updateLiveDataRegistration(6, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                    z2 = zIsWaitReceiveStatus;
                    z3 = logisticTrackEnable;
                    z4 = zIsWaitPayOrPayingStatus;
                    z5 = zShowLearOrSeenButton;
                } else {
                    z2 = zIsWaitReceiveStatus;
                    z3 = logisticTrackEnable;
                    z4 = zIsWaitPayOrPayingStatus;
                    z5 = zShowLearOrSeenButton;
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
            zIsWaitCommentStatus = false;
            string = null;
            colorFromResource = 0;
            value3 = null;
            value4 = null;
            z = false;
            zSafeUnbox = false;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
        }
        long j3 = j & 768;
        if (j3 == 0 || clickProxy == null) {
            gVar = null;
            eVar = null;
            cVar = null;
            hVar = null;
            dVar = null;
            bVar = null;
            fVar = null;
            aVar = null;
        } else {
            h hVar2 = this.f10318a;
            if (hVar2 == null) {
                hVar2 = new h();
                this.f10318a = hVar2;
            }
            h hVarA = hVar2.a(clickProxy);
            a aVar2 = this.f10311a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f10311a = aVar2;
            }
            a aVarA = aVar2.a(clickProxy);
            b bVar2 = this.f10312a;
            if (bVar2 == null) {
                bVar2 = new b();
                this.f10312a = bVar2;
            }
            b bVarA = bVar2.a(clickProxy);
            c cVar2 = this.f10313a;
            if (cVar2 == null) {
                cVar2 = new c();
                this.f10313a = cVar2;
            }
            c cVarA = cVar2.a(clickProxy);
            d dVar2 = this.f10314a;
            if (dVar2 == null) {
                dVar2 = new d();
                this.f10314a = dVar2;
            }
            d dVarA = dVar2.a(clickProxy);
            e eVar2 = this.f10315a;
            if (eVar2 == null) {
                eVar2 = new e();
                this.f10315a = eVar2;
            }
            e eVarA = eVar2.a(clickProxy);
            f fVar2 = this.f10316a;
            if (fVar2 == null) {
                fVar2 = new f();
                this.f10316a = fVar2;
            }
            f fVarA = fVar2.a(clickProxy);
            g gVar2 = this.f10317a;
            if (gVar2 == null) {
                gVar2 = new g();
                this.f10317a = gVar2;
            }
            g gVarA = gVar2.a(clickProxy);
            hVar = hVarA;
            gVar = gVarA;
            eVar = eVarA;
            aVar = aVarA;
            cVar = cVarA;
            dVar = dVarA;
            bVar = bVarA;
            fVar = fVarA;
        }
        if ((j & 642) != 0) {
            boolean z7 = z4;
            CommonBindingAdapter.l0(((MallActivityOrderDetailBinding) this).f10306a, z7);
            CommonBindingAdapter.l0(this.b, z7);
            CommonBindingAdapter.l0(this.c, zIsWaitCommentStatus);
            CommonBindingAdapter.l0(this.d, z3);
            CommonBindingAdapter.l0(this.e, z7);
            CommonBindingAdapter.l0(this.f, z);
            CommonBindingAdapter.l0(this.g, z5);
            TextViewBindingAdapter.setText(this.g, string);
            this.g.setTextColor(colorFromResource);
            CommonBindingAdapter.l0(this.h, z2);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(((MallActivityOrderDetailBinding) this).f10306a, eVar, null);
            CommonBindingAdapter.q(this.b, cVar, null);
            CommonBindingAdapter.q(this.c, hVar, null);
            CommonBindingAdapter.q(this.d, gVar, null);
            CommonBindingAdapter.q(this.e, fVar, null);
            CommonBindingAdapter.q(this.f, dVar, null);
            CommonBindingAdapter.q(this.g, bVar, null);
            CommonBindingAdapter.q(this.h, aVar, null);
        }
        if ((j & 672) != 0) {
            CommonBindingAdapter.e0(this.e, zSafeUnbox);
        }
        if ((j & 644) != 0) {
            TextViewBindingAdapter.setText(this.e, value3);
        }
        if ((j & 641) != 0) {
            xq8.a(this.f10310a, value2, null);
        }
        if ((j & 648) != 0) {
            CommonBindingAdapter.g(((MallActivityOrderDetailBinding) this).f34822a, value4, false, false);
        }
        if ((j & 704) != 0) {
            ((MallActivityOrderDetailBinding) this).f10303a.k(value);
        }
        ViewDataBinding.executeBindingsOn(((MallActivityOrderDetailBinding) this).f10303a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10308a != 0) {
                return true;
            }
            return ((MallActivityOrderDetailBinding) this).f10303a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10308a = 512L;
        }
        ((MallActivityOrderDetailBinding) this).f10303a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityOrderDetailBinding
    public void l(@Nullable OrderDetailActivity.ClickProxy clickProxy) {
        ((MallActivityOrderDetailBinding) this).f10304a = clickProxy;
        synchronized (this) {
            this.f10308a |= 256;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityOrderDetailBinding
    public void m(@Nullable OrderDetailVM orderDetailVM) {
        ((MallActivityOrderDetailBinding) this).f10305a = orderDetailVM;
        synchronized (this) {
            this.f10308a |= 128;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10308a |= 16;
        }
        return true;
    }

    public final boolean o(MutableLiveData<OrderDetailGoodsAdapter> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10308a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return r((MutableLiveData) obj, i2);
            case 1:
                return p((MutableLiveData) obj, i2);
            case 2:
                return q((MutableLiveData) obj, i2);
            case 3:
                return o((MutableLiveData) obj, i2);
            case 4:
                return n((LayoutToolbarBindingBinding) obj, i2);
            case 5:
                return s((MutableLiveData) obj, i2);
            case 6:
                return t((MutableLiveData) obj, i2);
            default:
                return false;
        }
    }

    public final boolean p(MutableLiveData<OrderDetailBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10308a |= 2;
        }
        return true;
    }

    public final boolean q(MutableLiveData<String> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10308a |= 4;
        }
        return true;
    }

    public final boolean r(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10308a |= 1;
        }
        return true;
    }

    public final boolean s(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10308a |= 32;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((MallActivityOrderDetailBinding) this).f10303a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            m((OrderDetailVM) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((OrderDetailActivity.ClickProxy) obj);
        }
        return true;
    }

    public final boolean t(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10308a |= 64;
        }
        return true;
    }

    public MallActivityOrderDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (BLButton) objArr[3], (BLButton) objArr[4], (BLButton) objArr[9], (BLButton) objArr[6], (BLButton) objArr[5], (BLButton) objArr[10], (BLButton) objArr[7], (BLButton) objArr[8], (RecyclerView) objArr[2], (LayoutToolbarBindingBinding) objArr[11]);
        this.f10308a = -1L;
        ((MallActivityOrderDetailBinding) this).f10306a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10309a = linearLayout;
        linearLayout.setTag(null);
        StateLayout stateLayout = (StateLayout) objArr[1];
        this.f10310a = stateLayout;
        stateLayout.setTag(null);
        ((MallActivityOrderDetailBinding) this).f34822a.setTag(null);
        setContainedBinding(((MallActivityOrderDetailBinding) this).f10303a);
        setRootTag(view);
        invalidateAll();
    }
}
