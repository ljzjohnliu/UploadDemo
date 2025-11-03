package com.study.upload.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import com.ss.bduploader.BDMaterialUploader;
import com.ss.bduploader.BDMaterialUploaderListener;
import com.ss.bduploader.BDVideoInfo;
import com.study.upload.R;

public class TestUploadActivity extends Activity {
    private static final String TAG = "TestOkhttpActivity";
    private String testUrl = "http://www.baidu.com";
    private String testUrl2 = "https://wanandroid.com/wxarticle/list/408/1/json";
    private Button syncBtn;
    private Button asyncBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_upload);

        syncBtn = findViewById(R.id.upload_pic);
        asyncBtn = findViewById(R.id.upload_video);

        syncBtn.setOnClickListener(v -> {
            uploadPic();
        });
        asyncBtn.setOnClickListener(v -> {
            uploadVideo();
        });
    }

    public void uploadPic() {
        try {
            BDMaterialUploader mUploader = new BDMaterialUploader();
            mUploader.setPathName("/data/user/0/xxx/files/test.mp4");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void uploadVideo() {
        try {
            BDMaterialUploader mUploader = new BDMaterialUploader();
            mUploader.setPathName("/data/user/0/xxx/files/test.mp4");
            mUploader.setTopAccessKey("xxx");
            mUploader.setTopSecretKey("xxx");
            mUploader.setTopSessionToken("xxx");
            mUploader.setSpaceName("xxx");
            mUploader.setListener(new BDMaterialUploaderListener() {

                @Override
                public void onNotify(int i, long l, BDVideoInfo bdVideoInfo) {

                }

                @Override
                public void onLog(int i, int i1, String s) {

                }

                @Override
                public void onUploadVideoStage(int i, long l) {

                }

                @Override
                public int videoUploadCheckNetState(int i, int i1) {
                    return 0;
                }

                @Override
                public String getStringFromExtern(int i) {
                    return "";
                }
            });
            mUploader.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
