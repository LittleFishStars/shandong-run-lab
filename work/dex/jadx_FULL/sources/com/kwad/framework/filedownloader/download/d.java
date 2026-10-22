package com.kwad.framework.filedownloader.download;

import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.framework.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.kwad.sdk.crash.utils.h;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d implements Handler.Callback {
    private volatile Thread aAD;
    private final a aBQ;
    private final int aBR;
    private final int aBS;
    private final int aBT;
    private long aBU;
    private HandlerThread aBV;
    private volatile boolean aBY;
    private final com.kwad.framework.filedownloader.d.c aBi;
    private Handler handler;
    private volatile boolean aBW = false;
    private volatile long aBC = 0;
    private final AtomicLong aBX = new AtomicLong();
    private boolean aBZ = true;
    private final com.kwad.framework.filedownloader.b.a aBd = b.Ca().Cc();

    public static class a {
        private boolean aCa;
        private Exception aCb;
        private int aCc;

        public final int AL() {
            return this.aCc;
        }

        public final boolean CC() {
            return this.aCa;
        }

        public final void bw(boolean z) {
            this.aCa = z;
        }

        public final void cM(int i) {
            this.aCc = i;
        }

        public final void f(Exception exc) {
            this.aCb = exc;
        }

        public final Exception getException() {
            return this.aCb;
        }
    }

    public d(com.kwad.framework.filedownloader.d.c cVar, int i, int i2, int i3) {
        this.aBi = cVar;
        this.aBS = i2 < 5 ? 5 : i2;
        this.aBT = i3;
        this.aBQ = new a();
        this.aBR = i;
    }

    private boolean CA() {
        if (this.aBi.isChunked()) {
            com.kwad.framework.filedownloader.d.c cVar = this.aBi;
            cVar.ah(cVar.CX());
        } else if (this.aBi.CX() != this.aBi.getTotal()) {
            c(new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.c("sofar[%d] not equal total[%d]", Long.valueOf(this.aBi.CX()), Long.valueOf(this.aBi.getTotal()))));
            return true;
        }
        return false;
    }

    private void CB() {
        this.aBi.d((byte) -2);
        this.aBd.d(this.aBi.getId(), this.aBi.CX());
        c((byte) -2);
    }

    private void Cy() {
        String strCp = this.aBi.Cp();
        String targetFilePath = this.aBi.getTargetFilePath();
        File file = new File(strCp);
        try {
            File file2 = new File(targetFilePath);
            if (file2.exists()) {
                long length = file2.length();
                if (!file2.delete()) {
                    throw new IOException(com.kwad.framework.filedownloader.f.f.c("Can't delete the old file([%s], [%d]), so can't replace it with the new downloaded one.", targetFilePath, Long.valueOf(length)));
                }
                com.kwad.framework.filedownloader.f.d.d(this, "The target file([%s], [%d]) will be replaced with the new downloaded file[%d]", targetFilePath, Long.valueOf(length), Long.valueOf(file.length()));
            }
            if (!file.renameTo(file2)) {
                throw new IOException(com.kwad.framework.filedownloader.f.f.c("Can't rename the  temp downloaded file(%s) to the target file(%s)", strCp, targetFilePath));
            }
            if (!file.exists() || file.delete()) {
                return;
            }
            com.kwad.framework.filedownloader.f.d.d(this, "delete the temp file(%s) failed, on completed downloading.", strCp);
        } catch (Throwable th) {
            if (file.exists() && !file.delete()) {
                com.kwad.framework.filedownloader.f.d.d(this, "delete the temp file(%s) failed, on completed downloading.", strCp);
            }
            throw th;
        }
    }

    private void Cz() {
        Cy();
        this.aBi.d((byte) -3);
        this.aBd.c(this.aBi.getId(), this.aBi.getTotal());
        this.aBd.cE(this.aBi.getId());
        c((byte) -3);
        if (com.kwad.framework.filedownloader.f.e.Dz().aDy) {
            com.kwad.framework.filedownloader.services.f.f(this.aBi);
        }
    }

    private boolean ac(long j) {
        if (!this.aBZ) {
            return this.aBU != -1 && this.aBX.get() >= this.aBU && j - this.aBC >= ((long) this.aBS);
        }
        this.aBZ = false;
        return true;
    }

    private synchronized void b(Message message) {
        if (!this.aBV.isAlive()) {
            if (com.kwad.framework.filedownloader.f.d.aDr) {
                com.kwad.framework.filedownloader.f.d.c(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
            }
            return;
        }
        try {
            this.handler.sendMessage(message);
        } catch (IllegalStateException e) {
            if (this.aBV.isAlive()) {
                throw e;
            }
            if (com.kwad.framework.filedownloader.f.d.aDr) {
                com.kwad.framework.filedownloader.f.d.c(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
            }
        }
    }

    private Exception d(Exception exc) {
        long length;
        String strCp = this.aBi.Cp();
        if ((!this.aBi.isChunked() && !com.kwad.framework.filedownloader.f.e.Dz().aDx) || !(exc instanceof IOException) || !new File(strCp).exists()) {
            return exc;
        }
        long availableBytes = h.getAvailableBytes(strCp);
        if (availableBytes > 4096) {
            return exc;
        }
        File file = new File(strCp);
        if (file.exists()) {
            length = file.length();
        } else {
            com.kwad.framework.filedownloader.f.d.a(this, exc, "Exception with: free space isn't enough, and the target file not exist.", new Object[0]);
            length = 0;
        }
        return new FileDownloadOutOfSpaceException(availableBytes, 4096L, length, exc);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void e(Exception exc) {
        SQLiteFullException sQLiteFullException;
        Exception excD = d(exc);
        if (excD instanceof SQLiteFullException) {
            a((SQLiteFullException) excD);
            sQLiteFullException = excD;
        } else {
            try {
                this.aBi.d((byte) -1);
                this.aBi.ch(exc.toString());
                this.aBd.a(this.aBi.getId(), excD, this.aBi.CX());
                sQLiteFullException = excD;
            } catch (SQLiteFullException e) {
                SQLiteFullException sQLiteFullException2 = e;
                a(sQLiteFullException2);
                sQLiteFullException = sQLiteFullException2;
            }
        }
        this.aBQ.f(sQLiteFullException);
        c((byte) -1);
    }

    private static long h(long j, long j2) {
        if (j2 <= 0) {
            return -1L;
        }
        if (j == -1) {
            return 1L;
        }
        long j3 = j / (j2 + 1);
        if (j3 <= 0) {
            return 1L;
        }
        return j3;
    }

    public final void Cs() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.aBV.quit();
            this.aAD = Thread.currentThread();
            while (this.aBW) {
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100L));
            }
            this.aAD = null;
        }
    }

    public final void Ct() {
        this.aBi.d((byte) 1);
        this.aBd.cG(this.aBi.getId());
        c((byte) 1);
    }

    public final void Cu() {
        this.aBi.d((byte) 6);
        c((byte) 6);
        this.aBd.cB(this.aBi.getId());
    }

    public final void Cv() {
        HandlerThread handlerThread = new HandlerThread("source-status-callback", 10);
        this.aBV = handlerThread;
        handlerThread.start();
        this.handler = new Handler(this.aBV.getLooper(), this);
    }

    public final void Cw() {
        CB();
    }

    public final void Cx() {
        if (CA()) {
            return;
        }
        Cz();
    }

    public final void a(boolean z, long j, String str, String str2) {
        String strCY = this.aBi.CY();
        if (strCY != null && !strCY.equals(str)) {
            throw new IllegalArgumentException(com.kwad.framework.filedownloader.f.f.c("callback onConnected must with precondition succeed, but the etag is changes(%s != %s)", str, strCY));
        }
        this.aBQ.bw(z);
        this.aBi.d((byte) 2);
        this.aBi.ah(j);
        this.aBi.cg(str);
        this.aBi.ci(str2);
        this.aBd.a(this.aBi.getId(), j, str, str2);
        c((byte) 2);
        this.aBU = h(j, this.aBT);
        this.aBY = true;
    }

    public final void c(Exception exc) {
        e(exc);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0024  */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        this.aBW = true;
        int i = message.what;
        try {
            if (i != 3) {
                if (i == 5) {
                    a((Exception) message.obj, message.arg1);
                }
                this.aBW = false;
                if (this.aAD != null) {
                    LockSupport.unpark(this.aAD);
                }
                return true;
            }
            b(SystemClock.elapsedRealtime(), true);
            this.aBW = false;
            if (this.aAD != null) {
                LockSupport.unpark(this.aAD);
            }
            return true;
        } catch (Throwable th) {
            this.aBW = false;
            if (this.aAD != null) {
                LockSupport.unpark(this.aAD);
            }
            throw th;
        }
    }

    public final boolean isAlive() {
        HandlerThread handlerThread = this.aBV;
        return handlerThread != null && handlerThread.isAlive();
    }

    public final void onProgress(long j) {
        this.aBX.addAndGet(j);
        this.aBi.ag(j);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zAc = ac(jElapsedRealtime);
        Handler handler = this.handler;
        if (handler == null) {
            b(jElapsedRealtime, zAc);
        } else if (zAc) {
            b(handler.obtainMessage(3));
        }
    }

    private void c(byte b) {
        if (b != -2) {
            com.kwad.framework.filedownloader.message.e.CR().s(com.kwad.framework.filedownloader.message.f.a(b, this.aBi, this.aBQ));
        } else if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "High concurrent cause, Already paused and we don't need to call-back to Task in here, %d", Integer.valueOf(this.aBi.getId()));
        }
    }

    private void b(long j, boolean z) {
        if (this.aBi.CX() == this.aBi.getTotal()) {
            this.aBd.b(this.aBi.getId(), this.aBi.CX());
            return;
        }
        if (this.aBY) {
            this.aBY = false;
            this.aBi.d((byte) 3);
        }
        if (z) {
            this.aBC = j;
            c((byte) 3);
            this.aBX.set(0L);
        }
    }

    public final void a(Exception exc, int i, long j) {
        this.aBX.set(0L);
        this.aBi.ag(-j);
        Handler handler = this.handler;
        if (handler == null) {
            a(exc, i);
        } else {
            b(handler.obtainMessage(5, i, 0, exc));
        }
    }

    private void a(SQLiteFullException sQLiteFullException) {
        int id = this.aBi.getId();
        if (com.kwad.framework.filedownloader.f.d.aDr) {
            com.kwad.framework.filedownloader.f.d.c(this, "the data of the task[%d] is dirty, because the SQLite full exception[%s], so remove it from the database directly.", Integer.valueOf(id), sQLiteFullException.toString());
        }
        this.aBi.ch(sQLiteFullException.toString());
        this.aBi.d((byte) -1);
        this.aBd.cF(id);
        this.aBd.cE(id);
    }

    private void a(Exception exc, int i) {
        Exception excD = d(exc);
        this.aBQ.f(excD);
        this.aBQ.cM(this.aBR - i);
        this.aBi.d((byte) 5);
        this.aBi.ch(excD.toString());
        this.aBd.a(this.aBi.getId(), excD);
        c((byte) 5);
    }
}
