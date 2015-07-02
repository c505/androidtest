package com.example.yoon2.hello;

import android.app.Activity;

import android.app.AlertDialog;

import android.content.DialogInterface;

import android.content.Intent;

import android.database.Cursor;

import android.os.Bundle;

import android.database.sqlite.SQLiteDatabase;

import android.util.Log;

import android.view.View;

import android.widget.AdapterView;

import android.widget.ArrayAdapter;

import android.widget.ListView;


import java.util.ArrayList;

public class listact extends Activity  {

    ArrayList<String> arrgrade = null;

    ArrayList<String> arrname = null;

    ArrayList<String> arrnumber = null;

    SQLiteDatabase database;

    String dbName = "human";



    @Override

    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        setContentView(R.layout.my_list);

        database = openOrCreateDatabase(dbName, MODE_WORLD_WRITEABLE, null);



        arrgrade = new ArrayList<String>();

        arrname = new ArrayList<String>();

        arrnumber = new ArrayList<String>();

       selectData();



        ArrayAdapter<String> Adapter1;
        ArrayAdapter<String> Adapter2;
        ArrayAdapter<String> Adapter3;
        Adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrgrade);
        Adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,  arrname);
        Adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrnumber);

        ListView list1 = (ListView)findViewById(R.id.l_view1);
        ListView list2 = (ListView)findViewById(R.id.l_view2);
        ListView list3 = (ListView)findViewById(R.id.l_view3);

        list1.setAdapter(Adapter1);
        list2.setAdapter(Adapter2);
        list3.setAdapter(Adapter3);





    }




   public void selectData(){

        Cursor result = database.rawQuery("SELECT * FROM member", null);

       result.moveToFirst();

        while(!result.isAfterLast()){

            arrgrade.add(result.getString(0));
            arrname.add(result.getString(1));
            arrnumber.add(result.getString(2));
           // arrlist.add(result.getString(1));

            result.moveToNext();

        }

        result.close();

    }



  /*  @Override

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

        final Integer selectedPos = i;

        AlertDialog.Builder alertDlg = new AlertDialog.Builder(view.getContext());

        alertDlg.setTitle(R.string.alert_title_question);

        Log.i("test", "1");

        alertDlg.setPositiveButton(R.string.button_yes, new DialogInterface.OnClickListener() {


            @Override

            public void onClick(DialogInterface dialog, int which) {

                String position = arr_id_list.get(selectedPos);

                final String sql = "delete from test_table where id = " + position;

                dialog.dismiss();

                Log.i("test", "onclick");

                database.execSQL(sql);

            }

        });



        alertDlg.setNegativeButton( R.string.button_no, new DialogInterface.OnClickListener(){



            @Override

            public void onClick( DialogInterface dialog, int which ) {

                String position = arr_id_list.get(selectedPos);

                dialog.dismiss();

                Log.i("test", "1");

                Intent intent = new Intent(second.this, updatedb.class);

                intent.putExtra("p_id", position);

                Log.i("test", "2");

                startActivity(intent);

            }

        });



        alertDlg.setMessage(R.string.alert_msg_delete);

        alertDlg.show();

        return false;



    }
*/
}