package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.i;
import java.net.InetAddress;
import java.text.ParseException;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@GwtIncompatible
@ElementTypesAreNonnullByDefault
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f32222a;

    public a(String str) {
        this.f32222a = str;
    }

    public static a a(String str) throws ParseException {
        try {
            return b(str);
        } catch (IllegalArgumentException e) {
            String strValueOf = String.valueOf(str);
            ParseException parseException = new ParseException(strValueOf.length() != 0 ? "Invalid host specifier: ".concat(strValueOf) : new String("Invalid host specifier: "), 0);
            parseException.initCause(e);
            throw parseException;
        }
    }

    public static a b(String str) {
        InetAddress inetAddressG;
        HostAndPort hostAndPortFromString = HostAndPort.fromString(str);
        i.d(!hostAndPortFromString.hasPort());
        String host = hostAndPortFromString.getHost();
        try {
            inetAddressG = c.g(host);
        } catch (IllegalArgumentException unused) {
            inetAddressG = null;
        }
        if (inetAddressG != null) {
            return new a(c.O(inetAddressG));
        }
        d dVarD = d.d(host);
        if (dVarD.f()) {
            return new a(dVarD.toString());
        }
        String strValueOf = String.valueOf(host);
        throw new IllegalArgumentException(strValueOf.length() != 0 ? "Domain name does not have a recognized public suffix: ".concat(strValueOf) : new String("Domain name does not have a recognized public suffix: "));
    }

    public static boolean c(String str) {
        try {
            b(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            return this.f32222a.equals(((a) obj).f32222a);
        }
        return false;
    }

    public int hashCode() {
        return this.f32222a.hashCode();
    }

    public String toString() {
        return this.f32222a;
    }
}
