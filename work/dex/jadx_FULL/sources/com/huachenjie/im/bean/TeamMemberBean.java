package com.huachenjie.im.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.im.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010$\u001a\u00020\fHÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003Jv\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\n2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010*\u001a\u00020+J\t\u0010,\u001a\u00020+HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\t\u0010\u0014R\u001a\u0010\r\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010¨\u0006."}, d2 = {"Lcom/huachenjie/im/bean/TeamMemberBean;", "", "accId", "", "name", "avatar", "appUserCode", "avatarFrameImgUrl", "teamNick", "isOwner", "", "joinTime", "", "isSelect", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;JZ)V", "getAccId", "()Ljava/lang/String;", "getAppUserCode", "getAvatar", "getAvatarFrameImgUrl", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "()Z", "setSelect", "(Z)V", "getJoinTime", "()J", "getName", "getTeamNick", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;JZ)Lcom/huachenjie/im/bean/TeamMemberBean;", "equals", "other", "formatCheckIcon", "", "hashCode", "toString", "IM_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TeamMemberBean {

    @Nullable
    private final String accId;

    @Nullable
    private final String appUserCode;

    @Nullable
    private final String avatar;

    @Nullable
    private final String avatarFrameImgUrl;

    @Nullable
    private final Boolean isOwner;
    private boolean isSelect;
    private final long joinTime;

    @Nullable
    private final String name;

    @Nullable
    private final String teamNick;

    public TeamMemberBean() {
        this(null, null, null, null, null, null, null, 0L, false, 511, null);
    }

    public TeamMemberBean(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Boolean bool, long j, boolean z) {
        this.accId = str;
        this.name = str2;
        this.avatar = str3;
        this.appUserCode = str4;
        this.avatarFrameImgUrl = str5;
        this.teamNick = str6;
        this.isOwner = bool;
        this.joinTime = j;
        this.isSelect = z;
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAccId() {
        return this.accId;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAppUserCode() {
        return this.appUserCode;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getTeamNick() {
        return this.teamNick;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Boolean getIsOwner() {
        return this.isOwner;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getJoinTime() {
        return this.joinTime;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    @NotNull
    public final TeamMemberBean copy(@Nullable String accId, @Nullable String name, @Nullable String avatar, @Nullable String appUserCode, @Nullable String avatarFrameImgUrl, @Nullable String teamNick, @Nullable Boolean isOwner, long joinTime, boolean isSelect) {
        return new TeamMemberBean(accId, name, avatar, appUserCode, avatarFrameImgUrl, teamNick, isOwner, joinTime, isSelect);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TeamMemberBean)) {
            return false;
        }
        TeamMemberBean teamMemberBean = (TeamMemberBean) other;
        return Intrinsics.areEqual(this.accId, teamMemberBean.accId) && Intrinsics.areEqual(this.name, teamMemberBean.name) && Intrinsics.areEqual(this.avatar, teamMemberBean.avatar) && Intrinsics.areEqual(this.appUserCode, teamMemberBean.appUserCode) && Intrinsics.areEqual(this.avatarFrameImgUrl, teamMemberBean.avatarFrameImgUrl) && Intrinsics.areEqual(this.teamNick, teamMemberBean.teamNick) && Intrinsics.areEqual(this.isOwner, teamMemberBean.isOwner) && this.joinTime == teamMemberBean.joinTime && this.isSelect == teamMemberBean.isSelect;
    }

    public final int formatCheckIcon() {
        if (Intrinsics.areEqual(this.isOwner, Boolean.TRUE)) {
            return R.drawable.ic_team_member_normal;
        }
        return this.isSelect ? R.drawable.ic_team_member_checked : R.drawable.ic_team_member_uncheck;
    }

    @Nullable
    public final String getAccId() {
        return this.accId;
    }

    @Nullable
    public final String getAppUserCode() {
        return this.appUserCode;
    }

    @Nullable
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    public final long getJoinTime() {
        return this.joinTime;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getTeamNick() {
        return this.teamNick;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public int hashCode() {
        String str = this.accId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.avatar;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.appUserCode;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.avatarFrameImgUrl;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.teamNick;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Boolean bool = this.isOwner;
        int iHashCode7 = (((iHashCode6 + (bool != null ? bool.hashCode() : 0)) * 31) + Long.hashCode(this.joinTime)) * 31;
        boolean z = this.isSelect;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode7 + r1;
    }

    @Nullable
    public final Boolean isOwner() {
        return this.isOwner;
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setSelect(boolean z) {
        this.isSelect = z;
    }

    @NotNull
    public String toString() {
        return "TeamMemberBean(accId=" + this.accId + ", name=" + this.name + ", avatar=" + this.avatar + ", appUserCode=" + this.appUserCode + ", avatarFrameImgUrl=" + this.avatarFrameImgUrl + ", teamNick=" + this.teamNick + ", isOwner=" + this.isOwner + ", joinTime=" + this.joinTime + ", isSelect=" + this.isSelect + ')';
    }

    public /* synthetic */ TeamMemberBean(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, long j, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) == 0 ? str6 : "", (i & 64) != 0 ? Boolean.FALSE : bool, (i & 128) != 0 ? 0L : j, (i & 256) != 0 ? false : z);
    }
}
