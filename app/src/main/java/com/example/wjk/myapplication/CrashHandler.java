package com.example.wjk.myapplication;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CrashHandler implements Thread.UncaughtExceptionHandler {
    
    private static final CrashHandler sInstance = new CrashHandler();
    private static Thread.UncaughtExceptionHandler sDefaultHandler;
    
    private Context mContext;
    
    private CrashHandler() {
    }
    
    public static CrashHandler getInstance() {
        return sInstance;
    }
    
    public void init(Context context) {
        sDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        mContext = context;
    }
    
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        handleException(t, e);
        if (sDefaultHandler != null) {
            sDefaultHandler.uncaughtException(t, e);
        }
    }
    
    private void handleException(Thread t, Throwable ex) {
        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        ex.printStackTrace(printWriter);
        
        Throwable cause = ex.getCause();
        while (cause != null) {
            cause.printStackTrace(printWriter);
            cause = cause.getCause();
        }
        printWriter.close();
        String result = writer.toString();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS", Locale.getDefault());
        
        String fileName = sdf.format(new Date(System.currentTimeMillis())) + ".log";
        
        File crashLogDir = mContext.getExternalFilesDir("crash");
        
        FileOutputStream fos = null;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            try {
                fos = new FileOutputStream(crashLogDir.getAbsoluteFile() + File.separator + fileName)
                fos.write(result.getBytes());
            } catch (IOException e) {
                // ignore
            } finally {
                try {
                    if (fos != null) {
                        fos.close();
                    }
                } catch (IOException e) {
                }
            }
        }
    }
}