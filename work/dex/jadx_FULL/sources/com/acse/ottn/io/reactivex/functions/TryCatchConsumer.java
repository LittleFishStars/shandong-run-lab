package com.acse.ottn.io.reactivex.functions;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TryCatchConsumer<T> implements Consumer<T> {
    Consumer<T> consumer;

    public TryCatchConsumer(Consumer<T> consumer) {
        this.consumer = consumer;
    }

    @Override // com.acse.ottn.io.reactivex.functions.Consumer
    public void accept(T t) throws Exception {
        this.consumer.accept(t);
    }
}
