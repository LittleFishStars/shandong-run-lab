package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public final class SurfaceCombination {
    private final List<SurfaceConfig> mSurfaceConfigList = new ArrayList();

    private static void generateArrangements(List<int[]> list, int i, int[] iArr, int i2) {
        boolean z;
        if (i2 >= iArr.length) {
            list.add((int[]) iArr.clone());
            return;
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = 0;
            while (true) {
                if (i4 >= i2) {
                    z = false;
                    break;
                } else {
                    if (i3 == iArr[i4]) {
                        z = true;
                        break;
                    }
                    i4++;
                }
            }
            if (!z) {
                iArr[i2] = i3;
                generateArrangements(list, i, iArr, i2 + 1);
            }
        }
    }

    private List<int[]> getElementsArrangements(int i) {
        ArrayList arrayList = new ArrayList();
        generateArrangements(arrayList, i, new int[i], 0);
        return arrayList;
    }

    public boolean addSurfaceConfig(@NonNull SurfaceConfig surfaceConfig) {
        return this.mSurfaceConfigList.add(surfaceConfig);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0079  */
    /* JADX WARN: Code duplicated, block: B:34:? A[RETURN, SYNTHETIC] */
    @Nullable
    public List<SurfaceConfig> getOrderedSupportedSurfaceConfigList(@NonNull List<SurfaceConfig> list) {
        int i;
        boolean zIsSupported;
        if (list.isEmpty()) {
            return new ArrayList();
        }
        if (list.size() != this.mSurfaceConfigList.size()) {
            return null;
        }
        List<int[]> elementsArrangements = getElementsArrangements(this.mSurfaceConfigList.size());
        SurfaceConfig[] surfaceConfigArr = new SurfaceConfig[list.size()];
        Iterator<int[]> it = elementsArrangements.iterator();
        do {
            i = 0;
            if (it.hasNext()) {
                int[] next = it.next();
                zIsSupported = true;
                while (i < this.mSurfaceConfigList.size()) {
                    if (next[i] < list.size()) {
                        zIsSupported &= this.mSurfaceConfigList.get(i).isSupported(list.get(next[i]));
                        if (!zIsSupported) {
                            break;
                        }
                        surfaceConfigArr[next[i]] = this.mSurfaceConfigList.get(i);
                    }
                    i++;
                }
            }
            if (i != 0) {
                return Arrays.asList(surfaceConfigArr);
            }
            return null;
        } while (!zIsSupported);
        i = 1;
        if (i != 0) {
            return Arrays.asList(surfaceConfigArr);
        }
        return null;
    }

    @NonNull
    public List<SurfaceConfig> getSurfaceConfigList() {
        return this.mSurfaceConfigList;
    }

    public boolean removeSurfaceConfig(@NonNull SurfaceConfig surfaceConfig) {
        return this.mSurfaceConfigList.remove(surfaceConfig);
    }
}
