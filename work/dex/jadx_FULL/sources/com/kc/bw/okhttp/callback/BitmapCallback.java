package com.kc.bw.okhttp.callback;

import android.graphics.Bitmap;
import android.util.Log;
import com.kc.bw.dexg;
import com.kc.bw.okhttp.convert.BitmapConvertV2;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class BitmapCallback extends AbsCallback<Bitmap> {
    public static final int BITMAP_TYPE_LARGE = 0;
    public static final int BITMAP_TYPE_SMALL = 1;
    public int bitmapType;

    public BitmapCallback(int i) {
        this.bitmapType = i;
    }

    @Override // com.kc.bw.okhttp.convert.Converter
    public Bitmap convertResponse(Response response) {
        ResponseBody responseBodyBody = response.body();
        try {
            Bitmap bitmapConvertResponse = (this.bitmapType == 1 ? BitmapConvertV2.getDefaultSmall() : BitmapConvertV2.getDefaultLarge()).convertResponse(response);
            if (bitmapConvertResponse == null) {
                Log.w(dexg.dexa("CjunbqDbmmcbdl"), dexg.dexa("efdpef!sfuvso!ovmm-!vsm>") + response.request().url());
            }
            if (responseBodyBody != null) {
                responseBodyBody.close();
            }
            return bitmapConvertResponse;
        } catch (Throwable th) {
            if (responseBodyBody != null) {
                try {
                    responseBodyBody.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
