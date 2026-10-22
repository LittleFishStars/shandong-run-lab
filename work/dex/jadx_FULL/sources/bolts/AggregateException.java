package bolts;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class AggregateException extends Exception {
    private static final long serialVersionUID = 1;
    private Throwable[] causes;

    public AggregateException(String str, Throwable[] thArr) {
    }

    public Throwable[] getCauses() {
        return this.causes;
    }

    @Deprecated
    public List<Exception> getErrors() {
    }

    @Deprecated
    public AggregateException(List<Exception> list) {
    }
}
