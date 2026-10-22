package com.ipd.dsp.internal.h;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.Dsp;
import com.ipd.dsp.internal.c2.k;
import com.ipd.dsp.internal.components.glide.load.ImageHeaderParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e {
    public static final String f = "ThumbStreamOpener";
    public static final a g = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f38314a;
    public final d b;
    public final com.ipd.dsp.internal.j.b c;
    public final ContentResolver d;
    public final List<ImageHeaderParser> e;

    public e(List<ImageHeaderParser> list, d dVar, com.ipd.dsp.internal.j.b bVar, ContentResolver contentResolver) {
        this(list, g, dVar, bVar, contentResolver);
    }

    public int a(Uri uri) {
        try {
            InputStream inputStreamOpenInputStream = this.d.openInputStream(uri);
            try {
                int iA = com.ipd.dsp.internal.components.glide.load.a.a(this.e, inputStreamOpenInputStream, this.c);
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
                return iA;
            } catch (Throwable th) {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException | NullPointerException e) {
            if (!Dsp.isDebugLogEnable()) {
                return -1;
            }
            k.a(f, "Failed to open uri: " + uri, e);
            return -1;
        }
    }

    @Nullable
    public final String b(@NonNull Uri uri) {
        try {
            Cursor cursorA = this.b.a(uri);
            if (cursorA != null) {
                try {
                    if (cursorA.moveToFirst()) {
                        String string = cursorA.getString(0);
                        cursorA.close();
                        return string;
                    }
                } catch (Throwable th) {
                    try {
                        cursorA.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            if (cursorA != null) {
                cursorA.close();
            }
            return null;
        } catch (SecurityException e) {
            if (Dsp.isDebugLogEnable()) {
                k.a(f, "Failed to query for thumbnail for Uri: " + uri, e);
            }
            return null;
        }
    }

    public InputStream c(Uri uri) throws FileNotFoundException {
        String strB = b(uri);
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        File fileA = this.f38314a.a(strB);
        if (!a(fileA)) {
            return null;
        }
        Uri uriFromFile = Uri.fromFile(fileA);
        try {
            return this.d.openInputStream(uriFromFile);
        } catch (NullPointerException e) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + uriFromFile).initCause(e));
        }
    }

    public e(List<ImageHeaderParser> list, a aVar, d dVar, com.ipd.dsp.internal.j.b bVar, ContentResolver contentResolver) {
        this.f38314a = aVar;
        this.b = dVar;
        this.c = bVar;
        this.d = contentResolver;
        this.e = list;
    }

    public final boolean a(File file) {
        return this.f38314a.a(file) && 0 < this.f38314a.b(file);
    }
}
