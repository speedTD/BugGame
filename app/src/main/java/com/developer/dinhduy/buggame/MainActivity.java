package com.developer.dinhduy.buggame;

import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    private BugAdapter adapter;
    private TextView txt_monney,txtResult;
    private Button btn_oke;
    private ImageView  Icon1, Icon2 ,Icon3;
    private AnimationDrawable DRIcon1,DRIcon2,DRIcon3;
    private Integer[] objImage={ R.drawable.bocanhcam,
    R.drawable.buom,
    R.drawable.domdom,
    R.drawable.ong,
    R.drawable.chuonchuon,
    R.drawable.chau};
    private Random RandomIcon;
    private  Handler mhandler;
    private Timer timer=new Timer();
    public static Integer Arraychoise []=new Integer[6];



    //sorry today my laptop  hot ,run slowly :v ok maybe i  will restart ny laptop

    int mm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        adapter=new BugAdapter(this,R.layout.custom_item,objImage);
        gridView.setAdapter(adapter);
        mhandler=new Handler(callback);
        btn_oke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                laclac();
            }
        });
        Money_old=Integer.valueOf(txt_monney.getText().toString());

        Icon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Money_old+=10000;
               txt_monney.setText(String.valueOf(Money_old));
               SaveMoney(Money_old);

            }
        });


    }
    private int Monney_new;
    private int Money_old;
    private int temp;
    private int checkValue1,checkValue2,checkValue3;
    Handler.Callback callback=new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {


            RandomIcon1();
            RandomIcon2();
            RandomIcon3();
            Log.d("AAA", "result: " +checkValue1 +" "+ checkValue2 +" "+checkValue3);
            //ok lest go , check win or lose
            for (int i=0;i<Arraychoise.length;i++){
                Log.d("AAA", i+"  buy  "+ Arraychoise[i]);
                // if  buy
                if(Arraychoise[i]!=0){
                    if(i==checkValue1)
                    {
                        Monney_new+=Arraychoise[i];
                    } if(i==checkValue2)
                    {
                        Monney_new+=Arraychoise[i];
                    }
                    if(i==checkValue3)
                    {
                        Monney_new+=Arraychoise[i];
                    } if(i!=checkValue1&&i!=checkValue2&&i!=checkValue3)
                    {
                        Monney_new-=Arraychoise[i];
                    }
                }

            }
            if(Monney_new<0){
                Toast.makeText(MainActivity.this, "huhuhu " +Monney_new, Toast.LENGTH_SHORT).show();
            }
            if(Monney_new>0){
                Toast.makeText(MainActivity.this, "hihii " +Monney_new, Toast.LENGTH_SHORT).show();
            }
            if(Monney_new==0){
                Toast.makeText(MainActivity.this, "=)), =((( " +Monney_new, Toast.LENGTH_SHORT).show();
            }
            Money_old=Integer.valueOf(txt_monney.getText().toString());
            txt_monney.setText(String.valueOf(Money_old+Monney_new));
            temp=Money_old+Monney_new;
            SaveMoney(temp);
            return false;
        }
    };
   private String Name_File="sahara";
    private void SaveMoney(int temp) {
        SharedPreferences sharedPreferences=getSharedPreferences(Name_File,MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.putInt("monney",temp);
        editor.apply();
        editor.commit();
    }

    @Override
    protected void onResume() {
        GetMoney();
        super.onResume();
    }

    private void GetMoney() {
        SharedPreferences sharedPreferences=getSharedPreferences(Name_File,MODE_PRIVATE);
        int Moneyget =sharedPreferences.getInt("monney",0);
        txt_monney.setText(String.valueOf(Moneyget));
    }

    private void RandomIcon1() {
        RandomIcon=new Random();
        switch (RandomIcon.nextInt(5)){
            case 0:
                Icon1.setImageResource(objImage[0]);
                checkValue1=0;
                break;
            case 1:
                Icon1.setImageResource(objImage[1]);
                checkValue1=1;
                break;
            case 2:
                Icon1.setImageResource(objImage[2]);
                checkValue1=2;
                break;
            case 3:
                Icon1.setImageResource(objImage[3]);
                checkValue1=3;
                break;
            case 4:
                Icon1.setImageResource(objImage[4]);
                checkValue1=4;
                break;
            case 5:
                Icon1.setImageResource(objImage[5]);
                checkValue1=5;
                break;
            default:break;
        }

    }

    private void RandomIcon2() {
        RandomIcon=new Random();
        switch (RandomIcon.nextInt(5)){
            case 0:
                Icon2.setImageResource(objImage[0]);
                checkValue2=0;
                break;
            case 1:
                Icon2.setImageResource(objImage[1]);
                checkValue2=1;
                break;
            case 2:
                Icon2.setImageResource(objImage[2]);
                checkValue2=2;
                break;
            case 3:
                Icon2.setImageResource(objImage[3]);
                checkValue2=3;
                break;
            case 4:
                Icon2.setImageResource(objImage[4]);
                checkValue2=4;
                break;
            case 5:
                Icon2.setImageResource(objImage[5]);
                checkValue2=5;
                break;
                default:break;
        }
    }

    private void RandomIcon3() {
        RandomIcon=new Random();
        switch (RandomIcon.nextInt(5)){
            case 0:
                Icon3.setImageResource(objImage[0]);
                checkValue3=0;
                break;
            case 1:
                Icon3.setImageResource(objImage[1]);
                checkValue3=1;
                break;
            case 2:
                Icon3.setImageResource(objImage[2]);
                checkValue3=2;
                break;
            case 3:
                Icon3.setImageResource(objImage[3]);
                checkValue3=3;
                break;
            case 4:
                Icon3.setImageResource(objImage[4]);
                checkValue3=4;
                break;
            case 5:
                Icon3.setImageResource(objImage[5]);
                checkValue3=5;
                break;
            default:break;
        }
    }


    private void laclac() {
        Monney_new=0;
        Money_old=0;
        temp=0;
        Icon1.setImageResource(R.drawable.iconchange1);
        Icon2.setImageResource(R.drawable.iconchange2);
        Icon3.setImageResource(R.drawable.iconchange3);

        DRIcon1= (AnimationDrawable) Icon1.getDrawable();
        DRIcon2= (AnimationDrawable) Icon2.getDrawable();
        DRIcon3= (AnimationDrawable) Icon3.getDrawable();

        DRIcon1.start();
        DRIcon2.start();
        DRIcon3.start();

        timer.schedule(new LacTime(),1000);
    }


    private void init() {
        gridView=(GridView) findViewById(R.id.girdview_id);
        btn_oke=(Button) findViewById(R.id.btn_ok);
        txt_monney=(TextView) findViewById(R.id.Text_Monney);
        Icon1=(ImageView) findViewById(R.id.icon1);
        Icon2=(ImageView) findViewById(R.id.icon2);
        Icon3 =(ImageView) findViewById(R.id.icon3);
    }


    private class LacTime extends TimerTask {
        @Override
        public void run() {
            mhandler.sendEmptyMessage(0);
        }
    }
}
