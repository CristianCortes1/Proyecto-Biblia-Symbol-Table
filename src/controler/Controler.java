package controler;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import modelo.mundo.BibliaNoOrdenada;
import modelo.mundo.BibliaOrdenada;
import view.VentanaPrincipal;
import static modelo.mundo.GestorArchivos.obtenerPalabras;

public class Controler implements ActionListener {

    private VentanaPrincipal ventana;
    private BibliaNoOrdenada bibliaNoOrdenada;
    private BibliaOrdenada bibliaOrdenada;

    public Controler(VentanaPrincipal ventana, BibliaNoOrdenada bibliaNoOrdenada, BibliaOrdenada bibliaOrdenada) {
        this.ventana = ventana;
        this.bibliaNoOrdenada = bibliaNoOrdenada;
        this.bibliaOrdenada = bibliaOrdenada;
        ventana.getConfirmar().addActionListener(this);
        ventana.getVolver().addActionListener(this);
        ventana.getConfitmarNoOrdenada().addActionListener(this);
        ventana.getConfitmarOrdenada().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] opcionesNoOrdenada = { "Mostrar palabras totales",
                "Mostrar palabras únicas",
                "Mostrar la palabra con más frecuencia",
                "Mostrar la cantidad de palabras con menos frecuencia",
                "Mostrar la frecuencia de una palabra",
                "Mostrar la frecuencia de cada palabra",
                "Mostrar palabras de la biblia sin repetir" };
        String[] opcionesOrdenada = { "Mostrar palabras totales",
                "Mostrar palabras únicas",
                "Mostrar la palabra con más frecuencia",
                "Mostrar la cantidad de palabras con menos frecuencia",
                "Mostrar la frecuencia de una palabra",
                "Mostrar la primera palabra alfabéticamente",
                "Mostrar la frecuencia de cada palabra",
                "Mostrar el rango de una palabra",
                "Mostrar palabras de la biblia sin repetir",
                "Mostrar la palabra en el rango n",
                "Mostrar palabras de la biblia sin repetir" };
        if (e.getSource().equals(ventana.getConfirmar())) {
            if (ventana.getOpciones().getSelectedItem().equals("Biblia no ordenada")) {
                try {
                    if (bibliaNoOrdenada != null) {
                        bibliaNoOrdenada.llenarDisorderedST();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                ventana.generarPanelTablaNoOrdenada();
            } else if (ventana.getOpciones().getSelectedItem().equals("Biblia ordenada")) {
                try {
                    if (bibliaOrdenada != null) {
                        bibliaOrdenada.llenarOrderedST();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                ventana.generarPanelTablaOrdenada();
            }
        } else if (e.getSource().equals(ventana.getVolver())) {
            ventana.generarPanelPrincipal();
            ventana.revalidate();
        } else if (e.getSource().equals(ventana.getConfitmarNoOrdenada())) {
            switch (((String) ventana.getOpcionesNoOrdenada().getSelectedItem())) {
                case "Mostrar palabras totales":
                    ventana.getTextArea().setText("Cantidad de palabras: "
                            + bibliaNoOrdenada.palabrasTotales());
                    break;
                case "Mostrar palabras únicas":
                    
                    if (bibliaNoOrdenada != null) {
                        String palabrasUnicas = bibliaNoOrdenada.palabrasUnicas();
                        if (palabrasUnicas != null) {
                            JTextArea textArea = new JTextArea(palabrasUnicas.split("\n").length,10);
                            textArea.setPreferredSize(new Dimension(400, 300));
                            textArea.setEditable(false);
                            textArea.setLineWrap(true);
                            textArea.setWrapStyleWord(true);
                            textArea.setText("Palabras únicas: " + palabrasUnicas);

                            JScrollPane scrollPane = new JScrollPane(textArea);
                            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                            scrollPane.setPreferredSize(new Dimension(400, 300));
                            ventana.add(scrollPane);
                            ventana.revalidate();
                        }
                    }
                    break;
                case "Mostrar la palabra con más frecuencia":
                    ventana.getTextArea().setText("Palabra con mayor frecuencia: "
                            + bibliaNoOrdenada.palabraMayorFrecuencia());
                    break;
                case "Mostrar la cantidad de palabras con menos frecuencia":
                    ventana.getTextArea().setText("Palabras con menos frecuencia: "
                            + bibliaNoOrdenada.palabrasUnicas());
                    break;
                case "Mostrar la frecuencia de una palabra":
                    // caso especial

                    break;
                case "Mostrar la frecuencia de cada palabra":
                    ventana.getTextArea().setText("Frecuencia de cada palabra: "
                            + bibliaNoOrdenada.palabraValor());
                    break;
                case "Mostrar palabras de la biblia sin repetir":
                    ventana.getTextArea().setText("Palabras sin repetir: "
                            + bibliaNoOrdenada.mostrarPalabrasSinRepetir());
                    break;
            }

        }
    }

}
