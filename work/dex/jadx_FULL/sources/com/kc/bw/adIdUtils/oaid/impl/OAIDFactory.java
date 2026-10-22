package com.kc.bw.adIdUtils.oaid.impl;

import android.app.Application;
import android.content.Context;
import com.kc.bw.adIdUtils.oaid.IOAID;
import com.kc.bw.adIdUtils.oaid.OAIDLog;
import com.kc.bw.adIdUtils.oaid.OAIDRom;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class OAIDFactory {
    public static IOAID ioaid;

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
        if (ioaidCreateManufacturerImpl != null && ioaidCreateManufacturerImpl.supported()) {
            OAIDLog.print(dexg.dexa("Nbovgbduvsfs!joufsgbdf!ibt!cffo!gpvoe;!") + ioaid.getClass().getName());
            return ioaid;
        }
        IOAID ioaidCreateMsaImpl = createMsaImpl(context);
        ioaid = ioaidCreateMsaImpl;
        if (ioaidCreateMsaImpl == null || !ioaidCreateMsaImpl.supported()) {
            return new DefaultImpl();
        }
        OAIDLog.print(dexg.dexa("Ntb!joufsgbdf!ibt!cffo!gpvoe;!") + ioaid.getClass().getName());
        return ioaid;
    }

    public static IOAID createManufacturerImpl(Context context) {
        if (OAIDRom.isLenovo() || OAIDRom.isMotolora()) {
            OAIDLog.print(dexg.dexa("��蕩邕焴痺碉ꈈ꜇PBJE"));
            return new LenovoImpl(context);
        }
        if (OAIDRom.isMeizu()) {
            OAIDLog.print(dexg.dexa("��蕩ꮆ瘐痺碉ꈈ꜇PBJE"));
            return new MeizuImpl(context);
        }
        if (OAIDRom.isNubia()) {
            OAIDLog.print(dexg.dexa("��蕩拫簕廛痺碉ꈈ꜇PBJE"));
            return new NubiaImpl(context);
        }
        if (OAIDRom.isXiaomi() || OAIDRom.isMiui() || OAIDRom.isBlackShark()) {
            OAIDLog.print(dexg.dexa("��蕩汐貴痺碉ꈈ꜇PBJE"));
            return new XiaomiImpl(context);
        }
        if (OAIDRom.isSamsung()) {
            OAIDLog.print(dexg.dexa("��蕩幊癠痺碉ꈈ꜇PBJE"));
            return new SamsungImpl(context);
        }
        if (OAIDRom.isVivo()) {
            OAIDLog.print(dexg.dexa("��蕩WJWP痺碉ꈈ꜇PBJE"));
            return new VivoImpl(context);
        }
        if (OAIDRom.isASUS()) {
            OAIDLog.print(dexg.dexa("��蕩掏袖痺碉ꈈ꜇PBJE"));
            return new AsusImpl(context);
        }
        if (OAIDRom.isHonor() && !OAIDRom.isEmui()) {
            HonorImpl honorImpl = new HonorImpl(context);
            if (honorImpl.supported()) {
                OAIDLog.print(dexg.dexa("��蕩鎤遁痺碉ꈈ꜇PBJE"));
                return honorImpl;
            }
        }
        if (OAIDRom.isHuawei() || OAIDRom.isEmui()) {
            OAIDLog.print(dexg.dexa("��蕩掏幻痺碉ꈈ꜇PBJE"));
            return new HuaweiImpl(context);
        }
        if (OAIDRom.isOppo() || OAIDRom.isOnePlus()) {
            OppoImpl oppoImpl = new OppoImpl(context);
            if (oppoImpl.supported()) {
                OAIDLog.print(dexg.dexa("��蕩PQQP痺碉ꈈ꜇PBJE"));
                return oppoImpl;
            }
            OAIDLog.print(dexg.dexa("��蕩PQQP犪沖痱痺碉ꈈ꜇PBJE"));
            return new OppoExtImpl(context);
        }
        if (OAIDRom.isCoolpad(context)) {
            OAIDLog.print(dexg.dexa("��蕩ꆸ絿痺碉ꈈ꜇PBJE"));
            return new CoolpadImpl(context);
        }
        if (OAIDRom.isCoosea()) {
            OAIDLog.print(dexg.dexa("��蕩Dpptfb痺碉ꈈ꜇PBJE"));
            return new CooseaImpl(context);
        }
        if (OAIDRom.isFreeme()) {
            OAIDLog.print(dexg.dexa("��蕩Gsffnf痺碉ꈈ꜇PBJE"));
            return new FreemeImpl(context);
        }
        if (!OAIDRom.is360OS()) {
            return null;
        }
        OAIDLog.print(dexg.dexa("��蕩471痺碉ꈈ꜇PBJE"));
        return new QikuImpl(context);
    }

    public static IOAID createMsaImpl(Context context) {
        MsaImpl msaImpl = new MsaImpl(context);
        if (!msaImpl.supported()) {
            return null;
        }
        OAIDLog.print(dexg.dexa("Npcjmf!Tfdvsjuz!Bmmjbodf!ibt!cffo!gpvoe;!") + MsaImpl.class.getName());
        return msaImpl;
    }

    public static IOAID createUniversalImpl(Context context) {
        StringBuilder sb;
        Class cls;
        IOAID msaImpl = new MsaImpl(context);
        if (msaImpl.supported()) {
            sb = new StringBuilder();
            sb.append(dexg.dexa("Npcjmf!Tfdvsjuz!Bmmjbodf!ibt!cffo!gpvoe;!"));
            cls = MsaImpl.class;
        } else {
            msaImpl = new GmsImpl(context);
            if (!msaImpl.supported()) {
                DefaultImpl defaultImpl = new DefaultImpl();
                OAIDLog.print(dexg.dexa("PBJE0BBJE!xbt!opu!tvqqpsufe;!") + DefaultImpl.class.getName());
                return defaultImpl;
            }
            sb = new StringBuilder();
            sb.append(dexg.dexa("Hpphmf!Qmbz!Tfswjdf!ibt!cffo!gpvoe;!"));
            cls = GmsImpl.class;
        }
        sb.append(cls.getName());
        OAIDLog.print(sb.toString());
        return msaImpl;
    }
}
