package com.facebook.datasource;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class BaseDataSubscriber<T> implements DataSubscriber<T> {
    @Override // com.facebook.datasource.DataSubscriber
    public void a(DataSource<T> dataSource) {
        try {
            onFailureImpl(dataSource);
        } finally {
            dataSource.a();
        }
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void b(DataSource<T> dataSource) {
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void c(DataSource<T> dataSource) {
        boolean zIsFinished = dataSource.isFinished();
        try {
            onNewResultImpl(dataSource);
        } finally {
            if (zIsFinished) {
                dataSource.a();
            }
        }
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void d(DataSource<T> dataSource) {
    }

    public abstract void onFailureImpl(DataSource<T> dataSource);

    public abstract void onNewResultImpl(DataSource<T> dataSource);
}
