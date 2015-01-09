
package com.ltc.commontitle.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.ltc.lib.commontitle.CommonTitle;

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
                
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
