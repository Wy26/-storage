package com.example.storage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


import static java.nio.charset.StandardCharsets.*;

public class MainActivity extends AppCompatActivity {
    /*private final static String Filename="text.txt";
    private final static String key_number="number";
    private final static String key_name="name";
    SharedPreferences preferences;
    SharedPreferences.Editor editor;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*preferences=getSharedPreferences(Filename,MODE_PRIVATE);//获取实例对象
        editor=preferences.edit();
        Button bn1=(Button)findViewById(R.id.button);
        Button bn2=(Button)findViewById(R.id.button2);
        bn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number=preferences.getString(key_number,"2017011271");
                String name=preferences.getString(key_name,null);
                if(number!=null&&name!=null){
                    Toast.makeText(MainActivity.this,"学号:"+number+""+"姓名:"+name,Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"无数据",Toast.LENGTH_LONG).show();
                }
            }
        });

        bn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"已写入",Toast.LENGTH_LONG).show();
                editor.putString(key_number,"2017011271");//写入键值对
                editor.putString(key_name,"wy");
                editor.apply();//写入内存
            }
        });*/
        final String FILE_NAME="test4.txt";
        Button bn1=(Button)findViewById(R.id.button);
        Button bn2=(Button)findViewById(R.id.button2);
        bn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputStream in=null;
                try {
                    FileInputStream b=openFileInput(FILE_NAME);
                    in=new BufferedInputStream(b);
                    int c = 0;
                    StringBuilder builder=new StringBuilder("");

                        try {
                            while  ((c=in.read())!=-1)
                            {
                                builder.append((char)c);
                                Toast.makeText(MainActivity.this,builder.toString(),Toast.LENGTH_SHORT).show();
                            }
                        } finally {
                            if(in!=null)
                                in.close();
                        }


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        bn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OutputStream out = null;
                try {
                    FileOutputStream a = null;
                    try {
                        a = openFileOutput(FILE_NAME, MODE_PRIVATE);
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                    out = new BufferedOutputStream(a);
                    String content = "number:2017011271 name:wy";
                    try {
                        out.write(content.getBytes("utf-8"));
                        out.flush();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } finally {
                        if (out != null) {
                            try {
                                out.close();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


       /* try {
            FileOutputStream fos=openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            String text="lalalala";
            fos.write(text.getBytes());
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }
}
