package com.huachenjie.channel.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.channel.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Parcelize
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\u0006\u0010\u001f\u001a\u00020\u001bJ\t\u0010 \u001a\u00020\u001bHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000b\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\u000e¨\u0006'"}, d2 = {"Lcom/huachenjie/channel/bean/TopicTeamMemberBean;", "Landroid/os/Parcelable;", "name", "", "avatar", "accId", "isOwner", "", "isSelect", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getAccId", "()Ljava/lang/String;", "getAvatar", "setAvatar", "(Ljava/lang/String;)V", "()Z", "setSelect", "(Z)V", "getName", "setName", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "describeContents", "", "equals", "other", "", "formatCheckIcon", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TopicTeamMemberBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<TopicTeamMemberBean> CREATOR = new Creator();

    @NotNull
    private final String accId;

    @NotNull
    private String avatar;
    private final boolean isOwner;
    private boolean isSelect;

    @NotNull
    private String name;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TopicTeamMemberBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TopicTeamMemberBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TopicTeamMemberBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TopicTeamMemberBean[] newArray(int i) {
            return new TopicTeamMemberBean[i];
        }
    }

    public TopicTeamMemberBean() {
        this(null, null, null, false, false, 31, null);
    }

    public TopicTeamMemberBean(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "avatar");
        Intrinsics.checkNotNullParameter(str3, "accId");
        this.name = str;
        this.avatar = str2;
        this.accId = str3;
        this.isOwner = z;
        this.isSelect = z2;
    }

    public static /* synthetic */ TopicTeamMemberBean copy$default(TopicTeamMemberBean topicTeamMemberBean, String str, String str2, String str3, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = topicTeamMemberBean.name;
        }
        if ((i & 2) != 0) {
            str2 = topicTeamMemberBean.avatar;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = topicTeamMemberBean.accId;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            z = topicTeamMemberBean.isOwner;
        }
        boolean z3 = z;
        if ((i & 16) != 0) {
            z2 = topicTeamMemberBean.isSelect;
        }
        return topicTeamMemberBean.copy(str, str4, str5, z3, z2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAccId() {
        return this.accId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsOwner() {
        return this.isOwner;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    @NotNull
    public final TopicTeamMemberBean copy(@NotNull String name, @NotNull String avatar, @NotNull String accId, boolean isOwner, boolean isSelect) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(accId, "accId");
        return new TopicTeamMemberBean(name, avatar, accId, isOwner, isSelect);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TopicTeamMemberBean)) {
            return false;
        }
        TopicTeamMemberBean topicTeamMemberBean = (TopicTeamMemberBean) other;
        return Intrinsics.areEqual(this.name, topicTeamMemberBean.name) && Intrinsics.areEqual(this.avatar, topicTeamMemberBean.avatar) && Intrinsics.areEqual(this.accId, topicTeamMemberBean.accId) && this.isOwner == topicTeamMemberBean.isOwner && this.isSelect == topicTeamMemberBean.isSelect;
    }

    public final int formatCheckIcon() {
        if (this.isOwner) {
            return R.drawable.ic_team_member_normal;
        }
        return this.isSelect ? R.drawable.ic_team_member_checked : R.drawable.ic_team_member_uncheck;
    }

    @NotNull
    public final String getAccId() {
        return this.accId;
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((this.name.hashCode() * 31) + this.avatar.hashCode()) * 31) + this.accId.hashCode()) * 31;
        boolean z = this.isOwner;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.isSelect;
        return i + (z2 ? 1 : z2);
    }

    public final boolean isOwner() {
        return this.isOwner;
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setAvatar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.avatar = str;
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setSelect(boolean z) {
        this.isSelect = z;
    }

    @NotNull
    public String toString() {
        return "TopicTeamMemberBean(name=" + this.name + ", avatar=" + this.avatar + ", accId=" + this.accId + ", isOwner=" + this.isOwner + ", isSelect=" + this.isSelect + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.name);
        parcel.writeString(this.avatar);
        parcel.writeString(this.accId);
        parcel.writeInt(this.isOwner ? 1 : 0);
        parcel.writeInt(this.isSelect ? 1 : 0);
    }

    public /* synthetic */ TopicTeamMemberBean(String str, String str2, String str3, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) == 0 ? str3 : "", (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2);
    }
}
