package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.zj.adlib.q13;
import com.zj.adlib.qq0;
import com.zj.adlib.rm1;
import com.zj.adlib.tm1;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class LocalFetchProducer implements Producer<q13> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PooledByteBufferFactory f30017a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f1684a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f1685a = false;

    public class a extends StatefulProducerRunnable<q13> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ImageRequest f1686a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Consumer consumer, ProducerListener producerListener, String str, String str2, ImageRequest imageRequest) {
            super(consumer, producerListener, str, str2);
            this.f1686a = imageRequest;
        }

        @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
        public void disposeResult(q13 q13Var) {
            q13.j(q13Var);
        }

        @Override // com.facebook.common.executors.StatefulRunnable
        public q13 getResult() throws Exception {
            q13 encodedImage = LocalFetchProducer.this.getEncodedImage(this.f1686a);
            if (encodedImage == null) {
                return null;
            }
            encodedImage.J();
            return encodedImage;
        }
    }

    public class b extends qq0 {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ StatefulProducerRunnable f1687a;

        public b(StatefulProducerRunnable statefulProducerRunnable) {
            this.f1687a = statefulProducerRunnable;
        }

        @Override // com.zj.adlib.qq0, com.facebook.imagepipeline.producers.ProducerContextCallbacks
        public void b() {
            this.f1687a.b();
        }
    }

    public class c implements Supplier<FileInputStream> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ File f1688a;

        public c(File file) {
            this.f1688a = file;
        }

        @Override // com.facebook.common.internal.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FileInputStream get() {
            try {
                return new FileInputStream(this.f1688a);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public LocalFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, boolean z) {
        this.f1684a = executor;
        this.f30017a = pooledByteBufferFactory;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void a(Consumer<q13> consumer, ProducerContext producerContext) {
        a aVar = new a(consumer, producerContext.c(), getProducerName(), producerContext.getId(), producerContext.b());
        producerContext.g(new b(aVar));
        this.f1684a.execute(aVar);
    }

    public q13 getByteBufferBackedEncodedImage(InputStream inputStream, int i) throws IOException {
        rm1 rm1VarH = null;
        try {
            rm1VarH = i < 0 ? rm1.H(this.f30017a.e(inputStream)) : rm1.H(this.f30017a.a(inputStream, i));
            q13 q13Var = new q13((rm1<PooledByteBuffer>) rm1VarH);
            tm1.b(inputStream);
            rm1.p(rm1VarH);
            return q13Var;
        } catch (Throwable th) {
            tm1.b(inputStream);
            rm1.p(rm1VarH);
            throw th;
        }
    }

    public abstract q13 getEncodedImage(ImageRequest imageRequest) throws IOException;

    public q13 getEncodedImage(InputStream inputStream, int i) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        long jMaxMemory = runtime.maxMemory();
        return (this.f1685a && (inputStream instanceof FileInputStream) && jMaxMemory >= Math.min(jMaxMemory - (runtime.totalMemory() - runtime.freeMemory()), 8388608L) * 64) ? getInputStreamBackedEncodedImage(new File(inputStream.toString()), i) : getByteBufferBackedEncodedImage(inputStream, i);
    }

    public q13 getInputStreamBackedEncodedImage(File file, int i) throws IOException {
        return new q13(new c(file), i);
    }

    public abstract String getProducerName();
}
