package com.kc.dw.ad.view.scaleImage.decoder;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class f implements FileFilter {
    public f(SkiaPooledImageRegionDecoder skiaPooledImageRegionDecoder) {
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return Pattern.matches("cpu[0-9]+", file.getName());
    }
}
