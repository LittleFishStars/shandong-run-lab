package com.zj.adlib;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class s53 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f44613a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f19516a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long[] f19517a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final EventMessage[] f19518a;
    public final String b;

    public s53(String str, String str2, long j, long[] jArr, EventMessage[] eventMessageArr) {
        this.f19516a = str;
        this.b = str2;
        this.f44613a = j;
        this.f19517a = jArr;
        this.f19518a = eventMessageArr;
    }

    public String a() {
        return this.f19516a + WVNativeCallbackUtil.SEPERATER + this.b;
    }
}
