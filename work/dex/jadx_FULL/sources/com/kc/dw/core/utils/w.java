package com.kc.dw.core.utils;

import android.graphics.Bitmap;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface w {
    void a(int i, IOException iOException);

    void a(byte[] bArr, Bitmap bitmap, Bitmap bitmap2, boolean z) throws IOException;

    void b(int i, IOException iOException);

    void onStartDownload();
}
