package com.kc.aw;

import com.kc.aw.lib.utils.TextUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _i6 implements Serializable {
    public String _a;
    public String _b;
    public String _c;
    public String _d;
    public List<_j9> _e;
    public _k8 _f;
    public String _g;
    public String _h;
    public String _i;

    public final boolean _a() {
        _k8 _k8Var = this._f;
        return _k8Var != null && TextUtil.isNotEmpty(_k8Var._a);
    }
}
