package com.kc.dw.core.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.Log;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static RenderScript f39358a;

    static {
        Collections.synchronizedList(new ArrayList());
    }

    public static Bitmap a(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        try {
            Bitmap.Config config = bitmap.getConfig();
            Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
            if (config != config2) {
                bitmap = bitmap.copy(config2, true);
            }
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 4, bitmap.getHeight() / 4, false);
            Log.i("ImageUtil", "scale size:" + bitmapCreateScaledBitmap.getWidth() + "*" + bitmapCreateScaledBitmap.getHeight());
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(f39358a, bitmapCreateScaledBitmap);
            Allocation allocationCreateTyped = Allocation.createTyped(f39358a, allocationCreateFromBitmap.getType());
            RenderScript renderScript = f39358a;
            ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
            scriptIntrinsicBlurCreate.setRadius(i);
            scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
            allocationCreateTyped.copyTo(bitmapCreateScaledBitmap);
            f39358a.destroy();
            return bitmapCreateScaledBitmap;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Bitmap a(byte[] bArr) {
        try {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean b(byte[] bArr) {
        return bArr.length >= 4 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }
}
