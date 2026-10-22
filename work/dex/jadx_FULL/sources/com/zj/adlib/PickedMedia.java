package com.zj.adlib;

import com.huachenjie.common.util.media_picker.MediaPickerMediaType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.zj.adlib.wq6, reason: from toString */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\t\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/zj/adlib/wq6;", "", "", "a", "Lcom/huachenjie/common/util/media_picker/MediaPickerMediaType;", "b", "path", "type", "c", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "Lcom/huachenjie/common/util/media_picker/MediaPickerMediaType;", "getType", "()Lcom/huachenjie/common/util/media_picker/MediaPickerMediaType;", "f", "()Z", "isVideo", "<init>", "(Ljava/lang/String;Lcom/huachenjie/common/util/media_picker/MediaPickerMediaType;)V", "common_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class PickedMedia {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    public final MediaPickerMediaType type;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
    @NotNull
    public final String path;

    public PickedMedia(@NotNull String str, @NotNull MediaPickerMediaType mediaPickerMediaType) {
        Intrinsics.checkNotNullParameter(str, "path");
        Intrinsics.checkNotNullParameter(mediaPickerMediaType, "type");
        this.path = str;
        this.type = mediaPickerMediaType;
    }

    public static /* synthetic */ PickedMedia d(PickedMedia pickedMedia, String str, MediaPickerMediaType mediaPickerMediaType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pickedMedia.path;
        }
        if ((i & 2) != 0) {
            mediaPickerMediaType = pickedMedia.type;
        }
        return pickedMedia.c(str, mediaPickerMediaType);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    @NotNull
    /* JADX INFO: renamed from: b, reason: from getter */
    public final MediaPickerMediaType getType() {
        return this.type;
    }

    @NotNull
    public final PickedMedia c(@NotNull String path, @NotNull MediaPickerMediaType type) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(type, "type");
        return new PickedMedia(path, type);
    }

    @NotNull
    public final String e() {
        return this.path;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PickedMedia)) {
            return false;
        }
        PickedMedia pickedMedia = (PickedMedia) other;
        return Intrinsics.areEqual(this.path, pickedMedia.path) && this.type == pickedMedia.type;
    }

    public final boolean f() {
        return this.type == MediaPickerMediaType.VIDEO;
    }

    @NotNull
    public final MediaPickerMediaType getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.path.hashCode() * 31) + this.type.hashCode();
    }

    @NotNull
    public String toString() {
        return "PickedMedia(path=" + this.path + ", type=" + this.type + ")";
    }
}
