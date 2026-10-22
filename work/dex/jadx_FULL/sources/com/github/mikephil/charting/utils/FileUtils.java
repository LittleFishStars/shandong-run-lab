package com.github.mikephil.charting.utils;

import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FileUtils {
    private static final String LOG = "MPChart-FileUtils";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public static List<BarEntry> loadBarEntriesFromAssets(AssetManager assetManager, String str) throws Throwable {
        ArrayList arrayList = new ArrayList();
        ?? r2 = 0;
        float f = 0.0f;
        r2 = 0;
        r2 = 0;
        try {
            try {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(str), "UTF-8"));
                    try {
                        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                            String[] strArrSplit = line.split("#");
                            f = Float.parseFloat(strArrSplit[1]);
                            arrayList.add(new BarEntry(f, Float.parseFloat(strArrSplit[0])));
                        }
                        bufferedReader.close();
                        r2 = f;
                    } catch (IOException e) {
                        e = e;
                        r2 = bufferedReader;
                        Log.e(LOG, e.toString());
                        if (r2 != 0) {
                            r2.close();
                            r2 = r2;
                        }
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        r2 = bufferedReader;
                        if (r2 != 0) {
                            try {
                                r2.close();
                            } catch (IOException e2) {
                                Log.e(LOG, e2.toString());
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    Log.e(LOG, e3.toString());
                }
            } catch (IOException e4) {
                e = e4;
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10, types: [float[]] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13, types: [float] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0081 -> B:37:0x0088). Please report as a decompilation issue!!! */
    public static List<Entry> loadEntriesFromAssets(AssetManager assetManager, String str) throws Throwable {
        ?? r2;
        ArrayList arrayList = new ArrayList();
        ?? r3 = 0;
        ?? r4 = 0;
        BufferedReader bufferedReader = null;
        r3 = 0;
        try {
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(assetManager.open(str), "UTF-8"));
                    try {
                        String line = bufferedReader2.readLine();
                        while (line != null) {
                            String[] strArrSplit = line.split("#");
                            if (strArrSplit.length <= 2) {
                                r2 = Float.parseFloat(strArrSplit[1]);
                                arrayList.add(new Entry(r2, Float.parseFloat(strArrSplit[0])));
                            } else {
                                int length = strArrSplit.length - 1;
                                r2 = new float[length];
                                for (int i = 0; i < length; i++) {
                                    r2[i] = Float.parseFloat(strArrSplit[i]);
                                }
                                arrayList.add(new BarEntry(Integer.parseInt(strArrSplit[strArrSplit.length - 1]), (float[]) r2));
                            }
                            line = bufferedReader2.readLine();
                            r4 = r2;
                        }
                        bufferedReader2.close();
                        r3 = r4;
                    } catch (IOException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        Log.e(LOG, e.toString());
                        r3 = bufferedReader;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                            r3 = bufferedReader;
                        }
                    } catch (Throwable th) {
                        th = th;
                        r3 = bufferedReader2;
                        if (r3 != 0) {
                            try {
                                r3.close();
                            } catch (IOException e2) {
                                Log.e(LOG, e2.toString());
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (IOException e4) {
            Log.e(LOG, e4.toString());
            r3 = r3;
        }
        return arrayList;
    }

    public static List<Entry> loadEntriesFromFile(String str) {
        File file = new File(Environment.getExternalStorageDirectory(), str);
        ArrayList arrayList = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] strArrSplit = line.split("#");
                if (strArrSplit.length <= 2) {
                    arrayList.add(new Entry(Float.parseFloat(strArrSplit[0]), Integer.parseInt(strArrSplit[1])));
                } else {
                    int length = strArrSplit.length - 1;
                    float[] fArr = new float[length];
                    for (int i = 0; i < length; i++) {
                        fArr[i] = Float.parseFloat(strArrSplit[i]);
                    }
                    arrayList.add(new BarEntry(Integer.parseInt(strArrSplit[strArrSplit.length - 1]), fArr));
                }
            }
        } catch (IOException e) {
            Log.e(LOG, e.toString());
        }
        return arrayList;
    }

    public static void saveToSdCard(List<Entry> list, String str) {
        File file = new File(Environment.getExternalStorageDirectory(), str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                Log.e(LOG, e.toString());
            }
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            for (Entry entry : list) {
                bufferedWriter.append((CharSequence) (entry.getY() + "#" + entry.getX()));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e2) {
            Log.e(LOG, e2.toString());
        }
    }
}
