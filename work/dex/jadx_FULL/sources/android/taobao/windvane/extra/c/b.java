package android.taobao.windvane.extra.c;

import android.taobao.windvane.base.m;
import android.taobao.windvane.util.TaoLog;
import com.uc.webview.export.WebResourceResponse;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static android.taobao.windvane.base.b.InterfaceC0007b f21224a = (android.taobao.windvane.base.b.InterfaceC0007b) m.a().b(android.taobao.windvane.base.b.InterfaceC0007b.class);
    private static String b = b.class.getSimpleName();

    /* JADX INFO: Removed unreachable split cross block B:27:0x0054 */
    public static WebResourceResponse a(String str, Map<String, String> map, String str2, String str3, InputStream inputStream) {
        WebResourceResponse webResourceResponse = new WebResourceResponse(str2, str3, inputStream);
        try {
            if (map != null) {
                try {
                    android.taobao.windvane.base.b.InterfaceC0007b interfaceC0007b = f21224a;
                    if (interfaceC0007b == null || !interfaceC0007b.e(str) || map.containsKey("Access-Control-Allow-Origin")) {
                        webResourceResponse.setResponseHeaders(map);
                    } else {
                        HashMap map2 = new HashMap();
                        map2.putAll(map);
                        map2.put("Access-Control-Allow-Origin", "*");
                        webResourceResponse.setResponseHeaders(map2);
                        TaoLog.i(b, "add cross origin header");
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else {
                android.taobao.windvane.base.b.InterfaceC0007b interfaceC0007b2 = f21224a;
                if (interfaceC0007b2 != null && interfaceC0007b2.e(str)) {
                    HashMap map3 = new HashMap();
                    map3.put("Access-Control-Allow-Origin", "*");
                    webResourceResponse.setResponseHeaders(map3);
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return webResourceResponse;
    }
}
