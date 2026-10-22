package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;
import com.alibaba.appmonitor.pool.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MeasureValue implements Parcelable, b {
    public static final Parcelable.Creator<MeasureValue> CREATOR = new Parcelable.Creator<MeasureValue>() { // from class: com.alibaba.mtl.appmonitor.model.MeasureValue.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MeasureValue createFromParcel(Parcel parcel) {
            return MeasureValue.readFromParcel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MeasureValue[] newArray(int i) {
            return new MeasureValue[i];
        }
    };
    private List<a> buckets;
    private boolean finish;
    private Double offset;
    private double value;

    public class a {
        private Double b;
        private Double c;
        private long o = 0;

        public a(Double d, Double d2) {
            this.b = d;
            this.c = d2;
        }

        public void ae() {
            this.o++;
        }

        public boolean a(Double d) {
            if (d == null) {
                return false;
            }
            Double dValueOf = this.b;
            Double dValueOf2 = this.c;
            if (dValueOf == null) {
                dValueOf = Double.valueOf(Double.MIN_VALUE);
            }
            if (dValueOf2 == null) {
                dValueOf2 = Double.valueOf(Double.MAX_VALUE);
            }
            return d.doubleValue() >= dValueOf.doubleValue() && d.doubleValue() < dValueOf2.doubleValue();
        }
    }

    @Deprecated
    public MeasureValue() {
    }

    public static MeasureValue create() {
        return (MeasureValue) com.alibaba.appmonitor.pool.a.a().a(MeasureValue.class, new Object[0]);
    }

    private a getBucket(double d) {
        if (this.buckets == null) {
            return null;
        }
        for (int i = 0; i < this.buckets.size(); i++) {
            if (this.buckets.get(i).a(Double.valueOf(d))) {
                return this.buckets.get(i);
            }
        }
        return null;
    }

    public static MeasureValue readFromParcel(Parcel parcel) {
        MeasureValue measureValueCreate = null;
        try {
            boolean z = parcel.readInt() != 0;
            Double dValueOf = Double.valueOf(parcel.readDouble());
            double d = parcel.readDouble();
            measureValueCreate = create();
            measureValueCreate.finish = z;
            measureValueCreate.offset = dValueOf;
            measureValueCreate.value = d;
            return measureValueCreate;
        } catch (Throwable th) {
            th.printStackTrace();
            return measureValueCreate;
        }
    }

    @Override // com.alibaba.appmonitor.pool.b
    public synchronized void clean() {
        this.value = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.offset = null;
        this.finish = false;
        this.buckets = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.alibaba.appmonitor.pool.b
    public synchronized void fill(Object... objArr) {
        if (objArr == null) {
            return;
        }
        if (objArr.length > 0) {
            this.value = ((Double) objArr[0]).doubleValue();
        }
        if (objArr.length > 1) {
            this.offset = (Double) objArr[1];
            this.finish = false;
        }
    }

    public synchronized Map<String, Double> getBuckets() {
        if (this.buckets == null) {
            return null;
        }
        HashMap map = new HashMap();
        for (a aVar : this.buckets) {
            if (aVar.o > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(aVar.b == null ? "-∞" : aVar.b);
                sb.append(",");
                sb.append(aVar.c == null ? "∞" : aVar.c);
                map.put(sb.toString(), Long.valueOf(aVar.o));
            }
        }
        return map;
    }

    public Double getOffset() {
        return this.offset;
    }

    public double getValue() {
        return this.value;
    }

    public boolean isFinish() {
        return this.finish;
    }

    public synchronized void setBuckets(Measure measure) {
        List<Double> bounds = measure.getBounds();
        if (bounds != null && bounds.size() >= 2) {
            if (this.buckets != null) {
                return;
            }
            this.buckets = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i2 >= bounds.size()) {
                    break;
                }
                this.buckets.add(new a(bounds.get(i), bounds.get(i2)));
                i = i2;
            }
            a bucket = getBucket(this.value);
            if (bucket != null) {
                bucket.ae();
            }
        }
    }

    public void setFinish(boolean z) {
        this.finish = z;
    }

    public void setOffset(double d) {
        this.offset = Double.valueOf(d);
    }

    public void setValue(double d) {
        this.value = d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeInt(this.finish ? 1 : 0);
            Double d = this.offset;
            parcel.writeDouble(d == null ? AudioStats.AUDIO_AMPLITUDE_NONE : d.doubleValue());
            parcel.writeDouble(this.value);
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    public MeasureValue(double d) {
        this.value = d;
    }

    public static MeasureValue create(double d) {
        return (MeasureValue) com.alibaba.appmonitor.pool.a.a().a(MeasureValue.class, Double.valueOf(d));
    }

    public synchronized void merge(MeasureValue measureValue) {
        if (measureValue == null) {
            return;
        }
        try {
            this.value += measureValue.getValue();
            if (measureValue.getOffset() != null) {
                if (this.offset == null) {
                    this.offset = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
                }
                this.offset = Double.valueOf(this.offset.doubleValue() + measureValue.getOffset().doubleValue());
            }
            a bucket = getBucket(measureValue.getValue());
            if (bucket != null) {
                bucket.ae();
            }
        } catch (Throwable unused) {
        }
    }

    public static MeasureValue create(double d, double d2) {
        return (MeasureValue) com.alibaba.appmonitor.pool.a.a().a(MeasureValue.class, Double.valueOf(d), Double.valueOf(d2));
    }

    @Deprecated
    public MeasureValue(double d, double d2) {
        this.offset = Double.valueOf(d2);
        this.value = d;
        this.finish = false;
    }
}
