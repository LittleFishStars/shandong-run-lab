package com.byazt.nu;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import com.byazt.bog.a;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.ipd.dsp.internal.b1.b;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 137, 54})
public final class ve implements Function<SparseArray<Object>, Object> {
    public static final int CANCELED = -4;
    public static final int DOWNLOAD_COMPLETE_HANDLE = 11;
    public static final int FAILED = -1;
    public static final int START = 2;
    public static final int SUCCESSED = -3;
    public static final int TYPE_ACTIVE = 1;
    public static final int TYPE_COMPLETE = 3;
    public static final int TYPE_PREPARE = 4;
    public static final int TYPE_WAITING = 2;
    public static volatile ve c;
    public final Context tt;
    public Function<SparseArray<Object>, Object> ve;

    private ve(Context context) {
        this.tt = context;
    }

    public static ve getInstance() {
        return c;
    }

    public static ve instance(Context context) {
        if (c == null) {
            synchronized (ve.class) {
                if (c == null) {
                    c = new ve(context);
                }
            }
        }
        return c;
    }

    public static boolean isMaterialNotification(Context context) {
        TypedArray typedArrayObtainStyledAttributes;
        if (context == null) {
            return false;
        }
        try {
            int color = Color.parseColor("#7f0b0198");
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(c.ve(), new int[]{c.c(), c.tt()});
            try {
                if (color == typedArrayObtainStyledAttributes.getColor(0, 0)) {
                    try {
                        typedArrayObtainStyledAttributes.recycle();
                    } catch (Throwable unused) {
                    }
                    return true;
                }
            } catch (Throwable unused2) {
                if (typedArrayObtainStyledAttributes != null) {
                }
                return false;
            }
        } catch (Throwable unused3) {
            typedArrayObtainStyledAttributes = null;
        }
        try {
            typedArrayObtainStyledAttributes.recycle();
        } catch (Throwable unused4) {
        }
        return false;
    }

    private Map<String, Object> tt(Map<String, Object> map) {
        String strConcat;
        String str;
        String str2;
        String str3;
        if (map == null) {
            return null;
        }
        HashMap map2 = new HashMap();
        String str4 = (String) map.get("install_app_name");
        Bitmap bitmap = (Bitmap) map.get("install_icon_bitmap");
        String str5 = (String) map.get("install_action_type");
        Object obj = map.get("install_click_type");
        String str6 = (String) map.get("install_package_name");
        String str7 = (String) map.get("install_tag");
        String str8 = (String) map.get("install_value");
        String str9 = (String) map.get("install_log_extra");
        int iIntValue = obj != null ? ((Integer) obj).intValue() : -1;
        Object obj2 = map.get("install_download_id");
        int iIntValue2 = obj2 != null ? ((Integer) obj2).intValue() : -1;
        Object obj3 = map.get("install_enable_target_34");
        boolean zBooleanValue = obj3 != null ? ((Boolean) obj3).booleanValue() : false;
        RemoteViews remoteViews = new RemoteViews(this.tt.getPackageName(), this.tt.getResources().getIdentifier("tt_install_notification_layout", "layout", this.tt.getPackageName()));
        int iU = c.u();
        int iT = c.t();
        int iYp = c.yp();
        int iZ = c.z();
        int iM = c.m();
        if (iIntValue == 1) {
            strConcat = b.a.p.concat(String.valueOf(str4));
            str = "应用已安装完成";
            str2 = "去打开";
        } else {
            strConcat = "安装".concat(String.valueOf(str4));
            str = "应用已下载完成";
            str2 = "去安装";
        }
        String str10 = str;
        String str11 = strConcat;
        remoteViews.setTextViewText(iT, str10);
        remoteViews.setTextViewText(iYp, str11);
        remoteViews.setTextViewText(iZ, str2);
        int iZm = c.zm();
        if (iZm == 0 && (iZm = c.gr()) == 0) {
            iZm = c.qy();
        }
        int i = iZm;
        remoteViews.setImageViewIcon(iU, Icon.createWithBitmap(bitmap));
        PendingIntent pendingIntentC = c(str5, iIntValue, iIntValue2, zBooleanValue, str6, str7, str8, str9);
        remoteViews.setOnClickPendingIntent(iM, pendingIntentC);
        remoteViews.setOnClickPendingIntent(iZ, pendingIntentC);
        String str12 = "csj_" + this.tt.getPackageName();
        try {
            NotificationChannel notificationChannel = new NotificationChannel(str12, "csj_install", 4);
            notificationChannel.setShowBadge(true);
            notificationChannel.setBypassDnd(true);
            str3 = "notification";
            try {
                ((NotificationManager) this.tt.getSystemService(str3)).createNotificationChannel(notificationChannel);
            } catch (Throwable th) {
                th = th;
                a.c(th);
            }
        } catch (Throwable th2) {
            th = th2;
            str3 = "notification";
        }
        NotificationCompat.Builder builderC = c(str12);
        builderC.setStyle(new NotificationCompat.DecoratedCustomViewStyle()).setContentIntent(pendingIntentC).setSmallIcon(i).setContentTitle(str10).setContentText(str11).setPriority(1).setDefaults(-1).setVisibility(1).setAutoCancel(true);
        Notification notificationBuild = builderC.build();
        notificationBuild.contentView = remoteViews;
        map2.put(str3, notificationBuild);
        return map2;
    }

    /* JADX WARN: Code duplicated, block: B:252:0x04f5  */
    /* JADX WARN: Code duplicated, block: B:253:0x04f7  */
    /* JADX WARN: Code duplicated, block: B:256:0x0501  */
    private Map<String, Object> ve(Map<String, Object> map) {
        int i;
        String str;
        String str2;
        int i2;
        String str3;
        String str4;
        String str5;
        Object obj;
        String str6;
        int i3;
        int i4;
        int i5;
        RemoteViews remoteViews = new RemoteViews(this.tt.getPackageName(), this.tt.getResources().getIdentifier("tt_adl_notification_layout", "layout", this.tt.getPackageName()));
        HashMap map2 = new HashMap();
        Object obj2 = map.get("csj_enable_target_34");
        boolean zBooleanValue = obj2 != null ? ((Boolean) obj2).booleanValue() : false;
        int iDa = c.da();
        Object obj3 = map.get("notification_type");
        Object obj4 = map.get("notification_opt_2");
        int iZm = c.zm();
        int i6 = iZm != 0 ? iZm : 0;
        if ((obj3 instanceof Integer) && (obj4 instanceof Integer)) {
            int iC = c(((Integer) obj3).intValue(), ((Integer) obj4).intValue() == 1);
            remoteViews.setImageViewResource(iDa, iC);
            if (iC != 0 && iZm == 0) {
                i6 = iC;
            }
        }
        map2.put("builder_small_icon", Integer.valueOf(i6));
        Object obj5 = map.get("click_type");
        int iIntValue = obj5 instanceof Integer ? ((Integer) obj5).intValue() : 0;
        Object obj6 = map.get("click_download_id");
        int iIntValue2 = obj6 instanceof Integer ? ((Integer) obj6).intValue() : 0;
        int i7 = c.i();
        boolean z = obj4 instanceof Integer;
        String str7 = null;
        if (!z || ((Integer) obj4).intValue() == 1) {
            i = i7;
        } else {
            Object obj7 = map.get("action_click_btn");
            i = i7;
            remoteViews.setOnClickPendingIntent(i, c(obj7 instanceof String ? (String) obj7 : null, iIntValue, iIntValue2, zBooleanValue, null));
        }
        Object obj8 = map.get("action_apa");
        if (obj8 instanceof String) {
            map2.put("apa_click_content_intent", c((String) obj8, iIntValue, iIntValue2, zBooleanValue, null));
        }
        Object obj9 = map.get("action_complete");
        if (obj9 instanceof String) {
            map2.put("complete_click_content_intent", c((String) obj9, iIntValue, iIntValue2, zBooleanValue, null));
        }
        Object obj10 = map.get("action_hide");
        if (obj10 instanceof String) {
            map2.put("hide_click_content_intent", c((String) obj10, iIntValue, iIntValue2, zBooleanValue, null));
        }
        Object obj11 = map.get("enable_notification_ui");
        if (c(obj11)) {
            remoteViews.setInt(i, "setBackgroundResource", c.rl());
            remoteViews.setTextColor(i, -1);
        }
        Object obj12 = map.get("show_title");
        if (obj12 == null) {
            obj12 = "未命名";
        }
        if (obj12 instanceof String) {
            remoteViews.setTextViewText(c.sl(), (String) obj12);
        }
        int iA = c(obj11) ? c.a() : c.n();
        remoteViews.setViewVisibility(i, 0);
        Object obj13 = map.get("percent");
        Object obj14 = map.get("indeterminate");
        if (obj13 != null && obj14 != null) {
            remoteViews.setProgressBar(iA, 100, ((Integer) obj13).intValue(), ((Boolean) obj14).booleanValue());
        }
        if (c(obj11)) {
            Object obj15 = map.get("bitmap");
            if (obj15 != null) {
                remoteViews.setInt(iDa, "setBackgroundColor", 0);
                remoteViews.setImageViewBitmap(iDa, (Bitmap) obj15);
            } else {
                remoteViews.setInt(iDa, "setBackgroundResource", c.rl());
            }
        }
        int iX = c.x();
        int iSp = c.sp();
        int iRh = c.rh();
        Object obj16 = map.get("is_bind_app");
        boolean z2 = (obj16 instanceof Boolean) && ((Boolean) obj16).booleanValue();
        int iIntValue3 = ((Integer) obj3).intValue();
        String str8 = "";
        if (iIntValue3 == 1 || iIntValue3 == 4) {
            Object obj17 = map.get("download_size");
            str = obj17 instanceof String ? (String) obj17 : "";
            if (iIntValue3 == 1) {
                Object obj18 = map.get("download_status");
                if (obj18 instanceof Integer) {
                    if (((Integer) obj18).intValue() == 11) {
                        str2 = "处理中";
                    } else {
                        str8 = "正在下载";
                    }
                }
                remoteViews.setViewVisibility(iA, 0);
                remoteViews.setViewVisibility(iSp, 8);
                remoteViews.setViewVisibility(iX, 0);
                if (z2) {
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                remoteViews.setViewVisibility(i, i2);
                if (tt(obj11)) {
                    remoteViews.setViewVisibility(i, 8);
                }
                str3 = "暂停";
                str4 = null;
                str5 = str8;
            } else {
                str2 = "准备中";
            }
            str8 = str2;
            remoteViews.setViewVisibility(iA, 0);
            remoteViews.setViewVisibility(iSp, 8);
            remoteViews.setViewVisibility(iX, 0);
            if (z2) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            remoteViews.setViewVisibility(i, i2);
            if (tt(obj11)) {
                remoteViews.setViewVisibility(i, 8);
            }
            str3 = "暂停";
            str4 = null;
            str5 = str8;
        } else if (iIntValue3 == 2) {
            Object obj19 = map.get("download_size");
            str8 = obj19 instanceof String ? (String) obj19 : "";
            if (z) {
                if (((Integer) obj4).intValue() != 1) {
                    i4 = 8;
                    remoteViews.setViewVisibility(iX, 0);
                    i5 = tt(obj11) ? 0 : 8;
                } else if (((Integer) obj13).intValue() >= ((Integer) map.get("progress_70")).intValue()) {
                    i5 = 0;
                    remoteViews.setViewVisibility(iA, 0);
                    iA = iX;
                    i4 = 8;
                } else {
                    remoteViews.setViewVisibility(iA, 8);
                    remoteViews.setViewVisibility(iX, 8);
                    remoteViews.setViewVisibility(iSp, 0);
                    remoteViews.setViewVisibility(iRh, 8);
                    str5 = "下载暂停中，点击继续。";
                }
                remoteViews.setViewVisibility(iA, i5);
                remoteViews.setViewVisibility(iSp, i4);
                str5 = "暂停中";
            } else {
                str5 = "暂停中";
            }
            if (z2) {
                str = str8;
                str8 = "继续";
                remoteViews.setViewVisibility(i, 8);
                str4 = str7;
                str3 = str8;
            } else {
                remoteViews.setViewVisibility(i, 0);
                if (tt(obj11)) {
                    Object obj20 = map.get("download_size");
                    if (obj20 instanceof String) {
                        str8 = (String) obj20;
                    }
                }
                str4 = null;
                str = str8;
                str3 = "继续";
            }
        } else if (iIntValue3 == 3) {
            Object obj21 = map.get("download_status");
            boolean z3 = obj21 instanceof Integer;
            if (z3) {
                int iIntValue4 = ((Integer) obj21).intValue();
                Object obj22 = map.get("is_network_error");
                Object obj23 = map.get("is_insufficient_space_error");
                if (iIntValue4 == -1 || iIntValue4 == -4) {
                    if (tt(obj11) && iIntValue4 == -1 && (((obj22 instanceof Boolean) && ((Boolean) obj22).booleanValue()) || ((obj23 instanceof Boolean) && ((Boolean) obj23).booleanValue()))) {
                        Object obj24 = map.get("download_size");
                        if (obj24 instanceof String) {
                            str8 = (String) obj24;
                        }
                    }
                    remoteViews.setViewVisibility(iRh, 8);
                    Object obj25 = map.get("is_error_code_insufficient_space_error");
                    Object obj26 = map.get("is_need_show_wait_net_text");
                    if ((obj25 instanceof Boolean) && ((Boolean) obj25).booleanValue()) {
                        str6 = "SdCard空间不足, 下载失败。";
                    } else if ((obj26 instanceof Boolean) && ((Boolean) obj26).booleanValue()) {
                        Object obj27 = map.get("is_wait_wifi");
                        str6 = (obj27 instanceof Boolean) && ((Boolean) obj27).booleanValue() ? "等待wifi开始下载" : "等待网络继续下载";
                    } else {
                        str6 = "下载失败。";
                    }
                    remoteViews.setViewVisibility(i, 8);
                    if (tt(obj11) && iIntValue4 == -1) {
                        Object obj28 = map.get("is_net_work_error");
                        if ((obj28 instanceof Boolean) && ((Boolean) obj28).booleanValue()) {
                            Object obj29 = map.get("is_wait_wifi_and_in_net");
                            if ((obj29 instanceof Boolean) && ((Boolean) obj29).booleanValue()) {
                                str6 = "无Wi-Fi 已暂停";
                                str = str8;
                                str8 = "继续";
                            } else {
                                str6 = "下载异常，请检查网络";
                            }
                        } else if ((obj23 instanceof Boolean) && ((Boolean) obj23).booleanValue()) {
                            Object obj30 = map.get("download_size_diff");
                            if (obj30 instanceof String) {
                                str6 = String.format("空间不足 还需%s", (String) obj30);
                            }
                        }
                    }
                    str = str8;
                    i3 = 8;
                    str8 = "重新下载";
                    remoteViews.setViewVisibility(iA, i3);
                    remoteViews.setViewVisibility(iSp, 0);
                    remoteViews.setViewVisibility(iX, i3);
                    obj = "is_network_error";
                } else if (iIntValue4 == -3) {
                    Object obj31 = map.get("download_size");
                    str = obj31 instanceof String ? (String) obj31 : "";
                    Object obj32 = map.get("is_mime_apk");
                    if ((obj32 instanceof Boolean) && ((Boolean) obj32).booleanValue()) {
                        Object obj33 = map.get("is_apk_installed");
                        if ((obj33 instanceof Boolean) && ((Boolean) obj33).booleanValue()) {
                            str6 = "安装完成，点击打开。";
                            str8 = b.a.p;
                        } else {
                            str6 = "下载完成，点击安装。";
                            str8 = "安装";
                        }
                    } else {
                        Object obj34 = map.get("is_have_notification_click_callback");
                        str6 = ((obj34 instanceof Boolean) && ((Boolean) obj34).booleanValue()) ? "下载完成，点击打开。" : "下载完成";
                    }
                    String str9 = str8;
                    if (((Integer) obj4).intValue() == 1) {
                        remoteViews.setTextViewText(i, str9);
                        remoteViews.setViewVisibility(iRh, 8);
                    } else {
                        remoteViews.setViewVisibility(i, 8);
                    }
                    str7 = str6;
                    str8 = str9;
                } else {
                    str = "";
                    str6 = str;
                }
                i3 = 8;
                remoteViews.setViewVisibility(iA, i3);
                remoteViews.setViewVisibility(iSp, 0);
                remoteViews.setViewVisibility(iX, i3);
                obj = "is_network_error";
            } else {
                obj = "is_network_error";
                str = "";
                str6 = str;
            }
            Object obj35 = map.get(obj);
            Object obj36 = map.get("is_insufficient_space_error");
            if (tt(obj11) && z3 && ((Integer) obj21).intValue() == -1 && (((obj35 instanceof Boolean) && ((Boolean) obj35).booleanValue()) || ((obj36 instanceof Boolean) && ((Boolean) obj36).booleanValue()))) {
                remoteViews.setViewVisibility(iA, 0);
                remoteViews.setViewVisibility(iSp, 8);
                remoteViews.setViewVisibility(iX, 0);
                Object obj37 = map.get("is_wait_wifi_and_in_net");
                if ((obj37 instanceof Boolean) && ((Boolean) obj37).booleanValue()) {
                    remoteViews.setViewVisibility(i, 0);
                    Object obj38 = map.get("download_size");
                    str = obj38 instanceof String ? (String) obj38 : str;
                } else {
                    str5 = str6;
                    remoteViews.setViewVisibility(i, 8);
                    str4 = str7;
                    str3 = str8;
                }
            }
            str5 = str6;
            str4 = str7;
            str3 = str8;
        } else {
            str4 = null;
            str5 = "";
            str3 = str5;
            str = str3;
        }
        remoteViews.setTextViewText(c.nu(), str);
        remoteViews.setTextViewText(c.my(), str5);
        remoteViews.setTextViewText(iRh, str);
        remoteViews.setTextViewText(c.gt(), str5);
        if (TextUtils.isEmpty(str3)) {
            remoteViews.setViewVisibility(i, 8);
        } else {
            remoteViews.setTextViewText(i, str3);
        }
        try {
            if (isMaterialNotification(this.tt)) {
                remoteViews.setInt(c.uj(), "setBackgroundColor", Color.parseColor("#fffafafa"));
            }
        } catch (Throwable unused) {
        }
        map2.put("remote_views", remoteViews);
        map2.put("builder_content_type", str4);
        return map2;
    }

    public void c(Map<String, Object> map, int i) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, Integer.valueOf(i));
        sparseArray.put(0, map);
        Function<SparseArray<Object>, Object> function = this.ve;
        if (function != null) {
            function.apply(sparseArray);
        }
    }

    public <T> T callMethod(Class<T> cls, int i, Map<String, Object> map) {
        a.tt("xgc_dl", "api:".concat(String.valueOf(i)));
        if (i == 0) {
            if (this.ve == null) {
                return (T) Boolean.FALSE;
            }
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 0);
            sparseArray.put(0, map);
            return (T) this.ve.apply(sparseArray);
        }
        if (i == 159) {
            if (map != null) {
                Object obj = map.get("n");
                if (obj instanceof Function) {
                    this.ve = (Function) obj;
                }
            }
            return null;
        }
        if (i == 161) {
            return (T) tt(map);
        }
        if (i == 155) {
            return (T) getCustomUriForFile((String) map.get("custom_authority"), (String) map.get("custom_file_path"));
        }
        if (i != 156) {
            return null;
        }
        return (T) c(map);
    }

    public Uri getCustomUriForFile(String str, String str2) {
        return !TextUtils.isEmpty(str) ? FileProvider.getUriForFile(this.tt, str, new File(str2)) : Uri.fromFile(new File(str2));
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        ValueSet valueSetTt = com.byazt.rl.ve.c(sparseArray).tt();
        int iIntValue = valueSetTt.intValue(-99999987);
        Class cls = (Class) valueSetTt.objectValue(-99999985, Class.class);
        if (iIntValue == -99999986) {
            return com.byazt.rl.ve.c().c(10000, 3).tt().sparseArray();
        }
        return callMethod(cls, iIntValue, valueSetTt.objectValue(0, Map.class) != null ? (Map) valueSetTt.objectValue(0, Map.class) : new HashMap<>());
    }

    private NotificationCompat.Builder c(String str) {
        try {
            return new NotificationCompat.Builder(this.tt, str);
        } catch (NoSuchMethodError unused) {
            return new NotificationCompat.Builder(this.tt);
        }
    }

    private Map<String, Object> c(Map<String, Object> map) {
        Map<String, Object> map2;
        if (map == null || (map2 = (Map) map.get("params")) == null) {
            return null;
        }
        Map<String, Object> mapVe = ve(map2);
        Object obj = mapVe.get("remote_views");
        Object obj2 = mapVe.get("builder_content_type");
        int iIntValue = ((Integer) map2.get("notification_type")).intValue();
        String str = (String) map2.get("channel_id");
        int iIntValue2 = ((Integer) map2.get("download_status")).intValue();
        NotificationCompat.Builder builderC = c(str);
        builderC.setWhen(((Long) map2.get("first_time")).longValue());
        Object obj3 = map2.get("notification_group");
        if (obj3 != null && (obj3 instanceof String)) {
            builderC.setGroup((String) obj3);
            builderC.setGroupSummary(false);
        }
        builderC.setStyle(new NotificationCompat.DecoratedCustomViewStyle());
        if (iIntValue == 1 || iIntValue == 4 || iIntValue == 2) {
            builderC.setContentIntent((PendingIntent) mapVe.get("apa_click_content_intent"));
            builderC.setAutoCancel(false);
        } else if (iIntValue == 3) {
            builderC.setAutoCancel(true);
            if (iIntValue2 == -3) {
                Object obj4 = map2.get("auto_cancel");
                if ((obj4 instanceof Boolean) && ((Boolean) obj4).booleanValue()) {
                    builderC.setAutoCancel(false);
                }
            }
            builderC.setContentIntent((PendingIntent) mapVe.get("complete_click_content_intent"));
            builderC.setDeleteIntent((PendingIntent) mapVe.get("hide_click_content_intent"));
        }
        if (iIntValue == 3 && iIntValue2 == -3 && (obj2 instanceof String)) {
            builderC.setContentText((String) obj2);
        }
        Object obj5 = mapVe.get("builder_small_icon");
        if (obj5 instanceof Integer) {
            builderC.setSmallIcon(((Integer) obj5).intValue());
        }
        Notification notificationBuild = builderC.build();
        notificationBuild.contentView = (RemoteViews) obj;
        mapVe.put("notification", notificationBuild);
        return mapVe;
    }

    private Pair<Intent, Boolean> c(Context context, long j, boolean z) {
        if (z) {
            return new Pair<>(new Intent(context, (Class<?>) ApiDownloadHandleNotificationActivity.class), Boolean.TRUE);
        }
        return new Pair<>(new Intent(context, (Class<?>) ApiDownloadHandlerService.class), Boolean.FALSE);
    }

    private PendingIntent c(String str, int i, int i2, boolean z, String str2) {
        Pair<Intent, Boolean> pairC = c(this.tt, i2, z);
        Intent intent = (Intent) pairC.first;
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i2);
        intent.putExtra("extra_click_download_type", i);
        intent.putExtra("extra_from_notification", true);
        intent.putExtra("extra_package_name", str2);
        return c(this.tt, pairC, i2);
    }

    private boolean tt(Object obj) {
        return (obj instanceof Integer) && ((Integer) obj).intValue() >= 2;
    }

    private PendingIntent c(String str, int i, int i2, boolean z, String str2, String str3, String str4, String str5) {
        Pair<Intent, Boolean> pairC = c(this.tt, i2, z);
        Intent intent = (Intent) pairC.first;
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i2);
        intent.putExtra("extra_click_download_type", i);
        intent.putExtra("extra_from_notification", true);
        intent.putExtra("extra_package_name", str2);
        intent.putExtra("extra_tag", str3);
        intent.putExtra("extra_value", str4);
        intent.putExtra("extra_log_extra", str5);
        return c(this.tt, pairC, i2);
    }

    private PendingIntent c(Context context, Pair<Intent, Boolean> pair, int i) {
        if (((Boolean) pair.second).booleanValue()) {
            return PendingIntent.getActivity(context, i, (Intent) pair.first, 201326592);
        }
        return PendingIntent.getService(context, i, (Intent) pair.first, 201326592);
    }

    private boolean c(Object obj) {
        return (obj instanceof Integer) && ((Integer) obj).intValue() > 0;
    }

    private int c(int i, boolean z) {
        if (z) {
            return c.gr();
        }
        if (i == 1 || i == 4) {
            return c.qy();
        }
        if (i == 2) {
            return c.gu();
        }
        if (i == 3) {
            return c.gr();
        }
        return 0;
    }
}
