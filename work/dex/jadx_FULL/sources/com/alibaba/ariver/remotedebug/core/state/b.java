package com.alibaba.ariver.remotedebug.core.state;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RemoteDebugState f24387a = RemoteDebugState.STATE_NON_REMOTE_DEBUG;
    private final List<a> b = new ArrayList();

    public void a(a aVar) {
        this.b.add(aVar);
        aVar.a(this.f24387a);
    }

    public void a(RemoteDebugState remoteDebugState) {
        for (a aVar : this.b) {
            if (aVar != null) {
                aVar.a(remoteDebugState);
            }
        }
    }
}
