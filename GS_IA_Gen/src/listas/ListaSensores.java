package listas;

import entidades.RegistroSensor;

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
            if (coordenadaString == lista.dado.getNumSensor()) {
                achou = true;
                lista = lista.prox;
            } else {
                NO aux = lista;

                while (aux.prox != null && !achou) {
                    if (aux.prox.dado.getNumSensor() != coordenadaString)
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

    public int contaNos() {
        int cont = 0;
        /* percorrer cada no da lista para obter quantidade de nos */
        NO aux = lista;
        while (aux != null) {
            cont++;
            aux = aux.prox;
        }
        return cont;
    }

    public void apresenta() {
        NO aux = lista;
        int cont = 1;
        System.out.println("\n  ---**Lista**---");
        while (aux != null) {
            System.out.println("Registro #" + cont + ":" + "\n" + aux.dado);
            System.out.println();
            aux = aux.prox;
            cont++;
        }
    }
}
