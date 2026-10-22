package com.alibaba.sdk.android.vod.upload.model;

import android.util.Base64;
import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class VodInfo {
    private Integer cateId;
    private String coverUrl;
    private String desc;
    private String fileName;
    private String fileSize;
    private String imageType;
    private Boolean isProcess = Boolean.TRUE;
    private Boolean isShowWaterMark;
    private Integer priority;
    private List<String> tags;
    private String title;
    private String userData;

    public Integer getCateId() {
        return this.cateId;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFileSize() {
        return this.fileSize;
    }

    public String getImageType() {
        return this.imageType;
    }

    public Boolean getIsProcess() {
        return this.isProcess;
    }

    public Boolean getIsShowWaterMark() {
        return this.isShowWaterMark;
    }

    public Integer getPriority() {
        return this.priority;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUserData() {
        return this.userData;
    }

    public void setCateId(Integer num) {
        this.cateId = num;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFileSize(String str) {
        this.fileSize = str;
    }

    public void setImageType(String str) {
        this.imageType = str;
    }

    public void setIsProcess(Boolean bool) {
        this.isProcess = bool;
    }

    public void setIsShowWaterMark(Boolean bool) {
        this.isShowWaterMark = bool;
    }

    public void setPriority(Integer num) {
        this.priority = num;
    }

    public void setTags(List<String> list) {
        this.tags = list;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUserData(String str) {
        this.userData = str;
    }

    public String toVodJsonStringWithBase64() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AliyunVodKey.KEY_VOD_TITLE, getTitle());
            jSONObject2.put(AliyunVodKey.KEY_VOD_DESCRIPTION, getDesc());
            jSONObject2.put(AliyunVodKey.KEY_VOD_CATEID, String.valueOf(getCateId()));
            jSONObject2.put("CoverUrl", getCoverUrl());
            jSONObject2.put("IsProcess", getIsProcess().toString());
            String strSubstring = "";
            if (getTags() != null && getTags().size() > 0) {
                String string = getTags().toString();
                strSubstring = string.substring(1, string.length() - 1);
            }
            jSONObject2.put(AliyunVodKey.KEY_VOD_TAGS, strSubstring);
            if (this.isShowWaterMark == null && this.priority == null) {
                jSONObject2.put(AliyunVodKey.KEY_VOD_USERDATA, getUserData());
            } else {
                JSONObject jSONObject3 = new JSONObject();
                Boolean bool = this.isShowWaterMark;
                if (bool == null || !bool.booleanValue()) {
                    jSONObject3.put("IsShowWaterMark", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
                } else {
                    jSONObject3.put("IsShowWaterMark", "true");
                }
                jSONObject3.put("Priority", String.valueOf(getPriority()));
                jSONObject2.put(AliyunVodKey.KEY_VOD_USERDATA, jSONObject3);
            }
            jSONObject.put("Vod", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Base64.encodeToString(jSONObject.toString().getBytes(), 2);
    }
}
