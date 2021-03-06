package com.xclong.vehiclemonitordemo.constant;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.Iterator;
import java.util.Map;

public class LoginUtils {

    public static void gotoActivity(Activity poFrom, Class<?> poTo,
                                    boolean pbFinish, Map<String, String> pmExtra) {
        Intent loIntent = new Intent(poFrom, poTo);
        if (pmExtra != null && !pmExtra.isEmpty()) {
            Iterator<String> loKeyIt = pmExtra.keySet().iterator();
            while (loKeyIt.hasNext()) {
                String lsKey = loKeyIt.next();
                loIntent.putExtra(lsKey, pmExtra.get(lsKey));
            }
        }
        if (pbFinish)
            poFrom.finish();
        poFrom.startActivity(loIntent);
    }


    public static boolean isStrEmpty(Editable poStr) {
        String lsStr = poStr.toString();
        return isStrEmpty(lsStr);
    }


    public static boolean isStrEmpty(String psStr) {
        return psStr == null || psStr.trim().length() == 0;
    }

    public static void closeKeybord(EditText mEditText, Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);

        imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
    }
}
