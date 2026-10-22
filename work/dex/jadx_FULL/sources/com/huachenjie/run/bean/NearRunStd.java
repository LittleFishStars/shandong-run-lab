package com.huachenjie.run.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class NearRunStd {
    private List<OldBarrageList> oldBarrageList;

    @SerializedName("runningUserList")
    private List<RunUserList> runUserList;
    public String tipMsg;
    private long totalDistance;
    private int totalStudent;

    public static class OldBarrageList {
        private String content;
        private String nickName;
        private boolean self;

        public String getContent() {
            return this.content;
        }

        public String getNickName() {
            return this.nickName;
        }

        public boolean getSelf() {
            return this.self;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public void setSelf(boolean self) {
            this.self = self;
        }
    }

    public static class RunUserList {
        private String avatarFrameImgUrl;
        private String headImg;
        private double lat;
        private double lng;
        private int sex;
        private String userId;

        public String getAvatarFrameImgUrl() {
            return this.avatarFrameImgUrl;
        }

        public String getHeadImg() {
            return this.headImg;
        }

        public double getLat() {
            return this.lat;
        }

        public double getLng() {
            return this.lng;
        }

        public int getSex() {
            return this.sex;
        }

        public String getUserId() {
            return this.userId;
        }

        public void setAvatarFrameImgUrl(String avatarFrameImgUrl) {
            this.avatarFrameImgUrl = avatarFrameImgUrl;
        }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }

    public List<OldBarrageList> getOldBarrageList() {
        return this.oldBarrageList;
    }

    public List<RunUserList> getRunUserList() {
        return this.runUserList;
    }

    public String getTipMsg() {
        return this.tipMsg;
    }

    public long getTotalDistance() {
        return this.totalDistance;
    }

    public int getTotalStudent() {
        return this.totalStudent;
    }

    public void setOldBarrageList(List<OldBarrageList> oldBarrageList) {
        this.oldBarrageList = oldBarrageList;
    }

    public void setRunUserList(List<RunUserList> runUserList) {
        this.runUserList = runUserList;
    }

    public void setTipMsg(String tipMsg) {
        this.tipMsg = tipMsg;
    }

    public void setTotalDistance(long totalDistance) {
        this.totalDistance = totalDistance;
    }

    public void setTotalStudent(int totalStudent) {
        this.totalStudent = totalStudent;
    }
}
