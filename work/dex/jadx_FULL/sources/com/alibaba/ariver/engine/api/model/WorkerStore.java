package com.alibaba.ariver.engine.api.model;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class WorkerStore {
    public String workerId;
    public boolean hasReceivedRegisterWorker = false;
    public final Set<String> dynamicLoadedPlugins = new HashSet();
}
