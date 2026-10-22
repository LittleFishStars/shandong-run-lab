package com.byazt.eg;

import com.baidu.mapapi.http.wrapper.HttpManager;
import com.huachenjie.common.constants.ErrorCode;
import java.net.URL;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 16, 499})
public final class yv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public md f28464a;
    public final my c;
    public final Object n;
    public volatile uj sp;
    public final String tt;
    public final p uj;
    public final rh ve;

    @com.byazt.zqa.c(c = {0, 1, 16, ErrorCode.CHECK_START_RUN_ERROR.f})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public md f28465a;
        public my c;
        public Object n;
        public String tt;
        public p uj;
        public rh.c ve;

        public c() {
            this.tt = "GET";
            this.ve = new rh.c();
        }

        public c c(my myVar) {
            if (myVar == null) {
                throw new NullPointerException("url == null");
            }
            this.c = myVar;
            return this;
        }

        public c delete(p pVar) {
            return c(HttpManager.HTTP_DELETE, pVar);
        }

        public c tt(String str, String str2) {
            this.ve.c(str, str2);
            return this;
        }

        public c delete() {
            return delete(com.byazt.kh.ve.uj);
        }

        public c tt(String str) {
            this.ve.tt(str);
            return this;
        }

        public c c(String str) {
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    str = "http:" + str.substring(3);
                } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str = "https:" + str.substring(4);
                }
                my myVarN = my.n(str);
                if (myVarN != null) {
                    return c(myVarN);
                }
                throw new IllegalArgumentException("unexpected url: ".concat(String.valueOf(str)));
            }
            throw new NullPointerException("url == null");
        }

        public c(yv yvVar) {
            this.c = yvVar.c;
            this.tt = yvVar.tt;
            this.uj = yvVar.uj;
            this.n = yvVar.n;
            this.ve = yvVar.ve.tt();
            this.f28465a = yvVar.f28464a;
        }

        public c c(URL url) {
            if (url != null) {
                my myVarC = my.c(url);
                if (myVarC != null) {
                    return c(myVarC);
                }
                throw new IllegalArgumentException("unexpected url: ".concat(String.valueOf(url)));
            }
            throw new NullPointerException("url == null");
        }

        public c c(String str, String str2) {
            this.ve.ve(str, str2);
            return this;
        }

        public c c(rh rhVar) {
            this.ve = rhVar.tt();
            return this;
        }

        public c c(uj ujVar) {
            String string = ujVar.toString();
            return string.isEmpty() ? tt("Cache-Control") : c("Cache-Control", string);
        }

        public c c(String str, p pVar) {
            if (str != null) {
                if (str.length() != 0) {
                    if (pVar != null && !com.byazt.yx.a.ve(str)) {
                        throw new IllegalArgumentException("method " + str + " must not have a request body.");
                    }
                    if (pVar == null && com.byazt.yx.a.tt(str)) {
                        throw new IllegalArgumentException("method " + str + " must have a request body.");
                    }
                    this.tt = str;
                    this.uj = pVar;
                    return this;
                }
                throw new IllegalArgumentException("method.length() == 0");
            }
            throw new NullPointerException("method == null");
        }

        public c c(Object obj) {
            this.n = obj;
            return this;
        }

        public yv c() {
            if (this.c != null) {
                return new yv(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    public yv(c cVar) {
        this.c = cVar.c;
        this.tt = cVar.tt;
        this.ve = cVar.ve.c();
        this.uj = cVar.uj;
        Object obj = cVar.n;
        this.n = obj == null ? this : obj;
        md mdVar = cVar.f28465a;
        if (mdVar != null) {
            this.f28464a = mdVar;
        } else {
            this.f28464a = new md();
        }
    }

    public c a() {
        return new c(this);
    }

    public my c() {
        return this.c;
    }

    public Object n() {
        return this.n;
    }

    public uj sp() {
        uj ujVar = this.sp;
        if (ujVar != null) {
            return ujVar;
        }
        uj ujVarC = uj.c(this.ve);
        this.sp = ujVarC;
        return ujVarC;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Request{method=");
        sb.append(this.tt);
        sb.append(", url=");
        sb.append(this.c);
        sb.append(", tag=");
        Object obj = this.n;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }

    public String tt() {
        return this.tt;
    }

    public p uj() {
        return this.uj;
    }

    public rh ve() {
        return this.ve;
    }

    public boolean x() {
        return this.c.uj();
    }

    public String c(String str) {
        return this.ve.c(str);
    }
}
