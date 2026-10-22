package com.huachenjie.base.bean.reward;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import com.beizi.fusion.asnp.adn.ad.model.impl.db.AdvertCacheDBModel;
import com.google.android.material.timepicker.TimeModel;
import com.google.common.net.c;
import com.huachenjie.base.R;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.ys8;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b(\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 O2\u00020\u0001:\u0001OBw\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010-\u001a\u00020\fHÆ\u0003J\t\u0010.\u001a\u00020\u0012HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\bHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u00103\u001a\u00020\fHÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\bHÆ\u0003J\t\u00106\u001a\u00020\fHÆ\u0003J{\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\t\u00108\u001a\u00020\bHÖ\u0001J\u0013\u00109\u001a\u00020\u00122\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\u001a\u0010<\u001a\u00020\f2\b\b\u0002\u0010=\u001a\u00020\u00122\b\b\u0002\u0010>\u001a\u00020\u0012J\u0006\u0010?\u001a\u00020\fJ\u0006\u0010@\u001a\u00020\bJ\u0006\u0010A\u001a\u00020\bJ\u0006\u0010B\u001a\u00020\bJ\b\u0010C\u001a\u00020\fH\u0007J\b\u0010D\u001a\u00020\fH\u0007J\u0006\u0010E\u001a\u00020\fJ\t\u0010F\u001a\u00020\bHÖ\u0001J\u0006\u0010G\u001a\u00020\u0012J\u0006\u0010H\u001a\u00020\u0012J\t\u0010I\u001a\u00020\fHÖ\u0001J\u0019\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\bHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0010\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u000f\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u001eR\u001a\u0010\u000e\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0017R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001d¨\u0006P"}, d2 = {"Lcom/huachenjie/base/bean/reward/RewardInfoBean;", "Landroid/os/Parcelable;", "awardInfo", "Lcom/huachenjie/base/bean/reward/RewardInfoDetailBean;", "validPeriod", "", AdvertCacheDBModel.COLUMN_EXPIRE_TIME, "receivedStatus", "", "receiveRecord", "Lcom/huachenjie/base/bean/reward/RewardInfoReceiveBean;", "winningRecordNo", "", "winningTime", "position", "errorTip", "dialogTitle", "isTaskDialog", "", "(Lcom/huachenjie/base/bean/reward/RewardInfoDetailBean;JJILcom/huachenjie/base/bean/reward/RewardInfoReceiveBean;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;Z)V", "getAwardInfo", "()Lcom/huachenjie/base/bean/reward/RewardInfoDetailBean;", "getDialogTitle", "()Ljava/lang/String;", "setDialogTitle", "(Ljava/lang/String;)V", "getErrorTip", "setErrorTip", "getExpireTime", "()J", "()Z", "getPosition", "()I", "setPosition", "(I)V", "getReceiveRecord", "()Lcom/huachenjie/base/bean/reward/RewardInfoReceiveBean;", "setReceiveRecord", "(Lcom/huachenjie/base/bean/reward/RewardInfoReceiveBean;)V", "getReceivedStatus", "setReceivedStatus", "getValidPeriod", "getWinningRecordNo", "getWinningTime", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "equals", "other", "", "formatterMenuName", "isRecordList", "isDialog", "formatterStatus", "formatterStatusBgColor", "formatterStatusIcon", "formatterStatusTvColor", "formatterValidTime", "formatterValidTimeStyle2", "formatterWinTime", "hashCode", "showMenu", "showValidTime", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RewardInfoBean implements Parcelable {
    public static final int AWARD_TYPE_CASH = 6;
    public static final int AWARD_TYPE_GOODS = 1;
    public static final int AWARD_TYPE_INSPIRATION = 3;
    public static final int AWARD_TYPE_MEMBER = 4;
    public static final int AWARD_TYPE_PROPS = 2;
    public static final int AWARD_TYPE_VIRTUAL_ASSET = 5;
    public static final int MATERIAL_SUB_TYPE_COMMON = 0;
    public static final int MATERIAL_SUB_TYPE_SKIN = 20;
    public static final int RECEIVED_STATUS_FAIL = -1;
    public static final int RECEIVED_STATUS_SUC = 9;
    public static final int RECEIVED_STATUS_WAIT = 1;

    @Nullable
    private final RewardInfoDetailBean awardInfo;

    @NotNull
    private String dialogTitle;

    @NotNull
    private String errorTip;
    private final long expireTime;
    private final boolean isTaskDialog;
    private int position;

    @Nullable
    private RewardInfoReceiveBean receiveRecord;
    private int receivedStatus;
    private final long validPeriod;

    @NotNull
    private final String winningRecordNo;
    private final long winningTime;

    @NotNull
    public static final Parcelable.Creator<RewardInfoBean> CREATOR = new Creator();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RewardInfoBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RewardInfoBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RewardInfoBean(parcel.readInt() == 0 ? null : RewardInfoDetailBean.CREATOR.createFromParcel(parcel), parcel.readLong(), parcel.readLong(), parcel.readInt(), parcel.readInt() != 0 ? RewardInfoReceiveBean.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readLong(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RewardInfoBean[] newArray(int i) {
            return new RewardInfoBean[i];
        }
    }

    public RewardInfoBean() {
        this(null, 0L, 0L, 0, null, null, 0L, 0, null, null, false, 2047, null);
    }

    public RewardInfoBean(@Nullable RewardInfoDetailBean rewardInfoDetailBean, long j, long j2, int i, @Nullable RewardInfoReceiveBean rewardInfoReceiveBean, @NotNull String str, long j3, int i2, @NotNull String str2, @NotNull String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "winningRecordNo");
        Intrinsics.checkNotNullParameter(str2, "errorTip");
        Intrinsics.checkNotNullParameter(str3, "dialogTitle");
        this.awardInfo = rewardInfoDetailBean;
        this.validPeriod = j;
        this.expireTime = j2;
        this.receivedStatus = i;
        this.receiveRecord = rewardInfoReceiveBean;
        this.winningRecordNo = str;
        this.winningTime = j3;
        this.position = i2;
        this.errorTip = str2;
        this.dialogTitle = str3;
        this.isTaskDialog = z;
    }

    public static /* synthetic */ String formatterMenuName$default(RewardInfoBean rewardInfoBean, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        return rewardInfoBean.formatterMenuName(z, z2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final RewardInfoDetailBean getAwardInfo() {
        return this.awardInfo;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getDialogTitle() {
        return this.dialogTitle;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getIsTaskDialog() {
        return this.isTaskDialog;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getValidPeriod() {
        return this.validPeriod;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getExpireTime() {
        return this.expireTime;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getReceivedStatus() {
        return this.receivedStatus;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final RewardInfoReceiveBean getReceiveRecord() {
        return this.receiveRecord;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getWinningRecordNo() {
        return this.winningRecordNo;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getWinningTime() {
        return this.winningTime;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getErrorTip() {
        return this.errorTip;
    }

    @NotNull
    public final RewardInfoBean copy(@Nullable RewardInfoDetailBean awardInfo, long validPeriod, long expireTime, int receivedStatus, @Nullable RewardInfoReceiveBean receiveRecord, @NotNull String winningRecordNo, long winningTime, int position, @NotNull String errorTip, @NotNull String dialogTitle, boolean isTaskDialog) {
        Intrinsics.checkNotNullParameter(winningRecordNo, "winningRecordNo");
        Intrinsics.checkNotNullParameter(errorTip, "errorTip");
        Intrinsics.checkNotNullParameter(dialogTitle, "dialogTitle");
        return new RewardInfoBean(awardInfo, validPeriod, expireTime, receivedStatus, receiveRecord, winningRecordNo, winningTime, position, errorTip, dialogTitle, isTaskDialog);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RewardInfoBean)) {
            return false;
        }
        RewardInfoBean rewardInfoBean = (RewardInfoBean) other;
        return Intrinsics.areEqual(this.awardInfo, rewardInfoBean.awardInfo) && this.validPeriod == rewardInfoBean.validPeriod && this.expireTime == rewardInfoBean.expireTime && this.receivedStatus == rewardInfoBean.receivedStatus && Intrinsics.areEqual(this.receiveRecord, rewardInfoBean.receiveRecord) && Intrinsics.areEqual(this.winningRecordNo, rewardInfoBean.winningRecordNo) && this.winningTime == rewardInfoBean.winningTime && this.position == rewardInfoBean.position && Intrinsics.areEqual(this.errorTip, rewardInfoBean.errorTip) && Intrinsics.areEqual(this.dialogTitle, rewardInfoBean.dialogTitle) && this.isTaskDialog == rewardInfoBean.isTaskDialog;
    }

    @NotNull
    public final String formatterMenuName(boolean isRecordList, boolean isDialog) {
        String strE;
        if (this.isTaskDialog) {
            String strE2 = ys8.e(R.string.home_record_menu_home_reward);
            Intrinsics.checkNotNullExpressionValue(strE2, "getString(R.string.home_record_menu_home_reward)");
            return strE2;
        }
        RewardInfoDetailBean rewardInfoDetailBean = this.awardInfo;
        if (rewardInfoDetailBean != null && rewardInfoDetailBean.getAwardType() == 1) {
            if (this.receivedStatus == 1) {
                strE = isRecordList ? ys8.e(R.string.home_record_menu_add_address) : ys8.e(R.string.home_record_menu_detail_add_address);
            } else {
                strE = ys8.e(R.string.home_record_menu_see_logistics);
            }
            Intrinsics.checkNotNullExpressionValue(strE, "{\n            if (receiv…)\n            }\n        }");
            return strE;
        }
        RewardInfoDetailBean rewardInfoDetailBean2 = this.awardInfo;
        if (rewardInfoDetailBean2 != null && rewardInfoDetailBean2.getAwardType() == 2) {
            RewardInfoMaterialBean materialInfo = this.awardInfo.getMaterialInfo();
            String strE3 = materialInfo != null && materialInfo.getMaterialSubType() == 20 ? ys8.e(R.string.home_record_menu_see_props) : ys8.e(R.string.home_record_menu_home_reward);
            Intrinsics.checkNotNullExpressionValue(strE3, "{\n            // 皮肤奖品显示去…)\n            }\n        }");
            return strE3;
        }
        RewardInfoDetailBean rewardInfoDetailBean3 = this.awardInfo;
        if (rewardInfoDetailBean3 != null && rewardInfoDetailBean3.getAwardType() == 6) {
            String strE4 = isRecordList ? ys8.e(R.string.home_record_menu_home_withdraw_record) : ys8.e(R.string.home_record_menu_home_withdraw);
            Intrinsics.checkNotNullExpressionValue(strE4, "{\n            if (isReco…)\n            }\n        }");
            return strE4;
        }
        if (!isDialog) {
            RewardInfoDetailBean rewardInfoDetailBean4 = this.awardInfo;
            if (rewardInfoDetailBean4 != null && rewardInfoDetailBean4.getAwardType() == 4) {
                String strE5 = ys8.e(R.string.home_record_menu_home_withdraw_record);
                Intrinsics.checkNotNullExpressionValue(strE5, "getString(R.string.home_…enu_home_withdraw_record)");
                return strE5;
            }
        }
        String strE6 = ys8.e(R.string.home_record_menu_home_reward);
        Intrinsics.checkNotNullExpressionValue(strE6, "{\n            StringUtil…nu_home_reward)\n        }");
        return strE6;
    }

    @NotNull
    public final String formatterStatus() {
        int i = this.receivedStatus;
        if (i == -1) {
            String strE = ys8.e(R.string.home_record_detail_status_fail);
            Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.home_record_detail_status_fail)");
            return strE;
        }
        if (i == 1) {
            String strE2 = ys8.e(R.string.home_record_detail_status_wait);
            Intrinsics.checkNotNullExpressionValue(strE2, "getString(R.string.home_record_detail_status_wait)");
            return strE2;
        }
        if (i != 9) {
            String strE3 = ys8.e(R.string.home_record_detail_status_fail);
            Intrinsics.checkNotNullExpressionValue(strE3, "getString(R.string.home_record_detail_status_fail)");
            return strE3;
        }
        String strE4 = ys8.e(R.string.home_record_detail_status_suc);
        Intrinsics.checkNotNullExpressionValue(strE4, "getString(R.string.home_record_detail_status_suc)");
        return strE4;
    }

    public final int formatterStatusBgColor() {
        int i = this.receivedStatus;
        if (i == -1) {
            return R.color.color_CCCCCC;
        }
        if (i != 1) {
            return i != 9 ? R.color.color_CCCCCC : R.color.color_191F20;
        }
        return R.color.color_0BD3FF;
    }

    public final int formatterStatusIcon() {
        int i = this.receivedStatus;
        if (i == -1) {
            return R.drawable.home_ic_reward_status_fail;
        }
        if (i != 1) {
            return i != 9 ? R.drawable.home_ic_reward_status_fail : R.drawable.home_ic_reward_status_suc;
        }
        return R.drawable.home_ic_reward_status_wait;
    }

    public final int formatterStatusTvColor() {
        int i = this.receivedStatus;
        if (i == -1) {
            return R.color.white;
        }
        if (i != 1) {
            return i != 9 ? R.color.white : R.color.color_0BD3FF;
        }
        return R.color.color_191F20;
    }

    @SuppressLint({"DefaultLocale"})
    @NotNull
    public final String formatterValidTime() {
        long j = this.validPeriod / ((long) 1000);
        long j2 = 86400;
        long j3 = j / j2;
        long j4 = 3600;
        long j5 = (j % j2) / j4;
        long j6 = 60;
        long j7 = (j % j4) / j6;
        long j8 = j % j6;
        if (j3 <= 0) {
            StringBuilder sb = new StringBuilder();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Long.valueOf(j5)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            sb.append(str);
            sb.append(c.b);
            String str2 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Long.valueOf(j7)}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
            sb.append(str2);
            sb.append(c.b);
            String str3 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Long.valueOf(j8)}, 1));
            Intrinsics.checkNotNullExpressionValue(str3, "format(format, *args)");
            sb.append(str3);
            sb.append(" 后失效");
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(j3);
        sb2.append("天 ");
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String str4 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Long.valueOf(j5)}, 1));
        Intrinsics.checkNotNullExpressionValue(str4, "format(format, *args)");
        sb2.append(str4);
        sb2.append(c.b);
        String str5 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Long.valueOf(j7)}, 1));
        Intrinsics.checkNotNullExpressionValue(str5, "format(format, *args)");
        sb2.append(str5);
        sb2.append(c.b);
        String str6 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Long.valueOf(j8)}, 1));
        Intrinsics.checkNotNullExpressionValue(str6, "format(format, *args)");
        sb2.append(str6);
        sb2.append(" 后失效");
        return sb2.toString();
    }

    @SuppressLint({"DefaultLocale"})
    @NotNull
    public final String formatterValidTimeStyle2() {
        return (((this.validPeriod / ((long) 1000)) / ((long) 3600)) + 1) + "小时内有效";
    }

    @NotNull
    public final String formatterWinTime() {
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Long.valueOf(this.winningTime));
        Intrinsics.checkNotNullExpressionValue(str, "simpleDateFormat.format(winningTime)");
        return str;
    }

    @Nullable
    public final RewardInfoDetailBean getAwardInfo() {
        return this.awardInfo;
    }

    @NotNull
    public final String getDialogTitle() {
        return this.dialogTitle;
    }

    @NotNull
    public final String getErrorTip() {
        return this.errorTip;
    }

    public final long getExpireTime() {
        return this.expireTime;
    }

    public final int getPosition() {
        return this.position;
    }

    @Nullable
    public final RewardInfoReceiveBean getReceiveRecord() {
        return this.receiveRecord;
    }

    public final int getReceivedStatus() {
        return this.receivedStatus;
    }

    public final long getValidPeriod() {
        return this.validPeriod;
    }

    @NotNull
    public final String getWinningRecordNo() {
        return this.winningRecordNo;
    }

    public final long getWinningTime() {
        return this.winningTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v16 */
    public int hashCode() {
        RewardInfoDetailBean rewardInfoDetailBean = this.awardInfo;
        int iHashCode = (((((((rewardInfoDetailBean == null ? 0 : rewardInfoDetailBean.hashCode()) * 31) + Long.hashCode(this.validPeriod)) * 31) + Long.hashCode(this.expireTime)) * 31) + Integer.hashCode(this.receivedStatus)) * 31;
        RewardInfoReceiveBean rewardInfoReceiveBean = this.receiveRecord;
        int iHashCode2 = (((((((((((iHashCode + (rewardInfoReceiveBean != null ? rewardInfoReceiveBean.hashCode() : 0)) * 31) + this.winningRecordNo.hashCode()) * 31) + Long.hashCode(this.winningTime)) * 31) + Integer.hashCode(this.position)) * 31) + this.errorTip.hashCode()) * 31) + this.dialogTitle.hashCode()) * 31;
        boolean z = this.isTaskDialog;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public final boolean isTaskDialog() {
        return this.isTaskDialog;
    }

    public final void setDialogTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dialogTitle = str;
    }

    public final void setErrorTip(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.errorTip = str;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final void setReceiveRecord(@Nullable RewardInfoReceiveBean rewardInfoReceiveBean) {
        this.receiveRecord = rewardInfoReceiveBean;
    }

    public final void setReceivedStatus(int i) {
        this.receivedStatus = i;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x003b  */
    /* JADX WARN: Code duplicated, block: B:30:0x0048  */
    /* JADX WARN: Code duplicated, block: B:32:0x004b  */
    /* JADX WARN: Code duplicated, block: B:37:0x0058  */
    /* JADX WARN: Code duplicated, block: B:39:0x005b  */
    /* JADX WARN: Code duplicated, block: B:44:0x006b  */
    /* JADX WARN: Code duplicated, block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:? A[RETURN, SYNTHETIC] */
    public final boolean showMenu() {
        RewardInfoDetailBean rewardInfoDetailBean;
        boolean z;
        RewardInfoDetailBean rewardInfoDetailBean2;
        boolean z2;
        RewardInfoMaterialBean materialInfo;
        boolean z3;
        if (this.receivedStatus == -1) {
            return false;
        }
        RewardInfoDetailBean rewardInfoDetailBean3 = this.awardInfo;
        if (!(rewardInfoDetailBean3 != null && rewardInfoDetailBean3.getAwardType() == 1)) {
            RewardInfoDetailBean rewardInfoDetailBean4 = this.awardInfo;
            if (rewardInfoDetailBean4 != null && rewardInfoDetailBean4.getAwardType() == 2) {
                RewardInfoMaterialBean materialInfo2 = this.awardInfo.getMaterialInfo();
                if (!(materialInfo2 != null && materialInfo2.getMaterialSubType() == 20)) {
                    rewardInfoDetailBean = this.awardInfo;
                    if (rewardInfoDetailBean == null) {
                        z = false;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        rewardInfoDetailBean2 = this.awardInfo;
                        if (rewardInfoDetailBean2 == null) {
                            z2 = false;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            return false;
                        }
                        materialInfo = this.awardInfo.getMaterialInfo();
                        if (materialInfo == null) {
                            z3 = false;
                        } else {
                            z3 = false;
                        }
                        if (!z3) {
                            return false;
                        }
                    }
                }
            } else {
                rewardInfoDetailBean = this.awardInfo;
                if (rewardInfoDetailBean == null && rewardInfoDetailBean.getAwardType() == 6) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    rewardInfoDetailBean2 = this.awardInfo;
                    if (rewardInfoDetailBean2 == null && rewardInfoDetailBean2.getAwardType() == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        return false;
                    }
                    materialInfo = this.awardInfo.getMaterialInfo();
                    if (materialInfo == null && materialInfo.getMaterialSubType() == 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (!z3) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final boolean showValidTime() {
        return this.receivedStatus == 1 && this.validPeriod > 0;
    }

    @NotNull
    public String toString() {
        return "RewardInfoBean(awardInfo=" + this.awardInfo + ", validPeriod=" + this.validPeriod + ", expireTime=" + this.expireTime + ", receivedStatus=" + this.receivedStatus + ", receiveRecord=" + this.receiveRecord + ", winningRecordNo=" + this.winningRecordNo + ", winningTime=" + this.winningTime + ", position=" + this.position + ", errorTip=" + this.errorTip + ", dialogTitle=" + this.dialogTitle + ", isTaskDialog=" + this.isTaskDialog + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        RewardInfoDetailBean rewardInfoDetailBean = this.awardInfo;
        if (rewardInfoDetailBean == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            rewardInfoDetailBean.writeToParcel(parcel, flags);
        }
        parcel.writeLong(this.validPeriod);
        parcel.writeLong(this.expireTime);
        parcel.writeInt(this.receivedStatus);
        RewardInfoReceiveBean rewardInfoReceiveBean = this.receiveRecord;
        if (rewardInfoReceiveBean == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            rewardInfoReceiveBean.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.winningRecordNo);
        parcel.writeLong(this.winningTime);
        parcel.writeInt(this.position);
        parcel.writeString(this.errorTip);
        parcel.writeString(this.dialogTitle);
        parcel.writeInt(this.isTaskDialog ? 1 : 0);
    }

    public /* synthetic */ RewardInfoBean(RewardInfoDetailBean rewardInfoDetailBean, long j, long j2, int i, RewardInfoReceiveBean rewardInfoReceiveBean, String str, long j3, int i2, String str2, String str3, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : rewardInfoDetailBean, (i3 & 2) != 0 ? 0L : j, (i3 & 4) != 0 ? 0L : j2, (i3 & 8) != 0 ? 0 : i, (i3 & 16) == 0 ? rewardInfoReceiveBean : null, (i3 & 32) != 0 ? "" : str, (i3 & 64) == 0 ? j3 : 0L, (i3 & 128) != 0 ? 0 : i2, (i3 & 256) != 0 ? "" : str2, (i3 & 512) == 0 ? str3 : "", (i3 & 1024) == 0 ? z : false);
    }
}
