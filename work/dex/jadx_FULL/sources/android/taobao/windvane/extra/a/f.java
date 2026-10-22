package android.taobao.windvane.extra.a;

import android.os.Handler;
import android.os.Message;
import android.taobao.windvane.extra.uc.WVUCWebView;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVUrlUtil;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class f implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f21221a = 276;
    private static final String b = "UCNetworkDelegate";
    private static final int c = 273;
    private static final int d = 274;
    private static final int e = 275;
    private static f h;
    private Map<WeakReference<WVUCWebView>, String> f = new ConcurrentHashMap();
    private Handler g = new g("Windvane", this).a();

    private f() {
    }

    public static f a() {
        if (h == null) {
            synchronized (f.class) {
                if (h == null) {
                    h = new f();
                }
            }
        }
        return h;
    }

    private void c(Object obj) {
        if (obj instanceof Hashtable) {
            Hashtable<String, String> hashtable = (Hashtable) obj;
            String strRemoveHashCode = WVUrlUtil.removeHashCode(WVUrlUtil.removeScheme(hashtable.get("url")));
            String strRemoveScheme = WVUrlUtil.removeScheme(hashtable.get("referrer"));
            if (TextUtils.isEmpty(strRemoveScheme)) {
                if (this.f.containsValue(strRemoveHashCode)) {
                    for (WeakReference<WVUCWebView> weakReference : this.f.keySet()) {
                        weakReference.get();
                        if (weakReference.get() != null && this.f.get(weakReference).equals(strRemoveHashCode)) {
                            a(hashtable, strRemoveHashCode, strRemoveScheme, weakReference);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            if (this.f.containsValue(strRemoveScheme)) {
                for (WeakReference<WVUCWebView> weakReference2 : this.f.keySet()) {
                    if (weakReference2.get() != null && this.f.get(weakReference2).equals(strRemoveScheme)) {
                        a(hashtable, strRemoveHashCode, strRemoveScheme, weakReference2);
                        return;
                    }
                }
                return;
            }
            for (WeakReference<WVUCWebView> weakReference3 : this.f.keySet()) {
                if (weakReference3.get() != null && e.a().a(strRemoveScheme)) {
                    a(hashtable, strRemoveHashCode, strRemoveScheme, weakReference3);
                    return;
                }
            }
        }
    }

    private void d(Object obj) {
        if (obj instanceof Hashtable) {
            Hashtable<String, String> hashtable = (Hashtable) obj;
            String strRemoveHashCode = WVUrlUtil.removeHashCode(WVUrlUtil.removeScheme(hashtable.get("url")));
            for (WeakReference<WVUCWebView> weakReference : this.f.keySet()) {
                String str = this.f.get(weakReference);
                if (str != null && str.contains(strRemoveHashCode)) {
                    a(hashtable, strRemoveHashCode, weakReference);
                    return;
                }
            }
            for (WeakReference<WVUCWebView> weakReference2 : this.f.keySet()) {
                if (weakReference2.get() != null && e.a().a(strRemoveHashCode)) {
                    a(hashtable, strRemoveHashCode, weakReference2);
                    return;
                }
            }
        }
    }

    public Map<WeakReference<WVUCWebView>, String> b() {
        return this.f;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 273:
                c(message.obj);
                return false;
            case 274:
                d(message.obj);
                return false;
            case 275:
                a(message.obj);
                break;
            case 276:
                break;
            default:
                return false;
        }
        b(message.obj);
        return false;
    }

    private void b(Object obj) {
        if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            if ((arrayList.get(0) instanceof WVUCWebView) && (arrayList.get(1) instanceof String)) {
                WVUCWebView wVUCWebView = (WVUCWebView) arrayList.get(0);
                String strRemoveHashCode = WVUrlUtil.removeHashCode(WVUrlUtil.removeScheme((String) arrayList.get(1)));
                for (WeakReference<WVUCWebView> weakReference : this.f.keySet()) {
                    WVUCWebView wVUCWebView2 = weakReference.get();
                    if (wVUCWebView2 != null && wVUCWebView.equals(wVUCWebView2)) {
                        e.a().c();
                        this.f.put(weakReference, strRemoveHashCode);
                        return;
                    }
                }
                this.f.put(new WeakReference<>(wVUCWebView), strRemoveHashCode);
            }
        }
    }

    public void a(WVUCWebView wVUCWebView) {
        Message messageObtainMessage = this.g.obtainMessage();
        messageObtainMessage.what = 275;
        messageObtainMessage.obj = wVUCWebView;
        this.g.sendMessage(messageObtainMessage);
    }

    public void a(WVUCWebView wVUCWebView, String str) {
        Message messageObtainMessage = this.g.obtainMessage();
        messageObtainMessage.what = 276;
        ArrayList arrayList = new ArrayList();
        arrayList.add(wVUCWebView);
        arrayList.add(str);
        messageObtainMessage.obj = arrayList;
        this.g.sendMessage(messageObtainMessage);
    }

    public void a(Map<String, String> map, String str) {
        if (this.f == null || map == null || str == null) {
            return;
        }
        Message messageObtainMessage = this.g.obtainMessage();
        messageObtainMessage.what = 273;
        Hashtable hashtable = new Hashtable();
        hashtable.put("url", str);
        String str2 = map.get("Referer");
        hashtable.put("referrer", TextUtils.isEmpty(str2) ? "" : str2);
        hashtable.put("start", String.valueOf(System.currentTimeMillis()));
        messageObtainMessage.obj = hashtable;
        TaoLog.d(b, "onSendRequest : " + str + " Referer: " + str2);
        this.g.sendMessage(messageObtainMessage);
    }

    public void a(int i, String str) {
        if (this.f == null || str == null) {
            return;
        }
        Message messageObtainMessage = this.g.obtainMessage();
        messageObtainMessage.what = 274;
        Hashtable hashtable = new Hashtable();
        hashtable.put("url", str);
        String strValueOf = String.valueOf(i);
        hashtable.put("statusCode", strValueOf);
        hashtable.put("end", String.valueOf(System.currentTimeMillis()));
        messageObtainMessage.obj = hashtable;
        TaoLog.d(b, "onFinish : " + str + " statusCode: " + strValueOf);
        this.g.sendMessage(messageObtainMessage);
    }

    private void a(Object obj) {
        Map<WeakReference<WVUCWebView>, String> map;
        if (!(obj instanceof WVUCWebView) || (map = this.f) == null) {
            return;
        }
        for (WeakReference<WVUCWebView> weakReference : map.keySet()) {
            WVUCWebView wVUCWebView = weakReference.get();
            if (wVUCWebView != null && obj.equals(wVUCWebView)) {
                this.f.remove(weakReference);
                return;
            }
        }
    }

    private void a(Hashtable<String, String> hashtable, String str, String str2, WeakReference<WVUCWebView> weakReference) {
        WVUCWebView wVUCWebView = weakReference.get();
        if (wVUCWebView == null) {
            return;
        }
        e.a().a(str, "url", TextUtils.isEmpty(str) ? "" : str);
        e eVarA = e.a();
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        eVarA.a(str, "referrer", str2);
        e.a().a(str, "start", String.valueOf(Long.parseLong(hashtable.get("start")) - wVUCWebView.mPageStart));
    }

    private void a(Hashtable<String, String> hashtable, String str, WeakReference<WVUCWebView> weakReference) {
        WVUCWebView wVUCWebView = weakReference.get();
        if (wVUCWebView == null) {
            return;
        }
        e.a().a(str, "statusCode", hashtable.get("statusCode"));
        e.a().a(str, "end", String.valueOf(Long.parseLong(hashtable.get("end")) - wVUCWebView.mPageStart));
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (WeakReference<WVUCWebView> weakReference : this.f.keySet()) {
            WVUCWebView wVUCWebView = weakReference.get();
            if (wVUCWebView != null && str.equals(WVUrlUtil.removeQueryParam(this.f.get(weakReference)))) {
                TaoLog.i(b, "Get bizCode : " + wVUCWebView.bizCode);
                return wVUCWebView.bizCode;
            }
        }
        return "";
    }
}
