package com.huachenjie.mall.databinding;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailBean;
import com.huachenjie.mall.page.goods_detail.GoodsDetailActivity;
import com.huachenjie.mall.page.goods_detail.GoodsDetailVM;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallLayoutGoodsDetailBottomPointBindingImpl extends MallLayoutGoodsDetailBottomPointBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35065a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10991a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10992a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10993a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10994a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f10995a;

    @NonNull
    public final TextView b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GoodsDetailActivity.ClickProxy f35066a;

        public a a(GoodsDetailActivity.ClickProxy clickProxy) {
            this.f35066a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35066a.g(view);
        }
    }

    public MallLayoutGoodsDetailBottomPointBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f10991a, f35065a));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x016c  */
    /* JADX WARN: Code duplicated, block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:75:0x0105 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:76:0x0107  */
    /* JADX WARN: Code duplicated, block: B:77:0x010c  */
    /* JADX WARN: Code duplicated, block: B:80:0x0113  */
    /* JADX WARN: Code duplicated, block: B:81:0x011a  */
    /* JADX WARN: Code duplicated, block: B:83:0x0120  */
    /* JADX WARN: Code duplicated, block: B:88:0x012a  */
    /* JADX WARN: Code duplicated, block: B:90:0x012d  */
    /* JADX WARN: Code duplicated, block: B:93:0x0143  */
    /* JADX WARN: Code duplicated, block: B:95:0x0154  */
    /* JADX WARN: Code duplicated, block: B:98:0x0160  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String string;
        String value;
        boolean zIsEmpty;
        boolean z;
        int iSafeUnbox;
        long j2;
        a aVarA;
        boolean zSafeUnbox;
        long j3;
        MutableLiveData<Boolean> mutableLiveDataR;
        Boolean value2;
        Resources resources;
        int i;
        synchronized (this) {
            j = this.f10992a;
            this.f10992a = 0L;
        }
        GoodsDetailVM goodsDetailVM = ((MallLayoutGoodsDetailBottomPointBinding) this).f10990a;
        GoodsDetailActivity.ClickProxy clickProxy = ((MallLayoutGoodsDetailBottomPointBinding) this).f10989a;
        if ((95 & j) != 0) {
            if ((j & 85) != 0) {
                MutableLiveData<GoodsDetailBean> mutableLiveDataU = goodsDetailVM != null ? goodsDetailVM.u() : null;
                updateLiveDataRegistration(0, mutableLiveDataU);
                GoodsDetailBean value3 = mutableLiveDataU != null ? mutableLiveDataU.getValue() : null;
                boolean outOfStock = value3 != null ? value3.getOutOfStock() : false;
                if ((j & 81) != 0) {
                    j |= outOfStock ? 1024L : 512L;
                }
                z = !outOfStock;
                if ((j & 85) != 0) {
                    j = z ? j | 256 : j | 128;
                }
                if ((j & 81) != 0) {
                    if (outOfStock) {
                        resources = this.f10993a.getResources();
                        i = R.string.mall_goods_detail_out_of_stock;
                    } else {
                        resources = this.f10993a.getResources();
                        i = R.string.mall_goods_detail_buy_now_point;
                    }
                    string = resources.getString(i);
                } else {
                    string = null;
                }
            } else {
                string = null;
                z = false;
            }
            if ((j & 82) != 0) {
                MutableLiveData<String> mutableLiveDataY = goodsDetailVM != null ? goodsDetailVM.y() : null;
                updateLiveDataRegistration(1, mutableLiveDataY);
                value = mutableLiveDataY != null ? mutableLiveDataY.getValue() : null;
                zIsEmpty = true ^ TextUtils.isEmpty(value);
            } else {
                value = null;
                zIsEmpty = false;
            }
            if ((j & 88) != 0) {
                BaseViewModel.b bVarE = goodsDetailVM != null ? goodsDetailVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataA = bVarE != null ? bVarE.a() : null;
                updateLiveDataRegistration(3, mutableLiveDataA);
                iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataA != null ? mutableLiveDataA.getValue() : null) + 8));
            }
            j2 = 96 & j;
            if (j2 != 0 || clickProxy == null) {
                aVarA = null;
            } else {
                a aVar = this.f10994a;
                if (aVar == null) {
                    aVar = new a();
                    this.f10994a = aVar;
                }
                aVarA = aVar.a(clickProxy);
            }
            if ((256 & j) != 0) {
                if (goodsDetailVM != null) {
                    mutableLiveDataR = goodsDetailVM.r();
                } else {
                    mutableLiveDataR = null;
                }
                updateLiveDataRegistration(2, mutableLiveDataR);
                if (mutableLiveDataR != null) {
                    value2 = mutableLiveDataR.getValue();
                } else {
                    value2 = null;
                }
                zSafeUnbox = ViewDataBinding.safeUnbox(value2);
            } else {
                zSafeUnbox = false;
            }
            j3 = j & 85;
            if (j3 != 0 || !z) {
                zSafeUnbox = false;
            }
            if (j3 != 0) {
                CommonBindingAdapter.e0(this.f10995a, zSafeUnbox);
                CommonBindingAdapter.e0(this.f10993a, zSafeUnbox);
                CommonBindingAdapter.e0(this.b, zSafeUnbox);
            }
            if ((88 & j) != 0) {
                CommonBindingAdapter.I(this.f10995a, 16, 8, 16, iSafeUnbox, null);
            }
            if (j2 != 0) {
                CommonBindingAdapter.q(this.f10995a, aVarA, null);
            }
            if ((81 & j) != 0) {
                TextViewBindingAdapter.setText(this.f10993a, string);
            }
            if ((j & 82) != 0) {
                TextViewBindingAdapter.setText(this.b, value);
                CommonBindingAdapter.l0(this.b, zIsEmpty);
            }
        }
        string = null;
        value = null;
        zIsEmpty = false;
        z = false;
        iSafeUnbox = 0;
        j2 = 96 & j;
        if (j2 != 0) {
            aVarA = null;
        } else {
            aVarA = null;
        }
        if ((256 & j) != 0) {
            if (goodsDetailVM != null) {
                mutableLiveDataR = goodsDetailVM.r();
            } else {
                mutableLiveDataR = null;
            }
            updateLiveDataRegistration(2, mutableLiveDataR);
            if (mutableLiveDataR != null) {
                value2 = mutableLiveDataR.getValue();
            } else {
                value2 = null;
            }
            zSafeUnbox = ViewDataBinding.safeUnbox(value2);
        } else {
            zSafeUnbox = false;
        }
        j3 = j & 85;
        if (j3 != 0) {
            zSafeUnbox = false;
        } else {
            zSafeUnbox = false;
        }
        if (j3 != 0) {
            CommonBindingAdapter.e0(this.f10995a, zSafeUnbox);
            CommonBindingAdapter.e0(this.f10993a, zSafeUnbox);
            CommonBindingAdapter.e0(this.b, zSafeUnbox);
        }
        if ((88 & j) != 0) {
            CommonBindingAdapter.I(this.f10995a, 16, 8, 16, iSafeUnbox, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f10995a, aVarA, null);
        }
        if ((81 & j) != 0) {
            TextViewBindingAdapter.setText(this.f10993a, string);
        }
        if ((j & 82) != 0) {
            TextViewBindingAdapter.setText(this.b, value);
            CommonBindingAdapter.l0(this.b, zIsEmpty);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10992a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10992a = 64L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallLayoutGoodsDetailBottomPointBinding
    public void l(@Nullable GoodsDetailActivity.ClickProxy clickProxy) {
        ((MallLayoutGoodsDetailBottomPointBinding) this).f10989a = clickProxy;
        synchronized (this) {
            this.f10992a |= 32;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallLayoutGoodsDetailBottomPointBinding
    public void m(@Nullable GoodsDetailVM goodsDetailVM) {
        ((MallLayoutGoodsDetailBottomPointBinding) this).f10990a = goodsDetailVM;
        synchronized (this) {
            this.f10992a |= 16;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10992a |= 4;
        }
        return true;
    }

    public final boolean o(MutableLiveData<GoodsDetailBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10992a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return q((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<String> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10992a |= 2;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10992a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            m((GoodsDetailVM) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((GoodsDetailActivity.ClickProxy) obj);
        }
        return true;
    }

    public MallLayoutGoodsDetailBottomPointBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (CardView) objArr[0]);
        this.f10992a = -1L;
        ((MallLayoutGoodsDetailBottomPointBinding) this).f35064a.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[1];
        this.f10995a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f10993a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.b = textView2;
        textView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
