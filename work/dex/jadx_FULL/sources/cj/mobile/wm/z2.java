package cj.mobile.wm;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class z2 extends w2<ParcelFileDescriptor> {
    public z2(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // cj.mobile.wm.w2
    public void dexa(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    @Override // cj.mobile.wm.w2
    /* JADX INFO: renamed from: dexb, reason: merged with bridge method [inline-methods] */
    public ParcelFileDescriptor dexa(AssetManager assetManager, String str) {
        return assetManager.openFd(str).getParcelFileDescriptor();
    }
}
