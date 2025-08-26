package br.com.fiap.bean;

import java.io.*;

/**
 * Representa um personagem do universo Dragon Ball Super com suas características
 * e habilidades de combate. Esta classe permite armazenar e recuperar dados
 * de personagens em arquivos de texto.
 *
 * @author FIAP
 * @version 1.0
 */
public class DragonBallSuper implements IDBSuper{
    /** Nome do personagem */
    private String nome;

    /** Nível de energia Ki do personagem */
    private int ki;

    /** Quantidade de técnicas especiais dominadas */
    private int tecnicas;

    /** Velocidade de movimento e combate */
    private int velocidade;

    /** Número de transformações disponíveis */
    private int transformacoes;

    /**
     * Construtor padrão que cria uma instância vazia de DragonBallSuper.
     */
    public DragonBallSuper() {
    }

    /**
     * Obtém o nome do personagem.
     *
     * @return o nome do personagem
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do personagem.
     *
     * @param nome o nome a ser atribuído ao personagem
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o nível de energia Ki do personagem.
     *
     * @return o valor do Ki
     */
    public int getKi() {
        return ki;
    }

    /**
     * Define o nível de energia Ki do personagem.
     *
     * @param ki o valor do Ki a ser atribuído
     */
    public void setKi(int ki) {
        this.ki = ki;
    }

    /**
     * Obtém a quantidade de técnicas especiais dominadas pelo personagem.
     *
     * @return o número de técnicas
     */
    public int getTecnicas() {
        return tecnicas;
    }

    /**
     * Define a quantidade de técnicas especiais do personagem.
     *
     * @param tecnicas o número de técnicas a ser atribuído
     */
    public void setTecnicas(int tecnicas) {
        this.tecnicas = tecnicas;
    }

    /**
     * Obtém a velocidade de movimento e combate do personagem.
     *
     * @return o valor da velocidade
     */
    public int getVelocidade() {
        return velocidade;
    }

    /**
     * Define a velocidade de movimento e combate do personagem.
     *
     * @param velocidade o valor da velocidade a ser atribuído
     */
    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    /**
     * Obtém o número de transformações disponíveis para o personagem.
     *
     * @return a quantidade de transformações
     */
    public int getTransformacoes() {
        return transformacoes;
    }

    /**
     * Define o número de transformações disponíveis para o personagem.
     *
     * @param transformacoes a quantidade de transformações a ser atribuída
     */
    public void setTransformacoes(int transformacoes) {
        this.transformacoes = transformacoes;
    }

    /**
     * Lê os dados do personagem a partir de um arquivo de texto.
     * O arquivo deve estar localizado no caminho especificado e ter o nome
     * do personagem seguido da extensão .txt.
     *
     * @param path o caminho do diretório onde está localizado o arquivo
     * @return a própria instância com os dados carregados
     * @throws IOException se ocorrer erro na leitura do arquivo
     */
    public DragonBallSuper ler (String path) throws IOException{
        BufferedReader br = new BufferedReader(
                new FileReader(path + "/" + nome + ".txt")
        );
        nome = br.readLine();
        ki = Integer.parseInt(br.readLine());
        tecnicas = Integer.parseInt(br.readLine());
        velocidade = Integer.parseInt(br.readLine());
        transformacoes = Integer.parseInt(br.readLine());
        br.close();
        return this;
    };

    /**
     * Grava os dados do personagem em um arquivo de texto.
     * Cria o diretório especificado caso não exista e salva o arquivo
     * com o nome do personagem seguido da extensão .txt.
     *
     * @param path o caminho do diretório onde o arquivo será salvo
     * @return mensagem indicando sucesso ou falha na operação
     */
    public String gravar (String path) {
        try {
            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdir();
            }
            PrintWriter pw = new PrintWriter(path + "/" + nome + ".txt");
            pw.println(nome);
            pw.println(ki);
            pw.println(tecnicas);
            pw.println(velocidade);
            pw.println(transformacoes);
            pw.flush();
            pw.close();
            return "Arquivo gravado com sucesso";
        } catch (IOException e) {
            return "Falha ao gravar arquivo: " + e.getMessage();
        }
    }
}
