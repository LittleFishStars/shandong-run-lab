package com.kc.aw;

import com.kc.aw.lib.model.AppInfo;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _hz {
    public static _gc _a(int i, boolean z, _h _hVar) {
        if (_hVar == null) {
            return null;
        }
        int i2 = 0;
        if (i == 8 && z) {
            String str_k = _hVar._k();
            String str_e = _hVar._e();
            String str_j = _hVar._j();
            List<_j9> list_h = _hVar._h();
            _i6 _i6Var = _hVar._z;
            String str = _i6Var != null ? _i6Var._g : "";
            int i_n = _hVar._n();
            int i_g = _hVar._g();
            int i3 = _hVar._a;
            AppInfo appInfo = _hVar._c;
            boolean z_s = _hVar._s();
            String str_m = _hVar._m();
            _k8 _k8Var_l = _hVar._l();
            String str2 = _k8Var_l != null ? _k8Var_l._a : "";
            _i6 _i6Var2 = _hVar._z;
            if (_i6Var2 != null && _i6Var2._a() && _i6Var2._a()) {
                i2 = _i6Var2._f._e;
            }
            long j = i2;
            _i6 _i6Var3 = _hVar._z;
            String str3 = _i6Var3 != null ? _i6Var3._d : "";
            String str_i = _hVar._i();
            boolean z2 = _hVar._J;
            int i4 = _hVar._m;
            _i6 _i6Var4 = _hVar._z;
            return new _gc(str_k, str_e, str_j, list_h, str, i_n, i_g, i3, appInfo, z_s, str_m, str2, j, str3, str_i, z2, i4, _i6Var4 != null ? _i6Var4._i : "", _hVar._A, _hVar._i);
        }
        _k _kVar = _hVar._q;
        if (!(_kVar != null && _kVar._v)) {
            return null;
        }
        String str_k2 = _hVar._k();
        String str_e2 = _hVar._e();
        String str_j2 = _hVar._j();
        List<_j9> list_h2 = _hVar._h();
        _i6 _i6Var5 = _hVar._z;
        String str4 = _i6Var5 != null ? _i6Var5._g : "";
        int i_n2 = _hVar._n();
        int i_g2 = _hVar._g();
        int i5 = _hVar._a;
        AppInfo appInfo2 = _hVar._c;
        boolean z_s2 = _hVar._s();
        String str_m2 = _hVar._m();
        _k8 _k8Var_l2 = _hVar._l();
        String str5 = _k8Var_l2 != null ? _k8Var_l2._a : "";
        _i6 _i6Var6 = _hVar._z;
        if (_i6Var6 != null && _i6Var6._a() && _i6Var6._a()) {
            i2 = _i6Var6._f._e;
        }
        long j2 = i2;
        _i6 _i6Var7 = _hVar._z;
        String str6 = _i6Var7 != null ? _i6Var7._d : "";
        String str_i2 = _hVar._i();
        boolean z3 = _hVar._J;
        int i6 = _hVar._m;
        _i6 _i6Var8 = _hVar._z;
        return new _gc(str_k2, str_e2, str_j2, list_h2, str4, i_n2, i_g2, i5, appInfo2, z_s2, str_m2, str5, j2, str6, str_i2, z3, i6, _i6Var8 != null ? _i6Var8._i : "", _hVar._A, _hVar._i);
    }
}
