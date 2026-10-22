package com.alibaba.ariver.permission.service;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.EntryInfo;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVAccountService;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.storage.KVStorageProxy;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.PatternUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.permission.AppPermissionUtils;
import com.alibaba.ariver.permission.R;
import com.alibaba.ariver.permission.api.extension.OfficialAppPoint;
import com.alibaba.ariver.permission.api.proxy.AuthDialogProxy;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.permission.api.proxy.DomainConfigProxy;
import com.alibaba.ariver.permission.api.proxy.SettingExtendProxy;
import com.alibaba.ariver.permission.b.d;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PermissionModel;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.embed.video.video.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f24370a = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, String> b = new ConcurrentHashMap<>();
    public static final List<String> c;
    public static final String d = "1";
    public static final String e = "0";
    public static final String f = "-1";
    private static final String g = "AriverPermission:LocalAuthPermissionManager";
    private static final String h = "snapshot";
    private static final String i = "获取你的位置信息";
    private static final String j = "使用你的摄像头";
    private static final String k = "访问你的相册";
    private static final String l = "访问你的麦克风";
    private static final String m = "使用你的蓝牙";
    private static final String n = "获取你通讯录信息";
    private static final String o = "获取你在支付宝首页选择的城市";
    private static boolean p;
    private String q;

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f24375a;
        NativeCallContext b;
        AuthenticationProxy.LocalPermissionCallback c;

        public b(String str, NativeCallContext nativeCallContext, AuthenticationProxy.LocalPermissionCallback localPermissionCallback) {
            this.f24375a = str;
            this.b = nativeCallContext;
            this.c = localPermissionCallback;
        }
    }

    public interface c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f24376a = "scope.userInfo";
        public static final String b = "scope.location";
        public static final String c = "scope.address";
        public static final String d = "scope.invoiceTitle";
        public static final String e = "scope.alirun";
        public static final String f = "scope.audioRecord";
        public static final String g = "scope.album";
        public static final String h = "scope.camera";
        public static final String i = "scope.bluetooth";
        public static final String j = "scope.ta_tb_auth";
        public static final String k = "scope.contact";
        public static final String l = "scope.mainCity";
    }

    static {
        ArrayList arrayList = new ArrayList();
        c = arrayList;
        p = false;
        arrayList.add("NBComponent.render");
        arrayList.add("NBComponent.sendMessage");
    }

    public a() {
        b();
        a();
    }

    private void b() {
        String string;
        String string2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (p) {
            return;
        }
        p = true;
        Context context = ProcessUtils.getContext();
        if (context == null) {
            str = i;
            str2 = j;
            str3 = k;
            string = l;
            str4 = m;
            str5 = n;
            string2 = o;
        } else {
            Resources resources = context.getResources();
            String string3 = resources.getString(R.string.tiny_request_location_permission);
            String string4 = resources.getString(R.string.tiny_request_camera_permission);
            string = resources.getString(R.string.tiny_request_record_permission);
            String string5 = resources.getString(R.string.tiny_request_photo_permission);
            String string6 = resources.getString(R.string.tiny_request_bluetooth_permission);
            String string7 = resources.getString(R.string.tiny_request_contact_permission);
            string2 = resources.getString(R.string.tiny_request_maincity_permission);
            str = string3;
            str2 = string4;
            str3 = string5;
            str4 = string6;
            str5 = string7;
        }
        ConcurrentHashMap<String, String> concurrentHashMap = f24370a;
        concurrentHashMap.put("getLocation", str);
        concurrentHashMap.put("getCurrentLocation", str);
        concurrentHashMap.put("authMapLocation", str);
        concurrentHashMap.put("scan", str2);
        concurrentHashMap.put("chooseImage", "%s\n%s");
        concurrentHashMap.put("chooseVideo", "%s\n%s");
        concurrentHashMap.put("saveImage", str3);
        concurrentHashMap.put("startAudioRecord", string);
        concurrentHashMap.put("stopAudioRecord", string);
        concurrentHashMap.put("cancelAudioRecord", string);
        concurrentHashMap.put("saveVideoToPhotosAlbum", str3);
        concurrentHashMap.put("shareTokenImageSilent", str3);
        concurrentHashMap.put("enableBluetooth", str4);
        concurrentHashMap.put("connectBLEDevice", str4);
        concurrentHashMap.put("openBluetoothAdapter", str4);
        concurrentHashMap.put("getBeacons", str4);
        concurrentHashMap.put("NBComponent.render", "%s\n%s");
        concurrentHashMap.put("NBComponent.sendMessage", "%s\n%s");
        concurrentHashMap.put("contact", str5);
        concurrentHashMap.put("chooseContact", str5);
        concurrentHashMap.put("APSocialNebulaPlugin.selectContactJSAPI", str5);
        concurrentHashMap.put("getMainSelectedCity", string2);
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.permission.service.a$a, reason: collision with other inner class name */
    public static class C0148a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map<String, List<b>> f24374a = new ConcurrentHashMap();

        @Nullable
        public static List<b> a(Node node, String str) {
            Map<String, List<b>> map;
            App app = (App) node.bubbleFindNode(App.class);
            if (app == null || (map = ((C0148a) app.getData(C0148a.class, true)).f24374a) == null) {
                return null;
            }
            return map.get(str);
        }

        @Nullable
        public static List<b> b(Node node, String str) {
            App app = (App) node.bubbleFindNode(App.class);
            if (app == null) {
                return null;
            }
            Map<String, List<b>> map = ((C0148a) app.getData(C0148a.class, true)).f24374a;
            RVLogger.d(a.g, "PermissionDialogData remove scope " + str + " with node: " + app);
            if (map != null) {
                return map.remove(str);
            }
            return null;
        }

        public static void a(Node node, String str, List<b> list) {
            App app = (App) node.bubbleFindNode(App.class);
            if (app == null) {
                return;
            }
            Map<String, List<b>> map = ((C0148a) app.getData(C0148a.class, true)).f24374a;
            RVLogger.d(a.g, "PermissionDialogData add scope " + str + " resultObjects " + list + " with node: " + app);
            if (map != null) {
                map.put(str, list);
            }
        }
    }

    private void a() {
        a(ProcessUtils.getContext());
    }

    private void a(Context context) {
        try {
            SettingExtendProxy settingExtendProxy = (SettingExtendProxy) RVProxy.get(SettingExtendProxy.class);
            if (settingExtendProxy == null) {
                return;
            }
            String extendAction = settingExtendProxy.getExtendAction();
            String extendDescription = settingExtendProxy.getExtendDescription();
            this.q = settingExtendProxy.getExtendScope();
            if (TextUtils.isEmpty(extendAction) || TextUtils.isEmpty(extendDescription)) {
                return;
            }
            JSONArray array = JSONUtils.parseArray(extendAction);
            JSONArray array2 = JSONUtils.parseArray(extendDescription);
            JSONArray array3 = JSONUtils.parseArray(this.q);
            if (array == null || array2 == null || array.size() <= 0 || array2.size() <= 0) {
                return;
            }
            for (int i2 = 0; i2 < array.size(); i2++) {
                RVLogger.d(g, "put ext action " + extendAction);
                String str = (String) array.get(i2);
                String str2 = (String) array2.get(i2);
                String str3 = (String) array3.get(i2);
                f24370a.put(str, str2);
                b.put(str, str3);
            }
        } catch (Exception e2) {
            RVLogger.e(g, "loadExtApiForInside exception", e2);
        }
    }

    public static String a(Context context, String str) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return null;
            }
            return bundle.getString(str);
        } catch (Exception e2) {
            RVLogger.e(g, "getStringValueFromMetaData ", e2);
            return null;
        }
    }

    private boolean a(Page page) {
        if (page == null) {
            return false;
        }
        return page.getEmbedType().isEmbedPage();
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01bc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:103:0x01be  */
    /* JADX WARN: Code duplicated, block: B:105:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:107:0x01de  */
    /* JADX WARN: Code duplicated, block: B:109:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:112:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:116:0x0210  */
    /* JADX WARN: Code duplicated, block: B:122:0x0237  */
    /* JADX WARN: Code duplicated, block: B:130:0x024e  */
    /* JADX WARN: Code duplicated, block: B:131:0x0253  */
    /* JADX WARN: Code duplicated, block: B:133:0x0256  */
    /* JADX WARN: Code duplicated, block: B:135:0x027a  */
    /* JADX WARN: Code duplicated, block: B:137:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:193:0x03a5  */
    /* JADX WARN: Code duplicated, block: B:195:0x03ab  */
    /* JADX WARN: Code duplicated, block: B:196:0x03be  */
    /* JADX WARN: Code duplicated, block: B:198:0x03c5  */
    /* JADX WARN: Code duplicated, block: B:200:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:210:0x03f1  */
    /* JADX WARN: Code duplicated, block: B:215:0x041e  */
    /* JADX WARN: Code duplicated, block: B:219:0x0448  */
    /* JADX WARN: Code duplicated, block: B:225:0x0460  */
    /* JADX WARN: Code duplicated, block: B:227:0x0466  */
    /* JADX WARN: Code duplicated, block: B:230:0x046b  */
    /* JADX WARN: Code duplicated, block: B:231:0x046d  */
    /* JADX WARN: Code duplicated, block: B:236:0x04a4  */
    /* JADX WARN: Code duplicated, block: B:238:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:240:0x04ac  */
    /* JADX WARN: Code duplicated, block: B:248:0x04cb  */
    /* JADX WARN: Code duplicated, block: B:250:0x04d0  */
    /* JADX WARN: Code duplicated, block: B:264:0x0209 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:265:0x0217 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:267:? A[LOOP:1: B:110:0x01f5->B:267:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:269:0x0442 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:270:0x045a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:272:0x0418 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:273:0x0418 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x009b  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a2 A[Catch: Exception -> 0x00a9, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x00a9, blocks: (B:35:0x0090, B:42:0x00a2, B:56:0x00e1, B:73:0x0127, B:81:0x0153), top: B:256:0x0090 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00c7 A[Catch: Exception -> 0x0168, TryCatch #2 {Exception -> 0x0168, blocks: (B:40:0x009c, B:47:0x00af, B:49:0x00b5, B:50:0x00c1, B:52:0x00c7, B:54:0x00d3, B:59:0x00f9, B:62:0x0104, B:66:0x010d, B:69:0x0119, B:71:0x0121, B:75:0x013d, B:77:0x0145, B:79:0x014d), top: B:257:0x009c }] */
    /* JADX WARN: Code duplicated, block: B:89:0x0186  */
    /* JADX WARN: Code duplicated, block: B:91:0x018d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x018f  */
    /* JADX WARN: Code duplicated, block: B:93:0x0198  */
    /* JADX WARN: Code duplicated, block: B:96:0x01a8  */
    /* JADX WARN: Instruction removed from duplicated block: B:133:0x0256, please report this as an issue */
    public boolean a(Permission permission, NativeCallContext nativeCallContext, AuthenticationProxy.LocalPermissionCallback localPermissionCallback, Page page) {
        boolean z;
        String string;
        List<String> stringArray;
        String strA;
        List<b> listA;
        String strA2;
        boolean configBoolean;
        JSONObject params;
        HashMap map;
        boolean zEquals;
        PermissionModel permissionModel;
        String string2;
        Context context;
        String string3;
        String str;
        HashMap map2;
        String strA3;
        Map<String, String> map3;
        JSONArray jSONArray;
        boolean z2;
        String str2;
        String str3;
        String strA4;
        String str4;
        String string4;
        String string5;
        HashMap map4;
        JSONObject jSONObject;
        String string6;
        DomainConfigProxy domainConfigProxy;
        if (page == null || page.getApp() == null) {
            return false;
        }
        AppModel appModel = (AppModel) page.getApp().getData(AppModel.class);
        PermissionModel permissionModel2 = appModel == null ? null : appModel.getPermissionModel();
        boolean z3 = permissionModel2 == null || permissionModel2.getNativeApiUserAuth() == null;
        String appId = page.getApp().getAppId();
        String strAuthority = permission == null ? "" : permission.authority();
        boolean zEquals2 = NativeCallContext.FROM_WORKER.equals(nativeCallContext.getSource());
        if (permissionModel2 != null && !zEquals2 && !a(page) && !c.contains(strAuthority)) {
            return false;
        }
        try {
            JSONObject configJSONObject = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONObject("h5_permissionDialogBlackList");
            if (!page.getApp().isTinyApp() && configJSONObject != null) {
                if (configJSONObject.getBoolean("is_on") != null) {
                    try {
                        if (configJSONObject.getBoolean("is_on").booleanValue()) {
                            z = false;
                        } else {
                            try {
                                RVLogger.d(g, "is_on exception hits ");
                                z = true;
                            } catch (Exception e2) {
                                e = e2;
                                z = true;
                                RVLogger.d(g, "check H5 exception occurs error " + e.getMessage());
                                if (z) {
                                    RVLogger.d(g, " isExceptedH5 is true skip show permission dialog  ");
                                    return false;
                                }
                                if (z3) {
                                    string = f24370a.get(strAuthority);
                                } else {
                                    string = permissionModel2.getNativeApiUserAuth().getString(strAuthority);
                                }
                                if ("snapshot".equals(strAuthority)) {
                                    string = null;
                                }
                                if (TextUtils.isEmpty(string)) {
                                    return false;
                                }
                                if (!(!"0".equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("ta_permissionDialogSwitch", "1")))) {
                                    RVLogger.d(g, "checkShowPermissionDialog...dialogSwitch closed");
                                    return false;
                                }
                                stringArray = JSONUtils.toStringArray(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_permissionDialogBlackList"));
                                if (stringArray != null) {
                                    for (Object obj : stringArray) {
                                        if ("all".equals(obj)) {
                                            RVLogger.d(g, "checkShowPermissionDialog... all in white list");
                                            return false;
                                        }
                                        if (appId.equals(obj)) {
                                            RVLogger.d(g, "checkShowPermissionDialog...in white list");
                                            return false;
                                        }
                                    }
                                }
                                strA = a(strAuthority, permissionModel2);
                                String config = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("h5_useLegacyLocationAuth", "no");
                                if (!strA.equalsIgnoreCase(c.b)) {
                                }
                                if (TextUtils.isEmpty(strA)) {
                                    listA = null;
                                } else {
                                    listA = C0148a.a(page, strA);
                                }
                                if (listA != null) {
                                    RVLogger.d(g, "checkShowPermissionDialog...already has dialog..." + strAuthority);
                                    listA.add(new b(permission.authority(), nativeCallContext, localPermissionCallback));
                                    return true;
                                }
                                strA2 = a(appModel, appId, page.getPageURI());
                                configBoolean = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigBoolean("ta_send_slientdeny_permission", true);
                                params = nativeCallContext.getParams();
                                map = new HashMap();
                                zEquals = "chooseImage".equals(strAuthority);
                                permissionModel = permissionModel2;
                                string2 = j;
                                if (zEquals) {
                                    context = ProcessUtils.getContext();
                                    if (context != null) {
                                        Resources resources = context.getResources();
                                        string3 = resources.getString(R.string.tiny_request_photo_permission);
                                        string2 = resources.getString(R.string.tiny_request_camera_permission);
                                    } else {
                                        string3 = k;
                                    }
                                    if (params != null) {
                                        jSONArray = params.getJSONArray("sourceType");
                                        String str5 = c.g;
                                        if (jSONArray == null) {
                                            str = strAuthority;
                                            map.put(c.g, string3);
                                            map.put(c.h, string2);
                                            strA = str5;
                                        } else {
                                            str = strAuthority;
                                            map.put(c.g, string3);
                                            map.put(c.h, string2);
                                            strA = str5;
                                        }
                                        ((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId(page.getApp());
                                        map2 = new HashMap();
                                        strA3 = null;
                                        z2 = true;
                                        for (Map.Entry entry : map.entrySet()) {
                                            str2 = (String) entry.getKey();
                                            str3 = (String) entry.getValue();
                                            strA4 = a(appId, b(page.getApp(), strA2, str2));
                                            if ("1".equals(strA4)) {
                                                if (!"-1".equalsIgnoreCase(strA4)) {
                                                    strA4 = a(appId, b(page.getApp(), strA2, str2));
                                                }
                                                if (!"1".equals(strA4)) {
                                                    map2.put(str2, str3);
                                                    if (strA3 != null) {
                                                        strA3 = strA4;
                                                    } else {
                                                        strA3 = strA4;
                                                    }
                                                    z2 = false;
                                                }
                                            }
                                        }
                                        if (z2) {
                                            strA3 = "1";
                                        }
                                    } else {
                                        str = strAuthority;
                                        strA = strA;
                                        map2 = null;
                                        strA3 = null;
                                    }
                                    map3 = map2;
                                    String str6 = strA3;
                                    str4 = strA;
                                    string4 = str6;
                                } else {
                                    context = ProcessUtils.getContext();
                                    if (context != null) {
                                        Resources resources2 = context.getResources();
                                        string3 = resources2.getString(R.string.tiny_request_photo_permission);
                                        string2 = resources2.getString(R.string.tiny_request_camera_permission);
                                    } else {
                                        string3 = k;
                                    }
                                    if (params != null) {
                                        jSONArray = params.getJSONArray("sourceType");
                                        String str7 = c.g;
                                        if (jSONArray == null) {
                                            str = strAuthority;
                                            map.put(c.g, string3);
                                            map.put(c.h, string2);
                                            strA = str7;
                                        } else {
                                            str = strAuthority;
                                            map.put(c.g, string3);
                                            map.put(c.h, string2);
                                            strA = str7;
                                        }
                                        ((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId(page.getApp());
                                        map2 = new HashMap();
                                        strA3 = null;
                                        z2 = true;
                                        while (r4.hasNext()) {
                                            str2 = (String) entry.getKey();
                                            str3 = (String) entry.getValue();
                                            strA4 = a(appId, b(page.getApp(), strA2, str2));
                                            if ("1".equals(strA4)) {
                                                if (!"-1".equalsIgnoreCase(strA4)) {
                                                    strA4 = a(appId, b(page.getApp(), strA2, str2));
                                                }
                                                if (!"1".equals(strA4)) {
                                                    map2.put(str2, str3);
                                                    if (strA3 != null) {
                                                        strA3 = strA4;
                                                    } else {
                                                        strA3 = strA4;
                                                    }
                                                    z2 = false;
                                                }
                                            }
                                        }
                                        if (z2) {
                                            strA3 = "1";
                                        }
                                    } else {
                                        str = strAuthority;
                                        strA = strA;
                                        map2 = null;
                                        strA3 = null;
                                    }
                                    map3 = map2;
                                    String str8 = strA3;
                                    str4 = strA;
                                    string4 = str8;
                                }
                                RVLogger.d(g, "alreadyAuthed: " + string4 + " buildPermissionKey(appId, scope): " + b(page.getApp(), strA2, str4));
                                if ("1".equals(string4)) {
                                    a(permission);
                                    return false;
                                }
                                if (configBoolean) {
                                }
                                if ("1".equals(a(appId, b(page.getApp(), strA2, str4)))) {
                                    a(permission);
                                    return false;
                                }
                                return a(page, appId, str, str4, nativeCallContext, localPermissionCallback, map3, permissionModel);
                            }
                        }
                        try {
                            if (!AppPermissionUtils.ALIPAY_WEB_COMMON_APPID.equalsIgnoreCase(appId)) {
                                RVLogger.d(g, "offline h5 appid is not 20000067 ");
                                z = true;
                            }
                            if (!z && configJSONObject.containsKey("domain")) {
                                for (String str9 : JSONUtils.toStringArray(configJSONObject.getJSONArray("domain"))) {
                                    if (TextUtils.isEmpty(str9) && PatternUtils.matchRegex(str9, UrlUtils.getHost(page.getPageURI()))) {
                                        RVLogger.d(g, "domain exception hits: domain: " + str9);
                                        z = true;
                                        break;
                                    }
                                }
                            }
                            string6 = configJSONObject.getString("group");
                        } catch (Exception e3) {
                            e = e3;
                            RVLogger.d(g, "check H5 exception occurs error " + e.getMessage());
                        }
                    } catch (Exception e4) {
                        e = e4;
                        z = false;
                    }
                } else {
                    z = false;
                    if (!AppPermissionUtils.ALIPAY_WEB_COMMON_APPID.equalsIgnoreCase(appId)) {
                        RVLogger.d(g, "offline h5 appid is not 20000067 ");
                        z = true;
                    }
                    if (!z) {
                        while (r0.hasNext()) {
                            if (TextUtils.isEmpty(str9)) {
                            }
                        }
                    }
                    string6 = configJSONObject.getString("group");
                }
                if (z) {
                    RVLogger.d(g, " isExceptedH5 is true skip show permission dialog  ");
                    return false;
                }
                if (z3) {
                    string = f24370a.get(strAuthority);
                } else {
                    string = permissionModel2.getNativeApiUserAuth().getString(strAuthority);
                }
                if ("snapshot".equals(strAuthority) && !JSONUtils.getBoolean(nativeCallContext.getParams(), "saveToGallery", true)) {
                    string = null;
                }
                if (TextUtils.isEmpty(string)) {
                    return false;
                }
                if (!(!"0".equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("ta_permissionDialogSwitch", "1")))) {
                    RVLogger.d(g, "checkShowPermissionDialog...dialogSwitch closed");
                    return false;
                }
                stringArray = JSONUtils.toStringArray(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_permissionDialogBlackList"));
                if (stringArray != null) {
                    while (r0.hasNext()) {
                        if ("all".equals(obj)) {
                            RVLogger.d(g, "checkShowPermissionDialog... all in white list");
                            return false;
                        }
                        if (appId.equals(obj)) {
                            RVLogger.d(g, "checkShowPermissionDialog...in white list");
                            return false;
                        }
                    }
                }
                strA = a(strAuthority, permissionModel2);
                String config2 = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("h5_useLegacyLocationAuth", "no");
                if (!strA.equalsIgnoreCase(c.b) && AppPermissionUtils.ALIPAY_WEB_COMMON_APPID.equalsIgnoreCase(appId) && "yes".equalsIgnoreCase(config2)) {
                    return false;
                }
                if (TextUtils.isEmpty(strA)) {
                    listA = C0148a.a(page, strA);
                } else {
                    listA = null;
                }
                if (listA != null) {
                    RVLogger.d(g, "checkShowPermissionDialog...already has dialog..." + strAuthority);
                    listA.add(new b(permission.authority(), nativeCallContext, localPermissionCallback));
                    return true;
                }
                strA2 = a(appModel, appId, page.getPageURI());
                configBoolean = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigBoolean("ta_send_slientdeny_permission", true);
                params = nativeCallContext.getParams();
                map = new HashMap();
                zEquals = "chooseImage".equals(strAuthority);
                permissionModel = permissionModel2;
                string2 = j;
                if (zEquals && !"chooseVideo".equals(strAuthority)) {
                    if ("NBComponent.render".equals(strAuthority)) {
                        if (params == null) {
                            return false;
                        }
                        JSONObject jSONObject2 = params.getJSONObject("data");
                        if (jSONObject2 != null) {
                            string5 = jSONObject2.getString("type");
                            if (TextUtils.isEmpty(string5) && (jSONObject = params.getJSONObject("componentData")) != null) {
                                string5 = jSONObject.getString("type");
                            }
                        } else {
                            string5 = null;
                        }
                        if (!h.d.equalsIgnoreCase(string5) && !"ai-camera".equalsIgnoreCase(string5) && !"ar".equalsIgnoreCase(string5)) {
                            return false;
                        }
                        string4 = a(appId, b(page.getApp(), strA2, c.h));
                        if ("1".equals(string4)) {
                            map4 = null;
                        } else {
                            map4 = new HashMap();
                            map4.put(c.h, j);
                        }
                        map3 = map4;
                        str = strAuthority;
                        str4 = c.h;
                    } else if ("NBComponent.sendMessage".equals(strAuthority)) {
                        if (params == null) {
                            return false;
                        }
                        String string7 = params.getString("actionType");
                        if (TextUtils.isEmpty(string7)) {
                            return false;
                        }
                        if (com.alibaba.ariver.jsapi.multimedia.camera.a.f24158a.equalsIgnoreCase(string7) || com.alibaba.ariver.jsapi.multimedia.camera.a.b.equalsIgnoreCase(string7) || "frameListenerStart".equalsIgnoreCase(string7)) {
                            strA3 = a(appId, b(page.getApp(), strA2, c.h));
                            if ("0".equals(strA3)) {
                                if (localPermissionCallback == null) {
                                    return true;
                                }
                                localPermissionCallback.onNegative(false);
                                return true;
                            }
                            HashMap map5 = new HashMap();
                            map5.put(c.h, j);
                            map3 = map5;
                            strA = c.h;
                        } else {
                            strA3 = null;
                            map3 = null;
                        }
                        str = strAuthority;
                    } else {
                        str4 = strA;
                        string4 = ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).getString(appId, b(page.getApp(), strA2, strA));
                        str = strAuthority;
                        map3 = null;
                    }
                    RVLogger.d(g, "alreadyAuthed: " + string4 + " buildPermissionKey(appId, scope): " + b(page.getApp(), strA2, str4));
                    if ("1".equals(string4)) {
                        a(permission);
                        return false;
                    }
                    if (configBoolean || !"-1".equalsIgnoreCase(string4)) {
                        if ("1".equals(a(appId, b(page.getApp(), strA2, str4)))) {
                            a(permission);
                            return false;
                        }
                        return a(page, appId, str, str4, nativeCallContext, localPermissionCallback, map3, permissionModel);
                    }
                    if (localPermissionCallback == null) {
                        return true;
                    }
                    localPermissionCallback.onNegative(false);
                    return true;
                }
                context = ProcessUtils.getContext();
                if (context != null) {
                    Resources resources3 = context.getResources();
                    string3 = resources3.getString(R.string.tiny_request_photo_permission);
                    string2 = resources3.getString(R.string.tiny_request_camera_permission);
                } else {
                    string3 = k;
                }
                if (params != null) {
                    jSONArray = params.getJSONArray("sourceType");
                    String str10 = c.g;
                    if (jSONArray == null && !jSONArray.isEmpty()) {
                        str = strAuthority;
                        if (jSONArray.contains(h.f)) {
                            map.put(c.g, string3);
                        } else {
                            str10 = strA;
                        }
                        if (jSONArray.contains(h.d)) {
                            map.put(c.h, string2);
                            strA = c.h;
                        }
                        ((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId(page.getApp());
                        map2 = new HashMap();
                        strA3 = null;
                        z2 = true;
                        while (r4.hasNext()) {
                            str2 = (String) entry.getKey();
                            str3 = (String) entry.getValue();
                            strA4 = a(appId, b(page.getApp(), strA2, str2));
                            if ("1".equals(strA4)) {
                                if (!"-1".equalsIgnoreCase(strA4)) {
                                    strA4 = a(appId, b(page.getApp(), strA2, str2));
                                }
                                if (!"1".equals(strA4)) {
                                    map2.put(str2, str3);
                                    if (strA3 != null || !"0".equals(strA4)) {
                                        strA3 = strA4;
                                    }
                                    z2 = false;
                                }
                            }
                        }
                        if (z2) {
                            strA3 = "1";
                        }
                    } else {
                        str = strAuthority;
                        map.put(c.g, string3);
                        map.put(c.h, string2);
                    }
                    strA = str10;
                    ((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId(page.getApp());
                    map2 = new HashMap();
                    strA3 = null;
                    z2 = true;
                    while (r4.hasNext()) {
                        str2 = (String) entry.getKey();
                        str3 = (String) entry.getValue();
                        strA4 = a(appId, b(page.getApp(), strA2, str2));
                        if ("1".equals(strA4)) {
                            if (!"-1".equalsIgnoreCase(strA4)) {
                                strA4 = a(appId, b(page.getApp(), strA2, str2));
                            }
                            if (!"1".equals(strA4)) {
                                map2.put(str2, str3);
                                if (strA3 != null) {
                                    strA3 = strA4;
                                } else {
                                    strA3 = strA4;
                                }
                                z2 = false;
                            }
                        }
                    }
                    if (z2) {
                        strA3 = "1";
                    }
                } else {
                    str = strAuthority;
                    strA = strA;
                    map2 = null;
                    strA3 = null;
                }
                map3 = map2;
                String str11 = strA3;
                str4 = strA;
                string4 = str11;
                RVLogger.d(g, "alreadyAuthed: " + string4 + " buildPermissionKey(appId, scope): " + b(page.getApp(), strA2, str4));
                if ("1".equals(string4)) {
                    a(permission);
                    return false;
                }
                if (configBoolean) {
                }
                if ("1".equals(a(appId, b(page.getApp(), strA2, str4)))) {
                    a(permission);
                    return false;
                }
                return a(page, appId, str, str4, nativeCallContext, localPermissionCallback, map3, permissionModel);
            }
            string6 = null;
            z = false;
            if (!z) {
                if (TextUtils.isEmpty(string6)) {
                    string6 = "ali";
                }
                String pageURI = page.getPageURI();
                if ("ali".equalsIgnoreCase(string6)) {
                    DomainConfigProxy domainConfigProxy2 = (DomainConfigProxy) RVProxy.get(DomainConfigProxy.class);
                    if (domainConfigProxy2 != null && domainConfigProxy2.isAliDomains(pageURI)) {
                        RVLogger.d(g, "ali domain exception hits url : " + pageURI);
                        z = true;
                    }
                } else if ("alipay".equalsIgnoreCase(string6) && (domainConfigProxy = (DomainConfigProxy) RVProxy.get(DomainConfigProxy.class)) != null && domainConfigProxy.isAlipayDomains(pageURI)) {
                    RVLogger.d(g, "alipay domain exception hits url : " + pageURI);
                    z = true;
                }
            }
        } catch (Exception e5) {
            e = e5;
            z = false;
        }
        if (z) {
            RVLogger.d(g, " isExceptedH5 is true skip show permission dialog  ");
            return false;
        }
        if (z3) {
            string = f24370a.get(strAuthority);
        } else {
            string = permissionModel2.getNativeApiUserAuth().getString(strAuthority);
        }
        if ("snapshot".equals(strAuthority)) {
            string = null;
        }
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        if (!(!"0".equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("ta_permissionDialogSwitch", "1")))) {
            RVLogger.d(g, "checkShowPermissionDialog...dialogSwitch closed");
            return false;
        }
        stringArray = JSONUtils.toStringArray(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_permissionDialogBlackList"));
        if (stringArray != null) {
            while (r0.hasNext()) {
                if ("all".equals(obj)) {
                    RVLogger.d(g, "checkShowPermissionDialog... all in white list");
                    return false;
                }
                if (appId.equals(obj)) {
                    RVLogger.d(g, "checkShowPermissionDialog...in white list");
                    return false;
                }
            }
        }
        strA = a(strAuthority, permissionModel2);
        String config3 = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("h5_useLegacyLocationAuth", "no");
        if (!strA.equalsIgnoreCase(c.b)) {
        }
        if (TextUtils.isEmpty(strA)) {
            listA = C0148a.a(page, strA);
        } else {
            listA = null;
        }
        if (listA != null) {
            RVLogger.d(g, "checkShowPermissionDialog...already has dialog..." + strAuthority);
            listA.add(new b(permission.authority(), nativeCallContext, localPermissionCallback));
            return true;
        }
        strA2 = a(appModel, appId, page.getPageURI());
        configBoolean = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigBoolean("ta_send_slientdeny_permission", true);
        params = nativeCallContext.getParams();
        map = new HashMap();
        zEquals = "chooseImage".equals(strAuthority);
        permissionModel = permissionModel2;
        string2 = j;
        if (zEquals) {
            context = ProcessUtils.getContext();
            if (context != null) {
                Resources resources4 = context.getResources();
                string3 = resources4.getString(R.string.tiny_request_photo_permission);
                string2 = resources4.getString(R.string.tiny_request_camera_permission);
            } else {
                string3 = k;
            }
            if (params != null) {
                jSONArray = params.getJSONArray("sourceType");
                String str12 = c.g;
                if (jSONArray == null) {
                    str = strAuthority;
                    map.put(c.g, string3);
                    map.put(c.h, string2);
                    strA = str12;
                } else {
                    str = strAuthority;
                    map.put(c.g, string3);
                    map.put(c.h, string2);
                    strA = str12;
                }
                ((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId(page.getApp());
                map2 = new HashMap();
                strA3 = null;
                z2 = true;
                while (r4.hasNext()) {
                    str2 = (String) entry.getKey();
                    str3 = (String) entry.getValue();
                    strA4 = a(appId, b(page.getApp(), strA2, str2));
                    if ("1".equals(strA4)) {
                        if (!"-1".equalsIgnoreCase(strA4)) {
                            strA4 = a(appId, b(page.getApp(), strA2, str2));
                        }
                        if (!"1".equals(strA4)) {
                            map2.put(str2, str3);
                            if (strA3 != null) {
                                strA3 = strA4;
                            } else {
                                strA3 = strA4;
                            }
                            z2 = false;
                        }
                    }
                }
                if (z2) {
                    strA3 = "1";
                }
            } else {
                str = strAuthority;
                strA = strA;
                map2 = null;
                strA3 = null;
            }
            map3 = map2;
            String str13 = strA3;
            str4 = strA;
            string4 = str13;
        } else {
            context = ProcessUtils.getContext();
            if (context != null) {
                Resources resources5 = context.getResources();
                string3 = resources5.getString(R.string.tiny_request_photo_permission);
                string2 = resources5.getString(R.string.tiny_request_camera_permission);
            } else {
                string3 = k;
            }
            if (params != null) {
                jSONArray = params.getJSONArray("sourceType");
                String str14 = c.g;
                if (jSONArray == null) {
                    str = strAuthority;
                    map.put(c.g, string3);
                    map.put(c.h, string2);
                    strA = str14;
                } else {
                    str = strAuthority;
                    map.put(c.g, string3);
                    map.put(c.h, string2);
                    strA = str14;
                }
                ((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId(page.getApp());
                map2 = new HashMap();
                strA3 = null;
                z2 = true;
                while (r4.hasNext()) {
                    str2 = (String) entry.getKey();
                    str3 = (String) entry.getValue();
                    strA4 = a(appId, b(page.getApp(), strA2, str2));
                    if ("1".equals(strA4)) {
                        if (!"-1".equalsIgnoreCase(strA4)) {
                            strA4 = a(appId, b(page.getApp(), strA2, str2));
                        }
                        if (!"1".equals(strA4)) {
                            map2.put(str2, str3);
                            if (strA3 != null) {
                                strA3 = strA4;
                            } else {
                                strA3 = strA4;
                            }
                            z2 = false;
                        }
                    }
                }
                if (z2) {
                    strA3 = "1";
                }
            } else {
                str = strAuthority;
                strA = strA;
                map2 = null;
                strA3 = null;
            }
            map3 = map2;
            String str15 = strA3;
            str4 = strA;
            string4 = str15;
        }
        RVLogger.d(g, "alreadyAuthed: " + string4 + " buildPermissionKey(appId, scope): " + b(page.getApp(), strA2, str4));
        if ("1".equals(string4)) {
            a(permission);
            return false;
        }
        if (configBoolean) {
        }
        if ("1".equals(a(appId, b(page.getApp(), strA2, str4)))) {
            a(permission);
            return false;
        }
        return a(page, appId, str, str4, nativeCallContext, localPermissionCallback, map3, permissionModel);
    }

    private String b(App app, String str, String str2) {
        String userId = ((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId(app);
        StringBuilder sb = new StringBuilder();
        sb.append(userId);
        sb.append(LoginConstants.UNDER_LINE);
        if (TextUtils.isEmpty(str)) {
            str = app.getAppId();
        }
        sb.append(str);
        sb.append(LoginConstants.UNDER_LINE);
        sb.append(str2.substring(str2.indexOf(Consts.DOT) + 1, str2.length()));
        return sb.toString();
    }

    private void b(String str, String str2) {
        ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).remove(str, str2);
    }

    private String a(AppModel appModel, String str, String str2) {
        return AppPermissionUtils.getAggregationMainAppId(appModel) == null ? AppPermissionUtils.getAggregationMainAppIdForH5Page(str, str2) : str;
    }

    private void a(Permission permission) {
        RVLogger.d(g, "checkIfSendAuthedLogToRemoteDebug: " + permission);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Page page, String str, String str2) {
        List<b> listB = C0148a.b(page, str2);
        if (listB != null) {
            for (b bVar : listB) {
                if (bVar.c != null) {
                    RVLogger.d(g, "cancelAuth...action=" + str + " on resultObject: " + bVar);
                    bVar.c.onNegative(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Node node, String str, String str2) {
        List<b> listB = C0148a.b(node, str2);
        if (listB != null) {
            for (b bVar : listB) {
                RVLogger.d(g, "sendResult...action=" + str + " on resultObject: " + bVar);
                try {
                    bVar.c.onPositive();
                } catch (Exception e2) {
                    RVLogger.e(g, "use local permission send result error:\t" + e2.getMessage());
                }
            }
        }
    }

    private String a(String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        if (jSONObject2 == null) {
            return null;
        }
        String string = jSONObject2.getString("desc");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    private String a(String str, Map<String, String> map) {
        if (!"chooseImage".equals(str) && !"chooseVideo".equals(str) && !"NBComponent.render".equalsIgnoreCase(str) && !"NBComponent.sendMessage".equalsIgnoreCase(str)) {
            return f24370a.get(str);
        }
        if (map == null || map.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            sb.append(it.next().getValue());
            sb.append("，");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private String a(String str, PermissionModel permissionModel) {
        String string = (permissionModel == null || permissionModel.getNativeApiUserAuth() == null || !permissionModel.getNativeApiUserAuth().containsKey(str)) ? "" : permissionModel.getNativeApiUserAuth().getString(str);
        if (TextUtils.isEmpty(string)) {
            if ("scan".equals(str)) {
                string = c.h;
            } else if ("saveImage".equals(str) || "saveVideoToPhotosAlbum".equals(str) || "shareTokenImageSilent".equals(str)) {
                string = c.g;
            } else if (str.contains("Location")) {
                string = c.b;
            } else if (str.contains("AudioRecord")) {
                string = c.f;
            } else if (str.equals("enableBluetooth") || str.equals("openBluetoothAdapter") || str.equals("connectBLEDevice") || str.equals("getBeacons")) {
                string = c.i;
            } else if ("contact".equals(str) || "chooseContact".equals(str) || "APSocialNebulaPlugin.selectContactJSAPI".equals(str)) {
                string = c.k;
            } else if ("getMainSelectedCity".equals(str)) {
                string = c.l;
            }
        }
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String str2 = b.get(str);
        if (TextUtils.isEmpty(str2)) {
            return string;
        }
        return "scope." + str2;
    }

    public Map<String, Boolean> a(String str, @Nullable AppModel appModel, @Nullable App app, Page page, Map<String, Map<String, PermissionModel>> map) {
        if (appModel == null) {
            appModel = ((RVAppInfoManager) RVProxy.get(RVAppInfoManager.class)).getAppModel(AppInfoQuery.make(str));
        }
        AppModel appModel2 = appModel;
        return a(str, appModel2, app, map, a(appModel2, str, page != null ? page.getPageURI() : null));
    }

    public Map<String, Boolean> a(String str, @Nullable AppModel appModel, @Nullable App app, Map<String, Map<String, PermissionModel>> map, String str2) {
        Map<String, PermissionModel> map2;
        JSONObject nativeApiScopeConfig;
        JSONArray array;
        Map<String, PermissionModel> map3;
        JSONObject nativeApiScopeConfig2;
        if (appModel == null) {
            appModel = ((RVAppInfoManager) RVProxy.get(RVAppInfoManager.class)).getAppModel(AppInfoQuery.make(str));
        }
        HashMap map4 = new HashMap();
        if (appModel != null && appModel.getPermissionModel() != null && appModel.getPermissionModel().getNativeApiScopeConfig() != null) {
            HashSet<String> hashSet = new HashSet();
            hashSet.addAll(appModel.getPermissionModel().getNativeApiScopeConfig().keySet());
            if (map != null && (map3 = map.get(str)) != null && !map3.isEmpty()) {
                for (PermissionModel permissionModel : map3.values()) {
                    if (permissionModel != null && (nativeApiScopeConfig2 = permissionModel.getNativeApiScopeConfig()) != null && !nativeApiScopeConfig2.keySet().isEmpty()) {
                        hashSet.addAll(nativeApiScopeConfig2.keySet());
                    }
                }
            }
            for (String str3 : hashSet) {
                String strA = a(app, str, str2, str3);
                if (!TextUtils.isEmpty(strA)) {
                    map4.put(str3, Boolean.valueOf("1".equalsIgnoreCase(strA)));
                }
            }
        } else {
            HashSet<String> hashSet2 = new HashSet();
            boolean z = false;
            if (map != null && map.get(str) != null && !map.get(str).isEmpty() && (map2 = map.get(str)) != null && !map2.isEmpty()) {
                for (PermissionModel permissionModel2 : map2.values()) {
                    if (permissionModel2 != null && (nativeApiScopeConfig = permissionModel2.getNativeApiScopeConfig()) != null) {
                        hashSet2.addAll(nativeApiScopeConfig.keySet());
                        z = true;
                    }
                }
            }
            if (z) {
                for (String str4 : hashSet2) {
                    String strA2 = a(app, str, str2, str4);
                    if (!TextUtils.isEmpty(strA2)) {
                        map4.put(str4, Boolean.valueOf("1".equalsIgnoreCase(strA2)));
                    }
                }
            } else {
                String strA3 = a(app, str, str2, c.b);
                if (!TextUtils.isEmpty(strA3)) {
                    map4.put(c.b, Boolean.valueOf("1".equalsIgnoreCase(strA3)));
                }
                String strA4 = a(app, str, str2, c.f);
                if (!TextUtils.isEmpty(strA4)) {
                    map4.put(c.f, Boolean.valueOf("1".equalsIgnoreCase(strA4)));
                }
                String strA5 = a(app, str, str2, c.g);
                if (!TextUtils.isEmpty(strA5)) {
                    map4.put(c.g, Boolean.valueOf("1".equalsIgnoreCase(strA5)));
                }
                String strA6 = a(app, str, str2, c.h);
                if (!TextUtils.isEmpty(strA6)) {
                    map4.put(c.h, Boolean.valueOf("1".equalsIgnoreCase(strA6)));
                }
                String strA7 = a(app, str, str2, c.i);
                if (!TextUtils.isEmpty(strA7)) {
                    map4.put(c.i, Boolean.valueOf("1".equalsIgnoreCase(strA7)));
                }
                String strA8 = a(app, str, str2, c.j);
                if (!TextUtils.isEmpty(strA8)) {
                    map4.put(c.j, Boolean.valueOf("1".equalsIgnoreCase(strA8)));
                }
                String strA9 = a(app, str, str2, c.k);
                if (!TextUtils.isEmpty(strA9)) {
                    map4.put(c.k, Boolean.valueOf("1".equalsIgnoreCase(strA9)));
                }
                String strA10 = a(app, str, str2, c.l);
                if (!TextUtils.isEmpty(strA10)) {
                    map4.put(c.l, Boolean.valueOf("1".equalsIgnoreCase(strA10)));
                }
            }
        }
        if (!TextUtils.isEmpty(this.q) && (array = JSONUtils.parseArray(this.q)) != null && array.size() > 0) {
            HashSet hashSet3 = new HashSet();
            for (Object obj : array) {
                if (obj instanceof String) {
                    hashSet3.add((String) obj);
                }
            }
            Iterator it = hashSet3.iterator();
            while (it.hasNext()) {
                String str5 = "scope." + ((String) it.next());
                if (!TextUtils.isEmpty(a(app, str, str2, str5))) {
                    map4.put(str5, Boolean.valueOf(TextUtils.equals(a(app, str, str2, str5), "1")));
                }
            }
        }
        return map4;
    }

    private boolean a(final Page page, final String str, final String str2, final String str3, final NativeCallContext nativeCallContext, final AuthenticationProxy.LocalPermissionCallback localPermissionCallback, final Map<String, String> map, PermissionModel permissionModel) {
        final String host;
        final String str4;
        final String str5;
        String logo;
        String strA = ("chooseImage".equals(str2) || "chooseVideo".equals(str2) || permissionModel == null || permissionModel.getNativeApiScopeConfig() == null) ? null : a(str3, permissionModel.getNativeApiScopeConfig());
        RVLogger.d(g, "dialogContent dynamic is\t:" + strA + ", action = " + str2);
        if (TextUtils.isEmpty(strA)) {
            strA = a(str2, map);
        }
        final String str6 = strA;
        RVLogger.d(g, "dialogContent native is\t:" + str6);
        if (TextUtils.isEmpty(str6)) {
            RVLogger.d(g, "doShowPermissionDialog not show dialog content null");
            return false;
        }
        RVLogger.d(g, "doShowPermissionDialog...action:" + str2 + ",appId:" + str);
        String name = "";
        if (page == null || page.getApp() == null) {
            host = "";
            str4 = host;
            str5 = str4;
        } else {
            AppModel appModel = (AppModel) page.getApp().getData(AppModel.class);
            String strA2 = a(appModel, str, page.getPageURI());
            RVLogger.d(g, "doShowPermissionDialog...aggregationMainAppId :" + strA2);
            if (appModel != null) {
                AppInfoModel appInfoModel = appModel.getAppInfoModel();
                EntryInfo entryInfo = (EntryInfo) page.getApp().getData(EntryInfo.class);
                if (entryInfo != null) {
                    name = entryInfo.title;
                    logo = entryInfo.iconUrl;
                } else {
                    logo = "";
                }
                if (appInfoModel != null) {
                    if (TextUtils.isEmpty(name)) {
                        name = appInfoModel.getName();
                    }
                    if (TextUtils.isEmpty(logo)) {
                        logo = appInfoModel.getLogo();
                    }
                }
            } else {
                logo = "";
            }
            if (AppPermissionUtils.ALIPAY_WEB_COMMON_APPID.equals(str)) {
                RVLogger.d(g, " 20000067 doShowPermissionDialog...action:" + str2 + " url :" + page.getPageURI());
                str5 = strA2;
                str4 = "https://gw.alipayobjects.com/mdn/rms_ef981d/afts/img/A*qpA3TKXchKUAAAAAAAAAAABkARQnAQ";
                host = UrlUtils.getHost(page.getPageURI());
            } else {
                host = name;
                String str7 = logo;
                str5 = strA2;
                str4 = str7;
            }
        }
        if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(str4)) {
            if (((OfficialAppPoint) ExtensionPoint.as(OfficialAppPoint.class).node(page.getApp()).create()).isOfficial(nativeCallContext.getPluginId())) {
                final String str8 = str5;
                ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.permission.service.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Map map2 = map;
                        if (map2 == null || map2.isEmpty()) {
                            a.this.a(page.getApp(), str, str8, str3, "1");
                        } else {
                            Iterator it = map.entrySet().iterator();
                            while (it.hasNext()) {
                                a.this.a(page.getApp(), str, str8, (String) ((Map.Entry) it.next()).getKey(), "1");
                            }
                        }
                        a.this.a((Node) page, str2, str3);
                    }
                });
                return true;
            }
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.permission.service.a.2
                @Override // java.lang.Runnable
                public void run() {
                    Activity activity = page.getRender().getActivity();
                    if (activity == null || activity.isFinishing()) {
                        return;
                    }
                    com.alibaba.ariver.permission.b.c localPermissionDialog = ((AuthDialogProxy) RVProxy.get(page, AuthDialogProxy.class)).getLocalPermissionDialog(page.getRender().getActivity());
                    localPermissionDialog.a(str6, host, str4);
                    localPermissionDialog.a(new d() { // from class: com.alibaba.ariver.permission.service.a.2.1
                        @Override // com.alibaba.ariver.permission.b.d
                        public void a() {
                            Map map2 = map;
                            if (map2 == null || map2.isEmpty()) {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                a aVar = a.this;
                                App app = page.getApp();
                                AnonymousClass2 anonymousClass3 = AnonymousClass2.this;
                                aVar.a(app, str, str5, str3, "1");
                            } else {
                                for (Map.Entry entry : map.entrySet()) {
                                    AnonymousClass2 anonymousClass4 = AnonymousClass2.this;
                                    a aVar2 = a.this;
                                    App app2 = page.getApp();
                                    AnonymousClass2 anonymousClass5 = AnonymousClass2.this;
                                    aVar2.a(app2, str, str5, (String) entry.getKey(), "1");
                                }
                            }
                            AnonymousClass2 anonymousClass6 = AnonymousClass2.this;
                            a.this.a((Node) page, str2, str3);
                        }

                        @Override // com.alibaba.ariver.permission.b.d
                        public void a(int i2, String str9, boolean z) {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            a.this.a(page, str2, str3);
                            RVLogger.d(a.g, "checkShowPermissionDialog...cancel");
                            Map map2 = map;
                            if (map2 != null && !map2.isEmpty()) {
                                for (Map.Entry entry : map.entrySet()) {
                                    AnonymousClass2 anonymousClass3 = AnonymousClass2.this;
                                    a aVar = a.this;
                                    App app = page.getApp();
                                    AnonymousClass2 anonymousClass4 = AnonymousClass2.this;
                                    aVar.a(app, str, str5, (String) entry.getKey(), z ? "0" : "-1");
                                }
                                return;
                            }
                            AnonymousClass2 anonymousClass5 = AnonymousClass2.this;
                            a aVar2 = a.this;
                            App app2 = page.getApp();
                            AnonymousClass2 anonymousClass6 = AnonymousClass2.this;
                            aVar2.a(app2, str, str5, str3, z ? "0" : "-1");
                        }
                    });
                    localPermissionDialog.a();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(a.this.new b(str2, nativeCallContext, localPermissionCallback));
                    C0148a.a(page, str3, arrayList);
                }
            });
            return true;
        }
        RVLogger.d(g, "doShowPermissionDialog not show icon or title null");
        return false;
    }

    private String a(App app, String str, String str2, String str3) {
        String strB = b(app, str, str3);
        String strA = a(str, strB);
        RVLogger.d(g, "isThePermissionApplied,key: " + strB + ",value: " + strA);
        return (!TextUtils.isEmpty(strA) || TextUtils.isEmpty(str2)) ? strA : a(str, b(app, str2, str3));
    }

    private String a(String str, String str2) {
        return ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).getString(str, str2);
    }

    private void a(String str, String str2, String str3) {
        ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).putString(str, str2, str3);
    }

    public void a(App app, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            a(app, str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        a(app, str2);
    }

    private void a(App app, String str) {
        b(str, b(app, str, c.f24376a));
        b(str, b(app, str, c.b));
        b(str, b(app, str, c.c));
        b(str, b(app, str, c.d));
        b(str, b(app, str, c.e));
        b(str, b(app, str, c.f));
        b(str, b(app, str, c.g));
        b(str, b(app, str, c.i));
        b(str, b(app, str, c.j));
        b(str, b(app, str, c.k));
        b(str, b(app, str, c.l));
    }

    public void a(App app, String str, String str2, String str3, String str4) {
        String strB;
        if (TextUtils.isEmpty(str2)) {
            strB = b(app, app.getAppId(), str3);
        } else {
            strB = b(app, str2, str3);
        }
        a(str, strB, str4);
        RVLogger.d(g, "changePermissionState,key: " + strB + ",opened: " + str4);
    }
}
