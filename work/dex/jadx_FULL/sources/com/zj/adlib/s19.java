package com.zj.adlib;

import com.huachenjie.im.page.TeamChatFragment;
import com.netease.nimlib.sdk.Observer;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final /* synthetic */ class s19 implements Observer, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TeamChatFragment f44587a;

    public /* synthetic */ s19(TeamChatFragment teamChatFragment) {
        this.f44587a = teamChatFragment;
    }

    public final void onEvent(Object obj) {
        this.f44587a.lambda$new$9b1c5750$1((List) obj);
    }
}
