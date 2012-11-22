/**
 * Copyright (C) 2009, 2010 SC 4ViewSoft SRL
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.litsoft.demo.chart;

import java.util.ArrayList;
import java.util.List;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import com.litsoft.demo.AbstractDemoChart;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint.Align;

/**
 * Average temperature demo chart.
 */
public class WgtcChart extends AbstractDemoChart {
  /**
   * Returns the chart name.
   * 
   * @return the chart name
   */
  public String getName() {
    return "Average temperature";
  }

  /**
   * Returns the chart description.
   * 
   * @return the chart description
   */
  public String getDesc() {
    return "The average temperature in 4 Greek islands (line chart)";
  }

  /**
   * Executes the chart demo.
   * 
   * @param context the context
   * @return the built intent
   */
  public Intent execute(Context context) {
	  
    //String[] titles = new String[] { "Crete", "Corfu", "Thassos", "Skiathos" };
	String[] titles = new String[] {"接受流量","发送流量"};

    List<double[]> x = new ArrayList<double[]>();
    for (int i = 0; i < titles.length; i++) {
      x.add(new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 ,13,14,15,16,17,18,19,20,21,22,23,24});
    }
    List<double[]> values = new ArrayList<double[]>();
    
    values.add(new double[] { 12.3, 12.5, 13.8, 16.8, 22, 24.4, 26.4, 26.1, 23.6, 
    		20.3, 17.2,13.9,12.3, 12.5, 13.8, 77, 20.4, 24.4, 26.4, 123, 123, 22, 17.2,13.9  });
    values.add(new double[] { 10, 10, 12, 88, 20, 24, 26, 32.22, 23, 18, 14, 11,5, 
    		5.3, 8, 12, 17, 120, 67, 44, 19, 15, 9, 6});
    //values.add(new double[] { 5, 5.3, 8, 12, 17, 22, 24.2, 24, 19, 15, 9, 6 });
   // values.add(new double[] { 9, 10, 11, 15, 19, 23, 26, 25, 22, 18, 13, 10 });
    
   // int[] colors = new int[] { Color.BLUE, Color.GREEN, Color.CYAN, Color.YELLOW };
    int[] colors = new int[] { Color.RED,Color.GREEN};
   // PointStyle[] styles = new PointStyle[] { PointStyle.CIRCLE, PointStyle.DIAMOND,PointStyle.TRIANGLE, PointStyle.SQUARE };
    PointStyle[] styles = new PointStyle[] { PointStyle.CIRCLE,PointStyle.DIAMOND};
    XYMultipleSeriesRenderer renderer = buildRenderer(colors, styles);//设置颜色和风格
    
    int length = renderer.getSeriesRendererCount();
    for (int i = 0; i < length; i++) {
      ((XYSeriesRenderer) renderer.getSeriesRendererAt(i)).setFillPoints(true);
    }
    setChartSettings(renderer, "2012年11月1日", "时间(小时)", "网络流量(Mbps)", 1, 24, 0, 125,Color.LTGRAY, Color.LTGRAY);//设置 显示的风格
     
    renderer.setXLabels(12);//X轴的最小的精度
    
    renderer.setYLabels(10);//Y最小的精度
    renderer.setShowGrid(true);
    renderer.setXLabelsAlign(Align.RIGHT);
    renderer.setYLabelsAlign(Align.RIGHT);
    //renderer.setLabelsColor(Color.BLUE);//设置显示的字体的颜色
    renderer.setApplyBackgroundColor(true);// 设置允许设置格子的背景颜色
    //renderer.setBackgroundColor(Color.WHITE);
    //renderer.setMarginsColor(Color.WHITE);
    renderer.setMargins(new int[]{20,40,15,5});//top,left,bottom,right
    renderer.setZoomButtonsVisible(true);//设置缩放4
    renderer.setPanLimits(new double[] { 0, 20,0, 40 });//拖动时的距离大小
    renderer.setZoomLimits(new double[] { 0, 20, 0, 40 });//按钮缩放大小
  
    Intent intent = ChartFactory.getLineChartIntent(context, 
    		buildDataset(titles, x, values),renderer, "卫岗同城电信1000M专线网络流量监控曲线");
    return intent;
  }

@Override
public GraphicalView executeGetView(Context context) {
	// TODO Auto-generated method stub
	   //String[] titles = new String[] { "Crete", "Corfu", "Thassos", "Skiathos" };
	String[] titles = new String[] {"接受流量","发送流量"};

    List<double[]> x = new ArrayList<double[]>();
    for (int i = 0; i < titles.length; i++) {
      x.add(new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 ,13,14,15,16,17,18,19,20,21,22,23,24});
    }
    List<double[]> values = new ArrayList<double[]>();
    
    values.add(new double[] { 12.3, 12.5, 13.8, 16.8, 22, 24.4, 26.4, 26.1, 23.6, 
    		20.3, 17.2,13.9,12.3, 12.5, 13.8, 77, 20.4, 24.4, 26.4, 123, 123, 22, 17.2,13.9  });
    values.add(new double[] { 10, 10, 12, 88, 20, 24, 26, 32.22, 23, 18, 14, 11,5, 
    		5.3, 8, 12, 17, 120, 67, 44, 19, 15, 9, 6});
    //values.add(new double[] { 5, 5.3, 8, 12, 17, 22, 24.2, 24, 19, 15, 9, 6 });
   // values.add(new double[] { 9, 10, 11, 15, 19, 23, 26, 25, 22, 18, 13, 10 });
    
   // int[] colors = new int[] { Color.BLUE, Color.GREEN, Color.CYAN, Color.YELLOW };
    int[] colors = new int[] { Color.RED,Color.GREEN};
   // PointStyle[] styles = new PointStyle[] { PointStyle.CIRCLE, PointStyle.DIAMOND,PointStyle.TRIANGLE, PointStyle.SQUARE };
    PointStyle[] styles = new PointStyle[] { PointStyle.CIRCLE,PointStyle.DIAMOND};
    XYMultipleSeriesRenderer renderer = buildRenderer(colors, styles);//设置颜色和风格
    
    int length = renderer.getSeriesRendererCount();
    for (int i = 0; i < length; i++) {
      ((XYSeriesRenderer) renderer.getSeriesRendererAt(i)).setFillPoints(true);
    }
    setChartSettings(renderer, "2012年11月1日", "时间(小时)", "网络流量(Mbps)", 1, 24, 0, 125,Color.LTGRAY, Color.LTGRAY);//设置 显示的风格
     
    renderer.setXLabels(12);//X轴的最小的精度
    
    renderer.setYLabels(10);//Y最小的精度
    renderer.setShowGrid(true);
    renderer.setXLabelsAlign(Align.RIGHT);
    renderer.setYLabelsAlign(Align.RIGHT);
    //renderer.setLabelsColor(Color.BLUE);//设置显示的字体的颜色
    renderer.setApplyBackgroundColor(true);// 设置允许设置格子的背景颜色
    //renderer.setBackgroundColor(Color.WHITE);
    //renderer.setMarginsColor(Color.WHITE);
    renderer.setMargins(new int[]{20,40,15,5});//top,left,bottom,right
    renderer.setZoomButtonsVisible(true);//设置缩放4
    renderer.setPanLimits(new double[] { 0, 20,0, 40 });//拖动时的距离大小
    renderer.setZoomLimits(new double[] { 0, 20, 0, 40 });//按钮缩放大小
  
    GraphicalView intent = ChartFactory.getLineChartView(context, 
    		buildDataset(titles, x, values),renderer);
	return intent;
}

}
