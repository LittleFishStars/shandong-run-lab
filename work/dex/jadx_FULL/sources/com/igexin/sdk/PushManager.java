package com.igexin.sdk;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.kernel.common.log.PageLog;
import com.aliyun.credentials.utils.AuthConstant;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.util.CommonUtil;
import com.getui.gtc.dim.Caller;
import com.getui.gtc.dim.DimManager;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.c.a.c.a.c;
import com.igexin.d.a.AnonymousClass1;
import com.igexin.push.core.ServiceManager;
import com.igexin.push.core.b;
import com.igexin.push.core.h;
import com.igexin.push.g.d;
import com.igexin.push.g.e;
import com.igexin.push.g.f;
import com.igexin.push.g.n;
import com.igexin.push.g.o;
import com.igexin.sdk.message.BindAliasCmdMessage;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.SetTagCmdMessage;
import com.igexin.sdk.message.UnBindAliasCmdMessage;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.crypto.KeyGenerator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class PushManager {
    private static final String TAG = "PushManager";
    private volatile h callback;
    private byte[] keyBytes;
    private long lastOpAliasTime;
    private long lastQueryTagTime;
    private long lastSendMessageTime;
    private long lastSetTagTime;
    private String safeCode;
    private String uActivity;
    private String uIntentService;
    private Class uPushService;
    private String uRegisterService;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final PushManager f38165a = new PushManager();

        private a() {
        }
    }

    private PushManager() {
        this.lastQueryTagTime = 0L;
    }

    private static void checkContext(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
    }

    private boolean checkGTCVersion() {
        if (!d.b("3.2.5.0")) {
            return true;
        }
        c.a().a("[PushManager] GTC Version Need >= 3.2.5.0");
        return false;
    }

    private int getAssistAction(int i, String str) {
        if (TextUtils.isEmpty(str) || !str.contains(LoginConstants.UNDER_LINE)) {
            return i;
        }
        if (i != 60001 && i != 60002) {
            return i;
        }
        if (str.startsWith(AssistPushConsts.HW_PREFIX)) {
            return i + 18;
        }
        if (str.startsWith(AssistPushConsts.XM_PREFIX)) {
            return i + 48;
        }
        if (str.startsWith(AssistPushConsts.OPPO_PREFIX)) {
            return i + 28;
        }
        if (str.startsWith(AssistPushConsts.VIVO_PREFIX)) {
            return i + 38;
        }
        if (str.startsWith(AssistPushConsts.MZ_PREFIX)) {
            return i + 58;
        }
        if (str.startsWith(AssistPushConsts.ST_PREFIX)) {
            return i + 78;
        }
        if (str.startsWith(AssistPushConsts.FCM_PREFIX)) {
            return i + 98;
        }
        return str.startsWith(AssistPushConsts.HONOR_PREFIX) ? i + 118 : i;
    }

    public static PushManager getInstance() {
        return a.f38165a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Application getMainApplication(Context context) {
        if (context == null || !isMainProcess(context)) {
            return null;
        }
        return context instanceof Application ? (Application) context : (Application) context.getApplicationContext();
    }

    private Class getUserPushService(Context context) {
        checkContext(context);
        Class cls = this.uPushService;
        return cls != null ? cls : ServiceManager.getInstance().b(context);
    }

    private boolean isMainProcess(Context context) {
        try {
            GtcProvider.setContext(context);
            return CommonUtil.isMainProcess();
        } catch (Throwable unused) {
            return false;
        }
    }

    private void registerCallback(final Context context) {
        ServiceManager.b = context.getApplicationContext();
        com.igexin.b.a.a().a("GTALCallback").execute(new Runnable() { // from class: com.igexin.sdk.PushManager.1
            @Override // java.lang.Runnable
            public final void run() {
                Application mainApplication;
                try {
                    if (PushManager.this.callback == null && (mainApplication = PushManager.this.getMainApplication(context)) != null && PushManager.this.callback == null) {
                        PushManager.this.callback = new h();
                        mainApplication.registerActivityLifecycleCallbacks(PushManager.this.callback);
                        com.igexin.c.a.c.a.a("PushManager｜ registerCallback ", new Object[0]);
                    }
                } catch (Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                }
            }
        });
    }

    private <T extends Activity> void registerPushActivity(Context context, Class<T> cls) {
        String name;
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            if (cls != null) {
                try {
                    Class.forName(cls.getName());
                    name = cls.getName();
                } catch (Exception e) {
                    c.a().a("[PushManager] can't load activity = " + e.toString());
                    com.igexin.c.a.c.a.a("PushManager|registerPushActivity|" + e.toString(), new Object[0]);
                    return;
                }
            } else {
                c.a().a("[PushManager] call -> registerPushActivity, parameter [activity] is null");
                name = "";
            }
            this.uActivity = name;
            if (this.uPushService != null) {
                Bundle bundle = new Bundle();
                bundle.putString("action", "registerPushActivity");
                bundle.putString("ua", this.uActivity);
                Intent intent = new Intent(context.getApplicationContext(), (Class<?>) this.uPushService);
                intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
                intent.putExtra("bundle", bundle);
                intent.putExtra("ua", this.uActivity);
                startService(context, intent);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] registerPushActivity sdk error = " + th.toString());
        }
    }

    private <T extends Service> void registerUserService(Context context, Class<T> cls) {
        String name;
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            if (cls != null) {
                try {
                    Class.forName(cls.getName());
                    name = cls.getName();
                } catch (Exception e) {
                    c.a().a("[PushManager] can't load service = " + e.toString());
                    com.igexin.c.a.c.a.a("PushManager|registerUserService|" + e.toString(), new Object[0]);
                    return;
                }
            } else {
                c.a().a("[PushManager] call -> registerUserService, parameter [service] is null");
                name = "";
            }
            this.uRegisterService = name;
            if (this.uPushService != null) {
                Bundle bundle = new Bundle();
                bundle.putString("action", "registerUserService");
                bundle.putString(o.f38157a, this.uRegisterService);
                Intent intent = new Intent(context.getApplicationContext(), (Class<?>) this.uPushService);
                intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
                intent.putExtra("bundle", bundle);
                intent.putExtra(o.f38157a, this.uRegisterService);
                startService(context, intent);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] registerUserService  error = " + th.toString());
        }
    }

    private void sendBindAliasResult(Context context, String str, String str2) {
        sendResult(context, new BindAliasCmdMessage(str, str2, 10010));
    }

    private void sendResult(Context context, GTCmdMessage gTCmdMessage) {
        try {
            Class clsC = ServiceManager.getInstance().c(context);
            if (clsC == null || context == null) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) clsC);
            Bundle bundle = new Bundle();
            bundle.putInt("action", 10010);
            bundle.putSerializable(PushConsts.KEY_CMD_MSG, gTCmdMessage);
            intent.putExtras(bundle);
            context.startService(intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a("PushManager|" + th.toString(), new Object[0]);
        }
    }

    private void sendSetTagResult(Context context, String str, String str2) {
        sendResult(context, new SetTagCmdMessage(str, str2, 10009));
    }

    private void sendUnBindAliasResult(Context context, String str, String str2) {
        sendResult(context, new UnBindAliasCmdMessage(str, str2, 10011));
    }

    private boolean startService(Context context, Intent intent) {
        try {
            if (TextUtils.isEmpty(this.safeCode)) {
                String string = o.b(context, "sc", "").toString();
                this.safeCode = string;
                if (TextUtils.isEmpty(string)) {
                    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                    keyGenerator.init(128);
                    String strA = e.a(keyGenerator.generateKey().getEncoded());
                    this.safeCode = strA;
                    o.a(context, "sc", strA);
                }
            }
            intent.putExtra("sc", this.safeCode);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
        if (checkGTCVersion()) {
            return ServiceManager.getInstance().b(context, intent);
        }
        return false;
    }

    private void unRegisterCallback(final Context context) {
        com.igexin.b.a.a().a("GTALCallback").execute(new Runnable() { // from class: com.igexin.sdk.PushManager.2
            @Override // java.lang.Runnable
            public final void run() {
                Application mainApplication;
                try {
                    if (PushManager.this.callback == null || (mainApplication = PushManager.this.getMainApplication(context)) == null) {
                        return;
                    }
                    mainApplication.unregisterActivityLifecycleCallbacks(PushManager.this.callback);
                    PushManager.this.callback = null;
                    System.currentTimeMillis();
                    com.igexin.c.a.c.a.a("PushManager | unRegisterCallback time= " + System.currentTimeMillis(), new Object[0]);
                } catch (Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                }
            }
        });
    }

    public boolean areNotificationsEnabled(Context context) {
        return com.igexin.push.g.c.b(context);
    }

    public boolean bindAlias(Context context, String str) {
        return bindAlias(context, str, "bindAlias_" + System.currentTimeMillis());
    }

    public boolean bindAlias(Context context, String str, String str2) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            c.a().a("PushManager|call bindAlias");
            com.igexin.c.a.c.a.a("PushManager|call bindAlias", new Object[0]);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.lastOpAliasTime < 1000) {
                c.a().a("[PushManager] call - > bindAlias failed, it be called too frequently");
                sendBindAliasResult(context, str2, "30001");
                return false;
            }
            this.lastOpAliasTime = jCurrentTimeMillis;
            Bundle bundle = new Bundle();
            bundle.putString("action", "bindAlias");
            bundle.putString("alias", str);
            bundle.putString("sn", str2);
            Intent intent = new Intent(context.getApplicationContext(), (Class<?>) getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return startService(context, intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] bindAlias  error = " + th.toString());
            return false;
        }
    }

    public void checkManifest(Context context) throws GetuiPushException {
        if (isMainProcess(context)) {
            com.igexin.push.g.c.c(context);
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x007a A[Catch: all -> 0x00d4, TryCatch #1 {all -> 0x00d4, blocks: (B:3:0x0001, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:12:0x0020, B:13:0x0028, B:15:0x002e, B:17:0x0038, B:18:0x003c, B:20:0x0042, B:22:0x005b, B:26:0x007a, B:28:0x007e, B:33:0x0098, B:35:0x00a8, B:37:0x00ae, B:39:0x00b3, B:40:0x00c0, B:42:0x00cd, B:25:0x0063), top: B:55:0x0001, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x007e A[Catch: all -> 0x00d4, TryCatch #1 {all -> 0x00d4, blocks: (B:3:0x0001, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:12:0x0020, B:13:0x0028, B:15:0x002e, B:17:0x0038, B:18:0x003c, B:20:0x0042, B:22:0x005b, B:26:0x007a, B:28:0x007e, B:33:0x0098, B:35:0x00a8, B:37:0x00ae, B:39:0x00b3, B:40:0x00c0, B:42:0x00cd, B:25:0x0063), top: B:55:0x0001, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0094  */
    /* JADX WARN: Code duplicated, block: B:33:0x0098 A[Catch: all -> 0x00d4, TRY_ENTER, TryCatch #1 {all -> 0x00d4, blocks: (B:3:0x0001, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:12:0x0020, B:13:0x0028, B:15:0x002e, B:17:0x0038, B:18:0x003c, B:20:0x0042, B:22:0x005b, B:26:0x007a, B:28:0x007e, B:33:0x0098, B:35:0x00a8, B:37:0x00ae, B:39:0x00b3, B:40:0x00c0, B:42:0x00cd, B:25:0x0063), top: B:55:0x0001, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00a8 A[Catch: all -> 0x00d4, TryCatch #1 {all -> 0x00d4, blocks: (B:3:0x0001, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:12:0x0020, B:13:0x0028, B:15:0x002e, B:17:0x0038, B:18:0x003c, B:20:0x0042, B:22:0x005b, B:26:0x007a, B:28:0x007e, B:33:0x0098, B:35:0x00a8, B:37:0x00ae, B:39:0x00b3, B:40:0x00c0, B:42:0x00cd, B:25:0x0063), top: B:55:0x0001, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00b3 A[Catch: all -> 0x00d4, LOOP:0: B:38:0x00b1->B:39:0x00b3, LOOP_END, TryCatch #1 {all -> 0x00d4, blocks: (B:3:0x0001, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:12:0x0020, B:13:0x0028, B:15:0x002e, B:17:0x0038, B:18:0x003c, B:20:0x0042, B:22:0x005b, B:26:0x007a, B:28:0x007e, B:33:0x0098, B:35:0x00a8, B:37:0x00ae, B:39:0x00b3, B:40:0x00c0, B:42:0x00cd, B:25:0x0063), top: B:55:0x0001, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00cd A[Catch: all -> 0x00d4, TRY_LEAVE, TryCatch #1 {all -> 0x00d4, blocks: (B:3:0x0001, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:12:0x0020, B:13:0x0028, B:15:0x002e, B:17:0x0038, B:18:0x003c, B:20:0x0042, B:22:0x005b, B:26:0x007a, B:28:0x007e, B:33:0x0098, B:35:0x00a8, B:37:0x00ae, B:39:0x00b3, B:40:0x00c0, B:42:0x00cd, B:25:0x0063), top: B:55:0x0001, inners: #2 }] */
    public synchronized String getClientid(Context context) {
        byte[] bArrDecode;
        int length;
        byte[] bArr;
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            if (this.keyBytes == null) {
                try {
                    ApplicationInfo applicationInfoB = n.b(context);
                    if (applicationInfoB != null && applicationInfoB.metaData != null) {
                        String strA = d.a(applicationInfoB);
                        if (TextUtils.isEmpty(strA)) {
                            strA = applicationInfoB.metaData.getString(b.b);
                        }
                        if (TextUtils.isEmpty(strA)) {
                            strA = applicationInfoB.metaData.getString("GETUI_APPID");
                        }
                        if (strA != null) {
                            strA = strA.trim();
                        }
                        if (!TextUtils.isEmpty(strA)) {
                            String strA2 = com.igexin.c.b.a.a(strA + context.getPackageName());
                            if (strA2 != null) {
                                this.keyBytes = strA2.getBytes();
                                if (this.keyBytes != null) {
                                    ServiceManager.b = context.getApplicationContext();
                                    if (TextUtils.isEmpty(com.igexin.push.core.d.d.a().a("c"))) {
                                        return "";
                                    }
                                    bArrDecode = Base64.decode(com.igexin.push.core.d.d.a().a("c"), 0);
                                    if (bArrDecode != null) {
                                        length = bArrDecode.length;
                                        bArr = new byte[length];
                                        for (int i = 0; i < length; i++) {
                                            bArr[i] = (byte) (this.keyBytes[i] ^ bArrDecode[i]);
                                        }
                                        if (Pattern.matches("[a-zA-Z0-9]+", new String(bArr))) {
                                            return new String(bArr);
                                        }
                                    }
                                }
                            } else if (this.keyBytes != null) {
                                ServiceManager.b = context.getApplicationContext();
                                if (TextUtils.isEmpty(com.igexin.push.core.d.d.a().a("c"))) {
                                    return "";
                                }
                                bArrDecode = Base64.decode(com.igexin.push.core.d.d.a().a("c"), 0);
                                if (bArrDecode != null) {
                                    length = bArrDecode.length;
                                    bArr = new byte[length];
                                    while (i < length) {
                                        bArr[i] = (byte) (this.keyBytes[i] ^ bArrDecode[i]);
                                    }
                                    if (Pattern.matches("[a-zA-Z0-9]+", new String(bArr))) {
                                        return new String(bArr);
                                    }
                                }
                            }
                        } else if (this.keyBytes != null) {
                            ServiceManager.b = context.getApplicationContext();
                            if (TextUtils.isEmpty(com.igexin.push.core.d.d.a().a("c"))) {
                                return "";
                            }
                            bArrDecode = Base64.decode(com.igexin.push.core.d.d.a().a("c"), 0);
                            if (bArrDecode != null) {
                                length = bArrDecode.length;
                                bArr = new byte[length];
                                while (i < length) {
                                    bArr[i] = (byte) (this.keyBytes[i] ^ bArrDecode[i]);
                                }
                                if (Pattern.matches("[a-zA-Z0-9]+", new String(bArr))) {
                                    return new String(bArr);
                                }
                            }
                        }
                    } else if (this.keyBytes != null) {
                        ServiceManager.b = context.getApplicationContext();
                        if (TextUtils.isEmpty(com.igexin.push.core.d.d.a().a("c"))) {
                            return "";
                        }
                        bArrDecode = Base64.decode(com.igexin.push.core.d.d.a().a("c"), 0);
                        if (bArrDecode != null && this.keyBytes.length == bArrDecode.length) {
                            length = bArrDecode.length;
                            bArr = new byte[length];
                            while (i < length) {
                                bArr[i] = (byte) (this.keyBytes[i] ^ bArrDecode[i]);
                            }
                            if (Pattern.matches("[a-zA-Z0-9]+", new String(bArr))) {
                                return new String(bArr);
                            }
                        }
                    }
                } catch (Exception e) {
                    com.igexin.c.a.c.a.a("PushManager|" + e.toString(), new Object[0]);
                }
            } else if (this.keyBytes != null) {
                ServiceManager.b = context.getApplicationContext();
                if (TextUtils.isEmpty(com.igexin.push.core.d.d.a().a("c"))) {
                    return "";
                }
                bArrDecode = Base64.decode(com.igexin.push.core.d.d.a().a("c"), 0);
                if (bArrDecode != null) {
                    length = bArrDecode.length;
                    bArr = new byte[length];
                    while (i < length) {
                        bArr[i] = (byte) (this.keyBytes[i] ^ bArrDecode[i]);
                    }
                    if (Pattern.matches("[a-zA-Z0-9]+", new String(bArr))) {
                        return new String(bArr);
                    }
                }
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] getClientid  error = " + th.toString());
        }
        return null;
    }

    public String getVersion(Context context) {
        return "3.3.7.0";
    }

    public void initialize(Context context) {
        Class cls;
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            ServiceManager.getInstance().f(context);
            if (TextUtils.isEmpty(this.uIntentService) && (cls = (Class) d.a(context, GTIntentService.class).second) != null) {
                this.uIntentService = cls.getName();
            }
            if (this.uPushService == null) {
                this.uPushService = (Class) d.a(context, PushService.class).second;
            }
            initialize(context, this.uPushService);
        } catch (Throwable th) {
            c.a().a("[PushManager] initialize sdk error = " + th.toString());
        }
    }

    @Deprecated
    public <T extends Service> void initialize(Context context, Class<T> cls) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            if (checkGTCVersion()) {
                ServiceManager.getInstance().f(context);
                if (cls == null || b.ap.equals(cls.getName())) {
                    cls = PushService.class;
                }
                context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, (Class<?>) cls), 1, 1);
                Intent intent = new Intent(context.getApplicationContext(), (Class<?>) cls);
                intent.putExtra("action", PushConsts.ACTION_SERVICE_INITIALIZE);
                intent.putExtra("ups", cls.getName());
                String str = this.uIntentService;
                if (str != null) {
                    intent.putExtra(o.c, str);
                }
                if (!TextUtils.isEmpty(this.uActivity)) {
                    intent.putExtra("ua", this.uActivity);
                }
                if (!TextUtils.isEmpty(this.uRegisterService)) {
                    intent.putExtra(o.f38157a, this.uRegisterService);
                }
                if (startService(context, intent)) {
                    this.uPushService = cls;
                }
                registerCallback(context);
                try {
                    com.igexin.d.a aVarA = com.igexin.d.a.a();
                    aVarA.f37850a = context.getApplicationContext();
                    com.igexin.b.a.a().b().schedule(aVarA.new AnonymousClass1(), 2000L, TimeUnit.MILLISECONDS);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] initialize sdk error = " + th.toString());
        }
    }

    public boolean isPushTurnedOn(Context context) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            ServiceManager.b = context.getApplicationContext();
            return com.igexin.push.core.d.d.a().b("p");
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] turnOffPush  error = " + th.toString());
            return false;
        }
    }

    public void openNotification(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
            intent.putExtra("android.provider.extra.CHANNEL_ID", context.getApplicationInfo().uid);
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Throwable unused) {
        }
    }

    public boolean preInit(Context context) {
        Class cls;
        try {
            Context applicationContext = context.getApplicationContext();
            if (TextUtils.isEmpty(this.uIntentService) && (cls = (Class) d.a(applicationContext, GTIntentService.class).second) != null) {
                this.uIntentService = cls.getName();
            }
            if (this.uPushService != null) {
                return true;
            }
            this.uPushService = (Class) d.a(applicationContext, PushService.class).second;
            return true;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public boolean queryPushOnLine(Context context) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            Bundle bundle = new Bundle();
            bundle.putString("action", "queryPushOnLine");
            Intent intent = new Intent(context.getApplicationContext(), (Class<?>) getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return startService(context, intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] queryPushOnLine  error = " + th.toString());
            return false;
        }
    }

    public int queryTag(Context context, String str) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            if (str == null) {
                c.a().a("[PushManager]call -> queryTag failed, parameter [sn] is null");
                return 20007;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.lastQueryTagTime < 1000) {
                c.a().a("[PushManager]call -> queryTag failed, it be called too frequently");
                return 20002;
            }
            Bundle bundle = new Bundle();
            bundle.putString("action", PushConsts.QUERY_TAG);
            bundle.putString("sn", str);
            this.lastQueryTagTime = jCurrentTimeMillis;
            Intent intent = new Intent(context.getApplicationContext(), (Class<?>) getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            startService(context, intent);
            return 0;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] queryTag  error = " + th.toString());
            return 0;
        }
    }

    @Deprecated
    public <T extends GTIntentService> void registerPushIntentService(Context context, Class<T> cls) {
        String name;
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            com.igexin.c.a.c.a.a("PushManager|call registerPushIntentService", new Object[0]);
            if (cls != null) {
                try {
                    Class.forName(cls.getName());
                    if (!com.igexin.push.g.c.a(new Intent(context, (Class<?>) cls), context)) {
                        com.igexin.c.a.c.a.e.a(TAG, "call - > registerPushIntentService, parameter [userIntentService] is set, but didn't find class \"" + cls.getName() + "\", please check your AndroidManifest");
                        return;
                    }
                    name = cls.getName();
                } catch (Exception e) {
                    com.igexin.c.a.c.a.a("PushManager|registerPushIntentService|" + e.toString(), new Object[0]);
                    return;
                }
            } else {
                name = "";
            }
            this.uIntentService = name;
            if (this.uPushService != null) {
                com.igexin.c.a.c.a.b(TAG, "start service to save intent service");
                Intent intent = new Intent(context.getApplicationContext(), (Class<?>) this.uPushService);
                intent.putExtra(o.c, this.uIntentService);
                startService(context, intent);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] registerPushIntentService  error = " + th.toString());
        }
    }

    public boolean sendApplinkFeedback(Context context, String str) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            if (TextUtils.isEmpty(str)) {
                c.a().a("[PushManager] call - > sendApplinkFeedback failed, parameter is illegal");
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putString("action", "sendApplinkFeedback");
            bundle.putString("url", str);
            Intent intent = new Intent(context.getApplicationContext(), (Class<?>) getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return startService(context, intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] sendApplinkFeedback  error = " + th.toString());
            return false;
        }
    }

    public boolean sendFeedbackMessage(Context context, String str, String str2, int i) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            boolean z = (i >= 60001 && i <= 60999) || (i >= 90001 && i <= 90999);
            if (str != null && str2 != null && z) {
                int assistAction = getAssistAction(i, str2);
                Bundle bundle = new Bundle();
                bundle.putString("action", "sendFeedbackMessage");
                bundle.putString("taskid", str);
                bundle.putString("messageid", str2);
                bundle.putString("actionid", String.valueOf(assistAction));
                Intent intent = new Intent(context.getApplicationContext(), (Class<?>) getUserPushService(context));
                intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
                intent.putExtra("bundle", bundle);
                return startService(context, intent);
            }
            c.a().a("[PushManager] call - > sendFeedbackMessage failed, parameter is illegal");
            return false;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] sendFeedbackMessage  error = " + th.toString());
            return false;
        }
    }

    public boolean sendMessage(Context context, String str, byte[] bArr) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (str != null && bArr != null && bArr.length <= 4096 && jCurrentTimeMillis - this.lastSendMessageTime >= 1000) {
                this.lastSendMessageTime = jCurrentTimeMillis;
                Bundle bundle = new Bundle();
                bundle.putString("action", "sendMessage");
                bundle.putString("taskid", str);
                bundle.putByteArray("extraData", bArr);
                Intent intent = new Intent(context.getApplicationContext(), (Class<?>) getUserPushService(context));
                intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
                intent.putExtra("bundle", bundle);
                return startService(context, intent);
            }
            c.a().a("[PushManager] call - > sendMessage failed, parameter is illegal or it be called too frequently");
            return false;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] sendMessage  error = " + th.toString());
            return false;
        }
    }

    public boolean setAdvertisingIdEnable(Context context, boolean z) {
        try {
            if (DimManager.getInstance().setSetting(context, f.b.u, Caller.PUSH.name(), String.valueOf(z))) {
                c.a().a("[PushManager] setAdvertisingIdEnable success");
                return true;
            }
            c.a().a("[PushManager] setAdvertisingIdEnable  error");
            return false;
        } catch (Throwable th) {
            c.a().a("[PushManager] setAdvertisingIdEnable fail " + th.getMessage());
            return false;
        }
    }

    public boolean setAdvertisingIdInterval(Context context, long j) {
        try {
            if (DimManager.getInstance().setSetting(context, f.b.v, Caller.PUSH.name(), String.valueOf(j * 60 * 60 * 1000))) {
                c.a().a("[PushManager] setAdvertisingIdInterval success");
                return true;
            }
            c.a().a("[PushManager] setAdvertisingIdInterval  error =必须在 24-24*7 小时之间");
            return false;
        } catch (Throwable th) {
            c.a().a("[PushManager] setAdvertisingIdInterval fail " + th.getMessage());
            return false;
        }
    }

    public boolean setAppListInterval(Context context, long j) {
        try {
            if (DimManager.getInstance().setSetting(context, f.b.f, Caller.PUSH.name(), String.valueOf(j * 60 * 60 * 1000))) {
                c.a().a("[PushManager] setAppListInterval success");
                return true;
            }
            c.a().a("[PushManager] setAppListInterval  error = 必须在6-24小时之间");
            return false;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] setAppListInterval  error = " + th.toString());
            return false;
        }
    }

    public boolean setBadgeNum(Context context, int i) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            c.a().a("[PushManager] call - > setBadgeNum");
            Bundle bundle = new Bundle();
            bundle.putString("action", "setBadgeNum");
            bundle.putInt("badgeNum", i);
            Intent intent = new Intent(context.getApplicationContext(), (Class<?>) getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return startService(context, intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] setBadgeNum  error = " + th.toString());
            return false;
        }
    }

    public boolean setCellInfoEnable(Context context, boolean z) {
        try {
            if (DimManager.getInstance().setSetting(context, f.b.w, Caller.PUSH.name(), String.valueOf(z))) {
                c.a().a("[PushManager] setCellInfoEnable success");
                return true;
            }
            c.a().a("[PushManager] setCellInfoEnable  error");
            return false;
        } catch (Throwable th) {
            c.a().a("[PushManager] setCellInfoEnable fail " + th.getMessage());
            return false;
        }
    }

    public boolean setCellInfoInterval(Context context, int i) {
        try {
            if (DimManager.getInstance().setSetting(context, f.b.x, Caller.PUSH.name(), String.valueOf(i * 1000))) {
                c.a().a("[PushManager] setCellInfoInterval success");
                return true;
            }
            c.a().a("[PushManager] setCellInfoInterval  error = 必须在 5-1800 秒之间");
            return false;
        } catch (Throwable th) {
            c.a().a("[PushManager] setCellInfoInterval fail " + th.getMessage());
            return false;
        }
    }

    public void setDebugLogger(Context context, IUserLoggerInterface iUserLoggerInterface) {
        if (context == null || iUserLoggerInterface == null) {
            throw new IllegalArgumentException("context or loggerInterface can not be null");
        }
        try {
            GtcProvider.setContext(context);
            if (!com.igexin.push.g.c.a(context)) {
                iUserLoggerInterface.log("only run in debug mode");
                return;
            }
            if (!isMainProcess(context)) {
                iUserLoggerInterface.log("Must be called in main process!");
                return;
            }
            try {
                checkManifest(context);
            } catch (GetuiPushException e) {
                iUserLoggerInterface.log(e.toString());
            }
            c cVarA = c.a();
            Context applicationContext = context.getApplicationContext();
            cVarA.a(applicationContext);
            cVarA.b.a(iUserLoggerInterface);
            cVarA.b.a();
            cVarA.a("[LogController] Sdk version = " + getInstance().getVersion(applicationContext));
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public boolean setDeviceToken(Context context, String str) {
        try {
            Context applicationContext = context.getApplicationContext();
            if (TextUtils.isEmpty(str)) {
                c.a().a("[PushManager] setDeviceToken error = token is empty");
                return false;
            }
            if (str.equalsIgnoreCase("InvalidAppKey")) {
                c.a().a("[PushManager] setDeviceToken error = token is InvalidAppKey");
                return false;
            }
            checkContext(applicationContext);
            GtcProvider.setContext(applicationContext);
            Bundle bundle = new Bundle();
            bundle.putString("action", "setDeviceToken");
            bundle.putString("token", str);
            Intent intent = new Intent(applicationContext.getApplicationContext(), (Class<?>) getUserPushService(applicationContext));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return startService(applicationContext, intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] setDeviceToken  error = " + th.toString());
            return false;
        }
    }

    public boolean setEmergencyPush(Context context, boolean z) {
        try {
            Context applicationContext = context.getApplicationContext();
            checkContext(applicationContext);
            GtcProvider.setContext(applicationContext);
            o.a(applicationContext, o.m, Boolean.valueOf(z));
            Boolean bool = Boolean.TRUE;
            boolean z2 = ((Boolean) o.b(applicationContext, o.n, bool)).booleanValue() || z;
            DimManager dimManager = DimManager.getInstance();
            String str = f.b.A;
            Caller caller = Caller.PUSH;
            dimManager.setSetting(applicationContext, str, caller.name(), String.valueOf(z2));
            DimManager.getInstance().setSetting(applicationContext, f.b.i, caller.name(), String.valueOf(z2));
            DimManager.getInstance().setSetting(applicationContext, f.b.g, caller.name(), String.valueOf(z2));
            DimManager.getInstance().setSetting(applicationContext, f.b.e, caller.name(), String.valueOf(((Boolean) o.b(applicationContext, o.l, bool)).booleanValue() || z || ((Boolean) o.b(applicationContext, o.k, bool)).booleanValue()));
            c.a().a("[PushManager] setEmergencyPush  success");
            return true;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] setEmergencyPush  error = " + th.toString());
            return false;
        }
    }

    @Deprecated
    public boolean setGuardOptions(Context context, boolean z, boolean z2) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            Bundle bundle = new Bundle();
            bundle.putString("action", "setGuardOptions");
            bundle.putBoolean("guardMe", z);
            bundle.putBoolean("guardOthers", z2);
            Intent intent = new Intent(context.getApplicationContext(), (Class<?>) getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return startService(context, intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] setGuardOptions  error = " + th.toString());
            return false;
        }
    }

    public boolean setHeartbeatInterval(Context context, int i) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            if (i < 0) {
                c.a().a("[PushManager] call -> setHeartbeatInterval failed, parameter [interval] < 0, illegal");
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putString("action", "setHeartbeatInterval");
            bundle.putInt("interval", i);
            Intent intent = new Intent(context.getApplicationContext(), (Class<?>) getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return startService(context, intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] setHeartbeatInterval  error = " + th.toString());
            return false;
        }
    }

    @Deprecated
    public boolean setHwBadgeNum(Context context, int i) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            c.a().a("[PushManager] call - > setHwBadgeNum");
            Bundle bundle = new Bundle();
            bundle.putString("action", "setHwBadgeNum");
            bundle.putInt("badgeNum", i);
            Intent intent = new Intent(context.getApplicationContext(), (Class<?>) getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return startService(context, intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] setHwBadgeNum  error = " + th.toString());
            return false;
        }
    }

    public boolean setIccIdEnable(Context context, boolean z) {
        try {
            if (DimManager.getInstance().setSetting(context, f.b.q, Caller.PUSH.name(), String.valueOf(z))) {
                c.a().a("[PushManager] setIccIdEnable success");
                return true;
            }
            c.a().a("[PushManager] setIccIdEnable  error");
            return false;
        } catch (Throwable th) {
            c.a().a("[PushManager] setIccIdEnable fail " + th.getMessage());
            return false;
        }
    }

    public boolean setIccIdInterval(Context context, int i) {
        try {
            if (DimManager.getInstance().setSetting(context, f.b.r, Caller.PUSH.name(), String.valueOf(((long) i) * 60 * 60 * 1000))) {
                c.a().a("[PushManager] setIccIdInterval success");
                return true;
            }
            c.a().a("[PushManager] setIccIdInterval  error = 必须在 24-24*7 小时之间");
            return false;
        } catch (Throwable th) {
            c.a().a("[PushManager] setIccIdInterval fail " + th.getMessage());
            return false;
        }
    }

    public boolean setImeiEnable(Context context, boolean z) {
        try {
            if (DimManager.getInstance().setSetting(context, f.b.k, Caller.PUSH.name(), String.valueOf(z))) {
                c.a().a("[PushManager] setImeiEnable success");
                return true;
            }
            c.a().a("[PushManager] setImeiEnable  error");
            return false;
        } catch (Throwable th) {
            c.a().a("[PushManager] setImeiEnable fail " + th.getMessage());
            return false;
        }
    }

    public boolean setImeiInterval(Context context, int i) {
        try {
            if (DimManager.getInstance().setSetting(context, f.b.l, Caller.PUSH.name(), String.valueOf(((long) i) * 60 * 60 * 1000))) {
                c.a().a("[PushManager] setImeiInterval success");
                return true;
            }
            c.a().a("[PushManager] setImeiInterval  error = 必须在 24-24*7 小时之间");
            return false;
        } catch (Throwable th) {
            c.a().a("[PushManager] setImeiInterval fail " + th.getMessage());
            return false;
        }
    }

    public boolean setImsiEnable(Context context, boolean z) {
        try {
            if (DimManager.getInstance().setSetting(context, f.b.m, Caller.PUSH.name(), String.valueOf(z))) {
                c.a().a("[PushManager] setImsiEnable success");
                return true;
            }
            c.a().a("[PushManager] setImsiEnable  error");
            return false;
        } catch (Throwable th) {
            c.a().a("[PushManager] setImsiEnable fail " + th.getMessage());
            return false;
        }
    }

    public boolean setImsiInterval(Context context, int i) {
        try {
            if (DimManager.getInstance().setSetting(context, f.b.n, Caller.PUSH.name(), String.valueOf(((long) i) * 60 * 60 * 1000))) {
                c.a().a("[PushManager] setImsiInterval success");
                return true;
            }
            c.a().a("[PushManager] setImsiInterval  error = 必须在 24-24*7 小时之间");
            return false;
        } catch (Throwable th) {
            c.a().a("[PushManager] setImsiInterval fail " + th.getMessage());
            return false;
        }
    }

    public boolean setIndividuationPush(Context context, boolean z) {
        try {
            Context applicationContext = context.getApplicationContext();
            checkContext(applicationContext);
            GtcProvider.setContext(applicationContext);
            o.a(applicationContext, o.k, Boolean.valueOf(z));
            Boolean bool = Boolean.TRUE;
            DimManager.getInstance().setSetting(applicationContext, f.b.e, Caller.PUSH.name(), String.valueOf(z || ((Boolean) o.b(applicationContext, o.l, bool)).booleanValue() || ((Boolean) o.b(applicationContext, o.m, bool)).booleanValue()));
            c.a().a("[PushManager] setIndividuationPush success");
            return true;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] setIndividuationPush  error = " + th.toString());
            return false;
        }
    }

    public boolean setIpEnable(Context context, boolean z) {
        try {
            if (DimManager.getInstance().setSetting(context, f.b.y, Caller.PUSH.name(), String.valueOf(z))) {
                c.a().a("[PushManager] setIpEnable success");
                return true;
            }
            c.a().a("[PushManager] setIpEnable  error");
            return false;
        } catch (Throwable th) {
            c.a().a("[PushManager] setIpEnable fail " + th.getMessage());
            return false;
        }
    }

    public boolean setIpInterval(Context context, long j) {
        try {
            if (DimManager.getInstance().setSetting(context, f.b.z, Caller.PUSH.name(), String.valueOf(j * 1000))) {
                c.a().a("[PushManager] setIpInterval success");
                return true;
            }
            c.a().a("[PushManager] setIpInterval  error = 必须在 5-1800  秒之间");
            return false;
        } catch (Throwable th) {
            c.a().a("[PushManager] setIpInterval fail " + th.getMessage());
            return false;
        }
    }

    public boolean setLinkMerge(Context context, boolean z) {
        try {
            Context applicationContext = context.getApplicationContext();
            checkContext(applicationContext);
            GtcProvider.setContext(applicationContext);
            o.a(applicationContext, o.l, Boolean.valueOf(z));
            String str = o.k;
            Boolean bool = Boolean.TRUE;
            DimManager.getInstance().setSetting(applicationContext, f.b.e, Caller.PUSH.name(), String.valueOf(((Boolean) o.b(applicationContext, str, bool)).booleanValue() || z || ((Boolean) o.b(applicationContext, o.m, bool)).booleanValue()));
            Bundle bundle = new Bundle();
            bundle.putString("action", "setLinkMerge");
            bundle.putBoolean(AuthConstant.INI_ENABLE, z);
            Intent intent = new Intent(applicationContext.getApplicationContext(), (Class<?>) getInstance().getUserPushService(applicationContext));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return getInstance().startService(applicationContext, intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] setLinkMerge  error = " + th.toString());
            return false;
        }
    }

    public boolean setLocationInterval(Context context, long j) {
        try {
            DimManager dimManager = DimManager.getInstance();
            String str = f.b.h;
            Caller caller = Caller.PUSH;
            long j2 = j * 1000;
            boolean setting = dimManager.setSetting(context, str, caller.name(), String.valueOf(j2));
            boolean setting2 = DimManager.getInstance().setSetting(context, f.b.j, caller.name(), String.valueOf(j2));
            if (setting && setting2) {
                c.a().a("[PushManager] setLocationInterval success");
                return true;
            }
            c.a().a("[PushManager] setLocationInterval  error = 必须在 5-1800 秒之间");
            return false;
        } catch (Throwable th) {
            c.a().a("[PushManager] setLocationInterval fail " + th.getMessage());
            return false;
        }
    }

    public boolean setMacEnable(Context context, boolean z) {
        try {
            if (DimManager.getInstance().setSetting(context, f.b.o, Caller.PUSH.name(), String.valueOf(z))) {
                c.a().a("[PushManager] setMacEnable success");
                return true;
            }
            c.a().a("[PushManager] setMacEnable  error");
            return false;
        } catch (Throwable th) {
            c.a().a("[PushManager] setMacEnable fail " + th.getMessage());
            return false;
        }
    }

    public boolean setMacInterval(Context context, int i) {
        try {
            if (DimManager.getInstance().setSetting(context, f.b.p, Caller.PUSH.name(), String.valueOf(((long) i) * 60 * 60 * 1000))) {
                c.a().a("[PushManager] setMacInterval success");
                return true;
            }
            c.a().a("[PushManager] setMacInterval  error = 必须在 24-24*7 小时之间");
            return false;
        } catch (Throwable th) {
            c.a().a("[PushManager] setMacInterval fail " + th.getMessage());
            return false;
        }
    }

    public boolean setNotificationIcon(Context context, String str, String str2) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            Bundle bundle = new Bundle();
            bundle.putString("action", "setNotificationIcon");
            bundle.putString("smallIcon", str);
            bundle.putString("largeIcon", str2);
            Intent intent = new Intent(context.getApplicationContext(), (Class<?>) getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return startService(context, intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] setNotificationIcon  error = " + th.toString());
            return false;
        }
    }

    @Deprecated
    public boolean setOPPOBadgeNum(Context context, int i) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            c.a().a("[PushManager] call - > setHwBadgeNum");
            Bundle bundle = new Bundle();
            bundle.putString("action", "setOppoBadgeNum");
            bundle.putInt("badgeNum", i);
            Intent intent = new Intent(context.getApplicationContext(), (Class<?>) getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return startService(context, intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] setOPPOBadgeNum  error = " + th.toString());
            return false;
        }
    }

    public boolean setScenePush(Context context, boolean z) {
        try {
            Context applicationContext = context.getApplicationContext();
            checkContext(applicationContext);
            GtcProvider.setContext(applicationContext);
            o.a(applicationContext, o.n, Boolean.valueOf(z));
            boolean z2 = z || ((Boolean) o.b(applicationContext, o.m, Boolean.TRUE)).booleanValue();
            DimManager dimManager = DimManager.getInstance();
            String str = f.b.i;
            Caller caller = Caller.PUSH;
            dimManager.setSetting(applicationContext, str, caller.name(), String.valueOf(z2));
            DimManager.getInstance().setSetting(applicationContext, f.b.g, caller.name(), String.valueOf(z2));
            DimManager.getInstance().setSetting(applicationContext, f.b.A, caller.name(), String.valueOf(z2));
            c.a().a("[PushManager] setScenePush success");
            return true;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] setScenePush  error = " + th.toString());
            return false;
        }
    }

    public boolean setSerialNumberEnable(Context context, boolean z) {
        try {
            if (DimManager.getInstance().setSetting(context, f.b.s, Caller.PUSH.name(), String.valueOf(z))) {
                c.a().a("[PushManager] setSerialNumberEnable success");
                return true;
            }
            c.a().a("[PushManager] setSerialNumberEnable  error");
            return false;
        } catch (Throwable th) {
            c.a().a("[PushManager] setSerialNumberEnable fail " + th.getMessage());
            return false;
        }
    }

    public boolean setSerialNumberInterval(Context context, int i) {
        try {
            if (DimManager.getInstance().setSetting(context, f.b.t, Caller.PUSH.name(), String.valueOf(((long) i) * 60 * 60 * 1000))) {
                c.a().a("[PushManager] setSerialNumberInterval success");
                return true;
            }
            c.a().a("[PushManager] setSerialNumberInterval  error = 必须在 24-24*7 小时之间");
            return false;
        } catch (Throwable th) {
            c.a().a("[PushManager] setSerialNumberInterval fail " + th.getMessage());
            return false;
        }
    }

    public boolean setSilentTime(Context context, int i, int i2) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            if (i >= 0 && i < 24 && i2 >= 0 && i2 <= 23) {
                Bundle bundle = new Bundle();
                bundle.putString("action", "setSilentTime");
                bundle.putInt("beginHour", i);
                bundle.putInt("duration", i2);
                Intent intent = new Intent(context.getApplicationContext(), (Class<?>) getUserPushService(context));
                intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
                intent.putExtra("bundle", bundle);
                return startService(context, intent);
            }
            c.a().a("[PushManager] call - > setSilentTime failed, parameter [beginHour] or [duration] value exceeding");
            return false;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] queryTag  error = " + th.toString());
            return false;
        }
    }

    public boolean setSocketTimeout(Context context, int i) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            if (i < 0) {
                c.a().a("[PushManager] call - > setSocketTimeout failed, parameter [timeout] < 0, illegal");
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putString("action", "setSocketTimeout");
            bundle.putInt(com.alipay.sdk.m.o.b.r0, i);
            Intent intent = new Intent(context.getApplicationContext(), (Class<?>) getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return startService(context, intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] setSocketTimeout  error = " + th.toString());
            return false;
        }
    }

    public int setTag(Context context, Tag[] tagArr, String str) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            if (tagArr == null) {
                c.a().a("[PushManager] call -> setTag failed, parameter [tags] is null");
                com.igexin.c.a.c.a.a("PushManager|tags is null", new Object[0]);
                sendSetTagResult(context, str, "20006");
                return 20006;
            }
            if (str == null) {
                c.a().a("[PushManager] call -> setTag failed, parameter [sn] is null");
                sendSetTagResult(context, str, "20007");
                return 20007;
            }
            if (tagArr.length > 200) {
                c.a().a("[PushManager] call -> setTag failed, parameter [tags] len > 200 is exceeds");
                sendSetTagResult(context, str, PushConsts.SEND_MESSAGE_ERROR_GENERAL);
                return 20001;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.lastSetTagTime < 1000) {
                c.a().a("[PushManager] call - > setTag failed, it be called too frequently");
                sendSetTagResult(context, str, PushConsts.SEND_MESSAGE_ERROR_TIME_OUT);
                return 20002;
            }
            StringBuilder sb = new StringBuilder();
            for (Tag tag : tagArr) {
                if (tag != null && tag.getName() != null) {
                    if (!tag.getName().contains(" ") && !tag.getName().contains(",")) {
                        sb.append(tag.getName());
                        sb.append(",");
                    }
                    c.a().a("[PushManager] call -> setTag failed, the tag [" + tag.getName() + "] is not illegal");
                    sendSetTagResult(context, str, "20011");
                    return PushConsts.SETTAG_TAG_ILLEGAL;
                }
            }
            if (sb.length() <= 0) {
                sendSetTagResult(context, str, "20006");
                return 20006;
            }
            sb.deleteCharAt(sb.length() - 1);
            c.a().a("[PushManager] call setTag");
            Bundle bundle = new Bundle();
            bundle.putString("action", "setTag");
            bundle.putString(PageLog.PAGE_LOG_TAGS, sb.toString());
            bundle.putString("sn", str);
            this.lastSetTagTime = jCurrentTimeMillis;
            Intent intent = new Intent(context.getApplicationContext(), (Class<?>) getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            startService(context, intent);
            return 0;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] setTag  error = " + th.toString());
            return 20005;
        }
    }

    @Deprecated
    public boolean setVivoAppBadgeNum(Context context, int i) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            c.a().a("[PushManager] call - > setHwBadgeNum");
            Bundle bundle = new Bundle();
            bundle.putString("action", "setVivoBadgeNum");
            bundle.putInt("badgeNum", i);
            Intent intent = new Intent(context.getApplicationContext(), (Class<?>) getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return startService(context, intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] setOPPOBadgeNum  error = " + th.toString());
            return false;
        }
    }

    public void turnOffPush(Context context) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            c.a().a("PushManager|call turnOffPush");
            Bundle bundle = new Bundle();
            bundle.putString("action", "turnOffPush");
            Intent intent = new Intent(context.getApplicationContext(), (Class<?>) getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            startService(context, intent);
            unRegisterCallback(context);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] turnOffPush  error = " + th.toString());
        }
    }

    public void turnOnPush(Context context) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            c.a().a("PushManager|call turnOnPush");
            Intent intent = new Intent(context.getApplicationContext(), (Class<?>) getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_SERVICE_INITIALIZE_SLAVE);
            intent.putExtra("op_app", context.getApplicationContext().getPackageName());
            intent.putExtra("isSlave", true);
            startService(context, intent);
            registerCallback(context);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] turnOnPush  error = " + th.toString());
        }
    }

    public boolean unBindAlias(Context context, String str, boolean z) {
        return unBindAlias(context, str, z, "unBindAlias_" + System.currentTimeMillis());
    }

    public boolean unBindAlias(Context context, String str, boolean z, String str2) {
        try {
            checkContext(context);
            GtcProvider.setContext(context);
            c.a().a("PushManager|call unBindAlias");
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.lastOpAliasTime < 1000) {
                c.a().a("[PushManager] call - > unBindAlias failed, it be called too frequently");
                sendUnBindAliasResult(context, str2, "30001");
                return false;
            }
            this.lastOpAliasTime = jCurrentTimeMillis;
            Bundle bundle = new Bundle();
            bundle.putString("action", "unbindAlias");
            bundle.putString("alias", str);
            bundle.putBoolean("isSeft", z);
            bundle.putString("sn", str2);
            Intent intent = new Intent(context.getApplicationContext(), (Class<?>) getUserPushService(context));
            intent.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return startService(context, intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            c.a().a("[PushManager] unBindAlias  error = " + th.toString());
            return false;
        }
    }
}
