package com.alibaba.alibclinkpartner.smartlink;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.alibaba.alibclinkpartner.smartlink.a.b;
import com.alibaba.alibclinkpartner.smartlink.b.a.d;
import com.alibaba.alibclinkpartner.smartlink.b.a.e;
import com.alibaba.alibclinkpartner.smartlink.b.a.i;
import com.alibaba.alibclinkpartner.smartlink.b.a.j;
import com.alibaba.alibclinkpartner.smartlink.b.a.k;
import com.alibaba.alibclinkpartner.smartlink.callback.ALPSmartLinkCallback;
import com.alibaba.alibclinkpartner.smartlink.config.ALSLConfigration;
import com.alibaba.alibclinkpartner.smartlink.config.ALSLContext;
import com.alibaba.alibclinkpartner.smartlink.config.ALSLUri;
import com.alibaba.alibclinkpartner.smartlink.constants.ALSLConfigConstants;
import com.alibaba.alibclinkpartner.smartlink.data.MatrixAppInfoDetail;
import com.alibaba.alibclinkpartner.smartlink.data.SafeConfig;
import com.alibaba.alibclinkpartner.smartlink.data.SmartLinkData;
import com.alibaba.alibclinkpartner.smartlink.data.SmartLinkDetail;
import com.alibaba.alibclinkpartner.smartlink.data.SmartLinkSwitch;
import com.alibaba.alibclinkpartner.smartlink.manager.ALSLAppCheckManager;
import com.alibaba.alibclinkpartner.smartlink.util.ALSLLogUtil;
import com.alibaba.alibclinkpartner.smartlink.util.ALSLSystemUtil;
import com.alibaba.alibclinkpartner.smartlink.util.c;
import com.alibaba.alibclinkpartner.smartlink.util.f;
import com.alibaba.alibclinkpartner.smartlink.util.g;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.ta.utdid2.device.UTDevice;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ALSLSmartLinkSDK {
    private static String formatParams(ALSLUri aLSLUri, String str) {
        HashMap map = new HashMap();
        StringBuffer stringBuffer = new StringBuffer();
        map.put("appkey", ALSLContext.instance().appkey);
        map.put("appName", ALSLSystemUtil.getAppName(ALSLContext.instance().mContext));
        map.put(ALPParamConstant.PACKAGENAME, aLSLUri.packageName);
        map.put("v", ALSLContext.instance().ALSLSDKVersion);
        map.put("source", "alsl");
        map.put("action", "ali.open.nav");
        map.put("module", aLSLUri.module);
        map.put("bc_fl_src", aLSLUri.bcFlSrc);
        map.put("bootImage", "0");
        map.put(ALPParamConstant.SDKNAME, ALSLConfigConstants.LINKPARTNER);
        Map<String, Object> map2 = aLSLUri.extraParam;
        if (map2 != null && map2.size() > 0) {
            String str2 = (String) aLSLUri.extraParam.get("tag");
            String str3 = (String) aLSLUri.extraParam.get("utdid");
            if (!TextUtils.isEmpty(str2)) {
                map.put("tag", str2);
            }
            if (TextUtils.isEmpty(str3)) {
                map.put("utdid", UTDevice.getUtdid(ALSLContext.instance().mContext));
            } else {
                map.put("utdid", str3);
            }
            aLSLUri.extraParam.remove("tag");
            aLSLUri.extraParam.remove("utdid");
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                try {
                    String strEncode = URLEncoder.encode((String) entry.getKey(), "UTF-8");
                    String strEncode2 = URLEncoder.encode((String) entry.getValue(), "UTF-8");
                    stringBuffer.append(strEncode);
                    stringBuffer.append("=");
                    stringBuffer.append(strEncode2);
                    stringBuffer.append("&");
                } catch (Throwable th) {
                    ALSLLogUtil.e("ALSLSmartLinkSDK", "formatParams", "url encode error t=" + th.toString());
                }
            }
        }
        if (aLSLUri.extraParam.size() > 0) {
            stringBuffer.append("params=");
            stringBuffer.append(c.a(aLSLUri.extraParam));
        }
        if (stringBuffer.toString().endsWith("&")) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        if (str.contains("?")) {
            return str + "&" + stringBuffer.toString();
        }
        return str + "?" + stringBuffer.toString();
    }

    private static void getBackUrlPackage() {
        try {
            if (System.currentTimeMillis() - ((Long) f.b(ALSLConfigConstants.LAST_SAFE_CONFIG_REQUEST_TIME, 0L)).longValue() < ((Long) f.b(ALSLConfigConstants.SAFE_PACKAGE_VALIDATE_TIME, 0L)).longValue()) {
                ALSLLogUtil.d("ALSLSmartLinkSDK", "getSmartLinkSwitch", "本地数据没过期，不拉数据");
            } else {
                ALSLLogUtil.d("ALSLSmartLinkSDK", "getSmartLinkSwitch", "本地数据过期，开始拉取数据");
                a.a(new Runnable() { // from class: com.alibaba.alibclinkpartner.smartlink.ALSLSmartLinkSDK.1
                    @Override // java.lang.Runnable
                    public void run() throws Throwable {
                        b bVarA = com.alibaba.alibclinkpartner.smartlink.a.a.a(ALSLConfigration.SAFE_PACKAGE_URL, (Map<String, String>) null);
                        if (bVarA.f23568a == 200) {
                            try {
                                JSONObject jSONObject = new JSONObject(bVarA.b);
                                SafeConfig safeConfig = new SafeConfig();
                                long j = jSONObject.getLong("validtime");
                                List<String> listA = c.a(jSONObject.getJSONArray("whiteList"));
                                safeConfig.setValidtime(j);
                                safeConfig.setWhiteList(listA);
                                f.c(ALSLConfigConstants.SAFE_PACKAGE_CONFIG, safeConfig);
                                f.a(ALSLConfigConstants.SAFE_PACKAGE_VALIDATE_TIME, Long.valueOf(j));
                                f.a(ALSLConfigConstants.LAST_SAFE_CONFIG_REQUEST_TIME, Long.valueOf(System.currentTimeMillis()));
                                ALSLLogUtil.d("ALSLSmartLinkSDK", "getBackUrlPackage", "拉到的包名数据：" + jSONObject);
                            } catch (Exception unused) {
                            }
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getH5DegradeUrl(ALSLUri aLSLUri) {
        StringBuilder sb;
        String str;
        String str2 = aLSLUri.degradeH5Url;
        String str3 = (str2 == null || str2.length() <= 0) ? aLSLUri.url : aLSLUri.degradeH5Url;
        if (str3.contains("?")) {
            sb = new StringBuilder();
            sb.append(str3);
            str = "&source=alsl";
        } else {
            sb = new StringBuilder();
            sb.append(str3);
            str = "?source=alsl";
        }
        sb.append(str);
        return sb.toString();
    }

    private static String getRegexUrl(ALSLUri aLSLUri, MatrixAppInfoDetail matrixAppInfoDetail) {
        String str;
        String strReplace = matrixAppInfoDetail.uri;
        Matcher matcher = Pattern.compile("\\$\\{(.*?)\\}").matcher(matrixAppInfoDetail.uri);
        while (matcher.find()) {
            String strGroup = matcher.group(0);
            String str2 = "${url}";
            if (!TextUtils.equals("${url}", strGroup) && !TextUtils.equals("${#url}", strGroup)) {
                str2 = "${backUrl}";
                if (TextUtils.equals("${backUrl}", strGroup) || TextUtils.equals("${#backUrl}", strGroup)) {
                    if (TextUtils.isEmpty(aLSLUri.backUrl)) {
                        strReplace = strReplace.replace(str2, "");
                    } else {
                        str = aLSLUri.backUrl;
                        strReplace = strReplace.replace(str2, g.d(str));
                    }
                } else if (strGroup.length() >= 3) {
                    String strSubstring = strGroup.substring(2, strGroup.length() - 1);
                    if (!TextUtils.isEmpty(strSubstring)) {
                        if (strSubstring.contains("#")) {
                            strSubstring = strSubstring.substring(1, strSubstring.length() - 1);
                        }
                        if (!TextUtils.isEmpty(strSubstring)) {
                            Map<String, Object> map = aLSLUri.extraParam;
                            if (map != null) {
                                String str3 = (String) map.get(strSubstring);
                                strReplace = strReplace.replace(strGroup, g.d(TextUtils.isEmpty(str3) ? "" : str3));
                                aLSLUri.extraParam.remove(strSubstring);
                            }
                        }
                    }
                    strReplace = strReplace.replace(strGroup, "");
                }
            } else if (TextUtils.isEmpty(aLSLUri.url)) {
                strReplace = strReplace.replace(str2, "");
            } else {
                str = aLSLUri.url;
                strReplace = strReplace.replace(str2, g.d(str));
            }
        }
        return strReplace;
    }

    public static void getSmartLinkSwitch() {
        try {
            if (System.currentTimeMillis() - ((Long) f.b(ALSLConfigConstants.SMART_LINK_SWITCH_TIME, 0L)).longValue() < 300000) {
                ALSLLogUtil.d("ALSLSmartLinkSDK", "getSmartLinkSwitch", "距离上次请求不到5分钟，不拉数据");
            } else {
                ALSLLogUtil.d("ALSLSmartLinkSDK", "getSmartLinkSwitch", "距离上次超过5分钟，开始拉取数据");
                a.a(new Runnable() { // from class: com.alibaba.alibclinkpartner.smartlink.ALSLSmartLinkSDK.2
                    @Override // java.lang.Runnable
                    public void run() throws Throwable {
                        f.a(ALSLConfigConstants.SMART_LINK_SWITCH_TIME, Long.valueOf(System.currentTimeMillis()));
                        b bVarA = com.alibaba.alibclinkpartner.smartlink.a.a.a(ALSLConfigration.SMART_LINK_SWITCH_URL, (Map<String, String>) null);
                        if (bVarA.f23568a == 200) {
                            try {
                                JSONObject jSONObject = new JSONObject(bVarA.b);
                                SmartLinkSwitch smartLinkSwitch = new SmartLinkSwitch();
                                smartLinkSwitch.smartLinkSwitch = jSONObject.getBoolean("smartLinkSwitch");
                                smartLinkSwitch.smartLinkGray = jSONObject.getInt("smartLinkGray");
                                f.c(ALSLConfigConstants.SMART_LINK_SWITCH, smartLinkSwitch);
                                ALSLLogUtil.d("ALSLSmartLinkSDK", "getSmartLinkSwitch", "拉到的开关数据：" + smartLinkSwitch);
                            } catch (Exception unused) {
                            }
                        }
                    }
                });
            }
        } catch (Exception e) {
            ALSLLogUtil.d("ALSLSmartLinkSDK", "getSmartLinkSwitch", "异常：" + e.getMessage());
        }
    }

    private static void go2DegradeWithUrl(ALSLUri aLSLUri, String str, boolean z, ALPSmartLinkCallback aLPSmartLinkCallback, int i) {
        String str2;
        String h5DegradeUrl;
        ALSLUri.ALSLdegradeType aLSLdegradeType = aLSLUri.degradeType;
        if (aLSLdegradeType != ALSLUri.ALSLdegradeType.NONE) {
            if (aLSLdegradeType != ALSLUri.ALSLdegradeType.H5 && aLSLdegradeType == ALSLUri.ALSLdegradeType.Download) {
                aLPSmartLinkCallback.getLinkUrl(false, aLSLUri.target, str, i);
            } else {
                str2 = aLSLUri.target;
                h5DegradeUrl = getH5DegradeUrl(aLSLUri);
            }
            i iVar = new i();
            iVar.d = aLSLUri.degradeType;
            iVar.f23574a = aLSLUri.target;
            iVar.c = aLSLUri.url;
            iVar.e = z;
            iVar.b = getH5DegradeUrl(aLSLUri);
            com.alibaba.alibclinkpartner.smartlink.manager.b.a(iVar);
        }
        str2 = aLSLUri.target;
        h5DegradeUrl = "";
        aLPSmartLinkCallback.getLinkUrl(false, str2, h5DegradeUrl, i);
        i iVar2 = new i();
        iVar2.d = aLSLUri.degradeType;
        iVar2.f23574a = aLSLUri.target;
        iVar2.c = aLSLUri.url;
        iVar2.e = z;
        iVar2.b = getH5DegradeUrl(aLSLUri);
        com.alibaba.alibclinkpartner.smartlink.manager.b.a(iVar2);
    }

    public static int init(Application application, String str) {
        if (application == null) {
            ALSLLogUtil.e("ALSLSmartLinkSDK", "init", "application is null");
            return 301;
        }
        if (ALSLContext.instance().isInit()) {
            ALSLLogUtil.e("ALSLSmartLinkSDK", "init", "已经初始化成功，无需再次初始化");
            return 201;
        }
        ALSLContext.instance().initContext(application, str);
        f.a(application, ALSLConfigConstants.SMART_LINK_SP);
        com.alibaba.alibclinkpartner.smartlink.manager.b.a(new e());
        ALSLConfigration.getMatrixAppList(application);
        getSmartLinkSwitch();
        application.registerActivityLifecycleCallbacks(new com.alibaba.alibclinkpartner.smartlink.manager.a());
        getBackUrlPackage();
        ALSLContext.instance().setInit(true);
        ALSLLogUtil.d("ALSLSmartLinkSDK", "init", "初始化成功");
        return 201;
    }

    private static void isSmartOpen(Context context, ALSLUri aLSLUri, ALPSmartLinkCallback aLPSmartLinkCallback, String str) {
        String str2;
        int iAbs = Math.abs(UTDevice.getUtdid(context).hashCode()) % 10000;
        SmartLinkSwitch smartLinkSwitch = (SmartLinkSwitch) f.d(ALSLConfigConstants.SMART_LINK_SWITCH, new SmartLinkSwitch());
        if (smartLinkSwitch != null) {
            boolean z = iAbs < smartLinkSwitch.smartLinkGray;
            if (smartLinkSwitch.smartLinkSwitch && z && !ALSLContext.instance().disableSmartLink) {
                openUrlWithSmart(context, aLSLUri, str, aLPSmartLinkCallback);
                str2 = "走智能唤端逻辑";
            } else {
                go2DegradeWithUrl(aLSLUri, str, false, aLPSmartLinkCallback, 310);
                str2 = "关闭智能唤端，走降级逻辑";
            }
            ALSLLogUtil.d("ALSLSmartLinkSDK", "init", str2);
        }
    }

    public static void openUrl(Context context, ALSLUri aLSLUri, ALPSmartLinkCallback aLPSmartLinkCallback) {
        String str;
        String str2;
        String str3;
        String str4;
        if (!ALSLContext.instance().isInit()) {
            str2 = "init";
            str3 = "唤端之前必须要初始化SDK";
            str4 = "ALSLSmartLinkSDK";
        } else {
            if (context != null) {
                com.alibaba.alibclinkpartner.smartlink.b.a.c cVar = new com.alibaba.alibclinkpartner.smartlink.b.a.c();
                cVar.c = aLSLUri.degradeType;
                cVar.f23571a = aLSLUri.target;
                cVar.b = aLSLUri.url;
                com.alibaba.alibclinkpartner.smartlink.manager.b.a(cVar);
                MatrixAppInfoDetail matrixAppInfoDetail = ALSLConfigration.sMatrixAPPData.appinfo.get(aLSLUri.target);
                if (matrixAppInfoDetail == null) {
                    str = "";
                } else {
                    if (tryOpenApp(context, aLSLUri, matrixAppInfoDetail)) {
                        aLPSmartLinkCallback.getLinkUrl(true, aLSLUri.target, getH5DegradeUrl(aLSLUri), 202);
                        d dVar = new d();
                        dVar.c = aLSLUri.degradeType;
                        dVar.f23572a = aLSLUri.target;
                        dVar.b = aLSLUri.url;
                        com.alibaba.alibclinkpartner.smartlink.manager.b.a(dVar);
                        return;
                    }
                    str = matrixAppInfoDetail.downloadUrl;
                }
                isSmartOpen(context, aLSLUri, aLPSmartLinkCallback, str);
                return;
            }
            str2 = BridgeDSL.INVOKE;
            str3 = "context is null";
            str4 = "ALPDistribution";
        }
        ALSLLogUtil.e(str4, str2, str3);
    }

    private static void openUrlWithSmart(final Context context, ALSLUri aLSLUri, String str, ALPSmartLinkCallback aLPSmartLinkCallback) {
        int i;
        String str2;
        ALSLLogUtil.d("ALSLSmartLinkSDK", "openUrlWithSmart", "进入能唤端逻辑");
        a.a(new Runnable() { // from class: com.alibaba.alibclinkpartner.smartlink.ALSLSmartLinkSDK.3
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                ALSLConfigration.updateSmartLinkData(context, ALSLContext.instance().appkey);
            }
        });
        if (ALSLConfigration.sSmartLinkData.data == null) {
            ALSLConfigration.sSmartLinkData = (SmartLinkData) f.d(ALSLConfigConstants.SMART_LINK_DATA, new SmartLinkData());
        }
        List<SmartLinkDetail> list = ALSLConfigration.sSmartLinkData.data;
        boolean z = false;
        if (list == null || list.size() == 0) {
            ALSLLogUtil.d("ALSLSmartLinkSDK", "openUrlWithSmart", "智能唤端信息为空，走降级逻辑");
            go2DegradeWithUrl(aLSLUri, str, false, aLPSmartLinkCallback, 302);
            return;
        }
        j jVar = new j();
        jVar.b = aLSLUri.target;
        jVar.f23575a = aLSLUri.url;
        jVar.c = aLSLUri.degradeType;
        com.alibaba.alibclinkpartner.smartlink.manager.b.a(jVar);
        ArrayList arrayList = new ArrayList();
        for (SmartLinkDetail smartLinkDetail : list) {
            List<String> list2 = smartLinkDetail.excludes;
            String str3 = ALSLContext.instance().appkey;
            if (list2 == null || list2.size() <= 0 || !list2.contains(str3)) {
                List<String> list3 = smartLinkDetail.patterns;
                if (list3.size() != 0) {
                    Iterator<String> it = list3.iterator();
                    while (it.hasNext()) {
                        if (Pattern.compile(it.next()).matcher(aLSLUri.url).matches()) {
                            arrayList.addAll(smartLinkDetail.targets);
                            break;
                        }
                    }
                    if (arrayList.size() > 0) {
                        ALSLLogUtil.d("ALSLSmartLinkSDK", "openUrlWithSmart", "匹配到的业务规则为：" + arrayList.size());
                        break;
                    }
                } else {
                    continue;
                }
            } else {
                ALSLLogUtil.d("ALSLSmartLinkSDK", "openUrlWithSmart", "需要智能唤端打开的APP在黑名单中，不能进行智能唤端");
            }
        }
        if (arrayList.size() > 0) {
            k kVar = new k();
            kVar.f23576a = aLSLUri.url;
            kVar.c = aLSLUri.degradeType;
            kVar.b = aLSLUri.target;
            kVar.d = arrayList;
            com.alibaba.alibclinkpartner.smartlink.manager.b.a(kVar);
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    str2 = "";
                    break;
                }
                str2 = (String) it2.next();
                if (tryOpenApp(context, aLSLUri, ALSLConfigration.sMatrixAPPData.appinfo.get(str2))) {
                    z = true;
                    break;
                }
            }
            if (z) {
                aLPSmartLinkCallback.getLinkUrl(true, str2, getH5DegradeUrl(aLSLUri), 202);
                com.alibaba.alibclinkpartner.smartlink.b.a.g gVar = new com.alibaba.alibclinkpartner.smartlink.b.a.g();
                gVar.f23573a = aLSLUri.target;
                gVar.c = aLSLUri.degradeType;
                gVar.d = str2;
                gVar.b = aLSLUri.url;
                com.alibaba.alibclinkpartner.smartlink.manager.b.a(gVar);
                return;
            }
            ALSLLogUtil.d("ALSLSmartLinkSDK", "openUrlWithSmart", "没有匹配到任何业务规则，进行降级：");
            i = 304;
        } else {
            ALSLLogUtil.d("ALSLSmartLinkSDK", "openUrlWithSmart", "没有匹配到任何业务规则，进行降级：" + arrayList.size());
            i = 305;
        }
        go2DegradeWithUrl(aLSLUri, str, true, aLPSmartLinkCallback, i);
    }

    public static boolean processIntent(Intent intent, Context context, ALSLUri aLSLUri) {
        String className;
        if (aLSLUri.intentProcessor == null) {
            return true;
        }
        String packageName = intent.getPackage();
        if (intent.getComponent() != null) {
            if (TextUtils.isEmpty(packageName)) {
                packageName = intent.getComponent().getPackageName();
            }
            className = intent.getComponent().getClassName();
        } else {
            ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 0);
            if (resolveInfoResolveActivity == null || resolveInfoResolveActivity.activityInfo == null) {
                className = null;
            } else {
                if (TextUtils.isEmpty(packageName)) {
                    packageName = resolveInfoResolveActivity.activityInfo.packageName;
                }
                className = resolveInfoResolveActivity.activityInfo.name;
            }
        }
        return aLSLUri.intentProcessor.process(intent, packageName, className, context);
    }

    private static boolean tryOpenApp(Context context, ALSLUri aLSLUri, MatrixAppInfoDetail matrixAppInfoDetail) {
        if (TextUtils.isEmpty(matrixAppInfoDetail.uri)) {
            ALSLLogUtil.e("ALSLSmartLinkSDK", "getMatrixAppList", "uri为空，打开失败");
            return false;
        }
        if (!ALSLAppCheckManager.isAppCanOpen(context, matrixAppInfoDetail.packageName)) {
            ALSLLogUtil.d("ALSLSmartLinkSDK", "tryOpenApp", "尝试唤端，但是APP未安装，走降级逻辑");
            return false;
        }
        String regexUrl = getRegexUrl(aLSLUri, matrixAppInfoDetail);
        int iA = com.alibaba.alibclinkpartner.smartlink.util.a.a(regexUrl, "?");
        if (iA > 0 && regexUrl.length() > 0) {
            for (int i = 1; i < iA; i++) {
                try {
                    int iLastIndexOf = regexUrl.lastIndexOf("?");
                    if (iLastIndexOf > 0) {
                        int iLastIndexOf2 = regexUrl.substring(0, iLastIndexOf - 1).lastIndexOf("=") + 1;
                        regexUrl = regexUrl.substring(0, iLastIndexOf2) + g.d(regexUrl.substring(iLastIndexOf2, regexUrl.length() - 1));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        String params = formatParams(aLSLUri, regexUrl);
        ALSLLogUtil.d("ALSLSmartLinkSDK", "tryOpenApp", "最终的唤端URL：" + params);
        f.a(matrixAppInfoDetail.packageName, params);
        Intent intent = new Intent();
        intent.setData(Uri.parse(params));
        intent.setPackage(matrixAppInfoDetail.packageName);
        if (!TextUtils.isEmpty(matrixAppInfoDetail.action)) {
            intent.setAction(matrixAppInfoDetail.action);
        }
        if (!processIntent(intent, context, aLSLUri)) {
            return false;
        }
        intent.setFlags(805339136);
        try {
            context.startActivity(intent);
            ALSLLogUtil.d("ALSLSmartLinkSDK", "tryOpenApp", "打开APP成功,包名为：" + matrixAppInfoDetail.packageName);
            return true;
        } catch (Exception e2) {
            ALSLLogUtil.d("ALSLSmartLinkSDK", "tryOpenApp", "尝试拉起：" + matrixAppInfoDetail.packageName + " 失败: " + e2.getMessage());
            return false;
        }
    }

    public static void turnOnDebug(boolean z) {
        ALSLLogUtil.isLog = z;
    }
}
