package cj.mobile.wm;

import android.annotation.TargetApi;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class g2 implements Closeable {
    public final File dexa;
    public final File dexb;
    public final File dexc;
    public final File dexd;
    public final int dexe;
    public long dexf;
    public final int dexg;
    public Writer dexi;
    public int dexk;
    public long dexh = 0;
    public final LinkedHashMap<String, dexd> dexj = new LinkedHashMap<>(0, 0.75f, true);
    public long dexl = 0;
    public final ThreadPoolExecutor dexm = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new dexb(null));
    public final Callable<Void> dexn = new dexa();

    public class dexa implements Callable<Void> {
        public dexa() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: dexa, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (g2.this) {
                if (g2.this.dexi == null) {
                    return null;
                }
                g2.this.dexg();
                if (g2.this.dexc()) {
                    g2.this.dexf();
                    g2.this.dexk = 0;
                }
                return null;
            }
        }
    }

    public static final class dexb implements ThreadFactory {
        public dexb() {
        }

        public /* synthetic */ dexb(dexa dexaVar) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    public final class dexc {
        public final dexd dexa;
        public final boolean[] dexb;
        public boolean dexc;

        public dexc(dexd dexdVar) {
            this.dexa = dexdVar;
            this.dexb = dexdVar.dexe ? null : new boolean[g2.this.dexg];
        }

        public /* synthetic */ dexc(g2 g2Var, dexd dexdVar, dexa dexaVar) {
            this(dexdVar);
        }

        public File dexa(int i) {
            File fileDexb;
            synchronized (g2.this) {
                if (this.dexa.dexf != this) {
                    throw new IllegalStateException();
                }
                if (!this.dexa.dexe) {
                    this.dexb[i] = true;
                }
                fileDexb = this.dexa.dexb(i);
                g2.this.dexa.mkdirs();
            }
            return fileDexb;
        }

        public void dexa() {
            g2.this.dexa(this, false);
        }

        public void dexb() {
            if (this.dexc) {
                return;
            }
            try {
                dexa();
            } catch (IOException unused) {
            }
        }

        public void dexc() {
            g2.this.dexa(this, true);
            this.dexc = true;
        }
    }

    public final class dexd {
        public final String dexa;
        public final long[] dexb;
        public File[] dexc;
        public File[] dexd;
        public boolean dexe;
        public dexc dexf;
        public long dexg;

        public dexd(String str) {
            this.dexa = str;
            this.dexb = new long[g2.this.dexg];
            this.dexc = new File[g2.this.dexg];
            this.dexd = new File[g2.this.dexg];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < g2.this.dexg; i++) {
                sb.append(i);
                this.dexc[i] = new File(g2.this.dexa, sb.toString());
                sb.append(".tmp");
                this.dexd[i] = new File(g2.this.dexa, sb.toString());
                sb.setLength(length);
            }
        }

        public /* synthetic */ dexd(g2 g2Var, String str, dexa dexaVar) {
            this(str);
        }

        private IOException dexa(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dexb(String[] strArr) throws IOException {
            if (strArr.length != g2.this.dexg) {
                throw dexa(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.dexb[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw dexa(strArr);
                }
            }
        }

        public File dexa(int i) {
            return this.dexc[i];
        }

        public String dexa() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.dexb) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public File dexb(int i) {
            return this.dexd[i];
        }
    }

    public final class dexe {
        public final String dexa;
        public final long dexb;
        public final long[] dexc;
        public final File[] dexd;

        public dexe(String str, long j, File[] fileArr, long[] jArr) {
            this.dexa = str;
            this.dexb = j;
            this.dexd = fileArr;
            this.dexc = jArr;
        }

        public /* synthetic */ dexe(g2 g2Var, String str, long j, File[] fileArr, long[] jArr, dexa dexaVar) {
            this(str, j, fileArr, jArr);
        }

        public File dexa(int i) {
            return this.dexd[i];
        }
    }

    public g2(File file, int i, int i2, long j) {
        this.dexa = file;
        this.dexe = i;
        this.dexb = new File(file, com.ipd.dsp.internal.d.a.t);
        this.dexc = new File(file, com.ipd.dsp.internal.d.a.u);
        this.dexd = new File(file, com.ipd.dsp.internal.d.a.v);
        this.dexg = i2;
        this.dexf = j;
    }

    private synchronized dexc dexa(String str, long j) {
        dexb();
        dexd dexdVar = this.dexj.get(str);
        dexa dexaVar = null;
        if (j != -1 && (dexdVar == null || dexdVar.dexg != j)) {
            return null;
        }
        if (dexdVar == null) {
            dexdVar = new dexd(this, str, dexaVar);
            this.dexj.put(str, dexdVar);
        } else if (dexdVar.dexf != null) {
            return null;
        }
        dexc dexcVar = new dexc(this, dexdVar, dexaVar);
        dexdVar.dexf = dexcVar;
        this.dexi.append((CharSequence) com.ipd.dsp.internal.d.a.A);
        this.dexi.append(' ');
        this.dexi.append((CharSequence) str);
        this.dexi.append('\n');
        dexb(this.dexi);
        return dexcVar;
    }

    public static g2 dexa(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, com.ipd.dsp.internal.d.a.v);
        if (file2.exists()) {
            File file3 = new File(file, com.ipd.dsp.internal.d.a.t);
            if (file3.exists()) {
                file2.delete();
            } else {
                dexa(file2, file3, false);
            }
        }
        g2 g2Var = new g2(file, i, i2, j);
        if (g2Var.dexb.exists()) {
            try {
                g2Var.dexe();
                g2Var.dexd();
                return g2Var;
            } catch (IOException e) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                g2Var.dexa();
            }
        }
        file.mkdirs();
        g2 g2Var2 = new g2(file, i, i2, j);
        g2Var2.dexf();
        return g2Var2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dexa(dexc dexcVar, boolean z) {
        dexd dexdVar = dexcVar.dexa;
        if (dexdVar.dexf != dexcVar) {
            throw new IllegalStateException();
        }
        if (z && !dexdVar.dexe) {
            for (int i = 0; i < this.dexg; i++) {
                if (!dexcVar.dexb[i]) {
                    dexcVar.dexa();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                if (!dexdVar.dexb(i).exists()) {
                    dexcVar.dexa();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.dexg; i2++) {
            File fileDexb = dexdVar.dexb(i2);
            if (!z) {
                dexa(fileDexb);
            } else if (fileDexb.exists()) {
                File fileDexa = dexdVar.dexa(i2);
                fileDexb.renameTo(fileDexa);
                long j = dexdVar.dexb[i2];
                long length = fileDexa.length();
                dexdVar.dexb[i2] = length;
                this.dexh = (this.dexh - j) + length;
            }
        }
        this.dexk++;
        dexdVar.dexf = null;
        if (dexdVar.dexe || z) {
            dexdVar.dexe = true;
            this.dexi.append((CharSequence) com.ipd.dsp.internal.d.a.z);
            this.dexi.append(' ');
            this.dexi.append((CharSequence) dexdVar.dexa);
            this.dexi.append((CharSequence) dexdVar.dexa());
            this.dexi.append('\n');
            if (z) {
                long j2 = this.dexl;
                this.dexl = 1 + j2;
                dexdVar.dexg = j2;
            }
        } else {
            this.dexj.remove(dexdVar.dexa);
            this.dexi.append((CharSequence) com.ipd.dsp.internal.d.a.B);
            this.dexi.append(' ');
            this.dexi.append((CharSequence) dexdVar.dexa);
            this.dexi.append('\n');
        }
        dexb(this.dexi);
        if (this.dexh > this.dexf || dexc()) {
            this.dexm.submit(this.dexn);
        }
    }

    public static void dexa(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void dexa(File file, File file2, boolean z) throws IOException {
        if (z) {
            dexa(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    @TargetApi(26)
    public static void dexa(Writer writer) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    private void dexb() {
        if (this.dexi == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @TargetApi(26)
    public static void dexb(Writer writer) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dexc() {
        int i = this.dexk;
        return i >= 2000 && i >= this.dexj.size();
    }

    private void dexd() throws IOException {
        dexa(this.dexc);
        Iterator<dexd> it = this.dexj.values().iterator();
        while (it.hasNext()) {
            dexd next = it.next();
            int i = 0;
            if (next.dexf == null) {
                while (i < this.dexg) {
                    this.dexh += next.dexb[i];
                    i++;
                }
            } else {
                next.dexf = null;
                while (i < this.dexg) {
                    dexa(next.dexa(i));
                    dexa(next.dexb(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    private void dexd(String str) throws IOException {
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
                this.dexj.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        dexd dexdVar = this.dexj.get(strSubstring);
        dexa dexaVar = null;
        if (dexdVar == null) {
            dexdVar = new dexd(this, strSubstring, dexaVar);
            this.dexj.put(strSubstring, dexdVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith(com.ipd.dsp.internal.d.a.z)) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            dexdVar.dexe = true;
            dexdVar.dexf = null;
            dexdVar.dexb(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith(com.ipd.dsp.internal.d.a.A)) {
            dexdVar.dexf = new dexc(this, dexdVar, dexaVar);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith(com.ipd.dsp.internal.d.a.C)) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    private void dexe() {
        h2 h2Var = new h2(new FileInputStream(this.dexb), i2.dexa);
        try {
            String strDexb = h2Var.dexb();
            String strDexb2 = h2Var.dexb();
            String strDexb3 = h2Var.dexb();
            String strDexb4 = h2Var.dexb();
            String strDexb5 = h2Var.dexb();
            if (!com.ipd.dsp.internal.d.a.w.equals(strDexb) || !"1".equals(strDexb2) || !Integer.toString(this.dexe).equals(strDexb3) || !Integer.toString(this.dexg).equals(strDexb4) || !"".equals(strDexb5)) {
                throw new IOException("unexpected journal header: [" + strDexb + ", " + strDexb2 + ", " + strDexb4 + ", " + strDexb5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    dexd(h2Var.dexb());
                    i++;
                } catch (EOFException unused) {
                    this.dexk = i - this.dexj.size();
                    if (h2Var.dexa()) {
                        dexf();
                    } else {
                        this.dexi = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.dexb, true), i2.dexa));
                    }
                    i2.dexa(h2Var);
                    return;
                }
            }
        } catch (Throwable th) {
            i2.dexa(h2Var);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dexf() {
        StringBuilder sb;
        Writer writer = this.dexi;
        if (writer != null) {
            dexa(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.dexc), i2.dexa));
        try {
            bufferedWriter.write(com.ipd.dsp.internal.d.a.w);
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.dexe));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.dexg));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (dexd dexdVar : this.dexj.values()) {
                if (dexdVar.dexf != null) {
                    sb = new StringBuilder();
                    sb.append("DIRTY ");
                    sb.append(dexdVar.dexa);
                } else {
                    sb = new StringBuilder();
                    sb.append("CLEAN ");
                    sb.append(dexdVar.dexa);
                    sb.append(dexdVar.dexa());
                }
                sb.append('\n');
                bufferedWriter.write(sb.toString());
            }
            dexa(bufferedWriter);
            if (this.dexb.exists()) {
                dexa(this.dexb, this.dexd, true);
            }
            dexa(this.dexc, this.dexb, false);
            this.dexd.delete();
            this.dexi = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.dexb, true), i2.dexa));
        } catch (Throwable th) {
            dexa(bufferedWriter);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dexg() {
        while (this.dexh > this.dexf) {
            dexc(this.dexj.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.dexi == null) {
            return;
        }
        for (dexd dexdVar : new ArrayList(this.dexj.values())) {
            if (dexdVar.dexf != null) {
                dexdVar.dexf.dexa();
            }
        }
        dexg();
        dexa(this.dexi);
        this.dexi = null;
    }

    public dexc dexa(String str) {
        return dexa(str, -1L);
    }

    public void dexa() throws IOException {
        close();
        i2.dexa(this.dexa);
    }

    public synchronized dexe dexb(String str) {
        dexb();
        dexd dexdVar = this.dexj.get(str);
        if (dexdVar == null) {
            return null;
        }
        if (!dexdVar.dexe) {
            return null;
        }
        for (File file : dexdVar.dexc) {
            if (!file.exists()) {
                return null;
            }
        }
        this.dexk++;
        this.dexi.append((CharSequence) com.ipd.dsp.internal.d.a.C);
        this.dexi.append(' ');
        this.dexi.append((CharSequence) str);
        this.dexi.append('\n');
        if (dexc()) {
            this.dexm.submit(this.dexn);
        }
        return new dexe(this, str, dexdVar.dexg, dexdVar.dexc, dexdVar.dexb, null);
    }

    public synchronized boolean dexc(String str) {
        dexb();
        dexd dexdVar = this.dexj.get(str);
        if (dexdVar != null && dexdVar.dexf == null) {
            for (int i = 0; i < this.dexg; i++) {
                File fileDexa = dexdVar.dexa(i);
                if (fileDexa.exists() && !fileDexa.delete()) {
                    throw new IOException("failed to delete " + fileDexa);
                }
                this.dexh -= dexdVar.dexb[i];
                dexdVar.dexb[i] = 0;
            }
            this.dexk++;
            this.dexi.append((CharSequence) com.ipd.dsp.internal.d.a.B);
            this.dexi.append(' ');
            this.dexi.append((CharSequence) str);
            this.dexi.append('\n');
            this.dexj.remove(str);
            if (dexc()) {
                this.dexm.submit(this.dexn);
            }
            return true;
        }
        return false;
    }
}
