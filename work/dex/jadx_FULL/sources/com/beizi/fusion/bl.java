package com.beizi.fusion;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import com.zj.adlib.c49;
import java.util.Stack;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class bl {
    public static int a(String str) {
        char cCharAt;
        Stack stack = new Stack();
        Stack stack2 = new Stack();
        int length = str.length();
        int i = 0;
        while (i < length) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 >= '0' && cCharAt2 <= '9') {
                String str2 = "" + cCharAt2;
                while (true) {
                    int i2 = i + 1;
                    if (i2 >= length || (cCharAt = str.charAt(i2)) < '0' || cCharAt > '9') {
                        break;
                    }
                    str2 = str2 + cCharAt;
                    i = i2;
                }
                stack.push(str2);
            } else if (cCharAt2 == '(') {
                stack2.push("" + cCharAt2);
            } else if (cCharAt2 == ')') {
                while (!((String) stack2.peek()).equals("(")) {
                    stack.push("" + a(Integer.parseInt((String) stack.pop()), (String) stack2.pop(), Integer.parseInt((String) stack.pop())));
                }
                stack2.pop();
            } else {
                if (!a(cCharAt2)) {
                    throw new RuntimeException("无法识别" + cCharAt2);
                }
                if (stack2.empty()) {
                    stack2.push("" + cCharAt2);
                } else {
                    String str3 = "" + cCharAt2;
                    if (b(str3) > b((String) stack2.peek())) {
                        stack2.push(str3);
                    } else {
                        while (!stack2.empty() && b(str3) <= b((String) stack2.peek())) {
                            stack.push("" + a(Integer.parseInt((String) stack.pop()), (String) stack2.pop(), Integer.parseInt((String) stack.pop())));
                        }
                        stack2.push(str3);
                    }
                }
            }
            i++;
        }
        while (!stack2.empty()) {
            stack.push("" + a(Integer.parseInt((String) stack.pop()), (String) stack2.pop(), Integer.parseInt((String) stack.pop())));
        }
        return Integer.parseInt((String) stack.pop());
    }

    private static boolean a(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }

    private static float b(String str) {
        str.getClass();
        byte b = -1;
        switch (str.hashCode()) {
            case 37:
                if (str.equals("%")) {
                    b = 0;
                }
                break;
            case 40:
                if (str.equals("(")) {
                    b = 1;
                }
                break;
            case 42:
                if (str.equals("*")) {
                    b = 2;
                }
                break;
            case 43:
                if (str.equals("+")) {
                    b = 3;
                }
                break;
            case 45:
                if (str.equals(c49.f40900a)) {
                    b = 4;
                }
                break;
            case 47:
                if (str.equals(WVNativeCallbackUtil.SEPERATER)) {
                    b = 5;
                }
                break;
        }
        switch (b) {
            case 0:
            case 2:
            case 5:
                return 2.0f;
            case 1:
                return 0.0f;
            case 3:
            case 4:
                return 1.0f;
            default:
                return -1.0f;
        }
    }

    private static int a(int i, String str, int i2) {
        str.getClass();
        switch (str) {
            case "%":
                return i % i2;
            case "*":
                return i * i2;
            case "+":
                return i + i2;
            case "-":
                return i - i2;
            case "/":
                return i / i2;
            default:
                return 0;
        }
    }
}
