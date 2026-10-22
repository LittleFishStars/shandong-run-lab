package com.facebook.datasource;

import android.util.Pair;
import com.zj.adlib.ax6;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AbstractDataSource<T> implements DataSource<T> {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("this")
    @Nullable
    public T f1569a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("this")
    public Throwable f1570a = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    public float f29960a = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("this")
    public boolean f1572a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("this")
    public DataSourceStatus f1568a = DataSourceStatus.IN_PROGRESS;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ConcurrentLinkedQueue<Pair<DataSubscriber<T>, Executor>> f1571a = new ConcurrentLinkedQueue<>();

    public enum DataSourceStatus {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ DataSubscriber f1573a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f1574a;
        public final /* synthetic */ boolean b;

        public a(boolean z, DataSubscriber dataSubscriber, boolean z2) {
            this.f1574a = z;
            this.f1573a = dataSubscriber;
            this.b = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1574a) {
                this.f1573a.a(AbstractDataSource.this);
            } else if (this.b) {
                this.f1573a.d(AbstractDataSource.this);
            } else {
                this.f1573a.c(AbstractDataSource.this);
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ DataSubscriber f1575a;

        public b(DataSubscriber dataSubscriber) {
            this.f1575a = dataSubscriber;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1575a.b(AbstractDataSource.this);
        }
    }

    @Override // com.facebook.datasource.DataSource
    public boolean a() {
        synchronized (this) {
            if (this.f1572a) {
                return false;
            }
            this.f1572a = true;
            T t = this.f1569a;
            this.f1569a = null;
            if (t != null) {
                closeResult(t);
            }
            if (!isFinished()) {
                g();
            }
            synchronized (this) {
                this.f1571a.clear();
            }
            return true;
        }
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean b() {
        return this.f1569a != null;
    }

    @Override // com.facebook.datasource.DataSource
    @Nullable
    public synchronized Throwable c() {
        return this.f1570a;
    }

    public void closeResult(@Nullable T t) {
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean d() {
        return this.f1568a == DataSourceStatus.FAILURE;
    }

    @Override // com.facebook.datasource.DataSource
    public void e(DataSubscriber<T> dataSubscriber, Executor executor) {
        ax6.i(dataSubscriber);
        ax6.i(executor);
        synchronized (this) {
            if (this.f1572a) {
                return;
            }
            if (this.f1568a == DataSourceStatus.IN_PROGRESS) {
                this.f1571a.add(Pair.create(dataSubscriber, executor));
            }
            boolean z = b() || isFinished() || k();
            if (z) {
                f(dataSubscriber, executor, d(), k());
            }
        }
    }

    public final void f(DataSubscriber<T> dataSubscriber, Executor executor, boolean z, boolean z2) {
        executor.execute(new a(z, dataSubscriber, z2));
    }

    public final void g() {
        boolean zD = d();
        boolean zK = k();
        for (Pair<DataSubscriber<T>, Executor> pair : this.f1571a) {
            f((DataSubscriber) pair.first, (Executor) pair.second, zD, zK);
        }
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized float getProgress() {
        return this.f29960a;
    }

    @Override // com.facebook.datasource.DataSource
    @Nullable
    public synchronized T getResult() {
        return this.f1569a;
    }

    public final synchronized boolean h(Throwable th) {
        if (!this.f1572a && this.f1568a == DataSourceStatus.IN_PROGRESS) {
            this.f1568a = DataSourceStatus.FAILURE;
            this.f1570a = th;
            return true;
        }
        return false;
    }

    public final synchronized boolean i(float f) {
        if (!this.f1572a && this.f1568a == DataSourceStatus.IN_PROGRESS) {
            if (f < this.f29960a) {
                return false;
            }
            this.f29960a = f;
            return true;
        }
        return false;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean isClosed() {
        return this.f1572a;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean isFinished() {
        return this.f1568a != DataSourceStatus.IN_PROGRESS;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0024, code lost:
    
        if (r4 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0026, code lost:
    
        closeResult(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0029, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x002c, code lost:
    
        if (r4 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x002e, code lost:
    
        closeResult(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0031, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:?, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:?, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean j(@Nullable T t, boolean z) {
        T t2;
        T t3 = null;
        try {
            synchronized (this) {
                try {
                    try {
                        if (!this.f1572a && this.f1568a == DataSourceStatus.IN_PROGRESS) {
                            if (z) {
                                this.f1568a = DataSourceStatus.SUCCESS;
                                this.f29960a = 1.0f;
                            }
                            T t4 = this.f1569a;
                            if (t4 != t) {
                                try {
                                    this.f1569a = t;
                                    t2 = t4;
                                } catch (Throwable th) {
                                    th = th;
                                    t3 = t4;
                                }
                            } else {
                                t2 = null;
                            }
                        }
                    } catch (Throwable th2) {
                        t3 = t;
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            throw th;
        } catch (Throwable th4) {
            if (t3 != null) {
                closeResult(t3);
            }
            throw th4;
        }
    }

    public final synchronized boolean k() {
        return isClosed() && !isFinished();
    }

    public void notifyProgressUpdate() {
        for (Pair<DataSubscriber<T>, Executor> pair : this.f1571a) {
            ((Executor) pair.second).execute(new b((DataSubscriber) pair.first));
        }
    }

    public boolean setFailure(Throwable th) {
        boolean zH = h(th);
        if (zH) {
            g();
        }
        return zH;
    }

    public boolean setProgress(float f) {
        boolean zI = i(f);
        if (zI) {
            notifyProgressUpdate();
        }
        return zI;
    }

    public boolean setResult(@Nullable T t, boolean z) {
        boolean zJ = j(t, z);
        if (zJ) {
            g();
        }
        return zJ;
    }
}
