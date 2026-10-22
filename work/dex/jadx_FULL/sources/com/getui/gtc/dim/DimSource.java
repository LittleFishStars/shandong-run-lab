package com.getui.gtc.dim;

import android.util.Base64;
import com.getui.gtc.dim.e.b;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class DimSource {
    private static final HashMap<Caller, DimSource> SOURCE_MAP = new HashMap<>(4);

    public static synchronized DimSource of(Caller caller) {
        String str = null;
        if (caller != null) {
            if (caller != Caller.UNKNOWN) {
                HashMap<Caller, DimSource> map = SOURCE_MAP;
                if (map.containsKey(caller)) {
                    return map.get(caller);
                }
                if (caller == Caller.PUSH) {
                    str = "Y29tLmlnZXhpbi5wdXNo";
                } else if (caller == Caller.IDO) {
                    str = "Y29tLmdldHVpLmdz";
                } else if (caller == Caller.GY) {
                    str = "Y29tLmcuZ3lzZGs=";
                } else if (caller == Caller.WUS) {
                    str = "Y29tLnNkay5wbHVz";
                } else if (caller == Caller.ONEID) {
                    str = "Y29tLmdldHVpLm9uZWlk";
                }
                DimSource dimSourceOf = of(str);
                map.put(caller, dimSourceOf);
                return dimSourceOf;
            }
        }
        return null;
    }

    private static DimSource of(String str) {
        try {
            return (DimSource) Class.forName(new String(Base64.decode(str, 0)) + ".SdkSource").getDeclaredField("INSTANCE").get(null);
        } catch (Throwable th) {
            b.b(th);
            return null;
        }
    }

    public abstract <P, V> V get(P p, DimCallback<P, V> dimCallback);
}
