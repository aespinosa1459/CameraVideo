package com.inventabto.plugins.camera_video;

import android.content.Intent;
import android.provider.MediaStore;
import android.os.Bundle;

import com.getcapacitor.BridgeActivity;
import com.getcapacitor.JSObject;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

public class CameraVideo {

    private static final int REQUEST_IMAGE_CAPTURE = 1;

    @PluginMethod
    public void openCamera(PluginCall call) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(call, takePictureIntent, "cameraResult");
        } else {
            call.reject("No camera app available");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            String imageUri = data.getData().toString();

            JSObject ret = new JSObject();
            ret.put("imageUri", imageUri);
            notifyListeners("cameraResult", ret);
        }
    }
}
