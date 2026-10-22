package com.kwad.sdk.core.diskcache.a;

import com.kwad.sdk.utils.y;
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
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a implements Closeable {
    private int aRB;
    private final File aRs;
    private final File aRt;
    private final File aRu;
    private final File aRv;
    private final int aRw;
    private int aRx;
    private final int aRy;
    private Writer aRz;
    private long maxSize;
    static final Pattern aRr = Pattern.compile("[a-z0-9_-]{1,64}");
    private static final OutputStream aRF = new OutputStream() { // from class: com.kwad.sdk.core.diskcache.a.a.3
        @Override // java.io.OutputStream
        public final void write(int i) {
        }
    };
    private long size = 0;
    private int aiu = 0;
    private final LinkedHashMap<String, b> aRA = new LinkedHashMap<>(0, 0.75f, true);
    private long aRC = 0;
    final ThreadPoolExecutor aRD = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.core.diskcache.a.a.1
        private final AtomicInteger poolNumber = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ksad-DiskLruCache-" + this.poolNumber.getAndIncrement());
        }
    });
    private final Callable<Void> aRE = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.a.a.2
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: Ln, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (a.this) {
                if (a.this.aRz == null) {
                    return null;
                }
                a.this.trimToSize();
                a.this.Lt();
                if (a.this.Ls()) {
                    a.this.Lq();
                    a.a(a.this, 0);
                }
                return null;
            }
        }
    };

    /* JADX INFO: renamed from: com.kwad.sdk.core.diskcache.a.a$a, reason: collision with other inner class name */
    public final class C1276a {
        private final b aRH;
        private final boolean[] aRI;
        private boolean aRJ;
        private boolean aRK;

        /* JADX INFO: renamed from: com.kwad.sdk.core.diskcache.a.a$a$a, reason: collision with other inner class name */
        public class C1277a extends FilterOutputStream {
            public /* synthetic */ C1277a(C1276a c1276a, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C1276a.b(C1276a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C1276a.b(C1276a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    C1276a.b(C1276a.this, true);
                }
            }

            private C1277a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C1276a.b(C1276a.this, true);
                }
            }
        }

        public /* synthetic */ C1276a(a aVar, b bVar, byte b) {
            this(bVar);
        }

        public static /* synthetic */ boolean b(C1276a c1276a, boolean z) {
            c1276a.aRJ = true;
            return true;
        }

        public final void abort() {
            a.this.a(this, false);
        }

        public final void commit() {
            if (this.aRJ) {
                a.this.a(this, false);
                a.this.remove(this.aRH.key);
            } else {
                a.this.a(this, true);
            }
            this.aRK = true;
        }

        public final OutputStream es(int i) {
            FileOutputStream fileOutputStream;
            C1277a c1277a;
            synchronized (a.this) {
                if (this.aRH.aRO != this) {
                    throw new IllegalStateException();
                }
                byte b = 0;
                if (!this.aRH.aRN) {
                    this.aRI[0] = true;
                }
                File fileEu = this.aRH.eu(0);
                try {
                    fileOutputStream = new FileOutputStream(fileEu);
                } catch (FileNotFoundException unused) {
                    a.this.aRs.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(fileEu);
                    } catch (FileNotFoundException unused2) {
                        return a.aRF;
                    }
                }
                c1277a = new C1277a(this, fileOutputStream, b);
            }
            return c1277a;
        }

        private C1276a(b bVar) {
            this.aRH = bVar;
            this.aRI = bVar.aRN ? null : new boolean[a.this.aRy];
        }
    }

    public final class b {
        private final long[] aRM;
        private boolean aRN;
        private C1276a aRO;
        private long aRP;
        private final String key;

        public /* synthetic */ b(a aVar, String str, byte b) {
            this(str);
        }

        public final String Lv() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.aRM) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public final File et(int i) {
            return new File(a.this.aRs, this.key + i);
        }

        public final File eu(int i) {
            return new File(a.this.aRs, this.key + i + ".tmp");
        }

        private b(String str) {
            this.key = str;
            this.aRM = new long[a.this.aRy];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) throws IOException {
            if (strArr.length != a.this.aRy) {
                throw c(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.aRM[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw c(strArr);
                }
            }
        }

        private static IOException c(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public static /* synthetic */ boolean a(b bVar, boolean z) {
            bVar.aRN = true;
            return true;
        }
    }

    public final class c implements Closeable {
        private final long[] aRM;
        private final long aRP;
        private File[] aRQ;
        private final InputStream[] aRR;
        private final String key;

        public /* synthetic */ c(a aVar, String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr, byte b) {
            this(str, j, fileArr, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.aRR) {
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            }
        }

        public final File ev(int i) {
            return this.aRQ[0];
        }

        private c(String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.aRP = j;
            this.aRQ = fileArr;
            this.aRR = inputStreamArr;
            this.aRM = jArr;
        }
    }

    private a(File file, int i, int i2, long j, int i3) {
        this.aRs = file;
        this.aRw = i;
        this.aRt = new File(file, com.ipd.dsp.internal.d.a.t);
        this.aRu = new File(file, com.ipd.dsp.internal.d.a.u);
        this.aRv = new File(file, com.ipd.dsp.internal.d.a.v);
        this.aRy = i2;
        this.maxSize = j;
        this.aRx = i3;
    }

    private void Lo() {
        com.kwad.sdk.core.diskcache.a.b bVar = new com.kwad.sdk.core.diskcache.a.b(new FileInputStream(this.aRt), com.kwad.sdk.crash.utils.a.US_ASCII);
        try {
            String line = bVar.readLine();
            String line2 = bVar.readLine();
            String line3 = bVar.readLine();
            String line4 = bVar.readLine();
            String line5 = bVar.readLine();
            if (!com.ipd.dsp.internal.d.a.w.equals(line) || !"1".equals(line2) || !Integer.toString(this.aRw).equals(line3) || !Integer.toString(this.aRy).equals(line4) || !"".equals(line5)) {
                throw new IOException("unexpected journal header: [" + line + ", " + line2 + ", " + line4 + ", " + line5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    em(bVar.readLine());
                    i++;
                } catch (EOFException unused) {
                    this.aRB = i - this.aRA.size();
                    com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
            throw th;
        }
    }

    private void Lp() throws IOException {
        p(this.aRu);
        Iterator<b> it = this.aRA.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i = 0;
            if (next.aRO == null) {
                while (i < this.aRy) {
                    this.size += next.aRM[i];
                    this.aiu++;
                    i++;
                }
            } else {
                next.aRO = null;
                while (i < this.aRy) {
                    p(next.et(i));
                    p(next.eu(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Lq() {
        try {
            Writer writer = this.aRz;
            if (writer != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly(writer);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aRu), com.kwad.sdk.crash.utils.a.US_ASCII));
            try {
                bufferedWriter.write(com.ipd.dsp.internal.d.a.w);
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.aRw));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.aRy));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (b bVar : this.aRA.values()) {
                    if (bVar.aRO != null) {
                        bufferedWriter.write("DIRTY " + bVar.key + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + bVar.key + bVar.Lv() + '\n');
                    }
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedWriter);
                if (this.aRt.exists()) {
                    a(this.aRt, this.aRv, true);
                }
                a(this.aRu, this.aRt, false);
                this.aRv.delete();
                this.aRz = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aRt, true), com.kwad.sdk.crash.utils.a.US_ASCII));
            } catch (Throwable th) {
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedWriter);
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ls() {
        int i = this.aRB;
        return i >= 2000 && i >= this.aRA.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lt() {
        while (this.aiu > this.aRx) {
            remove(this.aRA.entrySet().iterator().next().getKey());
        }
    }

    public static /* synthetic */ int a(a aVar, int i) {
        aVar.aRB = 0;
        return 0;
    }

    private void checkNotClosed() {
        if (this.aRz == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void em(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith(com.ipd.dsp.internal.d.a.B)) {
                this.aRA.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        b bVar = this.aRA.get(strSubstring);
        byte b2 = 0;
        if (bVar == null) {
            bVar = new b(this, strSubstring, b2);
            this.aRA.put(strSubstring, bVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith(com.ipd.dsp.internal.d.a.z)) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            b.a(bVar, true);
            bVar.aRO = null;
            bVar.b(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith(com.ipd.dsp.internal.d.a.A)) {
            bVar.aRO = new C1276a(this, bVar, b2);
        } else {
            if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith(com.ipd.dsp.internal.d.a.C)) {
                return;
            }
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private static void ep(String str) {
        if (aRr.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
    }

    private static void p(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.maxSize) {
            remove(this.aRA.entrySet().iterator().next().getKey());
        }
    }

    public final synchronized int Lr() {
        return this.aRx;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.aRz == null) {
            return;
        }
        for (b bVar : new ArrayList(this.aRA.values())) {
            if (bVar.aRO != null) {
                bVar.aRO.abort();
            }
        }
        trimToSize();
        Lt();
        com.kwad.sdk.crash.utils.b.closeQuietly(this.aRz);
        this.aRz = null;
    }

    public final void delete() {
        close();
        y.deleteContents(this.aRs);
    }

    public final synchronized c en(String str) {
        InputStream inputStream;
        if (this.aRz == null) {
            return null;
        }
        ep(str);
        b bVar = this.aRA.get(str);
        if (bVar == null) {
            return null;
        }
        if (!bVar.aRN) {
            return null;
        }
        int i = this.aRy;
        File[] fileArr = new File[i];
        InputStream[] inputStreamArr = new InputStream[i];
        for (int i2 = 0; i2 < this.aRy; i2++) {
            try {
                File fileEt = bVar.et(i2);
                fileArr[i2] = fileEt;
                inputStreamArr[i2] = new FileInputStream(fileEt);
            } catch (FileNotFoundException unused) {
                for (int i3 = 0; i3 < this.aRy && (inputStream = inputStreamArr[i3]) != null; i3++) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                }
                return null;
            }
        }
        this.aRB++;
        this.aRz.append((CharSequence) ("READ " + str + '\n'));
        if (Ls()) {
            this.aRD.submit(this.aRE);
        }
        return new c(this, str, bVar.aRP, fileArr, inputStreamArr, bVar.aRM, (byte) 0);
    }

    public final C1276a eo(String str) {
        return e(str, -1L);
    }

    public final synchronized void flush() {
        checkNotClosed();
        trimToSize();
        Lt();
        this.aRz.flush();
    }

    public final File getDirectory() {
        return this.aRs;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final synchronized boolean remove(String str) {
        checkNotClosed();
        ep(str);
        b bVar = this.aRA.get(str);
        if (bVar != null && bVar.aRO == null) {
            for (int i = 0; i < this.aRy; i++) {
                File fileEt = bVar.et(i);
                if (fileEt.exists() && !fileEt.delete()) {
                    throw new IOException("failed to delete " + fileEt);
                }
                this.size -= bVar.aRM[i];
                this.aiu--;
                bVar.aRM[i] = 0;
            }
            this.aRB++;
            this.aRz.append((CharSequence) ("REMOVE " + str + '\n'));
            this.aRA.remove(str);
            if (Ls()) {
                this.aRD.submit(this.aRE);
            }
            return true;
        }
        return false;
    }

    private synchronized C1276a e(String str, long j) {
        checkNotClosed();
        ep(str);
        b bVar = this.aRA.get(str);
        byte b2 = 0;
        if (bVar == null) {
            bVar = new b(this, str, b2);
            this.aRA.put(str, bVar);
        } else if (bVar.aRO != null) {
            return null;
        }
        C1276a c1276a = new C1276a(this, bVar, b2);
        bVar.aRO = c1276a;
        this.aRz.write("DIRTY " + str + '\n');
        this.aRz.flush();
        return c1276a;
    }

    public static a a(File file, int i, int i2, long j) {
        return a(file, 1, 1, 209715200L, Integer.MAX_VALUE);
    }

    public static a a(File file, int i, int i2, long j, int i3) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i3 <= 0) {
            throw new IllegalArgumentException("maxFileCount <= 0");
        }
        if (i2 > 0) {
            File file2 = new File(file, com.ipd.dsp.internal.d.a.v);
            if (file2.exists()) {
                File file3 = new File(file, com.ipd.dsp.internal.d.a.t);
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            a aVar = new a(file, i, i2, j, i3);
            if (aVar.aRt.exists()) {
                try {
                    aVar.Lo();
                    aVar.Lp();
                    aVar.aRz = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aVar.aRt, true), com.kwad.sdk.crash.utils.a.US_ASCII));
                    return aVar;
                } catch (IOException e) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    aVar.delete();
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, i, i2, j, i3);
            aVar2.Lq();
            return aVar2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    private static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            p(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(C1276a c1276a, boolean z) {
        b bVar = c1276a.aRH;
        if (bVar.aRO == c1276a) {
            if (z && !bVar.aRN) {
                for (int i = 0; i < this.aRy; i++) {
                    if (c1276a.aRI[i]) {
                        if (!bVar.eu(i).exists()) {
                            c1276a.abort();
                            return;
                        }
                    } else {
                        c1276a.abort();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                }
            }
            for (int i2 = 0; i2 < this.aRy; i2++) {
                File fileEu = bVar.eu(i2);
                if (z) {
                    if (fileEu.exists()) {
                        File fileEt = bVar.et(i2);
                        fileEu.renameTo(fileEt);
                        long j = bVar.aRM[i2];
                        long length = fileEt.length();
                        bVar.aRM[i2] = length;
                        this.size = (this.size - j) + length;
                        this.aiu++;
                    }
                } else {
                    p(fileEu);
                }
            }
            this.aRB++;
            bVar.aRO = null;
            if (!(bVar.aRN | z)) {
                this.aRA.remove(bVar.key);
                this.aRz.write("REMOVE " + bVar.key + '\n');
            } else {
                b.a(bVar, true);
                this.aRz.write("CLEAN " + bVar.key + bVar.Lv() + '\n');
                if (z) {
                    long j2 = this.aRC;
                    this.aRC = 1 + j2;
                    bVar.aRP = j2;
                }
            }
            this.aRz.flush();
            if (this.size > this.maxSize || this.aiu > this.aRx || Ls()) {
                this.aRD.submit(this.aRE);
            }
            return;
        }
        throw new IllegalStateException();
    }
}
