package com.hailiang.advlib.open;

import android.content.Context;
import android.text.TextUtils;
import com.hailiang.advlib.open.oaid.hla.d;
import com.hailiang.advlib.open.oaid.hla.e;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f32577a = "";

    @Keep
    public class a implements com.hailiang.advlib.open.oaid.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AliCheatParams.IListener f32578a;

        public a(AliCheatParams.IListener iListener) {
            this.f32578a = iListener;
        }

        @Override // com.hailiang.advlib.open.oaid.a
        public void a(Exception exc) {
            try {
                AliCheatParams.IListener iListener = this.f32578a;
                if (iListener != null) {
                    iListener.onError(exc);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // com.hailiang.advlib.open.oaid.a
        public void a(String str) {
            String unused = c.f32577a = str;
            try {
                AliCheatParams.IListener iListener = this.f32578a;
                if (iListener != null) {
                    iListener.onSuccess(str);
                }
            } catch (Throwable unused2) {
            }
        }
    }

    public static void a(Context context, AliCheatParams.IListener iListener) {
        if (!TextUtils.isEmpty(f32577a)) {
            if (iListener != null) {
                iListener.onSuccess(f32577a);
                return;
            }
            return;
        }
        com.hailiang.advlib.open.oaid.b bVarA = e.a(context);
        if (!(bVarA instanceof d)) {
            bVarA.a(new a(iListener));
        } else if (iListener != null) {
            iListener.onError(new Exception("not support"));
        }
    }
}
