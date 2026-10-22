package android.taobao.windvane.embed;

import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import com.uc.webview.export.extension.EmbedViewConfig;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class WVEVManager {
    private static final String TAG = "WVEVManager";
    private static final Map<String, a> embedViews = new ConcurrentHashMap();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f21211a;
        private ClassLoader b;

        public a(String str) {
            this.f21211a = str;
        }

        public void a(ClassLoader classLoader) {
            this.b = classLoader;
        }

        public String b() {
            return this.f21211a;
        }

        public ClassLoader a() {
            return this.b;
        }

        public a(String str, ClassLoader classLoader) {
            this.f21211a = str;
            this.b = classLoader;
        }

        public void a(String str) {
            this.f21211a = str;
        }
    }

    public static BaseEmbedView createEV(String str, String str2, android.taobao.windvane.d.b bVar, EmbedViewConfig embedViewConfig) {
        a ev = getEv(str2);
        if (ev == null) {
            TaoLog.e(TAG, "no register view with type:[" + str2 + "]");
            return null;
        }
        try {
            ClassLoader classLoaderA = ev.a();
            Class<?> cls = classLoaderA == null ? Class.forName(ev.b()) : classLoaderA.loadClass(ev.b());
            if (cls == null || !BaseEmbedView.class.isAssignableFrom(cls)) {
                TaoLog.e(TAG, "no class found");
            } else {
                BaseEmbedView baseEmbedView = (BaseEmbedView) cls.newInstance();
                if (baseEmbedView.init(str, str2, bVar, embedViewConfig)) {
                    return baseEmbedView;
                }
                TaoLog.e(TAG, "type check error, required type:[" + baseEmbedView.getViewType() + "], real type:[" + str2 + "]");
            }
        } catch (Exception e) {
            TaoLog.e(TAG, "create embed view error, type:" + str2 + " | msg:" + e.getMessage());
        }
        return null;
    }

    public static a getEv(String str) {
        return embedViews.get(str);
    }

    public static void registerEmbedView(String str, Class<? extends BaseEmbedView> cls, boolean z) {
        if (TextUtils.isEmpty(str) || cls == null) {
            return;
        }
        a aVar = new a(cls.getName(), z ? cls.getClassLoader() : null);
        Map<String, a> map = embedViews;
        if (map.containsKey(str)) {
            TaoLog.e(TAG, "new view:[" + cls.getSimpleName() + "] will overlap the old view [" + map.get(str).b() + "]");
        }
        map.put(str, aVar);
    }
}
