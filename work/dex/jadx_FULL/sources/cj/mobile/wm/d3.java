package cj.mobile.wm;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d3 extends w2<InputStream> {
    public d3(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // cj.mobile.wm.w2
    public void dexa(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // cj.mobile.wm.w2
    /* JADX INFO: renamed from: dexb, reason: merged with bridge method [inline-methods] */
    public InputStream dexa(AssetManager assetManager, String str) {
        return assetManager.open(str);
    }
}
