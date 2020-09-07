package com.esragarip.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button button;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button resultButton;
    Button multiplyButton;
    Button delete;
    Button sumButton;
    Button divideButton;
    Button subtractButton ;
    ImageButton clearChar;
    TextView textView;
    String text;
    Button dotButton;
    List<Double> list1;
    List<String> list2;
    double calculation;
    ImageButton exit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        text="";
        list1 = new ArrayList<>();
        list2=new ArrayList<>();
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
        button7=findViewById(R.id.button7);
        button8=findViewById(R.id.button8);
        button9=findViewById(R.id.button9);
        resultButton =findViewById(R.id.resultButton);
        multiplyButton=findViewById(R.id.multiplyButton);
        delete =findViewById(R.id.deleteAll);
        sumButton =findViewById(R.id.sumButton);
        divideButton =findViewById(R.id.divideButton);
        subtractButton =findViewById(R.id.subtractButton);
        textView=findViewById(R.id.textView);
        exit=findViewById(R.id.exit);
        dotButton=findViewById(R.id.dotButton);
        clearChar=findViewById(R.id.clearChar);
    }
    public void number(View view){
        switch (view.getId()){
            case R.id.button:
                text=text+button.getText();
                break;
            case R.id.button1:
                text=text+button1.getText();
                break;
            case R.id.button2:
                text=text+button2.getText() ;
                break;

            case R.id.button3:
                text=text+button3.getText();
                break;

            case R.id.button4:
                text=text+button4.getText();
                break;

            case R.id.button5:
                text=text+button5.getText();
                break;

            case R.id.button6:
                text=text+button6.getText();
                break;

            case R.id.button7:
                text=text+button7.getText();
                break;

            case R.id.button8:
                text=text+button8.getText();
                break;

            case R.id.button9:
                text=text+button9.getText();
                break;
            case R.id.dotButton:
                text=text+dotButton.getText();

        }
        textView.setText(text);

    }

    public void delete(View view){
        list1.clear();
        list2.clear();
        text="";
        textView.setText(text);
    }

    public void exit(View view){
        finish();
        System.exit(0);
    }

    public void sum(View view){
        list2.add((String) sumButton.getText());
        text=text+ sumButton.getText();
        textView.setText(text);

    }

    public void divide(View view){
        list2.add((String) divideButton.getText());
        text=text+ divideButton.getText();
        textView.setText(text);
    }


    public void multiply(View view){
        list2.add((String) multiplyButton.getText());
        text=text+multiplyButton.getText();
        textView.setText(text);

    }
    public void subtract(View view){

        text = text + subtractButton.getText();
        textView.setText(text);
        list2.add((String) subtractButton.getText());
        h
    }

    public void clearChar(View view){
        if (!textView.getText().equals("")){
            text=text.substring(0,text.length()-1);
            textView.setText(text);
        }


    }
    public void result(View view){
        try {

        if(text.charAt(0)=='-'){
            text="0"+text;
        }
        String [] str=text.split("[-+*/]");


        for(int i=0;i<str.length;i++){
            list1.add(Double.parseDouble(str[i]));
        }
        calculation=0;
        int i=0;
        int len=list2.size();

        while(len>0){
            if (list2.get(i).equals("+")) {

                if (i==0){
                    calculation=calculation+(list1.get(i)+list1.get(i+1));
                }
                else{
                    calculation=calculation+list1.get(i+1);
                }
            }
            else if (list2.get(i).equals("-")){
                if (i==0){
                    calculation=calculation+(list1.get(i)-list1.get(i+1));

                }
                else{
                    calculation=calculation-list1.get(i+1);
                }

            }
            else if (list2.get(i).equals("*")){
                if (i==0){
                    calculation=calculation+(list1.get(i)*list1.get(i+1));
                }
                else{
                    calculation=calculation*list1.get(i+1);
                }
            }
            else if (list2.get(i).equals("/")){
                if (i==0){
                    calculation=calculation+(list1.get(i)/list1.get(i+1));
                }
                else{
                    calculation=calculation/list1.get(i+1);
                }

            }

            len--;
            i++;

        }
        list1.clear();
        list2.clear();
        if(calculation<0){
            list2.add("-");
        }
        text=""+calculation;
        textView.setText(text);

        }
    catch (Exception e){
        text="Syntax Error";
        textView.setText(text );

        }
    }

}