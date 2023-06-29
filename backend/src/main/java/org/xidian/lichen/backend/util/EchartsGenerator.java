package org.xidian.lichen.backend.util;

import org.icepear.echarts.Bar;
import org.icepear.echarts.Line;
import org.icepear.echarts.Pie;
import org.icepear.echarts.charts.pie.*;
import org.icepear.echarts.components.coord.cartesian.CategoryAxis;
import org.icepear.echarts.components.coord.cartesian.ValueAxis;
import org.icepear.echarts.render.Engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EchartsGenerator {
    public void drawIntBar(String title,
                        String[] xAxis,
                        Map<String, Integer[]> series,
                        String htmlPath) {
        Bar bar = new Bar()
                .setTitle(title)
                .setTooltip("item")    // item or axis
                .setLegend()
                .addXAxis(xAxis)
                .addYAxis();
        for (String key : series.keySet()) {
            bar.addSeries(key, series.get(key));
        }

        // render it
        Engine engine = new Engine();
        engine.render(htmlPath, bar);
    }

    public void drawFloatBar(String title,
                        String[] xAxis,
                        Map<String, Double[]> series,
                        String htmlPath) {
        Bar bar = new Bar()
                .setTitle(title)
                .setTooltip("item")    // item or axis
                .setLegend()
                .addXAxis(xAxis)
                .addYAxis();
        for (String key : series.keySet()) {
            bar.addSeries(key, series.get(key));
        }

        // render it
        Engine engine = new Engine();
        engine.render(htmlPath, bar);
    }

    // line
    public void drawIntLine(String title,
                         String[] xAxis,
                         Map<String, Integer[]> series,
                         String htmlPath) {
        Line line = new Line()
                .setLegend()
                .setTitle(title)
                .setTooltip("axis")
                .addXAxis(new CategoryAxis()
                        .setBoundaryGap(false)
                        .setData(xAxis))
                .addYAxis(new ValueAxis().setScale(true));
        for (String key : series.keySet()) {
            line.addSeries(key, series.get(key));
        }

        Engine engine = new Engine();
        engine.render(htmlPath, line);
    }

    public void drawFloatLine(String title,
                         String[] xAxis,
                         Map<String, Double[]> series,
                         String htmlPath) {
        Line line = new Line()
                .setLegend()
                .setTitle(title)
                .setTooltip("axis")
                .addXAxis(new CategoryAxis()
                        .setBoundaryGap(false)
                        .setData(xAxis))
                .addYAxis(new ValueAxis().setScale(true));
        for (String key : series.keySet()) {
            line.addSeries(key, series.get(key));
        }

        Engine engine = new Engine();
        engine.render(htmlPath, line);
    }



    // pine
    public void drawIntPie(String title, Map<String, Integer> items, String htmlPath) {
        List<PieDataItem> dataItems = new ArrayList<>();
        for (String key : items.keySet()) {
            dataItems.add(new PieDataItem().setName(key).setValue(items.get(key)));
        }

        Pie pie = new Pie()
                .setTooltip("item")
                .setLegend()
                .addSeries(new PieSeries().setRadius(new String[] { "40%", "70%" })
                        .setItemStyle(new PieItemStyle()
                                .setBorderRadius(10)
                                .setBorderColor("#fff")
                                .setBorderWidth(2))
                        .setLabel(new PieLabel().setShow(false).setPosition("center"))
                        .setEmphasis(new PieEmphasis().setLabel(new PieLabel()
                                .setShow(true).setFontSize(20).setFontWeight("bold")))
                        .setData(dataItems.toArray()));

        Engine engine = new Engine();
        engine.render(htmlPath, pie);
    }

    public void drawDoublePie(String title, Map<String, Double> items, String htmlPath) {
        List<PieDataItem> dataItems = new ArrayList<>();
        for (String key : items.keySet()) {
            dataItems.add(new PieDataItem().setName(key).setValue(items.get(key)));
        }

        Pie pie = new Pie()
                .setTooltip("item")
                .setLegend()
                .addSeries(new PieSeries().setRadius(new String[] { "40%", "70%" })
                        .setItemStyle(new PieItemStyle()
                                .setBorderRadius(10)
                                .setBorderColor("#fff")
                                .setBorderWidth(2))
                        .setLabel(new PieLabel().setShow(false).setPosition("center"))
                        .setEmphasis(new PieEmphasis().setLabel(new PieLabel()
                                .setShow(true).setFontSize(20).setFontWeight("bold")))
                        .setData(dataItems.toArray()));

        Engine engine = new Engine();
        engine.render(htmlPath, pie);
    }
}
