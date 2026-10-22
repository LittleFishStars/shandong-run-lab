package com.huachenjie.mall.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/mall/bean/EpisodeDetailBean;", "", "episodeName", "", "episodeDesc", "coverUrl", "episodeProgress", "Lcom/huachenjie/mall/bean/EpisodeProgress;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/huachenjie/mall/bean/EpisodeProgress;)V", "getCoverUrl", "()Ljava/lang/String;", "getEpisodeDesc", "getEpisodeName", "getEpisodeProgress", "()Lcom/huachenjie/mall/bean/EpisodeProgress;", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EpisodeDetailBean {

    @NotNull
    private final String coverUrl;

    @NotNull
    private final String episodeDesc;

    @NotNull
    private final String episodeName;

    @Nullable
    private final EpisodeProgress episodeProgress;

    public EpisodeDetailBean() {
        this(null, null, null, null, 15, null);
    }

    public EpisodeDetailBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable EpisodeProgress episodeProgress) {
        Intrinsics.checkNotNullParameter(str, "episodeName");
        Intrinsics.checkNotNullParameter(str2, "episodeDesc");
        Intrinsics.checkNotNullParameter(str3, "coverUrl");
        this.episodeName = str;
        this.episodeDesc = str2;
        this.coverUrl = str3;
        this.episodeProgress = episodeProgress;
    }

    public static /* synthetic */ EpisodeDetailBean copy$default(EpisodeDetailBean episodeDetailBean, String str, String str2, String str3, EpisodeProgress episodeProgress, int i, Object obj) {
        if ((i & 1) != 0) {
            str = episodeDetailBean.episodeName;
        }
        if ((i & 2) != 0) {
            str2 = episodeDetailBean.episodeDesc;
        }
        if ((i & 4) != 0) {
            str3 = episodeDetailBean.coverUrl;
        }
        if ((i & 8) != 0) {
            episodeProgress = episodeDetailBean.episodeProgress;
        }
        return episodeDetailBean.copy(str, str2, str3, episodeProgress);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEpisodeName() {
        return this.episodeName;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEpisodeDesc() {
        return this.episodeDesc;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final EpisodeProgress getEpisodeProgress() {
        return this.episodeProgress;
    }

    @NotNull
    public final EpisodeDetailBean copy(@NotNull String episodeName, @NotNull String episodeDesc, @NotNull String coverUrl, @Nullable EpisodeProgress episodeProgress) {
        Intrinsics.checkNotNullParameter(episodeName, "episodeName");
        Intrinsics.checkNotNullParameter(episodeDesc, "episodeDesc");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        return new EpisodeDetailBean(episodeName, episodeDesc, coverUrl, episodeProgress);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EpisodeDetailBean)) {
            return false;
        }
        EpisodeDetailBean episodeDetailBean = (EpisodeDetailBean) other;
        return Intrinsics.areEqual(this.episodeName, episodeDetailBean.episodeName) && Intrinsics.areEqual(this.episodeDesc, episodeDetailBean.episodeDesc) && Intrinsics.areEqual(this.coverUrl, episodeDetailBean.coverUrl) && Intrinsics.areEqual(this.episodeProgress, episodeDetailBean.episodeProgress);
    }

    @NotNull
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @NotNull
    public final String getEpisodeDesc() {
        return this.episodeDesc;
    }

    @NotNull
    public final String getEpisodeName() {
        return this.episodeName;
    }

    @Nullable
    public final EpisodeProgress getEpisodeProgress() {
        return this.episodeProgress;
    }

    public int hashCode() {
        int iHashCode = ((((this.episodeName.hashCode() * 31) + this.episodeDesc.hashCode()) * 31) + this.coverUrl.hashCode()) * 31;
        EpisodeProgress episodeProgress = this.episodeProgress;
        return iHashCode + (episodeProgress == null ? 0 : episodeProgress.hashCode());
    }

    @NotNull
    public String toString() {
        return "EpisodeDetailBean(episodeName=" + this.episodeName + ", episodeDesc=" + this.episodeDesc + ", coverUrl=" + this.coverUrl + ", episodeProgress=" + this.episodeProgress + ')';
    }

    public /* synthetic */ EpisodeDetailBean(String str, String str2, String str3, EpisodeProgress episodeProgress, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? null : episodeProgress);
    }
}
