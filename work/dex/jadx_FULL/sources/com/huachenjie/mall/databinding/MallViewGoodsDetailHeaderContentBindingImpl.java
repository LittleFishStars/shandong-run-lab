package com.huachenjie.mall.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.view.ExpandableTextView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailBean;
import com.huachenjie.mall.page.goods_detail.GoodsDetailVM;
import com.huachenjie.mall.widget.PriceView;
import com.noober.background.view.BLTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallViewGoodsDetailHeaderContentBindingImpl extends MallViewGoodsDetailHeaderContentBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35088a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11063a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11064a;

    @NonNull
    public final BLTextView b;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35088a = sparseIntArray;
        sparseIntArray.put(R.id.tv_brokerage_rate_text, 18);
        sparseIntArray.put(R.id.tv_brokerage_earn_text, 19);
        sparseIntArray.put(R.id.tv_monthly_sales_text, 20);
        sparseIntArray.put(R.id.tv_score_text, 21);
    }

    public MallViewGoodsDetailHeaderContentBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 22, f11063a, f35088a));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x017f  */
    /* JADX WARN: Code duplicated, block: B:102:0x0199  */
    /* JADX WARN: Code duplicated, block: B:103:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:27:0x0075  */
    /* JADX WARN: Code duplicated, block: B:58:0x0104 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x0106  */
    /* JADX WARN: Code duplicated, block: B:60:0x010b  */
    /* JADX WARN: Code duplicated, block: B:63:0x0111  */
    /* JADX WARN: Code duplicated, block: B:64:0x0118  */
    /* JADX WARN: Code duplicated, block: B:67:0x0121 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:68:0x0123  */
    /* JADX WARN: Code duplicated, block: B:69:0x012a  */
    /* JADX WARN: Code duplicated, block: B:72:0x0131  */
    /* JADX WARN: Code duplicated, block: B:73:0x0138  */
    /* JADX WARN: Code duplicated, block: B:76:0x013f  */
    /* JADX WARN: Code duplicated, block: B:77:0x0141  */
    /* JADX WARN: Code duplicated, block: B:79:0x0144 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:80:0x0146  */
    /* JADX WARN: Code duplicated, block: B:81:0x0149  */
    /* JADX WARN: Code duplicated, block: B:83:0x014d  */
    /* JADX WARN: Code duplicated, block: B:84:0x0154  */
    /* JADX WARN: Code duplicated, block: B:87:0x015e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:89:0x0161  */
    /* JADX WARN: Code duplicated, block: B:91:0x0164 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x0166  */
    /* JADX WARN: Code duplicated, block: B:93:0x016d  */
    /* JADX WARN: Code duplicated, block: B:97:0x0179  */
    /* JADX WARN: Code duplicated, block: B:98:0x017c  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        MutableLiveData<Boolean> mutableLiveDataX;
        String value;
        boolean z;
        boolean z2;
        int i;
        GoodsDetailBean value2;
        boolean z3;
        String value3;
        String str;
        Boolean value4;
        boolean zSafeUnbox;
        boolean z4;
        int i2;
        boolean z5;
        String salePoint;
        String strValueOf;
        String saleCount;
        String goodsName;
        CharSequence charSequence;
        String labelStr;
        boolean z6;
        String str2;
        boolean zSafeUnbox2;
        String strValueOf2;
        long j2;
        MutableLiveData<Integer> mutableLiveDataD;
        Integer value5;
        int iSafeUnbox;
        boolean z7;
        long j3;
        CharSequence detailCommission;
        long j4;
        int i3;
        long j5;
        long j6;
        MutableLiveData<String> mutableLiveDataW;
        float goodsScore;
        float cooperationServiceChargeRate;
        synchronized (this) {
            j = this.f11064a;
            this.f11064a = 0L;
        }
        GoodsDetailVM goodsDetailVM = ((MallViewGoodsDetailHeaderContentBinding) this).f11055a;
        if ((127 & j) != 0) {
            if ((j & 97) != 0) {
                mutableLiveDataX = goodsDetailVM != null ? goodsDetailVM.x() : null;
                updateLiveDataRegistration(0, mutableLiveDataX);
                value4 = mutableLiveDataX != null ? mutableLiveDataX.getValue() : null;
                zSafeUnbox = ViewDataBinding.safeUnbox(value4);
                z4 = !zSafeUnbox;
                zSafeUnbox2 = ViewDataBinding.safeUnbox(Boolean.valueOf(z4));
            } else {
                zSafeUnbox = false;
                z4 = false;
                zSafeUnbox2 = false;
                mutableLiveDataX = null;
                value4 = null;
            }
            if ((j & 98) == 0) {
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataV = goodsDetailVM != null ? goodsDetailVM.v() : null;
                updateLiveDataRegistration(1, mutableLiveDataV);
                if (mutableLiveDataV != null) {
                    value = mutableLiveDataV.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 117) != 0) {
                MutableLiveData<GoodsDetailBean> mutableLiveDataU = goodsDetailVM != null ? goodsDetailVM.u() : null;
                updateLiveDataRegistration(2, mutableLiveDataU);
                value2 = mutableLiveDataU != null ? mutableLiveDataU.getValue() : null;
                if ((j & 100) != 0) {
                    if (value2 != null) {
                        goodsScore = value2.getGoodsScore();
                        salePoint = value2.getSalePoint();
                        cooperationServiceChargeRate = value2.getCooperationServiceChargeRate();
                        saleCount = value2.getSaleCount();
                        goodsName = value2.getGoodsName();
                    } else {
                        goodsScore = 0.0f;
                        cooperationServiceChargeRate = 0.0f;
                        salePoint = null;
                        saleCount = null;
                        goodsName = null;
                    }
                    strValueOf2 = String.valueOf(goodsScore);
                    strValueOf = String.valueOf(cooperationServiceChargeRate);
                } else {
                    strValueOf2 = null;
                    salePoint = null;
                    strValueOf = null;
                    saleCount = null;
                    goodsName = null;
                }
                long j7 = j & 101;
                if (j7 != 0) {
                    labelStr = value2 != null ? value2.getLabelStr() : null;
                    z5 = !TextUtils.isEmpty(labelStr);
                    if (j7 != 0) {
                        j = z5 ? j | 1024 : j | 512;
                    }
                }
                if ((j & 104) == 0) {
                    value3 = null;
                } else {
                    if (goodsDetailVM != null) {
                        mutableLiveDataW = goodsDetailVM.w();
                    } else {
                        mutableLiveDataW = null;
                    }
                    updateLiveDataRegistration(3, mutableLiveDataW);
                    if (mutableLiveDataW != null) {
                        value3 = mutableLiveDataW.getValue();
                    } else {
                        value3 = null;
                    }
                }
                j2 = j & 116;
                if (j2 != 0) {
                    if (goodsDetailVM != null) {
                        mutableLiveDataD = goodsDetailVM.D();
                    } else {
                        mutableLiveDataD = null;
                    }
                    updateLiveDataRegistration(4, mutableLiveDataD);
                    if (mutableLiveDataD != null) {
                        value5 = mutableLiveDataD.getValue();
                    } else {
                        value5 = null;
                    }
                    iSafeUnbox = ViewDataBinding.safeUnbox(value5);
                    if (iSafeUnbox == 1) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (j2 != 0) {
                        if (z7) {
                            j |= PlaybackStateCompat.ACTION_PREPARE;
                        } else {
                            j |= 8192;
                        }
                    }
                    if (value2 != null) {
                        detailCommission = value2.formatDetailCommission(iSafeUnbox);
                        j3 = 112;
                    } else {
                        j3 = 112;
                        detailCommission = null;
                    }
                    j4 = j & j3;
                    if (j4 != 0) {
                        z = iSafeUnbox == 3;
                        if (j4 != 0) {
                            if (z) {
                                j5 = j | 256;
                                j6 = 4096;
                            } else {
                                j5 = j | 128;
                                j6 = 2048;
                            }
                            j = j5 | j6;
                        }
                        if (z) {
                            i3 = 64;
                        } else {
                            i3 = 105;
                        }
                        salePoint = salePoint;
                        strValueOf = strValueOf;
                        saleCount = saleCount;
                        goodsName = goodsName;
                        charSequence = detailCommission;
                        labelStr = labelStr;
                        i2 = i3;
                        value3 = value3;
                        str = strValueOf2;
                        z3 = zSafeUnbox2;
                        boolean z8 = z7;
                        i = z ? 75 : 105;
                        z2 = z8;
                    } else {
                        z2 = z7;
                        charSequence = detailCommission;
                        z = false;
                        i = 0;
                        i2 = 0;
                    }
                } else {
                    z = false;
                    z2 = false;
                    i = 0;
                    i2 = 0;
                    charSequence = null;
                }
                str = strValueOf2;
                z3 = zSafeUnbox2;
            } else {
                value2 = null;
                strValueOf2 = null;
                salePoint = null;
                strValueOf = null;
                saleCount = null;
                goodsName = null;
            }
            labelStr = null;
            z5 = false;
            if ((j & 104) == 0) {
                value3 = null;
            } else {
                if (goodsDetailVM != null) {
                    mutableLiveDataW = goodsDetailVM.w();
                } else {
                    mutableLiveDataW = null;
                }
                updateLiveDataRegistration(3, mutableLiveDataW);
                if (mutableLiveDataW != null) {
                    value3 = mutableLiveDataW.getValue();
                } else {
                    value3 = null;
                }
            }
            j2 = j & 116;
            if (j2 != 0) {
                if (goodsDetailVM != null) {
                    mutableLiveDataD = goodsDetailVM.D();
                } else {
                    mutableLiveDataD = null;
                }
                updateLiveDataRegistration(4, mutableLiveDataD);
                if (mutableLiveDataD != null) {
                    value5 = mutableLiveDataD.getValue();
                } else {
                    value5 = null;
                }
                iSafeUnbox = ViewDataBinding.safeUnbox(value5);
                if (iSafeUnbox == 1) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (j2 != 0) {
                    if (z7) {
                        j |= PlaybackStateCompat.ACTION_PREPARE;
                    } else {
                        j |= 8192;
                    }
                }
                if (value2 != null) {
                    detailCommission = value2.formatDetailCommission(iSafeUnbox);
                    j3 = 112;
                } else {
                    j3 = 112;
                    detailCommission = null;
                }
                j4 = j & j3;
                if (j4 != 0) {
                    if (iSafeUnbox == 3) {
                    }
                    if (j4 != 0) {
                        if (z) {
                            j5 = j | 256;
                            j6 = 4096;
                        } else {
                            j5 = j | 128;
                            j6 = 2048;
                        }
                        j = j5 | j6;
                    }
                    if (z) {
                        i3 = 64;
                    } else {
                        i3 = 105;
                    }
                    salePoint = salePoint;
                    strValueOf = strValueOf;
                    saleCount = saleCount;
                    goodsName = goodsName;
                    charSequence = detailCommission;
                    labelStr = labelStr;
                    i2 = i3;
                    value3 = value3;
                    str = strValueOf2;
                    z3 = zSafeUnbox2;
                    boolean z9 = z7;
                    i = z ? 75 : 105;
                    z2 = z9;
                } else {
                    z2 = z7;
                    charSequence = detailCommission;
                    z = false;
                    i = 0;
                    i2 = 0;
                }
            } else {
                z = false;
                z2 = false;
                i = 0;
                i2 = 0;
                charSequence = null;
            }
            str = strValueOf2;
            z3 = zSafeUnbox2;
        } else {
            mutableLiveDataX = null;
            value = null;
            z = false;
            z2 = false;
            i = 0;
            value2 = null;
            z3 = false;
            value3 = null;
            str = null;
            value4 = null;
            zSafeUnbox = false;
            z4 = false;
            i2 = 0;
            z5 = false;
            salePoint = null;
            strValueOf = null;
            saleCount = null;
            goodsName = null;
            charSequence = null;
            labelStr = null;
        }
        if ((j & 1024) != 0) {
            if (goodsDetailVM != null) {
                mutableLiveDataX = goodsDetailVM.x();
            }
            z6 = false;
            updateLiveDataRegistration(0, mutableLiveDataX);
            if (mutableLiveDataX != null) {
                value4 = mutableLiveDataX.getValue();
            }
            zSafeUnbox = ViewDataBinding.safeUnbox(value4);
            z4 = !zSafeUnbox;
        } else {
            z6 = false;
        }
        boolean z10 = zSafeUnbox;
        String commissionRate = ((j & 8192) == 0 || value2 == null) ? null : value2.formatCommissionRate();
        String baseCommissionRate = ((j & PlaybackStateCompat.ACTION_PREPARE) == 0 || value2 == null) ? null : value2.formatBaseCommissionRate();
        long j8 = 101 & j;
        if (j8 != 0) {
            if (!z5) {
                z4 = z6;
            }
            z6 = z4;
        }
        long j9 = j & 116;
        if (j9 != 0) {
            if (z2) {
                commissionRate = baseCommissionRate;
            }
            str2 = commissionRate;
        } else {
            str2 = null;
        }
        if ((j & 97) != 0) {
            CommonBindingAdapter.l0(((MallViewGoodsDetailHeaderContentBinding) this).f11053a, z10);
            CommonBindingAdapter.l0(this.j, z3);
        }
        if ((j & 112) != 0) {
            CommonBindingAdapter.l0(this.i, z);
            CommonBindingAdapter.l0(this.g, z);
            CommonBindingAdapter.l0(this.h, z);
            CommonBindingAdapter.I(((MallViewGoodsDetailHeaderContentBinding) this).f35087a, i2, 0, 0, 0, null);
            CommonBindingAdapter.I(((MallViewGoodsDetailHeaderContentBinding) this).b, i, 0, 0, 0, null);
            CommonBindingAdapter.l0(((MallViewGoodsDetailHeaderContentBinding) this).c, z);
        }
        if ((100 & j) != 0) {
            TextViewBindingAdapter.setText(this.b, labelStr);
            String str3 = saleCount;
            TextViewBindingAdapter.setText(this.j, str3);
            aw9.f(((MallViewGoodsDetailHeaderContentBinding) this).f11054a, salePoint);
            TextViewBindingAdapter.setText(((MallViewGoodsDetailHeaderContentBinding) this).f11061c, str3);
            aw9.f(((MallViewGoodsDetailHeaderContentBinding) this).f11059b, goodsName);
            TextViewBindingAdapter.setText(this.e, str);
            TextViewBindingAdapter.setText(this.g, strValueOf);
        }
        if (j8 != 0) {
            CommonBindingAdapter.l0(this.b, z6);
        }
        if (j9 != 0) {
            TextViewBindingAdapter.setText(((MallViewGoodsDetailHeaderContentBinding) this).f11056a, charSequence);
            TextViewBindingAdapter.setText(((MallViewGoodsDetailHeaderContentBinding) this).f11057a, str2);
        }
        if ((104 & j) != 0) {
            TextViewBindingAdapter.setText(((MallViewGoodsDetailHeaderContentBinding) this).f11060b, value3);
        }
        if ((j & 98) != 0) {
            TextViewBindingAdapter.setText(((MallViewGoodsDetailHeaderContentBinding) this).f11062c, value);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11064a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11064a = 64L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallViewGoodsDetailHeaderContentBinding
    public void k(@Nullable GoodsDetailVM goodsDetailVM) {
        ((MallViewGoodsDetailHeaderContentBinding) this).f11055a = goodsDetailVM;
        synchronized (this) {
            this.f11064a |= 32;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<GoodsDetailBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f11064a |= 4;
        }
        return true;
    }

    public final boolean m(MutableLiveData<String> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f11064a |= 2;
        }
        return true;
    }

    public final boolean n(MutableLiveData<String> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f11064a |= 8;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f11064a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return m((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return l((MutableLiveData) obj, i2);
        }
        if (i == 3) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return p((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f11064a |= 16;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 != i) {
            return false;
        }
        k((GoodsDetailVM) obj);
        return true;
    }

    public MallViewGoodsDetailHeaderContentBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (ConstraintLayout) objArr[5], (FrameLayout) objArr[0], (PriceView) objArr[13], (TextView) objArr[19], (BLTextView) objArr[12], (TextView) objArr[18], (ExpandableTextView) objArr[17], (TextView) objArr[14], (TextView) objArr[20], (ExpandableTextView) objArr[16], (PriceView) objArr[3], (PriceView) objArr[1], (TextView) objArr[15], (TextView) objArr[21], (TextView) objArr[10], (TextView) objArr[9], (View) objArr[7], (View) objArr[8], (View) objArr[6]);
        this.f11064a = -1L;
        ((MallViewGoodsDetailHeaderContentBinding) this).f11053a.setTag(null);
        TextView textView = (TextView) objArr[11];
        this.i = textView;
        textView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[2];
        this.b = bLTextView;
        bLTextView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.j = textView2;
        textView2.setTag(null);
        ((MallViewGoodsDetailHeaderContentBinding) this).f11051a.setTag(null);
        ((MallViewGoodsDetailHeaderContentBinding) this).f11056a.setTag(null);
        ((MallViewGoodsDetailHeaderContentBinding) this).f11057a.setTag(null);
        ((MallViewGoodsDetailHeaderContentBinding) this).f11054a.setTag(null);
        ((MallViewGoodsDetailHeaderContentBinding) this).f11061c.setTag(null);
        ((MallViewGoodsDetailHeaderContentBinding) this).f11059b.setTag(null);
        ((MallViewGoodsDetailHeaderContentBinding) this).f11060b.setTag(null);
        ((MallViewGoodsDetailHeaderContentBinding) this).f11062c.setTag(null);
        this.e.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        ((MallViewGoodsDetailHeaderContentBinding) this).f35087a.setTag(null);
        ((MallViewGoodsDetailHeaderContentBinding) this).b.setTag(null);
        ((MallViewGoodsDetailHeaderContentBinding) this).c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
