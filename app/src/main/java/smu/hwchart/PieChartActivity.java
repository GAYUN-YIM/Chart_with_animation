package smu.hwchart;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PieChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        PieChart pieChart=findViewById(R.id.pieChart);

        ArrayList<PieEntry>students=new ArrayList<>();
        students.add(new PieEntry(6819927,"2015"));
        students.add(new PieEntry(6635784,"2016"));
        students.add(new PieEntry(6468629,"2017"));
        students.add(new PieEntry(6309723,"2018"));
        students.add(new PieEntry(6136794,"2019"));
        students.add(new PieEntry(6010006,"2020"));
        students.add(new PieEntry(5957087,"2021"));



        PieDataSet pieDataSet=new PieDataSet(students, "연도별 학생수");
        pieDataSet.setColors(ColorTemplate.LIBERTY_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueLineColor(Color.RED);

        pieDataSet.setValueTextSize(20f);

        PieData pieData=new PieData(pieDataSet);


        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("연도별 학생 수");
        pieChart.setCenterTextSize(30);
        pieChart.animateY(2000);


    }
}