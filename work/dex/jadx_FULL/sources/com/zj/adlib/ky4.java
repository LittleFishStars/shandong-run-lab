package com.zj.adlib;

import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ky4<T> extends AbstractDataSource<List<rm1<T>>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    public int f42943a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSource<rm1<T>>[] f17822a;

    public class b implements DataSubscriber<rm1<T>> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @GuardedBy("InternalDataSubscriber.this")
        public boolean f17823a;

        public b() {
            this.f17823a = false;
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void a(DataSource<rm1<T>> dataSource) {
            ky4.this.t(dataSource);
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void b(DataSource<rm1<T>> dataSource) {
            ky4.this.v();
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void c(DataSource<rm1<T>> dataSource) {
            if (dataSource.isFinished() && e()) {
                ky4.this.u();
            }
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void d(DataSource<rm1<T>> dataSource) {
            ky4.this.s();
        }

        public final synchronized boolean e() {
            if (this.f17823a) {
                return false;
            }
            this.f17823a = true;
            return true;
        }
    }

    public ky4(DataSource<rm1<T>>[] dataSourceArr) {
        this.f17822a = dataSourceArr;
    }

    public static <T> ky4<T> p(DataSource<rm1<T>>... dataSourceArr) {
        ax6.i(dataSourceArr);
        ax6.o(dataSourceArr.length > 0);
        ky4<T> ky4Var = new ky4<>(dataSourceArr);
        for (DataSource<rm1<T>> dataSource : dataSourceArr) {
            if (dataSource != null) {
                dataSource.e(new b(), ia1.a());
            }
        }
        return ky4Var;
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public boolean a() {
        if (!super.a()) {
            return false;
        }
        for (DataSource<rm1<T>> dataSource : this.f17822a) {
            dataSource.a();
        }
        return true;
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public synchronized boolean b() {
        return !isClosed() && this.f42943a == this.f17822a.length;
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    @Nullable
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public synchronized List<rm1<T>> getResult() {
        if (!b()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.f17822a.length);
        for (DataSource<rm1<T>> dataSource : this.f17822a) {
            arrayList.add(dataSource.getResult());
        }
        return arrayList;
    }

    public final synchronized boolean r() {
        int i;
        i = this.f42943a + 1;
        this.f42943a = i;
        return i == this.f17822a.length;
    }

    public final void s() {
        setFailure(new CancellationException());
    }

    public final void t(DataSource<rm1<T>> dataSource) {
        setFailure(dataSource.c());
    }

    public final void u() {
        if (r()) {
            setResult(null, true);
        }
    }

    public final void v() {
        float progress = 0.0f;
        for (DataSource<rm1<T>> dataSource : this.f17822a) {
            progress += dataSource.getProgress();
        }
        setProgress(progress / this.f17822a.length);
    }
}
