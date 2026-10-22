package androidx.p002lifecycle;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class MutableLiveData<T> extends LiveData<T> {
    public MutableLiveData(T t) {
        super(t);
    }

    @Override // androidx.p002lifecycle.LiveData
    public void postValue(T t) {
        super.postValue(t);
    }

    @Override // androidx.p002lifecycle.LiveData
    public void setValue(T t) {
        super.setValue(t);
    }

    public MutableLiveData() {
    }
}
