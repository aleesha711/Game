package com.example.testtricks;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class front extends Activity implements OnClickListener{
	
	private Button highBtn;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.front);
	        
	        highBtn = (Button)findViewById(R.id.high_btn);
	        highBtn.setOnClickListener(this);
	        
	    }


	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	     
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }

	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	       
	        int id = item.getItemId();
	        if (id == R.id.action_settings) {
	            return true;
	        }
	        return super.onOptionsItemSelected(item);
	    }
	    public void onClick(View view) {
			if(view.getId()==R.id.high_btn){
				
				Intent mainIntent = new Intent(this, MainActivity.class);
				this.startActivity(mainIntent);
				
					} 
	    }
	    
	}
