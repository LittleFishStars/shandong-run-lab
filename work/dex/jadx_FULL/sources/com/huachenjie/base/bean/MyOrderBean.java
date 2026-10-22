package com.huachenjie.base.bean;

import com.huachenjie.base.R;
import com.huachenjie.mall.page.express.ExpressLogisticsActivity;
import com.zj.adlib.ys8;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b,\b\u0016\u0018\u0000 @2\u00020\u0001:\u0001@BÉ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006¢\u0006\u0002\u0010\u001aJ\u0006\u00108\u001a\u00020\u0003J\u0006\u00109\u001a\u00020\u0003J\u0006\u0010:\u001a\u00020\u0015J\u0006\u0010;\u001a\u00020\u0015J\u0006\u0010<\u001a\u00020\u0015J\u0006\u0010=\u001a\u00020\u0015J\u0006\u0010>\u001a\u00020\u0015J\u0006\u0010?\u001a\u00020\u0015R\u0011\u0010\u0019\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0012\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001c\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0016\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001c\"\u0004\b+\u0010\u001fR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010.R\u0011\u0010\u0018\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010%R\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001c\"\u0004\b2\u0010\u001fR\u0011\u0010\u0017\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b3\u0010!R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010%R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010%R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010%R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010%¨\u0006A"}, d2 = {"Lcom/huachenjie/base/bean/MyOrderBean;", "", "orderNo", "", "tradeNo", "orderStatus", "", "orderStatusDesc", "shopName", "shopLogo", "shopNo", "goodsList", "", "Lcom/huachenjie/base/bean/OrderGoodsBean;", "payAmount", "orderAmount", "goodsPriceTotal", "payRemainTime", "commentStatus", ExpressLogisticsActivity.t, "logisticTrackEnable", "", "commentViewEnable", "payStatus", "orderType", "categoryView", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ZZZII)V", "getCategoryView", "()I", "getCommentStatus", "setCommentStatus", "(I)V", "getCommentViewEnable", "()Z", "getGoodsList", "()Ljava/util/List;", "getGoodsPriceTotal", "()Ljava/lang/String;", "getLogisticNo", "getLogisticTrackEnable", "getOrderAmount", "getOrderNo", "getOrderStatus", "setOrderStatus", "getOrderStatusDesc", "setOrderStatusDesc", "(Ljava/lang/String;)V", "getOrderType", "getPayAmount", "getPayRemainTime", "setPayRemainTime", "getPayStatus", "getShopLogo", "getShopName", "getShopNo", "getTradeNo", "getRemainPayTime", "getStatusColor", "isWaitCommentStatus", "isWaitDeliveryStatus", "isWaitPayOrPayingStatus", "isWaitReceiveStatus", "needShowButton", "showLearOrSeenButton", "Companion", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class MyOrderBean {
    public static final int STATUS_CANCEL = 4;
    public static final int STATUS_FINISH = 3;
    public static final int STATUS_HAS_COMMENT = 2;
    public static final int STATUS_NO_COMMENT = 0;
    public static final int STATUS_PAYING = 5;
    public static final int STATUS_WAIT_COMMENT = 1;
    public static final int STATUS_WAIT_DELIVERY = 1;
    public static final int STATUS_WAIT_PAY = 0;
    public static final int STATUS_WAIT_RECEIVE = 2;
    private final int categoryView;
    private int commentStatus;
    private final boolean commentViewEnable;

    @NotNull
    private final List<OrderGoodsBean> goodsList;

    @NotNull
    private final String goodsPriceTotal;

    @NotNull
    private final String logisticNo;
    private final boolean logisticTrackEnable;

    @NotNull
    private final String orderAmount;

    @NotNull
    private final String orderNo;
    private int orderStatus;

    @NotNull
    private String orderStatusDesc;
    private final int orderType;

    @NotNull
    private final String payAmount;
    private int payRemainTime;
    private final boolean payStatus;

    @NotNull
    private final String shopLogo;

    @NotNull
    private final String shopName;

    @NotNull
    private final String shopNo;

    @NotNull
    private final String tradeNo;

    public MyOrderBean() {
        this(null, null, 0, null, null, null, null, null, null, null, null, 0, 0, null, false, false, false, 0, 0, 524287, null);
    }

    public MyOrderBean(@NotNull String str, @NotNull String str2, int i, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull List<OrderGoodsBean> list, @NotNull String str7, @NotNull String str8, @NotNull String str9, int i2, int i3, @NotNull String str10, boolean z, boolean z2, boolean z3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(str, "orderNo");
        Intrinsics.checkNotNullParameter(str2, "tradeNo");
        Intrinsics.checkNotNullParameter(str3, "orderStatusDesc");
        Intrinsics.checkNotNullParameter(str4, "shopName");
        Intrinsics.checkNotNullParameter(str5, "shopLogo");
        Intrinsics.checkNotNullParameter(str6, "shopNo");
        Intrinsics.checkNotNullParameter(list, "goodsList");
        Intrinsics.checkNotNullParameter(str7, "payAmount");
        Intrinsics.checkNotNullParameter(str8, "orderAmount");
        Intrinsics.checkNotNullParameter(str9, "goodsPriceTotal");
        Intrinsics.checkNotNullParameter(str10, ExpressLogisticsActivity.t);
        this.orderNo = str;
        this.tradeNo = str2;
        this.orderStatus = i;
        this.orderStatusDesc = str3;
        this.shopName = str4;
        this.shopLogo = str5;
        this.shopNo = str6;
        this.goodsList = list;
        this.payAmount = str7;
        this.orderAmount = str8;
        this.goodsPriceTotal = str9;
        this.payRemainTime = i2;
        this.commentStatus = i3;
        this.logisticNo = str10;
        this.logisticTrackEnable = z;
        this.commentViewEnable = z2;
        this.payStatus = z3;
        this.orderType = i4;
        this.categoryView = i5;
    }

    public final int getCategoryView() {
        return this.categoryView;
    }

    public final int getCommentStatus() {
        return this.commentStatus;
    }

    public final boolean getCommentViewEnable() {
        return this.commentViewEnable;
    }

    @NotNull
    public final List<OrderGoodsBean> getGoodsList() {
        return this.goodsList;
    }

    @NotNull
    public final String getGoodsPriceTotal() {
        return this.goodsPriceTotal;
    }

    @NotNull
    public final String getLogisticNo() {
        return this.logisticNo;
    }

    public final boolean getLogisticTrackEnable() {
        return this.logisticTrackEnable;
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

    public final int getOrderType() {
        return this.orderType;
    }

    @NotNull
    public final String getPayAmount() {
        return this.payAmount;
    }

    public final int getPayRemainTime() {
        return this.payRemainTime;
    }

    public final boolean getPayStatus() {
        return this.payStatus;
    }

    @NotNull
    public final String getRemainPayTime() {
        int i = this.payRemainTime;
        int i2 = R.string.mall_my_order_menu_pay;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.getDefault(), "%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i / 3600), Integer.valueOf((i % 3600) / 60), Integer.valueOf(i % 60)}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        String strF = ys8.f(i2, str);
        Intrinsics.checkNotNullExpressionValue(strF, "getString(\n            R… minutes, secs)\n        )");
        return strF;
    }

    @NotNull
    public final String getShopLogo() {
        return this.shopLogo;
    }

    @NotNull
    public final String getShopName() {
        return this.shopName;
    }

    @NotNull
    public final String getShopNo() {
        return this.shopNo;
    }

    @NotNull
    public final String getStatusColor() {
        int i = this.orderStatus;
        if (i != 0 && i != 1 && i != 2) {
            if (i == 3) {
                return "#2C3E50";
            }
            if (i == 4 || i != 5) {
                return "#C1C1C1";
            }
        }
        return "#00B6DE";
    }

    @NotNull
    public final String getTradeNo() {
        return this.tradeNo;
    }

    public final boolean isWaitCommentStatus() {
        int i;
        return this.orderStatus == 3 && ((i = this.commentStatus) == 0 || i == 1);
    }

    public final boolean isWaitDeliveryStatus() {
        return this.orderStatus == 1;
    }

    public final boolean isWaitPayOrPayingStatus() {
        int i = this.orderStatus;
        return i == 0 || i == 5;
    }

    public final boolean isWaitReceiveStatus() {
        return this.orderStatus == 2;
    }

    public final boolean needShowButton() {
        int i = this.orderStatus;
        return (i == 1 || i == 4) ? false : true;
    }

    public final void setCommentStatus(int i) {
        this.commentStatus = i;
    }

    public final void setOrderStatus(int i) {
        this.orderStatus = i;
    }

    public final void setOrderStatusDesc(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.orderStatusDesc = str;
    }

    public final void setPayRemainTime(int i) {
        this.payRemainTime = i;
    }

    public final boolean showLearOrSeenButton() {
        int i;
        return this.orderType == 2 && ((i = this.orderStatus) == 2 || i == 3);
    }

    public /* synthetic */ MyOrderBean(String str, String str2, int i, String str3, String str4, String str5, String str6, List list, String str7, String str8, String str9, int i2, int i3, String str10, boolean z, boolean z2, boolean z3, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? "" : str, (i6 & 2) != 0 ? "" : str2, (i6 & 4) != 0 ? -1 : i, (i6 & 8) != 0 ? "" : str3, (i6 & 16) != 0 ? "" : str4, (i6 & 32) != 0 ? "" : str5, (i6 & 64) != 0 ? "" : str6, (i6 & 128) != 0 ? new ArrayList() : list, (i6 & 256) != 0 ? "" : str7, (i6 & 512) != 0 ? "" : str8, (i6 & 1024) != 0 ? "" : str9, (i6 & 2048) != 0 ? 0 : i2, (i6 & 4096) != 0 ? 0 : i3, (i6 & 8192) == 0 ? str10 : "", (i6 & 16384) != 0 ? false : z, (i6 & 32768) != 0 ? false : z2, (i6 & 65536) != 0 ? false : z3, (i6 & 131072) != 0 ? 0 : i4, (i6 & 262144) != 0 ? 0 : i5);
    }
}
