package com.bwt.top.api.bean;

import com.easyjson.annotation.JSONField;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class PosInfoBean implements Serializable {

    @JSONField(name = "appId")
    private String appid;
    private String expand;
    private String id;

    @JSONField(name = "posid")
    private String posId;

    @JSONField(name = "name")
    private String posName;

    @JSONField(name = "type")
    private String posPlatform;

    @JSONField(name = "price")
    private int price;

    @JSONField(name = "thirdappid")
    private String thirdAppId;

    @JSONField(name = "thirdposid")
    private String thirdPosId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PosInfoBean.class != obj.getClass()) {
            return false;
        }
        PosInfoBean posInfoBean = (PosInfoBean) obj;
        return this.posId.equals(posInfoBean.posId) && this.thirdPosId.equals(posInfoBean.thirdPosId) && this.posPlatform.equals(posInfoBean.posPlatform);
    }

    public String getAppid() {
        return this.appid;
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
