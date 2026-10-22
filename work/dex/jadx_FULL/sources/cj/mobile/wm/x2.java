package cj.mobile.wm;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class x2 implements y2<InputStream> {
    public final byte[] dexa;
    public final String dexb;

    public x2(byte[] bArr, String str) {
        this.dexa = bArr;
        this.dexb = str;
    }

    @Override // cj.mobile.wm.y2
    public void a() {
    }

    @Override // cj.mobile.wm.y2
    public void b() {
    }

    @Override // cj.mobile.wm.y2
    /* JADX INFO: renamed from: dexb, reason: merged with bridge method [inline-methods] */
    public InputStream dexa(com.wangmai.insightvision.openadsdk.image.b.i iVar) {
        return new ByteArrayInputStream(this.dexa);
    }

    @Override // cj.mobile.wm.y2
    public String getId() {
        return this.dexb;
    }
}
