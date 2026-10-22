package anetwork.network.cache;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface Cache {
    boolean a(String str);

    boolean b(String str, String str2);

    boolean c(String str, String str2, RpcCache rpcCache);

    RpcCache d(String str, String str2);

    boolean remove(String str);
}
