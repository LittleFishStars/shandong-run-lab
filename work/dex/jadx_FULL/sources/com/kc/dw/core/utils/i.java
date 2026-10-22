package com.kc.dw.core.utils;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.FileTypes;
import com.kc.dw.core.domain.HttpResponse;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f39371a = Collections.synchronizedList(new ArrayList());
    public static final List<SoftReference<b>> b = Collections.synchronizedList(new ArrayList());
    public static final Object c = new Object();

    @Keep
    public class a implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f39372a;
        public final File b;
        public final File c;

        public a(String str, File file, File file2) {
            this.f39372a = str;
            this.b = file;
            this.c = file2;
        }

        @Override // com.kc.dw.core.utils.x
        public void onFailure(IOException iOException) {
            try {
                i.f39371a.remove(this.f39372a);
            } catch (Exception unused) {
            }
            i.a(false, this.f39372a);
        }

        @Override // com.kc.dw.core.utils.x
        public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
            List<String> list;
            FileOutputStream fileOutputStream = null;
            boolean zRenameTo = false;
            try {
                try {
                    if (httpResponse.isSuccessful()) {
                        byte[] responseBody = httpResponse.getResponseBody();
                        FileOutputStream fileOutputStream2 = new FileOutputStream(this.b);
                        try {
                            fileOutputStream2.write(responseBody);
                            fileOutputStream2.close();
                            zRenameTo = this.b.renameTo(this.c);
                            if (!zRenameTo) {
                                LogUtil.e("DefImageUtil", "rename error");
                            }
                            fileOutputStream = fileOutputStream2;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            try {
                                th.printStackTrace();
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Throwable unused) {
                                    }
                                }
                                list = i.f39371a;
                            } finally {
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Throwable unused2) {
                                    }
                                }
                                try {
                                    i.f39371a.remove(this.f39372a);
                                } catch (Exception unused3) {
                                }
                                i.a(zRenameTo, this.f39372a);
                            }
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused4) {
                        }
                    }
                    list = i.f39371a;
                } catch (Exception unused5) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
            list.remove(this.f39372a);
        }
    }

    @Keep
    public interface b {
        void a(String str);

        void b(String str);
    }

    public static void a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        File[] fileArrListFiles = b().listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = com.kc.dw.base.a.getSharedPreferences().edit();
        boolean z = false;
        for (File file : fileArrListFiles) {
            String name = file.getName();
            long jLastModified = com.kc.dw.base.a.getSharedPreferences().getLong(name, 0L);
            if (jLastModified == 0) {
                jLastModified = file.lastModified();
            }
            if (jCurrentTimeMillis - jLastModified > 2592000000L && file.delete()) {
                editorEdit.remove(name);
                try {
                    if (!TextUtils.isEmpty(name)) {
                        List<String> list = f39371a;
                        if (!list.isEmpty()) {
                            Iterator<String> it = list.iterator();
                            while (it.hasNext()) {
                                if (name.equals(b(it.next()))) {
                                    it.remove();
                                    break;
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                System.out.println("删除过期缓存文件: " + name);
                z = true;
            }
        }
        if (z) {
            editorEdit.apply();
        }
    }

    public static void a(b bVar) {
        boolean z;
        if (bVar == null) {
            return;
        }
        try {
            synchronized (c) {
                Iterator<SoftReference<b>> it = b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else if (it.next().get() == bVar) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    b.add(new SoftReference<>(bVar));
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String strB = b(str);
            File file = new File(b(), strB);
            if (file.exists()) {
                file.delete();
            }
            com.kc.dw.base.a.getSharedPreferences().edit().remove(strB).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(String str, boolean z, b bVar) {
        try {
            if (z) {
                try {
                    a();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (TextUtils.isEmpty(str)) {
                if (bVar != null) {
                    bVar.a(str);
                    return;
                }
                return;
            }
            String strB = b(str);
            File file = new File(b(), strB);
            if (file.exists()) {
                if (bVar != null) {
                    bVar.b(str);
                    return;
                }
                return;
            }
            a(bVar);
            List<String> list = f39371a;
            if (list.contains(str)) {
                return;
            }
            list.add(str);
            File file2 = new File(b(), strB + "_temp");
            if (file2.exists()) {
                file2.delete();
            }
            z.a(str, (x) new a(str, file2, file), false);
        } catch (Exception e) {
            e.printStackTrace();
            if (bVar != null) {
                bVar.a(str);
            }
        }
    }

    public static void a(List<String> list) {
        if (list != null) {
            try {
                if (list.isEmpty()) {
                    return;
                }
                int i = 0;
                while (i < list.size()) {
                    a(list.get(i), i == 0, null);
                    i++;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(boolean z, String str) {
        try {
            synchronized (c) {
                try {
                    for (SoftReference<b> softReference : b) {
                        if (z) {
                            try {
                                softReference.get().b(str);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        } else {
                            softReference.get().a(str);
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean a(byte[] bArr, String str) {
        Bitmap bitmapA;
        if (bArr == null) {
            return false;
        }
        try {
            if (bArr.length <= 0) {
                return false;
            }
            try {
                bitmapA = d0.a(bArr);
            } catch (Exception unused) {
                bitmapA = null;
            }
            if (bitmapA != null) {
                return true;
            }
            a(str);
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003a A[Catch: all -> 0x003d, DONT_GENERATE, TRY_LEAVE, TryCatch #5 {all -> 0x003d, blocks: (B:21:0x0035, B:23:0x003a), top: B:44:0x0035 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0046 A[Catch: all -> 0x0049, FINALLY_INSNS, TRY_LEAVE, TryCatch #3 {all -> 0x0049, blocks: (B:27:0x0041, B:29:0x0046), top: B:40:0x0041 }] */
    public static byte[] a(File file) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        fileInputStream.close();
                        byteArrayOutputStream.close();
                    } catch (Throwable unused) {
                    }
                    return byteArray;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                if (byteArrayOutputStream != null) {
                                }
                            } catch (Throwable unused2) {
                                return null;
                            }
                        } else if (byteArrayOutputStream != null) {
                        }
                        return null;
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                            } catch (Throwable unused3) {
                            }
                        } else if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            fileInputStream = null;
        }
    }

    public static File b() {
        File file = new File(com.kc.dw.base.a.getContext().getFilesDir(), "def_images");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String b(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                sb.append(String.format("%02x", Byte.valueOf(b2)));
            }
            return sb.toString() + FileTypes.F;
        } catch (Exception unused) {
            return String.valueOf(str.hashCode()) + FileTypes.F;
        }
    }

    public static void b(b bVar) {
        try {
            synchronized (c) {
                try {
                    for (SoftReference<b> softReference : b) {
                        if (softReference.get() == bVar) {
                            b.remove(softReference);
                            break;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static byte[] c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String strB = b(str);
            File file = new File(b(), strB);
            if (file.exists()) {
                com.kc.dw.base.a.getSharedPreferences().edit().putLong(strB, System.currentTimeMillis()).apply();
                return a(file);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }
}
