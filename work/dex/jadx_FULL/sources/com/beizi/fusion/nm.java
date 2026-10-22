package com.beizi.fusion;

import android.text.TextUtils;
import com.zj.adlib.u15;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class nm {
    private static nm b;
    private static Map c = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f27566a = false;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            try {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : nm.c.entrySet()) {
                    if (sb.length() > 0) {
                        sb.append("&");
                    }
                    String str = (String) entry.getKey();
                    String str2 = (String) entry.getValue();
                    sb.append(str);
                    sb.append(u15.f19942b);
                    sb.append(str2);
                }
                if (sb.length() > 0) {
                    String strB = h3.b(sb.toString());
                    if (TextUtils.isEmpty(strB)) {
                        return;
                    }
                    b8.a(q1.h().m(), "sdk_version_control", strB);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized nm a() {
        if (b == null) {
            synchronized (nm.class) {
                b = new nm();
            }
        }
        return b;
    }

    public synchronized int a(String str) {
        String[] strArrSplit;
        String[] strArrSplit2;
        if (c == null) {
            return 0;
        }
        try {
            if (!this.f27566a) {
                String strA = b8.a(q1.h().m(), "sdk_version_control");
                if (!TextUtils.isEmpty(strA)) {
                    String strA2 = h3.a(strA);
                    if (!TextUtils.isEmpty(strA2)) {
                        if (strA2.contains("&")) {
                            String[] strArrSplit3 = strA2.split("&");
                            if (strArrSplit3 != null && strArrSplit3.length > 0) {
                                for (String str2 : strArrSplit3) {
                                    if (!TextUtils.isEmpty(str2) && str2.contains(u15.f19942b) && (strArrSplit2 = str2.split(u15.f19942b)) != null && strArrSplit2.length == 2) {
                                        c.put(strArrSplit2[0], strArrSplit2[1]);
                                    }
                                }
                            }
                        } else if (strA2.contains(u15.f19942b) && (strArrSplit = strA2.split(u15.f19942b)) != null && strArrSplit.length == 2) {
                            c.put(strArrSplit[0], strArrSplit[1]);
                        }
                    }
                }
            }
            this.f27566a = true;
            if (c.containsKey(str)) {
                String str3 = (String) c.get(str);
                if ("2".equals(str3)) {
                    return 2;
                }
                if ("1".equals(str3)) {
                    return 1;
                }
            }
        } catch (Exception unused) {
            this.f27566a = true;
        }
        return 0;
    }

    public void a(String str, int i) {
        if (i == 0) {
            return;
        }
        try {
            Map map = c;
            if (map != null) {
                if (map.containsKey(str)) {
                    if (String.valueOf(i).equals((String) c.get(str))) {
                        return;
                    }
                }
                c.put(str, String.valueOf(i));
                v3.b().f().execute(new a());
            }
        } catch (Exception unused) {
        }
    }
}
