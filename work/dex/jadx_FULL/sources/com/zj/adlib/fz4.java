package com.zj.adlib;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.producers.LocalFetchProducer;
import com.facebook.imagepipeline.producers.ThumbnailProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.fl.saas.base.cache.DatabaseHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class fz4 extends LocalFetchProducer implements ThumbnailProducer<q13> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f41783a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public static final String f16645a = "LocalContentUriThumbnailFetchProducer";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ContentResolver f16648a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Class<?> f16644a = fz4.class;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String[] f16646a = {DatabaseHelper.COLUMN_ID, "_data"};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String[] f16647b = {"_data"};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Rect f16643a = new Rect(0, 0, 512, 384);
    public static final Rect b = new Rect(0, 0, 96, 96);

    public fz4(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver, boolean z) {
        super(executor, pooledByteBufferFactory, z);
        this.f16648a = contentResolver;
    }

    public static int d(String str) {
        if (str == null) {
            return -1;
        }
        return (int) new File(str).length();
    }

    public static int e(String str) {
        if (str != null) {
            try {
                return do4.a(new ExifInterface(str).getAttributeInt("Orientation", 1));
            } catch (IOException e) {
                ad3.t(f16644a, e, "Unable to retrieve thumbnail rotation for %s", str);
            }
        }
        return 0;
    }

    public static int g(sf7 sf7Var) {
        Rect rect = b;
        if (n69.b(rect.width(), rect.height(), sf7Var)) {
            return 3;
        }
        Rect rect2 = f16643a;
        return n69.b(rect2.width(), rect2.height(), sf7Var) ? 1 : 0;
    }

    @Override // com.facebook.imagepipeline.producers.ThumbnailProducer
    public boolean b(sf7 sf7Var) {
        Rect rect = f16643a;
        return n69.b(rect.width(), rect.height(), sf7Var);
    }

    @Nullable
    public final q13 c(Uri uri, sf7 sf7Var) throws IOException {
        q13 q13VarF;
        Cursor cursorQuery = this.f16648a.query(uri, f16646a, null, null, null);
        if (cursorQuery == null) {
            return null;
        }
        try {
            if (cursorQuery.getCount() == 0) {
                return null;
            }
            cursorQuery.moveToFirst();
            String string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
            if (sf7Var == null || (q13VarF = f(sf7Var, cursorQuery.getInt(cursorQuery.getColumnIndex(DatabaseHelper.COLUMN_ID)))) == null) {
                return null;
            }
            q13VarF.R(e(string));
            return q13VarF;
        } finally {
            cursorQuery.close();
        }
    }

    public final q13 f(sf7 sf7Var, int i) throws Throwable {
        int iG = g(sf7Var);
        Cursor cursor = null;
        if (iG == 0) {
            return null;
        }
        try {
            Cursor cursorQueryMiniThumbnail = MediaStore.Images.Thumbnails.queryMiniThumbnail(this.f16648a, i, iG, f16647b);
            if (cursorQueryMiniThumbnail == null) {
                if (cursorQueryMiniThumbnail != null) {
                    cursorQueryMiniThumbnail.close();
                }
                return null;
            }
            try {
                cursorQueryMiniThumbnail.moveToFirst();
                if (cursorQueryMiniThumbnail.getCount() > 0) {
                    String string = cursorQueryMiniThumbnail.getString(cursorQueryMiniThumbnail.getColumnIndex("_data"));
                    if (new File(string).exists()) {
                        q13 encodedImage = getEncodedImage(new FileInputStream(string), d(string));
                        cursorQueryMiniThumbnail.close();
                        return encodedImage;
                    }
                }
                cursorQueryMiniThumbnail.close();
                return null;
            } catch (Throwable th) {
                th = th;
                cursor = cursorQueryMiniThumbnail;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public q13 getEncodedImage(ImageRequest imageRequest) throws IOException {
        q13 q13VarC;
        Uri uriO = imageRequest.o();
        if (!th9.d(uriO) || (q13VarC = c(uriO, imageRequest.m())) == null) {
            return null;
        }
        return q13VarC;
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public String getProducerName() {
        return f16645a;
    }
}
