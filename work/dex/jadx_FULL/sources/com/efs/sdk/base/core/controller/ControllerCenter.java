package com.efs.sdk.base.core.controller;

import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.location.LocationConst;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.b.e;
import com.efs.sdk.base.core.b.h;
import com.efs.sdk.base.core.c.d;
import com.efs.sdk.base.core.config.GlobalEnvStruct;
import com.efs.sdk.base.core.config.GlobalInfoManager;
import com.efs.sdk.base.core.config.remote.b;
import com.efs.sdk.base.core.controller.a.a;
import com.efs.sdk.base.core.d.c;
import com.efs.sdk.base.core.d.f;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.concurrent.WorkThreadUtil;
import com.efs.sdk.base.http.HttpResponse;
import com.efs.sdk.base.protocol.ILogProtocol;
import com.huachenjie.shandong_school.splash.SplashActivity;
import com.igexin.sdk.PushConsts;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ControllerCenter implements Handler.Callback {
    private static GlobalEnvStruct h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f29598a = 0;
    private final int b = 0;
    private final int c = 1;
    private final int d = 2;
    private final int e = 3;
    private volatile boolean f = false;
    private a g;
    private boolean i;
    private Handler j;

    public ControllerCenter(EfsReporter.Builder builder) {
        this.i = false;
        GlobalEnvStruct globalEnvStruct = builder.getGlobalEnvStruct();
        h = globalEnvStruct;
        this.i = globalEnvStruct.isOpenCodeLog();
        Handler handler = new Handler(com.efs.sdk.base.core.util.concurrent.a.f29618a.getLooper(), this);
        this.j = handler;
        handler.sendEmptyMessage(0);
    }

    private void a() {
        if (this.g == null) {
            this.g = new a();
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            h.mAppContext.registerReceiver(this.g, intentFilter);
        } catch (Throwable th) {
            Log.w("efs.base", "register network change receiver error", th);
            int i = this.f29598a + 1;
            this.f29598a = i;
            if (i < 3) {
                this.j.sendEmptyMessageDelayed(3, SplashActivity.f36053a);
            }
        }
    }

    private void b(final ILogProtocol iLogProtocol) {
        if (iLogProtocol == null) {
            return;
        }
        WorkThreadUtil.submit(new Runnable() { // from class: com.efs.sdk.base.core.controller.ControllerCenter.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    iLogProtocol.insertGlobal(GlobalInfoManager.getInstance().getGlobalInfo());
                    if (!"wa".equalsIgnoreCase(iLogProtocol.getLogType())) {
                        ControllerCenter.a(iLogProtocol);
                    }
                    if (ControllerCenter.getGlobalEnvStruct().isEnableSendLog()) {
                        final LogDto logDtoBuildLogDto = LogDto.buildLogDto(iLogProtocol);
                        final d dVar = d.a.f29577a;
                        WorkThreadUtil.submit(new Runnable() { // from class: com.efs.sdk.base.core.c.d.1

                            /* JADX INFO: renamed from: a */
                            final /* synthetic */ LogDto f29576a;

                            public AnonymousClass1() {
                                logDto = logDtoBuildLogDto;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                d.this.f29575a.a(logDto);
                            }
                        });
                    }
                } catch (Throwable th) {
                    Log.e("efs.base", "log send error", th);
                }
            }
        });
    }

    @NonNull
    public static GlobalEnvStruct getGlobalEnvStruct() {
        return h;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        int i = message.what;
        if (i == 0) {
            GlobalInfoManager.getInstance().initGlobalInfo();
            h unused = h.a.f29572a;
            b.a().b();
            a();
            f fVar = f.a.f29604a;
            boolean zIsIntl = h.isIntl();
            c cVar = fVar.f29603a;
            if (zIsIntl) {
                cVar.f29602a = "https://errnewlogos.umeng.com/api/crashsdk/logcollect";
                cVar.b = "4ea4e41a3993";
            } else {
                cVar.f29602a = "https://errnewlog.umeng.com/api/crashsdk/logcollect";
                cVar.b = "28ef1713347d";
            }
            fVar.b = this;
            fVar.c.f29600a = this;
            fVar.d.f29600a = this;
            this.f = true;
            e.a().sendEmptyMessageDelayed(0, h.getLogSendDelayMills());
            if (this.i) {
                e.a().sendEmptyMessageDelayed(10, h.getLogSendDelayMills());
            }
            f fVar2 = f.a.f29604a;
            if (fVar2.b != null && getGlobalEnvStruct().isEnableWaStat()) {
                fVar2.b.send(new com.efs.sdk.base.core.d.b("efs_core", "pvuv", fVar2.f29603a.c));
            }
        } else if (i == 1) {
            Object obj = message.obj;
            if (obj != null && (obj instanceof ILogProtocol)) {
                b((ILogProtocol) obj);
            }
        } else if (i == 3) {
            a();
        }
        return true;
    }

    public void send(ILogProtocol iLogProtocol) {
        if (this.f) {
            b(iLogProtocol);
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = iLogProtocol;
        this.j.sendMessage(messageObtain);
    }

    @Nullable
    public HttpResponse sendSyncImmediately(String str, int i, String str2, boolean z, File file) {
        LogDto logDto = new LogDto(str, (byte) 2);
        logDto.setLogBodyType(1);
        logDto.setFile(file);
        logDto.setCp(str2);
        logDto.setDe(i);
        logDto.setLimitByFlow(z);
        logDto.setSendImediately(true);
        d.a.f29577a.f29575a.a(logDto);
        return logDto.getResponseDto();
    }

    public static /* synthetic */ void a(ILogProtocol iLogProtocol) {
        for (ValueCallback<Pair<Message, Message>> valueCallback : getGlobalEnvStruct().getCallback(9)) {
            HashMap map = new HashMap(4);
            map.put("log_type", iLogProtocol.getLogType());
            map.put(com.igexin.c.a.c.a.d.d, iLogProtocol.generateString());
            map.put("link_key", iLogProtocol.getLinkKey());
            map.put(LocationConst.HDYawConst.KEY_HD_YAW_LINK_ID, iLogProtocol.getLinkId());
            Message messageObtain = Message.obtain(null, 9, map);
            Message messageObtain2 = Message.obtain();
            valueCallback.onReceiveValue(new Pair<>(messageObtain, messageObtain2));
            messageObtain.recycle();
            messageObtain2.recycle();
        }
    }
}
