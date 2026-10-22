package com.huachenjie.base.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.constants.UserConstants;
import com.zj.adlib.ai9;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b9\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 T2\u00020\u0001:\u0001TB¡\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f¢\u0006\u0002\u0010\u0015J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u000fHÆ\u0003J\t\u00108\u001a\u00020\rHÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u000fHÆ\u0003J\t\u0010<\u001a\u00020\u000fHÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\u000f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J\t\u0010D\u001a\u00020\rHÆ\u0003J¥\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000fHÆ\u0001J\t\u0010F\u001a\u00020\rHÖ\u0001J\u0013\u0010G\u001a\u00020\u000f2\b\u0010H\u001a\u0004\u0018\u00010IHÖ\u0003J\u0006\u0010J\u001a\u00020\u0003J\u0006\u0010K\u001a\u00020\u0003J\t\u0010L\u001a\u00020\rHÖ\u0001J\u0006\u0010M\u001a\u00020\u000fJ\t\u0010N\u001a\u00020\u0003HÖ\u0001J\u0019\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\rHÖ\u0001R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0014\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010'R\u001a\u0010\u0013\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010'R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010#\"\u0004\b-\u0010.R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0017R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0017R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0017¨\u0006U"}, d2 = {"Lcom/huachenjie/base/bean/UserInfoBean;", "Landroid/os/Parcelable;", "userName", "", UserConstants.USER_PARAMS.b, "avatar", "slogan", "appUserCode", "avatarFrameImgUrl", "accId", "tagList", "", "relation", "", "friendFlag", "", "contactsFlag", "worksCount", "followedCount", "hasAppliedFriend", "anonymous", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;IZILjava/lang/String;Ljava/lang/String;ZZ)V", "getAccId", "()Ljava/lang/String;", "setAccId", "(Ljava/lang/String;)V", "getAnonymous", "()Z", "getAppUserCode", "setAppUserCode", "getAvatar", "setAvatar", "getAvatarFrameImgUrl", "setAvatarFrameImgUrl", "getContactsFlag", "()I", "getFollowedCount", "getFriendFlag", "setFriendFlag", "(Z)V", "getHasAppliedFriend", "setHasAppliedFriend", "getNickName", "setNickName", "getRelation", "setRelation", "(I)V", "getSlogan", "getTagList", "()Ljava/util/List;", "setTagList", "(Ljava/util/List;)V", "getUserName", "getWorksCount", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "equals", "other", "", "formatterFollowedCount", "formatterWorksCount", "hashCode", "isMineInfo", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class UserInfoBean implements Parcelable {
    public static final int RELATION_FOLLOW = 2;
    public static final int RELATION_MUTUAL = 3;
    public static final int RELATION_NONE = 1;

    @NotNull
    private String accId;
    private final boolean anonymous;

    @NotNull
    private String appUserCode;

    @NotNull
    private String avatar;

    @NotNull
    private String avatarFrameImgUrl;
    private final int contactsFlag;

    @NotNull
    private final String followedCount;
    private boolean friendFlag;
    private boolean hasAppliedFriend;

    @NotNull
    private String nickName;
    private int relation;

    @NotNull
    private final String slogan;

    @NotNull
    private List<String> tagList;

    @NotNull
    private final String userName;

    @NotNull
    private final String worksCount;

    @NotNull
    public static final Parcelable.Creator<UserInfoBean> CREATOR = new Creator();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<UserInfoBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserInfoBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UserInfoBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserInfoBean[] newArray(int i) {
            return new UserInfoBean[i];
        }
    }

    public UserInfoBean() {
        this(null, null, null, null, null, null, null, null, 0, false, 0, null, null, false, false, 32767, null);
    }

    public UserInfoBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull List<String> list, int i, boolean z, int i2, @NotNull String str8, @NotNull String str9, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(str, "userName");
        Intrinsics.checkNotNullParameter(str2, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(str3, "avatar");
        Intrinsics.checkNotNullParameter(str4, "slogan");
        Intrinsics.checkNotNullParameter(str5, "appUserCode");
        Intrinsics.checkNotNullParameter(str6, "avatarFrameImgUrl");
        Intrinsics.checkNotNullParameter(str7, "accId");
        Intrinsics.checkNotNullParameter(list, "tagList");
        Intrinsics.checkNotNullParameter(str8, "worksCount");
        Intrinsics.checkNotNullParameter(str9, "followedCount");
        this.userName = str;
        this.nickName = str2;
        this.avatar = str3;
        this.slogan = str4;
        this.appUserCode = str5;
        this.avatarFrameImgUrl = str6;
        this.accId = str7;
        this.tagList = list;
        this.relation = i;
        this.friendFlag = z;
        this.contactsFlag = i2;
        this.worksCount = str8;
        this.followedCount = str9;
        this.hasAppliedFriend = z2;
        this.anonymous = z3;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getFriendFlag() {
        return this.friendFlag;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getContactsFlag() {
        return this.contactsFlag;
    }

    @NotNull
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getWorksCount() {
        return this.worksCount;
    }

    @NotNull
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getFollowedCount() {
        return this.followedCount;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getHasAppliedFriend() {
        return this.hasAppliedFriend;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final boolean getAnonymous() {
        return this.anonymous;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSlogan() {
        return this.slogan;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAppUserCode() {
        return this.appUserCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getAccId() {
        return this.accId;
    }

    @NotNull
    public final List<String> component8() {
        return this.tagList;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getRelation() {
        return this.relation;
    }

    @NotNull
    public final UserInfoBean copy(@NotNull String userName, @NotNull String nickName, @NotNull String avatar, @NotNull String slogan, @NotNull String appUserCode, @NotNull String avatarFrameImgUrl, @NotNull String accId, @NotNull List<String> tagList, int relation, boolean friendFlag, int contactsFlag, @NotNull String worksCount, @NotNull String followedCount, boolean hasAppliedFriend, boolean anonymous) {
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(nickName, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(slogan, "slogan");
        Intrinsics.checkNotNullParameter(appUserCode, "appUserCode");
        Intrinsics.checkNotNullParameter(avatarFrameImgUrl, "avatarFrameImgUrl");
        Intrinsics.checkNotNullParameter(accId, "accId");
        Intrinsics.checkNotNullParameter(tagList, "tagList");
        Intrinsics.checkNotNullParameter(worksCount, "worksCount");
        Intrinsics.checkNotNullParameter(followedCount, "followedCount");
        return new UserInfoBean(userName, nickName, avatar, slogan, appUserCode, avatarFrameImgUrl, accId, tagList, relation, friendFlag, contactsFlag, worksCount, followedCount, hasAppliedFriend, anonymous);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserInfoBean)) {
            return false;
        }
        UserInfoBean userInfoBean = (UserInfoBean) other;
        return Intrinsics.areEqual(this.userName, userInfoBean.userName) && Intrinsics.areEqual(this.nickName, userInfoBean.nickName) && Intrinsics.areEqual(this.avatar, userInfoBean.avatar) && Intrinsics.areEqual(this.slogan, userInfoBean.slogan) && Intrinsics.areEqual(this.appUserCode, userInfoBean.appUserCode) && Intrinsics.areEqual(this.avatarFrameImgUrl, userInfoBean.avatarFrameImgUrl) && Intrinsics.areEqual(this.accId, userInfoBean.accId) && Intrinsics.areEqual(this.tagList, userInfoBean.tagList) && this.relation == userInfoBean.relation && this.friendFlag == userInfoBean.friendFlag && this.contactsFlag == userInfoBean.contactsFlag && Intrinsics.areEqual(this.worksCount, userInfoBean.worksCount) && Intrinsics.areEqual(this.followedCount, userInfoBean.followedCount) && this.hasAppliedFriend == userInfoBean.hasAppliedFriend && this.anonymous == userInfoBean.anonymous;
    }

    @NotNull
    public final String formatterFollowedCount() {
        return "粉丝 " + this.followedCount;
    }

    @NotNull
    public final String formatterWorksCount() {
        return "作品 " + this.worksCount;
    }

    @NotNull
    public final String getAccId() {
        return this.accId;
    }

    public final boolean getAnonymous() {
        return this.anonymous;
    }

    @NotNull
    public final String getAppUserCode() {
        return this.appUserCode;
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    public final int getContactsFlag() {
        return this.contactsFlag;
    }

    @NotNull
    public final String getFollowedCount() {
        return this.followedCount;
    }

    public final boolean getFriendFlag() {
        return this.friendFlag;
    }

    public final boolean getHasAppliedFriend() {
        return this.hasAppliedFriend;
    }

    @NotNull
    public final String getNickName() {
        return this.nickName;
    }

    public final int getRelation() {
        return this.relation;
    }

    @NotNull
    public final String getSlogan() {
        return this.slogan;
    }

    @NotNull
    public final List<String> getTagList() {
        return this.tagList;
    }

    @NotNull
    public final String getUserName() {
        return this.userName;
    }

    @NotNull
    public final String getWorksCount() {
        return this.worksCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r0v27, types: [int] */
    /* JADX WARN: Type inference failed for: r0v29, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v25, types: [int] */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((((((((((this.userName.hashCode() * 31) + this.nickName.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.slogan.hashCode()) * 31) + this.appUserCode.hashCode()) * 31) + this.avatarFrameImgUrl.hashCode()) * 31) + this.accId.hashCode()) * 31) + this.tagList.hashCode()) * 31) + Integer.hashCode(this.relation)) * 31;
        boolean z = this.friendFlag;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((((((iHashCode + r1) * 31) + Integer.hashCode(this.contactsFlag)) * 31) + this.worksCount.hashCode()) * 31) + this.followedCount.hashCode()) * 31;
        boolean z2 = this.hasAppliedFriend;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode2 + r2) * 31;
        boolean z3 = this.anonymous;
        return i + (z3 ? 1 : z3);
    }

    public final boolean isMineInfo() {
        return Intrinsics.areEqual(ai9.e().getUserId(), this.appUserCode);
    }

    public final void setAccId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.accId = str;
    }

    public final void setAppUserCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appUserCode = str;
    }

    public final void setAvatar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.avatar = str;
    }

    public final void setAvatarFrameImgUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.avatarFrameImgUrl = str;
    }

    public final void setFriendFlag(boolean z) {
        this.friendFlag = z;
    }

    public final void setHasAppliedFriend(boolean z) {
        this.hasAppliedFriend = z;
    }

    public final void setNickName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nickName = str;
    }

    public final void setRelation(int i) {
        this.relation = i;
    }

    public final void setTagList(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.tagList = list;
    }

    @NotNull
    public String toString() {
        return "UserInfoBean(userName=" + this.userName + ", nickName=" + this.nickName + ", avatar=" + this.avatar + ", slogan=" + this.slogan + ", appUserCode=" + this.appUserCode + ", avatarFrameImgUrl=" + this.avatarFrameImgUrl + ", accId=" + this.accId + ", tagList=" + this.tagList + ", relation=" + this.relation + ", friendFlag=" + this.friendFlag + ", contactsFlag=" + this.contactsFlag + ", worksCount=" + this.worksCount + ", followedCount=" + this.followedCount + ", hasAppliedFriend=" + this.hasAppliedFriend + ", anonymous=" + this.anonymous + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.userName);
        parcel.writeString(this.nickName);
        parcel.writeString(this.avatar);
        parcel.writeString(this.slogan);
        parcel.writeString(this.appUserCode);
        parcel.writeString(this.avatarFrameImgUrl);
        parcel.writeString(this.accId);
        parcel.writeStringList(this.tagList);
        parcel.writeInt(this.relation);
        parcel.writeInt(this.friendFlag ? 1 : 0);
        parcel.writeInt(this.contactsFlag);
        parcel.writeString(this.worksCount);
        parcel.writeString(this.followedCount);
        parcel.writeInt(this.hasAppliedFriend ? 1 : 0);
        parcel.writeInt(this.anonymous ? 1 : 0);
    }

    public /* synthetic */ UserInfoBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, List list, int i, boolean z, int i2, String str8, String str9, boolean z2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? "" : str6, (i3 & 64) != 0 ? "" : str7, (i3 & 128) != 0 ? new ArrayList() : list, (i3 & 256) != 0 ? 0 : i, (i3 & 512) != 0 ? false : z, (i3 & 1024) != 0 ? 0 : i2, (i3 & 2048) != 0 ? "" : str8, (i3 & 4096) == 0 ? str9 : "", (i3 & 8192) != 0 ? false : z2, (i3 & 16384) == 0 ? z3 : false);
    }
}
