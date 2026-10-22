package com.alibaba.ariver.app.api;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.permission.AppPermissionUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ParamUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23818a = "AriverApp.ParamUtils";
    private static final String b = "__webview_options__";
    private static Map<String, ParamImpl> c = new HashMap<String, ParamImpl>() { // from class: com.alibaba.ariver.app.api.ParamUtils.1
        {
            RVParams.ParamType paramType = RVParams.ParamType.STRING;
            put("url", new ParamImpl("url", "u", paramType, ""));
            put(RVParams.LONG_DEFAULT_TITLE, new ParamImpl(RVParams.LONG_DEFAULT_TITLE, RVParams.DEFAULT_TITLE, paramType, ""));
            put(RVParams.LONG_TITLE_IMAGE, new ParamImpl(RVParams.LONG_TITLE_IMAGE, RVParams.TITLE_IMAGE, paramType, ""));
            RVParams.ParamType paramType2 = RVParams.ParamType.BOOLEAN;
            Boolean bool = Boolean.TRUE;
            put(RVParams.LONG_SHOW_TITLEBAR, new ParamImpl(RVParams.LONG_SHOW_TITLEBAR, "st", paramType2, bool));
            Boolean bool2 = Boolean.FALSE;
            put(RVParams.LONG_SHOW_FAVORITES, new ParamImpl(RVParams.LONG_SHOW_FAVORITES, RVParams.SHOW_FAVORITES, paramType2, bool2));
            put(RVParams.LONG_SHOW_REPORT_BTN, new ParamImpl(RVParams.LONG_SHOW_REPORT_BTN, RVParams.SHOW_REPORT_BTN, paramType2, bool2));
            put(RVParams.LONG_SHOW_TOOLBAR, new ParamImpl(RVParams.LONG_SHOW_TOOLBAR, RVParams.SHOW_TOOLBAR, paramType2, bool2));
            put(RVParams.LONG_SHOW_LOADING, new ParamImpl(RVParams.LONG_SHOW_LOADING, "sl", paramType2, bool2));
            put(RVParams.LONG_CLOSE_BUTTON_TEXT, new ParamImpl(RVParams.LONG_CLOSE_BUTTON_TEXT, RVParams.CLOSE_BUTTON_TEXT, paramType, ""));
            put(RVParams.LONG_SSO_LOGIN_ENABLE, new ParamImpl(RVParams.LONG_SSO_LOGIN_ENABLE, RVParams.SSO_LOGIN_ENABLE, paramType2, bool));
            put(RVParams.LONG_SAFEPAY_ENABLE, new ParamImpl(RVParams.LONG_SAFEPAY_ENABLE, RVParams.SAFEPAY_ENABLE, paramType2, bool));
            put(RVParams.LONG_SAFEPAY_CONTEXT, new ParamImpl(RVParams.LONG_SAFEPAY_CONTEXT, "sc", paramType, ""));
            put(RVParams.LONG_READ_TITLE, new ParamImpl(RVParams.LONG_READ_TITLE, "rt", paramType2, bool));
            put(RVParams.LONG_BIZ_SCENARIO, new ParamImpl(RVParams.LONG_BIZ_SCENARIO, RVParams.BIZ_SCENARIO, paramType, ""));
            put(RVParams.LONG_ANTI_PHISHING, new ParamImpl(RVParams.LONG_ANTI_PHISHING, RVParams.ANTI_PHISHING, paramType2, bool));
            put(RVParams.LONG_TOOLBAR_MENU, new ParamImpl(RVParams.LONG_TOOLBAR_MENU, RVParams.TOOLBAR_MENU, paramType, ""));
            put(RVParams.LONG_PULL_REFRESH, new ParamImpl(RVParams.LONG_PULL_REFRESH, "pr", paramType2, bool2));
            put(RVParams.LONG_SHOW_TITLE_LOADING, new ParamImpl(RVParams.LONG_SHOW_TITLE_LOADING, RVParams.SHOW_TITLE_LOADING, paramType2, bool2));
            put(RVParams.LONG_SHOW_PROGRESS, new ParamImpl(RVParams.LONG_SHOW_PROGRESS, RVParams.SHOW_PROGRESS, paramType2, bool2));
            put(RVParams.LONG_SMART_TOOLBAR, new ParamImpl(RVParams.LONG_SMART_TOOLBAR, "tb", paramType2, bool2));
            put(RVParams.LONG_ENABLE_PROXY, new ParamImpl(RVParams.LONG_ENABLE_PROXY, RVParams.ENABLE_PROXY, paramType2, bool2));
            put(RVParams.LONG_CAN_PULL_DOWN, new ParamImpl(RVParams.LONG_CAN_PULL_DOWN, "pd", paramType2, bool));
            put(RVParams.LONG_SHOW_DOMAIN, new ParamImpl(RVParams.LONG_SHOW_DOMAIN, "sd", paramType2, bool));
            put(RVParams.LONG_PREFETCH_LOCATION, new ParamImpl(RVParams.LONG_PREFETCH_LOCATION, RVParams.PREFETCH_LOCATION, paramType2, bool2));
            put(RVParams.LONG_SHOW_OPTION_MENU, new ParamImpl(RVParams.LONG_SHOW_OPTION_MENU, RVParams.SHOW_OPTION_MENU, paramType2, bool));
            RVParams.ParamType paramType3 = RVParams.ParamType.INT;
            put("backgroundColor", new ParamImpl("backgroundColor", RVParams.BACKGROUND_COLOR, paramType3, -1));
            put(RVParams.LONG_INTERCEPT_JUMP, new ParamImpl(RVParams.LONG_INTERCEPT_JUMP, RVParams.INTERCEPT_JUMP, paramType2, bool));
            put(RVParams.LONG_CLOSE_AFTER_PAY_FINISH, new ParamImpl(RVParams.LONG_CLOSE_AFTER_PAY_FINISH, RVParams.CLOSE_AFTER_PAY_FINISH, paramType2, bool));
            put(RVStartParams.KEY_TRANSPARENT, new ParamImpl(RVStartParams.KEY_TRANSPARENT, "tt", paramType2, bool2));
            put("fullscreen", new ParamImpl("fullscreen", "fs", paramType2, bool2));
            put("landscape", new ParamImpl("landscape", RVStartParams.KEY_LANDSCAPE_SHORT, paramType, ""));
            put(RVParams.LONG_ENABLE_SCROLLBAR, new ParamImpl(RVParams.LONG_ENABLE_SCROLLBAR, RVParams.ENABLE_SCROLLBAR, paramType2, bool));
            put(RVParams.LONG_DELAY_RENDER, new ParamImpl(RVParams.LONG_DELAY_RENDER, "dr", paramType2, bool2));
            put(RVParams.LONG_CAN_DESTROY, new ParamImpl(RVParams.LONG_CAN_DESTROY, RVParams.CAN_DESTROY, paramType2, bool2));
            put("transparentTitle", new ParamImpl("transparentTitle", RVParams.TRANSPARENT_TITLE, paramType, ""));
            put(RVParams.LONG_TITLE_SCROLLDISTANCE, new ParamImpl(RVParams.LONG_TITLE_SCROLLDISTANCE, RVParams.TITLE_SCROLLDISTANCE, paramType3, 255));
            put(RVParams.LONG_BOUNCE_TOP_COLOR, new ParamImpl(RVParams.LONG_BOUNCE_TOP_COLOR, RVParams.BOUNCE_TOP_COLOR, true, paramType3, Integer.valueOf(RVParams.DEFAULT_LONG_BOUNCE_TOP_COLOR)));
            put(RVParams.LONG_ALLOWS_BOUNCE_VERTICAL, new ParamImpl(RVParams.LONG_ALLOWS_BOUNCE_VERTICAL, RVParams.ALLOWS_BOUNCE_VERTICAL, paramType, ""));
            put(RVStartParams.LONG_NB_UPDATE, new ParamImpl(RVStartParams.LONG_NB_UPDATE, RVParams.NB_UPDATE, paramType, "async"));
            put(RVStartParams.LONG_NB_OFFLINE, new ParamImpl(RVStartParams.LONG_NB_OFFLINE, RVParams.NB_OFFLINE, paramType, "async"));
            put(RVStartParams.LONG_NB_URL, new ParamImpl(RVStartParams.LONG_NB_URL, RVParams.NB_URL, paramType, ""));
            put(RVParams.LONG_OB_VERSION, new ParamImpl(RVParams.LONG_OB_VERSION, RVParams.OB_VERSION, paramType, ""));
            put(RVStartParams.LONG_NB_VERSION, new ParamImpl(RVStartParams.LONG_NB_VERSION, RVParams.NB_VERSION, paramType, ""));
            put(RVParams.LONG_NAV_SEARCH_BAR_TYPE, new ParamImpl(RVParams.LONG_NAV_SEARCH_BAR_TYPE, RVParams.NAV_SEARCH_BAR_TYPE, paramType, ""));
            put(RVParams.LONG_NAV_SEARCH_BAR_PLACEHOLDER, new ParamImpl(RVParams.LONG_NAV_SEARCH_BAR_PLACEHOLDER, RVParams.NAV_SEARCH_BAR_PLACEHOLDER, paramType, ""));
            put(RVParams.LONG_NAV_SEARCH_BAR_VALUE, new ParamImpl(RVParams.LONG_NAV_SEARCH_BAR_VALUE, RVParams.NAV_SEARCH_BAR_VALUE, paramType, ""));
            put(RVParams.LONG_NAV_SEARCH_BAR_MAX_LENGTH, new ParamImpl(RVParams.LONG_NAV_SEARCH_BAR_MAX_LENGTH, RVParams.NAV_SEARCH_BAR_MAX_LENGTH, paramType3, 0));
            put(RVParams.LONG_NAV_SEARCH_BAR_SEARCH_PLACEHOLDER, new ParamImpl(RVParams.LONG_NAV_SEARCH_BAR_SEARCH_PLACEHOLDER, RVParams.NAV_SEARCH_BAR_SEARCH_PLACEHOLDER, paramType2, bool2));
            put(RVParams.LONG_BACKBTN_IMAGE, new ParamImpl(RVParams.LONG_BACKBTN_IMAGE, RVParams.BACKBTN_IMAGE, paramType, "default"));
            put(RVParams.LONG_BACKBTN_TEXTCOLOR, new ParamImpl(RVParams.LONG_BACKBTN_TEXTCOLOR, RVParams.BACKBTN_TEXTCOLOR, paramType3, -16777216));
            put(RVParams.LONG_TITLE_COLOR, new ParamImpl(RVParams.LONG_TITLE_COLOR, RVParams.TITLE_COLOR, paramType3, -16777216));
            put(RVParams.LONG_TRANSPARENT_TITLE_TEXTAUTO, new ParamImpl(RVParams.LONG_TRANSPARENT_TITLE_TEXTAUTO, RVParams.TRANSPARENT_TITLE_TEXTAUTO, paramType, "NO"));
            put(RVParams.LONG_PRESSO_LOGIN, new ParamImpl(RVParams.LONG_PRESSO_LOGIN, "ps", paramType, "YES"));
            put(RVParams.LONG_PRESSO_LOGIN_BINDINGPAGE, new ParamImpl(RVParams.LONG_PRESSO_LOGIN_BINDINGPAGE, RVParams.PRESSO_LOGIN_BINDINGPAGE, paramType, ""));
            put(RVParams.LONG_PRESSO_LOGIN_URL, new ParamImpl(RVParams.LONG_PRESSO_LOGIN_URL, RVParams.PRESSO_LOGIN_URL, paramType, ""));
            put("tabBarJson", new ParamImpl("tabBarJson", "tabBarJson", paramType, ""));
            put("enableTabBar", new ParamImpl("enableTabBar", "enableTabBar", paramType, "default"));
            put("tabItemCount", new ParamImpl("tabItemCount", "tabItemCount", paramType3, -1));
            put(RVParams.LONG_TITLE_BAR_COLOR, new ParamImpl(RVParams.LONG_TITLE_BAR_COLOR, RVParams.LONG_TITLE_BAR_COLOR, paramType3, null));
            put("preventAutoLoginLoop", new ParamImpl("preventAutoLoginLoop", "preventAutoLoginLoop", paramType2, bool2));
            put(RVStartParams.KEY_TRANS_ANIMATE, new ParamImpl(RVStartParams.KEY_TRANS_ANIMATE, RVParams.TRANS_ANIMATE, paramType2, bool2));
            put(RVParams.LONG_NB_OFFMODE, new ParamImpl(RVParams.LONG_NB_OFFMODE, RVParams.NB_OFFMODE, paramType, "force"));
            put("openUrlMethod", new ParamImpl("openUrlMethod", "openUrlMethod", paramType, "GET"));
            put("openUrlPostParams", new ParamImpl("openUrlPostParams", "openUrlPostParams", paramType, ""));
            put(RVParams.LONG_SHARETOKENPARAMS, new ParamImpl(RVParams.LONG_SHARETOKENPARAMS, "stp", paramType, ""));
        }
    };

    private static void a(@NonNull Bundle bundle) {
        String string = BundleUtils.getString(bundle, "tt");
        if (TextUtils.isEmpty(string)) {
            string = BundleUtils.getString(bundle, RVStartParams.KEY_TRANSPARENT);
        }
        if (TextUtils.isEmpty(string) && (BundleUtils.getBoolean(bundle, RVStartParams.KEY_TRANSPARENT, false) || BundleUtils.getBoolean(bundle, "tt", false))) {
            string = "YES";
        }
        if ("YES".equalsIgnoreCase(string) || "TRUE".equalsIgnoreCase(string)) {
            bundle.remove("st");
            bundle.remove(RVParams.LONG_SHOW_TITLEBAR);
            bundle.remove(RVParams.SHOW_TOOLBAR);
            bundle.remove(RVParams.LONG_SHOW_TOOLBAR);
            bundle.remove(RVParams.SHOW_PROGRESS);
            bundle.remove(RVParams.LONG_SHOW_PROGRESS);
            bundle.remove("sd");
            bundle.remove(RVParams.LONG_SHOW_DOMAIN);
            bundle.remove("pd");
            bundle.remove(RVParams.LONG_CAN_PULL_DOWN);
            bundle.remove(RVParams.ALLOWS_BOUNCE_VERTICAL);
            bundle.remove(RVParams.LONG_ALLOWS_BOUNCE_VERTICAL);
            bundle.putString("st", "NO");
            bundle.putString(RVParams.LONG_SHOW_TITLEBAR, "NO");
            bundle.putString(RVParams.SHOW_TOOLBAR, "NO");
            bundle.putString(RVParams.LONG_SHOW_TOOLBAR, "NO");
            bundle.putString(RVParams.SHOW_PROGRESS, "NO");
            bundle.putString(RVParams.LONG_SHOW_PROGRESS, "NO");
            bundle.putString("sd", "NO");
            bundle.putString(RVParams.LONG_SHOW_DOMAIN, "NO");
            bundle.putString("pd", "NO");
            bundle.putString(RVParams.LONG_CAN_PULL_DOWN, "NO");
            bundle.putString(RVParams.ALLOWS_BOUNCE_VERTICAL, "NO");
            bundle.putString(RVParams.LONG_ALLOWS_BOUNCE_VERTICAL, "NO");
            if (bundle.containsKey("backgroundColor") || bundle.containsKey(RVParams.BACKGROUND_COLOR)) {
                return;
            }
            String string2 = BundleUtils.getString(bundle, "fullscreen");
            if (BundleUtils.getBoolean(bundle, "fullscreen", false)) {
                return;
            }
            if (TextUtils.isEmpty(string2) || !string2.equals("YES")) {
                String string3 = BundleUtils.getString(bundle, RVStartParams.KEY_TRANS_ANIMATE);
                boolean z = BundleUtils.getBoolean(bundle, RVStartParams.KEY_TRANS_ANIMATE, false);
                if ((TextUtils.isEmpty(string3) || !"YES".equals(string3)) && !z) {
                    bundle.putInt(RVParams.BACKGROUND_COLOR, 855638016);
                    bundle.putInt("backgroundColor", 855638016);
                } else {
                    bundle.putInt(RVParams.BACKGROUND_COLOR, -1291845632);
                    bundle.putInt("backgroundColor", -1291845632);
                }
            }
        }
    }

    private static void b(Bundle bundle) {
        if (bundle.containsKey(RVParams.LONG_SHOW_OPTION_MENU) || bundle.containsKey(RVParams.SHOW_OPTION_MENU)) {
            return;
        }
        boolean z = BundleUtils.getBoolean(bundle, RVParams.isH5App, false);
        StringBuilder sb = new StringBuilder();
        sb.append("pre-fill set showOptionMenu as ");
        sb.append(!z);
        RVLogger.d(f23818a, sb.toString());
        bundle.putBoolean(RVParams.LONG_SHOW_OPTION_MENU, !z);
    }

    public static void filterCreatePageParams(Bundle bundle) {
        bundle.remove("url");
        bundle.remove("MINI-PROGRAM-WEB-VIEW-TAG");
        RVLogger.d(f23818a, "in H5SessionPlugin delete preRpc startparam");
        bundle.remove("preRpc");
        bundle.remove(RVParams.LONG_NAV_SEARCH_BAR_TYPE);
        bundle.remove(RVStartParams.KEY_FRAGMENT_TYPE);
        bundle.remove(RVStartParams.KEY_FROM_RELAUNCH);
        bundle.remove("backgroundColor");
        bundle.remove("transparentTitle");
        bundle.remove(RVParams.LONG_TRANSPARENT_TITLE_TEXTAUTO);
        RVLogger.d(f23818a, "in H5SessionPlugin delete titleImage startparam");
        bundle.remove(RVParams.LONG_TITLE_IMAGE);
        bundle.remove(RVParams.LONG_BOUNCE_TOP_COLOR);
        bundle.remove("closeAllWindow");
        bundle.remove(RVParams.DISABLE_PAGE_ROUTE);
    }

    public static boolean isShowTransAnimate(Bundle bundle) {
        return BundleUtils.getBoolean(bundle, RVStartParams.KEY_TRANSPARENT, false) && BundleUtils.getBoolean(bundle, RVStartParams.KEY_TRANS_ANIMATE, false);
    }

    public static void mergeParams(Bundle bundle, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.isEmpty()) {
            return;
        }
        for (String str : jSONObject.keySet()) {
            ParamImpl paramImplA = a(str);
            if (paramImplA == null || (bundle.get(paramImplA.getLongName()) == null && bundle.get(paramImplA.getShortName()) == null)) {
                Object obj = jSONObject.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!bundle.containsKey(str) || TextUtils.isEmpty(BundleUtils.getString(bundle, str))) {
                        bundle.putString(str, str2);
                    } else {
                        RVLogger.d(f23818a, "bundle contain " + str + " value:" + BundleUtils.getString(bundle, str) + " not to merge appInfo");
                    }
                } else if (obj instanceof Boolean) {
                    bundle.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if (obj instanceof BigDecimal) {
                    bundle.putDouble(str, ((BigDecimal) obj).doubleValue());
                } else if (obj instanceof Integer) {
                    bundle.putInt(str, ((Integer) obj).intValue());
                } else if (obj instanceof JSONObject) {
                    bundle.putString(str, ((JSONObject) obj).toString());
                } else if (obj instanceof JSONArray) {
                    bundle.putString(str, ((JSONArray) obj).toString());
                }
            } else {
                RVLogger.d(f23818a, "merge config [key] " + str + " already exists and value not empty");
            }
        }
    }

    @Nullable
    public static Map<String, String> parseMagicOptions(String str, boolean z) {
        String strDecode;
        if (TextUtils.isEmpty(str)) {
            RVLogger.w(f23818a, "no url found in magic parameter");
            return null;
        }
        String param = UrlUtils.getParam(UrlUtils.parseUrl(str), b, null);
        if (TextUtils.isEmpty(param)) {
            RVLogger.w(f23818a, "no magic options found");
            return null;
        }
        RVLogger.d(f23818a, "found magic options " + param);
        try {
            strDecode = URLDecoder.decode(param, "UTF-8");
        } catch (Throwable th) {
            RVLogger.e(f23818a, "magic options decode exp ", th);
            strDecode = null;
        }
        if (TextUtils.isEmpty(strDecode)) {
            RVLogger.e(f23818a, "failed to decode magic options");
            return null;
        }
        try {
            String[] strArrSplit = strDecode.split("&");
            if (strArrSplit != null && strArrSplit.length != 0) {
                HashMap map = new HashMap();
                for (String str2 : strArrSplit) {
                    String[] strArrSplit2 = str2.split("=");
                    if (strArrSplit2.length >= 2) {
                        map.put(URLDecoder.decode(strArrSplit2[0], "UTF-8"), URLDecoder.decode(strArrSplit2[1], "UTF-8"));
                    } else if (z) {
                        map.put(URLDecoder.decode(strArrSplit2[0], "UTF-8"), null);
                    }
                }
                return map;
            }
            return null;
        } catch (Exception e) {
            RVLogger.e(f23818a, "failed to decode magic option.", e);
            return null;
        }
    }

    public static void processTransparent(Bundle bundle) {
        int i;
        if (BundleUtils.getBoolean(bundle, RVStartParams.KEY_TRANSPARENT, false) || (i = BundleUtils.getInt(bundle, "backgroundColor", -16777216)) == -16777216) {
            return;
        }
        bundle.putInt("backgroundColor", (-16777216) | i);
    }

    public static void remove(Bundle bundle, String str) {
        ParamImpl paramImplA;
        if (bundle == null || TextUtils.isEmpty(str) || (paramImplA = a(str)) == null) {
            return;
        }
        bundle.remove(paramImplA.getLongName());
        bundle.remove(paramImplA.getShortName());
    }

    public static boolean transparentBackground(Bundle bundle) {
        return !TextUtils.isEmpty(BundleUtils.getString(bundle, RVStartParams.KEY_BACKGROUND_IMAGE_URL));
    }

    public static Bundle unify(Bundle bundle, String str, boolean z) {
        return !c.containsKey(str) ? bundle : c.get(str).unify(bundle, z);
    }

    public static Bundle unifyAll(Bundle bundle, boolean z) {
        if (bundle == null) {
            return null;
        }
        a(bundle);
        c.get(RVParams.LONG_SHOW_PROGRESS).setDefaultValue(Boolean.valueOf(AppPermissionUtils.ALIPAY_WEB_COMMON_APPID.equals(BundleUtils.getString(bundle, "appId"))));
        if (z) {
            b(bundle);
        }
        Iterator<String> it = c.keySet().iterator();
        while (it.hasNext()) {
            bundle = c.get(it.next()).unify(bundle, z);
        }
        String string = BundleUtils.getString(bundle, RVParams.LONG_ALLOWS_BOUNCE_VERTICAL, "");
        RVLogger.d(f23818a, "merge LONG_ALLOWS_BOUNCE_VERTICAL & LONG_CAN_PULL_DOWN " + string);
        if (!TextUtils.isEmpty(string)) {
            if ("YES".equals(string)) {
                bundle.putBoolean(RVParams.LONG_CAN_PULL_DOWN, true);
            } else if ("NO".equals(string)) {
                bundle.putBoolean(RVParams.LONG_CAN_PULL_DOWN, false);
            }
        }
        int i = BundleUtils.getInt(bundle, "tabItemCount", -1);
        String string2 = BundleUtils.getString(bundle, "enableTabBar", "default");
        RVLogger.d(f23818a, "tabItemCount " + i + ", enableTabBar " + string2);
        if (TextUtils.equals("default", string2)) {
            if (i != -1) {
                bundle.putString("enableTabBar", "YES");
            }
        } else if (TextUtils.equals("YES", string2) && i == -1) {
            bundle.putInt("tabItemCount", 4);
        }
        if (bundle.containsKey(RVParams.LONG_SHOW_THIRDDISCLAIMER)) {
            RVLogger.d(f23818a, "parse contains LONG_SHOW_THIRDDISCLAIMER force set true");
            bundle.remove(RVParams.LONG_SHOW_THIRDDISCLAIMER);
            bundle.putBoolean(RVParams.LONG_SHOW_THIRDDISCLAIMER, true);
        }
        return bundle;
    }

    public static void parseMagicOptions(Bundle bundle, String str) {
        Map<String, String> magicOptions = parseMagicOptions(str, false);
        if (magicOptions == null || magicOptions.isEmpty()) {
            return;
        }
        try {
            for (Map.Entry<String, String> entry : magicOptions.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(value) && !"dr".equals(key) && !RVParams.LONG_DELAY_RENDER.equals(key) && !"tt".equals(key) && !RVStartParams.KEY_TRANSPARENT.equals(key)) {
                    remove(bundle, key);
                    bundle.putString(key, value);
                    RVLogger.d(f23818a, "decode magic option [key] " + key + " [value] " + value);
                }
            }
            if (bundle.containsKey(RVParams.LONG_SHOW_THIRDDISCLAIMER)) {
                RVLogger.d(f23818a, "parseMagicOptions contains LONG_SHOW_THIRDDISCLAIMER force set true");
                bundle.remove(RVParams.LONG_SHOW_THIRDDISCLAIMER);
                bundle.putBoolean(RVParams.LONG_SHOW_THIRDDISCLAIMER, true);
            }
        } catch (Exception e) {
            RVLogger.e(f23818a, "failed to decode magic option.", e);
        }
    }

    private static ParamImpl a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<String> it = c.keySet().iterator();
        while (it.hasNext()) {
            ParamImpl paramImpl = c.get(it.next());
            String longName = paramImpl.getLongName();
            String shortName = paramImpl.getShortName();
            if (str.equals(longName) || str.equals(shortName)) {
                return paramImpl;
            }
        }
        return null;
    }
}
