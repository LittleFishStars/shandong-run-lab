package android.taobao.windvane.extra.a;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.taobao.windvane.base.i;
import android.taobao.windvane.base.j;
import android.taobao.windvane.base.m;
import android.taobao.windvane.extra.uc.WVUCWebView;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.taobao.windvane.util.WVUrlUtil;
import android.text.TextUtils;
import anetwork.channel.IBodyHandler;
import anetwork.channel.Network;
import anetwork.channel.NetworkCallBack;
import anetwork.channel.NetworkEvent;
import anetwork.channel.Request;
import anetwork.channel.Response;
import anetwork.channel.degrade.DegradableNetwork;
import anetwork.channel.http.HttpNetwork;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.uc.webview.export.internal.interfaces.EventHandler;
import com.uc.webview.export.internal.interfaces.INetwork;
import com.uc.webview.export.internal.interfaces.IRequest;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.ParseException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class a implements INetwork {
    public static final int b = 0;
    public static final int c = 1;
    private static android.taobao.windvane.base.b n = (android.taobao.windvane.base.b) m.a().b(android.taobao.windvane.base.b.class);
    private static j o = (j) m.a().b(j.class);
    private static i p = (i) m.a().b(i.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f21215a;
    public boolean d;
    public boolean e;
    public HashSet<EventHandler> f;
    private Context g;
    private Network h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private String m;

    /* JADX INFO: renamed from: android.taobao.windvane.extra.a.a$a, reason: collision with other inner class name */
    public class C0009a implements NetworkCallBack.FinishListener, NetworkCallBack.ProgressListener, NetworkCallBack.ResponseCodeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        EventHandler f21217a;
        String b;
        IRequest c;
        int d = 0;
        int e = 0;

        public C0009a() {
        }

        public void a(EventHandler eventHandler) {
            this.f21217a = eventHandler;
        }

        public void onDataReceived(NetworkEvent.ProgressEvent progressEvent, Object obj) {
            if (TaoLog.getLogStatus()) {
                TaoLog.d(a.this.f21215a, "[onDataReceived] event:" + progressEvent + "event.getSize():" + progressEvent.getSize() + ", data:" + progressEvent.getBytedata().length + " bytes");
            }
            this.f21217a.data(progressEvent.getBytedata(), progressEvent.getSize());
            this.d += progressEvent.getSize();
            if (this.e == 0) {
                this.e = progressEvent.getTotal();
            }
        }

        public void onFinished(NetworkEvent.FinishEvent finishEvent, Object obj) {
            if (TaoLog.getLogStatus()) {
                TaoLog.d(a.this.f21215a, "[onFinished] event:" + finishEvent);
                TaoLog.e(a.this.f21215a, "onFinished code = " + finishEvent.getHttpCode() + ", url = " + this.b + ", rev_size = " + this.d + ", total_size = " + this.e);
            }
            if (a.o != null && a.o.d() != null) {
                try {
                    String str = finishEvent.getStatisticData().connectionType;
                    long j = finishEvent.getStatisticData().tcpConnTime;
                    a.o.d().a(this.b, System.currentTimeMillis(), str, 0L);
                } catch (Throwable th) {
                    a.o.d().a(this.b, System.currentTimeMillis(), "unknown", 0L);
                    TaoLog.e(a.this.f21215a, "didResourceFinishLoadAtTime failed : " + th.getMessage());
                }
            }
            c cVar = (c) this.c;
            int httpCode = finishEvent.getHttpCode();
            f.a().a(httpCode, this.b);
            if (httpCode >= 0) {
                if (TaoLog.getLogStatus()) {
                    TaoLog.d(a.this.f21215a, "endData");
                }
                cVar.f = c.e;
                this.f21217a.endData();
                cVar.a();
                return;
            }
            if (TaoLog.getLogStatus()) {
                TaoLog.e(a.this.f21215a, "error code=" + httpCode + ",desc=" + finishEvent.getDesc() + ",url=" + this.b);
            }
            this.f21217a.error(httpCode, finishEvent.getDesc());
            cVar.a();
        }

        /* JADX WARN: Code duplicated, block: B:35:0x0089  */
        public boolean onResponseCode(int i, Map<String, List<String>> map, Object obj) {
            String str;
            String strRemoveScheme;
            try {
                String strRemoveScheme2 = WVUrlUtil.removeScheme(WVUrlUtil.removeQueryParam(this.b));
                Map headers = this.c.getHeaders();
                if (headers != null) {
                    String str2 = (String) headers.get("Referer");
                    if (TextUtils.isEmpty(str2)) {
                        str2 = (String) headers.get(RequestParameters.SUBRESOURCE_REFERER);
                    }
                    str = str2;
                } else {
                    str = "";
                }
                String str3 = "0";
                if (strRemoveScheme2 != null && (strRemoveScheme2.endsWith(".htm") || strRemoveScheme2.endsWith(".html") || strRemoveScheme2.endsWith(WVNativeCallbackUtil.SEPERATER))) {
                    str3 = "1";
                }
                String str4 = str3;
                if ((i < 200 || i > 304) && i != 307) {
                    if (a.o != null && a.o.d() != null) {
                        a.o.d().a(this.b, str, String.valueOf(i), str4, f.a().a(strRemoveScheme2));
                    }
                } else if (i == 302) {
                    if (map == null) {
                        strRemoveScheme = "";
                    } else {
                        List<String> list = map.get("Location");
                        if (list == null) {
                            list = map.get(RequestParameters.SUBRESOURCE_LOCATION);
                        }
                        if (list != null) {
                            strRemoveScheme = list.get(0);
                            if (!TextUtils.isEmpty(strRemoveScheme)) {
                                strRemoveScheme = WVUrlUtil.removeScheme(WVUrlUtil.removeQueryParam(strRemoveScheme));
                            }
                        } else {
                            strRemoveScheme = "";
                        }
                    }
                    if (!TextUtils.isEmpty(strRemoveScheme) && a.o != null && a.o.d() != null) {
                        if (strRemoveScheme.equals("//err.tmall.com/error1.html") || strRemoveScheme.equals("//err.taobao.com/error1.html")) {
                            a.o.d().a(this.b, str, String.valueOf(404), str4, f.a().a(strRemoveScheme2));
                        } else if (strRemoveScheme.equals("//err.tmall.com/error2.html")) {
                            a.o.d().a(this.b, str, String.valueOf(500), str4, f.a().a(strRemoveScheme2));
                        }
                    }
                }
            } catch (Throwable th) {
                TaoLog.e(a.this.f21215a, "AppMonitorUtil.commitStatusCode error : " + th.getMessage());
            }
            if (map.containsKey("x-protocol") && map.get("x-protocol").size() != 0) {
                String str5 = map.get("x-protocol").get(0);
                if (str5.equals("http") || str5.equals("https")) {
                    this.f21217a.status(0, 0, i, "");
                } else {
                    this.f21217a.status(2, 0, i, "");
                }
            } else if (map.containsKey(":status")) {
                this.f21217a.status(2, 0, i, "");
            } else {
                this.f21217a.status(0, 0, i, "");
            }
            this.f21217a.headers(map);
            return false;
        }

        public void a(String str) {
            this.b = str;
        }

        public void a(IRequest iRequest) {
            this.c = iRequest;
        }
    }

    public a(Context context) {
        this(context, WVUCWebView.WINDVANE);
    }

    public void cancelPrefetchLoad() {
    }

    public void clearUserSslPrefTable() {
    }

    public IRequest formatRequest(EventHandler eventHandler, String str, String str2, boolean z, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, byte[]> map4, long j, int i, int i2) {
        c cVar;
        c cVar2 = new c(eventHandler, d.c(str), str2, z, map, map2, map3, map4, j, i, i2, this.l, this.m);
        if (this.d) {
            cVar = cVar2;
            cVar.f = c.c;
        } else {
            cVar = cVar2;
        }
        a(cVar.b(), cVar);
        eventHandler.setRequest(cVar);
        eventHandler.setResourceType(i);
        return cVar;
    }

    public int getNetworkType() {
        return 1;
    }

    public String getVersion() {
        return "1.0";
    }

    public boolean requestURL(EventHandler eventHandler, String str, String str2, boolean z, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, byte[]> map4, long j, int i, int i2) {
        TaoLog.d(this.f21215a, "requestURL:" + str + " isUCProxyReq:" + z + " requestType:" + i);
        c cVar = new c(eventHandler, d.c(str), str2, z, map, map2, map3, map4, j, i, i2, this.l, this.m);
        if (this.d) {
            cVar.f = c.c;
        }
        a(cVar.b(), cVar);
        eventHandler.setRequest(cVar);
        return a(cVar);
    }

    public boolean sendRequest(IRequest iRequest) {
        return a((c) iRequest);
    }

    public a(Context context, String str) {
        this(context, 2, str);
    }

    public a(Context context, int i) {
        this(context, i, WVUCWebView.WINDVANE);
    }

    public static boolean a(EventHandler eventHandler) {
        int resourceType = eventHandler.getResourceType();
        return resourceType == 0 || resourceType == 14 || eventHandler.isSynchronous();
    }

    public a(Context context, int i, String str) {
        this.f21215a = "AliNetwork";
        this.i = -1;
        this.j = 1;
        this.k = 1024;
        this.l = true;
        this.m = "";
        this.d = false;
        this.e = false;
        this.f = new HashSet<>();
        this.g = context;
        this.i = i;
        this.m = str;
        this.l = p.a();
        int i2 = this.i;
        if (i2 == 0) {
            this.h = new HttpNetwork(context);
        } else if (i2 == 1 || i2 == 2) {
            this.h = new DegradableNetwork(context);
        }
    }

    private boolean a(c cVar) {
        Request requestB = cVar.b();
        EventHandler eventHandler = cVar.getEventHandler();
        if (TaoLog.getLogStatus()) {
            TaoLog.d(this.f21215a, "requestURL eventId=" + cVar.getEventHandler().hashCode() + ", url=" + cVar.getUrl() + ",isSync=" + eventHandler.isSynchronous());
        }
        int i = this.j;
        if (i == 0) {
            Response responseSyncSend = this.h.syncSend(requestB, (Object) null);
            Throwable error = responseSyncSend.getError();
            if (error != null) {
                eventHandler.error(a(error), error.toString());
            } else {
                int statusCode = responseSyncSend.getStatusCode();
                String str = responseSyncSend.getStatisticData().connectionType;
                if (!TextUtils.isEmpty(str) && str.startsWith("http2")) {
                    eventHandler.status(2, 0, statusCode, "");
                } else {
                    eventHandler.status(0, 0, statusCode, "");
                }
                if (TaoLog.getLogStatus()) {
                    TaoLog.d(this.f21215a, "status code=" + statusCode);
                }
                eventHandler.headers(responseSyncSend.getConnHeadFields());
                byte[] bytedata = responseSyncSend.getBytedata();
                if (bytedata != null) {
                    eventHandler.data(bytedata, bytedata.length);
                }
                cVar.f = c.e;
                eventHandler.endData();
            }
        } else if (i == 1) {
            C0009a c0009a = new C0009a();
            c0009a.a(eventHandler);
            c0009a.a(cVar.getUrl());
            c0009a.a(cVar);
            cVar.a(this.h.asyncSend(requestB, (Object) null, (Handler) null, c0009a));
        }
        return true;
    }

    private void a(Request request, c cVar) {
        if (cVar.getUploadFileTotalLen() != 0) {
            Map<String, String> uploadFileMap = cVar.getUploadFileMap();
            Map<String, byte[]> uploadDataMap = cVar.getUploadDataMap();
            request.setBodyHandler(new IBodyHandler(uploadFileMap.size() + uploadDataMap.size(), uploadFileMap, uploadDataMap) { // from class: android.taobao.windvane.extra.a.a.1
                byte[] f;
                List<InputStream> g;
                final /* synthetic */ int i;
                final /* synthetic */ Map j;
                final /* synthetic */ Map k;

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                boolean f21216a = false;
                int b = 0;
                int c = 0;
                String d = null;
                byte[] e = null;
                boolean h = false;

                {
                    this.i = i;
                    this.j = uploadFileMap;
                    this.k = uploadDataMap;
                    this.f = new byte[a.this.k];
                    this.g = new ArrayList(i);
                }

                public void a() {
                    try {
                        this.c = 0;
                        while (true) {
                            int i = this.c;
                            if (i >= this.i) {
                                return;
                            }
                            this.d = (String) this.j.get(String.valueOf(i));
                            this.e = (byte[]) this.k.get(String.valueOf(this.c));
                            if (TaoLog.getLogStatus() && this.e != null) {
                                String str = a.this.f21215a;
                                StringBuilder sb = new StringBuilder();
                                sb.append("len =");
                                sb.append(this.e.length);
                                sb.append(",datavalue=");
                                byte[] bArr = this.e;
                                sb.append(new String(bArr, 0, bArr.length));
                                TaoLog.d(str, sb.toString());
                            }
                            String str2 = this.d;
                            if (str2 == null) {
                                this.g.add(this.c, new ByteArrayInputStream(this.e));
                            } else if (str2.toLowerCase().startsWith("content://")) {
                                this.g.add(this.c, a.this.g.getContentResolver().openInputStream(Uri.parse(this.d)));
                            } else {
                                this.g.add(this.c, new FileInputStream(this.d));
                            }
                            this.c++;
                        }
                    } catch (Exception unused) {
                    }
                }

                public boolean isCompleted() {
                    boolean z = this.f21216a;
                    if (!z) {
                        return z;
                    }
                    this.f21216a = false;
                    this.h = false;
                    try {
                        Iterator<InputStream> it = this.g.iterator();
                        while (it.hasNext()) {
                            it.next().close();
                        }
                        this.g.clear();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return true;
                }

                public int read(byte[] bArr) {
                    if (!this.h) {
                        a();
                        List<InputStream> list = this.g;
                        if (list == null || list.size() == 0) {
                            this.f21216a = true;
                            return 0;
                        }
                        this.h = true;
                    }
                    Iterator<InputStream> it = this.g.iterator();
                    while (it.hasNext()) {
                        try {
                            int i = it.next().read(this.f, 0, a.this.k > bArr.length ? bArr.length : a.this.k);
                            if (i != -1) {
                                System.arraycopy(this.f, 0, bArr, 0, i);
                                this.b += i;
                                TaoLog.i(a.this.f21215a, "read len=" + i);
                                return i;
                            }
                        } catch (Exception e) {
                            TaoLog.i(a.this.f21215a, "read exception" + e.getMessage());
                            this.f21216a = true;
                            return 0;
                        }
                    }
                    TaoLog.i(a.this.f21215a, "read finish");
                    this.f21216a = true;
                    return 0;
                }
            });
        }
    }

    public int a(Throwable th) {
        if (th instanceof ParseException) {
            return -43;
        }
        if (th instanceof SocketTimeoutException) {
            return -46;
        }
        if (th instanceof SocketException) {
            return -47;
        }
        if (th instanceof IOException) {
            return -44;
        }
        if (th instanceof IllegalStateException) {
            return -45;
        }
        return th instanceof UnknownHostException ? -2 : -99;
    }
}
