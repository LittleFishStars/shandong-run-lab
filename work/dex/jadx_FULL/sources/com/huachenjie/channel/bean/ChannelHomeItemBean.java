package com.huachenjie.channel.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.channel.R;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u000ej\b\u0012\u0004\u0012\u00020\u0005`\u000f\u0012\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u000ej\b\u0012\u0004\u0012\u00020\u0005`\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003¢\u0006\u0002\u0010\u0013J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u0019\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u000ej\b\u0012\u0004\u0012\u00020\u0005`\u000fHÆ\u0003J\t\u0010-\u001a\u00020\u000bHÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u000bHÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\u0019\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u000ej\b\u0012\u0004\u0012\u00020\u0005`\u000fHÆ\u0003J¡\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u000ej\b\u0012\u0004\u0012\u00020\u0005`\u000f2\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u000ej\b\u0012\u0004\u0012\u00020\u0005`\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u0003HÆ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001J\u0013\u00109\u001a\u00020\u000b2\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\u0006\u0010<\u001a\u00020\u0003J\u0006\u0010=\u001a\u00020\u0005J\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00050?J\u0006\u0010@\u001a\u00020\u0005J\t\u0010A\u001a\u00020\u0003HÖ\u0001J\u0006\u0010B\u001a\u00020\u000bJ\u0006\u0010C\u001a\u00020\u000bJ\t\u0010D\u001a\u00020\u0005HÖ\u0001J\u0019\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR!\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u000ej\b\u0012\u0004\u0012\u00020\u0005`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010$R\u001a\u0010\u0011\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010'R!\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u000ej\b\u0012\u0004\u0012\u00020\u0005`\u000f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010\u001c¨\u0006J"}, d2 = {"Lcom/huachenjie/channel/bean/ChannelHomeItemBean;", "Landroid/os/Parcelable;", "channelType", "", "logo", "", "channelName", "channelNo", "channelStatus", "failReason", "certificationFlag", "", RemoteMessageConst.Notification.ICON, "subjectTeamIdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "clubTeamIdList", "selected", "unreadCount", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZILjava/util/ArrayList;Ljava/util/ArrayList;ZI)V", "getCertificationFlag", "()Z", "getChannelName", "()Ljava/lang/String;", "getChannelNo", "getChannelStatus", "()I", "setChannelStatus", "(I)V", "getChannelType", "getClubTeamIdList", "()Ljava/util/ArrayList;", "getFailReason", "getIcon", "getLogo", "setLogo", "(Ljava/lang/String;)V", "getSelected", "setSelected", "(Z)V", "getSubjectTeamIdList", "getUnreadCount", "setUnreadCount", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "equals", "other", "", "formatOfficeIcon", "formatReviewText", "formatTeamIdList", "", "formatterUnreadCount", "hashCode", "showOfficeIcon", "showReviewStatus", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ChannelHomeItemBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<ChannelHomeItemBean> CREATOR = new Creator();
    private final boolean certificationFlag;

    @NotNull
    private final String channelName;

    @NotNull
    private final String channelNo;
    private int channelStatus;
    private final int channelType;

    @NotNull
    private final ArrayList<String> clubTeamIdList;

    @NotNull
    private final String failReason;
    private final int icon;

    @NotNull
    private String logo;
    private boolean selected;

    @NotNull
    private final ArrayList<String> subjectTeamIdList;
    private int unreadCount;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ChannelHomeItemBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ChannelHomeItemBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ChannelHomeItemBean(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.createStringArrayList(), parcel.createStringArrayList(), parcel.readInt() != 0, parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ChannelHomeItemBean[] newArray(int i) {
            return new ChannelHomeItemBean[i];
        }
    }

    public ChannelHomeItemBean() {
        this(0, null, null, null, 0, null, false, 0, null, null, false, 0, 4095, null);
    }

    public ChannelHomeItemBean(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, int i2, @NotNull String str4, boolean z, int i3, @NotNull ArrayList<String> arrayList, @NotNull ArrayList<String> arrayList2, boolean z2, int i4) {
        Intrinsics.checkNotNullParameter(str, "logo");
        Intrinsics.checkNotNullParameter(str2, "channelName");
        Intrinsics.checkNotNullParameter(str3, "channelNo");
        Intrinsics.checkNotNullParameter(str4, "failReason");
        Intrinsics.checkNotNullParameter(arrayList, "subjectTeamIdList");
        Intrinsics.checkNotNullParameter(arrayList2, "clubTeamIdList");
        this.channelType = i;
        this.logo = str;
        this.channelName = str2;
        this.channelNo = str3;
        this.channelStatus = i2;
        this.failReason = str4;
        this.certificationFlag = z;
        this.icon = i3;
        this.subjectTeamIdList = arrayList;
        this.clubTeamIdList = arrayList2;
        this.selected = z2;
        this.unreadCount = i4;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getChannelType() {
        return this.channelType;
    }

    @NotNull
    public final ArrayList<String> component10() {
        return this.clubTeamIdList;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getUnreadCount() {
        return this.unreadCount;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLogo() {
        return this.logo;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getChannelNo() {
        return this.channelNo;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getChannelStatus() {
        return this.channelStatus;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getFailReason() {
        return this.failReason;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getCertificationFlag() {
        return this.certificationFlag;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getIcon() {
        return this.icon;
    }

    @NotNull
    public final ArrayList<String> component9() {
        return this.subjectTeamIdList;
    }

    @NotNull
    public final ChannelHomeItemBean copy(int channelType, @NotNull String logo, @NotNull String channelName, @NotNull String channelNo, int channelStatus, @NotNull String failReason, boolean certificationFlag, int icon, @NotNull ArrayList<String> subjectTeamIdList, @NotNull ArrayList<String> clubTeamIdList, boolean selected, int unreadCount) {
        Intrinsics.checkNotNullParameter(logo, "logo");
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        Intrinsics.checkNotNullParameter(failReason, "failReason");
        Intrinsics.checkNotNullParameter(subjectTeamIdList, "subjectTeamIdList");
        Intrinsics.checkNotNullParameter(clubTeamIdList, "clubTeamIdList");
        return new ChannelHomeItemBean(channelType, logo, channelName, channelNo, channelStatus, failReason, certificationFlag, icon, subjectTeamIdList, clubTeamIdList, selected, unreadCount);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelHomeItemBean)) {
            return false;
        }
        ChannelHomeItemBean channelHomeItemBean = (ChannelHomeItemBean) other;
        return this.channelType == channelHomeItemBean.channelType && Intrinsics.areEqual(this.logo, channelHomeItemBean.logo) && Intrinsics.areEqual(this.channelName, channelHomeItemBean.channelName) && Intrinsics.areEqual(this.channelNo, channelHomeItemBean.channelNo) && this.channelStatus == channelHomeItemBean.channelStatus && Intrinsics.areEqual(this.failReason, channelHomeItemBean.failReason) && this.certificationFlag == channelHomeItemBean.certificationFlag && this.icon == channelHomeItemBean.icon && Intrinsics.areEqual(this.subjectTeamIdList, channelHomeItemBean.subjectTeamIdList) && Intrinsics.areEqual(this.clubTeamIdList, channelHomeItemBean.clubTeamIdList) && this.selected == channelHomeItemBean.selected && this.unreadCount == channelHomeItemBean.unreadCount;
    }

    public final int formatOfficeIcon() {
        return R.drawable.channel_bg_official_certification_tag;
    }

    @NotNull
    public final String formatReviewText() {
        int i = this.channelStatus;
        if (i != 1) {
            return i != 3 ? "" : "未通过";
        }
        return "审核中";
    }

    @NotNull
    public final List<String> formatTeamIdList() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.subjectTeamIdList);
        arrayList.addAll(this.clubTeamIdList);
        return arrayList;
    }

    @NotNull
    public final String formatterUnreadCount() {
        int i = this.unreadCount;
        return i > 99 ? "99+" : String.valueOf(i);
    }

    public final boolean getCertificationFlag() {
        return this.certificationFlag;
    }

    @NotNull
    public final String getChannelName() {
        return this.channelName;
    }

    @NotNull
    public final String getChannelNo() {
        return this.channelNo;
    }

    public final int getChannelStatus() {
        return this.channelStatus;
    }

    public final int getChannelType() {
        return this.channelType;
    }

    @NotNull
    public final ArrayList<String> getClubTeamIdList() {
        return this.clubTeamIdList;
    }

    @NotNull
    public final String getFailReason() {
        return this.failReason;
    }

    public final int getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getLogo() {
        return this.logo;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    @NotNull
    public final ArrayList<String> getSubjectTeamIdList() {
        return this.subjectTeamIdList;
    }

    public final int getUnreadCount() {
        return this.unreadCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((((Integer.hashCode(this.channelType) * 31) + this.logo.hashCode()) * 31) + this.channelName.hashCode()) * 31) + this.channelNo.hashCode()) * 31) + Integer.hashCode(this.channelStatus)) * 31) + this.failReason.hashCode()) * 31;
        boolean z = this.certificationFlag;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((((((iHashCode + r1) * 31) + Integer.hashCode(this.icon)) * 31) + this.subjectTeamIdList.hashCode()) * 31) + this.clubTeamIdList.hashCode()) * 31;
        boolean z2 = this.selected;
        return ((iHashCode2 + (z2 ? 1 : z2)) * 31) + Integer.hashCode(this.unreadCount);
    }

    public final void setChannelStatus(int i) {
        this.channelStatus = i;
    }

    public final void setLogo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.logo = str;
    }

    public final void setSelected(boolean z) {
        this.selected = z;
    }

    public final void setUnreadCount(int i) {
        this.unreadCount = i;
    }

    public final boolean showOfficeIcon() {
        int i = this.channelType;
        return i == 1 || i == 2 || i == 3 || this.certificationFlag;
    }

    public final boolean showReviewStatus() {
        int i = this.channelStatus;
        return i == 1 || i == 3;
    }

    @NotNull
    public String toString() {
        return "ChannelHomeItemBean(channelType=" + this.channelType + ", logo=" + this.logo + ", channelName=" + this.channelName + ", channelNo=" + this.channelNo + ", channelStatus=" + this.channelStatus + ", failReason=" + this.failReason + ", certificationFlag=" + this.certificationFlag + ", icon=" + this.icon + ", subjectTeamIdList=" + this.subjectTeamIdList + ", clubTeamIdList=" + this.clubTeamIdList + ", selected=" + this.selected + ", unreadCount=" + this.unreadCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.channelType);
        parcel.writeString(this.logo);
        parcel.writeString(this.channelName);
        parcel.writeString(this.channelNo);
        parcel.writeInt(this.channelStatus);
        parcel.writeString(this.failReason);
        parcel.writeInt(this.certificationFlag ? 1 : 0);
        parcel.writeInt(this.icon);
        parcel.writeStringList(this.subjectTeamIdList);
        parcel.writeStringList(this.clubTeamIdList);
        parcel.writeInt(this.selected ? 1 : 0);
        parcel.writeInt(this.unreadCount);
    }

    public /* synthetic */ ChannelHomeItemBean(int i, String str, String str2, String str3, int i2, String str4, boolean z, int i3, ArrayList arrayList, ArrayList arrayList2, boolean z2, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? "" : str, (i5 & 4) != 0 ? "" : str2, (i5 & 8) != 0 ? "" : str3, (i5 & 16) != 0 ? 0 : i2, (i5 & 32) == 0 ? str4 : "", (i5 & 64) != 0 ? false : z, (i5 & 128) != 0 ? 0 : i3, (i5 & 256) != 0 ? new ArrayList() : arrayList, (i5 & 512) != 0 ? new ArrayList() : arrayList2, (i5 & 1024) != 0 ? false : z2, (i5 & 2048) == 0 ? i4 : 0);
    }
}
