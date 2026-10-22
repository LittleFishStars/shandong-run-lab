package com.huachenjie.mall.bean;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.byazt.bv.BaseConstants;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.express.ExpressLogisticsActivity;
import com.huachenjie.run.map.RouteOverlay;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\b\u0004\u0018\u0000 &2\u00020\u0001:\u0001&BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\u0017J\u0006\u0010%\u001a\u00020\u0017R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u001a\u0010\u001e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013¨\u0006'"}, d2 = {"Lcom/huachenjie/mall/bean/ExpressLogisticsBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "logisticNodeDesc", "", "logisticNode", "", BaseConstants.MARKET_URI_AUTHORITY_DETAIL, "", "Lcom/huachenjie/mall/bean/ExpressLogisticsDetailBean;", "time", "desc", CollegeTownItemFragment.ITEM_TYPE, "(Ljava/lang/String;ILjava/util/List;Ljava/lang/String;Ljava/lang/String;I)V", "allPosition", "getAllPosition", "()I", "setAllPosition", "(I)V", "getDesc", "()Ljava/lang/String;", "getDetails", "()Ljava/util/List;", ExpressLogisticsActivity.x, "", "()Z", "setLightStatus", "(Z)V", "getItemType", "getLogisticNode", "getLogisticNodeDesc", "position", "getPosition", "setPosition", "getTime", "getContentSpan", "", "isFirstPosition", "isLastPosition", "Companion", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExpressLogisticsBean.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExpressLogisticsBean.kt\ncom/huachenjie/mall/bean/ExpressLogisticsBean\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,229:1\n1313#2,2:230\n*S KotlinDebug\n*F\n+ 1 ExpressLogisticsBean.kt\ncom/huachenjie/mall/bean/ExpressLogisticsBean\n*L\n191#1:230,2\n*E\n"})
public final class ExpressLogisticsBean implements MultiItemEntity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int EXPRESS_LOGISTICS_NORMAL = 0;
    public static final int EXPRESS_LOGISTICS_SIMPLE = 1;
    public static final int LOGISTIC_DELIVERY = 1;
    public static final int LOGISTIC_PICK_UP = 3;
    public static final int LOGISTIC_SEND = 0;
    public static final int LOGISTIC_SIGN = 5;
    public static final int LOGISTIC_STOCK_UP = -1;
    public static final int LOGISTIC_TRANSPORT = 2;
    public static final int LOGISTIC_WAIT_TAKE = 4;
    private int allPosition;

    @NotNull
    private final String desc;

    @NotNull
    private final List<ExpressLogisticsDetailBean> details;
    private boolean isLightStatus;
    private final int itemType;
    private final int logisticNode;

    @NotNull
    private final String logisticNodeDesc;
    private int position;

    @NotNull
    private final String time;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/mall/bean/ExpressLogisticsBean$Companion;", "", "()V", "EXPRESS_LOGISTICS_NORMAL", "", "EXPRESS_LOGISTICS_SIMPLE", "LOGISTIC_DELIVERY", "LOGISTIC_PICK_UP", "LOGISTIC_SEND", "LOGISTIC_SIGN", "LOGISTIC_STOCK_UP", "LOGISTIC_TRANSPORT", "LOGISTIC_WAIT_TAKE", "getLogisticsStatusIcon", "logisticNode", "isHighlight", "", ExpressLogisticsActivity.x, "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final int getLogisticsStatusIcon(int logisticNode, boolean isHighlight, boolean isLightStatus) {
            if (isLightStatus) {
                if (logisticNode == -1) {
                    return !isHighlight ? R.drawable.mall_ic_reward_express_status1 : R.drawable.mall_ic_reward_express_status1_active;
                }
                if (logisticNode == 0) {
                    return !isHighlight ? R.drawable.mall_ic_reward_express_status2 : R.drawable.mall_ic_reward_express_status2_active;
                }
                if (logisticNode == 1) {
                    return !isHighlight ? R.drawable.mall_ic_reward_express_status3 : R.drawable.mall_ic_reward_express_status3_active;
                }
                if (logisticNode == 2) {
                    return !isHighlight ? R.drawable.mall_ic_reward_express_status4 : R.drawable.mall_ic_reward_express_status4_active;
                }
                if (logisticNode == 3) {
                    return !isHighlight ? R.drawable.mall_ic_reward_express_status5 : R.drawable.mall_ic_reward_express_status5_active;
                }
                if (logisticNode != 4) {
                    return !isHighlight ? R.drawable.mall_ic_reward_express_status7 : R.drawable.mall_ic_reward_express_status7_active;
                }
                return !isHighlight ? R.drawable.mall_ic_reward_express_status6 : R.drawable.mall_ic_reward_express_status6_active;
            }
            if (logisticNode == -1) {
                return !isHighlight ? R.drawable.mall_ic_express_status1 : R.drawable.mall_ic_express_status1_active;
            }
            if (logisticNode == 0) {
                return !isHighlight ? R.drawable.mall_ic_express_status2 : R.drawable.mall_ic_express_status2_active;
            }
            if (logisticNode == 1) {
                return !isHighlight ? R.drawable.mall_ic_express_status3 : R.drawable.mall_ic_express_status3_active;
            }
            if (logisticNode == 2) {
                return !isHighlight ? R.drawable.mall_ic_express_status4 : R.drawable.mall_ic_express_status4_active;
            }
            if (logisticNode == 3) {
                return !isHighlight ? R.drawable.mall_ic_express_status5 : R.drawable.mall_ic_express_status5_active;
            }
            if (logisticNode != 4) {
                return !isHighlight ? R.drawable.mall_ic_express_status7 : R.drawable.mall_ic_express_status7_active;
            }
            return !isHighlight ? R.drawable.mall_ic_express_status6 : R.drawable.mall_ic_express_status6_active;
        }
    }

    public ExpressLogisticsBean(@NotNull String str, int i, @NotNull List<ExpressLogisticsDetailBean> list, @NotNull String str2, @NotNull String str3, int i2) {
        Intrinsics.checkNotNullParameter(str, "logisticNodeDesc");
        Intrinsics.checkNotNullParameter(list, BaseConstants.MARKET_URI_AUTHORITY_DETAIL);
        Intrinsics.checkNotNullParameter(str2, "time");
        Intrinsics.checkNotNullParameter(str3, "desc");
        this.logisticNodeDesc = str;
        this.logisticNode = i;
        this.details = list;
        this.time = str2;
        this.desc = str3;
        this.itemType = i2;
    }

    @JvmStatic
    public static final int getLogisticsStatusIcon(int i, boolean z, boolean z2) {
        return INSTANCE.getLogisticsStatusIcon(i, z, z2);
    }

    public final int getAllPosition() {
        return this.allPosition;
    }

    @NotNull
    public final CharSequence getContentSpan() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.desc);
        for (MatchResult matchResult : Regex.findAll$default(new Regex("\\b(1[3-9]\\d{9})\\b"), this.desc, 0, 2, (Object) null)) {
            int first = matchResult.getRange().getFirst();
            int last = matchResult.getRange().getLast() + 1;
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor(this.isLightStatus ? "#00B6DE" : RouteOverlay.f12338c)), first, last, 18);
            spannableStringBuilder.setSpan(new StyleSpan(1), first, last, 18);
        }
        return spannableStringBuilder;
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    public final List<ExpressLogisticsDetailBean> getDetails() {
        return this.details;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.itemType;
    }

    public final int getLogisticNode() {
        return this.logisticNode;
    }

    @NotNull
    public final String getLogisticNodeDesc() {
        return this.logisticNodeDesc;
    }

    public final int getPosition() {
        return this.position;
    }

    @NotNull
    public final String getTime() {
        return this.time;
    }

    public final boolean isFirstPosition() {
        return this.position == 0;
    }

    public final boolean isLastPosition() {
        return this.position == this.allPosition - 1;
    }

    /* JADX INFO: renamed from: isLightStatus, reason: from getter */
    public final boolean getIsLightStatus() {
        return this.isLightStatus;
    }

    public final void setAllPosition(int i) {
        this.allPosition = i;
    }

    public final void setLightStatus(boolean z) {
        this.isLightStatus = z;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public /* synthetic */ ExpressLogisticsBean(String str, int i, List list, String str2, String str3, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? new ArrayList() : list, (i3 & 8) != 0 ? "" : str2, (i3 & 16) != 0 ? "" : str3, i2);
    }
}
