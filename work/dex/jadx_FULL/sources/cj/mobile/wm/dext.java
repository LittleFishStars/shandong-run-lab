package cj.mobile.wm;

import android.content.Context;
import java.io.File;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dext implements dexr {
    @Override // cj.mobile.wm.dexr
    public boolean dexa(Context context, String str) {
        String absolutePath;
        if (context == null) {
            return false;
        }
        try {
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir != null) {
                File parentFile = externalCacheDir.getParentFile();
                Objects.requireNonNull(parentFile);
                File parentFile2 = parentFile.getParentFile();
                Objects.requireNonNull(parentFile2);
                absolutePath = parentFile2.getAbsolutePath();
            } else {
                absolutePath = null;
            }
            return new File(absolutePath + File.separator + str).exists();
        } catch (Exception unused) {
            return false;
        }
    }
}
