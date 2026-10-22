package com.byazt.xx;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.byazt.nbs.da;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1007, 54})
public class ve {
    public static void c(String str, String str2, String str3) {
        if (com.byazt.bp.tt.tt().lt() != null) {
            com.byazt.ik.ve.c().insert(str, str2, str3, "show");
        }
    }

    private static boolean c(int i) {
        return i == 0 || i == 1 || i == 2;
    }

    public static void tt(String str, String str2, String str3) {
        if (com.byazt.bp.tt.tt().lt() != null) {
            com.byazt.ik.ve.c().insert(str, str2, str3, "send");
        }
    }

    private static boolean tt(int i) {
        return i == 3 || i == 4 || i == 5 || i == 6 || i == 7 || i == 8 || i == 9;
    }

    public static void ve(String str, String str2, String str3) {
        if (com.byazt.bp.tt.tt().lt() != null) {
            com.byazt.ik.ve.c().insert(str, str2, str3, "fill");
        }
    }

    public static void c(String str, int i) {
        if (com.byazt.bp.tt.tt().lt() == null || TextUtils.isEmpty(str)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - ((long) (i * 3600000));
        com.byazt.eu.tt.tt("TMe", "---预缓存优化删除存储的过期数据 primeRit = " + str + " startTime = " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(jCurrentTimeMillis)));
        com.byazt.ik.ve.c().c(str, jCurrentTimeMillis);
    }

    /* JADX WARN: Code duplicated, block: B:52:0x01be  */
    public static com.byazt.nbs.tt c(com.byazt.ll.tt ttVar, com.byazt.nbs.tt ttVar2) {
        com.byazt.nbs.tt ttVar3;
        HashMap map;
        int i;
        String str;
        String str2;
        Iterator<da> it;
        c cVar;
        tt ttVarLt = com.byazt.bp.tt.tt().lt();
        com.byazt.eu.tt.tt("TMe", "----预缓存优化判断是否可以发起预缓存开始");
        if (ttVar == null) {
            return null;
        }
        com.byazt.eu.tt.tt("TMe", "待检测的 behaviorState = " + ttVar.x());
        int iC = c(ttVar2, ttVarLt, ttVar.x());
        HashSet hashSet = new HashSet();
        if (iC == 200) {
            List<da> listL = ttVar2.l();
            HashSet<String> hashSet2 = new HashSet();
            Iterator<da> it2 = listL.iterator();
            while (true) {
                str = " adnrit = ";
                str2 = "adnName = ";
                if (!it2.hasNext()) {
                    break;
                }
                da next = it2.next();
                com.byazt.eu.tt.tt("TMe", "adnName = " + next.nu() + " adnrit = " + next.rh());
                hashSet2.add(next.nu());
            }
            LinkedList linkedList = new LinkedList();
            HashMap map2 = new HashMap();
            Iterator<da> it3 = listL.iterator();
            while (it3.hasNext()) {
                da next2 = it3.next();
                if (next2 != null) {
                    c cVar2 = (c) map2.get(next2.nu());
                    if (cVar2 == null) {
                        String strNu = next2.nu();
                        String strNb = ttVar2.nb();
                        int i2 = ttVar2.to();
                        double dC = ttVarLt.c(strNu, strNb);
                        double dTt = ttVarLt.tt(strNu, strNb);
                        it = it3;
                        if (dC == AudioStats.AUDIO_AMPLITUDE_NONE && dTt == AudioStats.AUDIO_AMPLITUDE_NONE) {
                            com.byazt.eu.tt.tt("TMe", "没有配置规则，直接添加到adn list中 adnName = " + next2.nu() + " adnRit " + next2.rh());
                            linkedList.add(next2);
                            it3 = it;
                        } else {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            List<com.byazt.ik.tt> listQuery = com.byazt.ik.ve.c().query(strNu, strNb, jCurrentTimeMillis - ((long) (i2 * 3600000)), jCurrentTimeMillis);
                            if (listQuery != null && listQuery.size() != 0) {
                                Iterator<com.byazt.ik.tt> it4 = listQuery.iterator();
                                int i3 = 0;
                                int i4 = 0;
                                int i5 = 0;
                                while (it4.hasNext()) {
                                    com.byazt.ik.tt next3 = it4.next();
                                    Iterator<com.byazt.ik.tt> it5 = it4;
                                    if (TextUtils.equals(next3.c(), "send")) {
                                        i5++;
                                    } else if (TextUtils.equals(next3.c(), "fill")) {
                                        i3++;
                                    } else if (TextUtils.equals(next3.c(), "show")) {
                                        i4++;
                                    }
                                    it4 = it5;
                                }
                                str = str;
                                c cVar3 = new c(i3 != 0 ? ((double) i4) / ((double) i3) : 0.0d, i5 != 0 ? ((double) i3) / ((double) i5) : 0.0d, dC, dTt, ttVarLt.c(), ttVarLt.a());
                                cVar3.tt(i3);
                                cVar3.c(i5);
                                cVar3.ve(i4);
                                map2.put(next2.nu(), cVar3);
                                cVar = cVar3;
                            } else {
                                com.byazt.eu.tt.tt("TMe", "数据库里没有查询到数据，直接添加到adn list中 adnName = " + next2.nu() + " adnRit " + next2.rh());
                                linkedList.add(next2);
                            }
                            if (cVar != null) {
                                cVar.c(next2.nu());
                                cVar.tt(next2.rh());
                                com.byazt.eu.tt.tt("TMe", "compareData ".concat(String.valueOf(cVar)));
                            }
                            if (cVar != null && cVar.c()) {
                                linkedList.add(next2);
                            }
                        }
                    } else {
                        it = it3;
                    }
                    cVar = cVar2;
                    if (cVar != null) {
                        cVar.c(next2.nu());
                        cVar.tt(next2.rh());
                        com.byazt.eu.tt.tt("TMe", "compareData ".concat(String.valueOf(cVar)));
                    }
                    if (cVar != null) {
                        linkedList.add(next2);
                    }
                } else {
                    str = str;
                    str2 = str2;
                    it = it3;
                }
                str = str;
                it3 = it;
                str2 = str2;
            }
            String str3 = str;
            String str4 = str2;
            com.byazt.eu.tt.tt("TMe", "筛选掉代码位 后留下的代码位 ------- ");
            HashSet hashSet3 = new HashSet();
            for (da daVar : linkedList) {
                com.byazt.eu.tt.tt("TMe", str4 + daVar.nu() + str3 + daVar.rh());
                hashSet3.add(daVar.nu());
            }
            for (String str5 : hashSet2) {
                if (!hashSet3.contains(str5)) {
                    hashSet.add(str5);
                }
            }
            int i6 = listL.size() == linkedList.size() ? 11 : 10;
            com.byazt.nbs.tt ttVarClone = ttVar2.clone();
            ttVarClone.c(linkedList);
            if (ttVarClone.yp()) {
                ttVarClone.tt(linkedList);
            } else {
                ttVarClone.c(linkedList);
            }
            i = i6;
            ttVar3 = ttVarClone;
            map = map2;
        } else {
            ttVar3 = null;
            map = null;
            i = iC;
        }
        if (ttVar3 == null) {
            c(ttVar, ttVar2, ttVarLt, i, hashSet, map);
        } else {
            c(ttVar, ttVar3, ttVarLt, i, hashSet, map);
        }
        if (ttVar2 != null) {
            c(ttVar.gt(), ttVar2.to());
        }
        return ttVar3;
    }

    private static int c(com.byazt.nbs.tt ttVar, tt ttVar2, int i) {
        if (!com.byazt.bp.tt.tt().lo()) {
            return 0;
        }
        if (ttVar2 == null || ttVar2.n() == null) {
            return 1;
        }
        if (!ttVar2.c(i)) {
            return 2;
        }
        if (ttVar2.tt() == 0) {
            return 3;
        }
        if (ttVar2.c() == 0) {
            return 4;
        }
        if (!ttVar2.sp()) {
            return 5;
        }
        if (ttVar == null || !ttVar2.c(ttVar.nb())) {
            return 6;
        }
        if (ttVar.to() == 0) {
            return 7;
        }
        if (c(ttVar, ttVar2)) {
            return c(ttVar) ? 9 : 200;
        }
        return 8;
    }

    private static boolean c(com.byazt.nbs.tt ttVar, tt ttVar2) {
        if (ttVar == null || ttVar.l() == null || ttVar2 == null) {
            return false;
        }
        for (da daVar : ttVar.l()) {
            double dC = ttVar2.c(daVar.nu(), ttVar.nb());
            double dTt = ttVar2.tt(daVar.nu(), ttVar.nb());
            if (dC != AudioStats.AUDIO_AMPLITUDE_NONE || dTt != AudioStats.AUDIO_AMPLITUDE_NONE) {
                return true;
            }
        }
        return false;
    }

    private static boolean c(com.byazt.nbs.tt ttVar) {
        if (ttVar == null) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        List<com.byazt.ik.tt> listQuery = com.byazt.ik.ve.c().query("", ttVar.nb(), jCurrentTimeMillis - (((long) ttVar.to()) * 3600000), jCurrentTimeMillis);
        return listQuery == null || listQuery.isEmpty();
    }

    private static void c(com.byazt.ll.tt ttVar, com.byazt.nbs.tt ttVar2, tt ttVar3, int i, Set<String> set, Map<String, c> map) {
        if (ttVar.i() != null) {
            com.byazt.eu.tt.tt("TMe", "预缓存优化存在埋点数据 无需重新存储");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", i);
            if (c(i)) {
                ttVar.c(jSONObject);
                return;
            }
            jSONObject.put("perform", c(i, ttVar3, map));
            if (tt(i)) {
                ttVar.c(jSONObject);
                return;
            }
            jSONObject.put("behavior_state", c(ttVar3));
            jSONObject.put("condition", ttVar3.tt());
            if (ttVar2 != null) {
                try {
                    jSONObject.put("behavior_ttl", ttVar2.to());
                } catch (JSONException unused) {
                }
            }
            if (set != null && set.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject.put("filtered_adn", jSONArray);
            }
            ttVar.c(jSONObject);
        } catch (JSONException unused2) {
        }
    }

    private static JSONArray c(tt ttVar) {
        List<Integer> list;
        JSONArray jSONArray = new JSONArray();
        if (ttVar != null && (list = ttVar.c) != null) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
        }
        return jSONArray;
    }

    private static JSONObject c(int i, tt ttVar, Map<String, c> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("rule_id", ttVar.ve());
        jSONObject.put("rule_timestamp", ttVar.uj());
        if (tt(i)) {
            return jSONObject;
        }
        jSONObject.put("condition", ttVar.c());
        jSONObject.put("rule_inuse", (i == 10 || i == 11) ? 1 : 0);
        if (map != null) {
            try {
                DecimalFormat decimalFormat = new DecimalFormat("#0.000");
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                for (Map.Entry<String, c> entry : map.entrySet()) {
                    c value = entry.getValue();
                    if (value != null) {
                        jSONObject3.put(entry.getKey(), decimalFormat.format(value.tt()));
                        jSONObject4.put(entry.getKey(), decimalFormat.format(value.ve()));
                    }
                }
                jSONObject2.put("ssr", jSONObject3);
                jSONObject2.put("srr", jSONObject4);
                jSONObject.put("res", jSONObject2);
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }
}
