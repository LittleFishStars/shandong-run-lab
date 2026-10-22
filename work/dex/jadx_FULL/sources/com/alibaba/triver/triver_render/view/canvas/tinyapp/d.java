package com.alibaba.triver.triver_render.view.canvas.tinyapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.proxy.RVResourceManager;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.mobile.tinycanvas.plugin.TinyImageLoadParams;
import com.alibaba.mobile.tinycanvas.plugin.TinyImageLoadResult;
import com.alibaba.mobile.tinycanvas.plugin.TinyImagePlugin;
import com.alibaba.mobile.tinycanvas.session.TinyCanvasSession;
import com.alibaba.mobile.tinycanvas.session.TinyCanvasSessionManager;
import com.alibaba.mobile.tinycanvas.util.TinyLogUtils;
import com.alibaba.triver.kit.api.utils.FileUtils;
import com.alibaba.triver.triver_render.utils.ResourceUtils;
import com.taobao.phenix.intf.Phenix;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.phenix.intf.event.SuccPhenixEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d implements TinyImagePlugin {
    private final String b = "https://resource";
    private final String c = "gcanvas";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f25232a = 13;

    private void b(Page page, final String str, final TinyImagePlugin.ImageLoadCallback imageLoadCallback) {
        ResourceUtils.a(page.getApp(), str, new ResourceUtils.a() { // from class: com.alibaba.triver.triver_render.view.canvas.tinyapp.d.1
            @Override // com.alibaba.triver.triver_render.utils.ResourceUtils.a
            public void a(Bitmap bitmap) {
                if (bitmap == null) {
                    d.this.a(str, imageLoadCallback);
                } else {
                    imageLoadCallback.onLoadComplete(new TinyImageLoadResult(str, bitmap));
                }
            }
        });
    }

    private void c(Page page, String str, TinyImagePlugin.ImageLoadCallback imageLoadCallback) {
        Bitmap bitmapA;
        if (str.indexOf("https://resource") == 0) {
            String strApUrlToFilePath = FileUtils.apUrlToFilePath(str);
            if (new File(strApUrlToFilePath).exists()) {
                bitmapA = BitmapFactory.decodeFile(strApUrlToFilePath);
            } else {
                a(str, imageLoadCallback);
                bitmapA = null;
            }
        } else {
            bitmapA = ResourceUtils.a(page.getApp(), str);
        }
        if (bitmapA != null) {
            imageLoadCallback.onLoadComplete(new TinyImageLoadResult(str, bitmapA));
        } else {
            a(str, imageLoadCallback);
        }
    }

    private void b(final String str, final TinyImagePlugin.ImageLoadCallback imageLoadCallback) {
        Phenix.instance().load(FileUtils.apUrlToFilePath(str)).succListener(new IPhenixListener<SuccPhenixEvent>() { // from class: com.alibaba.triver.triver_render.view.canvas.tinyapp.d.2
            public boolean a(SuccPhenixEvent succPhenixEvent) {
                if (succPhenixEvent.getDrawable() == null || succPhenixEvent.isIntermediate()) {
                    d.this.a(str, imageLoadCallback);
                    return false;
                }
                Bitmap bitmap = succPhenixEvent.getDrawable().getBitmap();
                if (bitmap == null) {
                    d.this.a(str, imageLoadCallback);
                    return false;
                }
                imageLoadCallback.onLoadComplete(new TinyImageLoadResult(str, bitmap));
                return false;
            }
        }).fetch();
    }

    public void a(Map<String, Object> map, TinyImagePlugin.ImageSaveCallback imageSaveCallback) {
        byte[] bArr = (byte[]) map.get("bytes");
        String strValueOf = String.valueOf(System.currentTimeMillis());
        Page pageA = a((String) map.get(RVParams.SESSION_ID));
        if (pageA == null) {
            TinyLogUtils.e("saveToTempFilePath page is null");
            return;
        }
        File file = new File(((RVResourceManager) RVProxy.get(RVResourceManager.class)).getInstallPath((AppModel) pageA.getApp().getData(AppModel.class)), "gcanvas");
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file, strValueOf + ".img");
        String strFilePathToApUrl = FileUtils.filePathToApUrl(file2.getPath(), "image");
        if (!com.alibaba.ariver.commonability.file.f.a(new ByteArrayInputStream(bArr), file2)) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("error", (Object) 13);
            imageSaveCallback.onSaveComplete(jSONObject);
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("apFilePath", (Object) strFilePathToApUrl);
        jSONObject2.put("tempFilePath", (Object) ("gcanvas/" + file2.getName()));
        imageSaveCallback.onSaveComplete(jSONObject2);
    }

    public void a(TinyImageLoadParams tinyImageLoadParams, TinyImagePlugin.ImageLoadCallback imageLoadCallback) {
        Page pageA;
        TinyLogUtils.i(String.format("ImagePluginImpl loadImage:path=%s,session=%s,extParam=%s", tinyImageLoadParams.path, tinyImageLoadParams.sessionId, tinyImageLoadParams.extParams));
        String str = tinyImageLoadParams.path;
        Map map = tinyImageLoadParams.extParams;
        if (map != null && map.containsKey("h5pageReference")) {
            pageA = (Page) map.get("h5pageReference");
        } else {
            TinyLogUtils.e("extParams don't contains h5page");
            pageA = null;
        }
        if (pageA == null) {
            TinyLogUtils.i("ImagePluginImpl loadImage:the session id " + tinyImageLoadParams.sessionId);
            pageA = a(tinyImageLoadParams.sessionId);
        }
        if (pageA == null) {
            TinyLogUtils.e("ImagePluginImpl loadImage:page is null ");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            TinyLogUtils.i("ImagePluginImpl loadImage fail:path is empty");
            if (imageLoadCallback != null) {
                imageLoadCallback.onLoadComplete(new TinyImageLoadResult(""));
                return;
            }
            return;
        }
        a(pageA, str, imageLoadCallback);
    }

    private void a(Page page, String str, TinyImagePlugin.ImageLoadCallback imageLoadCallback) {
        if (str.startsWith(com.alibaba.ariver.commonability.file.proxy.b.f24036a)) {
            b(str, imageLoadCallback);
            return;
        }
        if ((str.indexOf("http://") != 0 && str.indexOf("https://") != 0 && str.indexOf("data:") != 0) || str.indexOf("https://resource") == 0) {
            c(page, str, imageLoadCallback);
        } else {
            b(page, str, imageLoadCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, TinyImagePlugin.ImageLoadCallback imageLoadCallback) {
        TinyImageLoadResult tinyImageLoadResult = new TinyImageLoadResult(str);
        tinyImageLoadResult.success = false;
        imageLoadCallback.onLoadComplete(tinyImageLoadResult);
    }

    private Page a(String str) {
        TinyCanvasSession canvasSession = TinyCanvasSessionManager.getInstance().getCanvasSession(str);
        if (canvasSession != null) {
            Map sessionData = canvasSession.getSessionData();
            if (sessionData.containsKey(b.c)) {
                return (Page) sessionData.get(b.c);
            }
        }
        return null;
    }
}
