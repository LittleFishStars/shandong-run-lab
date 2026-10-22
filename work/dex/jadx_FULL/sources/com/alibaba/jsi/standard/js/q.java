package com.alibaba.jsi.standard.js;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class q extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f24585a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;

    public class a extends o {
        public a(com.alibaba.jsi.standard.b bVar) {
            super(bVar, Bridge.createNative(bVar, 14));
        }

        public boolean a(com.alibaba.jsi.standard.b bVar, w wVar) {
            t();
            return Bridge.cmd(bVar, 401, this.u, new Object[]{wVar}) != null;
        }

        public boolean b(com.alibaba.jsi.standard.b bVar, w wVar) {
            t();
            return Bridge.cmd(bVar, 402, this.u, new Object[]{wVar}) != null;
        }

        public q c(com.alibaba.jsi.standard.b bVar) {
            t();
            Object objCmd = Bridge.cmd(bVar, 400, this.u);
            if (objCmd == null || !(objCmd instanceof q)) {
                return null;
            }
            return (q) objCmd;
        }
    }

    public q(com.alibaba.jsi.standard.b bVar, long j) {
        super(bVar, j);
    }

    public q a(com.alibaba.jsi.standard.b bVar, j jVar) {
        t();
        Object objCmd = Bridge.cmd(bVar, 420, this.u, new Object[]{jVar});
        if (objCmd == null || !(objCmd instanceof q)) {
            return null;
        }
        return (q) objCmd;
    }

    public q b(com.alibaba.jsi.standard.b bVar, j jVar) {
        t();
        Object objCmd = Bridge.cmd(bVar, TypedValues.CycleType.TYPE_WAVE_SHAPE, this.u, new Object[]{jVar});
        if (objCmd == null || !(objCmd instanceof q)) {
            return null;
        }
        return (q) objCmd;
    }

    public boolean c(com.alibaba.jsi.standard.b bVar) {
        t();
        return Bridge.cmd(bVar, 422, this.u) != null;
    }

    public w d(com.alibaba.jsi.standard.b bVar) {
        t();
        Object objCmd = Bridge.cmd(bVar, 423, this.u);
        if (objCmd == null || !(objCmd instanceof w)) {
            return null;
        }
        return (w) objCmd;
    }

    public int e(com.alibaba.jsi.standard.b bVar) {
        t();
        Object objCmd = Bridge.cmd(bVar, TypedValues.CycleType.TYPE_WAVE_OFFSET, this.u);
        if (objCmd == null || !(objCmd instanceof Long)) {
            return 1;
        }
        return ((Long) objCmd).intValue();
    }

    @Override // com.alibaba.jsi.standard.js.w
    public boolean n() {
        return true;
    }
}
