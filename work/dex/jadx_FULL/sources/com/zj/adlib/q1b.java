package com.zj.adlib;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Environment;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class q1b {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Context f18980a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static AssetManager f18981a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Resources f18983a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f18986a = true;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static Resources f18987b = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f18984a = "amap_resource";

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static String f18988b = "1_0_0";
    public static String d = ".jar";
    public static String e = f18984a + f18988b + d;
    public static String c = ".png";
    public static String f = f18984a + f18988b + c;
    public static String g = "";
    public static String h = g + e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Resources.Theme f18982a = null;
    public static Resources.Theme b = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Field f18985a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static Field f18989b = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Activity f18979a = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f44105a = -1;

    public static class a implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(q1b.f18988b);
            sb.append(q1b.d);
            return str.startsWith(q1b.f18984a) && !str.endsWith(sb.toString());
        }
    }

    public static AssetManager a(String str) {
        AssetManager assetManager = null;
        try {
            Class<?> cls = Class.forName("android.content.res.AssetManager");
            AssetManager assetManager2 = (AssetManager) cls.getConstructor(null).newInstance(null);
            try {
                cls.getDeclaredMethod("addAssetPath", String.class).invoke(assetManager2, str);
                return assetManager2;
            } catch (Throwable th) {
                th = th;
                assetManager = assetManager2;
                a7b.m(th, "ResourcesUtil", "getAssetManager(String apkPath)");
                return assetManager;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Resources b() {
        Resources resources = f18983a;
        return resources == null ? f18980a.getResources() : resources;
    }

    public static Resources c(Context context, AssetManager assetManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.setToDefaults();
        return new Resources(assetManager, displayMetrics, context.getResources().getConfiguration());
    }

    public static View d(Context context, int i) {
        XmlResourceParser xml = b().getXml(i);
        View viewInflate = null;
        if (!f18986a) {
            return LayoutInflater.from(context).inflate(xml, (ViewGroup) null);
        }
        try {
            int i2 = f44105a;
            if (i2 == -1) {
                i2 = 0;
            }
            viewInflate = LayoutInflater.from(new l1b(context, i2, q1b.class.getClassLoader())).inflate(xml, (ViewGroup) null);
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                a7b.m(th, "ResourcesUtil", "selfInflate(Activity activity, int resource, ViewGroup root)");
            } finally {
                xml.close();
            }
        }
        return viewInflate;
    }

    public static OutputStream e(InputStream inputStream) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(g, e));
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i <= 0) {
                return fileOutputStream;
            }
            fileOutputStream.write(bArr, 0, i);
        }
    }

    public static boolean f(Context context) {
        try {
            f18980a = context;
            File fileG = g(context);
            if (fileG != null) {
                g = fileG.getAbsolutePath() + WVNativeCallbackUtil.SEPERATER;
            }
            h = g + e;
            if (!f18986a) {
                return true;
            }
            if (!k(context)) {
                return false;
            }
            AssetManager assetManagerA = a(h);
            f18981a = assetManagerA;
            f18983a = c(context, assetManagerA);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return true;
    }

    public static File g(Context context) {
        try {
            if (context == null) {
                if (context != null) {
                    context.getFilesDir();
                }
                return null;
            }
            try {
                File externalFilesDir = (Environment.getExternalStorageState().equals("mounted") && Environment.getExternalStorageDirectory().canWrite()) ? context.getExternalFilesDir("LBS") : context.getFilesDir();
                if (externalFilesDir == null) {
                    context.getFilesDir();
                }
                return externalFilesDir;
            } catch (Exception e2) {
                e2.printStackTrace();
                if (0 == 0) {
                    return context.getFilesDir();
                }
                return null;
            }
        } catch (Throwable th) {
            if (0 == 0) {
                context.getFilesDir();
            }
            throw th;
        }
    }

    public static boolean i(InputStream inputStream) throws IOException {
        File file = new File(h);
        long length = file.length();
        int iAvailable = inputStream.available();
        if (!file.exists() || length != iAvailable) {
            return false;
        }
        inputStream.close();
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003c A[Catch: IOException -> 0x0038, TRY_LEAVE, TryCatch #0 {IOException -> 0x0038, blocks: (B:14:0x0034, B:18:0x003c), top: B:38:0x0034 }] */
    public static boolean k(Context context) {
        m(context);
        InputStream inputStreamOpen = null;
        try {
            inputStreamOpen = context.getResources().getAssets().open(f);
            if (i(inputStreamOpen)) {
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        a7b.m(e2, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                    }
                }
                return true;
            }
            n();
            OutputStream outputStreamE = e(inputStreamOpen);
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                    if (outputStreamE != null) {
                        outputStreamE.close();
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                    a7b.m(e3, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                }
            } else if (outputStreamE != null) {
                outputStreamE.close();
            }
            return true;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                a7b.m(th, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                if (inputStreamOpen == null) {
                    return false;
                }
                try {
                    return false;
                } catch (IOException e4) {
                    return false;
                }
            } finally {
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                        a7b.m(e5, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                    }
                }
            }
        }
    }

    public static void m(Context context) {
        g = context.getFilesDir().getAbsolutePath();
        h = g + WVNativeCallbackUtil.SEPERATER + e;
    }

    public static void n() {
        File[] fileArrListFiles = new File(g).listFiles(new a());
        if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
            return;
        }
        for (File file : fileArrListFiles) {
            file.delete();
        }
    }
}
