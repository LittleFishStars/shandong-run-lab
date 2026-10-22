package com.fl.saas.base.rest;

import android.content.Context;
import android.text.TextUtils;
import com.fl.saas.common.rest.AdHttpUtils;
import com.fl.saas.config.http.HttpCallbackBytesListener;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.FileHelper;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.config.utils.MD5Utils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class PreResManager {
    public static final String IMAGE_CACHE = "image";
    public static final String RAIN_CACHE = "RainRed";
    private static final String SDK_CACHE_DIR = "saas_cache";

    public static String checkImageCache(String str) {
        try {
            Context context = DeviceUtil.getContext();
            if (context == null || TextUtils.isEmpty(str) || !str.contains("https://creative.medproad.com/medpro/imgs/")) {
                return "";
            }
            String path = context.getCacheDir().getPath();
            StringBuilder sb = new StringBuilder();
            sb.append(SDK_CACHE_DIR);
            String str2 = File.separator;
            sb.append(str2);
            sb.append("image");
            String str3 = path + str2 + sb.toString() + str2 + MD5Utils.getMD5(str);
            if (new File(str3).exists()) {
                return str3;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static List<String> getDirInAllFilePath(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        File file = new File(context.getCacheDir(), SDK_CACHE_DIR + File.separator + str);
        return (file.exists() && file.isDirectory()) ? FileHelper.getFileNamesInDirectory(file) : new ArrayList();
    }

    private static void handleDown(final String str, final String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        AdHttpUtils.getInstance().doGet(str2, new HttpCallbackBytesListener() { // from class: com.fl.saas.base.rest.PreResManager.1
            @Override // com.fl.saas.config.http.HttpCallbackBytesListener
            public void onError(Exception exc) {
                LogcatUtil.d(String.format(Locale.CHINA, "PreResManager, onFailure, code:%d, msg:%s, url:%s", 20405, exc.getMessage(), str2));
            }

            @Override // com.fl.saas.config.http.HttpCallbackBytesListener
            public void onSuccess(byte[] bArr) {
                try {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                    try {
                        File file = new File(str + File.separator + MD5Utils.getMD5(str2));
                        if (file.exists()) {
                            if (file.isDirectory()) {
                                FileHelper.deleteAllFilesInDirectory(file);
                            } else {
                                file.delete();
                            }
                        }
                        file.createNewFile();
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            try {
                                byte[] bArr2 = new byte[1024];
                                while (true) {
                                    int i = byteArrayInputStream.read(bArr2);
                                    if (i == -1) {
                                        break;
                                    } else {
                                        fileOutputStream.write(bArr2, 0, i);
                                    }
                                }
                                fileOutputStream.close();
                                byteArrayInputStream.close();
                            } catch (Throwable th) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (Throwable th3) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                        throw th3;
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        });
    }

    public static void handleDownload(String str, List<String> list) {
        Context context = DeviceUtil.getContext();
        if (context == null) {
            return;
        }
        File cacheDir = context.getCacheDir();
        String path = cacheDir.getPath();
        String str2 = SDK_CACHE_DIR + File.separator + str;
        File file = new File(cacheDir, str2);
        if (list == null || list.isEmpty()) {
            if (file.exists() && file.isDirectory()) {
                FileHelper.deleteAllFilesInDirectory(file);
                return;
            }
            return;
        }
        HashMap map = new HashMap();
        for (String str3 : list) {
            map.put(MD5Utils.getMD5(str3), str3);
        }
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                    for (File file2 : fileArrListFiles) {
                        String name = file2.getName();
                        if (map.containsKey(name)) {
                            map.remove(name);
                        } else {
                            try {
                                file2.delete();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            } else {
                try {
                    file.delete();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (map.isEmpty()) {
            return;
        }
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        if (file.exists()) {
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                handleDown(path + File.separator + str2, (String) it.next());
            }
        }
    }

    public static boolean isRainRedCacheEmpty() {
        List<String> dirInAllFilePath;
        Context context = DeviceUtil.getContext();
        return context == null || (dirInAllFilePath = getDirInAllFilePath(context, RAIN_CACHE)) == null || dirInAllFilePath.size() <= 4;
    }

    public static void loadImageCache() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("https://creative.medproad.com/medpro/imgs/yd_saas_bg_click_area.webp");
        arrayList.add("https://creative.medproad.com/medpro/imgs/944e91c4ed73a3267d43f9b9eee5bea.png");
        arrayList.add("https://creative.medproad.com/medpro/imgs/yd_saas_custom_spread_bg.webp");
        arrayList.add("https://creative.medproad.com/medpro/imgs/yd_saas_icon_all_arrow.webp");
        arrayList.add("https://creative.medproad.com/medpro/imgs/yd_saas_icon_envelope_bottom.webp");
        arrayList.add("https://creative.medproad.com/medpro/imgs/yd_saas_icon_envelope_top.webp");
        arrayList.add("https://creative.medproad.com/medpro/imgs/yd_saas_spread_guide.webp");
        handleDownload("image", arrayList);
    }
}
