package com.byazt.bzd;

import android.text.TextUtils;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.byazt.omf.gt;
import com.byazt.ukr.yp;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.CRC32;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 724, 34})
public class a {
    public static final Map<String, Long> c;
    public static final Map<String, Long> tt;
    public static final ConcurrentHashMap<String, Boolean> ve;

    @com.byazt.zqa.c(c = {0, 1, 724, 464})
    public static class c {
        /* JADX INFO: Access modifiers changed from: private */
        public static tt tt(File file) throws IOException {
            int iVe;
            int iVe2;
            int iVe3;
            int iVe4;
            int iVe5;
            long jC;
            long jC2;
            long jTt;
            long j;
            long j2;
            int i;
            int i2;
            tt ttVar = new tt();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            try {
                byte[] bArr = new byte[16];
                randomAccessFile.readFully(bArr);
                if (bArr[0] != 127 || bArr[1] != 69 || bArr[2] != 76 || bArr[3] != 70) {
                    throw new IOException("Not ELF");
                }
                boolean z = bArr[4] == 2;
                ByteOrder byteOrder = bArr[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
                randomAccessFile.seek(18L);
                int iVe6 = ve(randomAccessFile, byteOrder);
                ttVar.c = iVe6 == 40;
                ttVar.tt = iVe6 == 183;
                if (z) {
                    randomAccessFile.seek(32L);
                    jC = c(randomAccessFile, byteOrder);
                    randomAccessFile.seek(40L);
                    jC2 = c(randomAccessFile, byteOrder);
                    randomAccessFile.seek(54L);
                    iVe = ve(randomAccessFile, byteOrder);
                    iVe2 = ve(randomAccessFile, byteOrder);
                    iVe3 = ve(randomAccessFile, byteOrder);
                    iVe4 = ve(randomAccessFile, byteOrder);
                    iVe5 = ve(randomAccessFile, byteOrder);
                } else {
                    randomAccessFile.seek(28L);
                    long jTt2 = tt(randomAccessFile, byteOrder);
                    randomAccessFile.seek(32L);
                    long jTt3 = tt(randomAccessFile, byteOrder);
                    randomAccessFile.seek(42L);
                    iVe = ve(randomAccessFile, byteOrder);
                    iVe2 = ve(randomAccessFile, byteOrder);
                    iVe3 = ve(randomAccessFile, byteOrder);
                    iVe4 = ve(randomAccessFile, byteOrder);
                    iVe5 = ve(randomAccessFile, byteOrder);
                    jC = jTt2;
                    jC2 = jTt3;
                }
                CRC32 crc32 = new CRC32();
                byte[] bArr2 = new byte[iVe];
                int i3 = 0;
                while (i3 < iVe2) {
                    long j3 = jC2;
                    int i4 = iVe2;
                    int i5 = iVe3;
                    randomAccessFile.seek((((long) i3) * ((long) iVe)) + jC);
                    randomAccessFile.readFully(bArr2);
                    ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr2).order(byteOrder);
                    if (z) {
                        i = byteBufferOrder.getInt();
                        i2 = byteBufferOrder.getInt();
                    } else {
                        i = byteBufferOrder.getInt();
                        byteBufferOrder.getInt();
                        byteBufferOrder.position(byteBufferOrder.position() + 8);
                        byteBufferOrder.getInt();
                        byteBufferOrder.position(byteBufferOrder.position() + 4);
                        i2 = byteBufferOrder.getInt();
                    }
                    if (i == 1) {
                        ttVar.f28339a++;
                        if ((i2 & 1) != 0) {
                            ttVar.sp++;
                        }
                        c(crc32, i);
                        c(crc32, i2);
                    }
                    i3++;
                    jC2 = j3;
                    iVe2 = i4;
                    iVe3 = i5;
                }
                long j4 = jC2;
                int i6 = iVe3;
                ttVar.ve = crc32.getValue();
                long j5 = i6;
                randomAccessFile.seek(j4 + (((long) iVe5) * j5));
                if (z) {
                    randomAccessFile.skipBytes(24);
                    jTt = c(randomAccessFile, byteOrder);
                } else {
                    randomAccessFile.skipBytes(16);
                    jTt = tt(randomAccessFile, byteOrder);
                }
                byte[] bArr3 = new byte[i6];
                int i7 = 0;
                while (true) {
                    if (i7 >= iVe4) {
                        j = -1;
                        j2 = -1;
                        break;
                    }
                    randomAccessFile.seek(j4 + (((long) i7) * j5));
                    randomAccessFile.readFully(bArr3);
                    ByteBuffer byteBufferOrder2 = ByteBuffer.wrap(bArr3).order(byteOrder);
                    int i8 = byteBufferOrder2.getInt();
                    byteBufferOrder2.position(byteBufferOrder2.position() + 4);
                    byteBufferOrder2.position(byteBufferOrder2.position() + (z ? 8 : 4));
                    byteBufferOrder2.position(byteBufferOrder2.position() + (z ? 8 : 4));
                    long j6 = z ? byteBufferOrder2.getLong() : ((long) byteBufferOrder2.getInt()) & 4294967295L;
                    j2 = z ? byteBufferOrder2.getLong() : 4294967295L & ((long) byteBufferOrder2.getInt());
                    if (".text".equals(c(randomAccessFile, ((long) i8) + jTt))) {
                        j = j6;
                        break;
                    }
                    i7++;
                    byteOrder = byteOrder;
                    bArr3 = bArr3;
                }
                if (j < 0) {
                    throw new IOException(".text not found");
                }
                long jC3 = c(randomAccessFile, j, j2);
                ttVar.uj = jC3;
                ttVar.n = c(ttVar.ve, jC3);
                randomAccessFile.close();
                return ttVar;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        randomAccessFile.close();
                        throw th2;
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                        throw th2;
                    }
                }
            }
        }

        private static int ve(RandomAccessFile randomAccessFile, ByteOrder byteOrder) throws IOException {
            byte[] bArr = new byte[2];
            randomAccessFile.readFully(bArr);
            return ByteBuffer.wrap(bArr).order(byteOrder).getShort() & 65535;
        }

        private static long c(long j, long j2) {
            CRC32 crc32 = new CRC32();
            c(crc32, (int) j);
            c(crc32, (int) j2);
            return crc32.getValue();
        }

        private static long c(RandomAccessFile randomAccessFile, long j, long j2) throws IOException {
            int i;
            randomAccessFile.seek(j);
            CRC32 crc32 = new CRC32();
            byte[] bArr = new byte[8192];
            while (j2 > 0 && (i = randomAccessFile.read(bArr, 0, (int) Math.min(8192L, j2))) > 0) {
                crc32.update(bArr, 0, i);
                j2 -= (long) i;
            }
            return crc32.getValue();
        }

        private static void c(CRC32 crc32, int i) {
            crc32.update((i >>> 24) & 255);
            crc32.update((i >>> 16) & 255);
            crc32.update((i >>> 8) & 255);
            crc32.update(i & 255);
        }

        private static String c(RandomAccessFile randomAccessFile, long j) throws IOException {
            randomAccessFile.seek(j);
            StringBuilder sb = new StringBuilder();
            while (true) {
                int i = randomAccessFile.read();
                if (i > 0) {
                    sb.append((char) i);
                } else {
                    return sb.toString();
                }
            }
        }

        private static long c(RandomAccessFile randomAccessFile, ByteOrder byteOrder) throws IOException {
            byte[] bArr = new byte[8];
            randomAccessFile.readFully(bArr);
            return ByteBuffer.wrap(bArr).order(byteOrder).getLong();
        }

        private static long tt(RandomAccessFile randomAccessFile, ByteOrder byteOrder) throws IOException {
            byte[] bArr = new byte[4];
            randomAccessFile.readFully(bArr);
            return ((long) ByteBuffer.wrap(bArr).order(byteOrder).getInt()) & 4294967295L;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 724, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH})
    public static class tt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f28339a;
        public boolean c;
        public long n;
        public int sp;
        public boolean tt;
        public long uj;
        public long ve;
    }

    @com.byazt.zqa.c(c = {0, 1, 724, 471})
    public static class ve extends UnsatisfiedLinkError {
        public ve(String str) {
            super(str);
        }
    }

    static {
        HashMap map = new HashMap();
        c = map;
        HashMap map2 = new HashMap();
        tt = map2;
        ve = new ConcurrentHashMap<>();
        map.put("pangleflipped", 2108457691L);
        map2.put("pangleflipped", 1987010392L);
        map2.put("panglearmor", 199833129L);
        map2.put("tt_ugen_layout", 4099492101L);
        map2.put("avmdl_lite", 2580523452L);
        map2.put("Pglbizssdk_ml", 2636633674L);
        map2.put("ttmplayer_lite", 2952398659L);
        map2.put("tobEmbedEncrypt", 1277933986L);
    }

    public static boolean c(String str) {
        Boolean bool = Boolean.TRUE;
        ConcurrentHashMap<String, Boolean> concurrentHashMap = ve;
        if (bool.equals(concurrentHashMap.get(str))) {
            return true;
        }
        Map<String, Long> map = tt;
        if (map.get(str) == null) {
            return true;
        }
        try {
            File fileTt = tt(str);
            if (fileTt != null && fileTt.exists()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                tt ttVarTt = c.tt(fileTt);
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                if (!ttVarTt.tt) {
                    map = c;
                }
                long jLongValue = map.get(str).longValue();
                long j = ttVarTt.n;
                if (j == jLongValue && j != 0) {
                    concurrentHashMap.put(str, bool);
                    c(str, jCurrentTimeMillis2, ttVarTt, jLongValue, 1);
                    return true;
                }
                if (j == 0) {
                    c(str, jCurrentTimeMillis2, ttVarTt, jLongValue, -2);
                    return true;
                }
                c(str, jCurrentTimeMillis2, ttVarTt, jLongValue, -1);
                return false;
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    private static File tt(String str) {
        try {
            String strFindLibrary = ((BaseDexClassLoader) sp.class.getClassLoader()).findLibrary(str);
            if (!TextUtils.isEmpty(strFindLibrary)) {
                return new File(strFindLibrary);
            }
            String str2 = gt.getContext().getApplicationInfo().nativeLibraryDir;
            if (!TextUtils.isEmpty(str2)) {
                File file = new File(str2, "lib" + str + ".so");
                if (file.exists()) {
                    return file;
                }
            }
            return null;
        } catch (Throwable unused) {
        }
    }

    private static void c(String str, long j, tt ttVar, long j2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("lib", str);
            jSONObject.put("isV8", ttVar.tt ? 1 : 0);
            jSONObject.put("phdrCrc", ttVar.ve);
            jSONObject.put("textCrc", ttVar.uj);
            jSONObject.put("finalCrc", ttVar.n);
            jSONObject.put("expected", j2);
            jSONObject.put("loadCount", ttVar.f28339a);
            jSONObject.put("execCount", ttVar.sp);
            jSONObject.put("checkResult", i);
            jSONObject.put("cost", j);
        } catch (JSONException unused) {
        }
        yp.c().tt("so_security_check", jSONObject);
    }
}
