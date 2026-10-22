package com.huachenjie.mall.page.goods_detail;

import android.text.TextUtils;
import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.bean.ImageBean;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailBean;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailSku;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.cy6;
import com.zj.adlib.fk8;
import com.zj.adlib.i46;
import com.zj.adlib.y6b;
import com.zj.adlib.ys8;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b@\u0010AJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\b8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\fR\u001f\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001d\u0010\fR\"\u0010%\u001a\u00020\u001f8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\t\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0006¢\u0006\f\n\u0004\b+\u0010\n\u001a\u0004\b,\u0010\fR\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020.0\b8\u0006¢\u0006\f\n\u0004\b/\u0010\n\u001a\u0004\b0\u0010\fR\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020.0\b8\u0006¢\u0006\f\n\u0004\b\u0007\u0010\n\u001a\u0004\b2\u0010\fR\u001d\u00105\u001a\b\u0012\u0004\u0012\u00020\u00170\b8\u0006¢\u0006\f\n\u0004\b0\u0010\n\u001a\u0004\b4\u0010\fR\u001d\u00108\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0006¢\u0006\f\n\u0004\b6\u0010\n\u001a\u0004\b7\u0010\fR\u001d\u00109\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0006¢\u0006\f\n\u0004\b7\u0010\n\u001a\u0004\b6\u0010\fR\"\u0010?\u001a\u00020.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006B"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/GoodsSpecificationVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "selSpecIndexArray", "", "B", "", "i", "Landroidx/lifecycle/MutableLiveData;", "a", "Landroidx/lifecycle/MutableLiveData;", j.b, "()Landroidx/lifecycle/MutableLiveData;", "goodsImage", "b", "r", "price", "c", "q", "outPrice", "d", "w", "selSpecStr", "", "e", "p", "goodsNum", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailSku;", "f", "u", "selSku", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailBean;", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailBean;", "m", "()Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailBean;", "y", "(Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailBean;)V", "detailBean", "[I", "v", "()[I", "A", "([I)V", y6b.f, "t", "remainTimeStr", "", y6b.g, "j", "canExchange", "s", "promotion", "x", "squareType", "k", t.d, "commissionStr", "commissionRateStr", "Z", "n", "()Z", j.o, "(Z)V", "fromReward", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class GoodsSpecificationVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public GoodsDetailBean detailBean;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean fromReward;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public int[] selSpecIndexArray;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> goodsImage = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> price = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> outPrice = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> selSpecStr = new MutableLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> goodsNum = new MutableLiveData<>();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<GoodsDetailSku> selSku = new MutableLiveData<>();

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> remainTimeStr = new MutableLiveData<>();

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> canExchange = new MutableLiveData<>();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> promotion = new MutableLiveData<>(Boolean.FALSE);

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> squareType = new MutableLiveData<>(0);

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> commissionStr = new MutableLiveData<>();

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> commissionRateStr = new MutableLiveData<>();

    public final void A(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.selSpecIndexArray = iArr;
    }

    public final void B(@NotNull int[] selSpecIndexArray) {
        String str;
        String commissionRate;
        String url;
        String url2;
        Intrinsics.checkNotNullParameter(selSpecIndexArray, "selSpecIndexArray");
        A(selSpecIndexArray);
        String url3 = "";
        if (ArraysKt.contains(selSpecIndexArray, -1)) {
            this.selSku.setValue(null);
            str = "";
        } else {
            Pair<GoodsDetailSku, String> pairA = fk8.f41700a.a(m().getSpecList(), m().getSkuList(), selSpecIndexArray);
            this.selSku.setValue((GoodsDetailSku) pairA.getFirst());
            str = (String) pairA.getSecond();
        }
        if (this.selSku.getValue() == null) {
            MutableLiveData<String> mutableLiveData = this.goodsImage;
            ImageBean imageBean = (ImageBean) CollectionsKt.firstOrNull(m().getMainImageList());
            if (imageBean == null || (url2 = imageBean.getUrl()) == null) {
                url2 = "";
            }
            mutableLiveData.setValue(url2);
            this.price.setValue(cy6.e(m().getType(), m().getMultipleSku(), m().getMinSkuPrice(), m().getMaxSkuPrice(), m().getMinPointsInMinPriceSku(), m().getMaxPointsInMinPriceSku()));
            this.outPrice.setValue("");
            this.selSpecStr.setValue("");
            this.goodsNum.setValue(1);
            Integer value = this.squareType.getValue();
            String strA = i46.a((value != null && value.intValue() == 1) ? m().getBaseCommission() : m().getCooperationCommission());
            this.commissionStr.setValue((char) 165 + strA);
            MutableLiveData<String> mutableLiveData2 = this.commissionRateStr;
            Integer value2 = this.squareType.getValue();
            mutableLiveData2.setValue((value2 != null && value2.intValue() == 1) ? m().formatBaseCommissionRate() : m().formatCommissionRate());
            return;
        }
        MutableLiveData<String> mutableLiveData3 = this.goodsImage;
        GoodsDetailSku value3 = this.selSku.getValue();
        Intrinsics.checkNotNull(value3);
        ImageBean skuImageInfo = value3.getSkuImageInfo();
        if (TextUtils.isEmpty(skuImageInfo != null ? skuImageInfo.getUrl() : null)) {
            ImageBean imageBean2 = (ImageBean) CollectionsKt.firstOrNull(m().getMainImageList());
            if (imageBean2 != null && (url = imageBean2.getUrl()) != null) {
                url3 = url;
            }
        } else {
            GoodsDetailSku value4 = this.selSku.getValue();
            Intrinsics.checkNotNull(value4);
            ImageBean skuImageInfo2 = value4.getSkuImageInfo();
            Intrinsics.checkNotNull(skuImageInfo2);
            url3 = skuImageInfo2.getUrl();
        }
        mutableLiveData3.setValue(url3);
        MutableLiveData<String> mutableLiveData4 = this.price;
        int type = m().getType();
        GoodsDetailSku value5 = this.selSku.getValue();
        Intrinsics.checkNotNull(value5);
        String salePrice = value5.getSalePrice();
        GoodsDetailSku value6 = this.selSku.getValue();
        Intrinsics.checkNotNull(value6);
        mutableLiveData4.setValue(cy6.h(type, salePrice, value6.getPointsPrice()));
        MutableLiveData<String> mutableLiveData5 = this.outPrice;
        StringBuilder sb = new StringBuilder();
        sb.append((char) 165);
        GoodsDetailSku value7 = this.selSku.getValue();
        Intrinsics.checkNotNull(value7);
        sb.append(value7.getOutPrice());
        mutableLiveData5.setValue(sb.toString());
        this.selSpecStr.setValue(str);
        if (this.goodsNum.getValue() == null) {
            this.goodsNum.setValue(1);
        } else {
            Integer value8 = this.goodsNum.getValue();
            Intrinsics.checkNotNull(value8);
            int iIntValue = value8.intValue();
            GoodsDetailSku value9 = this.selSku.getValue();
            Intrinsics.checkNotNull(value9);
            if (iIntValue > value9.getAvailableStock()) {
                MutableLiveData<Integer> mutableLiveData6 = this.goodsNum;
                GoodsDetailSku value10 = this.selSku.getValue();
                Intrinsics.checkNotNull(value10);
                mutableLiveData6.setValue(Integer.valueOf(value10.getAvailableStock()));
            }
        }
        MutableLiveData<String> mutableLiveData7 = this.commissionStr;
        GoodsDetailSku value11 = this.selSku.getValue();
        Intrinsics.checkNotNull(value11);
        GoodsDetailSku goodsDetailSku = value11;
        Integer value12 = this.squareType.getValue();
        if (value12 == null) {
            value12 = 0;
        }
        mutableLiveData7.setValue(goodsDetailSku.formatCommission(value12.intValue()));
        MutableLiveData<String> mutableLiveData8 = this.commissionRateStr;
        Integer value13 = this.squareType.getValue();
        if (value13 != null && value13.intValue() == 1) {
            GoodsDetailSku value14 = this.selSku.getValue();
            Intrinsics.checkNotNull(value14);
            commissionRate = value14.formatBaseCommissionRate();
        } else {
            GoodsDetailSku value15 = this.selSku.getValue();
            Intrinsics.checkNotNull(value15);
            commissionRate = value15.formatCommissionRate();
        }
        mutableLiveData8.setValue(commissionRate);
    }

    @NotNull
    public final String i() {
        if (this.selSku.getValue() != null) {
            GoodsDetailSku value = this.selSku.getValue();
            Intrinsics.checkNotNull(value);
            if (value.getAvailableStock() <= 0) {
                String strE = ys8.e(R.string.mall_goods_detail_out_of_stock);
                Intrinsics.checkNotNullExpressionValue(strE, "{\n            StringUtil…l_out_of_stock)\n        }");
                return strE;
            }
        }
        if (this.fromReward) {
            String strE2 = ys8.e(R.string.mall_goods_detail_receive_now);
            Intrinsics.checkNotNullExpressionValue(strE2, "{\n            StringUtil…il_receive_now)\n        }");
            return strE2;
        }
        if (m().getType() == 3) {
            String strE3 = ys8.e(R.string.mall_goods_detail_buy_now_point);
            Intrinsics.checkNotNullExpressionValue(strE3, "{\n            StringUtil…_buy_now_point)\n        }");
            return strE3;
        }
        String strE4 = ys8.e(R.string.mall_goods_detail_buy_now);
        Intrinsics.checkNotNullExpressionValue(strE4, "{\n            StringUtil…detail_buy_now)\n        }");
        return strE4;
    }

    @NotNull
    public final MutableLiveData<Boolean> j() {
        return this.canExchange;
    }

    @NotNull
    public final MutableLiveData<String> k() {
        return this.commissionRateStr;
    }

    @NotNull
    public final MutableLiveData<String> l() {
        return this.commissionStr;
    }

    @NotNull
    public final GoodsDetailBean m() {
        GoodsDetailBean goodsDetailBean = this.detailBean;
        if (goodsDetailBean != null) {
            return goodsDetailBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("detailBean");
        return null;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final boolean getFromReward() {
        return this.fromReward;
    }

    @NotNull
    public final MutableLiveData<String> o() {
        return this.goodsImage;
    }

    @NotNull
    public final MutableLiveData<Integer> p() {
        return this.goodsNum;
    }

    @NotNull
    public final MutableLiveData<String> q() {
        return this.outPrice;
    }

    @NotNull
    public final MutableLiveData<String> r() {
        return this.price;
    }

    @NotNull
    public final MutableLiveData<Boolean> s() {
        return this.promotion;
    }

    @NotNull
    public final MutableLiveData<String> t() {
        return this.remainTimeStr;
    }

    @NotNull
    public final MutableLiveData<GoodsDetailSku> u() {
        return this.selSku;
    }

    @NotNull
    public final int[] v() {
        int[] iArr = this.selSpecIndexArray;
        if (iArr != null) {
            return iArr;
        }
        Intrinsics.throwUninitializedPropertyAccessException("selSpecIndexArray");
        return null;
    }

    @NotNull
    public final MutableLiveData<String> w() {
        return this.selSpecStr;
    }

    @NotNull
    public final MutableLiveData<Integer> x() {
        return this.squareType;
    }

    public final void y(@NotNull GoodsDetailBean goodsDetailBean) {
        Intrinsics.checkNotNullParameter(goodsDetailBean, "<set-?>");
        this.detailBean = goodsDetailBean;
    }

    public final void z(boolean z) {
        this.fromReward = z;
    }
}
