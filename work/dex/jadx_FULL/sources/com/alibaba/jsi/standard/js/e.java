package com.alibaba.jsi.standard.js;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f24580a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 6;
    public static final int h = 7;
    public static final int i = 8;
    public static final int j = 9;
    public static final int k = 10;
    public static final int l = 11;
    public static final int m = 12;
    private int v;
    private int w;
    private int x;
    private int y;
    private ByteBuffer z;

    public e(com.alibaba.jsi.standard.b bVar, int i2, int i3) {
        super(bVar, Bridge.createNative(bVar, 11, i2, i3));
        this.v = -1;
        this.w = -1;
        this.x = -1;
        this.y = -1;
        this.z = null;
    }

    public int a(com.alibaba.jsi.standard.b bVar) {
        t();
        if (this.v == -1) {
            Object objCmd = Bridge.cmd(bVar, 500, this.u);
            if (objCmd == null || !(objCmd instanceof Long)) {
                this.v = 0;
            } else {
                this.v = ((Long) objCmd).intValue();
            }
        }
        return this.v;
    }

    public boolean b_(com.alibaba.jsi.standard.b bVar) {
        t();
        if (this.w == -1) {
            if (Bridge.cmd(bVar, 501, this.u) != null) {
                this.w = 1;
            } else {
                this.w = 0;
            }
        }
        return this.w == 1;
    }

    public int c(com.alibaba.jsi.standard.b bVar) {
        t();
        if (this.x == -1) {
            Object objCmd = Bridge.cmd(bVar, 502, this.u);
            if (objCmd == null || !(objCmd instanceof Long)) {
                this.x = 0;
            } else {
                this.x = ((Long) objCmd).intValue();
            }
        }
        return this.x;
    }

    @Override // com.alibaba.jsi.standard.js.w
    public boolean c() {
        return true;
    }

    public int d(com.alibaba.jsi.standard.b bVar) {
        t();
        if (this.y == -1) {
            Object objCmd = Bridge.cmd(bVar, 503, this.u);
            if (objCmd == null || !(objCmd instanceof Long)) {
                this.y = 0;
            } else {
                this.y = ((Long) objCmd).intValue();
            }
        }
        return this.y;
    }

    public int e(com.alibaba.jsi.standard.b bVar) {
        t();
        Object objCmd = Bridge.cmd(bVar, 504, this.u);
        if (objCmd == null || !(objCmd instanceof Long)) {
            return 0;
        }
        return ((Long) objCmd).intValue();
    }

    public ByteBuffer f(com.alibaba.jsi.standard.b bVar) {
        Object objCmd;
        t();
        if (this.z == null && (objCmd = Bridge.cmd(bVar, 505, this.u)) != null && (objCmd instanceof ByteBuffer)) {
            this.z = (ByteBuffer) objCmd;
        }
        return this.z;
    }

    public boolean g(com.alibaba.jsi.standard.b bVar) {
        t();
        Object objCmd = Bridge.cmd(bVar, 506, this.u);
        this.z = null;
        return objCmd != null;
    }

    public e(com.alibaba.jsi.standard.b bVar, int i2, ByteBuffer byteBuffer) {
        super(bVar, 0L);
        this.v = -1;
        this.w = -1;
        this.x = -1;
        this.y = -1;
        this.z = null;
        if (byteBuffer != null) {
            if (byteBuffer.isDirect()) {
                this.z = byteBuffer;
                this.u = Bridge.createNative(bVar, 11, i2, byteBuffer.limit(), new Object[]{byteBuffer});
                com.alibaba.jsi.standard.d.a(bVar, this);
                return;
            }
            throw new IllegalArgumentException("buffer must be a direct ByteBuffer!");
        }
        throw new NullPointerException("buffer can not be null!");
    }

    public e(com.alibaba.jsi.standard.b bVar, long j2) {
        super(bVar, j2);
        this.v = -1;
        this.w = -1;
        this.x = -1;
        this.y = -1;
        this.z = null;
    }
}
