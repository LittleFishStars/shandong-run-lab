package com.efs.sdk.base.core.cache;

import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.FileUtil;
import com.efs.sdk.base.core.util.Log;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c implements d {
    @Override // com.efs.sdk.base.core.cache.d
    public final void a(LogDto logDto) {
        if (logDto.getData() == null) {
            return;
        }
        String fileName = FileUtil.getFileName(logDto);
        File file = new File(com.efs.sdk.base.core.util.a.h(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid()), fileName);
        FileUtil.write(file, logDto.getData());
        try {
            if (ControllerCenter.getGlobalEnvStruct().isEnablePaBackup() && "patrace".equals(logDto.getLogType())) {
                File file2 = new File(ControllerCenter.getGlobalEnvStruct().mAppContext.getApplicationInfo().dataDir + File.separator + "apm_backup_files", fileName);
                FileUtil.copy(file, file2);
                if (ControllerCenter.getGlobalEnvStruct().isDebug()) {
                    Log.d("efs.base", "backup patrace file to " + file2.getAbsolutePath());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        com.efs.sdk.base.core.d.f.a.f29604a.c.b();
        com.efs.sdk.base.core.d.f.a.f29604a.c.c();
    }

    @Override // com.efs.sdk.base.core.cache.d
    public final void a(String str) {
    }

    @Override // com.efs.sdk.base.core.cache.d
    public final void a(File file) throws Throwable {
        FileUtil.move(file, com.efs.sdk.base.core.util.a.h(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid()));
    }

    @Override // com.efs.sdk.base.core.cache.d
    public final boolean a(File file, LogDto logDto) {
        if (!file.exists()) {
            return false;
        }
        logDto.setFile(file);
        logDto.setSendImediately(true);
        logDto.setLogBodyType(1);
        return true;
    }
}
