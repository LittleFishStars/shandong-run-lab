package com.igexin.push.core.d;

import android.text.TextUtils;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.getui.gtc.base.util.io.IOUtils;
import com.igexin.push.g.j;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f37988a = "guard.me";
    public static final String b = "guard.others";
    private static final String c = "GuardConfig";
    private static final c d = new c();
    private long e;
    private final Map<String, String> f = new HashMap();

    private c() {
        try {
            if (TextUtils.isEmpty(j.g)) {
                j.a();
            }
            File file = new File(j.g);
            if (file.exists()) {
                return;
            }
            file.createNewFile();
        } catch (IOException e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    private int a(String str, int... iArr) {
        try {
            return Integer.parseInt(b(str));
        } catch (NumberFormatException e) {
            com.igexin.c.a.c.a.a(e);
            if (iArr == null || iArr.length != 1) {
                return -1;
            }
            return iArr[0];
        }
    }

    private long a(String str, long... jArr) {
        try {
            return Long.parseLong(b(str));
        } catch (NumberFormatException e) {
            com.igexin.c.a.c.a.a(e);
            if (jArr == null || jArr.length != 1) {
                return 0L;
            }
            return jArr[0];
        }
    }

    public static c a() {
        return d;
    }

    private static void a(com.igexin.push.core.g.a<RandomAccessFile> aVar) throws Throwable {
        RandomAccessFile randomAccessFile;
        FileLock fileLockLock = null;
        try {
            randomAccessFile = new RandomAccessFile(new File(j.g), "rw");
            try {
                try {
                    fileLockLock = randomAccessFile.getChannel().lock();
                    if (fileLockLock.isValid()) {
                        aVar.a(randomAccessFile);
                    }
                    if (fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (IOException unused) {
                        }
                    }
                    IOUtils.safeClose(randomAccessFile);
                } catch (Exception e) {
                    e = e;
                    com.igexin.c.a.c.a.a(e);
                    com.igexin.c.a.c.a.a("GuardConfig| getProcessLock err：" + e.toString(), new Object[0]);
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (IOException unused2) {
                        }
                    }
                    IOUtils.safeClose(randomAccessFile);
                }
            } catch (Throwable th) {
                th = th;
                if (fileLockLock != null && fileLockLock.isValid()) {
                    try {
                        fileLockLock.release();
                    } catch (IOException unused3) {
                    }
                }
                IOUtils.safeClose(randomAccessFile);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            randomAccessFile = null;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
            if (fileLockLock != null) {
                fileLockLock.release();
            }
            IOUtils.safeClose(randomAccessFile);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RandomAccessFile randomAccessFile) {
        int i;
        try {
            this.f.clear();
            while (true) {
                String line = randomAccessFile.readLine();
                if (line == null) {
                    return true;
                }
                int iIndexOf = line.indexOf("=");
                if (iIndexOf >= 0 && (i = iIndexOf + 1) != line.length()) {
                    this.f.put(line.substring(0, iIndexOf), line.substring(i));
                }
            }
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return false;
        }
    }

    private String b(String str) throws Throwable {
        if (b()) {
            a(new com.igexin.push.core.g.a<RandomAccessFile>() { // from class: com.igexin.push.core.d.c.3
                /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
                private void a2(RandomAccessFile randomAccessFile) {
                    c.this.a(randomAccessFile);
                }

                @Override // com.igexin.push.core.g.a
                public final /* bridge */ /* synthetic */ void a(RandomAccessFile randomAccessFile) {
                    c.this.a(randomAccessFile);
                }
            });
        }
        return this.f.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        long jLastModified = new File(j.g).lastModified();
        boolean z = this.e != jLastModified;
        this.e = jLastModified;
        return z;
    }

    private static Boolean c(String str) {
        if (str == null) {
            return null;
        }
        if (str.equalsIgnoreCase("true")) {
            return Boolean.TRUE;
        }
        if (str.equalsIgnoreCase(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE)) {
            return Boolean.FALSE;
        }
        return null;
    }

    public final Boolean a(String str) throws Throwable {
        String strB = b(str);
        if (strB == null) {
            return null;
        }
        return c(strB);
    }

    public final void a(final String str, final Object obj) throws Throwable {
        a(new com.igexin.push.core.g.a<RandomAccessFile>() { // from class: com.igexin.push.core.d.c.2
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
            private void a2(RandomAccessFile randomAccessFile) {
                if (c.this.b()) {
                    c.this.a(randomAccessFile);
                }
                c.this.f.put(str, String.valueOf(obj));
                try {
                    randomAccessFile.setLength(0L);
                    for (Map.Entry entry : c.this.f.entrySet()) {
                        randomAccessFile.writeBytes(((String) entry.getKey()) + "=" + ((String) entry.getValue()));
                        randomAccessFile.writeBytes("\n");
                    }
                } catch (IOException e) {
                    com.igexin.c.a.c.a.a(e);
                }
            }

            @Override // com.igexin.push.core.g.a
            public final /* synthetic */ void a(RandomAccessFile randomAccessFile) {
                RandomAccessFile randomAccessFile2 = randomAccessFile;
                if (c.this.b()) {
                    c.this.a(randomAccessFile2);
                }
                c.this.f.put(str, String.valueOf(obj));
                try {
                    randomAccessFile2.setLength(0L);
                    for (Map.Entry entry : c.this.f.entrySet()) {
                        randomAccessFile2.writeBytes(((String) entry.getKey()) + "=" + ((String) entry.getValue()));
                        randomAccessFile2.writeBytes("\n");
                    }
                } catch (IOException e) {
                    com.igexin.c.a.c.a.a(e);
                }
            }
        }.a(new com.igexin.push.core.g.a<RandomAccessFile>() { // from class: com.igexin.push.core.d.c.1
            private void a() {
                c.this.b();
            }

            @Override // com.igexin.push.core.g.a
            public final /* bridge */ /* synthetic */ void a(RandomAccessFile randomAccessFile) {
                c.this.b();
            }
        }));
    }
}
