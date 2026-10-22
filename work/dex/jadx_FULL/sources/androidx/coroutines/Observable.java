package androidx.coroutines;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface Observable {

    public static abstract class OnPropertyChangedCallback {
        public abstract void onPropertyChanged(Observable sender, int propertyId);
    }

    void addOnPropertyChangedCallback(OnPropertyChangedCallback callback);

    void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback);
}
