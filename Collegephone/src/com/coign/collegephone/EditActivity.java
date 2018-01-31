package com.coign.collegephone;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditActivity extends Activity {
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit);
		final TextView edname=(TextView)findViewById(R.id.textname);
		final EditText edmob=(EditText)findViewById(R.id.etmob);
		final EditText edmail=(EditText)findViewById(R.id.etemail);
		final EditText edgndr=(EditText)findViewById(R.id.etgender);
		final EditText edqual=(EditText)findViewById(R.id.etqual);
		final EditText edbr=(EditText)findViewById(R.id.etbranch);
		Button bt=(Button)findViewById(R.id.btupdate);
		String s=getIntent().getStringExtra("name");
		edname.setText(s);
		db=openOrCreateDatabase("coign", MODE_PRIVATE, null);
		Cursor c=db.rawQuery("select * from regs where name='"+s+"'", null);
		c.moveToFirst();
		if(c.getCount()>0){
			int i=c.getColumnIndex("mobileno");
			String smob=c.getString(i);
			edmob.setText(smob);
			int j=c.getColumnIndex("mailid");
			String smail=c.getString(j);
			edmail.setText(smail);
			int k=c.getColumnIndex("genders");
			String sgen=c.getString(k);
			edgndr.setText(sgen);
			int l=c.getColumnIndex("qualification");
			String squal=c.getString(l);
			edqual.setText(squal);
			int m=c.getColumnIndex("branch");
			String sbr=c.getString(m);
			edbr.setText(sbr);
		}
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String s011=edname.getText().toString();
				String s01=edmob.getText().toString();
				String s02=edmail.getText().toString();
				String s03=edgndr.getText().toString();
				String s04=edqual.getText().toString();
				String s05=edbr.getText().toString();
				db.execSQL("update regs set mobileno='"+s01+"',mailid='"+s02+"',genders='"+s03+"',qualification='"+s04+"',branch='"+s05+"'where name='"+s011+"' ");
				Toast.makeText(getApplicationContext(), "updated", Toast.LENGTH_LONG).show();
				Intent it=new Intent(EditActivity.this,MainActivity.class);
				startActivity(it);
			}
		});
	}
}
