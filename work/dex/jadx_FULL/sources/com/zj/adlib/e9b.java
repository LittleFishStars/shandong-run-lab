package com.zj.adlib;

import com.alibaba.android.arouter.utils.Consts;
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
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class e9b implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OutputStream f41380a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ThreadFactory f16251a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static ThreadPoolExecutor f16252a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Pattern f16253a = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final Charset b = Charset.forName("US-ASCII");
    public static final Charset c = Charset.forName("UTF-8");
    public int N;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f16254a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final File f16255a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Writer f16256a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final File f16260b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final File f16262c;
    public final File d;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f16259b = 0;
    public int M = 1000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LinkedHashMap<String, f> f16257a = new LinkedHashMap<>(0, 0.75f, true);

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f16261c = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Callable<Void> f16258a = new b();
    public final int K = 1;
    public final int L = 1;

    public static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f41381a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "disklrucache#" + this.f41381a.getAndIncrement());
        }
    }

    public class b implements Callable<Void> {
        public b() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void call() throws Exception {
            synchronized (e9b.this) {
                if (e9b.this.f16256a == null) {
                    return null;
                }
                e9b.this.q0();
                if (e9b.this.m0()) {
                    e9b.this.k0();
                    e9b.L(e9b.this);
                }
                return null;
            }
        }
    }

    public static class c extends OutputStream {
        @Override // java.io.OutputStream
        public final void write(int i) throws IOException {
        }
    }

    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f41383a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f16264a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean[] f16265a;
        public boolean b;

        public class a extends FilterOutputStream {
            public /* synthetic */ a(d dVar, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    d.f(d.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    d.f(d.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    d.f(d.this);
                }
            }

            public a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    d.f(d.this);
                }
            }
        }

        public /* synthetic */ d(e9b e9bVar, f fVar, byte b) {
            this(fVar);
        }

        public static /* synthetic */ boolean f(d dVar) {
            dVar.f16264a = true;
            return true;
        }

        public final OutputStream b() throws IOException {
            FileOutputStream fileOutputStream;
            a aVar;
            if (e9b.this.L <= 0) {
                throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + e9b.this.L);
            }
            synchronized (e9b.this) {
                if (this.f41383a.f16269a != this) {
                    throw new IllegalStateException();
                }
                byte b = 0;
                if (!this.f41383a.f16272a) {
                    this.f16265a[0] = true;
                }
                File fileI = this.f41383a.i(0);
                try {
                    fileOutputStream = new FileOutputStream(fileI);
                } catch (FileNotFoundException unused) {
                    e9b.this.f16255a.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(fileI);
                    } catch (FileNotFoundException unused2) {
                        return e9b.f41380a;
                    }
                }
                aVar = new a(this, fileOutputStream, b);
            }
            return aVar;
        }

        public final void c() throws IOException {
            if (this.f16264a) {
                e9b.this.j(this, false);
                e9b.this.E(this.f41383a.f16271a);
            } else {
                e9b.this.j(this, true);
            }
            this.b = true;
        }

        public final void e() throws IOException {
            e9b.this.j(this, false);
        }

        public d(f fVar) {
            this.f41383a = fVar;
            this.f16265a = fVar.f16272a ? null : new boolean[e9b.this.L];
        }
    }

    public final class e implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f41385a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long[] f16267a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final InputStream[] f16268a;
        public final String f;

        public /* synthetic */ e(e9b e9bVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, byte b) {
            this(str, j, inputStreamArr, jArr);
        }

        public final InputStream a() {
            return this.f16268a[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.f16268a) {
                e9b.l(inputStream);
            }
        }

        public e(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.f = str;
            this.f41385a = j;
            this.f16268a = inputStreamArr;
            this.f16267a = jArr;
        }
    }

    public final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f41386a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public d f16269a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f16271a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f16272a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long[] f16273a;

        public /* synthetic */ f(e9b e9bVar, String str, byte b) {
            this(str);
        }

        public static IOException d(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public static /* synthetic */ void f(f fVar, String[] strArr) throws IOException {
            if (strArr.length != e9b.this.L) {
                throw d(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    fVar.f16273a[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw d(strArr);
                }
            }
        }

        public static /* synthetic */ boolean g(f fVar) {
            fVar.f16272a = true;
            return true;
        }

        public final File c(int i) {
            return new File(e9b.this.f16255a, this.f16271a + Consts.DOT + i);
        }

        public final String e() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.f16273a) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public final File i(int i) {
            return new File(e9b.this.f16255a, this.f16271a + Consts.DOT + i + ".tmp");
        }

        public f(String str) {
            this.f16271a = str;
            this.f16273a = new long[e9b.this.L];
        }
    }

    static {
        a aVar = new a();
        f16251a = aVar;
        f16252a = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), aVar);
        f41380a = new c();
    }

    public e9b(File file, long j) {
        this.f16255a = file;
        this.f16260b = new File(file, com.ipd.dsp.internal.d.a.t);
        this.f16262c = new File(file, com.ipd.dsp.internal.d.a.u);
        this.d = new File(file, com.ipd.dsp.internal.d.a.v);
        this.f16254a = j;
    }

    public static /* synthetic */ int L(e9b e9bVar) {
        e9bVar.N = 0;
        return 0;
    }

    public static void R(String str) {
        if (f16253a.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public static ThreadPoolExecutor W() {
        try {
            ThreadPoolExecutor threadPoolExecutor = f16252a;
            if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                f16252a = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), f16251a);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f16252a;
    }

    public static e9b c(File file, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        File file2 = new File(file, com.ipd.dsp.internal.d.a.v);
        if (file2.exists()) {
            File file3 = new File(file, com.ipd.dsp.internal.d.a.t);
            if (file3.exists()) {
                file2.delete();
            } else {
                p(file2, file3, false);
            }
        }
        e9b e9bVar = new e9b(file, j);
        if (e9bVar.f16260b.exists()) {
            try {
                e9bVar.i0();
                e9bVar.j0();
                e9bVar.f16256a = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(e9bVar.f16260b, true), b));
                return e9bVar;
            } catch (Throwable unused) {
                e9bVar.H();
            }
        }
        file.mkdirs();
        e9b e9bVar2 = new e9b(file, j);
        e9bVar2.k0();
        return e9bVar2;
    }

    public static void g() {
        ThreadPoolExecutor threadPoolExecutor = f16252a;
        if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        f16252a.shutdown();
    }

    public static void l(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static void m(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void p(File file, File file2, boolean z) throws IOException {
        if (z) {
            m(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public static void v(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                v(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: ".concat(String.valueOf(file2)));
            }
        }
    }

    public final synchronized boolean E(String str) throws IOException {
        o0();
        R(str);
        f fVar = this.f16257a.get(str);
        if (fVar != null && fVar.f16269a == null) {
            for (int i = 0; i < this.L; i++) {
                File fileC = fVar.c(i);
                if (fileC.exists() && !fileC.delete()) {
                    throw new IOException("failed to delete ".concat(String.valueOf(fileC)));
                }
                this.f16259b -= fVar.f16273a[i];
                fVar.f16273a[i] = 0;
            }
            this.N++;
            this.f16256a.append((CharSequence) ("REMOVE " + str + '\n'));
            this.f16257a.remove(str);
            if (m0()) {
                W().submit(this.f16258a);
            }
            return true;
        }
        return false;
    }

    public final synchronized d F(String str) throws IOException {
        o0();
        R(str);
        f fVar = this.f16257a.get(str);
        byte b2 = 0;
        if (fVar == null) {
            fVar = new f(this, str, b2);
            this.f16257a.put(str, fVar);
        } else if (fVar.f16269a != null) {
            return null;
        }
        d dVar = new d(this, fVar, b2);
        fVar.f16269a = dVar;
        this.f16256a.write("DIRTY " + str + '\n');
        this.f16256a.flush();
        return dVar;
    }

    public final void H() throws IOException {
        close();
        v(this.f16255a);
    }

    public final synchronized e b(String str) throws IOException {
        InputStream inputStream;
        o0();
        R(str);
        f fVar = this.f16257a.get(str);
        if (fVar == null) {
            return null;
        }
        if (!fVar.f16272a) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.L];
        for (int i = 0; i < this.L; i++) {
            try {
                inputStreamArr[i] = new FileInputStream(fVar.c(i));
            } catch (FileNotFoundException unused) {
                for (int i2 = 0; i2 < this.L && (inputStream = inputStreamArr[i2]) != null; i2++) {
                    l(inputStream);
                }
                return null;
            }
        }
        this.N++;
        this.f16256a.append((CharSequence) ("READ " + str + '\n'));
        if (m0()) {
            W().submit(this.f16258a);
        }
        return new e(this, str, fVar.f41386a, inputStreamArr, fVar.f16273a, (byte) 0);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        if (this.f16256a == null) {
            return;
        }
        for (f fVar : new ArrayList(this.f16257a.values())) {
            if (fVar.f16269a != null) {
                fVar.f16269a.e();
            }
        }
        q0();
        this.f16256a.close();
        this.f16256a = null;
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0004 A[PHI: r0
      0x0004: PHI (r0v2 int) = (r0v0 int), (r0v1 int) binds: [B:3:0x0002, B:6:0x0008] A[DONT_GENERATE, DONT_INLINE]] */
    public final void h(int i) {
        int i2 = 10;
        if (i < 10) {
            i = i2;
        } else {
            i2 = 10000;
            if (i > 10000) {
                i = i2;
            }
        }
        this.M = i;
    }

    public final void i0() throws IOException {
        String strSubstring;
        f9b f9bVar = new f9b(new FileInputStream(this.f16260b), b);
        try {
            String strA = f9bVar.a();
            String strA2 = f9bVar.a();
            String strA3 = f9bVar.a();
            String strA4 = f9bVar.a();
            String strA5 = f9bVar.a();
            if (!com.ipd.dsp.internal.d.a.w.equals(strA) || !"1".equals(strA2) || !Integer.toString(this.K).equals(strA3) || !Integer.toString(this.L).equals(strA4) || !"".equals(strA5)) {
                throw new IOException("unexpected journal header: [" + strA + ", " + strA2 + ", " + strA4 + ", " + strA5 + "]");
            }
            byte b2 = 0;
            int i = 0;
            while (true) {
                try {
                    String strA6 = f9bVar.a();
                    int iIndexOf = strA6.indexOf(32);
                    if (iIndexOf == -1) {
                        throw new IOException("unexpected journal line: ".concat(strA6));
                    }
                    int i2 = iIndexOf + 1;
                    int iIndexOf2 = strA6.indexOf(32, i2);
                    if (iIndexOf2 == -1) {
                        strSubstring = strA6.substring(i2);
                        if (iIndexOf == 6 && strA6.startsWith(com.ipd.dsp.internal.d.a.B)) {
                            this.f16257a.remove(strSubstring);
                        }
                        i++;
                    } else {
                        strSubstring = strA6.substring(i2, iIndexOf2);
                    }
                    f fVar = this.f16257a.get(strSubstring);
                    if (fVar == null) {
                        fVar = new f(this, strSubstring, b2);
                        this.f16257a.put(strSubstring, fVar);
                    }
                    if (iIndexOf2 != -1 && iIndexOf == 5 && strA6.startsWith(com.ipd.dsp.internal.d.a.z)) {
                        String[] strArrSplit = strA6.substring(iIndexOf2 + 1).split(" ");
                        f.g(fVar);
                        fVar.f16269a = null;
                        f.f(fVar, strArrSplit);
                    } else if (iIndexOf2 == -1 && iIndexOf == 5 && strA6.startsWith(com.ipd.dsp.internal.d.a.A)) {
                        fVar.f16269a = new d(this, fVar, b2);
                    } else if (iIndexOf2 != -1 || iIndexOf != 4 || !strA6.startsWith(com.ipd.dsp.internal.d.a.C)) {
                        throw new IOException("unexpected journal line: ".concat(strA6));
                    }
                    i++;
                } catch (EOFException unused) {
                    this.N = i - this.f16257a.size();
                    l(f9bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            l(f9bVar);
            throw th;
        }
    }

    public final synchronized void j(d dVar, boolean z) throws IOException {
        f fVar = dVar.f41383a;
        if (fVar.f16269a != dVar) {
            throw new IllegalStateException();
        }
        if (z && !fVar.f16272a) {
            for (int i = 0; i < this.L; i++) {
                if (!dVar.f16265a[i]) {
                    dVar.e();
                    throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
                }
                if (!fVar.i(i).exists()) {
                    dVar.e();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.L; i2++) {
            File fileI = fVar.i(i2);
            if (!z) {
                m(fileI);
            } else if (fileI.exists()) {
                File fileC = fVar.c(i2);
                fileI.renameTo(fileC);
                long j = fVar.f16273a[i2];
                long length = fileC.length();
                fVar.f16273a[i2] = length;
                this.f16259b = (this.f16259b - j) + length;
            }
        }
        this.N++;
        fVar.f16269a = null;
        if (fVar.f16272a || z) {
            f.g(fVar);
            this.f16256a.write("CLEAN " + fVar.f16271a + fVar.e() + '\n');
            if (z) {
                long j2 = this.f16261c;
                this.f16261c = 1 + j2;
                fVar.f41386a = j2;
            }
        } else {
            this.f16257a.remove(fVar.f16271a);
            this.f16256a.write("REMOVE " + fVar.f16271a + '\n');
        }
        this.f16256a.flush();
        if (this.f16259b > this.f16254a || m0()) {
            W().submit(this.f16258a);
        }
    }

    public final void j0() throws IOException {
        m(this.f16262c);
        Iterator<f> it = this.f16257a.values().iterator();
        while (it.hasNext()) {
            f next = it.next();
            int i = 0;
            if (next.f16269a == null) {
                while (i < this.L) {
                    this.f16259b += next.f16273a[i];
                    i++;
                }
            } else {
                next.f16269a = null;
                while (i < this.L) {
                    m(next.c(i));
                    m(next.i(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    public final synchronized void k0() throws IOException {
        try {
            Writer writer = this.f16256a;
            if (writer != null) {
                writer.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f16262c), b));
            try {
                bufferedWriter.write(com.ipd.dsp.internal.d.a.w);
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.K));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.L));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (f fVar : this.f16257a.values()) {
                    if (fVar.f16269a != null) {
                        bufferedWriter.write("DIRTY " + fVar.f16271a + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + fVar.f16271a + fVar.e() + '\n');
                    }
                }
                bufferedWriter.close();
                if (this.f16260b.exists()) {
                    p(this.f16260b, this.d, true);
                }
                p(this.f16262c, this.f16260b, false);
                this.d.delete();
                this.f16256a = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f16260b, true), b));
            } catch (Throwable th) {
                bufferedWriter.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final boolean m0() {
        int i = this.N;
        return i >= 2000 && i >= this.f16257a.size();
    }

    public final void o0() {
        if (this.f16256a == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final d q(String str) throws IOException {
        return F(str);
    }

    public final void q0() throws IOException {
        while (true) {
            if (this.f16259b <= this.f16254a && this.f16257a.size() <= this.M) {
                return;
            } else {
                E(this.f16257a.entrySet().iterator().next().getKey());
            }
        }
    }

    public final File r() {
        return this.f16255a;
    }

    public final synchronized void w() throws IOException {
        o0();
        q0();
        this.f16256a.flush();
    }
}
