package com.kc.aw;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface _hf extends IInterface {

    @Keep
    public static final class _a implements _hf {
        public IBinder _a;

        public _a(IBinder iBinder) {
            this._a = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this._a;
        }
    }

    @Keep
    public static abstract class _b extends Binder implements _hf {
        public static final int _a = 0;
    }
}
