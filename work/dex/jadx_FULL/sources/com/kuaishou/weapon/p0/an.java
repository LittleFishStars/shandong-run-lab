package com.kuaishou.weapon.p0;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Camera;
import android.location.Location;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.aliyun.vod.log.core.AliyunLogCommon;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class an {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f40039a = "de.robv.android.xposed.XposedHelpers";
    public static final String b = "de.robv.android.xposed.XposedBridge";
    public static final String c = "com.elderdrivers.riru.edxp.config.EdXpConfigGlobal";

    /* JADX WARN: Code duplicated, block: B:34:0x0095 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x0096 A[RETURN] */
    public Set<String> a() throws Throwable {
        BufferedReader bufferedReader;
        HashSet hashSet = new HashSet();
        BufferedReader bufferedReader2 = null;
        try {
            HashSet<String> hashSet2 = new HashSet();
            bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/maps"));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if (line.endsWith(".so") || line.endsWith(".jar")) {
                        hashSet2.add(line.substring(line.lastIndexOf(" ") + 1));
                    }
                } catch (Exception unused) {
                    if (bufferedReader != null) {
                    }
                    if (hashSet.size() > 0) {
                        return hashSet;
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            }
            bufferedReader.close();
            for (String str : hashSet2) {
                if (str.contains("com.saurik.substrate")) {
                    hashSet.add(str);
                } else if (str.contains("XposedBridge.jar")) {
                    hashSet.add(str);
                }
            }
        } catch (Exception unused3) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            bufferedReader.close();
        } catch (Exception unused4) {
        }
        if (hashSet.size() > 0) {
            return hashSet;
        }
        return null;
    }

    public Set<String> b() {
        Set setKeySet;
        try {
            Class<?> clsLoadClass = ClassLoader.getSystemClassLoader().loadClass(b);
            if (clsLoadClass == null) {
                return null;
            }
            Field declaredField = clsLoadClass.getDeclaredField("sHookedMethodCallbacks");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(clsLoadClass);
            if (map == null || (setKeySet = map.keySet()) == null || setKeySet.size() <= 0) {
                return null;
            }
            return a(setKeySet);
        } catch (Exception unused) {
            return null;
        }
    }

    public Set<String> c() {
        Set setKeySet;
        try {
            Class<?> clsLoadClass = ClassLoader.getSystemClassLoader().loadClass(f40039a);
            if (clsLoadClass == null) {
                return null;
            }
            Field declaredField = clsLoadClass.getDeclaredField("methodCache");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(clsLoadClass);
            if (map == null || (setKeySet = map.keySet()) == null || setKeySet.size() <= 0) {
                return null;
            }
            return a(setKeySet);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", a(TelephonyManager.class, "getDeviceId", new Class[0]) ? 1 : 0);
            jSONObject.put("1", a(TelephonyManager.class, "getSubscriberId", new Class[0]) ? 1 : 0);
            jSONObject.put("2", a(TelephonyManager.class, "getSimSerialNumber", new Class[0]) ? 1 : 0);
            jSONObject.put("3", a(Location.class, "getLatitude", new Class[0]) ? 1 : 0);
            jSONObject.put("4", a(Location.class, "getLongitude", new Class[0]) ? 1 : 0);
            jSONObject.put("5", a(Build.class, "getSerial", new Class[0]) ? 1 : 0);
            jSONObject.put("6", a(WifiInfo.class, "getMacAddress", new Class[0]) ? 1 : 0);
            jSONObject.put("7", a(WifiInfo.class, "getBSSID", new Class[0]) ? 1 : 0);
            jSONObject.put(PrepareException.ERROR_AUTH_FAIL, a(WifiInfo.class, "getRssi", new Class[0]) ? 1 : 0);
            jSONObject.put("9", a(Class.class, "forName", String.class) ? 1 : 0);
            jSONObject.put("10", a(ActivityManager.class, "getRunningServices", Integer.TYPE) ? 1 : 0);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject e() {
        try {
            JSONObject jSONObject = new JSONObject();
            int i = 1;
            boolean zA = a(MediaRecorder.class, "setOutputFile", String.class);
            if (zA) {
                jSONObject.put("0", zA ? 1 : 0);
            }
            boolean zA2 = a(Camera.class, "takePicture", Camera.ShutterCallback.class, Camera.PictureCallback.class, Camera.PictureCallback.class);
            if (zA2) {
                jSONObject.put("1", zA2 ? 1 : 0);
            }
            boolean zA3 = a(MediaPlayer.class, "setDataSource", Context.class, Uri.class);
            if (zA3) {
                if (!zA3) {
                    i = 0;
                }
                jSONObject.put("2", i);
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject f() {
        try {
            JSONObject jSONObject = new JSONObject();
            boolean zA = a(Cipher.class, "doFinal", byte[].class);
            jSONObject.put("0", zA ? 1 : 0);
            boolean zA2 = a(SecureRandom.class, "setSeed", byte[].class);
            jSONObject.put("1", zA2 ? 1 : 0);
            if (zA2) {
                zA = true;
            }
            boolean zA3 = a(MessageDigest.class, "update", byte[].class);
            jSONObject.put("2", zA3 ? 1 : 0);
            if (zA3) {
                zA = true;
            }
            boolean zA4 = a(MessageDigest.class, "getInstance", String.class);
            jSONObject.put("3", zA4 ? 1 : 0);
            if (zA4) {
                zA = true;
            }
            boolean zA5 = a(Uri.class, "parse", String.class);
            jSONObject.put("4", zA5 ? 1 : 0);
            if (zA5) {
                zA = true;
            }
            boolean zA6 = a(SQLiteDatabase.class, "execSQL", String.class);
            jSONObject.put("5", zA6 ? 1 : 0);
            if (zA6) {
                zA = true;
            }
            boolean zA7 = a(Activity.class, "finish", new Class[0]);
            jSONObject.put("6", zA7 ? 1 : 0);
            if (zA7 ? true : zA) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
        }
    }

    public JSONObject g() {
        try {
            JSONObject jSONObject = new JSONObject();
            boolean zA = a(JSONObject.class, "toString", new Class[0]);
            if (zA) {
                jSONObject.put("0", zA ? 1 : 0);
            }
            boolean zA2 = a(TextUtils.class, "isEmpty", CharSequence.class);
            if (zA2) {
                jSONObject.put("1", zA2 ? 1 : 0);
            }
            boolean zA3 = a(JSONArray.class, "toString", new Class[0]);
            if (zA3) {
                jSONObject.put("2", zA3 ? 1 : 0);
            }
            boolean zA4 = a(Cipher.class, "doFinal", byte[].class);
            if (zA4) {
                jSONObject.put("3", zA4 ? 1 : 0);
            }
            boolean zA5 = a(ByteArrayOutputStream.class, "toByteArray", new Class[0]);
            if (zA5) {
                jSONObject.put("4", zA5 ? 1 : 0);
            }
            boolean zA6 = a(FileOutputStream.class, "write", byte[].class);
            if (zA6) {
                jSONObject.put("5", zA6 ? 1 : 0);
            }
            boolean zA7 = a(HttpURLConnection.class, "setRequestProperty", String.class, String.class);
            if (zA7) {
                jSONObject.put("6", zA7 ? 1 : 0);
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
        }
    }

    public JSONObject b(Set set) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (ClassLoader.getSystemClassLoader() != null && set.size() > 0) {
                int i = 1;
                jSONObject.put("0", a(Class.class, "forName", set) ? 1 : 0);
                jSONObject.put("1", a(ClassLoader.class, "loadClass", set) ? 1 : 0);
                jSONObject.put("2", a(Throwable.class, "getStackTrace", set) ? 1 : 0);
                jSONObject.put("3", a(PackageManager.class, c.b("Z2V0SW5zdGFsbGVkUGFja2FnZXM=", 2), set) ? 1 : 0);
                jSONObject.put("4", a(PackageManager.class, c.b("Z2V0SW5zdGFsbGVkQXBwbGljYXRpb25z", 2), set) ? 1 : 0);
                jSONObject.put("5", a(ActivityManager.class, "getRunningServices", set) ? 1 : 0);
                if (!a(JSONObject.class, "toString", set)) {
                    i = 0;
                }
                jSONObject.put("6", i);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public Set a(Set set) {
        HashSet hashSet = new HashSet();
        for (Object obj : set) {
            if (obj instanceof String) {
                if (obj != null) {
                    String str = (String) obj;
                    if (str.startsWith("android.app.ResourcesManager#") || str.startsWith("android.view.LayoutInflater#")) {
                    }
                }
                hashSet.add(obj);
            } else if (obj instanceof Method) {
                hashSet.add(((Method) obj).getName());
            }
        }
        return hashSet;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0052  */
    public int a(Context context, int i, Set set) {
        boolean zA;
        try {
            if (ClassLoader.getSystemClassLoader() != null) {
                switch (i) {
                    case 13:
                        zA = a(context, "getDeviceId", set);
                        break;
                    case 14:
                        zA = a(context, "getSubscriberId", set);
                        break;
                    case 15:
                        zA = a(context, "getSimSerialNumber", set);
                        break;
                    case 16:
                        zA = a(Settings.Secure.class, "getString", set);
                        break;
                    case 17:
                        zA = a(StringBuilder.class, "toString", set);
                        break;
                    case 18:
                        zA = a(Method.class, BridgeDSL.INVOKE, set);
                        break;
                    case 19:
                        zA = a(WifiInfo.class, "getMacAddress", set);
                        break;
                    case 20:
                        zA = a(WifiInfo.class, "getSSID", set);
                        break;
                    case 21:
                        zA = a(WifiInfo.class, "getBSSID", set);
                        break;
                    default:
                        zA = false;
                        break;
                }
            } else {
                zA = false;
            }
            return zA ? 1 : 0;
        } catch (Exception unused) {
        }
    }

    private boolean a(Class cls, String str, Set set) {
        if (str != null) {
            try {
                if (set.size() > 0 && set.toString().contains(str) && set.toString().contains(cls.getName())) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private boolean a(Context context, String str, Set set) {
        TelephonyManager telephonyManager;
        try {
            if (set.size() > 0 && (telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE)) != null) {
                return a(telephonyManager.getClass(), str, set);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean a(Class cls, String str, Class<?>... clsArr) {
        try {
            return a(bf.a((Class<?>) cls, str, clsArr));
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean a(Method method) {
        return method != null && Modifier.isNative(method.getModifiers());
    }
}
