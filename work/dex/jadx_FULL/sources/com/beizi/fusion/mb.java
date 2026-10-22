package com.beizi.fusion;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface mb {
    void a(Map map);

    void b(Map map);

    int getECPM();

    public static class a {
        public static Map a(int i, int i2, String str, int i3) {
            HashMap map = new HashMap();
            map.put("winPrice", String.valueOf(i));
            map.put("secHighPrice", String.valueOf(i2));
            map.put("adnId", str);
            map.put("expectPrice", String.valueOf(i3));
            return map;
        }

        public static Map a(int i, int i2, String str, String str2, int i3) {
            HashMap map = new HashMap();
            map.put("winPrice", String.valueOf(i));
            map.put("secHighPrice", String.valueOf(i2));
            map.put("lossReason", str2);
            map.put("adnId", str);
            map.put("expectPrice", String.valueOf(i3));
            return map;
        }
    }
}
