package com.huachenjie.common.util.media_picker;

import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.fl.saas.common.util.FileTypeUtils;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.en6;
import java.io.File;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001b\u0010\n\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\fR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0014\u0010\u0015\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\fR\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0012\u0010\u0018R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0003\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/common/util/media_picker/MediaPickerConstants;", "", "", "a", "Ljava/lang/String;", "SANDBOX_SUBDIR", "Ljava/io/File;", "Lkotlin/Lazy;", "b", "()Ljava/io/File;", "sandboxDir", "", "I", "FALLBACK_MAX_PICK_LIMIT", "JPEG_QUALITY", "", "J", "LUBAN_TIMEOUT_SECONDS", "c", "DEFAULT_GIF_FRAME_DELAY_MS", "d", "CROP_THUMBNAIL_SIZE", "", "Ljava/util/Set;", "()Ljava/util/Set;", "VIDEO_EXTENSIONS", "GIF_EXTENSIONS", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class MediaPickerConstants {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final int FALLBACK_MAX_PICK_LIMIT = 100;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public static final long LUBAN_TIMEOUT_SECONDS = 30;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String SANDBOX_SUBDIR = "media_picker";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static final int JPEG_QUALITY = 85;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static final int DEFAULT_GIF_FRAME_DELAY_MS = 100;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public static final int CROP_THUMBNAIL_SIZE = 240;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final MediaPickerConstants f8905a = new MediaPickerConstants();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final Lazy sandboxDir = LazyKt.lazy(new Function0<File>() { // from class: com.huachenjie.common.util.media_picker.MediaPickerConstants$sandboxDir$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final File m361invoke() {
            File file = new File(en6.F(), MediaPickerConstants.SANDBOX_SUBDIR);
            file.mkdirs();
            return file;
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final Set<String> VIDEO_EXTENSIONS = SetsKt.setOf(new String[]{"3g2", "3gp", "asf", "avi", "f4v", LiveConfigKey.FLV, "m2ts", "m4v", "mkv", "mov", "mp4", "mpeg", "mpg", "mts", "ogv", "qt", t.w, "rmvb", "ts", MatroskaExtractor.c, "wmv"});

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final Set<String> GIF_EXTENSIONS = SetsKt.setOf(FileTypeUtils.FILE_TYPE_GIF);

    @NotNull
    public final Set<String> a() {
        return GIF_EXTENSIONS;
    }

    @NotNull
    public final File b() {
        return (File) sandboxDir.getValue();
    }

    @NotNull
    public final Set<String> c() {
        return VIDEO_EXTENSIONS;
    }
}
