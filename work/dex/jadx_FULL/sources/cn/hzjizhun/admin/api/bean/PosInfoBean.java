package cn.hzjizhun.admin.api.bean;

import java.io.Serializable;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PosInfoBean implements Serializable {
    private String appid;
    private double biddingRatio;
    private int countdown;
    private String expand;
    private String id;
    private String posId;
    private String posName;
    private String posPlatform;
    private int price;
    private String reqId;
    private String thirdAppId;
    private String thirdPosId;

    public static PosInfoBean toBean(String str) {
        PosInfoBean posInfoBean = new PosInfoBean();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("name");
            String strOptString2 = jSONObject.optString("posid");
            String strOptString3 = jSONObject.optString("thirdposid");
            String strOptString4 = jSONObject.optString("type");
            String strOptString5 = jSONObject.optString("thirdappid");
            String strOptString6 = jSONObject.optString("appid");
            int iOptInt = jSONObject.optInt("price");
            int iOptInt2 = jSONObject.optInt("countdown");
            double dOptDouble = jSONObject.optDouble("bidding_ratio");
            String strOptString7 = jSONObject.optString("id");
            posInfoBean.posName = strOptString;
            posInfoBean.posId = strOptString2;
            posInfoBean.thirdPosId = strOptString3;
            posInfoBean.thirdAppId = strOptString5;
            posInfoBean.posPlatform = strOptString4;
            posInfoBean.appid = strOptString6;
            posInfoBean.price = iOptInt;
            posInfoBean.countdown = iOptInt2;
            posInfoBean.biddingRatio = dOptDouble;
            posInfoBean.id = strOptString7;
        } catch (Throwable unused) {
        }
        return posInfoBean;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PosInfoBean posInfoBean = (PosInfoBean) obj;
            if (this.posId.equals(posInfoBean.posId) && this.thirdPosId.equals(posInfoBean.thirdPosId) && this.posPlatform.equals(posInfoBean.posPlatform)) {
                return true;
            }
        }
        return false;
    }

    public String getAppid() {
        return this.appid;
    }

    public double getBiddingRatio() {
        return this.biddingRatio;
    }

    public int getCountdown() {
        return this.countdown;
    }

    public String getExpand() {
        return this.expand;
    }

    public String getId() {
        return this.id;
    }

    public String getPosId() {
        return this.posId;
    }

    public String getPosName() {
        return this.posName;
    }

    public String getPosPlatform() {
        return this.posPlatform;
    }

    public int getPrice() {
        return this.price;
    }

    public String getReqId() {
        return this.reqId;
    }

    public String getThirdAppId() {
        return this.thirdAppId;
    }

    public String getThirdPosId() {
        return this.thirdPosId;
    }

    public int hashCode() {
        return Objects.hash(this.posId, this.thirdPosId, this.posPlatform);
    }

    public void setAppid(String str) {
        this.appid = str;
    }

    public void setCountdown(int i) {
        this.countdown = i;
    }

    public void setExpand(String str) {
        this.expand = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setPosId(String str) {
        this.posId = str;
    }

    public void setPosName(String str) {
        this.posName = str;
    }

    public void setPosPlatform(String str) {
        this.posPlatform = str;
    }

    public void setPrice(int i) {
        this.price = i;
    }

    public void setReqId(String str) {
        this.reqId = str;
    }

    public void setThirdAppId(String str) {
        this.thirdAppId = str;
    }

    public void setThirdPosId(String str) {
        this.thirdPosId = str;
    }

    public String toString() {
        return "PosInfoBean{posName='" + this.posName + "', posId='" + this.posId + "', thirdPosId='" + this.thirdPosId + "', posPlatform='" + this.posPlatform + "', thirdAppId='" + this.thirdAppId + "', appid='" + this.appid + "', id='" + this.id + "', expand='" + this.expand + "', price='" + this.price + "'}";
    }
}
