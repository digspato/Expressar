package com.example.expressar;

import java.io.IOException;
import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
	
	private SurfaceHolder mHolder;
	private Camera mCamera;

	public CameraPreview(Context context, Camera camera) {
	 super(context);
	 mCamera = camera;


	 mHolder = getHolder();
	 mHolder.addCallback(this);

	}

	public void surfaceCreated(SurfaceHolder holder) {

		try {
			mCamera.setPreviewDisplay(holder);
			mCamera.startPreview();
	 	} catch (IOException e) {
	       Log.d(VIEW_LOG_TAG, "Error setting camera preview: " + e.getMessage());
	    }
	
	}

	 public void surfaceDestroyed(SurfaceHolder holder) {

	 }

	 public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {


		if (mHolder.getSurface() == null){

		 return;
	 	}

	
		try {
			mCamera.stopPreview();
		} catch (Exception e){

		}

		try {
			mCamera.setPreviewDisplay(mHolder);
			mCamera.startPreview();

		} catch (Exception e) {
		    Log.d(VIEW_LOG_TAG, "Error starting camera preview: " + e.getMessage());
		}
	 
	 }

}
