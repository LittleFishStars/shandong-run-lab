package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.bl;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BlackListModel extends ASNPJsonResponseModel {

    @kg(key = GoodsSpecificationPreviewActivity.z)
    private List<String> blackList;

    @kg(key = "version")
    private String version;

    public BlackListModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public List<String> getBlackList() {
        return this.blackList;
    }

    public String getVersion() {
        return this.version;
    }
}
