package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import modelo.mundo.BibliaNoOrdenada;
import modelo.mundo.BibliaOrdenada;
import view.VentanaPrincipal;

public class Controler implements ActionListener {

    private VentanaPrincipal ventana;
    private BibliaNoOrdenada bibliaNoOrdenada;
    private BibliaOrdenada bibliaOrdenada;
    private boolean frecuenciaDeUnaPalabra = false, rangoDeUnaPalabra = false, palabraDeRangoN=false;

    public Controler(VentanaPrincipal ventana, BibliaNoOrdenada bibliaNoOrdenada, BibliaOrdenada bibliaOrdenada) {
        this.ventana = ventana;
        this.bibliaNoOrdenada = bibliaNoOrdenada;
        this.bibliaOrdenada = bibliaOrdenada;
        ventana.getConfirmar().addActionListener(this);
        ventana.getVolver().addActionListener(this);
        ventana.getConfitmarNoOrdenada().addActionListener(this);
        ventana.getConfitmarOrdenada().addActionListener(this);
        ventana.getConfirmarPalabra().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource().equals(ventana.getConfirmar())) {
            if (ventana.getOpciones().getSelectedItem().equals("Biblia no ordenada")) {
                try {
                    if (bibliaNoOrdenada.palabrasTotales() == 0) {
                        bibliaNoOrdenada.llenarDisorderedST();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                ventana.generarPanelTablaNoOrdenada();
                ventana.getTextArea().setText("");
            } else if (ventana.getOpciones().getSelectedItem().equals("Biblia ordenada")) {
                try {
                    if (bibliaOrdenada.palabrasTotales() == 0) {
                        bibliaOrdenada.llenarOrderedST();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                ventana.getTextArea().setText("");
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
                    ventana.getTextArea().setRows(10);
                    break;
                case "Mostrar palabras únicas":
                    ventana.getTextArea().setRows(bibliaNoOrdenada.palabrasUnicas().split("\n").length);
                    ventana.getTextArea().setText("Palabras únicas: "
                            + bibliaNoOrdenada.palabrasUnicas());
                    break;
                case "Mostrar la palabra con más frecuencia":
                    ventana.getTextArea().setText("Palabra con mayor frecuencia: "
                            + bibliaNoOrdenada.palabraMayorFrecuencia());
                    ventana.getTextArea().setRows(10);
                    break;
                case "Mostrar la cantidad de palabras con menos frecuencia":
                    ventana.getTextArea().setText("Palabras con menos frecuencia: "
                            + bibliaNoOrdenada.palabrasUnicas());
                    ventana.getTextArea().setRows(bibliaNoOrdenada.palabrasUnicas().split("\n").length);
                    break;
                case "Mostrar la frecuencia de una palabra":
                    ventana.getTextArea().setEditable(true);
                    ventana.getTextArea().setText("Escriba la palabra: ");
                    ventana.getTextArea().setRows(10);
                    ventana.getConfirmarPalabra().setVisible(true);
                    frecuenciaDeUnaPalabra = true;
                    break;
                case "Mostrar la frecuencia de cada palabra":
                    ventana.getTextArea().setText("Frecuencia de cada palabra: "
                            + bibliaNoOrdenada.palabraValor());
                    ventana.getTextArea().setRows(bibliaNoOrdenada.palabraValor().split("\n").length);
                    break;
                case "Mostrar palabras de la biblia sin repetir":
                    ventana.getTextArea().setText("Palabras sin repetir: "
                            + bibliaNoOrdenada.mostrarPalabrasSinRepetir());
                    ventana.getTextArea().setRows(bibliaNoOrdenada.mostrarPalabrasSinRepetir().split("\n").length);
                    break;
            }
            ventana.getScrollPane().revalidate();
            ventana.revalidate();
        } else if (e.getSource().equals(ventana.getConfitmarOrdenada())) {
            switch (((String) ventana.getOpcionesOrdenada().getSelectedItem())) {
                case "Mostrar palabras totales":
                    ventana.getTextArea().setText("Cantidad de palabras: "
                            + bibliaOrdenada.palabrasTotales());
                    ventana.getTextArea().setRows(10);
                    break;
                case "Mostrar palabras únicas":
                    ventana.getTextArea().setRows(bibliaOrdenada.palabrasUnicas().split("\n").length);
                    ventana.getTextArea().setText("Palabras únicas: "
                            + bibliaOrdenada.palabrasUnicas());
                    break;
                case "Mostrar la palabra con más frecuencia":
                    ventana.getTextArea().setText("Palabra con mayor frecuencia: "
                            + bibliaOrdenada.palabraMayorFrecuencia());
                    ventana.getTextArea().setRows(10);
                    break;
                case "Mostrar la cantidad de palabras con menos frecuencia":
                    ventana.getTextArea().setText("Palabras con menos frecuencia: "
                            + bibliaOrdenada.palabrasUnicas());
                    ventana.getTextArea().setRows(bibliaOrdenada.palabrasUnicas().split("\n").length);
                    break;
                case "Mostrar la frecuencia de una palabra":
                frecuenciaDeUnaPalabra = true;
                    ventana.getTextArea().setEditable(true);
                    ventana.getTextArea().setText("Escriba la palabra: ");
                    ventana.getTextArea().setRows(10);
                    ventana.getConfirmarPalabra().setVisible(true);
                    break;
                case "Mostrar la primera palabra alfabéticamente":
                    ventana.getTextArea().setText("Primera palabra: "
                            + bibliaOrdenada.primerPalabra());
                    ventana.getTextArea().setRows(10);
                    break;
                case "Mostrar la última palabra alfabéticamente":
                    ventana.getTextArea().setText("Ultima palabra: "
                            + bibliaOrdenada.ultimaPalabra());
                    ventana.getTextArea().setRows(10);
                    break;
                case "Mostrar la frecuencia de cada palabra":
                    ventana.getTextArea().setText("Frecuencia de cada palabra: "
                            + bibliaOrdenada.palabraValor());
                    ventana.getTextArea().setRows(bibliaOrdenada.palabraValor().split("\n").length);
                    break;
                case "Mostrar el rango de una palabra":
                    ventana.getTextArea().setEditable(true);
                    ventana.getTextArea().setText("Escriba la palabra: ");
                    ventana.getTextArea().setRows(10);
                    ventana.getConfirmarPalabra().setVisible(true);
                    rangoDeUnaPalabra = true;
                    break;
                case "Mostrar la palabra en el rango n":
                    ventana.getTextArea().setEditable(true);
                    ventana.getTextArea().setText("Escriba el rango: ");
                    ventana.getTextArea().setRows(10);    
                    ventana.getConfirmarPalabra().setVisible(true);
                    palabraDeRangoN = true;
                    break;
                case "Mostrar palabras de la biblia sin repetir":
                    ventana.getTextArea().setText("Palabras sin repetir: "
                            + bibliaOrdenada.mostrarPalabrasSinRepetir());
                    ventana.getTextArea().setRows(bibliaOrdenada.mostrarPalabrasSinRepetir().split("\n").length);
                    break;
            }
            ventana.getScrollPane().revalidate();
            ventana.revalidate();

        } else if (e.getSource().equals(ventana.getConfirmarPalabra())) {
            if (frecuenciaDeUnaPalabra) {
                ventana.getTextArea().setEditable(false);
                ventana.getTextArea().setText("Frecuencia de la palabra: "
                        + bibliaOrdenada
                                .buscarFrecuenciaDeUnaPalabra(ventana.getTextArea().getText().substring(20)));
                ventana.getConfirmarPalabra().setVisible(false);
                frecuenciaDeUnaPalabra = false;
            } else if (rangoDeUnaPalabra) {
                ventana.getTextArea().setEditable(false);
                ventana.getTextArea().setText("Rango de la palabra: "
                        + bibliaOrdenada
                                .rangoPalabra(ventana.getTextArea().getText().substring(20)));
                ventana.getConfirmarPalabra().setVisible(false);
                rangoDeUnaPalabra = false;
            }else if (palabraDeRangoN){
                ventana.getTextArea().setEditable(false);
                ventana.getTextArea().setText("Palabra en el rango: "
                        + bibliaOrdenada
                                .palabraDeRangoN(Integer.parseInt(ventana.getTextArea().getText().substring(18))));
                ventana.getConfirmarPalabra().setVisible(false);
                palabraDeRangoN = false;
            }
        }
    }

}
