package br.edu.unisep.tarefas.model;

import javax.swing.*;
import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        ArrayList<String> listaTarefas = new ArrayList<>();
        int opcao;

        do {
            // Exibição do menu principal
            String menu = "Escolha uma das opções abaixo:\n"
                    + "1. Adicionar uma nova tarefa\n"
                    + "2. Marcar tarefa como concluída\n"
                    + "3. Remover tarefa\n"
                    + "4. Exibir todas as tarefas\n"
                    + "5. Sair";
            String entrada = JOptionPane.showInputDialog(menu);

            if (entrada == null || entrada.isEmpty()) {
                break; // Encerra se o usuário fechar ou não inserir entrada
            }

            try {
                opcao = Integer.parseInt(entrada);

                switch (opcao) {
                    case 1:
                        adicionarTarefa(listaTarefas);
                        break;
                    case 2:
                        marcarComoConcluida(listaTarefas);
                        break;
                    case 3:
                        removerTarefa(listaTarefas);
                        break;
                    case 4:
                        exibirTarefas(listaTarefas);
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Encerrando o sistema...");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número correspondente à opção.");
                opcao = -1; // Continua o loop
            }
        } while (true);
    }

    private static void adicionarTarefa(ArrayList<String> listaTarefas) {
        String tarefa = JOptionPane.showInputDialog("Informe a descrição da nova tarefa:");
        if (tarefa != null && !tarefa.trim().isEmpty()) {
            listaTarefas.add(tarefa.trim());
            JOptionPane.showMessageDialog(null, "Tarefa adicionada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Tarefa inválida. Não foi adicionada.");
        }
    }

    private static void marcarComoConcluida(ArrayList<String> listaTarefas) {
        if (listaTarefas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não existem tarefas cadastradas para serem concluídas.");
            return;
        }

        StringBuilder tarefas = new StringBuilder("Tarefas disponíveis:\n");
        for (int i = 0; i < listaTarefas.size(); i++) {
            tarefas.append(i + 1).append(". ").append(listaTarefas.get(i)).append("\n");
        }

        String entrada = JOptionPane.showInputDialog(tarefas + "Informe o número da tarefa que deseja marcar como concluída:");
        try {
            int indice = Integer.parseInt(entrada) - 1;
            if (indice >= 0 && indice < listaTarefas.size()) {
                listaTarefas.set(indice, listaTarefas.get(indice) + " (Concluída)");
                JOptionPane.showMessageDialog(null, "Tarefa marcada como concluída!");
            } else {
                JOptionPane.showMessageDialog(null, "Número inválido. Nenhuma tarefa foi concluída.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Nenhuma tarefa foi concluída.");
        }
    }

    private static void removerTarefa(ArrayList<String> listaTarefas) {
        if (listaTarefas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma tarefa cadastrada para ser removida.");
            return;
        }

        StringBuilder tarefas = new StringBuilder("Tarefas cadastradas:\n");
        for (int i = 0; i < listaTarefas.size(); i++) {
            tarefas.append(i + 1).append(". ").append(listaTarefas.get(i)).append("\n");
        }

        String entrada = JOptionPane.showInputDialog(tarefas + "Digite o número da tarefa que deseja excluir:");
        try {
            int indice = Integer.parseInt(entrada) - 1;
            if (indice >= 0 && indice < listaTarefas.size()) {
                listaTarefas.remove(indice);
                JOptionPane.showMessageDialog(null, "Tarefa removida com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Número inválido. Nenhuma tarefa foi excluída.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Nenhuma tarefa foi excluída.");
        }
    }

    private static void exibirTarefas(ArrayList<String> listaTarefas) {
        if (listaTarefas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma tarefa cadastrada no momento.");
        } else {
            StringBuilder tarefas = new StringBuilder("Lista de tarefas:\n");
            for (int i = 0; i < listaTarefas.size(); i++) {
                tarefas.append(i + 1).append(". ").append(listaTarefas.get(i)).append("\n");
            }
            JOptionPane.showMessageDialog(null, tarefas.toString());
        }
    }
}
