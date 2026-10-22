package cj.mobile.wm;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c5 extends l4<ParcelFileDescriptor> implements v4 {

    public static class dexa implements w4<File, ParcelFileDescriptor> {
        @Override // cj.mobile.wm.w4
        public void a() {
        }

        @Override // cj.mobile.wm.w4
        public v4<File, ParcelFileDescriptor> dexa(Context context, m4 m4Var) {
            return new c5(m4Var.dexa(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public c5(v4<Uri, ParcelFileDescriptor> v4Var) {
        super(v4Var);
    }
}
