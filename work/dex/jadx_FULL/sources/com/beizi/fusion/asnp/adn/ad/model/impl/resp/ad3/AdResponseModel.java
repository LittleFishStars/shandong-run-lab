package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3;

import com.ali.auth.third.login.LoginConstants;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.AdItemModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ext.ResponseExtModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.s2s.S2SAdVerifyModel;
import com.beizi.fusion.kg;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AdResponseModel extends ASNPJsonResponseModel {

    @kg(key = "ad")
    private List<AdItemModel> adItemModelList;

    @kg(key = "s2s")
    private S2SAdVerifyModel s2SAdVerifyModel;

    @kg(key = LoginConstants.EXT)
    private ResponseExtModel updateRequireModel;

    public AdResponseModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public List<AdItemModel> getAdItemList() {
        return this.adItemModelList;
    }

    public ResponseExtModel getExtraResponse() {
        return this.updateRequireModel;
    }

    public S2SAdVerifyModel getS2SAdVerify() {
        return this.s2SAdVerifyModel;
    }
}
