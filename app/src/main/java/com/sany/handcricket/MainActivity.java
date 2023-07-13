package com.sany.handcricket;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int r,cs=0,ys=0,prev=3;
    final int win_score=20;
    TextView you,cpu;
    ImageView grock,gpaper,gsciss,crock,cpaper,csciss;
    ImageButton stone,paper,sciss;
    AlertDialog.Builder exit,win;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        stone=findViewById(R.id.stone);
        paper=findViewById(R.id.paper);
        sciss=findViewById(R.id.sciss);
        grock=findViewById(R.id.gr);
        gsciss=findViewById(R.id.gs);
        gpaper=findViewById(R.id.gp);
        crock=findViewById(R.id.cr);
        csciss=findViewById(R.id.cs);
        cpaper=findViewById(R.id.cp);
        View.OnTouchListener listener=new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(v.getId())
                {
                    case R.id.stone:
                    case R.id.paper:
                    case R.id.sciss:
                        if(event.getAction()==MotionEvent.ACTION_DOWN)
                            v.setBackground(getResources().getDrawable(R.drawable.change));
                        if(event.getAction()==MotionEvent.ACTION_UP)
                            v.setBackground(getResources().getDrawable(R.drawable.shape));
                }
                return false;

            }
        };
        stone.setOnTouchListener(listener);
        paper.setOnTouchListener(listener);
        sciss.setOnTouchListener(listener);
        grock.setVisibility(View.INVISIBLE);
        gpaper.setVisibility(View.INVISIBLE);
        gsciss.setVisibility(View.INVISIBLE);
        crock.setVisibility(View.INVISIBLE);
        cpaper.setVisibility(View.INVISIBLE);
        csciss.setVisibility(View.INVISIBLE);
        you=findViewById(R.id.you);
        cpu=findViewById(R.id.cpu);
        stone.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                r=(int)(Math.random()*3);
                grock.setVisibility(View.VISIBLE);
                gpaper.setVisibility(View.INVISIBLE);
                gsciss.setVisibility(View.INVISIBLE);
                while(r==prev)
                    r=(int)(Math.random()*3);
                if(r==0)
                {
                    crock.setVisibility(View.VISIBLE);
                    cpaper.setVisibility(View.INVISIBLE);
                    csciss.setVisibility(View.INVISIBLE);
                }
                else if(r==1)
                {
                    cs++;
                    crock.setVisibility(View.INVISIBLE);
                    cpaper.setVisibility(View.VISIBLE);
                    csciss.setVisibility(View.INVISIBLE);
                    cpu.setText("CPU : "+cs);
                    if(cs==win_score)wins("CPU");
                }
                else if(r==2)
                {
                    ys++;
                    crock.setVisibility(View.INVISIBLE);
                    cpaper.setVisibility(View.INVISIBLE);
                    csciss.setVisibility(View.VISIBLE);
                    you.setText("YOU : "+ys);
                    if(ys==win_score)wins("YOU");
                }
                prev=r;
            }
        });
        paper.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                r=(int)(Math.random()*3);
                grock.setVisibility(View.INVISIBLE);
                gpaper.setVisibility(View.VISIBLE);
                gsciss.setVisibility(View.INVISIBLE);
                while(r==prev)
                    r=(int)(Math.random()*3);
                if(r==0)
                {
                    ys++;
                    crock.setVisibility(View.VISIBLE);
                    cpaper.setVisibility(View.INVISIBLE);
                    csciss.setVisibility(View.INVISIBLE);
                    you.setText("YOU : "+ys);
                    if(ys==win_score)wins("YOU");
                }
                else if(r==1)
                {
                    crock.setVisibility(View.INVISIBLE);
                    cpaper.setVisibility(View.VISIBLE);
                    csciss.setVisibility(View.INVISIBLE);
                }
                else if(r==2)
                {
                    cs++;
                    crock.setVisibility(View.INVISIBLE);
                    cpaper.setVisibility(View.INVISIBLE);
                    csciss.setVisibility(View.VISIBLE);
                    cpu.setText("CPU : "+cs);
                    if(cs==win_score)wins("CPU");
                }
                prev=r;
            }
        });
        sciss.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                r=(int)(Math.random()*3);
                grock.setVisibility(View.INVISIBLE);
                gpaper.setVisibility(View.INVISIBLE);
                gsciss.setVisibility(View.VISIBLE);
                while(r==prev)
                    r=(int)(Math.random()*3);
                if(r==0)
                {
                    cs++;
                    crock.setVisibility(View.VISIBLE);
                    cpaper.setVisibility(View.INVISIBLE);
                    csciss.setVisibility(View.INVISIBLE);
                    cpu.setText("CPU : "+cs);
                    if(cs==win_score)wins("CPU");
                }
                else if(r==1)
                {
                    ys++;
                    crock.setVisibility(View.INVISIBLE);
                    cpaper.setVisibility(View.VISIBLE);
                    csciss.setVisibility(View.INVISIBLE);
                    you.setText("YOU : "+ys);
                    if(ys==win_score)wins("YOU");
                }
                else if(r==2)
                {
                    crock.setVisibility(View.INVISIBLE);
                    cpaper.setVisibility(View.INVISIBLE);
                    csciss.setVisibility(View.VISIBLE);
                }
                prev=r;
            }
        });

    }
    private void wins(String s)
    {

        win=new AlertDialog.Builder(this);
        win.setTitle(s+" win!");
        win.setMessage("Play new game!");
        win.setCancelable(false);
        win.setPositiveButton("PLAY",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface d,int which)
            {
                d.dismiss();
                cs=0;
                ys=0;
                you.setText("YOU : "+ys);
                cpu.setText("CPU : "+cs);
                grock.setVisibility(View.INVISIBLE);
                gpaper.setVisibility(View.INVISIBLE);
                gsciss.setVisibility(View.INVISIBLE);
                crock.setVisibility(View.INVISIBLE);
                cpaper.setVisibility(View.INVISIBLE);
                csciss.setVisibility(View.INVISIBLE);
            }
        });
        win.setNegativeButton("EXIT",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface d,int which)
            {
                finish();
            }
        });
        win.create().show();
    }
    @Override
    public void onBackPressed()
    {
        exit=new AlertDialog.Builder(this);
        exit.setTitle("Quit!");
        exit.setMessage("Are You sure you want to exit");
        exit.setCancelable(false);
        exit.setPositiveButton("YES",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface d,int which)
            {
                finish();
            }
        });
        exit.setNegativeButton("NO",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface d,int which)
            {
                d.dismiss();
            }
        });
        exit.create().show();
    }
}