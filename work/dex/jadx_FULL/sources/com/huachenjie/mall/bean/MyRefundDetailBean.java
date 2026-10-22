package com.huachenjie.mall.bean;

import com.huachenjie.base.bean.mall.ShippingAddressBean;
import com.huachenjie.mall.R;
import com.huachenjie.run.map.RouteOverlay;
import com.zj.adlib.ys8;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 .2\u00020\u0001:\u0001.B\u008f\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007¢\u0006\u0002\u0010\u0014J\u0006\u0010&\u001a\u00020\u0007J\u0006\u0010'\u001a\u00020\u0007J\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020)J\u0006\u0010+\u001a\u00020)J\u0006\u0010,\u001a\u00020)J\u0006\u0010-\u001a\u00020)R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0011\u0010\u0011\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\u0012\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0011\u0010\u0013\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001a¨\u0006/"}, d2 = {"Lcom/huachenjie/mall/bean/MyRefundDetailBean;", "Lcom/huachenjie/mall/bean/MyRefundBean;", "afterSaleStatus", "", "applyTime", "handleTime", "refundReason", "", "cancelReason", "rejectReason", "attachmentList", "", "Lcom/huachenjie/mall/bean/AttachmentBean;", "applyDesc", "addressInfo", "Lcom/huachenjie/base/bean/mall/ShippingAddressBean;", "logisticCoName", "logisticCoCode", "logisticSid", "shopAccId", "(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/huachenjie/base/bean/mall/ShippingAddressBean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddressInfo", "()Lcom/huachenjie/base/bean/mall/ShippingAddressBean;", "getAfterSaleStatus", "()I", "getApplyDesc", "()Ljava/lang/String;", "getApplyTime", "getAttachmentList", "()Ljava/util/List;", "getCancelReason", "getHandleTime", "getLogisticCoCode", "getLogisticCoName", "getLogisticSid", "getRefundReason", "getRejectReason", "getShopAccId", "formatterStatusColor", "formatterStatusDesc", "hideStatusSubDesc", "", "showBottomMenu", "showChangeAddress", "showFillAddress", "showSaleAddress", "Companion", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MyRefundDetailBean extends MyRefundBean {
    public static final int AFTER_TYPE_AGREEN = 3;
    public static final int AFTER_TYPE_CANCEL = 1;
    public static final int AFTER_TYPE_DISPOSE = 2;
    public static final int AFTER_TYPE_FINISH = 100;
    public static final int AFTER_TYPE_NONE = 0;
    public static final int AFTER_TYPE_RECEIVED = 7;
    public static final int AFTER_TYPE_REJECT = 4;
    public static final int AFTER_TYPE_WAIT_RECEIVE = 6;
    public static final int AFTER_TYPE_WAIT_SEND = 5;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<SimpleDateFormat> dataFormatter$delegate = LazyKt.lazy(new Function0<SimpleDateFormat>() { // from class: com.huachenjie.mall.bean.MyRefundDetailBean$Companion$dataFormatter$2
        @NotNull
        public final SimpleDateFormat invoke() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        }
    });

    @Nullable
    private final ShippingAddressBean addressInfo;
    private final int afterSaleStatus;

    @NotNull
    private final String applyDesc;
    private final int applyTime;

    @NotNull
    private final List<AttachmentBean> attachmentList;

    @NotNull
    private final String cancelReason;
    private final int handleTime;

    @NotNull
    private final String logisticCoCode;

    @NotNull
    private final String logisticCoName;

    @NotNull
    private final String logisticSid;

    @NotNull
    private final String refundReason;

    @NotNull
    private final String rejectReason;

    @NotNull
    private final String shopAccId;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/mall/bean/MyRefundDetailBean$Companion;", "", "()V", "AFTER_TYPE_AGREEN", "", "AFTER_TYPE_CANCEL", "AFTER_TYPE_DISPOSE", "AFTER_TYPE_FINISH", "AFTER_TYPE_NONE", "AFTER_TYPE_RECEIVED", "AFTER_TYPE_REJECT", "AFTER_TYPE_WAIT_RECEIVE", "AFTER_TYPE_WAIT_SEND", "dataFormatter", "Ljava/text/SimpleDateFormat;", "getDataFormatter", "()Ljava/text/SimpleDateFormat;", "dataFormatter$delegate", "Lkotlin/Lazy;", "formatterTime", "", "secondTime", "", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final SimpleDateFormat getDataFormatter() {
            return (SimpleDateFormat) MyRefundDetailBean.dataFormatter$delegate.getValue();
        }

        @JvmStatic
        @NotNull
        public final String formatterTime(long secondTime) {
            String str = getDataFormatter().format(new Date(secondTime * ((long) 1000)));
            Intrinsics.checkNotNullExpressionValue(str, "dataFormatter.format(Date(secondTime * 1000))");
            return str;
        }
    }

    public MyRefundDetailBean() {
        this(0, 0, 0, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    public /* synthetic */ MyRefundDetailBean(int i, int i2, int i3, String str, String str2, String str3, List list, String str4, ShippingAddressBean shippingAddressBean, String str5, String str6, String str7, String str8, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) == 0 ? i3 : 0, (i4 & 8) != 0 ? "" : str, (i4 & 16) != 0 ? "" : str2, (i4 & 32) != 0 ? "" : str3, (i4 & 64) != 0 ? new ArrayList() : list, (i4 & 128) != 0 ? "" : str4, (i4 & 256) != 0 ? null : shippingAddressBean, (i4 & 512) != 0 ? "" : str5, (i4 & 1024) != 0 ? "" : str6, (i4 & 2048) != 0 ? "" : str7, (i4 & 4096) == 0 ? str8 : "");
    }

    @JvmStatic
    @NotNull
    public static final String formatterTime(long j) {
        return INSTANCE.formatterTime(j);
    }

    @NotNull
    public final String formatterStatusColor() {
        int i = this.afterSaleStatus;
        if (i == 1 || i == 4) {
            return "#8997A4";
        }
        return i != 100 ? RouteOverlay.f12338c : "#2C3E50";
    }

    @NotNull
    public final String formatterStatusDesc() {
        int i = this.afterSaleStatus;
        if (i == 1) {
            String strF = ys8.f(R.string.mall_order_refund_state_main7_desc, this.cancelReason);
            Intrinsics.checkNotNullExpressionValue(strF, "getString(\n             …ancelReason\n            )");
            return strF;
        }
        if (i == 2) {
            String strE = ys8.e(R.string.mall_order_refund_state_main1_desc);
            Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.mall_…_refund_state_main1_desc)");
            return strE;
        }
        if (i == 3) {
            String strE2 = getLogisticStatus() == 0 ? ys8.e(R.string.mall_order_refund_state_main4_desc) : ys8.e(R.string.mall_order_refund_state_main2_desc);
            Intrinsics.checkNotNullExpressionValue(strE2, "if (logisticStatus == 0)…main2_desc)\n            }");
            return strE2;
        }
        if (i == 4) {
            String strF2 = ys8.f(R.string.mall_order_refund_state_main6_desc, this.rejectReason);
            Intrinsics.checkNotNullExpressionValue(strF2, "getString(\n             …ejectReason\n            )");
            return strF2;
        }
        if (i == 5) {
            String strE3 = ys8.e(R.string.mall_order_refund_state_main2_desc);
            Intrinsics.checkNotNullExpressionValue(strE3, "getString(R.string.mall_…_refund_state_main2_desc)");
            return strE3;
        }
        if (i == 7) {
            String strE4 = ys8.e(R.string.mall_order_refund_state_main4_desc);
            Intrinsics.checkNotNullExpressionValue(strE4, "getString(R.string.mall_…_refund_state_main4_desc)");
            return strE4;
        }
        if (i != 100) {
            return "";
        }
        String strE5 = ys8.e(R.string.mall_order_refund_state_main5_desc);
        Intrinsics.checkNotNullExpressionValue(strE5, "getString(R.string.mall_…_refund_state_main5_desc)");
        return strE5;
    }

    @Nullable
    public final ShippingAddressBean getAddressInfo() {
        return this.addressInfo;
    }

    public final int getAfterSaleStatus() {
        return this.afterSaleStatus;
    }

    @NotNull
    public final String getApplyDesc() {
        return this.applyDesc;
    }

    public final int getApplyTime() {
        return this.applyTime;
    }

    @NotNull
    public final List<AttachmentBean> getAttachmentList() {
        return this.attachmentList;
    }

    @NotNull
    public final String getCancelReason() {
        return this.cancelReason;
    }

    public final int getHandleTime() {
        return this.handleTime;
    }

    @NotNull
    public final String getLogisticCoCode() {
        return this.logisticCoCode;
    }

    @NotNull
    public final String getLogisticCoName() {
        return this.logisticCoName;
    }

    @NotNull
    public final String getLogisticSid() {
        return this.logisticSid;
    }

    @NotNull
    public final String getRefundReason() {
        return this.refundReason;
    }

    @NotNull
    public final String getRejectReason() {
        return this.rejectReason;
    }

    @NotNull
    public final String getShopAccId() {
        return this.shopAccId;
    }

    public final boolean hideStatusSubDesc() {
        return getLogisticStatus() == 2 && this.afterSaleStatus == 6;
    }

    public final boolean showBottomMenu() {
        int i;
        return this.afterSaleStatus == 2 || (getLogisticStatus() > 0 && ((i = this.afterSaleStatus) == 3 || i == 5 || i == 6));
    }

    public final boolean showChangeAddress() {
        return getLogisticStatus() == 2;
    }

    public final boolean showFillAddress() {
        return getLogisticStatus() == 1;
    }

    public final boolean showSaleAddress() {
        int i;
        return getLogisticStatus() > 0 && ((i = this.afterSaleStatus) == 3 || i == 5 || i == 7);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyRefundDetailBean(int i, int i2, int i3, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull List<AttachmentBean> list, @NotNull String str4, @Nullable ShippingAddressBean shippingAddressBean, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8) {
        super(null, 0, null, null, null, null, null, null, null, null, 0, null, 0, null, 16383, null);
        Intrinsics.checkNotNullParameter(str, "refundReason");
        Intrinsics.checkNotNullParameter(str2, "cancelReason");
        Intrinsics.checkNotNullParameter(str3, "rejectReason");
        Intrinsics.checkNotNullParameter(list, "attachmentList");
        Intrinsics.checkNotNullParameter(str4, "applyDesc");
        Intrinsics.checkNotNullParameter(str5, "logisticCoName");
        Intrinsics.checkNotNullParameter(str6, "logisticCoCode");
        Intrinsics.checkNotNullParameter(str7, "logisticSid");
        Intrinsics.checkNotNullParameter(str8, "shopAccId");
        this.afterSaleStatus = i;
        this.applyTime = i2;
        this.handleTime = i3;
        this.refundReason = str;
        this.cancelReason = str2;
        this.rejectReason = str3;
        this.attachmentList = list;
        this.applyDesc = str4;
        this.addressInfo = shippingAddressBean;
        this.logisticCoName = str5;
        this.logisticCoCode = str6;
        this.logisticSid = str7;
        this.shopAccId = str8;
    }
}
