package com.coign.collegephone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btreg=(Button)findViewById(R.id.btreg);
        Button btview=(Button)findViewById(R.id.btview);
        Button btexit=(Button)findViewById(R.id.btexit);
        btreg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(MainActivity.this,RegistrationActivity.class);
				startActivity(it);
				
			}
		});
btview.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(MainActivity.this,BranchActivity.class);
				startActivity(it);
				
			}
		});
btexit.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		moveTaskToBack(true);
	}
});
    }
}
