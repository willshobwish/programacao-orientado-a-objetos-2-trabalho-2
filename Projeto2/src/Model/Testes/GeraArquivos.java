package Model.Testes;

import Controller.ControladorSerializable;
import Model.Usuario.Cliente;
import Model.Usuario.ClienteOuro;
import Model.Usuario.Gerente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

/*
Bruno Augusto Furquim
Giovanna Silva Custodio
Willian Yoshio Murayama
 */
public class GeraArquivos {

    public static void main(String[] args) {
        int codigo = 0;
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Gerente> gerentes = new ArrayList<>();
        ArrayList<ClienteOuro> clientesOuro = new ArrayList<>();

        String[] nomesArray = {"Cara Bryant", "Lily-Mae Macias", "Natasha Newman", "Evan O'Gallagher", "Nathanael Williams", "Filip Cuevas", "Sion Harmon", "Magnus York", "Nikita Garner", "Kade Wilcox", "Ava Buckley", "Ethan Nichols", "Candice Clay", "Faizan Mckenzie", "Herbie Wyatt", "Rosalind Tucker", "Stefan Lee", "Fatma Santos", "Lena Case", "Mathilda Parks", "Osman James", "Warren Higgins", "Jesse Schneider", "Frederic Hendricks", "Zara Aguirre", "Cora Perry", "Keira Brock", "Willie Fulton", "Fatima Frazier", "Keane Dotson", "Mari Crane", "Joanna Mullins", "Harvey Dunlap", "Hassan Ramos", "Khalil Luna", "Soraya Chandler", "Calvin Phelps", "Aleena Finch", "Inaya Fletcher", "Keelan Pham", "Caitlyn Yoder", "Jenna Butler", "Ebony Bates", "Harriet Hines", "Malakai Molina", "Wiktor Ayers", "Tyrell Jordan", "Timothy Crosby", "Grover Bradford", "Zayd Garrett"};
        String[] nomesArrayGerente = {"Nevaeh Rowe", "Jake Mora", "Monty Melendez", "Elinor Sweeney", "Kye Irwin", "Autumn Golden", "Shanice Wise", "Adrian Dalton", "Zayn Moran", "Mohammad Hale", "Vinny Rogers", "Barney Mcintosh", "Agnes Daugherty", "Adnan Sanford", "Ray Huff", "Patricia Mullen", "Riya Young", "Brogan Bird", "Luke Spence", "Brooke Santiago", "Saskia Hogan", "Katherine Carroll", "Spencer Hilton", "Lennox Duran", "Macy Patton", "Angelo Brennan", "Travis Baird", "Alexandra Slater", "Zakaria Tran", "Nell Hardin", "Lorraine Graham", "Penelope Tate", "Phoenix Rasmussen", "Laura Ward", "Ela Gilmore", "Taylor Clayton", "Emmie Mckay", "Eden Duke", "Sian Hoffman", "Amaan Byrd", "Imogen Petersen", "Tamara Tucker", "Barnaby Bernard", "Oakley Brandt", "Luis Donnelly", "Rosie Hendrix", "Polly Barrera", "Luqman O'Sullivan", "Christina Rollins", "Janice Johns"};
        String[] nomesArrayClienteOuro = {"Siobhan Ramirez", "Zohaib Contreras", "Eloise Campbell", "Natasha Torres", "Angel Fuller", "Betsy Connolly", "Linda Davila", "Milan Pineda", "Robbie Peck", "Jorge Terrell", "Lily-May Oneill", "Lila Cain", "Lukas Kerr", "Chelsea Berger", "Jan Winter", "Sumayyah Hobbs", "Lennon Cotton", "Aaryan Carlson", "Kaleb Mcknight", "Lena Rios", "Hope Owens", "Maisie Fisher", "Oliwier Sharp", "Tyrone Ortiz", "Bronwyn Brock", "Ana Lang", "Alexa Montgomery", "Lea Norris", "Jennie Norman", "Aled Patterson", "Jannat England", "Amaya Schneider", "Edie Nelson", "Casey Riley", "Clementine Rodgers", "Haroon Cross", "Fred Perry", "Joel Calderon", "Ollie Stevenson", "Cole Walls", "Dawud Munoz", "Rohan Glover", "Dulcie Cannon", "Jane Coffey", "Saoirse Hunter", "Madiha Thomson", "Margaret Dyer", "Mina Dawson", "Harun Melendez", "Mariam Camacho"};
        Iterator<String> nomesCliente = Arrays.stream(nomesArray).iterator();
        Iterator<String> nomesGerente = Arrays.stream(nomesArrayGerente).iterator();
        Iterator<String> nomesClienteOuro = Arrays.stream(nomesArrayClienteOuro).iterator();

        while (nomesCliente.hasNext()) {
            clientes.add(geraCliente(codigo, (String) nomesCliente.next()));
            codigo++;
        }
        Controller.ControladorSerializable.salvarClientes(clientes);
        codigo = 0;
        while (nomesClienteOuro.hasNext()) {
            clientesOuro.add(geraClienteOuro(codigo, (String) nomesClienteOuro.next()));
            codigo++;
        }
        ControladorSerializable.salvarClientesOuro(clientesOuro);
        codigo = 0;
        while (nomesGerente.hasNext()) {
            gerentes.add(geraGerente(codigo, (String) nomesGerente.next()));
            codigo++;
        }

        Controller.ControladorSerializable.salvarGerentes(gerentes);
    }

    public static Cliente geraCliente(int codigo, String nome) {
        return new Cliente(codigo, nome, geraCPF(), geraCPF(), geraDataNascimento(), "endereço teste", geraCEP(), "%s@cliente.com".formatted(nome.replaceAll("\\s+", ".").toLowerCase()), geraDataCadastro());
    }

    public static ClienteOuro geraClienteOuro(int codigo, String nome) {
        return new ClienteOuro(codigo, nome, geraCPF(), geraCPF(), geraDataNascimento(), "endereço teste", geraCEP(), "%s@cliente.com".formatted(nome.replaceAll("\\s+", ".").toLowerCase()), geraDataCadastro());
    }

    public static Gerente geraGerente(int codigo, String nome) {
        return new Gerente(geraSalario(), geraCPF(), geraDataCadastro(), codigo, nome, geraCPF(), geraCPF(), geraDataNascimento(), "endereco", geraCEP(), "%s@institucional.com".formatted(nome.replaceAll("\\s+", ".").toLowerCase()));
    }

    public static String geraCPF() {
        Random random = new Random();
        String cpf = "";
        for (int i = 0; i < 4; i++) {
            cpf += String.valueOf(random.nextInt(999));
            if (i < 3) {
                cpf += ".";
            }
        }
        return cpf;
    }

    public static String geraCEP() {
        Random random = new Random();
        String cpf = "";

        cpf += String.valueOf(random.nextInt(99999));
        cpf += "-";
        cpf += String.valueOf(random.nextInt(999));

        return cpf;
    }

    public static float geraSalario() {
        Random random = new Random();

        return (float) random.nextDouble(999.99);
    }

    public static LocalDate geraDataNascimento() {
        Random random = new Random();
        int minDay = (int) LocalDate.of(2002, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2002, 12, 31).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    public static LocalDate geraDataCadastro() {
        Random random = new Random();
        int minDay = (int) LocalDate.of(2022, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2022, 12, 31).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        return LocalDate.ofEpochDay(randomDay);
    }
}
