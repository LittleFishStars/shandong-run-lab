package com.efs.sdk.base.core.cache;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ali.auth.third.login.LoginConstants;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.FileUtil;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.ProcessUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class CacheManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f29578a;
    private boolean b;
    private com.efs.sdk.base.core.cache.a c;
    private a d;
    private List<File> e;

    public static class a implements Comparator<File> {
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            long jLastModified = file.lastModified() - file2.lastModified();
            if (jLastModified > 0) {
                return 1;
            }
            return jLastModified == 0 ? 0 : -1;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final CacheManager f29579a = new CacheManager(0);
    }

    public /* synthetic */ CacheManager(byte b2) {
        this();
    }

    private void a() {
        String[] list;
        File fileD = com.efs.sdk.base.core.util.a.d(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (!fileD.exists() || !fileD.isDirectory() || (list = fileD.list()) == null || list.length <= 0) {
            return;
        }
        for (String str : list) {
            if (!ProcessUtil.isProcessExist(ControllerCenter.getGlobalEnvStruct().mAppContext, str)) {
                File file = new File(fileD, str);
                List<File> listListFiles = FileUtil.listFiles(file);
                if (!listListFiles.isEmpty()) {
                    for (File file2 : listListFiles) {
                        if (a(file2.getName())) {
                            a(file2);
                        } else {
                            String name = file2.getName();
                            LogDto logDtoCreateLogDtoByName = (TextUtils.isEmpty(name) || !name.startsWith(Constants.LOG_TYPE_CODELOGPERF)) ? FileUtil.createLogDtoByName(name) : FileUtil.createCodeLogDtoByName(name);
                            if (logDtoCreateLogDtoByName == null) {
                                onChangeDtoError(file2);
                            } else {
                                d dVarA = this.c.a(logDtoCreateLogDtoByName.getLogProtocol());
                                if (dVarA == null) {
                                    onChangeDtoError(file2);
                                } else {
                                    dVarA.a(file2);
                                }
                            }
                        }
                    }
                }
                FileUtil.delete(file);
            }
        }
    }

    private void b() {
        String[] list;
        File fileE = com.efs.sdk.base.core.util.a.e(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (!fileE.exists() || !fileE.isDirectory() || (list = fileE.list()) == null || list.length <= 0) {
            return;
        }
        for (String str : list) {
            if (!ProcessUtil.isProcessExist(ControllerCenter.getGlobalEnvStruct().mAppContext, str)) {
                File file = new File(fileE, str);
                List<File> listListFiles = FileUtil.listFiles(file);
                if (!listListFiles.isEmpty()) {
                    for (File file2 : listListFiles) {
                        if (a(file2.getName())) {
                            a(file2);
                        } else {
                            String name = file2.getName();
                            LogDto logDtoCreateLogDtoByName = (TextUtils.isEmpty(name) || !name.startsWith(Constants.LOG_TYPE_CODELOGPERF)) ? FileUtil.createLogDtoByName(name) : FileUtil.createCodeLogDtoByName(name);
                            if (logDtoCreateLogDtoByName == null) {
                                onChangeDtoError(file2);
                            } else {
                                d dVarA = this.c.a(logDtoCreateLogDtoByName.getLogProtocol());
                                if (dVarA == null) {
                                    onChangeDtoError(file2);
                                } else {
                                    dVarA.a(file2);
                                }
                            }
                        }
                    }
                }
                FileUtil.delete(file);
            }
        }
    }

    public static CacheManager getInstance() {
        return b.f29579a;
    }

    @Nullable
    public LogDto changeLogDto(File file) {
        try {
            if (!file.exists()) {
                return null;
            }
            if (a(file.getName())) {
                a(file);
                return null;
            }
            String name = file.getName();
            LogDto logDtoCreateLogDtoByName = (TextUtils.isEmpty(name) || !name.startsWith(Constants.LOG_TYPE_CODELOGPERF)) ? FileUtil.createLogDtoByName(name) : FileUtil.createCodeLogDtoByName(name);
            if (logDtoCreateLogDtoByName == null) {
                onChangeDtoError(file);
                return null;
            }
            d dVarA = this.c.a(logDtoCreateLogDtoByName.getLogProtocol());
            if (dVarA == null) {
                onChangeDtoError(file);
                return null;
            }
            if (dVarA.a(file, logDtoCreateLogDtoByName)) {
                return logDtoCreateLogDtoByName;
            }
            onChangeDtoError(file);
            return null;
        } catch (Throwable th) {
            Log.w("efs.cache", th);
            onChangeDtoError(file);
            return null;
        }
    }

    public void flushImmediately(byte b2, String str) {
        d dVarA = this.c.a(b2);
        if (dVarA == null) {
            return;
        }
        dVarA.a(str);
    }

    public List<File> getCodeLogList() {
        return this.e;
    }

    public List<File> getFileList(int i, @Nullable IFileFilter iFileFilter) {
        a();
        File fileH = com.efs.sdk.base.core.util.a.h(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (!fileH.exists()) {
            return Collections.emptyList();
        }
        List<File> listListFiles = FileUtil.listFiles(fileH);
        if (this.b) {
            com.efs.sdk.base.core.d.f fVar = com.efs.sdk.base.core.d.f.a.f29604a;
            int size = listListFiles.size();
            if (fVar.b != null && ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                com.efs.sdk.base.core.d.b bVar = new com.efs.sdk.base.core.d.b("efs_core", "log_lag", fVar.f29603a.c);
                bVar.put("cnt", Integer.valueOf(size));
                fVar.b.send(bVar);
            }
            this.b = false;
        }
        Collections.sort(listListFiles, this.d);
        ArrayList arrayList = new ArrayList(i);
        for (int size2 = listListFiles.size() - 1; size2 >= 0 && arrayList.size() < i; size2--) {
            File file = listListFiles.get(size2);
            if (file.exists() && (iFileFilter == null || !iFileFilter.filter(file))) {
                arrayList.add(file);
            }
        }
        return arrayList;
    }

    public List<File> getFileListCodeLog(int i, @Nullable IFileFilter iFileFilter) {
        b();
        List<File> list = this.e;
        if (list == null || list.isEmpty()) {
            File fileI = com.efs.sdk.base.core.util.a.i(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
            if (!fileI.exists()) {
                return Collections.emptyList();
            }
            List<File> listListFiles = FileUtil.listFiles(fileI);
            this.e = listListFiles;
            Collections.sort(listListFiles, this.d);
        }
        ArrayList arrayList = new ArrayList(i);
        for (int size = this.e.size() - 1; size >= 0 && arrayList.size() < i; size--) {
            File file = this.e.get(size);
            if (file.exists()) {
                if (iFileFilter == null || !iFileFilter.filter(file)) {
                    Log.i("efs.cache", "[-->>] add file is " + file.getName());
                    arrayList.add(file);
                } else {
                    Log.i("efs.cache", "[--xx] filter file is " + file.getName());
                }
            }
        }
        return arrayList;
    }

    public List<LogDto> getLogDto(int i, IFileFilter iFileFilter) {
        a();
        List<File> fileList = getFileList(i, iFileFilter);
        ArrayList arrayList = new ArrayList(i);
        for (File file : fileList) {
            LogDto logDtoChangeLogDto = changeLogDto(file);
            if (logDtoChangeLogDto == null) {
                Log.w("efs.cache", "file upload error, name is " + file.getName());
            } else {
                arrayList.add(logDtoChangeLogDto);
            }
        }
        return arrayList;
    }

    public List<LogDto> getLogDtoCodeLog(int i, IFileFilter iFileFilter) {
        b();
        List<File> fileListCodeLog = getFileListCodeLog(i, iFileFilter);
        ArrayList arrayList = new ArrayList(i);
        for (File file : fileListCodeLog) {
            LogDto logDtoChangeLogDto = changeLogDto(file);
            if (logDtoChangeLogDto == null) {
                Log.w("efs.cache", "file upload error, name is " + file.getName());
            } else {
                arrayList.add(logDtoChangeLogDto);
            }
        }
        return arrayList;
    }

    public void onChangeDtoError(@NonNull File file) {
        if (!file.getName().startsWith("wa_")) {
            com.efs.sdk.base.core.d.f.a.f29604a.c.c.incrementAndGet();
        }
        FileUtil.delete(file);
    }

    public void put(LogDto logDto) {
        d dVarA;
        if (!"wa".equals(logDto.getLogType()) && !Constants.LOG_TYPE_CODELOGPERF.equals(logDto.getLogType()) && !com.efs.sdk.base.core.cache.b.a().f29581a) {
            if (!this.f29578a) {
                com.efs.sdk.base.core.d.f fVar = com.efs.sdk.base.core.d.f.a.f29604a;
                int i = com.efs.sdk.base.core.config.remote.b.a().d.mConfigVersion;
                if (fVar.b != null || ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                    fVar.b.send(fVar.a("disk_limit", i));
                }
            }
            this.f29578a = true;
            return;
        }
        if (!Constants.LOG_TYPE_CODELOGPERF.equals(logDto.getLogType()) || com.efs.sdk.base.core.cache.b.a().b) {
            if ((logDto.getLogBodyType() == 0 && (logDto.getData() == null || logDto.getData().length == 0)) || (dVarA = this.c.a(logDto.getLogProtocol())) == null) {
                return;
            }
            dVarA.a(logDto);
        }
    }

    private CacheManager() {
        this.f29578a = false;
        this.b = true;
        this.c = new com.efs.sdk.base.core.cache.a();
        this.d = new a();
    }

    public static boolean a(String str) {
        long j;
        try {
            if (str.startsWith(Constants.LOG_TYPE_CODELOGPERF)) {
                j = Long.parseLong(str.substring(str.lastIndexOf(LoginConstants.UNDER_LINE) + 1));
            } else {
                j = Long.parseLong(str.substring(str.lastIndexOf(LoginConstants.UNDER_LINE) + 1));
            }
            com.efs.sdk.base.core.a.a.a();
            return Math.abs(com.efs.sdk.base.core.a.a.b() - j) >= 604800000;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static void a(File file) {
        StringBuilder sb = new StringBuilder("file is expire: ");
        sb.append(file.getName());
        sb.append(", now is ");
        com.efs.sdk.base.core.a.a.a();
        sb.append(com.efs.sdk.base.core.a.a.b());
        Log.i("efs.cache", sb.toString());
        if (!file.getName().startsWith("wa_")) {
            com.efs.sdk.base.core.d.f.a.f29604a.c.d();
        }
        FileUtil.delete(file);
    }
}
