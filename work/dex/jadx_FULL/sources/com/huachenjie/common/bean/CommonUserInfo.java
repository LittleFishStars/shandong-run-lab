package com.huachenjie.common.bean;

import com.aliyun.vod.log.core.AliyunLogCommon;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.constants.UserConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b<\b\u0086\b\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bBÇ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018¢\u0006\u0002\u0010\u001aJ\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0015HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018HÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003JË\u0001\u0010O\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018HÆ\u0001J\u0013\u0010P\u001a\u00020\u00152\b\u0010Q\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010R\u001a\u00020\u0005HÖ\u0001J\u0006\u0010S\u001a\u00020\u0003J\t\u0010T\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001e\"\u0004\b \u0010!R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010!R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001e\"\u0004\b*\u0010!R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010!R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001e\"\u0004\b.\u0010!R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001eR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001eR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001e\"\u0004\b6\u0010!R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001e\"\u0004\b8\u0010!R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u001eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00102\"\u0004\b;\u0010<¨\u0006U"}, d2 = {"Lcom/huachenjie/common/bean/CommonUserInfo;", "", "userId", "", "userType", "", "token", "satoken", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "userName", UserConstants.USER_PARAMS.b, "avatar", "defaultAvatar", "sex", AliyunLogCommon.TERMINAL_TYPE, "studentNumber", "schoolCode", "schoolName", "shortName", "alumniId", "hasMonthCardRight", "", "avatarFrameImgUrl", "activityInfoList", "", "Lcom/huachenjie/common/bean/UserActivityInfo;", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;)V", "getActivityInfoList", "()Ljava/util/List;", "getAlumniId", "()Ljava/lang/String;", "getAvatar", "setAvatar", "(Ljava/lang/String;)V", "getAvatarFrameImgUrl", "setAvatarFrameImgUrl", "getDefaultAvatar", "getHasMonthCardRight", "()Z", "setHasMonthCardRight", "(Z)V", "getNickName", "setNickName", "getPhone", "setPhone", "getSatoken", "setSatoken", "getSchoolCode", "getSchoolName", "getSex", "()I", "getShortName", "getStudentNumber", "getToken", "setToken", "getUserId", "setUserId", "getUserName", "getUserType", "setUserType", "(I)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "equals", "other", "hashCode", "planetName", "toString", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CommonUserInfo {

    @Nullable
    private final List<UserActivityInfo> activityInfoList;

    @NotNull
    private final String alumniId;

    @NotNull
    private String avatar;

    @Nullable
    private String avatarFrameImgUrl;

    @NotNull
    private final String defaultAvatar;
    private boolean hasMonthCardRight;

    @NotNull
    private String nickName;

    @NotNull
    private String phone;

    @Nullable
    private String satoken;

    @NotNull
    private final String schoolCode;

    @NotNull
    private final String schoolName;
    private final int sex;

    @NotNull
    private final String shortName;

    @NotNull
    private final String studentNumber;

    @Nullable
    private String token;

    @NotNull
    private String userId;

    @NotNull
    private final String userName;
    private int userType;

    public CommonUserInfo() {
        this(null, 0, null, null, null, null, 0, null, null, null, null, null, null, null, null, false, null, null, 262143, null);
    }

    public CommonUserInfo(@NotNull String str, int i, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, int i2, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @Nullable String str12, @Nullable String str13, boolean z, @Nullable String str14, @Nullable List<UserActivityInfo> list) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.checkNotNullParameter(str2, "userName");
        Intrinsics.checkNotNullParameter(str3, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(str4, "avatar");
        Intrinsics.checkNotNullParameter(str5, "defaultAvatar");
        Intrinsics.checkNotNullParameter(str6, AliyunLogCommon.TERMINAL_TYPE);
        Intrinsics.checkNotNullParameter(str7, "studentNumber");
        Intrinsics.checkNotNullParameter(str8, "schoolCode");
        Intrinsics.checkNotNullParameter(str9, "schoolName");
        Intrinsics.checkNotNullParameter(str10, "shortName");
        Intrinsics.checkNotNullParameter(str11, "alumniId");
        this.userId = str;
        this.userType = i;
        this.userName = str2;
        this.nickName = str3;
        this.avatar = str4;
        this.defaultAvatar = str5;
        this.sex = i2;
        this.phone = str6;
        this.studentNumber = str7;
        this.schoolCode = str8;
        this.schoolName = str9;
        this.shortName = str10;
        this.alumniId = str11;
        this.token = str12;
        this.satoken = str13;
        this.hasMonthCardRight = z;
        this.avatarFrameImgUrl = str14;
        this.activityInfoList = list;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getSchoolCode() {
        return this.schoolCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getSchoolName() {
        return this.schoolName;
    }

    @NotNull
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getShortName() {
        return this.shortName;
    }

    @NotNull
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getAlumniId() {
        return this.alumniId;
    }

    @Nullable
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    @Nullable
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getSatoken() {
        return this.satoken;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final boolean getHasMonthCardRight() {
        return this.hasMonthCardRight;
    }

    @Nullable
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    @Nullable
    public final List<UserActivityInfo> component18() {
        return this.activityInfoList;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getUserType() {
        return this.userType;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDefaultAvatar() {
        return this.defaultAvatar;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getSex() {
        return this.sex;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getStudentNumber() {
        return this.studentNumber;
    }

    @NotNull
    public final CommonUserInfo copy(@NotNull String userId, int userType, @NotNull String userName, @NotNull String nickName, @NotNull String avatar, @NotNull String defaultAvatar, int sex, @NotNull String phone, @NotNull String studentNumber, @NotNull String schoolCode, @NotNull String schoolName, @NotNull String shortName, @NotNull String alumniId, @Nullable String token, @Nullable String satoken, boolean hasMonthCardRight, @Nullable String avatarFrameImgUrl, @Nullable List<UserActivityInfo> activityInfoList) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(nickName, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(defaultAvatar, "defaultAvatar");
        Intrinsics.checkNotNullParameter(phone, AliyunLogCommon.TERMINAL_TYPE);
        Intrinsics.checkNotNullParameter(studentNumber, "studentNumber");
        Intrinsics.checkNotNullParameter(schoolCode, "schoolCode");
        Intrinsics.checkNotNullParameter(schoolName, "schoolName");
        Intrinsics.checkNotNullParameter(shortName, "shortName");
        Intrinsics.checkNotNullParameter(alumniId, "alumniId");
        return new CommonUserInfo(userId, userType, userName, nickName, avatar, defaultAvatar, sex, phone, studentNumber, schoolCode, schoolName, shortName, alumniId, token, satoken, hasMonthCardRight, avatarFrameImgUrl, activityInfoList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonUserInfo)) {
            return false;
        }
        CommonUserInfo commonUserInfo = (CommonUserInfo) other;
        return Intrinsics.areEqual(this.userId, commonUserInfo.userId) && this.userType == commonUserInfo.userType && Intrinsics.areEqual(this.userName, commonUserInfo.userName) && Intrinsics.areEqual(this.nickName, commonUserInfo.nickName) && Intrinsics.areEqual(this.avatar, commonUserInfo.avatar) && Intrinsics.areEqual(this.defaultAvatar, commonUserInfo.defaultAvatar) && this.sex == commonUserInfo.sex && Intrinsics.areEqual(this.phone, commonUserInfo.phone) && Intrinsics.areEqual(this.studentNumber, commonUserInfo.studentNumber) && Intrinsics.areEqual(this.schoolCode, commonUserInfo.schoolCode) && Intrinsics.areEqual(this.schoolName, commonUserInfo.schoolName) && Intrinsics.areEqual(this.shortName, commonUserInfo.shortName) && Intrinsics.areEqual(this.alumniId, commonUserInfo.alumniId) && Intrinsics.areEqual(this.token, commonUserInfo.token) && Intrinsics.areEqual(this.satoken, commonUserInfo.satoken) && this.hasMonthCardRight == commonUserInfo.hasMonthCardRight && Intrinsics.areEqual(this.avatarFrameImgUrl, commonUserInfo.avatarFrameImgUrl) && Intrinsics.areEqual(this.activityInfoList, commonUserInfo.activityInfoList);
    }

    @Nullable
    public final List<UserActivityInfo> getActivityInfoList() {
        return this.activityInfoList;
    }

    @NotNull
    public final String getAlumniId() {
        return this.alumniId;
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    @NotNull
    public final String getDefaultAvatar() {
        return this.defaultAvatar;
    }

    public final boolean getHasMonthCardRight() {
        return this.hasMonthCardRight;
    }

    @NotNull
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    public final String getPhone() {
        return this.phone;
    }

    @Nullable
    public final String getSatoken() {
        return this.satoken;
    }

    @NotNull
    public final String getSchoolCode() {
        return this.schoolCode;
    }

    @NotNull
    public final String getSchoolName() {
        return this.schoolName;
    }

    public final int getSex() {
        return this.sex;
    }

    @NotNull
    public final String getShortName() {
        return this.shortName;
    }

    @NotNull
    public final String getStudentNumber() {
        return this.studentNumber;
    }

    @Nullable
    public final String getToken() {
        return this.token;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    @NotNull
    public final String getUserName() {
        return this.userName;
    }

    public final int getUserType() {
        return this.userType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v31, types: [int] */
    /* JADX WARN: Type inference failed for: r1v31, types: [int] */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v40 */
    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((this.userId.hashCode() * 31) + Integer.hashCode(this.userType)) * 31) + this.userName.hashCode()) * 31) + this.nickName.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.defaultAvatar.hashCode()) * 31) + Integer.hashCode(this.sex)) * 31) + this.phone.hashCode()) * 31) + this.studentNumber.hashCode()) * 31) + this.schoolCode.hashCode()) * 31) + this.schoolName.hashCode()) * 31) + this.shortName.hashCode()) * 31) + this.alumniId.hashCode()) * 31;
        String str = this.token;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.satoken;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        boolean z = this.hasMonthCardRight;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode3 + r1) * 31;
        String str3 = this.avatarFrameImgUrl;
        int iHashCode4 = (i + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<UserActivityInfo> list = this.activityInfoList;
        return iHashCode4 + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public final String planetName() {
        String str;
        StringBuilder sb;
        if (this.shortName.length() > 0) {
            str = this.shortName;
            sb = new StringBuilder();
        } else {
            str = this.schoolName;
            sb = new StringBuilder();
        }
        sb.append(str);
        sb.append("星球");
        return sb.toString();
    }

    public final void setAvatar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.avatar = str;
    }

    public final void setAvatarFrameImgUrl(@Nullable String str) {
        this.avatarFrameImgUrl = str;
    }

    public final void setHasMonthCardRight(boolean z) {
        this.hasMonthCardRight = z;
    }

    public final void setNickName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nickName = str;
    }

    public final void setPhone(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.phone = str;
    }

    public final void setSatoken(@Nullable String str) {
        this.satoken = str;
    }

    public final void setToken(@Nullable String str) {
        this.token = str;
    }

    public final void setUserId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userId = str;
    }

    public final void setUserType(int i) {
        this.userType = i;
    }

    @NotNull
    public String toString() {
        return "CommonUserInfo(userId=" + this.userId + ", userType=" + this.userType + ", userName=" + this.userName + ", nickName=" + this.nickName + ", avatar=" + this.avatar + ", defaultAvatar=" + this.defaultAvatar + ", sex=" + this.sex + ", phone=" + this.phone + ", studentNumber=" + this.studentNumber + ", schoolCode=" + this.schoolCode + ", schoolName=" + this.schoolName + ", shortName=" + this.shortName + ", alumniId=" + this.alumniId + ", token=" + this.token + ", satoken=" + this.satoken + ", hasMonthCardRight=" + this.hasMonthCardRight + ", avatarFrameImgUrl=" + this.avatarFrameImgUrl + ", activityInfoList=" + this.activityInfoList + ")";
    }

    public /* synthetic */ CommonUserInfo(String str, int i, String str2, String str3, String str4, String str5, int i2, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, boolean z, String str14, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? "" : str4, (i3 & 32) != 0 ? "" : str5, (i3 & 64) != 0 ? 0 : i2, (i3 & 128) != 0 ? "" : str6, (i3 & 256) != 0 ? "" : str7, (i3 & 512) != 0 ? "" : str8, (i3 & 1024) != 0 ? "" : str9, (i3 & 2048) != 0 ? "" : str10, (i3 & 4096) != 0 ? "" : str11, (i3 & 8192) != 0 ? null : str12, (i3 & 16384) != 0 ? null : str13, (i3 & 32768) != 0 ? false : z, (i3 & 65536) != 0 ? "" : str14, (i3 & 131072) == 0 ? list : null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CommonUserInfo(@NotNull String str, int i, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.checkNotNullParameter(str2, "token");
        Intrinsics.checkNotNullParameter(str3, "satoken");
        String str4 = null;
        this(null, 0, null, null, null, null, 0, null, null, null, null, str4, str4, str4, str4, false, null, null, 262143, null);
        this.userId = str;
        this.userType = i;
        this.token = str2;
        this.satoken = str3;
    }
}
