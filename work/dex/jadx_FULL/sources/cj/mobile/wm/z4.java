package cj.mobile.wm;

import android.net.Uri;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class z4<T> implements v4<String, T> {
    public final v4<Uri, T> dexa;

    public z4(v4<Uri, T> v4Var) {
        this.dexa = v4Var;
    }

    public static Uri dexa(String str) {
        return Uri.fromFile(new File(str));
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0010  */
    @Override // cj.mobile.wm.v4
    public y2<T> dexa(String str, int i, int i2) {
        Uri uriDexa;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(WVNativeCallbackUtil.SEPERATER)) {
            uriDexa = dexa(str);
        } else {
            Uri uri = Uri.parse(str);
            if (uri.getScheme() == null) {
                uriDexa = dexa(str);
            } else {
                uriDexa = uri;
            }
        }
        return this.dexa.dexa(uriDexa, i, i2);
    }
}
