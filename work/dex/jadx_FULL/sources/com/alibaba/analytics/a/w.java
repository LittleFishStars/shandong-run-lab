package com.alibaba.analytics.a;

import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class w {
    public static double b() {
        return (new StatFs(Environment.getRootDirectory().getPath()).getAvailableBytes() / 1024.0d) / 1024.0d;
    }

    public static String z() {
        String line = null;
        try {
            FileReader fileReader = new FileReader("/proc/cpuinfo");
            try {
                BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
                line = bufferedReader.readLine();
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                Log.e("SystemUtils", "Could not read from file /proc/cpuinfo :" + e.toString());
            }
        } catch (Exception e2) {
            Log.e("SystemUtils", "BaseParameter-Could not open file /proc/cpuinfo :" + e2.toString());
        }
        return line != null ? line.substring(line.indexOf(58) + 1).trim() : "";
    }
}
