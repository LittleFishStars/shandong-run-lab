package com.igexin.push.core.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.common.log.PageLog;
import com.aliyun.credentials.utils.AuthConstant;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.igexin.assist.sdk.AssistPushManager;
import com.igexin.assist.util.AssistUtils;
import com.igexin.push.config.a.AnonymousClass3;
import com.igexin.push.config.a.AnonymousClass4;
import com.igexin.push.core.ServiceManager;
import com.igexin.push.core.a.a.c;
import com.igexin.push.core.a.a.d;
import com.igexin.push.core.a.a.e;
import com.igexin.push.core.a.a.f;
import com.igexin.push.core.b.n;
import com.igexin.push.core.e.e.AnonymousClass3;
import com.igexin.push.core.e.f.AnonymousClass20;
import com.igexin.push.core.e.f.AnonymousClass21;
import com.igexin.push.core.l;
import com.igexin.push.core.m;
import com.igexin.push.d.c.h;
import com.igexin.push.d.c.k;
import com.igexin.push.d.c.p;
import com.igexin.push.d.c.q;
import com.igexin.push.extension.mod.PushTaskBean;
import com.igexin.push.g.g;
import com.igexin.push.g.j;
import com.igexin.push.g.o;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.main.FeedbackImpl;
import com.kc.openset.constant.DeviceIdType;
import com.zj.adlib.u15;
import com.zj.adlib.ze1;
import java.io.File;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b extends a implements com.igexin.push.e.b {
    private static final String b = "CoreAction";
    private static SparseArray<a> c;
    private static volatile b d;

    private b() {
        SparseArray<a> sparseArray = new SparseArray<>();
        c = sparseArray;
        sparseArray.put(0, new com.igexin.push.core.a.a.a());
        c.put(5, new c());
        c.put(37, new d());
        c.put(9, new f());
        c.put(20, new e());
        c.put(26, new com.igexin.push.core.a.b.d());
        c.put(97, new com.igexin.push.core.a.a.b());
    }

    public static Class a(Context context) {
        return ServiceManager.getInstance().b(context);
    }

    public static String a(String str, String str2) {
        return str + u15.f19942b + str2;
    }

    public static void a(Intent intent) throws Throwable {
        com.igexin.c.a.c.a.a("CoreAction|onServiceInitialize ##", new Object[0]);
        if (intent == null) {
            return;
        }
        com.igexin.push.core.d unused = com.igexin.push.core.d.a.f37984a;
        com.igexin.push.core.d.a(false);
        com.igexin.push.core.e.N = intent.hasExtra("op_app") ? intent.getStringExtra("op_app") : "";
        com.igexin.push.core.e.v = false;
        if (com.igexin.push.core.e.u) {
            l.a().c();
            com.igexin.push.core.e.v = true;
        }
        if (!o.a(com.igexin.push.core.e.l) || j.d == null) {
            return;
        }
        ServiceManager.getInstance();
        String strE = ServiceManager.e(com.igexin.push.core.e.l);
        if (!com.igexin.push.core.b.ap.equals(strE)) {
            byte[] bArrB = com.igexin.c.b.a.b(strE.getBytes());
            if (bArrB == null || !j.k()) {
                return;
            }
            j.a(bArrB, j.d);
            return;
        }
        if (j.k() && new File(j.d).delete()) {
            String str = j.d;
            com.igexin.c.a.c.a.a("del " + j.d + " success ~~~", new Object[0]);
        }
    }

    /* JADX WARN: Code duplicated, block: B:74:0x0139  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static void a(Bundle bundle) {
        byte b2;
        try {
            m.a();
            String string = bundle.getString("action");
            com.igexin.c.a.c.a.a("PushController|action pushmanager action = ".concat(String.valueOf(string)), new Object[0]);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            switch (string.hashCode()) {
                case -1710807787:
                    if (!string.equals("queryPushOnLine")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.common.base.a.u;
                    }
                    break;
                case -1673882831:
                    if (!string.equals("setVivoBadgeNum")) {
                        b2 = -1;
                    } else {
                        b2 = 11;
                    }
                    break;
                case -1411528570:
                    if (!string.equals("setNotificationIcon")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.common.base.a.r;
                    }
                    break;
                case -1166665294:
                    if (!string.equals(PushConsts.QUERY_TAG)) {
                        b2 = -1;
                    } else {
                        b2 = 17;
                    }
                    break;
                case -1092138459:
                    if (!string.equals("setOppoBadgeNum")) {
                        b2 = -1;
                    } else {
                        b2 = 12;
                    }
                    break;
                case -957964269:
                    if (!string.equals("bindAlias")) {
                        b2 = -1;
                    } else {
                        b2 = 7;
                    }
                    break;
                case -908867308:
                    if (!string.equals("setHwBadgeNum")) {
                        b2 = -1;
                    } else {
                        b2 = 10;
                    }
                    break;
                case -905799720:
                    if (!string.equals("setTag")) {
                        b2 = -1;
                    } else {
                        b2 = 0;
                    }
                    break;
                case -889524838:
                    if (!string.equals("unbindAlias")) {
                        b2 = -1;
                    } else {
                        b2 = 8;
                    }
                    break;
                case -850755092:
                    if (!string.equals("turnOffPush")) {
                        b2 = -1;
                    } else {
                        b2 = 6;
                    }
                    break;
                case -479268212:
                    if (!string.equals("registerPushActivity")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.common.base.a.p;
                    }
                    break;
                case -344351336:
                    if (!string.equals("sendApplinkFeedback")) {
                        b2 = -1;
                    } else {
                        b2 = 9;
                    }
                    break;
                case -159289499:
                    if (!string.equals("setBadgeNum")) {
                        b2 = -1;
                    } else {
                        b2 = 13;
                    }
                    break;
                case -101965284:
                    if (!string.equals("setLinkMerge")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.common.base.a.y;
                    }
                    break;
                case -12797509:
                    if (!string.equals("setGuardOptions")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.common.base.a.x;
                    }
                    break;
                case 329771905:
                    if (!string.equals("setDeviceToken")) {
                        b2 = -1;
                    } else {
                        b2 = 19;
                    }
                    break;
                case 495464132:
                    if (!string.equals("setSilentTime")) {
                        b2 = -1;
                    } else {
                        b2 = 1;
                    }
                    break;
                case 539767084:
                    if (!string.equals("setSocketTimeout")) {
                        b2 = -1;
                    } else {
                        b2 = 4;
                    }
                    break;
                case 556182983:
                    if (!string.equals("registerUserService")) {
                        b2 = -1;
                    } else {
                        b2 = com.google.common.base.a.q;
                    }
                    break;
                case 691453791:
                    if (!string.equals("sendMessage")) {
                        b2 = -1;
                    } else {
                        b2 = 2;
                    }
                    break;
                case 999002527:
                    if (!string.equals("setHeartbeatInterval")) {
                        b2 = -1;
                    } else {
                        b2 = 3;
                    }
                    break;
                case 1841202202:
                    if (!string.equals("sendFeedbackMessage")) {
                        b2 = -1;
                    } else {
                        b2 = 5;
                    }
                    break;
                default:
                    b2 = -1;
                    break;
            }
            switch (b2) {
                case 0:
                    if (com.igexin.push.config.d.k) {
                        String string2 = bundle.getString(PageLog.PAGE_LOG_TAGS);
                        String string3 = bundle.getString("sn");
                        if (TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                            com.igexin.c.a.c.a.d.a().a("setTag : " + string2 + ", failed, has not get clientid");
                            l.a().a(string3, "20008");
                            return;
                        }
                        try {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("action", "set_tag");
                                jSONObject.put("id", String.valueOf(jCurrentTimeMillis));
                                jSONObject.put("cid", com.igexin.push.core.e.A);
                                jSONObject.put("appid", com.igexin.push.core.e.f38001a);
                                jSONObject.put(PageLog.PAGE_LOG_TAGS, URLEncoder.encode(string2, "utf-8"));
                                jSONObject.put("sn", string3);
                                break;
                            } catch (Exception e) {
                                com.igexin.c.a.c.a.a(e);
                            }
                            com.igexin.push.core.e.e = string2.replaceAll(",", " ");
                            String string4 = jSONObject.toString();
                            com.igexin.push.core.e.e.a().b(new n(jCurrentTimeMillis, string4, (byte) 2, com.igexin.push.core.e.u ? jCurrentTimeMillis : 0L));
                            com.igexin.push.d.c.o oVar = new com.igexin.push.d.c.o();
                            oVar.c = 128;
                            oVar.e = com.igexin.push.core.b.O;
                            oVar.f = string4;
                            com.igexin.push.core.d.a.f37984a.h.a("C-" + com.igexin.push.core.e.A, oVar, false);
                            com.igexin.c.a.c.a.a("settag", new Object[0]);
                            return;
                        } catch (Exception e2) {
                            com.igexin.c.a.c.a.a(e2);
                            return;
                        }
                    }
                    return;
                case 1:
                    if (com.igexin.push.config.d.l) {
                        int i = bundle.getInt("beginHour", 0);
                        int i2 = bundle.getInt("duration", 0);
                        com.igexin.push.core.e.l.getPackageName();
                        m.a(i, i2);
                        AssistPushManager.getInstance().setSilentTime(com.igexin.push.core.e.l, i, i2);
                        return;
                    }
                    return;
                case 2:
                    boolean z = com.igexin.push.config.d.j;
                    com.igexin.c.a.c.a.a("PushController onPushManagerMessage recevie action : sendMessage", new Object[0]);
                    if (com.igexin.push.config.d.j) {
                        String string5 = bundle.getString("taskid");
                        byte[] byteArray = bundle.getByteArray("extraData");
                        com.igexin.c.a.c.a.a("PushController receive broadcast msg data , task id : " + string5 + " ######@##@@@#", new Object[0]);
                        if (com.igexin.push.core.e.A != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            try {
                                jSONObject2.put("action", "sendmessage");
                                jSONObject2.put("id", String.valueOf(jCurrentTimeMillis2));
                                jSONObject2.put("cid", com.igexin.push.core.e.A);
                                jSONObject2.put("appid", com.igexin.push.core.e.f38001a);
                                jSONObject2.put("taskid", string5);
                                jSONObject2.put("extraData", Base64.encodeToString(byteArray, 0));
                                String string6 = jSONObject2.toString();
                                com.igexin.push.core.e.e.a().b(new n(jCurrentTimeMillis2, string6, (byte) 6, jCurrentTimeMillis2));
                                com.igexin.push.d.c.b bVar = new com.igexin.push.d.c.b();
                                bVar.c = 128;
                                bVar.b = (int) jCurrentTimeMillis2;
                                String str = com.igexin.push.core.e.A;
                                bVar.e = str;
                                bVar.f = string6;
                                bVar.g = byteArray;
                                bVar.h = str;
                                com.igexin.push.core.d.a.f37984a.h.a("C-" + com.igexin.push.core.e.A, bVar, false);
                                if (string5 == null || !string5.startsWith("4T5@S_")) {
                                    return;
                                }
                                com.igexin.c.a.c.a.a("PushController sending lbs report message : ".concat(String.valueOf(string6)), new Object[0]);
                                return;
                            } catch (Throwable th) {
                                com.igexin.c.a.c.a.a(th);
                                return;
                            }
                        }
                        return;
                    }
                    return;
                case 3:
                    if (com.igexin.push.config.d.m) {
                        int i3 = bundle.getInt("interval", 0);
                        com.igexin.push.core.e.l.getPackageName();
                        com.igexin.push.config.d.e = i3;
                        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.config.a.a().new AnonymousClass3(), false, true);
                        if (com.igexin.push.core.e.u) {
                            System.currentTimeMillis();
                            com.igexin.c.a.c.a.a("setHeartbeatInterval heartbeatReq", new Object[0]);
                            if (System.currentTimeMillis() - com.igexin.push.core.e.Y > 5000) {
                                com.igexin.push.core.e.Y = System.currentTimeMillis();
                                d();
                                f();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 4:
                    if (com.igexin.push.config.d.n) {
                        int i4 = bundle.getInt("submitTimeoutEvent", 0);
                        com.igexin.push.core.e.l.getPackageName();
                        com.igexin.push.config.d.f = i4;
                        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.config.a.a().new AnonymousClass4(), false, true);
                        return;
                    }
                    return;
                case 5:
                    boolean z2 = com.igexin.push.config.d.o;
                    int i5 = com.igexin.push.core.e.am;
                    if (!com.igexin.push.config.d.o || com.igexin.push.core.e.am > 200) {
                        return;
                    }
                    String string7 = bundle.getString("taskid");
                    String string8 = bundle.getString("messageid");
                    String string9 = bundle.getString("actionid");
                    String str2 = string7 + u15.f19942b + string8 + u15.f19942b + string9;
                    if (com.igexin.push.core.e.al.get(str2) == null) {
                        long jCurrentTimeMillis3 = System.currentTimeMillis();
                        PushTaskBean pushTaskBean = new PushTaskBean();
                        pushTaskBean.setTaskId(string7);
                        pushTaskBean.setMessageId(string8);
                        pushTaskBean.setAppid(com.igexin.push.core.e.f38001a);
                        FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean, string9);
                        com.igexin.push.core.e.am++;
                        com.igexin.push.core.e.al.put(str2, Long.valueOf(jCurrentTimeMillis3));
                        return;
                    }
                    return;
                case 6:
                    com.igexin.push.core.d dVar = com.igexin.push.core.d.a.f37984a;
                    if (com.igexin.push.core.e.l != null) {
                        com.igexin.push.core.d.d.a().a("p", Boolean.FALSE);
                        com.igexin.push.core.e.s = false;
                        com.igexin.push.core.e.v = false;
                        dVar.h.b();
                    }
                    AssistPushManager.getInstance().turnOffPush(com.igexin.push.core.e.l);
                    return;
                case 7:
                    String string10 = bundle.getString("alias");
                    String string11 = bundle.getString("sn");
                    com.igexin.c.a.c.a.a("PushController|onPushManagerMessage bindAlias...", new Object[0]);
                    if (TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                        com.igexin.c.a.c.a.d.a().a("bindAlias : " + string10 + ", failed, has not get clientid");
                        l.a().b(string11, "30005");
                        return;
                    }
                    long jCurrentTimeMillis4 = System.currentTimeMillis();
                    if (jCurrentTimeMillis4 - com.igexin.push.core.e.aa <= 1000) {
                        com.igexin.c.a.c.a.a("PushController|bindAlias frequently called", new Object[0]);
                        return;
                    }
                    String str3 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(jCurrentTimeMillis4));
                    if (!str3.equals(com.igexin.push.core.e.Z)) {
                        com.igexin.push.core.e.f.a().d(str3);
                        com.igexin.push.core.e.f.a().a(0);
                    }
                    int i6 = com.igexin.push.core.e.ab;
                    com.igexin.c.a.c.a.a("-> CoreRuntimeInfo.opAliasTimes:" + com.igexin.push.core.e.ab, new Object[0]);
                    if (com.igexin.push.core.e.ab < 100) {
                        com.igexin.c.a.c.a.a("start bindAlias ###", new Object[0]);
                        com.igexin.push.core.e.aa = jCurrentTimeMillis4;
                        com.igexin.push.core.e.f.a().a(com.igexin.push.core.e.ab + 1);
                        m.a(string10, string11, false, true);
                        return;
                    }
                    com.igexin.c.a.c.a.a("PushController|bindAlias times exceed", new Object[0]);
                    com.igexin.c.a.c.a.d.a().a("bindAlias : " + string10 + ", failed, , the number of calls per day cannot exceed 100");
                    l.a().b(string11, "30003");
                    return;
                case 8:
                    String string12 = bundle.getString("alias");
                    String string13 = bundle.getString("sn");
                    boolean z3 = bundle.getBoolean("isSeft");
                    com.igexin.c.a.c.a.a("PushController|onPushManagerMessage unbindAlias...", new Object[0]);
                    if (TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                        com.igexin.c.a.c.a.d.a().a("unbindAlias : " + string12 + ", failed, has not get clientid");
                        l.a().c(string13, "30005");
                        return;
                    }
                    if (z3 && TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                        return;
                    }
                    long jCurrentTimeMillis5 = System.currentTimeMillis();
                    if (jCurrentTimeMillis5 - com.igexin.push.core.e.aa <= 1000) {
                        com.igexin.c.a.c.a.a("PushController|unbindAlias frequently called", new Object[0]);
                        return;
                    }
                    String str4 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(jCurrentTimeMillis5));
                    if (!str4.equals(com.igexin.push.core.e.Z)) {
                        com.igexin.push.core.e.f.a().d(str4);
                        com.igexin.push.core.e.f.a().a(0);
                    }
                    if (com.igexin.push.core.e.ab < 100) {
                        com.igexin.c.a.c.a.a("start unbindAlias ###", new Object[0]);
                        com.igexin.push.core.e.aa = jCurrentTimeMillis5;
                        com.igexin.push.core.e.f.a().a(com.igexin.push.core.e.ab + 1);
                        m.a(string12, string13, true, z3);
                        return;
                    }
                    com.igexin.c.a.c.a.a("PushController|unbindAlias times exceed", new Object[0]);
                    com.igexin.c.a.c.a.d.a().a("unbindAlias : " + string12 + ", failed, , the number of calls per day cannot exceed 100");
                    l.a().c(string13, "30003");
                    return;
                case 9:
                    String string14 = bundle.getString("url");
                    boolean z4 = com.igexin.push.config.d.E;
                    if (TextUtils.isEmpty(string14)) {
                        return;
                    }
                    try {
                        Uri uri = Uri.parse(string14);
                        String host = uri.getHost();
                        String queryParameter = uri.getQueryParameter("p");
                        if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(queryParameter)) {
                            if (!com.igexin.push.config.d.E) {
                                com.igexin.c.a.c.a.a("PushController|isApplinkFeedback is false, not feedback", new Object[0]);
                                return;
                            }
                            if (!com.igexin.push.g.c.c(host)) {
                                com.igexin.c.a.c.a.a("PushController|checkIsWhiteApplinkDomain is false, not feedback", new Object[0]);
                                return;
                            }
                            com.igexin.c.a.c.a.a("PushController|isApplinkFeedback is true and checkIsWhiteApplinkDomain is true, to feedback", new Object[0]);
                            PushTaskBean pushTaskBean2 = new PushTaskBean();
                            pushTaskBean2.setTaskId("getuiapplinkup");
                            pushTaskBean2.setMessageId(queryParameter);
                            pushTaskBean2.setAppid(com.igexin.push.core.e.f38001a);
                            FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean2, PushConsts.SEND_MESSAGE_ERROR);
                            return;
                        }
                        com.igexin.c.a.c.a.a("PushController|url " + string14 + " is invalid", new Object[0]);
                        return;
                    } catch (Exception e3) {
                        com.igexin.c.a.c.a.a(e3);
                        com.igexin.c.a.c.a.a("PushController|" + e3.toString(), new Object[0]);
                        return;
                    }
                case 10:
                    com.igexin.push.g.d.a(bundle.getInt("badgeNum"), true);
                    return;
                case 11:
                    com.igexin.push.g.d.b(bundle.getInt("badgeNum"), true);
                    return;
                case 12:
                    com.igexin.push.g.d.c(bundle.getInt("badgeNum"), true);
                    return;
                case 13:
                    if (!com.igexin.push.g.n.d().equalsIgnoreCase(AssistUtils.BRAND_HW) && !com.igexin.push.g.n.d().equalsIgnoreCase(AssistUtils.BRAND_HON)) {
                        if (com.igexin.push.g.n.d().equalsIgnoreCase("oppo")) {
                            com.igexin.push.g.d.c(bundle.getInt("badgeNum"), true);
                            return;
                        } else {
                            if (com.igexin.push.g.n.d().equalsIgnoreCase("vivo")) {
                                com.igexin.push.g.d.b(bundle.getInt("badgeNum"), true);
                                return;
                            }
                            return;
                        }
                    }
                    com.igexin.push.g.d.a(bundle.getInt("badgeNum"), true);
                    return;
                case 14:
                case 15:
                    com.igexin.push.core.e.a();
                    return;
                case 16:
                    com.igexin.push.core.e.aK = bundle.getString("smallIcon", "");
                    com.igexin.push.core.e.aL = bundle.getString("largeIcon", "");
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.core.e.f.a().new AnonymousClass20(com.igexin.push.core.e.aK, com.igexin.push.core.e.aL), false, true);
                    com.igexin.c.a.c.a.d.a().a("[PushController] setNotificationIcon success");
                    return;
                case 17:
                    String string15 = bundle.getString("sn");
                    if (TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                        return;
                    }
                    if (System.currentTimeMillis() - com.igexin.push.core.e.c < com.igexin.push.config.d.f37910a * 1000 && com.igexin.push.core.e.d != null) {
                        com.igexin.c.a.c.a.a("PushController|query tag already cache, tag = " + com.igexin.push.core.e.d, new Object[0]);
                        l.a().a(string15, "0", com.igexin.push.core.e.d);
                        return;
                    }
                    try {
                        long jCurrentTimeMillis6 = System.currentTimeMillis();
                        JSONObject jSONObject3 = new JSONObject();
                        try {
                            jSONObject3.put("action", "query_tag");
                            jSONObject3.put("id", String.valueOf(jCurrentTimeMillis6));
                            jSONObject3.put("cid", com.igexin.push.core.e.A);
                            jSONObject3.put("appid", com.igexin.push.core.e.f38001a);
                            jSONObject3.put("sn", string15);
                            break;
                        } catch (Exception e4) {
                            com.igexin.c.a.c.a.a(e4);
                        }
                        String string16 = jSONObject3.toString();
                        com.igexin.push.core.e.e.a().b(new n(jCurrentTimeMillis6, string16, (byte) 11, jCurrentTimeMillis6));
                        com.igexin.push.d.c.o oVar2 = new com.igexin.push.d.c.o();
                        oVar2.c = 128;
                        oVar2.e = com.igexin.push.core.b.O;
                        oVar2.f = string16;
                        com.igexin.push.core.d.a.f37984a.h.a("C-" + com.igexin.push.core.e.A, oVar2, false);
                        com.igexin.push.core.e.f fVarA = com.igexin.push.core.e.f.a();
                        if (com.igexin.push.core.e.c != jCurrentTimeMillis6) {
                            com.igexin.push.core.e.c = jCurrentTimeMillis6;
                            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) fVarA.new AnonymousClass21(), false, true);
                        }
                        com.igexin.c.a.c.a.a("PushController｜queryTag", new Object[0]);
                        return;
                    } catch (Exception e5) {
                        com.igexin.c.a.c.a.a(e5);
                        return;
                    }
                case 18:
                    l.a().b();
                    return;
                case 19:
                    try {
                        String string17 = bundle.getString("token", "");
                        if (!TextUtils.isEmpty(string17) && com.igexin.push.core.e.b().booleanValue() && !string17.equals(com.igexin.push.core.e.I)) {
                            com.igexin.push.core.e.f.a().b(string17);
                            if (com.igexin.push.core.e.u) {
                                com.igexin.c.a.c.a.b("PushController", "online, send addphoneinfo");
                                d().i();
                            }
                        }
                        com.igexin.c.a.c.a.d.a().a("[PushController] setDeviceToken success ".concat(String.valueOf(string17)));
                        return;
                    } catch (Throwable th2) {
                        com.igexin.c.a.c.a.a(th2);
                        return;
                    }
                case 20:
                    com.igexin.push.config.e.a(bundle.getBoolean("guardMe", true), bundle.getBoolean("guardOthers", true));
                    com.igexin.push.core.e.a();
                    com.igexin.c.a.c.a.d.a().a("[PushController] setGuardOptions success");
                    return;
                case 21:
                    boolean z5 = bundle.getBoolean(AuthConstant.INI_ENABLE, true);
                    com.igexin.push.config.e.a(z5, z5);
                    com.igexin.push.core.e.a();
                    com.igexin.c.a.c.a.d.a().a("[PushController] setLinkMerge success");
                    return;
                default:
                    return;
            }
            com.igexin.c.a.c.a.a(th);
        } catch (Throwable th3) {
            com.igexin.c.a.c.a.a(th3);
        }
    }

    public static void a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", com.igexin.push.core.b.F);
            jSONObject.put("id", str);
        } catch (JSONException e) {
            com.igexin.c.a.c.a.a(e);
        }
        String string = jSONObject.toString();
        com.igexin.push.d.c.o oVar = new com.igexin.push.d.c.o();
        oVar.c = 128;
        ((com.igexin.push.d.c.b) oVar).b = (int) System.currentTimeMillis();
        oVar.e = com.igexin.push.core.b.O;
        oVar.f = string;
        oVar.h = com.igexin.push.core.e.A;
        com.igexin.push.core.d.a.f37984a.h.a("C-" + com.igexin.push.core.e.A, oVar, false);
    }

    @TargetApi(12)
    private static void a(String str, String str2, String str3, String str4) {
        l.a().a(str, str2, str3, str4);
    }

    public static boolean a(String str, String str2, String str3) {
        return com.igexin.push.core.n.a().a(str, str2, str3);
    }

    private static boolean a(JSONObject jSONObject, PushTaskBean pushTaskBean) {
        return com.igexin.push.core.n.a().a(jSONObject, pushTaskBean);
    }

    public static void b(Intent intent) {
        if (intent == null || !intent.hasExtra("isSlave")) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("isSlave", false);
        com.igexin.c.a.c.a.a("CoreAction|onServiceInitializeForSlave isSlave =".concat(String.valueOf(booleanExtra)), new Object[0]);
        if (booleanExtra) {
            com.igexin.push.core.d unused = com.igexin.push.core.d.a.f37984a;
            com.igexin.push.core.d.a(true);
            com.igexin.push.core.e.N = intent.hasExtra("op_app") ? intent.getStringExtra("op_app") : "";
            if (com.igexin.push.core.e.u) {
                l.a().c();
            }
        }
    }

    public static void b(String str) {
        com.igexin.c.a.c.a.a("CoreAction|resetDelayTime from = ".concat(String.valueOf(str)), new Object[0]);
        long j = com.igexin.push.core.e.O;
        if (j <= 10000 && j != 0) {
            com.igexin.c.a.c.a.a("CoreAction|resetDelayTime ignore, delay = " + com.igexin.push.core.e.O, new Object[0]);
            return;
        }
        int iRandom = (int) ((Math.random() * 100.0d) + 1000.0d);
        long j2 = com.igexin.push.core.e.O;
        com.igexin.c.a.c.a.a("CoreAction|reConnectDelayTime = " + com.igexin.push.core.e.O + ", reset = " + iRandom, new Object[0]);
        com.igexin.push.f.b.e.g().a((long) iRandom);
    }

    private static void c(Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return;
        }
        try {
            String action = intent.getAction();
            if (PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(action)) {
                e();
                return;
            }
            if (com.igexin.push.core.b.L.equals(action)) {
                com.igexin.push.core.n.a().a(intent);
                return;
            }
            if (com.igexin.push.core.b.N.equals(action)) {
                if (com.igexin.push.config.d.c != 0) {
                    com.igexin.push.f.f.a().d();
                }
            } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                com.igexin.push.core.e.y = 1;
                com.igexin.push.f.a.a().a(true);
                b("screen on");
            } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                com.igexin.push.core.e.y = 0;
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public static b d() {
        if (d == null) {
            synchronized (b.class) {
                if (d == null) {
                    d = new b();
                }
            }
        }
        return d;
    }

    public static void e() {
        com.igexin.push.core.d unused = com.igexin.push.core.d.a.f37984a;
        com.igexin.push.e.a.d();
        com.igexin.c.a.c.a.a("CoreAction|network changed check condition status", new Object[0]);
        com.igexin.push.f.a.a().a(true);
    }

    public static int f() {
        com.igexin.c.a.c.a.a("CoreAction|send heart beat data ........", new Object[0]);
        return com.igexin.push.core.d.a.f37984a.h.a("H-" + com.igexin.push.core.e.A, new com.igexin.push.d.c.f(), true);
    }

    public static void g() {
        try {
            for (n nVar : com.igexin.push.core.e.e.a().f38007a) {
                if (nVar.e >= com.igexin.push.config.d.N - 1) {
                    com.igexin.c.a.c.a.a("CoreAction|data.getSendTimes=" + nVar.e + " id=" + nVar.f37966a, new Object[0]);
                } else if (nVar.d + 20000 <= System.currentTimeMillis()) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject(nVar.b);
                    com.igexin.push.d.c.b bVar = new com.igexin.push.d.c.b();
                    bVar.c = 128;
                    bVar.b = (int) jCurrentTimeMillis;
                    bVar.e = com.igexin.push.core.b.O;
                    if (jSONObject.has("extraData")) {
                        bVar.g = Base64.decode(jSONObject.optString("extraData").getBytes(), 0);
                        jSONObject.remove("extraData");
                    }
                    bVar.f = nVar.b;
                    bVar.h = com.igexin.push.core.e.A;
                    com.igexin.c.a.c.a.a("freshral|" + nVar.b, new Object[0]);
                    com.igexin.push.core.e.e eVarA = com.igexin.push.core.e.e.a();
                    long j = nVar.f37966a;
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    n nVarA = eVarA.a(j);
                    if (nVarA != null) {
                        nVarA.d = jCurrentTimeMillis2;
                        nVarA.e++;
                        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) eVarA.new AnonymousClass3(com.igexin.push.core.e.e.a(nVarA), j), true, true);
                    }
                    com.igexin.push.core.d.a.f37984a.h.a("C-" + com.igexin.push.core.e.A, bVar, false);
                    return;
                }
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public static void h() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", "request_deviceid");
            jSONObject.put("id", String.valueOf(jCurrentTimeMillis));
        } catch (JSONException e) {
            com.igexin.c.a.c.a.a(e);
        }
        String string = jSONObject.toString();
        com.igexin.push.d.c.b bVar = new com.igexin.push.d.c.b();
        bVar.c = 128;
        bVar.b = (int) jCurrentTimeMillis;
        bVar.e = com.igexin.push.core.b.O;
        bVar.f = string;
        bVar.h = com.igexin.push.core.e.A;
        com.igexin.push.core.d.a.f37984a.h.a("C-" + com.igexin.push.core.e.A, bVar, false);
        com.igexin.c.a.c.a.a("CoreAction|deviceidReq", new Object[0]);
    }

    public static void j() {
        if (!com.igexin.push.core.e.W || com.igexin.push.core.e.X >= System.currentTimeMillis()) {
            return;
        }
        com.igexin.push.core.e.f.a().a(false);
    }

    public static void k() {
        if (!com.igexin.push.core.e.ae) {
            com.igexin.push.core.e.ae = com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.f.b.b.g(), false, true);
        }
        if (!com.igexin.push.core.e.af) {
            com.igexin.push.core.e.af = com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.f.b.e.g(), true, true);
        }
        if (com.igexin.push.core.e.ag) {
            return;
        }
        com.igexin.push.core.d.a.f37984a.b();
    }

    private static boolean l() {
        return false;
    }

    private static void m() {
        com.igexin.push.g.c.d();
    }

    @Override // com.igexin.push.core.a.a
    public final void a() {
    }

    @Override // com.igexin.push.e.b
    public final boolean a(com.igexin.push.d.c.c cVar) {
        if (cVar == null) {
            return false;
        }
        a aVar = c.get(cVar.m);
        com.igexin.c.a.c.a.a("CoreAction|receive : " + cVar.getClass().getName() + " resp ~~~~", new Object[0]);
        if ((cVar instanceof h) || (cVar instanceof k) || (cVar instanceof com.igexin.push.d.c.m) || (cVar instanceof p) || (cVar instanceof com.igexin.push.d.c.f) || (cVar instanceof q)) {
            com.igexin.c.a.b.a.a.d.a().a(cVar.getClass().getName());
        }
        if ((cVar instanceof k) || (cVar instanceof com.igexin.push.d.c.m) || (cVar instanceof p)) {
            com.igexin.push.core.e.b(0L);
            com.igexin.push.c.c.a().d().b();
        }
        if (aVar != null) {
            aVar.a(cVar);
        }
        com.igexin.push.f.b.b.g().i();
        return true;
    }

    @Override // com.igexin.push.core.a.a
    public final boolean a(Object obj) {
        com.igexin.push.e.a aVar = com.igexin.push.core.d.a.f37984a.h;
        if ((obj instanceof com.igexin.push.d.c.c) && aVar != null) {
            com.igexin.push.e.a.a((com.igexin.push.d.c.c) obj);
        } else if (obj instanceof com.igexin.push.d.b.b) {
            com.igexin.c.a.c.a.a("CoreAction|TcpExceptionNotify###", new Object[0]);
            com.igexin.push.c.c.a().d().c();
            com.igexin.push.c.a aVarD = com.igexin.push.c.c.a().d();
            com.igexin.push.core.j.a().a(com.igexin.push.core.j.a.c);
            aVarD.f();
            if (com.igexin.push.e.a.e()) {
                com.igexin.c.a.c.a.a(com.igexin.push.e.a.f38112a, "sdkOn = false or pushOn = false, disconnect|user");
                com.igexin.c.a.c.a.a(com.igexin.push.e.a.f38112a + "|sdkOn = false or pushOn = false, disconnect|user", new Object[0]);
            } else {
                com.igexin.c.a.c.a.a(com.igexin.push.e.a.f38112a + "|disconnect by network", new Object[0]);
            }
            com.igexin.c.a.d.e<com.igexin.c.a.d.f> eVar = com.igexin.c.a.b.e.a().s;
            if (eVar != null) {
                eVar.a(com.igexin.c.a.b.a.a.f.class);
            }
            com.igexin.push.e.a.a(false);
        } else if (obj instanceof com.igexin.push.d.b.a) {
            com.igexin.c.a.c.a.a("CoreAction|TcpDisconnectSuccessNotify ###", new Object[0]);
            if (com.igexin.push.core.e.u) {
                com.igexin.push.core.e.u = false;
                com.igexin.c.a.c.a.a("CoreAction|broadcast online state = offline", new Object[0]);
                l.a().b();
            }
            com.igexin.push.d.a.c.b = -1;
            if (com.igexin.push.core.e.q) {
                com.igexin.c.a.c.a.a(com.igexin.push.e.a.f38112a, "isAppidWrong = true");
                com.igexin.c.a.c.a.a(com.igexin.push.e.a.f38112a + "|isAppidWrong = true", new Object[0]);
                com.igexin.c.a.c.a.d.a().a("isAppidWrong = true");
            } else if (!g.a()) {
                com.igexin.c.a.c.a.a(com.igexin.push.e.a.f38112a, "so error ++++++++");
                com.igexin.c.a.c.a.a(com.igexin.push.e.a.f38112a + "|so error ++++++++", new Object[0]);
            } else if (com.igexin.push.core.e.az) {
                com.igexin.push.e.a.c();
            } else {
                com.igexin.c.a.c.a.a(com.igexin.push.e.a.f38112a, "initSuccess = false");
                com.igexin.c.a.c.a.a(com.igexin.push.e.a.f38112a + "|initSuccess = false", new Object[0]);
            }
        }
        return false;
    }

    @Override // com.igexin.push.core.a.a
    public final void b() {
    }

    public final void i() {
        try {
            if ((System.currentTimeMillis() - com.igexin.push.core.e.Q) - 86400000 > 0) {
                com.igexin.push.core.e.f.a().b(0);
                com.igexin.push.core.e.f.a().c(System.currentTimeMillis());
            }
            com.igexin.c.a.c.a.b(b, "sendAddphoneinfo.deviceToken" + com.igexin.push.core.e.I);
            if (com.igexin.push.core.e.aA <= 7) {
                com.igexin.push.core.e.f.a().b(com.igexin.push.core.e.aA + 1);
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.f.d() { // from class: com.igexin.push.core.a.b.1
                    @Override // com.igexin.push.f.d
                    public final void b() {
                        com.igexin.push.g.n.m();
                        try {
                            com.igexin.push.core.b.a aVar = new com.igexin.push.core.b.a();
                            long j = aVar.n;
                            JSONObject jSONObject = new JSONObject();
                            String str = aVar.f37951a;
                            if (str == null) {
                                str = "";
                            }
                            jSONObject.put(ze1.k, str);
                            String str2 = aVar.b;
                            if (str2 == null) {
                                str2 = "";
                            }
                            jSONObject.put("sim", str2);
                            String str3 = aVar.c;
                            if (str3 == null) {
                                str3 = "";
                            }
                            jSONObject.put(DeviceIdType.IMEI, str3);
                            jSONObject.put("mac", aVar.d == null ? "" : com.igexin.push.g.n.c());
                            String str4 = aVar.e;
                            if (str4 == null) {
                                str4 = "";
                            }
                            jSONObject.put("version", str4);
                            String str5 = aVar.f;
                            if (str5 == null) {
                                str5 = "";
                            }
                            jSONObject.put("channelid", str5);
                            jSONObject.put("type", "ANDROID");
                            String str6 = aVar.k;
                            if (str6 == null) {
                                str6 = "";
                            }
                            jSONObject.put(NativeCallContext.DOMAIN_APP, str6);
                            StringBuilder sb = new StringBuilder("ANDROID-");
                            String str7 = aVar.g;
                            if (str7 == null) {
                                str7 = "";
                            }
                            sb.append(str7);
                            jSONObject.put("deviceid", sb.toString());
                            String str8 = aVar.l;
                            if (str8 == null) {
                                str8 = "";
                            }
                            jSONObject.put(RemoteMessageConst.DEVICE_TOKEN, str8);
                            String str9 = aVar.m;
                            if (str9 == null) {
                                str9 = "";
                            }
                            jSONObject.put("brand", str9);
                            String str10 = aVar.j;
                            if (str10 == null) {
                                str10 = "";
                            }
                            jSONObject.put("system_version", str10);
                            String str11 = aVar.i;
                            if (str11 == null) {
                                str11 = "";
                            }
                            jSONObject.put("cell", str11);
                            jSONObject.put("aid", com.igexin.push.g.n.h());
                            jSONObject.put("adid", com.igexin.push.g.n.i());
                            jSONObject.put("gtcid", TextUtils.isEmpty(aVar.o) ? "" : aVar.o);
                            String str12 = com.igexin.push.core.e.h;
                            if (str12 == null) {
                                str12 = "";
                            }
                            jSONObject.put(DeviceIdType.OAID, str12);
                            ServiceManager.getInstance();
                            String strE = ServiceManager.e(com.igexin.push.core.e.l);
                            if (!com.igexin.push.core.b.ap.equals(strE)) {
                                jSONObject.put(o.f38157a, strE);
                            }
                            ServiceManager.getInstance();
                            jSONObject.put("ua", ServiceManager.d(com.igexin.push.core.e.l));
                            jSONObject.put("notification_enabled", com.igexin.push.g.c.b(com.igexin.push.core.e.l) ? 1 : 0);
                            jSONObject.put("installChannel", com.igexin.c.b.a.b(com.igexin.push.core.e.b, "").replaceAll("\\|", ""));
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("action", "addphoneinfo");
                            jSONObject2.put("id", String.valueOf(aVar.n));
                            jSONObject2.put(AliyunLogCommon.LogLevel.INFO, jSONObject);
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("guardMe", String.valueOf(com.igexin.push.config.e.b()));
                            jSONObject3.put("guardOthers", String.valueOf(com.igexin.push.config.e.c()));
                            jSONObject2.put("extra", jSONObject3);
                            String string = jSONObject2.toString();
                            com.igexin.c.a.c.a.a("addphoneinfo |  ".concat(String.valueOf(string)), new Object[0]);
                            com.igexin.push.core.e.e eVarA = com.igexin.push.core.e.e.a();
                            if (eVarA != null) {
                                eVarA.b(new n(j, string, (byte) 5, j));
                            }
                            com.igexin.push.d.c.b bVar = new com.igexin.push.d.c.b();
                            bVar.c = 128;
                            bVar.b = (int) j;
                            bVar.e = com.igexin.push.core.b.O;
                            bVar.f = string;
                            bVar.h = com.igexin.push.core.e.A;
                            com.igexin.push.core.d.a.f37984a.h.a("C-" + com.igexin.push.core.e.A, bVar, false);
                            if (com.igexin.c.b.a.a(com.igexin.push.core.e.K, com.igexin.push.core.e.I)) {
                                return;
                            }
                            com.igexin.push.core.e.f.a().c(com.igexin.push.core.e.I);
                        } catch (Throwable th) {
                            com.igexin.c.a.c.a.a(th);
                        }
                    }
                }, false, true);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }
}
