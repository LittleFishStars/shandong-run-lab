package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ac {
    public boolean a() {
        return Process.myUid() / 100000 != 0;
    }

    public String b(Context context) {
        try {
            return context.getFilesDir().getParentFile().getAbsolutePath();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String c(Context context) {
        try {
            Object objInvoke = Class.forName(ProcessUtils.ACTIVITY_THREAD).getMethod(ProcessUtils.CURRENT_ACTIVITY_THREAD, new Class[0]).invoke(null, new Object[0]);
            Field declaredField = objInvoke.getClass().getDeclaredField("mPackages");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(objInvoke);
            if (map != null && map.size() > 0) {
                for (Object obj : map.keySet()) {
                    if (obj.toString().length() > 1 && !obj.toString().equals(context.getPackageName())) {
                        File file = new File("/data/data" + File.separator + obj.toString());
                        if (file.exists() && file.canWrite()) {
                            return obj.toString();
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public JSONArray d(Context context) {
        BufferedReader bufferedReader;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/self/maps"));
                try {
                    HashSet hashSet = new HashSet();
                    String packageName = context.getPackageName();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            if (!line.contains("@Hw") && !line.contains(".apk@classes.dex") && !line.contains("WebViewGoogle") && !line.contains("FeatureFramework") && !line.contains("framework@oppo") && !line.contains("framework@mediatek")) {
                                if (hashSet.size() > 15) {
                                    break;
                                }
                                if (!line.contains(packageName) && line.contains("/data/") && line.contains(".so")) {
                                    hashSet.add(line.substring(line.indexOf("/data/"), line.indexOf(".so") + 3));
                                } else if (!line.contains(packageName) && line.contains("/data/") && line.contains(".dex")) {
                                    hashSet.add(line.substring(line.indexOf("/data/"), line.indexOf(".dex") + 4));
                                }
                            }
                        } else {
                            break;
                        }
                    }
                    if (hashSet.size() > 0) {
                        JSONArray jSONArray = new JSONArray((Collection) hashSet);
                        try {
                            bufferedReader.close();
                        } catch (IOException unused) {
                        }
                        return jSONArray;
                    }
                } catch (Throwable unused2) {
                    if (bufferedReader != null) {
                    }
                    return null;
                }
            } catch (Throwable unused3) {
                bufferedReader = null;
            }
            bufferedReader.close();
        } catch (IOException unused4) {
        }
        return null;
    }

    public int e(Context context) {
        FileOutputStream fileOutputStream;
        try {
            String absolutePath = context.getFilesDir().getParentFile().getAbsolutePath();
            String str = "fk_w_" + System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            sb.append(absolutePath);
            String str2 = File.separator;
            sb.append(str2);
            sb.append(str);
            fileOutputStream = new FileOutputStream(sb.toString());
            try {
                FileDescriptor fd = fileOutputStream.getFD();
                Field declaredField = fd.getClass().getDeclaredField("descriptor");
                declaredField.setAccessible(true);
                declaredField.get(fd);
                String absolutePath2 = Files.readSymbolicLink(Paths.get(String.format("/proc/self/fd/%d", Integer.valueOf(((Integer) declaredField.get(fd)).intValue())), new String[0])).toFile().getAbsolutePath();
                if (!absolutePath2.substring(absolutePath2.lastIndexOf(str2)).equals(str2 + str)) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused) {
                    }
                    return 1;
                }
                boolean zCanRead = new File(absolutePath2.replace(str, "")).getParentFile().canRead();
                File file = new File(absolutePath2);
                if (file.exists()) {
                    file.delete();
                }
                if (zCanRead) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused2) {
                    }
                    return 1;
                }
                try {
                    fileOutputStream.close();
                } catch (Exception unused3) {
                }
                return 0;
            } catch (Throwable unused4) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused5) {
                    }
                }
                return 0;
            }
        } catch (Throwable unused6) {
            fileOutputStream = null;
        }
    }

    public boolean f(Context context) {
        try {
            int i = context.getApplicationInfo().targetSdkVersion;
            Class<?> cls = Class.forName("android.os.SELinux");
            String str = (String) cls.getDeclaredMethod("getContext", new Class[0]).invoke(cls, new Object[0]);
            return (TextUtils.isEmpty(str) || str.startsWith(a(i, Build.VERSION.SDK_INT))) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean a(Context context) {
        try {
            return new File(context.getFilesDir().getParentFile().getAbsolutePath() + File.separator + "..").canRead();
        } catch (Throwable unused) {
            return false;
        }
    }

    private String a(int i, int i2) {
        if (i2 < 26) {
            return "u:r:untrusted_app";
        }
        if (i >= i2) {
            return "u:r:untrusted_app:s0";
        }
        if (i < 26) {
            return "u:r:untrusted_app_25:s0";
        }
        if (i2 == 27) {
            if (i >= 26) {
                return "u:r:untrusted_app:s0";
            }
        } else if (i2 == 28 || i2 == 29) {
            if (i >= 26) {
                return "u:r:untrusted_app_27:s0";
            }
        } else if (i2 == 30) {
            if (i >= 29) {
                return "u:r:untrusted_app_29:s0";
            }
            return "u:r:untrusted_app_27:s0";
        }
        return "u:r:untrusted_app";
    }
}
