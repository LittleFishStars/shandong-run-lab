package com.kc.dw.core.utils;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class ResultBean {
    private AdInfo adInfo;
    private String aderId;
    private String cat;
    private String cid;
    private int drawing;
    private String ecpm;
    private HashMap<String, Object> extraMap;
    private int interactionType;
    private int is_bidding;
    private int price;
    private String reward_name;
    private int reward_num;
    private String s_code;
    private String s_ext;
    private String pid = "";
    private String appid = "";
    private String sdkName = "";
    private String reqId = "";
    private String fromId = "";

    @Keep
    public static class AdInfo {
        private String act_ext;
        private String cid;
        private int creative_type;
        private String deep_link;
        private String desc;
        private String iconUrl;
        private String[] imgUrls;
        private String landing_page_url;
        private String package_name;
        private String title;
        private String[] videoUrls;

        public String getAct_ext() {
            return this.act_ext;
        }

        public String getCid() {
            return this.cid;
        }

        public int getCreative_type() {
            return this.creative_type;
        }

        public String getDeepLink() {
            return this.deep_link;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getIconUrl() {
            return this.iconUrl;
        }

        public String[] getImgUrls() {
            return this.imgUrls;
        }

        public String getLandingPageUrl() {
            return this.landing_page_url;
        }

        public String getPackageName() {
            return this.package_name;
        }

        public String getTitle() {
            return this.title;
        }

        public String[] getVideoUrls() {
            return this.videoUrls;
        }

        public void setAct_ext(String str) {
            this.act_ext = str;
        }

        public void setCid(String str) {
            this.cid = str;
        }

        public void setCreative_type(int i) {
            this.creative_type = i;
        }

        public void setDeepLink(String str) {
            this.deep_link = str;
        }

        public void setDesc(String str) {
            this.desc = str;
        }

        public void setIconUrl(String str) {
            this.iconUrl = str;
        }

        public void setImgUrls(String[] strArr) {
            this.imgUrls = strArr;
        }

        public void setLandingPageUrl(String str) {
            this.landing_page_url = str;
        }

        public void setPackageName(String str) {
            this.package_name = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setVideoUrls(String[] strArr) {
            this.videoUrls = strArr;
        }

        public String toString() {
            StringBuilder sbA = com.kc.dw.activity.a.a("AdInfo{creative_type=");
            sbA.append(this.creative_type);
            sbA.append(", title='");
            sbA.append(this.title);
            sbA.append('\'');
            sbA.append(", desc='");
            sbA.append(this.desc);
            sbA.append('\'');
            sbA.append(", imgUrls=");
            sbA.append(Arrays.toString(this.imgUrls));
            sbA.append(", videoUrls=");
            sbA.append(Arrays.toString(this.videoUrls));
            sbA.append(", iconUrl='");
            sbA.append(this.iconUrl);
            sbA.append('\'');
            sbA.append(", cid='");
            sbA.append(this.cid);
            sbA.append('\'');
            sbA.append(", act_ext='");
            sbA.append(this.act_ext);
            sbA.append('\'');
            sbA.append('}');
            return sbA.toString();
        }
    }

    public AdInfo getAdInfo() {
        return this.adInfo;
    }

    public String getAderId() {
        return this.aderId;
    }

    public String getAppid() {
        return this.appid;
    }

    public String getCat() {
        return this.cat;
    }

    public String getCid() {
        return this.cid;
    }

    public int getDrawing() {
        return this.drawing;
    }

    public String getEcpm() {
        return this.ecpm;
    }

    public HashMap<String, Object> getExtraMap() {
        return this.extraMap;
    }

    public String getFromId() {
        return this.fromId;
    }

    public int getInteractionType() {
        return this.interactionType;
    }

    public int getIs_bidding() {
        return this.is_bidding;
    }

    public String getPid() {
        return this.pid;
    }

    public int getPrice() {
        return this.price;
    }

    public String getReqId() {
        return this.reqId;
    }

    public String getReward_name() {
        return this.reward_name;
    }

    public int getReward_num() {
        return this.reward_num;
    }

    public String getS_code() {
        return this.s_code;
    }

    public String getS_ext() {
        return this.s_ext;
    }

    public String getSdkName() {
        return this.sdkName;
    }

    public void setAdInfo(AdInfo adInfo) {
        this.adInfo = adInfo;
    }

    public void setAderId(String str) {
        this.aderId = str;
    }

    public void setAppid(String str) {
        this.appid = str;
    }

    public void setCat(String str) {
        this.cat = str;
    }

    public void setCid(String str) {
        this.cid = str;
    }

    public void setDrawing(int i) {
        this.drawing = i;
    }

    public void setEcpm(String str) {
        this.ecpm = str;
    }

    public void setExtraMap(HashMap<String, Object> map) {
        this.extraMap = map;
    }

    public void setFromId(String str) {
        this.fromId = str;
    }

    public void setInteractionType(int i) {
        this.interactionType = i;
    }

    public void setIs_bidding(int i) {
        this.is_bidding = i;
    }

    public void setPid(String str) {
        this.pid = str;
    }

    public void setPrice(int i) {
        this.price = i;
    }

    public void setReqId(String str) {
        this.reqId = str;
    }

    public void setReward_name(String str) {
        this.reward_name = str;
    }

    public void setReward_num(int i) {
        this.reward_num = i;
    }

    public void setS_code(String str) {
        this.s_code = str;
    }

    public void setS_ext(String str) {
        this.s_ext = str;
    }

    public void setSdkName(String str) {
        this.sdkName = str;
    }
}
