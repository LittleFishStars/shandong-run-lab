package com.alibaba.ariver.commonability.file;

import android.net.Uri;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.alibaba.ariver.commonability.file.proxy.RVFileAbilityProxy;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24010a = "AOMPFileTinyAppUtils";

    public static String a() {
        RVFileAbilityProxy rVFileAbilityProxy = (RVFileAbilityProxy) RVProxy.get(RVFileAbilityProxy.class);
        if (rVFileAbilityProxy != null) {
            return rVFileAbilityProxy.getUserId();
        }
        RVLogger.e(f24010a, "provider ==null ");
        return null;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strC = c(str);
        return (TextUtils.isEmpty(strC) || !strC.startsWith("file://")) ? strC : strC.replaceAll("file://", "");
    }

    public static String c(String str) {
        String strA;
        if (str.endsWith("image")) {
            strA = a(str, "image");
            if (!TextUtils.isEmpty(strA)) {
                str = e(strA);
            }
        } else if (str.endsWith("video")) {
            strA = a(str, "video");
            if (!TextUtils.isEmpty(strA)) {
                str = e(strA);
            }
        } else if (str.endsWith("audio")) {
            strA = a(str, "audio");
            if (!TextUtils.isEmpty(strA)) {
                str = e(strA);
            }
        } else {
            OfficeFileType officeFileType = OfficeFileType.Pdf;
            if (str.endsWith(officeFileType.fileType())) {
                strA = a(str, officeFileType.fileType());
                if (!TextUtils.isEmpty(strA)) {
                    str = e(strA);
                }
            } else {
                OfficeFileType officeFileType2 = OfficeFileType.Doc;
                if (str.endsWith(officeFileType2.fileType())) {
                    strA = a(str, officeFileType2.fileType());
                    if (!TextUtils.isEmpty(strA)) {
                        str = e(strA);
                    }
                } else {
                    OfficeFileType officeFileType3 = OfficeFileType.Docx;
                    if (str.endsWith(officeFileType3.fileType())) {
                        strA = a(str, officeFileType3.fileType());
                        if (!TextUtils.isEmpty(strA)) {
                            str = e(strA);
                        }
                    } else {
                        OfficeFileType officeFileType4 = OfficeFileType.Xls;
                        if (str.endsWith(officeFileType4.fileType())) {
                            strA = a(str, officeFileType4.fileType());
                            if (!TextUtils.isEmpty(strA)) {
                                str = e(strA);
                            }
                        } else {
                            OfficeFileType officeFileType5 = OfficeFileType.Xlsx;
                            if (str.endsWith(officeFileType5.fileType())) {
                                strA = a(str, officeFileType5.fileType());
                                if (!TextUtils.isEmpty(strA)) {
                                    str = e(strA);
                                }
                            } else {
                                OfficeFileType officeFileType6 = OfficeFileType.PPt;
                                if (str.endsWith(officeFileType6.fileType())) {
                                    strA = a(str, officeFileType6.fileType());
                                    if (!TextUtils.isEmpty(strA)) {
                                        str = e(strA);
                                    }
                                } else {
                                    OfficeFileType officeFileType7 = OfficeFileType.PPtx;
                                    if (str.endsWith(officeFileType7.fileType())) {
                                        strA = a(str, officeFileType7.fileType());
                                        if (!TextUtils.isEmpty(strA)) {
                                            str = e(strA);
                                        }
                                    } else {
                                        strA = a(str, "other");
                                        if (TextUtils.isEmpty(strA)) {
                                            strA = d(str);
                                            if (!TextUtils.isEmpty(strA) && strA.startsWith(com.alibaba.ariver.commonability.file.proxy.b.f24036a)) {
                                                str = e(strA);
                                            }
                                        } else {
                                            str = e(strA);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        RVLogger.d(f24010a, "id:" + strA + " filePath:" + str);
        return str;
    }

    public static String d(String str) {
        String[] strArrSplit;
        Uri uriB = i.b(str);
        if (uriB == null || TextUtils.isEmpty(uriB.getPath()) || (strArrSplit = uriB.getPath().replace(WVNativeCallbackUtil.SEPERATER, "").split("\\.")) == null || strArrSplit.length <= 1) {
            return null;
        }
        String str2 = strArrSplit[0];
        try {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            return str2;
        } catch (Exception e) {
            RVLogger.e(f24010a, e);
            return null;
        }
    }

    public static String e(String str) {
        return com.alibaba.ariver.commonability.file.proxy.b.a().b(str);
    }

    public static String f(String str) {
        if (str == null) {
            return "other";
        }
        String str2 = "image";
        if (!str.contains("image")) {
            str2 = "video";
            if (!str.contains("video")) {
                str2 = "audio";
                if (!str.contains("audio")) {
                    OfficeFileType officeFileType = OfficeFileType.Pdf;
                    if (str.contains(officeFileType.fileType())) {
                        return officeFileType.fileType();
                    }
                    OfficeFileType officeFileType2 = OfficeFileType.Doc;
                    if (str.contains(officeFileType2.fileType())) {
                        return officeFileType2.fileType();
                    }
                    OfficeFileType officeFileType3 = OfficeFileType.Docx;
                    if (str.contains(officeFileType3.fileType())) {
                        return officeFileType3.fileType();
                    }
                    OfficeFileType officeFileType4 = OfficeFileType.Xls;
                    if (str.contains(officeFileType4.fileType())) {
                        return officeFileType4.fileType();
                    }
                    OfficeFileType officeFileType5 = OfficeFileType.Xlsx;
                    if (str.contains(officeFileType5.fileType())) {
                        return officeFileType5.fileType();
                    }
                    OfficeFileType officeFileType6 = OfficeFileType.PPt;
                    if (str.contains(officeFileType6.fileType())) {
                        return officeFileType6.fileType();
                    }
                    OfficeFileType officeFileType7 = OfficeFileType.PPtx;
                    return str.contains(officeFileType7.fileType()) ? officeFileType7.fileType() : "other";
                }
            }
        }
        return str2;
    }

    public static String a(String str) {
        return com.alibaba.ariver.commonability.file.proxy.b.a().a(str);
    }

    public static String a(String str, String str2) {
        if (str != null && str.startsWith(g.e) && str.endsWith(str2)) {
            return d(str);
        }
        return null;
    }

    public static String a(ApiContext apiContext) {
        String pluginId = apiContext.getPluginId();
        if (TextUtils.isEmpty(pluginId)) {
            return apiContext.getAppId();
        }
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        String config = rVConfigService.getConfig("ta_close_plugin_distinguish_file", "");
        if (!TextUtils.isEmpty(config) && "true".equalsIgnoreCase(config)) {
            return apiContext.getAppId();
        }
        if (Arrays.asList(rVConfigService.getConfig("ta_close_distinguish_file_pluginIds", "").split(",")).contains(pluginId)) {
            return apiContext.getAppId();
        }
        return apiContext.getAppId() + pluginId;
    }
}
