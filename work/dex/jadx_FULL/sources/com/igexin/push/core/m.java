package com.igexin.push.core;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.ariver.kernel.common.log.PageLog;
import com.aliyun.credentials.utils.AuthConstant;
import com.igexin.assist.sdk.AssistPushManager;
import com.igexin.assist.util.AssistUtils;
import com.igexin.push.config.a.AnonymousClass3;
import com.igexin.push.config.a.AnonymousClass4;
import com.igexin.push.core.e.f.AnonymousClass20;
import com.igexin.push.core.e.f.AnonymousClass21;
import com.igexin.push.d.c.o;
import com.igexin.push.extension.mod.PushTaskBean;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.main.FeedbackImpl;
import com.zj.adlib.u15;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f38078a = "PushController";
    private static m b;

    private m() {
    }

    public static m a() {
        if (b == null) {
            b = new m();
        }
        return b;
    }

    private static void a(int i) {
        com.igexin.push.config.d.e = i;
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.config.a.a().new AnonymousClass3(), false, true);
        if (e.u) {
            System.currentTimeMillis();
            com.igexin.c.a.c.a.a("setHeartbeatInterval heartbeatReq", new Object[0]);
            if (System.currentTimeMillis() - e.Y > 5000) {
                e.Y = System.currentTimeMillis();
                com.igexin.push.core.a.b.d();
                com.igexin.push.core.a.b.f();
            }
        }
    }

    public static void a(int i, int i2) {
        com.igexin.push.config.d.b = i;
        com.igexin.push.config.d.c = i2;
        com.igexin.push.config.a.a().b();
        com.igexin.push.f.f.a().d();
        com.igexin.c.a.c.a.d.a().a("[PushController] setSilentTime success");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v9 */
    private static void a(Bundle bundle) {
        int i;
        int i2;
        String string = bundle.getString("action");
        com.igexin.c.a.c.a.a("PushController|action pushmanager action = ".concat(String.valueOf(string)), new Object[0]);
        if (TextUtils.isEmpty(string)) {
        }
        string.hashCode();
        byte b2 = -1;
        switch (string.hashCode()) {
            case -1710807787:
                if (string.equals("queryPushOnLine")) {
                    b2 = 0;
                }
                break;
            case -1673882831:
                if (string.equals("setVivoBadgeNum")) {
                    b2 = 1;
                }
                break;
            case -1411528570:
                if (string.equals("setNotificationIcon")) {
                    b2 = 2;
                }
                break;
            case -1166665294:
                if (string.equals(PushConsts.QUERY_TAG)) {
                    b2 = 3;
                }
                break;
            case -1092138459:
                if (string.equals("setOppoBadgeNum")) {
                    b2 = 4;
                }
                break;
            case -957964269:
                if (string.equals("bindAlias")) {
                    b2 = 5;
                }
                break;
            case -908867308:
                if (string.equals("setHwBadgeNum")) {
                    b2 = 6;
                }
                break;
            case -905799720:
                if (string.equals("setTag")) {
                    b2 = 7;
                }
                break;
            case -889524838:
                if (string.equals("unbindAlias")) {
                    b2 = 8;
                }
                break;
            case -850755092:
                if (string.equals("turnOffPush")) {
                    b2 = 9;
                }
                break;
            case -479268212:
                if (string.equals("registerPushActivity")) {
                    b2 = 10;
                }
                break;
            case -344351336:
                if (string.equals("sendApplinkFeedback")) {
                    b2 = 11;
                }
                break;
            case -159289499:
                if (string.equals("setBadgeNum")) {
                    b2 = 12;
                }
                break;
            case -101965284:
                if (string.equals("setLinkMerge")) {
                    b2 = 13;
                }
                break;
            case -12797509:
                if (string.equals("setGuardOptions")) {
                    b2 = com.google.common.base.a.p;
                }
                break;
            case 329771905:
                if (string.equals("setDeviceToken")) {
                    b2 = com.google.common.base.a.q;
                }
                break;
            case 495464132:
                if (string.equals("setSilentTime")) {
                    b2 = com.google.common.base.a.r;
                }
                break;
            case 539767084:
                if (string.equals("setSocketTimeout")) {
                    b2 = 17;
                }
                break;
            case 556182983:
                if (string.equals("registerUserService")) {
                    b2 = com.google.common.base.a.u;
                }
                break;
            case 691453791:
                if (string.equals("sendMessage")) {
                    b2 = 19;
                }
                break;
            case 999002527:
                if (string.equals("setHeartbeatInterval")) {
                    b2 = com.google.common.base.a.x;
                }
                break;
            case 1841202202:
                if (string.equals("sendFeedbackMessage")) {
                    b2 = com.google.common.base.a.y;
                }
                break;
        }
        switch (b2) {
            case 0:
                l.a().b();
                break;
            case 1:
                com.igexin.push.g.d.b(bundle.getInt("badgeNum"), true);
                break;
            case 2:
                e.aK = bundle.getString("smallIcon", "");
                e.aL = bundle.getString("largeIcon", "");
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.core.e.f.a().new AnonymousClass20(e.aK, e.aL), false, true);
                com.igexin.c.a.c.a.d.a().a("[PushController] setNotificationIcon success");
                break;
            case 3:
                String string2 = bundle.getString("sn");
                if (!TextUtils.isEmpty(e.A)) {
                    if (System.currentTimeMillis() - e.c < com.igexin.push.config.d.f37910a * 1000 && e.d != null) {
                        com.igexin.c.a.c.a.a("PushController|query tag already cache, tag = " + e.d, new Object[0]);
                        l.a().a(string2, "0", e.d);
                    } else {
                        try {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("action", "query_tag");
                                jSONObject.put("id", String.valueOf(jCurrentTimeMillis));
                                jSONObject.put("cid", e.A);
                                jSONObject.put("appid", e.f38001a);
                                jSONObject.put("sn", string2);
                            } catch (Exception e) {
                                com.igexin.c.a.c.a.a(e);
                            }
                            String string3 = jSONObject.toString();
                            com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.n(jCurrentTimeMillis, string3, (byte) 11, jCurrentTimeMillis));
                            o oVar = new o();
                            oVar.c = 128;
                            oVar.e = b.O;
                            oVar.f = string3;
                            d.a.f37984a.h.a("C-" + e.A, oVar, false);
                            com.igexin.push.core.e.f fVarA = com.igexin.push.core.e.f.a();
                            if (e.c != jCurrentTimeMillis) {
                                e.c = jCurrentTimeMillis;
                                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) fVarA.new AnonymousClass21(), false, true);
                            }
                            com.igexin.c.a.c.a.a("PushController｜queryTag", new Object[0]);
                        } catch (Exception e2) {
                            com.igexin.c.a.c.a.a(e2);
                            return;
                        }
                    }
                }
                break;
            case 4:
                com.igexin.push.g.d.c(bundle.getInt("badgeNum"), true);
                break;
            case 5:
                String string4 = bundle.getString("alias");
                String string5 = bundle.getString("sn");
                com.igexin.c.a.c.a.a("PushController|onPushManagerMessage bindAlias...", new Object[0]);
                if (!TextUtils.isEmpty(e.A)) {
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    if (jCurrentTimeMillis2 - e.aa <= 1000) {
                        com.igexin.c.a.c.a.a("PushController|bindAlias frequently called", new Object[0]);
                    } else {
                        String str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(jCurrentTimeMillis2));
                        if (str.equals(e.Z)) {
                            i = 0;
                        } else {
                            com.igexin.push.core.e.f.a().d(str);
                            i = 0;
                            com.igexin.push.core.e.f.a().a(0);
                        }
                        int i3 = e.ab;
                        com.igexin.c.a.c.a.a("-> CoreRuntimeInfo.opAliasTimes:" + e.ab, new Object[i]);
                        if (e.ab >= 100) {
                            com.igexin.c.a.c.a.a("PushController|bindAlias times exceed", new Object[i]);
                            com.igexin.c.a.c.a.d.a().a("bindAlias : " + string4 + ", failed, , the number of calls per day cannot exceed 100");
                            l.a().b(string5, "30003");
                        } else {
                            com.igexin.c.a.c.a.a("start bindAlias ###", new Object[i]);
                            e.aa = jCurrentTimeMillis2;
                            com.igexin.push.core.e.f.a().a(e.ab + 1);
                            a(string4, string5, i, true);
                        }
                    }
                } else {
                    com.igexin.c.a.c.a.d.a().a("bindAlias : " + string4 + ", failed, has not get clientid");
                    l.a().b(string5, "30005");
                }
                break;
            case 6:
                com.igexin.push.g.d.a(bundle.getInt("badgeNum"), true);
                break;
            case 7:
                if (com.igexin.push.config.d.k) {
                    String string6 = bundle.getString(PageLog.PAGE_LOG_TAGS);
                    String string7 = bundle.getString("sn");
                    if (TextUtils.isEmpty(e.A)) {
                        com.igexin.c.a.c.a.d.a().a("setTag : " + string6 + ", failed, has not get clientid");
                        l.a().a(string7, "20008");
                    } else {
                        try {
                            long jCurrentTimeMillis3 = System.currentTimeMillis();
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("action", "set_tag");
                                jSONObject2.put("id", String.valueOf(jCurrentTimeMillis3));
                                jSONObject2.put("cid", e.A);
                                jSONObject2.put("appid", e.f38001a);
                                jSONObject2.put(PageLog.PAGE_LOG_TAGS, URLEncoder.encode(string6, "utf-8"));
                                jSONObject2.put("sn", string7);
                            } catch (Exception e3) {
                                com.igexin.c.a.c.a.a(e3);
                            }
                            e.e = string6.replaceAll(",", " ");
                            String string8 = jSONObject2.toString();
                            com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.n(jCurrentTimeMillis3, string8, (byte) 2, e.u ? jCurrentTimeMillis3 : 0L));
                            o oVar2 = new o();
                            oVar2.c = 128;
                            oVar2.e = b.O;
                            oVar2.f = string8;
                            d.a.f37984a.h.a("C-" + e.A, oVar2, false);
                            com.igexin.c.a.c.a.a("settag", new Object[0]);
                        } catch (Exception e4) {
                            com.igexin.c.a.c.a.a(e4);
                            return;
                        }
                    }
                }
                break;
            case 8:
                String string9 = bundle.getString("alias");
                String string10 = bundle.getString("sn");
                boolean z = bundle.getBoolean("isSeft");
                com.igexin.c.a.c.a.a("PushController|onPushManagerMessage unbindAlias...", new Object[0]);
                if (TextUtils.isEmpty(e.A)) {
                    com.igexin.c.a.c.a.d.a().a("unbindAlias : " + string9 + ", failed, has not get clientid");
                    l.a().c(string10, "30005");
                } else if (!z || !TextUtils.isEmpty(e.A)) {
                    long jCurrentTimeMillis4 = System.currentTimeMillis();
                    if (jCurrentTimeMillis4 - e.aa <= 1000) {
                        com.igexin.c.a.c.a.a("PushController|unbindAlias frequently called", new Object[0]);
                    } else {
                        String str2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(jCurrentTimeMillis4));
                        if (str2.equals(e.Z)) {
                            i2 = 0;
                        } else {
                            com.igexin.push.core.e.f.a().d(str2);
                            i2 = 0;
                            com.igexin.push.core.e.f.a().a(0);
                        }
                        if (e.ab >= 100) {
                            com.igexin.c.a.c.a.a("PushController|unbindAlias times exceed", new Object[i2]);
                            com.igexin.c.a.c.a.d.a().a("unbindAlias : " + string9 + ", failed, , the number of calls per day cannot exceed 100");
                            l.a().c(string10, "30003");
                        } else {
                            com.igexin.c.a.c.a.a("start unbindAlias ###", new Object[i2]);
                            e.aa = jCurrentTimeMillis4;
                            com.igexin.push.core.e.f.a().a(e.ab + 1);
                            a(string9, string10, true, z);
                        }
                    }
                }
                break;
            case 9:
                d dVar = d.a.f37984a;
                if (e.l != null) {
                    com.igexin.push.core.d.d.a().a("p", Boolean.FALSE);
                    e.s = false;
                    e.v = false;
                    dVar.h.b();
                }
                AssistPushManager.getInstance().turnOffPush(e.l);
                break;
            case 10:
            case 18:
                e.a();
                break;
            case 11:
                String string11 = bundle.getString("url");
                boolean z2 = com.igexin.push.config.d.E;
                if (!TextUtils.isEmpty(string11)) {
                    try {
                        Uri uri = Uri.parse(string11);
                        String host = uri.getHost();
                        String queryParameter = uri.getQueryParameter("p");
                        if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(queryParameter)) {
                            if (!com.igexin.push.config.d.E) {
                                com.igexin.c.a.c.a.a("PushController|isApplinkFeedback is false, not feedback", new Object[0]);
                            } else if (!com.igexin.push.g.c.c(host)) {
                                com.igexin.c.a.c.a.a("PushController|checkIsWhiteApplinkDomain is false, not feedback", new Object[0]);
                            } else {
                                com.igexin.c.a.c.a.a("PushController|isApplinkFeedback is true and checkIsWhiteApplinkDomain is true, to feedback", new Object[0]);
                                PushTaskBean pushTaskBean = new PushTaskBean();
                                pushTaskBean.setTaskId("getuiapplinkup");
                                pushTaskBean.setMessageId(queryParameter);
                                pushTaskBean.setAppid(e.f38001a);
                                FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean, PushConsts.SEND_MESSAGE_ERROR);
                            }
                        }
                        com.igexin.c.a.c.a.a("PushController|url " + string11 + " is invalid", new Object[0]);
                    } catch (Exception e5) {
                        com.igexin.c.a.c.a.a(e5);
                        com.igexin.c.a.c.a.a("PushController|" + e5.toString(), new Object[0]);
                        return;
                    }
                }
                break;
            case 12:
                if (com.igexin.push.g.n.d().equalsIgnoreCase(AssistUtils.BRAND_HW) || com.igexin.push.g.n.d().equalsIgnoreCase(AssistUtils.BRAND_HON)) {
                    com.igexin.push.g.d.a(bundle.getInt("badgeNum"), true);
                } else if (com.igexin.push.g.n.d().equalsIgnoreCase("oppo")) {
                    com.igexin.push.g.d.c(bundle.getInt("badgeNum"), true);
                } else if (com.igexin.push.g.n.d().equalsIgnoreCase("vivo")) {
                    com.igexin.push.g.d.b(bundle.getInt("badgeNum"), true);
                }
                break;
            case 13:
                boolean z3 = bundle.getBoolean(AuthConstant.INI_ENABLE, true);
                com.igexin.push.config.e.a(z3, z3);
                e.a();
                com.igexin.c.a.c.a.d.a().a("[PushController] setLinkMerge success");
                break;
            case 14:
                com.igexin.push.config.e.a(bundle.getBoolean("guardMe", true), bundle.getBoolean("guardOthers", true));
                e.a();
                com.igexin.c.a.c.a.d.a().a("[PushController] setGuardOptions success");
                break;
            case 15:
                try {
                    String string12 = bundle.getString("token", "");
                    if (!TextUtils.isEmpty(string12) && e.b().booleanValue() && !string12.equals(e.I)) {
                        com.igexin.push.core.e.f.a().b(string12);
                        if (e.u) {
                            com.igexin.c.a.c.a.b(f38078a, "online, send addphoneinfo");
                            com.igexin.push.core.a.b.d().i();
                        }
                    }
                    com.igexin.c.a.c.a.d.a().a("[PushController] setDeviceToken success ".concat(String.valueOf(string12)));
                } catch (Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                    return;
                }
                break;
            case 16:
                if (com.igexin.push.config.d.l) {
                    int i4 = bundle.getInt("beginHour", 0);
                    int i5 = bundle.getInt("duration", 0);
                    e.l.getPackageName();
                    a(i4, i5);
                    AssistPushManager.getInstance().setSilentTime(e.l, i4, i5);
                }
                break;
            case 17:
                if (com.igexin.push.config.d.n) {
                    int i6 = bundle.getInt("submitTimeoutEvent", 0);
                    e.l.getPackageName();
                    com.igexin.push.config.d.f = i6;
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.config.a.a().new AnonymousClass4(), false, true);
                }
                break;
            case 19:
                boolean z4 = com.igexin.push.config.d.j;
                com.igexin.c.a.c.a.a("PushController onPushManagerMessage recevie action : sendMessage", new Object[0]);
                if (com.igexin.push.config.d.j) {
                    String string13 = bundle.getString("taskid");
                    byte[] byteArray = bundle.getByteArray("extraData");
                    com.igexin.c.a.c.a.a("PushController receive broadcast msg data , task id : " + string13 + " ######@##@@@#", new Object[0]);
                    if (e.A != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        long jCurrentTimeMillis5 = System.currentTimeMillis();
                        try {
                            jSONObject3.put("action", "sendmessage");
                            jSONObject3.put("id", String.valueOf(jCurrentTimeMillis5));
                            jSONObject3.put("cid", e.A);
                            jSONObject3.put("appid", e.f38001a);
                            jSONObject3.put("taskid", string13);
                            jSONObject3.put("extraData", Base64.encodeToString(byteArray, 0));
                            String string14 = jSONObject3.toString();
                            com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.n(jCurrentTimeMillis5, string14, (byte) 6, jCurrentTimeMillis5));
                            com.igexin.push.d.c.b bVar = new com.igexin.push.d.c.b();
                            bVar.c = 128;
                            bVar.b = (int) jCurrentTimeMillis5;
                            String str3 = e.A;
                            bVar.e = str3;
                            bVar.f = string14;
                            bVar.g = byteArray;
                            bVar.h = str3;
                            d.a.f37984a.h.a("C-" + e.A, bVar, false);
                            if (string13 != null && string13.startsWith("4T5@S_")) {
                                com.igexin.c.a.c.a.a("PushController sending lbs report message : ".concat(String.valueOf(string14)), new Object[0]);
                                break;
                            }
                        } catch (Throwable th2) {
                            com.igexin.c.a.c.a.a(th2);
                            return;
                        }
                    }
                }
                break;
            case 20:
                if (com.igexin.push.config.d.m) {
                    int i7 = bundle.getInt("interval", 0);
                    e.l.getPackageName();
                    com.igexin.push.config.d.e = i7;
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.config.a.a().new AnonymousClass3(), false, true);
                    if (e.u) {
                        System.currentTimeMillis();
                        com.igexin.c.a.c.a.a("setHeartbeatInterval heartbeatReq", new Object[0]);
                        if (System.currentTimeMillis() - e.Y > 5000) {
                            e.Y = System.currentTimeMillis();
                            com.igexin.push.core.a.b.d();
                            com.igexin.push.core.a.b.f();
                        }
                    }
                }
                break;
            case 21:
                boolean z5 = com.igexin.push.config.d.o;
                int i8 = e.am;
                if (com.igexin.push.config.d.o && e.am <= 200) {
                    String string15 = bundle.getString("taskid");
                    String string16 = bundle.getString("messageid");
                    String string17 = bundle.getString("actionid");
                    String str4 = string15 + u15.f19942b + string16 + u15.f19942b + string17;
                    if (e.al.get(str4) == null) {
                        long jCurrentTimeMillis6 = System.currentTimeMillis();
                        PushTaskBean pushTaskBean2 = new PushTaskBean();
                        pushTaskBean2.setTaskId(string15);
                        pushTaskBean2.setMessageId(string16);
                        pushTaskBean2.setAppid(e.f38001a);
                        FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean2, string17);
                        e.am++;
                        e.al.put(str4, Long.valueOf(jCurrentTimeMillis6));
                    }
                    break;
                }
                break;
        }
    }

    private static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Uri uri = Uri.parse(str);
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
                PushTaskBean pushTaskBean = new PushTaskBean();
                pushTaskBean.setTaskId("getuiapplinkup");
                pushTaskBean.setMessageId(queryParameter);
                pushTaskBean.setAppid(e.f38001a);
                FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean, PushConsts.SEND_MESSAGE_ERROR);
                return;
            }
            com.igexin.c.a.c.a.a("PushController|url " + str + " is invalid", new Object[0]);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            com.igexin.c.a.c.a.a("PushController|" + e.toString(), new Object[0]);
        }
    }

    private static void a(String str, String str2) {
        if (TextUtils.isEmpty(e.A)) {
            com.igexin.c.a.c.a.d.a().a("setTag : " + str + ", failed, has not get clientid");
            l.a().a(str2, "20008");
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("action", "set_tag");
                jSONObject.put("id", String.valueOf(jCurrentTimeMillis));
                jSONObject.put("cid", e.A);
                jSONObject.put("appid", e.f38001a);
                jSONObject.put(PageLog.PAGE_LOG_TAGS, URLEncoder.encode(str, "utf-8"));
                jSONObject.put("sn", str2);
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
            e.e = str.replaceAll(",", " ");
            String string = jSONObject.toString();
            com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.n(jCurrentTimeMillis, string, (byte) 2, e.u ? jCurrentTimeMillis : 0L));
            o oVar = new o();
            oVar.c = 128;
            oVar.e = b.O;
            oVar.f = string;
            d.a.f37984a.h.a("C-" + e.A, oVar, false);
            com.igexin.c.a.c.a.a("settag", new Object[0]);
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    private static void a(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(e.A)) {
            com.igexin.c.a.c.a.d.a().a("unbindAlias : " + str + ", failed, has not get clientid");
            l.a().c(str2, "30005");
            return;
        }
        if (z && TextUtils.isEmpty(e.A)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - e.aa <= 1000) {
            com.igexin.c.a.c.a.a("PushController|unbindAlias frequently called", new Object[0]);
            return;
        }
        String str3 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(jCurrentTimeMillis));
        if (!str3.equals(e.Z)) {
            com.igexin.push.core.e.f.a().d(str3);
            com.igexin.push.core.e.f.a().a(0);
        }
        if (e.ab < 100) {
            com.igexin.c.a.c.a.a("start unbindAlias ###", new Object[0]);
            e.aa = jCurrentTimeMillis;
            com.igexin.push.core.e.f.a().a(e.ab + 1);
            a(str, str2, true, z);
            return;
        }
        com.igexin.c.a.c.a.a("PushController|unbindAlias times exceed", new Object[0]);
        com.igexin.c.a.c.a.d.a().a("unbindAlias : " + str + ", failed, , the number of calls per day cannot exceed 100");
        l.a().c(str2, "30003");
    }

    public static void a(String str, String str2, boolean z, boolean z2) {
        if (TextUtils.isEmpty(e.A)) {
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            String str3 = z ? "unbind_alias" : "bind_alias";
            byte b2 = z ? (byte) 8 : (byte) 7;
            try {
                jSONObject.put("action", str3);
                jSONObject.put("id", String.valueOf(jCurrentTimeMillis));
                jSONObject.put("cid", e.A);
                jSONObject.put("appid", e.f38001a);
                jSONObject.put("alias", str);
                jSONObject.put("sn", str2);
                if (z) {
                    jSONObject.put("is_self", z2);
                }
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
            String string = jSONObject.toString();
            com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.n(jCurrentTimeMillis, string, b2, e.u ? jCurrentTimeMillis : 0L));
            o oVar = new o();
            oVar.c = 128;
            oVar.e = b.O;
            oVar.f = string;
            d.a.f37984a.h.a("C-" + e.A, oVar, false);
            com.igexin.c.a.c.a.a(str3 + " = " + string, new Object[0]);
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    private static void a(String str, byte[] bArr) {
        if (e.A != null) {
            JSONObject jSONObject = new JSONObject();
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                jSONObject.put("action", "sendmessage");
                jSONObject.put("id", String.valueOf(jCurrentTimeMillis));
                jSONObject.put("cid", e.A);
                jSONObject.put("appid", e.f38001a);
                jSONObject.put("taskid", str);
                jSONObject.put("extraData", Base64.encodeToString(bArr, 0));
                String string = jSONObject.toString();
                com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.n(jCurrentTimeMillis, string, (byte) 6, jCurrentTimeMillis));
                com.igexin.push.d.c.b bVar = new com.igexin.push.d.c.b();
                bVar.c = 128;
                bVar.b = (int) jCurrentTimeMillis;
                String str2 = e.A;
                bVar.e = str2;
                bVar.f = string;
                bVar.g = bArr;
                bVar.h = str2;
                d.a.f37984a.h.a("C-" + e.A, bVar, false);
                if (str == null || !str.startsWith("4T5@S_")) {
                    return;
                }
                com.igexin.c.a.c.a.a("PushController sending lbs report message : ".concat(String.valueOf(string)), new Object[0]);
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    private static void b(int i) {
        com.igexin.push.config.d.f = i;
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.config.a.a().new AnonymousClass4(), false, true);
    }

    private static void b(String str) {
        if (TextUtils.isEmpty(e.A)) {
            return;
        }
        if (System.currentTimeMillis() - e.c < com.igexin.push.config.d.f37910a * 1000 && e.d != null) {
            com.igexin.c.a.c.a.a("PushController|query tag already cache, tag = " + e.d, new Object[0]);
            l.a().a(str, "0", e.d);
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("action", "query_tag");
                jSONObject.put("id", String.valueOf(jCurrentTimeMillis));
                jSONObject.put("cid", e.A);
                jSONObject.put("appid", e.f38001a);
                jSONObject.put("sn", str);
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
            String string = jSONObject.toString();
            com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.n(jCurrentTimeMillis, string, (byte) 11, jCurrentTimeMillis));
            o oVar = new o();
            oVar.c = 128;
            oVar.e = b.O;
            oVar.f = string;
            d.a.f37984a.h.a("C-" + e.A, oVar, false);
            com.igexin.push.core.e.f fVarA = com.igexin.push.core.e.f.a();
            if (e.c != jCurrentTimeMillis) {
                e.c = jCurrentTimeMillis;
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) fVarA.new AnonymousClass21(), false, true);
            }
            com.igexin.c.a.c.a.a("PushController｜queryTag", new Object[0]);
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    private static void b(String str, String str2) {
        if (TextUtils.isEmpty(e.A)) {
            com.igexin.c.a.c.a.d.a().a("bindAlias : " + str + ", failed, has not get clientid");
            l.a().b(str2, "30005");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - e.aa <= 1000) {
            com.igexin.c.a.c.a.a("PushController|bindAlias frequently called", new Object[0]);
            return;
        }
        String str3 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(jCurrentTimeMillis));
        if (!str3.equals(e.Z)) {
            com.igexin.push.core.e.f.a().d(str3);
            com.igexin.push.core.e.f.a().a(0);
        }
        int i = e.ab;
        com.igexin.c.a.c.a.a("-> CoreRuntimeInfo.opAliasTimes:" + e.ab, new Object[0]);
        if (e.ab < 100) {
            com.igexin.c.a.c.a.a("start bindAlias ###", new Object[0]);
            e.aa = jCurrentTimeMillis;
            com.igexin.push.core.e.f.a().a(e.ab + 1);
            a(str, str2, false, true);
            return;
        }
        com.igexin.c.a.c.a.a("PushController|bindAlias times exceed", new Object[0]);
        com.igexin.c.a.c.a.d.a().a("bindAlias : " + str + ", failed, , the number of calls per day cannot exceed 100");
        l.a().b(str2, "30003");
    }
}
