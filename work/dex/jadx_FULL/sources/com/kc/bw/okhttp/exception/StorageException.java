package com.kc.bw.okhttp.exception;

import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class StorageException extends Exception {
    public static final long serialVersionUID = 178946465;

    public StorageException() {
    }

    public StorageException(String str) {
        super(str);
    }

    public StorageException(String str, Throwable th) {
        super(str, th);
    }

    public StorageException(Throwable th) {
        super(th);
    }

    public static StorageException NOT_AVAILABLE() {
        return new StorageException(dexg.dexa("TEDbse!jto(u!bwbjmbcmf-!qmfbtf!difdl!TE!dbse!boe!qfsnjttjpo;!XSJUF`FYUFSOBM`TUPSBHF-!boe!zpv!nvtu!qbz!buufoujpo!up!Boespje7/1!SvoUjnf!Qfsnjttjpot\""));
    }
}
