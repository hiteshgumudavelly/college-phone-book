package com.coign.collegephone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TypeActivity extends Activity {
	String s2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_type);
		Button bttch=(Button)findViewById(R.id.btteach);
		Button btntch=(Button)findViewById(R.id.btnonteach);
		final String s1=getIntent().getStringExtra("data");
		bttch.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(TypeActivity.this,ListActivity.class);
				s2="TEACHING";
				it.putExtra("type", s2);
				it.putExtra("type1", s1);
				startActivity(it);
			}
		});
btntch.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(TypeActivity.this,ListActivity.class);
				s2="NON-TEACHING";
				it.putExtra("type", s2);
				it.putExtra("type1", s1);
				startActivity(it);
			}
		});
	}
}
