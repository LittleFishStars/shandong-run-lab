package com.kc.aw;

import android.content.Context;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _g9 implements _ek {
    public Context _a;

    @Keep
    public final class _a implements InvocationHandler {
        public final _a3 _a;

        public _a(_a3 _a3Var) {
            this._a = _a3Var;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            String str;
            StringBuilder sb;
            String str2;
            try {
                if ("OnSupport".equals(method.getName())) {
                    Object objInvoke = objArr[1].getClass().getMethod("getOAID", new Class[0]).invoke(objArr[1], new Object[0]);
                    str = objInvoke != null ? (String) objInvoke : "";
                    _a3 _a3Var = this._a;
                    if (_a3Var != null) {
                        _a3Var._a(str);
                    }
                    sb = new StringBuilder();
                    str2 = "initOaid msa oaid 1: ";
                } else {
                    if (!"onSupport".equals(method.getName())) {
                        return null;
                    }
                    Object objInvoke2 = objArr[0].getClass().getMethod("getOAID", new Class[0]).invoke(objArr[0], new Object[0]);
                    str = objInvoke2 != null ? (String) objInvoke2 : "";
                    _a3 _a3Var2 = this._a;
                    if (_a3Var2 != null) {
                        _a3Var2._a(str);
                    }
                    sb = new StringBuilder();
                    str2 = "initOaid msa oaid 2: ";
                }
                sb.append(str2);
                sb.append(str);
                Logger.d("OaidHelperTag", sb.toString());
                return null;
            } catch (Exception e) {
                StringBuilder sb_a = _jf._a("initOaid msa oaid getOAID() error： ");
                sb_a.append(e.getMessage());
                Logger.d("OaidHelperTag", sb_a.toString());
                return null;
            }
        }
    }

    public _g9(Context context) {
        this._a = context;
    }

    @Override // com.kc.aw._ek
    public final void _a(_a3 _a3Var) {
        try {
            MdidSdkHelper.class.getMethod("InitSdk", Context.class, Boolean.TYPE, IIdentifierListener.class).invoke(null, this._a, Boolean.TRUE, Proxy.newProxyInstance(IIdentifierListener.class.getClassLoader(), new Class[]{IIdentifierListener.class}, new _a(_a3Var)));
        } catch (Exception e) {
            StringBuilder sb_a = _jf._a("initOaid msa oaid class error： ");
            sb_a.append(e.getMessage());
            Logger.d("OaidHelperTag", sb_a.toString());
        }
    }
}
