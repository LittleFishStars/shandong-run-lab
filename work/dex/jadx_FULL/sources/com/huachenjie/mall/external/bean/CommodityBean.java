package com.huachenjie.mall.external.bean;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.base.bean.ImageBean;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import com.zj.adlib.b49;
import com.zj.adlib.c49;
import com.zj.adlib.cy6;
import com.zj.adlib.qv1;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\r\n\u0002\b\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e¢\u0006\u0002\u0010\u000fJ\u0006\u0010!\u001a\u00020\u0003J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#J\u0006\u0010%\u001a\u00020#J\u0006\u0010&\u001a\u00020\u0003J\u0006\u0010'\u001a\u00020\u0014J\u0006\u0010(\u001a\u00020\u0014J\u0006\u0010)\u001a\u00020\u0007J\u0006\u0010*\u001a\u00020\u0007R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0011¨\u0006+"}, d2 = {"Lcom/huachenjie/mall/external/bean/CommodityBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "goodsNo", "", "shopNo", "goodsName", "multipleSku", "", "minSkuPrice", "maxSkuPrice", "totalSaleCount", "imageInfo", "Lcom/huachenjie/base/bean/ImageBean;", "labelList", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/huachenjie/base/bean/ImageBean;Ljava/util/List;)V", "getGoodsName", "()Ljava/lang/String;", "getGoodsNo", CollegeTownItemFragment.ITEM_TYPE, "", "getItemType", "()I", "getLabelList", "()Ljava/util/List;", "getMaxSkuPrice", "getMinSkuPrice", "getMultipleSku", "()Z", "priceStr", "getPriceStr", "getShopNo", "getTotalSaleCount", "findLabelImage", "formatPrice", "", "formatSaleCount", "formatStrikePrice", "getGoodsCover", "getGoodsCoverHeight", "getGoodsCoverWidth", "showLabelImage", "showStrike", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CommodityBean implements MultiItemEntity {

    @NotNull
    private final String goodsName;

    @NotNull
    private final String goodsNo;

    @NotNull
    private final ImageBean imageInfo;

    @NotNull
    private final List<String> labelList;

    @NotNull
    private final String maxSkuPrice;

    @NotNull
    private final String minSkuPrice;
    private final boolean multipleSku;

    @NotNull
    private final String shopNo;

    @NotNull
    private final String totalSaleCount;

    public CommodityBean() {
        this(null, null, null, false, null, null, null, null, null, 511, null);
    }

    public CommodityBean(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull ImageBean imageBean, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "goodsNo");
        Intrinsics.checkNotNullParameter(str2, "shopNo");
        Intrinsics.checkNotNullParameter(str3, "goodsName");
        Intrinsics.checkNotNullParameter(str4, "minSkuPrice");
        Intrinsics.checkNotNullParameter(str5, "maxSkuPrice");
        Intrinsics.checkNotNullParameter(str6, "totalSaleCount");
        Intrinsics.checkNotNullParameter(imageBean, "imageInfo");
        Intrinsics.checkNotNullParameter(list, "labelList");
        this.goodsNo = str;
        this.shopNo = str2;
        this.goodsName = str3;
        this.multipleSku = z;
        this.minSkuPrice = str4;
        this.maxSkuPrice = str5;
        this.totalSaleCount = str6;
        this.imageInfo = imageBean;
        this.labelList = list;
    }

    @NotNull
    public final String findLabelImage() {
        List<String> list = this.labelList;
        return (list == null || list.isEmpty() || TextUtils.isEmpty(this.labelList.get(0))) ? "" : this.labelList.get(0);
    }

    @NotNull
    public final CharSequence formatPrice() {
        boolean z = this.multipleSku && !TextUtils.equals(this.minSkuPrice, this.maxSkuPrice);
        try {
            c49 c49VarF = c49.f();
            if (StringsKt.contains$default(this.minSkuPrice, Consts.DOT, false, 2, (Object) null)) {
                List listSplit$default = StringsKt.split$default(this.minSkuPrice, new String[]{Consts.DOT}, false, 0, 6, (Object) null);
                if (listSplit$default.size() > 1) {
                    c49VarF.g(new b49().o((String) listSplit$default.get(0)).q(qv1.W(18.0f)).p(Color.parseColor("#FFF3474A")).r(1)).g(new b49().o('.' + ((String) listSplit$default.get(1))).q(qv1.W(11.0f)).p(Color.parseColor("#FFF3474A")).r(1));
                } else {
                    c49VarF.g(new b49().o(this.minSkuPrice).q(qv1.W(18.0f)).r(1).p(Color.parseColor("#FFF3474A")));
                }
            } else {
                c49VarF.g(new b49().o(this.minSkuPrice).q(qv1.W(18.0f)).r(1).p(Color.parseColor("#FFF3474A")));
            }
            if (z) {
                c49VarF.g(new b49().o("起").q(qv1.W(11.0f - 2)).p(Color.parseColor("#FFF3474A")).r(1));
            }
            SpannableStringBuilder spannableStringBuilderE = c49VarF.e();
            Intrinsics.checkNotNullExpressionValue(spannableStringBuilderE, "builder.build()");
            return spannableStringBuilderE;
        } catch (Exception unused) {
            if (!z) {
                return this.minSkuPrice;
            }
            return this.minSkuPrice + (char) 36215;
        }
    }

    @NotNull
    public final CharSequence formatSaleCount() {
        return TextUtils.isEmpty(this.totalSaleCount) ? "0人付款" : this.totalSaleCount;
    }

    @NotNull
    public final CharSequence formatStrikePrice() {
        return "";
    }

    @NotNull
    public final String getGoodsCover() {
        return this.imageInfo.getUrl();
    }

    public final int getGoodsCoverHeight() {
        return this.imageInfo.getHeight();
    }

    public final int getGoodsCoverWidth() {
        return this.imageInfo.getWidth();
    }

    @NotNull
    public final String getGoodsName() {
        return this.goodsName;
    }

    @NotNull
    public final String getGoodsNo() {
        return this.goodsNo;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 0;
    }

    @NotNull
    public final List<String> getLabelList() {
        return this.labelList;
    }

    @NotNull
    public final String getMaxSkuPrice() {
        return this.maxSkuPrice;
    }

    @NotNull
    public final String getMinSkuPrice() {
        return this.minSkuPrice;
    }

    public final boolean getMultipleSku() {
        return this.multipleSku;
    }

    @NotNull
    public final String getPriceStr() {
        return cy6.g(this.multipleSku, this.minSkuPrice, this.maxSkuPrice);
    }

    @NotNull
    public final String getShopNo() {
        return this.shopNo;
    }

    @NotNull
    public final String getTotalSaleCount() {
        return this.totalSaleCount;
    }

    public final boolean showLabelImage() {
        List<String> list = this.labelList;
        return list != null && (list.isEmpty() ^ true);
    }

    public final boolean showStrike() {
        return false;
    }

    public /* synthetic */ CommodityBean(String str, String str2, String str3, boolean z, String str4, String str5, String str6, ImageBean imageBean, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? false : z, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5, (i & 64) == 0 ? str6 : "", (i & 128) != 0 ? new ImageBean(null, null, 0, 0, 0, 31, null) : imageBean, (i & 256) != 0 ? new ArrayList() : list);
    }
}
