package cj.mobile.wm;

import android.net.Uri;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class l4<T> implements v4<File, T> {
    public final v4<Uri, T> dexa;

    public l4(v4<Uri, T> v4Var) {
        this.dexa = v4Var;
    }

    @Override // cj.mobile.wm.v4
    public y2<T> dexa(File file, int i, int i2) {
        return this.dexa.dexa(Uri.fromFile(file), i, i2);
    }
}
