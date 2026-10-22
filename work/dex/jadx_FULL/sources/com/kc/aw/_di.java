package com.kc.aw;

import android.content.Context;
import android.hardware.SensorManager;
import android.text.TextUtils;
import cn.hzjizhun.admin.util.ShellUtils;
import com.acse.ottn.p3;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _di {
    public static String _a(String str) {
        String str2;
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod(p3.f, String.class).invoke(null, str);
            str2 = objInvoke != null ? (String) objInvoke : null;
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2;
    }

    /* JADX WARN: Code duplicated, block: B:186:0x0274  */
    /* JADX WARN: Code duplicated, block: B:199:0x028f  */
    /* JADX WARN: Code duplicated, block: B:200:0x0293  */
    /* JADX WARN: Code duplicated, block: B:203:0x029a  */
    /* JADX WARN: Code duplicated, block: B:205:0x029e  */
    /* JADX WARN: Code duplicated, block: B:217:0x026f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:219:0x026a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:223:0x0282 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:225:0x027d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:242:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:243:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public static boolean _a(Context context) throws Throwable {
        int i;
        _b4 _b4Var;
        int i2;
        _b4 _b4Var2;
        _b4 _b4Var3;
        _b4 _b4Var4;
        _b4 _b4Var5;
        _b4 _b4Var6;
        _b4 _b4Var7;
        Throwable th;
        Process processExec;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream2;
        String str_a;
        _b4 _b4Var8;
        String str_a2 = _a("ro.hardware");
        BufferedOutputStream bufferedOutputStream2 = null;
        BufferedInputStream bufferedInputStream3 = null;
        if (str_a2 == null) {
            _b4Var = new _b4(0, null);
        } else {
            String lowerCase = str_a2.toLowerCase();
            lowerCase.getClass();
            switch (lowerCase) {
                case "cancro":
                case "vbox86":
                case "nox":
                case "ttvm":
                case "vbox":
                case "intel":
                case "android_x86":
                    i = 1;
                    break;
                default:
                    i = 2;
                    break;
            }
            _b4Var = new _b4(i, str_a2);
        }
        int i3 = _b4Var._a;
        if (i3 == 0) {
            i2 = 1;
        } else {
            if (i3 == 1) {
                return true;
            }
            i2 = 0;
        }
        String str_a3 = _a("ro.build.flavor");
        if (str_a3 == null) {
            _b4Var2 = new _b4(0, null);
        } else {
            String lowerCase2 = str_a3.toLowerCase();
            _b4Var2 = new _b4((lowerCase2.contains("vbox") || lowerCase2.contains("sdk_gphone")) ? 1 : 2, str_a3);
        }
        int i4 = _b4Var2._a;
        if (i4 == 0) {
            i2++;
        } else if (i4 == 1) {
            return true;
        }
        String str_a4 = _a("ro.product.model");
        if (str_a4 == null) {
            _b4Var3 = new _b4(0, null);
        } else {
            String lowerCase3 = str_a4.toLowerCase();
            _b4Var3 = new _b4((lowerCase3.contains("google_sdk") || lowerCase3.contains("emulator") || lowerCase3.contains("android sdk built for x86")) ? 1 : 2, str_a4);
        }
        int i5 = _b4Var3._a;
        if (i5 == 0) {
            i2++;
        } else if (i5 == 1) {
            return true;
        }
        String str_a5 = _a("ro.product.manufacturer");
        if (str_a5 == null) {
            _b4Var4 = new _b4(0, null);
        } else {
            String lowerCase4 = str_a5.toLowerCase();
            _b4Var4 = new _b4((lowerCase4.contains("genymotion") || lowerCase4.contains("netease")) ? 1 : 2, str_a5);
        }
        int i6 = _b4Var4._a;
        if (i6 == 0) {
            i2++;
        } else if (i6 == 1) {
            return true;
        }
        String str_a6 = _a("ro.product.board");
        if (str_a6 == null) {
            _b4Var5 = new _b4(0, null);
        } else {
            String lowerCase5 = str_a6.toLowerCase();
            _b4Var5 = new _b4((lowerCase5.contains("android") || lowerCase5.contains("goldfish")) ? 1 : 2, str_a6);
        }
        int i7 = _b4Var5._a;
        if (i7 == 0) {
            i2++;
        } else if (i7 == 1) {
            return true;
        }
        String str_a7 = _a("ro.board.platform");
        if (str_a7 == null) {
            _b4Var6 = new _b4(0, null);
        } else {
            _b4Var6 = new _b4(str_a7.toLowerCase().contains("android") ? 1 : 2, str_a7);
        }
        int i8 = _b4Var6._a;
        if (i8 == 0) {
            i2++;
        } else if (i8 == 1) {
            return true;
        }
        String str_a8 = _a("gsm.version.baseband");
        if (str_a8 == null) {
            _b4Var7 = new _b4(0, null);
        } else {
            _b4Var7 = new _b4(str_a8.contains("1.0.0.0") ? 1 : 2, str_a8);
        }
        int i9 = _b4Var7._a;
        if (i9 == 0) {
            i2 += 2;
        } else if (i9 == 1) {
            return true;
        }
        if (((SensorManager) context.getSystemService("sensor")).getSensorList(-1).size() <= 7) {
            i2++;
        }
        if (!context.getPackageManager().hasSystemFeature("android.hardware.camera.flash")) {
            i2++;
        }
        if (!context.getPackageManager().hasSystemFeature("android.hardware.camera")) {
            i2++;
        }
        if (!context.getPackageManager().hasSystemFeature("android.hardware.bluetooth")) {
            i2++;
        }
        if ((((SensorManager) context.getSystemService("sensor")).getDefaultSensor(5) != null) == false) {
            i2++;
        }
        try {
            processExec = Runtime.getRuntime().exec(ShellUtils.COMMAND_SH);
            try {
                bufferedOutputStream = new BufferedOutputStream(processExec.getOutputStream());
                try {
                    bufferedInputStream2 = new BufferedInputStream(processExec.getInputStream());
                    try {
                        bufferedOutputStream.write("cat /proc/self/cgroup".getBytes());
                        bufferedOutputStream.write(10);
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        processExec.waitFor();
                        str_a = _ba._a(bufferedInputStream2);
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException unused) {
                        }
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException unused2) {
                        }
                    } catch (Exception unused3) {
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException unused5) {
                            }
                        }
                        str_a = null;
                        if (processExec != null) {
                        }
                        if (str_a == null) {
                            _b4Var8 = new _b4(0, null);
                        } else {
                            _b4Var8 = new _b4(2, str_a);
                        }
                        if (_b4Var8._a == 0) {
                            i2++;
                        }
                        if (i2 > 3) {
                            return true;
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream3 = bufferedInputStream2;
                        BufferedInputStream bufferedInputStream4 = bufferedInputStream3;
                        bufferedOutputStream2 = bufferedOutputStream;
                        bufferedInputStream = bufferedInputStream4;
                        if (bufferedOutputStream2 != null) {
                            try {
                                bufferedOutputStream2.close();
                            } catch (IOException unused6) {
                            }
                        }
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException unused7) {
                            }
                        }
                        if (processExec != null) {
                            throw th;
                        }
                        processExec.destroy();
                        throw th;
                    }
                } catch (Exception unused8) {
                    bufferedInputStream2 = null;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception unused9) {
                bufferedOutputStream = null;
                bufferedInputStream2 = null;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                str_a = null;
                if (processExec != null) {
                    processExec.destroy();
                }
                if (str_a == null) {
                    _b4Var8 = new _b4(0, null);
                } else {
                    _b4Var8 = new _b4(2, str_a);
                }
                if (_b4Var8._a == 0) {
                    i2++;
                }
                if (i2 > 3) {
                    return true;
                }
                return false;
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
                if (bufferedOutputStream2 != null) {
                    bufferedOutputStream2.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (processExec != null) {
                    throw th;
                }
                processExec.destroy();
                throw th;
            }
        } catch (Exception unused10) {
            processExec = null;
        } catch (Throwable th5) {
            th = th5;
            processExec = null;
        }
        processExec.destroy();
        if (str_a == null) {
            _b4Var8 = new _b4(0, null);
        } else {
            _b4Var8 = new _b4(2, str_a);
        }
        if (_b4Var8._a == 0) {
            i2++;
        }
        if (i2 > 3) {
            return true;
        }
        return false;
    }
}
