package com.zj.adlib;

import android.content.Context;
import android.database.Cursor;
import android.net.Proxy;
import android.net.Uri;
import android.text.TextUtils;
import com.amap.api.col.p0003l.fj;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class q4b {
    public static String a() {
        String defaultHost;
        try {
            defaultHost = Proxy.getDefaultHost();
        } catch (Throwable th) {
            a7b.m(th, "pu", "gdh");
            defaultHost = null;
        }
        return defaultHost == null ? "null" : defaultHost;
    }

    public static String b(String str) {
        return s4b.v(str);
    }

    public static java.net.Proxy c(Context context) {
        try {
            return d(context, new URI("http://restsdk.amap.com"));
        } catch (Throwable th) {
            a7b.m(th, "pu", "gp");
            return null;
        }
    }

    public static java.net.Proxy d(Context context, URI uri) {
        java.net.Proxy proxy;
        if (g(context)) {
            try {
                List<java.net.Proxy> listSelect = ProxySelector.getDefault().select(uri);
                if (listSelect == null || listSelect.isEmpty() || (proxy = listSelect.get(0)) == null || proxy.type() == java.net.Proxy.Type.DIRECT) {
                    return null;
                }
                return proxy;
            } catch (Throwable th) {
                a7b.m(th, "pu", "gpsc");
            }
        }
        return null;
    }

    public static int e() {
        try {
            return Proxy.getDefaultPort();
        } catch (Throwable th) {
            a7b.m(th, "pu", "gdp");
            return -1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:109:0x0158 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:114:0x0161 A[Catch: all -> 0x015d, TRY_LEAVE, TryCatch #11 {all -> 0x015d, blocks: (B:107:0x0152, B:114:0x0161), top: B:133:0x0152 }] */
    /* JADX WARN: Code duplicated, block: B:128:0x0146 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:131:0x00d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:133:0x0152 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0078 A[PHI: r11
      0x0078: PHI (r11v29 java.lang.String) = (r11v24 java.lang.String), (r11v33 java.lang.String) binds: [B:49:0x00af, B:29:0x0076] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:31:0x007b A[PHI: r10 r11
      0x007b: PHI (r10v11 int) = (r10v10 int), (r10v13 int) binds: [B:49:0x00af, B:29:0x0076] A[DONT_GENERATE, DONT_INLINE]
      0x007b: PHI (r11v28 java.lang.String) = (r11v24 java.lang.String), (r11v33 java.lang.String) binds: [B:49:0x00af, B:29:0x0076] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:55:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:76:0x00f3 A[Catch: all -> 0x0176, TryCatch #9 {all -> 0x0176, blocks: (B:65:0x00ce, B:74:0x00e8, B:76:0x00f3, B:78:0x0107, B:80:0x010d, B:85:0x011b, B:88:0x0122, B:90:0x0128, B:92:0x012e, B:97:0x013c), top: B:130:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0107 A[Catch: all -> 0x0176, TryCatch #9 {all -> 0x0176, blocks: (B:65:0x00ce, B:74:0x00e8, B:76:0x00f3, B:78:0x0107, B:80:0x010d, B:85:0x011b, B:88:0x0122, B:90:0x0128, B:92:0x012e, B:97:0x013c), top: B:130:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x010d A[Catch: all -> 0x0176, TryCatch #9 {all -> 0x0176, blocks: (B:65:0x00ce, B:74:0x00e8, B:76:0x00f3, B:78:0x0107, B:80:0x010d, B:85:0x011b, B:88:0x0122, B:90:0x0128, B:92:0x012e, B:97:0x013c), top: B:130:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x0117  */
    /* JADX WARN: Code duplicated, block: B:85:0x011b A[Catch: all -> 0x0176, TryCatch #9 {all -> 0x0176, blocks: (B:65:0x00ce, B:74:0x00e8, B:76:0x00f3, B:78:0x0107, B:80:0x010d, B:85:0x011b, B:88:0x0122, B:90:0x0128, B:92:0x012e, B:97:0x013c), top: B:130:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x0121  */
    /* JADX WARN: Code duplicated, block: B:88:0x0122 A[Catch: all -> 0x0176, TryCatch #9 {all -> 0x0176, blocks: (B:65:0x00ce, B:74:0x00e8, B:76:0x00f3, B:78:0x0107, B:80:0x010d, B:85:0x011b, B:88:0x0122, B:90:0x0128, B:92:0x012e, B:97:0x013c), top: B:130:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x0128 A[Catch: all -> 0x0176, TryCatch #9 {all -> 0x0176, blocks: (B:65:0x00ce, B:74:0x00e8, B:76:0x00f3, B:78:0x0107, B:80:0x010d, B:85:0x011b, B:88:0x0122, B:90:0x0128, B:92:0x012e, B:97:0x013c), top: B:130:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x012e A[Catch: all -> 0x0176, TryCatch #9 {all -> 0x0176, blocks: (B:65:0x00ce, B:74:0x00e8, B:76:0x00f3, B:78:0x0107, B:80:0x010d, B:85:0x011b, B:88:0x0122, B:90:0x0128, B:92:0x012e, B:97:0x013c), top: B:130:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0138  */
    /* JADX WARN: Code duplicated, block: B:97:0x013c A[Catch: all -> 0x0176, TRY_LEAVE, TryCatch #9 {all -> 0x0176, blocks: (B:65:0x00ce, B:74:0x00e8, B:76:0x00f3, B:78:0x0107, B:80:0x010d, B:85:0x011b, B:88:0x0122, B:90:0x0128, B:92:0x012e, B:97:0x013c), top: B:130:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x0143  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v8, types: [int] */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4, types: [int] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.content.ContentResolver, android.database.Cursor] */
    public static java.net.Proxy f(Context context) {
        Cursor cursorQuery;
        ?? r10;
        String strA0;
        ?? E;
        ?? r11;
        String lowerCase;
        String strA;
        boolean z;
        boolean z2;
        String lowerCase2;
        int iE;
        boolean z3;
        int i;
        boolean z4;
        if (g(context)) {
            Uri uri = Uri.parse("content://telephony/carriers/preferapn");
            ?? contentResolver = context.getContentResolver();
            String strB = null;
            boolean z5 = false;
            try {
                try {
                    cursorQuery = contentResolver.query(uri, null, null, null, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.moveToFirst()) {
                                String string = cursorQuery.getString(cursorQuery.getColumnIndex("apn"));
                                if (string != null) {
                                    lowerCase2 = string;
                                    r10 = uri;
                                    Locale locale = Locale.US;
                                    lowerCase2 = string.toLowerCase(locale);
                                    r10 = locale;
                                }
                                try {
                                    try {
                                        lowerCase2 = string;
                                        r10 = uri;
                                        if (lowerCase2 != null && lowerCase2.contains("ctwap")) {
                                            String strA2 = a();
                                            iE = e();
                                            if (TextUtils.isEmpty(strA2) || strA2.equals("null")) {
                                                strB = null;
                                                z4 = false;
                                            } else {
                                                strB = strA2;
                                                z4 = true;
                                            }
                                            if (!z4) {
                                                strB = b("QMTAuMC4wLjIwMA==");
                                            }
                                            if (iE == -1) {
                                                i = 80;
                                            } else {
                                                i = iE;
                                            }
                                        } else if (lowerCase2 == null || !lowerCase2.contains("wap")) {
                                            strB = null;
                                            i = -1;
                                        } else {
                                            String strA3 = a();
                                            iE = e();
                                            if (TextUtils.isEmpty(strA3) || strA3.equals("null")) {
                                                strB = null;
                                                z3 = false;
                                            } else {
                                                strB = strA3;
                                                z3 = true;
                                            }
                                            if (!z3) {
                                                strB = b("QMTAuMC4wLjE3Mg==");
                                            }
                                            if (iE == -1) {
                                                i = 80;
                                            } else {
                                                i = iE;
                                            }
                                        }
                                    } catch (SecurityException e) {
                                        e = e;
                                        strB = null;
                                        a7b.m(e, "pu", "ghp");
                                        strA0 = fj.a0(context);
                                        if (strA0 != null) {
                                            lowerCase = strA0.toLowerCase(Locale.US);
                                            strA = a();
                                            E = e();
                                            if (lowerCase.indexOf("ctwap") != -1) {
                                                if (!TextUtils.isEmpty(strA) || strA.equals("null")) {
                                                    z2 = false;
                                                } else {
                                                    strB = strA;
                                                    z2 = true;
                                                }
                                                if (!z2) {
                                                    strB = b("QMTAuMC4wLjIwMA==");
                                                }
                                                if (E == -1) {
                                                    E = 80;
                                                }
                                            } else if (lowerCase.indexOf("wap") != -1) {
                                                if (!TextUtils.isEmpty(strA) || strA.equals("null")) {
                                                    z = false;
                                                } else {
                                                    strB = strA;
                                                    z = true;
                                                }
                                                if (!z) {
                                                    strB = b("QMTAuMC4wLjE3Mg==");
                                                }
                                                E = 80;
                                            }
                                        } else {
                                            E = r10;
                                        }
                                        if (cursorQuery != null) {
                                            try {
                                                cursorQuery.close();
                                            } catch (Throwable th) {
                                                a7b.m(th, "pu", "gPx2");
                                            }
                                        }
                                        r11 = E;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        strB = null;
                                        a7b.m(th, "pu", "gPx1");
                                        th.printStackTrace();
                                        r11 = r10;
                                        if (cursorQuery != null) {
                                            try {
                                                cursorQuery.close();
                                                r11 = r10;
                                            } catch (Throwable th3) {
                                                a7b.m(th3, "pu", "gPx2");
                                                r11 = r10;
                                            }
                                        }
                                    }
                                } catch (SecurityException e2) {
                                    e = e2;
                                    a7b.m(e, "pu", "ghp");
                                    strA0 = fj.a0(context);
                                    if (strA0 != null) {
                                        lowerCase = strA0.toLowerCase(Locale.US);
                                        strA = a();
                                        E = e();
                                        if (lowerCase.indexOf("ctwap") != -1) {
                                            if (TextUtils.isEmpty(strA)) {
                                                z2 = false;
                                            } else {
                                                z2 = false;
                                            }
                                            if (!z2) {
                                                strB = b("QMTAuMC4wLjIwMA==");
                                            }
                                            if (E == -1) {
                                                E = 80;
                                            }
                                        } else if (lowerCase.indexOf("wap") != -1) {
                                            if (TextUtils.isEmpty(strA)) {
                                                z = false;
                                            } else {
                                                z = false;
                                            }
                                            if (!z) {
                                                strB = b("QMTAuMC4wLjE3Mg==");
                                            }
                                            E = 80;
                                        }
                                    } else {
                                        E = r10;
                                    }
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                    r11 = E;
                                } catch (Throwable th4) {
                                    th = th4;
                                    a7b.m(th, "pu", "gPx1");
                                    th.printStackTrace();
                                    r11 = r10;
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                        r11 = r10;
                                    }
                                }
                            } else {
                                strB = null;
                                i = -1;
                            }
                        } catch (SecurityException e3) {
                            e = e3;
                            strB = null;
                            r10 = -1;
                            a7b.m(e, "pu", "ghp");
                            strA0 = fj.a0(context);
                            if (strA0 != null) {
                                lowerCase = strA0.toLowerCase(Locale.US);
                                strA = a();
                                E = e();
                                if (lowerCase.indexOf("ctwap") != -1) {
                                    if (TextUtils.isEmpty(strA)) {
                                        z2 = false;
                                    } else {
                                        z2 = false;
                                    }
                                    if (!z2) {
                                        strB = b("QMTAuMC4wLjIwMA==");
                                    }
                                    if (E == -1) {
                                        E = 80;
                                    }
                                } else if (lowerCase.indexOf("wap") != -1) {
                                    if (TextUtils.isEmpty(strA)) {
                                        z = false;
                                    } else {
                                        z = false;
                                    }
                                    if (!z) {
                                        strB = b("QMTAuMC4wLjE3Mg==");
                                    }
                                    E = 80;
                                }
                            } else {
                                E = r10;
                            }
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            r11 = E;
                            if (strB != null) {
                                try {
                                    if (strB.length() > 0) {
                                        z5 = true;
                                    }
                                } catch (Throwable th5) {
                                    v6b.b(th5, "pu", "gp2");
                                    th5.printStackTrace();
                                }
                            }
                            if (z5) {
                                return new java.net.Proxy(java.net.Proxy.Type.HTTP, InetSocketAddress.createUnresolved(strB, r11));
                            }
                            return null;
                        } catch (Throwable th6) {
                            th = th6;
                            strB = null;
                            r10 = -1;
                            a7b.m(th, "pu", "gPx1");
                            th.printStackTrace();
                            r11 = r10;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                                r11 = r10;
                            }
                            if (strB != null) {
                                if (strB.length() > 0) {
                                    z5 = true;
                                }
                            }
                            if (z5) {
                                return new java.net.Proxy(java.net.Proxy.Type.HTTP, InetSocketAddress.createUnresolved(strB, r11));
                            }
                            return null;
                        }
                    } else {
                        strB = null;
                        i = -1;
                    }
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Throwable th7) {
                            a7b.m(th7, "pu", "gPx2");
                        }
                    }
                    r11 = i;
                } catch (Throwable th8) {
                    if (contentResolver == 0) {
                        throw th8;
                    }
                    try {
                        contentResolver.close();
                        throw th8;
                    } catch (Throwable th9) {
                        a7b.m(th9, "pu", "gPx2");
                        throw th8;
                    }
                }
            } catch (SecurityException e4) {
                e = e4;
                cursorQuery = null;
                strB = null;
            } catch (Throwable th10) {
                th = th10;
                cursorQuery = null;
                strB = null;
            }
            if (strB != null) {
                if (strB.length() > 0 && r11 != -1) {
                    z5 = true;
                }
            }
            if (z5) {
                return new java.net.Proxy(java.net.Proxy.Type.HTTP, InetSocketAddress.createUnresolved(strB, r11));
            }
        }
        return null;
    }

    public static boolean g(Context context) {
        return fj.Y(context) == 0;
    }
}
