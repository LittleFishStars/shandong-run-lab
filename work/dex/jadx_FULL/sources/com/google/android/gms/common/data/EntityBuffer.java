package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.zj.adlib.yw6;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public abstract class EntityBuffer<T> extends AbstractDataBuffer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f31275a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f5635a;

    @KeepForSdk
    public EntityBuffer(@NonNull DataHolder dataHolder) {
        super(dataHolder);
        this.f5635a = false;
    }

    public final int a(int i) {
        if (i >= 0 && i < this.f31275a.size()) {
            return ((Integer) this.f31275a.get(i)).intValue();
        }
        throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
    }

    public final void g() {
        synchronized (this) {
            if (!this.f5635a) {
                int count = ((DataHolder) yw6.l(((AbstractDataBuffer) this).f31272a)).getCount();
                ArrayList arrayList = new ArrayList();
                this.f31275a = arrayList;
                if (count > 0) {
                    arrayList.add(0);
                    String primaryDataMarkerColumn = getPrimaryDataMarkerColumn();
                    String string = ((AbstractDataBuffer) this).f31272a.getString(primaryDataMarkerColumn, 0, ((AbstractDataBuffer) this).f31272a.getWindowIndex(0));
                    for (int i = 1; i < count; i++) {
                        int windowIndex = ((AbstractDataBuffer) this).f31272a.getWindowIndex(i);
                        String string2 = ((AbstractDataBuffer) this).f31272a.getString(primaryDataMarkerColumn, i, windowIndex);
                        if (string2 == null) {
                            throw new NullPointerException("Missing value for markerColumn: " + primaryDataMarkerColumn + ", at row: " + i + ", for window: " + windowIndex);
                        }
                        if (!string2.equals(string)) {
                            this.f31275a.add(Integer.valueOf(i));
                            string = string2;
                        }
                    }
                }
                this.f5635a = true;
            }
        }
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @NonNull
    @KeepForSdk
    public final T get(int i) {
        int iIntValue;
        int iIntValue2;
        g();
        int iA = a(i);
        int i2 = 0;
        if (i >= 0 && i != this.f31275a.size()) {
            if (i == this.f31275a.size() - 1) {
                iIntValue = ((DataHolder) yw6.l(((AbstractDataBuffer) this).f31272a)).getCount();
                iIntValue2 = ((Integer) this.f31275a.get(i)).intValue();
            } else {
                iIntValue = ((Integer) this.f31275a.get(i + 1)).intValue();
                iIntValue2 = ((Integer) this.f31275a.get(i)).intValue();
            }
            int i3 = iIntValue - iIntValue2;
            if (i3 == 1) {
                int iA2 = a(i);
                int windowIndex = ((DataHolder) yw6.l(((AbstractDataBuffer) this).f31272a)).getWindowIndex(iA2);
                String childDataMarkerColumn = getChildDataMarkerColumn();
                if (childDataMarkerColumn == null || ((AbstractDataBuffer) this).f31272a.getString(childDataMarkerColumn, iA2, windowIndex) != null) {
                    i2 = 1;
                }
            } else {
                i2 = i3;
            }
        }
        return getEntry(iA, i2);
    }

    @Nullable
    @KeepForSdk
    public String getChildDataMarkerColumn() {
        return null;
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @KeepForSdk
    public int getCount() {
        g();
        return this.f31275a.size();
    }

    @NonNull
    @KeepForSdk
    public abstract T getEntry(int i, int i2);

    @NonNull
    @KeepForSdk
    public abstract String getPrimaryDataMarkerColumn();
}
