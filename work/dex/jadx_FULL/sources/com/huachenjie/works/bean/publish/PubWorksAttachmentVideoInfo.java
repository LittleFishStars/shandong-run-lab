package com.huachenjie.works.bean.publish;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/works/bean/publish/PubWorksAttachmentVideoInfo;", "", "name", "", "signId", "width", "", "height", "(Ljava/lang/String;Ljava/lang/String;II)V", "getHeight", "()I", "setHeight", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getSignId", "setSignId", "getWidth", "setWidth", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class PubWorksAttachmentVideoInfo {
    private int height;

    @NotNull
    private String name;

    @Nullable
    private String signId;
    private int width;

    public PubWorksAttachmentVideoInfo() {
        this(null, null, 0, 0, 15, null);
    }

    public PubWorksAttachmentVideoInfo(@NotNull String str, @Nullable String str2, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
        this.signId = str2;
        this.width = i;
        this.height = i2;
    }

    public final int getHeight() {
        return this.height;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getSignId() {
        return this.signId;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setSignId(@Nullable String str) {
        this.signId = str;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    public /* synthetic */ PubWorksAttachmentVideoInfo(String str, String str2, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }
}
