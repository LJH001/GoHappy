package com.example.liujianhui.gohappy.util;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
   *Description:Snackbar工具 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/3/2 0002 18:06
 */

public class SnackbarUtil {

    public static void show(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show();
    }

    public static void showShort(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show();
    }
}
