package com.huachenjie.channel.external.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.channel.R;
import com.huachenjie.common.constants.UserConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Parcelize
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b%\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n¢\u0006\u0002\u0010\u0010J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\nHÆ\u0003J\u0081\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\nHÆ\u0001J\t\u0010/\u001a\u000200HÖ\u0001J\u0013\u00101\u001a\u00020\n2\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\u0006\u00104\u001a\u00020\u0003J\u0006\u00105\u001a\u00020\u0003J\u0006\u00106\u001a\u00020\u0003J\t\u00107\u001a\u000200HÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001J\u0019\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u000200HÖ\u0001R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012R\u001a\u0010\f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0012¨\u0006>"}, d2 = {"Lcom/huachenjie/channel/external/bean/FansBean;", "Landroid/os/Parcelable;", "avatar", "", "avatarFrameImgUrl", UserConstants.USER_PARAMS.b, "fansUserCode", "followUserCode", "alumniId", "eachFollow", "", RemoteMessageConst.MSGID, "readFlag", "accid", "worksCount", "isAttentionPage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Z)V", "getAccid", "()Ljava/lang/String;", "getAlumniId", "getAvatar", "getAvatarFrameImgUrl", "getEachFollow", "()Z", "setEachFollow", "(Z)V", "getFansUserCode", "getFollowUserCode", "setAttentionPage", "getMsgId", "getNickName", "getReadFlag", "setReadFlag", "getWorksCount", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "", "equals", "other", "", "formatterAlumniId", "formatterUserWorks", "getAppUserCode", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FansBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<FansBean> CREATOR = new Creator();

    @NotNull
    private final String accid;

    @NotNull
    private final String alumniId;

    @NotNull
    private final String avatar;

    @NotNull
    private final String avatarFrameImgUrl;
    private boolean eachFollow;

    @NotNull
    private final String fansUserCode;

    @NotNull
    private final String followUserCode;
    private boolean isAttentionPage;

    @NotNull
    private final String msgId;

    @NotNull
    private final String nickName;
    private boolean readFlag;

    @NotNull
    private final String worksCount;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FansBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FansBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FansBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FansBean[] newArray(int i) {
            return new FansBean[i];
        }
    }

    public FansBean() {
        this(null, null, null, null, null, null, false, null, false, null, null, false, 4095, null);
    }

    public FansBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, boolean z, @NotNull String str7, boolean z2, @NotNull String str8, @NotNull String str9, boolean z3) {
        Intrinsics.checkNotNullParameter(str, "avatar");
        Intrinsics.checkNotNullParameter(str2, "avatarFrameImgUrl");
        Intrinsics.checkNotNullParameter(str3, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(str4, "fansUserCode");
        Intrinsics.checkNotNullParameter(str5, "followUserCode");
        Intrinsics.checkNotNullParameter(str6, "alumniId");
        Intrinsics.checkNotNullParameter(str7, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(str8, "accid");
        Intrinsics.checkNotNullParameter(str9, "worksCount");
        this.avatar = str;
        this.avatarFrameImgUrl = str2;
        this.nickName = str3;
        this.fansUserCode = str4;
        this.followUserCode = str5;
        this.alumniId = str6;
        this.eachFollow = z;
        this.msgId = str7;
        this.readFlag = z2;
        this.accid = str8;
        this.worksCount = str9;
        this.isAttentionPage = z3;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getAccid() {
        return this.accid;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getWorksCount() {
        return this.worksCount;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getIsAttentionPage() {
        return this.isAttentionPage;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFansUserCode() {
        return this.fansUserCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getFollowUserCode() {
        return this.followUserCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getAlumniId() {
        return this.alumniId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getEachFollow() {
        return this.eachFollow;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getMsgId() {
        return this.msgId;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getReadFlag() {
        return this.readFlag;
    }

    @NotNull
    public final FansBean copy(@NotNull String avatar, @NotNull String avatarFrameImgUrl, @NotNull String nickName, @NotNull String fansUserCode, @NotNull String followUserCode, @NotNull String alumniId, boolean eachFollow, @NotNull String msgId, boolean readFlag, @NotNull String accid, @NotNull String worksCount, boolean isAttentionPage) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(avatarFrameImgUrl, "avatarFrameImgUrl");
        Intrinsics.checkNotNullParameter(nickName, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(fansUserCode, "fansUserCode");
        Intrinsics.checkNotNullParameter(followUserCode, "followUserCode");
        Intrinsics.checkNotNullParameter(alumniId, "alumniId");
        Intrinsics.checkNotNullParameter(msgId, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(accid, "accid");
        Intrinsics.checkNotNullParameter(worksCount, "worksCount");
        return new FansBean(avatar, avatarFrameImgUrl, nickName, fansUserCode, followUserCode, alumniId, eachFollow, msgId, readFlag, accid, worksCount, isAttentionPage);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FansBean)) {
            return false;
        }
        FansBean fansBean = (FansBean) other;
        return Intrinsics.areEqual(this.avatar, fansBean.avatar) && Intrinsics.areEqual(this.avatarFrameImgUrl, fansBean.avatarFrameImgUrl) && Intrinsics.areEqual(this.nickName, fansBean.nickName) && Intrinsics.areEqual(this.fansUserCode, fansBean.fansUserCode) && Intrinsics.areEqual(this.followUserCode, fansBean.followUserCode) && Intrinsics.areEqual(this.alumniId, fansBean.alumniId) && this.eachFollow == fansBean.eachFollow && Intrinsics.areEqual(this.msgId, fansBean.msgId) && this.readFlag == fansBean.readFlag && Intrinsics.areEqual(this.accid, fansBean.accid) && Intrinsics.areEqual(this.worksCount, fansBean.worksCount) && this.isAttentionPage == fansBean.isAttentionPage;
    }

    @NotNull
    public final String formatterAlumniId() {
        String string = Utils.a().getString(R.string.channel_notify_menu_user_id, this.alumniId);
        Intrinsics.checkNotNullExpressionValue(string, "getApp().getString(R.str…y_menu_user_id, alumniId)");
        return string;
    }

    @NotNull
    public final String formatterUserWorks() {
        String string = Utils.a().getString(R.string.channel_notify_menu_user_works, this.worksCount);
        Intrinsics.checkNotNullExpressionValue(string, "getApp().getString(R.str…u_user_works, worksCount)");
        return string;
    }

    @NotNull
    public final String getAccid() {
        return this.accid;
    }

    @NotNull
    public final String getAlumniId() {
        return this.alumniId;
    }

    @NotNull
    public final String getAppUserCode() {
        return TextUtils.isEmpty(this.fansUserCode) ? this.followUserCode : this.fansUserCode;
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    public final boolean getEachFollow() {
        return this.eachFollow;
    }

    @NotNull
    public final String getFansUserCode() {
        return this.fansUserCode;
    }

    @NotNull
    public final String getFollowUserCode() {
        return this.followUserCode;
    }

    @NotNull
    public final String getMsgId() {
        return this.msgId;
    }

    @NotNull
    public final String getNickName() {
        return this.nickName;
    }

    public final boolean getReadFlag() {
        return this.readFlag;
    }

    @NotNull
    public final String getWorksCount() {
        return this.worksCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((((this.avatar.hashCode() * 31) + this.avatarFrameImgUrl.hashCode()) * 31) + this.nickName.hashCode()) * 31) + this.fansUserCode.hashCode()) * 31) + this.followUserCode.hashCode()) * 31) + this.alumniId.hashCode()) * 31;
        boolean z = this.eachFollow;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((iHashCode + r1) * 31) + this.msgId.hashCode()) * 31;
        boolean z2 = this.readFlag;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int iHashCode3 = (((((iHashCode2 + r2) * 31) + this.accid.hashCode()) * 31) + this.worksCount.hashCode()) * 31;
        boolean z3 = this.isAttentionPage;
        return iHashCode3 + (z3 ? 1 : z3);
    }

    public final boolean isAttentionPage() {
        return this.isAttentionPage;
    }

    public final void setAttentionPage(boolean z) {
        this.isAttentionPage = z;
    }

    public final void setEachFollow(boolean z) {
        this.eachFollow = z;
    }

    public final void setReadFlag(boolean z) {
        this.readFlag = z;
    }

    @NotNull
    public String toString() {
        return "FansBean(avatar=" + this.avatar + ", avatarFrameImgUrl=" + this.avatarFrameImgUrl + ", nickName=" + this.nickName + ", fansUserCode=" + this.fansUserCode + ", followUserCode=" + this.followUserCode + ", alumniId=" + this.alumniId + ", eachFollow=" + this.eachFollow + ", msgId=" + this.msgId + ", readFlag=" + this.readFlag + ", accid=" + this.accid + ", worksCount=" + this.worksCount + ", isAttentionPage=" + this.isAttentionPage + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.avatar);
        parcel.writeString(this.avatarFrameImgUrl);
        parcel.writeString(this.nickName);
        parcel.writeString(this.fansUserCode);
        parcel.writeString(this.followUserCode);
        parcel.writeString(this.alumniId);
        parcel.writeInt(this.eachFollow ? 1 : 0);
        parcel.writeString(this.msgId);
        parcel.writeInt(this.readFlag ? 1 : 0);
        parcel.writeString(this.accid);
        parcel.writeString(this.worksCount);
        parcel.writeInt(this.isAttentionPage ? 1 : 0);
    }

    public /* synthetic */ FansBean(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, boolean z2, String str8, String str9, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? false : z, (i & 128) != 0 ? "" : str7, (i & 256) != 0 ? false : z2, (i & 512) != 0 ? "" : str8, (i & 1024) == 0 ? str9 : "", (i & 2048) == 0 ? z3 : false);
    }
}
