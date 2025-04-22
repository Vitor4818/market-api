package personagem;

public record DadosListagemPersonagem(Long id, String nome, Classe classe, int nivel) {
    public DadosListagemPersonagem(Personagem personagem){
        this(personagem.getId(),
                personagem.getNome(),
                personagem.getClasse(),
                personagem.getNivel());
    }
}
