package com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.log2.event;

import com.alibaba.ariver.permission.b;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class Analyse2EventModel extends ASNPJsonResponseModel {

    @kg(key = "codes")
    private List<String> codes;

    @kg(key = "count")
    private int count;

    @kg(key = b.b)
    private List<String> exclude;

    @kg(key = "sample")
    private int sample;

    @kg(key = "time")
    private String time;

    @kg(key = "uploadUrl")
    private String url;

    public Analyse2EventModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
