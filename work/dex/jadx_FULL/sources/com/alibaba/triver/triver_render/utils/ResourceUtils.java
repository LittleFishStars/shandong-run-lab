package com.alibaba.triver.triver_render.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.extensions.resources.model.ResourceLoadContext;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.api.resources.ResourceLoadPoint;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.ImageUtil;
import com.alibaba.triver.kit.api.proxy.IImageProxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ResourceUtils {

    public enum ResourceType {
        ONLINE,
        BASE64,
        INTERNAL
    }

    public static abstract class a {
        public abstract void a(Bitmap bitmap);
    }

    private ResourceUtils() {
    }

    public static void a(App app, String str, @NonNull final a aVar) {
        if (app == null || str == null || str.isEmpty()) {
            aVar.a(null);
        } else if (a(str, BundleUtils.getString(app.getStartParams(), "onlineHost")) != ResourceType.INTERNAL) {
            ((IImageProxy) RVProxy.get(IImageProxy.class)).loadImage(str, null, new IImageProxy.ImageListener() { // from class: com.alibaba.triver.triver_render.utils.ResourceUtils.1
                @Override // com.alibaba.triver.kit.api.proxy.IImageProxy.ImageListener
                public void onImageFinish(Drawable drawable) {
                    try {
                        aVar.a(((BitmapDrawable) drawable).getBitmap());
                    } catch (Throwable unused) {
                    }
                }
            });
        } else {
            aVar.a(a(app, str));
        }
    }

    public static Bitmap a(App app, String str) {
        if (app != null && str != null && !str.isEmpty()) {
            String string = BundleUtils.getString(app.getStartParams(), "onlineHost");
            if (!str.startsWith(string)) {
                str = FileUtils.combinePath(string, str);
            }
            Resource resourceLoad = ((ResourceLoadPoint) ExtensionPoint.as(ResourceLoadPoint.class).node(app).create()).load(ResourceLoadContext.newBuilder().originUrl(str).build());
            if (resourceLoad != null) {
                byte[] bytes = resourceLoad.getBytes();
                return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            }
        }
        return null;
    }

    public static ResourceType a(@NonNull String str, String str2) {
        if (str.startsWith(str2)) {
            return ResourceType.INTERNAL;
        }
        if (!str.startsWith("https:") && !str.startsWith("http:")) {
            if (ImageUtil.isBase64Url(str)) {
                return ResourceType.BASE64;
            }
            return ResourceType.INTERNAL;
        }
        return ResourceType.ONLINE;
    }
}
