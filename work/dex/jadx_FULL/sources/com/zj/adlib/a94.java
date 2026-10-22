package com.zj.adlib;

import com.facebook.common.internal.Supplier;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ThreadSafe
public class a94<T> implements Supplier<DataSource<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Supplier<DataSource<T>>> f40485a;

    @ThreadSafe
    public class a extends AbstractDataSource<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @GuardedBy("IncreasingQualityDataSource.this")
        public int f40486a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        public ArrayList<DataSource<T>> f15213a;

        /* JADX INFO: renamed from: com.zj.adlib.a94$a$a, reason: collision with other inner class name */
        public class C1327a implements DataSubscriber<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f40487a;

            public C1327a(int i) {
                this.f40487a = i;
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void a(DataSource<T> dataSource) {
                a.this.s(this.f40487a, dataSource);
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void b(DataSource<T> dataSource) {
                if (this.f40487a == 0) {
                    a.this.setProgress(dataSource.getProgress());
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void c(DataSource<T> dataSource) {
                if (dataSource.b()) {
                    a.this.t(this.f40487a, dataSource);
                } else if (dataSource.isFinished()) {
                    a.this.s(this.f40487a, dataSource);
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void d(DataSource<T> dataSource) {
            }
        }

        public a() {
            int size = a94.this.f40485a.size();
            this.f40486a = size;
            this.f15213a = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                DataSource<T> dataSource = (DataSource) ((Supplier) a94.this.f40485a.get(i)).get();
                this.f15213a.add(dataSource);
                dataSource.e(new C1327a(i), ia1.a());
                if (dataSource.b()) {
                    return;
                }
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public boolean a() {
            synchronized (this) {
                if (!super.a()) {
                    return false;
                }
                ArrayList<DataSource<T>> arrayList = this.f15213a;
                this.f15213a = null;
                if (arrayList == null) {
                    return true;
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    n(arrayList.get(i));
                }
                return true;
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public synchronized boolean b() {
            DataSource<T> dataSourceQ;
            dataSourceQ = q();
            return dataSourceQ != null && dataSourceQ.b();
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        @Nullable
        public synchronized T getResult() {
            DataSource<T> dataSourceQ;
            dataSourceQ = q();
            return dataSourceQ != null ? dataSourceQ.getResult() : null;
        }

        public final void n(DataSource<T> dataSource) {
            if (dataSource != null) {
                dataSource.a();
            }
        }

        @Nullable
        public final synchronized DataSource<T> o(int i) {
            DataSource<T> dataSource;
            ArrayList<DataSource<T>> arrayList = this.f15213a;
            dataSource = null;
            if (arrayList != null && i < arrayList.size()) {
                dataSource = this.f15213a.set(i, null);
            }
            return dataSource;
        }

        @Nullable
        public final synchronized DataSource<T> p(int i) {
            ArrayList<DataSource<T>> arrayList;
            arrayList = this.f15213a;
            return (arrayList == null || i >= arrayList.size()) ? null : this.f15213a.get(i);
        }

        @Nullable
        public final synchronized DataSource<T> q() {
            return p(this.f40486a);
        }

        public final void r(int i, DataSource<T> dataSource, boolean z) {
            synchronized (this) {
                int i2 = this.f40486a;
                if (dataSource == p(i) && i != this.f40486a) {
                    if (q() == null || (z && i < this.f40486a)) {
                        this.f40486a = i;
                    } else {
                        i = i2;
                    }
                    while (i2 > i) {
                        n(o(i2));
                        i2--;
                    }
                }
            }
        }

        public final void s(int i, DataSource<T> dataSource) {
            n(u(i, dataSource));
            if (i == 0) {
                setFailure(dataSource.c());
            }
        }

        public final void t(int i, DataSource<T> dataSource) {
            r(i, dataSource, dataSource.isFinished());
            if (dataSource == q()) {
                setResult(null, i == 0 && dataSource.isFinished());
            }
        }

        @Nullable
        public final synchronized DataSource<T> u(int i, DataSource<T> dataSource) {
            if (dataSource == q()) {
                return null;
            }
            if (dataSource != p(i)) {
                return dataSource;
            }
            return o(i);
        }
    }

    public a94(List<Supplier<DataSource<T>>> list) {
        ax6.e(!list.isEmpty(), "List of suppliers is empty!");
        this.f40485a = list;
    }

    public static <T> a94<T> b(List<Supplier<DataSource<T>>> list) {
        return new a94<>(list);
    }

    @Override // com.facebook.common.internal.Supplier
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public DataSource<T> get() {
        return new a();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a94) {
            return h76.a(this.f40485a, ((a94) obj).f40485a);
        }
        return false;
    }

    public int hashCode() {
        return this.f40485a.hashCode();
    }

    public String toString() {
        return h76.f(this).f(GoodsSpecificationPreviewActivity.z, this.f40485a).toString();
    }
}
