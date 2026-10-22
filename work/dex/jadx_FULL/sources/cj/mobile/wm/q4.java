package cj.mobile.wm;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class q4 {
    public final InputStream dexa;
    public final ParcelFileDescriptor dexb;

    public q4(InputStream inputStream, ParcelFileDescriptor parcelFileDescriptor) {
        this.dexa = inputStream;
        this.dexb = parcelFileDescriptor;
    }

    public ParcelFileDescriptor dexa() {
        return this.dexb;
    }

    public InputStream dexb() {
        return this.dexa;
    }
}
