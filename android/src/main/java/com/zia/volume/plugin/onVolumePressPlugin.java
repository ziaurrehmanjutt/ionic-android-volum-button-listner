// package com.zia.volume.plugin;
// import com.getcapacitor.JSObject;
// import com.getcapacitor.Plugin;
// import com.getcapacitor.PluginCall;
// import com.getcapacitor.PluginMethod;
// import com.getcapacitor.annotation.CapacitorPlugin;

// @CapacitorPlugin(name = "onVolumePress")  
// public class onVolumePressPlugin extends Plugin {

//     private onVolumePress implementation = new onVolumePress();

//     @PluginMethod
//     public void echo(PluginCall call) {
//         @Override
//         public boolean onKeyDown(int keyCode, KeyEvent event) {
//             if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN){
//                 JSObject ret = new JSObject();
//                 ret.put(keyCode, event);
//                 notifyListeners("keyDownVolume", ret);
//                 // call.resolve(keyCode);
//             }
//         }

//     }


// }


package com.zia.volume.plugin;

import android.view.KeyEvent;
import android.view.View;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import android.util.Log;
@CapacitorPlugin(name = "onVolumePress")
public class onVolumePressPlugin extends Plugin {

    private onVolumePress implementation = new onVolumePress();
    public static final String VOLUME_BUTTON_PRESSED_EVENT = "volumeButtonPressed";

    @Override
    public void load() {
        getBridge()
            .getWebView()
            .setOnKeyListener(
                new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View v, int keyCode, android.view.KeyEvent event) {
                        // boolean isKeyUp = event.getAction() == KeyEvent.ACTION_UP;
                        boolean isKeyDown = event.getAction() == KeyEvent.ACTION_DOWN;
                        JSObject ret = new JSObject();
                        // Log.w("Code Pressed", "code" + keyCode);
                        if (isKeyDown) {
                            if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
                                ret.put("direction", "up");
                                notifyListeners(VOLUME_BUTTON_PRESSED_EVENT, ret);
                                return false;
                            } else if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
                                ret.put("direction", "down");
                                notifyListeners(VOLUME_BUTTON_PRESSED_EVENT, ret);
                                return true;
                            }
                        }

                        return false;
                    }
                }
            );
    }
}