package com.baidu.sec.privacy.f;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.view.MotionEventCompat;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.ipd.dsp.internal.q.u;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.zj.adlib.aq6;
import com.zj.adlib.xd9;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f26819a;
    public final Context b;
    public PublicKey c;

    public class a implements Comparator<c> {
        public a(d dVar) {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            int i = cVar2.c - cVar.c;
            if (i != 0) {
                return i;
            }
            boolean z = cVar.b;
            if (z && cVar2.b) {
                return 0;
            }
            if (z) {
                return -1;
            }
            if (cVar2.b) {
                return 1;
            }
            return i;
        }
    }

    public static class b {
        public static byte[] a(byte[] bArr) {
            return a(bArr, bArr.length);
        }

        public static byte[] a(byte[] bArr, int i) {
            byte b;
            int i2;
            int i3 = (i / 4) * 3;
            if (i3 == 0) {
                return new byte[0];
            }
            byte[] bArr2 = new byte[i3];
            int i4 = i;
            int i5 = 0;
            while (true) {
                byte b2 = bArr[i4 - 1];
                b = 10;
                if (b2 != 10 && b2 != 13 && b2 != 32 && b2 != 9) {
                    if (b2 != 61) {
                        break;
                    }
                    i5++;
                }
                i4--;
            }
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (i6 < i4) {
                byte b3 = bArr[i6];
                if (b3 != b && b3 != 13 && b3 != 32 && b3 != 9) {
                    if (b3 >= 65 && b3 <= 90) {
                        i2 = b3 - 65;
                    } else if (b3 >= 97 && b3 <= 122) {
                        i2 = b3 - 71;
                    } else if (b3 >= 48 && b3 <= 57) {
                        i2 = b3 + 4;
                    } else if (b3 == 43) {
                        i2 = 62;
                    } else {
                        if (b3 != 47) {
                            return null;
                        }
                        i2 = 63;
                    }
                    i8 = ((byte) i2) | (i8 << 6);
                    if (i9 % 4 == 3) {
                        int i10 = i7 + 1;
                        bArr2[i7] = (byte) ((16711680 & i8) >> 16);
                        int i11 = i10 + 1;
                        bArr2[i10] = (byte) ((65280 & i8) >> 8);
                        bArr2[i11] = (byte) (i8 & 255);
                        i7 = i11 + 1;
                    }
                    i9++;
                }
                i6++;
                b = 10;
            }
            if (i5 > 0) {
                int i12 = i8 << (i5 * 6);
                int i13 = i7 + 1;
                bArr2[i7] = (byte) ((i12 & xd9.p) >> 16);
                if (i5 == 1) {
                    i7 = i13 + 1;
                    bArr2[i13] = (byte) ((i12 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
                } else {
                    i7 = i13;
                }
            }
            byte[] bArr3 = new byte[i7];
            System.arraycopy(bArr2, 0, bArr3, 0, i7);
            return bArr3;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ApplicationInfo f26820a;
        public boolean b;
        public int c;
        public boolean d;

        public /* synthetic */ c(a aVar) {
            this();
        }

        public c() {
            this.c = 0;
            this.d = false;
            this.b = false;
        }
    }

    /* JADX INFO: renamed from: com.baidu.sec.privacy.f.d$d, reason: collision with other inner class name */
    public static class C0291d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f26821a;
        public String b;
        public int c = 0;

        public static boolean a(int i) {
            return i >= 14;
        }

        public static boolean b(String str) {
            return TextUtils.isEmpty(str);
        }

        public boolean c() {
            return b(this.b);
        }

        public static C0291d a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> itKeys = jSONObject.keys();
                String str2 = "0";
                String strOptString = "0";
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!d.d("ZGV2aWNlaWQ=").equals(next) && !d.d("dmVy").equals(next)) {
                        strOptString = jSONObject.optString(next, "0");
                    }
                }
                String string = jSONObject.getString(d.d("ZGV2aWNlaWQ="));
                jSONObject.getInt(d.d("dmVy"));
                int length = TextUtils.isEmpty(strOptString) ? 0 : strOptString.length();
                if (!TextUtils.isEmpty(string)) {
                    C0291d c0291d = new C0291d();
                    c0291d.f26821a = string;
                    c0291d.c = length;
                    if (length >= 14) {
                        return c0291d;
                    }
                    if (!TextUtils.isEmpty(strOptString)) {
                        str2 = strOptString;
                    }
                    c0291d.b = str2;
                    return c0291d;
                }
            } catch (Exception e) {
                com.baidu.sec.privacy.f.c.a(e);
            }
            return null;
        }

        public boolean b() {
            return a(this.c);
        }

        public static C0291d b(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C0291d c0291d = new C0291d();
            c0291d.f26821a = str;
            int length = TextUtils.isEmpty(str2) ? 0 : str2.length();
            c0291d.c = length;
            if (length >= 14) {
                return c0291d;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "0";
            }
            c0291d.b = str2;
            return c0291d;
        }

        public String a() {
            String str = this.b;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            return this.f26821a + "|" + str;
        }
    }

    public static final class e {
        public static byte[] a() {
            return new byte[]{com.alibaba.ariver.resource.parser.a.e.i, -126, 3, 99, com.alibaba.ariver.resource.parser.a.e.i, -126, 2, 75, -96, 3, 2, 1, 2, 2, 4, 106, -93, aq6.f40585a, 122, com.alibaba.ariver.resource.parser.a.e.i, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, com.alibaba.ariver.resource.parser.a.e.i, 97, com.alibaba.ariver.resource.parser.a.e.j, 11, com.alibaba.ariver.resource.parser.a.e.i, 9, 6, 3, 85, 4, 6, 19, 2, 99, 110, com.alibaba.ariver.resource.parser.a.e.j, com.google.common.base.a.r, com.alibaba.ariver.resource.parser.a.e.i, com.google.common.base.a.p, 6, 3, 85, 4, 8, 19, 7, 98, 101, 105, 106, 105, 110, 103, com.alibaba.ariver.resource.parser.a.e.j, com.google.common.base.a.r, com.alibaba.ariver.resource.parser.a.e.i, com.google.common.base.a.p, 6, 3, 85, 4, 7, 19, 7, 104, 97, 105, 100, 105, 97, 110, com.alibaba.ariver.resource.parser.a.e.j, com.google.common.base.a.p, com.alibaba.ariver.resource.parser.a.e.i, 12, 6, 3, 85, 4, 10, 19, 5, 98, 97, 105, 100, 117, com.alibaba.ariver.resource.parser.a.e.j, com.google.common.base.a.p, com.alibaba.ariver.resource.parser.a.e.i, 12, 6, 3, 85, 4, 11, 19, 5, 98, 97, 105, 100, 117, com.alibaba.ariver.resource.parser.a.e.j, com.google.common.base.a.p, com.alibaba.ariver.resource.parser.a.e.i, 12, 6, 3, 85, 4, 3, 19, 5, 98, 97, 105, 100, 117, com.alibaba.ariver.resource.parser.a.e.i, 32, com.google.common.base.a.A, 13, com.alibaba.ariver.resource.parser.a.e.j, com.alibaba.ariver.resource.parser.a.e.n, com.alibaba.ariver.resource.parser.a.e.j, com.alibaba.ariver.resource.parser.a.e.i, com.alibaba.ariver.resource.parser.a.e.k, com.alibaba.ariver.resource.parser.a.e.j, com.alibaba.ariver.resource.parser.a.e.i, com.alibaba.ariver.resource.parser.a.e.m, com.alibaba.ariver.resource.parser.a.e.l, com.alibaba.ariver.resource.parser.a.e.o, com.alibaba.ariver.resource.parser.a.e.l, com.alibaba.ariver.resource.parser.a.e.p, 90, com.google.common.base.a.B, com.google.common.base.a.q, com.alibaba.ariver.resource.parser.a.e.k, com.alibaba.ariver.resource.parser.a.e.i, com.alibaba.ariver.resource.parser.a.e.p, com.alibaba.ariver.resource.parser.a.e.i, com.alibaba.ariver.resource.parser.a.e.i, com.alibaba.ariver.resource.parser.a.e.p, com.alibaba.ariver.resource.parser.a.e.k, com.alibaba.ariver.resource.parser.a.e.m, com.alibaba.ariver.resource.parser.a.e.i, com.alibaba.ariver.resource.parser.a.e.m, com.alibaba.ariver.resource.parser.a.e.l, com.alibaba.ariver.resource.parser.a.e.o, com.alibaba.ariver.resource.parser.a.e.l, com.alibaba.ariver.resource.parser.a.e.p, 90, com.alibaba.ariver.resource.parser.a.e.i, 97, com.alibaba.ariver.resource.parser.a.e.j, 11, com.alibaba.ariver.resource.parser.a.e.i, 9, 6, 3, 85, 4, 6, 19, 2, 99, 110, com.alibaba.ariver.resource.parser.a.e.j, com.google.common.base.a.r, com.alibaba.ariver.resource.parser.a.e.i, com.google.common.base.a.p, 6, 3, 85, 4, 8, 19, 7, 98, 101, 105, 106, 105, 110, 103, com.alibaba.ariver.resource.parser.a.e.j, com.google.common.base.a.r, com.alibaba.ariver.resource.parser.a.e.i, com.google.common.base.a.p, 6, 3, 85, 4, 7, 19, 7, 104, 97, 105, 100, 105, 97, 110, com.alibaba.ariver.resource.parser.a.e.j, com.google.common.base.a.p, com.alibaba.ariver.resource.parser.a.e.i, 12, 6, 3, 85, 4, 10, 19, 5, 98, 97, 105, 100, 117, com.alibaba.ariver.resource.parser.a.e.j, com.google.common.base.a.p, com.alibaba.ariver.resource.parser.a.e.i, 12, 6, 3, 85, 4, 11, 19, 5, 98, 97, 105, 100, 117, com.alibaba.ariver.resource.parser.a.e.j, com.google.common.base.a.p, com.alibaba.ariver.resource.parser.a.e.i, 12, 6, 3, 85, 4, 3, 19, 5, 98, 97, 105, 100, 117, com.alibaba.ariver.resource.parser.a.e.i, -126, 1, 34, com.alibaba.ariver.resource.parser.a.e.i, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -126, 1, com.google.common.base.a.q, 0, com.alibaba.ariver.resource.parser.a.e.i, -126, 1, 10, 2, -126, 1, 1, 0, -86, -91, -2, -41, 127, com.google.android.exoplayer2.text.cea.a.g, -25, -33, 93, com.alibaba.ariver.resource.parser.a.e.l, -73, 32, -81, 61, 108, com.google.android.exoplayer2.text.cea.a.g, 126, com.google.common.base.a.p, -125, 125, u.u7, -29, 34, -60, 84, -67, -46, 125, -93, -67, -27, 97, com.alibaba.ariver.resource.parser.a.e.o, 35, 0, -6, 83, 67, -116, com.google.android.exoplayer2.text.cea.a.l, -24, com.google.common.base.a.D, 88, -5, com.google.android.exoplayer2.text.cea.a.e, com.google.common.base.a.E, -105, com.alibaba.ariver.resource.parser.a.e.j, 76, -70, -32, 105, -48, 67, 69, 102, -111, -81, 93, -103, -18, 17, com.alibaba.ariver.resource.parser.a.e.p, 81, -34, -80, -76, -13, -84, 6, 91, 10, com.alibaba.ariver.resource.parser.a.e.i, -56, -1, com.google.android.exoplayer2.text.cea.a.n, 9, com.google.common.base.a.A, 34, 6, 103, 35, u.x7, com.google.common.base.a.G, 70, -19, u.x7, com.google.common.base.a.x, u.D7, -43, -97, 75, com.google.common.base.a.A, -124, -101, -71, -75, -107, -88, -13, -71, 80, 90, -76, -119, com.alibaba.ariver.resource.parser.a.e.l, -80, 118, UnsignedBytes.f32243a, -12, -108, 98, -29, -27, 60, -119, -74, 110, 61, com.alibaba.ariver.resource.parser.a.e.l, -22, com.alibaba.ariver.resource.parser.a.e.n, 66, -99, -45, -25, 111, -121, com.google.common.base.a.C, -72, 127, 3, com.alibaba.ariver.resource.parser.a.e.l, -100, 57, -90, 116, u.r7, -117, 74, -71, 121, 59, 19, -8, -109, com.google.android.exoplayer2.text.cea.a.e, -14, 76, -105, -127, -23, 5, 99, -82, com.google.common.base.a.z, -99, com.alibaba.ariver.resource.parser.a.e.l, 78, -26, 77, -52, -29, 121, 42, -76, com.google.common.base.a.x, 2, 116, 111, -76, 2, -78, -90, u.v7, 81, 115, 82, com.alibaba.ariver.resource.parser.a.e.k, 124, -83, 96, com.google.common.base.a.x, u.m7, -118, 105, 90, -70, aq6.f40585a, -33, -110, 12, -15, com.google.android.exoplayer2.text.cea.a.h, 34, -125, -116, 69, u.v7, -103, -109, -124, com.google.common.base.a.D, 94, -89, -98, -11, -66, 89, com.alibaba.ariver.resource.parser.a.e.i, -68, u.x7, 107, -60, 12, 114, -71, 119, com.alibaba.ariver.resource.parser.a.e.j, u.B7, -65, 113, -99, 3, -90, 79, -88, u.A7, -87, -25, u.A7, com.google.android.exoplayer2.text.cea.a.j, 110, -25, com.google.common.base.a.G, com.alibaba.ariver.resource.parser.a.e.j, 124, -76, -91, 77, -11, -90, 114, u.o7, 118, -22, -5, -124, 19, com.google.common.base.a.z, -74, -75, 78, com.google.common.base.a.F, 47, -69, 2, 3, 1, 0, 1, -93, com.google.android.exoplayer2.text.cea.a.e, com.alibaba.ariver.resource.parser.a.e.i, 31, com.alibaba.ariver.resource.parser.a.e.i, com.google.common.base.a.G, 6, 3, 85, com.google.common.base.a.G, com.google.common.base.a.p, 4, com.google.common.base.a.z, 4, com.google.common.base.a.x, -41, -108, com.google.android.exoplayer2.text.cea.a.e, -126, -103, 35, 115, -83, 99, 110, u.D7, 110, -125, -118, -69, 87, -103, com.google.common.base.a.H, 12, u.w7, com.alibaba.ariver.resource.parser.a.e.i, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 3, -126, 1, 1, 0, 0, -117, 0, -28, com.alibaba.ariver.resource.parser.a.e.l, com.google.common.base.a.D, -4, -15, 86, 127, com.google.common.base.a.p, -101, -48, 121, 115, u.w7, -72, -22, 4, -83, com.alibaba.ariver.resource.parser.a.e.j, 106, -15, -44, -116, -105, 19, 65, -32, 65, 92, com.google.common.base.a.y, com.alibaba.ariver.resource.parser.a.e.l, 61, -21, -74, 71, 91, SignedBytes.f32242a, 75, -72, -48, 102, 17, -120, -23, -68, com.alibaba.ariver.resource.parser.a.e.l, com.google.common.base.a.A, -104, 107, 65, -30, 109, -6, com.google.android.exoplayer2.text.cea.a.o, -44, -46, -73, u.v7, u.u7, 63, 77, u.v7, -11, u.x7, com.google.common.base.a.E, -1, 114, 86, -80, com.google.common.base.a.F, -89, com.google.common.base.a.G, -20, com.alibaba.ariver.resource.parser.a.e.j, -8, 57, -7, -30, 61, -108, -6, -60, 113, com.google.android.exoplayer2.text.cea.a.n, -32, -93, 19, u.p7, -89, 106, 91, 96, -48, 90, u.r7, com.google.android.exoplayer2.text.cea.a.o, 104, 111, -88, com.alibaba.ariver.resource.parser.a.e.l, u.D7, MaterialProgressDrawable.c, -36, -113, 86, -92, com.google.common.base.a.C, com.google.common.base.a.H, 94, -13, -15, u.t7, 59, -21, -111, 104, u.y7, -3, -121, -90, -43, 61, 105, -3, 57, 69, com.alibaba.ariver.resource.parser.a.e.l, -3, u.B7, 105, -12, 19, 77, -82, -120, 121, 108, u.o7, -126, com.google.android.exoplayer2.text.cea.a.o, -43, com.google.common.base.a.p, -56, com.google.common.base.a.y, 47, 63, -104, -7, 113, 57, 100, -9, -12, -101, 107, -77, u.n7, 91, -104, u.q7, 0, -7, -72, -19, 75, 12, 111, 127, -115, -46, -99, -111, -93, -67, -42, -66, 32, 81, 70, 109, u.t7, 10, 19, u.z7, -44, 59, com.google.common.base.a.y, 31, u.q7, u.r7, 83, -14, com.google.android.exoplayer2.text.cea.a.l, 73, -88, aq6.f40585a, u.s7, -46, com.google.android.exoplayer2.text.cea.a.o, 66, com.google.android.exoplayer2.text.cea.a.j, -2, -70, -6, -42, 103, 8, 4, 89, 110, -122, 68, -86, 62, -68, 13, -117, 35, -52, -6, 106, -91, 91, u.p7, -56, -26, -41, -109, 68, -102, -43, -29, 113, com.google.android.exoplayer2.text.cea.a.l, -126, -127, 122, -47, -30, -96, -2, 78, com.google.android.exoplayer2.text.cea.a.m, -92, u.A7, -124, -102, 73, -105, -66, 5, -85, -7, MaterialProgressDrawable.d};
        }
    }

    public static final class f {
        public static byte[] a(byte[] bArr) {
            try {
                return MessageDigest.getInstance("SHA-1").digest(bArr);
            } catch (Exception e) {
                d.b(e);
                return new byte[0];
            }
        }
    }

    static {
        new String(b.a(new byte[]{77, 122, 65, 121, 77, 84, 73, aq6.f40585a, 77, 68, 73, 61}));
        new String(b.a(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, 61}));
    }

    public d(Context context) throws Throwable {
        this.b = context.getApplicationContext();
        c();
    }

    public static String b(Context context) {
        C0291d c0291dA = a(context);
        return c0291dA != null ? c0291dA.a() : "";
    }

    public static void b(Throwable th) {
    }

    public static String d(String str) {
        return new String(b.a(str.getBytes()));
    }

    /* JADX WARN: Code duplicated, block: B:32:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final void c() throws Throwable {
        Throwable th;
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            try {
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(e.a());
                try {
                    this.c = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream2).getPublicKey();
                    byteArrayInputStream2.close();
                } catch (Exception e2) {
                    e = e2;
                    byteArrayInputStream = byteArrayInputStream2;
                    try {
                        b(e);
                        if (byteArrayInputStream == null) {
                        } else {
                            byteArrayInputStream.close();
                        }
                    } catch (Throwable th2) {
                        byteArrayInputStream2 = byteArrayInputStream;
                        th = th2;
                        ByteArrayInputStream byteArrayInputStream3 = byteArrayInputStream2;
                        th = th;
                        byteArrayInputStream = byteArrayInputStream3;
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (Exception e3) {
                                b(e3);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    ByteArrayInputStream byteArrayInputStream4 = byteArrayInputStream2;
                    th = th;
                    byteArrayInputStream = byteArrayInputStream4;
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                b(e4);
            }
        } catch (Exception e5) {
            e = e5;
        } catch (Throwable th4) {
            th = th4;
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            throw th;
        }
    }

    public final String e(String str) {
        return "0";
    }

    public final String f(String str) {
        try {
            return Settings.System.getString(this.b.getContentResolver(), str);
        } catch (Exception e2) {
            b(e2);
            return null;
        }
    }

    public static String a(byte[] bArr) {
        if (bArr != null) {
            String str = "";
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & 255);
                str = hexString.length() == 1 ? str + "0" + hexString : str + hexString;
            }
            return str.toLowerCase();
        }
        throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
    }

    public final boolean b(String str) {
        return this.b.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    public final C0291d b() {
        return C0291d.b(f("com.baidu.deviceid"), f("bd_setting_i"));
    }

    public final String[] a(Signature[] signatureArr) {
        int length = signatureArr.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = a(f.a(signatureArr[i].toByteArray()));
        }
        return strArr;
    }

    public static byte[] a(byte[] bArr, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, publicKey);
        return cipher.doFinal(bArr);
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return "";
    }

    public final List<c> a(Intent intent, boolean z) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = this.b.getPackageManager();
        List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (listQueryBroadcastReceivers != null) {
            for (ResolveInfo resolveInfo : listQueryBroadcastReceivers) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null && activityInfo.applicationInfo != null) {
                    try {
                        ActivityInfo activityInfo2 = resolveInfo.activityInfo;
                        Bundle bundle = packageManager.getReceiverInfo(new ComponentName(activityInfo2.packageName, activityInfo2.name), 128).metaData;
                        if (bundle != null) {
                            String string = bundle.getString("galaxy_data");
                            if (!TextUtils.isEmpty(string)) {
                                byte[] bArrA = b.a(string.getBytes("utf-8"));
                                JSONObject jSONObject = new JSONObject(new String(bArrA));
                                c cVar = new c(null);
                                cVar.c = jSONObject.getInt("priority");
                                cVar.f26820a = resolveInfo.activityInfo.applicationInfo;
                                if (this.b.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                                    cVar.b = true;
                                }
                                if (z) {
                                    String string2 = bundle.getString("galaxy_sf");
                                    if (!TextUtils.isEmpty(string2)) {
                                        PackageInfo packageInfo = packageManager.getPackageInfo(resolveInfo.activityInfo.applicationInfo.packageName, 64);
                                        JSONArray jSONArray = jSONObject.getJSONArray("sigs");
                                        int length = jSONArray.length();
                                        String[] strArr = new String[length];
                                        for (int i = 0; i < length; i++) {
                                            strArr[i] = jSONArray.getString(i);
                                        }
                                        if (a(strArr, a(packageInfo.signatures))) {
                                            byte[] bArrA2 = a(b.a(string2.getBytes()), this.c);
                                            if (bArrA2 != null && Arrays.equals(bArrA2, f.a(bArrA))) {
                                                cVar.d = true;
                                            }
                                        }
                                    }
                                }
                                arrayList.add(cVar);
                            }
                        }
                    } catch (Exception e2) {
                        b(e2);
                    }
                }
            }
        }
        Collections.sort(arrayList, new a(this));
        return arrayList;
    }

    public final boolean a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            hashSet.add(str);
        }
        HashSet hashSet2 = new HashSet();
        for (String str2 : strArr2) {
            hashSet2.add(str2);
        }
        return hashSet.equals(hashSet2);
    }

    public static String a(File file) throws Throwable {
        FileReader fileReader;
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader(file);
            try {
                try {
                    char[] cArr = new char[8192];
                    CharArrayWriter charArrayWriter = new CharArrayWriter();
                    while (true) {
                        int i = fileReader.read(cArr);
                        if (i <= 0) {
                            break;
                        }
                        charArrayWriter.write(cArr, 0, i);
                        th = th;
                        fileReader2 = fileReader;
                        if (fileReader2 != null) {
                            try {
                                fileReader2.close();
                            } catch (Exception e2) {
                                b(e2);
                            }
                        }
                        throw th;
                    }
                    String string = charArrayWriter.toString();
                    try {
                        fileReader.close();
                    } catch (Exception e3) {
                        b(e3);
                    }
                    return string;
                } catch (Exception e4) {
                    e = e4;
                    b(e);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e5) {
                            b(e5);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileReader2 = fileReader;
            }
        } catch (Exception e6) {
            e = e6;
            fileReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static C0291d a(Context context) {
        return new d(context).a();
    }

    public final C0291d a() {
        List<c> listA = a(new Intent("com.baidu.intent.action.GALAXY").setPackage(this.b.getPackageName()), true);
        boolean z = false;
        if (listA == null || listA.size() == 0) {
            for (int i = 0; i < 3; i++) {
            }
        } else {
            boolean z2 = listA.get(0).d;
            if (!z2) {
                for (int i2 = 0; i2 < 3; i2++) {
                }
            }
            z = z2;
        }
        File file = new File(this.b.getFilesDir(), "libcuid.so");
        C0291d c0291dA = file.exists() ? C0291d.a(c(a(file))) : null;
        if (c0291dA == null) {
            f26819a |= 16;
            List<c> listA2 = a(new Intent("com.baidu.intent.action.GALAXY"), z);
            if (listA2 != null) {
                File filesDir = this.b.getFilesDir();
                String name = "files".equals(filesDir.getName()) ? "files" : filesDir.getName();
                for (c cVar : listA2) {
                    if (!cVar.b) {
                        File file2 = new File(new File(cVar.f26820a.dataDir, name), "libcuid.so");
                        if (file2.exists() && (c0291dA = C0291d.a(c(a(file2)))) != null) {
                            break;
                        }
                    }
                }
            }
        }
        if (c0291dA == null) {
            c0291dA = C0291d.a(c(f("com.baidu.deviceid.v2")));
        }
        boolean zB = b("android.permission.READ_EXTERNAL_STORAGE");
        if (c0291dA == null && zB) {
            f26819a |= 2;
        }
        if (c0291dA == null) {
            f26819a |= 8;
            c0291dA = b();
        }
        if (c0291dA == null && zB) {
            f26819a |= 1;
            e("");
        }
        a(c0291dA);
        return c0291dA;
    }

    public final boolean a(C0291d c0291d) {
        if (c0291d == null) {
            return false;
        }
        if (c0291d.b()) {
            c0291d.b = "O";
            return true;
        }
        if (!c0291d.c()) {
            return false;
        }
        c0291d.b = "0";
        return true;
    }
}
