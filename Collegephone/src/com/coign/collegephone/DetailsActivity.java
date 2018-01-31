package com.coign.collegephone;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DetailsActivity extends ActionBarActivity {
SQLiteDatabase db;
String smobile,s11,sname;
private TextView tvname;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);
		tvname=(TextView)findViewById(R.id.tvname);
		TextView tvmob=(TextView)findViewById(R.id.tvmobile);
		TextView tvmail=(TextView)findViewById(R.id.tvemail);
		TextView tvgen=(TextView)findViewById(R.id.tvgender);
		TextView tvadd=(TextView)findViewById(R.id.tvaddress);
		Button btback=(Button)findViewById(R.id.bthome);
		sname=getIntent().getStringExtra("nam");
		tvname.setText(sname);
		db=openOrCreateDatabase("coign", MODE_PRIVATE, null);
		Cursor c=db.rawQuery("select * from regs where name='"+sname+"'", null);
		c.moveToFirst();
		if(c.getCount()>0)
		{
			int i=c.getColumnIndex("mobileno");
			 smobile=c.getString(i);
			tvmob.setText(smobile);
			int j=c.getColumnIndex("mailid");
			String s1=c.getString(j);
			tvmail.setText(s1);
			int k=c.getColumnIndex("genders");
			String s3=c.getString(k);
			tvgen.setText(s3);
			int l=c.getColumnIndex("addresss");
			String s4=c.getString(l);
			tvadd.setText(s4);	
		}
		btback.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it=new Intent(DetailsActivity.this,MainActivity.class);
				startActivity(it);
			}
		});
		
		
	}
	@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// TODO Auto-generated method stub
		menu.add("call");
		menu.add("message");
		menu.add("edit");
		menu.add("delete");
			return super.onCreateOptionsMenu(menu);
			
		}
	@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			// TODO Auto-generated method stub
		if(item.getTitle().equals("call")){
			Intent it=new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+smobile));
			startActivity(it);
		}
		else if (item.getTitle().equals("message")) {
			
			Intent it=new Intent(DetailsActivity.this,MessageActivity.class);
			it.putExtra("mobno",smobile);
			startActivity(it);
		}
		else if (item.getTitle().equals("edit")) {
			String s6=tvname.getText().toString();
			
			Intent it=new Intent(DetailsActivity.this,EditActivity.class);
			it.putExtra("name", s6);
			startActivity(it);
			
		}
		else if (item.getTitle().equals("delete")) {
			AlertDialog.Builder ab=new AlertDialog.Builder(DetailsActivity.this);
			ab.setTitle("delete");
			ab.setIcon(R.drawable.ic_launcher);
			ab.setMessage("r u wanna delete");
			ab.setPositiveButton("yes",new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
				db.execSQL("delete from regs where name='"+sname+"'");	
				}
			});
			ab.create();
			ab.show();
			
		}
			return super.onOptionsItemSelected(item);
		}
}
