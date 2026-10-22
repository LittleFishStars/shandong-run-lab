package android.taobao.windvane.base;

import android.content.Context;
import android.graphics.Bitmap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface i {

    public interface a {
        void saveFail();

        void saveSuccess();
    }

    int a(String str);

    Bitmap a(Bitmap bitmap, int i);

    Bitmap a(Bitmap bitmap, long j, long j2);

    Bitmap a(String str, int i);

    void a(Context context, String str, a aVar);

    boolean a();

    byte[] a(Bitmap bitmap, Bitmap.CompressFormat compressFormat);

    Bitmap b(Bitmap bitmap, int i);
}
