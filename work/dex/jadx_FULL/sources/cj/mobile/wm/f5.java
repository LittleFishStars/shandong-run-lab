package cj.mobile.wm;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f5 extends a5<ParcelFileDescriptor> implements v4 {

    public static class dexa implements w4<Uri, ParcelFileDescriptor> {
        @Override // cj.mobile.wm.w4
        public void a() {
        }

        @Override // cj.mobile.wm.w4
        public v4<Uri, ParcelFileDescriptor> dexa(Context context, m4 m4Var) {
            return new f5(context, m4Var.dexa(n4.class, ParcelFileDescriptor.class));
        }
    }

    public f5(Context context, v4<n4, ParcelFileDescriptor> v4Var) {
        super(context, v4Var);
    }

    @Override // cj.mobile.wm.a5
    public y2<ParcelFileDescriptor> dexa(Context context, Uri uri) {
        return new a3(context, uri);
    }

    @Override // cj.mobile.wm.a5
    public y2<ParcelFileDescriptor> dexa(Context context, String str) {
        return new z2(de.dexb(context), str);
    }
}
