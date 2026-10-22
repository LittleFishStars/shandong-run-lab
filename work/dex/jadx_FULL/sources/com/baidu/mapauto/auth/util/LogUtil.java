package com.baidu.mapauto.auth.util;

import android.util.Log;
import com.baidu.mapauto.auth.base.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class LogUtil implements e {
    private static volatile LogUtil sUtil;
    private Boolean openLog = Boolean.FALSE;
    private final List<WeakReference<e>> wrOutput = new ArrayList(10);

    private LogUtil() {
    }

    public static LogUtil getInstance() {
        if (sUtil == null) {
            synchronized (LogUtil.class) {
                if (sUtil == null) {
                    sUtil = new LogUtil();
                }
            }
        }
        return sUtil;
    }

    public void addOutput(e eVar) {
        this.wrOutput.add(new WeakReference<>(eVar));
    }

    @Override // com.baidu.mapauto.auth.base.e
    public void e(String str, String str2) {
        if (this.openLog.booleanValue()) {
            Log.e(str, str2);
            Iterator<WeakReference<e>> it = this.wrOutput.iterator();
            while (it.hasNext()) {
                e eVar = it.next().get();
                if (eVar == null) {
                    it.remove();
                } else {
                    eVar.e(str, str2);
                }
            }
        }
    }

    @Override // com.baidu.mapauto.auth.base.e
    public void i(String str, String str2) {
        if (this.openLog.booleanValue()) {
            Log.i(str, str2);
            Iterator<WeakReference<e>> it = this.wrOutput.iterator();
            while (it.hasNext()) {
                e eVar = it.next().get();
                if (eVar == null) {
                    it.remove();
                } else {
                    eVar.i(str, str2);
                }
            }
        }
    }

    public void openLog(Boolean bool) {
        this.openLog = Boolean.FALSE;
    }

    public void removeOutput(e eVar) {
        Iterator<WeakReference<e>> it = this.wrOutput.iterator();
        while (it.hasNext()) {
            e eVar2 = it.next().get();
            if (eVar2 == null || eVar2 == eVar) {
                it.remove();
            }
        }
    }
}
