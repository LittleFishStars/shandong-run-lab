package com.zj.adlib;

import android.content.Context;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import com.huachenjie.common.util.media_picker.MediaPickerMediaType;
import com.huachenjie.common.util.media_picker.PickType;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\u001f\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0012\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¨\u0006\u001b"}, d2 = {"Lcom/zj/adlib/br6;", "", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "uri", "Lcom/zj/adlib/qh9;", "b", "metadata", "Lcom/huachenjie/common/util/media_picker/PickType;", "pickType", "Lcom/huachenjie/common/util/media_picker/MediaPickerMediaType;", "e", "", "d", "(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/Long;", "", "allowGif", "a", "Landroid/database/Cursor;", "cursor", "", "index", "", "c", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class br6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final br6 f40823a = new br6();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f40824a;

        static {
            int[] iArr = new int[PickType.values().length];
            try {
                iArr[PickType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PickType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PickType.IMAGE_AND_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f40824a = iArr;
        }
    }

    public final boolean a(@NotNull UriMetadata metadata, boolean allowGif) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        if (metadata.i()) {
            return allowGif;
        }
        String strH = metadata.h();
        return strH != null && StringsKt.startsWith$default(strH, "image/", false, 2, (Object) null);
    }

    @NotNull
    public final UriMetadata b(@NotNull Context context, @NotNull Uri uri) {
        UriMetadata uriMetadata;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{com.google.android.exoplayer2.offline.a.f3586e, "_display_name"}, null, null, null);
        if (cursorQuery == null) {
            return new UriMetadata(null, null, uri.getLastPathSegment());
        }
        Cursor cursor = cursorQuery;
        try {
            Cursor cursor2 = cursor;
            if (cursor2.moveToFirst()) {
                int columnIndex = cursor2.getColumnIndex(com.google.android.exoplayer2.offline.a.f3586e);
                int columnIndex2 = cursor2.getColumnIndex("_display_name");
                br6 br6Var = f40823a;
                uriMetadata = new UriMetadata(br6Var.c(cursor2, columnIndex), br6Var.c(cursor2, columnIndex2), uri.getLastPathSegment());
            } else {
                uriMetadata = new UriMetadata(null, null, uri.getLastPathSegment());
            }
            CloseableKt.closeFinally(cursor, (Throwable) null);
            return uriMetadata;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(cursor, th);
                throw th2;
            }
        }
    }

    public final String c(Cursor cursor, int index) {
        if (index < 0 || cursor.isNull(index)) {
            return null;
        }
        return cursor.getString(index);
    }

    @Nullable
    public final Long d(@NotNull Context context, @NotNull Uri uri) throws IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        Long longOrNull = null;
        try {
            try {
                mediaMetadataRetriever.setDataSource(context, uri);
                String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
                if (strExtractMetadata != null) {
                    longOrNull = StringsKt.toLongOrNull(strExtractMetadata);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return longOrNull;
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    @NotNull
    public final MediaPickerMediaType e(@NotNull UriMetadata metadata, @NotNull PickType pickType) throws NoWhenBranchMatchedException {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(pickType, "pickType");
        int i = a.f40824a[pickType.ordinal()];
        if (i == 1) {
            return MediaPickerMediaType.IMAGE;
        }
        if (i == 2) {
            return MediaPickerMediaType.VIDEO;
        }
        if (i == 3) {
            return metadata.k() ? MediaPickerMediaType.VIDEO : MediaPickerMediaType.IMAGE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
