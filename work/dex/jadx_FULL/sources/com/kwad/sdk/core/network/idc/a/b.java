package com.kwad.sdk.core.network.idc.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ac;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b implements com.kwad.sdk.core.b {
    private final Map<String, List<String>> aUt = new ConcurrentHashMap();

    @NonNull
    private Map<String, List<String>> Mu() {
        return this.aUt;
    }

    public static b eS(String str) {
        b bVar = new b();
        if (str != null && !str.isEmpty()) {
            try {
                bVar.parseJson(new JSONObject(str));
            } catch (JSONException e) {
                c.printStackTraceOnly(e);
            }
        }
        return bVar;
    }

    @NonNull
    public final Set<String> Mv() {
        return this.aUt.keySet();
    }

    public final void a(b bVar) {
        this.aUt.clear();
        if (bVar != null) {
            this.aUt.putAll(bVar.Mu());
        }
    }

    @NonNull
    public final List<String> eR(String str) {
        List<String> list;
        Map<String, List<String>> map = this.aUt;
        return (map == null || (list = map.get(str)) == null) ? Collections.emptyList() : list;
    }

    public final boolean isEmpty() {
        return this.aUt.isEmpty();
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                map.put(next, ac.h(jSONObject.optJSONArray(next)));
            }
        }
        this.aUt.clear();
        this.aUt.putAll(map);
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        Map<String, List<String>> map = this.aUt;
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            ac.putValue(jSONObject, str, ac.Y(map.get(str)));
        }
        return jSONObject;
    }
}
