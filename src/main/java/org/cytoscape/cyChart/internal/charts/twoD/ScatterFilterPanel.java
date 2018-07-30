package org.cytoscape.cyChart.internal.charts.twoD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.concurrent.CountDownLatch;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.log4j.Logger;
import org.cytoscape.application.CyUserLog;
import org.cytoscape.cyChart.internal.model.CyChartManager;
import org.cytoscape.service.util.CyServiceRegistrar;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class ScatterFilterPanel extends JPanel {
 
	protected JFXPanel jfxPanel;
 
	private final JLabel lblStatus = new JLabel();

	public static final String EVENT_TYPE_CLICK = "click";
	public static final String EVENT_TYPE_CONTEXT_MENU = "contextmenu";

	private String title = null;
	private CyServiceRegistrar registrar;

	final Logger logger = Logger.getLogger(CyUserLog.NAME);
 
	public ScatterFilterPanel(CyChartManager manager, ScatterFilterDialog parentDialog) {
		super(new BorderLayout());
		registrar = manager.getRegistrar();
		System.out.println("ScatterFilterPanel");
		setPreferredSize(new Dimension(520, 500));
		initComponents();
//		Platform.setImplicitExit(false);
	}

	public String getTitle() 	{		return title;	}

	public String execute(final String script) {
		final String[] returnVal = new String[1]; 
		final CountDownLatch doneLatch = new CountDownLatch(1);
		try {
			doneLatch.await();
		} catch (InterruptedException e) {
		}
		return returnVal[0];
	}

	private void initComponents() {
		jfxPanel = new JFXPanel();
		StackPane appPane = AppScatters.getStackPane(registrar, lblStatus);
		if (appPane != null) 
		{
			Scene scene = new Scene(appPane);
			jfxPanel.setScene(scene);
			System.out.println("scene created");
		}
		else System.out.println("appPane came back null");

		JPanel topBar = new JPanel(new BorderLayout(5, 0));
		topBar.setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 5));

		JPanel statusBar = new JPanel(new BorderLayout(5, 0));
		statusBar.add(lblStatus, BorderLayout.CENTER);
		lblStatus.setMinimumSize(new Dimension(20, 20));
		lblStatus.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 13));
		lblStatus.setText("The status bar reports the range and percentage selected");
		add(topBar, BorderLayout.NORTH);
		add(statusBar, BorderLayout.SOUTH);
//		JPanel container = new JPanel();
//		container.setBorder(BorderFactory.createLineBorder(Color.GREEN));
//		jfxPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
//		container.add(jfxPanel);
		add(jfxPanel, BorderLayout.CENTER);
//		jfxPanel.setBorder(Borders.blueBorder1);
//		jfxPanel.setStyle("-fx-border-color: orange");
	}

}