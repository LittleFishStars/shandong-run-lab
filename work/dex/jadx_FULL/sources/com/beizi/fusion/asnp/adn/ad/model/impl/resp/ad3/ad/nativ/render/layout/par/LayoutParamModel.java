package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.layout.par;

import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import com.beizi.fusion.no;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class LayoutParamModel extends ASNPJsonResponseModel {

    @kg(key = "layout")
    private String layout;

    @kg(key = "reference")
    private String reference;

    @kg(key = "size")
    private String size;

    public LayoutParamModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public String getLayout() {
        return this.layout;
    }

    public String getReference() {
        return this.reference;
    }

    public String getSize() {
        return this.size;
    }

    public float getSizeDp() {
        return no.h(this.size);
    }

    public float getSizePercent() {
        return no.k(this.size);
    }

    public boolean usePercent() {
        if (TextUtils.isEmpty(this.size)) {
            return false;
        }
        return this.size.contains("%");
    }
}
