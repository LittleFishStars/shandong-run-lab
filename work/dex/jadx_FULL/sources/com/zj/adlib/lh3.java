package com.zj.adlib;

import com.facebook.common.internal.Supplier;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ThreadSafe
public class lh3<T> implements Supplier<DataSource<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Supplier<DataSource<T>>> f43063a;

    @ThreadSafe
    public class b extends AbstractDataSource<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f43064a = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public DataSource<T> f17940a = null;
        public DataSource<T> b = null;

        public class a implements DataSubscriber<T> {
            public a() {
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void a(DataSource<T> dataSource) {
                b.this.s(dataSource);
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void b(DataSource<T> dataSource) {
                b.this.setProgress(Math.max(b.this.getProgress(), dataSource.getProgress()));
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void c(DataSource<T> dataSource) {
                if (dataSource.b()) {
                    b.this.t(dataSource);
                } else if (dataSource.isFinished()) {
                    b.this.s(dataSource);
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void d(DataSource<T> dataSource) {
            }
        }

        public b() {
            if (v()) {
                return;
            }
            setFailure(new RuntimeException("No data source supplier or supplier returned null."));
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public boolean a() {
            synchronized (this) {
                if (!super.a()) {
                    return false;
                }
                DataSource<T> dataSource = this.f17940a;
                this.f17940a = null;
                DataSource<T> dataSource2 = this.b;
                this.b = null;
                o(dataSource2);
                o(dataSource);
                return true;
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public synchronized boolean b() {
            DataSource<T> dataSourceP;
            dataSourceP = p();
            return dataSourceP != null && dataSourceP.b();
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        @Nullable
        public synchronized T getResult() {
            DataSource<T> dataSourceP;
            dataSourceP = p();
            return dataSourceP != null ? dataSourceP.getResult() : null;
        }

        public final synchronized boolean n(DataSource<T> dataSource) {
            if (!isClosed() && dataSource == this.f17940a) {
                this.f17940a = null;
                return true;
            }
            return false;
        }

        public final void o(DataSource<T> dataSource) {
            if (dataSource != null) {
                dataSource.a();
            }
        }

        @Nullable
        public final synchronized DataSource<T> p() {
            return this.b;
        }

        @Nullable
        public final synchronized Supplier<DataSource<T>> q() {
            if (isClosed() || this.f43064a >= lh3.this.f43063a.size()) {
                return null;
            }
            List list = lh3.this.f43063a;
            int i = this.f43064a;
            this.f43064a = i + 1;
            return (Supplier) list.get(i);
        }

        public final void r(DataSource<T> dataSource, boolean z) {
            DataSource<T> dataSource2;
            synchronized (this) {
                if (dataSource == this.f17940a && dataSource != (dataSource2 = this.b)) {
                    if (dataSource2 == null || z) {
                        this.b = dataSource;
                    } else {
                        dataSource2 = null;
                    }
                    o(dataSource2);
                }
            }
        }

        public final void s(DataSource<T> dataSource) {
            if (n(dataSource)) {
                if (dataSource != p()) {
                    o(dataSource);
                }
                if (v()) {
                    return;
                }
                setFailure(dataSource.c());
            }
        }

        public final void t(DataSource<T> dataSource) {
            r(dataSource, dataSource.isFinished());
            if (dataSource == p()) {
                setResult(null, dataSource.isFinished());
            }
        }

        public final synchronized boolean u(DataSource<T> dataSource) {
            if (isClosed()) {
                return false;
            }
            this.f17940a = dataSource;
            return true;
        }

        public final boolean v() {
            Supplier<DataSource<T>> supplierQ = q();
            DataSource<T> dataSource = supplierQ != null ? supplierQ.get() : null;
            if (!u(dataSource) || dataSource == null) {
                o(dataSource);
                return false;
            }
            dataSource.e(new a(), ia1.a());
            return true;
        }
    }

    public lh3(List<Supplier<DataSource<T>>> list) {
        ax6.e(!list.isEmpty(), "List of suppliers is empty!");
        this.f43063a = list;
    }

    public static <T> lh3<T> b(List<Supplier<DataSource<T>>> list) {
        return new lh3<>(list);
    }

    @Override // com.facebook.common.internal.Supplier
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public DataSource<T> get() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof lh3) {
            return h76.a(this.f43063a, ((lh3) obj).f43063a);
        }
        return false;
    }

    public int hashCode() {
        return this.f43063a.hashCode();
    }

    public String toString() {
        return h76.f(this).f(GoodsSpecificationPreviewActivity.z, this.f43063a).toString();
    }
}
