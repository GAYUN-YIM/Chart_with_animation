package smu.hwchart;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class RadarChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radar_chart);

        RadarChart radarChart=findViewById(R.id.radarChart);

        ArrayList<RadarEntry> students=new ArrayList<>();
        students.add(new RadarEntry(6819927));
        students.add(new RadarEntry(6635784));
        students.add(new RadarEntry(6468629));
        students.add(new RadarEntry(6309723));
        students.add(new RadarEntry(6136794));
        students.add(new RadarEntry(6010006));
        students.add(new RadarEntry(5957087));


        RadarDataSet radarDataSet=new RadarDataSet(students,"연도별 학생수");
        radarDataSet.setColors(Color.BLUE);
        radarDataSet.setLineWidth(1f);
        radarDataSet.setValueTextColor(Color.BLACK);
        radarDataSet.setValueTextSize(17f);


        RadarData radarData=new RadarData();
        radarData.addDataSet(radarDataSet);

        String[] labels={"2015","2016","2017","2018","2019","2020","2021"};

        XAxis xAxis=radarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));

        radarChart.setData(radarData);
        radarChart.animateY(2000);
        radarChart.getDescription().setEnabled(false);


    }
}