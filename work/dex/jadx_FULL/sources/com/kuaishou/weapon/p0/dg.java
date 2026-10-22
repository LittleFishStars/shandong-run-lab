package com.kuaishou.weapon.p0;

import android.os.Process;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class dg {
    public static String a() {
        try {
            return b(String.format(" lsof -p %1$s ", Integer.valueOf(Process.myPid())));
        } catch (Exception unused) {
            return null;
        }
    }

    private static String b(String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream()));
            ArrayList arrayList = new ArrayList();
            do {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                if (line.contains("TCP") && !line.contains(":443")) {
                    arrayList.add(line);
                }
            } while (arrayList.size() <= 5);
            bufferedReader.close();
            if (arrayList.size() > 0) {
                return arrayList.toString();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Set c() throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            HashSet hashSet = new HashSet();
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(" netstat -nap ").getInputStream()));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if (line.contains(LiveConfigKey.TCP) && line.contains("ESTABLISHED") && line.contains(":5555 ")) {
                        hashSet.add(line);
                    }
                } catch (Exception unused) {
                    if (bufferedReader != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            }
            if (hashSet.size() > 0) {
                try {
                    bufferedReader.close();
                } catch (Exception unused3) {
                }
                return hashSet;
            }
        } catch (Exception unused4) {
            bufferedReader = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
        try {
            bufferedReader.close();
        } catch (Exception unused5) {
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int d() throws Throwable {
        String line;
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(" netstat -apn | grep scrcpy ").getInputStream()));
            do {
                try {
                    line = bufferedReader2.readLine();
                    if (line == null) {
                        try {
                            bufferedReader2.close();
                        } catch (Exception unused) {
                        }
                        return 0;
                    }
                } catch (Exception unused2) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused3) {
                        }
                    }
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            } while (!line.contains("scrcpy"));
            bufferedReader2.close();
            return 1;
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static JSONObject e() throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(" netstat -an ").getInputStream()));
            try {
                JSONObject jSONObject = new JSONObject();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if (line.contains(WVNativeCallbackUtil.SEPERATER) || line.contains("@")) {
                        if (line.contains(WVNativeCallbackUtil.SEPERATER)) {
                            line = line.substring(line.indexOf(WVNativeCallbackUtil.SEPERATER));
                        } else if (line.contains("@")) {
                            line = line.substring(line.indexOf("@"));
                        }
                        if (line.contains("/ddy")) {
                            jSONObject.put("0", line);
                        } else if (line.contains("scrcpy")) {
                            jSONObject.put("1", line);
                        } else if (line.contains("supersu")) {
                            jSONObject.put("2", line);
                        } else if (line.contains("/adbd")) {
                            jSONObject.put("3", line);
                        }
                    }
                }
                if (jSONObject.length() > 0) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused) {
                    }
                    return jSONObject;
                }
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                return null;
            } catch (Exception unused3) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused4) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception unused5) {
                    }
                }
                throw th;
            }
        } catch (Exception unused6) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String a(String str) throws Throwable {
        String str2 = "";
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream()));
            try {
                String line = bufferedReader2.readLine();
                if (line != null) {
                    str2 = "" + line;
                }
                try {
                    bufferedReader2.close();
                } catch (Exception unused) {
                }
                return str2;
            } catch (Exception unused2) {
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                }
                return "";
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String b() throws Throwable {
        try {
            String strA = a(" pidof adbd ");
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            return strA.length() > 10 ? strA.substring(0, 10) : strA;
        } catch (Exception unused) {
            return null;
        }
    }
}
