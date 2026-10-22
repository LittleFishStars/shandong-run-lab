package com.huachenjie.mall.bean;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/huachenjie/mall/bean/VideoEnterTabBean;", "", "name", "", RemoteMessageConst.Notification.ICON, "", "selIcon", "(Ljava/lang/String;II)V", "getIcon", "()I", "getName", "()Ljava/lang/String;", "getSelIcon", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VideoEnterTabBean {
    private final int icon;

    @NotNull
    private final String name;
    private final int selIcon;

    public VideoEnterTabBean() {
        this(null, 0, 0, 7, null);
    }

    public VideoEnterTabBean(@NotNull String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
        this.icon = i;
        this.selIcon = i2;
    }

    public final int getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getSelIcon() {
        return this.selIcon;
    }

    public /* synthetic */ VideoEnterTabBean(String str, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2);
    }
}
