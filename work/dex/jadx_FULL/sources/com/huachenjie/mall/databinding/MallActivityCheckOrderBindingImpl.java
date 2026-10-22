package com.huachenjie.mall.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.aliyun.vod.common.utils.FileUtils;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.bean.mall.ShippingAddressBean;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.mall.bean.TradeBaseInfo;
import com.huachenjie.mall.bean.TradeGoodsInfoBean;
import com.huachenjie.mall.bean.TradeTotalPriceBean;
import com.huachenjie.mall.page.check_order.CheckOrderActivity;
import com.huachenjie.mall.page.check_order.CheckOrderVM;
import com.huachenjie.mall.widget.PriceView;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLRelativeLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.g89;
import com.zj.adlib.hk0;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallActivityCheckOrderBindingImpl extends MallActivityCheckOrderBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34777a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10160a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10161a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10162a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f10163a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10164a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f10165a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f10166a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final PriceView f10167a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f10168a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLRelativeLayout f10169a;

    @NonNull
    public final LinearLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final PriceView f10170b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f10171b;

    @NonNull
    public final PriceView c;

    @NonNull
    public final PriceView d;

    @NonNull
    public final PriceView e;

    @NonNull
    public final PriceView f;

    @NonNull
    public final TextView m;

    @NonNull
    public final TextView n;

    @NonNull
    public final TextView o;

    @NonNull
    public final TextView p;

    @NonNull
    public final TextView q;

    @NonNull
    public final TextView r;

    @NonNull
    public final TextView s;

    @NonNull
    public final TextView t;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CheckOrderActivity.ClickProxy f34778a;

        public a a(CheckOrderActivity.ClickProxy clickProxy) {
            this.f34778a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34778a.c(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CheckOrderActivity.ClickProxy f34779a;

        public b a(CheckOrderActivity.ClickProxy clickProxy) {
            this.f34779a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34779a.b(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CheckOrderActivity.ClickProxy f34780a;

        public c a(CheckOrderActivity.ClickProxy clickProxy) {
            this.f34780a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34780a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(35);
        f10160a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{28}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34777a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.mall.R.id.tv_change_address, 29);
        sparseIntArray.put(com.huachenjie.mall.R.id.tv_freight_title, 30);
        sparseIntArray.put(com.huachenjie.mall.R.id.tv_remark_title, 31);
        sparseIntArray.put(com.huachenjie.mall.R.id.tv_price_title, 32);
        sparseIntArray.put(com.huachenjie.mall.R.id.tv_extra_freight_title, 33);
        sparseIntArray.put(com.huachenjie.mall.R.id.tv_total_price_title, 34);
    }

    public MallActivityCheckOrderBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 35, f10160a, f34777a));
    }

    /* JADX WARN: Code duplicated, block: B:143:0x02d1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:144:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:145:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:147:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:148:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:151:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:152:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:154:0x0305  */
    /* JADX WARN: Code duplicated, block: B:157:0x0310 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:158:0x0312  */
    /* JADX WARN: Code duplicated, block: B:159:0x031f  */
    /* JADX WARN: Code duplicated, block: B:162:0x032a  */
    /* JADX WARN: Code duplicated, block: B:163:0x0331  */
    /* JADX WARN: Code duplicated, block: B:166:0x0338 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:167:0x033a  */
    /* JADX WARN: Code duplicated, block: B:168:0x0342  */
    /* JADX WARN: Code duplicated, block: B:16:0x0049  */
    /* JADX WARN: Code duplicated, block: B:172:0x034e  */
    /* JADX WARN: Code duplicated, block: B:174:0x038f  */
    /* JADX WARN: Code duplicated, block: B:216:0x04dc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:217:0x04de  */
    /* JADX WARN: Code duplicated, block: B:219:0x04e5  */
    /* JADX WARN: Code duplicated, block: B:222:0x04ef  */
    /* JADX WARN: Code duplicated, block: B:223:0x0503  */
    /* JADX WARN: Code duplicated, block: B:226:0x0516  */
    /* JADX WARN: Code duplicated, block: B:227:0x0523  */
    /* JADX WARN: Code duplicated, block: B:230:0x0531  */
    /* JADX WARN: Code duplicated, block: B:231:0x053e  */
    /* JADX WARN: Code duplicated, block: B:234:0x0547 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:235:0x0549  */
    /* JADX WARN: Code duplicated, block: B:236:0x054c  */
    /* JADX WARN: Code duplicated, block: B:238:0x0551  */
    /* JADX WARN: Code duplicated, block: B:240:0x0554 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:241:0x0556  */
    /* JADX WARN: Code duplicated, block: B:243:0x055c  */
    /* JADX WARN: Code duplicated, block: B:245:0x0562  */
    /* JADX WARN: Code duplicated, block: B:247:0x056b  */
    /* JADX WARN: Code duplicated, block: B:252:0x057c  */
    /* JADX WARN: Code duplicated, block: B:254:0x0580 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:256:0x0583  */
    /* JADX WARN: Code duplicated, block: B:258:0x0588  */
    /* JADX WARN: Code duplicated, block: B:260:0x058c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:261:0x058e  */
    /* JADX WARN: Code duplicated, block: B:263:0x0593  */
    /* JADX WARN: Code duplicated, block: B:266:0x0599  */
    /* JADX WARN: Code duplicated, block: B:267:0x0636  */
    /* JADX WARN: Code duplicated, block: B:270:0x0640  */
    /* JADX WARN: Code duplicated, block: B:273:0x064d  */
    /* JADX WARN: Code duplicated, block: B:275:0x0685  */
    /* JADX WARN: Code duplicated, block: B:278:0x06a8  */
    /* JADX WARN: Code duplicated, block: B:280:0x06b1  */
    /* JADX WARN: Code duplicated, block: B:282:0x06c1  */
    /* JADX WARN: Code duplicated, block: B:285:0x06de  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        String shopLogo;
        String goodsImage;
        String goodsPrice;
        boolean z;
        boolean z2;
        boolean shippingFreeFlag;
        String goodsSpec;
        int i2;
        boolean z3;
        TradeTotalPriceBean totalPrice;
        String str;
        TradeBaseInfo value;
        MutableLiveData<TradeBaseInfo> mutableLiveDataR;
        String str2;
        BindingTitleBean value2;
        boolean z4;
        String str3;
        boolean valid;
        boolean z5;
        String str4;
        boolean zIsEmpty;
        boolean z6;
        boolean zIsEmpty2;
        String postage;
        String goodsPriceTotal;
        int i3;
        String postage2;
        boolean zIsEmpty3;
        int i4;
        boolean z7;
        int i5;
        String phone;
        String city;
        String address;
        String receiverName;
        String str5;
        String payAmount;
        String bottomAmount;
        String goodsName;
        String shopName;
        String errorMessage;
        b bVarA;
        c cVar;
        a aVar;
        RequestOptions requestOptions;
        RequestOptions requestOptions2;
        int i6;
        long j2;
        boolean shippingFreeFlag2;
        boolean z8;
        long j3;
        String str6;
        int i7;
        char c2;
        String str7;
        String str8;
        String str9;
        long j4;
        boolean z9;
        String str10;
        String str11;
        boolean z10;
        boolean z11;
        boolean z12;
        String str12;
        boolean z13;
        boolean z14;
        boolean z15;
        int iSafeUnbox;
        long j5;
        MutableLiveData<String> mutableLiveDataP;
        String value3;
        boolean zIsEmpty4;
        long j6;
        long j7;
        BaseViewModel.b bVarE;
        MutableLiveData<Integer> mutableLiveDataA;
        Integer value4;
        MutableLiveData<ShippingAddressBean> mutableLiveDataL;
        TradeGoodsInfoBean goodsInfo;
        int payPointsTotal;
        String bottomPointAmount;
        boolean valid2;
        long j8;
        long j9;
        long j10;
        long j11;
        synchronized (this) {
            j = this.f10161a;
            this.f10161a = 0L;
        }
        CheckOrderVM checkOrderVM = ((MallActivityCheckOrderBinding) this).f10157a;
        CheckOrderActivity.ClickProxy clickProxy = ((MallActivityCheckOrderBinding) this).f10156a;
        float f = 0.0f;
        if ((383 & j) != 0) {
            if ((j & 321) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = checkOrderVM != null ? checkOrderVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value2 = mutableLiveDataI.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 322) != 0) {
                MutableLiveData<Integer> mutableLiveDataM = checkOrderVM != null ? checkOrderVM.m() : null;
                updateLiveDataRegistration(1, mutableLiveDataM);
                str2 = String.format("x%d", mutableLiveDataM != null ? mutableLiveDataM.getValue() : null);
            } else {
                str2 = null;
            }
            long j12 = j & 332;
            int i8 = RunIndexRecordAdapter.O;
            if (j12 != 0) {
                if (checkOrderVM != null) {
                    mutableLiveDataL = checkOrderVM.l();
                    mutableLiveDataR = checkOrderVM.r();
                } else {
                    mutableLiveDataL = null;
                    mutableLiveDataR = null;
                }
                updateLiveDataRegistration(2, mutableLiveDataL);
                updateLiveDataRegistration(3, mutableLiveDataR);
                ShippingAddressBean value5 = mutableLiveDataL != null ? mutableLiveDataL.getValue() : null;
                value = mutableLiveDataR != null ? mutableLiveDataR.getValue() : null;
                if ((j & 324) == 0 || value5 == null) {
                    phone = null;
                    city = null;
                    address = null;
                    receiverName = null;
                } else {
                    phone = value5.formatPhone();
                    city = value5.formatCity();
                    address = value5.getAddress();
                    receiverName = value5.getReceiverName();
                }
                z15 = value5 != null;
                z14 = value5 == null;
                if ((j & 8192) != 0) {
                    j |= z15 ? 16777216L : 8388608L;
                }
                if ((j & 332) != 0) {
                    j = z15 ? j | 68719476736L : j | 34359738368L;
                }
                if ((j & 332) != 0) {
                    j = z14 ? j | PlaybackStateCompat.ACTION_PREPARE : j | 8192;
                }
                if ((j & 324) != 0) {
                    if (z14) {
                        j10 = j | 67108864;
                        j11 = 17179869184L;
                    } else {
                        j10 = j | 33554432;
                        j11 = g89.f;
                    }
                    j = j10 | j11;
                }
                valid = value != null ? value.getValid() : false;
                if ((j & 332) != 0) {
                    j |= valid ? FileUtils.ONE_GB : 536870912L;
                }
                if ((j & 324) != 0) {
                    i4 = z14 ? -4079167 : -13877680;
                    str5 = z14 ? "添加收货地址后计算" : "包邮";
                } else {
                    i4 = 0;
                    str5 = null;
                }
                long j13 = j & 328;
                if (j13 != 0) {
                    if (value != null) {
                        totalPrice = value.getTotalPrice();
                        goodsInfo = value.getGoodsInfo();
                    } else {
                        totalPrice = null;
                        goodsInfo = null;
                    }
                    if (totalPrice != null) {
                        payPointsTotal = totalPrice.getPayPointsTotal();
                        payAmount = totalPrice.getPayAmount();
                        bottomAmount = totalPrice.getBottomAmount();
                        postage = totalPrice.getPostage();
                        goodsPriceTotal = totalPrice.getGoodsPriceTotal();
                        bottomPointAmount = totalPrice.getBottomPointAmount();
                    } else {
                        payPointsTotal = 0;
                        payAmount = null;
                        bottomAmount = null;
                        postage = null;
                        goodsPriceTotal = null;
                        bottomPointAmount = null;
                    }
                    if (goodsInfo != null) {
                        goodsImage = goodsInfo.getGoodsImage();
                        goodsPrice = goodsInfo.getGoodsPrice();
                        shippingFreeFlag = goodsInfo.getShippingFreeFlag();
                        valid2 = goodsInfo.getValid();
                        goodsName = goodsInfo.getGoodsName();
                        shopName = goodsInfo.getShopName();
                        errorMessage = goodsInfo.getErrorMessage();
                        goodsSpec = goodsInfo.getGoodsSpec();
                        postage2 = goodsInfo.getPostage();
                        shopLogo = goodsInfo.getShopLogo();
                    } else {
                        shopLogo = null;
                        goodsImage = null;
                        goodsPrice = null;
                        shippingFreeFlag = false;
                        valid2 = false;
                        goodsName = null;
                        shopName = null;
                        errorMessage = null;
                        goodsSpec = null;
                        postage2 = null;
                    }
                    if (j13 != 0) {
                        if (valid2) {
                            j8 = j | 4096 | 262144;
                            j9 = 268435456;
                        } else {
                            j8 = j | 2048 | 131072;
                            j9 = 134217728;
                        }
                        j = j8 | j9;
                    }
                    str4 = String.format("减%d闪金币", Integer.valueOf(payPointsTotal));
                    z5 = payPointsTotal > 0;
                    zIsEmpty = TextUtils.isEmpty(postage);
                    zIsEmpty2 = TextUtils.isEmpty(goodsPriceTotal);
                    str12 = String.format(" + %s", bottomPointAmount);
                    boolean zIsEmpty5 = TextUtils.isEmpty(bottomPointAmount);
                    z6 = !shippingFreeFlag;
                    f = valid2 ? 1.0f : 0.5f;
                    i = valid2 ? -7759964 : -4079167;
                    z7 = !valid2;
                    i2 = valid2 ? -13877680 : -4079167;
                    zIsEmpty3 = TextUtils.isEmpty(postage2);
                    if ((j & 328) != 0) {
                        j = zIsEmpty ? j | PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED : j | 2097152;
                    }
                    if ((j & 328) != 0) {
                        j = zIsEmpty2 ? j | 1048576 : j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                    }
                    if ((j & 328) != 0) {
                        j = zIsEmpty3 ? j | 4294967296L : j | 2147483648L;
                    }
                    z13 = !zIsEmpty5;
                } else {
                    str12 = null;
                    z13 = false;
                    str4 = null;
                    z5 = false;
                    z6 = false;
                    totalPrice = null;
                }
                if ((j & 336) != 0) {
                    if (checkOrderVM != null) {
                        bVarE = checkOrderVM.e();
                    } else {
                        bVarE = null;
                    }
                    if (bVarE != null) {
                        mutableLiveDataA = bVarE.a();
                    } else {
                        mutableLiveDataA = null;
                    }
                    updateLiveDataRegistration(4, mutableLiveDataA);
                    if (mutableLiveDataA != null) {
                        value4 = mutableLiveDataA.getValue();
                    } else {
                        value4 = null;
                    }
                    iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(value4) + 8));
                } else {
                    str12 = str12;
                    iSafeUnbox = 0;
                }
                j5 = j & 352;
                if (j5 != 0) {
                    if (checkOrderVM != null) {
                        mutableLiveDataP = checkOrderVM.p();
                    } else {
                        mutableLiveDataP = null;
                    }
                    updateLiveDataRegistration(5, mutableLiveDataP);
                    if (mutableLiveDataP != null) {
                        value3 = mutableLiveDataP.getValue();
                    } else {
                        value3 = null;
                    }
                    zIsEmpty4 = TextUtils.isEmpty(value3);
                    if (j5 != 0) {
                        if (zIsEmpty4) {
                            j6 = j | 1024;
                            j7 = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                        } else {
                            j6 = j | 512;
                            j7 = PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                        }
                        j = j6 | j7;
                    }
                    if (!zIsEmpty4) {
                        i8 = -13877680;
                    }
                    z = zIsEmpty4;
                    i5 = i8;
                    z4 = z13;
                    str = value3;
                } else {
                    iSafeUnbox = iSafeUnbox;
                    z4 = z13;
                    z = false;
                    str = null;
                    i5 = 0;
                }
                i3 = iSafeUnbox;
                z3 = z14;
                z2 = z15;
                str3 = str12;
            } else {
                str12 = null;
                z13 = false;
                str4 = null;
                z5 = false;
                z14 = false;
                value = null;
                z6 = false;
                mutableLiveDataR = null;
                totalPrice = null;
                phone = null;
                city = null;
                address = null;
                receiverName = null;
                z15 = false;
                valid = false;
                i4 = 0;
                str5 = null;
            }
            zIsEmpty = false;
            shopLogo = null;
            zIsEmpty2 = false;
            payAmount = null;
            bottomAmount = null;
            postage = null;
            goodsPriceTotal = null;
            goodsImage = null;
            goodsPrice = null;
            shippingFreeFlag = false;
            i2 = 0;
            goodsName = null;
            shopName = null;
            errorMessage = null;
            goodsSpec = null;
            postage2 = null;
            i = 0;
            z7 = false;
            zIsEmpty3 = false;
            if ((j & 336) != 0) {
                if (checkOrderVM != null) {
                    bVarE = checkOrderVM.e();
                } else {
                    bVarE = null;
                }
                if (bVarE != null) {
                    mutableLiveDataA = bVarE.a();
                } else {
                    mutableLiveDataA = null;
                }
                updateLiveDataRegistration(4, mutableLiveDataA);
                if (mutableLiveDataA != null) {
                    value4 = mutableLiveDataA.getValue();
                } else {
                    value4 = null;
                }
                iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(value4) + 8));
            } else {
                str12 = str12;
                iSafeUnbox = 0;
            }
            j5 = j & 352;
            if (j5 != 0) {
                if (checkOrderVM != null) {
                    mutableLiveDataP = checkOrderVM.p();
                } else {
                    mutableLiveDataP = null;
                }
                updateLiveDataRegistration(5, mutableLiveDataP);
                if (mutableLiveDataP != null) {
                    value3 = mutableLiveDataP.getValue();
                } else {
                    value3 = null;
                }
                zIsEmpty4 = TextUtils.isEmpty(value3);
                if (j5 != 0) {
                    if (zIsEmpty4) {
                        j6 = j | 1024;
                        j7 = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                    } else {
                        j6 = j | 512;
                        j7 = PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                    }
                    j = j6 | j7;
                }
                if (!zIsEmpty4) {
                    i8 = -13877680;
                }
                z = zIsEmpty4;
                i5 = i8;
                z4 = z13;
                str = value3;
            } else {
                iSafeUnbox = iSafeUnbox;
                z4 = z13;
                z = false;
                str = null;
                i5 = 0;
            }
            i3 = iSafeUnbox;
            z3 = z14;
            z2 = z15;
            str3 = str12;
        } else {
            f = 0.0f;
            i = 0;
            shopLogo = null;
            goodsImage = null;
            goodsPrice = null;
            z = false;
            z2 = false;
            shippingFreeFlag = false;
            goodsSpec = null;
            i2 = 0;
            z3 = false;
            totalPrice = null;
            str = null;
            value = null;
            mutableLiveDataR = null;
            str2 = null;
            value2 = null;
            z4 = false;
            str3 = null;
            valid = false;
            z5 = false;
            str4 = null;
            zIsEmpty = false;
            z6 = false;
            zIsEmpty2 = false;
            postage = null;
            goodsPriceTotal = null;
            i3 = 0;
            postage2 = null;
            zIsEmpty3 = false;
            i4 = 0;
            z7 = false;
            i5 = 0;
            phone = null;
            city = null;
            address = null;
            receiverName = null;
            str5 = null;
            payAmount = null;
            bottomAmount = null;
            goodsName = null;
            shopName = null;
            errorMessage = null;
        }
        long j14 = j & 384;
        if (j14 == 0 || clickProxy == null) {
            bVarA = null;
            cVar = null;
            aVar = null;
        } else {
            c cVar2 = this.f10166a;
            if (cVar2 == null) {
                cVar2 = new c();
                this.f10166a = cVar2;
            }
            c cVarA = cVar2.a(clickProxy);
            a aVar2 = this.f10164a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f10164a = aVar2;
            }
            a aVarA = aVar2.a(clickProxy);
            b bVar = this.f10165a;
            if (bVar == null) {
                bVar = new b();
                this.f10165a = bVar;
            }
            bVarA = bVar.a(clickProxy);
            cVar = cVarA;
            aVar = aVarA;
        }
        long j15 = j & 328;
        if (j15 != 0) {
            RequestOptions requestOptions3 = ju3.m;
            requestOptions = ju3.d;
            requestOptions2 = requestOptions3;
        } else {
            requestOptions = null;
            requestOptions2 = null;
        }
        if ((j & 68736253952L) != 0) {
            MutableLiveData<TradeBaseInfo> mutableLiveDataR2 = checkOrderVM != null ? checkOrderVM.r() : mutableLiveDataR;
            i6 = i2;
            updateLiveDataRegistration(3, mutableLiveDataR2);
            TradeBaseInfo value6 = mutableLiveDataR2 != null ? mutableLiveDataR2.getValue() : value;
            if (value6 != null) {
                totalPrice = value6.getTotalPrice();
            }
            shippingFreeFlag2 = totalPrice != null ? totalPrice.getShippingFreeFlag() : false;
            j2 = 0;
            z8 = (j & 68719476736L) != 0 ? !shippingFreeFlag2 : false;
            j3 = j & 352;
            if (j3 != j2) {
                if (z) {
                    str = "无备注";
                }
                str6 = str;
            } else {
                str6 = null;
            }
            if ((j & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) != j2) {
                i7 = 1;
                c2 = 0;
                str7 = String.format("¥%s", goodsPriceTotal);
            } else {
                i7 = 1;
                c2 = 0;
                str7 = null;
            }
            if ((j & 2097152) != j2) {
                Object[] objArr = new Object[i7];
                objArr[c2] = postage;
                str8 = String.format("¥%s", objArr);
            } else {
                str8 = null;
            }
            if ((j & 2147483648L) != j2) {
                Object[] objArr2 = new Object[i7];
                objArr2[c2] = postage2;
                str9 = String.format("¥%s", objArr2);
            } else {
                str9 = null;
            }
            j4 = j & 332;
            if (j4 != j2) {
                if (valid) {
                    z12 = z2;
                } else {
                    z12 = false;
                }
                z9 = z12;
            } else {
                z9 = false;
            }
            if (j15 != 0) {
                if (zIsEmpty2) {
                    str7 = "";
                }
                if (zIsEmpty) {
                    str8 = "";
                }
                if (zIsEmpty3) {
                    str9 = "";
                }
                str11 = str8;
                str10 = str7;
            } else {
                str9 = null;
                str10 = null;
                str11 = null;
            }
            if ((j & 8192) != 0 || !z2) {
                shippingFreeFlag2 = false;
            }
            if (j4 != j2) {
                if (!z2) {
                    z8 = false;
                }
                z10 = z8;
            } else {
                z10 = false;
            }
            if (j4 != j2) {
                if (z3) {
                    shippingFreeFlag2 = true;
                }
                z11 = shippingFreeFlag2;
            } else {
                z11 = false;
            }
            if (j15 != 0) {
                CommonBindingAdapter.b0(((MallActivityCheckOrderBinding) this).f34776a, shopLogo, requestOptions, false);
                CommonBindingAdapter.c0(((MallActivityCheckOrderBinding) this).b, f);
                CommonBindingAdapter.b0(((MallActivityCheckOrderBinding) this).b, goodsImage, requestOptions2, false);
                TextViewBindingAdapter.setText(this.m, goodsSpec);
                this.m.setTextColor(i);
                TextViewBindingAdapter.setText(this.f10167a, goodsPrice);
                int i9 = i6;
                this.f10167a.setTextColor(i9);
                this.n.setTextColor(i9);
                CommonBindingAdapter.l0(this.o, shippingFreeFlag);
                TextViewBindingAdapter.setText(this.f10170b, str9);
                CommonBindingAdapter.l0(this.f10170b, z6);
                TextViewBindingAdapter.setText(this.c, str10);
                TextViewBindingAdapter.setText(this.d, str11);
                TextViewBindingAdapter.setText(this.r, str4);
                boolean z16 = z5;
                CommonBindingAdapter.l0(this.r, z16);
                TextViewBindingAdapter.setText(this.e, payAmount);
                TextViewBindingAdapter.setText(this.f, bottomAmount);
                TextViewBindingAdapter.setText(this.s, str3);
                CommonBindingAdapter.l0(this.s, z4);
                TextViewBindingAdapter.setText(this.t, shopName);
                TextViewBindingAdapter.setText(super.c, errorMessage);
                CommonBindingAdapter.l0(super.c, z7);
                CommonBindingAdapter.l0(super.e, z16);
                TextViewBindingAdapter.setText(this.g, goodsName);
                this.g.setTextColor(i9);
            }
            if ((j & 321) != 0) {
                this.f10163a.k(value2);
            }
            if ((j & 324) != 0) {
                CommonBindingAdapter.l0(this.f10168a, z3);
                CommonBindingAdapter.l0(this.f10169a, z2);
                TextViewBindingAdapter.setText(this.q, str5);
                this.q.setTextColor(i4);
                TextViewBindingAdapter.setText(((MallActivityCheckOrderBinding) this).f10155a, address);
                TextViewBindingAdapter.setText(((MallActivityCheckOrderBinding) this).f10159b, city);
                TextViewBindingAdapter.setText(this.i, receiverName);
                TextViewBindingAdapter.setText(this.j, phone);
            }
            if (j14 != 0) {
                b bVar2 = bVarA;
                CommonBindingAdapter.q(this.f10168a, bVar2, null);
                CommonBindingAdapter.q(this.p, cVar, null);
                CommonBindingAdapter.q(this.f10169a, bVar2, null);
                CommonBindingAdapter.q(this.f10171b, aVar, null);
            }
            if ((j & 322) != 0) {
                TextViewBindingAdapter.setText(this.n, str2);
            }
            if (j3 != j2) {
                TextViewBindingAdapter.setText(this.p, str6);
                this.p.setTextColor(i5);
            }
            if (j4 != j2) {
                CommonBindingAdapter.l0(this.d, z10);
                CommonBindingAdapter.l0(this.q, z11);
                CommonBindingAdapter.e0(this.f10171b, z9);
            }
            if ((j & 336) != 0) {
                CommonBindingAdapter.I(this.b, 16, 8, 16, i3, null);
            }
            ViewDataBinding.executeBindingsOn(this.f10163a);
        }
        i6 = i2;
        j2 = 0;
        shippingFreeFlag2 = false;
        j3 = j & 352;
        if (j3 != j2) {
            if (z) {
                str = "无备注";
            }
            str6 = str;
        } else {
            str6 = null;
        }
        if ((j & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) != j2) {
            i7 = 1;
            c2 = 0;
            str7 = String.format("¥%s", goodsPriceTotal);
        } else {
            i7 = 1;
            c2 = 0;
            str7 = null;
        }
        if ((j & 2097152) != j2) {
            Object[] objArr3 = new Object[i7];
            objArr3[c2] = postage;
            str8 = String.format("¥%s", objArr3);
        } else {
            str8 = null;
        }
        if ((j & 2147483648L) != j2) {
            Object[] objArr4 = new Object[i7];
            objArr4[c2] = postage2;
            str9 = String.format("¥%s", objArr4);
        } else {
            str9 = null;
        }
        j4 = j & 332;
        if (j4 != j2) {
            if (valid) {
                z12 = z2;
            } else {
                z12 = false;
            }
            z9 = z12;
        } else {
            z9 = false;
        }
        if (j15 != 0) {
            if (zIsEmpty2) {
                str7 = "";
            }
            if (zIsEmpty) {
                str8 = "";
            }
            if (zIsEmpty3) {
                str9 = "";
            }
            str11 = str8;
            str10 = str7;
        } else {
            str9 = null;
            str10 = null;
            str11 = null;
        }
        if ((j & 8192) != 0) {
            shippingFreeFlag2 = false;
        } else {
            shippingFreeFlag2 = false;
        }
        if (j4 != j2) {
            if (!z2) {
                z8 = false;
            }
            z10 = z8;
        } else {
            z10 = false;
        }
        if (j4 != j2) {
            if (z3) {
                shippingFreeFlag2 = true;
            }
            z11 = shippingFreeFlag2;
        } else {
            z11 = false;
        }
        if (j15 != 0) {
            CommonBindingAdapter.b0(((MallActivityCheckOrderBinding) this).f34776a, shopLogo, requestOptions, false);
            CommonBindingAdapter.c0(((MallActivityCheckOrderBinding) this).b, f);
            CommonBindingAdapter.b0(((MallActivityCheckOrderBinding) this).b, goodsImage, requestOptions2, false);
            TextViewBindingAdapter.setText(this.m, goodsSpec);
            this.m.setTextColor(i);
            TextViewBindingAdapter.setText(this.f10167a, goodsPrice);
            int i10 = i6;
            this.f10167a.setTextColor(i10);
            this.n.setTextColor(i10);
            CommonBindingAdapter.l0(this.o, shippingFreeFlag);
            TextViewBindingAdapter.setText(this.f10170b, str9);
            CommonBindingAdapter.l0(this.f10170b, z6);
            TextViewBindingAdapter.setText(this.c, str10);
            TextViewBindingAdapter.setText(this.d, str11);
            TextViewBindingAdapter.setText(this.r, str4);
            boolean z17 = z5;
            CommonBindingAdapter.l0(this.r, z17);
            TextViewBindingAdapter.setText(this.e, payAmount);
            TextViewBindingAdapter.setText(this.f, bottomAmount);
            TextViewBindingAdapter.setText(this.s, str3);
            CommonBindingAdapter.l0(this.s, z4);
            TextViewBindingAdapter.setText(this.t, shopName);
            TextViewBindingAdapter.setText(super.c, errorMessage);
            CommonBindingAdapter.l0(super.c, z7);
            CommonBindingAdapter.l0(super.e, z17);
            TextViewBindingAdapter.setText(this.g, goodsName);
            this.g.setTextColor(i10);
        }
        if ((j & 321) != 0) {
            this.f10163a.k(value2);
        }
        if ((j & 324) != 0) {
            CommonBindingAdapter.l0(this.f10168a, z3);
            CommonBindingAdapter.l0(this.f10169a, z2);
            TextViewBindingAdapter.setText(this.q, str5);
            this.q.setTextColor(i4);
            TextViewBindingAdapter.setText(((MallActivityCheckOrderBinding) this).f10155a, address);
            TextViewBindingAdapter.setText(((MallActivityCheckOrderBinding) this).f10159b, city);
            TextViewBindingAdapter.setText(this.i, receiverName);
            TextViewBindingAdapter.setText(this.j, phone);
        }
        if (j14 != 0) {
            b bVar3 = bVarA;
            CommonBindingAdapter.q(this.f10168a, bVar3, null);
            CommonBindingAdapter.q(this.p, cVar, null);
            CommonBindingAdapter.q(this.f10169a, bVar3, null);
            CommonBindingAdapter.q(this.f10171b, aVar, null);
        }
        if ((j & 322) != 0) {
            TextViewBindingAdapter.setText(this.n, str2);
        }
        if (j3 != j2) {
            TextViewBindingAdapter.setText(this.p, str6);
            this.p.setTextColor(i5);
        }
        if (j4 != j2) {
            CommonBindingAdapter.l0(this.d, z10);
            CommonBindingAdapter.l0(this.q, z11);
            CommonBindingAdapter.e0(this.f10171b, z9);
        }
        if ((j & 336) != 0) {
            CommonBindingAdapter.I(this.b, 16, 8, 16, i3, null);
        }
        ViewDataBinding.executeBindingsOn(this.f10163a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10161a != 0) {
                return true;
            }
            return this.f10163a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10161a = 256L;
        }
        this.f10163a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityCheckOrderBinding
    public void l(@Nullable CheckOrderActivity.ClickProxy clickProxy) {
        ((MallActivityCheckOrderBinding) this).f10156a = clickProxy;
        synchronized (this) {
            this.f10161a |= 128;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityCheckOrderBinding
    public void m(@Nullable CheckOrderVM checkOrderVM) {
        ((MallActivityCheckOrderBinding) this).f10157a = checkOrderVM;
        synchronized (this) {
            this.f10161a |= 64;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<ShippingAddressBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10161a |= 4;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10161a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return q((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return n((MutableLiveData) obj, i2);
        }
        if (i == 3) {
            return r((MutableLiveData) obj, i2);
        }
        if (i == 4) {
            return s((MutableLiveData) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return p((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<String> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10161a |= 32;
        }
        return true;
    }

    public final boolean q(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10161a |= 1;
        }
        return true;
    }

    public final boolean r(MutableLiveData<TradeBaseInfo> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10161a |= 8;
        }
        return true;
    }

    public final boolean s(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10161a |= 16;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f10163a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            m((CheckOrderVM) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((CheckOrderActivity.ClickProxy) obj);
        }
        return true;
    }

    public MallActivityCheckOrderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (ImageView) objArr[7], (ImageView) objArr[9], (TextView) objArr[4], (BLTextView) objArr[29], (TextView) objArr[3], (TextView) objArr[14], (TextView) objArr[33], (TextView) objArr[21], (TextView) objArr[30], (TextView) objArr[10], (TextView) objArr[32], (TextView) objArr[5], (TextView) objArr[6], (TextView) objArr[31], (TextView) objArr[34]);
        this.f10161a = -1L;
        ((MallActivityCheckOrderBinding) this).f34776a.setTag(null);
        ((MallActivityCheckOrderBinding) this).b.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[28];
        this.f10163a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10162a = linearLayout;
        linearLayout.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[1];
        this.f10168a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        TextView textView = (TextView) objArr[11];
        this.m = textView;
        textView.setTag(null);
        PriceView priceView = (PriceView) objArr[12];
        this.f10167a = priceView;
        priceView.setTag(null);
        TextView textView2 = (TextView) objArr[13];
        this.n = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[15];
        this.o = textView3;
        textView3.setTag(null);
        PriceView priceView2 = (PriceView) objArr[16];
        this.f10170b = priceView2;
        priceView2.setTag(null);
        TextView textView4 = (TextView) objArr[17];
        this.p = textView4;
        textView4.setTag(null);
        PriceView priceView3 = (PriceView) objArr[18];
        this.c = priceView3;
        priceView3.setTag(null);
        PriceView priceView4 = (PriceView) objArr[19];
        this.d = priceView4;
        priceView4.setTag(null);
        BLRelativeLayout bLRelativeLayout = (BLRelativeLayout) objArr[2];
        this.f10169a = bLRelativeLayout;
        bLRelativeLayout.setTag(null);
        TextView textView5 = (TextView) objArr[20];
        this.q = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[22];
        this.r = textView6;
        textView6.setTag(null);
        PriceView priceView5 = (PriceView) objArr[23];
        this.e = priceView5;
        priceView5.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[24];
        this.b = linearLayout2;
        linearLayout2.setTag(null);
        PriceView priceView6 = (PriceView) objArr[25];
        this.f = priceView6;
        priceView6.setTag(null);
        TextView textView7 = (TextView) objArr[26];
        this.s = textView7;
        textView7.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[27];
        this.f10171b = bLTextView;
        bLTextView.setTag(null);
        TextView textView8 = (TextView) objArr[8];
        this.t = textView8;
        textView8.setTag(null);
        ((MallActivityCheckOrderBinding) this).f10155a.setTag(null);
        ((MallActivityCheckOrderBinding) this).f10159b.setTag(null);
        super.c.setTag(null);
        super.e.setTag(null);
        this.g.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
