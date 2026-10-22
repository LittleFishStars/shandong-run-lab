package com.huachenjie.mall.bean;

import com.aliyun.auth.common.AliyunVodHttpCommon;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/mall/bean/ApplyRefundFileBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", CollegeTownItemFragment.ITEM_TYPE, "", "path", "", AliyunVodHttpCommon.ImageType.IMAGETYPE_COVER, "name", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCover", "()Ljava/lang/String;", "getItemType", "()I", "getName", "setName", "(Ljava/lang/String;)V", "getPath", "Companion", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ApplyRefundFileBean implements MultiItemEntity {
    public static final int ITEM_TYPE_ADD = 2;
    public static final int ITEM_TYPE_PIC = 1;

    @Nullable
    private final String cover;
    private final int itemType;

    @NotNull
    private String name;

    @Nullable
    private final String path;

    public ApplyRefundFileBean() {
        this(0, null, null, null, 15, null);
    }

    public ApplyRefundFileBean(int i, @Nullable String str, @Nullable String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str3, "name");
        this.itemType = i;
        this.path = str;
        this.cover = str2;
        this.name = str3;
    }

    @Nullable
    public final String getCover() {
        return this.cover;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.itemType;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getPath() {
        return this.path;
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public /* synthetic */ ApplyRefundFileBean(int i, String str, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1 : i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? "" : str3);
    }
}
