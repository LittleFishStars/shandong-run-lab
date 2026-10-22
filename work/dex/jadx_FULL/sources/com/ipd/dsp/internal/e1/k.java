package com.ipd.dsp.internal.e1;

import androidx.annotation.Nullable;
import com.ipd.dsp.internal.c2.o;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class k implements Serializable {
    public final HashMap<String, LinkedList<String>> f = new HashMap<>();
    public final HashMap<Integer, LinkedList<String>> g = new HashMap<>();

    public k(@Nullable JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        Object obj = jSONObject.get(next);
                        if (obj instanceof JSONArray) {
                            if (next.equals("play_n_seconds")) {
                                for (int i = 0; i < ((JSONArray) obj).length(); i++) {
                                    Object obj2 = ((JSONArray) obj).get(i);
                                    if (obj2 instanceof JSONObject) {
                                        try {
                                            int i2 = ((JSONObject) obj2).getInt("seconds");
                                            JSONArray jSONArray = ((JSONObject) obj2).getJSONArray("urls");
                                            LinkedList<String> linkedList = new LinkedList<>();
                                            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                                try {
                                                    String string = jSONArray.getString(i3);
                                                    if (o.c(string)) {
                                                        linkedList.add(string);
                                                    }
                                                } catch (JSONException unused) {
                                                }
                                            }
                                            if (!linkedList.isEmpty()) {
                                                this.g.put(Integer.valueOf(i2), linkedList);
                                            }
                                        } catch (JSONException unused2) {
                                        }
                                    }
                                }
                            } else {
                                LinkedList<String> linkedList2 = new LinkedList<>();
                                for (int i4 = 0; i4 < ((JSONArray) obj).length(); i4++) {
                                    Object obj3 = ((JSONArray) obj).get(i4);
                                    if ((obj3 instanceof String) && o.c((String) obj3)) {
                                        linkedList2.add((String) obj3);
                                    }
                                }
                                this.f.put(next, linkedList2);
                            }
                        }
                    } catch (JSONException unused3) {
                    }
                }
            } catch (Throwable unused4) {
            }
        }
    }

    @Nullable
    public LinkedList<String> a(String str) {
        return this.f.get(str);
    }

    @Nullable
    public LinkedList<String> a(int i) {
        HashMap<Integer, LinkedList<String>> map = this.g;
        if (map == null || map.isEmpty()) {
            return null;
        }
        return this.g.remove(Integer.valueOf(i));
    }
}
