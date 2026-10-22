package android.taobao.windvane.extra.a;

import android.taobao.windvane.base.j;
import android.taobao.windvane.base.m;
import android.taobao.windvane.extra.uc.WVUCWebView;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import anetwork.channel.Request;
import anetwork.channel.Response;
import anetwork.channel.entity.RequestImpl;
import com.alibaba.android.arouter.utils.Consts;
import com.aliyun.auth.common.AliyunVodHttpCommon;
import com.taobao.tao.util.ImageStrategyDecider;
import com.uc.webview.export.internal.interfaces.EventHandler;
import com.uc.webview.export.internal.interfaces.IRequest;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class c implements IRequest {
    public static final String c = "reload";
    public static final String d = "stop";
    public static final String e = "enddata";
    private static final String v = "normal";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f21218a;
    Request b;
    public String f;
    Future<Response> g;
    private EventHandler h;
    private String i;
    private String j;
    private Map<String, String> k;
    private Map<String, byte[]> l;
    private Map<String, String> m;
    private Map<String, String> n;
    private long o;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private String t;
    private final Object u;

    public c(Request request, EventHandler eventHandler) {
        this.f21218a = "alinetwork";
        this.j = "GET";
        this.u = new Object();
        this.f = "normal";
        this.h = eventHandler;
    }

    private Request a(String str, String str2, boolean z, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, byte[]> map4, long j, int i, int i2, boolean z2) {
        if (z2) {
            try {
                if (a(str)) {
                    String strJustConvergeAndWebP = ImageStrategyDecider.justConvergeAndWebP(str);
                    if (!TextUtils.isEmpty(strJustConvergeAndWebP) && !strJustConvergeAndWebP.equals(str)) {
                        TaoLog.i(this.f21218a, str + " decideUrl to : " + strJustConvergeAndWebP);
                        str = strJustConvergeAndWebP;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        try {
            RequestImpl requestImpl = new RequestImpl(str);
            requestImpl.setFollowRedirects(false);
            requestImpl.setBizId(this.t);
            requestImpl.setCookieEnabled(WVUCWebView.isNeedCookie(str));
            requestImpl.setMethod(str2);
            if (map != null) {
                requestImpl.addHeader("f-refer", "wv_h5");
                f.a().a(map, str);
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (TaoLog.getLogStatus()) {
                        TaoLog.d(this.f21218a, "AliRequestAdapter from uc header key=" + key + ",value=" + value);
                    }
                    requestImpl.addHeader(key, value);
                }
            }
            j jVar = (j) m.a().b(j.class);
            if (jVar != null && jVar.d() != null) {
                jVar.d().f(this.i, System.currentTimeMillis());
            }
            return requestImpl;
        } catch (Exception e2) {
            TaoLog.e(this.f21218a, " AliRequestAdapter formatAliRequest Exception" + e2.getMessage());
            return null;
        }
    }

    private Request c() {
        return a(this.i, this.j, this.p, this.m, this.n, this.k, this.l, this.o, this.r, this.s, this.q);
    }

    public Request b() {
        return this.b;
    }

    public void cancel() {
        Future<Response> future;
        if (WVUCWebView.isStop) {
            this.f = "stop";
        }
        TaoLog.e(this.f21218a, "cancel id= " + this.h.hashCode() + ", phase:[" + this.f + "]");
        try {
            if (TaoLog.getLogStatus() && (future = this.g) != null && future.get() != null) {
                TaoLog.d(this.f21218a, "AliRequestAdapter cancel desc url=" + this.g.get().getDesc());
            }
            a();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            TaoLog.d(this.f21218a, "AliRequestAdapter cancel =" + e2.getMessage());
        } catch (ExecutionException e3) {
            e3.printStackTrace();
            TaoLog.d(this.f21218a, "AliRequestAdapter cancel =" + e3.getMessage());
        }
        Future<Response> future2 = this.g;
        if (future2 != null) {
            future2.cancel(true);
        }
    }

    public EventHandler getEventHandler() {
        return this.h;
    }

    public Map<String, String> getHeaders() {
        return this.m;
    }

    public boolean getIsUCProxy() {
        return this.p;
    }

    public int getLoadtype() {
        return this.s;
    }

    public String getMethod() {
        return this.j;
    }

    public int getRequestType() {
        return this.r;
    }

    public Map<String, String> getUCHeaders() {
        return this.n;
    }

    public Map<String, byte[]> getUploadDataMap() {
        return this.l;
    }

    public Map<String, String> getUploadFileMap() {
        return this.k;
    }

    public long getUploadFileTotalLen() {
        return this.o;
    }

    public String getUrl() {
        return this.i;
    }

    public void handleSslErrorResponse(boolean z) {
    }

    public void setEventHandler(EventHandler eventHandler) {
        this.h = eventHandler;
    }

    public void waitUntilComplete(int i) {
        if (this.h.isSynchronous()) {
            synchronized (this.u) {
                try {
                    if (TaoLog.getLogStatus()) {
                        TaoLog.d(this.f21218a, "AliRequestAdapter waitUntilComplete timeout=" + i + ",url=" + this.i);
                    }
                    this.u.wait(i);
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    public c(EventHandler eventHandler, String str, String str2, boolean z, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, byte[]> map4, long j, int i, int i2, boolean z2, String str3) {
        this.f21218a = "alinetwork";
        this.u = new Object();
        this.f = "normal";
        this.q = z2;
        this.h = eventHandler;
        this.i = str;
        this.j = str2;
        this.p = z;
        this.m = map;
        this.n = map2;
        this.k = map3;
        this.l = map4;
        this.o = j;
        this.r = i;
        this.s = i2;
        this.t = str3;
        this.b = c();
    }

    public void a(Future<Response> future) {
        this.g = future;
    }

    public void a() {
        WVUCWebView.isStop = false;
        if (this.h.isSynchronous()) {
            synchronized (this.u) {
                if (TaoLog.getLogStatus()) {
                    TaoLog.d(this.f21218a, "AliRequestAdapter complete will notify");
                }
                this.u.notifyAll();
            }
        }
    }

    private boolean a(String str) {
        if (str != null && -1 != str.lastIndexOf(Consts.DOT)) {
            String strSubstring = str.substring(str.lastIndexOf(Consts.DOT) + 1, str.length());
            String[] strArr = {"png", AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG, "jpg", "webp"};
            for (int i = 0; i < 4; i++) {
                if (strArr[i].equals(strSubstring)) {
                    return true;
                }
            }
        }
        return false;
    }
}
