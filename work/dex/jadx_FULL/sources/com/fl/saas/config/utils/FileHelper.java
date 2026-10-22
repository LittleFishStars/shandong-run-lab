package com.fl.saas.config.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FileHelper {
    public static void deleteAllFilesInDirectory(File file) {
        File[] fileArrListFiles;
        if (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isFile()) {
                try {
                    file2.delete();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (file2.isDirectory()) {
                deleteAllFilesInDirectory(file2);
            }
        }
    }

    public static void deleteFile(File file) {
        if (file == null || file.exists()) {
            return;
        }
        try {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                deleteAllFilesInDirectory(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteNotSelectedFilesInDirectory(File file, List<String> list) {
        deleteSelectedFilesDirectory(file, list, false);
    }

    private static void deleteSelectedFilesDirectory(File file, List<String> list, boolean z) {
        File[] fileArrListFiles;
        if (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (list.contains(file2.getName()) == z) {
                return;
            }
            if (file2.isFile()) {
                try {
                    file2.delete();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                deleteAllFilesInDirectory(file2);
            }
        }
    }

    public static void deleteSelectedFilesInDirectory(File file, List<String> list) {
        deleteSelectedFilesDirectory(file, list, true);
    }

    public static InputStream getAssets(String str) {
        try {
            return DeviceUtil.getContext().getAssets().open(str);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> getFileNamesInDirectory(File file) {
        File[] fileArrListFiles;
        ArrayList arrayList = new ArrayList();
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    arrayList.add(file2.getPath());
                }
            }
        }
        return arrayList;
    }
}
