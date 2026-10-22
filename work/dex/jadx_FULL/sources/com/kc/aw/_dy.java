package com.kc.aw;

import android.graphics.Movie;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.ByteArrayInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _dy implements _9 {
    public static final _dy _a = new _dy();

    @Override // com.kc.aw._9
    public final Object _a(_c4 _c4Var) {
        try {
            if (_c4Var._b()._c() != 6) {
                return null;
            }
            return Movie.decodeStream(new ByteArrayInputStream(_c4Var._a()));
        } catch (Exception unused) {
            return null;
        }
    }
}
