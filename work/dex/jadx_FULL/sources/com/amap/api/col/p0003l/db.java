package com.amap.api.col.p0003l;

import com.amap.api.maps.MapsInitializer;
import com.zj.adlib.gia;
import com.zj.adlib.i9b;
import com.zj.adlib.zwa;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class db extends hs {
    protected boolean isPostFlag = true;

    @Override // com.amap.api.col.p0003l.hs
    public Map<String, String> getParams() {
        return null;
    }

    public byte[] makeHttpRequest() throws ff {
        i9b i9bVarMakeHttpRequestNeedHeader = makeHttpRequestNeedHeader();
        if (i9bVarMakeHttpRequestNeedHeader != null) {
            return i9bVarMakeHttpRequestNeedHeader.f17171a;
        }
        return null;
    }

    public i9b makeHttpRequestNeedHeader() throws ff {
        if (gia.f41914a != null && fo.a(gia.f41914a, zwa.t()).f26036a != fo.c.SuccessCode) {
            return null;
        }
        setHttpProtocol(MapsInitializer.getProtocol() == 1 ? hs.c.HTTP : hs.c.HTTPS);
        w.l();
        return this.isPostFlag ? hl.e(this) : w.n(this);
    }

    public byte[] makeHttpRequestWithInterrupted() throws ff {
        setDegradeAbility(hs.a.INTERRUPT_IO);
        return makeHttpRequest();
    }
}
