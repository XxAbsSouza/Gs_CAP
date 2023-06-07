package listas;

import entidades.RegistroSensor;
import filas.FilaSensores;

public class ListaSensores {

    private class NO {
        RegistroSensor dado;
        NO prox;
    }

    private NO lista = null;

    // ------Organizar a Lista pelo nível da umidade--------
    public void insere(RegistroSensor elem) {
        NO novo = new NO();
        novo.dado = elem;
        if (lista == null) {
            novo.prox = null;
            lista = novo;
        } else {
            if (novo.dado.getUmidade() < lista.dado.getUmidade()) {
                novo.prox = lista;
                lista = novo;
            } else {
                NO aux = lista;
                boolean achou = false;
                while (aux.prox != null && !achou) {
                    if (aux.prox.dado.getUmidade() < novo.dado.getUmidade())
                        aux = aux.prox;
                    else
                        achou = true;
                }
                novo.prox = aux.prox;
                aux.prox = novo;
            }
        }
    }
    // --------------

    // -------Remover Registro Sensor---------
    public boolean remove(String coordenadaString) {
        boolean achou = false;
        if (lista != null) {
            if (coordenadaString.equalsIgnoreCase(lista.dado.getNumSensor())) {
                achou = true;
                lista = lista.prox;
            } else {
                NO aux = lista;

                while (aux.prox != null && !achou) {
                    if (!coordenadaString.equalsIgnoreCase(aux.prox.dado.getNumSensor()))
                        aux = aux.prox;
                    else {
                        achou = true;
                        aux.prox = aux.prox.prox;
                    }
                }
            }
        }
        return achou;
    }
    // ----------------

    public void pesquisaCoordenada(String coordenadaString) {
        NO aux = lista;
        boolean achei = true;

        while (aux != null) {
            if (coordenadaString.equalsIgnoreCase(aux.dado.getNumSensor())) {
                System.out.println("O registro da coordenada " + coordenadaString + ", é:" + "\n" + aux.dado);
                achei = true;
                break;
            } else {
                achei = false;
            }
            aux = aux.prox;
        }
        if (achei == false) {
            System.out.println("Coordenada inserida não foi encontrada.");
        }
    }

    public void apresentarAlertas() {
        FilaSensores filaAlertas = new FilaSensores();
        filaAlertas.init();
        NO aux = lista;

        while (aux != null) {
            if (aux.dado.getUmidade() < 25 || aux.dado.getUmidade() > 75) {
                filaAlertas.enqueue(aux.dado);
            } else if (aux.dado.getConcenPotassio() < 115 || aux.dado.getConcenPotassio() > 200) {
                filaAlertas.enqueue(aux.dado);
            } else if (aux.dado.getPh() <= 3 || aux.dado.getPh() > 8) {
                filaAlertas.enqueue(aux.dado);
            } else {
                if (filaAlertas.isEmpty()) {
                    System.out.println("Não há coordenadas com alertas :)");
                }
            }
            aux = aux.prox;
        }
        filaAlertas.printFila();
    }

    public void apresenta() {
        NO aux = lista;
        int cont = 1;
        System.out.println("\n  ---**Lista de Registros**---");
        System.out.println();
        while (aux != null) {
            System.out.println("REGISTRO #" + cont + ":" + "\n" + aux.dado);
            System.out.println();
            aux = aux.prox;
            cont++;
        }
    }
}
