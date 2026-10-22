package com.baidu.b.b;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.baidu.b.h;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class e extends com.baidu.b.b.a {
    private Context d;
    private f e;

    public static final class a implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String[] f26269a = {"read0", "read1", "read2", "read3", "access0", "access1", "access2", "access3", "sync0", "sync1", "sync2", "sync3", "open0", "open1", "open2", "open3"};
        private final int b;

        private a(int i) {
            this.b = i;
        }

        public static a a(byte b, boolean z) {
            int i = b & 255;
            return a(z ? i >> 4 : i & 15);
        }

        public static a a(int i) {
            if (i >= 0 && i < 16) {
                return new a(i);
            }
            throw new IllegalArgumentException("invalid idx " + i);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return this.b - aVar.b;
        }

        public String a() {
            return f26269a[this.b];
        }

        public byte b() {
            return (byte) this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && a.class == obj.getClass() && this.b == ((a) obj).b;
        }

        public int hashCode() {
            return this.b;
        }
    }

    public class b {
        private int b = 33;
        private a[] c = new a[33];
        private int d;

        public b() {
        }

        private void b(int i) {
            a[] aVarArr = this.c;
            if (i - aVarArr.length > 0) {
                int length = aVarArr.length;
                int i2 = length + (length >> 1);
                if (i2 - i >= 0) {
                    i = i2;
                }
                this.c = (a[]) Arrays.copyOf(aVarArr, i);
            }
        }

        public int a() {
            return this.d;
        }

        public a a(int i) {
            if (i < this.d) {
                return this.c[i];
            }
            throw new IndexOutOfBoundsException("idx " + i + " size " + this.d);
        }

        public void a(a aVar) {
            b(this.d + 1);
            a[] aVarArr = this.c;
            int i = this.d;
            this.d = i + 1;
            aVarArr[i] = aVar;
        }

        public byte[] b() {
            int i;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i2 = 0;
            while (true) {
                i = this.d;
                if (i2 >= i / 2) {
                    break;
                }
                int i3 = i2 * 2;
                byteArrayOutputStream.write((byte) (((a(i3 + 1).b() & 255) << 4) | (a(i3).b() & 255)));
                i2++;
            }
            if (i % 2 != 0) {
                byteArrayOutputStream.write((byte) (a(i - 1).b() & 255));
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List f26271a = new ArrayList();

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f26272a;
            private a b;

            public a(a aVar) {
                this.b = aVar;
            }

            public void a() {
                this.f26272a++;
            }
        }

        public List a() {
            ArrayList arrayList = new ArrayList(this.f26271a);
            Collections.sort(arrayList, new com.baidu.b.b.f(this));
            return arrayList;
        }

        public void a(a aVar) {
            this.f26271a.add(new a(aVar));
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        byte[] f26273a;
        byte b;
        byte[] c;

        public d(byte[] bArr, byte b, byte[] bArr2) {
            this.f26273a = bArr;
            this.b = b;
            this.c = bArr2;
        }

        public h.a a() {
            try {
                String strA = com.baidu.b.d.b.a(this.f26273a, "", true);
                String str = new String(new byte[]{this.b}, "UTF-8");
                byte[] bArr = this.c;
                return h.a(strA, str, bArr != null ? new String(bArr, "UTF-8") : null);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: com.baidu.b.b.e$e, reason: collision with other inner class name */
    public static class C0257e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f26274a;
        public int b;
        public int c = 16;

        public String toString() {
            return "";
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Method f26275a;
        private Method b;
        private Method c;
        private Method d;
        private Method e;

        public int a(Context context, Uri uri, int i, int i2, int i3) throws com.baidu.b.a.e.a {
            try {
                return ((Integer) this.f26275a.invoke(context, uri, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3))).intValue();
            } catch (Exception e) {
                throw new com.baidu.b.a.e.a(e);
            }
        }

        public void a() {
            try {
                String strA = com.baidu.b.a.e.a(com.baidu.b.a.d.d());
                Class cls = Integer.TYPE;
                this.f26275a = com.baidu.b.a.e.a(Context.class, strA, new Class[]{Uri.class, cls, cls, cls});
                this.b = com.baidu.b.a.e.a(Context.class, com.baidu.b.a.e.a(com.baidu.b.a.d.e()), new Class[]{String.class, Uri.class, cls});
                this.c = com.baidu.b.a.e.a(ContentResolver.class, com.baidu.b.a.e.a(com.baidu.b.a.d.f()), new Class[]{Uri.class, cls});
                this.d = com.baidu.b.a.e.a(Context.class, com.baidu.b.a.e.a(com.baidu.b.a.d.g()), new Class[]{Uri.class, cls});
                this.e = com.baidu.b.a.e.a(ContentResolver.class, com.baidu.b.a.e.a(com.baidu.b.a.d.h()), new Class[]{Uri.class, cls});
            } catch (Exception unused) {
            }
        }
    }

    public e() {
        super("upc", 9000000L);
        f fVar = new f();
        this.e = fVar;
        fVar.a();
    }

    private a a(String str, int i, List list, int i2, C0257e c0257e) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c.a aVar = (c.a) it.next();
            if (a(str, i, aVar.b, i2, c0257e)) {
                aVar.a();
                return aVar.b;
            }
        }
        return null;
    }

    private String a(String str) {
        return str + ".cesium";
    }

    private String a(String str, int i, a aVar) {
        return String.format("content://%s/dat/v1/i%d/%s", a(str), Integer.valueOf(i), aVar.a());
    }

    private String a(String str, a aVar) {
        return String.format("content://%s/dic/v1/%s", a(str), aVar.a());
    }

    private boolean a(String str, int i, a aVar, int i2, C0257e c0257e) {
        int iA;
        Uri uri = Uri.parse(a(str, i, aVar));
        int i3 = 0;
        while (true) {
            if (i3 >= 2) {
                iA = -1;
                break;
            }
            if (c0257e != null) {
                try {
                    c0257e.f26274a++;
                } catch (Throwable unused) {
                    try {
                        Thread.sleep(5L);
                    } catch (Exception unused2) {
                    }
                    i3++;
                }
            }
            iA = this.e.a(this.d, uri, 0, i2, 1);
            break;
        }
        if (iA == 0) {
            return true;
        }
        if (c0257e != null) {
            c0257e.b++;
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0025 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:14:0x0027 A[RETURN] */
    private boolean a(String str, a aVar, int i) {
        int iA;
        Uri uri = Uri.parse(a(str, aVar));
        for (int i2 = 0; i2 < 2; i2++) {
            try {
                iA = this.e.a(this.d, uri, 0, i, 1);
                if (iA == 0) {
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                try {
                    Thread.sleep(5L);
                } catch (Exception unused2) {
                }
            }
        }
        iA = -1;
        if (iA == 0) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.b.b.a
    public com.baidu.b.b.a.e a(String str, com.baidu.b.b.a.d dVar) {
        int packageUid;
        byte[] bArrB;
        boolean z;
        Byte bValueOf;
        try {
            packageUid = this.d.getPackageManager().getPackageUid(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageUid = -1;
        }
        int i = packageUid;
        if (i < 0) {
            return com.baidu.b.b.a.e.a();
        }
        C0257e c0257e = new C0257e();
        b bVar = new b();
        c cVar = new c();
        c cVar2 = new c();
        for (int i2 = 0; i2 < 16; i2++) {
            a aVarA = a.a(i2);
            if (a(str, aVarA, i)) {
                cVar.a(aVarA);
            } else {
                cVar2.a(aVarA);
            }
        }
        for (int i3 = 0; i3 < 32; i3++) {
            a aVarA2 = a(str, i3, cVar.a(), i, c0257e);
            if (aVarA2 == null) {
                aVarA2 = a(str, i3, cVar2.a(), i, c0257e);
            }
            if (aVarA2 == null) {
                return com.baidu.b.b.a.e.a();
            }
            bVar.a(aVarA2);
        }
        byte[] bArrB2 = bVar.b();
        int i4 = 3;
        boolean z2 = true;
        byte[] bArr = {"0".getBytes()[0], "O".getBytes()[0], "V".getBytes()[0]};
        int i5 = 0;
        while (true) {
            bArrB = null;
            if (i5 >= i4) {
                z = z2;
                bValueOf = null;
                break;
            }
            byte b2 = bArr[i5];
            a aVarA3 = a.a(b2, false);
            int i6 = i5;
            z = z2;
            byte[] bArr2 = bArr;
            if (a(str, 32, aVarA3, i, c0257e)) {
                a aVarA4 = a.a(b2, z);
                if (a(str, 33, aVarA4, i, c0257e)) {
                    b bVar2 = new b();
                    bVar2.a(aVarA3);
                    bVar2.a(aVarA4);
                    bValueOf = Byte.valueOf(bVar2.b()[0]);
                    break;
                }
            }
            i5 = i6 + 1;
            z2 = z;
            bArr = bArr2;
            i4 = 3;
        }
        if (bValueOf == null) {
            b bVar3 = new b();
            int i7 = 32;
            for (int i8 = 34; i7 < i8; i8 = 34) {
                int i9 = i7;
                b bVar4 = bVar3;
                a aVarA5 = a(str, i7, cVar.a(), i, c0257e);
                if (aVarA5 == null) {
                    aVarA5 = a(str, i9, cVar2.a(), i, c0257e);
                }
                if (aVarA5 == null) {
                    return com.baidu.b.b.a.e.a();
                }
                bVar4.a(aVarA5);
                i7 = i9 + 1;
                bVar3 = bVar4;
            }
            bValueOf = Byte.valueOf(bVar3.b()[0]);
        } else {
            z = false;
        }
        Byte b3 = bValueOf;
        if (z) {
            b bVar5 = new b();
            for (int i10 = 34; i10 < 94; i10++) {
                a aVarA6 = a(str, i10, cVar.a(), i, c0257e);
                if (aVarA6 == null) {
                    aVarA6 = a(str, i10, cVar2.a(), i, c0257e);
                }
                if (aVarA6 == null) {
                    break;
                }
                bVar5.a(aVarA6);
            }
            if (bVar5.a() > 0) {
                bArrB = bVar5.b();
            }
        }
        return com.baidu.b.b.a.e.a(new d(bArrB2, b3.byteValue(), bArrB).a());
    }

    @Override // com.baidu.b.b.a
    public void a(com.baidu.b.b.a.c cVar) {
        this.d = this.b.f26262a;
    }
}
