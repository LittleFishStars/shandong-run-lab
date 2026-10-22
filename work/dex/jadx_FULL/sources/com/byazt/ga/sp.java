package com.byazt.ga;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.util.Base64;
import android.util.JsonReader;
import com.alibaba.android.arouter.utils.Consts;
import com.byazt.fs.gu;
import com.bytedance.component.sdk.annotation.RawRes;
import com.bytedance.component.sdk.annotation.WorkerThread;
import com.google.android.exoplayer2.util.FileTypes;
import com.zj.adlib.qt1;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 256, 91})
public class sp {
    public static final Map<String, u<a>> c = new HashMap();
    public static final Set<Object> tt = new HashSet();
    public static final byte[] ve = {80, 75, 3, 4};

    public static u<a> tt(Context context, String str) {
        return tt(context, str, "asset_" + str);
    }

    @WorkerThread
    public static t<a> ve(Context context, String str) {
        return ve(context, str, "asset_" + str);
    }

    public static void c(int i) {
        com.byazt.nb.a.c().c(i);
    }

    public static u<a> tt(Context context, final String str, final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return c(str2, new Callable<t<a>>() { // from class: com.byazt.ga.sp.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public t<a> call() throws Exception {
                return sp.ve(applicationContext, str, str2);
            }
        });
    }

    @WorkerThread
    public static t<a> ve(Context context, String str, String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return tt(context.getAssets().open(str), str2);
            }
            return c(context, new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e) {
            return new t<>((Throwable) e);
        }
    }

    public static u<a> c(Context context, String str) {
        return c(context, str, str);
    }

    public static u<a> c(final Context context, final String str, final String str2) {
        return c(str2, new Callable<t<a>>() { // from class: com.byazt.ga.sp.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public t<a> call() throws Exception {
                t<a> tVarC = n.c(context).c(context, str, str2);
                if (str2 != null && tVarC.c() != null) {
                    com.byazt.nb.a.c().c(str2, tVarC.c());
                }
                return tVarC;
            }
        });
    }

    @WorkerThread
    public static t<a> tt(Context context, @RawRes int i) {
        return tt(context, i, ve(context, i));
    }

    public static u<a> c(Context context, @RawRes int i) {
        return c(context, i, ve(context, i));
    }

    @WorkerThread
    public static t<a> tt(Context context, @RawRes int i, String str) {
        try {
            return tt(context.getResources().openRawResource(i), ve(context, i));
        } catch (Resources.NotFoundException e) {
            return new t<>((Throwable) e);
        }
    }

    public static u<a> c(Context context, @RawRes final int i, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return c(str, new Callable<t<a>>() { // from class: com.byazt.ga.sp.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public t<a> call() throws Exception {
                Context context2 = (Context) weakReference.get();
                if (context2 == null) {
                    context2 = applicationContext;
                }
                return sp.tt(context2, i, str);
            }
        });
    }

    private static String ve(Context context, @RawRes int i) {
        StringBuilder sb = new StringBuilder("rawRes");
        sb.append(c(context) ? "_night_" : "_day_");
        sb.append(i);
        return sb.toString();
    }

    @WorkerThread
    public static t<a> tt(InputStream inputStream, String str) {
        return c(inputStream, str, true);
    }

    @WorkerThread
    private static t<a> tt(Context context, ZipInputStream zipInputStream, String str) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            a aVarC = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase(qt1.c)) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().endsWith(".json")) {
                    aVarC = c(new JsonReader(new InputStreamReader(zipInputStream)), (String) null, false).c();
                } else if (!name.endsWith(".png") && !name.endsWith(".webp") && !name.endsWith(FileTypes.F) && !name.endsWith(".jpeg")) {
                    if (!name.endsWith(".ttf") && !name.endsWith(".otf")) {
                        zipInputStream.closeEntry();
                    } else if (name.contains("../")) {
                        zipInputStream.closeEntry();
                        nextEntry = zipInputStream.getNextEntry();
                    } else {
                        String[] strArrSplit = name.split(WVNativeCallbackUtil.SEPERATER);
                        String str2 = strArrSplit[strArrSplit.length - 1];
                        String str3 = str2.split("\\.")[0];
                        File file = new File(com.byazt.nys.tt.tt(context), str2);
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            try {
                                byte[] bArr = new byte[4096];
                                while (true) {
                                    int i = zipInputStream.read(bArr);
                                    if (i == -1) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, i);
                                }
                                fileOutputStream.flush();
                                fileOutputStream.close();
                                Typeface typefaceCreateFromFile = Typeface.createFromFile(file);
                                if (!file.delete()) {
                                    com.byazt.kk.a.tt("Failed to delete temp font file " + file.getAbsolutePath() + Consts.DOT);
                                }
                                map2.put(str3, typefaceCreateFromFile);
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Throwable th3) {
                                        th.addSuppressed(th3);
                                    }
                                    throw th2;
                                }
                            }
                        } catch (Throwable th4) {
                            com.byazt.kk.a.c("Unable to save font " + str3 + " to the temporary file: " + str2 + ". ", th4);
                        }
                    }
                } else if (name.contains("../")) {
                    zipInputStream.closeEntry();
                    nextEntry = zipInputStream.getNextEntry();
                } else {
                    String[] strArrSplit2 = name.split(WVNativeCallbackUtil.SEPERATER);
                    map.put(strArrSplit2[strArrSplit2.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (aVarC == null) {
                return new t<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                i iVarC = c(aVarC, (String) entry.getKey());
                if (iVarC != null) {
                    iVarC.c(com.byazt.kk.da.c((Bitmap) entry.getValue(), iVarC.c(), iVarC.tt()));
                }
            }
            for (Map.Entry entry2 : map2.entrySet()) {
                boolean z = false;
                for (com.byazt.nb.ve veVar : aVarC.m().values()) {
                    if (veVar.c().equals(entry2.getKey())) {
                        veVar.c((Typeface) entry2.getValue());
                        z = true;
                    }
                }
                if (!z) {
                    com.byazt.kk.a.tt("Parsed font for " + ((String) entry2.getKey()) + " however it was not found in the animation.");
                }
            }
            if (map.isEmpty()) {
                Iterator<Map.Entry<String, i>> it = aVarC.nu().entrySet().iterator();
                while (it.hasNext()) {
                    i value = it.next().getValue();
                    if (value == null) {
                        return null;
                    }
                    String strU = value.u();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inScaled = true;
                    options.inDensity = 160;
                    if (strU.startsWith("data:") && strU.indexOf("base64,") > 0) {
                        try {
                            byte[] bArrDecode = Base64.decode(strU.substring(strU.indexOf(44) + 1), 0);
                            value.c(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
                        } catch (IllegalArgumentException e) {
                            com.byazt.kk.a.c("data URL did not have correct base64 format.", e);
                            return null;
                        }
                    }
                }
            }
            for (Map.Entry<String, i> entry3 : aVarC.nu().entrySet()) {
                if (entry3.getValue().z() == null) {
                    return new t<>((Throwable) new IllegalStateException("There is no image for " + entry3.getValue().u()));
                }
            }
            if (str != null) {
                com.byazt.nb.a.c().c(str, aVarC);
            }
            return new t<>(aVarC);
        } catch (IOException e2) {
            return new t<>((Throwable) e2);
        }
    }

    private static boolean c(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static u<a> c(final InputStream inputStream, final String str) {
        return c(str, new Callable<t<a>>() { // from class: com.byazt.ga.sp.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public t<a> call() throws Exception {
                return sp.tt(inputStream, str);
            }
        });
    }

    @WorkerThread
    private static t<a> c(InputStream inputStream, String str, boolean z) {
        try {
            return c(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z) {
                com.byazt.kk.da.c(inputStream);
            }
        }
    }

    @WorkerThread
    public static t<a> c(JsonReader jsonReader, String str) {
        return c(jsonReader, str, true);
    }

    private static t<a> c(JsonReader jsonReader, String str, boolean z) {
        try {
            a aVarC = gu.c(jsonReader);
            com.byazt.nb.a.c().c(str, aVarC);
            return new t<>(aVarC);
        } catch (Exception e) {
            return new t<>((Throwable) e);
        } finally {
            if (z) {
                c(jsonReader);
            }
        }
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    @WorkerThread
    public static t<a> c(Context context, ZipInputStream zipInputStream, String str) {
        try {
            return tt(context, zipInputStream, str);
        } finally {
            com.byazt.kk.da.c(zipInputStream);
        }
    }

    private static i c(a aVar, String str) {
        for (i iVar : aVar.nu().values()) {
            if (iVar.u().equals(str)) {
                return iVar;
            }
        }
        return null;
    }

    private static u<a> c(final String str, Callable<t<a>> callable) {
        final a aVarC = str == null ? null : com.byazt.nb.a.c().c(str);
        if (aVarC != null) {
            return new u<>(new Callable<t<a>>() { // from class: com.byazt.ga.sp.7
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public t<a> call() throws Exception {
                    return new t<>(aVarC);
                }
            });
        }
        if (str != null) {
            Map<String, u<a>> map = c;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        u<a> uVar = new u<>(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            uVar.c(new da<a>() { // from class: com.byazt.ga.sp.2
                @Override // com.byazt.ga.da
                public void c(a aVar) {
                    sp.c.remove(str);
                    atomicBoolean.set(true);
                    if (sp.c.size() == 0) {
                        sp.tt(true);
                    }
                }
            });
            uVar.ve(new da<Throwable>() { // from class: com.byazt.ga.sp.3
                @Override // com.byazt.ga.da
                public void c(Throwable th) {
                    sp.c.remove(str);
                    atomicBoolean.set(true);
                    if (sp.c.size() == 0) {
                        sp.tt(true);
                    }
                }
            });
            if (!atomicBoolean.get()) {
                Map<String, u<a>> map2 = c;
                map2.put(str, uVar);
                if (map2.size() == 1) {
                    tt(false);
                }
            }
        }
        return uVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(boolean z) {
        ArrayList arrayList = new ArrayList(tt);
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }
    }
}
