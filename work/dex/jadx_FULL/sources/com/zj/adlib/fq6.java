package com.zj.adlib;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.PickVisualMediaRequestKt;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.FileProvider;
import com.alibaba.triver.embed.video.video.h;
import com.google.android.exoplayer2.util.FileTypes;
import com.huachenjie.common.util.media_picker.MediaPickerRequest;
import com.huachenjie.common.util.media_picker.PickType;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ \u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eJ,\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eJ\u001c\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\bH\u0002¨\u0006\u0018"}, d2 = {"Lcom/zj/adlib/fq6;", "", "", "e", "Lcom/huachenjie/common/util/media_picker/b;", "request", "Landroidx/activity/result/PickVisualMediaRequest;", y6b.f, "Landroid/content/Context;", "context", "Ljava/io/File;", "file", "Landroid/net/Uri;", "f", "", "category", "fileName", "b", "Lkotlin/Pair;", "c", "a", "d", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class fq6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final fq6 f41732a = new fq6();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41733a;

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
            f41733a = iArr;
        }
    }

    @Nullable
    public final Pair<File, Uri> a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return c(context, h.d, "IMG_" + System.currentTimeMillis() + FileTypes.F);
    }

    @Nullable
    public final File b(@NotNull Context context, @NotNull String category, @NotNull String fileName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (externalFilesDir == null && (externalFilesDir = context.getExternalCacheDir()) == null && (externalFilesDir = context.getCacheDir()) == null) {
            return null;
        }
        File file = new File(externalFilesDir, "media_picker/" + category);
        if (file.exists() || file.mkdirs()) {
            return new File(file, fileName);
        }
        return null;
    }

    @Nullable
    public final Pair<File, Uri> c(@NotNull Context context, @NotNull String category, @NotNull String fileName) {
        Uri uriF;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        try {
            File fileB = b(context, category, fileName);
            if (fileB == null) {
                return null;
            }
            if ((fileB.exists() || fileB.createNewFile()) && (uriF = f(context, fileB)) != null) {
                return TuplesKt.to(fileB, uriF);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final String d(Context context) {
        return context.getPackageName() + ".FileProvider";
    }

    public final int e() {
        if (Build.VERSION.SDK_INT >= 33) {
            return MediaStore.getPickImagesMaxLimit();
        }
        return 100;
    }

    @Nullable
    public final Uri f(@NotNull Context context, @NotNull File file) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        try {
            return FileProvider.getUriForFile(context, d(context), file);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @NotNull
    public final PickVisualMediaRequest g(@NotNull MediaPickerRequest request) {
        ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType;
        Intrinsics.checkNotNullParameter(request, "request");
        int i = a.f41733a[request.getType().ordinal()];
        if (i == 1) {
            visualMediaType = ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE;
        } else if (i == 2) {
            visualMediaType = ActivityResultContracts.PickVisualMedia.VideoOnly.INSTANCE;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            visualMediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        }
        return PickVisualMediaRequestKt.PickVisualMediaRequest(visualMediaType);
    }
}
