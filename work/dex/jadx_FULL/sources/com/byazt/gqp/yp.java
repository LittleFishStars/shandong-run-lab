package com.byazt.gqp;

import com.huachenjie.base.interact.bean.WorksInteractEventBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 323, 215})
public abstract class yp {
    public t c;

    @com.byazt.zqa.c(c = {0, 1, 323, WorksInteractEventBean.EVENT_TYPE_COMMENT_ALUMNI_SAY_NOTIFY_UNLIKE})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public z f28587a;
        public com.byazt.gqp.c c;
        public Object n;
        public a.c sp;
        public Map<String, List<String>> tt;
        public String uj;
        public sp ve;

        public c() {
            this.tt = new HashMap();
            this.sp = new a.c();
        }

        public c c(com.byazt.gqp.c cVar) {
            this.c = cVar;
            return this;
        }

        public c tt(String str, String str2) {
            if (!this.tt.containsKey(str)) {
                this.tt.put(str, new ArrayList());
            }
            this.tt.get(str).add(str2);
            return this;
        }

        public c c(Object obj) {
            this.n = obj;
            return this;
        }

        public c c(String str) {
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    str = "http:" + str.substring(3);
                } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str = "https:" + str.substring(4);
                }
                sp spVarVe = sp.ve(str);
                if (spVarVe != null) {
                    return c(spVarVe);
                }
                throw new IllegalArgumentException("unexpected url: ".concat(String.valueOf(str)));
            }
            throw new NullPointerException("url == null");
        }

        public c(yp ypVar) {
            this.ve = ypVar.tt();
            this.uj = ypVar.ve();
            this.tt = ypVar.uj();
            this.n = ypVar.c();
            this.f28587a = ypVar.a();
            this.c = ypVar.n();
        }

        public yp tt() {
            return new yp() { // from class: com.byazt.gqp.yp.c.1
                @Override // com.byazt.gqp.yp
                public z a() {
                    return c.this.f28587a;
                }

                @Override // com.byazt.gqp.yp
                public Object c() {
                    return c.this.n;
                }

                @Override // com.byazt.gqp.yp
                public com.byazt.gqp.c n() {
                    return c.this.c;
                }

                public String toString() {
                    return "";
                }

                @Override // com.byazt.gqp.yp
                public sp tt() {
                    return c.this.ve;
                }

                @Override // com.byazt.gqp.yp
                public Map uj() {
                    return c.this.tt;
                }

                @Override // com.byazt.gqp.yp
                public String ve() {
                    return c.this.uj;
                }
            };
        }

        public c c(sp spVar) {
            this.ve = spVar;
            return this;
        }

        public c c(String str, String str2) {
            return tt(str, str2);
        }

        public c c(a aVar) {
            if (aVar != null) {
                this.tt = aVar.tt();
            }
            return this;
        }

        public c c() {
            return c("GET", (z) null);
        }

        public c c(String str, z zVar) {
            this.uj = str;
            this.f28587a = zVar;
            return this;
        }

        public c c(z zVar) {
            return c("POST", zVar);
        }
    }

    public z a() {
        return null;
    }

    public abstract Object c();

    public void c(t tVar) {
        this.c = tVar;
    }

    public abstract com.byazt.gqp.c n();

    public c sp() {
        return new c(this);
    }

    public abstract sp tt();

    public abstract Map<String, List<String>> uj();

    public abstract String ve();
}
