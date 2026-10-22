package com.fl.saas.config.oaid.impl;

import android.app.Application;
import android.content.Context;
import com.fl.saas.config.oaid.IOAID;
import com.fl.saas.config.oaid.OAIDLog;
import com.fl.saas.config.oaid.OAIDRom;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class OAIDFactory {
    private static IOAID ioaid;

    private OAIDFactory() {
    }

    public static IOAID create(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        IOAID ioaid2 = ioaid;
        if (ioaid2 != null) {
            return ioaid2;
        }
        IOAID ioaidCreateManufacturerImpl = createManufacturerImpl(context);
        ioaid = ioaidCreateManufacturerImpl;
        if (ioaidCreateManufacturerImpl == null || !ioaidCreateManufacturerImpl.supported()) {
            IOAID ioaidCreateUniversalImpl = createUniversalImpl(context);
            ioaid = ioaidCreateUniversalImpl;
            return ioaidCreateUniversalImpl;
        }
        OAIDLog.print("Manufacturer interface has been found: " + ioaid.getClass().getName());
        return ioaid;
    }

    private static IOAID createManufacturerImpl(Context context) {
        if (OAIDRom.isLenovo() || OAIDRom.isMotolora()) {
            return new LenovoImpl(context);
        }
        if (OAIDRom.isMeizu()) {
            return new MeizuImpl(context);
        }
        if (OAIDRom.isNubia()) {
            return new NubiaImpl(context);
        }
        if (OAIDRom.isXiaomi() || OAIDRom.isMiui() || OAIDRom.isBlackShark()) {
            return new XiaomiImpl(context);
        }
        if (OAIDRom.isSamsung()) {
            return new SamsungImpl(context);
        }
        if (OAIDRom.isVivo()) {
            return new VivoImpl(context);
        }
        if (OAIDRom.isASUS()) {
            return new AsusImpl(context);
        }
        if (OAIDRom.isHuawei() || OAIDRom.isEmui()) {
            return new HuaweiImpl(context);
        }
        if (OAIDRom.isOppo() || OAIDRom.isOnePlus()) {
            OppoImpl oppoImpl = new OppoImpl(context);
            return oppoImpl.supported() ? oppoImpl : new OppoExtImpl(context);
        }
        if (OAIDRom.isCoolpad(context)) {
            return new CoolpadImpl(context);
        }
        if (OAIDRom.isCoosea()) {
            return new CooseaImpl(context);
        }
        if (OAIDRom.isFreeme()) {
            return new FreemeImpl(context);
        }
        return null;
    }

    private static IOAID createUniversalImpl(Context context) {
        StringBuilder sb;
        Class cls;
        IOAID msaImpl = new MsaImpl(context);
        if (msaImpl.supported()) {
            sb = new StringBuilder();
            sb.append("Mobile Security Alliance has been found: ");
            cls = MsaImpl.class;
        } else {
            msaImpl = new GmsImpl(context);
            if (!msaImpl.supported()) {
                DefaultImpl defaultImpl = new DefaultImpl();
                OAIDLog.print("OAID/AAID was not supported: " + DefaultImpl.class.getName());
                return defaultImpl;
            }
            sb = new StringBuilder();
            sb.append("Google Play Service has been found: ");
            cls = GmsImpl.class;
        }
        sb.append(cls.getName());
        OAIDLog.print(sb.toString());
        return msaImpl;
    }
}
