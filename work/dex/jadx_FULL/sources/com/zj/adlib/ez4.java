package com.zj.adlib;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.producers.LocalFetchProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.fl.saas.base.cache.DatabaseHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ez4 extends LocalFetchProducer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public static final String f41555a = "LocalContentUriFetchProducer";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String[] f16423a = {DatabaseHelper.COLUMN_ID, "_data"};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ContentResolver f16424a;

    public ez4(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver, boolean z) {
        super(executor, pooledByteBufferFactory, z);
        this.f16424a = contentResolver;
    }

    public static int d(String str) {
        if (str == null) {
            return -1;
        }
        return (int) new File(str).length();
    }

    @Nullable
    public final q13 c(Uri uri) throws IOException {
        Cursor cursorQuery = this.f16424a.query(uri, f16423a, null, null, null);
        if (cursorQuery == null) {
            return null;
        }
        try {
            if (cursorQuery.getCount() == 0) {
                return null;
            }
            cursorQuery.moveToFirst();
            String string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
            if (string != null) {
                return getEncodedImage(new FileInputStream(string), d(string));
            }
            return null;
        } finally {
            cursorQuery.close();
        }
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public q13 getEncodedImage(ImageRequest imageRequest) throws IOException {
        q13 q13VarC;
        InputStream inputStreamOpenInputStream;
        Uri uriO = imageRequest.o();
        if (!th9.e(uriO)) {
            return (!th9.d(uriO) || (q13VarC = c(uriO)) == null) ? getEncodedImage(this.f16424a.openInputStream(uriO), -1) : q13VarC;
        }
        if (uriO.toString().endsWith("/photo")) {
            inputStreamOpenInputStream = this.f16424a.openInputStream(uriO);
        } else {
            InputStream inputStreamOpenContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(this.f16424a, uriO);
            if (inputStreamOpenContactPhotoInputStream == null) {
                throw new IOException("Contact photo does not exist: " + uriO);
            }
            inputStreamOpenInputStream = inputStreamOpenContactPhotoInputStream;
        }
        return getEncodedImage(inputStreamOpenInputStream, -1);
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public String getProducerName() {
        return f41555a;
    }
}
