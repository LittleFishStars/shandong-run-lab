package cj.mobile.wm;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e5 extends z4<ParcelFileDescriptor> implements v4 {

    public static class dexa implements w4<String, ParcelFileDescriptor> {
        @Override // cj.mobile.wm.w4
        public void a() {
        }

        @Override // cj.mobile.wm.w4
        public v4<String, ParcelFileDescriptor> dexa(Context context, m4 m4Var) {
            return new e5(m4Var.dexa(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public e5(v4<Uri, ParcelFileDescriptor> v4Var) {
        super(v4Var);
    }
}
