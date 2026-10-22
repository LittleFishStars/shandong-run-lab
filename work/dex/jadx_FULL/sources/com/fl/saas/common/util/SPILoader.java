package com.fl.saas.common.util;

import android.text.TextUtils;
import com.fl.saas.config.utils.FileHelper;
import com.fl.saas.config.utils.LogcatUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class SPILoader {
    private static final String PREFIX = "META-INF/services/";
    private static final String TAG = CommConstant.getClassTag(SPILoader.class);

    public static List<String> loadSPINames(ClassLoader classLoader, Class<?> cls) {
        String name = cls.getName();
        String str = PREFIX + name;
        String str2 = TAG;
        LogcatUtil.d(str2, "fullName:" + str);
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<URL> resources = classLoader.getResources(str);
            if (resources == null || !resources.hasMoreElements()) {
                LogcatUtil.d(str2, "urls is empty, parse assets");
                ArrayList<String> arrayList2 = parse(str);
                if (arrayList2.size() == 0) {
                    arrayList2 = parse(name);
                }
                arrayList.addAll(arrayList2);
            } else {
                while (resources.hasMoreElements()) {
                    arrayList.addAll(parse(resources.nextElement()));
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (name.contains("AdapterAPI")) {
            arrayList.add("com.yd.saas.zc.ZCVideoAdapter");
            arrayList.add("com.yd.saas.zc.ZCInterstitialAdapter");
            arrayList.add("com.yd.saas.zc.ZCBannerAdapter");
            arrayList.add("com.yd.saas.zc.ZCSpreadAdapter");
            arrayList.add("com.yd.saas.zc.ZCTemplateAdapter");
            arrayList.add("com.yd.saas.zc.ZCNativeAdapter");
        }
        if (name.contains("MixNativeAPI")) {
            arrayList.add("com.fl.saas.zc.mixNative.ZCMixNativeHandler");
        }
        return arrayList;
    }

    private static ArrayList<String> parse(InputStream inputStream) {
        String str;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    String str2 = TAG;
                    LogcatUtil.d(str2, "parse:" + line);
                    int iIndexOf = line.indexOf(35);
                    if (iIndexOf >= 0) {
                        line = line.substring(0, iIndexOf);
                    }
                    String strTrim = line.trim();
                    if (!TextUtils.isEmpty(strTrim)) {
                        if (strTrim.indexOf(32) >= 0 || strTrim.indexOf(9) >= 0) {
                            str = "SPI Illegal configuration-file syntax";
                        } else {
                            int iCodePointAt = strTrim.codePointAt(0);
                            if (Character.isJavaIdentifierStart(iCodePointAt)) {
                                int length = strTrim.length();
                                int iCharCount = Character.charCount(iCodePointAt);
                                while (iCharCount < length) {
                                    int iCodePointAt2 = strTrim.codePointAt(iCharCount);
                                    if (!Character.isJavaIdentifierPart(iCodePointAt2) && iCodePointAt2 != 46) {
                                        LogcatUtil.d(TAG, "SPI Illegal provider-class name: " + strTrim);
                                        break;
                                    }
                                    iCharCount += Character.charCount(iCodePointAt2);
                                }
                                if (!arrayList.contains(strTrim)) {
                                    arrayList.add(strTrim);
                                }
                            } else {
                                str = "SPI Illegal provider-class name: " + strTrim;
                            }
                        }
                        LogcatUtil.d(str2, str);
                    }
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    private static ArrayList<String> parse(String str) {
        try {
            InputStream assets = FileHelper.getAssets(str);
            try {
                ArrayList<String> arrayList = parse(assets);
                if (assets != null) {
                    assets.close();
                }
                return arrayList;
            } catch (Throwable th) {
                if (assets != null) {
                    try {
                        assets.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private static ArrayList<String> parse(URL url) {
        try {
            InputStream inputStreamOpenStream = url.openStream();
            try {
                ArrayList<String> arrayList = parse(inputStreamOpenStream);
                if (inputStreamOpenStream != null) {
                    inputStreamOpenStream.close();
                }
                return arrayList;
            } catch (Throwable th) {
                if (inputStreamOpenStream != null) {
                    try {
                        inputStreamOpenStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
            return new ArrayList<>();
        }
    }
}
