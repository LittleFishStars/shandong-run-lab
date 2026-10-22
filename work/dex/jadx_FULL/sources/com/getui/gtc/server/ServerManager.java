package com.getui.gtc.server;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.getui.gtc.base.crypt.SecureCryptTools;
import com.getui.gtc.base.util.ScheduleQueue;
import com.getui.gtc.e.c;
import com.getui.gtc.e.d;
import com.getui.gtc.f.e;
import com.getui.gtc.i.c.a;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ServerManager {
    private static final long SERVERS_REFRESH_PERIOD = 86400000;
    private static Map<String, List<String>> availableServerMap;
    private static Map<String, List<String>> configServerMap;
    private static Map<String, String> runningServerMap;
    private static final Map<String, List<String>> buildInServerMap = new ConcurrentHashMap();
    private static final Map<String, List<String>> unavailableServerMap = new ConcurrentHashMap();

    public static synchronized void addBuildInServerMap(Map<String, List<String>> map) {
        buildInServerMap.putAll(map);
    }

    public static synchronized void confirmServer(String str, String str2) {
        List<String> list = unavailableServerMap.get(str);
        if (list != null) {
            list.remove(str2);
        }
        String str3 = c.a.f30351a.f30350a.i;
        try {
            Properties properties = new Properties();
            if (!TextUtils.isEmpty(str3)) {
                properties.load(new StringReader(str3));
            }
            properties.put(str, str2);
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : properties.entrySet()) {
                String str4 = (String) entry.getKey();
                String str5 = (String) entry.getValue();
                sb.append(str4);
                sb.append("=");
                sb.append(str5);
                sb.append("\n");
            }
            d dVar = c.a.f30351a.f30350a;
            String string = sb.toString();
            try {
                if (dVar.a(13, Base64.encodeToString(SecureCryptTools.getInstance().encrypt(string.getBytes()), 0))) {
                    dVar.i = string;
                }
            } catch (Throwable th) {
                a.c(th);
            }
        } catch (Throwable th2) {
            a.b(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, List<String>> getAvailableServerMap() {
        Map<String, List<String>> map = availableServerMap;
        if (map != null) {
            return map;
        }
        availableServerMap = new HashMap();
        parseServerProperties(c.a.f30351a.f30350a.h, availableServerMap);
        return availableServerMap;
    }

    public static synchronized List<String> getBuildInServers(String str) {
        return buildInServerMap.get(str);
    }

    public static synchronized List<String> getConfigServerMap(String str) {
        return getConfigServerMap().get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, List<String>> getConfigServerMap() {
        Map<String, List<String>> map = configServerMap;
        if (map != null) {
            return map;
        }
        configServerMap = new HashMap();
        parseServerProperties(c.a.f30351a.f30350a.g, configServerMap);
        return configServerMap;
    }

    private static Map<String, String> getRunningServerMap() {
        Map<String, String> map = runningServerMap;
        if (map != null) {
            return map;
        }
        runningServerMap = new HashMap();
        try {
            String str = c.a.f30351a.f30350a.i;
            if (!TextUtils.isEmpty(str)) {
                Properties properties = new Properties();
                properties.load(new StringReader(str));
                for (Map.Entry entry : properties.entrySet()) {
                    runningServerMap.put((String) entry.getKey(), (String) entry.getValue());
                }
            }
        } catch (Throwable th) {
            a.b(th);
        }
        return runningServerMap;
    }

    public static synchronized String getServer(String str) {
        List<String> list;
        String str2 = getRunningServerMap().get(str);
        if (TextUtils.isEmpty(str2) && (list = buildInServerMap.get(str)) != null && list.size() > 0) {
            str2 = list.get(0);
        }
        List<String> list2 = getAvailableServerMap().get(str);
        if (list2 != null && list2.size() > 0 && !list2.contains(str2)) {
            String str3 = list2.get(0);
            getRunningServerMap().put(str, str3);
            return str3;
        }
        if (str2 != null) {
            getRunningServerMap().put(str, str2);
        }
        return str2;
    }

    @Deprecated
    public static void initServerMap(Context context) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void parseServerProperties(String str, Map<String, List<String>> map) {
        if (map == null) {
            return;
        }
        map.clear();
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Properties properties = new Properties();
            properties.load(new StringReader(str));
            for (Map.Entry entry : properties.entrySet()) {
                String str2 = (String) entry.getKey();
                String str3 = (String) entry.getValue();
                ArrayList arrayList = new ArrayList();
                map.put(str2, arrayList);
                JSONObject jSONObject = new JSONObject(str3);
                Iterator<String> itKeys = jSONObject.keys();
                HashMap map2 = new HashMap();
                ArrayList arrayList2 = new ArrayList();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    JSONArray jSONArray = jSONObject.getJSONArray(next);
                    arrayList2.add(next);
                    ArrayList arrayList3 = new ArrayList();
                    map2.put(next, arrayList3);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String str4 = (String) jSONArray.opt(i);
                        if (!TextUtils.isEmpty(str4) && !arrayList3.contains(str4)) {
                            arrayList3.add(str4);
                        }
                    }
                }
                Collections.sort(arrayList2);
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList.addAll((Collection) map2.get((String) it.next()));
                }
            }
        } catch (Throwable th) {
            a.b(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveAvailableConfigServers() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : availableServerMap.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                jSONObject.put("1", jSONArray);
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                sb.append(jSONObject.toString());
            } catch (JSONException e) {
                a.b(e);
            }
            sb.append("\n");
        }
        c.a.f30351a.f30350a.c(sb.toString());
    }

    public static synchronized boolean switchServer(String str, String str2) {
        Map<String, List<String>> map = unavailableServerMap;
        List<String> arrayList = map.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            map.put(str, arrayList);
        }
        if (!arrayList.contains(str2)) {
            arrayList.add(str2);
        }
        List<String> list = getAvailableServerMap().get(str);
        if (list != null) {
            list.remove(str2);
            saveAvailableConfigServers();
        }
        if (!TextUtils.equals(str2, getRunningServerMap().get(str))) {
            return true;
        }
        if (list != null && list.size() > 0) {
            getRunningServerMap().put(str, list.get(0));
            return true;
        }
        List<String> list2 = buildInServerMap.get(str);
        if (list2 != null && list2.size() > 0) {
            for (String str3 : list2) {
                if (!arrayList.contains(str3) && !TextUtils.equals(str3, str2)) {
                    getRunningServerMap().put(str, str3);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static synchronized void updateConfigServerMap() {
        ScheduleQueue.getInstance().addSchedule(new Runnable() { // from class: com.getui.gtc.server.ServerManager.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (ServerManager.class) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - c.a.f30351a.f30350a.j > 86400000) {
                        d dVar = c.a.f30351a.f30350a;
                        if (dVar.a(14, jCurrentTimeMillis)) {
                            dVar.j = jCurrentTimeMillis;
                        }
                        ServerManager.getAvailableServerMap().clear();
                        ServerManager.getAvailableServerMap().putAll(ServerManager.getConfigServerMap());
                        ServerManager.saveAvailableConfigServers();
                    }
                    Map<String, String> mapA = com.getui.gtc.f.c.a(com.heytap.mcssdk.constant.a.g, new e() { // from class: com.getui.gtc.server.ServerManager.1.1
                        @Override // com.getui.gtc.f.e
                        public final void a(String str) {
                        }

                        @Override // com.getui.gtc.f.e
                        public final void a(Map<String, String> map, Map<String, String> map2) {
                            if (map2 == null || map2.size() <= 0) {
                                return;
                            }
                            final String str = map2.get("sdk.gtc.hosts.url");
                            if (map != null && map.size() > 0) {
                                String str2 = map.get("sdk.gtc.hosts.url");
                                if (TextUtils.isEmpty(str) || str.equalsIgnoreCase(str2)) {
                                    return;
                                }
                            }
                            String str3 = c.a.f30351a.f30350a.f;
                            if (TextUtils.isEmpty(str) || str.equalsIgnoreCase(str3)) {
                                return;
                            }
                            com.getui.gtc.h.e.a(str, map2.get("sdk.gtc.hosts.key"), new com.getui.gtc.h.e.a() { // from class: com.getui.gtc.server.ServerManager.1.1.1
                                @Override // com.getui.gtc.h.e.a
                                public final void a(String str4) {
                                    c.a.f30351a.f30350a.a(str);
                                    c.a.f30351a.f30350a.b(str4);
                                    c.a.f30351a.f30350a.c(str4);
                                    ServerManager.parseServerProperties(str4, ServerManager.getConfigServerMap());
                                    ServerManager.parseServerProperties(str4, ServerManager.getAvailableServerMap());
                                }
                            });
                        }
                    });
                    if (mapA != null && mapA.size() > 0) {
                        final String str = mapA.get("sdk.gtc.hosts.url");
                        String str2 = c.a.f30351a.f30350a.f;
                        if (!TextUtils.isEmpty(str) && !str.equalsIgnoreCase(str2)) {
                            com.getui.gtc.h.e.a(str, mapA.get("sdk.gtc.hosts.key"), new com.getui.gtc.h.e.a() { // from class: com.getui.gtc.server.ServerManager.1.2
                                @Override // com.getui.gtc.h.e.a
                                public final void a(String str3) {
                                    c.a.f30351a.f30350a.a(str);
                                    c.a.f30351a.f30350a.b(str3);
                                    c.a.f30351a.f30350a.c(str3);
                                    ServerManager.parseServerProperties(str3, ServerManager.getConfigServerMap());
                                    ServerManager.parseServerProperties(str3, ServerManager.getAvailableServerMap());
                                }
                            });
                        }
                    }
                }
            }
        });
    }
}
