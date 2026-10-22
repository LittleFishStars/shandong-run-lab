package com.huachenjie.college.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/huachenjie/college/bean/GameUserBean;", "", "gameUserNo", "", "(Ljava/lang/String;)V", "getGameUserNo", "()Ljava/lang/String;", "college_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GameUserBean {

    @NotNull
    private final String gameUserNo;

    /* JADX WARN: Illegal instructions before constructor call */
    public GameUserBean() {
        String str = null;
        this(str, 1, str);
    }

    public GameUserBean(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "gameUserNo");
        this.gameUserNo = str;
    }

    @NotNull
    public final String getGameUserNo() {
        return this.gameUserNo;
    }

    public /* synthetic */ GameUserBean(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }
}
