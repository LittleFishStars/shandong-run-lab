package com.huachenjie.run.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/run/bean/RankingRangeBean;", "", "name", "", "code", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "component1", "component2", OperatePopupWindow.g, "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/huachenjie/run/bean/RankingRangeBean;", "equals", "", "other", "hashCode", "toString", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RankingRangeBean {

    @Nullable
    private final Integer code;

    @Nullable
    private final String name;

    /* JADX WARN: Multi-variable type inference failed */
    public RankingRangeBean() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public RankingRangeBean(@Nullable String str, @Nullable Integer num) {
        this.name = str;
        this.code = num;
    }

    public static /* synthetic */ RankingRangeBean copy$default(RankingRangeBean rankingRangeBean, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rankingRangeBean.name;
        }
        if ((i & 2) != 0) {
            num = rankingRangeBean.code;
        }
        return rankingRangeBean.copy(str, num);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getCode() {
        return this.code;
    }

    @NotNull
    public final RankingRangeBean copy(@Nullable String name, @Nullable Integer code) {
        return new RankingRangeBean(name, code);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RankingRangeBean)) {
            return false;
        }
        RankingRangeBean rankingRangeBean = (RankingRangeBean) other;
        return Intrinsics.areEqual(this.name, rankingRangeBean.name) && Intrinsics.areEqual(this.code, rankingRangeBean.code);
    }

    @Nullable
    public final Integer getCode() {
        return this.code;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.code;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "RankingRangeBean(name=" + this.name + ", code=" + this.code + ')';
    }

    public /* synthetic */ RankingRangeBean(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "年级" : str, (i & 2) != 0 ? 20 : num);
    }
}
