package com.huachenjie.college.bean;

import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/college/bean/RecommendItemBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "bizName", "", "coverImg", "relationUrl", UserTrackConstant.JUMP_TYPE, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getBizName", "()Ljava/lang/String;", "getCoverImg", CollegeTownItemFragment.ITEM_TYPE, "getItemType", "()I", "getJumpType", "getRelationUrl", "college_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class RecommendItemBean implements MultiItemEntity {

    @NotNull
    private final String bizName;

    @NotNull
    private final String coverImg;
    private final int jumpType;

    @NotNull
    private final String relationUrl;

    public RecommendItemBean() {
        this(null, null, null, 0, 15, null);
    }

    public RecommendItemBean(@NotNull String str, @NotNull String str2, @NotNull String str3, int i) {
        Intrinsics.checkNotNullParameter(str, "bizName");
        Intrinsics.checkNotNullParameter(str2, "coverImg");
        Intrinsics.checkNotNullParameter(str3, "relationUrl");
        this.bizName = str;
        this.coverImg = str2;
        this.relationUrl = str3;
        this.jumpType = i;
    }

    @NotNull
    public final String getBizName() {
        return this.bizName;
    }

    @NotNull
    public final String getCoverImg() {
        return this.coverImg;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 0;
    }

    public final int getJumpType() {
        return this.jumpType;
    }

    @NotNull
    public final String getRelationUrl() {
        return this.relationUrl;
    }

    public /* synthetic */ RecommendItemBean(String str, String str2, String str3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? 0 : i);
    }
}
