package com.byazt.utw;

import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 450, 34})
public class a {
    public final ve c;
    public final List<tt> tt;
    public final c ve;

    @com.byazt.zqa.c(c = {0, 1, 450, 464})
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f29110a;
        public final int c;
        public final int n;
        public final String tt;
        public final int uj;
        public final String ve;

        public String toString() {
            return "Extra{flag=" + this.c + ", rawKey='" + this.tt + "', key='" + this.ve + "', from=" + this.uj + ", to=" + this.n + ", urls=" + this.f29110a + '}';
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 450, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH})
    public static final class tt {
        public final String c;
        public final String tt;

        public tt(String str, String str2) {
            this.c = str;
            this.tt = str2;
        }

        public String toString() {
            return "Header{name='" + this.c + "', value='" + this.tt + "'}";
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 450, 471})
    public static final class ve {
        public final String c;
        public final String tt;
        public final String ve;

        public String toString() {
            return "RequestLine{method='" + this.c + "', path='" + this.tt + "', version='" + this.ve + "'}";
        }
    }

    public String toString() {
        return "Request{requestLine=" + this.c + ", headers=" + this.tt + ", extra=" + this.ve + '}';
    }
}
