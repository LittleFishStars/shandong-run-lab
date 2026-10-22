package com.huachenjie.run.bean;

import com.alibaba.android.arouter.utils.Consts;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import com.huachenjie.mine.page.dressing_table.avatar.AvatarFragment;
import com.huachenjie.run.page.sun_run.success.SchoolActivitySuccessActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001f\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\u0006\u00102\u001a\u00020\u0005R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\"\"\u0004\b$\u0010%R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010,R\u001a\u0010\u000f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001b\"\u0004\b.\u0010/R\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u0010,¨\u00063"}, d2 = {"Lcom/huachenjie/run/bean/RankItemData;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", CollegeTownItemFragment.ITEM_TYPE, "", "appUserCode", "", AvatarFragment.AVATAR_URL, "avatarFrameImgUrl", SchoolActivitySuccessActivity.x, "", "name", "rankNumber", "progress", "", "duration", "updateTime", "updateTimeStr", "stageName", "likeCount", "hasLiked", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;IFLjava/lang/String;JLjava/lang/String;Ljava/lang/String;IZ)V", "getAppUserCode", "()Ljava/lang/String;", "getAvatarFrameImgUrl", "getAvatarUrl", "getDistance", "()J", "getDuration", "getHasLiked", "()Z", "setHasLiked", "(Z)V", "getItemType", "()I", "getLikeCount", "setLikeCount", "(I)V", "getName", "getProgress", "()F", "getRankNumber", "getStageName", "setStageName", "(Ljava/lang/String;)V", "getUpdateTime", "setUpdateTime", "(J)V", "getUpdateTimeStr", "setUpdateTimeStr", "formatLikeCount", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RankItemData implements MultiItemEntity {

    @NotNull
    private final String appUserCode;

    @Nullable
    private final String avatarFrameImgUrl;

    @Nullable
    private final String avatarUrl;
    private final long distance;

    @Nullable
    private final String duration;
    private boolean hasLiked;
    private final int itemType;
    private int likeCount;

    @Nullable
    private final String name;
    private final float progress;
    private final int rankNumber;

    @Nullable
    private String stageName;
    private long updateTime;

    @NotNull
    private String updateTimeStr;

    public RankItemData(int i, @NotNull String str, @Nullable String str2, @Nullable String str3, long j, @Nullable String str4, int i2, float f, @Nullable String str5, long j2, @NotNull String str6, @Nullable String str7, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "appUserCode");
        Intrinsics.checkNotNullParameter(str6, "updateTimeStr");
        this.itemType = i;
        this.appUserCode = str;
        this.avatarUrl = str2;
        this.avatarFrameImgUrl = str3;
        this.distance = j;
        this.name = str4;
        this.rankNumber = i2;
        this.progress = f;
        this.duration = str5;
        this.updateTime = j2;
        this.updateTimeStr = str6;
        this.stageName = str7;
        this.likeCount = i3;
        this.hasLiked = z;
    }

    @NotNull
    public final String formatLikeCount() {
        String string;
        int i = this.likeCount;
        if (i < 10000) {
            return String.valueOf(i);
        }
        if (i < 100000) {
            try {
                List listSplit$default = StringsKt.split$default(String.valueOf(i / 10000.0f), new String[]{Consts.DOT}, false, 0, 6, (Object) null);
                String str = (String) listSplit$default.get(0);
                String str2 = (String) listSplit$default.get(1);
                if (StringsKt.startsWith$default(str2, "0", false, 2, (Object) null)) {
                    string = str + 'W';
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append('.');
                    String strSubstring = str2.substring(0, 1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    sb.append(strSubstring);
                    sb.append('W');
                    string = sb.toString();
                }
                return string;
            } catch (Exception unused) {
            }
        }
        return "10W+";
    }

    @NotNull
    public final String getAppUserCode() {
        return this.appUserCode;
    }

    @Nullable
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    @Nullable
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final long getDistance() {
        return this.distance;
    }

    @Nullable
    public final String getDuration() {
        return this.duration;
    }

    public final boolean getHasLiked() {
        return this.hasLiked;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.itemType;
    }

    public final int getLikeCount() {
        return this.likeCount;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public final float getProgress() {
        return this.progress;
    }

    public final int getRankNumber() {
        return this.rankNumber;
    }

    @Nullable
    public final String getStageName() {
        return this.stageName;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    @NotNull
    public final String getUpdateTimeStr() {
        return this.updateTimeStr;
    }

    public final void setHasLiked(boolean z) {
        this.hasLiked = z;
    }

    public final void setLikeCount(int i) {
        this.likeCount = i;
    }

    public final void setStageName(@Nullable String str) {
        this.stageName = str;
    }

    public final void setUpdateTime(long j) {
        this.updateTime = j;
    }

    public final void setUpdateTimeStr(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.updateTimeStr = str;
    }

    public /* synthetic */ RankItemData(int i, String str, String str2, String str3, long j, String str4, int i2, float f, String str5, long j2, String str6, String str7, int i3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i4 & 2) != 0 ? "" : str, str2, str3, (i4 & 16) != 0 ? 0L : j, str4, (i4 & 64) != 0 ? 0 : i2, (i4 & 128) != 0 ? 0.0f : f, (i4 & 256) != 0 ? null : str5, (i4 & 512) != 0 ? 0L : j2, (i4 & 1024) != 0 ? "" : str6, (i4 & 2048) != 0 ? "" : str7, (i4 & 4096) != 0 ? 0 : i3, (i4 & 8192) != 0 ? false : z);
    }
}
