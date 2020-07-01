package com.example.mapsapplication;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class Permission {

    public static boolean validatePermission(String[] permission, Activity activity, int requestCode){

        if (Build.VERSION.SDK_INT >= 23 ){
            List<String> listPermission = new ArrayList<>();
            for ( String permissions : permission ){
                Boolean hasPermission = ContextCompat.checkSelfPermission(activity, permissions) == PackageManager.PERMISSION_GRANTED;
                if ( !hasPermission ) listPermission.add(permissions);
            }
            if ( listPermission.isEmpty() ) return true;
            String[] newPermissoes = new String[ listPermission.size() ];
            listPermission.toArray( newPermissoes );

            ActivityCompat.requestPermissions(activity, newPermissoes, requestCode );
        }
        return true;
    }
}
