package com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.item.spec.ext;

import com.beizi.fusion.asnp.adn.ad.model.impl.req.ASNPJsonRequestModel;
import com.beizi.fusion.kg;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ReqSpecExtModel extends ASNPJsonRequestModel {

    @kg(key = "schemeId")
    private List<String> localSchemeIDs;

    public void setLocalSchemeIDs(List<String> list) {
        this.localSchemeIDs = list;
    }
}
