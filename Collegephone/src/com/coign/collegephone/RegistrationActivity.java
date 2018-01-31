package com.coign.collegephone;

import java.util.ArrayList;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class RegistrationActivity extends Activity {
SQLiteDatabase db;
String spqu,spb,spt;
ArrayList<String> al=new ArrayList<String>();
ArrayList<String> al1=new ArrayList<String>();
ArrayList<String> al2=new ArrayList<String>();
String gender="male";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
		final EditText edname=(EditText)findViewById(R.id.editname);
		final EditText edmob=(EditText)findViewById(R.id.editmobile);
		final EditText edmail=(EditText)findViewById(R.id.editemail);
		final EditText eddob=(EditText)findViewById(R.id.editdob);
		final EditText edadd=(EditText)findViewById(R.id.editadd);
		final RadioButton rmale=(RadioButton)findViewById(R.id.radio0);
		final RadioButton rfemale=(RadioButton)findViewById(R.id.radio1);
		final Spinner spqual=(Spinner)findViewById(R.id.spqual);
		final Spinner spbr=(Spinner)findViewById(R.id.spbranch);
		final Spinner sptype=(Spinner)findViewById(R.id.sptype);
		Button btsub=(Button)findViewById(R.id.btsubmit);
		db=openOrCreateDatabase("coign", MODE_PRIVATE, null);
		db.execSQL("create table if not exists regs(name varchar(50),mobileno varchar(50),genders varchar(50),qualification varchar(50),branch varchar(50),types varchar(50),mailid varchar(50),dob varchar(50),addresss varchar(50))");
		al.add("btech");
		al.add("mtech");
		al.add("bpharm");
		al1.add("cse");
		al1.add("ece");
		al1.add("mech");
		al1.add("eee");
		al1.add("civil");
		al2.add("TEACHING");
		al2.add("NON-TEACHING");
		ArrayAdapter<String> ad=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line,al);
		ArrayAdapter<String> ad1=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line,al1);
		ArrayAdapter<String> ad2=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line,al2);
		spqual.setAdapter(ad);
		spbr.setAdapter(ad1);
		sptype.setAdapter(ad2);
		
		
		rmale.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				gender="male";
			}
		});
rfemale.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				gender="female";
			}
		});
spqual.setOnItemSelectedListener(new OnItemSelectedListener() {

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		spqu=spqual.getItemAtPosition(arg2).toString();
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
});
spbr.setOnItemSelectedListener(new OnItemSelectedListener() {

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		spb=spbr.getItemAtPosition(arg2).toString();
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
});
sptype.setOnItemSelectedListener(new OnItemSelectedListener() {

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		spt=sptype.getItemAtPosition(arg2).toString();
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
});
btsub.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String s=edname.getText().toString();
		String s1=edmob.getText().toString();
		
		String s5=edmail.getText().toString();
		String s6=eddob.getText().toString();
		String s7=edadd.getText().toString();
		db.execSQL("insert into regs values('"+s+"','"+s1+"','"+gender+"','"+spqu+"','"+spb+"','"+spt+"','"+s5+"','"+s6+"','"+s7+"')");
		Toast.makeText(getApplicationContext(),"registeration successful", Toast.LENGTH_SHORT).show();
	}
});
	}
}
