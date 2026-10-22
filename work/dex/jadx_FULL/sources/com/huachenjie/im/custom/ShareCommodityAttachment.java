package com.huachenjie.im.custom;

import android.text.TextUtils;
import com.huachenjie.im.custom.base.BaseAttachment;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ShareCommodityAttachment extends BaseAttachment {
    protected String goodsNo = "";
    protected String goodsName = "";
    protected String salePoint = "";
    protected String mainImageUrl = "";
    protected String traceNo = "";

    @Override // com.huachenjie.im.custom.base.BaseAttachment
    public int getCustomType() {
        return 12;
    }

    public String getGoodsName() {
        return TextUtils.isEmpty(this.goodsName) ? "" : this.goodsName;
    }

    public String getGoodsNo() {
        return this.goodsNo;
    }

    public String getMainImageUrl() {
        return TextUtils.isEmpty(this.mainImageUrl) ? "" : this.mainImageUrl;
    }

    public String getSalePoint() {
        return TextUtils.isEmpty(this.salePoint) ? "" : this.salePoint;
    }

    public String getTraceNo() {
        return TextUtils.isEmpty(this.traceNo) ? "" : this.traceNo;
    }

    public void setGoodsName(String str) {
        this.goodsName = str;
    }

    public void setGoodsNo(String str) {
        this.goodsNo = str;
    }

    public void setMainImageUrl(String str) {
        this.mainImageUrl = str;
    }

    public void setSalePoint(String str) {
        this.salePoint = str;
    }

    public void setTraceNo(String str) {
        this.traceNo = str;
    }
}
