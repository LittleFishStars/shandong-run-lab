package com.bykv.vk.component.ttvideo.log;

import android.content.Context;
import android.provider.Settings;
import com.bykv.vk.component.ttvideo.utils.TTVideoEngineLog;
import com.zj.adlib.u15;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public enum e {
    instance;


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private VideoEventEngineUploader f29290a;
    private Context b;

    private void a(JSONObject jSONObject) {
        if (((TTVideoEngineLog.LogNotifyLevel >> 2) & 1) == 1 || ((TTVideoEngineLog.LogTurnOn >> 2) & 1) == 1) {
            TTVideoEngineLog.i("VideoEventManager", jSONObject.toString());
        }
        if (((TTVideoEngineLog.LogTurnOn >> 1) & 1) == 1) {
            Context context = this.b;
            String string = context != null ? Settings.Global.getString(context.getContentResolver(), "engine.debug") : "";
            if (string != null) {
                for (String str : string.split(",", -1)) {
                    if (jSONObject.opt(str) != null) {
                        TTVideoEngineLog.i("VideoEventManager", str + u15.f19942b + jSONObject.opt(str));
                    }
                }
            }
        }
    }

    public void a(Context context) {
        this.b = context.getApplicationContext();
    }

    public synchronized void a(VideoEventEngineUploader videoEventEngineUploader) {
        this.f29290a = videoEventEngineUploader;
    }

    public void a(boolean z, JSONObject jSONObject) {
        synchronized (e.class) {
            try {
                if (jSONObject == null) {
                    return;
                }
                a(jSONObject);
                VideoEventEngineUploader videoEventEngineUploader = this.f29290a;
                if (videoEventEngineUploader != null) {
                    videoEventEngineUploader.onEvent("video_playq", jSONObject);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
