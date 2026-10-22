package com.huachenjie.compat.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.bean.AddressBean;
import com.huachenjie.common.bean.SchoolInfo;
import com.huachenjie.common.constants.UserConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010%\u001a\u00020\rHÆ\u0003J[\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0012\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012¨\u0006,"}, d2 = {"Lcom/huachenjie/compat/bean/PersonalInfo;", "", "userName", "", "sex", "", "avatar", "avatarFrameImgUrl", "birthday", "nation", "address", "Lcom/huachenjie/common/bean/AddressBean;", UserConstants.LOGIN_PARAMS.c, "Lcom/huachenjie/common/bean/SchoolInfo;", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/huachenjie/common/bean/AddressBean;Lcom/huachenjie/common/bean/SchoolInfo;)V", "getAddress", "()Lcom/huachenjie/common/bean/AddressBean;", "getAvatar", "()Ljava/lang/String;", "getAvatarFrameImgUrl", "getBirthday", "setBirthday", "(Ljava/lang/String;)V", "getNation", "setNation", "getSchoolInfo", "()Lcom/huachenjie/common/bean/SchoolInfo;", "getSex", "()I", "getUserName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "compat_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PersonalInfo {

    @Nullable
    private final AddressBean address;

    @NotNull
    private final String avatar;

    @NotNull
    private final String avatarFrameImgUrl;

    @NotNull
    private String birthday;

    @NotNull
    private String nation;

    @NotNull
    private final SchoolInfo schoolInfo;
    private final int sex;

    @NotNull
    private final String userName;

    public PersonalInfo(@NotNull String str, int i, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @Nullable AddressBean addressBean, @NotNull SchoolInfo schoolInfo) {
        Intrinsics.checkNotNullParameter(str, "userName");
        Intrinsics.checkNotNullParameter(str2, "avatar");
        Intrinsics.checkNotNullParameter(str3, "avatarFrameImgUrl");
        Intrinsics.checkNotNullParameter(str4, "birthday");
        Intrinsics.checkNotNullParameter(str5, "nation");
        Intrinsics.checkNotNullParameter(schoolInfo, UserConstants.LOGIN_PARAMS.c);
        this.userName = str;
        this.sex = i;
        this.avatar = str2;
        this.avatarFrameImgUrl = str3;
        this.birthday = str4;
        this.nation = str5;
        this.address = addressBean;
        this.schoolInfo = schoolInfo;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getSex() {
        return this.sex;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getBirthday() {
        return this.birthday;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getNation() {
        return this.nation;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final AddressBean getAddress() {
        return this.address;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final SchoolInfo getSchoolInfo() {
        return this.schoolInfo;
    }

    @NotNull
    public final PersonalInfo copy(@NotNull String userName, int sex, @NotNull String avatar, @NotNull String avatarFrameImgUrl, @NotNull String birthday, @NotNull String nation, @Nullable AddressBean address, @NotNull SchoolInfo schoolInfo) {
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(avatarFrameImgUrl, "avatarFrameImgUrl");
        Intrinsics.checkNotNullParameter(birthday, "birthday");
        Intrinsics.checkNotNullParameter(nation, "nation");
        Intrinsics.checkNotNullParameter(schoolInfo, UserConstants.LOGIN_PARAMS.c);
        return new PersonalInfo(userName, sex, avatar, avatarFrameImgUrl, birthday, nation, address, schoolInfo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PersonalInfo)) {
            return false;
        }
        PersonalInfo personalInfo = (PersonalInfo) other;
        return Intrinsics.areEqual(this.userName, personalInfo.userName) && this.sex == personalInfo.sex && Intrinsics.areEqual(this.avatar, personalInfo.avatar) && Intrinsics.areEqual(this.avatarFrameImgUrl, personalInfo.avatarFrameImgUrl) && Intrinsics.areEqual(this.birthday, personalInfo.birthday) && Intrinsics.areEqual(this.nation, personalInfo.nation) && Intrinsics.areEqual(this.address, personalInfo.address) && Intrinsics.areEqual(this.schoolInfo, personalInfo.schoolInfo);
    }

    @Nullable
    public final AddressBean getAddress() {
        return this.address;
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    @NotNull
    public final String getBirthday() {
        return this.birthday;
    }

    @NotNull
    public final String getNation() {
        return this.nation;
    }

    @NotNull
    public final SchoolInfo getSchoolInfo() {
        return this.schoolInfo;
    }

    public final int getSex() {
        return this.sex;
    }

    @NotNull
    public final String getUserName() {
        return this.userName;
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.userName.hashCode() * 31) + Integer.hashCode(this.sex)) * 31) + this.avatar.hashCode()) * 31) + this.avatarFrameImgUrl.hashCode()) * 31) + this.birthday.hashCode()) * 31) + this.nation.hashCode()) * 31;
        AddressBean addressBean = this.address;
        return ((iHashCode + (addressBean == null ? 0 : addressBean.hashCode())) * 31) + this.schoolInfo.hashCode();
    }

    public final void setBirthday(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.birthday = str;
    }

    public final void setNation(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nation = str;
    }

    @NotNull
    public String toString() {
        return "PersonalInfo(userName=" + this.userName + ", sex=" + this.sex + ", avatar=" + this.avatar + ", avatarFrameImgUrl=" + this.avatarFrameImgUrl + ", birthday=" + this.birthday + ", nation=" + this.nation + ", address=" + this.address + ", schoolInfo=" + this.schoolInfo + ')';
    }
}
