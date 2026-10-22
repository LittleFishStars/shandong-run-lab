package com.kwad.components.offline.api.core.api;

import android.content.Context;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface IZipper {
    boolean unZip(Context context, InputStream inputStream, String str);

    boolean zip(File file, File file2);

    void zipFile(File file);
}
