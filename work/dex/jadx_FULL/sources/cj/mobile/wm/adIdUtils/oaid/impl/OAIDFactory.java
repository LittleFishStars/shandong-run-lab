package cj.mobile.wm.adIdUtils.oaid.impl;

import android.app.Application;
import android.content.Context;
import cj.mobile.wm.adIdUtils.oaid.IOAID;
import cj.mobile.wm.adIdUtils.oaid.OAIDLog;
import cj.mobile.wm.adIdUtils.oaid.OAIDRom;
import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class OAIDFactory {
    public static IOAID oaidImpl;

    public static IOAID create(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        IOAID ioaid = oaidImpl;
        if (ioaid != null) {
            return ioaid;
        }
        IOAID ioaidCreateManufacturerImpl = createManufacturerImpl(context);
        oaidImpl = ioaidCreateManufacturerImpl;
        if (ioaidCreateManufacturerImpl == null) {
            OAIDLog.printE(dexc.dexa("opu!gpvoe!pbjeJnqm"));
        } else if (!ioaidCreateManufacturerImpl.supported()) {
            OAIDLog.printE(dexc.dexa("pbjeJnqm!opu!tvqqpsufe!"));
        }
        return oaidImpl;
    }

    public static IOAID createManufacturerImpl(Context context) {
        if (OAIDRom.isLenovo() || OAIDRom.isMotolora()) {
            OAIDLog.print(dexc.dexa("MfopwpJnqm"));
            return new LenovoImpl(context);
        }
        if (OAIDRom.isMeizu()) {
            OAIDLog.print(dexc.dexa("Nfj{vJnqm"));
            return new MeizuImpl(context);
        }
        if (OAIDRom.isNubia()) {
            OAIDLog.print(dexc.dexa("OvcjbJnqm"));
            return new NubiaImpl(context);
        }
        if (OAIDRom.isXiaomi() || OAIDRom.isMiui() || OAIDRom.isBlackShark()) {
            OAIDLog.print(dexc.dexa("YjbpnjJnqm"));
            return new XiaomiImpl(context);
        }
        if (OAIDRom.isSamsung()) {
            OAIDLog.print(dexc.dexa("TbntvohJnqm"));
            return new SamsungImpl(context);
        }
        if (OAIDRom.isVivo()) {
            OAIDLog.print(dexc.dexa("WjwpJnqm"));
            return new VivoImpl(context);
        }
        if (OAIDRom.isHonor() && !OAIDRom.isEmui()) {
            HonorImpl honorImpl = new HonorImpl(context);
            if (honorImpl.supported()) {
                OAIDLog.print(dexc.dexa("IpopsJnqm"));
                return honorImpl;
            }
        }
        if (OAIDRom.isHuawei() || OAIDRom.isEmui()) {
            OAIDLog.print(dexc.dexa("IvbxfjJnqm"));
            return new HuaweiImpl(context);
        }
        if (OAIDRom.isOppo() || OAIDRom.isOnePlus()) {
            OppoImpl oppoImpl = new OppoImpl(context);
            if (oppoImpl.supported()) {
                OAIDLog.print(dexc.dexa("PqqpJnqm"));
                return oppoImpl;
            }
            OAIDLog.print(dexc.dexa("PqqpFyuJnqm"));
            return new OppoExtImpl(context);
        }
        if (OAIDRom.isCoolpad(context)) {
            OAIDLog.print(dexc.dexa("DppmqbeJnqm"));
            return new CoolpadImpl(context);
        }
        if (OAIDRom.isCoosea()) {
            OAIDLog.print(dexc.dexa("DpptfbJnqm"));
            return new CooseaImpl(context);
        }
        if (OAIDRom.isFreeme()) {
            OAIDLog.print(dexc.dexa("GsffnfJnqm"));
            return new FreemeImpl(context);
        }
        if (!OAIDRom.is360OS()) {
            return null;
        }
        OAIDLog.print(dexc.dexa("RjlvJnqm"));
        return new QikuImpl(context);
    }
}
