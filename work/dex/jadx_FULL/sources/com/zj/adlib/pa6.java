package com.zj.adlib;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huachenjie.base.dialog.ShareDialog;
import com.huachenjie.common.callback.VoidCallback;
import com.huachenjie.common.util.open.OpenThirdApp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class pa6 implements OpenThirdApp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f43937a;

    public pa6() {
        HashMap map = new HashMap();
        this.f43937a = map;
        map.clear();
        map.put("alipay", "支付宝APP");
        map.put("dingtalk", "钉钉APP");
        map.put("taobao", "淘宝APP");
        map.put("tbopen", "淘宝APP");
        map.put("tmall", "天猫APP");
        map.put("mqq", "QQ");
        map.put("qqmusic", "QQ音乐APP");
        map.put("qqbrowser", "QQ浏览器APP");
        map.put("mttbrowser", "QQ浏览器APP");
        map.put("qqmail", "QQ邮箱APP");
        map.put("tenvideo", "腾讯视频APP");
        map.put("qqmap", "腾讯地图APP");
        map.put(nl0.WEIXIN_PRE, "微信APP");
        map.put(ShareDialog.WECHAT, "微信APP");
        map.put("baiduboxapp", "百度APP");
        map.put("bdapp", "百度地图APP");
        map.put("imeituan", "美团APP");
        map.put("jd", "京东APP");
        map.put("openapp.jdmobile", "京东APP");
        map.put("snssdk1128", "抖音APP");
        map.put("kwai", "快手APP");
        map.put("youku", "优酷APP");
        map.put("weibo", "新浪微博APP");
        map.put("amapuri", "高德地图APP");
        map.put("iqiyi", "爱奇艺APP");
        map.put("zhihu", "知乎APP");
        map.put("pinduoduo", "拼多多APP");
    }

    public static /* synthetic */ void e(Uri uri, Context context, VoidCallback voidCallback) {
        try {
            try {
                context.startActivity(new Intent("android.intent.action.VIEW", uri));
            } catch (Exception unused) {
                fv5.b("您暂未安装相关APP");
            }
        } finally {
            voidCallback.a();
        }
    }

    public static /* synthetic */ void f(String str, String str2, VoidCallback voidCallback) {
        try {
            try {
                IWXAPI iwxapiM = it9.a.m();
                WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
                req.userName = str;
                req.path = str2;
                req.miniprogramType = 0;
                iwxapiM.sendReq(req);
            } catch (Exception unused) {
                fv5.b("您暂未安装微信APP");
            }
        } finally {
            voidCallback.a();
        }
    }

    @Override // com.huachenjie.common.util.open.OpenThirdApp
    public void a(final Context context, String url, VoidCallback cancelCallback, final VoidCallback confirmCallback) {
        final Uri uri = Uri.parse(url);
        String str = this.f43937a.get(uri.getScheme());
        if (TextUtils.isEmpty(str)) {
            str = "第三方应用";
        }
        pq8.i(context, "跳转提示", "闪动校园想要打开" + str, false, "不同意", "同意", cancelCallback, new VoidCallback() { // from class: com.zj.adlib.oa6
            @Override // com.huachenjie.common.callback.VoidCallback
            public final void a() {
                pa6.e(uri, context, confirmCallback);
            }
        });
    }

    @Override // com.huachenjie.common.util.open.OpenThirdApp
    public void b(Context context, final String userName, final String path, VoidCallback cancelCallback, final VoidCallback confirmCallback) {
        pq8.i(context, "跳转提示", "闪动校园想要打开微信小程序", false, "不同意", "同意", cancelCallback, new VoidCallback() { // from class: com.zj.adlib.na6
            @Override // com.huachenjie.common.callback.VoidCallback
            public final void a() {
                pa6.f(userName, path, confirmCallback);
            }
        });
    }
}
