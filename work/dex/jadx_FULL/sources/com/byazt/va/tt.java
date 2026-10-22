package com.byazt.va;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.byazt.gqp.a;
import com.byazt.gqp.m;
import com.byazt.gqp.t;
import com.byazt.gqp.yp;
import com.zj.adlib.c49;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 116, 13})
public class tt extends uj {
    public File c;
    public File tt;

    public tt(t tVar) {
        super(tVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(Map<String, String> map) {
        if (TextUtils.equals(map.get("Accept-Ranges"), "bytes") || TextUtils.equals(map.get("accept-ranges"), "bytes")) {
            return true;
        }
        String str = map.get("Content-Range");
        if (TextUtils.isEmpty(str)) {
            str = map.get("content-range");
        }
        return str != null && str.startsWith("bytes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        try {
            this.c.delete();
        } catch (Throwable unused) {
        }
        try {
            this.tt.delete();
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long sp(Map<String, String> map) {
        String str;
        if (map.containsKey("content-length")) {
            str = map.get("content-length");
        } else {
            str = map.containsKey("Content-Length") ? map.get("Content-Length") : null;
        }
        if (TextUtils.isEmpty(str) || str == null) {
            return 0L;
        }
        try {
            return Long.valueOf(str).longValue();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean x(Map<String, String> map) {
        return TextUtils.equals(map.get("Content-Encoding"), "gzip");
    }

    public tt(t tVar, String str, String str2, String str3) {
        super(tVar);
        c(str);
        c(str2, str3);
    }

    public void c(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        this.c = new File(str, str2);
        this.tt = new File(str, str2 + ".temp");
    }

    public void c(final com.byazt.mh.c cVar) {
        File file = this.c;
        if (file == null || this.tt == null) {
            if (cVar != null) {
                cVar.c(this, new IOException("File info is null, please exec setFileInfo(String dir, String fileName)"));
                return;
            }
            return;
        }
        if (file.exists() && this.c.length() != 0 && cVar != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.byazt.hm.tt ttVar = new com.byazt.hm.tt(true, 200, "Success", null, null, jCurrentTimeMillis, jCurrentTimeMillis);
            ttVar.c(this.c);
            cVar.c(this, ttVar);
            return;
        }
        long length = this.tt.length();
        final long j = length >= 0 ? length : 0L;
        yp.c cVar2 = new yp.c();
        cVar2.c((Object) tt());
        tt("Range", "bytes=" + j + c49.f40900a);
        if (TextUtils.isEmpty(this.f29124a)) {
            cVar.c(this, new IOException("Url is Empty"));
            return;
        }
        try {
            cVar2.c(this.f29124a);
            c(cVar2);
            this.ve.c(cVar2.c().tt()).c(new com.byazt.gqp.ve() { // from class: com.byazt.va.tt.1
                @Override // com.byazt.gqp.ve
                public void onFailure(com.byazt.gqp.tt ttVar2, IOException iOException) {
                    com.byazt.mh.c cVar3 = cVar;
                    if (cVar3 != null) {
                        cVar3.c(tt.this, iOException);
                    }
                    tt.this.n();
                }

                @Override // com.byazt.gqp.ve
                public void onResponse(com.byazt.gqp.tt ttVar2, m mVar) throws IOException {
                    RandomAccessFile randomAccessFile;
                    long j2;
                    byte[] bArr;
                    long j3;
                    int i;
                    if (cVar == null) {
                        return;
                    }
                    HashMap map = new HashMap();
                    if (mVar == null) {
                        return;
                    }
                    a aVarSp = mVar.sp();
                    if (aVarSp != null) {
                        for (int i2 = 0; i2 < aVarSp.c(); i2++) {
                            map.put(aVarSp.c(i2), aVarSp.tt(i2));
                        }
                    }
                    com.byazt.hm.tt ttVar3 = new com.byazt.hm.tt(mVar.uj(), mVar.ve(), mVar.n(), map, null, mVar.tt(), mVar.c());
                    if (!mVar.uj()) {
                        cVar.c(tt.this, ttVar3);
                        return;
                    }
                    long jC = mVar.a().c();
                    if (jC <= 0) {
                        jC = tt.sp(map);
                    }
                    boolean zA = tt.a(map);
                    int i3 = -1;
                    if (zA) {
                        jC += j;
                        String str = (String) map.get("Content-Range");
                        if (!TextUtils.isEmpty(str)) {
                            String str2 = "bytes " + j + c49.f40900a + (jC - 1);
                            if (TextUtils.indexOf(str, str2) == -1) {
                                tt.this.n();
                                cVar.c(tt.this, new IOException("The Content-Range Header is invalid Assume[" + str2 + "] vs Real[" + str + "], please remove the temporary file [" + tt.this.tt + "]."));
                                return;
                            }
                        }
                    }
                    if (jC > 0 && tt.this.tt.exists() && tt.this.tt.length() == jC) {
                        tt ttVar4 = tt.this;
                        if (!ttVar4.tt.renameTo(ttVar4.c)) {
                            cVar.c(tt.this, new IOException("Rename fail"));
                            return;
                        } else {
                            ttVar3.c(tt.this.c);
                            cVar.c(tt.this, ttVar3);
                            return;
                        }
                    }
                    InputStream inputStreamVe = null;
                    try {
                        try {
                            try {
                                randomAccessFile = new RandomAccessFile(tt.this.tt, "rw");
                                try {
                                    if (zA) {
                                        randomAccessFile.seek(j);
                                        j2 = j;
                                    } else {
                                        randomAccessFile.setLength(0L);
                                        j2 = 0;
                                    }
                                    while (true) {
                                        int i4 = inputStreamVe.read(bArr, i, 16384 - i);
                                        boolean z = true;
                                        if (i4 == i3) {
                                            break;
                                        }
                                        i += i4;
                                        InputStream inputStream = inputStreamVe;
                                        j3 += (long) i4;
                                        try {
                                            if (j3 % PlaybackStateCompat.ACTION_PREPARE != 0 && j3 != jC - j) {
                                                z = false;
                                            }
                                            if (z) {
                                                randomAccessFile.seek(j2);
                                                randomAccessFile.write(bArr, 0, i);
                                                j2 += (long) i;
                                                i = 0;
                                            }
                                            inputStreamVe = inputStream;
                                            i3 = -1;
                                        } catch (Throwable th) {
                                            th = th;
                                            inputStreamVe = inputStream;
                                            try {
                                                com.byazt.nr.m.c(th);
                                                cVar.c(tt.this, new IOException(th.getMessage()));
                                                if (!zA) {
                                                    tt.this.n();
                                                }
                                                try {
                                                    return;
                                                } catch (Throwable unused) {
                                                    return;
                                                }
                                            } finally {
                                                if (inputStreamVe != null) {
                                                    try {
                                                        inputStreamVe.close();
                                                    } catch (Throwable unused2) {
                                                    }
                                                }
                                                try {
                                                    randomAccessFile.close();
                                                } catch (Throwable unused3) {
                                                }
                                            }
                                        }
                                    }
                                } catch (Throwable unused4) {
                                }
                            } catch (Throwable unused5) {
                                randomAccessFile = null;
                            }
                            bArr = new byte[16384];
                            j3 = 0;
                            i = 0;
                            InputStream inputStream2 = inputStreamVe;
                            if (!zA) {
                                jC = tt.this.tt.length();
                            }
                            if (jC > 0 && tt.this.tt.exists() && tt.this.tt.length() == jC) {
                                tt ttVar5 = tt.this;
                                if (ttVar5.tt.renameTo(ttVar5.c)) {
                                    ttVar3.c(tt.this.c);
                                    cVar.c(tt.this, ttVar3);
                                } else {
                                    cVar.c(tt.this, new IOException("Rename fail"));
                                }
                            } else {
                                com.byazt.mh.c cVar3 = cVar;
                                tt ttVar6 = tt.this;
                                StringBuilder sb = new StringBuilder(" tempFile.length() == fileSize is");
                                sb.append(tt.this.tt.length() == jC);
                                cVar3.c(ttVar6, new IOException(sb.toString()));
                            }
                            try {
                                inputStream2.close();
                            } catch (Throwable unused6) {
                            }
                            try {
                                randomAccessFile.close();
                                return;
                            } catch (Throwable unused7) {
                                return;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        inputStreamVe = mVar.a().ve();
                        if (tt.x(map) && !(inputStreamVe instanceof GZIPInputStream)) {
                            inputStreamVe = new GZIPInputStream(inputStreamVe);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
            });
        } catch (IllegalArgumentException unused) {
            cVar.c(this, new IOException("Url is not a valid HTTP or HTTPS URL"));
        }
    }

    /* JADX WARN: Code duplicated, block: B:133:0x02d4 A[Catch: all -> 0x02f3, TryCatch #12 {all -> 0x02f3, blocks: (B:131:0x02cd, B:133:0x02d4, B:134:0x02d7), top: B:201:0x02cd, outer: #18 }] */
    /* JADX WARN: Code duplicated, block: B:195:0x02ec A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.byazt.va.uj
    public com.byazt.hm.tt c() {
        long j;
        RandomAccessFile randomAccessFile;
        long j2;
        Throwable th;
        String str;
        int i;
        InputStream inputStream;
        boolean z;
        File file = this.c;
        if (file != null && this.tt != null) {
            if (file.exists() && this.c.length() != 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                com.byazt.hm.tt ttVar = new com.byazt.hm.tt(true, 200, "Success", null, null, jCurrentTimeMillis, jCurrentTimeMillis);
                ttVar.c(this.c);
                return ttVar;
            }
            long length = this.tt.length();
            if (length < 0) {
                length = 0;
            }
            yp.c cVar = new yp.c();
            cVar.c((Object) tt());
            tt("Range", "bytes=" + length + c49.f40900a);
            String str2 = "DownloadExecutor";
            if (TextUtils.isEmpty(this.f29124a)) {
                com.byazt.nr.m.uj("DownloadExecutor", "execute: Url is Empty");
                return new com.byazt.hm.tt(false, -9, "url is Empty", null, null, 0L, 0L);
            }
            try {
                cVar.c(this.f29124a);
                c(cVar);
                try {
                    m mVarTt = this.ve.c(cVar.c().tt()).tt();
                    if (mVarTt != null && mVarTt.uj()) {
                        HashMap map = new HashMap();
                        a aVarSp = mVarTt.sp();
                        if (aVarSp != null) {
                            for (int i2 = 0; i2 < aVarSp.c(); i2++) {
                                map.put(aVarSp.c(i2), aVarSp.tt(i2));
                            }
                        }
                        com.byazt.hm.tt ttVar2 = new com.byazt.hm.tt(mVarTt.uj(), mVarTt.ve(), mVarTt.n(), map, null, mVarTt.tt(), mVarTt.c());
                        long jC = mVarTt.a().c();
                        if (jC <= 0) {
                            jC = sp(map);
                        }
                        long length2 = this.tt.length();
                        boolean zA = a(map);
                        if (zA) {
                            jC += length2;
                            String str3 = (String) map.get("Content-Range");
                            if (!TextUtils.isEmpty(str3)) {
                                String str4 = "bytes " + length2 + c49.f40900a + (jC - 1);
                                if (TextUtils.indexOf(str3, str4) == -1) {
                                    com.byazt.lf.n.c("DownloadExecutor", "execute: The Content-Range Header is invalid Assume[" + str4 + "] vs Real[" + str3 + "], please remove the temporary file [" + this.tt + "].");
                                    n();
                                    return new com.byazt.hm.tt(false, -7, "realRangeValue failed", null, null, 0L, 0L);
                                }
                            }
                            j = 0;
                        } else {
                            j = 0;
                        }
                        if (jC > j && this.tt.exists() && this.tt.length() == jC) {
                            if (this.tt.renameTo(this.c)) {
                                ttVar2.c(this.c);
                                return ttVar2;
                            }
                            com.byazt.lf.n.c("DownloadExecutor", "Rename fail");
                            return new com.byazt.hm.tt(false, -6, "rename failed", null, null, 0L, 0L);
                        }
                        InputStream inputStreamVe = null;
                        try {
                            randomAccessFile = new RandomAccessFile(this.tt, "rw");
                            try {
                                if (zA) {
                                    randomAccessFile.seek(length);
                                    j2 = length;
                                } else {
                                    randomAccessFile.setLength(0L);
                                    j2 = 0;
                                }
                            } catch (Throwable unused) {
                            }
                        } catch (Throwable unused2) {
                            randomAccessFile = null;
                        }
                        try {
                            inputStreamVe = mVarTt.a().ve();
                            if (x(map) && !(inputStreamVe instanceof GZIPInputStream)) {
                                inputStreamVe = new GZIPInputStream(inputStreamVe);
                            }
                            try {
                                byte[] bArr = new byte[16384];
                                int i3 = 0;
                                long j3 = 0;
                                while (true) {
                                    str = str2;
                                    i = inputStreamVe.read(bArr, i3, 16384 - i3);
                                    inputStream = inputStreamVe;
                                    if (i == -1) {
                                        break;
                                    }
                                    i3 += i;
                                    RandomAccessFile randomAccessFile2 = randomAccessFile;
                                    long j4 = j3 + ((long) i);
                                    try {
                                        if (j4 % PlaybackStateCompat.ACTION_PREPARE == 0 || j4 == jC - length) {
                                            randomAccessFile = randomAccessFile2;
                                            try {
                                                randomAccessFile.seek(j2);
                                                randomAccessFile.write(bArr, 0, i3);
                                                j2 += (long) i3;
                                                i3 = 0;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                th = th;
                                                inputStreamVe = inputStream;
                                                try {
                                                    com.byazt.nr.m.c(th);
                                                    if (!zA) {
                                                        n();
                                                    }
                                                    return new com.byazt.hm.tt(false, -3, "Error occured when FileRequest.parseHttpResponse", null, null, 0L, 0L, th);
                                                } finally {
                                                    if (inputStreamVe != null) {
                                                        try {
                                                            inputStreamVe.close();
                                                        } catch (Throwable unused3) {
                                                        }
                                                    }
                                                    try {
                                                        randomAccessFile.close();
                                                    } catch (Throwable unused4) {
                                                    }
                                                }
                                            }
                                        } else {
                                            randomAccessFile = randomAccessFile2;
                                        }
                                        str2 = str;
                                        inputStreamVe = inputStream;
                                        j3 = j4;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        randomAccessFile = randomAccessFile2;
                                    }
                                }
                                if (i != 0) {
                                    randomAccessFile.seek(j2);
                                    z = false;
                                    randomAccessFile.write(bArr, 0, i3);
                                } else {
                                    z = false;
                                }
                                if (!zA || length == 0) {
                                    jC = this.tt.length();
                                }
                                if (jC > 0 && this.tt.exists() && this.tt.length() == jC) {
                                    if (this.tt.renameTo(this.c)) {
                                        ttVar2.c(this.c);
                                        try {
                                            inputStream.close();
                                        } catch (Throwable unused5) {
                                        }
                                        try {
                                            randomAccessFile.close();
                                        } catch (Throwable unused6) {
                                        }
                                        return ttVar2;
                                    }
                                    com.byazt.hm.tt ttVar3 = new com.byazt.hm.tt(false, -5, "rename failed", null, null, 0L, 0L);
                                    try {
                                        inputStream.close();
                                    } catch (Throwable unused7) {
                                    }
                                    try {
                                        randomAccessFile.close();
                                    } catch (Throwable unused8) {
                                    }
                                    return ttVar3;
                                }
                                StringBuilder sb = new StringBuilder(" tempFile.length() == fileSize is");
                                sb.append(this.tt.length() == jC ? true : z);
                                String string = sb.toString();
                                com.byazt.lf.n.c(str, string);
                                com.byazt.hm.tt ttVar4 = new com.byazt.hm.tt(false, -4, string, null, null, 0L, 0L);
                                try {
                                    inputStream.close();
                                } catch (Throwable unused9) {
                                }
                                try {
                                    randomAccessFile.close();
                                } catch (Throwable unused10) {
                                }
                                return ttVar4;
                            } catch (Throwable th4) {
                                th = th4;
                                th = th;
                                com.byazt.nr.m.c(th);
                                if (!zA) {
                                    n();
                                }
                                return new com.byazt.hm.tt(false, -3, "Error occured when FileRequest.parseHttpResponse", null, null, 0L, 0L, th);
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } else {
                        return new com.byazt.hm.tt(false, mVarTt == null ? -2 : mVarTt.ve(), mVarTt == null ? "ok response is null" : mVarTt.n(), null, null, 0L, 0L);
                    }
                } catch (IOException e) {
                    com.byazt.nr.m.c(e);
                    n();
                    return new com.byazt.hm.tt(false, -1, e.getMessage(), null, null, 0L, 0L, e);
                }
            } catch (IllegalArgumentException unused11) {
                com.byazt.nr.m.uj("DownloadExecutor", "Url is not a valid HTTP or HTTPS URL");
                return new com.byazt.hm.tt(false, -8, "Url is not a valid HTTP or HTTPS URL", null, null, 0L, 0L);
            }
        } else {
            StringBuilder sb2 = new StringBuilder("file == null: ");
            sb2.append(this.c == null);
            sb2.append(" tempFile == null: ");
            sb2.append(this.tt == null);
            return new com.byazt.hm.tt(false, -10, sb2.toString(), null, null, 0L, 0L);
        }
    }
}
