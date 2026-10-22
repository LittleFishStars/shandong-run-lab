package com.kc.cw.ad.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.kc.cw.ad.utils.ThreadUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class d {

    @Keep
    public interface a {
        void a(Bitmap bitmap);
    }

    public static void a(Context context, Bitmap bitmap, a aVar) {
        ThreadUtils.runOnThreadPool(new Runnable(bitmap, context, aVar) { // from class: com.kc.cw.ad.d.d.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Bitmap f38811a;
            final Context b;
            final a c;

            {
                this.f38811a = bitmap;
                this.b = context;
                this.c = aVar;
            }

            /* JADX WARN: Code duplicated, block: B:14:0x004f A[Catch: Exception -> 0x0081, PHI: r4 r5 r6 r7
              0x004f: PHI (r4v10 android.renderscript.RenderScript) = 
              (r4v7 android.renderscript.RenderScript)
              (r4v8 android.renderscript.RenderScript)
              (r4v14 android.renderscript.RenderScript)
             binds: [B:28:0x006f, B:42:0x008d, B:13:0x004c] A[DONT_GENERATE, DONT_INLINE]
              0x004f: PHI (r5v8 android.renderscript.ScriptIntrinsicBlur) = 
              (r5v5 android.renderscript.ScriptIntrinsicBlur)
              (r5v6 android.renderscript.ScriptIntrinsicBlur)
              (r5v11 android.renderscript.ScriptIntrinsicBlur)
             binds: [B:28:0x006f, B:42:0x008d, B:13:0x004c] A[DONT_GENERATE, DONT_INLINE]
              0x004f: PHI (r6v6 android.renderscript.Allocation) = (r6v3 android.renderscript.Allocation), (r6v4 android.renderscript.Allocation), (r6v8 android.renderscript.Allocation) binds: [B:28:0x006f, B:42:0x008d, B:13:0x004c] A[DONT_GENERATE, DONT_INLINE]
              0x004f: PHI (r7v6 android.renderscript.Allocation) = (r7v3 android.renderscript.Allocation), (r7v4 android.renderscript.Allocation), (r7v9 android.renderscript.Allocation) binds: [B:28:0x006f, B:42:0x008d, B:13:0x004c] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #12 {Exception -> 0x0081, blocks: (B:10:0x0044, B:12:0x0049, B:13:0x004c, B:14:0x004f, B:23:0x0062, B:25:0x0067, B:27:0x006c, B:35:0x007d, B:39:0x0085, B:41:0x008a), top: B:71:0x0005 }] */
            /* JADX WARN: Code duplicated, block: B:23:0x0062 A[Catch: Exception -> 0x0081, TRY_ENTER, TryCatch #12 {Exception -> 0x0081, blocks: (B:10:0x0044, B:12:0x0049, B:13:0x004c, B:14:0x004f, B:23:0x0062, B:25:0x0067, B:27:0x006c, B:35:0x007d, B:39:0x0085, B:41:0x008a), top: B:71:0x0005 }] */
            /* JADX WARN: Code duplicated, block: B:25:0x0067 A[Catch: Exception -> 0x0081, TryCatch #12 {Exception -> 0x0081, blocks: (B:10:0x0044, B:12:0x0049, B:13:0x004c, B:14:0x004f, B:23:0x0062, B:25:0x0067, B:27:0x006c, B:35:0x007d, B:39:0x0085, B:41:0x008a), top: B:71:0x0005 }] */
            /* JADX WARN: Code duplicated, block: B:27:0x006c A[Catch: Exception -> 0x0081, TRY_LEAVE, TryCatch #12 {Exception -> 0x0081, blocks: (B:10:0x0044, B:12:0x0049, B:13:0x004c, B:14:0x004f, B:23:0x0062, B:25:0x0067, B:27:0x006c, B:35:0x007d, B:39:0x0085, B:41:0x008a), top: B:71:0x0005 }] */
            /* JADX WARN: Code duplicated, block: B:35:0x007d A[Catch: Exception -> 0x0081, TRY_ENTER, TryCatch #12 {Exception -> 0x0081, blocks: (B:10:0x0044, B:12:0x0049, B:13:0x004c, B:14:0x004f, B:23:0x0062, B:25:0x0067, B:27:0x006c, B:35:0x007d, B:39:0x0085, B:41:0x008a), top: B:71:0x0005 }] */
            /* JADX WARN: Code duplicated, block: B:39:0x0085 A[Catch: Exception -> 0x0081, TryCatch #12 {Exception -> 0x0081, blocks: (B:10:0x0044, B:12:0x0049, B:13:0x004c, B:14:0x004f, B:23:0x0062, B:25:0x0067, B:27:0x006c, B:35:0x007d, B:39:0x0085, B:41:0x008a), top: B:71:0x0005 }] */
            /* JADX WARN: Code duplicated, block: B:41:0x008a A[Catch: Exception -> 0x0081, TRY_LEAVE, TryCatch #12 {Exception -> 0x0081, blocks: (B:10:0x0044, B:12:0x0049, B:13:0x004c, B:14:0x004f, B:23:0x0062, B:25:0x0067, B:27:0x006c, B:35:0x007d, B:39:0x0085, B:41:0x008a), top: B:71:0x0005 }] */
            /* JADX WARN: Code duplicated, block: B:52:0x009f A[Catch: Exception -> 0x009b, TryCatch #7 {Exception -> 0x009b, blocks: (B:48:0x0097, B:52:0x009f, B:54:0x00a4, B:56:0x00a9), top: B:69:0x0097 }] */
            /* JADX WARN: Code duplicated, block: B:54:0x00a4 A[Catch: Exception -> 0x009b, TryCatch #7 {Exception -> 0x009b, blocks: (B:48:0x0097, B:52:0x009f, B:54:0x00a4, B:56:0x00a9), top: B:69:0x0097 }] */
            /* JADX WARN: Code duplicated, block: B:56:0x00a9 A[Catch: Exception -> 0x009b, TRY_LEAVE, TryCatch #7 {Exception -> 0x009b, blocks: (B:48:0x0097, B:52:0x009f, B:54:0x00a4, B:56:0x00a9), top: B:69:0x0097 }] */
            @Override // java.lang.Runnable
            public void run() {
                RenderScript renderScriptCreate;
                ScriptIntrinsicBlur scriptIntrinsicBlurCreate;
                Allocation allocationCreateFromBitmap;
                Allocation allocationCreateFromBitmap2;
                try {
                    try {
                        try {
                            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.f38811a.getWidth(), this.f38811a.getHeight(), Bitmap.Config.ARGB_8888);
                            renderScriptCreate = RenderScript.create(this.b);
                            try {
                                scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
                                try {
                                    allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, this.f38811a);
                                    try {
                                        allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
                                        try {
                                            scriptIntrinsicBlurCreate.setRadius(20.0f);
                                            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
                                            scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
                                            allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
                                            this.c.a(bitmapCreateBitmap);
                                            if (renderScriptCreate != null) {
                                                renderScriptCreate.destroy();
                                            }
                                            if (allocationCreateFromBitmap != null) {
                                                allocationCreateFromBitmap.destroy();
                                            }
                                            allocationCreateFromBitmap2.destroy();
                                        } catch (Exception unused) {
                                            this.c.a(null);
                                            if (renderScriptCreate != null) {
                                                renderScriptCreate.destroy();
                                            }
                                            if (allocationCreateFromBitmap != null) {
                                                allocationCreateFromBitmap.destroy();
                                            }
                                            if (allocationCreateFromBitmap2 != null) {
                                                allocationCreateFromBitmap2.destroy();
                                            }
                                            if (scriptIntrinsicBlurCreate != null) {
                                            }
                                        } catch (Throwable unused2) {
                                            this.c.a(null);
                                            if (renderScriptCreate != null) {
                                                renderScriptCreate.destroy();
                                            }
                                            if (allocationCreateFromBitmap != null) {
                                                allocationCreateFromBitmap.destroy();
                                            }
                                            if (allocationCreateFromBitmap2 != null) {
                                                allocationCreateFromBitmap2.destroy();
                                            }
                                            if (scriptIntrinsicBlurCreate != null) {
                                            }
                                        }
                                    } catch (Exception unused3) {
                                        allocationCreateFromBitmap2 = null;
                                    } catch (Throwable unused4) {
                                        allocationCreateFromBitmap2 = null;
                                    }
                                } catch (Exception unused5) {
                                    allocationCreateFromBitmap = null;
                                    allocationCreateFromBitmap2 = null;
                                    this.c.a(null);
                                    if (renderScriptCreate != null) {
                                        renderScriptCreate.destroy();
                                    }
                                    if (allocationCreateFromBitmap != null) {
                                        allocationCreateFromBitmap.destroy();
                                    }
                                    if (allocationCreateFromBitmap2 != null) {
                                        allocationCreateFromBitmap2.destroy();
                                    }
                                    if (scriptIntrinsicBlurCreate != null) {
                                        scriptIntrinsicBlurCreate.destroy();
                                    }
                                } catch (Throwable unused6) {
                                    allocationCreateFromBitmap = null;
                                    allocationCreateFromBitmap2 = null;
                                    this.c.a(null);
                                    if (renderScriptCreate != null) {
                                        renderScriptCreate.destroy();
                                    }
                                    if (allocationCreateFromBitmap != null) {
                                        allocationCreateFromBitmap.destroy();
                                    }
                                    if (allocationCreateFromBitmap2 != null) {
                                        allocationCreateFromBitmap2.destroy();
                                    }
                                    if (scriptIntrinsicBlurCreate != null) {
                                        scriptIntrinsicBlurCreate.destroy();
                                    }
                                }
                            } catch (Exception unused7) {
                                scriptIntrinsicBlurCreate = null;
                                allocationCreateFromBitmap = null;
                                allocationCreateFromBitmap2 = null;
                                this.c.a(null);
                                if (renderScriptCreate != null) {
                                    renderScriptCreate.destroy();
                                }
                                if (allocationCreateFromBitmap != null) {
                                    allocationCreateFromBitmap.destroy();
                                }
                                if (allocationCreateFromBitmap2 != null) {
                                    allocationCreateFromBitmap2.destroy();
                                }
                                if (scriptIntrinsicBlurCreate != null) {
                                    scriptIntrinsicBlurCreate.destroy();
                                }
                            } catch (Throwable unused8) {
                                scriptIntrinsicBlurCreate = null;
                                allocationCreateFromBitmap = null;
                                allocationCreateFromBitmap2 = null;
                                this.c.a(null);
                                if (renderScriptCreate != null) {
                                    renderScriptCreate.destroy();
                                }
                                if (allocationCreateFromBitmap != null) {
                                    allocationCreateFromBitmap.destroy();
                                }
                                if (allocationCreateFromBitmap2 != null) {
                                    allocationCreateFromBitmap2.destroy();
                                }
                                if (scriptIntrinsicBlurCreate != null) {
                                    scriptIntrinsicBlurCreate.destroy();
                                }
                            }
                        } catch (Throwable th) {
                            if (renderScriptCreate != null) {
                                try {
                                    renderScriptCreate.destroy();
                                    if (allocationCreateFromBitmap != null) {
                                        allocationCreateFromBitmap.destroy();
                                    }
                                    if (allocationCreateFromBitmap2 != null) {
                                        allocationCreateFromBitmap2.destroy();
                                    }
                                    if (scriptIntrinsicBlurCreate != null) {
                                        scriptIntrinsicBlurCreate.destroy();
                                    }
                                } catch (Exception e) {
                                    com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
                                    throw th;
                                }
                            } else {
                                if (allocationCreateFromBitmap != null) {
                                    allocationCreateFromBitmap.destroy();
                                }
                                if (allocationCreateFromBitmap2 != null) {
                                    allocationCreateFromBitmap2.destroy();
                                }
                                if (scriptIntrinsicBlurCreate != null) {
                                    scriptIntrinsicBlurCreate.destroy();
                                }
                            }
                            throw th;
                        }
                    } catch (Exception unused9) {
                        renderScriptCreate = null;
                    } catch (Throwable unused10) {
                        renderScriptCreate = null;
                    }
                    scriptIntrinsicBlurCreate.destroy();
                } catch (Exception e2) {
                    com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e2);
                }
            }
        });
    }
}
