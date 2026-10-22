package com.kwad.sdk.utils.a;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class c {
    private static final int PAGE_SIZE;
    private static final int[] brN = {0, 1, 4, 4, 8, 8};
    private static final byte[] brO = new byte[0];
    private static final int brP;
    private static final int brQ;
    private static final int brR;
    private final String apn;
    private final Map<String, b> brS;
    private FileChannel brU;
    private FileChannel brV;
    private RandomAccessFile brW;
    private RandomAccessFile brX;
    private MappedByteBuffer brY;
    private MappedByteBuffer brZ;
    private com.kwad.sdk.utils.a.b bsa;
    private int bsb;
    private long bsc;
    private int bsf;
    private int bsg;
    private int bsh;
    private boolean bsi;
    private String bsj;
    private int bsk;
    private int bsm;
    private final String name;
    private final d brT = com.kwad.sdk.utils.a.d.bsx;
    private final Map<String, com.kwad.sdk.utils.a.a.b> bsd = new HashMap();
    private boolean bse = false;
    private final ArrayList<e> bsl = new ArrayList<>();
    private boolean bsn = true;
    private final Executor bso = new f();

    public static class a {
        static int bsq = 11;
        static final C1308c bsr = new C1308c(11);
        private final String apn;
        private int bsm = 0;
        private b[] bss;
        private final String name;

        public a(String str, String str2) {
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("path is empty");
            }
            if (str2 == null || str2.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            if (!str.endsWith(WVNativeCallbackUtil.SEPERATER)) {
                str = str + '/';
            }
            this.apn = str;
            this.name = str2;
        }

        public final c XC() {
            String str = this.apn + this.name;
            c cVarIz = C1308c.iz(str);
            if (cVarIz == null) {
                synchronized (a.class) {
                    cVarIz = C1308c.iz(str);
                    if (cVarIz == null) {
                        cVarIz = new c(this.apn, this.name, this.bss, this.bsm);
                        C1308c.b(str, cVarIz);
                    }
                }
            }
            Integer num = C1308c.bsw.get(str);
            if (num != null) {
                C1308c.bsw.put(str, Integer.valueOf(num.intValue() + 1));
            } else {
                C1308c.bsw.put(str, 1);
            }
            return cVarIz;
        }
    }

    public interface b<T> {
        String XD();

        T f(byte[] bArr, int i, int i2);

        byte[] u(T t);
    }

    /* JADX INFO: renamed from: com.kwad.sdk.utils.a.c$c, reason: collision with other inner class name */
    public static class C1308c {
        private static Map<String, c> bst;
        private static List<String> bsu;
        private static int bsv;
        public static Map<String, Integer> bsw;

        public C1308c(int i) {
            int size = getSize(i);
            bst = new ConcurrentHashMap(size);
            bsw = new HashMap(size);
            bsu = new CopyOnWriteArrayList();
            bsv = i;
        }

        public static void b(String str, c cVar) {
            if (bst == null) {
                bst = new ConcurrentHashMap(getSize(bsv));
            }
            if (bsu == null) {
                bsu = new CopyOnWriteArrayList();
            }
            if (bst.containsKey(str)) {
                bsu.remove(str);
                bsu.add(str);
            } else {
                bsu.add(str);
            }
            bst.put(str, cVar);
            if (bst.size() > bsv) {
                Integer num = bsw.get(bsu.get(0));
                if (num != null && num.intValue() != 2) {
                    gq(bsv + 1);
                    return;
                }
                c cVar2 = bst.get(bsu.get(0));
                if (cVar2 != null) {
                    cVar2.release();
                }
                bst.remove(bsu.get(0));
                bsu.remove(0);
            }
        }

        private static int getSize(int i) {
            return (int) ((i / 0.75f) + 1.0f);
        }

        private static void gq(int i) {
            com.kwad.sdk.utils.a.d.bsx.i("Ks_UnionKv", "reSize:" + i);
            bsv = i;
        }

        public static c iz(String str) {
            if (bst == null) {
                bst = new ConcurrentHashMap(getSize(bsv));
            }
            if (bsu == null) {
                bsu = new CopyOnWriteArrayList();
            }
            c cVar = bst.get(str);
            if (cVar == null) {
                return null;
            }
            bsu.remove(str);
            bsu.add(str);
            return cVar;
        }

        public static void remove(String str) {
            List<String> list = bsu;
            if (list != null) {
                list.remove(str);
            }
            Map<String, c> map = bst;
            if (map != null) {
                map.remove(str);
            }
        }
    }

    public interface d {
        void a(String str, Exception exc);

        void e(String str, Throwable th);

        void i(String str, String str2);
    }

    public static class e implements Comparable<e> {
        int end;
        int start;

        public e(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(e eVar) {
            return this.start - eVar.start;
        }
    }

    static {
        int iXF = h.XF();
        PAGE_SIZE = iXF;
        brP = iXF - 192;
        int iMax = Math.max(iXF << 1, 16384);
        brQ = iMax;
        brR = iMax << 1;
    }

    public c(String str, String str2, b[] bVarArr, int i) {
        this.apn = str;
        this.name = str2;
        this.bsm = i;
        HashMap map = new HashMap();
        g gVar = g.bsE;
        map.put(gVar.XD(), gVar);
        if (bVarArr != null && bVarArr.length > 0) {
            for (b bVar : bVarArr) {
                String strXD = bVar.XD();
                if (map.containsKey(strXD)) {
                    iy("duplicate encoder tag:" + strXD);
                } else {
                    map.put(strXD, bVar);
                }
            }
        }
        this.brS = map;
        synchronized (this.bsd) {
            com.kwad.sdk.utils.a.d.getExecutor().execute(new Runnable() { // from class: com.kwad.sdk.utils.a.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.Xk();
                }
            });
            while (!this.bse) {
                try {
                    this.bsd.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    private int M(int i, int i2) {
        if (i2 > 536870912) {
            IllegalStateException illegalStateException = new IllegalStateException("data size out of limit");
            if (com.kwad.library.a.a.pe.booleanValue()) {
                throw illegalStateException;
            }
            z(illegalStateException);
        }
        int i3 = PAGE_SIZE;
        if (i2 <= i3) {
            return i3;
        }
        while (i < i2) {
            int i4 = brQ;
            i = i <= i4 ? i << 1 : i + i4;
        }
        return i;
    }

    private void N(int i, int i2) {
        this.bsk += i2 - i;
        ArrayList<e> arrayList = this.bsl;
        if (arrayList != null) {
            arrayList.add(new e(i, i2));
        }
    }

    private void XA() {
        ArrayList<e> arrayList = this.bsl;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size() - 1;
        e eVar = this.bsl.get(size);
        while (size > 0) {
            size--;
            e eVar2 = this.bsl.get(size);
            if (eVar.start == eVar2.end) {
                eVar2.end = eVar.end;
                this.bsl.remove(size + 1);
            }
            eVar = eVar2;
        }
    }

    private void XB() {
        this.bsk = 0;
        ArrayList<e> arrayList = this.bsl;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Xk() {
        synchronized (this.bsd) {
            this.bse = true;
            this.bsd.notify();
        }
        long jNanoTime = System.nanoTime();
        if (!Xn() && this.bsm == 0) {
            Xl();
        }
        if (this.bsa == null) {
            this.bsa = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
        }
        if (this.brT != null) {
            info("loading finish, data len:" + this.bsb + ", get keys:" + this.bsd.size() + ", use time:" + ((System.nanoTime() - jNanoTime) / 1000000) + " ms");
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0110  */
    /* JADX WARN: Code duplicated, block: B:49:0x019b  */
    private void Xl() {
        boolean z;
        boolean z2;
        File file = new File(this.apn, this.name + ".kva");
        File file2 = new File(this.apn, this.name + ".kvb");
        try {
            if (h.ag(file) && h.ag(file2)) {
                this.brW = new RandomAccessFile(file, "rw");
                this.brX = new RandomAccessFile(file2, "rw");
                long length = this.brW.length();
                long length2 = this.brX.length();
                this.brU = this.brW.getChannel();
                this.brV = this.brX.getChannel();
                try {
                    MappedByteBuffer map = this.brU.map(FileChannel.MapMode.READ_WRITE, 0L, length > 0 ? length : PAGE_SIZE);
                    this.brY = map;
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    MappedByteBuffer map2 = this.brV.map(FileChannel.MapMode.READ_WRITE, 0L, length2 > 0 ? length2 : PAGE_SIZE);
                    this.brZ = map2;
                    map2.order(byteOrder);
                    this.bsa = new com.kwad.sdk.utils.a.b(this.brY.capacity());
                    if (length == 0 && length2 == 0) {
                        this.bsb = 12;
                        return;
                    }
                    int i = this.brY.getInt();
                    long j = this.brY.getLong();
                    int i2 = this.brZ.getInt();
                    long j2 = this.brZ.getLong();
                    if (i < 0 || i > length - 12) {
                        z = false;
                    } else {
                        this.bsb = i + 12;
                        this.brY.rewind();
                        this.brY.get(this.bsa.brM, 0, this.bsb);
                        if (j == this.bsa.L(12, i) && Xo() == 0) {
                            this.bsc = j;
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    if (z) {
                        if (length == length2 && Xm()) {
                            return;
                        }
                        g(new Exception("B file error"));
                        a(this.brY, this.brZ, this.bsb);
                        return;
                    }
                    if (i2 < 0 || i2 > length2 - 12) {
                        z2 = false;
                    } else {
                        this.bsd.clear();
                        XB();
                        this.bsb = i2 + 12;
                        if (this.bsa.brM.length != this.brZ.capacity()) {
                            this.bsa = new com.kwad.sdk.utils.a.b(this.brZ.capacity());
                        }
                        this.brZ.rewind();
                        this.brZ.get(this.bsa.brM, 0, this.bsb);
                        if (j2 == this.bsa.L(12, i2) && Xo() == 0) {
                            g(new Exception("A file error"));
                            a(this.brZ, this.brY, this.bsb);
                            this.bsc = j2;
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    }
                    if (z2) {
                        return;
                    }
                    iy("both files error");
                    Xu();
                    return;
                } catch (IOException e2) {
                    z(e2);
                    Xt();
                    j(file, file2);
                    return;
                }
            }
            z(new Exception("open file failed"));
            Xt();
        } catch (Throwable th) {
            z(th);
            Xv();
            Xt();
        }
    }

    private boolean Xm() {
        com.kwad.sdk.utils.a.b bVar = new com.kwad.sdk.utils.a.b(this.bsb);
        MappedByteBuffer mappedByteBuffer = this.brZ;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.rewind();
            this.brZ.get(bVar.brM, 0, this.bsb);
        }
        com.kwad.sdk.utils.a.b bVar2 = this.bsa;
        if (bVar2 == null) {
            return true;
        }
        byte[] bArr = bVar2.brM;
        byte[] bArr2 = bVar.brM;
        for (int i = 0; i < this.bsb; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean Xn() {
        File file = new File(this.apn, this.name + ".kvc");
        File file2 = new File(this.apn, this.name + ".tmp");
        boolean z = false;
        try {
            if (!file.exists()) {
                file = file2.exists() ? file2 : null;
            }
            if (file != null) {
                if (!af(file)) {
                    Xv();
                    Xs();
                    return false;
                }
                if (this.bsm != 0) {
                    return false;
                }
                if (!a(this.bsa)) {
                    this.bsm = 1;
                    return false;
                }
                info("recover from c file");
                try {
                    Xs();
                    return true;
                } catch (Exception e2) {
                    e = e2;
                    z = true;
                    z(e);
                    return z;
                }
            }
            if (this.bsm == 0) {
                return false;
            }
            File file3 = new File(this.apn, this.name + ".kva");
            File file4 = new File(this.apn, this.name + ".kvb");
            if (!file3.exists() || !file4.exists()) {
                return false;
            }
            j(file3, file4);
            return false;
        } catch (Exception e3) {
            e = e3;
        }
    }

    private int Xo() {
        com.kwad.sdk.utils.a.b bVar = this.bsa;
        bVar.position = 12;
        while (true) {
            try {
                int i = bVar.position;
                int i2 = this.bsb;
                if (i >= i2) {
                    if (i == i2) {
                        return 0;
                    }
                    g(new Exception("parse dara failed"));
                    return -1;
                }
                byte b2 = bVar.get();
                byte b3 = (byte) (b2 & 63);
                if (b3 <= 0 || b3 > 8) {
                    throw new Exception("parse dara failed");
                }
                int i3 = bVar.get() & 255;
                if (b2 < 0) {
                    bVar.position += i3;
                    int i4 = b3 <= 5 ? brN[b3] : bVar.getShort() & 65535;
                    com.kwad.sdk.utils.a.b bVar2 = this.bsa;
                    int i5 = bVar2.position + i4;
                    bVar2.position = i5;
                    N(i, i5);
                } else {
                    String string = bVar.getString(i3);
                    int i6 = bVar.position;
                    boolean z = true;
                    if (b3 > 5) {
                        int i7 = 65535 & bVar.getShort();
                        if ((b2 & SignedBytes.f32242a) == 0) {
                            z = false;
                        }
                        f(i7, z);
                        if (b3 == 6) {
                            this.bsd.put(string, new com.kwad.sdk.utils.a.a.i(i, i6 + 2, z ? bVar.gi(i7) : bVar.getString(i7), i7, z));
                        } else if (b3 == 7) {
                            this.bsd.put(string, new com.kwad.sdk.utils.a.a.C1307a(i, i6 + 2, z ? bVar.getString(i7) : bVar.getBytes(i7), i7, z));
                        } else if (z) {
                            this.bsd.put(string, new com.kwad.sdk.utils.a.a.h(i, i6 + 2, bVar.getString(i7), i7, true));
                        } else {
                            int i8 = bVar.get() & 255;
                            String string2 = bVar.getString(i8);
                            b bVar3 = this.brS.get(string2);
                            int i9 = i7 - (i8 + 1);
                            if (i9 < 0) {
                                throw new Exception("parse dara failed");
                            }
                            if (bVar3 != null) {
                                try {
                                    Object objF = bVar3.f(bVar.brM, bVar.position, i9);
                                    if (objF != null) {
                                        this.bsd.put(string, new com.kwad.sdk.utils.a.a.h(i, i6 + 2, objF, i7, false));
                                    }
                                } catch (Exception e2) {
                                    z(e2);
                                }
                            } else {
                                iy("object with tag: " + string2 + " without encoder");
                            }
                            bVar.position += i9;
                        }
                    } else if (b3 == 1) {
                        this.bsd.put(string, new com.kwad.sdk.utils.a.a.c(i6, bVar.get() == 1));
                    } else if (b3 == 2) {
                        this.bsd.put(string, new com.kwad.sdk.utils.a.a.f(i6, bVar.getInt()));
                    } else if (b3 == 3) {
                        this.bsd.put(string, new com.kwad.sdk.utils.a.a.e(i6, bVar.getFloat()));
                    } else if (b3 != 4) {
                        this.bsd.put(string, new com.kwad.sdk.utils.a.a.d(i6, bVar.getDouble()));
                    } else {
                        this.bsd.put(string, new com.kwad.sdk.utils.a.a.g(i6, bVar.getLong()));
                    }
                }
            } catch (Exception e3) {
                g(e3);
                return -1;
            }
        }
    }

    private void Xp() {
        if (this.bsm == 0 || !this.bsn) {
            return;
        }
        Xq();
    }

    private boolean Xq() {
        int i = this.bsm;
        if (i == 1) {
            Executor executor = this.bso;
            if (executor != null) {
                executor.execute(new Runnable() { // from class: com.kwad.sdk.utils.a.c.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.this.Xr();
                    }
                });
            }
        } else if (i == 2) {
            return Xr();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean Xr() {
        try {
            File file = new File(this.apn, this.name + ".tmp");
            if (h.ag(file)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.setLength(this.bsb);
                randomAccessFile.write(this.bsa.brM, 0, this.bsb);
                randomAccessFile.close();
                File file2 = new File(this.apn, this.name + ".kvc");
                if (!file2.exists() || file2.delete()) {
                    if (file.renameTo(file2)) {
                        return true;
                    }
                    g(new Exception("rename failed"));
                }
            }
        } catch (Exception e2) {
            z(e2);
        }
        return false;
    }

    private void Xs() {
        try {
            h.h(new File(this.apn, this.name + ".kvc"));
            h.h(new File(this.apn, this.name + ".tmp"));
        } catch (Exception e2) {
            z(e2);
        }
    }

    private void Xt() {
        this.bsm = 1;
        h.closeQuietly(this.brU);
        h.closeQuietly(this.brV);
        this.brU = null;
        this.brV = null;
        this.brY = null;
        this.brZ = null;
    }

    private void Xu() {
        if (this.bsm == 0) {
            try {
                a(this.brY);
                a(this.brZ);
            } catch (Throwable unused) {
                Xt();
            }
        }
        Xv();
        h.h(new File(this.apn + this.name));
    }

    private void Xv() {
        this.bsb = 12;
        this.bsc = 0L;
        XB();
        this.bsd.clear();
        com.kwad.sdk.utils.a.b bVar = this.bsa;
        if (bVar == null || bVar.brM.length != PAGE_SIZE) {
            this.bsa = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
        } else {
            bVar.J(0, 0);
            this.bsa.h(4, 0L);
        }
    }

    private void Xw() {
        com.kwad.sdk.utils.a.b bVar;
        com.kwad.sdk.utils.a.b bVar2 = this.bsa;
        if (bVar2 != null) {
            this.bsc ^= bVar2.L(this.bsf, this.bsg);
        }
        if (this.bsm == 0) {
            MappedByteBuffer mappedByteBuffer = this.brY;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putInt(0, -1);
                b(this.brY);
                this.brY.putInt(0, this.bsb - 12);
            }
            MappedByteBuffer mappedByteBuffer2 = this.brZ;
            if (mappedByteBuffer2 != null) {
                b(mappedByteBuffer2);
            }
        } else {
            if (this.bsi && (bVar = this.bsa) != null) {
                bVar.J(0, this.bsb - 12);
            }
            com.kwad.sdk.utils.a.b bVar3 = this.bsa;
            if (bVar3 != null) {
                bVar3.h(4, this.bsc);
            }
        }
        this.bsi = false;
        this.bsh = 0;
        this.bsg = 0;
    }

    private int Xx() {
        int i = this.bsb;
        if (i <= 16384) {
            return 4096;
        }
        return i <= 65536 ? 8192 : 16384;
    }

    private void Xy() {
        gn(this.bsg);
        int i = this.bsb;
        this.bsf = i;
        this.bsb = this.bsg + i;
        com.kwad.sdk.utils.a.b bVar = this.bsa;
        if (bVar != null) {
            bVar.position = i;
        }
        this.bsi = true;
    }

    private void Xz() {
        if (this.bsk < (Xx() << 1)) {
            if (this.bsl.size() < (this.bsb < 16384 ? 80 : 160)) {
                return;
            }
        }
        go(0);
    }

    private boolean af(File file) {
        long length = file.length();
        if (length != 0 && length <= 536870912) {
            int i = (int) length;
            int iM = M(PAGE_SIZE, i);
            com.kwad.sdk.utils.a.b bVar = this.bsa;
            if (bVar == null || bVar.brM.length != iM) {
                bVar = new com.kwad.sdk.utils.a.b(new byte[iM]);
                this.bsa = bVar;
            } else {
                bVar.position = 0;
            }
            h.a(file, bVar.brM, i);
            int i2 = bVar.getInt();
            long j = bVar.getLong();
            this.bsb = i2 + 12;
            if (i2 >= 0 && i2 <= i - 12 && j == bVar.L(12, i2) && Xo() == 0) {
                this.bsc = j;
                return true;
            }
        }
        return false;
    }

    private static void f(int i, boolean z) {
        if (z) {
            if (i != 32) {
                throw new IllegalStateException("name size not match");
            }
        } else if (i < 0 || i >= 2048) {
            throw new IllegalStateException("value size out of bound");
        }
    }

    private static long g(long j, int i) {
        int i2 = (i & 7) << 3;
        return (j >>> (64 - i2)) | (j << i2);
    }

    private void g(Exception exc) {
        d dVar = this.brT;
        if (dVar != null) {
            dVar.a(this.name, exc);
        }
    }

    private static void gm(int i) {
        if (i > 255) {
            throw new IllegalArgumentException("key's length must less than 256");
        }
    }

    private void gn(int i) {
        if (this.bsa == null) {
            this.bsa = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
        }
        int length = this.bsa.brM.length;
        int i2 = this.bsb + i;
        if (i2 >= length) {
            int i3 = this.bsk;
            if (i3 > i && i3 > Xx()) {
                go(i);
                return;
            }
            int iM = M(length, i2);
            byte[] bArr = new byte[iM];
            System.arraycopy(this.bsa.brM, 0, bArr, 0, this.bsb);
            this.bsa.brM = bArr;
            if (this.bsm == 0) {
                try {
                    long j = iM;
                    MappedByteBuffer map = this.brU.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                    this.brY = map;
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    MappedByteBuffer map2 = this.brV.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                    this.brZ = map2;
                    map2.order(byteOrder);
                } catch (Throwable th) {
                    z(new Exception("map failed", th));
                    this.bsa.J(0, this.bsb - 12);
                    this.bsa.h(4, this.bsc);
                    Xt();
                }
            }
        }
    }

    private void go(int i) {
        int i2;
        ArrayList<e> arrayList = this.bsl;
        if (arrayList == null || this.bsa == null) {
            return;
        }
        Collections.sort(arrayList);
        XA();
        e eVar = this.bsl.get(0);
        int i3 = eVar.start;
        int i4 = this.bsb;
        int i5 = i4 - this.bsk;
        int i6 = i5 - 12;
        int i7 = i5 - i3;
        int i8 = i4 - i3;
        boolean z = i6 < i8 + i7;
        if (!z) {
            this.bsc ^= this.bsa.L(i3, i8);
        }
        int size = this.bsl.size();
        int i9 = size - 1;
        int i10 = this.bsb - this.bsl.get(i9).end;
        int[] iArr = new int[(i10 > 0 ? size : i9) << 1];
        int i11 = eVar.start;
        int i12 = eVar.end;
        for (int i13 = 1; i13 < size; i13++) {
            e eVar2 = this.bsl.get(i13);
            int i14 = eVar2.start - i12;
            byte[] bArr = this.bsa.brM;
            System.arraycopy(bArr, i12, bArr, i11, i14);
            int i15 = (i13 - 1) << 1;
            iArr[i15] = i12;
            iArr[i15 + 1] = i12 - i11;
            i11 += i14;
            i12 = eVar2.end;
        }
        if (i10 > 0) {
            byte[] bArr2 = this.bsa.brM;
            System.arraycopy(bArr2, i12, bArr2, i11, i10);
            int i16 = i9 << 1;
            iArr[i16] = i12;
            iArr[i16 + 1] = i12 - i11;
        }
        XB();
        if (z) {
            this.bsc = this.bsa.L(12, i6);
        } else {
            this.bsc ^= this.bsa.L(i3, i7);
        }
        this.bsb = i5;
        if (this.bsm == 0) {
            MappedByteBuffer mappedByteBuffer = this.brY;
            if (mappedByteBuffer != null) {
                i2 = 0;
                mappedByteBuffer.putInt(0, -1);
                this.brY.putLong(4, this.bsc);
                this.brY.position(i3);
                this.brY.put(this.bsa.brM, i3, i7);
                this.brY.putInt(0, i6);
            } else {
                i2 = 0;
            }
            MappedByteBuffer mappedByteBuffer2 = this.brZ;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putInt(i2, i6);
                this.brZ.putLong(4, this.bsc);
                this.brZ.position(i3);
                this.brZ.put(this.bsa.brM, i3, i7);
            }
        } else {
            this.bsa.J(0, i6);
            this.bsa.h(4, this.bsc);
        }
        a(i3, iArr);
        int i17 = i5 + i;
        if (this.bsa.brM.length - i17 > brR) {
            gp(i17);
        }
        info("gc finish");
    }

    private void gp(int i) {
        int i2 = PAGE_SIZE;
        int iM = M(i2, i + i2);
        com.kwad.sdk.utils.a.b bVar = this.bsa;
        if (bVar != null) {
            byte[] bArr = bVar.brM;
            if (iM >= bArr.length) {
                return;
            }
            byte[] bArr2 = new byte[iM];
            System.arraycopy(bArr, 0, bArr2, 0, this.bsb);
            this.bsa.brM = bArr2;
        }
        if (this.bsm == 0) {
            try {
                long j = iM;
                this.brU.truncate(j);
                MappedByteBuffer map = this.brU.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.brY = map;
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                map.order(byteOrder);
                this.brV.truncate(j);
                MappedByteBuffer map2 = this.brV.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.brZ = map2;
                map2.order(byteOrder);
            } catch (Throwable th) {
                z(new Exception("map failed", th));
                Xt();
            }
        }
        info("truncate finish");
    }

    private void info(String str) {
        d dVar = this.brT;
        if (dVar != null) {
            dVar.i(this.name, str);
        }
    }

    private static void ix(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("key is empty");
        }
    }

    private void iy(String str) {
        d dVar = this.brT;
        if (dVar != null) {
            dVar.e(this.name, new Exception(str));
        }
    }

    private void j(File file, File file2) {
        try {
            if (af(file)) {
                return;
            }
        } catch (IOException e2) {
            g(e2);
        }
        Xv();
        try {
            if (af(file2)) {
                return;
            }
        } catch (Exception e3) {
            g(e3);
        }
        Xv();
    }

    private synchronized void putDouble(String str, double d2) {
        ix(str);
        com.kwad.sdk.utils.a.a.d dVar = (com.kwad.sdk.utils.a.a.d) this.bsd.get(str);
        if (dVar != null) {
            if (dVar.value != d2) {
                long jDoubleToRawLongBits = Double.doubleToRawLongBits(d2);
                long jDoubleToRawLongBits2 = Double.doubleToRawLongBits(dVar.value) ^ jDoubleToRawLongBits;
                dVar.value = d2;
                b(jDoubleToRawLongBits, jDoubleToRawLongBits2, dVar.offset);
                Xp();
            }
            return;
        }
        a(str, (byte) 5);
        com.kwad.sdk.utils.a.b bVar = this.bsa;
        if (bVar != null) {
            int i = bVar.position;
            bVar.bg(Double.doubleToRawLongBits(d2));
            Xw();
            Map<String, com.kwad.sdk.utils.a.a.b> map = this.bsd;
            if (map != null) {
                map.put(str, new com.kwad.sdk.utils.a.a.d(i, d2));
            }
        }
        Xp();
    }

    private synchronized void putFloat(String str, float f) {
        ix(str);
        com.kwad.sdk.utils.a.a.e eVar = (com.kwad.sdk.utils.a.a.e) this.bsd.get(str);
        if (eVar != null) {
            if (eVar.value != f) {
                int iFloatToRawIntBits = Float.floatToRawIntBits(f);
                long jFloatToRawIntBits = ((long) (Float.floatToRawIntBits(eVar.value) ^ iFloatToRawIntBits)) & 4294967295L;
                eVar.value = f;
                b(iFloatToRawIntBits, jFloatToRawIntBits, eVar.offset);
                Xp();
            }
            return;
        }
        a(str, (byte) 3);
        com.kwad.sdk.utils.a.b bVar = this.bsa;
        if (bVar != null) {
            int i = bVar.position;
            bVar.gf(Float.floatToRawIntBits(f));
            Xw();
            Map<String, com.kwad.sdk.utils.a.a.b> map = this.bsd;
            if (map != null) {
                map.put(str, new com.kwad.sdk.utils.a.a.e(i, f));
            }
        }
        Xp();
    }

    private synchronized void putStringSet(String str, Set<String> set) {
        try {
            if (set == null) {
                remove(str);
            } else {
                a(str, set, g.bsE);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void u(String str, int i) {
        com.kwad.sdk.utils.a.b bVar = this.bsa;
        if (bVar == null) {
            return;
        }
        bVar.e((byte) i);
        if (i != str.length()) {
            this.bsa.it(str);
            return;
        }
        com.kwad.sdk.utils.a.b bVar2 = this.bsa;
        a(str, 0, i, bVar2.brM, bVar2.position);
        this.bsa.position += i;
    }

    private void updateBytes(int i, byte[] bArr) {
        int length = bArr.length;
        com.kwad.sdk.utils.a.b bVar = this.bsa;
        if (bVar != null) {
            this.bsc ^= bVar.L(i, length);
            com.kwad.sdk.utils.a.b bVar2 = this.bsa;
            bVar2.position = i;
            bVar2.p(bArr);
            this.bsc ^= this.bsa.L(i, length);
        }
        if (this.bsm != 0) {
            com.kwad.sdk.utils.a.b bVar3 = this.bsa;
            if (bVar3 != null) {
                bVar3.h(4, this.bsc);
                return;
            }
            return;
        }
        MappedByteBuffer mappedByteBuffer = this.brY;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.putInt(0, -1);
            this.brY.putLong(4, this.bsc);
            this.brY.position(i);
            this.brY.put(bArr);
            this.brY.putInt(0, this.bsb - 12);
        }
        MappedByteBuffer mappedByteBuffer2 = this.brZ;
        if (mappedByteBuffer2 != null) {
            mappedByteBuffer2.putLong(4, this.bsc);
            this.brZ.position(i);
            this.brZ.put(bArr);
        }
    }

    private void v(String str, int i) {
        com.kwad.sdk.utils.a.b bVar = this.bsa;
        if (bVar == null) {
            return;
        }
        bVar.a((short) i);
        if (i != str.length()) {
            this.bsa.it(str);
        } else {
            com.kwad.sdk.utils.a.b bVar2 = this.bsa;
            a(str, 0, i, bVar2.brM, bVar2.position);
        }
    }

    private void z(Throwable th) {
        d dVar = this.brT;
        if (dVar != null) {
            dVar.e(this.name, th);
        }
    }

    public final synchronized boolean contains(String str) {
        return this.bsd.containsKey(str);
    }

    public final synchronized Map<String, Object> getAll() {
        Object objValueOf;
        int size = this.bsd.size();
        if (size == 0) {
            return new HashMap();
        }
        HashMap map = new HashMap(((size * 4) / 3) + 1);
        for (Map.Entry<String, com.kwad.sdk.utils.a.a.b> entry : this.bsd.entrySet()) {
            String key = entry.getKey();
            com.kwad.sdk.utils.a.a.b value = entry.getValue();
            switch (value.Xi()) {
                case 1:
                    objValueOf = Boolean.valueOf(((com.kwad.sdk.utils.a.a.c) value).value);
                    break;
                case 2:
                    objValueOf = Integer.valueOf(((com.kwad.sdk.utils.a.a.f) value).value);
                    break;
                case 3:
                    objValueOf = Float.valueOf(((com.kwad.sdk.utils.a.a.e) value).value);
                    break;
                case 4:
                    objValueOf = Long.valueOf(((com.kwad.sdk.utils.a.a.g) value).value);
                    break;
                case 5:
                    objValueOf = Double.valueOf(((com.kwad.sdk.utils.a.a.d) value).value);
                    break;
                case 6:
                    com.kwad.sdk.utils.a.a.i iVar = (com.kwad.sdk.utils.a.a.i) value;
                    objValueOf = iVar.brK ? a(iVar) : iVar.value;
                    break;
                case 7:
                    com.kwad.sdk.utils.a.a.C1307a c1307a = (com.kwad.sdk.utils.a.a.C1307a) value;
                    objValueOf = c1307a.brK ? a(c1307a) : c1307a.value;
                    break;
                case 8:
                    com.kwad.sdk.utils.a.a.h hVar = (com.kwad.sdk.utils.a.a.h) value;
                    objValueOf = hVar.brK ? a(hVar) : ((com.kwad.sdk.utils.a.a.h) value).value;
                    break;
                default:
                    objValueOf = null;
                    break;
            }
            map.put(key, objValueOf);
        }
        return map;
    }

    public final synchronized boolean getBoolean(String str, boolean z) {
        com.kwad.sdk.utils.a.a.c cVar = (com.kwad.sdk.utils.a.a.c) this.bsd.get(str);
        if (cVar == null) {
            return z;
        }
        return cVar.value;
    }

    public final synchronized int getInt(String str, int i) {
        com.kwad.sdk.utils.a.a.f fVar = (com.kwad.sdk.utils.a.a.f) this.bsd.get(str);
        if (fVar == null) {
            return i;
        }
        return fVar.value;
    }

    public final synchronized long getLong(String str, long j) {
        com.kwad.sdk.utils.a.a.g gVar = (com.kwad.sdk.utils.a.a.g) this.bsd.get(str);
        if (gVar == null) {
            return j;
        }
        return gVar.value;
    }

    public final synchronized String getString(String str, String str2) {
        com.kwad.sdk.utils.a.a.i iVar = (com.kwad.sdk.utils.a.a.i) this.bsd.get(str);
        if (iVar == null) {
            return str2;
        }
        if (iVar.brK) {
            return a(iVar);
        }
        return (String) iVar.value;
    }

    public final void putAll(Map<String, Object> map) {
        a(map, (Map<Class, b>) null);
    }

    public final synchronized void putBoolean(String str, boolean z) {
        ix(str);
        com.kwad.sdk.utils.a.a.c cVar = (com.kwad.sdk.utils.a.a.c) this.bsd.get(str);
        if (cVar != null) {
            if (cVar.value != z) {
                cVar.value = z;
                a((byte) (z ? 1 : 0), cVar.offset);
                Xp();
            }
            return;
        }
        a(str, (byte) 1);
        com.kwad.sdk.utils.a.b bVar = this.bsa;
        if (bVar != null) {
            int i = bVar.position;
            bVar.e((byte) (z ? 1 : 0));
            Xw();
            Map<String, com.kwad.sdk.utils.a.a.b> map = this.bsd;
            if (map != null) {
                map.put(str, new com.kwad.sdk.utils.a.a.c(i, z));
            }
        }
        Xp();
    }

    public final synchronized void putInt(String str, int i) {
        ix(str);
        com.kwad.sdk.utils.a.a.f fVar = (com.kwad.sdk.utils.a.a.f) this.bsd.get(str);
        if (fVar != null) {
            int i2 = fVar.value;
            if (i2 != i) {
                fVar.value = i;
                b(i, ((long) (i2 ^ i)) & 4294967295L, fVar.offset);
                Xp();
            }
            return;
        }
        a(str, (byte) 2);
        com.kwad.sdk.utils.a.b bVar = this.bsa;
        if (bVar != null) {
            int i3 = bVar.position;
            bVar.gf(i);
            Xw();
            Map<String, com.kwad.sdk.utils.a.a.b> map = this.bsd;
            if (map != null) {
                map.put(str, new com.kwad.sdk.utils.a.a.f(i3, i));
            }
        }
        Xp();
    }

    public final synchronized void putLong(String str, long j) {
        ix(str);
        com.kwad.sdk.utils.a.a.g gVar = (com.kwad.sdk.utils.a.a.g) this.bsd.get(str);
        if (gVar != null) {
            long j2 = gVar.value;
            if (j2 != j) {
                gVar.value = j;
                b(j, j ^ j2, gVar.offset);
                Xp();
            }
            return;
        }
        a(str, (byte) 4);
        com.kwad.sdk.utils.a.b bVar = this.bsa;
        if (bVar != null) {
            int i = bVar.position;
            bVar.bg(j);
            Xw();
            Map<String, com.kwad.sdk.utils.a.a.b> map = this.bsd;
            if (map != null) {
                map.put(str, new com.kwad.sdk.utils.a.a.g(i, j));
            }
        }
        Xp();
    }

    public final synchronized void putString(String str, String str2) {
        byte[] bArrIw;
        byte[] bArr;
        byte[] bArr2;
        ix(str);
        if (str2 == null) {
            remove(str);
            return;
        }
        com.kwad.sdk.utils.a.a.i iVar = (com.kwad.sdk.utils.a.a.i) this.bsd.get(str);
        if (str2.length() * 3 < 2048) {
            a(str, str2, iVar);
            return;
        }
        if (!str2.isEmpty()) {
            if (iVar == null && str2.length() < 2048) {
                int iIu = com.kwad.sdk.utils.a.b.iu(str2);
                bArr = new byte[iIu];
                if (iIu == str2.length()) {
                    a(str2, 0, iIu, bArr, 0);
                    bArr2 = bArr;
                } else {
                    bArrIw = com.kwad.sdk.utils.a.b.iw(str2);
                }
            } else if (iVar == null || iVar.brK) {
                bArrIw = com.kwad.sdk.utils.a.b.iw(str2);
            } else {
                int iIu2 = com.kwad.sdk.utils.a.b.iu(str2);
                bArr = new byte[iIu2];
                if (iIu2 == str2.length()) {
                    a(str2, 0, iIu2, bArr, 0);
                    bArr2 = bArr;
                } else {
                    bArrIw = com.kwad.sdk.utils.a.b.iw(str2);
                }
            }
            a(str, str2, bArr2, iVar, (byte) 6);
        }
        bArrIw = brO;
        bArr2 = bArrIw;
        a(str, str2, bArr2, iVar, (byte) 6);
    }

    public final void release() {
        h.closeQuietly(this.brW);
        h.closeQuietly(this.brX);
        h.closeQuietly(this.brU);
        h.closeQuietly(this.brV);
        this.brU = null;
        this.brV = null;
        this.brY = null;
        this.brZ = null;
        String str = this.apn + this.name;
        C1308c c1308c = a.bsr;
        C1308c.remove(str);
    }

    public final synchronized void remove(String str) {
        com.kwad.sdk.utils.a.a.b bVar = this.bsd.get(str);
        if (bVar != null) {
            this.bsd.remove(str);
            byte bXi = bVar.Xi();
            String str2 = null;
            if (bXi <= 5) {
                int iIu = com.kwad.sdk.utils.a.b.iu(str);
                int i = bVar.offset;
                a(bXi, i - (iIu + 2), i + brN[bXi]);
            } else {
                com.kwad.sdk.utils.a.a.j jVar = (com.kwad.sdk.utils.a.a.j) bVar;
                a(bXi, jVar.start, jVar.offset + jVar.brJ);
                if (jVar.brK) {
                    str2 = (String) jVar.value;
                }
            }
            byte b2 = (byte) (bXi | UnsignedBytes.f32243a);
            if (this.bsm == 0) {
                MappedByteBuffer mappedByteBuffer = this.brY;
                if (mappedByteBuffer != null) {
                    mappedByteBuffer.putLong(4, this.bsc);
                    this.brY.put(this.bsh, b2);
                }
                MappedByteBuffer mappedByteBuffer2 = this.brZ;
                if (mappedByteBuffer2 != null) {
                    mappedByteBuffer2.putLong(4, this.bsc);
                    this.brZ.put(this.bsh, b2);
                }
            } else {
                com.kwad.sdk.utils.a.b bVar2 = this.bsa;
                if (bVar2 != null) {
                    bVar2.h(4, this.bsc);
                }
            }
            this.bsh = 0;
            if (str2 != null) {
                h.h(new File(this.apn + this.name, str2));
            }
            Xz();
            Xp();
        }
    }

    public final synchronized String toString() {
        return "FastKV: path:" + this.apn + " name:" + this.name;
    }

    private boolean a(com.kwad.sdk.utils.a.b bVar) {
        int length = bVar.brM.length;
        File file = new File(this.apn, this.name + ".kva");
        File file2 = new File(this.apn, this.name + ".kvb");
        try {
            if (!h.ag(file) || !h.ag(file2)) {
                throw new Exception("open file failed");
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
            long j = length;
            randomAccessFile.setLength(j);
            randomAccessFile2.setLength(j);
            this.brU = randomAccessFile.getChannel();
            this.brV = randomAccessFile2.getChannel();
            MappedByteBuffer map = this.brU.map(FileChannel.MapMode.READ_WRITE, 0L, j);
            this.brY = map;
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            map.order(byteOrder);
            MappedByteBuffer map2 = this.brV.map(FileChannel.MapMode.READ_WRITE, 0L, j);
            this.brZ = map2;
            map2.order(byteOrder);
            this.brY.put(bVar.brM, 0, this.bsb);
            this.brZ.put(bVar.brM, 0, this.bsb);
            return true;
        } catch (Exception e2) {
            z(e2);
            return false;
        }
    }

    private synchronized void b(String str, byte[] bArr) {
        ix(str);
        if (bArr == null) {
            remove(str);
        } else {
            a(str, bArr, bArr, (com.kwad.sdk.utils.a.a.C1307a) this.bsd.get(str), (byte) 7);
        }
    }

    private void b(MappedByteBuffer mappedByteBuffer) {
        if (mappedByteBuffer == null) {
            return;
        }
        if (this.bsi && mappedByteBuffer != this.brY) {
            mappedByteBuffer.putInt(0, this.bsb - 12);
        }
        mappedByteBuffer.putLong(4, this.bsc);
        int i = this.bsh;
        if (i != 0) {
            mappedByteBuffer.put(i, this.bsa.brM[i]);
        }
        if (this.bsg != 0) {
            mappedByteBuffer.position(this.bsf);
            mappedByteBuffer.put(this.bsa.brM, this.bsf, this.bsg);
        }
    }

    private void b(int i, long j, int i2) {
        long jG = g(j, i2) ^ this.bsc;
        this.bsc = jG;
        if (this.bsm == 0) {
            MappedByteBuffer mappedByteBuffer = this.brY;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, jG);
                this.brY.putInt(i2, i);
            }
            MappedByteBuffer mappedByteBuffer2 = this.brZ;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.bsc);
                this.brZ.putInt(i2, i);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.bsa;
            if (bVar != null) {
                bVar.h(4, jG);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.bsa;
        if (bVar2 != null) {
            bVar2.J(i2, i);
        }
    }

    private void a(MappedByteBuffer mappedByteBuffer, MappedByteBuffer mappedByteBuffer2, int i) {
        if (mappedByteBuffer.capacity() != mappedByteBuffer2.capacity()) {
            try {
                MappedByteBuffer map = (mappedByteBuffer2 == this.brZ ? this.brV : this.brU).map(FileChannel.MapMode.READ_WRITE, 0L, mappedByteBuffer.capacity());
                map.order(ByteOrder.LITTLE_ENDIAN);
                if (mappedByteBuffer2 == this.brZ) {
                    this.brZ = map;
                } else {
                    this.brY = map;
                }
                mappedByteBuffer2 = map;
            } catch (Exception e2) {
                z(e2);
                Xt();
                return;
            }
        }
        mappedByteBuffer.rewind();
        mappedByteBuffer2.rewind();
        mappedByteBuffer.limit(i);
        mappedByteBuffer2.put(mappedByteBuffer);
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
    }

    private void b(long j, long j2, int i) {
        long jG = g(j2, i) ^ this.bsc;
        this.bsc = jG;
        if (this.bsm == 0) {
            MappedByteBuffer mappedByteBuffer = this.brY;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, jG);
                this.brY.putLong(i, j);
            }
            MappedByteBuffer mappedByteBuffer2 = this.brZ;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.bsc);
                this.brZ.putLong(i, j);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.bsa;
            if (bVar != null) {
                bVar.h(4, jG);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.bsa;
        if (bVar2 != null) {
            bVar2.h(i, j);
        }
    }

    private String a(com.kwad.sdk.utils.a.a.i iVar) {
        byte[] bytes;
        try {
            byte[] bArrAh = h.ah(new File(this.apn + this.name, (String) iVar.value));
            String str = new String(bArrAh);
            return (bArrAh == null || TextUtils.isEmpty(str) || (bytes = com.kwad.sdk.utils.a.b.j(bArrAh, com.kwad.sdk.utils.a.b.iu(str)).getBytes()) == null || bytes.length == 0) ? "" : new String(bytes, com.kwad.sdk.utils.a.b.UTF_8);
        } catch (Exception e2) {
            z(e2);
        }
        return "";
    }

    private int b(String str, byte[] bArr, byte b2) {
        a(str, b2, bArr.length + 2);
        com.kwad.sdk.utils.a.b bVar = this.bsa;
        if (bVar == null) {
            return 0;
        }
        bVar.a((short) bArr.length);
        com.kwad.sdk.utils.a.b bVar2 = this.bsa;
        int i = bVar2.position;
        bVar2.p(bArr);
        return i;
    }

    private byte[] a(com.kwad.sdk.utils.a.a.C1307a c1307a) {
        try {
            byte[] bArrAh = h.ah(new File(this.apn + this.name, (String) c1307a.value));
            return bArrAh != null ? bArrAh : brO;
        } catch (Exception e2) {
            z(e2);
            return brO;
        }
    }

    private Object a(com.kwad.sdk.utils.a.a.h hVar) {
        try {
            byte[] bArrAh = h.ah(new File(this.apn + this.name, (String) hVar.value));
            if (bArrAh != null) {
                int i = bArrAh[0] & 255;
                String str = new String(bArrAh, 1, i, com.kwad.sdk.utils.a.b.UTF_8);
                b bVar = this.brS.get(str);
                if (bVar != null) {
                    int i2 = i + 1;
                    return bVar.f(bArrAh, i2, bArrAh.length - i2);
                }
                g(new Exception("No encoder for tag:" + str));
                return null;
            }
            g(new Exception("Read object data failed"));
            return null;
        } catch (Exception e2) {
            z(e2);
            return null;
        }
    }

    private synchronized <T> void a(String str, T t, b<T> bVar) {
        byte[] bArrU;
        ix(str);
        if (bVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Encoder is null");
            if (!com.kwad.library.a.a.pe.booleanValue()) {
                z(illegalArgumentException);
                return;
            }
            throw illegalArgumentException;
        }
        String strXD = bVar.XD();
        if (!strXD.isEmpty() && strXD.length() <= 50) {
            if (!this.brS.containsKey(strXD)) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Encoder hasn't been registered");
                if (!com.kwad.library.a.a.pe.booleanValue()) {
                    z(illegalArgumentException2);
                    return;
                }
                throw illegalArgumentException2;
            }
            if (t == null) {
                remove(str);
                return;
            }
            try {
                bArrU = bVar.u(t);
            } catch (Exception e2) {
                z(e2);
                bArrU = null;
            }
            if (bArrU == null) {
                remove(str);
                return;
            }
            int iIu = com.kwad.sdk.utils.a.b.iu(strXD);
            com.kwad.sdk.utils.a.b bVar2 = new com.kwad.sdk.utils.a.b(iIu + 1 + bArrU.length);
            bVar2.e((byte) iIu);
            bVar2.it(strXD);
            bVar2.p(bArrU);
            a(str, t, bVar2.brM, (com.kwad.sdk.utils.a.a.h) this.bsd.get(str), (byte) 8);
            return;
        }
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Invalid encoder tag:" + strXD);
        if (!com.kwad.library.a.a.pe.booleanValue()) {
            z(illegalArgumentException3);
            return;
        }
        throw illegalArgumentException3;
    }

    private synchronized void a(Map<String, Object> map, Map<Class, b> map2) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null && !key.isEmpty()) {
                if (value instanceof String) {
                    putString(key, (String) value);
                } else if (value instanceof Boolean) {
                    putBoolean(key, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    putInt(key, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    putLong(key, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    putFloat(key, ((Float) value).floatValue());
                } else if (value instanceof Double) {
                    putDouble(key, ((Double) value).doubleValue());
                } else if (value instanceof Set) {
                    Set set = (Set) value;
                    if (!set.isEmpty() && (set.iterator().next() instanceof String)) {
                        putStringSet(key, (Set) value);
                    }
                } else if (value instanceof byte[]) {
                    b(key, (byte[]) value);
                } else {
                    g(new Exception("missing encoders"));
                }
            }
        }
    }

    private void a(MappedByteBuffer mappedByteBuffer) throws IOException {
        if (mappedByteBuffer == null) {
            return;
        }
        int iCapacity = mappedByteBuffer.capacity();
        int i = PAGE_SIZE;
        if (iCapacity != i) {
            FileChannel fileChannel = mappedByteBuffer == this.brY ? this.brU : this.brV;
            if (fileChannel == null) {
                return;
            }
            fileChannel.truncate(i);
            MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, i);
            map.order(ByteOrder.LITTLE_ENDIAN);
            if (mappedByteBuffer == this.brY) {
                this.brY = map;
            } else {
                this.brZ = map;
            }
            mappedByteBuffer = map;
        }
        mappedByteBuffer.putInt(0, 0);
        mappedByteBuffer.putLong(4, 0L);
    }

    private void a(String str, byte b2) {
        a(str, b2, brN[b2]);
    }

    private void a(String str, byte b2, int i) {
        int iIu = com.kwad.sdk.utils.a.b.iu(str);
        gm(iIu);
        this.bsg = iIu + 2 + i;
        Xy();
        com.kwad.sdk.utils.a.b bVar = this.bsa;
        if (bVar != null) {
            bVar.e(b2);
        }
        u(str, iIu);
    }

    private void a(byte b2, int i) {
        long jG = this.bsc ^ g(1L, i);
        this.bsc = jG;
        if (this.bsm == 0) {
            MappedByteBuffer mappedByteBuffer = this.brY;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, jG);
                this.brY.put(i, b2);
            }
            MappedByteBuffer mappedByteBuffer2 = this.brZ;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.bsc);
                this.brZ.put(i, b2);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.bsa;
            if (bVar != null) {
                bVar.h(4, jG);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.bsa;
        if (bVar2 != null) {
            bVar2.brM[i] = b2;
        }
    }

    private static void a(String str, int i, int i2, byte[] bArr, int i3) {
        int i4;
        if (i2 <= str.length() && i2 >= 0) {
            int i5 = 0;
            while (i5 < i2) {
                int i6 = i5 + 1;
                char cCharAt = str.charAt(i5);
                if (cCharAt < 128) {
                    i4 = i3 + 1;
                    bArr[i3] = (byte) (((byte) cCharAt) ^ 1);
                } else {
                    i4 = i3 + 1;
                    bArr[i3] = (byte) cCharAt;
                }
                i5 = i6;
                i3 = i4;
            }
        }
    }

    private void a(String str, String str2, com.kwad.sdk.utils.a.a.i iVar) {
        int iIu = com.kwad.sdk.utils.a.b.iu(str2);
        if (iVar == null) {
            int iIu2 = com.kwad.sdk.utils.a.b.iu(str);
            gm(iIu2);
            int i = iIu2 + 4;
            this.bsg = i + iIu;
            Xy();
            com.kwad.sdk.utils.a.b bVar = this.bsa;
            if (bVar != null) {
                bVar.e((byte) 6);
            }
            u(str, iIu2);
            v(str2, iIu);
            Map<String, com.kwad.sdk.utils.a.a.b> map = this.bsd;
            int i2 = this.bsf;
            map.put(str, new com.kwad.sdk.utils.a.a.i(i2, i2 + i, str2, iIu, false));
            Xw();
        } else {
            int i3 = iVar.offset;
            int i4 = i3 - iVar.start;
            int i5 = iVar.brJ;
            boolean z = false;
            String str3 = null;
            if (i5 == iIu) {
                this.bsc ^= this.bsa.L(i3, i5);
                if (iIu == str2.length()) {
                    a(str2, 0, iIu, this.bsa.brM, iVar.offset);
                } else {
                    com.kwad.sdk.utils.a.b bVar2 = this.bsa;
                    if (bVar2 != null) {
                        bVar2.position = iVar.offset;
                        bVar2.it(str2);
                    }
                }
                this.bsf = iVar.offset;
                this.bsg = iIu;
            } else {
                this.bsg = i4 + iIu;
                Xy();
                com.kwad.sdk.utils.a.b bVar3 = this.bsa;
                if (bVar3 != null) {
                    bVar3.e((byte) 6);
                }
                int i6 = i4 - 3;
                com.kwad.sdk.utils.a.b bVar4 = this.bsa;
                if (bVar4 != null) {
                    byte[] bArr = bVar4.brM;
                    System.arraycopy(bArr, iVar.start + 1, bArr, bVar4.position, i6);
                }
                com.kwad.sdk.utils.a.b bVar5 = this.bsa;
                if (bVar5 != null) {
                    bVar5.position += i6;
                }
                v(str2, iIu);
                a((byte) 6, iVar.start, iVar.offset + iVar.brJ);
                str3 = iVar.brK ? (String) iVar.value : null;
                iVar.brK = false;
                int i7 = this.bsf;
                iVar.start = i7;
                iVar.offset = i7 + i4;
                iVar.brJ = iIu;
                z = true;
            }
            iVar.value = str2;
            Xw();
            if (z) {
                Xz();
            }
            if (str3 != null) {
                h.h(new File(this.apn + this.name, str3));
            }
        }
        Xp();
    }

    private void a(String str, Object obj, byte[] bArr, com.kwad.sdk.utils.a.a.j jVar, byte b2) {
        if (jVar == null) {
            a(str, obj, bArr, b2);
        } else if (!jVar.brK && jVar.brJ == bArr.length) {
            updateBytes(jVar.offset, bArr);
            jVar.value = obj;
        } else {
            a(str, obj, bArr, jVar);
        }
        Xp();
    }

    private void a(String str, Object obj, byte[] bArr, byte b2) {
        Object obj2;
        int length;
        com.kwad.sdk.utils.a.a.b hVar;
        int iA = a(str, bArr, b2);
        if (iA != 0) {
            String str2 = this.bsj;
            boolean z = str2 != null;
            if (z) {
                this.bsj = null;
                length = 32;
                obj2 = str2;
            } else {
                obj2 = obj;
                length = bArr.length;
            }
            if (b2 == 6) {
                hVar = new com.kwad.sdk.utils.a.a.i(this.bsf, iA, (String) obj2, length, z);
            } else if (b2 == 7) {
                hVar = new com.kwad.sdk.utils.a.a.C1307a(this.bsf, iA, obj2, length, z);
            } else {
                hVar = new com.kwad.sdk.utils.a.a.h(this.bsf, iA, obj2, length, z);
            }
            this.bsd.put(str, hVar);
            Xw();
        }
    }

    private void a(String str, Object obj, byte[] bArr, @NonNull com.kwad.sdk.utils.a.a.j jVar) {
        int iA = a(str, bArr, jVar.Xi());
        if (iA != 0) {
            String str2 = jVar.brK ? (String) jVar.value : null;
            a(jVar.Xi(), jVar.start, jVar.offset + jVar.brJ);
            String str3 = this.bsj;
            boolean z = str3 != null;
            jVar.start = this.bsf;
            jVar.offset = iA;
            jVar.brK = z;
            if (z) {
                jVar.value = str3;
                jVar.brJ = 32;
                this.bsj = null;
            } else {
                jVar.value = obj;
                jVar.brJ = bArr.length;
            }
            Xw();
            Xz();
            if (str2 != null) {
                h.h(new File(this.apn + this.name, str2));
            }
        }
    }

    private int a(String str, byte[] bArr, byte b2) {
        this.bsj = null;
        if (bArr.length < 2048) {
            return b(str, bArr, b2);
        }
        info("large value, key: " + str + ", size: " + bArr.length);
        String strXE = h.XE();
        if (h.a(new File(this.apn + this.name, strXE), bArr)) {
            this.bsj = strXE;
            byte[] bArr2 = new byte[32];
            strXE.getBytes(0, 32, bArr2, 0);
            return b(str, bArr2, (byte) (b2 | SignedBytes.f32242a));
        }
        iy("save large value failed");
        return 0;
    }

    private void a(byte b2, int i, int i2) {
        byte[] bArr;
        N(i, i2);
        byte b3 = (byte) (b2 | UnsignedBytes.f32243a);
        com.kwad.sdk.utils.a.b bVar = this.bsa;
        if (bVar != null && (bArr = bVar.brM) != null) {
            this.bsc = ((((long) (bArr[i] ^ b3)) & 255) << ((i & 7) << 3)) ^ this.bsc;
            bArr[i] = b3;
        }
        this.bsh = i;
    }

    private void a(int i, int[] iArr) {
        Map<String, com.kwad.sdk.utils.a.a.b> map = this.bsd;
        if (map == null) {
            return;
        }
        for (com.kwad.sdk.utils.a.a.b bVar : map.values()) {
            int i2 = bVar.offset;
            if (i2 > i) {
                int i3 = iArr[(h.binarySearch(iArr, i2) << 1) + 1];
                bVar.offset -= i3;
                if (bVar.Xi() >= 6) {
                    ((com.kwad.sdk.utils.a.a.j) bVar).start -= i3;
                }
            }
        }
    }
}
