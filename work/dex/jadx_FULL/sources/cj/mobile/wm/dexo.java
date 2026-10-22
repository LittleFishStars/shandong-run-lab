package cj.mobile.wm;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class dexo implements dexn {
    public dexn dexa;

    public dexo(String str) {
        try {
            this.dexa = (dexn) Class.forName(str).newInstance();
        } catch (ClassNotFoundException unused) {
            throw new IllegalArgumentException("Stringfog implementation class not found: " + str);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Stringfog implementation class access failed: " + e.getMessage());
        } catch (InstantiationException e2) {
            throw new IllegalArgumentException("Stringfog implementation class new instance failed: " + e2.getMessage());
        }
    }

    @Override // cj.mobile.wm.dexn
    public String decrypt(String str, String str2) {
        dexn dexnVar = this.dexa;
        return dexnVar == null ? str : dexnVar.decrypt(str, str2);
    }

    @Override // cj.mobile.wm.dexn
    public String encrypt(String str, String str2) {
        dexn dexnVar = this.dexa;
        return dexnVar == null ? str : dexnVar.encrypt(str, str2);
    }

    @Override // cj.mobile.wm.dexn
    public boolean overflow(String str, String str2) {
        dexn dexnVar = this.dexa;
        return dexnVar != null && dexnVar.overflow(str, str2);
    }
}
