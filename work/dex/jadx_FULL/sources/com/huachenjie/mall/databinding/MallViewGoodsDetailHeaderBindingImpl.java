package com.huachenjie.mall.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.ViewStubProxy;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailAttribute;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailBean;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailService;
import com.huachenjie.mall.page.goods_detail.GoodsDetailActivity;
import com.huachenjie.mall.page.goods_detail.GoodsDetailVM;
import com.huachenjie.mall.page.goods_detail.preview.ImagePreviewView;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.hk0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallViewGoodsDetailHeaderBindingImpl extends MallViewGoodsDetailHeaderBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35083a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11038a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11039a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11040a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f11041a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11042a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11043a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f11044a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f11045a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f11046a;

    @NonNull
    public final LinearLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f11047b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f11048b;

    @NonNull
    public final LinearLayout c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f11049c;

    @NonNull
    public final LinearLayout d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final TextView f11050d;

    @NonNull
    public final TextView e;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GoodsDetailActivity.ClickProxy f35084a;

        public a a(GoodsDetailActivity.ClickProxy clickProxy) {
            this.f35084a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35084a.h(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GoodsDetailActivity.ClickProxy f35085a;

        public b a(GoodsDetailActivity.ClickProxy clickProxy) {
            this.f35085a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35085a.d(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GoodsDetailActivity.ClickProxy f35086a;

        public c a(GoodsDetailActivity.ClickProxy clickProxy) {
            this.f35086a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35086a.g(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35083a = sparseIntArray;
        sparseIntArray.put(R.id.vs_header_content, 13);
    }

    public MallViewGoodsDetailHeaderBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, f11038a, f35083a));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0193 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:102:0x0195  */
    /* JADX WARN: Code duplicated, block: B:103:0x0198  */
    /* JADX WARN: Code duplicated, block: B:106:0x01a3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:108:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:110:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:112:0x01ae A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:113:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:114:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:115:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:121:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:126:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:129:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:131:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:134:0x0232  */
    /* JADX WARN: Code duplicated, block: B:137:0x0249  */
    /* JADX WARN: Code duplicated, block: B:140:0x0256  */
    /* JADX WARN: Code duplicated, block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x0108  */
    /* JADX WARN: Code duplicated, block: B:72:0x0118  */
    /* JADX WARN: Code duplicated, block: B:86:0x0153  */
    /* JADX WARN: Code duplicated, block: B:89:0x015e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:90:0x0160  */
    /* JADX WARN: Code duplicated, block: B:91:0x0165  */
    /* JADX WARN: Code duplicated, block: B:93:0x0168  */
    /* JADX WARN: Code duplicated, block: B:94:0x016a  */
    /* JADX WARN: Code duplicated, block: B:97:0x0173  */
    /* JADX WARN: Code duplicated, block: B:98:0x0183  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        boolean z3;
        String value;
        boolean zIsEmpty;
        String deliveryPlace;
        List<GoodsDetailService> serviceList;
        boolean zIsEmpty2;
        boolean z4;
        String str;
        String str2;
        String str3;
        boolean z5;
        int iSafeUnbox;
        int iG;
        b bVarA;
        a aVarA;
        c cVarA;
        boolean z6;
        boolean z7;
        boolean z8;
        String str4;
        long j2;
        long j3;
        boolean z9;
        int size;
        ArrayList<GoodsDetailAttribute> goodsAttributeList;
        String expressStr;
        String attributesNameStr;
        String serviceStr;
        synchronized (this) {
            j = this.f11039a;
            this.f11039a = 0L;
        }
        GoodsDetailVM goodsDetailVM = ((MallViewGoodsDetailHeaderBinding) this).f11035a;
        Integer num = ((MallViewGoodsDetailHeaderBinding) this).f11037a;
        GoodsDetailActivity.ClickProxy clickProxy = ((MallViewGoodsDetailHeaderBinding) this).f11034a;
        int type = 0;
        if ((39 & j) != 0) {
            long j4 = j & 37;
            if (j4 != 0) {
                MutableLiveData<String> mutableLiveDataC = goodsDetailVM != null ? goodsDetailVM.C() : null;
                updateLiveDataRegistration(0, mutableLiveDataC);
                value = mutableLiveDataC != null ? mutableLiveDataC.getValue() : null;
                zIsEmpty = TextUtils.isEmpty(value);
                if (j4 != 0) {
                    j |= zIsEmpty ? 8192L : 4096L;
                }
            } else {
                zIsEmpty = false;
                value = null;
            }
            long j5 = j & 38;
            if (j5 != 0) {
                MutableLiveData<GoodsDetailBean> mutableLiveDataU = goodsDetailVM != null ? goodsDetailVM.u() : null;
                updateLiveDataRegistration(1, mutableLiveDataU);
                GoodsDetailBean value2 = mutableLiveDataU != null ? mutableLiveDataU.getValue() : null;
                if (value2 != null) {
                    goodsAttributeList = value2.getGoodsAttributeList();
                    expressStr = value2.getExpressStr();
                    deliveryPlace = value2.getDeliveryPlace();
                    attributesNameStr = value2.getAttributesNameStr();
                    serviceList = value2.getServiceList();
                    serviceStr = value2.getServiceStr();
                    type = value2.getType();
                } else {
                    goodsAttributeList = null;
                    expressStr = null;
                    deliveryPlace = null;
                    attributesNameStr = null;
                    serviceList = null;
                    serviceStr = null;
                }
                z = value2 != null;
                int size2 = goodsAttributeList != null ? goodsAttributeList.size() : 0;
                zIsEmpty2 = TextUtils.isEmpty(deliveryPlace);
                z4 = serviceList != null;
                boolean z10 = type != 2;
                z3 = type == 2;
                if (j5 != 0) {
                    j = zIsEmpty2 ? j | 512 : j | 256;
                }
                if ((j & 38) != 0) {
                    j = z4 ? j | 128 : j | 64;
                }
                z2 = size2 > 0;
                str = expressStr;
                str2 = attributesNameStr;
                str3 = serviceStr;
                z5 = z10;
            } else {
                z = false;
                z2 = false;
                z3 = false;
                type = 0;
            }
            if ((j & 40) != 0) {
                iSafeUnbox = ViewDataBinding.safeUnbox(num);
                iG = SizeUtils.g(iSafeUnbox / 2) - 24;
            } else {
                iSafeUnbox = 0;
                iG = 0;
            }
            if ((j & 48) != 0 || clickProxy == null) {
                bVarA = null;
                aVarA = null;
                cVarA = null;
            } else {
                c cVar = this.f11045a;
                if (cVar == null) {
                    cVar = new c();
                    this.f11045a = cVar;
                }
                cVarA = cVar.a(clickProxy);
                a aVar = this.f11043a;
                if (aVar == null) {
                    aVar = new a();
                    this.f11043a = aVar;
                }
                aVarA = aVar.a(clickProxy);
                b bVar = this.f11044a;
                if (bVar == null) {
                    bVar = new b();
                    this.f11044a = bVar;
                }
                bVarA = bVar.a(clickProxy);
            }
            if ((j & 128) == 0) {
                z6 = false;
            } else {
                if (serviceList != null) {
                    size = serviceList.size();
                } else {
                    size = 0;
                }
                if (size > 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
            }
            if ((j & 256) != 0) {
                z7 = true;
                z8 = false;
                str4 = String.format("从%s发货", deliveryPlace);
            } else {
                z7 = true;
                z8 = false;
                str4 = null;
            }
            if ((j & 37) != 0) {
                value = null;
            } else if (zIsEmpty) {
                value = "请选择规格";
            }
            j2 = j & 38;
            if (j2 != 0) {
                if (!z4) {
                    z6 = z8;
                }
                if (zIsEmpty2) {
                    str4 = "";
                }
                if (j2 != 0) {
                    if (z6) {
                        j |= 2048;
                    } else {
                        j |= 1024;
                    }
                }
            } else {
                z6 = z8;
                str4 = null;
            }
            if ((j & 2048) != 0 || type == 3) {
                z7 = z8;
            }
            j3 = j & 38;
            if (j3 == 0 && z6) {
                z9 = z7;
            } else {
                z9 = z8;
            }
            if ((j & 40) != 0) {
                CommonBindingAdapter.G(((MallViewGoodsDetailHeaderBinding) this).f11036a, iSafeUnbox);
                CommonBindingAdapter.I(this.f11046a, 0, iG, 0, 0, null);
            }
            if (j3 != 0) {
                TextViewBindingAdapter.setText(this.f11042a, str);
                CommonBindingAdapter.l0(this.f11040a, z2);
                TextViewBindingAdapter.setText(this.f11047b, str2);
                CommonBindingAdapter.l0(this.f11046a, z3);
                CommonBindingAdapter.l0(this.f11048b, z);
                CommonBindingAdapter.l0(this.b, z9);
                TextViewBindingAdapter.setText(this.f11049c, str3);
                CommonBindingAdapter.l0(this.d, z5);
                TextViewBindingAdapter.setText(this.e, str4);
            }
            if ((48 & j) != 0) {
                CommonBindingAdapter.q(this.f11040a, bVarA, null);
                CommonBindingAdapter.q(this.f11046a, aVarA, null);
                CommonBindingAdapter.q(this.c, cVarA, null);
            }
            if ((j & 37) != 0) {
                TextViewBindingAdapter.setText(this.f11050d, value);
            }
            if (((MallViewGoodsDetailHeaderBinding) this).f35082a.getBinding() != null) {
                ViewDataBinding.executeBindingsOn(((MallViewGoodsDetailHeaderBinding) this).f35082a.getBinding());
            }
        }
        z = false;
        z2 = false;
        z3 = false;
        type = 0;
        value = null;
        zIsEmpty = false;
        deliveryPlace = null;
        serviceList = null;
        zIsEmpty2 = false;
        z4 = false;
        str = null;
        str2 = null;
        str3 = null;
        z5 = false;
        if ((j & 40) != 0) {
            iSafeUnbox = ViewDataBinding.safeUnbox(num);
            iG = SizeUtils.g(iSafeUnbox / 2) - 24;
        } else {
            iSafeUnbox = 0;
            iG = 0;
        }
        if ((j & 48) != 0) {
            bVarA = null;
            aVarA = null;
            cVarA = null;
        } else {
            bVarA = null;
            aVarA = null;
            cVarA = null;
        }
        if ((j & 128) == 0) {
            z6 = false;
        } else {
            if (serviceList != null) {
                size = serviceList.size();
            } else {
                size = 0;
            }
            if (size > 0) {
                z6 = true;
            } else {
                z6 = false;
            }
        }
        if ((j & 256) != 0) {
            z7 = true;
            z8 = false;
            str4 = String.format("从%s发货", deliveryPlace);
        } else {
            z7 = true;
            z8 = false;
            str4 = null;
        }
        if ((j & 37) != 0) {
            value = null;
        } else if (zIsEmpty) {
            value = "请选择规格";
        }
        j2 = j & 38;
        if (j2 != 0) {
            if (!z4) {
                z6 = z8;
            }
            if (zIsEmpty2) {
                str4 = "";
            }
            if (j2 != 0) {
                if (z6) {
                    j |= 2048;
                } else {
                    j |= 1024;
                }
            }
        } else {
            z6 = z8;
            str4 = null;
        }
        if ((j & 2048) != 0) {
            z7 = z8;
        } else {
            z7 = z8;
        }
        j3 = j & 38;
        if (j3 == 0) {
            z9 = z8;
        } else {
            z9 = z8;
        }
        if ((j & 40) != 0) {
            CommonBindingAdapter.G(((MallViewGoodsDetailHeaderBinding) this).f11036a, iSafeUnbox);
            CommonBindingAdapter.I(this.f11046a, 0, iG, 0, 0, null);
        }
        if (j3 != 0) {
            TextViewBindingAdapter.setText(this.f11042a, str);
            CommonBindingAdapter.l0(this.f11040a, z2);
            TextViewBindingAdapter.setText(this.f11047b, str2);
            CommonBindingAdapter.l0(this.f11046a, z3);
            CommonBindingAdapter.l0(this.f11048b, z);
            CommonBindingAdapter.l0(this.b, z9);
            TextViewBindingAdapter.setText(this.f11049c, str3);
            CommonBindingAdapter.l0(this.d, z5);
            TextViewBindingAdapter.setText(this.e, str4);
        }
        if ((48 & j) != 0) {
            CommonBindingAdapter.q(this.f11040a, bVarA, null);
            CommonBindingAdapter.q(this.f11046a, aVarA, null);
            CommonBindingAdapter.q(this.c, cVarA, null);
        }
        if ((j & 37) != 0) {
            TextViewBindingAdapter.setText(this.f11050d, value);
        }
        if (((MallViewGoodsDetailHeaderBinding) this).f35082a.getBinding() != null) {
            ViewDataBinding.executeBindingsOn(((MallViewGoodsDetailHeaderBinding) this).f35082a.getBinding());
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11039a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11039a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallViewGoodsDetailHeaderBinding
    public void m(@Nullable Integer num) {
        ((MallViewGoodsDetailHeaderBinding) this).f11037a = num;
        synchronized (this) {
            this.f11039a |= 8;
        }
        notifyPropertyChanged(hk0.f);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallViewGoodsDetailHeaderBinding
    public void n(@Nullable GoodsDetailActivity.ClickProxy clickProxy) {
        ((MallViewGoodsDetailHeaderBinding) this).f11034a = clickProxy;
        synchronized (this) {
            this.f11039a |= 16;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallViewGoodsDetailHeaderBinding
    public void o(@Nullable GoodsDetailVM goodsDetailVM) {
        ((MallViewGoodsDetailHeaderBinding) this).f11035a = goodsDetailVM;
        synchronized (this) {
            this.f11039a |= 4;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return q((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return p((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<GoodsDetailBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f11039a |= 2;
        }
        return true;
    }

    public final boolean q(MutableLiveData<String> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f11039a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            o((GoodsDetailVM) obj);
        } else if (hk0.f == i) {
            m((Integer) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            n((GoodsDetailActivity.ClickProxy) obj);
        }
        return true;
    }

    public MallViewGoodsDetailHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ImagePreviewView) objArr[1], new ViewStubProxy((ViewStub) objArr[13]));
        this.f11039a = -1L;
        ((MallViewGoodsDetailHeaderBinding) this).f11036a.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f11041a = relativeLayout;
        relativeLayout.setTag(null);
        TextView textView = (TextView) objArr[10];
        this.f11042a = textView;
        textView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[11];
        this.f11040a = linearLayout;
        linearLayout.setTag(null);
        TextView textView2 = (TextView) objArr[12];
        this.f11047b = textView2;
        textView2.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[2];
        this.f11046a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        BLLinearLayout bLLinearLayout2 = (BLLinearLayout) objArr[3];
        this.f11048b = bLLinearLayout2;
        bLLinearLayout2.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[4];
        this.b = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView3 = (TextView) objArr[5];
        this.f11049c = textView3;
        textView3.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[6];
        this.c = linearLayout3;
        linearLayout3.setTag(null);
        TextView textView4 = (TextView) objArr[7];
        this.f11050d = textView4;
        textView4.setTag(null);
        LinearLayout linearLayout4 = (LinearLayout) objArr[8];
        this.d = linearLayout4;
        linearLayout4.setTag(null);
        TextView textView5 = (TextView) objArr[9];
        this.e = textView5;
        textView5.setTag(null);
        ((MallViewGoodsDetailHeaderBinding) this).f35082a.setContainingBinding(this);
        setRootTag(view);
        invalidateAll();
    }
}
