package com.huachenjie.channel.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.channel.page.team_member_manage.TeamMemberManageActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0004HÆ\u0003J\t\u0010 \u001a\u00020\u0004HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\u0004HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003JE\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\t\u0010%\u001a\u00020\bHÖ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\bHÖ\u0001J\t\u0010+\u001a\u00020\u0004HÖ\u0001J\u0019\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\bHÖ\u0001R\u001c\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013¨\u00061"}, d2 = {"Lcom/huachenjie/channel/bean/OrganizeTeamBean;", "Landroid/os/Parcelable;", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "teamId", "", TeamMemberManageActivity.C, "teamTitle", "teamCount", "", "message", "messageCount", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)V", "childNode", "", "getChildNode", "()Ljava/util/List;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getMessageCount", "()I", "setMessageCount", "(I)V", "getTeamCode", "getTeamCount", "setTeamCount", "getTeamId", "getTeamTitle", "setTeamTitle", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class OrganizeTeamBean extends BaseNode implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<OrganizeTeamBean> CREATOR = new Creator();

    @NotNull
    private String message;
    private int messageCount;

    @NotNull
    private final String teamCode;
    private int teamCount;

    @NotNull
    private final String teamId;

    @NotNull
    private String teamTitle;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<OrganizeTeamBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrganizeTeamBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new OrganizeTeamBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrganizeTeamBean[] newArray(int i) {
            return new OrganizeTeamBean[i];
        }
    }

    public OrganizeTeamBean() {
        this(null, null, null, 0, null, 0, 63, null);
    }

    public /* synthetic */ OrganizeTeamBean(String str, String str2, String str3, int i, String str4, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? 0 : i, (i3 & 16) == 0 ? str4 : "", (i3 & 32) != 0 ? 0 : i2);
    }

    public static /* synthetic */ OrganizeTeamBean copy$default(OrganizeTeamBean organizeTeamBean, String str, String str2, String str3, int i, String str4, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = organizeTeamBean.teamId;
        }
        if ((i3 & 2) != 0) {
            str2 = organizeTeamBean.teamCode;
        }
        String str5 = str2;
        if ((i3 & 4) != 0) {
            str3 = organizeTeamBean.teamTitle;
        }
        String str6 = str3;
        if ((i3 & 8) != 0) {
            i = organizeTeamBean.teamCount;
        }
        int i4 = i;
        if ((i3 & 16) != 0) {
            str4 = organizeTeamBean.message;
        }
        String str7 = str4;
        if ((i3 & 32) != 0) {
            i2 = organizeTeamBean.messageCount;
        }
        return organizeTeamBean.copy(str, str5, str6, i4, str7, i2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTeamId() {
        return this.teamId;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTeamCode() {
        return this.teamCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTeamTitle() {
        return this.teamTitle;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getTeamCount() {
        return this.teamCount;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getMessageCount() {
        return this.messageCount;
    }

    @NotNull
    public final OrganizeTeamBean copy(@NotNull String teamId, @NotNull String teamCode, @NotNull String teamTitle, int teamCount, @NotNull String message, int messageCount) {
        Intrinsics.checkNotNullParameter(teamId, "teamId");
        Intrinsics.checkNotNullParameter(teamCode, TeamMemberManageActivity.C);
        Intrinsics.checkNotNullParameter(teamTitle, "teamTitle");
        Intrinsics.checkNotNullParameter(message, "message");
        return new OrganizeTeamBean(teamId, teamCode, teamTitle, teamCount, message, messageCount);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrganizeTeamBean)) {
            return false;
        }
        OrganizeTeamBean organizeTeamBean = (OrganizeTeamBean) other;
        return Intrinsics.areEqual(this.teamId, organizeTeamBean.teamId) && Intrinsics.areEqual(this.teamCode, organizeTeamBean.teamCode) && Intrinsics.areEqual(this.teamTitle, organizeTeamBean.teamTitle) && this.teamCount == organizeTeamBean.teamCount && Intrinsics.areEqual(this.message, organizeTeamBean.message) && this.messageCount == organizeTeamBean.messageCount;
    }

    @Override // com.chad.library.adapter.base.entity.node.BaseNode
    @Nullable
    public List<BaseNode> getChildNode() {
        return null;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    public final int getMessageCount() {
        return this.messageCount;
    }

    @NotNull
    public final String getTeamCode() {
        return this.teamCode;
    }

    public final int getTeamCount() {
        return this.teamCount;
    }

    @NotNull
    public final String getTeamId() {
        return this.teamId;
    }

    @NotNull
    public final String getTeamTitle() {
        return this.teamTitle;
    }

    public int hashCode() {
        return (((((((((this.teamId.hashCode() * 31) + this.teamCode.hashCode()) * 31) + this.teamTitle.hashCode()) * 31) + Integer.hashCode(this.teamCount)) * 31) + this.message.hashCode()) * 31) + Integer.hashCode(this.messageCount);
    }

    public final void setMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    public final void setMessageCount(int i) {
        this.messageCount = i;
    }

    public final void setTeamCount(int i) {
        this.teamCount = i;
    }

    public final void setTeamTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.teamTitle = str;
    }

    @NotNull
    public String toString() {
        return "OrganizeTeamBean(teamId=" + this.teamId + ", teamCode=" + this.teamCode + ", teamTitle=" + this.teamTitle + ", teamCount=" + this.teamCount + ", message=" + this.message + ", messageCount=" + this.messageCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.teamId);
        parcel.writeString(this.teamCode);
        parcel.writeString(this.teamTitle);
        parcel.writeInt(this.teamCount);
        parcel.writeString(this.message);
        parcel.writeInt(this.messageCount);
    }

    public OrganizeTeamBean(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, @NotNull String str4, int i2) {
        Intrinsics.checkNotNullParameter(str, "teamId");
        Intrinsics.checkNotNullParameter(str2, TeamMemberManageActivity.C);
        Intrinsics.checkNotNullParameter(str3, "teamTitle");
        Intrinsics.checkNotNullParameter(str4, "message");
        this.teamId = str;
        this.teamCode = str2;
        this.teamTitle = str3;
        this.teamCount = i;
        this.message = str4;
        this.messageCount = i2;
    }
}
