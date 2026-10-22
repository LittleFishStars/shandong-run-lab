package com.huachenjie.im.custom;

import com.huachenjie.im.custom.base.BaseAttachment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010'\u001a\u00020\u0004H\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001a\u0010$\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000e¨\u0006("}, d2 = {"Lcom/huachenjie/im/custom/ShareOrderAttachment;", "Lcom/huachenjie/im/custom/base/BaseAttachment;", "()V", "goodsCount", "", "getGoodsCount", "()I", "setGoodsCount", "(I)V", "goodsImage", "", "getGoodsImage", "()Ljava/lang/String;", "setGoodsImage", "(Ljava/lang/String;)V", "goodsName", "getGoodsName", "setGoodsName", "goodsSpec", "getGoodsSpec", "setGoodsSpec", "goodsUnitPrice", "getGoodsUnitPrice", "setGoodsUnitPrice", "orderAmount", "getOrderAmount", "setOrderAmount", "orderNo", "getOrderNo", "setOrderNo", "orderStatus", "getOrderStatus", "setOrderStatus", "orderStatusDesc", "getOrderStatusDesc", "setOrderStatusDesc", "payAmount", "getPayAmount", "setPayAmount", "getCustomType", "IM_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ShareOrderAttachment extends BaseAttachment {
    private int goodsCount;

    @NotNull
    private String orderNo = "";
    private int orderStatus = -1;

    @NotNull
    private String orderStatusDesc = "";

    @NotNull
    private String goodsName = "";

    @NotNull
    private String goodsSpec = "";

    @NotNull
    private String goodsImage = "";

    @NotNull
    private String goodsUnitPrice = "";

    @NotNull
    private String orderAmount = "";

    @NotNull
    private String payAmount = "";

    @Override // com.huachenjie.im.custom.base.BaseAttachment
    public int getCustomType() {
        return 13;
    }

    public final int getGoodsCount() {
        return this.goodsCount;
    }

    @NotNull
    public final String getGoodsImage() {
        return this.goodsImage;
    }

    @NotNull
    public final String getGoodsName() {
        return this.goodsName;
    }

    @NotNull
    public final String getGoodsSpec() {
        return this.goodsSpec;
    }

    @NotNull
    public final String getGoodsUnitPrice() {
        return this.goodsUnitPrice;
    }

    @NotNull
    public final String getOrderAmount() {
        return this.orderAmount;
    }

    @NotNull
    public final String getOrderNo() {
        return this.orderNo;
    }

    public final int getOrderStatus() {
        return this.orderStatus;
    }

    @NotNull
    public final String getOrderStatusDesc() {
        return this.orderStatusDesc;
    }

    @NotNull
    public final String getPayAmount() {
        return this.payAmount;
    }

    public final void setGoodsCount(int i) {
        this.goodsCount = i;
    }

    public final void setGoodsImage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.goodsImage = str;
    }

    public final void setGoodsName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.goodsName = str;
    }

    public final void setGoodsSpec(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.goodsSpec = str;
    }

    public final void setGoodsUnitPrice(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.goodsUnitPrice = str;
    }

    public final void setOrderAmount(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.orderAmount = str;
    }

    public final void setOrderNo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.orderNo = str;
    }

    public final void setOrderStatus(int i) {
        this.orderStatus = i;
    }

    public final void setOrderStatusDesc(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.orderStatusDesc = str;
    }

    public final void setPayAmount(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.payAmount = str;
    }
}
