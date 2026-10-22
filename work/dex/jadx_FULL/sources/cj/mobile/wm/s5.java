package cj.mobile.wm;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class s5 implements u2<Bitmap> {
    public Bitmap.CompressFormat dexa;
    public int dexb;

    public s5() {
        this(null, 90);
    }

    public s5(Bitmap.CompressFormat compressFormat, int i) {
        this.dexa = compressFormat;
        this.dexb = i;
    }

    private Bitmap.CompressFormat dexa(Bitmap bitmap) {
        Bitmap.CompressFormat compressFormat = this.dexa;
        if (compressFormat != null) {
            return compressFormat;
        }
        return bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    @Override // cj.mobile.wm.q2
    public boolean dexa(n3<Bitmap> n3Var, OutputStream outputStream) {
        Bitmap bitmap = n3Var.get();
        long jDexa = a9.dexa();
        Bitmap.CompressFormat compressFormatDexa = dexa(bitmap);
        bitmap.compress(compressFormatDexa, this.dexb, outputStream);
        if (!Log.isLoggable(com.ipd.dsp.internal.q.e.d, 2)) {
            return true;
        }
        Log.v(com.ipd.dsp.internal.q.e.d, "Compressed with type: " + compressFormatDexa + " of size " + e9.dexa(bitmap) + " in " + a9.dexa(jDexa));
        return true;
    }

    @Override // cj.mobile.wm.q2
    public String getId() {
        return "BitmapEncoder.com.youku.insightvision.sdk.openadsdk.image.glide.load.resource.bitmap";
    }
}
