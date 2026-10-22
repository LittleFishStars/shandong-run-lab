package com.kwad.sdk.crash.model.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class FastUnwindBacktrace implements Serializable {
    private static final long serialVersionUID = -7198748358207470664L;
    public int frame;
    public int isJavaUnwindInSig;
    public long javaUnwindCost;
    public int lock;
    public long nativeSigCost;
    public long nativeTidCost;
    public long nativeUnwindCost;
    public long nativeUnwindTotalCost;
    public long nativeUnwindWaitCost;
    public int threadId;
    public long threadInfoCost;
    public int threadState;
    public List<FastUnwindBackTraceElement> backtraces = new ArrayList();
    public String lockType = "";
    public String lockMsg = "";
    public String threadStateStr = "";
    public String threadDumpStr = "";
    public String exceptionMsg = "";
}
