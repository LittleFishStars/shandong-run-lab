package com.ipd.dsp.open;

import android.content.Context;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.ipd.dsp.Dsp;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class IPDFileProvider extends FileProvider {
    public static Uri getUri(File file) {
        return getUri(Dsp.getContext(), file);
    }

    public static Uri getUri(Context context, File file) {
        if (context == null) {
            return null;
        }
        return FileProvider.getUriForFile(context, context.getPackageName() + ".IPDFileProvider", file);
    }
}
