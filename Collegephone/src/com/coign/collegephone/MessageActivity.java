package com.coign.collegephone;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MessageActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message);
		TextView textmob=(TextView)findViewById(R.id.textmobile);
		final EditText et=(EditText)findViewById(R.id.editmessage);
		Button bt=(Button)findViewById(R.id.btsend);
		final String s12=getIntent().getStringExtra("mobno");
		textmob.setText(s12);
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SmsManager sms=SmsManager.getDefault();
				String s1=et.getText().toString();
				sms.sendTextMessage(s12, null, s1, null, null);
				Toast.makeText(getApplicationContext(), "msg sent", Toast.LENGTH_LONG).show();
				
			}
		});
		
	
	}
}
