package com.huachenjie.im.custom;

import android.text.TextUtils;
import com.huachenjie.im.custom.base.BaseAttachment;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class MomentMessageAttachment extends BaseAttachment {
    private String appUserCode;
    private String avatar;
    private String content;
    private String emojiUrl;
    private List<MomentMessageFileBean> fileList;
    private int followUserCount;
    private String gradeDesc;
    private List<String> labelNameList;
    private String location;
    private int momentGiftCount;
    private String momentProductionCode;
    private int momentType;
    private String nickName;
    private String publishTimeDesc;
    private String schoolName;
    private int status;
    private String voiceBackGroundImgUrl;

    public class MomentMessageFileBean {
        private String coverUrl;
        private boolean defaultVoiceBubbleFlag;
        private String linkUrl;
        private String voiceBubbleImgUrl;
        private int voiceTime;

        public MomentMessageFileBean() {
        }

        public String getCoverUrl() {
            return TextUtils.isEmpty(this.coverUrl) ? "" : this.coverUrl;
        }

        public String getLinkUrl() {
            return TextUtils.isEmpty(this.linkUrl) ? "" : this.linkUrl;
        }

        public String getVoiceBubbleImgUrl() {
            return this.voiceBubbleImgUrl;
        }

        public int getVoiceTime() {
            return this.voiceTime;
        }

        public boolean isDefaultVoiceBubbleFlag() {
            return this.defaultVoiceBubbleFlag;
        }

        public void setCoverUrl(String str) {
            this.coverUrl = str;
        }

        public void setDefaultVoiceBubbleFlag(boolean z) {
            this.defaultVoiceBubbleFlag = z;
        }

        public void setLinkUrl(String str) {
            this.linkUrl = str;
        }

        public void setVoiceBubbleImgUrl(String str) {
            this.voiceBubbleImgUrl = str;
        }

        public void setVoiceTime(int i) {
            this.voiceTime = i;
        }
    }

    public String getAppUserCode() {
        return this.appUserCode;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getContent() {
        return this.content;
    }

    @Override // com.huachenjie.im.custom.base.BaseAttachment
    public int getCustomType() {
        return 6;
    }

    public String getEmojiUrl() {
        return this.emojiUrl;
    }

    public List<MomentMessageFileBean> getFileList() {
        return this.fileList;
    }

    public int getFollowUserCount() {
        return this.followUserCount;
    }

    public String getGradeDesc() {
        return this.gradeDesc;
    }

    public List<String> getLabelNameList() {
        return this.labelNameList;
    }

    public String getLocation() {
        return this.location;
    }

    public int getMomentGiftCount() {
        return this.momentGiftCount;
    }

    public String getMomentProductionCode() {
        return this.momentProductionCode;
    }

    public int getMomentType() {
        return this.momentType;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getPublishTimeDesc() {
        return this.publishTimeDesc;
    }

    public String getSchoolName() {
        return this.schoolName;
    }

    public int getStatus() {
        return this.status;
    }

    public String getVoiceBackGroundImgUrl() {
        return this.voiceBackGroundImgUrl;
    }

    public void setAppUserCode(String str) {
        this.appUserCode = str;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setEmojiUrl(String str) {
        this.emojiUrl = str;
    }

    public void setFileList(List<MomentMessageFileBean> list) {
        this.fileList = list;
    }

    public void setFollowUserCount(int i) {
        this.followUserCount = i;
    }

    public void setGradeDesc(String str) {
        this.gradeDesc = str;
    }

    public void setLabelNameList(List<String> list) {
        this.labelNameList = list;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setMomentGiftCount(int i) {
        this.momentGiftCount = i;
    }

    public void setMomentProductionCode(String str) {
        this.momentProductionCode = str;
    }

    public void setMomentType(int i) {
        this.momentType = i;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setPublishTimeDesc(String str) {
        this.publishTimeDesc = str;
    }

    public void setSchoolName(String str) {
        this.schoolName = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setVoiceBackGroundImgUrl(String str) {
        this.voiceBackGroundImgUrl = str;
    }
}
