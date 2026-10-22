package com.alibaba.alibctriver.b;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.alibcprotocol.route.config.AlibcConfigService;
import com.alibaba.alibcprotocol.route.model.ConfigDO;
import com.alibaba.alibcprotocol.route.model.MiscDO;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.parser.PackageParseUtils;
import com.alibaba.ariver.resource.parser.ParseContext;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.security.AlibcSecurityGuard;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.utils.CommonUtils;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23658a = "a";
    private static Map<String, Map<String, Resource>> b = new ConcurrentHashMap();

    public static void a(String str, String str2) throws Throwable {
        File[] fileArrListFiles;
        if (TextUtils.isEmpty(str2) || (fileArrListFiles = new File(str2).listFiles()) == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (file.getName().endsWith("tar")) {
                String absolutePath = file.getAbsolutePath();
                ParseContext parseContext = new ParseContext();
                parseContext.packagePath = absolutePath;
                HashMap map = new HashMap();
                try {
                    PackageParseUtils.fastReadTarIntoMemory(map, absolutePath, parseContext);
                } catch (IOException e) {
                    AlibcLogger.e(f23658a, "parse plugin tar exception: " + e.getMessage());
                }
                if (map.size() > 0) {
                    b.put(str, map);
                    return;
                }
                return;
            }
        }
    }

    public static String b(String str, String str2) {
        Resource resource;
        Map<String, Resource> map = b.get(str);
        if (map != null && (resource = map.get(str2)) != null) {
            try {
                byte[] bytes = resource.getBytes();
                if (bytes != null) {
                    return new String(bytes, Charset.forName("UTF-8"));
                }
            } catch (Exception e) {
                AlibcLogger.e(f23658a, e.getMessage());
            }
        }
        return null;
    }

    public static boolean b(String str) {
        String appKey = AlibcBaseTradeCommon.getAppKey();
        JSONObject jSONObjectA = a();
        if (jSONObjectA == null) {
            return false;
        }
        JSONArray jSONArray = jSONObjectA.getJSONArray(str);
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.size(); i++) {
                if (!appKey.equals(jSONArray.getString(i))) {
                }
            }
            return false;
        }
        return true;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.matches("^\\d+$")) {
            return str;
        }
        Long lAnalyseItemId = 0L;
        try {
            lAnalyseItemId = AlibcSecurityGuard.getInstance().analyseItemId(str);
        } catch (Exception e) {
            AlibcLogger.e(f23658a, "入参itemId=" + str + ", 异常：" + e.getMessage());
        }
        return (lAnalyseItemId == null || lAnalyseItemId.longValue() == 0) ? str : String.valueOf(lAnalyseItemId);
    }

    public static JSONObject a() {
        MiscDO misc;
        try {
            ConfigDO config = AlibcConfigService.getInstance().getConfig();
            if (config == null || (misc = config.getMisc()) == null) {
                return null;
            }
            return misc.getMiniConfJson();
        } catch (Exception e) {
            AlibcLogger.e(f23658a, "data parse exception: " + e.getMessage());
            return null;
        }
    }

    public static Uri a(Uri uri, String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str) || (strArrSplit = str.split("&")) == null) {
            return uri;
        }
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            if (!TextUtils.isEmpty(uri.getEncodedQuery())) {
                for (String str2 : uri.getEncodedQuery().split("&")) {
                    String[] strArrSplit2 = str2.split("=");
                    if (strArrSplit2 != null && strArrSplit2.length > 1) {
                        linkedHashMap.put(strArrSplit2[0], strArrSplit2[1]);
                    }
                }
            }
            if (linkedHashMap.containsKey("page")) {
                String strDecode = Uri.decode((String) linkedHashMap.get("page"));
                if (!TextUtils.isEmpty(strDecode)) {
                    String strSubstring = strDecode.substring(0, strDecode.indexOf("?") + 1);
                    Uri uri2 = Uri.parse(strDecode);
                    if ("plugin-private".equals(uri2.getScheme())) {
                        String strDecode2 = Uri.decode(uri2.getQuery());
                        if (!TextUtils.isEmpty(strDecode2)) {
                            for (String str3 : strDecode2.split("&")) {
                                String[] strArrSplit3 = str3.split("=");
                                if (strArrSplit3 != null && strArrSplit3.length > 1) {
                                    linkedHashMap2.put(strArrSplit3[0], strArrSplit3[1]);
                                }
                            }
                        }
                    }
                    a(strArrSplit, linkedHashMap2);
                    linkedHashMap.put("page", a(strSubstring, linkedHashMap2));
                }
            } else if (linkedHashMap.containsKey("query")) {
                String strDecode3 = Uri.decode((String) linkedHashMap.get("query"));
                if (!TextUtils.isEmpty(strDecode3)) {
                    for (String str4 : strDecode3.split("&")) {
                        String[] strArrSplit4 = str4.split("=");
                        if (strArrSplit4 != null && strArrSplit4.length > 1) {
                            linkedHashMap2.put(strArrSplit4[0], strArrSplit4[1]);
                        }
                    }
                }
                a(strArrSplit, linkedHashMap2);
                linkedHashMap.put("query", a("", linkedHashMap2));
            } else {
                a(strArrSplit, linkedHashMap);
            }
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                try {
                    sb.append(CommonUtils.encode((String) entry.getKey()));
                    sb.append("=");
                    sb.append(CommonUtils.encode(URLDecoder.decode((String) entry.getValue(), "UTF-8")));
                    sb.append("&");
                } catch (Exception unused) {
                    sb.append(CommonUtils.encode((String) entry.getKey()));
                    sb.append("=");
                    sb.append(CommonUtils.encode((String) entry.getValue()));
                    sb.append("&");
                }
            }
            return uri.buildUpon().encodedQuery(sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "").build();
        } catch (Exception e) {
            RVLogger.e("url parse exception: " + e.getMessage());
            return uri;
        }
    }

    private static void a(String[] strArr, Map<String, String> map) {
        for (String str : strArr) {
            String[] strArrSplit = str.split("=");
            if (strArrSplit != null && strArrSplit.length > 1) {
                map.put(strArrSplit[0], strArrSplit[1]);
            }
        }
    }

    private static String a(String str, Map<String, String> map) {
        try {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(str)) {
                sb.append(str);
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    sb.append(key);
                    sb.append("=");
                    sb.append(Uri.encode(value, "utf-8"));
                    sb.append("&");
                }
            }
            return Uri.encode(sb.substring(0, sb.length() - 1), "utf-8");
        } catch (Exception e) {
            RVLogger.e("url parse exception: " + e.getMessage());
            return "";
        }
    }
}
