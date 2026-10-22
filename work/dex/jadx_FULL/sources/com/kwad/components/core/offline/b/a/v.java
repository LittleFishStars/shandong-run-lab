package com.kwad.components.core.offline.b.a;

import android.content.Context;
import com.kwad.components.offline.api.core.api.IZipper;
import com.kwad.sdk.utils.cg;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
final class v implements IZipper {
    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final boolean unZip(Context context, InputStream inputStream, String str) {
        return cg.unZip(context, inputStream, str);
    }

    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final boolean zip(File file, File file2) {
        return cg.zip(file, file2);
    }

    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final void zipFile(File file) {
        cg.zipFile(file);
    }
}
