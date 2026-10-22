package com.ipd.dsp.internal.d;

import android.annotation.TargetApi;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a implements Closeable {
    public static final String A = "DIRTY";
    public static final String B = "REMOVE";
    public static final String C = "READ";
    public static final String t = "journal";
    public static final String u = "journal.tmp";
    public static final String v = "journal.bkp";
    public static final String w = "libcore.io.DiskLruCache";
    public static final String x = "1";
    public static final long y = -1;
    public static final String z = "CLEAN";
    public final File f;
    public final File g;
    public final File h;
    public final File i;
    public final int j;
    public long k;
    public final int l;
    public Writer n;
    public int p;
    public long m = 0;
    public final LinkedHashMap<String, d> o = new LinkedHashMap<>(0, 0.75f, true);
    public long q = 0;
    public final ThreadPoolExecutor r = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));
    public final Callable<Void> s = new CallableC0874a();

    /* JADX INFO: renamed from: com.ipd.dsp.internal.d.a$a, reason: collision with other inner class name */
    public class CallableC0874a implements Callable<Void> {
        public CallableC0874a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (a.this) {
                if (a.this.n == null) {
                    return null;
                }
                a.this.i();
                if (a.this.e()) {
                    a.this.h();
                    a.this.p = 0;
                }
                return null;
            }
        }
    }

    public static final class b implements ThreadFactory {
        public b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        public /* synthetic */ b(CallableC0874a callableC0874a) {
            this();
        }
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f38268a;
        public final boolean[] b;
        public boolean c;

        public /* synthetic */ c(a aVar, d dVar, CallableC0874a callableC0874a) {
            this(dVar);
        }

        public final InputStream c(int i) throws IOException {
            synchronized (a.this) {
                if (this.f38268a.f != this) {
                    throw new IllegalStateException();
                }
                if (!this.f38268a.e) {
                    return null;
                }
                try {
                    return new FileInputStream(this.f38268a.a(i));
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }
        }

        public c(d dVar) {
            this.f38268a = dVar;
            this.b = dVar.e ? null : new boolean[a.this.l];
        }

        public File a(int i) throws IOException {
            File fileB;
            synchronized (a.this) {
                if (this.f38268a.f != this) {
                    throw new IllegalStateException();
                }
                if (!this.f38268a.e) {
                    this.b[i] = true;
                }
                fileB = this.f38268a.b(i);
                a.this.f.mkdirs();
            }
            return fileB;
        }

        public String b(int i) throws IOException {
            InputStream inputStreamC = c(i);
            if (inputStreamC != null) {
                return a.b(inputStreamC);
            }
            return null;
        }

        public void b() {
            if (this.c) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void c() throws IOException {
            a.this.a(this, true);
            this.c = true;
        }

        public void a(int i, String str) throws Throwable {
            OutputStreamWriter outputStreamWriter = null;
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(a(i)), com.ipd.dsp.internal.d.c.b);
                try {
                    outputStreamWriter2.write(str);
                    com.ipd.dsp.internal.d.c.a(outputStreamWriter2);
                } catch (Throwable th) {
                    th = th;
                    outputStreamWriter = outputStreamWriter2;
                    com.ipd.dsp.internal.d.c.a(outputStreamWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        public void a() throws IOException {
            a.this.a(this, false);
        }
    }

    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f38269a;
        public final long[] b;
        public File[] c;
        public File[] d;
        public boolean e;
        public c f;
        public long g;

        public /* synthetic */ d(a aVar, String str, CallableC0874a callableC0874a) {
            this(str);
        }

        public d(String str) {
            this.f38269a = str;
            this.b = new long[a.this.l];
            this.c = new File[a.this.l];
            this.d = new File[a.this.l];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < a.this.l; i++) {
                sb.append(i);
                this.c[i] = new File(a.this.f, sb.toString());
                sb.append(".tmp");
                this.d[i] = new File(a.this.f, sb.toString());
                sb.setLength(length);
            }
        }

        public final void b(String[] strArr) throws IOException {
            if (strArr.length != a.this.l) {
                throw a(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.b[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw a(strArr);
                }
            }
        }

        public String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.b) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public File b(int i) {
            return this.d[i];
        }

        public final IOException a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i) {
            return this.c[i];
        }
    }

    public final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f38270a;
        public final long b;
        public final long[] c;
        public final File[] d;

        public /* synthetic */ e(a aVar, String str, long j, File[] fileArr, long[] jArr, CallableC0874a callableC0874a) {
            this(str, j, fileArr, jArr);
        }

        public c a() throws IOException {
            return a.this.a(this.f38270a, this.b);
        }

        public long b(int i) {
            return this.c[i];
        }

        public String c(int i) throws IOException {
            return a.b(new FileInputStream(this.d[i]));
        }

        public e(String str, long j, File[] fileArr, long[] jArr) {
            this.f38270a = str;
            this.b = j;
            this.d = fileArr;
            this.c = jArr;
        }

        public File a(int i) {
            return this.d[i];
        }
    }

    public a(File file, int i, int i2, long j) {
        this.f = file;
        this.j = i;
        this.g = new File(file, t);
        this.h = new File(file, u);
        this.i = new File(file, v);
        this.l = i2;
        this.k = j;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.n == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.o.values());
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            d dVar = (d) obj;
            if (dVar.f != null) {
                dVar.f.a();
            }
        }
        i();
        a(this.n);
        this.n = null;
    }

    public synchronized void flush() throws IOException {
        a();
        i();
        b(this.n);
    }

    public final void g() throws IOException {
        com.ipd.dsp.internal.d.b bVar = new com.ipd.dsp.internal.d.b(new FileInputStream(this.g), com.ipd.dsp.internal.d.c.f38271a);
        try {
            String strC = bVar.c();
            String strC2 = bVar.c();
            String strC3 = bVar.c();
            String strC4 = bVar.c();
            String strC5 = bVar.c();
            if (!w.equals(strC) || !"1".equals(strC2) || !Integer.toString(this.j).equals(strC3) || !Integer.toString(this.l).equals(strC4) || !"".equals(strC5)) {
                throw new IOException("unexpected journal header: [" + strC + ", " + strC2 + ", " + strC4 + ", " + strC5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    c(bVar.c());
                    i++;
                } catch (EOFException unused) {
                    this.p = i - this.o.size();
                    if (bVar.b()) {
                        h();
                    } else {
                        this.n = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.g, true), com.ipd.dsp.internal.d.c.f38271a));
                    }
                    com.ipd.dsp.internal.d.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.ipd.dsp.internal.d.c.a(bVar);
            throw th;
        }
    }

    public final synchronized void h() throws IOException {
        Writer writer = this.n;
        if (writer != null) {
            a(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.h), com.ipd.dsp.internal.d.c.f38271a));
        try {
            bufferedWriter.write(w);
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.j));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.l));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (d dVar : this.o.values()) {
                if (dVar.f != null) {
                    bufferedWriter.write("DIRTY " + dVar.f38269a + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + dVar.f38269a + dVar.a() + '\n');
                }
            }
            a(bufferedWriter);
            if (this.g.exists()) {
                a(this.g, this.i, true);
            }
            a(this.h, this.g, false);
            this.i.delete();
            this.n = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.g, true), com.ipd.dsp.internal.d.c.f38271a));
        } catch (Throwable th) {
            a(bufferedWriter);
            throw th;
        }
    }

    public final void i() throws IOException {
        while (this.m > this.k) {
            d(this.o.entrySet().iterator().next().getKey());
        }
    }

    public synchronized boolean isClosed() {
        return this.n == null;
    }

    public synchronized long size() {
        return this.m;
    }

    public synchronized e b(String str) throws IOException {
        a();
        d dVar = this.o.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.e) {
            return null;
        }
        for (File file : dVar.c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.p++;
        this.n.append((CharSequence) C);
        this.n.append(' ');
        this.n.append((CharSequence) str);
        this.n.append('\n');
        if (e()) {
            this.r.submit(this.s);
        }
        return new e(this, str, dVar.g, dVar.c, dVar.b, null);
    }

    public final void c(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith(B)) {
                this.o.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        d dVar = this.o.get(strSubstring);
        CallableC0874a callableC0874a = null;
        if (dVar == null) {
            dVar = new d(this, strSubstring, callableC0874a);
            this.o.put(strSubstring, dVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith(z)) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            dVar.e = true;
            dVar.f = null;
            dVar.b(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith(A)) {
            dVar.f = new c(this, dVar, callableC0874a);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith(C)) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public synchronized long d() {
        return this.k;
    }

    public final boolean e() {
        int i = this.p;
        return i >= 2000 && i >= this.o.size();
    }

    public final void f() throws IOException {
        a(this.h);
        Iterator<d> it = this.o.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i = 0;
            if (next.f == null) {
                while (i < this.l) {
                    this.m += next.b[i];
                    i++;
                }
            } else {
                next.f = null;
                while (i < this.l) {
                    a(next.a(i));
                    a(next.b(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    public synchronized boolean d(String str) throws IOException {
        a();
        d dVar = this.o.get(str);
        if (dVar != null && dVar.f == null) {
            for (int i = 0; i < this.l; i++) {
                File fileA = dVar.a(i);
                if (fileA.exists() && !fileA.delete()) {
                    throw new IOException("failed to delete " + fileA);
                }
                this.m -= dVar.b[i];
                dVar.b[i] = 0;
            }
            this.p++;
            this.n.append((CharSequence) B);
            this.n.append(' ');
            this.n.append((CharSequence) str);
            this.n.append('\n');
            this.o.remove(str);
            if (e()) {
                this.r.submit(this.s);
            }
            return true;
        }
        return false;
    }

    public static a a(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 > 0) {
            File file2 = new File(file, v);
            if (file2.exists()) {
                File file3 = new File(file, t);
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            a aVar = new a(file, i, i2, j);
            if (aVar.g.exists()) {
                try {
                    aVar.g();
                    aVar.f();
                    return aVar;
                } catch (IOException e2) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                    aVar.b();
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, i, i2, j);
            aVar2.h();
            return aVar2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    public void b() throws IOException {
        close();
        com.ipd.dsp.internal.d.c.a(this.f);
    }

    public static String b(InputStream inputStream) throws IOException {
        return com.ipd.dsp.internal.d.c.a((Reader) new InputStreamReader(inputStream, com.ipd.dsp.internal.d.c.b));
    }

    @TargetApi(26)
    public static void b(Writer writer) throws IOException {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public File c() {
        return this.f;
    }

    public static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void a(File file, File file2, boolean z2) throws IOException {
        if (z2) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public c a(String str) throws IOException {
        return a(str, -1L);
    }

    public final synchronized c a(String str, long j) throws IOException {
        a();
        d dVar = this.o.get(str);
        CallableC0874a callableC0874a = null;
        if (j != -1 && (dVar == null || dVar.g != j)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str, callableC0874a);
            this.o.put(str, dVar);
        } else if (dVar.f != null) {
            return null;
        }
        c cVar = new c(this, dVar, callableC0874a);
        dVar.f = cVar;
        this.n.append((CharSequence) A);
        this.n.append(' ');
        this.n.append((CharSequence) str);
        this.n.append('\n');
        b(this.n);
        return cVar;
    }

    public synchronized void a(long j) {
        this.k = j;
        this.r.submit(this.s);
    }

    public final synchronized void a(c cVar, boolean z2) throws IOException {
        d dVar = cVar.f38268a;
        if (dVar.f == cVar) {
            if (z2 && !dVar.e) {
                for (int i = 0; i < this.l; i++) {
                    if (cVar.b[i]) {
                        if (!dVar.b(i).exists()) {
                            cVar.a();
                            return;
                        }
                    } else {
                        cVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                }
            }
            for (int i2 = 0; i2 < this.l; i2++) {
                File fileB = dVar.b(i2);
                if (z2) {
                    if (fileB.exists()) {
                        File fileA = dVar.a(i2);
                        fileB.renameTo(fileA);
                        long j = dVar.b[i2];
                        long length = fileA.length();
                        dVar.b[i2] = length;
                        this.m = (this.m - j) + length;
                    }
                } else {
                    a(fileB);
                }
            }
            this.p++;
            dVar.f = null;
            if (!(dVar.e | z2)) {
                this.o.remove(dVar.f38269a);
                this.n.append((CharSequence) B);
                this.n.append(' ');
                this.n.append((CharSequence) dVar.f38269a);
                this.n.append('\n');
            } else {
                dVar.e = true;
                this.n.append((CharSequence) z);
                this.n.append(' ');
                this.n.append((CharSequence) dVar.f38269a);
                this.n.append((CharSequence) dVar.a());
                this.n.append('\n');
                if (z2) {
                    long j2 = this.q;
                    this.q = 1 + j2;
                    dVar.g = j2;
                }
            }
            b(this.n);
            if (this.m > this.k || e()) {
                this.r.submit(this.s);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public final void a() {
        if (this.n == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @TargetApi(26)
    public static void a(Writer writer) throws IOException {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}
