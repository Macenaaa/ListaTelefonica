public class Contato {
    private int id;
    private String nome;
    private String telefone;


    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }


    public Contato(int id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }


    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }

    public void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    @Override
    public String toString() {
        return String.format(
                "ID: %d |" +
                " Nome: %s | " +
                "Telefone: %s", id, nome, telefone);
    }
}

