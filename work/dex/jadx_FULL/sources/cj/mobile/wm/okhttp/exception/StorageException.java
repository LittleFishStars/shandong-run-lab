package cj.mobile.wm.okhttp.exception;

import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
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
        return new StorageException(dexc.dexa("TEDbse!jto(u!bwbjmbcmf-!qmfbtf!difdl!TE!dbse!boe!qfsnjttjpo;!XSJUF`FYUFSOBM`TUPSBHF-!boe!zpv!nvtu!qbz!buufoujpo!up!Boespje7/1!SvoUjnf!Qfsnjttjpot\""));
    }
}
