package com.huachenjie.run.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Parcelize
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006&"}, d2 = {"Lcom/huachenjie/run/bean/RunPlanBean;", "Landroid/os/Parcelable;", "runPlanCode", "", "runPlanName", "planStatus", "", "applyModel", "runScene", "touchCheckType", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;II)V", "getApplyModel", "()Ljava/lang/String;", "getPlanStatus", "()I", "getRunPlanCode", "getRunPlanName", "getRunScene", "getTouchCheckType", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RunPlanBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<RunPlanBean> CREATOR = new Creator();

    @NotNull
    private final String applyModel;
    private final int planStatus;

    @NotNull
    private final String runPlanCode;

    @NotNull
    private final String runPlanName;
    private final int runScene;
    private final int touchCheckType;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RunPlanBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RunPlanBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RunPlanBean(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RunPlanBean[] newArray(int i) {
            return new RunPlanBean[i];
        }
    }

    public RunPlanBean() {
        this(null, null, 0, null, 0, 0, 63, null);
    }

    public RunPlanBean(@NotNull String str, @NotNull String str2, int i, @NotNull String str3, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "runPlanCode");
        Intrinsics.checkNotNullParameter(str2, "runPlanName");
        Intrinsics.checkNotNullParameter(str3, "applyModel");
        this.runPlanCode = str;
        this.runPlanName = str2;
        this.planStatus = i;
        this.applyModel = str3;
        this.runScene = i2;
        this.touchCheckType = i3;
    }

    public static /* synthetic */ RunPlanBean copy$default(RunPlanBean runPlanBean, String str, String str2, int i, String str3, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = runPlanBean.runPlanCode;
        }
        if ((i4 & 2) != 0) {
            str2 = runPlanBean.runPlanName;
        }
        String str4 = str2;
        if ((i4 & 4) != 0) {
            i = runPlanBean.planStatus;
        }
        int i5 = i;
        if ((i4 & 8) != 0) {
            str3 = runPlanBean.applyModel;
        }
        String str5 = str3;
        if ((i4 & 16) != 0) {
            i2 = runPlanBean.runScene;
        }
        int i6 = i2;
        if ((i4 & 32) != 0) {
            i3 = runPlanBean.touchCheckType;
        }
        return runPlanBean.copy(str, str4, i5, str5, i6, i3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRunPlanCode() {
        return this.runPlanCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRunPlanName() {
        return this.runPlanName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPlanStatus() {
        return this.planStatus;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getApplyModel() {
        return this.applyModel;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getRunScene() {
        return this.runScene;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getTouchCheckType() {
        return this.touchCheckType;
    }

    @NotNull
    public final RunPlanBean copy(@NotNull String runPlanCode, @NotNull String runPlanName, int planStatus, @NotNull String applyModel, int runScene, int touchCheckType) {
        Intrinsics.checkNotNullParameter(runPlanCode, "runPlanCode");
        Intrinsics.checkNotNullParameter(runPlanName, "runPlanName");
        Intrinsics.checkNotNullParameter(applyModel, "applyModel");
        return new RunPlanBean(runPlanCode, runPlanName, planStatus, applyModel, runScene, touchCheckType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RunPlanBean)) {
            return false;
        }
        RunPlanBean runPlanBean = (RunPlanBean) other;
        return Intrinsics.areEqual(this.runPlanCode, runPlanBean.runPlanCode) && Intrinsics.areEqual(this.runPlanName, runPlanBean.runPlanName) && this.planStatus == runPlanBean.planStatus && Intrinsics.areEqual(this.applyModel, runPlanBean.applyModel) && this.runScene == runPlanBean.runScene && this.touchCheckType == runPlanBean.touchCheckType;
    }

    @NotNull
    public final String getApplyModel() {
        return this.applyModel;
    }

    public final int getPlanStatus() {
        return this.planStatus;
    }

    @NotNull
    public final String getRunPlanCode() {
        return this.runPlanCode;
    }

    @NotNull
    public final String getRunPlanName() {
        return this.runPlanName;
    }

    public final int getRunScene() {
        return this.runScene;
    }

    public final int getTouchCheckType() {
        return this.touchCheckType;
    }

    public int hashCode() {
        return (((((((((this.runPlanCode.hashCode() * 31) + this.runPlanName.hashCode()) * 31) + Integer.hashCode(this.planStatus)) * 31) + this.applyModel.hashCode()) * 31) + Integer.hashCode(this.runScene)) * 31) + Integer.hashCode(this.touchCheckType);
    }

    @NotNull
    public String toString() {
        return "RunPlanBean(runPlanCode=" + this.runPlanCode + ", runPlanName=" + this.runPlanName + ", planStatus=" + this.planStatus + ", applyModel=" + this.applyModel + ", runScene=" + this.runScene + ", touchCheckType=" + this.touchCheckType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.runPlanCode);
        parcel.writeString(this.runPlanName);
        parcel.writeInt(this.planStatus);
        parcel.writeString(this.applyModel);
        parcel.writeInt(this.runScene);
        parcel.writeInt(this.touchCheckType);
    }

    public /* synthetic */ RunPlanBean(String str, String str2, int i, String str3, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? "" : str2, (i4 & 4) != 0 ? 0 : i, (i4 & 8) == 0 ? str3 : "", (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? 0 : i3);
    }
}
