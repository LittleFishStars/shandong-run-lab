package cj.mobile.wm;

import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class n6 implements a8<InputStream, File> {
    public static final dexb dexc = new dexb();
    public final t2<File, File> dexa = new k6();
    public final q2<InputStream> dexb = new y4();

    public static class dexb implements t2<InputStream, File> {
        public dexb() {
        }

        @Override // cj.mobile.wm.t2
        public n3<File> dexa(InputStream inputStream, int i, int i2) {
            throw new Error("You cannot decode a File from an InputStream by default, try either #diskCacheStratey(DiskCacheStrategy.SOURCE) to avoid this call or #decoder(ResourceDecoder) to replace this Decoder");
        }

        @Override // cj.mobile.wm.t2
        public String getId() {
            return "";
        }
    }

    @Override // cj.mobile.wm.a8
    public t2<File, File> a() {
        return this.dexa;
    }

    @Override // cj.mobile.wm.a8
    public u2<File> c() {
        return o5.dexa();
    }

    @Override // cj.mobile.wm.a8
    public q2<InputStream> d() {
        return this.dexb;
    }

    @Override // cj.mobile.wm.a8
    public t2<InputStream, File> f() {
        return dexc;
    }
}
