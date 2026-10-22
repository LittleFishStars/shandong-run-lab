package com.kwad.components.core.innerEc.live.widget;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a<T> extends Observable {
    private T XZ;
    private final CopyOnWriteArrayList<Observer> Ya = new CopyOnWriteArrayList<>();
    private boolean Yb = false;
    private Throwable Yc = null;

    private a(T t) {
        this.XZ = t;
    }

    public static <T> a<T> h(T t) {
        return new a<>(null);
    }

    @Override // java.util.Observable
    public final void addObserver(Observer observer) {
        if (!this.Yb && this.Yc == null) {
            this.Ya.add(observer);
            super.addObserver(observer);
            observer.update(this, this.XZ);
        }
    }

    public final void onNext(T t) {
        if (this.Yb || this.Yc != null) {
            return;
        }
        this.XZ = t;
        setChanged();
        notifyObservers(t);
    }
}
