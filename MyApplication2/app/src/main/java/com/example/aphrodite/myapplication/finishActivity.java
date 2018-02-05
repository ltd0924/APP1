package com.example.aphrodite.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;


public class finishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
    }

    private LineChart mLineChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLineChart = (LineChart)findViewById(R.id.chart);
        LineData mLineData =getLineData(36,100);
        showChart(mLineChart, mLineData, Color.rgb(114, 188, 223));
    }
    public void showChart(LineChart lineChart, LineData lineData, int color) {
        lineChart.setDrawBorders(false); //是否在折线图上添加边框

// no description text
        lineChart.setDescription("");// 数据描述
// 如果没有数据的时候，会显示这个，类似listview的emtpyview
        lineChart.setNoDataTextDescription("You need to provide data for the chart.");

// enable / disable grid background
        lineChart.setDrawGridBackground(false); // 是否显示表格颜色
        lineChart.setGridBackgroundColor(0x70FFFFFF); // 表格的的颜色，在这里是是给颜色设置一个透明度

// enable touch gestures
        lineChart.setTouchEnabled(true); // 设置是否可以触摸

// enable scaling and dragging
        lineChart.setDragEnabled(true);// 是否可以拖拽
        lineChart.setScaleEnabled(true);// 是否可以缩放

// if disabled, scaling can be done on x- and y-axis separately
        lineChart.setPinchZoom(false);//

        lineChart.setBackgroundColor(color);// 设置背景

// add data
        lineChart.setData(lineData); // 设置数据

// get the legend (only possible after setting data)
        Legend mLegend = lineChart.getLegend(); // 设置比例图标示，就是那个一组y的value的

// modify the legend ...
// mLegend.setPosition(LegendPosition.LEFT_OF_CHART);
        mLegend.setForm(Legend.LegendForm.CIRCLE);// 样式
        mLegend.setFormSize(6f);// 字体
        mLegend.setTextColor(Color.WHITE);// 颜色
// mLegend.setTypeface(mTf);// 字体

        lineChart.animateX(2500); // 立即执行的动画,x轴
    }

    public LineData getLineData(int count, float range) {
        ArrayList entries = new ArrayList<>();
        entries.add(new Entry(0, 4f));
        entries.add(new Entry(1, 8f));
        entries.add(new Entry(2, 6f));
        entries.add(new Entry(3, 2f));
        entries.add(new Entry(4, 18f));
        entries.add(new Entry(5, 9f));

        LineDataSet dataSet = new LineDataSet(entries, "# of Calls");
        LineData lineData = new LineData(dataSet);

        return lineData;
    }
}