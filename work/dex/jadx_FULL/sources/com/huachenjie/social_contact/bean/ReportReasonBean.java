package com.huachenjie.social_contact.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006 "}, d2 = {"Lcom/huachenjie/social_contact/bean/ReportReasonBean;", "Landroid/os/Parcelable;", MediationConstant.KEY_REASON, "", "code", "", "selected", "", "(Ljava/lang/String;IZ)V", "getCode", "()I", "getReason", "()Ljava/lang/String;", "getSelected", "()Z", "setSelected", "(Z)V", "component1", "component2", "component3", OperatePopupWindow.g, "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ReportReasonBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<ReportReasonBean> CREATOR = new Creator();
    private final int code;

    @NotNull
    private final String reason;
    private boolean selected;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ReportReasonBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ReportReasonBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ReportReasonBean(parcel.readString(), parcel.readInt(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ReportReasonBean[] newArray(int i) {
            return new ReportReasonBean[i];
        }
    }

    public ReportReasonBean(@NotNull String str, int i, boolean z) {
        Intrinsics.checkNotNullParameter(str, MediationConstant.KEY_REASON);
        this.reason = str;
        this.code = i;
        this.selected = z;
    }

    public static /* synthetic */ ReportReasonBean copy$default(ReportReasonBean reportReasonBean, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = reportReasonBean.reason;
        }
        if ((i2 & 2) != 0) {
            i = reportReasonBean.code;
        }
        if ((i2 & 4) != 0) {
            z = reportReasonBean.selected;
        }
        return reportReasonBean.copy(str, i, z);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    @NotNull
    public final ReportReasonBean copy(@NotNull String reason, int code, boolean selected) {
        Intrinsics.checkNotNullParameter(reason, MediationConstant.KEY_REASON);
        return new ReportReasonBean(reason, code, selected);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReportReasonBean)) {
            return false;
        }
        ReportReasonBean reportReasonBean = (ReportReasonBean) other;
        return Intrinsics.areEqual(this.reason, reportReasonBean.reason) && this.code == reportReasonBean.code && this.selected == reportReasonBean.selected;
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getReason() {
        return this.reason;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int iHashCode = ((this.reason.hashCode() * 31) + Integer.hashCode(this.code)) * 31;
        boolean z = this.selected;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final void setSelected(boolean z) {
        this.selected = z;
    }

    @NotNull
    public String toString() {
        return "ReportReasonBean(reason=" + this.reason + ", code=" + this.code + ", selected=" + this.selected + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.reason);
        parcel.writeInt(this.code);
        parcel.writeInt(this.selected ? 1 : 0);
    }
}
