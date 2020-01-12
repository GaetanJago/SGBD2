package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controller.DAO.CodecDAO;
import controller.DAO.FormatDAO;
import model.Codec;
import model.Format;
import model.Player;

public class InterfaceController {
	private EntityManagerFactory emf;
    private EntityManager em;
    
    private JFrame frmVideoEtCodec;
	private JTable table_format;
	private JTable table_player;
	private JTable table_codec;
	
	public InterfaceController(EntityManagerFactory emf, EntityManager em, JFrame frmVideoEtCodec,
			JTable table_format, JTable table_player, JTable table_codec) {
		this.frmVideoEtCodec = frmVideoEtCodec;
		this.table_format = table_format;
		this.table_player = table_player;
		this.table_codec = table_codec;
		this.emf = emf;
		this.em = em;
		
		dispFormats();
		dispCodec();

		table_format.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent event) {
				// do some actions here, for example
				// print first column value from selected row
				dispPlayers((Format) table_format.getValueAt(table_format.getSelectedRow(), 0));
				System.out.println("Select format");
			}
		});

		frmVideoEtCodec.setVisible(true);
		frmVideoEtCodec.addWindowListener((WindowListener) new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.out.println("Closing window");
				em.close();
				emf.close();
			}
		});
	}

	public void dispFormats() {
		FormatDAO fd = new FormatDAO(em);
		List<Format> listFormat = fd.getAll();
		DefaultTableModel model = (DefaultTableModel) table_format.getModel();
		model.setRowCount(0);//vider
		if(listFormat != null) {
			for(Format f : listFormat) {
				if(f != null) {
					Object[] row = {f};
					model.addRow(row);	
				}
			}
		}
	}

	public void dispPlayers(Format format) {
		DefaultTableModel model = (DefaultTableModel) table_player.getModel();
		model.setRowCount(0);//vider
		if(format != null) {
			for(Codec codec : format.getCodecs()) {
				if(codec != null && codec.getFormat() == format) {
					for(Player play : codec.getPlayers()) {
						Object[] row = {play,codec};
						model.addRow(row);	
					}
				}
			}
		}
	}

	public void dispCodec() {
		CodecDAO cd = new CodecDAO(em);
		List<Codec> listCodec = cd.getAll();
		DefaultTableModel model = (DefaultTableModel) table_codec.getModel();
		model.setRowCount(0);//vider
		if(listCodec != null) {
			for(Codec c : listCodec) {
				if(c != null) {
					if(c.getCompany() != null) {
						Object[] row = {c,c.getCompany()};
						model.addRow(row);	
					}
					else {
						Object[] row = {c,"Codec open source"};
						model.addRow(row);	
					}
				}
			}
		}
	}
}
