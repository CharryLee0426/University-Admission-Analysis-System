package org.xidian.lichen.backend.util;

import org.apache.poi.util.Units;
import org.apache.poi.xddf.usermodel.chart.*;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageSz;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

import java.io.*;
import java.math.BigInteger;

public class MicrosoftDocxGenerator {
    private XWPFDocument document = new XWPFDocument();
    private String filePath;

    private int column = 0;
    private XWPFTable table;

    public MicrosoftDocxGenerator(String filePath) {
        this.filePath = filePath;

        XWPFStyles styles = this.document.getStyles();

        // there must be section properties for the page having at least the page size set
        CTSectPr sectPr = this.document.getDocument().getBody().addNewSectPr();
        CTPageSz pageSz = sectPr.addNewPgSz();
        pageSz.setW(BigInteger.valueOf(12240)); //12240 Twips = 12240/20 = 612 pt = 612/72 = 8.5"
        pageSz.setH(BigInteger.valueOf(15840)); //15840 Twips = 15840/20 = 792 pt = 792/72 = 11"

    }

    public void addTitle(String title) {
        XWPFParagraph paragraph = this.document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run = paragraph.createRun();
        run.setBold(true);
        run.setFontSize(28);

        run.setText(title);
    }

    public void addHeading(String heading) {
        XWPFParagraph paragraph = this.document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setBold(true);
        run.setFontSize(20);
        run.setText(heading);

        // new line
        XWPFParagraph newLine = this.document.createParagraph();
        XWPFRun newLineRun = newLine.createRun();
        run.setText("\n");
    }

    public void addSubHeading(String heading) {
        XWPFParagraph paragraph = this.document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setBold(true);
        run.setFontSize(16);
        run.setText(heading);

        // new line
        XWPFParagraph newLine = this.document.createParagraph();
        XWPFRun newLineRun = newLine.createRun();
        run.setText("\n");
    }
    public void addParagraph(String text) {
        XWPFParagraph paragraph = this.document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("\t" + text);

        // new line
        XWPFParagraph newLine = this.document.createParagraph();
        XWPFRun newLineRun = newLine.createRun();
        run.setText("\n");
    }

    public void addTable(int column, String[] columnNames) throws Exception {
        if (columnNames.length == column && column > 1) {
            XWPFParagraph paragraph = document.createParagraph();
            paragraph.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run = paragraph.createRun();
            this.column = column;
            this.table = document.createTable();
            this.table.setWidth("80%");
            this.table.setTableAlignment(TableRowAlign.CENTER);
            XWPFTableRow columnRow = this.table.getRow(0);

            table.getCTTbl().addNewTblGrid().addNewGridCol().setW(BigInteger.valueOf(1 * 1440)); // 2 * 1440

            XWPFParagraph firstColumnParagraph = columnRow.getCell(0).getParagraphs().get(0);
            firstColumnParagraph.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun firstColumnRun = firstColumnParagraph.createRun();
            firstColumnRun.setText(columnNames[0]);
            for (int i = 1; i < columnNames.length; i++) {
                table.getCTTbl().getTblGrid().addNewGridCol().setW(BigInteger.valueOf(1 * 1440));

                XWPFTableCell cell = columnRow.addNewTableCell();
                XWPFParagraph cellParagraph = cell.getParagraphs().get(0);
                cellParagraph.setAlignment(ParagraphAlignment.CENTER);
                XWPFRun cellRun = cellParagraph.createRun();
                cellRun.setText(columnNames[i]);
            }
        } else {
            throw new Exception("Please check your column names and column number first");
        }
    }

    public void addTableItem(String[] item) throws Exception {
        if (this.column == 0 || this.table == null || this.column != item.length) {
            throw new Exception("Please check your item data first, or add table first");
        } else {
            this.table.setWidth("80%");
            this.table.setTableAlignment(TableRowAlign.CENTER);
            XWPFTableRow row = this.table.createRow();
            for (int i = 0; i < this.column; i++) {
                XWPFTableCell cell = row.getCell(i);
                XWPFParagraph cellParagraph = cell.getParagraphs().get(0);
                cellParagraph.setAlignment(ParagraphAlignment.CENTER);
                XWPFRun cellRun = cellParagraph.createRun();
                cellRun.setText(item[i]);
            }
        }
    }

    public void addQuote(String quote) {
        // there must be section properties for the page having at least the page size set
        CTSectPr sectPr = this.document.getDocument().getBody().addNewSectPr();
        CTPageSz pageSz = sectPr.addNewPgSz();
        pageSz.setW(BigInteger.valueOf(12240)); //12240 Twips = 12240/20 = 612 pt = 612/72 = 8.5"
        pageSz.setH(BigInteger.valueOf(15840)); //15840 Twips = 15840/20 = 792 pt = 792/72 = 11"

        XWPFParagraph paragraph = this.document.createParagraph();
        paragraph.setIndentFromLeft(2000);      // ~ 2.5 inch
        paragraph.setIndentationRight(2000);    // ~ 2.5 inch
        paragraph.setIndentationFirstLine(500);
        paragraph.setVerticalAlignment(TextAlignment.CENTER);
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        paragraph.setBorderTop(Borders.BASIC_BLACK_DASHES);
        paragraph.setBorderLeft(Borders.BASIC_BLACK_DASHES);
        paragraph.setBorderRight(Borders.BASIC_BLACK_DASHES);
        paragraph.setBorderBottom(Borders.BASIC_BLACK_DASHES);
        XWPFRun run = paragraph.createRun();
        run.setFontSize(10);
        run.setItalic(true);
        run.setColor("737379");

        run.setText(quote);
    }

    public void addImage(String imgPath) throws Exception {
        // there must be section properties for the page having at least the page size set
        CTSectPr sectPr = this.document.getDocument().getBody().addNewSectPr();
        CTPageSz pageSz = sectPr.addNewPgSz();
        pageSz.setW(BigInteger.valueOf(12240)); //12240 Twips = 12240/20 = 612 pt = 612/72 = 8.5"
        pageSz.setH(BigInteger.valueOf(15840)); //15840 Twips = 15840/20 = 792 pt = 792/72 = 11"

        XWPFParagraph newLine = this.document.createParagraph();
        XWPFRun newLineRun = newLine.createRun();
        newLineRun.setText("\n");
        XWPFParagraph paragraph = this.document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run = paragraph.createRun();

        InputStream imgInput = new FileInputStream(imgPath);
        int pictureType = Document.PICTURE_TYPE_PNG;

        run.addPicture(imgInput, pictureType, imgPath, Units.toEMU(200), Units.toEMU(200));
    }

    public void addIntBar(String title,
                          String xTitle,
                          String[] xAxisData,
                          String yTitle,
                          Integer[] yAxisData,
                          String legendTitle) throws Exception {
        XWPFChart chart = this.document.createChart(15 * Units.EMU_PER_CENTIMETER,
                10 * Units.EMU_PER_CENTIMETER);

        chart.setTitleText(title);
        chart.setTitleOverlay(false);

//        XDDFChartLegend legend = chart.getOrAddLegend();
//        legend.setPosition(LegendPosition.TOP);

        XDDFCategoryAxis xAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
        xAxis.setTitle(xTitle);
        XDDFCategoryDataSource xAxisDatasource = XDDFDataSourcesFactory.fromArray(xAxisData);

        XDDFValueAxis yAxis = chart.createValueAxis(AxisPosition.LEFT);
        yAxis.setTitle(yTitle);
        yAxis.setCrossBetween(AxisCrossBetween.BETWEEN);
        XDDFNumericalDataSource<Integer> yAxisDatasource = XDDFDataSourcesFactory.fromArray(yAxisData);

        XDDFBarChartData barChart = (XDDFBarChartData) chart.createData(ChartTypes.BAR, xAxis, yAxis);
        barChart.setBarDirection(BarDirection.COL); // default is BarDirect.BAR

        XDDFBarChartData.Series barSeries = (XDDFBarChartData.Series) barChart.addSeries(xAxisDatasource,
                yAxisDatasource);
        barSeries.setTitle(legendTitle, null);

        chart.plot(barChart);
    }

    public void addDoubleBar(String title,
                          String xTitle,
                          String[] xAxisData,
                          String yTitle,
                          Double[] yAxisData,
                          String legendTitle) throws Exception {
        XWPFChart chart = this.document.createChart(15 * Units.EMU_PER_CENTIMETER,
                10 * Units.EMU_PER_CENTIMETER);

        chart.setTitleText(title);
        chart.setTitleOverlay(false);

//        XDDFChartLegend legend = chart.getOrAddLegend();
//        legend.setPosition(LegendPosition.TOP);

        XDDFCategoryAxis xAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
        xAxis.setTitle(xTitle);
        XDDFCategoryDataSource xAxisDatasource = XDDFDataSourcesFactory.fromArray(xAxisData);

        XDDFValueAxis yAxis = chart.createValueAxis(AxisPosition.LEFT);
        yAxis.setTitle(yTitle);
        yAxis.setCrossBetween(AxisCrossBetween.BETWEEN);
        XDDFNumericalDataSource<Double> yAxisDatasource = XDDFDataSourcesFactory.fromArray(yAxisData);

        XDDFBarChartData barChart = (XDDFBarChartData) chart.createData(ChartTypes.BAR, xAxis, yAxis);
        barChart.setBarDirection(BarDirection.COL); // default is BarDirect.BAR

        XDDFBarChartData.Series barSeries = (XDDFBarChartData.Series) barChart.addSeries(xAxisDatasource,
                yAxisDatasource);
        barSeries.setTitle(legendTitle, null);

        chart.plot(barChart);
    }

    public void addIntLine(String title,
                           String xTitle,
                           String[] xAxisData,
                           String yTitle,
                           Integer[] yAxisData,
                           String legendTitle) throws Exception {
        XWPFChart chart = this.document.createChart(15 * Units.EMU_PER_CENTIMETER,
                10 * Units.EMU_PER_CENTIMETER);
        chart.setTitleText(title);
        chart.setTitleOverlay(false);

        XDDFChartLegend legend = chart.getOrAddLegend();
        legend.setPosition(LegendPosition.TOP);

        XDDFCategoryAxis xAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
        xAxis.setTitle(xTitle);
        XDDFCategoryDataSource xAxisDatasource = XDDFDataSourcesFactory.fromArray(xAxisData);

        XDDFValueAxis yAxis = chart.createValueAxis(AxisPosition.LEFT);
        yAxis.setTitle(yTitle);
        yAxis.setCrossBetween(AxisCrossBetween.BETWEEN);
        XDDFNumericalDataSource<Integer> yAxisDatasource = XDDFDataSourcesFactory.fromArray(yAxisData);

        XDDFLineChartData lineChart = (XDDFLineChartData) chart.createData(ChartTypes.LINE, xAxis, yAxis);

        XDDFLineChartData.Series lineSeries = (XDDFLineChartData.Series) lineChart.addSeries(xAxisDatasource,
                yAxisDatasource);
        lineSeries.setTitle(legendTitle, null);
        lineSeries.setSmooth(true);
        lineSeries.setMarkerSize((short) 6);
        lineSeries.setMarkerStyle(MarkerStyle.CIRCLE);

        chart.plot(lineChart);
    }

    public void addDoubleLine(String title,
                              String xTitle,
                              String[] xAxisData,
                              String yTitle,
                              Double[] yAxisData,
                              String legendTitle) throws Exception {
        XWPFChart chart = this.document.createChart(15 * Units.EMU_PER_CENTIMETER,
                10 * Units.EMU_PER_CENTIMETER);
        chart.setTitleText(title);
        chart.setTitleOverlay(false);

//        XDDFChartLegend legend = chart.getOrAddLegend();
//        legend.setPosition(LegendPosition.TOP);

        XDDFCategoryAxis xAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
        xAxis.setTitle(xTitle);
        XDDFCategoryDataSource xAxisDatasource = XDDFDataSourcesFactory.fromArray(xAxisData);

        XDDFValueAxis yAxis = chart.createValueAxis(AxisPosition.LEFT);
        yAxis.setTitle(yTitle);
        yAxis.setCrossBetween(AxisCrossBetween.BETWEEN);
        XDDFNumericalDataSource<Double> yAxisDatasource = XDDFDataSourcesFactory.fromArray(yAxisData);

        XDDFLineChartData lineChart = (XDDFLineChartData) chart.createData(ChartTypes.LINE, xAxis, yAxis);

        XDDFLineChartData.Series lineSeries = (XDDFLineChartData.Series) lineChart.addSeries(xAxisDatasource,
                yAxisDatasource);
        lineSeries.setTitle(legendTitle, null);
        lineSeries.setSmooth(true);
        lineSeries.setMarkerSize((short) 6);
        lineSeries.setMarkerStyle(MarkerStyle.CIRCLE);

        chart.plot(lineChart);
    }

    public void addIntPie(String title,
                          String[] xAxisData,
                          Integer[] yAxisData,
                          String legendTitle) throws Exception {
        XWPFChart chart = this.document.createChart(15 * Units.EMU_PER_CENTIMETER,
                10 * Units.EMU_PER_CENTIMETER);
        chart.setTitleText(title);
        chart.setTitleOverlay(false);

//        XDDFChartLegend legend = chart.getOrAddLegend();
//        legend.setPosition(LegendPosition.TOP);

        XDDFCategoryDataSource xAxisDatasource = XDDFDataSourcesFactory.fromArray(xAxisData);
        XDDFNumericalDataSource<Integer> yAxisDatasource = XDDFDataSourcesFactory.fromArray(yAxisData);

        XDDFPieChartData pieChart = (XDDFPieChartData) chart.createData(ChartTypes.PIE, null, null);

        XDDFPieChartData.Series pieSeries = (XDDFPieChartData.Series) pieChart.addSeries(xAxisDatasource,
                yAxisDatasource);
        pieSeries.setTitle(legendTitle, null);

        chart.plot(pieChart);
    }

    public void addDoublePie(String title,
                             String[] xAxisData,
                             Double[] yAxisData,
                             String legendTitle) throws Exception {
        XWPFChart chart = this.document.createChart(15 * Units.EMU_PER_CENTIMETER,
                10 * Units.EMU_PER_CENTIMETER);
        chart.setTitleText(title);
        chart.setTitleOverlay(false);

//        XDDFChartLegend legend = chart.getOrAddLegend();
//        legend.setPosition(LegendPosition.TOP);

        XDDFCategoryDataSource xAxisDatasource = XDDFDataSourcesFactory.fromArray(xAxisData);
        XDDFNumericalDataSource<Double> yAxisDatasource = XDDFDataSourcesFactory.fromArray(yAxisData);

        XDDFPieChartData pieChart = (XDDFPieChartData) chart.createData(ChartTypes.PIE, null, null);

        XDDFPieChartData.Series pieSeries = (XDDFPieChartData.Series) pieChart.addSeries(xAxisDatasource,
                yAxisDatasource);
        pieSeries.setTitle(legendTitle, null);

        chart.plot(pieChart);
    }

    public void save() throws FileNotFoundException, IOException {
        FileOutputStream out = new FileOutputStream(new File(this.filePath));
        this.document.write(out);
    }
}
