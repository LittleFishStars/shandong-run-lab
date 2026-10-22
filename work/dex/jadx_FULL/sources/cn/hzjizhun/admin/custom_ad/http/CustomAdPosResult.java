package cn.hzjizhun.admin.custom_ad.http;

import android.text.TextUtils;
import com.aliyun.auth.common.AliyunVodHttpCommon;
import com.coremedia.iso.boxes.FreeSpaceBox;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.igexin.push.core.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CustomAdPosResult implements Serializable {
    private int acceleration;
    private int bidPrice;
    private List<String> clickReport;
    private int ctype;
    private String deeplink;
    private String desc;
    private List<String> displayReport;
    private List<String> dpf;
    private List<String> dps;
    private List<String> dpt;
    private String iconUrl;
    private String imgUrl;
    private boolean isDownload;
    public boolean isNativePop;
    private boolean isOutFunction;
    private boolean isShowSecondarySureDialog;
    private String jumpPage;
    private boolean keen;
    private String mChannelName;
    public HeadersBean mHeadersBean;
    private String mPostId;
    private String moment;
    private String pkg;
    private String storePkg;
    private String title;
    public List<TrackerBean> trackers;
    public VideoBean video;
    private String wechatId;
    private String wechatPath;

    public static class HeadersBean {
        public String headName;
        public String headVaule;
        public String requested;
    }

    public static class TrackerBean {
        public int type;
        public List<String> urls;
    }

    public static class VideoBean {
        public String cover;
        public int duration;
        public VideoEndCardBean end_card;
        public int expires;
        public int height;
        public String mime;
        public int min_time;
        public int size;
        public String skip;
        public int type;
        public String url;
        public int width;

        public boolean isCanSkip() {
            return Objects.equals(this.skip, "1");
        }
    }

    public static class VideoEndCardBean {
        public String desc;
        public String html;
        public String title;
        public int type;
        public String url;
    }

    private static List<String> getJsonUrls(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                String strOptString = jSONArray.optString(i);
                if (!TextUtils.isEmpty(strOptString)) {
                    arrayList.add(strOptString);
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    public static CustomAdPosResult toBean(String str) {
        CustomAdPosResult customAdPosResult = new CustomAdPosResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("ldp");
            String strOptString2 = jSONObject.optString("img");
            String strOptString3 = jSONObject.optString("title");
            String strOptString4 = jSONObject.optString("description");
            String strOptString5 = jSONObject.optString(RemoteMessageConst.Notification.ICON);
            String strOptString6 = jSONObject.optString(b.aC);
            int iOptInt = jSONObject.optInt("ctype");
            int iOptInt2 = jSONObject.optInt("acceleration");
            int iOptInt3 = jSONObject.optInt("bidPrice");
            boolean zOptBoolean = jSONObject.optBoolean("keen");
            String strOptString7 = jSONObject.optString("moment");
            String strOptString8 = jSONObject.optString("storePkg");
            String strOptString9 = jSONObject.optString("deeplink");
            String strOptString10 = jSONObject.optString("wechatId");
            String strOptString11 = jSONObject.optString("wechatPath");
            customAdPosResult.setJumpPage(strOptString);
            customAdPosResult.setImgUrl(strOptString2);
            customAdPosResult.setTitle(strOptString3);
            customAdPosResult.setDesc(strOptString4);
            customAdPosResult.setIconUrl(strOptString5);
            customAdPosResult.setPkg(strOptString6);
            customAdPosResult.setCtype(iOptInt);
            customAdPosResult.setAcceleration(iOptInt2);
            customAdPosResult.setBidPrice(iOptInt3);
            customAdPosResult.setKeen(zOptBoolean);
            customAdPosResult.setMoment(strOptString7);
            customAdPosResult.setStorePkg(strOptString8);
            customAdPosResult.setDeeplink(strOptString9);
            customAdPosResult.setWechatId(strOptString10);
            customAdPosResult.setWechatPath(strOptString11);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("heads");
            if (jSONObjectOptJSONObject != null) {
                HeadersBean headersBean = new HeadersBean();
                headersBean.headName = jSONObjectOptJSONObject.optString("headName");
                headersBean.headVaule = jSONObjectOptJSONObject.optString("headVaule");
                headersBean.requested = jSONObjectOptJSONObject.optString("requested");
                customAdPosResult.mHeadersBean = headersBean;
            }
            customAdPosResult.setDisplayReport(getJsonUrls(jSONObject.optJSONArray("displayReport")));
            customAdPosResult.setClickReport(getJsonUrls(jSONObject.optJSONArray("clickReport")));
            customAdPosResult.setDpt(getJsonUrls(jSONObject.optJSONArray("dpt")));
            customAdPosResult.setDps(getJsonUrls(jSONObject.optJSONArray("dps")));
            customAdPosResult.setDpf(getJsonUrls(jSONObject.optJSONArray("dpf")));
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("video");
            if (jSONObjectOptJSONObject2 != null) {
                VideoBean videoBean = new VideoBean();
                videoBean.type = jSONObjectOptJSONObject2.optInt("type");
                videoBean.url = jSONObjectOptJSONObject2.optString("url");
                videoBean.width = jSONObjectOptJSONObject2.optInt("width");
                videoBean.height = jSONObjectOptJSONObject2.optInt("height");
                videoBean.cover = jSONObjectOptJSONObject2.optString(AliyunVodHttpCommon.ImageType.IMAGETYPE_COVER);
                videoBean.size = jSONObjectOptJSONObject2.optInt("size");
                videoBean.mime = jSONObjectOptJSONObject2.optString("mime");
                videoBean.duration = jSONObjectOptJSONObject2.optInt("duration");
                videoBean.skip = jSONObjectOptJSONObject2.optString(FreeSpaceBox.TYPE);
                videoBean.min_time = jSONObjectOptJSONObject2.optInt("min_time");
                videoBean.expires = jSONObjectOptJSONObject2.optInt("expires");
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("end_card");
                if (jSONObjectOptJSONObject3 != null) {
                    VideoEndCardBean videoEndCardBean = new VideoEndCardBean();
                    videoEndCardBean.type = jSONObjectOptJSONObject3.optInt("type");
                    videoEndCardBean.url = jSONObjectOptJSONObject3.optString("url");
                    videoEndCardBean.html = jSONObjectOptJSONObject3.optString("html");
                    videoEndCardBean.title = jSONObjectOptJSONObject3.optString("title");
                    videoEndCardBean.desc = jSONObjectOptJSONObject3.optString("desc");
                    videoBean.end_card = videoEndCardBean;
                }
                customAdPosResult.video = videoBean;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("trackers");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject4 != null) {
                        TrackerBean trackerBean = new TrackerBean();
                        trackerBean.type = jSONObjectOptJSONObject4.optInt("type");
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject4.optJSONArray("urls");
                        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                            ArrayList arrayList2 = new ArrayList();
                            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                                arrayList2.add(jSONArrayOptJSONArray2.optString(i2));
                            }
                            trackerBean.urls = arrayList2;
                        }
                        arrayList.add(trackerBean);
                    }
                }
                customAdPosResult.trackers = arrayList;
            }
        } catch (Throwable unused) {
        }
        return customAdPosResult;
    }

    public int getAcceleration() {
        return this.acceleration;
    }

    public int getBidPrice() {
        return this.bidPrice;
    }

    public String getChannelName() {
        return this.mChannelName;
    }

    public List<String> getClickReport() {
        return this.clickReport;
    }

    public int getCtype() {
        return this.ctype;
    }

    public String getDeeplink() {
        return this.deeplink;
    }

    public String getDesc() {
        return this.desc;
    }

    public List<String> getDisplayReport() {
        return this.displayReport;
    }

    public List<String> getDpf() {
        return this.dpf;
    }

    public List<String> getDps() {
        return this.dps;
    }

    public List<String> getDpt() {
        return this.dpt;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public String getJumpPage() {
        return this.jumpPage;
    }

    public String getMoment() {
        return this.moment;
    }

    public String getPkg() {
        return TextUtils.isEmpty(this.pkg) ? "" : this.pkg;
    }

    public String getPostId() {
        return this.mPostId;
    }

    public String getStorePkg() {
        return this.storePkg;
    }

    public String getTitle() {
        return this.title;
    }

    public String getWechatId() {
        return this.wechatId;
    }

    public String getWechatPath() {
        return this.wechatPath;
    }

    public boolean isDownload() {
        return this.isDownload;
    }

    public boolean isKeen() {
        return this.keen;
    }

    public boolean isOutFunction() {
        return this.isOutFunction;
    }

    public boolean isShowSecondarySureDialog() {
        return this.isShowSecondarySureDialog;
    }

    public void setAcceleration(int i) {
        this.acceleration = i;
    }

    public void setBidPrice(int i) {
        this.bidPrice = i;
    }

    public void setChannelName(String str) {
        this.mChannelName = str;
    }

    public void setClickReport(List<String> list) {
        this.clickReport = list;
    }

    public void setCtype(int i) {
        this.ctype = i;
    }

    public void setDeeplink(String str) {
        this.deeplink = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setDisplayReport(List<String> list) {
        this.displayReport = list;
    }

    public void setDownload(boolean z) {
        this.isDownload = z;
    }

    public void setDpf(List<String> list) {
        this.dpf = list;
    }

    public void setDps(List<String> list) {
        this.dps = list;
    }

    public void setDpt(List<String> list) {
        this.dpt = list;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public void setJumpPage(String str) {
        this.jumpPage = str;
    }

    public void setKeen(boolean z) {
        this.keen = z;
    }

    public void setMoment(String str) {
        this.moment = str;
    }

    public void setOutFunction(boolean z) {
        this.isOutFunction = z;
    }

    public void setPkg(String str) {
        this.pkg = str;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void setShowSecondarySureDialog(boolean z) {
        this.isShowSecondarySureDialog = z;
    }

    public void setStorePkg(String str) {
        this.storePkg = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setWechatId(String str) {
        this.wechatId = str;
    }

    public void setWechatPath(String str) {
        this.wechatPath = str;
    }

    public String toString() {
        return "ChannelAdPosResult{, ctype=" + this.ctype + "jumpPage='" + this.jumpPage + "', imgUrl='" + this.imgUrl + "', title='" + this.title + "', desc='" + this.desc + "', iconUrl='" + this.iconUrl + "', displayReport=" + this.displayReport + ", clickReport=" + this.clickReport + '}';
    }
}
