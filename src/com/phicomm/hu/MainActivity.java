
package com.phicomm.hu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
    LinearLayout mFloatLayout;

    WindowManager.LayoutParams wmParams = new WindowManager.LayoutParams();

    WindowManager mWindowManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button start = (Button) findViewById(R.id.start);

        Button remove = (Button) findViewById(R.id.remove);

        Button uninstall = (Button) findViewById(R.id.uninstall);
        

        start.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FxService.class);
                startService(intent);
                finish();
            }
        });

        remove.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FxService.class);
                stopService(intent);
            }
        });

        uninstall.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                uninstallApp(getApplicationContext().getPackageName());
            }
        });
        

    }

    private void uninstallApp(String packageName) {
        Uri packageURI = Uri.parse("package:" + packageName);
        Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
        startActivity(uninstallIntent);
    }

//    private void forceStopApp(String packageName) {
//        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
//        Method method;
//        try {
//            method = Class.forName("android.app.ActivityManager").getMethod("forceStopPackage", String.class);
//            method.invoke(activityManager, packageName);
//        } catch (IllegalArgumentException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }
}
