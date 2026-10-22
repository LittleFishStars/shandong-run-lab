package com.zj.adlib;

import android.os.Environment;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.text.format.Formatter;
import com.blankj.utilcode.util.CollectionUtils;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.i;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class dr7 {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f41262a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f16063a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f16064a;
        public long b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public String f16065b;

        public a(String str, String str2, boolean z) {
            this.f16063a = str;
            this.f16065b = str2;
            this.f16064a = z;
            this.f41262a = i.R(str);
            this.b = i.Q(str);
        }

        public long c() {
            return this.b;
        }

        public String d() {
            return this.f16063a;
        }

        public String e() {
            return this.f16065b;
        }

        public long f() {
            return this.f41262a;
        }

        public boolean g() {
            return this.f16064a;
        }

        public String toString() {
            return "SDCardInfo {path = " + this.f16063a + ", state = " + this.f16065b + ", isRemovable = " + this.f16064a + ", totalSize = " + Formatter.formatFileSize(Utils.a(), this.f41262a) + ", availableSize = " + Formatter.formatFileSize(Utils.a(), this.b) + '}';
        }
    }

    public dr7() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static long a() {
        return i.Q(g());
    }

    public static long b() {
        return i.R(g());
    }

    public static long c() {
        return i.Q(Environment.getDataDirectory().getAbsolutePath());
    }

    public static long d() {
        return i.R(Environment.getDataDirectory().getAbsolutePath());
    }

    public static List<String> e() {
        ArrayList arrayList = new ArrayList();
        List<a> listF = f();
        if (listF != null && !listF.isEmpty()) {
            for (a aVar : listF) {
                String str = aVar.f16065b;
                if (str != null && "mounted".equals(str.toLowerCase())) {
                    arrayList.add(aVar.f16063a);
                }
            }
        }
        return arrayList;
    }

    public static List<a> f() {
        ArrayList arrayList = new ArrayList();
        StorageManager storageManager = (StorageManager) Utils.a().getSystemService("storage");
        if (storageManager == null) {
            return arrayList;
        }
        List<StorageVolume> storageVolumes = storageManager.getStorageVolumes();
        if (CollectionUtils.r(storageVolumes)) {
            return arrayList;
        }
        try {
            Method method = StorageVolume.class.getMethod("getPath", new Class[0]);
            if (method == null) {
                return arrayList;
            }
            for (StorageVolume storageVolume : storageVolumes) {
                boolean zIsRemovable = storageVolume.isRemovable();
                arrayList.add(new a((String) method.invoke(storageVolume, new Object[0]), storageVolume.getState(), zIsRemovable));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
        return arrayList;
    }

    public static String g() {
        return h() ? Environment.getExternalStorageDirectory().getAbsolutePath() : "";
    }

    public static boolean h() {
        return "mounted".equals(Environment.getExternalStorageState());
    }
}
