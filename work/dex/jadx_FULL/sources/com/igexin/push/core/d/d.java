package com.igexin.push.core.d;

import android.text.TextUtils;
import com.getui.gtc.base.util.io.IOUtils;
import com.igexin.push.core.ServiceManager;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f37992a = "grp.prop";
    public static final String b = "itmp";
    public static final String c = "itop";
    public static final String d = "c";
    public static final String e = "i";
    public static final String f = "p";
    public static final String g = "s";
    public static final String h = "t145gt";
    public static final String i = "t145main";
    private static final String j = "RpConfig";
    private static final d k = new d();
    private final String l;
    private long m;
    private final Map<String, String> n = new HashMap();

    /* JADX INFO: renamed from: com.igexin.push.core.d.d$3, reason: invalid class name */
    public class AnonymousClass3 extends com.igexin.push.core.g.a<RandomAccessFile> {
        public AnonymousClass3() {
        }

        private void a() {
            d.this.b();
        }

        @Override // com.igexin.push.core.g.a
        public final /* bridge */ /* synthetic */ void a(RandomAccessFile randomAccessFile) {
            d.this.b();
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.core.d.d$4, reason: invalid class name */
    public class AnonymousClass4 extends com.igexin.push.core.g.a<RandomAccessFile> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f37996a;

        public AnonymousClass4(String str) {
            this.f37996a = str;
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        private void a2(RandomAccessFile randomAccessFile) {
            if (d.this.b()) {
                d.this.a(randomAccessFile);
            }
            d.this.n.remove(this.f37996a);
            try {
                randomAccessFile.setLength(0L);
                for (Map.Entry entry : d.this.n.entrySet()) {
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
            if (d.this.b()) {
                d.this.a(randomAccessFile2);
            }
            d.this.n.remove(this.f37996a);
            try {
                randomAccessFile2.setLength(0L);
                for (Map.Entry entry : d.this.n.entrySet()) {
                    randomAccessFile2.writeBytes(((String) entry.getKey()) + "=" + ((String) entry.getValue()));
                    randomAccessFile2.writeBytes("\n");
                }
            } catch (IOException e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
    }

    private d() {
        String str = ServiceManager.b.getFilesDir().getAbsolutePath() + "/grp.prop";
        this.l = str;
        try {
            File file = new File(str);
            if (file.exists()) {
                return;
            }
            file.createNewFile();
        } catch (IOException e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    private int a(String str, int... iArr) {
        try {
            return Integer.parseInt(a(str));
        } catch (NumberFormatException e2) {
            com.igexin.c.a.c.a.a(e2);
            if (iArr == null || iArr.length != 1) {
                return -1;
            }
            return iArr[0];
        }
    }

    public static d a() {
        return k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RandomAccessFile randomAccessFile) {
        int i2;
        try {
            this.n.clear();
            while (true) {
                String line = randomAccessFile.readLine();
                if (line == null) {
                    return true;
                }
                int iIndexOf = line.indexOf("=");
                if (iIndexOf >= 0 && (i2 = iIndexOf + 1) != line.length()) {
                    this.n.put(line.substring(0, iIndexOf), line.substring(i2));
                }
            }
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        long jLastModified = new File(this.l).lastModified();
        boolean z = this.m != jLastModified;
        this.m = jLastModified;
        return z;
    }

    private void c(String str) throws Throwable {
        a(new AnonymousClass4(str).a((com.igexin.push.core.g.a) new AnonymousClass3()));
    }

    public final long a(String str, long... jArr) {
        try {
            return Long.parseLong(a(str));
        } catch (NumberFormatException e2) {
            com.igexin.c.a.c.a.a(e2);
            if (jArr.length == 1) {
                return jArr[0];
            }
            return 0L;
        }
    }

    public final String a(String str) throws Throwable {
        if (b()) {
            a(new com.igexin.push.core.g.a<RandomAccessFile>() { // from class: com.igexin.push.core.d.d.5
                /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
                private void a2(RandomAccessFile randomAccessFile) {
                    d.this.a(randomAccessFile);
                }

                @Override // com.igexin.push.core.g.a
                public final /* bridge */ /* synthetic */ void a(RandomAccessFile randomAccessFile) {
                    d.this.a(randomAccessFile);
                }
            });
        }
        return this.n.get(str);
    }

    public final ArrayList<String> a(String str, ArrayList<String> arrayList) throws Throwable {
        String strA = a(str);
        try {
            if (TextUtils.isEmpty(strA)) {
                return arrayList;
            }
            ArrayList<String> arrayList2 = new ArrayList<>();
            JSONArray jSONArray = new JSONArray(strA);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String strOptString = jSONArray.optString(i2);
                if (!TextUtils.isEmpty(strOptString)) {
                    arrayList2.add(strOptString);
                }
            }
            return arrayList2;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return arrayList;
        }
    }

    public final void a(com.igexin.push.core.g.a<RandomAccessFile> aVar) throws Throwable {
        RandomAccessFile randomAccessFile;
        FileLock fileLockLock = null;
        try {
            randomAccessFile = new RandomAccessFile(new File(this.l), "rw");
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
                } catch (Exception e2) {
                    e = e2;
                    com.igexin.c.a.c.a.a(e);
                    com.igexin.c.a.c.a.a("RpConfig| getProcessLock err：" + e.toString(), new Object[0]);
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
        } catch (Exception e3) {
            e = e3;
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

    public final void a(final String str, final Object obj) {
        a(new com.igexin.push.core.g.a<RandomAccessFile>() { // from class: com.igexin.push.core.d.d.2
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
            private void a2(RandomAccessFile randomAccessFile) {
                String string;
                if (d.this.b()) {
                    d.this.a(randomAccessFile);
                }
                Object obj2 = obj;
                if (obj2 instanceof List) {
                    try {
                        string = new JSONArray((Collection) obj).toString();
                    } catch (Throwable th) {
                        com.igexin.c.a.c.a.a(th);
                        return;
                    }
                } else {
                    string = String.valueOf(obj2);
                }
                d.this.n.put(str, string);
                try {
                    randomAccessFile.setLength(0L);
                    for (Map.Entry entry : d.this.n.entrySet()) {
                        randomAccessFile.writeBytes(((String) entry.getKey()) + "=" + ((String) entry.getValue()));
                        randomAccessFile.writeBytes("\n");
                    }
                } catch (IOException e2) {
                    com.igexin.c.a.c.a.a(e2);
                }
            }

            @Override // com.igexin.push.core.g.a
            public final /* synthetic */ void a(RandomAccessFile randomAccessFile) {
                String string;
                RandomAccessFile randomAccessFile2 = randomAccessFile;
                if (d.this.b()) {
                    d.this.a(randomAccessFile2);
                }
                Object obj2 = obj;
                if (obj2 instanceof List) {
                    try {
                        string = new JSONArray((Collection) obj).toString();
                    } catch (Throwable th) {
                        com.igexin.c.a.c.a.a(th);
                        return;
                    }
                } else {
                    string = String.valueOf(obj2);
                }
                d.this.n.put(str, string);
                try {
                    randomAccessFile2.setLength(0L);
                    for (Map.Entry entry : d.this.n.entrySet()) {
                        randomAccessFile2.writeBytes(((String) entry.getKey()) + "=" + ((String) entry.getValue()));
                        randomAccessFile2.writeBytes("\n");
                    }
                } catch (IOException e2) {
                    com.igexin.c.a.c.a.a(e2);
                }
            }
        }.a(new com.igexin.push.core.g.a<RandomAccessFile>() { // from class: com.igexin.push.core.d.d.1
            private void a() {
                d.this.b();
            }

            @Override // com.igexin.push.core.g.a
            public final /* bridge */ /* synthetic */ void a(RandomAccessFile randomAccessFile) {
                d.this.b();
            }
        }));
    }

    public final boolean b(String str) {
        return Boolean.parseBoolean(a(str));
    }
}
