package com.huachenjie.social_contact.bean;

import android.annotation.SuppressLint;
import com.huachenjie.common.bean.StaticSuitModelBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class MirrorDimensionBean extends StaticSuitModelBean {
    private FavorabilityBean favorability;
    private int type = -1;
    private int friendType = -1;
    private int status = -1;
    private String nickName = "";
    private String accId = "";
    private String attitudeName = "";
    private int section = -1;
    private int starLevel = -1;
    private String userId = "";
    private String friendCode = "";
    private int specialAbility = -1;
    private int energyValue = 0;
    private String avatar = "";
    private String avatarFrameImgUrl = "";
    private String appUserCode = "";
    private String backgroudImg = "";
    private String inOtherQuadraticElementCode = "";
    private String quadraticElementConfigCode = "";
    private String elementName = "";
    private String remarkNickname = "";
    private String alumniId = "";

    public String getAccId() {
        return this.accId;
    }

    public String getAlumniId() {
        return this.alumniId;
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

    public String getBackgroudImg() {
        return this.backgroudImg;
    }

    public String getElementName() {
        return this.elementName;
    }

    public int getEnergyValue() {
        return this.energyValue;
    }

    public FavorabilityBean getFavorability() {
        return this.favorability;
    }

    public String getFavorabilityDesc() {
        FavorabilityBean favorabilityBean = this.favorability;
        return (favorabilityBean == null || favorabilityBean.getFavorabilityDesc() == null) ? "" : this.favorability.getFavorabilityDesc();
    }

    public int getFavorabilityLevel() {
        FavorabilityBean favorabilityBean = this.favorability;
        if (favorabilityBean == null) {
            return 0;
        }
        return favorabilityBean.getFavorabilityLevel();
    }

    @SuppressLint({"DefaultLocale"})
    public String getFavorabilityLevelStr() {
        FavorabilityBean favorabilityBean = this.favorability;
        return favorabilityBean == null ? "" : String.format("LV.%d", Integer.valueOf(favorabilityBean.getFavorabilityLevel()));
    }

    @SuppressLint({"DefaultLocale"})
    public String getFavorabilityProgress() {
        FavorabilityBean favorabilityBean = this.favorability;
        return favorabilityBean == null ? "" : String.format("%d/%d", Integer.valueOf(favorabilityBean.getFavorabilityAmount()), Integer.valueOf(this.favorability.getHighFavorability()));
    }

    public String getFriendCode() {
        return this.friendCode;
    }

    public int getFriendType() {
        return this.friendType;
    }

    public String getInOtherQuadraticElementCode() {
        return this.inOtherQuadraticElementCode;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getQuadraticElementConfigCode() {
        return this.quadraticElementConfigCode;
    }

    public String getRemarkNickname() {
        return this.remarkNickname;
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

    public int getStatus() {
        return this.status;
    }

    public int getType() {
        return this.type;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setAccId(String str) {
        this.accId = str;
    }

    public void setAlumniId(String str) {
        this.alumniId = str;
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

    public void setBackgroudImg(String str) {
        this.backgroudImg = str;
    }

    public void setElementName(String str) {
        this.elementName = str;
    }

    public void setEnergyValue(int i) {
        this.energyValue = i;
    }

    public void setFavorability(FavorabilityBean favorabilityBean) {
        this.favorability = favorabilityBean;
    }

    public void setFriendCode(String str) {
        this.friendCode = str;
    }

    public void setFriendType(int i) {
        this.friendType = i;
    }

    public void setInOtherQuadraticElementCode(String str) {
        this.inOtherQuadraticElementCode = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setQuadraticElementConfigCode(String str) {
        this.quadraticElementConfigCode = str;
    }

    public void setRemarkNickname(String str) {
        this.remarkNickname = str;
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

    public void setStatus(int i) {
        this.status = i;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
