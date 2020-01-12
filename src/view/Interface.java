package view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.InterfaceController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Interface {

	private JFrame frmVideoEtCodec;
	private JTable table_format;
	private JTable table_player;
	private JTable table_codec;
    
    private InterfaceController controller;


	/**
	 * Create the application.
	 */
	public Interface(EntityManagerFactory emf, EntityManager em) {
		super();
		initialize();
		controller = new InterfaceController(emf, em, frmVideoEtCodec,
				table_format,table_player,table_codec);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {	
				
		frmVideoEtCodec = new JFrame();
		frmVideoEtCodec.setTitle("Video et codec JAGOREL DERENNE");
		frmVideoEtCodec.setBounds(100, 100, 719, 420);
		frmVideoEtCodec.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmVideoEtCodec.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_format = new JPanel();
		tabbedPane.addTab("Formats", null, panel_format, null);
		GridBagLayout gbl_panel_format = new GridBagLayout();
		gbl_panel_format.columnWidths = new int[]{281, 410, 0};
		gbl_panel_format.rowHeights = new int[]{353, 0};
		gbl_panel_format.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_format.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_format.setLayout(gbl_panel_format);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_format.add(scrollPane, gbc_scrollPane);
		
		table_format = new JTable();
		table_format.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Nom du format"
				}
				){
				private static final long serialVersionUID = 3L;
				public boolean isCellEditable(int row, int column){return false;}});
		scrollPane.setViewportView(table_format);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 0;
		panel_format.add(scrollPane_1, gbc_scrollPane_1);
		
		table_player = new JTable();
		table_player.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Players", "Codec"
				}
				){
				private static final long serialVersionUID = 3L;
				public boolean isCellEditable(int row, int column){return false;}});
		
		scrollPane_1.setViewportView(table_player);
		
		JPanel panel_codec = new JPanel();
		tabbedPane.addTab("Propri\u00E9taire", null, panel_codec, null);
		panel_codec.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_codec.add(scrollPane_2, BorderLayout.CENTER);
		
		table_codec = new JTable();
		table_codec.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codec", "Propriétaire"
			}
		));
		scrollPane_2.setViewportView(table_codec);
	}
	

}
