package br.com.fiap.main;

import javax.swing.JOptionPane;
import br.com.fiap.bean.DragonBallSuper;
import java.io.IOException;

/**
 * Classe principal para interagir com o usuário e gerenciar personagens de
 * Dragon Ball Super, permitindo cadastrar e consultar informações.
 */
public class UsaDBSuper {
    public static void main(String[] args) {
        String aux, nome, path;
        int ki, tecnicas, velocidade, transformacoes, opcao;
        DragonBallSuper dbs;
        do {
            try {
                aux = JOptionPane.showInputDialog("Escolha a operação desejada:\n1. Cadastrar Personagem\n2. Consultar Personagem");
                opcao = Integer.parseInt(aux);
                path = JOptionPane.showInputDialog("Digite o caminho da pasta");
                dbs = new DragonBallSuper();
                switch (opcao) {
                    case 1:
                        nome = JOptionPane.showInputDialog("Digite o nome do Personagem");
                        ki = Integer.parseInt(JOptionPane.showInputDialog("Digite o nível de Ki"));
                        tecnicas = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de Técnicas"));
                        velocidade = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor de Velocidade"));
                        transformacoes = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de Transformações"));
                        dbs.setNome(nome);
                        dbs.setKi(ki);
                        dbs.setTecnicas(tecnicas);
                        dbs.setVelocidade(velocidade);
                        dbs.setTransformacoes(transformacoes);
                        JOptionPane.showMessageDialog(null, dbs.gravar(path));
                        break;
                    case 2:
                        nome = JOptionPane.showInputDialog("Digite o nome do personagem para consulta");
                        dbs.setNome(nome);
                        dbs = dbs.ler(path);
                        if (nome == null){
                            JOptionPane.showMessageDialog(null, "Caminho e/ou codigo informado inexistente");
                        } else{
                            JOptionPane.showMessageDialog(null,"Exibindo dados:"
                                    + "\n\nCaminho do Arquivo: " + path + "/" + dbs.getNome() + ".txt"
                                    + "\nNome: " + dbs.getNome()
                                    + "\nKi: " + dbs.getKi()
                                    + "\nTécnicas: " + dbs.getTecnicas()
                                    + "\nVelocidade: " + dbs.getVelocidade()
                                    + "\nTransformações: " + dbs.getTransformacoes());
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro de Conversão!\nPor favor, digite apenas números nos campos numéricos.", "ERRO", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro de Arquivo!\nPersonagem não encontrado ou falha na leitura.", "ERRO", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado:\n" + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }

        } while (JOptionPane.showConfirmDialog(null, "Deseja realizar outra operação?", "Continuar", JOptionPane.YES_NO_OPTION) == 0);

        JOptionPane.showMessageDialog(null, "Programa finalizado.");
    }
}