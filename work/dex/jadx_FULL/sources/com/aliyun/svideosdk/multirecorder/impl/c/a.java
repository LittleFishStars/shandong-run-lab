package com.aliyun.svideosdk.multirecorder.impl.c;

import com.aliyun.svideosdk.common.AliyunRecordVideoSource;
import com.aliyun.svideosdk.common.struct.common.AliyunBorderParam;
import com.aliyun.svideosdk.common.struct.common.AliyunLayoutParam;
import com.aliyun.svideosdk.multirecorder.AliyunIBaseCapture;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class a implements e, AliyunIBaseCapture {
    private static int k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e.c f25788a;
    private AliyunRecordVideoSource c;
    private AliyunLayoutParam d;
    private AliyunBorderParam e;
    private int g;
    private int h;
    protected com.aliyun.svideosdk.multirecorder.impl.b i;
    private Integer f = 30;
    private boolean j = false;
    private int b = i();

    private int i() {
        int i = k + 1;
        k = i;
        return i;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public void a(int i) {
        this.f = Integer.valueOf(i);
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public final void a(int i, int i2) {
        this.g = i;
        this.h = i2;
        AliyunBorderParam aliyunBorderParam = this.e;
        if (aliyunBorderParam != null) {
            setBorderParam(aliyunBorderParam);
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.e
    public void a(AliyunRecordVideoSource aliyunRecordVideoSource, AliyunLayoutParam aliyunLayoutParam, com.aliyun.svideosdk.multirecorder.impl.b bVar) {
        this.c = aliyunRecordVideoSource;
        this.d = aliyunLayoutParam;
        this.i = bVar;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.e
    public final void a(e.c cVar) {
        this.f25788a = cVar;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.e
    public boolean a() {
        return this.j;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.e
    public final AliyunRecordVideoSource b() {
        return this.c;
    }

    public final void b(boolean z) {
        e.c cVar = this.f25788a;
        if (cVar != null) {
            cVar.a(this, z);
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public int c() {
        return this.g;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIBaseCapture
    public int captureId() {
        return n();
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public int d() {
        return this.h;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.e
    public boolean f() {
        return false;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.e
    public boolean h() {
        return false;
    }

    public final int[] j() {
        return new int[]{(int) (this.g * this.d.getWidthRatio()), (int) (this.h * this.d.getHeightRatio())};
    }

    public int k() {
        return this.f.intValue();
    }

    public final void l() {
        if (this.j) {
            return;
        }
        this.j = true;
        e.c cVar = this.f25788a;
        if (cVar != null) {
            cVar.b(this);
        }
    }

    public final void m() {
        e.c cVar = this.f25788a;
        if (cVar != null) {
            cVar.a(this);
        }
    }

    public final int n() {
        return this.b;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public void prepare() {
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIBaseCapture
    public void removeBorder() {
        this.e = null;
        e.c cVar = this.f25788a;
        if (cVar != null) {
            cVar.c(this);
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIBaseCapture
    public final void setBorderParam(AliyunBorderParam aliyunBorderParam) {
        int i;
        e.c cVar;
        if (aliyunBorderParam == null) {
            return;
        }
        this.e = aliyunBorderParam;
        int i2 = this.g;
        if (i2 <= 0 || (i = this.h) <= 0 || (cVar = this.f25788a) == null) {
            return;
        }
        cVar.a(this, aliyunBorderParam, i2, i);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIBaseCapture
    public int setProperty(String str, String str2) {
        return -1;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public int startPreview() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public int startRecording() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public void stopPreview() {
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIBaseCapture
    public void updateLayout(AliyunLayoutParam aliyunLayoutParam) {
        e.c cVar = this.f25788a;
        if (cVar != null) {
            cVar.a(this, aliyunLayoutParam);
            this.d = aliyunLayoutParam;
        }
    }
}
