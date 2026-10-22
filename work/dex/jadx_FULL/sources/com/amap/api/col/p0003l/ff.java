package com.amap.api.col.p0003l;

import com.amap.api.maps.AMapException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ff extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f25938a;
    private String b;
    private String c;
    private String d;
    private String e;
    private int f;
    private int g;
    private volatile boolean h;
    private String i;
    private Map<String, List<String>> j;

    public ff(String str) {
        super(str);
        this.f25938a = AMapException.ERROR_UNKNOWN;
        this.b = "";
        this.c = "";
        this.d = "1900";
        this.e = "UnknownError";
        this.f = -1;
        this.g = -1;
        this.h = false;
        this.f25938a = str;
        if (AMapException.ERROR_IO.equals(str)) {
            this.f = 21;
            this.d = "1902";
            this.e = "IOException";
        } else if (AMapException.ERROR_SOCKET.equals(str)) {
            this.f = 22;
        } else if (AMapException.ERROR_SOCKE_TIME_OUT.equals(str)) {
            this.f = 23;
            this.d = "1802";
            this.e = "SocketTimeoutException";
        } else if (AMapException.ERROR_INVALID_PARAMETER.equals(str)) {
            this.f = 24;
            this.d = "1901";
            this.e = "IllegalArgumentException";
        } else if (AMapException.ERROR_NULL_PARAMETER.equals(str)) {
            this.f = 25;
            this.d = "1903";
            this.e = "NullPointException";
        } else if (AMapException.ERROR_URL.equals(str)) {
            this.f = 26;
            this.d = "1803";
            this.e = "MalformedURLException";
        } else if (AMapException.ERROR_UNKNOW_HOST.equals(str)) {
            this.f = 27;
            this.d = "1804";
            this.e = "UnknownHostException";
        } else if (AMapException.ERROR_UNKNOW_SERVICE.equals(str)) {
            this.f = 28;
            this.d = "1805";
            this.e = "CannotConnectToHostException";
        } else if (AMapException.ERROR_PROTOCOL.equals(str)) {
            this.f = 29;
            this.d = "1801";
            this.e = "ProtocolException";
        } else if (AMapException.ERROR_CONNECTION.equals(str)) {
            this.f = 30;
            this.d = "1806";
            this.e = "ConnectionException";
        } else if ("服务QPS超限".equalsIgnoreCase(str)) {
            this.f = 30;
            this.d = "2001";
            this.e = "ConnectionException";
        } else if (AMapException.ERROR_UNKNOWN.equals(str)) {
            this.f = 31;
        } else if (AMapException.ERROR_FAILURE_AUTH.equals(str)) {
            this.f = 32;
        } else if ("requeust is null".equals(str)) {
            this.f = 1;
        } else if ("request url is empty".equals(str)) {
            this.f = 2;
        } else if ("response is null".equals(str)) {
            this.f = 3;
        } else if ("thread pool has exception".equals(str)) {
            this.f = 4;
        } else if ("sdk name is invalid".equals(str)) {
            this.f = 5;
        } else if ("sdk info is null".equals(str)) {
            this.f = 6;
        } else if ("sdk packages is null".equals(str)) {
            this.f = 7;
        } else if ("线程池为空".equals(str)) {
            this.f = 8;
        } else if ("获取对象错误".equals(str)) {
            this.f = 101;
        } else if ("DNS解析失败".equals(str)) {
            this.f = 3;
        } else {
            this.f = -1;
        }
        if (AMapException.ERROR_IO.equals(str)) {
            this.g = 7;
            return;
        }
        if (AMapException.ERROR_SOCKET.equals(str)) {
            this.g = 6;
            return;
        }
        if (AMapException.ERROR_SOCKE_TIME_OUT.equals(str)) {
            this.g = 2;
            return;
        }
        if (!AMapException.ERROR_UNKNOW_HOST.equals(str)) {
            if (AMapException.ERROR_CONNECTION.equals(str)) {
                this.g = 6;
                return;
            } else if (!AMapException.ERROR_UNKNOWN.equals(str) && "DNS解析失败".equals(str)) {
                this.g = 3;
                return;
            }
        }
        this.g = 9;
    }

    public final String a() {
        return this.f25938a;
    }

    public final String b() {
        return this.d;
    }

    public final String c() {
        return this.e;
    }

    public final String d() {
        return this.b;
    }

    public final String e() {
        return this.c;
    }

    public final int f() {
        return this.f;
    }

    public final int g() {
        return this.g;
    }

    public final int h() {
        this.g = 10;
        return 10;
    }

    public final boolean i() {
        return this.h;
    }

    public final void j() {
        this.h = true;
    }

    public final void a(int i) {
        this.f = i;
    }

    public final void a(String str) {
        this.i = str;
    }

    public final void a(Map<String, List<String>> map) {
        this.j = map;
    }

    public ff(String str, String str2, String str3) {
        this(str);
        this.b = str2;
        this.c = str3;
    }
}
