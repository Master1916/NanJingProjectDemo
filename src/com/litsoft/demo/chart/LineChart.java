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
import java.util.Random;

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
public class LineChart extends AbstractDemoChart {
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
	 * @param context
	 *            the context
	 * @return the built intent
	 */
	public Intent execute(Context context, String title_time) {

		// String[] titles = new String[] { "Crete", "Corfu", "Thassos",
		// "Skiathos" };
		String[] titles = new String[] { "接受流量", "发送流量" };

		List<double[]> x = new ArrayList<double[]>();
		List<double[]> values = new ArrayList<double[]>();

		for (int i = 0; i < titles.length; i++) {
			x.add(new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
					15, 16, 17, 18, 19, 20, 21, 22, 23, 24 });
		}

		// Random r = new Random();
		double into[] = new double[] { 12.3, 14, 21, 34.334, 22, 24.4, 26.4,
				26.1, 23.6, 20.3, 17.2, 13.9, 12.3, 12.5, 13.8, 77, 20.4, 24.4,
				26.4, 123, 123, 22, 17.2, 13.9 };
		double out[] = new double[] { 34, 10, 12, 88, 20, 12, 26, 32.22, 23,
				18, 14, 11, 5, 5.3, 24, 12, 17, 120, 67, 44, 15, 122, 9, 6 };
		/*
		 * for (int i = 0; i < 24; i++) { into[i] = r.nextDouble() * 125; out[i]
		 * = r.nextDouble() * 125; }
		 */

		values.add(into);
		values.add(out);

		// values.add(new double[] { 5, 5.3, 8, 12, 17, 22, 24.2, 24, 19, 15, 9,
		// 6 });
		// values.add(new double[] { 9, 10, 11, 15, 19, 23, 26, 25, 22, 18, 13,
		// 10 });

		// int[] colors = new int[] { Color.BLUE, Color.GREEN, Color.CYAN,
		// Color.YELLOW };
		int[] colors = new int[] { Color.RED, Color.GREEN };
		// PointStyle[] styles = new PointStyle[] { PointStyle.CIRCLE,
		// PointStyle.DIAMOND,PointStyle.TRIANGLE, PointStyle.SQUARE };
		PointStyle[] styles = new PointStyle[] { PointStyle.CIRCLE,
				PointStyle.DIAMOND };
		XYMultipleSeriesRenderer renderer = buildRenderer(colors, styles);// 设置颜色和风格

		int length = renderer.getSeriesRendererCount();
		for (int i = 0; i < length; i++) {
			((XYSeriesRenderer) renderer.getSeriesRendererAt(i))
					.setFillPoints(true);
		}

		setChartSettings(renderer, title_time, "时间(小时)", "网络流量(Mbps)", 1, 24,
				0, 125, Color.LTGRAY, Color.LTGRAY);// 设置 显示的风格
		renderer.setXLabels(12);

		// renderer.setXLabels();// X轴的最小的精度

		renderer.setYLabels(10);// Y最小的精度
		renderer.setShowGrid(true);
		renderer.setXLabelsAlign(Align.RIGHT);
		renderer.setYLabelsAlign(Align.RIGHT);
		// renderer.setLabelsColor(Color.BLUE);//设置显示的字体的颜色
		renderer.setApplyBackgroundColor(true);// 设置允许设置格子的背景颜色
		// renderer.setBackgroundColor(Color.WHITE);
		// renderer.setMarginsColor(Color.WHITE);
		renderer.setMargins(new int[] { 30, 35, 15, 5 });// top,left,bottom,right
		renderer.setZoomButtonsVisible(true);// 设置缩放4
		renderer.setPanLimits(new double[] { 0, 20, 0, 40 });// 拖动时的距离大小
		renderer.setZoomLimits(new double[] { 0, 20, 0, 40 });// 按钮缩放大小

		Intent intent = ChartFactory.getLineChartIntent(context,
				buildDataset(titles, x, values), renderer);
		return intent;
	}

	@Override
	public Intent execute(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GraphicalView executeGetView(Context context, String title_time) {
		// TODO Auto-generated method stub
		// String[] titles = new String[] { "Crete", "Corfu", "Thassos",
		// "Skiathos" };
		String[] titles = new String[] { "接受流量", "发送流量" };

		List<double[]> x = new ArrayList<double[]>();
		List<double[]> values = new ArrayList<double[]>();

		for (int i = 0; i < titles.length; i++) {
			x.add(new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
					15, 16, 17, 18, 19, 20, 21, 22, 23, 24 });
		}

		// Random r = new Random();
		double into[] = new double[] { 12.3, 14, 21, 34.334, 22, 24.4, 26.4,
				26.1, 23.6, 20.3, 17.2, 13.9, 12.3, 12.5, 13.8, 77, 20.4, 24.4,
				26.4, 123, 123, 22, 17.2, 13.9 };
		double out[] = new double[] { 34, 10, 12, 88, 20, 12, 26, 32.22, 23,
				18, 14, 11, 5, 5.3, 24, 12, 17, 120, 67, 44, 15, 122, 9, 6 };
		/*
		 * for (int i = 0; i < 24; i++) { into[i] = r.nextDouble() * 125; out[i]
		 * = r.nextDouble() * 125; }
		 */

		values.add(into);
		values.add(out);

		// values.add(new double[] { 5, 5.3, 8, 12, 17, 22, 24.2, 24, 19, 15, 9,
		// 6 });
		// values.add(new double[] { 9, 10, 11, 15, 19, 23, 26, 25, 22, 18, 13,
		// 10 });

		// int[] colors = new int[] { Color.BLUE, Color.GREEN, Color.CYAN,
		// Color.YELLOW };
		int[] colors = new int[] { Color.RED, Color.GREEN };
		// PointStyle[] styles = new PointStyle[] { PointStyle.CIRCLE,
		// PointStyle.DIAMOND,PointStyle.TRIANGLE, PointStyle.SQUARE };
		PointStyle[] styles = new PointStyle[] { PointStyle.CIRCLE,
				PointStyle.DIAMOND };
		XYMultipleSeriesRenderer renderer = buildRenderer(colors, styles);// 设置颜色和风格

		int length = renderer.getSeriesRendererCount();
		for (int i = 0; i < length; i++) {
			((XYSeriesRenderer) renderer.getSeriesRendererAt(i))
					.setFillPoints(true);
		}

		setChartSettings(renderer, title_time, "时间(小时)", "网络流量(Mbps)", 1, 24,
				0, 125, Color.LTGRAY, Color.LTGRAY);// 设置 显示的风格
		renderer.setXLabels(12);

		// renderer.setXLabels();// X轴的最小的精度

		renderer.setYLabels(10);// Y最小的精度
		renderer.setShowGrid(true);
		renderer.setXLabelsAlign(Align.RIGHT);
		renderer.setYLabelsAlign(Align.RIGHT);
		// renderer.setLabelsColor(Color.BLUE);//设置显示的字体的颜色
		renderer.setApplyBackgroundColor(true);// 设置允许设置格子的背景颜色
		// renderer.setBackgroundColor(Color.WHITE);
		// renderer.setMarginsColor(Color.WHITE);
		renderer.setMargins(new int[] { 30, 35, 15, 5 });// top,left,bottom,right
		renderer.setZoomButtonsVisible(true);// 设置缩放4
		renderer.setPanLimits(new double[] { 0, 20, 0, 40 });// 拖动时的距离大小
		renderer.setZoomLimits(new double[] { 0, 20, 0, 40 });// 按钮缩放大小

		GraphicalView GraphicalView = ChartFactory.getLineChartView(context,
				buildDataset(titles, x, values), renderer);
		return GraphicalView;
	}

	@Override
	public GraphicalView executeGetView(Context context) {

		String[] titles = new String[] { "接受流量", "发送流量" };

		List<double[]> x = new ArrayList<double[]>();
		List<double[]> values = new ArrayList<double[]>();

		for (int i = 0; i < titles.length; i++) {
			x.add(new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
					15, 16, 17, 18, 19, 20, 21, 22, 23, 24 });
		}

		/*
		 * 
		 * double into[] = new double[24]; double out[] = new double[24];
		 */

		double into[] = new double[] { 4.4, 2.1, 2.8, 2.7, 2, 2.6, 7.8, 13, 19,
				17, 10, 3.5, 1.7, 0.5, 0.6, 9.3, 12.3, 1.8, 1.2, 6.9, 6.3, 3.3,
				3, 1.7, 3.4 };
		double out[] = new double[] { 23, 8, 1.9, 0.8, 1.6, 2.4, 0.4, 0.3, 0.7,
				5.2, 1.5, 1.4, 1.2, 1.5, 2.8, 16, 1.2, 16, 4, 19, 30, 122, 39,
				10 };

		Random r = new Random();
        int temp=r.nextInt(10);
        System.out.println(temp);
		for (int i = temp; i < 24; i+=8) {
			 into[i] = r.nextDouble() * 125;
			 out[i] = r.nextDouble() * 125;
		}

		values.add(into);
		values.add(out);

		int[] colors = new int[] { Color.RED, Color.GREEN };
		// PointStyle[] styles = new PointStyle[] { PointStyle.CIRCLE,
		// PointStyle.DIAMOND,PointStyle.TRIANGLE, PointStyle.SQUARE };
		PointStyle[] styles = new PointStyle[] { PointStyle.CIRCLE,
				PointStyle.DIAMOND };
		XYMultipleSeriesRenderer renderer = buildRenderer(colors, styles);// 设置颜色和风格

		int length = renderer.getSeriesRendererCount();
		for (int i = 0; i < length; i++) {
			((XYSeriesRenderer) renderer.getSeriesRendererAt(i))
					.setFillPoints(true);
		}

		setChartSettings(renderer, "", "时间(小时)", "网络流量(Mbps)", 1, 24, 0, 125,
				Color.LTGRAY, Color.LTGRAY);// 设置 显示的风格
		renderer.setXLabels(12);

		// renderer.setXLabels();// X轴的最小的精度

		renderer.setYLabels(10);// Y最小的精度
		renderer.setShowGrid(true);
		renderer.setXLabelsAlign(Align.CENTER);// 设置数字在刻度的中间还是左边或是右边
		renderer.setYLabelsAlign(Align.RIGHT);
		renderer.setGridColor(Color.WHITE);

		// renderer.setLabelsColor(Color.BLUE);//设置显示的字体的颜色
		renderer.setLabelsTextSize(15);
		// renderer.setChartTitleTextSize(8);//设置表的标题的字体大小
		// renderer.setLegendTextSize(15);
		renderer.setAxisTitleTextSize(15);

		renderer.setApplyBackgroundColor(true);// 设置允许设置格子的背景颜色
		renderer.setBackgroundColor(android.graphics.Color
				.parseColor("#1f1f1f"));
		renderer.setMarginsColor(android.graphics.Color.parseColor("#1f1f1f"));
		renderer.setMargins(new int[] { 15, 45, 25, 15 });// top,left,bottom,right
		// renderer.setMarginsColor(Color.GREEN);
		renderer.setLegendHeight(70);

		renderer.setZoomButtonsVisible(true);

		// renderer.setPanLimits(new double[] { 0, 20, 0, 40 });// 拖动时的距离大小
		// renderer.setZoomLimits(new double[] { 0, 20, 0, 40 });// 按钮缩放大小

		GraphicalView GraphicalView = ChartFactory.getLineChartView(context,
				buildDataset(titles, x, values), renderer);
		return GraphicalView;
	}
}
