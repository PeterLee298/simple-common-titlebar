
package com.ltc.commontitle.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.ltc.lib.commontitle.CommonTitle;
import com.ltc.share.ShareInfo;
import com.ltc.share.ShareUtil;
import com.ltc.share.qq.QQUtil;

public class MainActivity extends Activity {
    
    private CommonTitle commonTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        commonTitle = (CommonTitle) findViewById(R.id.title);
        commonTitle.setOnTitleClickListener(new CommonTitle.TitleClickListener() {
            
            @Override
            public void onRightClicked(View parent, View v) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void onRight2Clicked(View parent, View v) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void onLeftClicked(View parent, View v) {
                // TODO Auto-generated method stub
            	
            	ShareInfo shareInfo = new ShareInfo("title", "http://www.baidu.com",
						"summary", "wxcontent", "wxMomentsContent", "normalText", R.drawable.ic_launcher, 
						"https://res.wx.qq.com/open/zh_CN/htmledition/res/img/pic/app-create/pic_logo_282168b9.png");
            	
                ShareUtil.getInstance().showShareWindow(MainActivity.this, shareInfo, new ShareUtil.ShareListener() {
					
					@Override
					public void onError(String errorMessage) {
						// TODO Auto-generated method stub
						Log.e("aaaaaaaaaaaaaa", "qq onError" + errorMessage);
					}
					
					@Override
					public void onComplete() {
						// TODO Auto-generated method stub
						Log.e("aaaaaaaaaaaaaa", "qq onComplete");
						
					}
					
					@Override
					public void onCancel() {
						// TODO Auto-generated method stub
						Log.e("aaaaaaaaaaaaaa", "qq onCancel");
						
					}
				});
            }
        });
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	
    	QQUtil.getInstance().getTencentInstance(getApplicationContext()).onActivityResult(requestCode, resultCode, data);
    	
    	super.onActivityResult(requestCode, resultCode, data);
    	
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
