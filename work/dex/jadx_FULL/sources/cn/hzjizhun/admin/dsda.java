package cn.hzjizhun.admin;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import cn.hzjizhun.admin.api.ApiManager;
import com.igexin.sdk.PushConsts;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class dsda {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f22716a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static HashMap f296a;
    public static String b;
    public static String c;
    public static String d;

    static {
        HashMap map = new HashMap();
        f296a = map;
        map.put("10001", "初始化接口失败或者返回为空");
        f296a.put("10004", "请求广告时，初始化未完成");
        f296a.put("10002", "没有添加 wx appid");
        f296a.put("10003", "没有调用初始化方法，或者没有传入 appId");
        f296a.put("10005", "");
        f296a.put(PushConsts.SEND_MESSAGE_ERROR_GENERAL, "用户使用的posid，与 初始化接口返回的配置不匹配");
        f296a.put(PushConsts.SEND_MESSAGE_ERROR_TIME_OUT, "图片素材错误，不能正常加载");
        f296a.put("20003", "没有匹配到广告渠道");
        d = "https://ad.shunchangzhixing.com";
    }

    public static String a() {
        return c;
    }

    public static String b() {
        return f22716a;
    }

    public static String c() {
        return d;
    }

    public static HashMap d() {
        return f296a;
    }

    public static void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String appId = JZAdSdk.getInstance().getAppId();
        if (str.endsWith(WVNativeCallbackUtil.SEPERATER)) {
            f22716a = str + "infoConfig/" + appId;
            b = str + "notice/" + appId;
            if (str.contains("ad.jzon")) {
                c = "https://ad.shunchangzhixing.com/keenValue/" + appId;
            } else {
                c = str + "keenValue/" + appId;
            }
        } else {
            f22716a = str + "/infoConfig/" + appId;
            b = str + "/notice/" + appId;
            if (str.contains("ad.jzon")) {
                c = "https://ad.shunchangzhixing.com/keenValue/" + appId;
            } else {
                c = str + "/keenValue/" + appId;
            }
        }
        if (str.contains("ad.jzon")) {
            d = "https://ad.shunchangzhixing.com";
        } else {
            d = str;
        }
        ApiManager.requestFile(appId);
        ApiManager.getFInfo(appId);
    }

    public static String f() {
        return b;
    }
}
