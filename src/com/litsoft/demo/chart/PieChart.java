package com.litsoft.demo.chart;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.renderer.DefaultRenderer;

import com.litsoft.demo.AbstractDemoChart;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

/**
 * Budget demo pie chart.
 */
public class PieChart extends AbstractDemoChart {
	/**
	 * Returns the chart name.
	 * 
	 * @return the chart name
	 */
	public String getName() {
		return "Budget chart";
	}

	/**
	 * Returns the chart description.
	 * 
	 * @return the chart description
	 */
	public String getDesc() {
		return "The budget per project for this year (pie chart)";
	}

	/**
	 * Executes the chart demo.
	 * 
	 * @param context
	 *            the context
	 * @return the built intent
	 */
	public Intent execute(Context context) {
		double[] values = new double[] { 80, 77, 18, 703, 142 };

		String[] titles = { "紧急事件", "严重事件", "重要事件", "警告", "被阻断的攻击事件" };
		int[] colors = new int[] { Color.BLUE, Color.GREEN, Color.MAGENTA,
				Color.YELLOW, Color.CYAN };
		DefaultRenderer renderer = buildCategoryRenderer(colors);
		// renderer.setMargins(0,0,30,0);
		renderer.setApplyBackgroundColor(true);
		// renderer.setBackgroundColor(Color.WHITE);
		renderer.setZoomButtonsVisible(true);
		renderer.setZoomEnabled(true);
		renderer.setChartTitleTextSize(15);
		renderer.setLabelsColor(Color.WHITE);
		renderer.setChartTitle("网络攻击统计");

		return ChartFactory.getPieChartIntent(context,
				buildCategoryDataset("Project budget", titles, values),
				renderer, "网络攻击统计");
	}

	public GraphicalView executeview(Context context, double[] values,
			String[] titles, int[] colors) {
		DefaultRenderer renderer = buildCategoryRenderer(colors);
		// renderer.setMargins(0,0,30,0);
		renderer.setApplyBackgroundColor(true);
		// renderer.setBackgroundColor(Color.WHITE);
		renderer.setZoomButtonsVisible(true);
		renderer.setZoomEnabled(true);
		renderer.setChartTitleTextSize(15);
		renderer.setLabelsColor(Color.WHITE);
		// renderer.setDisplayChartValues(true);
		// renderer.setShowLabels(false);
		renderer.setShowLegend(true);// 显示图例
		// renderer.setChartTitle(biaoti);
		renderer.setFitLegend(false);
		return ChartFactory.getPieChartView(context,
				buildCategoryDataset("Project budget", titles, values),
				renderer);

	}

	@Override
	public GraphicalView executeGetView(Context context) {
		// TODO Auto-generated method stub
		double[] values = new double[] { 80, 77, 18, 703, 142 };

		String[] titles = { "紧急事件", "严重事件", "重要事件", "警告事件", "被阻断的攻击事件" };
		int[] colors = new int[] { Color.BLUE, Color.GREEN, Color.MAGENTA,
				Color.YELLOW, Color.CYAN };
		DefaultRenderer renderer = buildCategoryRenderer(colors);
		// renderer.setMargins(0,0,30,0);
		renderer.setApplyBackgroundColor(true);
		// renderer.setBackgroundColor(Color.WHITE);
		renderer.setZoomButtonsVisible(true);
		renderer.setZoomEnabled(true);
		renderer.setChartTitleTextSize(15);
		renderer.setLabelsColor(Color.WHITE);
		/* renderer.setChartTitle("网络攻击统计"); */

		return ChartFactory.getPieChartView(context,
				buildCategoryDataset("Project budget", titles, values),
				renderer);
	}
}
