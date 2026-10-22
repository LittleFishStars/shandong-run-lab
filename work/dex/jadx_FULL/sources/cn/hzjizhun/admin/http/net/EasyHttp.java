package cn.hzjizhun.admin.http.net;

import android.text.TextUtils;
import cn.hzjizhun.admin.http.net.callback.IBaseEasyCallback;
import cn.hzjizhun.admin.http.net.core.EasyRequestManager;
import cn.hzjizhun.admin.http.net.core.Request;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class EasyHttp {
    private static EasyHttpConfig sConfig = new EasyHttpConfig();
    private static EasyRequestManager sEasyRequestManager = new EasyRequestManager();

    private EasyHttp() {
    }

    public static void cancelAll() {
        sEasyRequestManager.performCancelAll();
    }

    public static void cancelRequest(Object obj) {
        sEasyRequestManager.performCancelRequest(obj);
    }

    public static EasyHttpConfig getConfig() {
        return sConfig;
    }

    public static void initializeConfig(EasyHttpConfig easyHttpConfig) {
        sConfig = easyHttpConfig;
    }

    public static void sendRequest(Request request, IBaseEasyCallback iBaseEasyCallback) {
        try {
            if (request == null) {
                throw new NullPointerException("request == null");
            }
            if (TextUtils.isEmpty(request.url)) {
                throw new NullPointerException("url == null");
            }
            Object obj = request.tag;
            if (obj == null) {
                obj = request.url;
            }
            request.tag = obj;
            sEasyRequestManager.performRequest(sConfig, request, iBaseEasyCallback);
        } catch (Throwable unused) {
            boolean z = EasyHttpUtils.sisOpen;
        }
    }
}
