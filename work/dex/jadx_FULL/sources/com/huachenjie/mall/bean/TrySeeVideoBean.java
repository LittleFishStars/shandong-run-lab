package com.huachenjie.mall.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/mall/bean/TrySeeVideoBean;", "", "goodsName", "", "episodeNo", "goodsImage", "trySee", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getEpisodeNo", "()Ljava/lang/String;", "getGoodsImage", "getGoodsName", "getTrySee", "()I", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TrySeeVideoBean {

    @NotNull
    private final String episodeNo;

    @NotNull
    private final String goodsImage;

    @NotNull
    private final String goodsName;
    private final int trySee;

    public TrySeeVideoBean() {
        this(null, null, null, 0, 15, null);
    }

    public TrySeeVideoBean(@NotNull String str, @NotNull String str2, @NotNull String str3, int i) {
        Intrinsics.checkNotNullParameter(str, "goodsName");
        Intrinsics.checkNotNullParameter(str2, "episodeNo");
        Intrinsics.checkNotNullParameter(str3, "goodsImage");
        this.goodsName = str;
        this.episodeNo = str2;
        this.goodsImage = str3;
        this.trySee = i;
    }

    @NotNull
    public final String getEpisodeNo() {
        return this.episodeNo;
    }

    @NotNull
    public final String getGoodsImage() {
        return this.goodsImage;
    }

    @NotNull
    public final String getGoodsName() {
        return this.goodsName;
    }

    public final int getTrySee() {
        return this.trySee;
    }

    public /* synthetic */ TrySeeVideoBean(String str, String str2, String str3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? 0 : i);
    }
}
