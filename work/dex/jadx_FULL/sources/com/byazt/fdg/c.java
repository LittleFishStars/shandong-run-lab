package com.byazt.fdg;

import android.content.pm.Signature;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicReference;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, 20})
public class c {
    public static final AtomicReference<byte[]> c = new AtomicReference<>();

    public static z c(String str, boolean z) throws Throwable {
        JarFile jarFile = null;
        try {
            try {
                JarFile jarFile2 = new JarFile(str);
                try {
                    ArrayList<JarEntry> arrayList = new ArrayList();
                    JarEntry jarEntry = jarFile2.getJarEntry("AndroidManifest.xml");
                    if (jarEntry == null) {
                        throw new nu(1, "Package " + str + " has no manifest");
                    }
                    Certificate[][] certificateArrC = c(jarFile2, jarEntry);
                    if (com.byazt.uq.uj.c(certificateArrC)) {
                        throw new nu(4, "Package " + str + " has no certificates at entry AndroidManifest.xml");
                    }
                    Signature[] signatureArrC = uj.c(certificateArrC);
                    if (z) {
                        Enumeration<JarEntry> enumerationEntries = jarFile2.entries();
                        while (enumerationEntries.hasMoreElements()) {
                            JarEntry jarEntryNextElement = enumerationEntries.nextElement();
                            if (!jarEntryNextElement.isDirectory()) {
                                String name = jarEntryNextElement.getName();
                                if (!name.startsWith("META-INF/") && !name.equals("AndroidManifest.xml")) {
                                    arrayList.add(jarEntryNextElement);
                                }
                            }
                        }
                        for (JarEntry jarEntry2 : arrayList) {
                            Certificate[][] certificateArrC2 = c(jarFile2, jarEntry2);
                            if (com.byazt.uq.uj.c(certificateArrC2)) {
                                throw new nu(4, "Package " + str + " has no certificates at entry " + jarEntry2.getName());
                            }
                            if (!z.c(signatureArrC, uj.c(certificateArrC2))) {
                                throw new nu(3, "Package " + str + " has mismatched certificates at entry " + jarEntry2.getName());
                            }
                        }
                    }
                    z zVar = new z(signatureArrC, 1, null, null, null);
                    try {
                        jarFile2.close();
                    } catch (Exception unused) {
                    }
                    return zVar;
                } catch (IOException e) {
                    e = e;
                    throw new nu(4, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
                } catch (RuntimeException e2) {
                    e = e2;
                    throw new nu(4, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
                } catch (GeneralSecurityException e3) {
                    e = e3;
                    throw new nu(2, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
                } catch (Throwable th) {
                    th = th;
                    jarFile = jarFile2;
                    if (jarFile != null) {
                        try {
                            jarFile.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e4) {
            e = e4;
        } catch (RuntimeException e5) {
            e = e5;
        } catch (GeneralSecurityException e6) {
            e = e6;
        }
    }

    private static Certificate[][] c(JarFile jarFile, JarEntry jarEntry) throws nu {
        InputStream inputStream = null;
        try {
            try {
                InputStream inputStream2 = jarFile.getInputStream(jarEntry);
                c(inputStream2);
                Certificate[][] certificateArr = {jarEntry.getCertificates()};
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception unused) {
                    }
                }
                return certificateArr;
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException | RuntimeException e3) {
            throw new nu(5, "Failed reading " + jarEntry.getName() + " in " + jarFile, e3);
        }
    }

    private static void c(InputStream inputStream) throws IOException {
        byte[] andSet = c.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[4096];
        }
        while (inputStream.read(andSet, 0, andSet.length) != -1) {
        }
        c.set(andSet);
    }
}
