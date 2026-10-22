package com.bykv.vk.component.ttvideo;

import android.text.TextUtils;
import com.byazt.bzd.sp;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class LibraryLoader {
    private static final String TAG = "LibraryLoader";
    private static Loader sLoader;

    public interface Loader {
        void loadLibrary(String str) throws Exception;

        void loadLibraryFromPath(String str) throws Exception;
    }

    public static void loadLibrary(String str) throws Exception {
        Loader loader = sLoader;
        if (TextUtils.isEmpty(str)) {
            throw new Exception("Invalid library name.");
        }
        if (loader != null) {
            loader.loadLibrary(str);
        } else {
            sp.c(str);
        }
    }

    public static void loadLibraryFromPath(String str) throws Exception {
        Loader loader = sLoader;
        if (TextUtils.isEmpty(str)) {
            throw new Exception("Invalid library name.");
        }
        File file = new File(str);
        if (!file.exists()) {
            throw new Exception("Not found library '" + str + "' file.");
        }
        if (loader == null) {
            System.load(file.getAbsolutePath());
        } else {
            file.getAbsolutePath();
            loader.loadLibraryFromPath(file.getAbsolutePath());
        }
    }

    public static void setupLibraryLoader(Loader loader) {
        sLoader = loader;
    }
}
