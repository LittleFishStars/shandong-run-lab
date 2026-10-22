package cj.mobile.wm;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a3 extends c3<ParcelFileDescriptor> {
    public a3(Context context, Uri uri) {
        super(context, uri);
    }

    @Override // cj.mobile.wm.c3
    public void dexa(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    @Override // cj.mobile.wm.c3
    /* JADX INFO: renamed from: dexb, reason: merged with bridge method [inline-methods] */
    public ParcelFileDescriptor dexa(Uri uri, ContentResolver contentResolver) {
        return contentResolver.openAssetFileDescriptor(uri, "r").getParcelFileDescriptor();
    }
}
