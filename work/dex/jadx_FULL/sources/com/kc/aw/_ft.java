package com.kc.aw;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ft implements _hn {
    public File _a = _a();

    @Keep
    public final class _a implements Runnable {
        public final _ho _a;
        public final _ft _b;

        public _a(_ft _ftVar, _ho _hoVar) {
            this._b = _ftVar;
            this._a = _hoVar;
        }

        /* JADX WARN: Code duplicated, block: B:101:0x0139  */
        /* JADX WARN: Code duplicated, block: B:103:0x0142  */
        /* JADX WARN: Code duplicated, block: B:105:0x0146  */
        /* JADX WARN: Code duplicated, block: B:107:0x0159  */
        /* JADX WARN: Code duplicated, block: B:109:0x0172  */
        /* JADX WARN: Code duplicated, block: B:111:0x0178  */
        /* JADX WARN: Code duplicated, block: B:113:0x0191  */
        /* JADX WARN: Code duplicated, block: B:123:0x0127 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:127:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:131:0x0067 A[EXC_TOP_SPLITTER, PHI: r2 r4
          0x0067: PHI (r2v16 java.io.InputStream) = (r2v15 java.io.InputStream), (r2v22 java.io.InputStream) binds: [B:27:0x0065, B:15:0x0054] A[DONT_GENERATE, DONT_INLINE]
          0x0067: PHI (r4v14 byte[]) = (r4v13 byte[]), (r4v18 byte[]) binds: [B:27:0x0065, B:15:0x0054] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:138:0x0122 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:154:? A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:156:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:98:0x0132  */
        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            byte[] byteArray;
            _cj _cjVar;
            _cn _cnVar;
            _ho _hoVar;
            BufferedReader bufferedReader;
            FileReader fileReader;
            Exception e;
            InputStream inputStreamOpenInputStream;
            PtgAdSdk.getConfig().getClass();
            PtgAdSdk.getConfig().getClass();
            String str_c = _jw._c(PtgAdSdk.getContext(), "local_config");
            if (this._b._a == null && TextUtils.isEmpty(str_c)) {
                Logger.d("LocalConfigPolicyLoader: not find local Policy");
                _ho _hoVar2 = this._a;
                if (_hoVar2 != null) {
                    _hoVar2._c("not find local Policy");
                    return;
                }
                return;
            }
            String string = "";
            FileReader fileReader2 = null;
            InputStream inputStream = null;
            BufferedReader bufferedReader2 = null;
            if (TextUtils.isEmpty("")) {
                byteArray = null;
            } else {
                try {
                    inputStreamOpenInputStream = PtgAdSdk.getContext().getContentResolver().openInputStream(Uri.parse(""));
                    try {
                        try {
                            byteArray = _nx._a(inputStreamOpenInputStream).toByteArray();
                            if (inputStreamOpenInputStream != null) {
                                try {
                                    inputStreamOpenInputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            e.printStackTrace();
                            byteArray = null;
                            if (inputStreamOpenInputStream != null) {
                                inputStreamOpenInputStream.close();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStreamOpenInputStream;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    inputStreamOpenInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th;
                }
                if (byteArray == null || byteArray.length == 0) {
                    Logger.e("find local policy file fail ，uri = ");
                }
            }
            String str = PtgAdSdk.getConfig()._i;
            if (TextUtils.isEmpty(str)) {
                Logger.e("local policy encode unset");
                _ho _hoVar3 = this._a;
                if (_hoVar3 != null) {
                    _hoVar3._c("local policy encode unset");
                    return;
                }
                return;
            }
            if (byteArray != null && byteArray.length > 0) {
                try {
                    string = new String(byteArray, Charset.forName(str));
                } catch (Exception unused) {
                    Logger.e("local policy decode fail");
                    _ho _hoVar4 = this._a;
                    if (_hoVar4 != null) {
                        _hoVar4._c("local policy decode fail");
                        return;
                    }
                    return;
                }
            }
            File file = this._b._a;
            if (file != null && file.exists()) {
                try {
                    StringBuilder sb = new StringBuilder();
                    fileReader = new FileReader(this._b._a);
                    try {
                        bufferedReader = new BufferedReader(fileReader);
                        while (true) {
                            try {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                } else {
                                    sb.append(line);
                                }
                            } catch (Exception unused2) {
                                try {
                                    Logger.e("global local policy read fail");
                                    if (fileReader != null) {
                                        try {
                                            fileReader.close();
                                        } catch (Exception unused3) {
                                        }
                                    }
                                    if (bufferedReader != null) {
                                    }
                                    if (!TextUtils.isEmpty(string)) {
                                        str_c = string;
                                    }
                                    if (TextUtils.isEmpty(str_c)) {
                                        Logger.e("all local policy decode fail");
                                        _hoVar = this._a;
                                        if (_hoVar != null) {
                                            _hoVar._c("all local policy decode fail");
                                            return;
                                        }
                                        return;
                                    }
                                    _cjVar = new _cj();
                                    _cnVar = new _cn();
                                    if (!_cnVar._c(str_c)) {
                                        this._b.getClass();
                                        Logger.e(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, "local policy config parse fail", (Object) null).getMessage());
                                        this._a._c("local policy config parse fail");
                                    } else if (_cjVar._a(str_c, _cnVar)) {
                                        this._a._a(_cjVar, _cnVar);
                                        this._a._b(str_c);
                                        this._a._a(str_c);
                                    } else {
                                        this._b.getClass();
                                        Logger.e(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, "local policy data parse fail", (Object) null).getMessage());
                                        this._a._c("local policy data parse fail");
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    fileReader2 = fileReader;
                                    fileReader = fileReader2;
                                    bufferedReader2 = bufferedReader;
                                    if (fileReader != null) {
                                        try {
                                            fileReader.close();
                                        } catch (Exception unused4) {
                                        }
                                    }
                                    if (bufferedReader2 != null) {
                                        throw th;
                                    }
                                    try {
                                        bufferedReader2.close();
                                        throw th;
                                    } catch (Exception unused5) {
                                        throw th;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                bufferedReader2 = bufferedReader;
                                if (fileReader != null) {
                                    fileReader.close();
                                }
                                if (bufferedReader2 != null) {
                                    throw th;
                                }
                                bufferedReader2.close();
                                throw th;
                            }
                        }
                        if (sb.length() > 0) {
                            string = sb.toString();
                        }
                        try {
                            fileReader.close();
                        } catch (Exception unused6) {
                        }
                    } catch (Exception unused7) {
                        bufferedReader = null;
                    } catch (Throwable th5) {
                        th = th5;
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        if (bufferedReader2 != null) {
                            throw th;
                        }
                        bufferedReader2.close();
                        throw th;
                    }
                } catch (Exception unused8) {
                    fileReader = null;
                    bufferedReader = null;
                } catch (Throwable th6) {
                    th = th6;
                    bufferedReader = null;
                    fileReader = fileReader2;
                    bufferedReader2 = bufferedReader;
                    if (fileReader != null) {
                        fileReader.close();
                    }
                    if (bufferedReader2 != null) {
                        throw th;
                    }
                    bufferedReader2.close();
                    throw th;
                }
                try {
                    bufferedReader.close();
                } catch (Exception unused9) {
                }
            }
            if (!TextUtils.isEmpty(string)) {
                str_c = string;
            }
            if (TextUtils.isEmpty(str_c)) {
                Logger.e("all local policy decode fail");
                _hoVar = this._a;
                if (_hoVar != null) {
                    _hoVar._c("all local policy decode fail");
                    return;
                }
                return;
            }
            _cjVar = new _cj();
            _cnVar = new _cn();
            if (!_cnVar._c(str_c)) {
                this._b.getClass();
                Logger.e(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, "local policy config parse fail", (Object) null).getMessage());
                this._a._c("local policy config parse fail");
            } else if (_cjVar._a(str_c, _cnVar)) {
                this._b.getClass();
                Logger.e(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, "local policy data parse fail", (Object) null).getMessage());
                this._a._c("local policy data parse fail");
            } else {
                this._a._a(_cjVar, _cnVar);
                this._a._b(str_c);
                this._a._a(str_c);
            }
        }
    }

    public static File _a() {
        Context context = PtgAdSdk.getContext();
        if (context != null && !TextUtils.isEmpty(PtgAdSdk.getConfig()._j)) {
            try {
                File file = new File(context.getExternalFilesDir(null), PtgAdSdk.getConfig()._j);
                if (file.exists() && file.canRead()) {
                    return file;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Override // com.kc.aw._hn
    public final void _a(_ho _hoVar) {
        _b(_hoVar);
    }

    @Override // com.kc.aw._hn
    public final void _b(_ho _hoVar) {
        com.kc.aw.lib.utils._d._b(new _a(this, _hoVar));
    }
}
