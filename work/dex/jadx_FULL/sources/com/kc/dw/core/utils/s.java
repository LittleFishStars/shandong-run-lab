package com.kc.dw.core.utils;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.content.FileProvider;
import com.alibaba.android.arouter.utils.Consts;
import com.kc.dw.core.service.SsdFileProvider;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f39404a;

    public static String a(String str) {
        try {
            Charset charset = d1.f39359a;
            return new String(Base64.decode(str, 0));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean a(Context context, String str) {
        try {
            boolean zA = a(context, context.getPackageName() + Consts.DOT + "SSDFileProvider", SsdFileProvider.class);
            if (zA) {
                f39404a = context.getPackageName() + Consts.DOT + "SSDFileProvider";
            }
            if (!zA && !TextUtils.isEmpty(str) && (zA = a(context, str, FileProvider.class))) {
                f39404a = str;
            }
            if (!zA) {
                LogUtil.w("s", a("cGxlYXNlIHNldHRpbmcgRmlsZVByb3ZpZGVy"));
            }
            return zA;
        } catch (Throwable th) {
            th.printStackTrace();
            LogUtil.e("s", "", th);
            return false;
        }
    }

    public static boolean a(Context context, String str, Class cls) {
        try {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(str, 128);
            if (providerInfoResolveContentProvider != null && cls.isAssignableFrom(Class.forName(providerInfoResolveContentProvider.name))) {
                try {
                    XmlResourceParser xmlResourceParserLoadXmlMetaData = providerInfoResolveContentProvider.loadXmlMetaData(context.getPackageManager(), a("YW5kcm9pZC5zdXBwb3J0LkZJTEVfUFJPVklERVJfUEFUSFM="));
                    if (xmlResourceParserLoadXmlMetaData == null) {
                        LogUtil.e("s", a("TWlzc2luZyBhbmRyb2lkLnN1cHBvcnQuRklMRV9QUk9WSURFUl9QQVRIUyBtZXRhLWRhdGE="));
                        return true;
                    }
                    boolean z = false;
                    while (true) {
                        int next = xmlResourceParserLoadXmlMetaData.next();
                        if (next == 1) {
                            break;
                        }
                        if (next == 2) {
                            String name = xmlResourceParserLoadXmlMetaData.getName();
                            xmlResourceParserLoadXmlMetaData.getAttributeValue(null, "name");
                            String attributeValue = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, "path");
                            if ("root-path".equals(name)) {
                                if (Consts.DOT.equals(attributeValue)) {
                                    z = true;
                                }
                            } else if ("external-path".equals(name)) {
                                if (Consts.DOT.equals(attributeValue)) {
                                    z = true;
                                }
                            } else if ("external-files-path".equals(name) && (Consts.DOT.equals(attributeValue) || "Download".equalsIgnoreCase(attributeValue))) {
                                z = true;
                            }
                        }
                    }
                    xmlResourceParserLoadXmlMetaData.close();
                    if (!z) {
                        LogUtil.w("s", a("cGxlYXNlIGFkZCA8ZXh0ZXJuYWwtZmlsZXMtcGF0aCBuYW1lPSJkb3dubG9hZCIgcGF0aD0iRG93bmxvYWQiLz4gaW4g") + "SSDFileProvider");
                    }
                    return true;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return false;
    }
}
