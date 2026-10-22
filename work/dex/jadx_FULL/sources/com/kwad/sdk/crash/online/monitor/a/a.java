package com.kwad.sdk.crash.online.monitor.a;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@KsJson
public class a extends com.kwad.sdk.core.response.a.a {
    public double aJV;
    public List<String> bfn = new ArrayList();
    public List<String> bfo = new ArrayList();
    public List<String> bfp = new ArrayList();
    public List<String> bfq = new ArrayList();
    public List<b> bfr = new ArrayList();
    public Map<String, b> bfs = new HashMap();
    public int bft;
    public int bfu;
    public int bfv;

    public final boolean QC() {
        return (this.bfv & 4) != 0;
    }

    public final boolean QD() {
        return (this.bfv & 1) != 0;
    }

    public final boolean QE() {
        return (this.bfv & 2) != 0;
    }

    public final boolean QF() {
        return this.bfv == 0;
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        List<b> list = this.bfr;
        if (list != null) {
            for (b bVar : list) {
                this.bfs.put(bVar.appId, bVar);
            }
            this.bfr.clear();
        }
    }

    @Nullable
    public final b gB(String str) {
        if (this.bfs == null) {
            return null;
        }
        b bVar = TextUtils.isEmpty(str) ? null : this.bfs.get(str);
        return bVar == null ? this.bfs.get("000000000") : bVar;
    }
}
