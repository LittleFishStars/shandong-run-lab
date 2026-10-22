package com.byazt.or;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.byazt.nr.m;
import com.bytedance.component.sdk.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 579, 13})
public class tt {
    /* JADX WARN: Code duplicated, block: B:36:0x007d A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:38:0x0082 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:40:0x0087 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:42:0x008c A[DONT_GENERATE] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.renderscript.BaseObj] */
    /* JADX WARN: Type inference failed for: r2v5, types: [android.renderscript.BaseObj, android.renderscript.ScriptIntrinsicBlur] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.renderscript.Allocation] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8, types: [android.renderscript.Allocation] */
    @RequiresApi(api = 17)
    public static Bitmap c(Context context, Bitmap bitmap, int i) {
        RenderScript renderScriptCreate;
        Allocation allocationCreateFromBitmap;
        ?? Create;
        ?? CreateFromBitmap;
        try {
            com.byazt.sr.uj.c();
            if (bitmap != null && !bitmap.isRecycled()) {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * 0.2f), Math.round(bitmap.getHeight() * 0.2f), false);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateScaledBitmap);
                renderScriptCreate = RenderScript.create(context);
                if (renderScriptCreate == null) {
                    if (renderScriptCreate != null) {
                        renderScriptCreate.destroy();
                    }
                    return null;
                }
                try {
                    Create = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
                    try {
                        allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateScaledBitmap);
                        try {
                            CreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
                            try {
                                Create.setRadius(i);
                                Create.setInput(allocationCreateFromBitmap);
                                Create.forEach(CreateFromBitmap);
                                CreateFromBitmap.copyTo(bitmapCreateBitmap);
                                if (allocationCreateFromBitmap != null) {
                                    allocationCreateFromBitmap.destroy();
                                }
                                CreateFromBitmap.destroy();
                                Create.destroy();
                                renderScriptCreate.destroy();
                                return bitmapCreateBitmap;
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    m.c(th);
                                    return null;
                                } finally {
                                    if (allocationCreateFromBitmap != null) {
                                        allocationCreateFromBitmap.destroy();
                                    }
                                    if (CreateFromBitmap != 0) {
                                        CreateFromBitmap.destroy();
                                    }
                                    if (Create != 0) {
                                        Create.destroy();
                                    }
                                    if (renderScriptCreate != null) {
                                        renderScriptCreate.destroy();
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            CreateFromBitmap = 0;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        allocationCreateFromBitmap = null;
                        CreateFromBitmap = 0;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    allocationCreateFromBitmap = null;
                    Create = allocationCreateFromBitmap;
                    CreateFromBitmap = Create;
                    m.c(th);
                    return null;
                }
            }
            return null;
        } catch (Throwable th5) {
            th = th5;
            renderScriptCreate = null;
            allocationCreateFromBitmap = null;
        }
    }
}
