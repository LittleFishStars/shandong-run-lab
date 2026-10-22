package com.zj.adlib;

import com.google.android.inner_exoplayer2.Player;
import com.google.android.inner_exoplayer2.util.ListenerSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final /* synthetic */ class o93 implements ListenerSet.Event {
    @Override // com.google.android.inner_exoplayer2.util.ListenerSet.Event
    public final void invoke(Object obj) {
        ((Player.Listener) obj).onSeekProcessed();
    }
}
