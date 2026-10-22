package com.byazt.qv;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.byazt.nbs.da;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME, 46})
public class n {
    public static final Map<String, c> c = new ConcurrentHashMap();

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME, 151})
    public static class c {
        public String c;
        public int n;
        public int tt;
        public Set<String> uj;
        public Set<String> ve;
    }

    public static void c(JSONArray jSONArray) {
        int iOptInt;
        if (jSONArray == null || jSONArray.length() <= 0) {
            c.clear();
            return;
        }
        c.clear();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("id");
                if (!TextUtils.isEmpty(strOptString)) {
                    c cVar = new c();
                    int iOptInt2 = jSONObjectOptJSONObject.optInt("t");
                    cVar.c = strOptString;
                    cVar.tt = iOptInt2;
                    if (iOptInt2 == 1) {
                        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("a");
                        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                            cVar.uj = new HashSet();
                            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                                cVar.uj.add(jSONArrayOptJSONArray.optString(i2));
                            }
                            c.put(strOptString, cVar);
                        }
                    } else if (iOptInt2 == 2) {
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("r");
                        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                            cVar.ve = new HashSet();
                            for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                                cVar.ve.add(jSONArrayOptJSONArray2.optString(i3));
                            }
                            c.put(strOptString, cVar);
                        }
                    } else if ((iOptInt2 == 3 || iOptInt2 == 4) && (iOptInt = jSONObjectOptJSONObject.optInt("c", -1)) != -1) {
                        cVar.n = iOptInt;
                        c.put(strOptString, cVar);
                    }
                }
            }
        }
    }

    private static String tt(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        str.hashCode();
        switch (str) {
            case "pangle":
                return "376434";
            case "sigmob":
                return "476747";
            case "ks":
                return "575683";
            case "gdt":
                return "384735";
            case "baidu":
                return "476385";
            case "unity":
                return "846469";
            case "mintegral":
                return "765380";
            default:
                return str;
        }
    }

    public static c c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c.get(str);
    }

    private static boolean c(c cVar, double d, String str, String str2) {
        if (!c.isEmpty() && cVar != null) {
            int i = cVar.tt;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4 && d > AudioStats.AUDIO_AMPLITUDE_NONE && d <= cVar.n) {
                            return true;
                        }
                    } else if (d > AudioStats.AUDIO_AMPLITUDE_NONE && d >= cVar.n) {
                        return true;
                    }
                } else if (cVar.ve.contains(str2)) {
                    return true;
                }
            } else if (cVar.uj.contains(tt(str))) {
                return true;
            }
        }
        return false;
    }

    public static c c(com.byazt.ll.tt ttVar, da daVar) {
        if (c.isEmpty()) {
            return null;
        }
        Map<String, Object> mapCu = ttVar.cu();
        Object obj = mapCu.get("on_shield");
        Object obj2 = mapCu.get("id_list");
        if ((obj instanceof Integer) && (obj2 instanceof List) && daVar != null && ((Integer) obj).intValue() == 1) {
            ArrayList<c> arrayList = new ArrayList();
            try {
                Iterator it = ((List) obj2).iterator();
                boolean z = false;
                boolean z2 = false;
                while (it.hasNext()) {
                    c cVarC = c((String) it.next());
                    if (cVarC != null) {
                        int i = cVarC.tt;
                        if (i == 3) {
                            if (!z) {
                                arrayList.add(cVarC);
                                z = true;
                            }
                        } else if (i != 4) {
                            arrayList.add(cVarC);
                        } else if (!z2) {
                            arrayList.add(cVarC);
                            z2 = true;
                        }
                    }
                }
                Collections.sort(arrayList, new Comparator<c>() { // from class: com.byazt.qv.n.1
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public int compare(c cVar, c cVar2) {
                        return cVar.tt - cVar2.tt;
                    }
                });
            } catch (Throwable th) {
                m.c(th);
            }
            if (!arrayList.isEmpty()) {
                c(arrayList);
                for (c cVar : arrayList) {
                    if (c(cVar, daVar.gr(), daVar.nu(), daVar.rh())) {
                        return cVar;
                    }
                }
            }
        }
        return null;
    }

    private static void c(List<c> list) {
        if (list.size() >= 2) {
            int size = list.size();
            int i = size - 1;
            if (list.get(i).tt != 4) {
                return;
            }
            int i2 = size - 2;
            if (list.get(i2).tt == 3 && list.get(i2).n <= list.get(i).n) {
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
