package cj.mobile.wm;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c6 implements t2<q4, Bitmap> {
    public final t2<InputStream, Bitmap> dexa;
    public final t2<ParcelFileDescriptor, Bitmap> dexb;

    public c6(t2<InputStream, Bitmap> t2Var, t2<ParcelFileDescriptor, Bitmap> t2Var2) {
        this.dexa = t2Var;
        this.dexb = t2Var2;
    }

    @Override // cj.mobile.wm.t2
    public n3<Bitmap> dexa(q4 q4Var, int i, int i2) {
        n3<Bitmap> n3VarDexa;
        ParcelFileDescriptor parcelFileDescriptorDexa;
        InputStream inputStreamDexb = q4Var.dexb();
        if (inputStreamDexb != null) {
            try {
                n3VarDexa = this.dexa.dexa(inputStreamDexb, i, i2);
            } catch (IOException e) {
                if (Log.isLoggable("ImageVideoDecoder", 2)) {
                    Log.v("ImageVideoDecoder", "Failed to load image from stream, trying FileDescriptor", e);
                }
                n3VarDexa = null;
            }
        } else {
            n3VarDexa = null;
        }
        return (n3VarDexa != null || (parcelFileDescriptorDexa = q4Var.dexa()) == null) ? n3VarDexa : this.dexb.dexa(parcelFileDescriptorDexa, i, i2);
    }

    @Override // cj.mobile.wm.t2
    public String getId() {
        return "ImageVideoBitmapDecoder.com.youku.insightvision.sdk.openadsdk.image.glide.load.resource.bitmap";
    }
}
