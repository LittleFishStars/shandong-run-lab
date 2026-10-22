package com.huachenjie.channel.bean.my_channel;

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
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\t\u0010!\u001a\u00020\tHÖ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\tHÖ\u0001J\t\u0010'\u001a\u00020\u0004HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\tHÖ\u0001R\u001c\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012¨\u0006-"}, d2 = {"Lcom/huachenjie/channel/bean/my_channel/MyChannelChatTeam;", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "Landroid/os/Parcelable;", TeamMemberManageActivity.C, "", "teamTitle", "logoUrl", "roomId", "teamCount", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "childNode", "", "getChildNode", "()Ljava/util/List;", "getLogoUrl", "()Ljava/lang/String;", "setLogoUrl", "(Ljava/lang/String;)V", "getRoomId", "setRoomId", "getTeamCode", "setTeamCode", "getTeamCount", "()I", "getTeamTitle", "setTeamTitle", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class MyChannelChatTeam extends BaseNode implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<MyChannelChatTeam> CREATOR = new Creator();

    @NotNull
    private String logoUrl;

    @NotNull
    private String roomId;

    @NotNull
    private String teamCode;
    private final int teamCount;

    @NotNull
    private String teamTitle;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MyChannelChatTeam> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MyChannelChatTeam createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MyChannelChatTeam(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MyChannelChatTeam[] newArray(int i) {
            return new MyChannelChatTeam[i];
        }
    }

    public MyChannelChatTeam() {
        this(null, null, null, null, 0, 31, null);
    }

    public /* synthetic */ MyChannelChatTeam(String str, String str2, String str3, String str4, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) == 0 ? str4 : "", (i2 & 16) != 0 ? 0 : i);
    }

    public static /* synthetic */ MyChannelChatTeam copy$default(MyChannelChatTeam myChannelChatTeam, String str, String str2, String str3, String str4, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = myChannelChatTeam.teamCode;
        }
        if ((i2 & 2) != 0) {
            str2 = myChannelChatTeam.teamTitle;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = myChannelChatTeam.logoUrl;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = myChannelChatTeam.roomId;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            i = myChannelChatTeam.teamCount;
        }
        return myChannelChatTeam.copy(str, str5, str6, str7, i);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTeamCode() {
        return this.teamCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTeamTitle() {
        return this.teamTitle;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getTeamCount() {
        return this.teamCount;
    }

    @NotNull
    public final MyChannelChatTeam copy(@NotNull String teamCode, @NotNull String teamTitle, @NotNull String logoUrl, @NotNull String roomId, int teamCount) {
        Intrinsics.checkNotNullParameter(teamCode, TeamMemberManageActivity.C);
        Intrinsics.checkNotNullParameter(teamTitle, "teamTitle");
        Intrinsics.checkNotNullParameter(logoUrl, "logoUrl");
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        return new MyChannelChatTeam(teamCode, teamTitle, logoUrl, roomId, teamCount);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MyChannelChatTeam)) {
            return false;
        }
        MyChannelChatTeam myChannelChatTeam = (MyChannelChatTeam) other;
        return Intrinsics.areEqual(this.teamCode, myChannelChatTeam.teamCode) && Intrinsics.areEqual(this.teamTitle, myChannelChatTeam.teamTitle) && Intrinsics.areEqual(this.logoUrl, myChannelChatTeam.logoUrl) && Intrinsics.areEqual(this.roomId, myChannelChatTeam.roomId) && this.teamCount == myChannelChatTeam.teamCount;
    }

    @Override // com.chad.library.adapter.base.entity.node.BaseNode
    @Nullable
    public List<BaseNode> getChildNode() {
        return null;
    }

    @NotNull
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @NotNull
    public final String getRoomId() {
        return this.roomId;
    }

    @NotNull
    public final String getTeamCode() {
        return this.teamCode;
    }

    public final int getTeamCount() {
        return this.teamCount;
    }

    @NotNull
    public final String getTeamTitle() {
        return this.teamTitle;
    }

    public int hashCode() {
        return (((((((this.teamCode.hashCode() * 31) + this.teamTitle.hashCode()) * 31) + this.logoUrl.hashCode()) * 31) + this.roomId.hashCode()) * 31) + Integer.hashCode(this.teamCount);
    }

    public final void setLogoUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.logoUrl = str;
    }

    public final void setRoomId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.roomId = str;
    }

    public final void setTeamCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.teamCode = str;
    }

    public final void setTeamTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.teamTitle = str;
    }

    @NotNull
    public String toString() {
        return "MyChannelChatTeam(teamCode=" + this.teamCode + ", teamTitle=" + this.teamTitle + ", logoUrl=" + this.logoUrl + ", roomId=" + this.roomId + ", teamCount=" + this.teamCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.teamCode);
        parcel.writeString(this.teamTitle);
        parcel.writeString(this.logoUrl);
        parcel.writeString(this.roomId);
        parcel.writeInt(this.teamCount);
    }

    public MyChannelChatTeam(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i) {
        Intrinsics.checkNotNullParameter(str, TeamMemberManageActivity.C);
        Intrinsics.checkNotNullParameter(str2, "teamTitle");
        Intrinsics.checkNotNullParameter(str3, "logoUrl");
        Intrinsics.checkNotNullParameter(str4, "roomId");
        this.teamCode = str;
        this.teamTitle = str2;
        this.logoUrl = str3;
        this.roomId = str4;
        this.teamCount = i;
    }
}
