import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.commons.lang3.StringUtils;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ContadorPalabra extends JFrame implements Runnable {
    
    private JPanel contentPane;
    private JTextField jtf_palabra; // JTextfield con la palabra a buscar
    private JTextField jtf_contador; // JTextfield con el n de veces que se repite la palabra
    private JTextArea jta_texto; // JTextArea donde escribimos el texto

    public ContadorPalabra() {
        setTitle("Contador Palabras");
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // JTextField con la palabra a buscar.
        jtf_palabra = new JTextField();
        jtf_palabra.setBounds(115, 13, 110, 20);
        contentPane.add(jtf_palabra);
        jtf_palabra.setColumns(10);
        
        // JTextField donde se imprime el nº de veces que aparece la palabra
        jtf_contador = new JTextField();
        jtf_contador.setBounds(302, 11, 95, 20);
        contentPane.add(jtf_contador);
        jtf_contador.setText("2");

        // JTextArea donde se escribe el texto
        jta_texto = new JTextArea();
        jta_texto.setBounds(10, 42, 414, 160);
        contentPane.add(jta_texto);
       
        JLabel lblPalabraAEncontrar = new JLabel("Palabra a encontrar");
        lblPalabraAEncontrar.setBounds(10, 14, 95, 14);
        contentPane.add(lblPalabraAEncontrar);

        JLabel lblRepeticiones = new JLabel("Repeticiones");
        lblRepeticiones.setBounds(235, 16, 71, 14);
        contentPane.add(lblRepeticiones);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    // Metodo run que se va a ejecutar cada 5 segundos
    public void run() {
        try {
            while (true) {
                // Guarda el texto del JTextArea en un String
                String texto = jta_texto.getText();
                // Guarda la palabra a buscar en un String
                String palabra = jtf_palabra.getText();
                // Cuenta el número de veces que aparece la palabra 
                Integer cont = StringUtils.countMatches(texto, palabra);
                // Imprime el numero de veces que aparece la palabra en el JTextField correspondiente
                jtf_contador.setText(cont.toString());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    // TODO: handle exception
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
