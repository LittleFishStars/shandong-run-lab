package androidx.camera.video;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
final class AutoValue_Quality_ConstantQuality extends Quality.ConstantQuality {
    private final String name;
    private final int value;

    public AutoValue_Quality_ConstantQuality(int i, String str) {
        this.value = i;
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.name = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Quality.ConstantQuality)) {
            return false;
        }
        Quality.ConstantQuality constantQuality = (Quality.ConstantQuality) obj;
        return this.value == constantQuality.getValue() && this.name.equals(constantQuality.getName());
    }

    @Override // androidx.camera.video.Quality.ConstantQuality
    @NonNull
    public String getName() {
        return this.name;
    }

    @Override // androidx.camera.video.Quality.ConstantQuality
    public int getValue() {
        return this.value;
    }

    public int hashCode() {
        return ((this.value ^ 1000003) * 1000003) ^ this.name.hashCode();
    }

    public String toString() {
        return "ConstantQuality{value=" + this.value + ", name=" + this.name + "}";
    }
}
