package com.coign.collegephone;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BranchActivity extends Activity {
	String s1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_branch);
		Button bt1=(Button)findViewById(R.id.btcse);
		Button bt2=(Button)findViewById(R.id.btece);
		Button bt3=(Button)findViewById(R.id.bteee);
		Button bt4=(Button)findViewById(R.id.btmech);
		Button bt5=(Button)findViewById(R.id.btcivil);
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(BranchActivity.this,TypeActivity.class);
				s1="cse";
				it.putExtra("data", s1);
				startActivity(it);
			}
		});
bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(BranchActivity.this,TypeActivity.class);
				s1="ece";
				it.putExtra("data", s1);
				startActivity(it);
			}
		});
bt3.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent it=new Intent(BranchActivity.this,TypeActivity.class);
		s1="eee";
		it.putExtra("data", s1);
		startActivity(it);
	}
});
bt4.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent it=new Intent(BranchActivity.this,TypeActivity.class);
		s1="mech";
		it.putExtra("data", s1);
		startActivity(it);
	}
});
bt5.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent it=new Intent(BranchActivity.this,TypeActivity.class);
		s1="civil";
		it.putExtra("data", s1);
		startActivity(it);
	}
});
	}
}
