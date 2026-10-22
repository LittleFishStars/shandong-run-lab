package com.beizi.fusion;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class a8 {
    public static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, 0) != null;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static void b(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(268435456);
                context.startActivity(launchIntentForPackage);
            }
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(context, "启动失败:" + str, 1).show();
        }
    }

    public static File c(Context context) {
        try {
            return context.getCacheDir();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static File d(Context context) {
        if (context == null) {
            return null;
        }
        try {
            File externalFilesDir = ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) ? context.getExternalFilesDir(null) : null;
            return externalFilesDir == null ? context.getFilesDir() : externalFilesDir;
        } catch (Exception unused) {
            return context.getFilesDir();
        }
    }

    public static File e(Context context) {
        try {
            File file = new File(context.getCacheDir().getPath() + "/beizi/material/");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final File f(Context context) {
        File fileD = d(context);
        if (fileD == null) {
            return null;
        }
        File file = new File(fileD.getPath() + "/Beizi/download/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static void a(String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static File b(Context context) {
        File file = new File(context.getCacheDir().getPath() + "/beizi/ad/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static void a(Context context, int i) {
        File[] fileArrListFiles;
        if (context == null) {
            return;
        }
        try {
            File fileE = e(context);
            if (fileE == null || !fileE.exists() || (fileArrListFiles = fileE.listFiles()) == null) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - ((long) (86400000 * i));
            try {
                int i2 = 0;
                for (File file : fileArrListFiles) {
                    if (file.isFile() && file.exists()) {
                        if (i2 > 100) {
                            return;
                        }
                        if (file.lastModified() < jCurrentTimeMillis) {
                            file.delete();
                            i2++;
                        }
                    }
                }
                if (i != 5 || fileE.listFiles().length <= 400) {
                    return;
                }
                a(context, 2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0075 A[Catch: all -> 0x0078, TRY_LEAVE, TryCatch #0 {all -> 0x0078, blocks: (B:29:0x0070, B:31:0x0075), top: B:37:0x0070 }] */
    public static String b(Context context, String str, String str2) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                File file = new File(b(context).getPath() + WVNativeCallbackUtil.SEPERATER + str + WVNativeCallbackUtil.SEPERATER, str2);
                if (!file.exists()) {
                    return null;
                }
                fileReader = new FileReader(file);
                try {
                    if (!fileReader.ready()) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused) {
                        }
                        return null;
                    }
                    bufferedReader = new BufferedReader(fileReader);
                    try {
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            sb.append(line);
                        }
                        String string = sb.toString();
                        try {
                            bufferedReader.close();
                            fileReader.close();
                        } catch (Throwable unused2) {
                        }
                        return string;
                    } catch (Throwable unused3) {
                    }
                } catch (Throwable unused4) {
                    bufferedReader = null;
                }
            } catch (Throwable unused5) {
                fileReader = null;
                bufferedReader = null;
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                    if (fileReader != null) {
                        fileReader.close();
                    }
                } catch (Throwable unused6) {
                }
            } else if (fileReader != null) {
                fileReader.close();
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0069 A[Catch: all -> 0x006c, TRY_LEAVE, TryCatch #2 {all -> 0x006c, blocks: (B:25:0x0064, B:27:0x0069), top: B:36:0x0064 }] */
    public static boolean a(Context context, String str, String str2, String str3) {
        FileWriter fileWriter;
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            BufferedWriter bufferedWriter = null;
            try {
                File file = new File(b(context).getPath() + WVNativeCallbackUtil.SEPERATER + str + WVNativeCallbackUtil.SEPERATER);
                if (!file.exists()) {
                    file.mkdirs();
                }
                fileWriter = new FileWriter(new File(file, str2), false);
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter);
                    try {
                        bufferedWriter2.write(str3);
                        try {
                            bufferedWriter2.close();
                            fileWriter.close();
                        } catch (Throwable unused) {
                        }
                        return true;
                    } catch (Throwable unused2) {
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                                if (fileWriter != null) {
                                    fileWriter.close();
                                }
                            } catch (Throwable unused3) {
                            }
                        } else if (fileWriter != null) {
                            fileWriter.close();
                        }
                        return false;
                    }
                } catch (Throwable unused4) {
                }
            } catch (Throwable unused5) {
                fileWriter = null;
            }
        }
        return false;
    }

    public static void a(Context context) {
        File[] fileArrListFiles;
        File[] fileArrListFiles2;
        if (context == null) {
            return;
        }
        try {
            File fileB = b(context);
            if (fileB.exists() && fileB.isDirectory() && (fileArrListFiles = fileB.listFiles()) != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(System.currentTimeMillis() - 86400000);
                for (File file : fileArrListFiles) {
                    if (file.isDirectory() && (fileArrListFiles2 = file.listFiles()) != null) {
                        try {
                            for (File file2 : fileArrListFiles2) {
                                if (file2.isFile() && simpleDateFormat.parse(simpleDateFormat.format(Long.valueOf(file2.lastModified()))).before(date)) {
                                    file2.delete();
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            File fileB = b(context);
            if (fileB.exists() && fileB.isDirectory()) {
                File file = new File(fileB.getPath() + WVNativeCallbackUtil.SEPERATER + str + WVNativeCallbackUtil.SEPERATER, str2);
                if (file.exists()) {
                    file.delete();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
