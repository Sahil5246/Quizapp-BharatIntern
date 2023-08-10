package com.example.vikasojha.quizbee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionsActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
                            "Which of the following option leads to the portability and security of Java?",
                            "Which of the following is not a Java features?",
                            "The \\u0021 article referred to as a",
                            "_____ is used to find and fix bugs in the Java programs.",
                            "Which of the following is a valid declaration of a char?",
                            "What is the return type of the hashCode() method in the Object class?",
                            "Which of the following is a valid long literal?",
                            "What does the expression float a = 35 / 0 return?",
                            "Evaluate the following Java expression, if x=3, y=5, and z=10:\n" +
                                    "\n" +
                                    "++z + y - y + z + x++",
                            "Which of the following tool is used to generate API documentation in HTML format from doc comments in source code?"
                         };
    String answers[] = {"Bytecode is executed by JVM","Use of pointers","Unicode escape sequence","JDB","char ch = '\\utea'","int","0xnf029L","Infinity","25","Javadoc tool"};
    String opt[] = {
                    "Bytecode is executed by JVM","The applet makes the Java code secure and portable","Use of exception handling","Dynamic binding between objects",
                    "Dynamic","Architecture Neutral","Use of pointers","Object-oriented",
                    "Unicode escape sequence","Octal escape","Hexadecimal","Line feed",
                    "JVM","JRE","JDK","JDB",
                    "char ch = '\\utea';","char ca = 'tea';","char cr = \\u0223;","char cc = '\\itea';",
                    "object","int","long","void",
                    "ABH8097","L990023","904423","0xnf029L",
                    "0","Not a Number","Infinity","Run time exception",
                    "24","23","20","25",
                    "javap tool","javaw command","Javadoc tool","javah command"
                   };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("Hello User");
        else
        textView.setText("Hello " + name);

        submitbutton=(Button)findViewById(R.id.next);
        quitbutton=(Button)findViewById(R.id.quit);
        tv=(TextView) findViewById(R.id.huhuihu);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.opt_1);
        rb2=(RadioButton)findViewById(R.id.opt_2);
        rb3=(RadioButton)findViewById(R.id.opt_3);
        rb4=(RadioButton)findViewById(R.id.opt_4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });
    }

}