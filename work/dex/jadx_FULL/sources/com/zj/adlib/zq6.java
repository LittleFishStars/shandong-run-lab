package com.zj.adlib;

import android.content.Context;
import android.net.Uri;
import com.huachenjie.common.R;
import com.huachenjie.common.util.media_picker.MediaPickerConstants;
import com.huachenjie.common.util.media_picker.MediaPickerMediaType;
import com.huachenjie.common.util.media_picker.MediaPickerProcessException;
import com.huachenjie.common.util.media_picker.PickType;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b%\u0010&J<\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bJ*\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\u0006\u0010\n\u001a\u00020\tJ*\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\tH\u0002J*\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\tH\u0002J\"\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J \u0010 \u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\"\u0010!\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\"\u0010\"\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010$\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u001bH\u0002¨\u0006'"}, d2 = {"Lcom/zj/adlib/zq6;", "", "Landroid/content/Context;", "context", "", "Landroid/net/Uri;", "uris", "Lcom/huachenjie/common/util/media_picker/PickType;", "pickType", "Lcom/zj/adlib/u64;", "compressConfig", "Lcom/zj/adlib/xn9;", "videoConfig", "Lcom/zj/adlib/wq6;", y6b.g, "", "paths", "f", "uri", "Lcom/zj/adlib/qh9;", "metadata", y6b.f, "d", "path", "e", "Ljava/io/File;", "file", "", "c", "", "maxDurationSeconds", "", "k", "a", "b", "compressed", "j", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPickerMediaProcessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PickerMediaProcessor.kt\ncom/huachenjie/common/util/media_picker/PickerMediaProcessor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,166:1\n1603#2,9:167\n1855#2:176\n1856#2:178\n1612#2:179\n1603#2,9:180\n1855#2:189\n1856#2:191\n1612#2:192\n1#3:177\n1#3:190\n1#3:193\n*S KotlinDebug\n*F\n+ 1 PickerMediaProcessor.kt\ncom/huachenjie/common/util/media_picker/PickerMediaProcessor\n*L\n18#1:167,9\n18#1:176\n18#1:178\n18#1:179\n33#1:180,9\n33#1:189\n33#1:191\n33#1:192\n18#1:177\n33#1:190\n*E\n"})
public final class zq6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final zq6 f46321a = new zq6();

    public static /* synthetic */ List i(zq6 zq6Var, Context context, List list, PickType pickType, ImageCompressConfig imageCompressConfig, VideoPickConfig videoPickConfig, int i, Object obj) {
        if ((i & 16) != 0) {
            videoPickConfig = new VideoPickConfig(0, 1, null);
        }
        return zq6Var.h(context, list, pickType, imageCompressConfig, videoPickConfig);
    }

    public final String a(Context context, Uri uri, UriMetadata metadata) {
        File fileB = b(context, uri, metadata);
        if (fileB != null) {
            return fileB.getAbsolutePath();
        }
        return null;
    }

    public final File b(Context context, Uri uri, UriMetadata metadata) {
        boolean z = false;
        try {
            File file = new File(MediaPickerConstants.f8905a.b(), j(metadata, false));
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream != null) {
                try {
                    jg3.f42579a.n(inputStreamOpenInputStream, file);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(inputStreamOpenInputStream, (Throwable) null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(inputStreamOpenInputStream, th);
                        throw th2;
                    }
                }
            }
            if (file.exists() && file.length() > 0) {
                z = true;
            }
            if (z) {
                return file;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final boolean c(File file) {
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "file.name");
        String lowerCase = StringsKt.substringAfterLast(name, '.', "").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return MediaPickerConstants.f8905a.a().contains(lowerCase);
    }

    public final String d(Context context, Uri uri, UriMetadata metadata, ImageCompressConfig compressConfig) throws MediaPickerProcessException {
        if (!compressConfig.f()) {
            String string = context.getString(R.string.common_media_picker_gif_not_allowed);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…a_picker_gif_not_allowed)");
            throw new MediaPickerProcessException(string);
        }
        File fileB = b(context, uri, metadata);
        if (fileB == null) {
            return null;
        }
        return (!compressConfig.i() || compressConfig.h() <= 0) ? fileB.getAbsolutePath() : xq6.f45878a.a(context, fileB, compressConfig);
    }

    public final String e(Context context, String path, ImageCompressConfig compressConfig) throws MediaPickerProcessException {
        File file = new File(path);
        if (!file.exists() || file.length() == 0) {
            return null;
        }
        if (!compressConfig.i()) {
            return path;
        }
        if (!c(file)) {
            return yq6.d(yq6.f46098a, context, file, compressConfig.h(), compressConfig.g(), null, 16, null);
        }
        if (compressConfig.f()) {
            return xq6.f45878a.a(context, file, compressConfig);
        }
        String string = context.getString(R.string.common_media_picker_gif_not_allowed);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…a_picker_gif_not_allowed)");
        throw new MediaPickerProcessException(string);
    }

    @NotNull
    public final List<PickedMedia> f(@NotNull Context context, @NotNull List<String> paths, @NotNull ImageCompressConfig compressConfig) throws MediaPickerProcessException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(paths, "paths");
        Intrinsics.checkNotNullParameter(compressConfig, "compressConfig");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = paths.iterator();
        while (it.hasNext()) {
            String strE = f46321a.e(context, (String) it.next(), compressConfig);
            PickedMedia pickedMedia = strE == null ? null : new PickedMedia(strE, MediaPickerMediaType.IMAGE);
            if (pickedMedia != null) {
                arrayList.add(pickedMedia);
            }
        }
        return arrayList;
    }

    public final String g(Context context, Uri uri, UriMetadata metadata, ImageCompressConfig compressConfig) {
        if (metadata.i()) {
            return d(context, uri, metadata, compressConfig);
        }
        if (!compressConfig.i() || !br6.f40823a.a(metadata, compressConfig.f())) {
            return a(context, uri, metadata);
        }
        File fileB = b(context, uri, metadata);
        if (fileB == null) {
            return null;
        }
        return yq6.f46098a.c(context, fileB, compressConfig.h(), compressConfig.g(), compressConfig.h() > 0 ? j(metadata, true) : null);
    }

    @NotNull
    public final List<PickedMedia> h(@NotNull Context context, @NotNull List<? extends Uri> uris, @NotNull PickType pickType, @NotNull ImageCompressConfig compressConfig, @NotNull VideoPickConfig videoConfig) throws MediaPickerProcessException, IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uris, "uris");
        Intrinsics.checkNotNullParameter(pickType, "pickType");
        Intrinsics.checkNotNullParameter(compressConfig, "compressConfig");
        Intrinsics.checkNotNullParameter(videoConfig, "videoConfig");
        ArrayList arrayList = new ArrayList();
        for (Uri uri : uris) {
            br6 br6Var = br6.f40823a;
            UriMetadata uriMetadataB = br6Var.b(context, uri);
            if (videoConfig.d() && uriMetadataB.k()) {
                f46321a.k(context, uri, videoConfig.e());
            }
            String strG = f46321a.g(context, uri, uriMetadataB, compressConfig);
            PickedMedia pickedMedia = strG == null ? null : new PickedMedia(strG, br6Var.e(uriMetadataB, pickType));
            if (pickedMedia != null) {
                arrayList.add(pickedMedia);
            }
        }
        return arrayList;
    }

    public final String j(UriMetadata metadata, boolean compressed) {
        String strF = metadata.f();
        if (!metadata.i()) {
            if (strF == null || StringsKt.isBlank(strF)) {
                if (compressed) {
                    strF = System.currentTimeMillis() + "_compressed.jpg";
                } else {
                    strF = String.valueOf(System.currentTimeMillis());
                }
            } else if (compressed) {
                strF = StringsKt.substringBeforeLast(strF, '.', strF) + "_compressed.jpg";
            }
            return yq6.f46098a.e(strF);
        }
        if (strF == null || StringsKt.isBlank(strF)) {
            if (compressed) {
                strF = System.currentTimeMillis() + "_compressed.gif";
            } else {
                strF = System.currentTimeMillis() + ".gif";
            }
        } else if (compressed) {
            strF = StringsKt.substringBeforeLast(strF, '.', strF) + "_compressed.gif";
        }
        return yq6.f46098a.e(strF);
    }

    public final void k(Context context, Uri uri, int maxDurationSeconds) throws MediaPickerProcessException, IOException {
        Long lD = br6.f40823a.d(context, uri);
        if (lD == null || lD.longValue() <= ((long) maxDurationSeconds) * 1000) {
            return;
        }
        String string = context.getString(R.string.common_media_picker_video_duration_limit, Integer.valueOf(maxDurationSeconds));
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…imit, maxDurationSeconds)");
        throw new MediaPickerProcessException(string);
    }
}
