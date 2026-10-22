package com.kwad.sdk.crash.utils;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class d {
    /* JADX WARN: Code duplicated, block: B:55:0x00ca  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.io.BufferedReader, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public static List<String> a(String[] strArr, int i) throws Throwable {
        Process processF;
        OutputStream outputStream;
        InputStream inputStream;
        InputStream errorStream;
        ?? bufferedReader;
        ?? r5;
        ArrayList arrayList = new ArrayList(20);
        InputStream inputStream2 = null;
        try {
            processF = f(strArr);
            try {
                inputStream = processF.getInputStream();
                try {
                    outputStream = processF.getOutputStream();
                    try {
                        errorStream = processF.getErrorStream();
                        try {
                            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                            try {
                                for (String line = bufferedReader.readLine(); line != null && arrayList.size() < 0; line = bufferedReader.readLine()) {
                                    arrayList.add(line);
                                }
                                processF.waitFor();
                                if (processF.exitValue() != 0) {
                                    throw new IOException("Command line returned OS error code '" + processF.exitValue() + "' for command " + Arrays.asList(strArr));
                                }
                                b.closeQuietly(inputStream);
                                b.closeQuietly(outputStream);
                                b.closeQuietly(errorStream);
                                b.closeQuietly((Closeable) bufferedReader);
                                processF.destroy();
                                return arrayList;
                            } catch (InterruptedException e) {
                                e = e;
                                inputStream2 = processF;
                                bufferedReader = bufferedReader;
                                try {
                                    throw new IOException("Command line threw an InterruptedException for command " + Arrays.asList(strArr), e);
                                } catch (Throwable th) {
                                    th = th;
                                    processF = inputStream2;
                                    inputStream2 = inputStream;
                                    r5 = bufferedReader;
                                    b.closeQuietly(inputStream2);
                                    b.closeQuietly(outputStream);
                                    b.closeQuietly(errorStream);
                                    b.closeQuietly((Closeable) r5);
                                    if (processF != null) {
                                        processF.destroy();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream2 = inputStream;
                                r5 = bufferedReader;
                                b.closeQuietly(inputStream2);
                                b.closeQuietly(outputStream);
                                b.closeQuietly(errorStream);
                                b.closeQuietly((Closeable) r5);
                                if (processF != null) {
                                    processF.destroy();
                                }
                                throw th;
                            }
                        } catch (InterruptedException e2) {
                            e = e2;
                            bufferedReader = 0;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = 0;
                        }
                    } catch (InterruptedException e3) {
                        e = e3;
                        errorStream = null;
                        bufferedReader = errorStream;
                        inputStream2 = processF;
                        bufferedReader = bufferedReader;
                        throw new IOException("Command line threw an InterruptedException for command " + Arrays.asList(strArr), e);
                    } catch (Throwable th4) {
                        th = th4;
                        errorStream = null;
                        bufferedReader = errorStream;
                        inputStream2 = inputStream;
                        r5 = bufferedReader;
                        b.closeQuietly(inputStream2);
                        b.closeQuietly(outputStream);
                        b.closeQuietly(errorStream);
                        b.closeQuietly((Closeable) r5);
                        if (processF != null) {
                            processF.destroy();
                        }
                        throw th;
                    }
                } catch (InterruptedException e4) {
                    e = e4;
                    outputStream = null;
                    errorStream = outputStream;
                    bufferedReader = errorStream;
                    inputStream2 = processF;
                    bufferedReader = bufferedReader;
                    throw new IOException("Command line threw an InterruptedException for command " + Arrays.asList(strArr), e);
                } catch (Throwable th5) {
                    th = th5;
                    outputStream = null;
                    errorStream = null;
                }
            } catch (InterruptedException e5) {
                e = e5;
                inputStream = null;
                outputStream = null;
            } catch (Throwable th6) {
                th = th6;
                outputStream = null;
                errorStream = outputStream;
                r5 = errorStream;
                b.closeQuietly(inputStream2);
                b.closeQuietly(outputStream);
                b.closeQuietly(errorStream);
                b.closeQuietly((Closeable) r5);
                if (processF != null) {
                    processF.destroy();
                }
                throw th;
            }
        } catch (InterruptedException e6) {
            e = e6;
            inputStream = null;
            outputStream = null;
            errorStream = null;
            bufferedReader = 0;
        } catch (Throwable th7) {
            th = th7;
            processF = null;
            outputStream = null;
        }
    }

    private static Process f(String[] strArr) {
        return Runtime.getRuntime().exec(strArr);
    }
}
