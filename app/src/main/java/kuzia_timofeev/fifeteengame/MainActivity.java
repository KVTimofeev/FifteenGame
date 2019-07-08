package kuzia_timofeev.fifeteengame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16;
    List<Button>ButtonList;
    Button test;
    Button mix;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test = (Button)findViewById(R.id.test);
        mix=(Button)findViewById(R.id.start);

        btn1=(Button)findViewById(R.id.id1);
        btn2=(Button)findViewById(R.id.id2);
        btn3=(Button)findViewById(R.id.id3);
        btn4=(Button)findViewById(R.id.id4);
        btn5=(Button)findViewById(R.id.id5);
        btn6=(Button)findViewById(R.id.id6);
        btn7=(Button)findViewById(R.id.id7);
        btn8=(Button)findViewById(R.id.id8);
        btn9=(Button)findViewById(R.id.id9);
        btn10=(Button)findViewById(R.id.id10);
        btn11=(Button)findViewById(R.id.id11);
        btn12=(Button)findViewById(R.id.id12);
        btn13=(Button)findViewById(R.id.id13);
        btn14=(Button)findViewById(R.id.id14);
        btn15=(Button)findViewById(R.id.id15);
        btn16=(Button)findViewById(R.id.id16);
        btn1.setOnClickListener(OnBtnClc);
                btn2.setOnClickListener(OnBtnClc);
        btn3.setOnClickListener(OnBtnClc);
                btn4.setOnClickListener(OnBtnClc);
        btn5.setOnClickListener(OnBtnClc);
                btn6.setOnClickListener(OnBtnClc);
        btn7.setOnClickListener(OnBtnClc);
                btn8.setOnClickListener(OnBtnClc);
        btn9.setOnClickListener(OnBtnClc);
        btn10.setOnClickListener(OnBtnClc);
        btn11.setOnClickListener(OnBtnClc);
        btn12.setOnClickListener(OnBtnClc);
        btn13.setOnClickListener(OnBtnClc);
        btn14.setOnClickListener(OnBtnClc);
        btn15.setOnClickListener(OnBtnClc);
        btn16.setOnClickListener(OnBtnClc);
        ButtonList=new ArrayList<>();
        ButtonList.add(btn1);
        ButtonList.add(btn2);
        ButtonList.add(btn3);
        ButtonList.add(btn4);
        ButtonList.add(btn5);
        ButtonList.add(btn6);
        ButtonList.add(btn7);
        ButtonList.add(btn8);
        ButtonList.add(btn9);
        ButtonList.add(btn10);
        ButtonList.add(btn11);
        ButtonList.add(btn12);
        ButtonList.add(btn13);
        ButtonList.add(btn14);
        ButtonList.add(btn15);
        ButtonList.add(btn16);
        //GiveSeqRandomNumers(ButtonList);
        //GiveSeqRandomNumers3(ButtonList);
        mix.setOnClickListener(mixListener);
        test.setOnClickListener(testListener);
    }

    View.OnClickListener OnBtnClc = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           /* switch (v.getId()) {
                case R.id.id15:
                    MoveBtn(btn16, btn15);

                    MoveBtn(btn11, btn15);
                    MoveBtn(btn14, btn15);
                    break;
                case R.id.id16:
                    MoveBtn(btn15, btn16);

                    MoveBtn(btn12, btn16);
                    break;
            }*/

            for (int i = 0; i < ButtonList.size(); i++) {
                if (ButtonList.get(i).getId() == v.getId()) {
                    int int_button_up = i - 4;
                    int int_button_down = i + 4;
                    int int_button_left = i - 1;
                    int int_button_right = i + 1;
                    int[] aroundArea = new int[4];
                    aroundArea[0] = i - 1;//button left from current;
                    aroundArea[1] = i - 4;//button up;
                    aroundArea[2] = i + 1;//btn right;
                    aroundArea[3] = i + 4;//btn down;
                    if((i>4 && i<7) || (i>8 && i<11)){//нажатая кнопка в середине дв.масс., в сердцевине.
                        for (int g = 0; g < aroundArea.length; g++) {
                            MoveBtn(ButtonList.get(aroundArea[g]), ButtonList.get(i));
                        }
                    }else {
                        if(i>3 && i<9 && ((i%4)==0)){//если в середине левого края;
                            //1,2,3;
                            for (int g = 1; g < aroundArea.length; g++) {
                                MoveBtn(ButtonList.get(aroundArea[g]), ButtonList.get(i));
                            }
                        }
                        if(i==7 || i==11){//если в середине правого края;
                            //3,1,0;
                            for (int g = 0; g < aroundArea.length; g++) {
                                if(g!=2){
                                    MoveBtn(ButtonList.get(aroundArea[g]), ButtonList.get(i));
                                }

                            }
                        }


                        if(i<4){//если нажатая кнопка находится наверху;
                            if(i>0 && i<3){
                                //3,2,0
                                for (int g = 0; g < aroundArea.length; g++) {
                                    if(g!=1){
                                        MoveBtn(ButtonList.get(aroundArea[g]), ButtonList.get(i));
                                    }
                                }
                            }
                            if(i==0){
                                //2,3
                                for (int g = 2; g < aroundArea.length; g++) {
                                        MoveBtn(ButtonList.get(aroundArea[g]), ButtonList.get(i));
                                }
                            }
                            if(i==3){
                                //0,3 меняется либо с левой либо с нижней;
                                MoveBtn(ButtonList.get(aroundArea[0]), ButtonList.get(i));
                                MoveBtn(ButtonList.get(aroundArea[3]), ButtonList.get(i));
                            }
                        }


                        if(i>11){//если нажатая кнопиищеее находится в самом низу
                            if(i>12 && i<15){
                                //0,1,2
                                for (int g = 0; g < 3; g++) {
                                    MoveBtn(ButtonList.get(aroundArea[g]), ButtonList.get(i));
                                }
                            }
                            if(i==12){
                                //1,2;
                                for (int g = 1; g < 3; g++) {
                                    MoveBtn(ButtonList.get(aroundArea[g]), ButtonList.get(i));
                                }
                            }
                            if(i==15) {
                                //0,1;
                                for (int g = 0; g < 2; g++) {
                                    MoveBtn(ButtonList.get(aroundArea[g]), ButtonList.get(i));
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    //раздача случайных чисел.
    private void GiveSeqRandomNumers(List<Button> btns){
        int lenght=btns.size();
        int[] busy =new int[lenght]; //массив занятых чисел;
        int busy_lenght=1;
        for(int i=0;i<lenght;i++){
            Random r=new Random();
            int rand=r.nextInt(lenght);
            if(i==0){
                btns.get(0).setText(""+rand);
                busy[0]=rand;
                busy_lenght++;
                Log.d("RAND"," "+rand);
            }

            if(i>0){
                for(int g=0;g<busy_lenght;g++){
                    if(rand!=busy[g]){
                        continue;
                    }else{
                        Log.d("RAND"," "+rand);
                        busy_lenght++;
                        break;
                    }

                }


            }

        }
    }


    private void GiveSeqRandomNumers2(List<Button> listBtns){
        int lenght=listBtns.size();
        int side=0;//направо или налево 1 or 0
        int[] mass=new int[listBtns.size()];
        for(int i=0;i<listBtns.size();i++){
            mass[i]=i+1;
            Log.d("MASS",""+mass[i]);
            //последнее значение массива равняется переменной lenght;
        }

        //перемешивание.
        Random r=new Random();
        int index_somethingNumber = r.nextInt(lenght+1);

        side=r.nextInt(2);
        //if(side==1) {
            int distLeft = index_somethingNumber;
        int distRight=(listBtns.size()-1) - index_somethingNumber;
            //Log.d("TEST", "lenght "+lenght+"index_sn=" + index_somethingNumber + " distLeft= " + distLeft + "distRight="+distRight+ " mass= " + mass[index_somethingNumber]);
            int temp=mass[index_somethingNumber];
            mass[index_somethingNumber]=mass[index_somethingNumber+distRight];
        mass[index_somethingNumber+distRight]=temp;


        for(int i=0;i<listBtns.size();i++){

            //Log.d("MASS2",""+mass[i]);
            //последнее значение массива равняется переменной lenght;
        }
    }

    private void MoveBtn(Button BtnInvisible, Button BtnVisible ){
        if(BtnInvisible.getVisibility()==View.INVISIBLE){
            BtnInvisible.setVisibility(View.VISIBLE);
            BtnInvisible.setText(BtnVisible.getText().toString());
            BtnVisible.setVisibility(View.INVISIBLE);
        }
    }

    private void swap(int one, int two){
        int temp=one;
        one=two;
        two=temp;
    }


    private void MixMassive(int[] mass){
        int lenght=mass.length;

        Random r= new Random();
        int counter=0;
        int current_index;
        int leftDist;
        int rightDist;
        int side;
        while ( counter<150){
            current_index=r.nextInt(lenght);
            if(current_index>1 && current_index<lenght-1){
                side=r.nextInt(2);

                if(side==1){
                    rightDist=r.nextInt((lenght-1)-current_index);

                    //swap(mass[current_index],mass[current_index+rightDist]);
                    int temp=mass[current_index];
                    mass[current_index]=mass[current_index+rightDist];
                    mass[current_index+rightDist]=temp;
                }
                if(side==0){
                    leftDist=r.nextInt(current_index);
                    //swap(mass[current_index],mass[current_index-leftDist]);
                    int temp=mass[current_index];
                    mass[current_index]=mass[current_index-leftDist];
                    mass[current_index-leftDist]=temp;
                }
            }
            counter++;

        }

        /*for(int i=0;i<mass.length;i++){

            Log.d("MASS",""+mass[i]);


        }*/


    }

    View.OnClickListener mixListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            GiveSeqRandomNumers3(ButtonList);
        }
    };

    private void GiveSeqRandomNumers3(List<Button> listBtns){
        int lenght=listBtns.size();

        int[] mass=new int[listBtns.size()];
        for(int i=0;i<listBtns.size();i++){
            mass[i]=i+1;
            //Log.d("MASS",""+mass[i]);
            //последнее значение массива равняется переменной lenght;

        }
        //Log.d("MASS", "перемешка");
        MixMassive(mass);

        for(int i=0;i<lenght;i++){
            listBtns.get(i).setText(mass[i]+"");
        }


    }

    View.OnClickListener testListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

                    if(TestSequence(ButtonList)){
                        Toast.makeText(getApplicationContext(),"Все верно!",Toast.LENGTH_LONG).show();
                    }
        }
    };

    private boolean TestSequence(List<Button>buttonList){
        boolean test=true;
        for (int i=0;i<buttonList.size()-2;i++){
            int firstNum=Integer.parseInt(buttonList.get(i+1).getText().toString());
            int secondNum=Integer.parseInt(buttonList.get(i).getText().toString());
            if((firstNum-secondNum)==1){
                continue;
            }else {
                test=false;
                break;
            }
        }
        return test;
    }



}
