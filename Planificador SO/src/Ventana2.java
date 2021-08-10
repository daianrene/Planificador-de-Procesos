import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;

public class Ventana2 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JScrollPane scrollSecuencia;
	private JScrollPane scrollPane;

	
	public Ventana2(Vector<String> secuencia, Vector<Proceso> copia, String nombre) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 753, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 59, 674, 176);
		contentPane.add(scrollPane);
		
		scrollSecuencia = new JScrollPane();
		scrollSecuencia.setBounds(27, 301, 674, 76);
		contentPane.add(scrollSecuencia);

		setVisible(true);
		
		table_1 = new JTable();
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
		table_1.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null},
				},
				new String[] {
					"0", "1", "2", "3", "4", "5", "6"
				}
			));
		scrollSecuencia.setViewportView( null );
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Proceso", "Tiempo de servicio", "Tiempo de espera", "Indice de servicio"
			}
		));
		scrollPane.setViewportView(table);
		
		mostrarGantt(secuencia);
		
		String matrix[][]= new String[copia.size()][4];
		
		float tiempoPromedio=0;
		
		for (int i = 0; i < matrix.length; i++) {

			matrix[i][0]= copia.get(i).getNombre();
			matrix[i][1]= String.valueOf(copia.get(i).getT_Servicio());
			matrix[i][2]= String.valueOf(copia.get(i).getT_Espera());
			matrix[i][3]= Float.toString(copia.get(i).getI_Servicio());
			
			tiempoPromedio+=copia.get(i).getT_Espera();
			
		}
		
		tiempoPromedio=tiempoPromedio/copia.size();

		table.setModel(new DefaultTableModel(
				matrix,
				new String[] {
					"Proceso", "Tiempo de servicio", "Tiempo de espera", "Indice de servicio"
				}
			));
		
		JLabel lblTitulo = new JLabel("Algoritmo "+nombre);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitulo.setBounds(27, 11, 381, 37);
		contentPane.add(lblTitulo);
		
		JLabel lblNewLabel = new JLabel("Tiempo espera promedio: "+tiempoPromedio);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(27, 258, 287, 22);
		contentPane.add(lblNewLabel);
		
	}
	
	private void mostrarGantt(Vector<String> secuencia) {

		scrollSecuencia.setViewportView( table_1 );
		
		Integer[] cont= new Integer[secuencia.size()];
		
		String matrix[][]= new String[1][secuencia.size()];
		Object[] objArray = secuencia.toArray();
		
		String[] sec = Arrays.copyOf(objArray,
                objArray.length,
                String[].class);
		
		for (int i = 0; i < secuencia.size(); i++) {
			cont[i]=i;
			matrix[0][i]=sec[i];
		}
		
		table_1.setModel(new DefaultTableModel(
				matrix,
				cont
			));
		
		
	}
}
