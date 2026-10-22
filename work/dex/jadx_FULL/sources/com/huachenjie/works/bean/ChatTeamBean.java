package com.huachenjie.works.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.channel.page.team_member_manage.TeamMemberManageActivity;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\u0017\u001a\u00020\nHÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\nHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\nHÖ\u0001R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006#"}, d2 = {"Lcom/huachenjie/works/bean/ChatTeamBean;", "Landroid/os/Parcelable;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", TeamMemberManageActivity.C, "", "teamTitle", "logoUrl", "roomId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", CollegeTownItemFragment.ITEM_TYPE, "", "getItemType", "()I", "getLogoUrl", "()Ljava/lang/String;", "getRoomId", "getTeamCode", "getTeamTitle", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ChatTeamBean implements Parcelable, MultiItemEntity {

    @NotNull
    public static final Parcelable.Creator<ChatTeamBean> CREATOR = new Creator();

    @NotNull
    private final String logoUrl;

    @NotNull
    private final String roomId;

    @NotNull
    private final String teamCode;

    @NotNull
    private final String teamTitle;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ChatTeamBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ChatTeamBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ChatTeamBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ChatTeamBean[] newArray(int i) {
            return new ChatTeamBean[i];
        }
    }

    public ChatTeamBean() {
        this(null, null, null, null, 15, null);
    }

    public ChatTeamBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, TeamMemberManageActivity.C);
        Intrinsics.checkNotNullParameter(str2, "teamTitle");
        Intrinsics.checkNotNullParameter(str3, "logoUrl");
        Intrinsics.checkNotNullParameter(str4, "roomId");
        this.teamCode = str;
        this.teamTitle = str2;
        this.logoUrl = str3;
        this.roomId = str4;
    }

    public static /* synthetic */ ChatTeamBean copy$default(ChatTeamBean chatTeamBean, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = chatTeamBean.teamCode;
        }
        if ((i & 2) != 0) {
            str2 = chatTeamBean.teamTitle;
        }
        if ((i & 4) != 0) {
            str3 = chatTeamBean.logoUrl;
        }
        if ((i & 8) != 0) {
            str4 = chatTeamBean.roomId;
        }
        return chatTeamBean.copy(str, str2, str3, str4);
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

    @NotNull
    public final ChatTeamBean copy(@NotNull String teamCode, @NotNull String teamTitle, @NotNull String logoUrl, @NotNull String roomId) {
        Intrinsics.checkNotNullParameter(teamCode, TeamMemberManageActivity.C);
        Intrinsics.checkNotNullParameter(teamTitle, "teamTitle");
        Intrinsics.checkNotNullParameter(logoUrl, "logoUrl");
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        return new ChatTeamBean(teamCode, teamTitle, logoUrl, roomId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatTeamBean)) {
            return false;
        }
        ChatTeamBean chatTeamBean = (ChatTeamBean) other;
        return Intrinsics.areEqual(this.teamCode, chatTeamBean.teamCode) && Intrinsics.areEqual(this.teamTitle, chatTeamBean.teamTitle) && Intrinsics.areEqual(this.logoUrl, chatTeamBean.logoUrl) && Intrinsics.areEqual(this.roomId, chatTeamBean.roomId);
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 0;
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

    @NotNull
    public final String getTeamTitle() {
        return this.teamTitle;
    }

    public int hashCode() {
        return (((((this.teamCode.hashCode() * 31) + this.teamTitle.hashCode()) * 31) + this.logoUrl.hashCode()) * 31) + this.roomId.hashCode();
    }

    @NotNull
    public String toString() {
        return "ChatTeamBean(teamCode=" + this.teamCode + ", teamTitle=" + this.teamTitle + ", logoUrl=" + this.logoUrl + ", roomId=" + this.roomId + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.teamCode);
        parcel.writeString(this.teamTitle);
        parcel.writeString(this.logoUrl);
        parcel.writeString(this.roomId);
    }

    public /* synthetic */ ChatTeamBean(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }
}
