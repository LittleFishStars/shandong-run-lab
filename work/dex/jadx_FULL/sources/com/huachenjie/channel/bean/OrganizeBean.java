package com.huachenjie.channel.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.chad.library.adapter.base.entity.node.BaseExpandNode;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002Bo\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b¢\u0006\u0002\u0010\u0011J\t\u0010)\u001a\u00020\u0004HÆ\u0003J\t\u0010*\u001a\u00020\u0004HÆ\u0003J\t\u0010+\u001a\u00020\u0004HÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\t\u0010-\u001a\u00020\u0004HÆ\u0003J\t\u0010.\u001a\u00020\bHÆ\u0003J\t\u0010/\u001a\u00020\u0004HÆ\u0003J\u0019\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fHÆ\u0003J\t\u00101\u001a\u00020\bHÆ\u0003Js\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\bHÆ\u0001J\t\u00103\u001a\u00020\bHÖ\u0001J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\u0006\u00108\u001a\u00020\u0004J\u0006\u00109\u001a\u00020\u0004J\u0006\u0010:\u001a\u00020\u0004J\t\u0010;\u001a\u00020\bHÖ\u0001J\t\u0010<\u001a\u00020\u0004HÖ\u0001J\u0019\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\bHÖ\u0001R*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138VX\u0096\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0011\u0010\u0010\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"¨\u0006B"}, d2 = {"Lcom/huachenjie/channel/bean/OrganizeBean;", "Landroid/os/Parcelable;", "Lcom/chad/library/adapter/base/entity/node/BaseExpandNode;", "clubName", "", "clubCode", "coverUrl", "userCount", "", "clubAdminUserCode", "teamCount", "clubDescription", "clubTeamList", "Ljava/util/ArrayList;", "Lcom/huachenjie/channel/bean/OrganizeTeamBean;", "Lkotlin/collections/ArrayList;", "clubMessageCount", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/util/ArrayList;I)V", "childNode", "", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "getChildNode$annotations", "()V", "getChildNode", "()Ljava/util/List;", "setChildNode", "(Ljava/util/List;)V", "getClubAdminUserCode", "()Ljava/lang/String;", "setClubAdminUserCode", "(Ljava/lang/String;)V", "getClubCode", "getClubDescription", "getClubMessageCount", "()I", "getClubName", "getClubTeamList", "()Ljava/util/ArrayList;", "getCoverUrl", "getTeamCount", "getUserCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "formatMessageCount", "formatTeamGroup", "formatUserCount", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class OrganizeBean extends BaseExpandNode implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<OrganizeBean> CREATOR = new Creator();

    @Nullable
    private List<BaseNode> childNode;

    @NotNull
    private String clubAdminUserCode;

    @NotNull
    private final String clubCode;

    @NotNull
    private final String clubDescription;
    private final int clubMessageCount;

    @NotNull
    private final String clubName;

    @NotNull
    private final ArrayList<OrganizeTeamBean> clubTeamList;

    @NotNull
    private final String coverUrl;
    private final int teamCount;
    private final int userCount;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<OrganizeBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrganizeBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            int i = parcel.readInt();
            String string4 = parcel.readString();
            int i2 = parcel.readInt();
            String string5 = parcel.readString();
            int i3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i3);
            for (int i4 = 0; i4 != i3; i4++) {
                arrayList.add(OrganizeTeamBean.CREATOR.createFromParcel(parcel));
            }
            return new OrganizeBean(string, string2, string3, i, string4, i2, string5, arrayList, parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrganizeBean[] newArray(int i) {
            return new OrganizeBean[i];
        }
    }

    public OrganizeBean() {
        this(null, null, null, 0, null, 0, null, null, 0, 511, null);
    }

    public /* synthetic */ OrganizeBean(String str, String str2, String str3, int i, String str4, int i2, String str5, ArrayList arrayList, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? "" : str2, (i4 & 4) != 0 ? "" : str3, (i4 & 8) != 0 ? 0 : i, (i4 & 16) != 0 ? "" : str4, (i4 & 32) != 0 ? 0 : i2, (i4 & 64) == 0 ? str5 : "", (i4 & 128) != 0 ? new ArrayList() : arrayList, (i4 & 256) == 0 ? i3 : 0);
    }

    public static /* synthetic */ void getChildNode$annotations() {
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getClubName() {
        return this.clubName;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getClubCode() {
        return this.clubCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getUserCount() {
        return this.userCount;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getClubAdminUserCode() {
        return this.clubAdminUserCode;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getTeamCount() {
        return this.teamCount;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getClubDescription() {
        return this.clubDescription;
    }

    @NotNull
    public final ArrayList<OrganizeTeamBean> component8() {
        return this.clubTeamList;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getClubMessageCount() {
        return this.clubMessageCount;
    }

    @NotNull
    public final OrganizeBean copy(@NotNull String clubName, @NotNull String clubCode, @NotNull String coverUrl, int userCount, @NotNull String clubAdminUserCode, int teamCount, @NotNull String clubDescription, @NotNull ArrayList<OrganizeTeamBean> clubTeamList, int clubMessageCount) {
        Intrinsics.checkNotNullParameter(clubName, "clubName");
        Intrinsics.checkNotNullParameter(clubCode, "clubCode");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(clubAdminUserCode, "clubAdminUserCode");
        Intrinsics.checkNotNullParameter(clubDescription, "clubDescription");
        Intrinsics.checkNotNullParameter(clubTeamList, "clubTeamList");
        return new OrganizeBean(clubName, clubCode, coverUrl, userCount, clubAdminUserCode, teamCount, clubDescription, clubTeamList, clubMessageCount);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrganizeBean)) {
            return false;
        }
        OrganizeBean organizeBean = (OrganizeBean) other;
        return Intrinsics.areEqual(this.clubName, organizeBean.clubName) && Intrinsics.areEqual(this.clubCode, organizeBean.clubCode) && Intrinsics.areEqual(this.coverUrl, organizeBean.coverUrl) && this.userCount == organizeBean.userCount && Intrinsics.areEqual(this.clubAdminUserCode, organizeBean.clubAdminUserCode) && this.teamCount == organizeBean.teamCount && Intrinsics.areEqual(this.clubDescription, organizeBean.clubDescription) && Intrinsics.areEqual(this.clubTeamList, organizeBean.clubTeamList) && this.clubMessageCount == organizeBean.clubMessageCount;
    }

    @NotNull
    public final String formatMessageCount() {
        return String.valueOf(this.clubMessageCount);
    }

    @NotNull
    public final String formatTeamGroup() {
        return "社群 (" + this.clubTeamList.size() + ')';
    }

    @NotNull
    public final String formatUserCount() {
        return String.valueOf(this.userCount);
    }

    @Override // com.chad.library.adapter.base.entity.node.BaseNode
    @Nullable
    public List<BaseNode> getChildNode() {
        if (this.childNode == null) {
            this.childNode = CollectionsKt.toMutableList(this.clubTeamList);
        }
        return this.childNode;
    }

    @NotNull
    public final String getClubAdminUserCode() {
        return this.clubAdminUserCode;
    }

    @NotNull
    public final String getClubCode() {
        return this.clubCode;
    }

    @NotNull
    public final String getClubDescription() {
        return this.clubDescription;
    }

    public final int getClubMessageCount() {
        return this.clubMessageCount;
    }

    @NotNull
    public final String getClubName() {
        return this.clubName;
    }

    @NotNull
    public final ArrayList<OrganizeTeamBean> getClubTeamList() {
        return this.clubTeamList;
    }

    @NotNull
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final int getTeamCount() {
        return this.teamCount;
    }

    public final int getUserCount() {
        return this.userCount;
    }

    public int hashCode() {
        return (((((((((((((((this.clubName.hashCode() * 31) + this.clubCode.hashCode()) * 31) + this.coverUrl.hashCode()) * 31) + Integer.hashCode(this.userCount)) * 31) + this.clubAdminUserCode.hashCode()) * 31) + Integer.hashCode(this.teamCount)) * 31) + this.clubDescription.hashCode()) * 31) + this.clubTeamList.hashCode()) * 31) + Integer.hashCode(this.clubMessageCount);
    }

    public void setChildNode(@Nullable List<BaseNode> list) {
        this.childNode = list;
    }

    public final void setClubAdminUserCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.clubAdminUserCode = str;
    }

    @NotNull
    public String toString() {
        return "OrganizeBean(clubName=" + this.clubName + ", clubCode=" + this.clubCode + ", coverUrl=" + this.coverUrl + ", userCount=" + this.userCount + ", clubAdminUserCode=" + this.clubAdminUserCode + ", teamCount=" + this.teamCount + ", clubDescription=" + this.clubDescription + ", clubTeamList=" + this.clubTeamList + ", clubMessageCount=" + this.clubMessageCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.clubName);
        parcel.writeString(this.clubCode);
        parcel.writeString(this.coverUrl);
        parcel.writeInt(this.userCount);
        parcel.writeString(this.clubAdminUserCode);
        parcel.writeInt(this.teamCount);
        parcel.writeString(this.clubDescription);
        ArrayList<OrganizeTeamBean> arrayList = this.clubTeamList;
        parcel.writeInt(arrayList.size());
        Iterator<OrganizeTeamBean> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.clubMessageCount);
    }

    public OrganizeBean(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, @NotNull String str4, int i2, @NotNull String str5, @NotNull ArrayList<OrganizeTeamBean> arrayList, int i3) {
        Intrinsics.checkNotNullParameter(str, "clubName");
        Intrinsics.checkNotNullParameter(str2, "clubCode");
        Intrinsics.checkNotNullParameter(str3, "coverUrl");
        Intrinsics.checkNotNullParameter(str4, "clubAdminUserCode");
        Intrinsics.checkNotNullParameter(str5, "clubDescription");
        Intrinsics.checkNotNullParameter(arrayList, "clubTeamList");
        this.clubName = str;
        this.clubCode = str2;
        this.coverUrl = str3;
        this.userCount = i;
        this.clubAdminUserCode = str4;
        this.teamCount = i2;
        this.clubDescription = str5;
        this.clubTeamList = arrayList;
        this.clubMessageCount = i3;
    }
}
