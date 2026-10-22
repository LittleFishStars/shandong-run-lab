package com.alibaba.triver.embed.video;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.basic.api.RequestPermission;
import com.alibaba.triver.embed.video.album.SelectVideoActivity;
import com.alibaba.triver.embed.video.video.RecordVideoActivity;
import com.alibaba.triver.embed.video.video.VideoModel;
import com.alibaba.triver.embed.video.video.h;
import com.alibaba.triver.kit.api.utils.FileUtils;
import com.alibaba.triver.kit.api.utils.InternationalUtil;
import com.alibaba.triver.kit.api.utils.TriverToastUtils;
import com.hjq.permissions.Permission;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverVideoBridgeExtension implements BridgeExtension {
    public static final String NAME = "video";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f24816a = 32;
    private static final String b = "VideoBridge";
    private static final int i = -1;
    private Activity c;
    private String[] e;
    private String[] f;
    private IntentFilter g;
    private BridgeCallback h;
    private int d = 60;
    BroadcastReceiver receiver = new BroadcastReceiver() { // from class: com.alibaba.triver.embed.video.TriverVideoBridgeExtension.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!h.h.equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra(h.n);
                if (!TextUtils.isEmpty(stringExtra) && TriverVideoBridgeExtension.this.j.contains(stringExtra)) {
                    TriverVideoBridgeExtension.this.j.remove(stringExtra);
                    VideoModel videoModel = (VideoModel) intent.getExtras().get(h.c);
                    String strC = TriverVideoBridgeExtension.this.c(videoModel.apFilePath);
                    if (TextUtils.isEmpty(strC)) {
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("error", (Object) InternationalUtil.getString(R.string.triver_video_get_video_path_failed));
                        jSONObject.put("fail", (Object) jSONObject2);
                        TriverVideoBridgeExtension.this.h.sendJSONResponse(jSONObject);
                    } else {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("tempFilePath", (Object) FileUtils.filePathToApUrl(strC, "video"));
                        jSONObject3.put("width", (Object) Long.valueOf(videoModel.width));
                        jSONObject3.put("height", (Object) Long.valueOf(videoModel.height));
                        jSONObject3.put("duration", (Object) Long.valueOf(videoModel.duration));
                        jSONObject3.put("size", (Object) Double.valueOf(videoModel.size));
                        TriverVideoBridgeExtension.this.h.sendJSONResponse(jSONObject3);
                    }
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("complete", (Object) jSONObject4);
                    TriverVideoBridgeExtension.this.h.sendJSONResponse(jSONObject4);
                    return;
                }
                return;
            }
            String stringExtra2 = intent.getStringExtra(h.m);
            if (!TextUtils.isEmpty(stringExtra2) && TriverVideoBridgeExtension.this.j.contains(stringExtra2)) {
                TriverVideoBridgeExtension.this.j.remove(stringExtra2);
                VideoModel videoModel2 = (VideoModel) intent.getExtras().get(h.c);
                if (videoModel2.duration > TriverVideoBridgeExtension.this.d) {
                    TriverVideoBridgeExtension.this.h.sendBridgeResponse(new BridgeResponse.Error(-1, String.valueOf(videoModel2.duration)));
                    return;
                }
                String strC2 = TriverVideoBridgeExtension.this.c(videoModel2.apFilePath);
                if (TextUtils.isEmpty(strC2)) {
                    JSONObject jSONObject5 = new JSONObject();
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("error", (Object) InternationalUtil.getString(R.string.triver_video_get_video_path_failed));
                    jSONObject5.put("fail", (Object) jSONObject6);
                    TriverVideoBridgeExtension.this.h.sendJSONResponse(jSONObject5);
                } else {
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("tempFilePath", (Object) FileUtils.filePathToApUrl(strC2, "video"));
                    jSONObject7.put("width", (Object) Long.valueOf(videoModel2.width));
                    jSONObject7.put("height", (Object) Long.valueOf(videoModel2.height));
                    jSONObject7.put("duration", (Object) Long.valueOf(videoModel2.duration));
                    jSONObject7.put("size", (Object) Double.valueOf(videoModel2.size));
                    TriverVideoBridgeExtension.this.h.sendJSONResponse(jSONObject7);
                }
                JSONObject jSONObject8 = new JSONObject();
                jSONObject8.put("complete", (Object) "");
                TriverVideoBridgeExtension.this.h.sendJSONResponse(jSONObject8);
            }
        }
    };
    private List<String> j = new Vector();

    public static class PerReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        a f24822a;

        public PerReceiver(a aVar) {
            this.f24822a = aVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                boolean z = false;
                if (intent.getIntExtra(RequestPermission.REQUEST_CODE, 0) == 32) {
                    int[] intArrayExtra = intent.getIntArrayExtra(RequestPermission.GRANT_RESULTS);
                    String[] stringArrayExtra = intent.getStringArrayExtra(RequestPermission.PERMISSIONS);
                    int i = 0;
                    while (true) {
                        if (intArrayExtra == null || i >= intArrayExtra.length) {
                            z = true;
                            break;
                        } else {
                            if (intArrayExtra[i] != 0) {
                                this.f24822a.a(stringArrayExtra[i]);
                                break;
                            }
                            i++;
                        }
                    }
                    if (z) {
                        this.f24822a.a();
                    }
                }
                LocalBroadcastManager.getInstance(context).unregisterReceiver(this);
            } catch (Throwable th) {
                RVLogger.e("Bridge", Log.getStackTraceString(th));
            }
        }
    }

    public interface a {
        void a();

        void a(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        if (this.f == null || this.e == null) {
            return "unknown";
        }
        int i2 = 0;
        while (true) {
            String[] strArr = this.f;
            if (i2 >= strArr.length) {
                i2 = -1;
                break;
            }
            if (strArr[i2].equalsIgnoreCase(str)) {
                break;
            }
            i2++;
        }
        if (i2 < 0) {
            return "unknown";
        }
        String[] strArr2 = this.e;
        return i2 < strArr2.length ? strArr2[i2] : "unknown";
    }

    private String b(String str) {
        int iLastIndexOf = str.lastIndexOf(File.separator);
        return iLastIndexOf == -1 ? str : str.substring(iLastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(String str) {
        return str;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void chooseVideo(@BindingParam({"sourceType"}) String[] strArr, @BindingParam({"compressed"}) boolean z, @BindingParam({h.p}) int i2, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        this.h = bridgeCallback;
        if (page.getPageContext() == null || page.getPageContext().getActivity() == null) {
            this.c = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getTopActivity().get();
        } else {
            this.c = page.getPageContext().getActivity();
        }
        this.d = i2;
        this.e = new String[strArr.length];
        this.f = new String[strArr.length];
        for (int i3 = 0; i3 < strArr.length; i3++) {
            String[] strArr2 = this.e;
            String str = strArr[i3];
            strArr2[i3] = str;
            if (h.f.equals(str)) {
                this.f[i3] = InternationalUtil.getString(R.string.triver_video_album);
            } else if (h.d.equals(this.e[i3])) {
                this.f[i3] = InternationalUtil.getString(R.string.triver_video_camera);
            } else {
                this.f[i3] = InternationalUtil.getString(R.string.triver_video_unknow_source);
            }
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            this.g = intentFilter;
            intentFilter.addAction(h.f24906a);
            this.g.addAction(h.b);
            this.g.addAction(h.h);
            this.c.getApplication().registerReceiver(this.receiver, this.g);
            final Activity activity = this.c;
            a(activity, new a() { // from class: com.alibaba.triver.embed.video.TriverVideoBridgeExtension.1
                @Override // com.alibaba.triver.embed.video.TriverVideoBridgeExtension.a
                public void a() {
                    Intent intent;
                    String str2;
                    if (TriverVideoBridgeExtension.this.e.length != 1) {
                        TriverVideoBridgeExtension triverVideoBridgeExtension = TriverVideoBridgeExtension.this;
                        triverVideoBridgeExtension.a(triverVideoBridgeExtension.f);
                        return;
                    }
                    if (h.d.equals(TriverVideoBridgeExtension.this.e[0])) {
                        intent = new Intent(activity, (Class<?>) RecordVideoActivity.class);
                        intent.putExtra(h.p, TriverVideoBridgeExtension.this.d);
                        str2 = "video_record_" + System.currentTimeMillis();
                        intent.putExtra(h.n, str2);
                    } else if (h.f.equals(TriverVideoBridgeExtension.this.e[0])) {
                        intent = new Intent(activity, (Class<?>) SelectVideoActivity.class);
                        str2 = "video_select_" + System.currentTimeMillis();
                        intent.putExtra(h.m, str2);
                    } else {
                        intent = null;
                        str2 = null;
                    }
                    if (intent == null || TextUtils.isEmpty(str2)) {
                        return;
                    }
                    TriverVideoBridgeExtension.this.j.add(str2);
                    activity.startActivity(intent);
                }

                @Override // com.alibaba.triver.embed.video.TriverVideoBridgeExtension.a
                public void a(String str2) {
                    if (TriverVideoBridgeExtension.this.h != null) {
                        TriverVideoBridgeExtension.this.h.sendBridgeResponse(new BridgeResponse.Error(4, InternationalUtil.getString(R.string.triver_video_no_permission_video_bridge)));
                    }
                }
            }, Permission.RECORD_AUDIO, "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", Permission.CAMERA);
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public com.alibaba.ariver.kernel.api.security.Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void saveVideoToPhotosAlbum(@BindingParam({"src"}) final String str, @BindingRequest JSONObject jSONObject, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        this.h = bridgeCallback;
        if (page.getPageContext() == null || page.getPageContext().getActivity() == null) {
            this.c = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getTopActivity().get();
        } else {
            this.c = page.getPageContext().getActivity();
        }
        a(this.c, new a() { // from class: com.alibaba.triver.embed.video.TriverVideoBridgeExtension.3
            @Override // com.alibaba.triver.embed.video.TriverVideoBridgeExtension.a
            public void a() {
                com.alibaba.triver.embed.video.video.a.a(TriverVideoBridgeExtension.this.c, FileUtils.apUrlToFilePath(str), System.currentTimeMillis(), 0L);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("success", (Object) Boolean.TRUE);
                TriverVideoBridgeExtension.this.h.sendJSONResponse(jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("complete", (Object) "");
                TriverVideoBridgeExtension.this.h.sendJSONResponse(jSONObject3);
            }

            @Override // com.alibaba.triver.embed.video.TriverVideoBridgeExtension.a
            public void a(String str2) {
                RVLogger.e(TriverVideoBridgeExtension.b, "Permission denied");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("error", (Object) 4);
                jSONObject2.put(SendToNativeCallback.KEY_MESSAGE, (Object) InternationalUtil.getString(R.string.triver_video_no_permission));
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("fail", (Object) jSONObject2);
                TriverVideoBridgeExtension.this.h.sendJSONResponse(jSONObject3);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("complete", (Object) "");
                TriverVideoBridgeExtension.this.h.sendJSONResponse(jSONObject4);
            }
        }, "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    private void a(Activity activity, a aVar, String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(activity, str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() == 0) {
            if (aVar != null) {
                aVar.a();
            }
        } else {
            try {
                ActivityCompat.requestPermissions(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), 32);
                LocalBroadcastManager.getInstance(activity).registerReceiver(new PerReceiver(aVar), new IntentFilter(RequestPermission.ACTION_REQUEST_PERMISSIONS_RESULT));
            } catch (Throwable th) {
                RVLogger.e("Bridge", Log.getStackTraceString(th));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String[] strArr) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.c, 3);
        builder.setTitle(InternationalUtil.getString(R.string.triver_video_select_video_source));
        builder.setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.alibaba.triver.embed.video.TriverVideoBridgeExtension.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
                String strA = TriverVideoBridgeExtension.this.a(strArr[i2]);
                if (h.f.equals(strA)) {
                    Intent intent = new Intent(TriverVideoBridgeExtension.this.c, (Class<?>) SelectVideoActivity.class);
                    String str = "video_select_" + System.currentTimeMillis();
                    intent.putExtra(h.m, str);
                    TriverVideoBridgeExtension.this.j.add(str);
                    TriverVideoBridgeExtension.this.c.startActivity(intent);
                    return;
                }
                if (!h.d.equals(strA)) {
                    TriverToastUtils.showLongToast(TriverVideoBridgeExtension.this.c, InternationalUtil.getString(R.string.triver_video_no_support_source));
                    return;
                }
                Intent intent2 = new Intent(TriverVideoBridgeExtension.this.c, (Class<?>) RecordVideoActivity.class);
                intent2.putExtra(h.p, TriverVideoBridgeExtension.this.d);
                String str2 = "video_record_" + System.currentTimeMillis();
                intent2.putExtra(h.n, str2);
                TriverVideoBridgeExtension.this.j.add(str2);
                TriverVideoBridgeExtension.this.c.startActivity(intent2);
            }
        });
        builder.setPositiveButton(InternationalUtil.getString(R.string.triver_video_cancel), new DialogInterface.OnClickListener() { // from class: com.alibaba.triver.embed.video.TriverVideoBridgeExtension.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }
}
