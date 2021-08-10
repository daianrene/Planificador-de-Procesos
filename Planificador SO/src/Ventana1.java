import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Ventana1 extends JFrame {

	private JPanel contentPane;
	private JButton btnAñadir;
	private JTextField txtRafaga;
	private JTextField txtOrden;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtProceso;
	private JButton btnQuitar;
	private Planificador planificador;
	
	private Vector<Proceso> procesos=new Vector<Proceso>();
	private JButton btnSRT;
	private JButton btnRR;
	private JButton btnFCFS;
	private JTextField txt_quantum;


	public Ventana1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 577);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		planificador = new Planificador();
		
		btnAñadir = new JButton("A\u00F1adir proceso");
	
		
		txtRafaga = new JTextField();
		txtRafaga.setColumns(10);
		
		txtOrden = new JTextField();
		txtOrden.setColumns(10);
		
		scrollPane = new JScrollPane();
		
		lblNewLabel = new JLabel("Rafaga");
		
		lblNewLabel_1 = new JLabel("Tiempo llegada");
		
		lblNewLabel_2 = new JLabel("Proceso");
		
		txtProceso = new JTextField();
		txtProceso.setColumns(10);
		
		btnQuitar = new JButton("Quitar proceso");

		txt_quantum = new JTextField();
		txt_quantum.setText("2");
		txt_quantum.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Quantum:");
		
		btnFCFS = new JButton("FCFS");
		btnFCFS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Vector<Proceso> copia = copiar(procesos);
				
				Vector<String> secuencia=planificador.FCFS(copia);
				
				Ventana2 ventanaFCFS = new Ventana2(secuencia,copia,"FCFS");
			}


		});
		
		btnSRT = new JButton("SRT");
		btnSRT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Vector<Proceso> copia = copiar(procesos);
				
				Vector<String> secuencia=planificador.SRT(copia);
				
				Ventana2 ventanaSRT = new Ventana2(secuencia,copia,"SRT");
			}

		});
		
		btnRR = new JButton("RR");
		btnRR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Vector<Proceso> copia = copiar(procesos);
				
				Vector<String> secuencia=planificador.RR(copia,Integer.parseInt(txt_quantum.getText()));
				
				Ventana2 ventanaRR = new Ventana2(secuencia,copia,"RR");
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_2))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txtProceso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtRafaga, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(82)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnQuitar)
										.addComponent(btnAñadir)))
								.addComponent(txtOrden, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 542, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnRR, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnFCFS, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnSRT, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
							.addGap(7)
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txt_quantum, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(txtProceso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAñadir))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(btnQuitar)
						.addComponent(txtRafaga, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtOrden, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnFCFS)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSRT)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRR)
						.addComponent(txt_quantum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addContainerGap())
		);
		
		
		table = new JTable();
		table.setRowHeight(25);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Proceso", "Rafaga", "Tiempo Llegada"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(107);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		
		
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Proceso proceso = new Proceso(txtProceso.getText(), Integer.parseInt(txtOrden.getText()),Integer.parseInt(txtRafaga.getText()));
				procesos.add(proceso);
				
				txtProceso.setText(null);
				txtOrden.setText(null);
				txtRafaga.setText(null);
				
				String matrix[][]= new String[procesos.size()][3];
				
				for (int i = 0; i < matrix.length; i++) {

					matrix[i][0]= procesos.get(i).getNombre();
					matrix[i][1]= Integer.toString(procesos.get(i).getRafaga());
					matrix[i][2]= Integer.toString(procesos.get(i).getOrden());
					
				}
				

				table.setModel(new DefaultTableModel(
						matrix,
						new String[] {
							"Proceso", "Rafaga", "Tiempo Llegada"
						}
					));
				
			}
		});
		
		
		btnQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				procesos.remove(procesos.size()-1);
				
				String matrix[][]= new String[procesos.size()][3];
				
				for (int i = 0; i < matrix.length; i++) {
					
					matrix[i][0]= procesos.get(i).getNombre();
					matrix[i][1]= Integer.toString(procesos.get(i).getRafaga());
					matrix[i][2]= Integer.toString(procesos.get(i).getOrden());
					
				}
				

				table.setModel(new DefaultTableModel(
						matrix,
						new String[] {
							"Proceso", "Rafaga", "Tiempo Llegada"
						}
					));
			}
		});
		
		
	}
	
	private Vector<Proceso> copiar(Vector<Proceso> procesos) {
		Vector<Proceso> copia=new Vector<Proceso>();
		
		for (int i = 0; i < procesos.size(); i++) {
			Proceso aux = new Proceso(procesos.get(i));
			copia.add(aux);
		}
		return copia;
	}
}