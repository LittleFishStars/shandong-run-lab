package com.facebook.imagepipeline.datasource;

import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.BaseConsumer;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.Producer;
import com.zj.adlib.ax6;
import com.zj.adlib.z68;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ThreadSafe
public abstract class AbstractProducerToDataSourceAdapter<T> extends AbstractDataSource<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RequestListener f29990a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z68 f1646a;

    public class a extends BaseConsumer<T> {
        public a() {
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onCancellationImpl() {
            AbstractProducerToDataSourceAdapter.this.p();
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable th) {
            AbstractProducerToDataSourceAdapter.this.q(th);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(@Nullable T t, boolean z) {
            AbstractProducerToDataSourceAdapter.this.onNewResultImpl(t, z);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onProgressUpdateImpl(float f) {
            AbstractProducerToDataSourceAdapter.this.setProgress(f);
        }
    }

    public AbstractProducerToDataSourceAdapter(Producer<T> producer, z68 z68Var, RequestListener requestListener) {
        this.f1646a = z68Var;
        this.f29990a = requestListener;
        requestListener.f(z68Var.b(), z68Var.f(), z68Var.getId(), z68Var.a());
        producer.a(o(), z68Var);
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public boolean a() {
        if (!super.a()) {
            return false;
        }
        if (super.isFinished()) {
            return true;
        }
        this.f29990a.a(this.f1646a.getId());
        this.f1646a.m();
        return true;
    }

    public final Consumer<T> o() {
        return new a();
    }

    public void onNewResultImpl(@Nullable T t, boolean z) {
        if (super.setResult(t, z) && z) {
            this.f29990a.b(this.f1646a.b(), this.f1646a.getId(), this.f1646a.a());
        }
    }

    public final synchronized void p() {
        ax6.o(isClosed());
    }

    public final void q(Throwable th) {
        if (super.setFailure(th)) {
            this.f29990a.e(this.f1646a.b(), this.f1646a.getId(), th, this.f1646a.a());
        }
    }
}
