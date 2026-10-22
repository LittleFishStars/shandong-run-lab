package com.alibaba.triver.prefetch.mtop;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.alibaba.triver.kit.api.model.RequestParams;
import com.alibaba.triver.kit.api.orange.TBShopOrangeController;
import com.alibaba.triver.kit.api.utils.TRiverUrlUtils;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ShopMtopRequestParam extends RequestParams {
    private static final String ORI_URL_KEY = "ori_url";
    private String originUrl;
    private Map<String, String> paramData;

    public ShopMtopRequestParam(String str, Bundle bundle, Map<String, String> map) {
        super(str, bundle);
        this.paramData = map;
        this.api = "mtop.taobao.wireless.shop.fetch";
        this.needLogin = true;
        this.version = getShopFetchVersion(map);
        if (!TBShopOrangeController.enableShopFetchSendShopNavi() || bundle == null) {
            return;
        }
        this.originUrl = bundle.getString("ori_url");
    }

    private String getShopFetchVersion(Map<String, String> map) {
        String str = map != null ? map.get("shopFetchVersion") : null;
        return TextUtils.isEmpty(str) ? "3.0" : str;
    }

    @Override // com.alibaba.triver.kit.api.model.RequestParams
    public Map<String, Object> toMap() {
        HashMap map = new HashMap();
        String str = this.paramData.get(ALPParamConstant.SHOPID);
        String str2 = this.paramData.get("flagShip");
        String str3 = this.paramData.get("sellerId");
        String shopTabKey = this.paramData.get("shop_navi");
        if (TBShopOrangeController.enableShopFetchSendShopNavi() && TextUtils.isEmpty(shopTabKey)) {
            shopTabKey = TRiverUrlUtils.getShopTabKey(this.originUrl);
        }
        String str4 = this.paramData.get("shop_origin");
        String str5 = this.paramData.get("features");
        String str6 = this.paramData.get("shopSourceChannel");
        if (AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equals(str2)) {
            map.put("flagShip", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        } else {
            map.put("flagShip", "true");
        }
        if (str == null) {
            str = "";
        }
        map.put(ALPParamConstant.SHOPID, str);
        if (str3 == null) {
            str3 = "";
        }
        map.put("sellerId", str3);
        if (shopTabKey == null) {
            shopTabKey = "";
        }
        map.put("shopNavi", shopTabKey);
        if (str4 == null) {
            str4 = "";
        }
        map.put("originUrl", str4);
        if (str5 == null) {
            str5 = "";
        }
        map.put("features", str5);
        if (str6 == null) {
            str6 = "";
        }
        map.put("shopSourceChannel", str6);
        return map;
    }
}
