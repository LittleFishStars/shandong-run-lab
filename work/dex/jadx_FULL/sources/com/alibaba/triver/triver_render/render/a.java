package com.alibaba.triver.triver_render.render;

import android.app.Application;
import android.util.Log;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.parser.PackageParseUtils;
import com.alibaba.ariver.resource.parser.ParseContext;
import com.alibaba.triver.kit.api.network.HttpDownloader;
import com.alibaba.triver.kit.api.orange.TBShopOrangeController;
import com.alibaba.triver.triver_render.R;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25201a = "ComponentJsCache";
    private static final String b = "https://g.alicdn.com/??windmills/miniapp-components-demo/miniapp-components.js,dinamic/shop-framwork-miniapp-component/miniapp-components.js";
    private static final String c = "https://dev.g.alicdn.com/??windmills/miniapp-components-demo/miniapp-components.js,dinamic/shop-framwork-miniapp-component/miniapp-components.js";
    private static String d = null;
    private static volatile boolean e = false;

    public static String b() {
        return b;
    }

    public static synchronized void b(final String str) {
        a(str);
        if (e) {
            return;
        }
        new Thread(new Runnable() { // from class: com.alibaba.triver.triver_render.render.a.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                StringBuilder sb;
                boolean unused = a.e = true;
                FileWriter fileWriter = null;
                try {
                    try {
                        Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
                        if (applicationContext == null) {
                            boolean unused2 = a.e = false;
                            return;
                        }
                        File filesDir = applicationContext.getFilesDir();
                        if (!filesDir.exists()) {
                            RVLogger.e(a.f25201a, filesDir.getAbsolutePath() + "not exists");
                            boolean unused3 = a.e = false;
                            return;
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(filesDir.getAbsolutePath());
                        String str2 = File.separator;
                        sb2.append(str2);
                        sb2.append("mComponentJs");
                        File file = new File(sb2.toString());
                        if (!file.exists() && !file.mkdir()) {
                            RVLogger.e(a.f25201a, file.getAbsolutePath() + "not exists");
                            boolean unused4 = a.e = false;
                            return;
                        }
                        File file2 = new File(file.getAbsolutePath() + str2 + "jsFile.js");
                        if (file2.exists() && !file2.delete()) {
                            RVLogger.e(a.f25201a, "jsFile delete failed");
                            boolean unused5 = a.e = false;
                            return;
                        }
                        if (!file2.createNewFile()) {
                            RVLogger.e(a.f25201a, "jsFile create failed");
                            boolean unused6 = a.e = false;
                            return;
                        }
                        if (!file2.canWrite()) {
                            RVLogger.e(a.f25201a, "jsFile can not write");
                            boolean unused7 = a.e = false;
                            return;
                        }
                        FileWriter fileWriter2 = new FileWriter(file2);
                        try {
                            fileWriter2.write(str);
                            fileWriter2.flush();
                            try {
                                fileWriter2.close();
                            } catch (IOException e2) {
                                e = e2;
                                RVLogger.w(Log.getStackTraceString(e));
                                sb = new StringBuilder();
                                sb.append("save to file release writer failed :  ");
                                sb.append(e.getMessage());
                                RVLogger.e(a.f25201a, sb.toString());
                            }
                        } catch (IOException e3) {
                            e = e3;
                            fileWriter = fileWriter2;
                            RVLogger.w(Log.getStackTraceString(e));
                            RVLogger.e(a.f25201a, "save to file : " + e.getMessage());
                            if (fileWriter != null) {
                                try {
                                    fileWriter.close();
                                } catch (IOException e4) {
                                    e = e4;
                                    RVLogger.w(Log.getStackTraceString(e));
                                    sb = new StringBuilder();
                                    sb.append("save to file release writer failed :  ");
                                    sb.append(e.getMessage());
                                    RVLogger.e(a.f25201a, sb.toString());
                                }
                            }
                        } catch (Exception e5) {
                            e = e5;
                            fileWriter = fileWriter2;
                            RVLogger.w(Log.getStackTraceString(e));
                            RVLogger.e(a.f25201a, "save to file : " + e.getMessage());
                            if (fileWriter != null) {
                                try {
                                    fileWriter.close();
                                } catch (IOException e6) {
                                    e = e6;
                                    RVLogger.w(Log.getStackTraceString(e));
                                    sb = new StringBuilder();
                                    sb.append("save to file release writer failed :  ");
                                    sb.append(e.getMessage());
                                    RVLogger.e(a.f25201a, sb.toString());
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileWriter = fileWriter2;
                            if (fileWriter != null) {
                                try {
                                    fileWriter.close();
                                } catch (IOException e7) {
                                    RVLogger.w(Log.getStackTraceString(e7));
                                    RVLogger.e(a.f25201a, "save to file release writer failed :  " + e7.getMessage());
                                }
                            }
                            boolean unused8 = a.e = false;
                            throw th;
                        }
                        boolean unused9 = a.e = false;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException e8) {
                    e = e8;
                } catch (Exception e9) {
                    e = e9;
                }
            }
        }, "ComponentJsCache-SaveFile").start();
    }

    public static String c() {
        return c;
    }

    public static void c(String str) throws Throwable {
        File[] fileArrListFiles;
        byte[] bytes;
        if (str == null || (fileArrListFiles = new File(str).listFiles()) == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (file.getName().endsWith("tar")) {
                String absolutePath = file.getAbsolutePath();
                ParseContext parseContext = new ParseContext();
                parseContext.packagePath = absolutePath;
                HashMap map = new HashMap();
                PackageParseUtils.fastReadTarIntoMemory(map, absolutePath, parseContext);
                Resource resource = (Resource) map.get("renderComponents.js");
                if (resource != null && (bytes = resource.getBytes()) != null) {
                    b(new String(bytes, Charset.forName("UTF-8")));
                }
                Log.d("ShopPkgPreLoadJob", "resource map size : " + map.size());
                return;
            }
        }
    }

    public static synchronized void d() {
        String str;
        String str2;
        Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        FileReader fileReader = null;
        try {
            try {
                File filesDir = applicationContext.getFilesDir();
                if (!filesDir.exists()) {
                    RVLogger.e(f25201a, filesDir.getAbsolutePath() + "not exists 1");
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(filesDir.getAbsolutePath());
                String str3 = File.separator;
                sb.append(str3);
                sb.append("mComponentJs");
                File file = new File(sb.toString());
                if (!file.exists()) {
                    RVLogger.e(f25201a, file.getAbsolutePath() + "not exists 1");
                    return;
                }
                File file2 = new File(file.getAbsolutePath() + str3 + "jsFile.js");
                if (!file2.exists()) {
                    RVLogger.e(f25201a, file2.getAbsolutePath() + "not exists 1");
                    return;
                }
                if (!file2.canRead()) {
                    RVLogger.e(f25201a, "js File can not read");
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                FileReader fileReader2 = new FileReader(file2);
                try {
                    char[] cArr = new char[4096];
                    while (true) {
                        int i = fileReader2.read(cArr);
                        if (i <= 0) {
                            break;
                        } else {
                            sb2.append(cArr, 0, i);
                        }
                    }
                    a(sb2.toString());
                    try {
                        fileReader2.close();
                    } catch (IOException e2) {
                        RVLogger.w(Log.getStackTraceString(e2));
                        str = f25201a;
                        str2 = "load from file release reader failed : " + e2.getMessage();
                        RVLogger.e(str, str2);
                    }
                } catch (IOException e3) {
                    e = e3;
                    fileReader = fileReader2;
                    RVLogger.w(Log.getStackTraceString(e));
                    RVLogger.e(f25201a, "load from file : " + e.getMessage());
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e4) {
                            RVLogger.w(Log.getStackTraceString(e4));
                            str = f25201a;
                            str2 = "load from file release reader failed : " + e4.getMessage();
                            RVLogger.e(str, str2);
                        }
                    }
                } catch (Exception e5) {
                    e = e5;
                    fileReader = fileReader2;
                    RVLogger.w(Log.getStackTraceString(e));
                    RVLogger.e(f25201a, "load from file : " + e.getMessage());
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e6) {
                            RVLogger.w(Log.getStackTraceString(e6));
                            str = f25201a;
                            str2 = "load from file release reader failed : " + e6.getMessage();
                            RVLogger.e(str, str2);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileReader = fileReader2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e7) {
                            RVLogger.w(Log.getStackTraceString(e7));
                            RVLogger.e(f25201a, "load from file release reader failed : " + e7.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e8) {
            e = e8;
        } catch (Exception e9) {
            e = e9;
        }
    }

    public static String e() {
        String strA = a();
        if (strA != null) {
            return strA;
        }
        RVLogger.e(f25201a, "mComponentJs cache miss!");
        String strDownload = TBShopOrangeController.isComponentJsPreRelease() ? HttpDownloader.download(c()) : HttpDownloader.download(b());
        if (strDownload == null) {
            RVLogger.e(f25201a, "mComponentJs download failed!");
            return IOUtils.read(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext().getResources().openRawResource(R.raw.component));
        }
        if (TBShopOrangeController.isComponentJsPreRelease()) {
            return strDownload;
        }
        b(strDownload);
        return strDownload;
    }

    public static synchronized String a() {
        return d;
    }

    public static synchronized void a(String str) {
        d = str;
    }
}
