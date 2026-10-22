package com.huachenjie.home.bean;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.alibaba.android.arouter.utils.Consts;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import com.zj.adlib.b49;
import com.zj.adlib.c49;
import com.zj.adlib.qv1;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u001f\u001a\u00020\u0003J\u0006\u0010 \u001a\u00020\u0003J\b\u0010!\u001a\u00020\u0003H\u0002J\b\u0010\"\u001a\u00020#H\u0002J\u0006\u0010$\u001a\u00020\u0003J\u0006\u0010%\u001a\u00020#J\u0006\u0010&\u001a\u00020\u0003J\u0006\u0010'\u001a\u00020#J\u0006\u0010(\u001a\u00020\u0014J\u0006\u0010)\u001a\u00020\u0014J\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020+R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006-"}, d2 = {"Lcom/huachenjie/home/bean/GoodStuffBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", ALPParamConstant.ITMEID, "", "itemBasicInfo", "Lcom/huachenjie/home/bean/ItemBasicInfo;", "pricePromotionInfo", "Lcom/huachenjie/home/bean/PricePromotionInfo;", "presaleInfo", "Lcom/huachenjie/home/bean/PresaleInfo;", "scopeInfo", "Lcom/huachenjie/home/bean/ScopeInfo;", "publishInfo", "Lcom/huachenjie/home/bean/PublishInfo;", "(Ljava/lang/String;Lcom/huachenjie/home/bean/ItemBasicInfo;Lcom/huachenjie/home/bean/PricePromotionInfo;Lcom/huachenjie/home/bean/PresaleInfo;Lcom/huachenjie/home/bean/ScopeInfo;Lcom/huachenjie/home/bean/PublishInfo;)V", "getItemBasicInfo", "()Lcom/huachenjie/home/bean/ItemBasicInfo;", "getItemId", "()Ljava/lang/String;", CollegeTownItemFragment.ITEM_TYPE, "", "getItemType", "()I", "getPresaleInfo", "()Lcom/huachenjie/home/bean/PresaleInfo;", "getPricePromotionInfo", "()Lcom/huachenjie/home/bean/PricePromotionInfo;", "getPublishInfo", "()Lcom/huachenjie/home/bean/PublishInfo;", "getScopeInfo", "()Lcom/huachenjie/home/bean/ScopeInfo;", "findGoodsCover", "findGoodsName", "findMinPrice", "findStrikePrice", "", "findTag", "formatPrice", "formatSaleCount", "formatStrikePrice", "getCoverHeight", "getCoverWidth", "showStrike", "", "showTag", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GoodStuffBean implements MultiItemEntity {

    @NotNull
    private final ItemBasicInfo itemBasicInfo;

    @NotNull
    private final String itemId;

    @NotNull
    private final PresaleInfo presaleInfo;

    @NotNull
    private final PricePromotionInfo pricePromotionInfo;

    @NotNull
    private final PublishInfo publishInfo;

    @NotNull
    private final ScopeInfo scopeInfo;

    public GoodStuffBean(@NotNull String str, @NotNull ItemBasicInfo itemBasicInfo, @NotNull PricePromotionInfo pricePromotionInfo, @NotNull PresaleInfo presaleInfo, @NotNull ScopeInfo scopeInfo, @NotNull PublishInfo publishInfo) {
        Intrinsics.checkNotNullParameter(str, ALPParamConstant.ITMEID);
        Intrinsics.checkNotNullParameter(itemBasicInfo, "itemBasicInfo");
        Intrinsics.checkNotNullParameter(pricePromotionInfo, "pricePromotionInfo");
        Intrinsics.checkNotNullParameter(presaleInfo, "presaleInfo");
        Intrinsics.checkNotNullParameter(scopeInfo, "scopeInfo");
        Intrinsics.checkNotNullParameter(publishInfo, "publishInfo");
        this.itemId = str;
        this.itemBasicInfo = itemBasicInfo;
        this.pricePromotionInfo = pricePromotionInfo;
        this.presaleInfo = presaleInfo;
        this.scopeInfo = scopeInfo;
        this.publishInfo = publishInfo;
    }

    private final String findMinPrice() {
        PricePromotionInfo pricePromotionInfo = this.pricePromotionInfo;
        if (pricePromotionInfo == null) {
            return "";
        }
        if (!TextUtils.isEmpty(pricePromotionInfo.getFinalPromotionPrice())) {
            return pricePromotionInfo.getFinalPromotionPrice();
        }
        if (TextUtils.isEmpty(pricePromotionInfo.getZkFinalPrice())) {
            return !TextUtils.isEmpty(pricePromotionInfo.getReservePrice()) ? pricePromotionInfo.getReservePrice() : "--.-";
        }
        return pricePromotionInfo.getZkFinalPrice();
    }

    private final CharSequence findStrikePrice() {
        PricePromotionInfo pricePromotionInfo = this.pricePromotionInfo;
        if (pricePromotionInfo == null) {
            return "";
        }
        if (!TextUtils.isEmpty(pricePromotionInfo.getReservePrice())) {
            return pricePromotionInfo.getReservePrice();
        }
        if (TextUtils.isEmpty(pricePromotionInfo.getZkFinalPrice())) {
            return !TextUtils.isEmpty(pricePromotionInfo.getFinalPromotionPrice()) ? pricePromotionInfo.getFinalPromotionPrice() : "";
        }
        return pricePromotionInfo.getZkFinalPrice();
    }

    @NotNull
    public final String findGoodsCover() {
        ItemBasicInfo itemBasicInfo = this.itemBasicInfo;
        if (itemBasicInfo == null || TextUtils.isEmpty(itemBasicInfo.getPictUrl())) {
            return "";
        }
        if (StringsKt.startsWith$default(this.itemBasicInfo.getPictUrl(), "http", false, 2, (Object) null)) {
            return String.valueOf(this.itemBasicInfo.getPictUrl());
        }
        return "https:" + this.itemBasicInfo.getPictUrl();
    }

    @NotNull
    public final String findGoodsName() {
        ItemBasicInfo itemBasicInfo = this.itemBasicInfo;
        if (itemBasicInfo != null && !TextUtils.isEmpty(itemBasicInfo.getShortTitle())) {
            return this.itemBasicInfo.getShortTitle();
        }
        ItemBasicInfo itemBasicInfo2 = this.itemBasicInfo;
        return (itemBasicInfo2 == null || TextUtils.isEmpty(itemBasicInfo2.getTitle())) ? "" : this.itemBasicInfo.getTitle();
    }

    @NotNull
    public final String findTag() {
        return showTag() ? this.pricePromotionInfo.getFinalPromotionPathList().get(0).getPromotionDesc() : "";
    }

    @NotNull
    public final CharSequence formatPrice() {
        String strFindMinPrice = findMinPrice();
        try {
            c49 c49VarF = c49.f();
            if (StringsKt.contains$default(strFindMinPrice, Consts.DOT, false, 2, (Object) null)) {
                List listSplit$default = StringsKt.split$default(strFindMinPrice, new String[]{Consts.DOT}, false, 0, 6, (Object) null);
                if (listSplit$default.size() > 1) {
                    c49VarF.g(new b49().o((String) listSplit$default.get(0)).q(qv1.W(20.0f)).p(Color.parseColor("#F3474A")).r(1)).g(new b49().o('.' + ((String) listSplit$default.get(1))).q(qv1.W(13.0f)).p(Color.parseColor("#F3474A")).r(1));
                } else {
                    c49VarF.g(new b49().o(strFindMinPrice).q(qv1.W(20.0f)).r(1).p(Color.parseColor("#F3474A")));
                }
            } else {
                c49VarF.g(new b49().o(strFindMinPrice).q(qv1.W(18.0f)).r(1).p(Color.parseColor("#F3474A")));
            }
            SpannableStringBuilder spannableStringBuilderE = c49VarF.e();
            Intrinsics.checkNotNullExpressionValue(spannableStringBuilderE, "builder.build()");
            return spannableStringBuilderE;
        } catch (Exception unused) {
            return String.valueOf(strFindMinPrice);
        }
    }

    @NotNull
    public final String formatSaleCount() {
        ItemBasicInfo itemBasicInfo = this.itemBasicInfo;
        if (itemBasicInfo == null || TextUtils.isEmpty(itemBasicInfo.getAnnualVol())) {
            return "";
        }
        return this.itemBasicInfo.getAnnualVol() + "人付款";
    }

    @NotNull
    public final CharSequence formatStrikePrice() {
        CharSequence charSequenceFindStrikePrice = findStrikePrice();
        try {
            c49 c49VarF = c49.f();
            b49 b49Var = new b49();
            StringBuilder sb = new StringBuilder();
            sb.append((char) 165);
            sb.append((Object) charSequenceFindStrikePrice);
            c49VarF.g(b49Var.o(sb.toString()).q(qv1.W(13.0f)).p(Color.parseColor("#757979")).l(true));
            SpannableStringBuilder spannableStringBuilderE = c49VarF.e();
            Intrinsics.checkNotNullExpressionValue(spannableStringBuilderE, "builder.build()");
            return spannableStringBuilderE;
        } catch (Exception unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append((char) 165);
            sb2.append((Object) charSequenceFindStrikePrice);
            return sb2.toString();
        }
    }

    public final int getCoverHeight() {
        return 1;
    }

    public final int getCoverWidth() {
        return 1;
    }

    @NotNull
    public final ItemBasicInfo getItemBasicInfo() {
        return this.itemBasicInfo;
    }

    @NotNull
    public final String getItemId() {
        return this.itemId;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    /* JADX INFO: renamed from: getItemType */
    public int getPostType() {
        return 0;
    }

    @NotNull
    public final PresaleInfo getPresaleInfo() {
        return this.presaleInfo;
    }

    @NotNull
    public final PricePromotionInfo getPricePromotionInfo() {
        return this.pricePromotionInfo;
    }

    @NotNull
    public final PublishInfo getPublishInfo() {
        return this.publishInfo;
    }

    @NotNull
    public final ScopeInfo getScopeInfo() {
        return this.scopeInfo;
    }

    public final boolean showStrike() {
        String strFindMinPrice = findMinPrice();
        String string = formatStrikePrice().toString();
        return (TextUtils.isEmpty(string) || TextUtils.equals(string, strFindMinPrice)) ? false : true;
    }

    public final boolean showTag() {
        PricePromotionInfo pricePromotionInfo = this.pricePromotionInfo;
        if (pricePromotionInfo == null || pricePromotionInfo.getFinalPromotionPathList() == null || !(!this.pricePromotionInfo.getFinalPromotionPathList().isEmpty())) {
            return false;
        }
        return !TextUtils.isEmpty(this.pricePromotionInfo.getFinalPromotionPathList().get(0).getPromotionDesc());
    }

    public /* synthetic */ GoodStuffBean(String str, ItemBasicInfo itemBasicInfo, PricePromotionInfo pricePromotionInfo, PresaleInfo presaleInfo, ScopeInfo scopeInfo, PublishInfo publishInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, itemBasicInfo, pricePromotionInfo, presaleInfo, scopeInfo, publishInfo);
    }
}
