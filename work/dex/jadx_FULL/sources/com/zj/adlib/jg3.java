package com.zj.adlib;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.alibaba.android.arouter.utils.Consts;
import com.google.android.exoplayer2.offline.a;
import com.google.android.exoplayer2.source.rtsp.j;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b(\u0010)J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0004J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006J;\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 J\u000e\u0010!\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\"\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010#\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u000eR\u0014\u0010'\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/zj/adlib/jg3;", "", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "uri", "Ljava/io/File;", "j", "", "p", "f", "k", "b", y6b.f, "", "type", "d", "e", "photoUri", "m", t.d, "i", y6b.g, "Ljava/io/InputStream;", "inputStream", "file", "", "n", "selection", "", "selectionArgs", "c", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", j.b, "r", "q", "filePath", "a", "Ljava/lang/String;", "TAG", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class jg3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final jg3 f42579a = new jg3();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String TAG = "FileProvider.FileUtil";

    @JvmStatic
    @Nullable
    public static final File j(@NotNull Context context, @NotNull Uri uri) {
        String path;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        String scheme = uri.getScheme();
        if (Intrinsics.areEqual("content", scheme)) {
            String[] strArr = {"_data"};
            Cursor cursorQuery = context.getContentResolver().query(uri, strArr, null, null, null);
            Intrinsics.checkNotNull(cursorQuery);
            cursorQuery.moveToFirst();
            int columnIndex = cursorQuery.getColumnIndex(strArr[0]);
            if (columnIndex >= 0) {
                path = cursorQuery.getString(columnIndex);
            } else {
                path = TextUtils.equals(uri.getAuthority(), yf3.a(context)) ? sh9.l(context, uri) : null;
            }
            cursorQuery.close();
        } else {
            path = Intrinsics.areEqual("file", scheme) ? uri.getPath() : null;
        }
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        return new File(path);
    }

    @JvmStatic
    public static final boolean p(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return Intrinsics.areEqual("com.android.externalstorage.documents", uri.getAuthority());
    }

    public final boolean a(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return new File(filePath).exists();
    }

    @Nullable
    public final File b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            String str = new Random().nextInt() + "_temp.jpg";
            File file = new File(nq6.f43588a.k(context).getAbsolutePath());
            if (!file.exists()) {
                file.mkdirs();
            }
            if (Build.VERSION.SDK_INT < 30) {
                return new File(file.getAbsolutePath() + File.separator + str);
            }
            File file2 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() + File.separator + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put("_data", file2.getAbsolutePath());
            contentValues.put("_display_name", str);
            contentValues.put(a.f3586e, "image/jpeg");
            context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            return file2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Nullable
    public final String c(@NotNull Context context, @Nullable Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) throws Throwable {
        Cursor cursorQuery;
        Intrinsics.checkNotNullParameter(context, "context");
        String[] strArr = {"_data"};
        Cursor cursor = null;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            Intrinsics.checkNotNull(uri);
            cursorQuery = contentResolver.query(uri, strArr, selection, selectionArgs, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                        cursorQuery.close();
                        return string;
                    }
                } catch (IllegalArgumentException unused) {
                    if (cursorQuery != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (IllegalArgumentException unused2) {
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
        }
        return null;
    }

    @Nullable
    public final File d(@NotNull Context context, @NotNull String type) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(type, "type");
        return context.getExternalFilesDir(type);
    }

    @NotNull
    public final String e(@NotNull Context context) {
        String path;
        Intrinsics.checkNotNullParameter(context, "context");
        if (Intrinsics.areEqual("mounted", Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            File externalCacheDir = context.getExternalCacheDir();
            path = externalCacheDir != null ? externalCacheDir.getPath() : context.getCacheDir().getPath();
            Intrinsics.checkNotNullExpressionValue(path, "{\n                val f …          }\n            }");
        } else {
            path = context.getCacheDir().getPath();
            Intrinsics.checkNotNullExpressionValue(path, "{\n                contex…cheDir.path\n            }");
        }
        return path + File.separator;
    }

    @Nullable
    public final File f(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getExternalCacheDir();
    }

    @Nullable
    public final File g(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
    }

    @RequiresApi(19)
    @Nullable
    public final String h(@NotNull Context context, @NotNull Uri uri) throws Throwable {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (Intrinsics.areEqual("content", uri.getScheme())) {
            String path = uri.getPath();
            Intrinsics.checkNotNull(path);
            if (StringsKt.contains$default(path, "document", false, 2, (Object) null)) {
                File fileL = l(context, uri);
                try {
                    n(context.getContentResolver().openInputStream(uri), fileL);
                    return fileL.getPath();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return i(context, uri);
    }

    @Nullable
    public final String i(@NotNull Context context, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        File fileJ = j(context, uri);
        if (fileJ != null) {
            return fileJ.getPath();
        }
        return null;
    }

    @Nullable
    public final File k(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getCacheDir();
    }

    @RequiresApi(19)
    @NotNull
    public final File l(@NotNull Context context, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        String strD = sh9.d(context, uri);
        String str = Environment.DIRECTORY_DOCUMENTS;
        Intrinsics.checkNotNullExpressionValue(str, "DIRECTORY_DOCUMENTS");
        File fileD = d(context, str);
        if (fileD != null && !fileD.exists()) {
            fileD.mkdirs();
        }
        return new File(fileD, UUID.randomUUID().toString() + Consts.DOT + strD);
    }

    @NotNull
    public final File m(@NotNull Context context, @NotNull Uri photoUri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(photoUri, "photoUri");
        String strD = sh9.d(context, photoUri);
        File fileF = f(context);
        if (fileF != null && !fileF.exists()) {
            fileF.mkdirs();
        }
        return new File(fileF, UUID.randomUUID().toString() + Consts.DOT + strD);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x005a A[Catch: IOException -> 0x0056, TRY_LEAVE, TryCatch #1 {IOException -> 0x0056, blocks: (B:31:0x004f, B:35:0x005a), top: B:39:0x004f }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.io.InputStream, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.IOException, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v5 */
    public final void n(@Nullable InputStream inputStream, @Nullable File file) throws Throwable {
        if (file == null || inputStream == 0) {
            Log.i(TAG, "inputStreamToFile:file not be null");
        }
        ?? r0 = 0;
        r0 = 0;
        r0 = 0;
        try {
            try {
                try {
                    ?? fileOutputStream = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[10240];
                        while (true) {
                            Intrinsics.checkNotNull((Object) inputStream);
                            r0 = inputStream.read(bArr);
                            if (r0 == -1) {
                                break;
                            } else {
                                fileOutputStream.write(bArr, 0, r0);
                            }
                        }
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        inputStream.close();
                    } catch (IOException e) {
                        e = e;
                        r0 = fileOutputStream;
                        e.printStackTrace();
                        if (r0 != 0) {
                            r0.flush();
                            r0.close();
                        }
                        if (inputStream != 0) {
                            inputStream.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        r0 = fileOutputStream;
                        if (r0 != 0) {
                            try {
                                r0.flush();
                                r0.close();
                                if (inputStream != 0) {
                                    inputStream.close();
                                }
                            } catch (IOException e2) {
                                e2.printStackTrace();
                                throw th;
                            }
                        } else if (inputStream != 0) {
                            inputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (IOException e4) {
            inputStream = e4;
            inputStream.printStackTrace();
        }
    }

    public final boolean o(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return Intrinsics.areEqual("com.android.providers.downloads.documents", uri.getAuthority());
    }

    public final boolean q(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return Intrinsics.areEqual("com.google.android.apps.photos.content", uri.getAuthority());
    }

    public final boolean r(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return Intrinsics.areEqual("com.android.providers.media.documents", uri.getAuthority());
    }
}
