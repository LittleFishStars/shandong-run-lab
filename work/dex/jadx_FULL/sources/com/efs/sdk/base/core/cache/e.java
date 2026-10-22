package com.efs.sdk.base.core.cache;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.FileUtil;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.secure.EncodeUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class e extends Handler implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, a> f29583a;
    private com.efs.sdk.base.core.c.a.d b;
    private com.efs.sdk.base.core.c.a.c c;

    public static class a extends FileOutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f29584a;
        File b;

        public a(@NonNull File file) {
            super(file);
            this.b = file;
            this.f29584a = System.currentTimeMillis();
        }
    }

    public e() {
        super(com.efs.sdk.base.core.util.concurrent.a.f29618a.getLooper());
        this.f29583a = new ConcurrentHashMap<>();
        this.b = new com.efs.sdk.base.core.c.a.d();
        this.c = new com.efs.sdk.base.core.c.a.c();
    }

    private static long b(String str) {
        Map<String, String> mapC = com.efs.sdk.base.core.config.remote.b.a().c();
        String strConcat = "record_accumulation_time_".concat(String.valueOf(str));
        if (!mapC.containsKey(strConcat)) {
            return 60000L;
        }
        String str2 = mapC.get(strConcat);
        if (TextUtils.isEmpty(str2)) {
            return 60000L;
        }
        try {
            return Math.max(Long.parseLong(str2) * 1000, 1000L);
        } catch (Throwable th) {
            Log.e("efs.cache", "get cache interval error", th);
            return 60000L;
        }
    }

    private void c(String str) {
        a aVar;
        if (this.f29583a.containsKey(str) && (aVar = this.f29583a.get(str)) != null) {
            try {
                aVar.flush();
                FileUtil.safeClose(aVar);
                Log.i("RecordLogCacheProcessor", "save file, type is ".concat(String.valueOf(str)));
                a(aVar.b);
                this.f29583a.remove(str);
                if ("wa".equalsIgnoreCase(str)) {
                    return;
                }
                com.efs.sdk.base.core.d.f.a.f29604a.c.c();
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                } finally {
                    this.f29583a.remove(str);
                    if (!"wa".equalsIgnoreCase(str)) {
                        com.efs.sdk.base.core.d.f.a.f29604a.c.c();
                    }
                }
            }
        }
    }

    @Override // com.efs.sdk.base.core.cache.d
    public final void a(LogDto logDto) {
        Message messageObtain = Message.obtain();
        messageObtain.obj = logDto;
        messageObtain.what = 0;
        sendMessage(messageObtain);
    }

    @Override // android.os.Handler
    public final void handleMessage(@NonNull Message message) {
        int i = message.what;
        if (i != 0) {
            if (i != 1) {
                return;
            }
            Object obj = message.obj;
            if (obj instanceof String) {
                c(obj.toString());
                return;
            }
            return;
        }
        LogDto logDto = (LogDto) message.obj;
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                a aVarB = b(logDto);
                if (aVarB == null) {
                    Log.w("efs.cache", "writer is null for type " + logDto.getLogType());
                    return;
                }
                if (aVarB.getChannel().position() + ((long) logDto.getData().length) > 819200) {
                    c(logDto.getLogType());
                    aVarB = b(logDto);
                    if (aVarB == null) {
                        Log.w("efs.cache", "writer is null for type " + logDto.getLogType());
                        return;
                    }
                }
                aVarB.write(EncodeUtil.base64Encode(logDto.getData()));
                aVarB.write("\n".getBytes());
                return;
            } catch (Throwable th) {
                Log.e("efs.cache", "cache file error", th);
            }
        }
    }

    @Override // com.efs.sdk.base.core.cache.d
    public final boolean a(File file, LogDto logDto) {
        if (!logDto.isCp()) {
            a(file);
            return false;
        }
        if (!file.exists()) {
            return false;
        }
        logDto.setFile(file);
        logDto.setSendImediately(true);
        logDto.setLogBodyType(1);
        return true;
    }

    private a b(LogDto logDto) {
        File file;
        a aVar;
        Throwable th;
        if (this.f29583a.containsKey(logDto.getLogType())) {
            return this.f29583a.get(logDto.getLogType());
        }
        if (Constants.LOG_TYPE_CODELOGPERF.equals(logDto.getLogType())) {
            file = new File(com.efs.sdk.base.core.util.a.g(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid()), FileUtil.getCodelogFileName(logDto));
        } else {
            file = new File(com.efs.sdk.base.core.util.a.f(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid()), FileUtil.getFileName(logDto));
        }
        try {
            aVar = new a(file);
            try {
                a aVarPutIfAbsent = this.f29583a.putIfAbsent(logDto.getLogType(), aVar);
                if (aVarPutIfAbsent != null) {
                    FileUtil.safeClose(aVar);
                    FileUtil.delete(file);
                    return aVarPutIfAbsent;
                }
                if (Constants.LOG_TYPE_CODELOGPERF.equals(logDto.getLogType())) {
                    Message messageObtain = Message.obtain();
                    messageObtain.obj = logDto.getLogType();
                    messageObtain.what = 1;
                    sendMessage(messageObtain);
                } else {
                    Message messageObtain2 = Message.obtain();
                    messageObtain2.obj = logDto.getLogType();
                    messageObtain2.what = 1;
                    sendMessageDelayed(messageObtain2, b(logDto.getLogType()));
                }
                if (!"wa".equalsIgnoreCase(logDto.getLogType())) {
                    com.efs.sdk.base.core.d.f.a.f29604a.c.b();
                }
                return aVar;
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
            }
        } catch (Throwable th3) {
            aVar = null;
            th = th3;
        }
    }

    @Override // com.efs.sdk.base.core.cache.d
    public final void a(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.obj = str;
        messageObtain.what = 1;
        sendMessage(messageObtain);
    }

    @Override // com.efs.sdk.base.core.cache.d
    public final void a(File file) {
        LogDto logDtoCreateLogDtoByName;
        String fileName;
        File fileH;
        String name = file.getName();
        if (!TextUtils.isEmpty(name) && name.startsWith(Constants.LOG_TYPE_CODELOGPERF)) {
            logDtoCreateLogDtoByName = FileUtil.createCodeLogDtoByName(name);
        } else {
            logDtoCreateLogDtoByName = FileUtil.createLogDtoByName(name);
        }
        if (logDtoCreateLogDtoByName == null) {
            CacheManager.getInstance().onChangeDtoError(file);
            return;
        }
        if (a(logDtoCreateLogDtoByName, file) && logDtoCreateLogDtoByName.getData() != null && logDtoCreateLogDtoByName.getData().length > 0) {
            if (Constants.LOG_TYPE_CODELOGPERF.equals(logDtoCreateLogDtoByName.getLogType())) {
                fileName = FileUtil.getCodelogFileName(logDtoCreateLogDtoByName);
                fileH = com.efs.sdk.base.core.util.a.i(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
            } else {
                fileName = FileUtil.getFileName(logDtoCreateLogDtoByName);
                fileH = com.efs.sdk.base.core.util.a.h(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
            }
            File file2 = new File(fileH, fileName);
            Log.i("RecordLogCacheProcessor", "upload file, name is ".concat(String.valueOf(name)));
            FileUtil.write(file2, logDtoCreateLogDtoByName.getData());
            FileUtil.delete(file);
            return;
        }
        CacheManager.getInstance().onChangeDtoError(file);
    }

    private boolean a(LogDto logDto, File file) {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader(file);
            try {
                bufferedReader = new BufferedReader(fileReader2);
                try {
                    for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                        String strBase64DecodeToStr = EncodeUtil.base64DecodeToStr(line.getBytes());
                        if (!TextUtils.isEmpty(strBase64DecodeToStr)) {
                            sb.append(strBase64DecodeToStr);
                            sb.append("\n");
                        }
                    }
                    logDto.setData(sb.toString().getBytes());
                    logDto.setSendImediately(true);
                    this.c.a(logDto);
                    logDto.setFile(file);
                    FileUtil.safeClose(bufferedReader);
                    FileUtil.safeClose(fileReader2);
                    return true;
                } catch (Throwable th) {
                    th = th;
                    fileReader = fileReader2;
                    try {
                        Log.e("efs.cache", "local decode error", th);
                        return false;
                    } finally {
                        FileUtil.safeClose(bufferedReader);
                        FileUtil.safeClose(fileReader);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
    }
}
