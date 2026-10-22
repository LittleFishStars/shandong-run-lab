package cj.mobile.wm;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d5 extends x4<ParcelFileDescriptor> implements v4 {

    public static class dexa implements w4<Integer, ParcelFileDescriptor> {
        @Override // cj.mobile.wm.w4
        public void a() {
        }

        @Override // cj.mobile.wm.w4
        public v4<Integer, ParcelFileDescriptor> dexa(Context context, m4 m4Var) {
            return new d5(context, m4Var.dexa(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public d5(Context context, v4<Uri, ParcelFileDescriptor> v4Var) {
        super(context, v4Var);
    }
}
