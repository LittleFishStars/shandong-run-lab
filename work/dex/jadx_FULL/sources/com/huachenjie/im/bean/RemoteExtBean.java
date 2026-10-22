package com.huachenjie.im.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.common.constants.UserConstants;
import com.zj.adlib.j64;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class RemoteExtBean implements Parcelable {
    public static final Parcelable.Creator<RemoteExtBean> CREATOR = new Parcelable.Creator<RemoteExtBean>() { // from class: com.huachenjie.im.bean.RemoteExtBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteExtBean createFromParcel(Parcel parcel) {
            return new RemoteExtBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteExtBean[] newArray(int i) {
            return new RemoteExtBean[i];
        }
    };
    private String appUserCode;
    private String attitudeName;
    private String avatar;
    private String avatarFrameImgUrl;
    private String nickName;
    private Map<String, Object> remoteExt;
    private int roleType;
    private int section;
    private int specialAbility;
    private int starLevel;

    public RemoteExtBean() {
        this.remoteExt = new HashMap();
        this.nickName = "";
        this.specialAbility = 0;
        this.section = 0;
        this.starLevel = 0;
        this.attitudeName = "";
    }

    public static RemoteExtBean getInstance(Map<String, Object> map) {
        RemoteExtBean remoteExtBean = new RemoteExtBean();
        if (map != null) {
            remoteExtBean.setRoleType(j64.j(map.get("roleType")));
            remoteExtBean.setAppUserCode(j64.p(map.get("appUserCode")));
            remoteExtBean.setAvatar(j64.p(map.get("avatar")));
            remoteExtBean.setAvatarFrameImgUrl(j64.p(map.get("avatarFrameImgUrl")));
            remoteExtBean.setNickName(j64.p(map.get(UserConstants.USER_PARAMS.b)));
            remoteExtBean.setSpecialAbility(j64.j(map.get("specialAbility")));
            remoteExtBean.setSection(j64.j(map.get("section")));
            remoteExtBean.setStarLevel(j64.j(map.get("starLevel")));
            remoteExtBean.setAttitudeName(j64.p(map.get("attitudeName")));
        }
        return remoteExtBean;
    }

    public void clear() {
        this.roleType = 3;
        this.appUserCode = "";
        this.avatar = "";
        this.avatarFrameImgUrl = "";
        this.nickName = "";
        this.specialAbility = 0;
        this.section = 0;
        this.starLevel = 0;
        this.attitudeName = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppUserCode() {
        return this.appUserCode;
    }

    public String getAttitudeName() {
        return this.attitudeName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    public String getNickName() {
        return this.nickName;
    }

    public Map<String, Object> getRemoteExt() {
        this.remoteExt.put("roleType", Integer.valueOf(this.roleType));
        this.remoteExt.put("appUserCode", this.appUserCode);
        this.remoteExt.put("avatar", this.avatar);
        this.remoteExt.put("avatarFrameImgUrl", this.avatarFrameImgUrl);
        this.remoteExt.put(UserConstants.USER_PARAMS.b, this.nickName);
        this.remoteExt.put("specialAbility", Integer.valueOf(this.specialAbility));
        this.remoteExt.put("section", Integer.valueOf(this.section));
        this.remoteExt.put("starLevel", Integer.valueOf(this.starLevel));
        this.remoteExt.put("attitudeName", this.attitudeName);
        return this.remoteExt;
    }

    public int getRoleType() {
        return this.roleType;
    }

    public int getSection() {
        return this.section;
    }

    public int getSpecialAbility() {
        return this.specialAbility;
    }

    public int getStarLevel() {
        return this.starLevel;
    }

    public void setAppUserCode(String str) {
        this.appUserCode = str;
    }

    public void setAttitudeName(String str) {
        this.attitudeName = str;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setAvatarFrameImgUrl(String str) {
        this.avatarFrameImgUrl = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setRoleType(int i) {
        this.roleType = i;
    }

    public void setSection(int i) {
        this.section = i;
    }

    public void setSpecialAbility(int i) {
        this.specialAbility = i;
    }

    public void setStarLevel(int i) {
        this.starLevel = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.roleType);
        parcel.writeString(this.appUserCode);
        parcel.writeString(this.avatar);
        parcel.writeString(this.avatarFrameImgUrl);
        parcel.writeString(this.nickName);
        parcel.writeInt(this.specialAbility);
        parcel.writeInt(this.section);
        parcel.writeInt(this.starLevel);
        parcel.writeString(this.attitudeName);
    }

    public RemoteExtBean(Parcel parcel) {
        this.remoteExt = new HashMap();
        this.nickName = "";
        this.specialAbility = 0;
        this.section = 0;
        this.starLevel = 0;
        this.attitudeName = "";
        this.roleType = parcel.readInt();
        this.appUserCode = parcel.readString();
        this.avatar = parcel.readString();
        this.avatarFrameImgUrl = parcel.readString();
        this.nickName = parcel.readString();
        this.specialAbility = parcel.readInt();
        this.section = parcel.readInt();
        this.starLevel = parcel.readInt();
        this.attitudeName = parcel.readString();
    }
}
