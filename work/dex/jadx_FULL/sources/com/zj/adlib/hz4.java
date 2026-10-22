package com.zj.adlib;

import android.content.ContentResolver;
import android.database.Cursor;
import android.media.ExifInterface;
import android.net.Uri;
import android.util.Pair;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.producers.StatefulProducerRunnable;
import com.facebook.imagepipeline.producers.ThumbnailProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class hz4 implements ThumbnailProducer<q13> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f42234a = 512;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public static final String f17095a = "LocalExifThumbnailProducer";

    @VisibleForTesting
    public static final String b = "createdThumbnail";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ContentResolver f17096a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PooledByteBufferFactory f17097a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f17098a;

    public class a extends StatefulProducerRunnable<q13> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageRequest f42235a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Consumer consumer, ProducerListener producerListener, String str, String str2, ImageRequest imageRequest) {
            super(consumer, producerListener, str, str2);
            this.f42235a = imageRequest;
        }

        @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
        public void disposeResult(q13 q13Var) {
            q13.j(q13Var);
        }

        @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
        public Map<String, String> getExtraMapOnSuccess(q13 q13Var) {
            return ImmutableMap.of("createdThumbnail", Boolean.toString(q13Var != null));
        }

        @Override // com.facebook.common.executors.StatefulRunnable
        public q13 getResult() throws Exception {
            ExifInterface exifInterfaceG = hz4.this.g(this.f42235a.o());
            if (exifInterfaceG == null || !exifInterfaceG.hasThumbnail()) {
                return null;
            }
            return hz4.this.e(hz4.this.f17097a.c(exifInterfaceG.getThumbnail()), exifInterfaceG);
        }
    }

    public class b extends qq0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StatefulProducerRunnable f42236a;

        public b(StatefulProducerRunnable statefulProducerRunnable) {
            this.f42236a = statefulProducerRunnable;
        }

        @Override // com.zj.adlib.qq0, com.facebook.imagepipeline.producers.ProducerContextCallbacks
        public void b() {
            this.f42236a.b();
        }
    }

    public hz4(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        this.f17098a = executor;
        this.f17097a = pooledByteBufferFactory;
        this.f17096a = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void a(Consumer<q13> consumer, ProducerContext producerContext) {
        a aVar = new a(consumer, producerContext.c(), f17095a, producerContext.getId(), producerContext.b());
        producerContext.g(new b(aVar));
        this.f17098a.execute(aVar);
    }

    @Override // com.facebook.imagepipeline.producers.ThumbnailProducer
    public boolean b(sf7 sf7Var) {
        return n69.b(512, 512, sf7Var);
    }

    public final q13 e(PooledByteBuffer pooledByteBuffer, ExifInterface exifInterface) {
        Pair<Integer, Integer> pairA = qw0.a(new pu6(pooledByteBuffer));
        int i = i(exifInterface);
        int iIntValue = pairA != null ? ((Integer) pairA.first).intValue() : -1;
        int iIntValue2 = pairA != null ? ((Integer) pairA.second).intValue() : -1;
        q13 q13Var = new q13((rm1<PooledByteBuffer>) rm1.H(pooledByteBuffer));
        q13Var.M(ImageFormat.JPEG);
        q13Var.R(i);
        q13Var.b0(iIntValue);
        q13Var.L(iIntValue2);
        return q13Var;
    }

    @VisibleForTesting
    public boolean f(String str) throws IOException {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.canRead();
    }

    @VisibleForTesting
    public ExifInterface g(Uri uri) throws Throwable {
        String strH = h(uri);
        if (f(strH)) {
            return new ExifInterface(strH);
        }
        return null;
    }

    public final String h(Uri uri) throws Throwable {
        Cursor cursor = null;
        String string = null;
        if (!th9.f(uri)) {
            if (th9.g(uri)) {
                return uri.getPath();
            }
            return null;
        }
        try {
            Cursor cursorQuery = this.f17096a.query(uri, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    cursorQuery.moveToFirst();
                    string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery == null) {
                return string;
            }
            cursorQuery.close();
            return string;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final int i(ExifInterface exifInterface) {
        return do4.a(Integer.parseInt(exifInterface.getAttribute("Orientation")));
    }
}
