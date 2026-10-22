package com.byazt.ss;

import com.ali.auth.third.core.model.SystemMessageConstants;
import com.alibaba.android.arouter.utils.Consts;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ipd.dsp.internal.d.a;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SystemMessageConstants.JS_BRIDGE_METHOD_NOT_FOUND, 20})
public final class c implements Closeable {
    public static final Pattern c = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final OutputStream ve = new OutputStream() { // from class: com.byazt.ss.c.2
        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f29029a;
    public final int da;
    public long i;
    public final File n;
    public final File sp;
    public Writer t;
    public final ExecutorService tt;
    public final File uj;
    public final int x;
    public int yp;
    public long sl = 0;
    public final LinkedHashMap<String, tt> u = new LinkedHashMap<>(0, 0.75f, true);
    public long z = -1;
    public long m = 0;
    public final Callable<Void> nu = new Callable<Void>() { // from class: com.byazt.ss.c.1
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (c.this) {
                if (c.this.t == null) {
                    return null;
                }
                c.this.sp();
                if (c.this.n()) {
                    c.this.uj();
                    c.this.yp = 0;
                }
                return null;
            }
        }
    };

    /* JADX INFO: renamed from: com.byazt.ss.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, SystemMessageConstants.JS_BRIDGE_METHOD_NOT_FOUND, 44})
    public final class C0525c {
        public boolean n;
        public final tt tt;
        public boolean uj;
        public final boolean[] ve;

        /* JADX INFO: renamed from: com.byazt.ss.c$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, SystemMessageConstants.JS_BRIDGE_METHOD_NOT_FOUND, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_STAT_INFO})
        public final class C0526c extends FilterOutputStream {
            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C0525c.this.uj = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C0525c.this.uj = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    C0525c.this.uj = true;
                }
            }

            private C0526c(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C0525c.this.uj = true;
                }
            }
        }

        private C0525c(tt ttVar) {
            this.tt = ttVar;
            this.ve = ttVar.uj ? null : new boolean[c.this.da];
        }

        public void tt() throws IOException {
            c.this.c(this, false);
        }

        public OutputStream c(int i) throws IOException {
            FileOutputStream fileOutputStream;
            C0526c c0526c;
            if (i < 0 || i >= c.this.da) {
                throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + c.this.da);
            }
            synchronized (c.this) {
                if (this.tt.n == this) {
                    if (!this.tt.uj) {
                        this.ve[i] = true;
                    }
                    File fileTt = this.tt.tt(i);
                    try {
                        fileOutputStream = new FileOutputStream(fileTt);
                    } catch (FileNotFoundException unused) {
                        c.this.uj.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(fileTt);
                        } catch (FileNotFoundException unused2) {
                            return c.ve;
                        }
                    }
                    c0526c = new C0526c(fileOutputStream);
                } else {
                    throw new IllegalStateException();
                }
            }
            return c0526c;
        }

        public void c() throws IOException {
            if (this.uj) {
                c.this.c(this, false);
                c.this.ve(this.tt.tt);
            } else {
                c.this.c(this, true);
            }
            this.n = true;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, SystemMessageConstants.JS_BRIDGE_METHOD_NOT_FOUND, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public final class tt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f29030a;
        public C0525c n;
        public final String tt;
        public boolean uj;
        public final long[] ve;

        private tt(String str) {
            this.tt = str;
            this.ve = new long[c.this.da];
        }

        private IOException tt(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File tt(int i) {
            return new File(c.this.uj, this.tt + Consts.DOT + i + ".tmp");
        }

        public String c() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.ve) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(String[] strArr) throws IOException {
            if (strArr.length == c.this.da) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.ve[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException unused) {
                        throw tt(strArr);
                    }
                }
                return;
            }
            throw tt(strArr);
        }

        public File c(int i) {
            return new File(c.this.uj, this.tt + Consts.DOT + i);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, SystemMessageConstants.JS_BRIDGE_METHOD_NOT_FOUND, 132})
    public final class ve implements Closeable {
        public final long[] n;
        public final String tt;
        public final InputStream[] uj;
        public final long ve;

        public InputStream c(int i) {
            return this.uj[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.uj) {
                com.byazt.as.tt.c(inputStream);
            }
        }

        private ve(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.tt = str;
            this.ve = j;
            this.uj = inputStreamArr;
            this.n = jArr;
        }
    }

    private c(File file, int i, int i2, long j, ExecutorService executorService) {
        this.uj = file;
        this.x = i;
        this.n = new File(file, a.t);
        this.f29029a = new File(file, a.u);
        this.sp = new File(file, a.v);
        this.da = i2;
        this.i = j;
        this.tt = executorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sp() throws IOException {
        long j = this.i;
        long j2 = this.z;
        if (j2 >= 0) {
            j = j2;
        }
        while (this.sl > j) {
            ve(this.u.entrySet().iterator().next().getKey());
        }
        this.z = -1L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.t == null) {
            return;
        }
        for (tt ttVar : new ArrayList(this.u.values())) {
            if (ttVar.n != null) {
                ttVar.n.tt();
            }
        }
        sp();
        this.t.close();
        this.t = null;
    }

    public void delete() throws IOException {
        close();
        uj.c(this.uj);
    }

    private void a() {
        if (this.t == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        int i = this.yp;
        return i >= 2000 && i >= this.u.size();
    }

    private void tt() throws IOException {
        com.byazt.ss.ve veVar = new com.byazt.ss.ve(new FileInputStream(this.n), uj.c);
        try {
            String strC = veVar.c();
            String strC2 = veVar.c();
            String strC3 = veVar.c();
            String strC4 = veVar.c();
            String strC5 = veVar.c();
            if (!a.w.equals(strC) || !"1".equals(strC2) || !Integer.toString(this.x).equals(strC3) || !Integer.toString(this.da).equals(strC4) || !"".equals(strC5)) {
                throw new IOException("unexpected journal header: [" + strC + ", " + strC2 + ", " + strC4 + ", " + strC5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    uj(veVar.c());
                    i++;
                } catch (EOFException unused) {
                    this.yp = i - this.u.size();
                    if (veVar.tt()) {
                        uj();
                    } else {
                        this.t = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.n, true), uj.c));
                    }
                    com.byazt.as.tt.c(veVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.byazt.as.tt.c(veVar);
            throw th;
        }
    }

    private void uj(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith(a.B)) {
                this.u.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        tt ttVar = this.u.get(strSubstring);
        if (ttVar == null) {
            ttVar = new tt(strSubstring);
            this.u.put(strSubstring, ttVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith(a.z)) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            ttVar.uj = true;
            ttVar.n = null;
            ttVar.c(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith(a.A)) {
            ttVar.n = new C0525c(ttVar);
        } else if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith(a.C)) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
    }

    private void ve() throws IOException {
        c(this.f29029a);
        Iterator<tt> it = this.u.values().iterator();
        while (it.hasNext()) {
            tt next = it.next();
            int i = 0;
            if (next.n == null) {
                while (i < this.da) {
                    this.sl += next.ve[i];
                    i++;
                }
            } else {
                next.n = null;
                while (i < this.da) {
                    c(next.c(i));
                    c(next.tt(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    public static c c(File file, int i, int i2, long j, ExecutorService executorService) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 > 0) {
            File file2 = new File(file, a.v);
            if (file2.exists()) {
                File file3 = new File(file, a.t);
                if (file3.exists()) {
                    file2.delete();
                } else {
                    c(file2, file3, false);
                }
            }
            c cVar = new c(file, i, i2, j, executorService);
            if (cVar.n.exists()) {
                try {
                    cVar.tt();
                    cVar.ve();
                    return cVar;
                } catch (IOException e) {
                    m.tt("DiskLruCache ", file + " is corrupt: " + e.getMessage() + ", removing");
                    cVar.delete();
                }
            }
            file.mkdirs();
            c cVar2 = new c(file, i, i2, j, executorService);
            cVar2.uj();
            return cVar2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    private void n(String str) {
        if (c.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public synchronized boolean ve(String str) throws IOException {
        a();
        n(str);
        tt ttVar = this.u.get(str);
        if (ttVar != null && ttVar.n == null) {
            for (int i = 0; i < this.da; i++) {
                File fileC = ttVar.c(i);
                if (fileC.exists() && !fileC.delete()) {
                    throw new IOException("failed to delete ".concat(String.valueOf(fileC)));
                }
                this.sl -= ttVar.ve[i];
                ttVar.ve[i] = 0;
            }
            this.yp++;
            this.t.append((CharSequence) ("REMOVE " + str + '\n'));
            this.u.remove(str);
            if (n()) {
                this.tt.submit(this.nu);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void uj() throws IOException {
        try {
            Writer writer = this.t;
            if (writer != null) {
                writer.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f29029a), uj.c));
            try {
                bufferedWriter.write(a.w);
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.x));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.da));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (tt ttVar : this.u.values()) {
                    if (ttVar.n != null) {
                        bufferedWriter.write("DIRTY " + ttVar.tt + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + ttVar.tt + ttVar.c() + '\n');
                    }
                }
                bufferedWriter.close();
                if (this.n.exists()) {
                    c(this.n, this.sp, true);
                }
                c(this.f29029a, this.n, false);
                this.sp.delete();
                this.t = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.n, true), uj.c));
            } catch (Throwable th) {
                bufferedWriter.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public C0525c tt(String str) throws IOException {
        return c(str, -1L);
    }

    private static void c(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void c(File file, File file2, boolean z) throws IOException {
        if (z) {
            c(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public synchronized ve c(String str) throws IOException {
        InputStream inputStream;
        a();
        n(str);
        tt ttVar = this.u.get(str);
        if (ttVar == null) {
            return null;
        }
        if (!ttVar.uj) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.da];
        for (int i = 0; i < this.da; i++) {
            try {
                inputStreamArr[i] = new FileInputStream(ttVar.c(i));
            } catch (FileNotFoundException unused) {
                for (int i2 = 0; i2 < this.da && (inputStream = inputStreamArr[i2]) != null; i2++) {
                    com.byazt.as.tt.c(inputStream);
                }
                return null;
            }
        }
        this.yp++;
        this.t.append((CharSequence) ("READ " + str + '\n'));
        if (n()) {
            this.tt.submit(this.nu);
        }
        return new ve(str, ttVar.f29030a, inputStreamArr, ttVar.ve);
    }

    private synchronized C0525c c(String str, long j) throws IOException {
        a();
        n(str);
        tt ttVar = this.u.get(str);
        if (j != -1 && (ttVar == null || ttVar.f29030a != j)) {
            return null;
        }
        if (ttVar != null) {
            if (ttVar.n != null) {
                return null;
            }
        } else {
            ttVar = new tt(str);
            this.u.put(str, ttVar);
        }
        C0525c c0525c = new C0525c(ttVar);
        ttVar.n = c0525c;
        this.t.write("DIRTY " + str + '\n');
        this.t.flush();
        return c0525c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(C0525c c0525c, boolean z) throws IOException {
        tt ttVar = c0525c.tt;
        if (ttVar.n == c0525c) {
            if (z && !ttVar.uj) {
                for (int i = 0; i < this.da; i++) {
                    if (c0525c.ve[i]) {
                        if (!ttVar.tt(i).exists()) {
                            c0525c.tt();
                            return;
                        }
                    } else {
                        c0525c.tt();
                        throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
                    }
                }
            }
            for (int i2 = 0; i2 < this.da; i2++) {
                File fileTt = ttVar.tt(i2);
                if (z) {
                    if (fileTt.exists()) {
                        File fileC = ttVar.c(i2);
                        fileTt.renameTo(fileC);
                        long j = ttVar.ve[i2];
                        long length = fileC.length();
                        ttVar.ve[i2] = length;
                        this.sl = (this.sl - j) + length;
                    }
                } else {
                    c(fileTt);
                }
            }
            this.yp++;
            ttVar.n = null;
            if (ttVar.uj | z) {
                ttVar.uj = true;
                this.t.write("CLEAN " + ttVar.tt + ttVar.c() + '\n');
                if (z) {
                    long j2 = this.m;
                    this.m = 1 + j2;
                    ttVar.f29030a = j2;
                }
            } else {
                this.u.remove(ttVar.tt);
                this.t.write("REMOVE " + ttVar.tt + '\n');
            }
            this.t.flush();
            if (this.sl > this.i || n()) {
                this.tt.submit(this.nu);
            }
            return;
        }
        throw new IllegalStateException();
    }

    public synchronized void c() throws IOException {
        a();
        sp();
        this.t.flush();
    }

    public void c(long j) {
        this.z = j;
        this.tt.submit(this.nu);
    }
}
