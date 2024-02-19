package smu.hwchart;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;




public class BarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);

        BarChart barChart=findViewById(R.id.barChart);

        ArrayList<BarEntry>students=new ArrayList<>();
        students.add(new BarEntry(2015, 6819927));;
        students.add(new BarEntry(2016, 6635784));;
        students.add(new BarEntry(2017, 6468629));;
        students.add(new BarEntry(2018, 6309723));;
        students.add(new BarEntry(2019, 6136794));;
        students.add(new BarEntry(2020, 6010006));;
        students.add(new BarEntry(2021, 5957087));;

        BarDataSet barDataSet=new BarDataSet(students,"연도별 학생수 분석");




        barDataSet.setColors(ColorTemplate.PASTEL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(17f);


        BarData barData=new BarData(barDataSet);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("연도별 학생수");
        barChart.getDescription().setTextSize(17);
        barChart.getDescription().setTextColor(Color.GRAY);

        barChart.animateY(2000);




    }
}

