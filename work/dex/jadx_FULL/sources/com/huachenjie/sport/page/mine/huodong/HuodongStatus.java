package com.huachenjie.sport.page.mine.huodong;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/sport/page/mine/huodong/HuodongStatus;", "", "id", "", "content", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getId", "()I", "sign_in_progress", "sign_not_start", "sign_finish", "huodong_in_progress", "huodong_stop", "huodong_finish", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum HuodongStatus {
    sign_in_progress(1, "报名中"),
    sign_not_start(2, "未开始报名"),
    sign_finish(3, "报名结束"),
    huodong_in_progress(4, "活动进行中"),
    huodong_stop(5, "活动终止"),
    huodong_finish(6, "活动结束");


    @NotNull
    private final String content;
    private final int id;

    HuodongStatus(int i, String str) {
        this.id = i;
        this.content = str;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public final int getId() {
        return this.id;
    }
}
