package com.alibaba.alibcprotocol.param;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcBizParams implements Serializable {
    private static final long serialVersionUID = 4774465215226546686L;
    private Map<String, String> extParams;
    private String id;
    private String sellerId;
    private String shopId;

    public Map<String, String> getExtParams() {
        return this.extParams;
    }

    public String getId() {
        return this.id;
    }

    public String getSellerId() {
        return this.sellerId;
    }

    public String getShopId() {
        return this.shopId;
    }

    public void setExtParams(Map<String, String> map) {
        this.extParams = map;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setSellerId(String str) {
        this.sellerId = str;
    }

    public void setShopId(String str) {
        this.shopId = str;
    }
}
