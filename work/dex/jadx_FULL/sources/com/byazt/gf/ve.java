package com.byazt.gf;

import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 914, 54})
public class ve {
    public static float[] c(List<Float> list, List<Float> list2, List<Float> list3, List<Float> list4, List<Float> list5, List<Float> list6) {
        int iMin = Math.min(list.size(), list4.size());
        float degrees = 0.0f;
        char c = 0;
        float f = 0.0f;
        float degrees2 = 0.0f;
        int i = 0;
        while (i < iMin) {
            Float f2 = list.get(i);
            Float f3 = list2.get(i);
            Float f4 = list3.get(i);
            Float f5 = list4.get(i);
            Float f6 = list5.get(i);
            Float f7 = list6.get(i);
            if (f2 == null || f3 == null || f4 == null || f5 == null || f6 == null || f7 == null) {
                break;
            }
            float[] fArr = new float[3];
            fArr[c] = f2.floatValue();
            fArr[1] = f3.floatValue();
            fArr[2] = f4.floatValue();
            float[] fArr2 = new float[3];
            fArr2[c] = f5.floatValue();
            fArr2[1] = f6.floatValue();
            fArr2[2] = f7.floatValue();
            float[] fArr3 = new float[9];
            float[] fArr4 = new float[3];
            SensorManager.getRotationMatrix(fArr3, null, fArr, fArr2);
            SensorManager.getOrientation(fArr3, fArr4);
            degrees += (((float) Math.toDegrees(fArr4[c])) + 360.0f) % 360.0f;
            float degrees3 = (((float) Math.toDegrees(fArr4[1])) + 360.0f) % 360.0f;
            degrees2 += (((float) Math.toDegrees(fArr4[2])) + 360.0f) % 360.0f;
            i++;
            f = degrees3 + f;
            c = 0;
        }
        float f8 = f;
        if (iMin == 0) {
            return new float[]{0.0f, 0.0f, 0.0f};
        }
        float f9 = iMin;
        return new float[]{degrees / f9, f8 / f9, degrees2 / f9};
    }

    @NonNull
    public static int[][] c(List<JSONObject> list, long j, long j2) throws JSONException {
        int size = list.size();
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        double[] dArr3 = new double[size];
        for (int i = 0; i < size; i++) {
            JSONArray jSONArrayOptJSONArray = list.get(i).optJSONArray("val");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() == 3) {
                dArr[i] = jSONArrayOptJSONArray.getDouble(0);
                dArr2[i] = jSONArrayOptJSONArray.getDouble(1);
                dArr3[i] = jSONArrayOptJSONArray.getDouble(2);
            }
        }
        return new int[][]{c(dArr, j), c(dArr2, j2), c(dArr3, j2)};
    }

    @NonNull
    public static int[] c(double[] dArr, long j) {
        if (j <= 0 || j > 360) {
            return new int[0];
        }
        int[] iArr = new int[(int) (360 / j)];
        for (double d : dArr) {
            int i = (int) (d / j);
            iArr[i] = iArr[i] + 1;
        }
        return iArr;
    }

    @NonNull
    public static int[] c(LinkedList<JSONObject> linkedList, int i) {
        int[] iArr = new int[i];
        if (linkedList != null && !linkedList.isEmpty()) {
            int iOptLong = (int) (((linkedList.get(linkedList.size() - 1).optLong("t", 0L) / 1000) / 60) / 60);
            Iterator<JSONObject> it = linkedList.iterator();
            while (it.hasNext()) {
                int iOptLong2 = iOptLong - ((int) (((it.next().optLong("t", 0L) / 1000) / 60) / 60));
                if (iOptLong2 >= 0 && iOptLong2 < i) {
                    iArr[iOptLong2] = iArr[iOptLong2] + 1;
                }
            }
        }
        return iArr;
    }
}
