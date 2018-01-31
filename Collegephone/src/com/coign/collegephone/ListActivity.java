package com.coign.collegephone;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListActivity extends Activity {
ArrayList<String> al=new ArrayList<String>();
SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		String s=getIntent().getStringExtra("type1");
		String s1=getIntent().getStringExtra("type");
		final ListView lv=(ListView)findViewById(R.id.listView1);
		db=openOrCreateDatabase("coign", MODE_PRIVATE, null);
		Cursor c= db.rawQuery("select * from regs where branch='"+s+"' AND types='"+s1+"' ", null);
		c.moveToFirst();
		if(c.getCount()>0)
		{
			do{
			int i=c.getColumnIndex("name");
			String s11=c.getString(i);
			al.add(s11);
			}while(c.moveToNext());
		
		ArrayAdapter<String> ad=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,al);
		lv.setAdapter(ad);
		}
		else{
			Toast.makeText(getApplicationContext(), "no data found", Toast.LENGTH_SHORT).show();
		}
		lv.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				String j=lv.getItemAtPosition(arg2).toString();
				Intent it=new Intent(ListActivity.this,DetailsActivity.class);
				it.putExtra("nam", j);
				startActivity(it);
				
				
			}
		});
}
}
