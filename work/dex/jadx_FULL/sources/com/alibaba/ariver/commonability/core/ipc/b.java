package com.alibaba.ariver.commonability.core.ipc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f23946a = new b();
    public final AtomicBoolean b = new AtomicBoolean();
    public final Map<Long, RemoteCallback> c = new ConcurrentHashMap();
    public final AtomicLong d = new AtomicLong();

    private b() {
    }
}
