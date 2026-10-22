package com.efs.sdk.base.core.b;

import android.os.Handler;
import android.os.Message;
import com.efs.sdk.base.core.cache.CacheManager;
import com.efs.sdk.base.core.cache.IFileFilter;
import com.efs.sdk.base.core.config.GlobalInfoManager;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.efs.sdk.base.core.util.concurrent.WorkThreadUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class e extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f29566a;
    public int b;
    public d c;
    public IFileFilter d;
    private d e;
    private d f;
    private List<String> g;
    private List<String> h;
    private AtomicInteger i;
    private AtomicInteger j;
    private IFileFilter k;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final e f29567a = new e(0);
    }

    public /* synthetic */ e(byte b) {
        this();
    }

    public static e a() {
        return a.f29567a;
    }

    public final void b(Object obj, int i) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 11;
        messageObtain.obj = obj;
        messageObtain.arg1 = i;
        sendMessage(messageObtain);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (h.a.f29572a.a()) {
            int i = message.what;
            if (i == 0) {
                String netStatus = GlobalInfoManager.getInstance().getNetStatus();
                if (NetworkUtil.NETWORK_CLASS_DENIED.equalsIgnoreCase(netStatus) || NetworkUtil.NETWORK_CLASS_DISCONNECTED.equalsIgnoreCase(netStatus)) {
                    Log.i("efs.send_log", "log cann't be send because net status is ".concat(String.valueOf(netStatus)));
                    sendEmptyMessageDelayed(0, ControllerCenter.getGlobalEnvStruct().getLogSendIntervalMills());
                    return;
                }
                List<LogDto> listEmptyList = Collections.emptyList();
                try {
                    listEmptyList = CacheManager.getInstance().getLogDto(this.f29566a, this.k);
                } catch (Throwable unused) {
                }
                for (LogDto logDto : listEmptyList) {
                    if ("wa".equals(logDto.getLogType()) || c.a().a(logDto.getLogType(), logDto.getBodySize())) {
                        d dVar = this.c;
                        if ("wa".equals(logDto.getLogType())) {
                            dVar = this.f;
                        }
                        String string = UUID.randomUUID().toString();
                        this.g.add(string);
                        if (WorkThreadUtil.submit(new f(logDto, dVar, string)) == null) {
                            a(string, -1);
                        }
                    }
                }
                if (this.g.size() <= 0) {
                    sendEmptyMessageDelayed(0, ControllerCenter.getGlobalEnvStruct().getLogSendIntervalMills());
                    return;
                }
                return;
            }
            if (i == 1) {
                Object obj = message.obj;
                if (obj != null) {
                    this.g.remove(obj.toString());
                }
                int iIncrementAndGet = message.arg1 != 0 ? this.i.incrementAndGet() : 0;
                if (this.g.isEmpty()) {
                    if (iIncrementAndGet < 5) {
                        sendEmptyMessage(0);
                        return;
                    }
                    this.i.set(0);
                    sendEmptyMessageDelayed(0, ControllerCenter.getGlobalEnvStruct().getLogSendDelayMills());
                    Log.i("efs.send_log", "request error cnt gt 5, next request delay 10s");
                    return;
                }
                return;
            }
            if (i != 10) {
                if (i != 11) {
                    return;
                }
                Object obj2 = message.obj;
                if (obj2 != null) {
                    this.h.remove(obj2.toString());
                }
                int iIncrementAndGet2 = message.arg1 != 0 ? this.j.incrementAndGet() : 0;
                if (this.h.isEmpty()) {
                    if (iIncrementAndGet2 == 0) {
                        Log.i("efs.send_log", "send secess.");
                        this.d.finish();
                    }
                    if (iIncrementAndGet2 < 5) {
                        sendEmptyMessage(10);
                        return;
                    }
                    this.j.set(0);
                    sendEmptyMessageDelayed(10, ControllerCenter.getGlobalEnvStruct().getLogSendDelayMills());
                    Log.i("efs.send_log", "request error cnt gt 5, next request delay 10s");
                    return;
                }
                return;
            }
            if (!this.d.hasTask()) {
                Log.i("efs.send_log", "-> none task. return.");
                return;
            }
            String netStatus2 = GlobalInfoManager.getInstance().getNetStatus();
            if (NetworkUtil.NETWORK_CLASS_DENIED.equalsIgnoreCase(netStatus2) || NetworkUtil.NETWORK_CLASS_DISCONNECTED.equalsIgnoreCase(netStatus2)) {
                Log.i("efs.send_log", "log cann't be send because net status is ".concat(String.valueOf(netStatus2)));
                Log.i("efs.send_log", "-> none net. over.");
                sendEmptyMessageDelayed(10, 300000L);
                return;
            }
            List<LogDto> listEmptyList2 = Collections.emptyList();
            try {
                listEmptyList2 = CacheManager.getInstance().getLogDtoCodeLog(this.b, this.d);
            } catch (Throwable unused2) {
            }
            for (LogDto logDto2 : listEmptyList2) {
                d dVar2 = this.e;
                String string2 = UUID.randomUUID().toString();
                this.h.add(string2);
                if (WorkThreadUtil.submit(new g(logDto2, dVar2, string2)) == null) {
                    b(string2, -1);
                }
            }
            if (this.h.size() <= 0) {
                if (CacheManager.getInstance().getCodeLogList() == null || CacheManager.getInstance().getCodeLogList().isEmpty()) {
                    Log.i("efs.send_log", "-> deal done and none log. return.");
                    sendEmptyMessageDelayed(10, 300000L);
                } else {
                    if (!this.d.hasTask()) {
                        Log.i("efs.send_log", "-> deal done and none task. return.");
                        return;
                    }
                    Log.i("efs.send_log", "-> deal done and has task. next interval.");
                    this.d.finish();
                    sendEmptyMessageDelayed(10, ControllerCenter.getGlobalEnvStruct().getLogSendIntervalMills());
                }
            }
        }
    }

    private e() {
        super(com.efs.sdk.base.core.util.concurrent.a.f29618a.getLooper());
        this.f29566a = 5;
        this.b = 1000;
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new AtomicInteger(0);
        this.j = new AtomicInteger(0);
        this.c = new com.efs.sdk.base.core.b.a();
        this.e = new b();
        this.f = new com.efs.sdk.base.core.d.e();
        this.k = new com.efs.sdk.base.core.cache.f();
    }

    public final void a(Object obj, int i) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = obj;
        messageObtain.arg1 = i;
        sendMessage(messageObtain);
    }
}
