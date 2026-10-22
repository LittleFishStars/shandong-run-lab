package cj.mobile.wm;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h6 implements r5<ParcelFileDescriptor> {
    public static final dexa dexc = new dexa();
    public dexa dexa;
    public int dexb;

    public static class dexa {
        public MediaMetadataRetriever dexa() {
            return new MediaMetadataRetriever();
        }
    }

    public h6() {
        this(dexc, -1);
    }

    public h6(dexa dexaVar, int i) {
        this.dexa = dexaVar;
        this.dexb = i;
    }

    public Bitmap dexa(ParcelFileDescriptor parcelFileDescriptor, r3 r3Var, int i, int i2, com.wangmai.insightvision.openadsdk.image.b.n.a aVar) throws IOException {
        MediaMetadataRetriever mediaMetadataRetrieverDexa = this.dexa.dexa();
        mediaMetadataRetrieverDexa.setDataSource(parcelFileDescriptor.getFileDescriptor());
        int i3 = this.dexb;
        Bitmap frameAtTime = i3 >= 0 ? mediaMetadataRetrieverDexa.getFrameAtTime(i3) : mediaMetadataRetrieverDexa.getFrameAtTime();
        mediaMetadataRetrieverDexa.release();
        parcelFileDescriptor.close();
        return frameAtTime;
    }
}
