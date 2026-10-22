package com.facebook.datasource;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class BaseBooleanSubscriber implements DataSubscriber<Boolean> {
    @Override // com.facebook.datasource.DataSubscriber
    public void a(DataSource<Boolean> dataSource) {
        try {
            onFailureImpl(dataSource);
        } finally {
            dataSource.a();
        }
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void b(DataSource<Boolean> dataSource) {
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void c(DataSource<Boolean> dataSource) {
        try {
            onNewResultImpl(dataSource.getResult().booleanValue());
        } finally {
            dataSource.a();
        }
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void d(DataSource<Boolean> dataSource) {
    }

    public abstract void onFailureImpl(DataSource<Boolean> dataSource);

    public abstract void onNewResultImpl(boolean z);
}
