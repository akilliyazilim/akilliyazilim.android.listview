package com.example.listviewapp;

import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListviewApp extends Activity implements OnInitListener
{
 
    public int index;
    public String [] cities = {"Ankara","Ýstanbul","Ýzmir","Bursa","Eskiþehir","Samsun"};
    public String [] Plate= {"06","34","35","16","26","55"};
 
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_app);
 
        final ListView lv =(ListView) findViewById(R.id.List);
 
        final TextToSpeech tts = new TextToSpeech(this,this);
        tts.setLanguage(Locale.ENGLISH);
 
        ArrayAdapter<String> array_adapter= new ArrayAdapter<String>(this,
                                                                     android.R.layout.simple_list_item_1,
                                                                     android.R.id.text1,
                                                                     cities);
 
       lv.setAdapter(array_adapter);
 
       lv.setOnItemClickListener(new OnItemClickListener(){
 
        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                long arg3) {
            // TODO Auto-generated method stub
            index= arg2;
            Toast.makeText(getApplicationContext(), Plate[index], Toast.LENGTH_SHORT).show();
            tts.speak(Plate[index], TextToSpeech.QUEUE_ADD, null);
        }
    });
 
      }

	@Override
	public void onInit(int arg0) {
		// TODO Auto-generated method stub
		
	}

	
 
    
 

}
