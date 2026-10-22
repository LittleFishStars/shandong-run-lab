package androidx.coroutines;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface ObservableList<T> extends List<T> {

    public static abstract class OnListChangedCallback<T extends ObservableList> {
        public abstract void onChanged(T sender);

        public abstract void onItemRangeChanged(T sender, int positionStart, int itemCount);

        public abstract void onItemRangeInserted(T sender, int positionStart, int itemCount);

        public abstract void onItemRangeMoved(T sender, int fromPosition, int toPosition, int itemCount);

        public abstract void onItemRangeRemoved(T sender, int positionStart, int itemCount);
    }

    void addOnListChangedCallback(OnListChangedCallback<? extends ObservableList<T>> callback);

    void removeOnListChangedCallback(OnListChangedCallback<? extends ObservableList<T>> callback);
}
