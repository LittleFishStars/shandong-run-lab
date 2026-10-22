package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class njc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f43539a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f18425a;

    public njc(Object obj, int i) {
        this.f18425a = obj;
        this.f43539a = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof njc)) {
            return false;
        }
        njc njcVar = (njc) obj;
        return this.f18425a == njcVar.f18425a && this.f43539a == njcVar.f43539a;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f18425a) * 65535) + this.f43539a;
    }
}
