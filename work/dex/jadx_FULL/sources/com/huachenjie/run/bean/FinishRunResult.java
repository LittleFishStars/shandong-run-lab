package com.huachenjie.run.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.common.bean.AlertTip;
import com.huachenjie.run.page.run_reward.RunRewardActivity;
import com.zj.adlib.yj7;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001Bw\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\t\u00107\u001a\u00020\u0003HÖ\u0001J\u0019\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b*\u0010#\"\u0004\b+\u0010,R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b3\u0010#\"\u0004\b4\u0010,R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b5\u0010#\"\u0004\b6\u0010,¨\u0006="}, d2 = {"Lcom/huachenjie/run/bean/FinishRunResult;", "Landroid/os/Parcelable;", "status", "", yj7.a.ALERT_TIP, "Lcom/huachenjie/common/bean/AlertTip;", "runRecordCode", "", "validDistance", "appealFlag", "", RunRewardActivity.t, "", RunRewardActivity.x, "recheckStatus", "inspiration", "Lcom/huachenjie/run/bean/InspirationBean;", "runScene", "emaAnswer", "Lcom/huachenjie/run/bean/EmaAnswerBean;", "(Ljava/lang/Integer;Lcom/huachenjie/common/bean/AlertTip;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/huachenjie/run/bean/InspirationBean;ILcom/huachenjie/run/bean/EmaAnswerBean;)V", "getAlertTip", "()Lcom/huachenjie/common/bean/AlertTip;", "setAlertTip", "(Lcom/huachenjie/common/bean/AlertTip;)V", "getAppealFlag", "()Ljava/lang/Boolean;", "setAppealFlag", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getEmaAnswer", "()Lcom/huachenjie/run/bean/EmaAnswerBean;", "getInspiration", "()Lcom/huachenjie/run/bean/InspirationBean;", "getRecheckStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRewardDistance", "()Ljava/lang/Long;", "setRewardDistance", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getRewardTimes", "setRewardTimes", "(Ljava/lang/Integer;)V", "getRunRecordCode", "()Ljava/lang/String;", "setRunRecordCode", "(Ljava/lang/String;)V", "getRunScene", "()I", "getStatus", "setStatus", "getValidDistance", "setValidDistance", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FinishRunResult implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<FinishRunResult> CREATOR = new Creator();

    @Nullable
    private AlertTip alertTip;

    @Nullable
    private Boolean appealFlag;

    @Nullable
    private final EmaAnswerBean emaAnswer;

    @NotNull
    private final InspirationBean inspiration;

    @Nullable
    private final Integer recheckStatus;

    @Nullable
    private Long rewardDistance;

    @Nullable
    private Integer rewardTimes;

    @Nullable
    private String runRecordCode;
    private final int runScene;

    @Nullable
    private Integer status;

    @Nullable
    private Integer validDistance;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FinishRunResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FinishRunResult createFromParcel(@NotNull Parcel parcel) {
            Boolean boolValueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            AlertTip alertTip = (AlertTip) parcel.readParcelable(FinishRunResult.class.getClassLoader());
            String string = parcel.readString();
            Integer numValueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new FinishRunResult(numValueOf, alertTip, string, numValueOf2, boolValueOf, parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), InspirationBean.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readInt() != 0 ? EmaAnswerBean.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FinishRunResult[] newArray(int i) {
            return new FinishRunResult[i];
        }
    }

    public FinishRunResult(@Nullable Integer num, @Nullable AlertTip alertTip, @Nullable String str, @Nullable Integer num2, @Nullable Boolean bool, @Nullable Long l, @Nullable Integer num3, @Nullable Integer num4, @NotNull InspirationBean inspirationBean, int i, @Nullable EmaAnswerBean emaAnswerBean) {
        Intrinsics.checkNotNullParameter(inspirationBean, "inspiration");
        this.status = num;
        this.alertTip = alertTip;
        this.runRecordCode = str;
        this.validDistance = num2;
        this.appealFlag = bool;
        this.rewardDistance = l;
        this.rewardTimes = num3;
        this.recheckStatus = num4;
        this.inspiration = inspirationBean;
        this.runScene = i;
        this.emaAnswer = emaAnswerBean;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final AlertTip getAlertTip() {
        return this.alertTip;
    }

    @Nullable
    public final Boolean getAppealFlag() {
        return this.appealFlag;
    }

    @Nullable
    public final EmaAnswerBean getEmaAnswer() {
        return this.emaAnswer;
    }

    @NotNull
    public final InspirationBean getInspiration() {
        return this.inspiration;
    }

    @Nullable
    public final Integer getRecheckStatus() {
        return this.recheckStatus;
    }

    @Nullable
    public final Long getRewardDistance() {
        return this.rewardDistance;
    }

    @Nullable
    public final Integer getRewardTimes() {
        return this.rewardTimes;
    }

    @Nullable
    public final String getRunRecordCode() {
        return this.runRecordCode;
    }

    public final int getRunScene() {
        return this.runScene;
    }

    @Nullable
    public final Integer getStatus() {
        return this.status;
    }

    @Nullable
    public final Integer getValidDistance() {
        return this.validDistance;
    }

    public final void setAlertTip(@Nullable AlertTip alertTip) {
        this.alertTip = alertTip;
    }

    public final void setAppealFlag(@Nullable Boolean bool) {
        this.appealFlag = bool;
    }

    public final void setRewardDistance(@Nullable Long l) {
        this.rewardDistance = l;
    }

    public final void setRewardTimes(@Nullable Integer num) {
        this.rewardTimes = num;
    }

    public final void setRunRecordCode(@Nullable String str) {
        this.runRecordCode = str;
    }

    public final void setStatus(@Nullable Integer num) {
        this.status = num;
    }

    public final void setValidDistance(@Nullable Integer num) {
        this.validDistance = num;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Integer num = this.status;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeParcelable(this.alertTip, flags);
        parcel.writeString(this.runRecordCode);
        Integer num2 = this.validDistance;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        Boolean bool = this.appealFlag;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Long l = this.rewardDistance;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        Integer num3 = this.rewardTimes;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        Integer num4 = this.recheckStatus;
        if (num4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num4.intValue());
        }
        this.inspiration.writeToParcel(parcel, flags);
        parcel.writeInt(this.runScene);
        EmaAnswerBean emaAnswerBean = this.emaAnswer;
        if (emaAnswerBean == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            emaAnswerBean.writeToParcel(parcel, flags);
        }
    }

    public /* synthetic */ FinishRunResult(Integer num, AlertTip alertTip, String str, Integer num2, Boolean bool, Long l, Integer num3, Integer num4, InspirationBean inspirationBean, int i, EmaAnswerBean emaAnswerBean, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, alertTip, str, num2, bool, l, num3, (i2 & 128) != 0 ? null : num4, (i2 & 256) != 0 ? new InspirationBean(null, 0, 0, 7, null) : inspirationBean, (i2 & 512) != 0 ? 0 : i, (i2 & 1024) != 0 ? null : emaAnswerBean);
    }
}
