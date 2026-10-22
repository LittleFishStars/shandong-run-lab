package com.amap.api.col.p0003l;

import android.content.Context;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.zj.adlib.j4b;
import com.zj.adlib.l4b;
import com.zj.adlib.r4b;
import com.zj.adlib.s4b;
import com.zj.adlib.v6b;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class hm extends fm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f25968a;
    protected r4b b;
    protected byte[] g;

    public hm(Context context, r4b r4bVar) {
        if (context != null) {
            this.f25968a = context.getApplicationContext();
        }
        this.b = r4bVar;
        setBinary(true);
    }

    public static byte[] a(byte[] bArr) {
        return s4b.o(bArr.length);
    }

    private static byte[] i() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(s4b.p("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                v6b.b(th, "bre", "gbh");
            }
            return byteArray;
        } catch (Throwable th2) {
            try {
                v6b.b(th2, "bre", "gbh");
                try {
                    return null;
                } catch (Throwable th3) {
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    v6b.b(th4, "bre", "gbh");
                }
            }
        }
    }

    private byte[] j() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            if (f()) {
                Context context = this.f25968a;
                boolean zH = h();
                r4b r4bVar = this.b;
                byte[] bArrF = l4b.f(context, zH, r4bVar != null && "navi".equals(r4bVar.a()));
                byteArrayOutputStream.write(a(bArrF));
                byteArrayOutputStream.write(bArrF);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] bArrP = s4b.p(e());
            if (bArrP == null || bArrP.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(a(bArrP));
                byteArrayOutputStream.write(bArrP);
            }
            byte[] bArrP2 = s4b.p(g());
            if (bArrP2 == null || bArrP2.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(a(bArrP2));
                byteArrayOutputStream.write(bArrP2);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                v6b.b(th, "bre", "gred");
            }
            return byteArray;
        } catch (Throwable th2) {
            try {
                v6b.b(th2, "bre", "gpd");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    v6b.b(th3, "bre", "gred");
                }
                return new byte[]{0};
            } catch (Throwable th4) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th5) {
                    v6b.b(th5, "bre", "gred");
                }
                throw th4;
            }
        }
    }

    private byte[] k() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArrC = c();
            if (bArrC != null && bArrC.length != 0) {
                byteArrayOutputStream.write(new byte[]{1});
                byteArrayOutputStream.write(a(bArrC));
                byteArrayOutputStream.write(bArrC);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th) {
                    v6b.b(th, "bre", "grrd");
                }
                return byteArray;
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                v6b.b(th2, "bre", "grrd");
            }
            return byteArray2;
        } catch (Throwable th3) {
            try {
                v6b.b(th3, "bre", "grrd");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    v6b.b(th4, "bre", "grrd");
                }
                return new byte[]{0};
            } catch (Throwable th5) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th6) {
                    v6b.b(th6, "bre", "grrd");
                }
                throw th5;
            }
        }
    }

    private byte[] l() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArrD = d();
            if (bArrD != null && bArrD.length != 0) {
                byteArrayOutputStream.write(new byte[]{1});
                byte[] bArrG = l4b.g(bArrD);
                byteArrayOutputStream.write(a(bArrG));
                byteArrayOutputStream.write(bArrG);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th) {
                    v6b.b(th, "bre", "gred");
                }
                return byteArray;
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                v6b.b(th2, "bre", "gred");
            }
            return byteArray2;
        } catch (Throwable th3) {
            try {
                v6b.b(th3, "bre", "gred");
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    v6b.b(th4, "bre", "gred");
                }
                return new byte[]{0};
            } catch (Throwable th5) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th6) {
                    v6b.b(th6, "bre", "gred");
                }
                throw th5;
            }
        }
    }

    public abstract byte[] c();

    public abstract byte[] d();

    public String e() {
        return "2.1";
    }

    public boolean f() {
        return true;
    }

    public String g() {
        return String.format("platform=Android&sdkversion=%s&product=%s", this.b.f(), this.b.a());
    }

    @Override // com.amap.api.col.p0003l.hs
    public final byte[] getEntityBytes() {
        byte[] bArr = this.g;
        if (bArr != null) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(i());
            byteArrayOutputStream.write(j());
            byteArrayOutputStream.write(k());
            byteArrayOutputStream.write(l());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.g = byteArray;
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                v6b.b(th, "bre", "geb");
            }
            return byteArray;
        } catch (Throwable th2) {
            try {
                v6b.b(th2, "bre", "geb");
                try {
                    return null;
                } catch (Throwable th3) {
                    return null;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    v6b.b(th4, "bre", "geb");
                }
            }
        }
    }

    @Override // com.amap.api.col.p0003l.hs
    public Map<String, String> getParams() {
        String strJ = j4b.j(this.f25968a);
        String strA = l4b.a();
        String strC = l4b.c(this.f25968a, strA, "key=".concat(String.valueOf(strJ)));
        HashMap map = new HashMap();
        map.put("ts", strA);
        map.put(CachedContentIndex.a.e, strJ);
        map.put("scode", strC);
        return map;
    }

    public boolean h() {
        return false;
    }
}
