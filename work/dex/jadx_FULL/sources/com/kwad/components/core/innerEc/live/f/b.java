package com.kwad.components.core.innerEc.live.f;

import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.utils.JsonHelper;
import com.kwad.sdk.core.d.c;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsJson
public class b extends com.kwad.sdk.core.response.a.a {
    public boolean XA;
    public boolean XB;
    public String XC;
    public boolean XD;
    public long XE;
    public boolean XF;
    public String XG;
    public String Xv;
    public long Xw;
    public String Xx;
    public String Xy;
    public Map<String, String> Xz;
    public int action;

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        if (this.Xz != null) {
            try {
                JsonHelper.putValue(json, "throughInfo", new JSONObject(this.Xz));
            } catch (Throwable th) {
                c.printStackTrace(th);
            }
        }
        return json;
    }
}
