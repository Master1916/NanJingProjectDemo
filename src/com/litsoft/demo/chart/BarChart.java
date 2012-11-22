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

import java.util.Random;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint.Align;

import com.litsoft.demo.AbstractDemoChart;

/**
 * Combined temperature demo chart.
 */
public class BarChart extends AbstractDemoChart {
	/**
	 * Returns the chart name.
	 * 
	 * @return the chart name
	 */
	public String getName() {
		return null;
	}

	/**
	 * Returns the chart description.
	 * 
	 * @return the chart description
	 */
	public String getDesc() {
		return null;
	}

	public Intent execute(Context context, double valuse[], String Legend,
			String title, String xTitle, String yTitle, double xStart,
			double xEnd, int xNum, int color) {

		XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
		renderer.setAxisTitleTextSize(16);
		renderer.setChartTitleTextSize(20);
		renderer.setLabelsTextSize(15);
		renderer.setLegendTextSize(15);
		renderer.setBarSpacing(0.5);//
		renderer.setMargins(new int[] { 40, 40, 15, 0 });
		renderer.setZoomButtonsVisible(true);// 设置缩放4
		// renderer.setPanLimits(new double[] { 0, 20, 0, 40 });// 拖动时的距离大小
		// renderer.setZoomLimits(new double[] { 0, 20, 0, 40 });// 按钮缩放大小
		renderer.setDisplayChartValues(true);
		SimpleSeriesRenderer r = new SimpleSeriesRenderer();
		r.setColor(color);
		renderer.addSeriesRenderer(r);

		renderer.setFitLegend(true);
		renderer.setChartTitle(title);
		renderer.setXTitle(xTitle);
		renderer.setYTitle(yTitle);
		renderer.setXAxisMin(xStart);
		renderer.setXAxisMax(xEnd);
		renderer.setXLabels(xNum);

		renderer.setYLabelsAlign(Align.RIGHT);
		renderer.setYAxisMin(0);
		renderer.setYAxisMax(300);
		renderer.setYLabels(10);

		XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
		java.text.NumberFormat formater = java.text.DecimalFormat.getInstance();
		formater.setMaximumFractionDigits(2);
		Random r1 = new Random();
		CategorySeries series = new CategorySeries(Legend);
		for (int i = 0; i < valuse.length; i++) {

			series.add(valuse[i]);
		}
		dataset.addSeries(series.toXYSeries());
		Intent intent = ChartFactory.getBarChartIntent(context, dataset,
				renderer, null);
		return intent;
	}

	public Intent execute(Context context, int color, String time,
			String title, int flag) {
		XYMultipleSeriesRenderer renderer = getBarDemoRenderer(color);
		setChartSettings(renderer,flag);
		Intent intent = ChartFactory.getBarChartIntent(context,
				getBarDemoDataset(title), renderer, null);
		return intent;
	}

	public GraphicalView executeview(Context context, int color, String title,
			int flag) {
		XYMultipleSeriesRenderer renderer = getBarDemoRenderer(color);
		setChartSettings(renderer, flag);
		GraphicalView view = ChartFactory.getBarChartView(context,
				getBarDemoDataset(title), renderer, null);
		return view;

	}

	private void setChartSettings(XYMultipleSeriesRenderer renderer, int flag) {
		// renderer.setChartTitle(tilte);
		renderer.setXTitle("时间(周)");
		renderer.setYTitle("数量(个)");
		if (flag == 0) {
			renderer.setXAxisMin(0.5);
			renderer.setXAxisMax(10.5);
			renderer.setXLabels(10);
		} else {
			// renderer.setShowAxes(false);

			// renderer.setXAxisMin(10.5*flag);
			// renderer.setXAxisMax(10.5*flag+10.5);
			renderer.setXAxisMin(0.5);
			renderer.setXAxisMax(10.5);
			renderer.setXLabels(0);
			int lang = flag * 10;
			for (int i = 0; i <= 10; i++) {

				renderer.addTextLabel(i, String.valueOf(lang));
				lang++;

			}
		}
		 
		renderer.setYLabelsAlign(Align.RIGHT);
		renderer.setYAxisMin(0);
		renderer.setYAxisMax(300);
		renderer.setYLabels(10);
		renderer.setDisplayChartValues(true);
		// renderer.setOrientation(XYMultipleSeriesRenderer.Orientation.VERTICAL);设置方向

		// renderer.setZoomEnabled(true);
		// / renderer.setPanLimits(0,20,0,20);

	}

	private XYMultipleSeriesDataset getBarDemoDataset(String title) {
		XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
		java.text.NumberFormat formater = java.text.DecimalFormat.getInstance();
		formater.setMaximumFractionDigits(2);
		Random r = new Random();
		CategorySeries series = new CategorySeries(title);
		for (int i = 0; i < 10; i++) {
			double temp = r.nextDouble() * 300;
			series.add(Double.valueOf(formater.format(temp)));
		}
		dataset.addSeries(series.toXYSeries());
		return dataset;
	}

	public XYMultipleSeriesRenderer getBarDemoRenderer(int color) {
		XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
		renderer.setAxisTitleTextSize(16);
		renderer.setChartTitleTextSize(20);
		renderer.setLabelsTextSize(15);
		renderer.setLegendTextSize(15);
		renderer.setBarSpacing(0.5);//设置注状图是整个的一半宽
		renderer.setMargins(new int[] { 0, 40,0, 0 });
		renderer.setMarginsColor(android.graphics.Color.parseColor("#1E1D1E"));
		renderer.setZoomButtonsVisible(true);// 设置缩放4
		//renderer.setPanLimits(new double[] { 0, 20, 0, 40 });// 拖动时的距离大小
		//renderer.setZoomLimits(new double[] { 0, 20, 0, 40 });// 按钮缩放大小
		renderer.setDisplayChartValues(true);
		SimpleSeriesRenderer r = new SimpleSeriesRenderer();
		r.setColor(color);
		renderer.addSeriesRenderer(r);
		return renderer;
	}

	@Override
	public Intent execute(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GraphicalView executeGetView(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	public GraphicalView executeGetView(Context context, double valuse[],
			String Legend, String xTitle, String yTitle, double xStart,
			double xEnd, int xNum, int color) {

		XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
		renderer.setAxisTitleTextSize(16);
		renderer.setChartTitleTextSize(20);
		renderer.setLabelsTextSize(15);
		renderer.setLegendTextSize(15);
		renderer.setBarSpacing(0.5);//
		renderer.setMargins(new int[] { 0, 40, 30, 10 });
		renderer.setZoomButtonsVisible(true);// 设置缩放4
		// renderer.setPanLimits(new double[] { 0, 20, 0, 40 });// 拖动时的距离大小
		// renderer.setZoomLimits(new double[] { 0, 20, 0, 40 });// 按钮缩放大小
		renderer.setDisplayChartValues(true);
		SimpleSeriesRenderer r = new SimpleSeriesRenderer();
		r.setColor(color);
		renderer.addSeriesRenderer(r);

		renderer.setFitLegend(true);
		renderer.setBackgroundColor(android.graphics.Color.parseColor("#1E1D1E"));
		renderer.setMarginsColor(android.graphics.Color.parseColor("#1E1D1E"));
		renderer.setXTitle(xTitle);
		renderer.setYTitle(yTitle);
		renderer.setXAxisMin(xStart);
		renderer.setXAxisMax(xEnd);
		renderer.setXLabels(xNum);

		renderer.setYLabelsAlign(Align.RIGHT);
		renderer.setYAxisMin(0);
		renderer.setYAxisMax(300);
		renderer.setYLabels(10);

		XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
		java.text.NumberFormat formater = java.text.DecimalFormat.getInstance();
		formater.setMaximumFractionDigits(2);
		Random r1 = new Random();
		CategorySeries series = new CategorySeries(Legend);
		for (int i = 0; i < valuse.length; i++) {

			series.add(valuse[i]);
		}
		dataset.addSeries(series.toXYSeries());
		GraphicalView view = ChartFactory.getBarChartView(context, dataset,
				renderer, null);
		return view;

	}

}
