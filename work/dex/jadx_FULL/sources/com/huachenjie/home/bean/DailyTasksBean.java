package com.huachenjie.home.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.home.page.SignUpWebActivity;
import com.ipd.dsp.internal.i.q;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b¢\u0006\u0002\u0010\u0013J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\t\u0010.\u001a\u00020\bHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\bHÆ\u0003J\t\u00103\u001a\u00020\bHÆ\u0003J\t\u00104\u001a\u00020\bHÆ\u0003J\t\u00105\u001a\u00020\fHÆ\u0003J\t\u00106\u001a\u00020\u000eHÆ\u0003J\u0083\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\bHÆ\u0001J\t\u00108\u001a\u00020\bHÖ\u0001J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<HÖ\u0003J\u0006\u0010=\u001a\u00020:J\t\u0010>\u001a\u00020\bHÖ\u0001J\u0006\u0010?\u001a\u00020\u0003J\u0006\u0010@\u001a\u00020\u0003J\u0006\u0010A\u001a\u00020\u0003J\u0006\u0010B\u001a\u00020\u0003J\t\u0010C\u001a\u00020\u0003HÖ\u0001J\u0019\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\bHÖ\u0001R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0012\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0011\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010(R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0017\"\u0004\b*\u0010\u0019¨\u0006I"}, d2 = {"Lcom/huachenjie/home/bean/DailyTasksBean;", "Landroid/os/Parcelable;", "taskNo", "", SignUpWebActivity.A, "logoUrl", "name", "taskFrequency", "", "taskType", "status", "progress", "Lcom/huachenjie/home/bean/DailyTasksProgressBean;", "rewardDisplay", "Lcom/huachenjie/home/bean/DailyTasksRewardDisplayBean;", "action", "Lcom/huachenjie/home/bean/DailyTasksActionBean;", "rewardStrat", "localOnceProgress", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILcom/huachenjie/home/bean/DailyTasksProgressBean;Lcom/huachenjie/home/bean/DailyTasksRewardDisplayBean;Lcom/huachenjie/home/bean/DailyTasksActionBean;II)V", "getAction", "()Lcom/huachenjie/home/bean/DailyTasksActionBean;", "getLocalOnceProgress", "()I", "setLocalOnceProgress", "(I)V", "getLogoUrl", "()Ljava/lang/String;", "getName", "getProgress", "()Lcom/huachenjie/home/bean/DailyTasksProgressBean;", "getRewardDisplay", "()Lcom/huachenjie/home/bean/DailyTasksRewardDisplayBean;", "getRewardStrat", "getStatus", "setStatus", "getTaskConfigNo", "getTaskFrequency", "getTaskNo", "setTaskNo", "(Ljava/lang/String;)V", "getTaskType", "setTaskType", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "finished", "hashCode", "localOnceProgressStr", "nameStr", "rewardDisplayStr", "statusName", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DailyTasksBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<DailyTasksBean> CREATOR = new Creator();

    @Nullable
    private final DailyTasksActionBean action;
    private int localOnceProgress;

    @NotNull
    private final String logoUrl;

    @NotNull
    private final String name;

    @NotNull
    private final DailyTasksProgressBean progress;

    @NotNull
    private final DailyTasksRewardDisplayBean rewardDisplay;
    private final int rewardStrat;
    private int status;

    @NotNull
    private final String taskConfigNo;
    private final int taskFrequency;

    @NotNull
    private String taskNo;
    private int taskType;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DailyTasksBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DailyTasksBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DailyTasksBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), DailyTasksProgressBean.CREATOR.createFromParcel(parcel), DailyTasksRewardDisplayBean.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : DailyTasksActionBean.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DailyTasksBean[] newArray(int i) {
            return new DailyTasksBean[i];
        }
    }

    public DailyTasksBean() {
        this(null, null, null, null, 0, 0, 0, null, null, null, 0, 0, 4095, null);
    }

    public DailyTasksBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i, int i2, int i3, @NotNull DailyTasksProgressBean dailyTasksProgressBean, @NotNull DailyTasksRewardDisplayBean dailyTasksRewardDisplayBean, @Nullable DailyTasksActionBean dailyTasksActionBean, int i4, int i5) {
        Intrinsics.checkNotNullParameter(str, "taskNo");
        Intrinsics.checkNotNullParameter(str2, SignUpWebActivity.A);
        Intrinsics.checkNotNullParameter(str3, "logoUrl");
        Intrinsics.checkNotNullParameter(str4, "name");
        Intrinsics.checkNotNullParameter(dailyTasksProgressBean, "progress");
        Intrinsics.checkNotNullParameter(dailyTasksRewardDisplayBean, "rewardDisplay");
        this.taskNo = str;
        this.taskConfigNo = str2;
        this.logoUrl = str3;
        this.name = str4;
        this.taskFrequency = i;
        this.taskType = i2;
        this.status = i3;
        this.progress = dailyTasksProgressBean;
        this.rewardDisplay = dailyTasksRewardDisplayBean;
        this.action = dailyTasksActionBean;
        this.rewardStrat = i4;
        this.localOnceProgress = i5;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTaskNo() {
        return this.taskNo;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final DailyTasksActionBean getAction() {
        return this.action;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getRewardStrat() {
        return this.rewardStrat;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getLocalOnceProgress() {
        return this.localOnceProgress;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTaskConfigNo() {
        return this.taskConfigNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getTaskFrequency() {
        return this.taskFrequency;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getTaskType() {
        return this.taskType;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final DailyTasksProgressBean getProgress() {
        return this.progress;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final DailyTasksRewardDisplayBean getRewardDisplay() {
        return this.rewardDisplay;
    }

    @NotNull
    public final DailyTasksBean copy(@NotNull String taskNo, @NotNull String taskConfigNo, @NotNull String logoUrl, @NotNull String name, int taskFrequency, int taskType, int status, @NotNull DailyTasksProgressBean progress, @NotNull DailyTasksRewardDisplayBean rewardDisplay, @Nullable DailyTasksActionBean action, int rewardStrat, int localOnceProgress) {
        Intrinsics.checkNotNullParameter(taskNo, "taskNo");
        Intrinsics.checkNotNullParameter(taskConfigNo, SignUpWebActivity.A);
        Intrinsics.checkNotNullParameter(logoUrl, "logoUrl");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(progress, "progress");
        Intrinsics.checkNotNullParameter(rewardDisplay, "rewardDisplay");
        return new DailyTasksBean(taskNo, taskConfigNo, logoUrl, name, taskFrequency, taskType, status, progress, rewardDisplay, action, rewardStrat, localOnceProgress);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DailyTasksBean)) {
            return false;
        }
        DailyTasksBean dailyTasksBean = (DailyTasksBean) other;
        return Intrinsics.areEqual(this.taskNo, dailyTasksBean.taskNo) && Intrinsics.areEqual(this.taskConfigNo, dailyTasksBean.taskConfigNo) && Intrinsics.areEqual(this.logoUrl, dailyTasksBean.logoUrl) && Intrinsics.areEqual(this.name, dailyTasksBean.name) && this.taskFrequency == dailyTasksBean.taskFrequency && this.taskType == dailyTasksBean.taskType && this.status == dailyTasksBean.status && Intrinsics.areEqual(this.progress, dailyTasksBean.progress) && Intrinsics.areEqual(this.rewardDisplay, dailyTasksBean.rewardDisplay) && Intrinsics.areEqual(this.action, dailyTasksBean.action) && this.rewardStrat == dailyTasksBean.rewardStrat && this.localOnceProgress == dailyTasksBean.localOnceProgress;
    }

    public final boolean finished() {
        return this.status == 2;
    }

    @Nullable
    public final DailyTasksActionBean getAction() {
        return this.action;
    }

    public final int getLocalOnceProgress() {
        return this.localOnceProgress;
    }

    @NotNull
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final DailyTasksProgressBean getProgress() {
        return this.progress;
    }

    @NotNull
    public final DailyTasksRewardDisplayBean getRewardDisplay() {
        return this.rewardDisplay;
    }

    public final int getRewardStrat() {
        return this.rewardStrat;
    }

    public final int getStatus() {
        return this.status;
    }

    @NotNull
    public final String getTaskConfigNo() {
        return this.taskConfigNo;
    }

    public final int getTaskFrequency() {
        return this.taskFrequency;
    }

    @NotNull
    public final String getTaskNo() {
        return this.taskNo;
    }

    public final int getTaskType() {
        return this.taskType;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((this.taskNo.hashCode() * 31) + this.taskConfigNo.hashCode()) * 31) + this.logoUrl.hashCode()) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.taskFrequency)) * 31) + Integer.hashCode(this.taskType)) * 31) + Integer.hashCode(this.status)) * 31) + this.progress.hashCode()) * 31) + this.rewardDisplay.hashCode()) * 31;
        DailyTasksActionBean dailyTasksActionBean = this.action;
        return ((((iHashCode + (dailyTasksActionBean == null ? 0 : dailyTasksActionBean.hashCode())) * 31) + Integer.hashCode(this.rewardStrat)) * 31) + Integer.hashCode(this.localOnceProgress);
    }

    @NotNull
    public final String localOnceProgressStr() {
        int i = this.taskType;
        if (i == 5) {
            return "当前步数" + this.localOnceProgress + (char) 27493;
        }
        if (i != 8) {
            return "";
        }
        return "已浏览" + this.localOnceProgress + (char) 20010;
    }

    @NotNull
    public final String nameStr() {
        return this.name + q.a.i + this.progress.getCompletedCount() + '/' + this.progress.getMaxCompleteCount();
    }

    @NotNull
    public final String rewardDisplayStr() {
        if (this.rewardDisplay.getMin() == this.rewardDisplay.getMax()) {
            return "闪金币+" + this.rewardDisplay.getMin();
        }
        return "闪金币+" + this.rewardDisplay.getMin() + '~' + this.rewardDisplay.getMax();
    }

    public final void setLocalOnceProgress(int i) {
        this.localOnceProgress = i;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setTaskNo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.taskNo = str;
    }

    public final void setTaskType(int i) {
        this.taskType = i;
    }

    @NotNull
    public final String statusName() {
        int i = this.status;
        if (i == 0) {
            return "去完成";
        }
        if (i != 1) {
            return i != 2 ? "" : "已完成";
        }
        return "待领取";
    }

    @NotNull
    public String toString() {
        return "DailyTasksBean(taskNo=" + this.taskNo + ", taskConfigNo=" + this.taskConfigNo + ", logoUrl=" + this.logoUrl + ", name=" + this.name + ", taskFrequency=" + this.taskFrequency + ", taskType=" + this.taskType + ", status=" + this.status + ", progress=" + this.progress + ", rewardDisplay=" + this.rewardDisplay + ", action=" + this.action + ", rewardStrat=" + this.rewardStrat + ", localOnceProgress=" + this.localOnceProgress + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.taskNo);
        parcel.writeString(this.taskConfigNo);
        parcel.writeString(this.logoUrl);
        parcel.writeString(this.name);
        parcel.writeInt(this.taskFrequency);
        parcel.writeInt(this.taskType);
        parcel.writeInt(this.status);
        this.progress.writeToParcel(parcel, flags);
        this.rewardDisplay.writeToParcel(parcel, flags);
        DailyTasksActionBean dailyTasksActionBean = this.action;
        if (dailyTasksActionBean == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dailyTasksActionBean.writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.rewardStrat);
        parcel.writeInt(this.localOnceProgress);
    }

    public /* synthetic */ DailyTasksBean(String str, String str2, String str3, String str4, int i, int i2, int i3, DailyTasksProgressBean dailyTasksProgressBean, DailyTasksRewardDisplayBean dailyTasksRewardDisplayBean, DailyTasksActionBean dailyTasksActionBean, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? "" : str, (i6 & 2) != 0 ? "" : str2, (i6 & 4) != 0 ? "" : str3, (i6 & 8) == 0 ? str4 : "", (i6 & 16) != 0 ? 0 : i, (i6 & 32) != 0 ? 0 : i2, (i6 & 64) != 0 ? 0 : i3, (i6 & 128) != 0 ? new DailyTasksProgressBean(0, 0, 3, null) : dailyTasksProgressBean, (i6 & 256) != 0 ? new DailyTasksRewardDisplayBean(0, 0, 3, null) : dailyTasksRewardDisplayBean, (i6 & 512) == 0 ? dailyTasksActionBean : null, (i6 & 1024) != 0 ? 0 : i4, (i6 & 2048) == 0 ? i5 : 0);
    }
}
