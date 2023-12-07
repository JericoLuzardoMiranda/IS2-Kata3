package software.ulpgc.kata3;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.statistics.HistogramDataset;

import javax.swing.*;

import java.awt.*;

import static org.jfree.chart.ChartFactory.createHistogram;

public class JFreeChartHistogramDisplay extends JPanel implements HistogramDisplay {

    @Override
    public void show(Histogram provider) {
        JFreeChart histogram = createHistogram(provider);
        add(new ChartPanel(histogram));
    }

    private JFreeChart createHistogram(Histogram provider) {
        HistogramDataset dataset = datasetWith(provider);

        JFreeChart histogram = ChartFactory.createHistogram(
                "", "Number of employees", "",
                datasetWith(provider),
                PlotOrientation.VERTICAL,
                false, false, false);

        XYPlot plot = (XYPlot) histogram.getPlot();
        XYBarRenderer renderer = (XYBarRenderer) plot.getRenderer();

        renderer.setSeriesPaint(0, Color.CYAN);
        renderer.setBarPainter(new StandardXYBarPainter());

        renderer.setDrawBarOutline(true);
        renderer.setBaseOutlinePaint(Color.BLACK);

        renderer.setOutlineStroke(new BasicStroke(3.0f));

        renderer.setShadowVisible(false);
        renderer.setMargin(0.3);

        return histogram;
    }

    private HistogramDataset datasetWith(Histogram histogram) {
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("s", histogram.values(), histogram.bins());
        return dataset;
    }

}
