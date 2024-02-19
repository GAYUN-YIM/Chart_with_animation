package smu.hwchart;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.LargeValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class LineChartActivity extends AppCompatActivity {
    LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);
        //초기화
        lineChart = (LineChart) findViewById(R.id.line_Chart);
        //1.데이터셋에 데이터 넣기
        LineDataSet lineDataSet1 = new LineDataSet(data1(), "2015");
        LineDataSet lineDataSet2 = new LineDataSet(data1(), "2016");
        LineDataSet lineDataSet3 = new LineDataSet(data1(), "2017");
        LineDataSet lineDataSet4 = new LineDataSet(data1(), "2018");
        LineDataSet lineDataSet5 = new LineDataSet(data1(), "2019");
        LineDataSet lineDataSet6 = new LineDataSet(data1(), "2020");
        LineDataSet lineDataSet7 = new LineDataSet(data1(), "2021");
        //2.리스트에 데이터셋 추가
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);
        dataSets.add(lineDataSet2);
        dataSets.add(lineDataSet3);
        dataSets.add(lineDataSet4);
        dataSets.add(lineDataSet5);
        dataSets.add(lineDataSet6);
        dataSets.add(lineDataSet7);


        //차트 커스텀

        //라인 굵기
        lineDataSet1.setLineWidth(4);
        //라인색상
        //lineDataSet1.setColor(Color.BLUE);
        //데이터 원 표시 여부
        lineDataSet1.setDrawCircles(true);
        //데이터 원 안의 홀 여부
        lineDataSet1.setDrawCircleHole(true);
        //데이터 원 색상
        lineDataSet1.setCircleColor(Color.GRAY);
        //데이터 원 홀 색상
        lineDataSet1.setCircleHoleColor(Color.rgb(152,197,147));
        //데이터 원 반지름
        lineDataSet1.setCircleRadius(10);
        //데이터 원 홀 반지름
        lineDataSet1.setCircleHoleRadius(5);
        //데이터 숫자 크기
        lineDataSet1.setValueTextSize(10);
        //데이터 숫자 색상
        // lineDataSet1.setValueTextColor(Color.BLACK);




        //라인 대쉬 형태로 라인길이, 골간길이, 단계
        lineDataSet1.enableDashedLine(5,10,0);
        //라인 별 색상 설정
        int colorArray[]={R.color.purple_200, R.color.teal_200, R.color.teal_700};
        lineDataSet1.setColors(colorArray,LineChartActivity.this);




        //차트 스타일

        //차트 배경 색상
        lineChart.setBackgroundColor(Color.rgb(250,244,192));
        //차트 데이터 없음 표시
        lineChart.setNoDataText("no data");
        //차트 데이터 없음 텍스트 색상
        lineChart.setNoDataTextColor(Color.RED);
        //격자 그리드 적용
        lineChart.setDrawGridBackground(true);
        //차트 외곽선 진하게
        lineChart.setDrawBorders(true);
        //차트외곽선색상
        lineChart.setBorderColor(Color.rgb(152,197,147));
        //차트 외곽선 굵기
        lineChart.setBorderWidth(10);


        //라벨 그래프 밑에
        Legend legend=lineChart.getLegend();
        //라벨 표시
        // legend.setEnabled(true);
        //라벨 텍스트 색상
        legend.setTextColor(Color.BLACK);
        //라벨 텍스트 사이즈
        legend.setTextSize(20);
        //라벨 아이콘 설정
        legend.setForm(Legend.LegendForm.CIRCLE);
        //라벨 아이콘 크기 설정
        legend.setFormSize(10);
        //라벨 간 거리
        legend.setXEntrySpace(15);
        //라벨 아이콘과 라벨 텍스트 거리
        legend.setFormToTextSpace(10);
        //커스텀 라벨 만들어 보기
        LegendEntry[] legendEntries=new LegendEntry[2];



        //색상
        int[] color={Color.BLUE, Color.RED};


        //라벨명
        String[] legandNAme={"Data1","Data2"};

        for(int i =0; i<legendEntries.length; i++){
            LegendEntry entry = new LegendEntry();

            //색상
            entry.formColor=colorArray[i];
            //텍스트
            entry.label=legandNAme[i];
            //담기
            legendEntries[i]=entry;
        }

        //설명
        Description description=new Description();
        description.setText("연도별 학생 수");
        description.setTextSize(50);//설명텍스트크기
        description.setTextColor(Color.DKGRAY);//텍스트 색상

        lineChart.setDescription(description);

        lineDataSet1.setValueTextSize(10);
        lineDataSet2.setValueTextSize(10);
        lineDataSet3.setValueTextSize(10);
        lineDataSet4.setValueTextSize(10);
        lineDataSet5.setValueTextSize(10);
        lineDataSet6.setValueTextSize(10);
        lineDataSet7.setValueTextSize(10);

        //3.라인데이터에 리스트 추가
        LineData data = new LineData(dataSets);

        //데이터 포맷
        data.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                String sValue = String.valueOf((int) value) + "명";
                return sValue;
            }
        });

        //x축
        //x축 가져오기
        XAxis xAxis = lineChart.getXAxis();
        //x축 위치
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //격자무뉘 설정
        xAxis.setDrawGridLines(false);
        //라벨 갯수
        xAxis.setLabelCount(data1().size(), true);
        //x축 포맷
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                String sValue = String.valueOf((int) value) + "년";
                return sValue;
            }
        });




        //y축
        //y축 가져오기
        YAxis yAxis = lineChart.getAxisLeft();
        //y축 위치
        yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        //y축 포맷
        yAxis.setValueFormatter(new LargeValueFormatter());


        //4.차트에 라인데이터 추가
        lineChart.setData(data);
        //5.차트 초기화
        lineChart.invalidate();
    }
    //데이터 생성
    private  ArrayList<Entry>data1() {
        ArrayList<Entry> dataList = new ArrayList<>();

        dataList.add(new Entry(2015, 6819927));
        dataList.add(new Entry(2016, 6635784));
        dataList.add(new Entry(2017, 6468629));
        dataList.add(new Entry(2018, 6309723));
        dataList.add(new Entry(2019, 6136794));
        dataList.add(new Entry(2020, 6010006));
        dataList.add(new Entry(2021, 5957087));


        return dataList;

    }

}