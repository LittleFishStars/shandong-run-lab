package com.byazt.jb;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.alibaba.triver.kit.api.model.SubscribeResouceItemModel;
import com.alipay.sdk.m.c0.d;
import com.alipay.sdk.m.t.e;
import com.byazt.mk.my;
import com.kc.aw.lib.constants.AdConstant;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 63, 15})
public final class uj {
    public static final ve[] c;
    public static final Map<com.byazt.mk.a, Integer> tt;

    @com.byazt.zqa.c(c = {0, 1, 63, 123})
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.byazt.mk.n f28693a;
        public ve[] c;
        public final List<ve> n;
        public final int sp;
        public int tt;
        public int uj;
        public int ve;
        public int x;

        public c(int i, my myVar) {
            this(i, i, myVar);
        }

        private void a() throws IOException {
            this.n.add(new ve(uj.c(ve()), ve()));
        }

        private int c(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.c.length;
                while (true) {
                    length--;
                    i2 = this.tt;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    int i4 = this.c[length].i;
                    i -= i4;
                    this.uj -= i4;
                    this.ve--;
                    i3++;
                }
                ve[] veVarArr = this.c;
                System.arraycopy(veVarArr, i2 + 1, veVarArr, i2 + 1 + i3, this.ve);
                this.tt += i3;
            }
            return i3;
        }

        private void n() {
            Arrays.fill(this.c, (Object) null);
            this.tt = this.c.length - 1;
            this.ve = 0;
            this.uj = 0;
        }

        private void sp() throws IOException {
            c(-1, new ve(uj.c(ve()), ve()));
        }

        private void uj() {
            int i = this.x;
            int i2 = this.uj;
            if (i < i2) {
                if (i == 0) {
                    n();
                } else {
                    c(i2 - i);
                }
            }
        }

        private int ve(int i) {
            return this.tt + 1 + i;
        }

        private int x() throws IOException {
            return this.f28693a.x() & 255;
        }

        public List<ve> tt() {
            ArrayList arrayList = new ArrayList(this.n);
            this.n.clear();
            return arrayList;
        }

        public c(int i, int i2, my myVar) {
            this.n = new ArrayList();
            ve[] veVarArr = new ve[8];
            this.c = veVarArr;
            this.tt = veVarArr.length - 1;
            this.ve = 0;
            this.uj = 0;
            this.sp = i;
            this.x = i2;
            this.f28693a = com.byazt.mk.t.c(myVar);
        }

        public com.byazt.mk.a ve() throws IOException {
            int iX = x();
            boolean z = (iX & 128) == 128;
            int iC = c(iX, 127);
            return z ? com.byazt.mk.a.c(sl.c().c(this.f28693a.sp(iC))) : this.f28693a.ve(iC);
        }

        private void tt(int i) throws IOException {
            if (sp(i)) {
                this.n.add(uj.c[i]);
                return;
            }
            int iVe = ve(i - uj.c.length);
            if (iVe >= 0) {
                ve[] veVarArr = this.c;
                if (iVe <= veVarArr.length - 1) {
                    this.n.add(veVarArr[iVe]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private com.byazt.mk.a a(int i) {
            if (sp(i)) {
                return uj.c[i].sp;
            }
            return this.c[ve(i - uj.c.length)].sp;
        }

        private boolean sp(int i) {
            return i >= 0 && i <= uj.c.length - 1;
        }

        private void uj(int i) throws IOException {
            this.n.add(new ve(a(i), ve()));
        }

        private void n(int i) throws IOException {
            c(-1, new ve(a(i), ve()));
        }

        public void c() throws IOException {
            while (!this.f28693a.n()) {
                int iX = this.f28693a.x() & 255;
                if (iX == 128) {
                    throw new IOException("index == 0");
                }
                if ((iX & 128) == 128) {
                    tt(c(iX, 127) - 1);
                } else if (iX == 64) {
                    sp();
                } else if ((iX & 64) == 64) {
                    n(c(iX, 63) - 1);
                } else if ((iX & 32) == 32) {
                    int iC = c(iX, 31);
                    this.x = iC;
                    if (iC >= 0 && iC <= this.sp) {
                        uj();
                    } else {
                        throw new IOException("Invalid dynamic table size update " + this.x);
                    }
                } else if (iX != 16 && iX != 0) {
                    uj(c(iX, 15) - 1);
                } else {
                    a();
                }
            }
        }

        private void c(int i, ve veVar) {
            this.n.add(veVar);
            int i2 = veVar.i;
            if (i != -1) {
                i2 -= this.c[ve(i)].i;
            }
            int i3 = this.x;
            if (i2 > i3) {
                n();
                return;
            }
            int iC = c((this.uj + i2) - i3);
            if (i == -1) {
                int i4 = this.ve + 1;
                ve[] veVarArr = this.c;
                if (i4 > veVarArr.length) {
                    ve[] veVarArr2 = new ve[veVarArr.length * 2];
                    System.arraycopy(veVarArr, 0, veVarArr2, veVarArr.length, veVarArr.length);
                    this.tt = this.c.length - 1;
                    this.c = veVarArr2;
                }
                int i5 = this.tt;
                this.tt = i5 - 1;
                this.c[i5] = veVar;
                this.ve++;
            } else {
                this.c[i + ve(i) + iC] = veVar;
            }
            this.uj += i2;
        }

        public int c(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int iX = x();
                if ((iX & 128) == 0) {
                    return i2 + (iX << i4);
                }
                i2 += (iX & 127) << i4;
                i4 += 7;
            }
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 63, 153})
    public static final class tt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f28694a;
        public int c;
        public boolean da;
        public int i;
        public int n;
        public final com.byazt.mk.ve sp;
        public int tt;
        public int uj;
        public ve[] ve;
        public final boolean x;

        public tt(com.byazt.mk.ve veVar) {
            this(4096, true, veVar);
        }

        private void c() {
            Arrays.fill(this.ve, (Object) null);
            this.uj = this.ve.length - 1;
            this.n = 0;
            this.f28694a = 0;
        }

        private int tt(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.ve.length;
                while (true) {
                    length--;
                    i2 = this.uj;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    int i4 = this.ve[length].i;
                    i -= i4;
                    this.f28694a -= i4;
                    this.n--;
                    i3++;
                }
                ve[] veVarArr = this.ve;
                System.arraycopy(veVarArr, i2 + 1, veVarArr, i2 + 1 + i3, this.n);
                ve[] veVarArr2 = this.ve;
                int i5 = this.uj;
                Arrays.fill(veVarArr2, i5 + 1, i5 + 1 + i3, (Object) null);
                this.uj += i3;
            }
            return i3;
        }

        public tt(int i, boolean z, com.byazt.mk.ve veVar) {
            this.i = Integer.MAX_VALUE;
            ve[] veVarArr = new ve[8];
            this.ve = veVarArr;
            this.uj = veVarArr.length - 1;
            this.n = 0;
            this.f28694a = 0;
            this.c = i;
            this.tt = i;
            this.x = z;
            this.sp = veVar;
        }

        private void c(ve veVar) {
            int i = veVar.i;
            int i2 = this.tt;
            if (i > i2) {
                c();
                return;
            }
            tt((this.f28694a + i) - i2);
            int i3 = this.n + 1;
            ve[] veVarArr = this.ve;
            if (i3 > veVarArr.length) {
                ve[] veVarArr2 = new ve[veVarArr.length * 2];
                System.arraycopy(veVarArr, 0, veVarArr2, veVarArr.length, veVarArr.length);
                this.uj = this.ve.length - 1;
                this.ve = veVarArr2;
            }
            int i4 = this.uj;
            this.uj = i4 - 1;
            this.ve[i4] = veVar;
            this.n++;
            this.f28694a += i;
        }

        private void tt() {
            int i = this.tt;
            int i2 = this.f28694a;
            if (i < i2) {
                if (i == 0) {
                    c();
                } else {
                    tt(i2 - i);
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0069  */
        /* JADX WARN: Code duplicated, block: B:26:0x0070  */
        /* JADX WARN: Code duplicated, block: B:28:0x0078  */
        /* JADX WARN: Code duplicated, block: B:30:0x0084  */
        /* JADX WARN: Code duplicated, block: B:33:0x0098 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:34:0x009a  */
        /* JADX WARN: Code duplicated, block: B:37:0x00a7  */
        /* JADX WARN: Code duplicated, block: B:38:0x00af  */
        /* JADX WARN: Code duplicated, block: B:40:0x00b3  */
        /* JADX WARN: Code duplicated, block: B:41:0x00c2  */
        /* JADX WARN: Code duplicated, block: B:46:0x00db  */
        /* JADX WARN: Code duplicated, block: B:55:0x0090 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:57:0x00a2 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:58:0x00a2 A[SYNTHETIC] */
        public void c(List<ve> list) throws IOException {
            int length;
            int length2;
            int i;
            int length3;
            if (this.da) {
                int i2 = this.i;
                if (i2 < this.tt) {
                    c(i2, 31, 32);
                }
                this.da = false;
                this.i = Integer.MAX_VALUE;
                c(this.tt, 31, 32);
            }
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                ve veVar = list.get(i3);
                com.byazt.mk.a aVarA = veVar.sp.a();
                com.byazt.mk.a aVar = veVar.x;
                Integer num = uj.tt.get(aVarA);
                if (num != null) {
                    length = num.intValue() + 1;
                    if (length <= 1 || length >= 8) {
                        length2 = length;
                        length = -1;
                    } else {
                        ve[] veVarArr = uj.c;
                        if (!com.byazt.kh.ve.c(veVarArr[length - 1].x, aVar)) {
                            if (com.byazt.kh.ve.c(veVarArr[length].x, aVar)) {
                                length2 = length;
                                length++;
                            } else {
                                length2 = length;
                                length = -1;
                            }
                        }
                    }
                    if (length == -1) {
                        length3 = this.ve.length;
                        for (i = this.uj + 1; i < length3; i++) {
                            if (!com.byazt.kh.ve.c(this.ve[i].sp, aVarA)) {
                                if (com.byazt.kh.ve.c(this.ve[i].x, aVar)) {
                                    length = uj.c.length + (i - this.uj);
                                    break;
                                } else if (length2 == -1) {
                                    length2 = (i - this.uj) + uj.c.length;
                                }
                            }
                        }
                    }
                    if (length != -1) {
                        c(length, 127, 128);
                    } else if (length2 == -1) {
                        this.sp.i(64);
                        c(aVarA);
                        c(aVar);
                        c(veVar);
                    } else if (!aVarA.c(ve.c) && !ve.f28695a.equals(aVarA)) {
                        c(length2, 15, 0);
                        c(aVar);
                    } else {
                        c(length2, 63, 64);
                        c(aVar);
                        c(veVar);
                    }
                } else {
                    length = -1;
                }
                length2 = length;
                if (length == -1) {
                    length3 = this.ve.length;
                    while (i < length3) {
                        if (!com.byazt.kh.ve.c(this.ve[i].sp, aVarA)) {
                            if (com.byazt.kh.ve.c(this.ve[i].x, aVar)) {
                                length = uj.c.length + (i - this.uj);
                                break;
                            } else if (length2 == -1) {
                                length2 = (i - this.uj) + uj.c.length;
                            }
                        }
                    }
                }
                if (length != -1) {
                    c(length, 127, 128);
                } else if (length2 == -1) {
                    this.sp.i(64);
                    c(aVarA);
                    c(aVar);
                    c(veVar);
                } else if (!aVarA.c(ve.c)) {
                    c(length2, 63, 64);
                    c(aVar);
                    c(veVar);
                } else {
                    c(length2, 63, 64);
                    c(aVar);
                    c(veVar);
                }
            }
        }

        public void c(int i, int i2, int i3) {
            if (i < i2) {
                this.sp.i(i | i3);
                return;
            }
            this.sp.i(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.sp.i(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.sp.i(i4);
        }

        public void c(com.byazt.mk.a aVar) throws IOException {
            if (this.x && sl.c().c(aVar) < aVar.sp()) {
                com.byazt.mk.ve veVar = new com.byazt.mk.ve();
                sl.c().c(aVar, veVar);
                com.byazt.mk.a aVarYp = veVar.yp();
                c(aVarYp.sp(), 127, 128);
                this.sp.tt(aVarYp);
                return;
            }
            c(aVar.sp(), 127, 0);
            this.sp.tt(aVar);
        }

        public void c(int i) {
            this.c = i;
            int iMin = Math.min(i, 16384);
            int i2 = this.tt;
            if (i2 == iMin) {
                return;
            }
            if (iMin < i2) {
                this.i = Math.min(this.i, iMin);
            }
            this.da = true;
            this.tt = iMin;
            tt();
        }
    }

    static {
        com.byazt.mk.a aVar = ve.ve;
        com.byazt.mk.a aVar2 = ve.uj;
        com.byazt.mk.a aVar3 = ve.n;
        com.byazt.mk.a aVar4 = ve.tt;
        c = new ve[]{new ve(ve.f28695a, ""), new ve(aVar, "GET"), new ve(aVar, "POST"), new ve(aVar2, WVNativeCallbackUtil.SEPERATER), new ve(aVar2, "/index.html"), new ve(aVar3, "http"), new ve(aVar3, "https"), new ve(aVar4, "200"), new ve(aVar4, "204"), new ve(aVar4, "206"), new ve(aVar4, AdConstant.NATIVE_TYPE.LEFT_IMAGE), new ve(aVar4, "400"), new ve(aVar4, "404"), new ve(aVar4, "500"), new ve("accept-charset", ""), new ve("accept-encoding", "gzip, deflate"), new ve("accept-language", ""), new ve("accept-ranges", ""), new ve(SubscribeResouceItemModel.ACCEPT, ""), new ve("access-control-allow-origin", ""), new ve("age", ""), new ve("allow", ""), new ve("authorization", ""), new ve("cache-control", ""), new ve("content-disposition", ""), new ve("content-encoding", ""), new ve("content-language", ""), new ve("content-length", ""), new ve("content-location", ""), new ve("content-range", ""), new ve(e.f, ""), new ve("cookie", ""), new ve("date", ""), new ve("etag", ""), new ve("expect", ""), new ve("expires", ""), new ve("from", ""), new ve(com.alipay.sdk.m.n.c.f, ""), new ve("if-match", ""), new ve("if-modified-since", ""), new ve("if-none-match", ""), new ve("if-range", ""), new ve("if-unmodified-since", ""), new ve("last-modified", ""), new ve("link", ""), new ve(RequestParameters.SUBRESOURCE_LOCATION, ""), new ve("max-forwards", ""), new ve("proxy-authenticate", ""), new ve("proxy-authorization", ""), new ve(com.google.android.exoplayer2.source.rtsp.i.m, ""), new ve(RequestParameters.SUBRESOURCE_REFERER, ""), new ve(d.x, ""), new ve("retry-after", ""), new ve("server", ""), new ve("set-cookie", ""), new ve("strict-transport-security", ""), new ve("transfer-encoding", ""), new ve("user-agent", ""), new ve("vary", ""), new ve("via", ""), new ve("www-authenticate", "")};
        tt = c();
    }

    private static Map<com.byazt.mk.a, Integer> c() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(c.length);
        int i = 0;
        while (true) {
            ve[] veVarArr = c;
            if (i >= veVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(veVarArr[i].sp)) {
                linkedHashMap.put(veVarArr[i].sp, Integer.valueOf(i));
            }
            i++;
        }
    }

    public static com.byazt.mk.a c(com.byazt.mk.a aVar) throws IOException {
        int iSp = aVar.sp();
        for (int i = 0; i < iSp; i++) {
            byte bC = aVar.c(i);
            if (bC >= 65 && bC <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + aVar.c());
            }
        }
        return aVar;
    }
}
